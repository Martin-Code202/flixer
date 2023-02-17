package com.netflix.mediaclient.acquisition.fragments;

import com.android.volley.VolleyError;
import o.C0524;
import o.C1283;
/* access modifiers changed from: package-private */
public final class CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$3 implements C0524.AbstractC2398iF {
    public static final CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$3 INSTANCE = new CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$3();

    CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$3() {
    }

    @Override // o.C0524.AbstractC2398iF
    public final void onErrorResponse(VolleyError volleyError) {
        C1283.m16850(CreditPaymentFragment.TAG, "Error fetching Secure MOP key!");
    }
}
