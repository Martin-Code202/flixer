package o;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.NotificationUtils;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import com.netflix.model.leafs.social.IrisNotificationsListSummary;
/* renamed from: o.tb  reason: case insensitive filesystem */
public abstract class AbstractC2171tb {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String f10472;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String f10473 = AbstractC2171tb.class.getSimpleName();

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract void mo11059(NotificationCompat.Builder builder, NotificationCompat.BigPictureStyle bigPictureStyle, IrisNotificationSummary irisNotificationSummary, Context context);

    /* renamed from: ˊ */
    public TextView mo11057(sB sBVar) {
        return null;
    }

    /* renamed from: ˏ */
    public View mo11061(sB sBVar) {
        return sBVar.m10514();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final sB m11064(View view, IrisNotificationSummary.NotificationTypes notificationTypes) {
        return new sB(null, (C0522) view.findViewById(R.id.video_art_img), (C0793) view.findViewById(R.id.stack_layout), (TextView) view.findViewById(R.id.timestamp_text), (TextView) view.findViewById(R.id.top_text), (TextView) view.findViewById(R.id.middle_text), null, null, null, null, null, (C0522) view.findViewById(R.id.nsa_video_art_img), view.findViewById(R.id.sliding_menu_notification_indicator));
    }

    /* renamed from: ˎ */
    public void mo11060(sB sBVar, IrisNotificationSummary irisNotificationSummary, Context context) {
        if (sBVar.m10508() != null) {
            sBVar.m10508().setVisibility(irisNotificationSummary.getWasRead() ? 4 : 0);
        }
        if (!(sBVar.m10511() == null || irisNotificationSummary.getFriendProfile() == null)) {
            sBVar.m10511().setVisibility(0);
            NetflixActivity.getImageLoader(context).mo3057(sBVar.m10511(), irisNotificationSummary.getFriendProfile().getBigImageUrl(), AssetType.profileAvatar, irisNotificationSummary.getFriendProfile().getFullName(), StaticImgConfig.DARK, true);
        }
        sBVar.m10512().setVisibility(8);
        sBVar.m10514().setVisibility(0);
        NetflixActivity.getImageLoader(context).mo3057(sBVar.m10514(), irisNotificationSummary.getTVCardUrl(), AssetType.boxArt, irisNotificationSummary.getVideoTitle(), StaticImgConfig.DARK, true);
        sBVar.m10504().setVisibility(0);
        if (irisNotificationSummary.getFriendProfile() != null) {
            sBVar.m10504().setText(irisNotificationSummary.getFriendProfile().getFullName());
        }
        sBVar.m10506().setGravity(8388611);
        if (sBVar.m10517() != null) {
            if (irisNotificationSummary.getMessageString() == null || irisNotificationSummary.getMessageString().length() == 0) {
                sBVar.m10517().setVisibility(8);
            } else {
                sBVar.m10517().setVisibility(0);
                sBVar.m10517().setText(String.format("\"%s\"", irisNotificationSummary.getMessageString()));
            }
        }
        if (sBVar.m10516() != null) {
            sBVar.m10516().setVisibility(0);
            sBVar.m10516().setText(DateUtils.getRelativeTimeSpanString(context, irisNotificationSummary.getTimestamp()));
        }
        if (sBVar.m10505() != null) {
            sBVar.m10505().setVisibility(8);
        }
        if (sBVar.m10510() != null) {
            sBVar.m10510().setVisibility(0);
        }
        if (sBVar.m10513() != null) {
            sBVar.m10513().setVisibility(8);
        }
        if (sBVar.m10515() != null) {
            sBVar.m10515().setVisibility(8);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m11062(sB sBVar, int i) {
        sBVar.m10514().setVisibility(8);
        sBVar.m10504().setVisibility(8);
        if (sBVar.m10511() != null) {
            sBVar.m10511().setVisibility(8);
        }
        if (sBVar.m10517() != null) {
            sBVar.m10517().setVisibility(8);
        }
        if (sBVar.m10516() != null) {
            sBVar.m10516().setVisibility(8);
        }
        if (sBVar.m10513() != null) {
            sBVar.m10513().setVisibility(8);
        }
        if (sBVar.m10515() != null) {
            sBVar.m10515().setVisibility(8);
        }
        if (sBVar.m10505() != null) {
            sBVar.m10505().setVisibility(8);
        }
        if (sBVar.m10510() != null) {
            sBVar.m10510().setVisibility(8);
        }
        sBVar.m10512().setVisibility(8);
        sBVar.m10506().setText(i);
        sBVar.m10506().setSingleLine(false);
        sBVar.m10506().setGravity(17);
    }

    /* renamed from: ˊ */
    public boolean mo11058() {
        return true;
    }

    /* renamed from: o.tb$ˋ  reason: contains not printable characters */
    class C0221 implements AbstractC0957 {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ IrisNotificationsListSummary f10480;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ Context f10481;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ IrisNotificationSummary f10482;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C1999nc f10484;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final Bitmap f10485;

        /* JADX WARN: Incorrect args count in method signature: (Landroid/graphics/Bitmap;)V */
        public C0221(Bitmap bitmap, Context context, C1999nc ncVar, IrisNotificationSummary irisNotificationSummary, IrisNotificationsListSummary irisNotificationsListSummary) {
            this.f10481 = context;
            this.f10484 = ncVar;
            this.f10482 = irisNotificationSummary;
            this.f10480 = irisNotificationsListSummary;
            this.f10485 = bitmap;
        }

        @Override // o.AbstractC0957
        public void onResponse(Bitmap bitmap, String str) {
            NotificationCompat.Builder builder;
            if (bitmap != null) {
                int color = this.f10481.getResources().getColor(R.color.brand_red);
                NotificationCompat.BigPictureStyle bigPicture = new NotificationCompat.BigPictureStyle().bigPicture(bitmap);
                NotificationManager notificationManager = (NotificationManager) this.f10481.getSystemService("notification");
                String r10 = NotificationUtils.m2992(notificationManager, this.f10481, this.f10484.m9280());
                if (r10 != null) {
                    builder = new NotificationCompat.Builder(this.f10481, r10);
                } else {
                    builder = new NotificationCompat.Builder(this.f10481);
                }
                builder.setSmallIcon(R.drawable.ic_sb_netflix_n).setLargeIcon(this.f10485).setContentTitle(this.f10482.getFriendProfile().getFullName()).setStyle(bigPicture).setColor(color);
                builder.setGroup("iris_notifications");
                builder.setGroupSummary(true);
                builder.setAutoCancel(true);
                AbstractC2171tb.this.mo11059(builder, bigPicture, this.f10482, this.f10481);
                AbstractC2171tb.this.m11065(builder, this.f10482, this.f10480, this.f10484, this.f10481);
                Intent intent = new Intent("com.netflix.mediaclient.intent.action.NOTIFICATION_CANCELED");
                C1999nc.m9277(intent, this.f10484);
                intent.putExtra("swiped_notification_id", this.f10482.getId());
                builder.setDeleteIntent(PendingIntent.getBroadcast(this.f10481.getApplicationContext(), 0, intent, 268435456));
                notificationManager.cancel(1000);
                notificationManager.notify(1000, builder.build());
                String unused = AbstractC2171tb.f10472 = this.f10482.getId();
            }
        }

        @Override // o.AbstractC0957
        public void onErrorResponse(String str) {
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m11066(final IrisNotificationSummary irisNotificationSummary, final IrisNotificationsListSummary irisNotificationsListSummary, final ImageLoader imageLoader, final C1999nc ncVar, final Context context) {
        AnonymousClass1 r0 = new AbstractC0957() { // from class: o.tb.1
            @Override // o.AbstractC0957
            public void onResponse(Bitmap bitmap, String str) {
                if (bitmap != null) {
                    imageLoader.mo3059(irisNotificationSummary.getTVCardUrl(), AssetType.boxArt, 0, 0, new C0221(bitmap, context, ncVar, irisNotificationSummary, irisNotificationsListSummary));
                }
            }

            @Override // o.AbstractC0957
            public void onErrorResponse(String str) {
            }
        };
        String id = irisNotificationSummary.getId();
        if (f10472 != null && f10472.equals(id)) {
            C1283.m16862(f10473, "Notification with such id was already shown - skipping...");
        } else if (id.equals(C1339Bl.m4045(context, "notification_id_deleted_from_statusbar", "-1"))) {
            C1283.m16862(f10473, "Notification with such id was swiped out by user - skipping...");
        } else {
            String imageUrl = irisNotificationSummary.getFriendProfile().getImageUrl();
            if (C1349Bv.m4113(imageUrl)) {
                imageUrl = irisNotificationSummary.getFriendProfile().getBigImageUrl();
            }
            imageLoader.mo3059(imageUrl, AssetType.profileAvatar, 0, 0, r0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11065(NotificationCompat.Builder builder, IrisNotificationSummary irisNotificationSummary, IrisNotificationsListSummary irisNotificationsListSummary, C1999nc ncVar, Context context) {
        Intent r3 = sC.m10518(ncVar);
        NotificationUtils.m2986(r3);
        builder.setContentIntent(PendingIntent.getBroadcast(context.getApplicationContext(), 3, r3, 134217728));
    }
}
