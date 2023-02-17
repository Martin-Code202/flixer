package com.netflix.mediaclient.servicemgr.interface_;

import android.text.TextUtils;
public enum LoMoType {
    CONTINUE_WATCHING("continueWatching"),
    INSTANT_QUEUE("queue"),
    BILLBOARD("billboard"),
    CHARACTERS("character"),
    ROAR("netflixOriginals"),
    FLAT_GENRE("defaultKidsList"),
    BIG_ROW("bigRow"),
    SHORT_FORM("shortForm"),
    PREVIEWS("thirtySecondPreview"),
    STANDARD("");
    

    /* renamed from: ͺ  reason: contains not printable characters */
    private final String f2800;

    private LoMoType(String str) {
        this.f2800 = str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static LoMoType m1573(String str) {
        if (!TextUtils.isEmpty(str)) {
            LoMoType[] values = values();
            for (LoMoType loMoType : values) {
                if (loMoType.f2800.equalsIgnoreCase(str)) {
                    return loMoType;
                }
            }
        }
        return STANDARD;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m1575() {
        return this.f2800;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m1574(LoMoType loMoType) {
        return STANDARD.equals(loMoType) || FLAT_GENRE.equals(loMoType);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m1572(LoMoType loMoType) {
        return !CONTINUE_WATCHING.equals(loMoType) && !BILLBOARD.equals(loMoType) && !ROAR.equals(loMoType) && !BIG_ROW.equals(loMoType) && !SHORT_FORM.equals(loMoType) && !PREVIEWS.equals(loMoType);
    }
}
