package com.netflix.mediaclient.acquisition;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import java.util.HashMap;
import o.C1456Fq;
import o.C1457Fr;
public final class SignupNativeTabletActivity extends SignupNativeActivity {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = TAG;
    private HashMap _$_findViewCache;

    @Override // com.netflix.mediaclient.acquisition.SignupNativeActivity
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.SignupNativeActivity
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

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final String getTAG() {
            return SignupNativeTabletActivity.TAG;
        }

        public final Intent createStartIntent(Context context) {
            C1457Fr.m5025(context, "context");
            return new Intent(context, SignupNativeTabletActivity.class);
        }
    }
}
