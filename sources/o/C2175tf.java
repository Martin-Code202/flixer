package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.TrackableObject;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
import java.util.List;
import o.C2112ra;
import o.C2130rs;
import o.C2172tc;
/* renamed from: o.tf  reason: case insensitive filesystem */
public class C2175tf extends C2172tc {

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private pL f10525;

    /* renamed from: ˌ  reason: contains not printable characters */
    private int f10526;

    /* renamed from: ˍ  reason: contains not printable characters */
    private String f10527;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Fragment m11135(String str, int i) {
        C2175tf tfVar = new C2175tf();
        Bundle bundle = new Bundle();
        bundle.putString("extra_chararcter_id", str);
        bundle.putInt("extra_kids_color_id", i);
        bundle.putBoolean("extra_show_details", true);
        tfVar.setArguments(bundle);
        return tfVar;
    }

    @Override // o.C2116re, o.AbstractC0496, o.AbstractC0459
    public boolean isLoadingData() {
        return this.f9824;
    }

    @Override // o.C2172tc, o.C2116re, o.AbstractC0496, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10527 = getArguments().getString("extra_chararcter_id");
        this.f10526 = getArguments().getInt("extra_kids_color_id");
    }

    @Override // o.C2116re, o.AbstractC0496, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        C1283.m16846("KidsCharacterDetailsFrag", "onManagerReady");
        super.onManagerReady(phVar, status);
        m11143();
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ʻ */
    public void mo10368() {
        this.f9839 = new C2172tc.Cif();
        this.f9844.setAdapter(this.f9839);
    }

    @Override // o.C2116re, com.netflix.mediaclient.ui.details.DetailsActivity.If
    public void P_() {
        if (this.f10487) {
            m10402();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ˊॱ */
    public void mo10384() {
        mo10397();
        ((AbstractC0801) this.f9844.getAdapter()).m15327(this.f9842);
        m10391(0);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ͺ */
    public void mo10397() {
        this.f9842 = new C2181tk(getActivity(), this.f10526);
        this.f9842.m1695();
        this.f9842.m1675();
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m11143() {
        if (m14474() == null) {
            C1283.m16865("KidsCharacterDetailsFrag", "Manager is null - can't get character details");
            return;
        }
        this.f9824 = true;
        m14474().m9764().mo9492(this.f10527, new If());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏˏ  reason: contains not printable characters */
    private C2112ra m11141() {
        if (m14476() == null || m10401() == null || C1322Av.m3791(m10401().getContext(), NetflixActivity.class) == null) {
            return null;
        }
        this.f9840 = new C2178th(this.f9828, m10401(), new View[0], this.f10487 ? this.f9845 : null, this.f10487 ? this.f9842.m1682() : null, this.f9842, this.f10487, this.f10526);
        m10401().setOnScrollListener(this.f9840);
        this.f9840.m10339(new C2112ra.iF() { // from class: o.tf.4
            @Override // o.C2112ra.iF
            /* renamed from: ˏ */
            public void mo10346() {
                C2175tf.this.f10486.m11113();
            }

            @Override // o.C2112ra.iF
            /* renamed from: ˋ */
            public void mo10345() {
                C2175tf.this.f10486.m11114(false);
            }

            @Override // o.C2112ra.iF
            /* renamed from: ˊ */
            public void mo10344() {
            }
        });
        mo10383();
        return this.f9840;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tf$If */
    public class If extends oP {
        public If() {
            super("KidsCharacterDetailsFrag");
        }

        @Override // o.oP, o.oU
        public void onKidsCharacterDetailsFetched(pL pLVar, Boolean bool, Status status) {
            super.onKidsCharacterDetailsFetched(pLVar, bool, status);
            C2175tf.this.f9824 = false;
            if (status.mo301()) {
                C1283.m16865("KidsCharacterDetailsFrag", "Invalid status code");
                C2175tf.this.m10379(status);
                return;
            }
            C2175tf.this.f10525 = pLVar;
            if (pLVar == null) {
                C1283.m16846("KidsCharacterDetailsFrag", "No details in response");
                C2175tf.this.m10379(AbstractC0367.f13245);
                return;
            }
            List<pJ> r3 = pLVar.mo4181();
            if (r3.size() == 0) {
                C1283.m16846("KidsCharacterDetailsFrag", "No details in response");
                C2175tf.this.m10379(AbstractC0367.f13245);
                return;
            }
            C2175tf.this.m11094();
            if (r3.size() > 1) {
                pJ r4 = m11153(r3);
                if (r4 != null) {
                    C2175tf.this.f9841 = r4.getId();
                    C2175tf.this.f10487 = false;
                    if (r4.getType() == VideoType.SHOW) {
                        C2175tf.this.m10402();
                    } else if (r4.getType() == VideoType.MOVIE) {
                        m11150();
                    }
                }
            } else {
                pJ pJVar = r3.get(0);
                if (pJVar.getType() == VideoType.SHOW) {
                    C2175tf.this.f9841 = pJVar.getId();
                    C2175tf.this.f10487 = true;
                    C2175tf.this.m11134();
                    C2175tf.this.m10402();
                } else if (pJVar.getType() == VideoType.MOVIE) {
                    qU.m9974(C2175tf.this.m14476(), pJVar, new oB("KidsCharacterDetailsFrag"), "CharacterClickListener");
                }
            }
            C2175tf.this.m11141();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private void m11150() {
            C2059ph r5 = C2175tf.this.m14474();
            if (r5 == null) {
                C1283.m16865("KidsCharacterDetailsFrag", "Manager is null - can't get movie details");
            } else if (C2175tf.this.m14476() == null) {
                C1283.m16865("KidsCharacterDetailsFrag", "Activity is null - can't get movie details");
            } else if (C2175tf.this.m10385() == null) {
                C1283.m16865("KidsCharacterDetailsFrag", "show ID is null - can't get movie details");
            } else {
                C2175tf.this.f9824 = true;
                C2175tf.this.f9846 = System.nanoTime();
                r5.m9764().mo9513(C2175tf.this.f9841, (String) null, new Cif(C2175tf.this.f9846));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.tf$If$if  reason: invalid class name */
        public class Cif extends oP {

            /* renamed from: ˏ  reason: contains not printable characters */
            private final long f10532;

            public Cif(long j) {
                super("KidsCharacterDetailsFrag");
                this.f10532 = j;
            }

            @Override // o.oP, o.oU
            public void onMovieDetailsFetched(pP pPVar, Status status) {
                super.onMovieDetailsFetched(pPVar, status);
                if (this.f10532 != this.f10532) {
                    C1283.m16846("KidsCharacterDetailsFrag", "Stale response - ignoring");
                    return;
                }
                C2175tf.this.f9824 = false;
                if (status.mo301()) {
                    C1283.m16865("KidsCharacterDetailsFrag", "Error status code fetching data - showing errors view");
                    C2175tf.this.m10379(status);
                } else if (pPVar == null) {
                    C1283.m16865("KidsCharacterDetailsFrag", "No details in response!");
                    C2175tf.this.m10379(AbstractC0367.f13245);
                } else {
                    C2175tf.this.m11142();
                    C2175tf.this.m11149(pPVar);
                    C2175tf.this.mo10398(AbstractC0367.f13235);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public pJ m11153(List<pJ> list) {
            pJ r1 = m11152(list);
            if (r1 == null) {
                return m11151(list);
            }
            return r1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public pJ m11152(List<pJ> list) {
            for (pJ pJVar : list) {
                if (pJVar.getType() == VideoType.SHOW) {
                    return pJVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public pJ m11151(List<pJ> list) {
            for (pJ pJVar : list) {
                if (pJVar.getType() == VideoType.MOVIE) {
                    return pJVar;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˑ  reason: contains not printable characters */
    private void m11142() {
        if (this.f10525 != null) {
            this.f9839.m15323(new TrackableObject(this.f10525.mo4177(), this.f10525.mo4178(), this.f10525.mo4180()));
            return;
        }
        C1276.m16820().mo5725("KidsCharacterDetails is null, should never hit this because movie/show details are not even fetched if this is null ");
    }

    /* access modifiers changed from: protected */
    @Override // o.C2172tc, o.C2116re
    /* renamed from: ˋ */
    public void mo10387(pR pRVar) {
        m11142();
        if (this.f10487) {
            super.mo10387(pRVar);
            m11140();
            return;
        }
        m11149((pT) pRVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ॱ */
    public void mo10399(List<pS> list) {
        if (this.f10487) {
            super.mo10399(list);
            this.f9845.setBackgroundResource(R.color.transparent);
            return;
        }
        mo10398(AbstractC0367.f13235);
    }

    /* renamed from: o.tf$ˋ  reason: contains not printable characters */
    public static class C0223 implements VideoDetailsViewGroup.AbstractC0033 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final pT f10533;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Context f10534;

        public C0223(Context context, pT pTVar) {
            this.f10534 = context;
            this.f10533 = pTVar;
        }

        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
        /* renamed from: ॱ */
        public CharSequence mo1715() {
            return BG.m3853(this.f10534, this.f10533);
        }

        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
        /* renamed from: ˎ */
        public CharSequence mo1714() {
            return null;
        }

        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
        /* renamed from: ˋ */
        public CharSequence mo1713() {
            return BG.m3852(this.f10534, R.string.label_starring, this.f10533.getActors());
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    @SuppressLint({"ResourceAsColor"})
    /* renamed from: ᐝॱ */
    public void mo10406() {
        C2130rs rsVar = new C2130rs(m14476(), new C2130rs.If() { // from class: o.tf.3
            @Override // o.C2130rs.If
            /* renamed from: ॱ */
            public View mo10407(ViewGroup viewGroup) {
                return View.inflate(viewGroup.getContext(), R.layout.kids_season_spinner_row, null);
            }
        });
        rsVar.m10475(R.color.kids_default);
        this.f9828.setAdapter((SpinnerAdapter) rsVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ˋॱ */
    public void mo10388() {
    }

    /* access modifiers changed from: protected */
    @Override // o.C2172tc, o.C2116re
    /* renamed from: ʻॱ */
    public ViewGroup mo10369() {
        ViewGroup r2 = super.mo10369();
        m11148(getResources().getColor(this.f10526));
        C2130rs rsVar = (C2130rs) this.f9828.getAdapter();
        if (rsVar != null) {
            rsVar.m10475(this.f10526);
            rsVar.m10472(R.color.white);
            rsVar.m10474(R.color.white);
            rsVar.m10471(this.f10526);
        }
        return r2;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ʿ */
    public void mo10375() {
        m10373();
        if (this.f9826 < 0) {
            C1283.m16846("KidsCharacterDetailsFrag", "No valid season index found");
        } else {
            this.f9828.setNonTouchSelection(this.f9826);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11148(int i) {
        Drawable drawable = getResources().getDrawable(R.drawable.btn_season_selector_bk);
        drawable.setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.kids_spinner_bg);
        layerDrawable.setAutoMirrored(true);
        Drawable drawable2 = layerDrawable.getDrawable(1);
        if (drawable2 != null) {
            drawable2.setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        }
        this.f9828.setBackground(layerDrawable, drawable);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎˏ  reason: contains not printable characters */
    private void m11134() {
        if (this.f10487) {
            this.f9845 = mo10369();
            m10396();
        }
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private void m11140() {
        mo10388();
        ((C2181tk) this.f9842).m11191(this.f10525);
        this.f9839.m15318(2);
        this.f9839.m15313(this.f10488);
        m11095();
        this.f9823.mo14663(false);
        if (this.f10486 != null) {
            this.f10486.m11113();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11149(pT pTVar) {
        this.f9839.m15328(this.f10525.mo4181());
        this.f9842.mo1685(pTVar, new C0223(getActivity(), pTVar));
        ((C2181tk) this.f9842).m11191(this.f10525);
        if (this.f10486 != null) {
            this.f10486.m11113();
        }
        m11095();
        this.f9823.mo14663(false);
    }
}
