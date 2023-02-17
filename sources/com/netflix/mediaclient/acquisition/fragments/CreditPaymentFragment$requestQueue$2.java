package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.NetflixApplication;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.C0482;
import o.C1148;
/* access modifiers changed from: package-private */
public final class CreditPaymentFragment$requestQueue$2 extends Lambda implements AbstractC1449Fj<C0482> {
    public static final CreditPaymentFragment$requestQueue$2 INSTANCE = new CreditPaymentFragment$requestQueue$2();

    CreditPaymentFragment$requestQueue$2() {
        super(0);
    }

    @Override // o.AbstractC1449Fj
    public final C0482 invoke() {
        return C1148.m16320(NetflixApplication.getInstance(), "Secure MOP Fetch Key");
    }
}
