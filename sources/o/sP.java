package o;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.social.NotificationTrackingInfo;
import com.netflix.model.leafs.social.multititle.NotificationHeroModule;
import com.netflix.model.leafs.social.multititle.NotificationHeroTitleAction;
import io.reactivex.subjects.AsyncSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
public final class sP extends sW {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static C2059ph f10072;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C0189 f10073 = new C0189(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f10074;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final NotificationHeroModule f10075;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f10076;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f10077;

    /* renamed from: ˎ  reason: contains not printable characters */
    private pT f10078;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AsyncSubject<sP> f10079;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Integer f10080;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f10081;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sP(int i, NotificationHeroModule notificationHeroModule, boolean z) {
        super(false, 1, null);
        C1457Fr.m5025(notificationHeroModule, "module");
        this.f10074 = i;
        this.f10075 = notificationHeroModule;
        this.f10081 = z;
        AsyncSubject<sP> create = AsyncSubject.create();
        C1457Fr.m5016((Object) create, "AsyncSubject.create()");
        this.f10079 = create;
        if (C1457Fr.m5018(this.f10075.getVideoType(), VideoType.SEASON) || C1457Fr.m5018(this.f10075.getVideoType(), VideoType.SHOW)) {
            this.f10081 = true;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sP(int i, NotificationHeroModule notificationHeroModule, boolean z, int i2, C1456Fq fq) {
        this((i2 & 1) != 0 ? 1 : i, notificationHeroModule, (i2 & 4) != 0 ? false : z);
    }

    @Override // o.sW
    /* renamed from: ˋ */
    public int mo10597() {
        return this.f10074;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final NotificationHeroModule m10640() {
        return this.f10075;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final boolean m10641() {
        return this.f10081;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final pT m10632() {
        return this.f10078;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m10639(pT pTVar) {
        this.f10078 = pTVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m10635(boolean z) {
        this.f10077 = z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final boolean m10636() {
        return this.f10077;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final AsyncSubject<sP> m10637() {
        return this.f10079;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m10634(String str) {
        this.f10076 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final String m10638() {
        return this.f10076;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final Integer m10630() {
        return this.f10080;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m10633(Integer num) {
        this.f10080 = num;
    }

    /* renamed from: o.sP$ˊ  reason: contains not printable characters */
    public static final class C0189 {
        private C0189() {
        }

        public /* synthetic */ C0189(C1456Fq fq) {
            this();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m10650(C2059ph phVar) {
            sP.f10072 = phVar;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final C2059ph m10651() {
            return sP.f10072;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public final void m10631() {
        List<NotificationHeroTitleAction> actions = this.f10075.getActions();
        C1457Fr.m5016((Object) actions, "module.actions");
        for (T t : actions) {
            C1457Fr.m5016((Object) t, "action");
            m10625(t, String.valueOf(this.f10075.getTitleId()));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m10625(NotificationHeroTitleAction notificationHeroTitleAction, String str) {
        NotificationTrackingInfo trackingInfo = notificationHeroTitleAction.getTrackingInfo();
        C1457Fr.m5016((Object) trackingInfo, "action.trackingInfo");
        String titleId = trackingInfo.getTitleId();
        VideoType videoType = notificationHeroTitleAction.getVideoType();
        if (videoType != null) {
            switch (sT.f10117[videoType.ordinal()]) {
                case 1:
                    C1457Fr.m5016((Object) titleId, "titleId");
                    m10623(titleId);
                    return;
                case 2:
                    C1457Fr.m5016((Object) titleId, "titleId");
                    m10626(titleId);
                    return;
                case 3:
                    m10627(str);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m10623(String str) {
        C2059ph r3 = m10629();
        if (r3 != null) {
            r3.m9764().mo9503(str, (String) null, new C0190(this, String.valueOf(System.nanoTime()), this));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m10626(String str) {
        C2059ph r3 = m10629();
        if (r3 != null) {
            r3.m9764().mo9484(str, null, new C0190(this, String.valueOf(System.nanoTime()), this));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m10627(String str) {
        C2059ph r3 = m10629();
        if (r3 != null) {
            r3.m9764().mo9513(str, (String) null, new C0190(this, String.valueOf(System.nanoTime()), this));
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final C2059ph m10629() {
        C2059ph r2 = f10073.m10651();
        if (r2 != null && r2.mo9519()) {
            return r2;
        }
        C1283.m16865("HeroTitle", "Manager is null/notReady - can't reload data");
        return null;
    }

    /* renamed from: o.sP$ˋ  reason: contains not printable characters */
    public final class C0190 extends oP {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ sP f10090;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final sP f10091;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f10092;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0190(sP sPVar, String str, sP sPVar2) {
            super(str);
            C1457Fr.m5025(str, "logtag");
            C1457Fr.m5025(sPVar2, "heroTitle");
            this.f10090 = sPVar;
            this.f10092 = str;
            this.f10091 = sPVar2;
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            C1457Fr.m5025(status, "res");
            super.onShowDetailsFetched(pRVar, status);
            if (pRVar != null) {
                this.f10090.m10639(pRVar);
                this.f10090.m10635(pRVar.isInQueue());
                if (this.f10090.m10641()) {
                    sP sPVar = this.f10090;
                    String currentEpisodeId = pRVar.getCurrentEpisodeId();
                    C1457Fr.m5016((Object) currentEpisodeId, "showDetails.currentEpisodeId");
                    sPVar.m10626(currentEpisodeId);
                    return;
                }
                this.f10090.m10637().onNext(this.f10091);
                this.f10090.m10637().onComplete();
            }
        }

        @Override // o.oP, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            C1457Fr.m5025(status, "res");
            super.onEpisodeDetailsFetched(pIVar, status);
            if (pIVar != null) {
                this.f10090.m10639(pIVar);
                if (this.f10090.m10641()) {
                    this.f10090.m10634(pIVar.getSeasonAbbrSeqLabel());
                    this.f10090.m10633(Integer.valueOf(pIVar.getEpisodeNumber()));
                }
                this.f10090.m10637().onNext(this.f10091);
                this.f10090.m10637().onComplete();
            }
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            C1457Fr.m5025(status, "res");
            super.onMovieDetailsFetched(pPVar, status);
            if (pPVar != null) {
                this.f10090.m10639(pPVar);
                this.f10090.m10635(pPVar.isInQueue());
                this.f10090.m10637().onNext(this.f10091);
                this.f10090.m10637().onComplete();
            }
        }
    }

    public static final class If extends RecyclerView.ViewHolder {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f10082 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(If.class), "heroImage", "getHeroImage()Lcom/netflix/mediaclient/android/widget/TopCropImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(If.class), "heroSynopsis", "getHeroSynopsis()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(If.class), "multiTitleHeroButtons", "getMultiTitleHeroButtons()Lcom/netflix/mediaclient/ui/iris/notifications/multititle/MultiTitleHeroButtonsViewGroup;"))};

        /* renamed from: ʽ  reason: contains not printable characters */
        private AbstractC0574 f10083;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final FI f10084 = C1197.m16471(this, (int) R.id.hero_synopsis);

        /* renamed from: ˎ  reason: contains not printable characters */
        private final FI f10085 = C1197.m16471(this, (int) R.id.hero_image);

        /* renamed from: ˏ  reason: contains not printable characters */
        private final FI f10086 = C1197.m16471(this, (int) R.id.multi_title_hero_buttons);

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f10087;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final sS m10644() {
            return (sS) this.f10086.mo4986(this, f10082[2]);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private final C1050 m10646() {
            return (C1050) this.f10085.mo4986(this, f10082[0]);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C0716 m10648() {
            return (C0716) this.f10084.mo4986(this, f10082[1]);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public If(final View view) {
            super(view);
            C1457Fr.m5025(view, "itemView");
            m10646().setOnClickListener(new View.OnClickListener(this) { // from class: o.sP.If.2

                /* renamed from: ˎ  reason: contains not printable characters */
                final /* synthetic */ If f10088;

                {
                    this.f10088 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f10088.m10643(this.f10088.f10083);
                    C0693.m14984((sR) C0345.m13893(view.getContext(), sR.class), new Intent("android.intent.action.VIEW", Uri.parse(this.f10088.f10087)));
                }
            });
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final void m10643(AbstractC0574 r4) {
            C1300Ac.m3531(new C1080(AppView.notificationLandingItem, r4), new C0642(), true);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m10649(sP sPVar, Integer num, float f) {
            T t;
            String str;
            C1457Fr.m5025(sPVar, "heroTitle");
            View view = this.itemView;
            NotificationHeroModule r10 = sPVar.m10640();
            if (num != null) {
                int intValue = (int) (((float) num.intValue()) / f);
                m10646().getLayoutParams().width = num.intValue();
                m10646().getLayoutParams().height = intValue;
            }
            ImageLoader imageLoader = NetflixActivity.getImageLoader(view.getContext());
            if (imageLoader != null) {
                imageLoader.mo3063(m10646(), r10.getHeroImage(), AssetType.boxArt, "", BrowseExperience.m1769(), true, 1);
            }
            m10648().setText(r10.getBodyCopy());
            m10644().m10678(sPVar.m10638(), sPVar.m10630());
            pT r13 = sPVar.m10632();
            if (r13 != null) {
                List<NotificationHeroTitleAction> actions = r10.getActions();
                C1457Fr.m5016((Object) actions, "module.actions");
                for (T t2 : actions) {
                    sS r0 = m10644();
                    C1457Fr.m5016((Object) t2, "action");
                    r0.m10677(t2, r13);
                }
            }
            m10644().m10676(Boolean.valueOf(sPVar.m10636()));
            List<NotificationHeroTitleAction> actions2 = r10.getActions();
            C1457Fr.m5016((Object) actions2, "module.actions");
            Iterator<T> it = actions2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t3 = next;
                C1457Fr.m5016((Object) t3, "it");
                String actionType = t3.getActionType();
                C1457Fr.m5016((Object) actionType, "it.actionType");
                if (actionType != null) {
                    String lowerCase = actionType.toLowerCase();
                    C1457Fr.m5016((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (C1457Fr.m5018((Object) lowerCase, (Object) "title")) {
                        t = next;
                        break;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            T t4 = t;
            this.f10083 = t4 != null ? t4.getTrackingInfo() : null;
            if (t4 == null || (str = t4.getAction()) == null) {
                str = "";
            }
            this.f10087 = str;
        }
    }
}
