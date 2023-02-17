package com.google.android.gms.cast;

import com.google.android.gms.internal.zzazl;
import java.util.Collection;
public final class CastMediaControlIntent {
    public static String categoryForCast(String str) {
        if (str != null) {
            return zza("com.google.android.gms.cast.CATEGORY_CAST", str, null);
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    public static String categoryForCast(String str, Collection<String> collection) {
        if (str == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        } else if (collection != null) {
            return zza("com.google.android.gms.cast.CATEGORY_CAST", str, collection);
        } else {
            throw new IllegalArgumentException("namespaces cannot be null");
        }
    }

    private static String zza(String str, String str2, Collection<String> collection) {
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            String upperCase = str2.toUpperCase();
            if (!upperCase.matches("[A-F0-9]+")) {
                String valueOf = String.valueOf(str2);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid application ID: ".concat(valueOf) : new String("Invalid application ID: "));
            }
            sb.append("/").append(upperCase);
        }
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if (str2 == null) {
                sb.append("/");
            }
            sb.append("/");
            boolean z = true;
            for (String str3 : collection) {
                zzazl.zzfg(str3);
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(zzazl.zzfi(str3));
            }
        }
        return sb.toString();
    }
}
