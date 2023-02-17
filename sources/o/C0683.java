package o;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.netflix.mediaclient.acquisition.fragments.WelcomeFragment;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.partner.playbilling.PlayBilling$1;
import com.netflix.mediaclient.partner.playbilling.PlayBilling$2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import o.AbstractC1028;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ถ  reason: contains not printable characters */
public class C0683 {

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static final List f14134 = new PlayBilling$1();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static final List f14135 = new PlayBilling$2();

    /* renamed from: ʻ  reason: contains not printable characters */
    AbstractC1028 f14136;

    /* renamed from: ʼ  reason: contains not printable characters */
    Context f14137;

    /* renamed from: ʽ  reason: contains not printable characters */
    volatile boolean f14138 = false;

    /* renamed from: ˊ  reason: contains not printable characters */
    boolean f14139 = false;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    String f14140;

    /* renamed from: ˋ  reason: contains not printable characters */
    boolean f14141 = false;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    ServiceConnection f14142;

    /* renamed from: ˎ  reason: contains not printable characters */
    boolean f14143 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    boolean f14144 = false;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    AbstractC0687 f14145;

    /* renamed from: ͺ  reason: contains not printable characters */
    int f14146;

    /* renamed from: ॱ  reason: contains not printable characters */
    volatile boolean f14147 = false;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int f14148 = 2000;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    Handler f14149;

    /* renamed from: ᐝ  reason: contains not printable characters */
    String f14150 = "";

    /* renamed from: o.ถ$if  reason: invalid class name */
    public interface Cif {
        void onSetupFinished(boolean z);
    }

