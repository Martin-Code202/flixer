package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.view.PhoneNumberCountryInput;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import o.C1457Fr;
import o.C2059ph;
public final class OrderFinalFragment$updateCountryCode$1 extends NetflixActivity.If {
    final /* synthetic */ String $countryCode;
    final /* synthetic */ OrderFinalFragment this$0;

    OrderFinalFragment$updateCountryCode$1(OrderFinalFragment orderFinalFragment, String str) {
        this.this$0 = orderFinalFragment;
        this.$countryCode = str;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
    public void run(C2059ph phVar) {
        C1457Fr.m5025(phVar, "manager");
        ImageLoader imageLoader = NetflixActivity.getImageLoader(this.this$0.getActivity());
        if (imageLoader != null) {
            ((PhoneNumberCountryInput) this.this$0._$_findCachedViewById(R.Cif.phoneNumberCountryInput)).updateFlag(this.$countryCode, imageLoader);
        }
    }
}
