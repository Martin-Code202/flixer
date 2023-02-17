package o;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
import o.C2134rw;
/* renamed from: o.rq  reason: case insensitive filesystem */
public class C2128rq extends C2122rk {

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f9927 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C2128rq m10461(String str, boolean z) {
        C2128rq rqVar = new C2128rq();
        Bundle bundle = new Bundle();
        bundle.putString("video_id", str);
        bundle.putBoolean("extra_is_movie", z);
        rqVar.setArguments(bundle);
        return rqVar;
    }

    @Override // o.C2122rk, o.qW, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9927 = getArguments().getBoolean("extra_is_movie", false);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2122rk, o.qW
    /* renamed from: ˎ */
    public void mo9989(View view) {
        this.f9559 = new Cif(getActivity());
        this.f9559.m1695();
        this.f9559.m1700();
        if (AD.m3307(getActivity()) && AD.m3299()) {
            this.f9559.setPadding(0, m14534().getActionBarHeight(), 0, 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2122rk
    /* renamed from: ॱॱ */
    public void mo10458(pP pPVar) {
        this.f9559.m1675();
    }

    /* access modifiers changed from: protected */
    @Override // o.C2122rk
    /* renamed from: ˉ */
    public void mo10449() {
        if (this.f9927) {
            super.mo10449();
        } else {
            m10463();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2122rk
    /* renamed from: ॱ */
    public VideoDetailsViewGroup.AbstractC0033 mo9994(pP pPVar) {
        if (this.f9927 || !(pPVar instanceof pR)) {
            return super.mo9994(pPVar);
        }
        return new C2134rw.C0186(getActivity(), (pR) pPVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10463() {
        C2059ph r5 = m14536();
        if (r5 == null || !r5.mo9519()) {
            C1283.m16865("PreReleaseDetailsFrag", "Manager is null/notReady - can't reload data");
            return;
        }
        this.f9903 = true;
        this.f9900 = System.nanoTime();
        r5.m9764().mo9503(this.f9910, (String) null, new iF(this.f9900));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.rq$iF */
    public class iF extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final long f9929;

        public iF(long j) {
            super("PreReleaseDetailsFrag");
            this.f9929 = j;
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            super.onShowDetailsFetched(pRVar, status);
            if (C1317As.m3750(C2128rq.this.m14534())) {
                C1283.m16846("PreReleaseDetailsFrag", "Activity state is invalid");
            } else if (this.f9929 != C2128rq.this.f9900 || C2128rq.this.T_()) {
                C1283.m16846("PreReleaseDetailsFrag", "Ignoring stale callback");
            } else {
                C2128rq.this.f9903 = false;
                if (status.mo301()) {
                    C1283.m16865("PreReleaseDetailsFrag", "Invalid status code");
                    C2128rq.this.m9991(status);
                } else if (pRVar == null) {
                    C1283.m16846("PreReleaseDetailsFrag", "No details in response");
                    C2128rq.this.m9991(AbstractC0367.f13245);
                } else {
                    C2128rq.this.mo9987((pP) pRVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.rq$if  reason: invalid class name */
    public class Cif extends VideoDetailsViewGroup {

        /* renamed from: ˍ  reason: contains not printable characters */
        private Button f9931;

        public Cif(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
        /* renamed from: ॱ */
        public int mo1697() {
            return R.layout.video_details_view_group_pre_release;
        }

        /* access modifiers changed from: protected */
        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
        /* renamed from: ˏ */
        public void mo1692() {
            super.mo1692();
            this.f9931 = (Button) findViewById(R.id.trailer_play_button);
        }

        /* access modifiers changed from: protected */
        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
        /* renamed from: ˊ */
        public void mo1679(pT pTVar, NetflixActivity netflixActivity) {
            if (pTVar.hasTrailers()) {
                String defaultTrailer = pTVar.getDefaultTrailer();
                if (!TextUtils.isEmpty(defaultTrailer)) {
                    m10464(defaultTrailer);
                    return;
                }
                return;
            }
            this.f9931.setVisibility(4);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m10464(String str) {
            C2059ph r4 = C2128rq.this.m14536();
            if (r4 == null || !r4.mo9519()) {
                C1283.m16865("PreReleaseVideoDetailsViewGroup", "Manager is null/notReady - can't reload data");
                return;
            }
            C2128rq.this.f9900 = System.nanoTime();
            r4.m9764().mo9513(str, (String) null, new C0185(C2128rq.this.f9900));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.rq$if$ˋ  reason: contains not printable characters */
        public class C0185 extends oP {

            /* renamed from: ˊ  reason: contains not printable characters */
            private pP f9932;

            /* renamed from: ˎ  reason: contains not printable characters */
            private View.OnClickListener f9934 = new View.OnClickListener() { // from class: o.rq.if.ˋ.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C2128rq.this.getActivity() != null && C0185.this.f9932 != null) {
                        oX r4 = ((qK) C2128rq.this.getActivity()).mo1635();
                        r4.mo9594(PlayLocationType.STORY_ART);
                        PlaybackLauncher.m1605((NetflixActivity) Cif.this.getContext(), C0185.this.f9932.getPlayable(), C0185.this.f9932.getType(), r4, 0);
                    }
                }
            };

            /* renamed from: ˏ  reason: contains not printable characters */
            private final long f9935;

            public C0185(long j) {
                super("PreReleaseVideoDetailsViewGroup");
                this.f9935 = j;
            }

            @Override // o.oP, o.oU
            public void onMovieDetailsFetched(pP pPVar, Status status) {
                super.onMovieDetailsFetched(pPVar, status);
                if (this.f9935 != C2128rq.this.f9900 || C2128rq.this.T_()) {
                    C1283.m16846("PreReleaseVideoDetailsViewGroup", "Ignoring stale callback");
                } else if (pPVar != null) {
                    this.f9932 = pPVar;
                    m10467();
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: ˏ  reason: contains not printable characters */
            public void m10467() {
                Cif.this.f9931.setVisibility(0);
                Cif.this.f9931.requestFocus();
                Cif.this.f9931.setOnClickListener(this.f9934);
            }
        }

        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
        /* renamed from: ˋ */
        public void mo1685(pT pTVar, VideoDetailsViewGroup.AbstractC0033 r2) {
            super.mo1685(pTVar, r2);
        }
    }
}
