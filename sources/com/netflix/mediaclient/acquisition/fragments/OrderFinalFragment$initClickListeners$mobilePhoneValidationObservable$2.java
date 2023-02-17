package com.netflix.mediaclient.acquisition.fragments;

import android.text.TextUtils;
import com.netflix.android.moneyball.fields.StringField;
import io.reactivex.functions.Function;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$initClickListeners$mobilePhoneValidationObservable$2<T, R> implements Function<CharSequence, Boolean> {
    final /* synthetic */ OrderFinalFragment this$0;

    OrderFinalFragment$initClickListeners$mobilePhoneValidationObservable$2(OrderFinalFragment orderFinalFragment) {
        this.this$0 = orderFinalFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* synthetic */ Boolean apply(CharSequence charSequence) {
        return Boolean.valueOf(apply(charSequence));
    }

    public final boolean apply(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "it");
        StringField mobilePhone = this.this$0.getOrderFinalViewModel().getMobilePhone();
        return (mobilePhone != null && mobilePhone.isValid()) || TextUtils.isEmpty(charSequence);
    }
}
