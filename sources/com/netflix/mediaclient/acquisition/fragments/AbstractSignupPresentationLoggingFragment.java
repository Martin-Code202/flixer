package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.cl.Logger;
import java.util.HashMap;
import o.AbstractC0574;
import o.C1224;
public abstract class AbstractSignupPresentationLoggingFragment extends AbstractSignupFragment {
    private HashMap _$_findViewCache;
    private Long presentationSessionId;

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public abstract AbstractC0574 getTrackingInfo();

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.presentationSessionId = Logger.INSTANCE.m142(new C1224(getTrackingInfo(), getAppView()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        Long l = this.presentationSessionId;
        if (l != null) {
            l.longValue();
            Logger.INSTANCE.m140(this.presentationSessionId);
        }
    }
}
