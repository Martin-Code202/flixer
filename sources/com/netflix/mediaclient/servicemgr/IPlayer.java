package com.netflix.mediaclient.servicemgr;
public interface IPlayer {

    public interface IF {
        /* renamed from: ˋ  reason: contains not printable characters */
        void mo1523();
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.IPlayer$If  reason: case insensitive filesystem */
    public interface AbstractC1290If {
        /* renamed from: ˋ  reason: contains not printable characters */
        void mo1524();
    }

    public enum PlayerStallReason {
        avStalled,
        subtitleStalled
    }

    public interface aux {
        /* renamed from: ʼ */
        boolean mo997();

        /* renamed from: ˊ */
        int mo998();

        /* renamed from: ˋ */
        boolean mo999();

        /* renamed from: ˎ */
        String mo1000();

        /* renamed from: ˏ */
        String mo1001();
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.IPlayer$iF  reason: case insensitive filesystem */
    public interface AbstractC1291iF {
        /* renamed from: ˋ  reason: contains not printable characters */
        void mo1528();
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.IPlayer$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ॱ  reason: contains not printable characters */
        void mo1529(long j);
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.IPlayer$ˊ  reason: contains not printable characters */
    public interface AbstractC0024 {
        /* renamed from: ˎ  reason: contains not printable characters */
        void mo1530(aux aux);
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.IPlayer$ˋ  reason: contains not printable characters */
    public interface AbstractC0025 {
        /* renamed from: ˏ  reason: contains not printable characters */
        void mo1531(PlayerState playerState);
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.IPlayer$ˎ  reason: contains not printable characters */
    public interface AbstractC0026 {
        /* renamed from: ˏ  reason: contains not printable characters */
        void mo1532(PlayerStallReason playerStallReason);
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.IPlayer$ˏ  reason: contains not printable characters */
    public interface AbstractC0027 {
        /* renamed from: ˏ  reason: contains not printable characters */
        void mo1533();
    }

    public enum PlayerState {
        Idle("Idle"),
        Prepared("Prepared"),
        Started("Started"),
        Paused("Paused"),
        Error("Error"),
        Stalled("Stalled"),
        Completed("Completed");
        

        /* renamed from: ʽ  reason: contains not printable characters */
        private final String f2588;

        private PlayerState(String str) {
            this.f2588 = str;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public String m1527() {
            return this.f2588;
        }
    }

    public enum PlaybackType {
        StreamingPlayback("StreamingPlayback"),
        OfflinePlayback("OfflinePlayback"),
        Unknown("Unknown");
        

        /* renamed from: ˎ  reason: contains not printable characters */
        private final String f2576;

        private PlaybackType(String str) {
            this.f2576 = str;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static PlaybackType m1525(String str) {
            PlaybackType[] values = values();
            for (PlaybackType playbackType : values) {
                if (playbackType.f2576.equalsIgnoreCase(str)) {
                    return playbackType;
                }
            }
            return Unknown;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public String m1526() {
            return this.f2576;
        }
    }
}
