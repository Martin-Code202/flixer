package com.netflix.mediaclient.acquisition.fragments;

import android.widget.CheckBox;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class ObtainConsentFragment$setupRequiredCheckBox$1<T> implements Consumer<Boolean> {
    final /* synthetic */ CheckBox $checkBox;
    final /* synthetic */ ObtainConsentFragment this$0;

    ObtainConsentFragment$setupRequiredCheckBox$1(ObtainConsentFragment obtainConsentFragment, CheckBox checkBox) {
        this.this$0 = obtainConsentFragment;
        this.$checkBox = checkBox;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "it");
        this.this$0.showError(this.$checkBox, !bool.booleanValue());
        this.this$0.checkForErrorMessage();
    }
}
