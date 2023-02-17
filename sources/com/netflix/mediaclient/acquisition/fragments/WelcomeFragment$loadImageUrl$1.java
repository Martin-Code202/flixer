package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import o.C0522;
import o.C1457Fr;
import o.C2059ph;
public final class WelcomeFragment$loadImageUrl$1 extends NetflixActivity.If {
    final /* synthetic */ String $description;
    final /* synthetic */ C0522 $imageView;
    final /* synthetic */ String $url;
    final /* synthetic */ WelcomeFragment this$0;

    WelcomeFragment$loadImageUrl$1(WelcomeFragment welcomeFragment, C0522 r2, String str, String str2) {
        this.this$0 = welcomeFragment;
        this.$imageView = r2;
        this.$url = str;
        this.$description = str2;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
    public void run(C2059ph phVar) {
        C1457Fr.m5025(phVar, "manager");
        ImageLoader imageLoader = NetflixActivity.getImageLoader(this.this$0.getActivity());
        if (imageLoader != null) {
            imageLoader.mo3057(this.$imageView, this.$url, AssetType.signupAsset, this.$description, StaticImgConfig.DARK, true);
        }
    }
}
