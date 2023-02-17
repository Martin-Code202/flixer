package o;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
/* renamed from: o.rw  reason: case insensitive filesystem */
public class C2134rw extends qW<pR> {

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f9952;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private long f9953;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f9954;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f9955 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C2134rw m10488(String str, String str2, int i) {
        C2134rw rwVar = new C2134rw();
        Bundle bundle = new Bundle();
        bundle.putString(NetflixActivity.EXTRA_VIDEO_ID, str);
        bundle.putString("extra_episode_id", str2);
        bundle.putInt("extra_model_view_id", i);
        rwVar.setArguments(bundle);
        return rwVar;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f9952 = getArguments().getString(NetflixActivity.EXTRA_VIDEO_ID);
        this.f9954 = getArguments().getString("extra_episode_id");
        super.onCreate(bundle);
    }

    @Override // o.qW, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LinearLayout linearLayout = (LinearLayout) onCreateView.findViewById(R.id.video_details_primary_group);
        if (linearLayout != null) {
            linearLayout.setOrientation(1);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                View childAt = linearLayout.getChildAt(i);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.weight = 0.0f;
                childAt.setLayoutParams(layoutParams);
            }
        }
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ˎ */
    public void mo9989(View view) {
        this.f9559 = (VideoDetailsViewGroup) view.findViewById(R.id.video_details_view_group);
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ᐝॱ */
    public void mo10000() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo9987(pR pRVar) {
        super.mo9987((C2134rw) pRVar);
        this.f9559.setCopyright(pRVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m10489(pR pRVar) {
        m10487(pRVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ॱˎ */
    public String mo9997() {
        return this.f9952;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public VideoDetailsViewGroup.AbstractC0033 mo9994(pR pRVar) {
        return new C0186(getActivity(), pRVar);
    }

    /* renamed from: o.rw$ˊ  reason: contains not printable characters */
    public static class C0186 implements VideoDetailsViewGroup.AbstractC0033 {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final pR f9956;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Context f9957;

        public C0186(Context context, pR pRVar) {
            this.f9957 = context;
            this.f9956 = pRVar;
        }

        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
        /* renamed from: ॱ */
        public CharSequence mo1715() {
            return BG.m3858(this.f9957, this.f9956);
        }

        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
        /* renamed from: ˎ */
        public CharSequence mo1714() {
            if (C1349Bv.m4113(this.f9956.getCreators())) {
                return null;
            }
            return BG.m3857(this.f9957, C0403.m14185(this.f9957, R.string.label_creators_plural).m14187(this.f9956.getNumCreators()).m14188(), this.f9956.getCreators());
        }

        @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
        /* renamed from: ˋ */
        public CharSequence mo1713() {
            return BG.m3852(this.f9957, R.string.label_starring, this.f9956.getActors());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10487(pR pRVar) {
        if (C1317As.m3750(m14534())) {
            C1283.m16846("ShowDetailsFrag", "Activity state is invalid");
        } else if (this.f9953 != this.f9953 || T_()) {
            C1283.m16846("ShowDetailsFrag", "Ignoring stale callback");
        } else {
            this.f9955 = false;
            if (pRVar == null) {
                C1283.m16846("ShowDetailsFrag", "No details in response");
                m9991(AbstractC0367.f13245);
                return;
            }
            mo9987(pRVar);
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f9955;
    }
}
