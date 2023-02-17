package com.netflix.mediaclient.servicemgr.interface_.offline;
public enum WatchState {
    UNKNOWN(-1),
    NOT_WATCHABLE_DUE_TO_NOT_ENOUGH_DATA(1),
    WATCHING_ALLOWED(2),
    LICENSE_EXPIRED(3),
    PLAY_WINDOW_EXPIRED_BUT_RENEWABLE(5),
    PLAY_WINDOW_EXPIRED_FINAL(6),
    VIEW_WINDOW_EXPIRED(7),
    GEO_BLOCKED(8);
    

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f2847;

    private WatchState(int i) {
        this.f2847 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m1585() {
        return this.f2847;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static WatchState m1584(int i) {
        WatchState[] values = values();
        for (WatchState watchState : values) {
            if (watchState.m1585() == i) {
                return watchState;
            }
        }
        return UNKNOWN;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m1586() {
        return m1585() != WATCHING_ALLOWED.m1585();
    }
}
