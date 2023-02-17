package com.netflix.mediaclient.ui.player;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import io.reactivex.subjects.PublishSubject;
import o.AbstractC0496;
import o.AbstractC1978mi;
import o.C2059ph;
import o.C2275wq;
import o.C2279wu;
import o.oX;
import o.pF;
import o.pT;
import o.qO;
import o.wG;
import o.xJ;
public interface IPlayerFragment {
    AbstractC0496.iF ab_();

    Bundle getArguments();

    /* renamed from: ʻ  reason: contains not printable characters */
    VideoType mo2225();

    /* renamed from: ʻॱ  reason: contains not printable characters */
    C2275wq mo2226();

    /* renamed from: ʼ  reason: contains not printable characters */
    oX m2227();

    /* renamed from: ʼॱ  reason: contains not printable characters */
    void mo2228();

    /* renamed from: ʽ  reason: contains not printable characters */
    void mo2229();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    qO.Cif mo2230();

    /* renamed from: ʾ  reason: contains not printable characters */
    boolean mo2231();

    /* renamed from: ʿ  reason: contains not printable characters */
    void mo2232();

    /* renamed from: ˈ  reason: contains not printable characters */
    void mo2233();

    /* renamed from: ˉ  reason: contains not printable characters */
    wG mo2234();

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo2235(Runnable runnable);

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo2236(boolean z);

    /* renamed from: ˊ  reason: contains not printable characters */
    boolean mo2237(PlaybackLauncher.PlayLaunchedBy... playLaunchedByArr);

    /* renamed from: ˊˊ  reason: contains not printable characters */
    Handler mo2238();

    /* renamed from: ˊˋ  reason: contains not printable characters */
    C2279wu mo2239();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    void mo2240();

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    boolean mo2241();

    /* renamed from: ˋ  reason: contains not printable characters */
    NetflixActivity m2242();

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo2243(C2279wu wuVar);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo2244(boolean z, PlayVerifierVault playVerifierVault);

    /* renamed from: ˋˊ  reason: contains not printable characters */
    AbstractC1978mi mo2245();

    /* renamed from: ˋˋ  reason: contains not printable characters */
    View mo2246();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    void mo2247();

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    void mo2248();

    /* renamed from: ˌ  reason: contains not printable characters */
    void mo2249();

    /* renamed from: ˎ  reason: contains not printable characters */
    boolean m2250();

    @Deprecated
    /* renamed from: ˎˎ  reason: contains not printable characters */
    PublishSubject<xJ> mo2251();

    /* renamed from: ˏ  reason: contains not printable characters */
    String mo2252(int i, String str);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo2253(pF pFVar, VideoType videoType, oX oXVar, int i);

    /* renamed from: ˏ  reason: contains not printable characters */
    boolean mo2254(int i, KeyEvent keyEvent);

    /* renamed from: ˏॱ  reason: contains not printable characters */
    boolean mo2255();

    /* renamed from: ͺ  reason: contains not printable characters */
    void mo2256();

    /* renamed from: ॱ  reason: contains not printable characters */
    C2059ph m2257();

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo2258(int i);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo2259(String str, VideoType videoType, oX oXVar);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo2260(String str, VideoType videoType, oX oXVar, int i);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo2261(pF pFVar, VideoType videoType, oX oXVar, boolean z, boolean z2, int i, boolean z3);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo2262(pT pTVar, Status status, IPlayer.PlaybackType playbackType);

    /* renamed from: ॱ  reason: contains not printable characters */
    boolean mo2263(int i, KeyEvent keyEvent);

    /* renamed from: ॱˊ  reason: contains not printable characters */
    void mo2264();

    /* renamed from: ॱˋ  reason: contains not printable characters */
    boolean mo2265();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    void mo2266();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    String mo2267();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    pF mo2268();

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    Context mo2269();

    @Deprecated
    public enum PublisherEvents {
        ON_PAUSE("ON_PAUSE"),
        ON_RESUME("ON_RESUME"),
        ON_DESTROY("ON_DESTROY"),
        ON_PLAYER_BUFFERING("ON_PLAYER_BUFFERING"),
        ON_PLAYER_STARTED("ON_PLAYER_STARTED"),
        ON_PLAYER_PAUSED("ON_PLAYER_PAUSED"),
        ON_PLAYER_STOPPED("ON_PLAYER_STOPPED"),
        ON_PLAYER_LOADING_NEXT("ON_PLAYER_LOADING_NEXT"),
        ON_HIDE_PLAYER_CONTROLS("ON_HIDE_PLAYER_CONTROLS"),
        ON_SHOW_PLAYER_CONTROLS("ON_SHOW_PLAYER_CONTROLS"),
        ON_SHOW_POST_PLAY_MARK("ON_SHOW_POST_PLAY_MARK"),
        INTENT_ON_PLAYER_TOUCH_FLING_DOWN("INTENT_ON_PLAYER_TOUCH_FLING_DOWN"),
        INTENT_ON_PLAYER_TOUCH_FLING_UP("INTENT_ON_PLAYER_TOUCH_FLING_UP"),
        INTENT_CLICK_TO_SHOW_PIVOTS("INTENT_CLICK_TO_SHOW_PIVOTS"),
        INTENT_ON_PLAYER_SNAP_DOWN("INTENT_ON_PLAYER_SNAP_DOWN"),
        INTENT_ON_PLAYER_SNAP_UP("INTENT_ON_PLAYER_SNAP_UP");
        

        /* renamed from: ॱᐝ  reason: contains not printable characters */
        private final String f3400;

        private PublisherEvents(String str) {
            this.f3400 = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.f3400;
        }
    }
}
