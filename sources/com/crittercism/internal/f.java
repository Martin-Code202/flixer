package com.crittercism.internal;

import java.net.InetAddress;
public final class f {
    public InetAddress a;
    String b;
    public String c = "/";
    public a d = null;
    public int e = -1;
    public boolean f = false;

    public enum a {
        HTTP("http", 80),
        HTTPS("https", 443);
        
        private String c;
        private int d;

        private a(String str, int i) {
            this.c = str;
            this.d = i;
        }
    }
}
