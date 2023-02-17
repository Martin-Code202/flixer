package org.chromium.net.impl;

import android.content.Context;
import org.chromium.net.ExperimentalCronetEngine;
public class NativeCronetEngineBuilderImpl extends CronetEngineBuilderImpl {
    public NativeCronetEngineBuilderImpl(Context context) {
        super(context);
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (getUserAgent() == null) {
            setUserAgent(getDefaultUserAgent());
        }
        CronetUrlRequestContext cronetUrlRequestContext = new CronetUrlRequestContext(this);
        this.mMockCertVerifier = 0;
        return cronetUrlRequestContext;
    }
}
