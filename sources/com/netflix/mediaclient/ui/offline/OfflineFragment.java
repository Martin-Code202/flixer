package com.netflix.mediaclient.ui.offline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import com.netflix.mediaclient.ui.offline.OfflineAdapterData;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.List;
import o.AbstractC0517;
import o.AbstractC1853hl;
import o.AbstractC1854hm;
import o.C0601;
import o.C0754;
import o.C1004;
import o.C1276;
import o.C1283;
import o.C1317As;
import o.C1322Av;
import o.C2059ph;
import o.C2093qn;
import o.C2098qr;
import o.oX;
import o.pV;
import o.qN;
import o.qU;
import o.vD;
import o.vF;
import o.vH;
import o.vL;
import o.vM;
import o.vO;
import o.vW;
public class OfflineFragment extends AbstractC0517 implements AbstractC1854hm {

    /* renamed from: ʻ  reason: contains not printable characters */
    private LinearLayoutManager f3361;

    /* renamed from: ʼ  reason: contains not printable characters */
    private vF f3362;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C0601 f3363;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f3364;

    /* renamed from: ˏ  reason: contains not printable characters */
    private RecyclerView f3365;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f3366;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f3367;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0754 f3368;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC1853hl f3369;

    enum Payload {
        All
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Fragment m2204() {
        return new OfflineFragment();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int m2221() {
        return R.layout.fragment_offline_primary;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1283.m16846("OfflineFragment", "Creating frag view");
        View inflate = layoutInflater.inflate(m2221(), viewGroup, false);
        m2209(inflate);
        m2210();
        return inflate;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2215(boolean z) {
        if (this.f3362 != null) {
            this.f3362.m11906(z);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean m2219() {
        return this.f3362 != null && this.f3362.m11915();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public int m2216() {
        if (this.f3362 != null) {
            return this.f3362.m11900();
        }
        return 0;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public String m2214() {
        if (this.f3362 != null) {
            return this.f3362.m11910();
        }
        return "";
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m2218() {
        if (this.f3362 != null) {
            this.f3362.m11904();
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m2217() {
        if (this.f3365 != null) {
            this.f3365.smoothScrollToPosition(0);
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public boolean m2212() {
        return this.f3362 instanceof vL;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public boolean m2222() {
        return this.f3362 != null && this.f3362.getItemCount() > 0;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m2210() {
        if (!this.f3364) {
            if (getActivity() == null) {
                C1283.m16854("OfflineFragment", "Activity is null - can't continue init");
                return;
            }
            C2059ph r3 = m14536();
            if (r3 == null) {
                C1283.m16854("OfflineFragment", "Manager not available - can't continue init");
            } else if (this.f3365 == null) {
                C1283.m16854("OfflineFragment", "Views are not initialized - can't continue init");
            } else if (!r3.m9824()) {
                C1283.m16854("OfflineFragment", "Offline Feature not available!");
            } else {
                this.f3369 = m14534().getServiceManager().m9832();
                if (this.f3369 != null) {
                    this.f3369.mo7124(this);
                }
                m2220();
                this.f3364 = true;
                m2197();
                OfflineAdapterData r4 = m2205(vO.m12029(this.f3369), this.f3366, this.f3367);
                if (r4 != null) {
                    getActivity().setTitle(r4.m2192().f3357.getTitle());
                }
            }
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public void m2220() {
        final NetflixActivity r1 = m14534();
        if (r1 != null) {
            r1.runWhenManagerIsReady(new NetflixActivity.If() { // from class: com.netflix.mediaclient.ui.offline.OfflineFragment.4
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    if (!C1317As.m3750(r1)) {
                        OfflineFragment.this.m2193();
                        OfflineFragment.this.m2211();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m2211() {
        OfflineAdapterData r8;
        AnonymousClass3 r6 = new vF.AbstractC0241() { // from class: com.netflix.mediaclient.ui.offline.OfflineFragment.3
            @Override // o.vF.AbstractC0241
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo2223(int i, boolean z) {
                String r3 = OfflineFragment.this.f3362.mo11907(i);
                if (OfflineFragment.this.f3362.m11915()) {
                    OfflineFragment.this.f3362.m11905(i, r3);
                } else if (r3 != null) {
                    switch (OfflineFragment.this.f3362.mo11903(i)) {
                        case MOVIE:
                            if (z) {
                                OfflineFragment.this.m2207(r3, i);
                                return;
                            } else {
                                C1283.m16862("OfflineFragment", "movie playIcon not visible, ignoring");
                                return;
                            }
                        case SHOW:
                            if (OfflineFragment.this.f3369 != null) {
                                String r4 = OfflineFragment.m2199(vO.m12029(OfflineFragment.this.f3369), i);
                                if (OfflineFragment.this.getActivity() != null) {
                                    OfflineFragment.this.startActivity(vH.m11937(OfflineFragment.this.getActivity(), r3, r4, false));
                                    return;
                                }
                                return;
                            }
                            return;
                        case EPISODE:
                            if (z) {
                                OfflineFragment.this.m2207(r3, i);
                                return;
                            } else {
                                C1283.m16862("OfflineFragment", "episode playIcon not visible, ignoring");
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        C2098qr[] qrVarArr = null;
        if (!(this.f3366 == null || (r8 = m2205(vO.m12029(this.f3369), this.f3366, this.f3367)) == null)) {
            qrVarArr = r8.m2190();
        }
        if (qrVarArr == null || qrVarArr.length <= 0) {
            this.f3362 = new vW(m14534(), this.f3369, r6);
        } else {
            this.f3362 = new vL(m14534(), this.f3369, r6, this.f3366, this.f3367);
        }
        this.f3362.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.netflix.mediaclient.ui.offline.OfflineFragment.5
            @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                OfflineFragment.this.m2195();
                FragmentActivity activity = OfflineFragment.this.getActivity();
                if (activity != null) {
                    activity.invalidateOptionsMenu();
                }
            }
        });
        this.f3365.setAdapter(this.f3362);
        m2195();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m2199(vM vMVar, int i) {
        if (vMVar.mo4074() > i) {
            return m2202((OfflineAdapterData) vMVar.mo4075(i));
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static String m2202(OfflineAdapterData offlineAdapterData) {
        if (offlineAdapterData.m2190() == null || offlineAdapterData.m2190().length <= 0) {
            return null;
        }
        C2098qr[] r2 = offlineAdapterData.m2190();
        for (C2098qr qrVar : r2) {
            if (C2093qn.m10093(qrVar) && qrVar.getType() == VideoType.EPISODE) {
                return qrVar.getProfileId();
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static OfflineAdapterData m2205(vM vMVar, String str, String str2) {
        if (str2 == null) {
            return null;
        }
        for (int i = 0; i < vMVar.mo4074(); i++) {
            OfflineAdapterData offlineAdapterData = (OfflineAdapterData) vMVar.mo4075(i);
            if (OfflineAdapterData.ViewType.SHOW.equals(offlineAdapterData.m2192().f3356) && C2093qn.m10093(offlineAdapterData.m2192().f3357) && offlineAdapterData.m2192().f3357.getId().equalsIgnoreCase(str) && str2.equals(m2202(offlineAdapterData))) {
                return offlineAdapterData;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼॱ  reason: contains not printable characters */
    private void m2193() {
        if (m14535()) {
            Intent intent = getActivity().getIntent();
            if (intent.hasExtra("title_id")) {
                this.f3366 = intent.getStringExtra("title_id");
            }
            if (intent.hasExtra("profile_id")) {
                this.f3367 = intent.getStringExtra("profile_id");
            }
            if (intent.hasExtra("playable_id")) {
                String stringExtra = intent.getStringExtra("playable_id");
                C2098qr r4 = C2093qn.m10096(stringExtra);
                if (!C2093qn.m10093(r4)) {
                    String str = "Video details not in realm, finish the activity : " + stringExtra;
                    C1283.m16865("OfflineFragment", str);
                    C1276.m16820().mo5725(str);
                    getActivity().finish();
                    return;
                } else if (r4.getType() == VideoType.EPISODE) {
                    this.f3366 = r4.getPlayable().getTopLevelId();
                    this.f3367 = r4.getProfileId();
                } else if (r4.getType() == VideoType.SHOW) {
                    C1283.m16865("OfflineFragment", "updateCurrentShowIdIfFound() found showId inside PLAYABLE_ID which should never happen - use TITLE_ID instead");
                    this.f3366 = stringExtra;
                    this.f3367 = r4.getProfileId();
                } else {
                    this.f3366 = stringExtra;
                }
            }
            if (m2212() && !intent.hasExtra("title_id") && !intent.hasExtra("playable_id")) {
                this.f3366 = null;
                this.f3367 = null;
                C1283.m16862("OfflineFragment", "Since there is no activity underneath, we are just transforming the UI of current OfflineActivity to show \"videos\" level");
            }
            String stringExtra2 = intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID);
            VideoType create = VideoType.create(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE));
            AbstractC1853hl r5 = m14536().m9832();
            NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(getActivity(), NetflixActivity.class);
            if (stringExtra2 != null && r5 != null) {
                boolean r7 = r5.mo7131();
                boolean r8 = ConnectivityUtils.m2955(netflixActivity);
                if (!ConnectivityUtils.m2964(netflixActivity)) {
                    vD.m11895(netflixActivity, stringExtra2, false).show();
                } else if (!r7 || r8) {
                    r5.mo7141(stringExtra2, create, (oX) intent.getParcelableExtra(NetflixActivity.EXTRA_PLAY_CONTEXT));
                } else {
                    vD.m11894(netflixActivity, stringExtra2, create, false).show();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2207(String str, int i) {
        vO.m12025(getActivity(), str, this.f3362.mo11903(i), this.f3362.m11913(str));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2209(View view) {
        this.f3363 = (C0601) view.findViewById(R.id.empty_state_view);
        this.f3368 = (C0754) view.findViewById(R.id.find_more_button);
        this.f3365 = (RecyclerView) view.findViewById(R.id.list_view_offline_playables);
        this.f3361 = new LinearLayoutManager(this.f3365.getContext());
        this.f3365.setLayoutManager(this.f3361);
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private void m2197() {
        final boolean z = this.f3362 instanceof vL;
        AnonymousClass1 r4 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.offline.OfflineFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!OfflineFragment.this.m14535()) {
                    return;
                }
                if (z) {
                    qU.m9966(OfflineFragment.this.m14534(), VideoType.SHOW, OfflineFragment.this.f3366, "", qN.f9515, "");
                } else {
                    vO.m12014(OfflineFragment.this.m14534());
                }
            }
        };
        if (this.f3368 != null) {
            if (z) {
                this.f3368.setText(getResources().getString(R.string.offline_action_more_episodes_to_download));
            } else {
                this.f3368.setText(getString(R.string.offline_action_more_to_download));
            }
            this.f3368.setOnClickListener(r4);
        }
        if (this.f3363 != null) {
            if (z) {
                this.f3363.setButtonText(getString(R.string.offline_action_more_episodes_to_download));
            } else {
                this.f3363.setButtonText(getString(R.string.offline_action_something_to_download_upper));
            }
            this.f3363.setButtonClickListener(r4);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f3369 != null) {
            this.f3369.mo7124(this);
        }
        if (this.f3364) {
            m2196();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (this.f3369 != null) {
            this.f3369.mo7135(this);
        }
        super.onPause();
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        C1283.m16854("OfflineFragment", "onManagerReady");
        if (status.mo301()) {
            C1283.m16865("OfflineFragment", "Manager status code not okay");
        } else {
            m2210();
        }
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˊ */
    public void mo2173(String str) {
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2185(String str, Status status) {
        m2196();
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m2196() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            C1276.m16820().mo5725("SPY-13205: Activity should not be null when calling OfflineFragment#updatePlayableList");
            return;
        }
        boolean z = !m2222();
        this.f3362.mo11908();
        if (z) {
            activity.invalidateOptionsMenu();
        }
        m2195();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽॱ  reason: contains not printable characters */
    private void m2195() {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        boolean z = false;
        if (this.f3362 instanceof vW) {
            z = ((vW) this.f3362).m12086();
        }
        int i = 0;
        if (this.f3362.getItemCount() == (z ? 1 : 0)) {
            if (!(!z || (findViewHolderForAdapterPosition = this.f3365.findViewHolderForAdapterPosition(0)) == null || findViewHolderForAdapterPosition.itemView == null)) {
                i = findViewHolderForAdapterPosition.itemView.getMeasuredHeight();
            }
            this.f3363.setVisibility(0);
            this.f3365.setVisibility(0);
            this.f3368.setVisibility(8);
        } else {
            this.f3363.setVisibility(8);
            this.f3368.setVisibility(0);
            this.f3365.setVisibility(0);
        }
        C1004.m15952(this.f3363, 1, i);
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2181(pV pVVar, int i) {
        String r3 = pVVar.mo6915();
        C1283.m16862("OfflineFragment", "onOfflinePlayableProgress playableId=" + r3 + " percentageDownloaded=" + i);
        int findFirstVisibleItemPosition = this.f3361.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0) {
            int findLastVisibleItemPosition = this.f3361.findLastVisibleItemPosition();
            for (int i2 = findFirstVisibleItemPosition; i2 <= findLastVisibleItemPosition; i2++) {
                if (this.f3362.mo11902(i2, r3)) {
                    this.f3365.getAdapter().notifyItemChanged(i2, Payload.All);
                    return;
                }
            }
        }
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˊ */
    public void mo2174(pV pVVar) {
        m2196();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2175(pV pVVar) {
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2177(pV pVVar, StopReason stopReason) {
        m2196();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2180(String str, Status status, boolean z) {
        m2196();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˎ */
    public void mo2178(List<String> list, Status status) {
        m2196();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo1758(Status status) {
        m2196();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2184(Status status) {
        m2196();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2176(pV pVVar, Status status) {
        m2196();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˎ */
    public void mo2179(pV pVVar, Status status) {
        m2196();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2182(boolean z) {
        NetflixActivity r2 = m14534();
        if (!C1317As.m3750(r2)) {
            C1004.m15958(r2, (int) R.string.offline_message_offline_storage_change_in_progress, 1);
            if (z) {
                m2196();
            } else {
                r2.finish();
            }
        }
    }

    @Override // o.AbstractC1854hm
    public boolean aa_() {
        return C1317As.m3750(m14534());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f3364 = false;
    }

    @Override // o.AbstractC0517
    public boolean af_() {
        if (this.f3362 == null) {
            return false;
        }
        this.f3362.m11899();
        return true;
    }

    @Override // o.AbstractC0517
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2213(View view) {
        C1004.m15959(view, 1, this.f13649 + this.f13651);
        C1004.m15959(view, 3, this.f13650);
    }
}
