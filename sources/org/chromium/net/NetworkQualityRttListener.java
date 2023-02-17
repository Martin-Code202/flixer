package org.chromium.net;

import java.util.concurrent.Executor;
public abstract class NetworkQualityRttListener {
    private final Executor mExecutor;

    public abstract void onRttObservation(int i, long j, int i2);

    public Executor getExecutor() {
        return this.mExecutor;
    }
}
