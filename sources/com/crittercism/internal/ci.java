package com.crittercism.internal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
public final class ci {
    public static final ci a = new ci();
    private cj b = new a(this, (byte) 0);
    private ThreadLocal<SimpleDateFormat> c = new ThreadLocal<>();
    private ThreadLocal<SimpleDateFormat> d = new ThreadLocal<>();

    private ci() {
    }

    private SimpleDateFormat b() {
        SimpleDateFormat simpleDateFormat = this.c.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
        simpleDateFormat2.setLenient(false);
        this.c.set(simpleDateFormat2);
        return simpleDateFormat2;
    }

    public final String a() {
        return a(this.b.a());
    }

    public final String a(Date date) {
        return b().format(date);
    }

    public final long a(String str) {
        Date date;
        try {
            date = b().parse(str);
        } catch (ParseException unused) {
            SimpleDateFormat simpleDateFormat = this.d.get();
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                simpleDateFormat.setLenient(false);
                this.d.set(simpleDateFormat);
            }
            date = simpleDateFormat.parse(str);
        }
        return date.getTime();
    }

    class a implements cj {
        private a() {
        }

        /* synthetic */ a(ci ciVar, byte b) {
            this();
        }

        @Override // com.crittercism.internal.cj
        public final Date a() {
            return new Date();
        }
    }
}
