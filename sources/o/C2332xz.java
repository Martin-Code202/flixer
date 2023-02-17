package o;

import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.ui.player.pivots.PivotsUIView;
/* renamed from: o.xz  reason: case insensitive filesystem */
public final /* synthetic */ class C2332xz {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final /* synthetic */ int[] f12322 = new int[Config_Ab9454_InPlayerPivots.Companion.RowType.values().length];

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final /* synthetic */ int[] f12323 = new int[PivotsUIView.PivotsListVisibility.values().length];

    static {
        f12322[Config_Ab9454_InPlayerPivots.Companion.RowType.CONTINUE_WATCHING.ordinal()] = 1;
        f12322[Config_Ab9454_InPlayerPivots.Companion.RowType.SIMILARS.ordinal()] = 2;
        f12323[PivotsUIView.PivotsListVisibility.SHOW.ordinal()] = 1;
        f12323[PivotsUIView.PivotsListVisibility.HIDE.ordinal()] = 2;
        f12323[PivotsUIView.PivotsListVisibility.SHOW_PARTIALLY.ordinal()] = 3;
    }
}
