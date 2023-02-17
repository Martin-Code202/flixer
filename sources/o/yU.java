package o;

import com.netflix.mediaclient.servicemgr.IPlayer;
public final /* synthetic */ class yU {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final /* synthetic */ int[] f12461 = new int[IPlayer.PlayerState.values().length];

    static {
        f12461[IPlayer.PlayerState.Idle.ordinal()] = 1;
        f12461[IPlayer.PlayerState.Prepared.ordinal()] = 2;
        f12461[IPlayer.PlayerState.Started.ordinal()] = 3;
        f12461[IPlayer.PlayerState.Paused.ordinal()] = 4;
        f12461[IPlayer.PlayerState.Error.ordinal()] = 5;
        f12461[IPlayer.PlayerState.Completed.ordinal()] = 6;
    }
}
