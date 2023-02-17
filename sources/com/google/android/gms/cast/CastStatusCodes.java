package com.google.android.gms.cast;

import com.google.android.gms.common.api.CommonStatusCodes;
public final class CastStatusCodes {
    public static String getStatusCodeString(int i) {
        switch (i) {
            case 0:
                return "SUCCESS";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 13:
                return "UNKNOWN_ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 2000:
                return "AUTHENTICATION_FAILED";
            case 2001:
                return "INVALID_REQUEST";
            case 2002:
                return "CANCELED";
            case 2003:
                return "NOT_ALLOWED";
            case 2004:
                return "APPLICATION_NOT_FOUND";
            case 2005:
                return "APPLICATION_NOT_RUNNING";
            case 2006:
                return "MESSAGE_TOO_LARGE";
            case 2007:
                return "MESSAGE_SEND_BUFFER_TOO_FULL";
            case 2100:
                return "FAILED";
            case 2101:
                return "STATUS_CANCELLED";
            case 2102:
                return "STATUS_TIMED_OUT";
            case 2103:
                return "REPLACED";
            case 2200:
                return "ERROR_SERVICE_CREATION_FAILED";
            case 2201:
                return "ERROR_SERVICE_DISCONNECTED";
            default:
                return CommonStatusCodes.getStatusCodeString(i);
        }
    }
}
