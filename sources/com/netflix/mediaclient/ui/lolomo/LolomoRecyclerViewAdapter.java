package com.netflix.mediaclient.ui.lolomo;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.model.leafs.LoLoMoSummary;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import o.AD;
import o.AbstractC0459;
import o.AbstractC0835;
import o.AbstractC0837;
import o.AbstractC0954;
import o.AbstractC2195ty;
import o.AbstractC2214un;
import o.C1276;
import o.C1283;
import o.C1317As;
import o.C1348Bu;
import o.C2059ph;
import o.C2196tz;
import o.C2201ua;
import o.C2203uc;
import o.C2206uf;
import o.C2207ug;
import o.C2208uh;
import o.C2209ui;
import o.C2210uj;
import o.C2211uk;
import o.C2212ul;
import o.C2213um;
import o.C2215uo;
import o.C2217uq;
import o.oP;
import o.pC;
import o.pW;
import o.tF;
import o.tG;
import o.tN;
import o.tP;
import o.tR;
import o.uD;
import o.uH;
public class LolomoRecyclerViewAdapter extends AbstractC0835<AbstractC0835.AbstractC2404iF> implements AbstractC0459, AbstractC2195ty.iF {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f3195;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final List<pC> f3196;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f3197;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f3198;

    /* renamed from: ˋ  reason: contains not printable characters */
    private RecyclerView f3199;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private uD.AbstractC0227 f3200;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f3201;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f3202;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private AbstractC0459.AbstractC0460 f3203;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final UiLocation f3204;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f3205;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Cif f3206;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final AbstractC2214un.Cif f3207;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f3208;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f3209;

    /* access modifiers changed from: package-private */
    public enum Payload {
        FetchError,
        FetchSuccess
    }

    /* renamed from: com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter$if  reason: invalid class name */
    public interface Cif {
        void W_();

        /* renamed from: ˊ  reason: contains not printable characters */
        void mo2065(LoLoMoSummary loLoMoSummary);

        /* renamed from: ॱ  reason: contains not printable characters */
        C2059ph m2066();

        /* renamed from: ॱ  reason: contains not printable characters */
        void mo2067(Status status);
    }

    public LolomoRecyclerViewAdapter(NetflixActivity netflixActivity, Cif ifVar, uD.AbstractC0227 r4) {
        this(netflixActivity, ifVar, null, r4);
    }

