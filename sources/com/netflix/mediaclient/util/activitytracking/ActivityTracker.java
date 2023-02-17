package com.netflix.mediaclient.util.activitytracking;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import o.AD;
import o.AbstractC1221;
import o.BH;
import o.C1283;
import org.json.JSONException;
import org.json.JSONObject;
public class ActivityTracker implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<Status> {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected boolean f4020;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected boolean f4021;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected GoogleApiClient f4022;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected If f4023;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected DominantActivity f4024 = DominantActivity.unknown;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected HashMap<DominantActivity, Long> f4025 = new HashMap<>();

    /* renamed from: ॱ  reason: contains not printable characters */
    protected Context f4026;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected long f4027 = 0;

    /* access modifiers changed from: package-private */
    public enum DominantActivity {
        motion("motion"),
        foot("foot"),
        still("still"),
        unknown("unknown");
        

        /* renamed from: ˊ  reason: contains not printable characters */
        private final String f4033;

        private DominantActivity(String str) {
            this.f4033 = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.f4033;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3046(AbstractC1221 r1, Context context) {
        return !r1.mo16507() && AD.m3321(context);
    }

    public ActivityTracker(Context context) {
        this.f4026 = context;
        this.f4023 = new If();
        this.f4022 = new GoogleApiClient.Builder(context).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(ActivityRecognition.API).build();
        this.f4022.connect();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3047() {
        this.f4025.clear();
        this.f4027 = System.currentTimeMillis();
        this.f4024 = DominantActivity.unknown;
        for (DominantActivity dominantActivity : DominantActivity.values()) {
            this.f4025.put(dominantActivity, 0L);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3054() {
        m3047();
        LocalBroadcastManager.getInstance(this.f4026).registerReceiver(this.f4023, new IntentFilter("com.netflix.mediaclient.ACTIVITIES_BROADCAST_ACTION"));
        ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(this.f4022, 300000, m3045()).setResultCallback(this);
        this.f4020 = true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3050() {
        if (!this.f4022.isConnected()) {
            C1283.m16850("ActivityTracker", "stopping while not connected ");
            return;
        }
        m3049();
        ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(this.f4022, m3045()).setResultCallback(this);
        LocalBroadcastManager.getInstance(this.f4026).unregisterReceiver(this.f4023);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m3053() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : m3051().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Map<String, Object> m3051() {
        HashMap hashMap = new HashMap();
        if (this.f4021) {
            hashMap.put("suspended", Boolean.TRUE);
        }
        for (Map.Entry<DominantActivity, Long> entry : this.f4025.entrySet()) {
            hashMap.put(entry.getKey().toString(), entry.getValue());
        }
        return hashMap;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private PendingIntent m3045() {
        return PendingIntent.getService(this.f4026, 0, new Intent(this.f4026, BH.class), 134217728);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        C1283.m16862("ActivityTracker", "Connected to GoogleApiClient");
        if (!this.f4020) {
            m3054();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        C1283.m16850("ActivityTracker", "Connection suspended");
        this.f4021 = true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void onResult(Status status) {
        if (status.isSuccess()) {
            C1283.m16850("ActivityTracker", "Successfully added activity detection.");
        } else {
            C1283.m16850("ActivityTracker", "Error adding or removing activity detection: " + status.getStatusMessage());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m3049() {
        if (this.f4020) {
            if (this.f4027 == 0) {
                this.f4027 = System.currentTimeMillis();
                return;
            }
            this.f4025.put(this.f4024, Long.valueOf(this.f4025.get(this.f4024).longValue() + ((System.currentTimeMillis() - this.f4027) / 1000)));
            this.f4027 = System.currentTimeMillis();
        }
    }

    public class If extends BroadcastReceiver {
        public If() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Iterator it = intent.getParcelableArrayListExtra("com.netflix.mediaclient.ACTIVITIES_EXTRA").iterator();
            while (it.hasNext()) {
                DetectedActivity detectedActivity = (DetectedActivity) it.next();
                if (detectedActivity.getConfidence() > 70) {
                    ActivityTracker.this.m3049();
                    switch (detectedActivity.getType()) {
                        case 0:
                        case 1:
                            ActivityTracker.this.f4024 = DominantActivity.motion;
                            continue;
                        case 2:
                        case 7:
                        case 8:
                            ActivityTracker.this.f4024 = DominantActivity.foot;
                            continue;
                        case 3:
                            ActivityTracker.this.f4024 = DominantActivity.still;
                            continue;
                    }
                }
            }
        }
    }
}
