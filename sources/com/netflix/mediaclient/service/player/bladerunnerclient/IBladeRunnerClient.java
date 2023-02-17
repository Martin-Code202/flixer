package com.netflix.mediaclient.service.player.bladerunnerclient;
public interface IBladeRunnerClient {

    public enum ManifestRequestFlavor {
        STANDARD("STANDARD"),
        PREFETCH("PRE_FETCH"),
        OFFLINE("OFFLINE"),
        UNKNOWN("");
        

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f1630;

        private ManifestRequestFlavor(String str) {
            this.f1630 = str;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m942() {
            return this.f1630;
        }
    }

    public enum ManifestType {
        STANDARD("standard"),
        OFFLINE("offline"),
        UNKNOWN("");
        

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f1635;

        private ManifestType(String str) {
            this.f1635 = str;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public String m943() {
            return this.f1635;
        }
    }

    public enum LicenseRequestFlavor {
        STANDARD("standard"),
        LIMITED("limited"),
        OFFLINE("offline"),
        UNKNOWN("");
        

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f1624;

        private LicenseRequestFlavor(String str) {
            this.f1624 = str;
        }
    }

    public enum OfflineRefreshInvoke {
        USER(0),
        MAINTENANCE(1),
        UNKNOWN(2);
        

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f1640;

        private OfflineRefreshInvoke(int i) {
            this.f1640 = i;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public int m944() {
            return this.f1640;
        }
    }

    public enum PdsEventType {
        START("start"),
        STOP("stop"),
        SPLICE("splice"),
        PAUSE("pause"),
        RESUME("resume"),
        KEEP_ALIVE("keepAlive"),
        UNKNOWN("");
        

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private String f1649;

        private PdsEventType(String str) {
            this.f1649 = str;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m945() {
            return this.f1649;
        }
    }
}
