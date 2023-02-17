package o;

import android.content.Context;
import android.content.SharedPreferences;
public class AY {

    /* renamed from: ˊ  reason: contains not printable characters */
    private SharedPreferences.Editor f4329;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Context f4330;

    /* renamed from: ॱ  reason: contains not printable characters */
    private SharedPreferences f4331;

    public AY(Context context) {
        this.f4330 = context;
        m3493();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m3493() {
        try {
            this.f4331 = this.f4330.getSharedPreferences("nfxpref", 0);
            this.f4329 = this.f4331.edit();
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to get preferences!", th);
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m3498(String str, boolean z) {
        if (!m3492(str)) {
            return false;
        }
        try {
            this.f4329.putBoolean(str, z);
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m3496(String str, int i) {
        if (!m3492(str)) {
            return false;
        }
        try {
            this.f4329.putInt(str, i);
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m3497(String str, String str2) {
        if (!m3492(str)) {
            return false;
        }
        try {
            this.f4329.putString(str, str2);
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m3499(String str, long j) {
        if (!m3492(str)) {
            return false;
        }
        try {
            this.f4329.putLong(str, j);
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m3495(String str) {
        if (!m3492(str)) {
            return false;
        }
        try {
            this.f4329.remove(str);
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m3492(String str) {
        if (!C1349Bv.m4113(str)) {
            return true;
        }
        C1283.m16865("nfxpref", "Name is null!");
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m3494() {
        try {
            return this.f4329.commit();
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }
}