    public C0683(Context context, Handler handler) {
        this.f14137 = context.getApplicationContext();
        this.f14149 = handler;
        C1283.m16854("playBilling", "IAB helper created.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14950(final Cif ifVar) {
        m14939();
        if (this.f14143) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        C1283.m16854("playBilling", "Starting play billing setup.");
        this.f14142 = new ServiceConnection() { // from class: o.ถ.2
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C1283.m16854("playBilling", "Billing service disconnected.");
                C0683.this.f14136 = null;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (!C0683.this.f14141) {
                    C1283.m16854("playBilling", "Billing service connected.");
                    C0683.this.f14136 = AbstractC1028.AbstractBinderC1029.m16028(iBinder);
                    String packageName = C0683.this.f14137.getPackageName();
                    try {
                        C1283.m16854("playBilling", "Checking for play billing 3 support.");
                        if (C0683.this.f14136.mo16022(3, packageName, "inapp") != 0) {
                            C0683.this.f14139 = false;
                            C0683.this.f14144 = false;
                            C1283.m16854("playBilling", "Error checking for billing v3 support.");
                            if (ifVar != null) {
                                ifVar.onSetupFinished(false);
                                return;
                            }
                            return;
                        }
                        C1283.m16854("playBilling", "play billing version 3 supported for " + packageName);
                        if (C0683.this.f14136.mo16022(5, packageName, "subs") == 0) {
                            C1283.m16854("playBilling", "Subscription re-signup AVAILABLE.");
                            C0683.this.f14144 = true;
                        } else {
                            C1283.m16854("playBilling", "Subscription re-signup not available.");
                            C0683.this.f14144 = false;
                        }
                        if (C0683.this.f14144) {
                            C0683.this.f14139 = true;
                        } else {
                            int r4 = C0683.this.f14136.mo16022(3, packageName, "subs");
                            if (r4 == 0) {
                                C1283.m16854("playBilling", "Subscriptions AVAILABLE.");
                                C0683.this.f14139 = true;
                            } else {
                                C1283.m16854("playBilling", "Subscriptions NOT AVAILABLE. Response: " + r4);
                                C0683.this.f14139 = false;
                                C0683.this.f14144 = false;
                            }
                        }
                        if (C0683.this.f14136.mo16022(6, packageName, "subs") != 0) {
                            C1283.m16850("playBilling", "api 6 not supported. Check if PlayStore version > 6.2");
                            C0683.this.f14139 = false;
                            C0683.this.f14144 = false;
                        } else {
                            C1283.m16854("playBilling", "api 6 supported... ");
                        }
                        C0683.this.f14143 = true;
                        C1283.m16854("playBilling", "Setup successful");
                        if (ifVar != null) {
                            ifVar.onSetupFinished(true);
                        }
                    } catch (Exception e) {
                        C1283.m16847("playBilling", "Exception while setting up in-app billing.", e);
                        if (ifVar != null) {
                            ifVar.onSetupFinished(false);
                        }
                    }
                }
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (m14936(intent)) {
            this.f14137.bindService(intent, this.f14142, 1);
        } else if (ifVar != null) {
            ifVar.onSetupFinished(false);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m14936(Intent intent) {
        return (this.f14137 == null || this.f14137.getPackageManager() == null || this.f14137.getPackageManager().queryIntentServices(intent, 0) == null || this.f14137.getPackageManager().queryIntentServices(intent, 0).isEmpty()) ? false : true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m14962() {
        return this.f14143 && this.f14139 && this.f14144;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14948() {
        if (this.f14138) {
            C1283.m16854("playBilling", "Will dispose after async operation finishes.");
            this.f14147 = true;
            return;
        }
        C1283.m16854("playBilling", "Disposing.");
        this.f14143 = false;
        if (this.f14142 != null) {
            C1283.m16854("playBilling", "Unbinding from service.");
            if (this.f14137 != null) {
                try {
                    this.f14137.unbindService(this.f14142);
                } catch (Exception e) {
                }
            }
        }
        this.f14141 = true;
        this.f14137 = null;
        this.f14142 = null;
        this.f14136 = null;
        this.f14145 = null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14939() {
        if (this.f14141) {
            throw new IllegalStateException("PlayBilling was disposed of, so it cannot be used.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14956(int i, int i2, Intent intent) {
        if (i == this.f14146) {
            m14939();
            m14958("handleActivityResult");
            if (this.f14145 == null) {
                C1283.m16850("playBilling", "purchase listerner null");
                return;
            }
            AbstractC0687 r2 = this.f14145;
            m14954();
            if (intent == null) {
                C1283.m16850("playBilling", "Null data in IAB activity result.");
                r2.mo13485(m14946(m14952(102)));
                return;
            }
            String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
            String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
            int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("RESPONSE_CODE", i2 == -1 ? 0 : intExtra);
                if (C1349Bv.m4107(stringExtra)) {
                    jSONObject.put("INAPP_PURCHASE_DATA", m14938(new JSONObject(stringExtra)));
                }
                jSONObject.put("INAPP_DATA_SIGNATURE", stringExtra2);
            } catch (Exception e) {
                C1283.m16847("playBilling", "error processing payment data", e);
            }
            r2.mo13485(jSONObject);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private JSONObject m14938(JSONObject jSONObject) {
        if (!jSONObject.has(WelcomeFragment.KEY_PLAY_BILLING_DEVELOPER_PAYLOAD)) {
            return jSONObject;
        }
        try {
            String string = jSONObject.getString(WelcomeFragment.KEY_PLAY_BILLING_DEVELOPER_PAYLOAD);
            if (C1349Bv.m4107(string) && !C1349Bv.m4126(string, "undefined")) {
                jSONObject.put(WelcomeFragment.KEY_PLAY_BILLING_DEVELOPER_PAYLOAD, new JSONObject(string));
            }
        } catch (Exception e) {
            C1283.m16847("playBilling", "error sanitizing payment data", e);
        }
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m14930(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i <= -1000) {
            int i2 = -1000 - i;
            if (i2 < 0 || i2 >= split2.length) {
                return String.valueOf(i) + ":Unknown IAB Helper Error";
            }
            return split2[i2];
        } else if (i < 0 || i >= split.length) {
            return String.valueOf(i) + ":Unknown";
        } else {
            return split[i];
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14958(String str) {
        if (!this.f14143) {
            C1283.m16850("playBilling", "Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public int m14951(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            C1283.m16854("playBilling", "Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            C1283.m16850("playBilling", "Unexpected type for bundle response code.");
            C1283.m16850("playBilling", obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14959(String str) {
        boolean z = this.f14138;
        this.f14150 = str;
        this.f14138 = true;
        C1283.m16854("playBilling", "Starting async operation: " + str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14954() {
        C1283.m16854("playBilling", "Ending async operation: " + this.f14150);
        this.f14150 = "";
        this.f14138 = false;
        if (this.f14147) {
            m14948();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14957(final NetflixActivity netflixActivity, final String str, final String str2, final int i, final String str3, final int i2, final AbstractC0687 r17) {
        if (m14945() || r17 == null) {
            m14959("locking for purchase");
            new BackgroundTask().m285(new Runnable() { // from class: o.ถ.5
                @Override // java.lang.Runnable
                public void run() {
                    C0683.this.f14145 = r17;
                    JSONObject r7 = C0683.this.m14942(netflixActivity, str, str2, i, str3, i2);
                    C0683.this.m14954();
                    if (r7 != null) {
                        C0683.this.f14145 = null;
                        if (r17 != null) {
                            C0683.this.m14940(r17, r7);
                        }
                    }
                }
            });
            return;
        }
        r17.mo13485(null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14960(NetflixActivity netflixActivity, String str, String str2, int i, String str3, int i2) {
        m14957(netflixActivity, str, str2, i, str3, i2, new AbstractC0687() { // from class: o.ถ.3
            @Override // o.AbstractC0687
            /* renamed from: ˊ */
            public void mo13485(JSONObject jSONObject) {
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14949(final String str, final AbstractC0687 r4) {
        if (!m14945()) {
            r4.mo13485(null);
            return;
        }
        m14959("locking for getPurchaseHistory");
        new BackgroundTask().m285(new Runnable() { // from class: o.ถ.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject r2 = C0683.this.m14931(str);
                C0683.this.m14954();
                C0683.this.m14940(r4, r2);
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14955(final String str, final AbstractC0687 r4) {
        if (!m14945()) {
            r4.mo13485(null);
            return;
        }
        m14959("locking for getPurchases");
        new BackgroundTask().m285(new Runnable() { // from class: o.ถ.4
            @Override // java.lang.Runnable
            public void run() {
                JSONObject r2 = C0683.this.m14947(str);
                C0683.this.m14954();
                C0683.this.m14940(r4, r2);
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14961(final ArrayList<String> arrayList, final AbstractC0687 r4) {
        if (!m14945()) {
            r4.mo13485(null);
            return;
        }
        m14959("locking for getSkuDetails");
        new BackgroundTask().m285(new Runnable() { // from class: o.ถ.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject r2 = C0683.this.m14935(arrayList);
                C0683.this.m14954();
                C0683.this.m14940(r4, r2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14940(final AbstractC0687 r3, final JSONObject jSONObject) {
        if (!this.f14141 && r3 != null) {
            this.f14149.post(new Runnable() { // from class: o.ถ.10
                @Override // java.lang.Runnable
                public void run() {
                    r3.mo13485(jSONObject);
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m14945() {
        m14939();
        boolean z = this.f14139 && !this.f14138;
        if (!z) {
            C1283.m16850("playBilling", "getSkuDetails mSubscriptionsSupported is false or mAsyncInProgress is true");
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @TargetApi(19)
    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject m14942(NetflixActivity netflixActivity, String str, String str2, int i, String str3, int i2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("trialPeriod", i);
            if (C1349Bv.m4107(str3)) {
                bundle.putString("accountId", str3);
            }
            C1283.m16854("playBilling", String.format("extras :%s", bundle));
            Bundle r7 = this.f14136.mo16026(6, this.f14137.getPackageName(), str, "subs", str2, bundle);
            int r9 = m14951(r7);
            if (r9 != 0) {
                C1283.m16850("playBilling", "Unable to buy item, Error response: " + m14930(r9));
                return m14946(r7);
            }
            C1283.m16854("playBilling", "Launching buy intent for " + str + ". Request code: " + i2);
            this.f14146 = i2;
            this.f14140 = "subs";
            Integer num = 0;
            Integer num2 = 0;
            Integer num3 = 0;
            netflixActivity.startIntentSenderForResult(((PendingIntent) r7.getParcelable("BUY_INTENT")).getIntentSender(), i2, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
            return null;
        } catch (Exception e) {
            C1283.m16851("playBilling", "getPurchasesFromPlayBilling failed", e);
            return m14946(m14953("initiatePurchasePlayBilling", m14941(e)));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject m14947(String str) {
        Bundle bundle;
        try {
            bundle = this.f14136.mo16025(3, this.f14137.getPackageName(), "subs", str);
        } catch (Exception e) {
            C1283.m16851("playBilling", "getPurchasesFromPlayBilling failed", e);
            bundle = m14953("getPurchasesFromPlayBilling", m14941(e));
        }
        return m14946(bundle);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private JSONObject m14931(String str) {
        Bundle bundle;
        try {
            bundle = this.f14136.mo16020(6, this.f14137.getPackageName(), "subs", str, (Bundle) null);
        } catch (Exception e) {
            C1283.m16851("playBilling", "getPurchaseHistoryFromPlayBilling failed", e);
            bundle = m14953("getPurchaseHistoryFromPlayBilling", m14941(e));
        }
        return m14946(bundle);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private JSONObject m14935(ArrayList<String> arrayList) {
        Bundle bundle;
        if (arrayList == null || arrayList.size() > 20) {
            return m14946(m14952(100));
        }
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("ITEM_ID_LIST", arrayList);
        C1283.m16854("playBilling", "getSkuDetailsFromPlayBilling bundle:" + bundle2);
        try {
            bundle = this.f14136.mo16023(5, this.f14137.getPackageName(), "subs", bundle2);
        } catch (Exception e) {
            C1283.m16851("playBilling", "getSkuDetailsFromPlayBilling failed", e);
            bundle = m14953("getSkuDetailsFromPlayBilling", m14941(e));
        }
        return m14946(bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public Bundle m14953(String str, String str2) {
        Bundle r1 = m14952(5);
        r1.putString("exceptionIn", str);
        r1.putString("exceptionString", str2);
        return r1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public Bundle m14952(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", i);
        return bundle;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m14941(Exception exc) {
        String exc2 = exc != null ? exc.toString() : "";
        if (!C1349Bv.m4107(exc2) || exc2.length() <= this.f14148) {
            return exc2;
        }
        return exc2.substring(0, this.f14148);
    }

    @TargetApi(19)
    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject m14946(Bundle bundle) {
        JSONArray jSONArray;
        if (bundle == null) {
            C1283.m16854("playBilling", "bundle is null");
            bundle = m14952(101);
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                Object obj = bundle.get(str);
                if (f14134.contains(str)) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
                    if (f14135.contains(str)) {
                        jSONArray = new JSONArray((Collection) stringArrayList);
                    } else {
                        jSONArray = new JSONArray();
                        Iterator<String> it = stringArrayList.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObject2 = new JSONObject(it.next());
                            if ("INAPP_PURCHASE_DATA_LIST".equals(str)) {
                                jSONObject2 = m14938(jSONObject2);
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                    obj = jSONArray;
                }
                Object wrap = JSONObject.wrap(obj);
                if (wrap != null) {
                    jSONObject.put(str, wrap);
                } else if (obj != null) {
                    jSONObject.put(str, obj.toString());
                }
            } catch (JSONException e) {
            }
        }
        try {
            jSONObject.put("rawData", m14934(bundle.toString()));
        } catch (JSONException e2) {
            C1283.m16847("playBilling", "error adding raw message", e2);
        }
        jSONObject.toString();
        return jSONObject;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String m14934(String str) {
        try {
            return C1323Aw.m3795(str.getBytes());
        } catch (Exception e) {
            C1283.m16847("playBilling", "error encoding to base64", e);
            return null;
        }
    }
}
