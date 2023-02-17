package com.netflix.mediaclient.acquisition.viewmodels;

import android.content.Context;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import o.C1457Fr;
public final class WarnUserViewModel extends AbstractSignupViewModel {
    private final String MODE = SignupConstants.Mode.WARN_USER;
    private final String NEXT_ACTION_ID = "";

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getMODE() {
        return this.MODE;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getNEXT_ACTION_ID() {
        return this.NEXT_ACTION_ID;
    }

    public final String warningString(Context context) {
        C1457Fr.m5025(context, "context");
        String errorStringKey = getErrorStringKey();
        String stringResource = errorStringKey != null ? ContextKt.getStringResource(context, errorStringKey) : null;
        if (stringResource != null) {
            return stringResource;
        }
        String string = context.getString(R.string.generic_retryable_failure);
        C1457Fr.m5016((Object) string, "context.getString(R.stri…eneric_retryable_failure)");
        return string;
    }
}
