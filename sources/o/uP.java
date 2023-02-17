package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import o.C1352By;
public class uP extends AbstractC0517 implements qK {

    /* renamed from: ʻ  reason: contains not printable characters */
    private TextView f10840;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private ViewGroup f10841;

    /* renamed from: ʼ  reason: contains not printable characters */
    private TextView f10842;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final BroadcastReceiver f10843 = new BroadcastReceiver() { // from class: o.uP.9
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!C1317As.m3750(uP.this.m14534()) && intent != null && uP.this.f10852 != null) {
                String action = intent.getAction();
                char c = 65535;
                switch (action.hashCode()) {
                    case -1571942370:
                        if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_HIDE")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1519756682:
                        if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_NEXT")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1890629848:
                        if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_END")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        uP.this.m11571(uP.this.f10852);
                        uP.this.m11575();
                        return;
                    case 1:
                        String stringExtra = intent.getStringExtra("id");
                        if (C1349Bv.m4107(stringExtra)) {
                            uP.this.m14534().getServiceManager().m9764().mo9484(stringExtra, null, new C0230("CastPlayerPostPlayFrag"));
                            return;
                        } else {
                            C1283.m16850("CastPlayerPostPlayFrag", "MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_NEXT id null");
                            return;
                        }
                    case 2:
                        uP.this.m11578();
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    private TextView f10844;

    /* renamed from: ˈ  reason: contains not printable characters */
    private ImageView f10845;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private ViewGroup f10846;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private ImageView f10847;

    /* renamed from: ˏ  reason: contains not printable characters */
    private TextView f10848;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private TextView f10849;

    /* renamed from: ͺ  reason: contains not printable characters */
    private ViewGroup f10850;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private ImageView f10851;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private pT f10852;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private ImageView f10853;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private TextView f10854;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1352By.C0072 f10855;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Button f10856;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private pI f10857;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1283.m16846("CastPlayerPostPlayFrag", "Creating new frag view...");
        View inflate = layoutInflater.inflate(R.layout.cast_player_post_play_frag, (ViewGroup) null, false);
        m11565(inflate);
        m11580();
        return inflate;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11565(View view) {
        this.f10848 = (TextView) view.findViewById(R.id.postplay_episode_title);
        this.f10844 = (TextView) view.findViewById(R.id.postplay_movie_title);
        this.f10842 = (TextView) view.findViewById(R.id.postplay_target_name);
        this.f10854 = (TextView) view.findViewById(R.id.post_play_countdown);
        this.f10840 = (TextView) view.findViewById(R.id.post_play_synopsis);
        this.f10856 = (Button) view.findViewById(R.id.postplay_play_btn);
        this.f10851 = (ImageView) view.findViewById(R.id.postplay_stop_btn);
        this.f10847 = (ImageView) view.findViewById(R.id.postplay_episodes_btn);
        this.f10849 = (TextView) view.findViewById(R.id.postplay_browse_btn);
        this.f10850 = (ViewGroup) view.findViewById(R.id.postplay_with_rating_container);
        this.f10846 = (ViewGroup) view.findViewById(R.id.postplay_next_container);
        this.f10841 = (ViewGroup) view.findViewById(R.id.postplay_thumbs_rating);
        this.f10853 = (ImageView) view.findViewById(R.id.postplay_thumbs_up);
        this.f10845 = (ImageView) view.findViewById(R.id.postplay_thumbs_down);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m11576() {
        C2059ph serviceManager;
        if (this.f10842 != null && (serviceManager = m14534().getServiceManager()) != null && C1298Aa.m3504(serviceManager)) {
            String r5 = C1298Aa.m3505(serviceManager);
            if (!TextUtils.isEmpty(r5)) {
                this.f10842.setText(C1349Bv.m4102(getString(R.string.label_postplay_target_name_memento, String.valueOf(r5))));
            }
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m11568() {
        if (this.f10856 != null) {
            this.f10856.setOnClickListener(new View.OnClickListener() { // from class: o.uP.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    uP.this.m11583();
                }
            });
        }
        if (this.f10851 != null) {
            this.f10851.setOnClickListener(new View.OnClickListener() { // from class: o.uP.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    uP.this.m11585();
                }
            });
        }
        if (this.f10849 != null) {
            this.f10849.setOnClickListener(new View.OnClickListener() { // from class: o.uP.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    uP.this.getActivity().sendBroadcast(new Intent("com.netflix.mediaclient.service.ACTION_CLOSE_CAST_PLAYER"));
                }
            });
        }
        if (this.f10847 != null) {
            this.f10847.setOnClickListener(new View.OnClickListener() { // from class: o.uP.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C1283.m16846("CastPlayerPostPlayFrag", "Showing episodes dialog");
                    if (uP.this.f10852 == null) {
                        C1283.m16865("CastPlayerPostPlayFrag", "currentVideo is null - can't show episodes");
                        return;
                    }
                    C2116re r3 = C2116re.m10364(uP.this.f10852.getPlayable().getTopLevelId(), (String) null, false);
                    r3.onManagerReady(uP.this.m14534().getServiceManager(), AbstractC0367.f13235);
                    r3.setCancelable(true);
                    uP.this.m14534().showDialog(r3);
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11585() {
        if (getActivity() != null && !m14534().isFinishing() && m14534().getServiceManager() != null && C1298Aa.m3504(m14534().getServiceManager())) {
            m11556();
            m14534().sendIntentToNetflixService(m11563("com.netflix.mediaclient.intent.action.MDX_ACTION_STOP"));
            m11578();
            this.f10855.m4150();
            this.f10854.setVisibility(4);
            this.f10842.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m11578() {
        if (this.f10850 != null) {
            this.f10850.setVisibility(4);
        }
        if (this.f10846 != null) {
            this.f10846.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m11575() {
        if (this.f10850 != null) {
            this.f10850.setVisibility(0);
        }
        if (this.f10846 != null) {
            this.f10846.setVisibility(4);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m11587() {
        if (m14535()) {
            int r3 = this.f10855.m4146();
            if (this.f10854 != null) {
                this.f10854.setText(C1349Bv.m4102(C0403.m14185(getActivity(), R.string.label_postplay_nextEpisode).m14187(r3).m14188()));
                this.f10854.setVisibility(0);
                this.f10842.setVisibility(0);
            }
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean m11584() {
        return this.f10850.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m11582() {
        if (this.f10846 != null) {
            this.f10846.setVisibility(0);
            this.f10850.setVisibility(4);
            getActivity().sendBroadcast(new Intent("com.netflix.mediaclient.service.ACTION_EXPAND_CAST_PLAYER"));
        }
        if (this.f10855 != null) {
            this.f10855.m4148(getResources().getInteger(R.integer.postplay_mdx_memento_postplay_countdown));
            this.f10855.m4151();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Intent m11563(String str) {
        C2059ph serviceManager = m14534().getServiceManager();
        if (C1298Aa.m3504(serviceManager)) {
            return uT.m11652(m14534(), str, serviceManager.m9811().mo6171());
        }
        return null;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m11556() {
        C2059ph serviceManager = m14534().getServiceManager();
        if (serviceManager.m9811() instanceof C1698eK) {
            ((C1698eK) serviceManager.m9811()).m6182();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m11583() {
        if (this.f10857 != null) {
            uT.m11651(m14534(), this.f10857.getPlayable(), this.f10857.getType(), qN.f9499, -1, true);
            uL.m11460(getActivity());
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m11580() {
        m11576();
        m11568();
        m11560();
        m11559();
        m11579();
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m11579() {
        AnonymousClass2 r1 = new View.OnClickListener() { // from class: o.uP.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(view.getContext(), NetflixActivity.class);
                int trackId = qN.f9503.getTrackId();
                if (netflixActivity != null && netflixActivity.getServiceManager().mo9519()) {
                    if (view == uP.this.f10853) {
                        uP.this.m11570(netflixActivity, uP.this.f10852, trackId, view, view.isSelected() ? 0 : 2);
                    } else if (view == uP.this.f10845) {
                        uP.this.m11570(netflixActivity, uP.this.f10852, trackId, view, view.isSelected() ? 0 : 1);
                    }
                }
            }
        };
        this.f10853.setOnClickListener(r1);
        this.f10845.setOnClickListener(r1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11570(final NetflixActivity netflixActivity, pT pTVar, int i, final View view, int i2) {
        String str;
        VideoType videoType;
        C1362Ch.m4380(null, netflixActivity.getUiScreen().f4084);
        Long r12 = Logger.INSTANCE.m142(new C0784(C1131.m16285(i2)));
        this.f10853.setEnabled(false);
        this.f10845.setEnabled(false);
        if (!(pTVar instanceof pI) || !pTVar.getType().equals(VideoType.EPISODE)) {
            str = pTVar.getId();
            videoType = pTVar.getType();
        } else {
            str = ((pI) pTVar).mo4565();
            videoType = VideoType.SHOW;
        }
        netflixActivity.getServiceManager().m9764().mo9468(str, videoType, i2, i, new AbstractC2381zo("CastPlayerPostPlayFrag", this.f10852, r12) { // from class: o.uP.8
            /* access modifiers changed from: protected */
            @Override // o.AbstractC2381zo
            /* renamed from: ˋ */
            public void mo1706(pE pEVar) {
                if (!C1317As.m3750(netflixActivity)) {
                    view.setSelected(!view.isSelected());
                    if (view == uP.this.f10845) {
                        uP.this.f10853.setSelected(false);
                    } else if (view == uP.this.f10853) {
                        uP.this.f10845.setSelected(false);
                    }
                    uP.this.f10853.setEnabled(true);
                    uP.this.f10845.setEnabled(true);
                }
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2381zo
            /* renamed from: ˏ */
            public void mo1707(Status status) {
            }
        });
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m11559() {
        this.f10855 = new C1352By.C0072(m14534());
        this.f10855.m4149(new Runnable() { // from class: o.uP.10
            @Override // java.lang.Runnable
            public void run() {
                uP.this.m11587();
            }
        });
        this.f10855.m4148(getResources().getInteger(R.integer.postplay_mdx_memento_postplay_countdown));
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private void m11560() {
        m14534().registerReceiverLocallyWithAutoUnregister(this.f10843, "com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_END");
        m14534().registerReceiverLocallyWithAutoUnregister(this.f10843, "com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_NEXT");
        m14534().registerReceiverLocallyWithAutoUnregister(this.f10843, "com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_HIDE");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11561(pI pIVar) {
        String str;
        if (this.f10848 != null) {
            if (pIVar.isEpisodeNumberHidden()) {
                str = getResources().getString(R.string.label_episodeTitleBasicQuoted, this.f10857.getTitle());
            } else {
                str = getResources().getString(R.string.label_episodeTitleQuoted, this.f10857.getSeasonAbbrSeqLabel(), Integer.valueOf(this.f10857.getEpisodeNumber()), this.f10857.getTitle());
            }
            this.f10848.setText(str);
        }
        if (this.f10840 != null) {
            this.f10840.setText(pIVar.getSynopsis());
        }
        m11576();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11571(pT pTVar) {
        if (this.f10844 != null) {
            if (pTVar instanceof pI) {
                this.f10844.setText(((pI) pTVar).getPlayable().getParentTitle());
            } else {
                this.f10844.setText(pTVar.getTitle());
            }
        }
        switch (pTVar.getUserThumbRating()) {
            case 0:
                this.f10853.setSelected(false);
                this.f10845.setSelected(false);
                return;
            case 1:
                this.f10853.setSelected(false);
                this.f10845.setSelected(true);
                return;
            case 2:
                this.f10853.setSelected(true);
                this.f10845.setSelected(false);
                return;
            default:
                return;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11586(pT pTVar) {
        this.f10852 = pTVar;
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        return qN.f9503;
    }

    /* renamed from: o.uP$ˋ  reason: contains not printable characters */
    class C0230 extends oP {
        public C0230(String str) {
            super(str);
        }

        @Override // o.oP, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            super.onEpisodeDetailsFetched(pIVar, status);
            if (pIVar != null) {
                uP.this.f10857 = pIVar;
                uP.this.m11561(pIVar);
                uP.this.m11582();
            }
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            super.onMovieDetailsFetched(pPVar, status);
            if (pPVar != null) {
                uP.this.m11571(pPVar);
            }
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            super.onShowDetailsFetched(pRVar, status);
            if (pRVar != null) {
                uP.this.m11571(pRVar);
            }
        }

        @Override // o.oP, o.oU
        public void onPostPlayVideosFetched(pO pOVar, Status status) {
            super.onPostPlayVideosFetched(pOVar, status);
            if ((pOVar == null || pOVar.getPostPlayVideos() == null || pOVar.getPostPlayVideos().size() == 0) && uP.this.f10844 != null && uP.this.f10852 != null) {
                uP.this.m14534().getServiceManager().m9764().mo9503(uP.this.f10852.getPlayable().getTopLevelId(), (String) null, new C0230("CastPlayerPostPlayFrag"));
            }
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }
}
