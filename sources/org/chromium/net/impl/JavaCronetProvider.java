package org.chromium.net.impl;

import android.content.Context;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;
import org.chromium.net.ExperimentalCronetEngine;
public class JavaCronetProvider extends CronetProvider {
    public JavaCronetProvider(Context context) {
        super(context);
    }

    @Override // org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder() {
        return new ExperimentalCronetEngine.Builder(new JavaCronetEngineBuilderImpl(this.mContext));
    }

    @Override // org.chromium.net.CronetProvider
    public String getName() {
        return "Fallback-Cronet-Provider";
    }

    @Override // org.chromium.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    @Override // org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }
}
