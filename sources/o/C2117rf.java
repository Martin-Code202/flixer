package o;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.webclient.model.leafs.TrackableObject;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.List;
import o.AbstractC0801;
/* renamed from: o.rf  reason: case insensitive filesystem */
public class C2117rf extends C2116re implements qV {

    /* renamed from: ˈ  reason: contains not printable characters */
    private AbstractC0801.Cif f9867;

    /* renamed from: ˉ  reason: contains not printable characters */
    private AL f9868;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private int f9869 = 0;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private TrackableObject f9870;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private TrackableObject f9871;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private int f9872;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private GridLayoutManager f9873;

    /* renamed from: ˌ  reason: contains not printable characters */
    private AbstractC0801.Cif f9874;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private GridLayoutManager f9875;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C2116re m10409(String str, String str2, boolean z) {
        C2117rf rfVar = new C2117rf();
        rfVar.setStyle(1, R.style.res_2131951877_netflixdialog_notitle);
        return m10360(rfVar, str, str2, z, false);
    }

    @Override // o.C2116re, o.AbstractC0496, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f9869 = bundle.getInt("saved_state_active_tab", 0);
        }
        this.f9872 = uH.m11417(m14476());
    }

    @Override // o.C2116re, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("saved_state_active_tab", this.f9869);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ʻ */
    public void mo10368() {
        if (this.f9839 != null) {
            this.f9844.setAdapter(this.f9839);
            return;
        }
        this.f9839 = new C2115rd((NetflixActivity) getActivity(), this, this.f9827);
        if (AD.m3299() && AD.m3307(getActivity())) {
            this.f9839.m15327(ViewUtils.m3033(m14476()));
        }
        this.f9844.setAdapter(this.f9839);
        this.f9839.m15321(false);
        m10378((ViewGroup) this.f9844);
    }

    @Override // o.C2116re
    /* renamed from: ˋ */
    public void mo10386(int i, boolean z) {
        if (this.f9869 == 0) {
            super.mo10386(i, z);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ˋ */
    public void mo10387(pR pRVar) {
        super.mo10387(pRVar);
        if (pRVar != null) {
            m10394(pRVar.getSimilars());
        }
        m10411();
        switch (this.f9869) {
            case 0:
                R_();
                break;
            case 1:
                Q_();
                break;
            case 2:
                U_();
                break;
        }
        this.f9844.setVisibility(0);
        if (!(this.f9842 instanceof rA)) {
            return;
        }
        if (this.f9869 == 2 || this.f9869 == 1) {
            ((rA) this.f9842).m10133();
        } else {
            ((rA) this.f9842).m10132();
        }
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m10411() {
        if (this.f9843 != null) {
            this.f9870 = new TrackableObject(this.f9843.getSimilarsRequestId(), this.f9843.getSimilarsTrackId(), this.f9843.getSimilarsListPos());
            this.f9871 = new TrackableObject(this.f9843.getTrailersRequestId(), this.f9843.getTrailersTrackId(), this.f9843.getTrailersListPos());
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ͺ */
    public void mo10397() {
        this.f9842 = new rA(getActivity());
        this.f9842.m1695();
        this.f9842.setDetailsHelper(this.f9825);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ʻॱ */
    public ViewGroup mo10369() {
        if (getActivity() == null) {
            return null;
        }
        this.f9828 = new C2133rv(getActivity());
        mo10406();
        m10404();
        this.f9845 = new FrameLayout(getActivity());
        this.f9845.setBackgroundResource(R.color.transparent);
        this.f9845.setPadding(0, 0, 0, (int) getResources().getDimension(R.dimen.double_padding));
        this.f9845.addView(this.f9828, new FrameLayout.LayoutParams(-2, -2, 8388627));
        return this.f9845;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    public boolean m10415() {
        return this.f9869 == 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˉ  reason: contains not printable characters */
    public void m10414() {
        if (this.f9873 != null) {
            this.f9844.setLayoutManager(this.f9873);
            return;
        }
        this.f9873 = new GridLayoutManager(getActivity(), this.f9872);
        this.f9873.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: o.rf.1
            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (i == 0 || ((AbstractC0801) C2117rf.this.f9844.getAdapter()).m15330(i)) {
                    return C2117rf.this.f9872;
                }
                return 1;
            }
        });
        this.f9844.setLayoutManager(this.f9873);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public void m10416() {
        if (this.f9875 == null) {
            this.f9875 = C1353Bz.m4152(getActivity(), (AbstractC0801) this.f9844.getAdapter());
        }
        this.f9844.setLayoutManager(this.f9875);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˍ  reason: contains not printable characters */
    public void m10418() {
        if (this.f9867 == null) {
            this.f9867 = new AbstractC0801.Cif() { // from class: o.rf.2

                /* renamed from: ˊ  reason: contains not printable characters */
                int f9877 = C2117rf.this.getActivity().getResources().getDimensionPixelSize(R.dimen.content_padding);

                /* renamed from: ˎ  reason: contains not printable characters */
                private int f9879;

                /* renamed from: ˏ  reason: contains not printable characters */
                private int f9880;

                {
                    m10419();
                }

                @Override // o.AbstractC0801.Cif
                /* renamed from: ˏ */
                public View mo4156(View view) {
                    C1210 r2 = new C1210(view.getContext());
                    r2.setAdjustViewBounds(true);
                    r2.setScaleType(ImageView.ScaleType.FIT_XY);
                    r2.setLayoutParams(new AbsListView.LayoutParams(this.f9880, this.f9879));
                    return r2;
                }

                /* renamed from: ॱ  reason: contains not printable characters */
                private void m10419() {
                    this.f9880 = (((AD.m3317(C2117rf.this.getActivity()) - C2117rf.this.f9844.getPaddingLeft()) - C2117rf.this.f9844.getPaddingRight()) - (C2117rf.this.f9872 * C2117rf.this.getActivity().getResources().getDimensionPixelOffset(R.dimen.content_padding))) / C2117rf.this.f9872;
                    this.f9879 = (int) (((float) this.f9880) * 1.43f);
                }
            };
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˌ  reason: contains not printable characters */
    public void m10417() {
        if (this.f9874 == null) {
            this.f9874 = C1353Bz.m4154(this.f9844);
        }
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private void m10410() {
        Parcelable onSaveInstanceState = this.f9844.getLayoutManager().onSaveInstanceState();
        switch (this.f9869) {
            case 0:
                mo10372();
                m10412();
                break;
            case 1:
                m10418();
                m10414();
                m10413();
                break;
            case 2:
                m10416();
                m10417();
                break;
        }
        this.f9844.getLayoutManager().onRestoreInstanceState(onSaveInstanceState);
    }

    @Override // o.qV
    public void Q_() {
        this.f9869 = 1;
        this.f9845.setVisibility(8);
        if (this.f9843 != null && this.f9843.getSimilars() != null) {
            m10410();
            this.f9839.m15320(this.f9843.getSimilars(), 1, this.f9867);
            if (this.f9870 != null) {
                this.f9839.m15323(this.f9870);
            }
            this.f9823.mo14663(false);
            mo10398(AbstractC0367.f13235);
        }
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private void m10413() {
        if (this.f9868 == null) {
            this.f9868 = new AL(getActivity().getResources().getDimensionPixelOffset(R.dimen.content_padding), this.f9872);
        }
        this.f9844.removeItemDecoration(this.f9868);
        this.f9844.addItemDecoration(this.f9868);
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private void m10412() {
        if (this.f9868 != null) {
            this.f9844.removeItemDecoration(this.f9868);
        }
    }

    @Override // o.qV
    public void R_() {
        this.f9869 = 0;
        this.f9845.setVisibility(0);
        m10410();
        if (((C2115rd) this.f9839).m10348() == null || ((C2115rd) this.f9839).m10348().size() <= 0) {
            this.f9839.m15318(2);
            this.f9839.m15313(this.f9827);
            this.f9839.m15314();
            m10374();
            return;
        }
        this.f9839.m15320(((C2115rd) this.f9839).m10348(), 2, this.f9827);
        mo10375();
    }

    @Override // o.qV
    public void U_() {
        this.f9869 = 2;
        this.f9845.setVisibility(8);
        if (this.f9843 != null && this.f9843.getTrailers() != null) {
            m10410();
            this.f9839.m15320(this.f9843.getTrailers(), 1, this.f9874);
            if (this.f9871 != null) {
                this.f9839.m15323(this.f9871);
            }
            this.f9823.mo14663(false);
            mo10398(AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ॱ */
    public void mo10399(List<pS> list) {
        super.mo10399(list);
        if (this.f9869 != 0) {
            this.f9845.setVisibility(8);
        }
    }
}
