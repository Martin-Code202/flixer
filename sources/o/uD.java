package o;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.BillboardInteractionType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.lomo.BillboardView;
import com.netflix.mediaclient.ui.lomo.LoMoUtils;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.model.leafs.originals.BillboardCTA;
import com.netflix.model.leafs.originals.BillboardLogo;
import com.netflix.model.leafs.originals.BillboardPhase;
import com.netflix.model.leafs.originals.BillboardSummary;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class uD extends BillboardView {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private C0522 f10689;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private ImageView f10690;

    /* renamed from: ʾ  reason: contains not printable characters */
    private C0754 f10691;

    /* renamed from: ʿ  reason: contains not printable characters */
    private TextView f10692;

    /* renamed from: ˈ  reason: contains not printable characters */
    private AbstractC0227 f10693;

    /* renamed from: ˉ  reason: contains not printable characters */
    private List<BillboardCTA> f10694;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private Disposable f10695;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private C0522 f10696;

    /* renamed from: o.uD$ˋ  reason: contains not printable characters */
    public interface AbstractC0227 {
        /* renamed from: ˋ  reason: contains not printable characters */
        void mo11355(uD uDVar, String str, String str2, boolean z, int i, int i2);
    }

    public uD(Context context) {
        super(context);
    }

    public uD(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public uD(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ˋ */
    public int mo2117() {
        return R.layout.billboard_view_phone;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ˊ */
    public void mo2115() {
        this.f3265 = (TextView) findViewById(R.id.billboard_supplemental_message);
        this.f3260 = (Button) findViewById(R.id.billboard_cta1_portrait_button);
        this.f10691 = (C0754) findViewById(R.id.billboard_portrait_add_to_queue);
        this.f10690 = (ImageView) findViewById(R.id.billboard_portrait_view_info);
        this.f3275 = (TextView) findViewById(R.id.billboard_episode_badge);
        this.f10696 = (C0522) findViewById(R.id.billboard_portrait_tv_card);
        this.f10692 = (TextView) findViewById(R.id.billboard_fallback_tv_card_title);
        this.f10689 = (C0522) findViewById(R.id.licensed_billboard);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ॱ */
    public void mo2129() {
        setOnClickListener(this.f3251);
        this.f10696.setVisibility(0);
        this.f10696.setForeground(null);
        this.f10690.setVisibility(0);
        this.f10690.setOnClickListener(this.f3251);
    }

    public void setBillboardListener(AbstractC0227 r1) {
        this.f10693 = r1;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ˏ */
    public void mo2125() {
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ˎ */
    public void mo2121() {
        ViewUtils.m3020((View) this.f3265, false);
        ViewUtils.m3002((View) this.f3260, false);
        ViewUtils.m3002((View) this.f10691, false);
        ViewUtils.m3002((View) this.f10690, false);
        ViewUtils.m3002((View) this.f10696, false);
        m11354();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11337(AbstractC2077pz pzVar) {
        BillboardSummary billboardSummary = pzVar.getBillboardSummary();
        if (billboardSummary.getBackgroundPortrait() != null) {
            int intValue = billboardSummary.getBackgroundPortrait().getHeight().intValue();
            int intValue2 = billboardSummary.getBackgroundPortrait().getWidth().intValue();
            if (this.f10693 != null) {
                this.f10693.mo11355(this, mo2124(pzVar), pzVar.getTitle(), billboardSummary.isOriginal(), intValue, intValue2);
            }
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m11350() {
        C1004.m15953(this.f3260, 0, 100, 100, 0);
        C1004.m15953(this.f10690, 0, 100, 100, 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11341(BillboardSummary billboardSummary, String str) {
        if (!billboardSummary.isOriginal()) {
            ViewUtils.m3002((View) this.f10696, false);
            ViewUtils.m3002((View) this.f10692, false);
        } else if (billboardSummary.getLogo() != null) {
            BillboardLogo logo = billboardSummary.getLogo();
            String url = logo.getUrl();
            m11347(logo.getHeight().intValue(), logo.getWidth().intValue());
            ViewUtils.m3002((View) this.f10696, true);
            ViewUtils.m3002((View) this.f10692, false);
            NetflixActivity.getImageLoader(getContext()).mo3063(this.f10696, url, AssetType.boxArt, str, StaticImgConfig.DARK_NO_PLACEHOLDER, true, 1);
        } else {
            String title = billboardSummary.getTitle();
            ViewUtils.m3002((View) this.f10696, false);
            ViewUtils.m3002((View) this.f10692, true);
            if (this.f10692 != null) {
                this.f10692.setText(title);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m11349(AbstractC2077pz pzVar) {
        BillboardSummary billboardSummary = pzVar.getBillboardSummary();
        if (billboardSummary.getPhase() == null || billboardSummary.getAvailabilityDates() == null || !pzVar.isPreRelease()) {
            return false;
        }
        return Long.valueOf(billboardSummary.getAvailabilityDates().start().longValue() - Long.valueOf(System.currentTimeMillis()).longValue()).longValue() < 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m11342(AbstractC2077pz pzVar) {
        BillboardSummary billboardSummary = pzVar.getBillboardSummary();
        if (billboardSummary.getPhase() == null || billboardSummary.getAvailabilityDates() == null) {
            return "";
        }
        return billboardSummary.getPhase().supplementalMessage();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private List<BillboardCTA> m11340(AbstractC2077pz pzVar) {
        BillboardSummary billboardSummary = pzVar.getBillboardSummary();
        if (billboardSummary.getPhase() == null || billboardSummary.getAvailabilityDates() == null) {
            return this.f10694;
        }
        return billboardSummary.getPhase().actions();
    }

    @Override // com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ˋ */
    public void mo2123(AbstractC2077pz pzVar, AbstractC2087qh qhVar, int i, boolean z, boolean z2) {
        BillboardSummary billboardSummary;
        this.f3278 = pzVar;
        C2059ph serviceManager = ((NetflixActivity) getContext()).getServiceManager();
        if (pzVar == null || (billboardSummary = pzVar.getBillboardSummary()) == null) {
            C1283.m16854("BillboardPhoneView", "Billboard Data missing summary when trying to render billboard");
            mo2121();
            return;
        }
        this.f3252 = new qN(qhVar, i);
        setVisibility(0);
        String format = String.format(getResources().getString(R.string.accesibility_play_video), pzVar.getTitle());
        setContentDescription(format);
        m2122(billboardSummary);
        this.f3284 = billboardSummary.getActionToken();
        this.f3282 = billboardSummary.getImpressionToken();
        if (m11349(pzVar)) {
            this.f3280 = m11342(pzVar);
        } else {
            this.f3280 = billboardSummary.getSupplementalMessage();
        }
        if (pzVar.isPreRelease()) {
            m11335(pzVar);
        }
        boolean r7 = m11352(billboardSummary);
        m11338(!r7);
        if (r7) {
            m11348(billboardSummary);
        }
        m11341(billboardSummary, format);
        m11344(billboardSummary, format);
        m11350();
        m11337(pzVar);
        m11351(pzVar);
        m2118(BillboardInteractionType.IMPRESSION);
        if (serviceManager.mo9519()) {
            C1283.m16846("BillboardPhoneView", "Loggin billboard impression for video: " + pzVar.getId());
            serviceManager.m9764().mo9466(pzVar, BillboardInteractionType.IMPRESSION, this.f3286);
        }
        mo2125();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m11352(BillboardSummary billboardSummary) {
        return billboardSummary.getBadgeKeys() != null && billboardSummary.getBadgeKeys().size() > 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11348(BillboardSummary billboardSummary) {
        LoMoUtils.m2146(billboardSummary.getBadgeKeys(), this.f3275);
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.billboard_constraint_layout);
        constraintSet.clone(constraintLayout);
        int r8 = C1004.m15954(getContext(), 20);
        if (!billboardSummary.isOriginal()) {
            constraintSet.connect(this.f10689.getId(), 4, this.f3275.getId(), 3, r8);
        } else if (billboardSummary.getLogo() != null) {
            constraintSet.connect(this.f10696.getId(), 4, this.f3275.getId(), 3, r8);
        } else {
            constraintSet.connect(this.f10692.getId(), 4, this.f3275.getId(), 3, r8);
        }
        constraintSet.applyTo(constraintLayout);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11338(boolean z) {
        if (C1349Bv.m4113(this.f3280) || !z) {
            this.f3265.setVisibility(8);
            return;
        }
        this.f3265.setText(this.f3280);
        this.f3265.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11343(BillboardPhase billboardPhase, boolean z) {
        this.f3280 = billboardPhase.supplementalMessage();
        m11338(z);
        this.f10694 = billboardPhase.actions();
        m11346(0);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m11335(AbstractC2077pz pzVar) {
        BillboardSummary billboardSummary = pzVar.getBillboardSummary();
        if (billboardSummary.getPhase() != null && billboardSummary.getAvailabilityDates() != null) {
            final BillboardPhase phase = billboardSummary.getPhase();
            Long valueOf = Long.valueOf(billboardSummary.getAvailabilityDates().start().longValue() - Long.valueOf(System.currentTimeMillis()).longValue());
            final boolean r10 = m11352(billboardSummary);
            if (valueOf.longValue() > 0 && this.f10695 == null) {
                C1283.m16854("BillboardPhoneView", " adding the delayed handlers for Pre Release content");
                this.f10695 = Completable.timer(valueOf.longValue(), TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: o.uD.3
                    @Override // io.reactivex.functions.Action
                    public void run() {
                        uD.this.m11343(phase, r10);
                    }
                });
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11346(int i) {
        if (this.f10694 == null) {
            return;
        }
        if (this.f10694.size() >= 1) {
            m2126(this.f10694.get(i), this.f3260);
        } else {
            this.f3260.setVisibility(8);
        }
    }

    @Override // com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ʽ */
    public void mo2114() {
        m11354();
        this.f10696.mo14543();
        this.f10689.mo14543();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m11354() {
        if (this.f10695 != null && !this.f10695.isDisposed()) {
            this.f10695.dispose();
            this.f10695 = null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11344(BillboardSummary billboardSummary, String str) {
        if (billboardSummary.isOriginal()) {
            ViewUtils.m3002((View) this.f10689, false);
            return;
        }
        ViewUtils.m3002((View) this.f10689, true);
        if (billboardSummary.getBackgroundPortrait() != null) {
            String url = billboardSummary.getBackgroundPortrait().getUrl();
            m11336(this.f10689, billboardSummary.getBackgroundPortrait().getHeight().intValue(), billboardSummary.getBackgroundPortrait().getWidth().intValue());
            NetflixActivity.getImageLoader(getContext()).mo3063(this.f10689, url, AssetType.merchStill, str, StaticImgConfig.DARK, true, 1);
        }
    }

    @Override // com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ˏ */
    public String mo2124(AbstractC2077pz pzVar) {
        String str = "";
        BillboardSummary billboardSummary = pzVar.getBillboardSummary();
        if (!(billboardSummary == null || billboardSummary.getBackgroundPortrait() == null)) {
            str = billboardSummary.getBackgroundPortrait().getUrl();
        }
        if (billboardSummary == null || billboardSummary.getLogo() == null || billboardSummary.getBackground() == null || billboardSummary.getBackgroundPortrait() == null) {
            C1283.m16850("BillboardPhoneView", "Data missing when trying to render billboard image");
        } else {
            C1283.m16846("BillboardPhoneView", String.format("Showing artwork only, image url: %s", str));
        }
        return str;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m11351(AbstractC2077pz pzVar) {
        if (!((NetflixActivity) getContext()).getServiceManager().mo9519()) {
            C1283.m16865("BillboardPhoneView", "Manager is null/notReady - can't reload data");
            return;
        }
        if (pzVar == null || pzVar.getBillboardSummary() == null || pzVar.getBillboardSummary().getActions() == null) {
            this.f10694 = new ArrayList();
        } else if (m11349(pzVar)) {
            this.f10694 = m11340(pzVar);
        } else {
            this.f10694 = pzVar.getBillboardSummary().getActions();
        }
        m11346(0);
        m11353(pzVar.getId(), pzVar.getType());
        m2131();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11353(String str, VideoType videoType) {
        this.f10691.setVisibility(0);
        C2059ph serviceManager = ((NetflixActivity) getContext()).getServiceManager();
        if (this.f3277 != null) {
            serviceManager.m9781(str, this.f3277);
            this.f3277 = null;
        }
        if (this.f10691 != null) {
            this.f3277 = serviceManager.m9792((NetflixActivity) getContext(), this.f10691, str, videoType, m2113(), false);
            serviceManager.m9802(str, this.f3277);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int[] m11339(int i, int i2) {
        int min = Math.min((AD.m3317(getContext()) * 3) / 5, (int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f));
        return new int[]{min, (min * i) / i2};
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11336(View view, int i, int i2) {
        int[] r1 = m11339(i, i2);
        int i3 = r1[1];
        int i4 = r1[0];
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11347(int i, int i2) {
        m11336(this.f10696, i, i2);
    }
}
