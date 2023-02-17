package o;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.social.multititle.NotificationGridTitleAction;
import kotlin.jvm.internal.PropertyReference1Impl;
public final class sL extends sW {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final NotificationGridTitleAction f10043;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f10044;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean f10045;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sL(int i, NotificationGridTitleAction notificationGridTitleAction, boolean z) {
        super(true);
        C1457Fr.m5025(notificationGridTitleAction, "action");
        this.f10044 = i;
        this.f10043 = notificationGridTitleAction;
        this.f10045 = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sL(int i, NotificationGridTitleAction notificationGridTitleAction, boolean z, int i2, C1456Fq fq) {
        this((i2 & 1) != 0 ? 3 : i, notificationGridTitleAction, z);
    }

    @Override // o.sW
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo10597() {
        return this.f10044;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final NotificationGridTitleAction m10596() {
        return this.f10043;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final boolean m10598() {
        return this.f10045;
    }

    /* renamed from: o.sL$ˋ  reason: contains not printable characters */
    public static final class C0188 extends RecyclerView.ViewHolder {

        /* renamed from: ॱ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f10046 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0188.class), "gridImage", "getGridImage()Lcom/netflix/mediaclient/android/widget/AdvancedImageView;"))};

        /* renamed from: ˊ  reason: contains not printable characters */
        private AbstractC0574 f10047;

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f10048;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final FI f10049 = C1197.m16471(this, (int) R.id.grid_image);

        /* renamed from: ˊ  reason: contains not printable characters */
        private final C0522 m10599() {
            return (C0522) this.f10049.mo4986(this, f10046[0]);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0188(final View view) {
            super(view);
            C1457Fr.m5025(view, "itemView");
            m10599().setOnClickListener(new View.OnClickListener(this) { // from class: o.sL.ˋ.2

                /* renamed from: ॱ  reason: contains not printable characters */
                final /* synthetic */ C0188 f10051;

                {
                    this.f10051 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f10051.m10601(this.f10051.f10047);
                    C0693.m14984((sR) C0345.m13893(view.getContext(), sR.class), new Intent("android.intent.action.VIEW", Uri.parse(this.f10051.f10048)));
                }
            });
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private final void m10601(AbstractC0574 r4) {
            C1300Ac.m3531(new C1080(AppView.notificationLandingItem, r4), new C0642(), true);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m10604(sL sLVar, String str, Integer num, float f, int i, int i2) {
            C1457Fr.m5025(sLVar, "title");
            C1457Fr.m5025(str, "boxart");
            View view = this.itemView;
            if (num != null) {
                int intValue = (int) (((((float) num.intValue()) - (((float) i2) * 2.0f)) - (((float) i) * 2.0f)) / 2.0f);
                m10599().getLayoutParams().width = intValue;
                m10599().getLayoutParams().height = (int) (((float) intValue) / f);
            }
            ImageLoader imageLoader = NetflixActivity.getImageLoader(view.getContext());
            if (imageLoader != null) {
                imageLoader.mo3063(m10599(), str, AssetType.boxArt, "", BrowseExperience.m1769(), true, 1);
            }
            this.f10048 = sLVar.m10596().getAction();
            this.f10047 = sLVar.m10596().getTrackingInfo();
        }
    }
}
