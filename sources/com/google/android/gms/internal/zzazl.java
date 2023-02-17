package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;
public final class zzazl {
    private static final Pattern zzfbv = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");

    public static <T> boolean zza(T t, T t2) {
        if (t == null && t2 == null) {
            return true;
        }
        return (t == null || t2 == null || !t.equals(t2)) ? false : true;
    }

    public static String zzb(Locale locale) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            sb.append('-').append(country);
        }
        String variant = locale.getVariant();
        if (!TextUtils.isEmpty(variant)) {
            sb.append('-').append(variant);
        }
        return sb.toString();
    }

    public static void zzfg(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        } else if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        } else if (str.length() == 11) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    public static String zzfh(String str) {
        String valueOf = String.valueOf("urn:x-cast:");
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public static String zzfi(String str) {
        if (zzfbv.matcher(str).matches()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z') || ((charAt >= '0' && charAt <= '9') || charAt == '_' || charAt == '-')) || charAt == '.' || charAt == ':') {
                sb.append(charAt);
            } else {
                sb.append(String.format("%%%04x", Integer.valueOf(65535 & charAt)));
            }
        }
        return sb.toString();
    }
}
