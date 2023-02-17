package com.crittercism.app;

import java.util.Date;
public class CrashData {
    private String a;
    private String b;
    private Date c;

    public CrashData(String str, String str2, Date date) {
        this.a = str;
        this.b = str2;
        this.c = date;
    }

    public CrashData copy() {
        return new CrashData(this.a, this.b, this.c);
    }

    public String getName() {
        return this.a;
    }

    public String getReason() {
        return this.b;
    }

    public Date getTimeOccurred() {
        return this.c;
    }
}
