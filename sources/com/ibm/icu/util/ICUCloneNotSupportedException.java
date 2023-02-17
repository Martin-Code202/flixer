package com.ibm.icu.util;
public class ICUCloneNotSupportedException extends ICUException {
    private static final long serialVersionUID = -4824446458488194964L;

    public ICUCloneNotSupportedException() {
    }

    public ICUCloneNotSupportedException(Throwable th) {
        super(th);
    }
}
