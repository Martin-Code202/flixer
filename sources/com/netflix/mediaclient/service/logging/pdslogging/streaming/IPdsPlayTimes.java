package com.netflix.mediaclient.service.logging.pdslogging.streaming;
public interface IPdsPlayTimes {

    public enum StreamType {
        AUDIO("audio"),
        VIDEO("video"),
        TIMED_TEXT("text"),
        UNKNOWN("");
        

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f1206;

        private StreamType(String str) {
            this.f1206 = str;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m616() {
            return this.f1206;
        }
    }
}
