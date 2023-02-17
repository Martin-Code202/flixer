package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzbae {
    private static final zzazx zzejm = new zzazx("MetadataUtils");
    private static final String[] zzfdd = {"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String zzfde;

    static {
        String valueOf = String.valueOf("yyyyMMdd'T'HHmmss");
        String valueOf2 = String.valueOf(zzfdd[0]);
        zzfde = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public static void zza(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
    }

    public static void zza(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage webImage : list) {
                jSONArray.put(webImage.toJson());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    public static Calendar zzfn(String str) {
        if (TextUtils.isEmpty(str)) {
            zzejm.zzb("Input string is empty or null", new Object[0]);
            return null;
        }
        String zzfo = zzfo(str);
        if (TextUtils.isEmpty(zzfo)) {
            zzejm.zzb("Invalid date format", new Object[0]);
            return null;
        }
        String zzfp = zzfp(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(zzfp)) {
            String valueOf = String.valueOf(zzfo);
            zzfo = new StringBuilder(String.valueOf(zzfp).length() + String.valueOf(valueOf).length() + 1).append(valueOf).append("T").append(zzfp).toString();
            str2 = zzfp.length() == 6 ? "yyyyMMdd'T'HHmmss" : zzfde;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(zzfo));
            return instance;
        } catch (ParseException e) {
            zzejm.zzb("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String zzfo(String str) {
        if (TextUtils.isEmpty(str)) {
            zzejm.zzb("Input string is empty or null", new Object[0]);
            return null;
        }
        try {
            return str.substring(0, 8);
        } catch (IndexOutOfBoundsException e) {
            zzejm.zze("Error extracting the date: %s", e.getMessage());
            return null;
        }
    }

    private static String zzfp(String str) {
        if (TextUtils.isEmpty(str)) {
            zzejm.zzb("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != 8) {
            zzejm.zzb("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == 6) {
                return substring;
            }
            switch (substring.charAt(6)) {
                case '+':
                case '-':
                    int length = substring.length();
                    if (length == zzfdd[1].length() + 6 || length == zzfdd[2].length() + 6 || length == zzfdd[3].length() + 6) {
                        return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    }
                    return null;
                case 'Z':
                    if (substring.length() != zzfdd[0].length() + 6) {
                        return null;
                    }
                    String valueOf = String.valueOf(substring.substring(0, substring.length() - 1));
                    String valueOf2 = String.valueOf("+0000");
                    return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            zzejm.zzb("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }
}
