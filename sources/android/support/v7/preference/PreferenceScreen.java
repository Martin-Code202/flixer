package android.support.v7.preference;

import android.content.Context;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.preference.PreferenceManager;
import android.util.AttributeSet;
public final class PreferenceScreen extends PreferenceGroup {
    private boolean mShouldUseGeneratedIds = true;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.preferenceScreenStyle, 16842891));
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.Preference
    public void onClick() {
        PreferenceManager.OnNavigateToScreenListener onNavigateToScreenListener;
        if (getIntent() == null && getFragment() == null && getPreferenceCount() != 0 && (onNavigateToScreenListener = getPreferenceManager().getOnNavigateToScreenListener()) != null) {
            onNavigateToScreenListener.onNavigateToScreen(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.PreferenceGroup
    public boolean isOnSameScreenAsChildren() {
        return false;
    }

    public boolean shouldUseGeneratedIds() {
        return this.mShouldUseGeneratedIds;
    }
}
