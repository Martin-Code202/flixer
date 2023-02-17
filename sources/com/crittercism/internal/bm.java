package com.crittercism.internal;
public class bm extends Throwable {
    private static final long serialVersionUID = -1947260712494608235L;
    public String a;

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        String localizedMessage = getLocalizedMessage();
        String str = this.a;
        if (localizedMessage == null) {
            return str;
        }
        return str + ": " + localizedMessage;
    }
}
