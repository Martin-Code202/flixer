package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.util.HashMap;
import o.C0522;
import o.C0716;
import o.C1456Fq;
import o.C1457Fr;
public final class PhoneNumberCountryInput extends RelativeLayout {
    private HashMap _$_findViewCache;

    public PhoneNumberCountryInput(Context context) {
        this(context, null, 0, 0, 14, null);
    }

    public PhoneNumberCountryInput(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public PhoneNumberCountryInput(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNumberCountryInput(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        C1457Fr.m5025(context, "context");
        View.inflate(context, R.layout.widget_phone_number_country_input, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneNumberCountryInput(Context context, AttributeSet attributeSet, int i, int i2, int i3, C1456Fq fq) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final String getFlagAssetUrl(String str) {
        C1457Fr.m5025(str, SignupConstants.Field.COUNTRY_CODE);
        return "https://assets.nflxext.com/ffe/siteui/acquisition/androidSignup/flags/" + str + ".png";
    }

    public final void updateFlag(String str, ImageLoader imageLoader) {
        C1457Fr.m5025(str, SignupConstants.Field.COUNTRY_CODE);
        C1457Fr.m5025(imageLoader, "imageLoader");
        loadFlagImageUrl(getFlagAssetUrl(str), imageLoader);
    }

    private final void loadFlagImageUrl(String str, ImageLoader imageLoader) {
        imageLoader.mo3057((C0522) _$_findCachedViewById(R.Cif.flagImage), str, AssetType.signupAsset, "flagImage", StaticImgConfig.DARK_NO_PLACEHOLDER, true);
    }

    public final void setErrorText(int i) {
        ((C0716) _$_findCachedViewById(R.Cif.phoneEditTextErrorMessage)).setText(i);
    }

    public final void showError(boolean z) {
        C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.phoneEditTextErrorMessage);
        C1457Fr.m5016((Object) r0, "phoneEditTextErrorMessage");
        r0.setVisibility(z ? 0 : 8);
        ((TextInputLayout) _$_findCachedViewById(R.Cif.phoneTextInputLayout)).setBackgroundResource(z ? R.drawable.text_input_layout_error_background : R.drawable.text_input_layout_background);
    }
}
