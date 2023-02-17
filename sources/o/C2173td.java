package o;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.social.IrisNotificationSummary;
/* renamed from: o.td  reason: case insensitive filesystem */
public final class C2173td extends C2170ta {
    @Override // o.C2170ta, o.AbstractC2171tb
    /* renamed from: ˎ */
    public void mo11060(sB sBVar, IrisNotificationSummary irisNotificationSummary, Context context) {
        C1457Fr.m5025(sBVar, "holder");
        C1457Fr.m5025(irisNotificationSummary, "summary");
        C1457Fr.m5025(context, "context");
        super.mo11060(sBVar, irisNotificationSummary, context);
        C0522 r0 = sBVar.m10512();
        C1457Fr.m5016((Object) r0, "holder.nsaArtImage");
        r0.setVisibility(8);
        ConstraintLayout r02 = sBVar.m10509();
        C1457Fr.m5016((Object) r02, "holder.stackLayout");
        r02.setVisibility(0);
        ImageLoader imageLoader = NetflixActivity.getImageLoader(context);
        if (imageLoader != null) {
            imageLoader.mo3057(sBVar.m10507(), irisNotificationSummary.getTVCardUrl(), AssetType.boxArt, irisNotificationSummary.getImageAltText(), StaticImgConfig.DARK, true);
        }
    }
}
