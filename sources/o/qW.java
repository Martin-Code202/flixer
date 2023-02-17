package o;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
import com.netflix.mediaclient.util.log.UIScreen;
import o.C0567;
import o.pT;
public abstract class qW<T extends pT> extends AbstractC0517 implements C0567.Cif, DetailsActivity.If {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected final C0567.Cif f9555 = new C0567.Cif() { // from class: o.qW.4
        @Override // o.C0567.Cif
        public void N_() {
            if (qW.this.f9562 != null) {
                qW.this.f9562.m10077();
                return;
            }
            FragmentActivity activity = qW.this.getActivity();
            if (activity instanceof C0567.Cif) {
                ((C0567.Cif) activity).N_();
            } else {
                C1283.m16865("DetailsFrag", "onRetryRequested but activity doesn't implement Errors callback: " + activity);
            }
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    protected View f9556;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected int f9557 = AppView.UNKNOWN.ordinal();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private T f9558;

    /* renamed from: ˏ  reason: contains not printable characters */
    public VideoDetailsViewGroup f9559;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private AddToListData.Cif f9560;

    /* renamed from: ͺ  reason: contains not printable characters */
    private oX f9561;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected qY f9562;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected C0616 f9563;

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void mo9989(View view);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract VideoDetailsViewGroup.AbstractC0033 mo9994(T t);

    /* access modifiers changed from: protected */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public abstract String mo9997();

    /* access modifiers changed from: protected */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public abstract void mo10000();

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1283.m16846("DetailsFrag", "Creating new frag view...");
        View inflate = layoutInflater.inflate(mo9992(), (ViewGroup) null, false);
        mo9989(inflate);
        this.f9563 = new C0616(inflate, this.f9555);
        this.f9556 = inflate.findViewById(mo9998());
        if (this.f9556 != null) {
            this.f9556.setVerticalScrollBarEnabled(false);
        }
        this.f9557 = getArguments().getInt("extra_model_view_id", AppView.UNKNOWN.ordinal());
        return inflate;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int mo9998() {
        return R.id.video_view_primary;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public String m9988() {
        if (this.f9558 == null) {
            return null;
        }
        return this.f9558.getTitle();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9985(qY qYVar) {
        this.f9562 = qYVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public int mo9992() {
        return R.layout.video_details_frag;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m9995() {
        C2059ph r2 = m14536();
        if (r2 != null) {
            if (this.f9559 != null) {
                this.f9559.m1681();
            }
            if (this.f9558 != null) {
                r2.m9818(mo9997(), this.f9558.isInQueue());
            }
        }
        if (getActivity() instanceof qK) {
            this.f9561 = ((qK) getActivity()).mo1635();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m9995();
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C2059ph r2 = m14536();
        if (r2 != null && this.f9560 != null) {
            r2.m9781(mo9997(), this.f9560);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo9990(Status status) {
        if (this.f9562 != null) {
            this.f9562.m10071(status);
        } else {
            super.mo9990(status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9991(Status status) {
        this.f9563.mo14660(true);
        mo9990(status);
        if (m14534() != null) {
            m14534().runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.qW.3
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    if (phVar.m9824() && vO.m12029(phVar.m9832()).mo11972() > 0) {
                        qW.this.f9563.m14661();
                    }
                }
            });
        }
        if (this.f9556 != null) {
            BQ.m3909(this.f9556, true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public void m9993() {
        this.f9563.mo14570(true);
        if (this.f9556 != null) {
            BQ.m3909(this.f9556, true);
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public C2136ry m9986() {
        if (this.f9562 != null) {
            return this.f9562.m10076();
        }
        if (getActivity() instanceof DetailsActivity) {
            return ((DetailsActivity) getActivity()).m1653();
        }
        return C2136ry.f9958;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9987(T t) {
        C2059ph r4 = m14536();
        this.f9558 = t;
        this.f9563.mo14663(true);
        if (this.f9556 != null) {
            BQ.m3914(this.f9556, true);
        }
        if (this.f9561 != null && this.f9557 == UIScreen.search.ordinal() && this.f9558.getPlayable() != null && !this.f9558.isPreRelease()) {
            m14534().playerPrepare(this.f9558.getPlayable(), PlayerPrefetchSource.DetailsPageFromSearch, this.f9561);
        }
        this.f9559.mo1685(t, mo9994(t));
        this.f9560 = m9984(this.f9559, (NetflixActivity) getActivity(), r4, m9986());
        this.f9559.setupDownloadButton(t);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static AddToListData.Cif m9984(VideoDetailsViewGroup videoDetailsViewGroup, NetflixActivity netflixActivity, C2059ph phVar, C2136ry ryVar) {
        TextView r9 = videoDetailsViewGroup.mo1696();
        if (phVar == null || phVar.m9826() == null || netflixActivity == null || r9 == null) {
            return null;
        }
        if (phVar.m9826() == null) {
            C1276.m16820().mo5727("SPY-8691 - current profile is null");
            C1283.m16865("DetailsFrag", "SPY-8691 - current profile is null");
            return null;
        } else if (!phVar.m9822()) {
            videoDetailsViewGroup.setMyListVisibility(8);
            return null;
        } else {
            AddToListData.Cif r8 = phVar.m9791(netflixActivity, r9, videoDetailsViewGroup.m1699(), ryVar.m10493(), ryVar.m10492(), ryVar.m10495(), false);
            phVar.m9802(ryVar.m10493(), r8);
            return r8;
        }
    }

    @Override // o.C0567.Cif
    public void N_() {
        m9993();
        mo10000();
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity.If
    public void P_() {
        C1283.m16846("DetailsFrag", "reload()");
        mo10000();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public VideoDetailsViewGroup m9999() {
        return this.f9559;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public pT m9996() {
        return this.f9558;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        view.setPadding(view.getPaddingLeft(), this.f13651, view.getPaddingRight(), this.f13650);
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment, java.lang.Object
    public String toString() {
        return super.toString() + " : " + mo9997();
    }
}
