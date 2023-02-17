package o;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.netflix.android.widgetry.widget.TrackedGridLayoutManager;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.ui.lomo.LoMoUtils;
import o.AbstractC2195ty;
import o.C0567;
import o.tP;
public class tK extends AbstractC2163su implements AbstractC2124rm {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected TrackedGridLayoutManager f10379;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected String f10380;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected C0840 f10381;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Parcelable f10382;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected final C0567.Cif f10383 = new C0567.Cif() { // from class: o.tK.1
        @Override // o.C0567.Cif
        public void N_() {
            if (tK.this.f10386 != null && tK.this.f10384 != null) {
                tK.this.f10384.mo11294(tK.this.f10386.m14664());
            }
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    protected C2215uo f10384;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f10385;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected C0616 f10386;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected pC f10387;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected GenreList f10388;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m10965(String str) {
        return "MyListFakeId".equals(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static tK m10963(pC pCVar, String str) {
        tK tKVar = new tK();
        Bundle bundle = new Bundle();
        bundle.putString("list_id", pCVar.getId());
        bundle.putBoolean("is_genre_list", false);
        bundle.putParcelable("lomo_parcel", pCVar);
        bundle.putString("genre_from_lolomo", str);
        tKVar.setArguments(bundle);
        return tKVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static tK m10960(pC pCVar) {
        return m10963(pCVar, "");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public String m10971() {
        return this.f10385;
    }

    /* renamed from: ॱॱ */
    public pC mo10891() {
        return this.f10387;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m10969() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.setClassLoader(tK.class.getClassLoader());
            this.f10385 = arguments.getString("list_id");
            this.f10387 = (pC) arguments.getParcelable("lomo_parcel");
            this.f10388 = (GenreList) arguments.getParcelable("genre_parcel");
            this.f10380 = arguments.getString("genre_from_lolomo");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(m10972(), viewGroup, false);
        m10969();
        m10970(inflate);
        m10973(inflate);
        return inflate;
    }

    @Override // o.AbstractC2163su
    /* renamed from: ˏ */
    public void mo10856(int i, String str) {
    }

    @Override // o.AbstractC2163su
    /* renamed from: ˋ */
    public void mo10854(boolean z) {
        if (this.f10381 == null) {
            return;
        }
        if (z) {
            this.f10381.smoothScrollToPosition(0);
        } else {
            this.f10381.scrollToPosition(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public int m10972() {
        return R.layout.gallery_content_frag;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10970(View view) {
        this.f10381 = (C0840) view.findViewById(R.id.gallery);
        int r1 = LoMoUtils.m2147(m14534());
        m10966(r1);
        m10961(m14534(), r1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10973(View view) {
        this.f10386 = new C0527(view, this.f10383, C0527.f13713);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10966(int i) {
        this.f10379 = new TrackedGridLayoutManager(getActivity(), i) { // from class: o.tK.5
            @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
            /* renamed from: ˏ */
            public void mo105(String str) {
            }

            @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
            /* renamed from: ˊ */
            public String mo104() {
                return "GalleryLoMoFrag";
            }
        };
        this.f10379.setSpanCount(i);
        this.f10381.setLayoutManager(this.f10379);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10961(final NetflixActivity netflixActivity, final int i) {
        netflixActivity.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.tK.4
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                AbstractC0954 r8 = tP.C0215.m10995(netflixActivity, 1, i);
                if (tK.this.f10384 == null || tK.this.f10384.getItemCount() == 0) {
                    if (TextUtils.equals(tK.this.f10385, "MyListFakeId")) {
                        pC r9 = phVar.m9764().mo9463("queue");
                        if (r9 != null) {
                            tK.this.f10387 = r9;
                            tK.this.f10384 = new tL(tK.this.f10381.getContext(), r9, netflixActivity.getServiceManager(), UiLocation.GENRE_LOLOMO, r8, r9.getListPos());
                        } else {
                            C1276.m16820().mo5725("My List gallery requested but not loaded in cmp");
                            if (!C1317As.m3750(netflixActivity)) {
                                netflixActivity.finish();
                                return;
                            }
                            return;
                        }
                    } else {
                        tK.this.f10384 = new tE(tK.this.f10381.getContext(), tK.this.mo10891(), netflixActivity.getServiceManager(), UiLocation.GENRE_LOLOMO, r8, tK.this.mo10891().getListPos());
                    }
                    if (tK.this.f10386 != null) {
                        tK.this.f10386.mo14663(false);
                    }
                    tK.this.m10958();
                    if (tK.this.f10384 != null) {
                        tK.this.f10384.m11290(new AbstractC2195ty.iF() { // from class: o.tK.4.4
                            @Override // o.AbstractC2195ty.iF
                            /* renamed from: ˊ */
                            public void mo2051(AbstractC2195ty tyVar) {
                                if (tyVar.m11286().size() == 0) {
                                    tK.this.m10962(false);
                                    if (tK.this.f10386 != null) {
                                        tK.this.f10386.mo14570(true);
                                    }
                                }
                            }

                            @Override // o.AbstractC2195ty.iF
                            /* renamed from: ˊ */
                            public void mo2052(AbstractC2195ty tyVar, int i2) {
                                C1283.m16854("GalleryLoMoFrag", "onFetchError");
                                if (tyVar.m11286().size() == 0 && tK.this.f10386 != null) {
                                    tK.this.f10386.mo14660(true);
                                }
                            }

                            @Override // o.AbstractC2195ty.iF
                            /* renamed from: ˎ */
                            public void mo2056(AbstractC2195ty tyVar, int i2) {
                                C1283.m16854("GalleryLoMoFrag", "onFetchSuccess");
                                if (tK.this.f10386 != null) {
                                    tK.this.f10386.mo14663(false);
                                }
                                tK.this.f10381.setVisibility(0);
                                tK.this.m10968();
                            }
                        });
                        if (tK.this.f10384.m11286().size() == 0) {
                            tK.this.f10381.setVisibility(4);
                        }
                    }
                }
                C1004.m15952(tK.this.f10381, 0, r8.mo15076());
                C1004.m15952(tK.this.f10381, 2, r8.mo15076());
                tK.this.f10381.setAdapter(tK.this.f10384);
                tK.this.f10384.mo11293(tK.this.f10381.getContext());
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10384 != null && this.f10381 != null) {
            this.f10384.mo11306(this.f10381.getContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (!(this.f10384 == null || this.f10381 == null)) {
            this.f10384.mo11311(this.f10381.getContext());
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (!(this.f10384 == null || this.f10381 == null)) {
            this.f10384.mo11300(this.f10381.getContext());
        }
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m10958() {
        if (this.f10384 != null) {
            m10962(this.f10384.getItemCount() == 0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10962(boolean z) {
        View view;
        ViewStub viewStub;
        if (!isDetached() && (view = getView()) != null) {
            C0601 r2 = (C0601) view.findViewById(R.id.empty_state_view);
            if (r2 == null && z && (viewStub = (ViewStub) view.findViewById(R.id.empty_list_stub)) != null) {
                r2 = (C0601) viewStub.inflate();
            }
            if (r2 != null) {
                mo2213(view);
                r2.setVisibility(z ? 0 : 8);
                if (z && this.f10385 != null) {
                    String str = this.f10385;
                    char c = 65535;
                    switch (str.hashCode()) {
                        case 635217018:
                            if (str.equals("MyListFakeId")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            r2.setIconDrawable(R.drawable.ic_emptygraphic_mylist);
                            r2.setMessageText(getString(R.string.my_list_empty_text));
                            r2.setButtonText(getString(R.string.my_list_empty_button));
                            r2.setButtonClickListener(new View.OnClickListener() { // from class: o.tK.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (!tK.this.isDetached()) {
                                        tK.this.startActivity(ActivityC2153sl.m10779(tK.this.m14534()));
                                    }
                                }
                            });
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m10968() {
        m10958();
        m10974();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m10974() {
        if (this.f10382 != null && this.f10381 != null) {
            C1283.m16848("GalleryLoMoFrag", "Restoring layout manager state: %s", this.f10382);
            this.f10381.getLayoutManager().onRestoreInstanceState(this.f10382);
            this.f10382 = null;
        }
    }

    @Override // o.AbstractC2124rm
    /* renamed from: ˊ */
    public Parcelable mo10450() {
        if (this.f10381 == null || this.f10381.getLayoutManager() == null) {
            return null;
        }
        return this.f10381.getLayoutManager().onSaveInstanceState();
    }

    @Override // o.AbstractC2124rm
    /* renamed from: ˋ */
    public void mo10452(Parcelable parcelable) {
        this.f10382 = parcelable;
    }

    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        C1004.m15952(view.findViewById(R.id.empty_state_view), 1, this.f13651 + this.f13649);
        if (this.f10381 != null) {
            this.f10381.setPadding(this.f10381.getPaddingLeft(), this.f13651 + this.f13649, this.f10381.getPaddingRight(), this.f13650 + this.f10381.getResources().getDimensionPixelSize(R.dimen.xlarge_padding));
        }
    }

    @Override // o.AbstractC0517
    public boolean af_() {
        NetflixActivity r2 = m14534();
        String title = this.f10388 != null ? this.f10388.getTitle() : this.f10387 != null ? this.f10387.getTitle() : null;
        if (title == null || r2 == null) {
            return false;
        }
        r2.setTitle(title);
        NetflixActionBar netflixActionBar = r2.getNetflixActionBar();
        if (netflixActionBar == null) {
            return false;
        }
        netflixActionBar.m355(r2.getActionBarStateBuilder().mo394((CharSequence) title).mo396(true).mo399(false).mo392());
        return true;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment, java.lang.Object
    public String toString() {
        return super.toString() + " - id: " + (this.f10388 != null ? this.f10388.getId() : this.f10387 != null ? this.f10387.getId() : null);
    }
}
