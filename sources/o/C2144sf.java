package o;

import com.netflix.mediaclient.servicemgr.IPlayer;
/* renamed from: o.sf  reason: case insensitive filesystem */
public final /* synthetic */ class C2144sf {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final /* synthetic */ int[] f10138 = new int[IPlayer.PlayerState.values().length];

    static {
        f10138[IPlayer.PlayerState.Prepared.ordinal()] = 1;
        f10138[IPlayer.PlayerState.Idle.ordinal()] = 2;
        f10138[IPlayer.PlayerState.Completed.ordinal()] = 3;
        f10138[IPlayer.PlayerState.Started.ordinal()] = 4;
        f10138[IPlayer.PlayerState.Paused.ordinal()] = 5;
        f10138[IPlayer.PlayerState.Error.ordinal()] = 6;
    }
}
