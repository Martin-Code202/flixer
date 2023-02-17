package org.chromium.net.impl;

import android.content.Context;
import org.chromium.net.ExperimentalCronetEngine;
public class JavaCronetEngineBuilderImpl extends CronetEngineBuilderImpl {
    public JavaCronetEngineBuilderImpl(Context context) {
        super(context);
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (getUserAgent() == null) {
            setUserAgent(getDefaultUserAgent());
        }
        return new JavaCronetEngine(this);
    }
}
