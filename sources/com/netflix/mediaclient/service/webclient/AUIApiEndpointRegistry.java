package com.netflix.mediaclient.service.webclient;

import java.util.Map;
public interface AUIApiEndpointRegistry extends ApiEndpointRegistry {
    /* renamed from: ˊ  reason: contains not printable characters */
    Map<String, String> mo1448();

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1449(String str);

    /* renamed from: ˏ  reason: contains not printable characters */
    Map<String, String> mo1450(ResponsePathFormat responsePathFormat);

    public enum ResponsePathFormat {
        GRAPH("graph"),
        HIERARCHICAL("hierarchical");
        

        /* renamed from: ˊ  reason: contains not printable characters */
        public final String f2344;

        private ResponsePathFormat(String str) {
            this.f2344 = str;
        }
    }
}
