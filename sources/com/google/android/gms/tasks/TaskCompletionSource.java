package com.google.android.gms.tasks;
public class TaskCompletionSource<TResult> {
    private final zzn<TResult> zzkgh = new zzn<>();

    public Task<TResult> getTask() {
        return this.zzkgh;
    }

    public void setException(Exception exc) {
        this.zzkgh.setException(exc);
    }

    public void setResult(TResult tresult) {
        this.zzkgh.setResult(tresult);
    }

    public boolean trySetException(Exception exc) {
        return this.zzkgh.trySetException(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.zzkgh.trySetResult(tresult);
    }
}
