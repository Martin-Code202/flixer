package com.google.firebase.iid;

import android.text.TextUtils;
public final class zzk {
    private static final Object zzaqc = new Object();
    private final zzr zzmlv;

    zzk(zzr zzr) {
        this.zzmlv = zzr;
    }

    /* access modifiers changed from: package-private */
    public final String zzbyq() {
        synchronized (zzaqc) {
            String string = this.zzmlv.zzhuk.getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    return split[1];
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzqe(String str) {
        synchronized (zzaqc) {
            String string = this.zzmlv.zzhuk.getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (!string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                return false;
            }
            String valueOf3 = String.valueOf(",");
            String valueOf4 = String.valueOf(str);
            this.zzmlv.zzhuk.edit().putString("topic_operaion_queue", string.substring((valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).length())).apply();
            return true;
        }
    }
}
