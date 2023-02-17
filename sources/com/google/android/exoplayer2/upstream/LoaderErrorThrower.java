package com.google.android.exoplayer2.upstream;
public interface LoaderErrorThrower {
    void maybeThrowError();

    public static final class Dummy implements LoaderErrorThrower {
        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() {
        }
    }
}
