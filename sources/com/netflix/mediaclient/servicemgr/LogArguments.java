package com.netflix.mediaclient.servicemgr;
public final class LogArguments {

    public enum LogLevel {
        CONSOLE(-1),
        TRACE(10),
        DEBUG(20),
        INFO(30),
        WARN(40),
        ERROR(50),
        FATAL(60);
        

        /* renamed from: ʻ  reason: contains not printable characters */
        private int f2630;

        private LogLevel(int i) {
            this.f2630 = i;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public int m1554() {
            return this.f2630;
        }
    }
}
