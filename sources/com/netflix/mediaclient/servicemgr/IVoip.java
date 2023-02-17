package com.netflix.mediaclient.servicemgr;
public interface IVoip {

    public enum CallState {
        CONNECTING,
        CONNECTED,
        ENDED
    }

    public enum ConnectivityState {
        NO_CONNECTION,
        RED,
        YELLOW,
        GREEN
    }

    public interface If {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo1548(Cif ifVar);

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo1549(Cif ifVar);

        /* renamed from: ˎ  reason: contains not printable characters */
        void mo1550(Cif ifVar);

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo1551(Cif ifVar);

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo1552(boolean z);

        /* renamed from: ॱ  reason: contains not printable characters */
        void mo1553(Cif ifVar);
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.IVoip$if  reason: invalid class name */
    public interface Cif {
    }

    /* renamed from: ʻ */
    boolean mo1428();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    boolean mo1537();

    /* renamed from: ʾ  reason: contains not printable characters */
    boolean mo1538();

    /* renamed from: ʿ  reason: contains not printable characters */
    void mo1539();

    /* renamed from: ˈ  reason: contains not printable characters */
    boolean mo1540();

    /* renamed from: ˉ  reason: contains not printable characters */
    boolean mo1541();

    /* renamed from: ˊ */
    long mo1430();

    /* renamed from: ˊ */
    boolean mo1431(If v);

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    void mo1542();

    /* renamed from: ˋ */
    void mo1434(If v);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo1543(boolean z);

    /* renamed from: ˋˊ  reason: contains not printable characters */
    boolean mo1544();

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1545(boolean z);

    /* renamed from: ˎ */
    boolean mo1437();

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo1546(char c);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo1547(float f);

    /* renamed from: ᐝ */
    boolean mo1446();
}
