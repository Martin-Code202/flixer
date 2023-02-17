package com.netflix.mediaclient.servicemgr;
public interface IMdxSharedState {

    public enum MdxPlaybackState {
        Stopped,
        Loading,
        Transitioning,
        Playing,
        Paused
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    String mo1521();

    /* renamed from: ˏ  reason: contains not printable characters */
    MdxPlaybackState mo1522();
}
