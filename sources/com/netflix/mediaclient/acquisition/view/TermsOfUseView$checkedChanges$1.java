package com.netflix.mediaclient.acquisition.view;

import android.widget.CheckBox;
import com.netflix.mediaclient.R;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class TermsOfUseView$checkedChanges$1<T> implements Consumer<Boolean> {
    final /* synthetic */ TermsOfUseView this$0;

    TermsOfUseView$checkedChanges$1(TermsOfUseView termsOfUseView) {
        this.this$0 = termsOfUseView;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "it");
        if (this.this$0.shouldShowErrorState) {
            TermsOfUseView termsOfUseView = this.this$0;
            CheckBox checkBox = (CheckBox) this.this$0._$_findCachedViewById(R.Cif.touCheckbox);
            C1457Fr.m5016((Object) checkBox, "touCheckbox");
            termsOfUseView.setErrorVisible(!checkBox.isChecked());
        }
    }
}
