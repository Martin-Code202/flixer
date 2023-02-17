package o;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.model.leafs.social.IrisNotificationSummary;
/* renamed from: o.ta  reason: case insensitive filesystem */
public class C2170ta extends AbstractC2171tb {
    @Override // o.AbstractC2171tb
    /* renamed from: ˏ  reason: contains not printable characters */
    public View mo11061(sB sBVar) {
        return sBVar.m10512();
    }

    @Override // o.AbstractC2171tb
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11060(sB sBVar, IrisNotificationSummary irisNotificationSummary, Context context) {
        if (C1349Bv.m4107(irisNotificationSummary.getHeaderText())) {
            sBVar.m10504().setVisibility(0);
            sBVar.m10504().setText(C1349Bv.m4102(irisNotificationSummary.getHeaderText()));
        }
        if (sBVar.m10511() != null) {
            sBVar.m10511().setVisibility(8);
        }
        if (sBVar.m10508() != null) {
            sBVar.m10508().setVisibility(irisNotificationSummary.getWasRead() ? 4 : 0);
        }
        sBVar.m10514().setVisibility(8);
        sBVar.m10509().setVisibility(8);
        sBVar.m10512().setVisibility(0);
        NetflixActivity.getImageLoader(context).mo3057(sBVar.m10512(), irisNotificationSummary.getTVCardUrl(), AssetType.boxArt, irisNotificationSummary.getImageAltText(), StaticImgConfig.DARK, true);
        if (sBVar.m10517() != null) {
            sBVar.m10517().setVisibility(8);
        }
        if (sBVar.m10516() != null && irisNotificationSummary.getShowTimestamp()) {
            sBVar.m10516().setVisibility(0);
            sBVar.m10516().setText(DateUtils.getRelativeTimeSpanString(context, irisNotificationSummary.getTimestamp()));
        }
        if (sBVar.m10510() != null) {
            sBVar.m10510().setVisibility(8);
        }
        if (sBVar.m10505() != null) {
            sBVar.m10505().setVisibility(0);
        }
        if (C1349Bv.m4107(irisNotificationSummary.getBodyText())) {
            sBVar.m10506().setGravity(8388611);
            sBVar.m10506().setText(C1349Bv.m4102(irisNotificationSummary.getBodyText()));
        }
        if (sBVar.m10515() != null) {
            sBVar.m10515().setVisibility(0);
        }
        if (sBVar.m10513() != null) {
            sBVar.m10513().setVisibility(4);
        }
    }

    @Override // o.AbstractC2171tb
    /* renamed from: ˊ  reason: contains not printable characters */
    public TextView mo11057(sB sBVar) {
        return sBVar.m10515();
    }

    @Override // o.AbstractC2171tb
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo11058() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2171tb
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo11059(NotificationCompat.Builder builder, NotificationCompat.BigPictureStyle bigPictureStyle, IrisNotificationSummary irisNotificationSummary, Context context) {
    }
}
