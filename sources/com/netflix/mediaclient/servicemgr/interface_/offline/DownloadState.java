package com.netflix.mediaclient.servicemgr.interface_.offline;
public enum DownloadState {
    Unknown(0),
    Creating(1),
    InProgress(2),
    Stopped(3),
    Complete(4),
    Deleted(5),
    DeleteComplete(6),
    CreateFailed(7);
    

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f2814;

    private DownloadState(int i) {
        this.f2814 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m1577() {
        return this.f2814;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static DownloadState m1576(int i) {
        DownloadState[] values = values();
        for (DownloadState downloadState : values) {
            if (downloadState.m1577() == i) {
                return downloadState;
            }
        }
        return Unknown;
    }
}
