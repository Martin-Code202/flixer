package com.netflix.mediaclient.servicemgr;

import o.C1349Bv;
import org.json.JSONObject;
public interface Logblob {

    public enum Severity {
        error,
        info,
        warn
    }

    /* renamed from: ˋ */
    String mo680();

    /* renamed from: ˎ  reason: contains not printable characters */
    JSONObject mo1555();

    /* renamed from: ˏ  reason: contains not printable characters */
    boolean mo1556();

    /* renamed from: ᐝ  reason: contains not printable characters */
    long mo1557();

    /* renamed from: com.netflix.mediaclient.servicemgr.Logblob$ˋ  reason: contains not printable characters */
    public static class C0028 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f2635;

        /* renamed from: ˋ  reason: contains not printable characters */
        public String f2636;

        public C0028(String str, String str2, String str3, String str4) {
            this.f2635 = str;
            this.f2636 = str4;
            m1558();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean m1558() {
            if (C1349Bv.m4113(this.f2635)) {
                throw new IllegalStateException("ESN is missing");
            } else if (!C1349Bv.m4113(this.f2636)) {
                return true;
            } else {
                throw new IllegalStateException("deviceModel is missing");
            }
        }
    }
}