    public LolomoRecyclerViewAdapter(NetflixActivity netflixActivity, Cif ifVar, String str, uD.AbstractC0227 r8) {
        super(netflixActivity, AbstractC0954.m15771(-2).mo15105(), AbstractC0954.m15771(-1).mo15105(), AbstractC0954.m15771(0).mo15105(), AbstractC0954.m15771(3).mo15103(new RecyclerView.RecycledViewPool()).mo15102(1).mo15096(1).mo15106(0).mo15100(0).mo15105(), AbstractC0954.m15771(4).mo15103(new RecyclerView.RecycledViewPool()).mo15102(uH.m11416(AD.m3284((Context) netflixActivity), AD.m3290((Context) netflixActivity))).mo15104(true).mo15106(uH.m11415()).mo15100(netflixActivity.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding)).mo15095(1.0f).mo15097(0.25f).mo15105(), tP.C0215.m10994(netflixActivity, 1), tP.C0215.m10997(netflixActivity, 2), tP.C0215.m10996(netflixActivity, 5), AbstractC0954.m15771(6).mo15103(new RecyclerView.RecycledViewPool()).mo15102(1).mo15096(1).mo15106(0).mo15100(0).mo15105(), m2033(netflixActivity, 7, tP.C0215.m10994(netflixActivity, 7)), m2023(netflixActivity, 8, tP.C0215.m10994(netflixActivity, 8)));
        this.f3205 = 0;
        this.f3201 = false;
        this.f3196 = new ArrayList();
        this.f3198 = true;
        this.f3207 = new AbstractC2214un.Cif() { // from class: com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter.1
            @Override // o.AbstractC2214un.Cif
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo2064(View view, int i) {
                AbstractC0837 r1 = LolomoRecyclerViewAdapter.this.m15453(i);
                if (r1 instanceof AbstractC2195ty) {
                    ((AbstractC2195ty) r1).mo11294(view);
                }
            }
        };
        this.f3206 = ifVar;
        this.f3200 = r8;
        this.f3208 = str;
        this.f3204 = this.f3208 == null ? UiLocation.HOME_LOLOMO : UiLocation.GENRE_LOLOMO;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2057(uD.AbstractC0227 r4) {
        this.f3200 = r4;
        for (int i = 0; i < mo2054(); i++) {
            if (m15453(i) instanceof tG) {
                ((tG) m15453(i)).m10907(this.f3200);
                return;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static AbstractC0954 m2023(NetflixActivity netflixActivity, int i, AbstractC0954 r8) {
        int r3 = uH.m11417(netflixActivity);
        AbstractC0954.Cif r5 = AbstractC0954.m15771(i).mo15095(1.15f).mo15103(new RecyclerView.RecycledViewPool()).mo15102(r3).mo15106(uH.m11415()).mo15099(true).mo15100(netflixActivity.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding));
        if (r3 > 1) {
            r5.mo15097(0.25f).mo15096(r8.mo15088()).mo15104(r8.mo15087());
        }
        return r5.mo15105();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static AbstractC0954 m2033(NetflixActivity netflixActivity, int i, AbstractC0954 r8) {
        int r3 = uH.m11413(netflixActivity);
        AbstractC0954.Cif r5 = AbstractC0954.m15771(i).mo15103(new RecyclerView.RecycledViewPool()).mo15102(r3).mo15106(uH.m11415()).mo15101(BrowseExperience.m1780()).mo15100(netflixActivity.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding));
        if (r3 > 1) {
            r5.mo15097(0.175f).mo15096(r8.mo15088()).mo15104(r8.mo15087());
        }
        return r5.mo15105();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public UiLocation m2059() {
        return this.f3204;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public List<pC> m2047() {
        return this.f3196;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public C2059ph m2046() {
        return this.f3206.m2066();
    }

    @Override // o.AbstractC0835, android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f3199 = recyclerView;
    }

    @Override // o.AbstractC0835, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f3199 = null;
        super.onDetachedFromRecyclerView(recyclerView);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0835
    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC0837 mo2055(Context context, AbstractC0954 r10, int i) {
        switch (r10.mo15078()) {
            case PagerAdapter.POSITION_NONE /* -2 */:
            case -1:
            case 0:
                return AbstractC0837.m15480(context, i);
            case 1:
                pC r7 = m2044(i);
                if (r7.getType() == LoMoType.INSTANT_QUEUE) {
                    return new tR(context, r7, this, r10, i);
                }
                return new C2215uo(context, r7, this, r10, i);
            case 2:
                return new tF(context, m2044(i), this, r10, i);
            case 3:
                return new tG(context, m2044(i), this, r10, i, this.f3200);
            case 4:
                return new tN(context, m2044(i), this, r10, i);
            case 5:
                return new C2206uf(context, m2044(i), this, r10, i);
            case 6:
                return new C2196tz(context, m2044(i), this, r10, i);
            case 7:
                return new C2217uq(context, m2044(i), this, r10, i);
            case 8:
                return new C2201ua(context, m2044(i), this, r10, i);
            default:
                throw new RuntimeException("Missing BaseRowAdapter for view type " + r10.mo15078());
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private pC m2044(int i) {
        return this.f3196.get(i - m15466());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean m2020(int i) {
        return this.f3196 == null || i == this.f3196.size() + m15466();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m2021(int i) {
        return i < m15466();
    }

    @Override // o.AbstractC0835
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo2058(int i) {
        if (m2020(i)) {
            return 0;
        }
        if (m2021(i)) {
            return -1;
        }
        LoMoType type = m2044(i).getType();
        switch (type) {
            case BILLBOARD:
                return 3;
            case CONTINUE_WATCHING:
                return 2;
            case BIG_ROW:
                return 6;
            case ROAR:
                boolean isRichUITreatment = m2044(i).isRichUITreatment();
                if (!tP.If.m10987() || !isRichUITreatment) {
                    return 1;
                }
                return 5;
            case INSTANT_QUEUE:
            case FLAT_GENRE:
            case STANDARD:
                return 1;
            case CHARACTERS:
                return 4;
            case SHORT_FORM:
                return 7;
            case PREVIEWS:
                return 8;
            default:
                C1283.m16850("LolomoRecyclerViewAdapter", "Unknown view type.");
                throw new IllegalArgumentException("Unknown view type: " + type.toString());
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0835
    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC0835.AbstractC2404iF mo2060(ViewGroup viewGroup, AbstractC0954 r5) {
        switch (r5.mo15078()) {
            case PagerAdapter.POSITION_NONE /* -2 */:
                return m2019(viewGroup, r5);
            case -1:
                return m2030(viewGroup);
            case 0:
                return m2039(viewGroup);
            case 1:
            case 2:
                return m2026(viewGroup, r5);
            case 3:
                return m2022(viewGroup, r5);
            case 4:
                return m2042(viewGroup, r5);
            case 5:
                return m2032(viewGroup, r5);
            case 6:
                return m2029(viewGroup, r5);
            case 7:
                return m2045(viewGroup, r5);
            case 8:
                return m2026(viewGroup, r5);
            default:
                C1283.m16850("LolomoRecyclerViewAdapter", "Unknown view type.");
                throw new IllegalArgumentException("Unknown view type: " + r5.mo15078());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private C2212ul m2026(ViewGroup viewGroup, AbstractC0954 r6) {
        return new C2212ul(this.f14645.inflate(R.layout.lolomo_lomo_row, viewGroup, false), r6, this.f3207);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private C2210uj m2032(ViewGroup viewGroup, AbstractC0954 r6) {
        return new C2210uj(this.f14645.inflate(R.layout.lolomo_lomo_row, viewGroup, false), r6, this.f3207);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private C2203uc m2022(ViewGroup viewGroup, AbstractC0954 r6) {
        return new C2203uc(this.f14645.inflate(R.layout.lolomo_billboard_row, viewGroup, false), r6, this.f3207);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C2203uc m2029(ViewGroup viewGroup, AbstractC0954 r6) {
        return new C2203uc(this.f14645.inflate(R.layout.lolomo_billboard_row, viewGroup, false), r6, this.f3207);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C2209ui m2042(ViewGroup viewGroup, AbstractC0954 r6) {
        return new C2209ui(this.f14645.inflate(R.layout.lolomo_character_row, viewGroup, false), r6, this.f3207);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C2212ul m2045(ViewGroup viewGroup, AbstractC0954 r6) {
        return new C2211uk(this.f14645.inflate(R.layout.lolomo_lomo_row_ab9296_short_form, viewGroup, false), r6, this.f3207);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private C2213um m2019(ViewGroup viewGroup, AbstractC0954 r3) {
        return C2213um.m11713(viewGroup);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private C2208uh m2039(ViewGroup viewGroup) {
        return C2208uh.m11704(viewGroup, ContextCompat.getColor(viewGroup.getContext(), R.color.brand_red));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C2207ug m2030(ViewGroup viewGroup) {
        return C2207ug.m11702(viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0835
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2053(AbstractC0835.AbstractC2404iF iFVar, int i, AbstractC0837 r5, Parcelable parcelable) {
        if (iFVar instanceof C2207ug) {
            ((C2207ug) iFVar).m11703(m15458(i));
        } else if (iFVar instanceof C2210uj) {
            ((C2210uj) iFVar).m11712(m2044(i), r5, parcelable);
        } else if (iFVar instanceof C2212ul) {
            ((C2212ul) iFVar).m11712(m2044(i), r5, parcelable);
        } else if (iFVar instanceof AbstractC2214un) {
            ((AbstractC2214un) iFVar).m15477(m2044(i), r5, parcelable);
        } else if (iFVar instanceof C2213um) {
            ((C2213um) iFVar).m11714(m2044(i));
        }
        if (!this.f3198 && this.f3201 && i >= (mo2054() + m15466()) - 2) {
            m2049(iFVar.itemView.getContext());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void onBindViewHolder(AbstractC0835.AbstractC2404iF iFVar, int i, List<Object> list) {
        if (list != null && list.contains(Payload.FetchError)) {
            iFVar.mo11717(true);
        } else if (list == null || !list.contains(Payload.FetchSuccess)) {
            super.onBindViewHolder(iFVar, i, list);
        } else {
            iFVar.mo11717(false);
        }
    }

    @Override // o.AbstractC2195ty.iF
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2052(AbstractC2195ty tyVar, int i) {
        notifyItemChanged(i, Payload.FetchError);
    }

    @Override // o.AbstractC2195ty.iF
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo2056(AbstractC2195ty tyVar, int i) {
        notifyItemChanged(i, Payload.FetchSuccess);
    }

    @Override // o.AbstractC2195ty.iF
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2051(AbstractC2195ty tyVar) {
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m2048() {
        return this.f3195;
    }

    @Override // o.AbstractC0835
    /* renamed from: ˎ  reason: contains not printable characters */
    public int mo2054() {
        int size = this.f3196 == null ? 0 : this.f3196.size();
        if (this.f3201) {
            return size + 1;
        }
        return size;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m2049(Context context) {
        this.f3198 = true;
        this.f3202 = System.nanoTime();
        int i = (this.f3205 + 22) - 1;
        C1283.m16848("LolomoRecyclerViewAdapter", "fetching more data, starting at index: %d", Integer.valueOf(this.f3205));
        C1283.m16848("LolomoRecyclerViewAdapter", "fetching from: %d to: %d, id: %s", Integer.valueOf(this.f3205), Integer.valueOf(i), this.f3195);
        C2059ph r10 = this.f3206.m2066();
        if (r10 == null) {
            C1283.m16865("LolomoRecyclerViewAdapter", "Service manager is null - can't fetch data");
            return;
        }
        int i2 = (i - this.f3205) + 1;
        if (this.f3208 != null) {
            r10.m9764().mo9480(this.f3208, this.f3205, i, new C0038(context, this.f3202, i2));
        } else {
            r10.m9764().mo9491(this.f3195, this.f3205, i, new C0038(context, this.f3202, i2));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2061(final Context context, final int i, String str) {
        C2059ph r15 = this.f3206.m2066();
        if (r15 == null) {
            C1283.m16865("LolomoRecyclerViewAdapter", "Service manager is null - can't refresh data");
            return;
        }
        C1283.m16846("LolomoRecyclerViewAdapter", "Prefetching lolomo...");
        this.f3197 = System.nanoTime();
        this.f3205 = 0;
        final long j = this.f3197;
        if (this.f3208 != null) {
            r15.m9764().mo9500(this.f3208, 0, 21, 0, uH.m11414(context, LoMoType.CONTINUE_WATCHING) - 1, false, i, new oP("LolomoRecyclerViewAdapter") { // from class: com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter.3
                @Override // o.oP, o.oU
                public void onGenreLoLoMoPrefetched(LoLoMoSummary loLoMoSummary, Status status) {
                    super.onGenreLoLoMoPrefetched(loLoMoSummary, status);
                    if (!C1317As.m3750(context)) {
                        LolomoRecyclerViewAdapter.this.f3198 = false;
                        C1348Bu.m4093();
                        if (j != LolomoRecyclerViewAdapter.this.f3197) {
                            C1283.m16854("LolomoRecyclerViewAdapter", "Request IDs do not match - skipping prefetch callback");
                            return;
                        }
                        if (i != 1) {
                            LolomoRecyclerViewAdapter.this.m2043();
                        }
                        LolomoRecyclerViewAdapter.this.m2040(context, loLoMoSummary);
                    }
                }
            });
        } else {
            r15.m9764().mo9467(i, str, new oP("LolomoRecyclerViewAdapter") { // from class: com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter.2
                @Override // o.oP, o.oU
                public void onLoLoMoPrefetched(LoLoMoSummary loLoMoSummary, Status status) {
                    super.onLoLoMoPrefetched(loLoMoSummary, status);
                    if (!C1317As.m3750(context)) {
                        LolomoRecyclerViewAdapter.this.f3198 = false;
                        C1348Bu.m4093();
                        if (j != LolomoRecyclerViewAdapter.this.f3197) {
                            C1283.m16854("LolomoRecyclerViewAdapter", "Request IDs do not match - skipping prefetch callback");
                            return;
                        }
                        boolean z = false;
                        if (status instanceof FalkorAgentStatus) {
                            z = ((FalkorAgentStatus) status).m546();
                        }
                        if (loLoMoSummary != null) {
                            loLoMoSummary.setFromCache(z);
                        }
                        if (i != 1) {
                            LolomoRecyclerViewAdapter.this.m2043();
                        }
                        LolomoRecyclerViewAdapter.this.m2040(context, loLoMoSummary);
                    }
                }
            });
        }
        if (i == 1) {
            m2043();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m2043() {
        this.f3196.clear();
        m15454();
        this.f3206.W_();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2040(Context context, LoLoMoSummary loLoMoSummary) {
        if (loLoMoSummary != null) {
            this.f3195 = loLoMoSummary.getLolomoId();
        }
        this.f3206.mo2065(loLoMoSummary);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m2050(NetflixActivity netflixActivity, NetflixImmutableStatus netflixImmutableStatus) {
        if (!this.f3209) {
            m2061(netflixActivity, 0, (String) null);
            this.f3209 = true;
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f3198;
    }

    @Override // o.AbstractC0459
    public void setLoadingStatusCallback(AbstractC0459.AbstractC0460 r1) {
        this.f3203 = r1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2028(List<? extends pC> list, Status status) {
        int size = list.size();
        int size2 = this.f3196.size();
        this.f3196.addAll(list);
        this.f3205 = this.f3196.size();
        if (this.f3201) {
            notifyItemChanged(m15466() + size2);
            m15455(size2 + 1 + m15466(), size);
        } else {
            notifyItemRemoved(m15466() + size2);
            m15455(m15466() + size2, size);
        }
        this.f3206.mo2067(status);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2027(Status status) {
        this.f3206.mo2067(status);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public int m2063() {
        return this.f3196.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter$ˊ  reason: contains not printable characters */
    public class C0038 extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f3223;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final long f3224;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final WeakReference<Context> f3225;

        public C0038(Context context, long j, int i) {
            super("LolomoRecyclerViewAdapter");
            this.f3224 = j;
            this.f3223 = i;
            this.f3225 = new WeakReference<>(context);
        }

        @Override // o.oP, o.oU
        public void onLoMosFetched(List<pC> list, Status status) {
            super.onLoMosFetched(list, status);
            m2068(list, status);
        }

        @Override // o.oP, o.oU
        public void onGenresFetched(List<pW> list, Status status) {
            super.onGenresFetched(list, status);
            m2068(list, status);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m2068(List<? extends pC> list, Status status) {
            if (!C1317As.m3750(this.f3225.get())) {
                LolomoRecyclerViewAdapter.this.f3201 = true;
                LolomoRecyclerViewAdapter.this.f3198 = false;
                if (LolomoRecyclerViewAdapter.this.f3203 != null) {
                    LolomoRecyclerViewAdapter.this.f3203.mo1654(status);
                }
                if (this.f3224 != LolomoRecyclerViewAdapter.this.f3202) {
                    C1283.m16846("LolomoRecyclerViewAdapter", "Ignoring stale onLoMosFetched callback");
                } else if (status.mo301()) {
                    C1283.m16865("LolomoRecyclerViewAdapter", "Invalid status code");
                    LolomoRecyclerViewAdapter.this.f3201 = false;
                    LolomoRecyclerViewAdapter.this.m2027(status);
                } else if (list != null) {
                    if (list.size() < this.f3223) {
                        LolomoRecyclerViewAdapter.this.f3201 = false;
                    }
                    LolomoRecyclerViewAdapter.this.m2028(list, status);
                } else {
                    C1276.m16820().mo5725("lomos is null but error is not error : " + status);
                }
            }
        }
    }
}
