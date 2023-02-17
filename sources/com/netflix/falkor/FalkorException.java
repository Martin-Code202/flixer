package com.netflix.falkor;

import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import java.util.Locale;
import o.AbstractC2049oy;
import o.C0848;
import o.C1283;
import o.C1349Bv;
public final class FalkorException extends VolleyError {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f533 = "FalkorException";

    public FalkorException(String str) {
        super(str);
    }

    public FalkorException(Throwable th) {
        super(th);
    }

    public FalkorException(String str, Throwable th) {
        super(str, th);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static StatusCode m156(String str, AbstractC2049oy oyVar) {
        StatusCode statusCode = StatusCode.FALKOR_RESPONSE_PARSE_ERROR;
        if (C1349Bv.m4113(str)) {
            return statusCode;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (m155(lowerCase)) {
            statusCode = StatusCode.BROWSE_AGENT_WRONG_STATE;
        } else if (m158(lowerCase)) {
            statusCode = StatusCode.INVALID_COUNRTY;
        } else if (m160(lowerCase)) {
            statusCode = StatusCode.INSUFFICIENT_CONTENT;
        } else if (m157(lowerCase)) {
            statusCode = StatusCode.USER_NOT_AUTHORIZED;
        } else if (m159(lowerCase)) {
            statusCode = StatusCode.DELETED_PROFILE;
        } else if (m153(lowerCase)) {
            if (oyVar != null) {
                oyVar.mo5714("Endpoint NPE " + lowerCase);
            }
            statusCode = StatusCode.WRONG_PATH;
        } else if (C0848.m15507(lowerCase)) {
            statusCode = StatusCode.ALREADY_IN_QUEUE;
        } else if (C0848.m15505(lowerCase)) {
            statusCode = StatusCode.NOT_IN_QUEUE;
        } else if (m161(lowerCase)) {
            if (oyVar != null) {
                oyVar.mo5714("map cache miss");
            }
            statusCode = StatusCode.SERVER_ERROR_MAP_CACHE_MISS;
        } else if (m154(lowerCase)) {
            if (oyVar != null) {
                oyVar.mo5714("map error " + lowerCase);
            }
            statusCode = StatusCode.MAP_ERROR;
        }
        C1283.m16854(f533, "statusCode :" + statusCode);
        return statusCode;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m155(String str) {
        return str.contains("wrong state".toLowerCase());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m158(String str) {
        return str.contains("failurereason=invalidcountry".toLowerCase());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m160(String str) {
        return str.contains("failurereason=insufficientdata".toLowerCase());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m157(String str) {
        return str.contains("NON_MEMBER_FAULT".toLowerCase(Locale.US)) || str.contains("not authorized") || str.contains("unauthorized");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m159(String str) {
        return str.contains("deleted profile".toLowerCase());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private static boolean m153(String str) {
        return str.contains("nullpointerexception".toLowerCase());
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private static boolean m154(String str) {
        return str.contains("map error".toLowerCase());
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static boolean m161(String str) {
        return str.contains("cache miss".toLowerCase()) || str.contains("mapgetcachedlistclient failed".toLowerCase()) || str.contains("cachemiss".toLowerCase());
    }
}
