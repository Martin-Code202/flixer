package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    public abstract void onSuccess(R r);
}
