package org.chromium.net;
public abstract class ICronetEngineBuilder {
    public abstract ExperimentalCronetEngine build();

    public abstract ICronetEngineBuilder enableHttp2(boolean z);

    public abstract ICronetEngineBuilder enableHttpCache(int i, long j);

    public abstract ICronetEngineBuilder setStoragePath(String str);

    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean z) {
        return this;
    }
}
