package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import o.C0522;
import o.C1457Fr;
import o.C2059ph;
public final class WelcomeFragment$loadVlVImageUrl$1 extends NetflixActivity.If {
    final /* synthetic */ String $description;
    final /* synthetic */ C0522 $imageView;
    final /* synthetic */ String $url;
    final /* synthetic */ WelcomeFragment this$0;

    WelcomeFragment$loadVlVImageUrl$1(WelcomeFragment welcomeFragment, C0522 r2, String str, String str2) {
        this.this$0 = welcomeFragment;
        this.$imageView = r2;
        this.$description = str;
        this.$url = str2;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
    public void run(C2059ph phVar) {
        C1457Fr.m5025(phVar, "manager");
        WelcomeFragment$loadVlVImageUrl$1$run$imageHelperListener$1 welcomeFragment$loadVlVImageUrl$1$run$imageHelperListener$1 = new WelcomeFragment$loadVlVImageUrl$1$run$imageHelperListener$1(this);
        ImageLoader r0 = phVar.m9829();
        if (r0 != null) {
            r0.mo3059(this.$url, AssetType.signupAsset, 0, 0, welcomeFragment$loadVlVImageUrl$1$run$imageHelperListener$1);
        }
    }
}
