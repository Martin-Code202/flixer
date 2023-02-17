package o;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.Set;
import o.AbstractC0801;
import o.C2240vj;
import o.qI;
import o.uO;
import o.uU;
import o.uX;
public class uL extends AbstractC0517 implements uU {

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final C2199iF f10769 = new C2199iF();

    /* renamed from: ʻ  reason: contains not printable characters */
    private NetflixActivity f10770;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private long f10771;

    /* renamed from: ʼ  reason: contains not printable characters */
    private pT f10772;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private AbstractC0801 f10773;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C2240vj f10774;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private RecyclerView f10775;

    /* renamed from: ʾ  reason: contains not printable characters */
    private long f10776;

    /* renamed from: ʿ  reason: contains not printable characters */
    private GridLayoutManager f10777;

    /* renamed from: ˈ  reason: contains not printable characters */
    private int f10778;

    /* renamed from: ˉ  reason: contains not printable characters */
    private View f10779;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private TextView f10780;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private C0522 f10781;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f10782;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private uU.If f10783;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private int f10784 = -1;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private final C2240vj.Cif f10785 = new C2240vj.Cif() { // from class: o.uL.5
        @Override // o.C2240vj.Cif
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo11504() {
            uL.this.m11439("updateVideoMetadata");
            if (uL.this.m14536() != null) {
                oG r3 = uL.this.f10788.mo11531();
                pT r4 = r3.mo6183();
                if (uL.this.f10772 != null && AU.m3420(r3, uL.this.f10772.getPlayable().getPlayableId())) {
                    uL.this.m11439("Same video is already playing, doing nothing");
                } else if (r4 == null) {
                    C1283.m16865("CastPlayerHelper", "null video details provided by mdx agent");
                } else {
                    uL.this.m11439("Different video, updating to: " + r4.getTitle());
                    uL.this.m11461(r4);
                }
            }
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo11516(boolean z) {
            uL.this.m11439("onNetworkConnectivityChange connected=" + z);
            if (uL.this.f10795 != null && uL.this.f10770 != null && !z && uL.this.mo3431()) {
                uL.this.f10800 = false;
                uL.this.f10796 = true;
                uL.this.f10795.m11637(false);
                uL.this.f10770.notifyCastPlayerEndOfPlayback();
                uL.this.f10795.m11620();
            }
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo11509(C2240vj.C0247 r8) {
            C1348Bu.m4093();
            uL.this.f10796 = false;
            uL.f10769.f10812 = r8.f11347;
            uL.this.m11442(r8.f11344, r8.f11345, r8.f11351, r8.f11343, true);
            uL.this.f10795.m11637(!r8.f11348 && r8.f11344);
            m11503(r8);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m11503(C2240vj.C0247 r4) {
            if (!uL.this.f10798 && uL.f10769.f10813) {
                if (uL.this.f10774.m12156() >= 0) {
                    uL.this.m11439("Update video seekbar - pos: " + r4.f11349);
                    uL.this.f10795.m11631(r4.f11349);
                }
                if (r4.f11348 || r4.f11345) {
                    uL.this.m11464();
                } else if (!r4.f11345 && uL.this.mo11497()) {
                    uL.this.m11459((long) r4.f11349);
                }
            }
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo11513(boolean z) {
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo11508(int i, String str) {
            uL.this.f10796 = true;
            if (!uL.this.f10797) {
                uL.this.f10793.m9888(i, str);
            } else {
                uL.this.m11446();
            }
            if (m11502(i)) {
                uL.this.f10795.m11637(false);
                uL.this.f10795.m11639();
                uL.this.f10770.notifyCastPlayerEndOfPlayback();
            }
            uL.this.f10795.m11620();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean m11502(int i) {
            return i >= 100 && i < 300;
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo11510() {
            uL.this.f10796 = true;
            uL.this.f10795.m11637(false);
            if (uL.this.f10772 != null && !m11514()) {
                LocalBroadcastManager.getInstance(uL.this.getActivity()).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_END"));
            }
            uL.f10769.m11535();
            uL.this.f10772 = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m11514() {
            if (!(uL.this.f10772 instanceof pI) || C1349Bv.m4113(((pI) uL.this.f10772).mo4562())) {
                return false;
            }
            return true;
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo11505(C1702eO eOVar) {
            if (!C1317As.m3750(uL.this.f10770)) {
                if (eOVar == null) {
                    C1283.m16865("CastPlayerHelper", "Capabilities is null!");
                    uL.this.m11453(false);
                    return;
                }
                uL.this.m11453(eOVar.m6249());
            }
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo11512(Language language) {
            uL.this.m11466();
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo11511(int i) {
            if (!C1317As.m3750(uL.this.f10770)) {
                uL.this.m11439("updateDuration, " + i);
                if (i > 0) {
                    uL.this.f10795.m11641(i);
                } else {
                    C1283.m16865("CastPlayerHelper", "We received an invalid duration - ignoring");
                }
            }
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo11507() {
            uL.this.m11439("targetListChanged");
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo11506(C2232vb vbVar) {
            if (!C1317As.m3750(uL.this.f10770)) {
                C2237vg r2 = C2237vg.m12132(vbVar);
                r2.onManagerReady(uL.this.m14536(), AbstractC0367.f13235);
                r2.setCancelable(true);
                uL.this.f10770.showDialog(r2);
            }
        }

        @Override // o.C2240vj.Cif
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo11515() {
            if (!C1317As.m3750(uL.this.f10770)) {
                uL.this.f10770.removeVisibleDialog();
            }
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private uX f10786;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private int f10787 = -1;

    /* renamed from: ˌ  reason: contains not printable characters */
    private final uS f10788 = new uS() { // from class: o.uL.6

        /* renamed from: ˊ  reason: contains not printable characters */
        private long f10807;

        @Override // o.uS
        /* renamed from: ˋ  reason: contains not printable characters */
        public pT mo11522() {
            return uL.this.f10772;
        }

        @Override // o.uS
        /* renamed from: ˏ  reason: contains not printable characters */
        public C2059ph mo11528() {
            return uL.this.m14536();
        }

        @Override // o.uS
        /* renamed from: ॱ  reason: contains not printable characters */
        public oG mo11531() {
            return uL.this.m14536().m9811();
        }

        @Override // o.uS
        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean mo11520() {
            return uL.f10769.f10811;
        }

        @Override // o.uS
        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean mo11527() {
            Language r1 = uL.this.f10774 == null ? null : uL.this.f10774.m12166();
            return r1 != null && r1.isLanguageSwitchEnabled();
        }

        @Override // o.uS
        /* renamed from: ʼ  reason: contains not printable characters */
        public boolean mo11518() {
            return uL.this.f10774 != null;
        }

        @Override // o.C0824.AbstractC0825
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo11523(SeekBar seekBar) {
            C1283.m16846("CastPlayerHelper", "onStartTrackingTouch");
            uL.this.f10798 = true;
            this.f10807 = System.nanoTime();
            uL.this.m11464();
        }

        @Override // o.C0824.AbstractC0825
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo11524(SeekBar seekBar, boolean z) {
            C1283.m16846("CastPlayerHelper", "onStopTrackingTouch, pos: " + seekBar.getProgress());
            uL.this.f10798 = false;
            if (z) {
                int progress = seekBar.getProgress() + ((int) ((System.nanoTime() - this.f10807) / 1000000000));
                uL.this.f10795.m11631(progress);
                uL.this.m11459((long) progress);
                return;
            }
            C1283.m16846("CastPlayerHelper", "Seeking...");
            uL.this.f10795.m11637(false);
            uL.this.f10774.m12157(AU.m3427(seekBar));
        }

        @Override // o.C0824.AbstractC0825
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo11532(SeekBar seekBar, int i, boolean z) {
        }

        @Override // o.uS
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo11526(boolean z) {
            uL.f10769.f10813 = z;
        }

        @Override // o.uS
        /* renamed from: ʽ  reason: contains not printable characters */
        public void mo11519() {
            if (uL.this.f10774 != null) {
                uL.this.f10774.m12167();
            }
        }

        @Override // o.uS
        /* renamed from: ʻ  reason: contains not printable characters */
        public void mo11517() {
            if (uL.this.f10774 != null) {
                uL.this.f10774.m12153();
            }
        }

        @Override // o.uS
        /* renamed from: ॱॱ  reason: contains not printable characters */
        public void mo11533() {
            if (uL.this.f10774 != null) {
                uL.this.f10774.m12152();
                uL.this.m11464();
            }
        }

        @Override // o.uS
        /* renamed from: ᐝ  reason: contains not printable characters */
        public void mo11534() {
            if (uL.this.f10774 != null) {
                uL.this.f10774.m12169();
            }
        }

        @Override // o.uS
        /* renamed from: ͺ  reason: contains not printable characters */
        public void mo11530() {
            if (uL.this.f10774 != null) {
                uL.this.f10774.m12161(false);
            }
        }

        @Override // o.uS
        /* renamed from: ˋॱ  reason: contains not printable characters */
        public void mo11525() {
            if (uL.this.f10774 != null) {
                Language r3 = uL.this.f10774.m12166();
                uL.this.m11439("Displaying language dialog, language: " + r3);
                uL.this.f10794.m9898(r3);
            }
        }

        @Override // o.uS
        /* renamed from: ˏॱ  reason: contains not printable characters */
        public boolean mo11529() {
            return uL.this.mo3431();
        }

        @Override // o.uS
        /* renamed from: ˊॱ  reason: contains not printable characters */
        public boolean mo11521() {
            return uL.this.f10770.isPanelExpanded();
        }
    };

    /* renamed from: ˍ  reason: contains not printable characters */
    private final qI.AbstractC0168 f10789 = new qI.AbstractC0168() { // from class: o.uL.3
        @Override // o.qI.AbstractC0168
        /* renamed from: ˏ */
        public void mo2534(Language language, boolean z) {
            if (uL.this.f10774 != null) {
                C1355Ca.m4328(uL.this.getActivity(), language);
                uL.this.f10774.m12154(language);
                uL.this.f10774.m12168();
            }
            uL.this.m11466();
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ˏ */
        public void mo2533(Dialog dialog) {
            uL.this.m11439("Updating dialog");
            uL.this.f10770.updateVisibleDialog(dialog);
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ˊ */
        public void mo2532() {
            uL.this.m11439("User canceled selection");
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ॱ */
        public boolean mo2535() {
            return false;
        }
    };

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private final Runnable f10790 = new Runnable() { // from class: o.uL.4
        @Override // java.lang.Runnable
        public void run() {
            if (C1317As.m3750(uL.this.f10770) || uL.this.f10798) {
                uL.this.m11439("skipping seekbar update");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - uL.this.f10776;
            if (uL.this.f10776 > 0 && currentTimeMillis > 0) {
                uL.this.f10771 += currentTimeMillis;
                int i = ((int) uL.this.f10771) / 1000;
                uL.this.m11439("updateSeekBarRunnable, timelinePosInSeconds: " + i);
                uL.this.f10795.m11631(i);
            }
            uL.this.f10776 = System.currentTimeMillis();
            uL.this.f10799.postDelayed(uL.this.f10790, 1000);
        }
    };

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private final uX.Cif f10791 = new uX.Cif() { // from class: o.uL.10
        @Override // o.uX.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public int mo11500() {
            return uL.this.mo11482();
        }

        @Override // o.uX.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo11501(int i) {
            uL.f10769.f10812 = i;
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    int f10792 = 3;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private qG f10793;

    /* renamed from: ͺ  reason: contains not printable characters */
    private qI f10794;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private uQ f10795;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f10796;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean f10797;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f10798;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Handler f10799 = new Handler();

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean f10800;

    public interface If {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uL$iF  reason: case insensitive filesystem */
    public static class C2199iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        boolean f10809;

        /* renamed from: ˋ  reason: contains not printable characters */
        boolean f10810;

        /* renamed from: ˎ  reason: contains not printable characters */
        boolean f10811;

        /* renamed from: ˏ  reason: contains not printable characters */
        int f10812;

        /* renamed from: ॱ  reason: contains not printable characters */
        boolean f10813;

        private C2199iF() {
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m11535() {
            C1283.m16854("CastPlayerHelper", "resetting shared state");
            this.f10810 = false;
            this.f10813 = false;
            this.f10811 = false;
            this.f10809 = false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11486(boolean z) {
        this.f10800 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m11460(Context context) {
        context.sendBroadcast(new Intent("com.netflix.mediaclient.ui.mdx.NOTIFY_SHOW_AND_DISABLE_INTENT"));
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        this.f10782 = getActivity().getClass().getSimpleName();
        this.f10770 = (NetflixActivity) getActivity();
        m11439("onCreate()");
        if (bundle == null) {
            i = -1;
        } else {
            i = bundle.getInt("saved_position_seconds", -1);
        }
        this.f10778 = i;
        m11439("savedPositionSeconds: " + this.f10778);
        this.f10770.registerReceiverWithAutoUnregister(new BroadcastReceiver() { // from class: o.uL.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                uL.this.m11455();
            }
        }, "com.netflix.mediaclient.ui.mdx.NOTIFY_SHOW_AND_DISABLE_INTENT");
        this.f10786 = new uX(this.f10791);
        this.f10793 = new qG("CastPlayerHelper", this.f10770);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10795 = new uN(this.f10770, this.f10788, this, this.f10783);
        m11439("Updating to empty state, controls enabled: " + f10769.f10813);
        this.f10795.m11624(f10769.f10813);
        m11449(this.f10795.m11647());
        m11498();
        return this.f10795.m11647();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11449(View view) {
        this.f10775 = (RecyclerView) view.findViewById(R.id.cast_player_related_grid);
        this.f10780 = (TextView) view.findViewById(R.id.cast_player_related_grid_title);
        this.f10779 = view.findViewById(R.id.cast_player_related_grid_group);
        this.f10781 = (C0522) view.findViewById(R.id.cast_player_box_art);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m11498() {
        if (this.f10775 != null) {
            this.f10775.setFocusable(false);
            this.f10779.setVisibility(8);
            this.f10792 = AD.m3299() ? 4 : 3;
            m11494();
            m11495();
            m11447();
        }
    }

    /* renamed from: o.uL$ˊ  reason: contains not printable characters */
    class C0228 extends RelativeLayout implements uO.Cif<pJ> {
        public C0228(Context context) {
            super(context);
            LayoutInflater.from(getContext()).inflate(R.layout.memento_related, (ViewGroup) this, true);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo2123(final pJ pJVar, AbstractC2087qh qhVar, int i, boolean z, boolean z2) {
            C0522 r8 = (C0522) findViewById(R.id.memento_related_img);
            if (r8 != null) {
                NetflixActivity.getImageLoader(getContext()).mo3063(r8, m11537(pJVar), AssetType.boxArt, pJVar.getTitle(), BrowseExperience.m1769(), true, z ? 1 : 0);
                m11536();
                r8.setOnClickListener(new View.OnClickListener() { // from class: o.uL.ˊ.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        qU.m9973(uL.this.m14534(), pJVar.getType(), pJVar.getId(), pJVar.getTitle(), qN.f9503);
                    }
                });
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m11536() {
            getLayoutParams().width = uL.this.f10784;
            getLayoutParams().height = uL.this.f10787;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m11537(pJ pJVar) {
            return pJVar.getBoxshotUrl();
        }

        @Override // o.qK
        /* renamed from: ʼ */
        public oX mo1635() {
            return qN.f9503;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public void m11495() {
        this.f10773 = new qS(true, this.f10792, new AbstractC0801.Cif() { // from class: o.uL.1
            {
                m11499();
            }

            @Override // o.AbstractC0801.Cif
            /* renamed from: ˏ */
            public View mo4156(View view) {
                return new C0228(view.getContext());
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            private void m11499() {
                uL.this.f10784 = (((AD.m3317(uL.this.getActivity()) - uL.this.f10775.getPaddingLeft()) - uL.this.f10775.getPaddingRight()) - ((uL.this.f10792 + 1) * uL.this.getActivity().getResources().getDimensionPixelOffset(R.dimen.rdp_content_padding_half))) / uL.this.f10792;
                uL.this.f10787 = (int) (((float) uL.this.f10784) * 1.43f);
            }
        });
        this.f10775.setAdapter(this.f10773);
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private void m11447() {
        this.f10775.addItemDecoration(new AL(getActivity().getResources().getDimensionPixelOffset(R.dimen.rdp_content_padding_half), this.f10792));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m11494() {
        this.f10777 = new GridLayoutManager(getActivity(), this.f10792);
        this.f10775.setLayoutManager(this.f10777);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m11483() {
        ViewUtils.m3002(this.f10779, false);
    }

    @Override // o.AbstractC2123rl
    public boolean V_() {
        if (this.f10779.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(600);
            this.f10779.setVisibility(8);
            this.f10795.m11635(0);
            m14534().setSlidingEnabled(true);
            this.f10779.startAnimation(alphaAnimation);
            return true;
        }
        uP uPVar = (uP) getFragmentManager().findFragmentById(R.id.postplay_frag);
        if (uPVar == null || !uPVar.m11584()) {
            return false;
        }
        getActivity().sendBroadcast(new Intent("com.netflix.mediaclient.service.ACTION_CLOSE_CAST_PLAYER"));
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f10795.m11618();
    }

    @Override // o.uU
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void mo11488() {
        m11439("onResumeFragments");
        this.f10797 = false;
        if (m14536() == null) {
            m11456();
            return;
        }
        oG r1 = m14536().m9811();
        this.f10772 = r1 != null ? r1.mo6183() : null;
        if (this.f10772 == null || !f10769.f10810) {
            m11446();
        } else {
            m11470(false);
        }
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public synchronized void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("saved_position_seconds", this.f10795.m11622());
        this.f10797 = true;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f10774 != null) {
            this.f10774.m12163();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m11455() {
        m11470(true);
        m11464();
        this.f10795.m11637(false);
    }

    @Override // o.uU
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11491(uM uMVar) {
        this.f10795.m11633(uMVar);
    }

    @Override // o.uU
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11490(String str) {
        if (this.f10774 != null) {
            this.f10774.m12160(str);
        }
    }

    @Override // o.uU
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean mo11497() {
        return this.f10800;
    }

    @Override // o.AU.If
    /* renamed from: ॱˋ */
    public uW mo3434() {
        oG r4 = this.f10788.mo11531();
        return new uW(r4.mo6163(), r4.mo6171(), false);
    }

    @Override // o.AU.If
    /* renamed from: ᐝॱ */
    public C2240vj mo3437() {
        return this.f10774;
    }

    @Override // o.AU.If
    /* renamed from: ʻॱ */
    public long mo3429() {
        return this.f10771;
    }

    @Override // o.AU.If
    /* renamed from: ॱᐝ */
    public pF mo3436() {
        if (!mo3431() || this.f10772 == null) {
            return null;
        }
        return this.f10772.getPlayable();
    }

    @Override // o.AU.If, o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        return qN.f9503;
    }

    @Override // o.AU.If
    /* renamed from: ॱˎ */
    public boolean mo3435() {
        return false;
    }

    @Override // o.AU.If
    /* renamed from: ʽॱ */
    public boolean mo3431() {
        return this.f10800 && !this.f10796;
    }

    @Override // o.AU.If
    /* renamed from: ˈ */
    public void mo3433() {
        m11446();
    }

    @Override // o.AU.If
    /* renamed from: ʼॱ */
    public void mo3430() {
        this.f10795.m11637(false);
    }

    @Override // o.AU.If
    /* renamed from: ʾ */
    public VideoType mo3432() {
        if (!mo3431() || this.f10772 == null) {
            return null;
        }
        return this.f10772.getType();
    }

    @Override // o.uU
    /* renamed from: ʿ  reason: contains not printable characters */
    public boolean mo11479() {
        return this.f10795.m11629(f10769.f10813);
    }

    @Override // o.uU
    /* renamed from: ˉ  reason: contains not printable characters */
    public View mo11480() {
        return this.f10795.mo11554();
    }

    @Override // o.uU
    /* renamed from: ˋˊ  reason: contains not printable characters */
    public int mo11487() {
        return this.f10795.mo11555();
    }

    @Override // o.uU
    /* renamed from: ˊˋ  reason: contains not printable characters */
    public int mo11482() {
        return f10769.f10812;
    }

    @Override // o.uU
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo11485(int i) {
        f10769.f10812 = i;
        if (this.f10774 != null) {
            this.f10774.m12164(i);
        }
    }

    @Override // o.uU
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo11492(float f) {
        this.f10795.m11626(f);
    }

    @Override // o.uU
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public void mo11484() {
        this.f10795.m11640();
    }

    @Override // o.uU
    /* renamed from: ˊˊ  reason: contains not printable characters */
    public void mo11481() {
        this.f10795.m11645();
        if (this.f10796) {
            this.f10796 = false;
            m11446();
        }
        if (this.f10779 != null) {
            this.f10779.setVisibility(4);
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        C1348Bu.m4093();
        if (this.f10770 == null || C1317As.m3750(this.f10770)) {
            m11439("Activity is null or destroyed - bailing early");
            return;
        }
        m11489();
        m11439("manager ready");
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    public void m11489() {
        m11439("initMdxComponents()");
        oG r6 = this.f10788.mo11531();
        if (r6 != null) {
            pT r7 = r6.mo6183();
            if (r7 != null) {
                m11461(r7);
                this.f10795.m11637(f10769.f10813);
                m11442(f10769.f10810, r6.mo6167(), false, "", false);
            }
            this.f10774 = new C2240vj(this.f10770, this.f10785);
            if (mo11497()) {
                if (f10769.f10813) {
                    m11439("Controls are enabled & mini player is showing. Requesting subs and dubs...");
                    this.f10774.m12168();
                }
                m11439("Syncing with remote player...");
                this.f10774.m12159();
            }
        }
        this.f10794 = qI.m9894(this.f10770, AD.m3299(), this.f10789);
        this.f10795.m11642(m14536());
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        if (this.f10774 != null) {
            this.f10774.m12163();
            this.f10774 = null;
        }
        this.f10795.m11624(false);
        m11446();
    }

    @Override // o.qO.Cif
    /* renamed from: ˏ */
    public void mo2536(pI pIVar) {
        m11468();
        PlaybackLauncher.m1607(this.f10770, pIVar.getPlayable(), pIVar.getType(), mo1635());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private synchronized void m11446() {
        m11439("hideSelf()");
        f10769.f10810 = false;
        m11464();
        this.f10795.m11620();
        if (this.f10797 || C1317As.m3750(this.f10770) || (getFragmentManager() != null && getFragmentManager().isStateSaved())) {
            m11439("Frag is in BG - should just hide self on resume");
            return;
        }
        this.f10800 = false;
        m11456();
    }

    @SuppressLint({"CommitTransaction"})
    /* renamed from: ˎˏ  reason: contains not printable characters */
    private synchronized void m11456() {
        m11439("Hiding MDX Player frag (internal)");
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().hide(this).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        m11468();
        m11463();
        this.f10770.notifyCastPlayerHidden();
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m11468() {
        DialogFragment dialogFragment = this.f10770.getDialogFragment();
        if (dialogFragment instanceof If) {
            C1283.m16854("CastPlayerHelper", "MDX mini player dialog frag currently shown - hiding");
            dialogFragment.dismiss();
        }
        if (m14534().isDialogFragmentVisible()) {
            m14534().removeDialogFrag();
        }
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private void m11463() {
        if (this.f10770.getVisibleDialog() instanceof If) {
            C1283.m16854("CastPlayerHelper", "MDX dialog currently shown - hiding");
            this.f10770.removeVisibleDialog();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private synchronized void m11470(boolean z) {
        m11439("showSelf()");
        f10769.f10810 = true;
        if (this.f10797 || C1317As.m3750(this.f10770) || (getFragmentManager() != null && getFragmentManager().isStateSaved())) {
            m11439("Frag is in BG - should just show self on resume");
        } else if (this.f10772 == null) {
            m11439("currentVideo is null - show self failed");
        } else {
            this.f10795.m11620();
            this.f10800 = true;
            m11439("Showing MDX Player frag");
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.beginTransaction().show(this).commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();
                this.f10770.notifyCastPlayerShown(z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˑ  reason: contains not printable characters */
    private void m11466() {
        m11439("updateLanguage()");
        this.f10795.m11623(this.f10788.mo11527());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11459(long j) {
        if (!C1317As.m3750(this.f10770)) {
            this.f10799.removeCallbacks(this.f10790);
            this.f10771 = 1000 * j;
            this.f10776 = System.currentTimeMillis();
            this.f10799.postDelayed(this.f10790, 1000);
            m11439("Simulated position update +started+");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏˏ  reason: contains not printable characters */
    private void m11464() {
        if (!C1317As.m3750(this.f10770)) {
            this.f10799.removeCallbacks(this.f10790);
            m11439("Simulated position update -stopped-");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11442(boolean z, boolean z2, boolean z3, String str, boolean z4) {
        if (this.f10800 != z) {
            if (z) {
                m11470(z4);
                if (this.f10774 != null && this.f10800) {
                    this.f10774.m12159();
                }
            } else {
                m11446();
            }
        }
        if (C1349Bv.m4113(str)) {
            str = getString(R.string.label_skip_intro_button_mdx);
        }
        this.f10795.m11628(z3, str);
        this.f10795.m11621(z2);
        this.f10795.m11648(f10769.f10809);
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x015f: APUT  
      (r1v25 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x015a: INVOKE  (r2v5 java.lang.Integer) = (r2v4 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11461(pT pTVar) {
        int i;
        String str;
        this.f10772 = pTVar;
        this.f10781.setVisibility(0);
        NetflixActivity.getImageLoader(this.f10770).mo3057(this.f10781, this.f10772.getBoxshotUrl(), AssetType.boxArt, this.f10772.getTitle(), StaticImgConfig.DARK, true);
        int r7 = AD.m3317(getActivity()) / (AD.m3307(getActivity()) ? 3 : 2);
        this.f10781.getLayoutParams().width = r7;
        this.f10781.getLayoutParams().height = (int) (((float) r7) * 1.43f);
        m11439("Updating metadata: " + this.f10772 + ", hash: " + this.f10772.hashCode());
        if (this.f10772.getType() == VideoType.EPISODE) {
            this.f10795.m11627(this.f10772.getPlayable().getParentTitle());
            if (this.f10772.isEpisodeNumberHidden()) {
                str = this.f10770.getString(R.string.label_episodeTitleBasicQuoted, new Object[]{this.f10772.getTitle()});
            } else {
                str = this.f10770.getString(R.string.label_episodeTitle, new Object[]{this.f10772.getPlayable().getSeasonAbbrSeqLabel(), Integer.valueOf(this.f10772.getPlayable().getEpisodeNumber()), this.f10772.getTitle()});
            }
            this.f10795.m11632(str);
        } else {
            this.f10795.m11627(this.f10772.getTitle());
            this.f10795.m11632("");
        }
        this.f10795.m11636(C1298Aa.m3505(m14536()));
        this.f10795.m11643(this.f10772.getType() != VideoType.MOVIE);
        m11439("Setting seek bar max: " + this.f10772.getPlayable().getRuntime());
        this.f10795.m11641(this.f10772.getPlayable().getRuntime());
        Object[] objArr = new Object[3];
        if (this.f10774 == null) {
            i = 0;
        } else {
            i = this.f10774.m12156();
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.f10772.getPlayable().getPlayableBookmarkPosition());
        objArr[2] = Integer.valueOf(this.f10778);
        m11439(String.format("updating seek pos - remote pos: %d, playable bookmark pos: %d, saved pos: %d", objArr));
        int i2 = this.f10778;
        this.f10778 = -1;
        if (i2 <= 0) {
            i2 = this.f10774 == null ? 0 : this.f10774.m12156();
            if (i2 <= 0) {
                i2 = this.f10772.getPlayable().getPlayableBookmarkPosition();
            }
        }
        if (i2 > 0) {
            m11439("Setting seek progress: " + i2);
            this.f10795.m11631(i2);
        }
        if (this.f10772.getType() == VideoType.MOVIE) {
            m14536().m9764().mo9513(this.f10772.getId(), (String) null, new Cif());
        } else if (this.f10772.getType() == VideoType.EPISODE) {
            m14536().m9764().mo9503(((pI) this.f10772).mo4565(), (String) null, new Cif());
        }
        if (!this.f10800) {
            m11439("updateVideoMetadata showself");
            m11470(this.f10770.isPanelExpanded());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11434(Set<String> set) {
        uP uPVar = (uP) getFragmentManager().findFragmentById(R.id.postplay_frag);
        if (uPVar != null) {
            uPVar.m11586(this.f10772);
        }
        m11466();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11453(boolean z) {
        f10769.f10809 = z;
        this.f10795.m11648(z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11439(String str) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uL$if  reason: invalid class name */
    public class Cif extends oP {
        public Cif() {
            super("CastPlayerHelper");
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            super.onMovieDetailsFetched(pPVar, status);
            if (!status.mo301()) {
                uL.this.m11434(pPVar.getCharacterRoles());
                uL.f10769.f10811 = pPVar != null;
                uL.this.f10795.m11637(uL.f10769.f10813);
            }
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            super.onShowDetailsFetched(pRVar, status);
            if (!status.mo301() && pRVar != null) {
                uL.this.m11434(pRVar.getCharacterRoles());
                uL.f10769.f10811 = pRVar != null;
                uL.this.f10795.m11637(uL.f10769.f10813);
            }
        }
    }

    @Override // o.uU
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo11496(KeyEvent keyEvent) {
        return this.f10786.m11668(keyEvent, m14536(), this.f10774);
    }

    @Override // o.uU
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo11493(uU.If r1) {
        this.f10783 = r1;
    }
}
