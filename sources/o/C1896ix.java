package o;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ix  reason: case insensitive filesystem */
public class C1896ix {

    /* renamed from: ʻ  reason: contains not printable characters */
    private iF f7815 = new iF();

    /* renamed from: ʽ  reason: contains not printable characters */
    private iF f7816 = new iF();

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f7817;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f7818;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f7819;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Context f7820;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f7821;

    /* renamed from: o.ix$iF */
    class iF {

        /* renamed from: ʽ  reason: contains not printable characters */
        public int f7823;

        /* renamed from: ˊ  reason: contains not printable characters */
        public int f7824;

        /* renamed from: ˋ  reason: contains not printable characters */
        public int f7825;

        /* renamed from: ˎ  reason: contains not printable characters */
        public int f7826;

        /* renamed from: ˏ  reason: contains not printable characters */
        public int f7827;

        /* renamed from: ॱ  reason: contains not printable characters */
        public int f7828;

        iF() {
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m7787(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f7827 = i;
            this.f7826 = i2;
            this.f7825 = i3;
            this.f7824 = i4;
            this.f7828 = i5;
            this.f7823 = i6;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public JSONObject m7786() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("level", this.f7827);
                jSONObject.put("health", this.f7826);
                jSONObject.put("plugged", this.f7825);
                jSONObject.put("status", this.f7824);
                jSONObject.put("temperature", this.f7828);
                jSONObject.put("voltage", this.f7823);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return "BStat{level=" + this.f7827 + ", health=" + this.f7826 + ", plugged=" + this.f7825 + ", status=" + this.f7824 + ", temperature=" + this.f7828 + ", voltage=" + this.f7823 + '}';
        }
    }

    public C1896ix(Context context, boolean z, String str, int i) {
        this.f7820 = context;
        this.f7817 = z;
        this.f7821 = str;
        this.f7819 = i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7785(boolean z) {
        this.f7818 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public JSONObject m7783() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("technology", this.f7821);
            jSONObject.put("scale", this.f7819);
            jSONObject.put("present", this.f7817);
            jSONObject.put("wasCharged", this.f7818);
            jSONObject.put("atStart", this.f7816.m7786());
            jSONObject.put("atEnd", this.f7815.m7786());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7784(boolean z) {
        Intent registerReceiver = this.f7820.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("health", 0);
            int intExtra3 = registerReceiver.getIntExtra("plugged", 0);
            int intExtra4 = registerReceiver.getIntExtra("status", 0);
            int intExtra5 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra6 = registerReceiver.getIntExtra("voltage", 0);
            if (z) {
                this.f7816.m7787(intExtra, intExtra2, intExtra3, intExtra4, intExtra5, intExtra6);
            } else {
                this.f7815.m7787(intExtra, intExtra2, intExtra3, intExtra4, intExtra5, intExtra6);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1896ix m7782(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return new C1896ix(context, registerReceiver.getExtras().getBoolean("present"), registerReceiver.getExtras().getString("technology"), registerReceiver.getIntExtra("scale", -1));
    }
}
