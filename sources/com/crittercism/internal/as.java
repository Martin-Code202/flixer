package com.crittercism.internal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
public final class as {
    private static final Map<String, String> e;
    public URL a;
    public URL b;
    public URL c;
    public URL d;

    static {
        HashMap hashMap = new HashMap();
        e = hashMap;
        hashMap.put("00555300", "crittercism.com");
        e.put("00555304", "crit-ci.com");
        e.put("00555305", "crit-staging.com");
        e.put("00444503", "eu.crittercism.com");
    }

    public as(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null App ID");
        } else if (!str.matches("[0-9a-fA-F]+")) {
            throw new IllegalArgumentException("App ID must be hexadecimal characters");
        } else if (str.length() == 24 || str.length() == 40) {
            String str2 = null;
            if (str.length() == 24) {
                str2 = "00555300";
            } else if (str.length() == 40) {
                str2 = str.substring(str.length() - 8);
            }
            String str3 = e.get(str2);
            if (str3 == null) {
                throw new IllegalArgumentException("Invalid character sequence");
            }
            try {
                this.a = new URL(System.getProperty("com.crittercism.apmUrl", "https://apm." + str3));
                this.b = new URL(System.getProperty("com.crittercism.apiUrl", "https://api." + str3));
                this.c = new URL(System.getProperty("com.crittercism.txnUrl", "https://txn.ingest." + str3));
                this.d = new URL(System.getProperty("com.crittercism.appLoadUrl", "https://appload.ingest." + str3));
            } catch (MalformedURLException e2) {
                throw new IllegalArgumentException("Crittercism failed to initialize", e2);
            }
        } else {
            throw new IllegalArgumentException("App ID must be either 24 or 40 characters");
        }
    }
}
