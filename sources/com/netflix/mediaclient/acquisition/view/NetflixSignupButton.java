package com.netflix.mediaclient.acquisition.view;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.netflix.mediaclient.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import o.C0754;
import o.C1456Fq;
import o.C1457Fr;
public final class NetflixSignupButton extends FrameLayout {
    private HashMap _$_findViewCache;
    private LiveData<Boolean> mLoadingData;

    public NetflixSignupButton(Context context) {
        this(context, null, 0, 0, 14, null);
    }

    public NetflixSignupButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public NetflixSignupButton(Context context, AttributeSet attributeSet, int i) {
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
    public NetflixSignupButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        C1457Fr.m5025(context, "context");
        View.inflate(context, R.layout.netflix_signup_button_layout, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetflixSignupButton(Context context, AttributeSet attributeSet, int i, int i2, int i3, C1456Fq fq) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final C0754 getButton() {
        C0754 r0 = (C0754) _$_findCachedViewById(R.Cif.textButton);
        C1457Fr.m5016((Object) r0, "textButton");
        return r0;
    }

    public final CharSequence getText() {
        C0754 r0 = (C0754) _$_findCachedViewById(R.Cif.textButton);
        C1457Fr.m5016((Object) r0, "textButton");
        CharSequence text = r0.getText();
        C1457Fr.m5016((Object) text, "textButton.text");
        return text;
    }

    public final void setText(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "value");
        C0754 r0 = (C0754) _$_findCachedViewById(R.Cif.textButton);
        C1457Fr.m5016((Object) r0, "textButton");
        r0.setText(charSequence);
    }

    public final LiveData<Boolean> getLoadingData() {
        LiveData<Boolean> liveData = this.mLoadingData;
        if (liveData == null) {
            C1457Fr.m5017("mLoadingData");
        }
        return liveData;
    }

    public final void setLoadingData(LiveData<Boolean> liveData) {
        C1457Fr.m5025(liveData, "value");
        this.mLoadingData = liveData;
        LiveData<Boolean> liveData2 = this.mLoadingData;
        if (liveData2 == null) {
            C1457Fr.m5017("mLoadingData");
        }
        Context context = getContext();
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.arch.lifecycle.LifecycleOwner");
        }
        liveData2.observe((LifecycleOwner) context, new NetflixSignupButton$loadingData$1(this));
    }

    public final void showSpinner() {
        ((C0754) _$_findCachedViewById(R.Cif.textButton)).setTextColor(ContextCompat.getColor(getContext(), 17170445));
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.Cif.loadingView);
        C1457Fr.m5016((Object) progressBar, "loadingView");
        progressBar.setVisibility(0);
        setEnabled(false);
    }

    public final void hideSpinner() {
        ((C0754) _$_findCachedViewById(R.Cif.textButton)).setTextColor(ContextCompat.getColor(getContext(), 17170443));
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.Cif.loadingView);
        C1457Fr.m5016((Object) progressBar, "loadingView");
        progressBar.setVisibility(8);
        setEnabled(true);
    }
}
