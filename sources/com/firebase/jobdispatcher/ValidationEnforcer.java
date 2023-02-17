package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;
import o.AbstractC0639;
import o.AbstractC0939;
public class ValidationEnforcer implements AbstractC0939 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC0939 f141;

    public ValidationEnforcer(AbstractC0939 r1) {
        this.f141 = r1;
    }

    @Override // o.AbstractC0939
    /* renamed from: ˊ  reason: contains not printable characters */
    public List<String> mo93(AbstractC0639 r2) {
        return this.f141.mo93(r2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m94(AbstractC0639 r2) {
        m92(mo93(r2));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m92(List<String> list) {
        if (list != null) {
            throw new ValidationException("JobParameters is invalid", list);
        }
    }

    public static final class ValidationException extends RuntimeException {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final List<String> f142;

        public ValidationException(String str, List<String> list) {
            super(str + ": " + TextUtils.join("\n  - ", list));
            this.f142 = list;
        }
    }
}
