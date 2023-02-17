package org.chromium.net.impl;

import android.content.Context;
import org.chromium.base.annotations.UsedByReflection;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;
import org.chromium.net.ExperimentalCronetEngine;
public class NativeCronetProvider extends CronetProvider {
    @UsedByReflection
    public NativeCronetProvider(Context context) {
        super(context);
    }

    @Override // org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder() {
        return new ExperimentalCronetEngine.Builder(new NativeCronetEngineBuilderImpl(this.mContext));
    }

    @Override // org.chromium.net.CronetProvider
    public String getName() {
        return "App-Packaged-Cronet-Provider";
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
