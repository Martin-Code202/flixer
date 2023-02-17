package io.reactivex.exceptions;
public final class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorNotImplementedException(Throwable th) {
        super(th != null ? th.getMessage() : null, th != null ? th : new NullPointerException());
    }
}
