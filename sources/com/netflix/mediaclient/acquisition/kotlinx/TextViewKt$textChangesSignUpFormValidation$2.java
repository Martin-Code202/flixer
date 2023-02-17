package com.netflix.mediaclient.acquisition.kotlinx;

import android.text.TextUtils;
import io.reactivex.functions.Predicate;
import o.C1457Fr;
public final class TextViewKt$textChangesSignUpFormValidation$2 implements Predicate<CharSequence> {
    private boolean first = true;

    TextViewKt$textChangesSignUpFormValidation$2() {
    }

    public final boolean getFirst() {
        return this.first;
    }

    public final void setFirst(boolean z) {
        this.first = z;
    }

    public boolean test(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "c");
        if (!this.first) {
            return true;
        }
        this.first = false;
        return !TextUtils.isEmpty(charSequence);
    }
}
