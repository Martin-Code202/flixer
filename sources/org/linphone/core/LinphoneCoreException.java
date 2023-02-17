package org.linphone.core;
public class LinphoneCoreException extends Exception {
    public LinphoneCoreException() {
    }

    public LinphoneCoreException(String str) {
        super(str);
    }

    public LinphoneCoreException(Throwable th) {
        super(th);
    }

    public LinphoneCoreException(String str, Throwable th) {
        super(str, th);
    }
}
