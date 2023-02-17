package com.netflix.mediaclient.service.webclient;

import java.net.URL;
import java.util.Map;
import o.AbstractC2032oh;
import o.AbstractC2039oo;
public interface ApiEndpointRegistry extends AbstractC2032oh {
    /* renamed from: ˊ  reason: contains not printable characters */
    String mo1451(String str);

    /* renamed from: ˋ  reason: contains not printable characters */
    URL mo1452(String str);

    /* renamed from: ˋ  reason: contains not printable characters */
    Map<String, String> mo1453();

    /* renamed from: ˎ  reason: contains not printable characters */
    String mo1454();

    /* renamed from: ˎ */
    void mo1449(String str);

    /* renamed from: ˏ  reason: contains not printable characters */
    String mo1455(String str);

    /* renamed from: ˏ  reason: contains not printable characters */
    Map<String, String> mo1456(ResponsePathFormat responsePathFormat);

    /* renamed from: ˏ  reason: contains not printable characters */
    AbstractC2039oo mo1457();

    /* renamed from: ॱ  reason: contains not printable characters */
    String mo1458(String str);

    /* renamed from: ॱ  reason: contains not printable characters */
    boolean mo1459();

    public enum ResponsePathFormat {
        GRAPH("graph"),
        HIERARCHICAL("hierarchical");
        

        /* renamed from: ˏ  reason: contains not printable characters */
        public final String f2348;

        private ResponsePathFormat(String str) {
            this.f2348 = str;
        }
    }
}
