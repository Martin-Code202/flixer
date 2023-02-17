package com.netflix.mediaclient.service.player.subtitles.text;

import o.mO;
public enum CharacterEdgeTypeMapping {
    NONE("NONE", null),
    RAISED("RAISED", mO.C0148.f8739),
    DEPRESSED("DEPRESSED", mO.C0148.f8741),
    UNIFORM("UNIFORM", mO.C0148.f8740),
    DROP_SHADOW("DROP_SHADOW", mO.C0148.f8738);
    

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f2029;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private mO.C0148 f2030;

    private CharacterEdgeTypeMapping(String str, mO.C0148 r4) {
        this.f2029 = str;
        this.f2030 = r4;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m1156() {
        return this.f2029;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public mO.C0148 m1157() {
        return this.f2030;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.f2029;
    }
}
