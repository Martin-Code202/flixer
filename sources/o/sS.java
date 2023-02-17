package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.model.leafs.social.NotificationTrackingInfo;
import com.netflix.model.leafs.social.multititle.NotificationHeroTitleAction;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
public final class sS extends RelativeLayout {

    /* renamed from: ˊ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f10108 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(sS.class), "playButton", "getPlayButton()Lcom/netflix/mediaclient/android/widget/NetflixTextButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(sS.class), "addToMyListButton", "getAddToMyListButton()Lcom/netflix/mediaclient/android/widget/IconFontTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(sS.class), "downloadButton", "getDownloadButton()Lcom/netflix/mediaclient/ui/offline/DownloadButton;"))};

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0192 f10109 = new C0192(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final FI f10110 = C1197.m16465(this, (int) R.id.add_to_my_list);

    /* renamed from: ˏ  reason: contains not printable characters */
    private final FI f10111 = C1197.m16465(this, (int) R.id.download_button);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final FI f10112 = C1197.m16465(this, (int) R.id.multi_title_play);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AddToListData.Cif f10113;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0754 m10667() {
        return (C0754) this.f10112.mo4986(this, f10108[0]);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final DownloadButton m10670() {
        return (DownloadButton) this.f10111.mo4986(this, f10108[2]);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0628 m10674() {
        return (C0628) this.f10110.mo4986(this, f10108[1]);
    }

    /* renamed from: o.sS$ˊ  reason: contains not printable characters */
    public static final class C0192 {
        private C0192() {
        }

        public /* synthetic */ C0192(C1456Fq fq) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sS(Context context) {
        super(context);
        C1457Fr.m5025(context, "context");
        LayoutInflater.from(getContext()).inflate(m10675(), (ViewGroup) this, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sS(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(attributeSet, "attrs");
        LayoutInflater.from(getContext()).inflate(m10675(), (ViewGroup) this, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sS(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(attributeSet, "attrs");
        LayoutInflater.from(getContext()).inflate(m10675(), (ViewGroup) this, true);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final int m10675() {
        return R.layout.multi_title_hero_buttons_layout;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m10671(String str) {
        NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(getContext(), NetflixActivity.class);
        if (netflixActivity != null) {
            sQ.f10093.m10657(netflixActivity, m10667(), str);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m10672(String str, VideoType videoType) {
        C2059ph r2 = m10673();
        NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(getContext(), NetflixActivity.class);
        if (r2 != null && netflixActivity != null) {
            m10669(netflixActivity, r2, str, videoType);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m10669(NetflixActivity netflixActivity, C2059ph phVar, String str, VideoType videoType) {
        if (!phVar.m9822()) {
            ViewUtils.m3002((View) m10674(), false);
            return;
        }
        this.f10113 = phVar.m9798(netflixActivity, m10674(), str, videoType, 0);
        phVar.m9802(str, this.f10113);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C2059ph m10673() {
        Context context = getContext();
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.android.activity.NetflixActivity");
        }
        C2059ph serviceManager = ((NetflixActivity) context).getServiceManager();
        C1457Fr.m5016((Object) serviceManager, "manager");
        if (serviceManager.mo9519()) {
            return serviceManager;
        }
        C1283.m16865("MultiTitleHeroButtonsViewGroup", "Manager is null/notReady - can't reload data");
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m10666(pT pTVar) {
        NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(getContext(), NetflixActivity.class);
        if (netflixActivity != null) {
            m10670().setStateFromPlayable(pTVar.getPlayable(), netflixActivity);
        }
        if (!C1457Fr.m5018(m10670().m2163(), DownloadButton.ButtonState.NOT_AVAILABLE)) {
            m10665();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private final void m10665() {
        ViewUtils.m3002((View) m10670(), true);
    }

    /* access modifiers changed from: package-private */
    public static final class iF implements View.OnTouchListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ AbstractC1100 f10114;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ AbstractC0574 f10115;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ boolean f10116;

        iF(AbstractC0574 r1, AbstractC1100 r2, boolean z) {
            this.f10115 = r1;
            this.f10114 = r2;
            this.f10116 = z;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            C1457Fr.m5016((Object) motionEvent, "motionEvent");
            if (motionEvent.getAction() != 0) {
                return false;
            }
            C1300Ac.m3531(new C1080(AppView.notificationLandingItem, this.f10115), this.f10114, this.f10116);
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m10668(View view, AbstractC0574 r3, AbstractC1100 r4, boolean z) {
        view.setOnTouchListener(new iF(r3, r4, z));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m10676(Boolean bool) {
        AddToListData.Cif ifVar;
        if (bool != null && bool.booleanValue() && (ifVar = this.f10113) != null) {
            ifVar.mo1480(AddToListData.AddToListState.IN_LIST);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m10677(NotificationHeroTitleAction notificationHeroTitleAction, pT pTVar) {
        C1457Fr.m5025(notificationHeroTitleAction, "action");
        C1457Fr.m5025(pTVar, "videoDetails");
        String action = notificationHeroTitleAction.getAction();
        NotificationTrackingInfo trackingInfo = notificationHeroTitleAction.getTrackingInfo();
        C1457Fr.m5016((Object) trackingInfo, "action.trackingInfo");
        String titleId = trackingInfo.getTitleId();
        String actionType = notificationHeroTitleAction.getActionType();
        C1457Fr.m5016((Object) actionType, "action.actionType");
        if (actionType == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = actionType.toLowerCase();
        C1457Fr.m5016((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case 96417:
                if (lowerCase.equals("add")) {
                    C1457Fr.m5016((Object) titleId, "titleId");
                    VideoType videoType = notificationHeroTitleAction.getVideoType();
                    C1457Fr.m5016((Object) videoType, "action.videoType");
                    m10672(titleId, videoType);
                    NotificationTrackingInfo trackingInfo2 = notificationHeroTitleAction.getTrackingInfo();
                    C1457Fr.m5016((Object) trackingInfo2, "action.trackingInfo");
                    m10668((View) m10674(), (AbstractC0574) trackingInfo2, (AbstractC1100) new C1039(), false);
                    return;
                }
                return;
            case 112903375:
                if (lowerCase.equals("watch")) {
                    C1457Fr.m5016((Object) action, "url");
                    m10671(action);
                    NotificationTrackingInfo trackingInfo3 = notificationHeroTitleAction.getTrackingInfo();
                    C1457Fr.m5016((Object) trackingInfo3, "action.trackingInfo");
                    m10668((View) m10667(), (AbstractC0574) trackingInfo3, (AbstractC1100) new C1244(), true);
                    return;
                }
                return;
            case 1427818632:
                if (lowerCase.equals("download")) {
                    m10666(pTVar);
                    NotificationTrackingInfo trackingInfo4 = notificationHeroTitleAction.getTrackingInfo();
                    C1457Fr.m5016((Object) trackingInfo4, "action.trackingInfo");
                    m10668((View) m10670(), (AbstractC0574) trackingInfo4, (AbstractC1100) new C0344(), false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m10678(String str, Integer num) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0) && num != null && num.intValue() != 0) {
            m10667().setText(getContext().getString(R.string.label_season_and_episode_abbreviated, str, num));
        }
    }
}
