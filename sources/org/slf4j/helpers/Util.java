package org.slf4j.helpers;
public class Util {
    public static final void reportFailure(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final void reportFailure(String str) {
        System.err.println("SLF4J: " + str);
    }
}
