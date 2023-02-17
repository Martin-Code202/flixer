package o;

import android.content.Context;
import android.os.Build;
import com.netflix.mediaclient.util.DeviceCategory;
/* renamed from: o.Ɔ  reason: contains not printable characters */
public class C0351 {

    /* renamed from: ʻ  reason: contains not printable characters */
    int f13092;

    /* renamed from: ʼ  reason: contains not printable characters */
    int f13093;

    /* renamed from: ʽ  reason: contains not printable characters */
    DeviceCategory f13094;

    /* renamed from: ˊ  reason: contains not printable characters */
    String f13095;

    /* renamed from: ˋ  reason: contains not printable characters */
    String f13096;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    String f13097;

    /* renamed from: ˎ  reason: contains not printable characters */
    String f13098;

    /* renamed from: ˏ  reason: contains not printable characters */
    String f13099;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    String f13100;

    /* renamed from: ॱ  reason: contains not printable characters */
    String f13101;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    String f13102;

    /* renamed from: ᐝ  reason: contains not printable characters */
    String f13103;

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m13951() {
        return this.f13101;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m13948() {
        return this.f13096;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m13949() {
        return this.f13095;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m13947() {
        return this.f13103;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m13950() {
        return this.f13097;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m13944() {
        return this.f13100;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m13945() {
        return this.f13102;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public int m13946() {
        return this.f13092;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int m13952() {
        return this.f13093;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m13953() {
        return this.f13094.m2972();
    }

    public C0351(int i, Context context, String str, String str2) {
        this.f13101 = "";
        this.f13099 = "";
        this.f13095 = "";
        this.f13096 = "";
        this.f13098 = "";
        this.f13103 = "";
        this.f13097 = "";
        this.f13100 = "";
        this.f13101 = "samurai";
        if (Build.MANUFACTURER != null) {
            this.f13096 = Build.MANUFACTURER.trim();
        }
        if (Build.MODEL != null) {
            this.f13099 = Build.MODEL.trim();
        }
        this.f13095 = str2;
        if (Build.FINGERPRINT != null) {
            this.f13098 = Build.FINGERPRINT.trim();
        }
        this.f13093 = Build.VERSION.SDK_INT;
        this.f13092 = i;
        this.f13102 = str;
        if (C1337Bj.m4031(context)) {
            this.f13094 = DeviceCategory.TABLET;
        } else {
            this.f13094 = DeviceCategory.PHONE;
        }
        if (Build.DEVICE != null) {
            this.f13103 = Build.DEVICE;
        }
        if (Build.BOARD != null) {
            this.f13097 = Build.BOARD;
        }
        if (Build.DISPLAY != null) {
            this.f13100 = Build.DISPLAY;
        }
    }
}
