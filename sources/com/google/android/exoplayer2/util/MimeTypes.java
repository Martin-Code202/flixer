package com.google.android.exoplayer2.util;
public final class MimeTypes {
    public static boolean isAudio(String str) {
        return "audio".equals(getTopLevelType(str));
    }

    public static boolean isVideo(String str) {
        return "video".equals(getTopLevelType(str));
    }

    public static boolean isText(String str) {
        return "text".equals(getTopLevelType(str));
    }

    public static String getMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            return "video/avc";
        }
        if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (trim.startsWith("mp4a")) {
            return "audio/mp4a-latm";
        }
        if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            return "audio/vnd.dts";
        }
        if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (trim.startsWith("opus")) {
            return "audio/opus";
        }
        if (trim.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        return null;
    }

    private static String getTopLevelType(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }
}
