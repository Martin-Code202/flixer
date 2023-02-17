package o;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import o.AU;
import o.BQ;
import o.C0824;
import o.iQ;
import o.uU;
public abstract class uQ {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final C1351Bx f10869 = new C1351Bx();

    /* renamed from: ʹ  reason: contains not printable characters */
    private final View.OnClickListener f10870 = new View.OnClickListener() { // from class: o.uQ.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            uQ.this.m11596("stop pressed");
            uQ.this.m11637(false);
            uQ.this.f10887.mo11530();
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    private TextView f10871;

    /* renamed from: ʻˊ  reason: contains not printable characters */
    private final ViewTreeObserver.OnGlobalLayoutListener f10872 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.uQ.10
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (uQ.this.f10881.getHeight() > 0) {
                Rect bounds = uQ.this.f10881.m15442().getBounds();
                int i = (bounds.right - bounds.left) / 2;
                C1283.m16846("MdxMiniPlayerViews", "Setting thumb offset: " + i);
                uQ.this.f10881.setThumbOffset(i);
                ViewUtils.m3009(uQ.this.f10881, this);
            }
        }
    };

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected View f10873;

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    private final View.OnClickListener f10874 = new View.OnClickListener() { // from class: o.uQ.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            uQ.this.f10913.displayDialog(AU.m3422(uQ.this.f10913, uQ.this.f10894));
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    protected float f10875;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    protected ImageView f10876;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final uU.If f10877;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private ImageView f10878;

    /* renamed from: ʾ  reason: contains not printable characters */
    protected ImageView f10879;

    /* renamed from: ʿ  reason: contains not printable characters */
    private ImageView f10880;

    /* renamed from: ˈ  reason: contains not printable characters */
    private C0824 f10881;

    /* renamed from: ˉ  reason: contains not printable characters */
    private TextView f10882;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private TextView f10883;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private C0628 f10884;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected final ViewGroup f10885;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private TextView f10886;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final uS f10887;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private ImageView f10888;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private ImageView f10889;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected int f10890;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private ImageView f10891;

    /* renamed from: ˌ  reason: contains not printable characters */
    private C0628 f10892;

    /* renamed from: ˍ  reason: contains not printable characters */
    private ImageView f10893;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AU.If f10894;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private C0628 f10895;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private boolean f10896 = true;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f10897;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private C0628 f10898;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private View f10899;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected View f10900;

    /* renamed from: ˑ  reason: contains not printable characters */
    private List<View> f10901;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected int f10902;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private C0754 f10903;

    /* renamed from: ـ  reason: contains not printable characters */
    private String f10904;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Interpolator f10905 = new AccelerateDecelerateInterpolator();

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private TextView f10906;

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private final View f10907;

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private boolean f10908 = false;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected View f10909;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected TextView f10910;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected View f10911;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private TextView f10912;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected final NetflixActivity f10913;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected View f10914;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private uM f10915;

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private final View f10916;

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private final C0824.AbstractC0825 f10917 = new C0824.AbstractC0825() { // from class: o.uQ.7

        /* renamed from: ॱ  reason: contains not printable characters */
        private long f10944;

        @Override // o.C0824.AbstractC0825
        /* renamed from: ˋ */
        public void mo11523(SeekBar seekBar) {
            C1283.m16846("MdxMiniPlayerViews", "onStartTrackingTouch");
            uQ.this.f10887.mo11523(seekBar);
            if (uQ.this.f10883 != null) {
                uQ.this.f10883.setVisibility(4);
            }
            if (uQ.this.f10879 != null) {
                uQ.this.m11644(uQ.this.f10879);
            }
            if (uQ.this.f10882 != null) {
                uQ.this.m11644(uQ.this.f10882);
            }
            uQ.this.mo11553(true);
        }

        @Override // o.C0824.AbstractC0825
        /* renamed from: ˋ */
        public void mo11524(SeekBar seekBar, boolean z) {
            C1283.m16846("MdxMiniPlayerViews", "onStopTrackingTouch, isInSnapRegion: " + z);
            uQ.this.f10887.mo11524(seekBar, z);
            this.f10944 = 0;
            if (z) {
                uQ.this.m11600(seekBar.getProgress());
            } else {
                mo11532(seekBar, seekBar.getProgress(), true);
            }
            uQ.this.m11625();
            uQ.this.mo11553(false);
            if (!z) {
                uQ.this.m11637(false);
            }
        }

        @Override // o.C0824.AbstractC0825
        /* renamed from: ॱ */
        public void mo11532(SeekBar seekBar, int i, boolean z) {
            uQ.this.f10887.mo11532(seekBar, i, z);
            if (z && C1352By.m4136(System.nanoTime() - this.f10944) >= -1) {
                this.f10944 = System.nanoTime();
                if (uQ.this.f10879 != null && C1298Aa.m3504(uQ.this.f10887.mo11528())) {
                    iQ.iF.m7541(uQ.this.f10887.mo11531().mo6169(i * 1000), uQ.this.f10879);
                }
                uQ.this.m11600(i);
            }
        }
    };

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected TextView f10918;

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private float f10919;

    /* renamed from: ᐧ  reason: contains not printable characters */
    private final float f10920;

    /* renamed from: ᐨ  reason: contains not printable characters */
    private Boolean f10921 = null;

    /* renamed from: ᶥ  reason: contains not printable characters */
    private final View.OnClickListener f10922 = new View.OnClickListener() { // from class: o.uQ.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1283.m16846("MdxMiniPlayerViews", "Dummy click listener");
            if (uQ.this.f10881 != null) {
                uQ.this.f10881.invalidate();
            }
        }
    };

    /* renamed from: ㆍ  reason: contains not printable characters */
    private final View.OnClickListener f10923 = new View.OnClickListener() { // from class: o.uQ.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1283.m16846("MdxMiniPlayerViews", "resume pressed");
            uQ.this.m11637(false);
            uQ.this.f10887.mo11517();
        }
    };

    /* renamed from: ꓸ  reason: contains not printable characters */
    private final View.OnClickListener f10924 = new View.OnClickListener() { // from class: o.uQ.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1283.m16846("MdxMiniPlayerViews", "skip pressed");
            uQ.this.m11637(false);
            uQ.this.f10887.mo11533();
        }
    };

    /* renamed from: ꜞ  reason: contains not printable characters */
    private final View.OnClickListener f10925 = new View.OnClickListener() { // from class: o.uQ.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pT r6 = uQ.this.f10887.mo11522();
            if (r6 != null) {
                if (uQ.this.f10913 instanceof DetailsActivity) {
                    DetailsActivity detailsActivity = (DetailsActivity) uQ.this.f10913;
                    if (C1349Bv.m4126(r6.getId(), detailsActivity.m1634()) || C1349Bv.m4126(r6.getPlayable().getTopLevelId(), detailsActivity.m1634())) {
                        C1283.m16854("MdxMiniPlayerViews", "Current details are already being shown - not showing details activity");
                        uQ.this.f10913.notifyMdxShowDetailsRequest();
                        return;
                    }
                }
                if (r6.getType() == VideoType.EPISODE) {
                    C1283.m16846("MdxMiniPlayerViews", "showing details activity from episode for: " + r6);
                    qU.m9968(uQ.this.f10913, r6.getPlayable().getTopLevelId(), r6.getId(), new oB("MdxMiniPlayerViews"), (DetailsActivity.Action) null, (String) null);
                    return;
                }
                C1283.m16846("MdxMiniPlayerViews", "showing details activity for: " + r6);
                qU.m9974(uQ.this.f10913, r6, new oB("MdxMiniPlayerViews"), "MdxMiniPlayer");
            }
        }
    };

    /* renamed from: ꜟ  reason: contains not printable characters */
    private final View.OnClickListener f10926 = new View.OnClickListener() { // from class: o.uQ.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            uQ.this.m11596("pause pressed");
            uQ.this.f10887.mo11519();
            uQ.this.m11637(false);
        }
    };

    /* renamed from: ꞌ  reason: contains not printable characters */
    private final View.OnClickListener f10927 = new View.OnClickListener() { // from class: o.uQ.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1283.m16846("MdxMiniPlayerViews", "skip intro pressed");
            uQ.this.m11637(false);
            uQ.this.f10887.mo11534();
        }
    };

    /* renamed from: ﹳ  reason: contains not printable characters */
    private final View.OnClickListener f10928 = new View.OnClickListener() { // from class: o.uQ.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            uQ.this.f10887.mo11525();
        }
    };

    /* renamed from: ﾞ  reason: contains not printable characters */
    private final View.OnClickListener f10929 = new View.OnClickListener() { // from class: o.uQ.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C1317As.m3750(uQ.this.f10913)) {
                pT r3 = uQ.this.f10887.mo11522();
                if (r3 == null) {
                    C1283.m16865("MdxMiniPlayerViews", "currentVideo is null - can't show episodes");
                } else if (!(r3 instanceof pI)) {
                    C1283.m16865("MdxMiniPlayerViews", "currentVideo is not an episode detail");
                } else {
                    C1283.m16846("MdxMiniPlayerViews", "Showing episodes dialog");
                    C2116re r4 = C2116re.m10364(r3.getPlayable().getTopLevelId(), (String) null, false);
                    r4.onManagerReady(uQ.this.f10887.mo11528(), AbstractC0367.f13235);
                    r4.setCancelable(true);
                    uQ.this.f10913.showDialog(r4);
                }
            }
        }
    };

    /* renamed from: ﾟ  reason: contains not printable characters */
    private final View.OnClickListener f10930 = new View.OnClickListener() { // from class: o.uQ.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C1317As.m3750(uQ.this.f10913)) {
                uQ.this.m11596("Activity destroyed, can't show volume frag");
            } else if (!uQ.this.f10887.mo11518()) {
                C1283.m16865("MdxMiniPlayerViews", "Remote player is not ready - can't get/set volume");
            } else {
                qR r2 = qR.m9948();
                r2.setCancelable(true);
                uQ.this.f10913.showDialog(r2);
            }
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract int mo11551();

    /* renamed from: ॱ */
    public abstract int mo11555();

    public uQ(final NetflixActivity netflixActivity, uS uSVar, AU.If r6, uU.If r7) {
        m11596("Creating");
        this.f10897 = netflixActivity.getClass().getSimpleName();
        this.f10913 = netflixActivity;
        this.f10887 = uSVar;
        this.f10877 = r7;
        this.f10894 = r6;
        this.f10885 = (ViewGroup) netflixActivity.getLayoutInflater().inflate(mo11551(), (ViewGroup) null);
        mo11549();
        this.f10907 = netflixActivity.getBottomNavBar();
        this.f10916 = netflixActivity.getSlidingPanelPullView();
        this.f10920 = this.f10903 != null ? this.f10903.getTranslationY() : 0.0f;
        if (this.f10916 != null) {
            this.f10916.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.uQ.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (uQ.this.f10916.getY() != uQ.this.f10919 && uQ.this.f10916.getVisibility() == 0 && netflixActivity.isPanelCollapsed()) {
                        uQ.this.f10919 = uQ.this.f10916.getY();
                        uQ.this.m11591();
                    }
                }
            });
        }
        mo11550();
    }

    /* renamed from: ˋ */
    public void mo11550() {
        Resources resources = this.f10913.getResources();
        boolean r2 = AD.m3299();
        boolean r3 = AD.m3306(this.f10913);
        m11617();
        m11589();
        m11614();
        m11601(resources, r2);
        m11610(resources);
        m11612(r2, r3);
        m11615(r2);
        ViewUtils.m3035(this.f10885);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m11646() {
        return this.f10908;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m11617() {
        if (this.f10885 != null) {
            this.f10885.setOnClickListener(this.f10922);
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m11589() {
        if (this.f10911 != null) {
            this.f10911.getLayoutParams().width = m11616();
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m11615(boolean z) {
        List<View> list = null;
        if (z) {
            list = ViewUtils.m3034(this.f10885, Integer.valueOf((int) R.id.cast_player_collapsed_divider_0), Integer.valueOf((int) R.id.cast_player_collapsed_divider_1), Integer.valueOf((int) R.id.cast_player_collapsed_divider_2), Integer.valueOf((int) R.id.cast_player_collapsed_divider_3));
            ViewUtils.m3013(list);
        } else {
            this.f10895 = null;
            this.f10898 = null;
            this.f10899 = null;
        }
        if (this.f10895 != null) {
            m11598(this.f10895, R.string.icon_font_audio_subtitle, R.string.accesibility_btnLanguage, 18);
        }
        if (this.f10898 != null) {
            m11598(this.f10898, R.string.icon_font_episodes, R.string.accesibility_btnEpisodes, 20);
        }
        if (this.f10892 != null) {
            m11598(this.f10892, R.string.icon_font_skip_back_30, R.string.accesibility_btnSkipBack, 24);
        }
        this.f10901 = new ArrayList();
        if (this.f10893 != null) {
            this.f10901.add(this.f10893);
        }
        if (this.f10892 != null) {
            this.f10901.add(this.f10892);
        }
        if (this.f10895 != null) {
            this.f10901.add(this.f10895);
        }
        if (this.f10898 != null) {
            this.f10901.add(this.f10898);
        }
        if (list != null) {
            this.f10901.addAll(list);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11612(boolean z, boolean z2) {
        if (z) {
            int min = Math.min(C1004.m15954(this.f10913, 600), AD.m3317(this.f10913));
            this.f10900.getLayoutParams().width = min;
            this.f10909.getLayoutParams().width = min;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11610(Resources resources) {
        this.f10890 = (int) (((float) (resources.getDimensionPixelOffset(R.dimen.cast_player_expanded_content_height) - resources.getDimensionPixelOffset(R.dimen.cast_player_height))) * 0.75f);
        this.f10902 = C1004.m15954(this.f10913, 2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11601(Resources resources, boolean z) {
        if (this.f10881 != null) {
            this.f10881.setSnappableOnSeekBarChangeListener(this.f10917);
            this.f10881.getViewTreeObserver().addOnGlobalLayoutListener(this.f10872);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.cast_player_seek_bar_time_view_margin);
            this.f10881.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            if (z) {
                this.f10881.setScrubberDentBitmap(R.drawable.cast_player_seek_bar_dent);
                this.f10881.setShouldSnapToTouchStartPosition(true);
            }
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m11614() {
        if (this.f10876 != null) {
            this.f10876.setRotation(180.0f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo11549() {
        this.f10873 = this.f10885.findViewById(R.id.cast_player_title_group);
        this.f10918 = (TextView) this.f10885.findViewById(R.id.cast_player_text_title);
        this.f10910 = (TextView) this.f10885.findViewById(R.id.cast_player_text_subtitle);
        this.f10906 = (TextView) this.f10885.findViewById(R.id.cast_player_text_title_expanded);
        this.f10912 = (TextView) this.f10885.findViewById(R.id.cast_player_text_subtitle_expanded);
        this.f10911 = this.f10885.findViewById(R.id.cast_player_text_group);
        this.f10876 = (ImageView) this.f10885.findViewById(R.id.cast_player_text_group_caret);
        this.f10882 = (TextView) this.f10885.findViewById(R.id.cast_player_bif_seek_time);
        this.f10879 = (ImageView) this.f10885.findViewById(R.id.cast_player_bif_view);
        this.f10914 = this.f10885.findViewById(R.id.cast_player_device_name_group);
        this.f10909 = this.f10885.findViewById(R.id.cast_player_playcard_controls_group);
        this.f10891 = (ImageView) this.f10885.findViewById(R.id.cast_player_play_pause_btn_expanded);
        this.f10884 = (C0628) this.f10885.findViewById(R.id.cast_player_skip_back_btn_expanded);
        this.f10880 = (ImageView) this.f10885.findViewById(R.id.cast_player_stop_btn);
        this.f10900 = this.f10885.findViewById(R.id.cast_player_aux_controls);
        this.f10888 = (ImageView) this.f10885.findViewById(R.id.cast_player_language_btn_expanded);
        this.f10889 = (ImageView) this.f10885.findViewById(R.id.cast_player_episodes_btn_expanded);
        this.f10878 = (ImageView) this.f10885.findViewById(R.id.cast_player_volume_btn);
        this.f10883 = (TextView) this.f10885.findViewById(R.id.cast_player_seek_bar_current_time);
        this.f10886 = (TextView) this.f10885.findViewById(R.id.cast_player_seek_bar_remaining_time);
        this.f10881 = (C0824) this.f10885.findViewById(R.id.mdx_mini_player_seek_bar);
        this.f10895 = (C0628) this.f10885.findViewById(R.id.cast_player_collapsed_button_0);
        this.f10898 = (C0628) this.f10885.findViewById(R.id.cast_player_collapsed_button_1);
        this.f10892 = (C0628) this.f10885.findViewById(R.id.cast_player_collapsed_button_2);
        this.f10899 = this.f10885.findViewById(R.id.cast_player_collapsed_divider_1);
        if (AD.m3292()) {
            this.f10892 = (C0628) this.f10885.findViewById(R.id.cast_player_collapsed_button_0);
        }
        this.f10903 = (C0754) this.f10885.findViewById(R.id.cast_player_skip_intro_btn);
        this.f10893 = (ImageView) this.f10885.findViewById(R.id.cast_player_collapsed_button_3);
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int m11616() {
        return AD.m3317(this.f10913) - ((this.f10913.getResources().getDimensionPixelSize(R.dimen.cast_player_action_button_width) + 1) * 4);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11598(C0628 r2, int i, int i2, int i3) {
        if (r2 != null) {
            r2.setContentDescription(this.f10913.getString(i2));
            r2.setText(i);
            r2.setTextSize((float) i3);
            r2.setVisibility(0);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11642(C2059ph phVar) {
        m11593();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m11618() {
        m11620();
        if (this.f10873 != null) {
            this.f10875 = this.f10873.getY();
        }
        m11619(this.f10887.mo11521());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m11620() {
        if (this.f10915 != null && this.f10887 != null) {
            C1283.m16854("MdxMiniPlayerViews", "updateMdxMenu");
            this.f10915.m11543();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11633(uM uMVar) {
        this.f10915 = uMVar;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public View m11647() {
        return this.f10885;
    }

    /* renamed from: ˏ */
    public View mo11554() {
        return this.f10911;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11624(boolean z) {
        m11632((String) null);
        String string = this.f10913.getString(R.string.label_loading_);
        if (this.f10918 != null) {
            this.f10918.setText(string);
        }
        if (this.f10871 != null) {
            this.f10871.setText(string);
        }
        m11637(z);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11637(boolean z) {
        m11596("Set controls enabled: " + z);
        this.f10885.setEnabled(z);
        if (this.f10881 != null) {
            this.f10881.setEnabled(z);
        }
        if (this.f10893 != null) {
            m11605(this.f10893, z);
        }
        if (this.f10891 != null) {
            m11605(this.f10891, z);
        }
        if (this.f10892 != null) {
            m11605(this.f10892, z);
        }
        if (this.f10884 != null) {
            m11605(this.f10884, z);
        }
        if (this.f10903 != null) {
            m11605(this.f10903, z);
        }
        if (this.f10895 != null) {
            m11605(this.f10895, z && this.f10887.mo11527());
        }
        if (this.f10888 != null) {
            m11605(this.f10888, z && this.f10887.mo11527());
        }
        if (this.f10898 != null) {
            m11605(this.f10898, z && this.f10887.mo11520());
        }
        if (this.f10889 != null) {
            m11605(this.f10889, z && this.f10887.mo11520());
        }
        if (this.f10914 != null) {
            m11605(this.f10914, z);
        }
        if (this.f10880 != null) {
            m11605(this.f10880, z);
        }
        if (this.f10878 != null) {
            m11605(this.f10878, z);
        }
        m11596(String.format("setControlsEnabled, enabled: %s", Boolean.valueOf(z)));
        if (this.f10915 != null) {
            this.f10915.m11544(m11629(z));
            if (this.f10887 != null) {
                C1283.m16854("MdxMiniPlayerViews", "setControlsEnabled");
                this.f10915.m11543();
            }
        }
        m11619(this.f10887.mo11521());
        this.f10887.mo11526(z);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m11629(boolean z) {
        if (this.f10887.mo11529()) {
            C1283.m16854("MdxMiniPlayerViews", "mdx is playing remotely - mdx menu enabled: " + z);
            return z;
        }
        C1283.m16854("MdxMiniPlayerViews", "mdx is not playing remotely - mdx menu enabled");
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11643(boolean z) {
        this.f10896 = z;
        m11613();
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m11613() {
        boolean z = this.f10921 == null ? false : !this.f10921.booleanValue();
        if (this.f10898 != null) {
            this.f10898.setVisibility((!z || !this.f10896) ? 4 : 0);
        }
        if (this.f10899 != null) {
            this.f10899.setVisibility((!z || !this.f10896) ? 4 : 0);
        }
        if (this.f10889 != null) {
            this.f10889.setVisibility(this.f10896 ? 0 : 8);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m11623(boolean z) {
        if (this.f10895 != null) {
            m11605(this.f10895, z);
        }
        m11605(this.f10888, z);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11641(int i) {
        if (this.f10881 != null) {
            this.f10881.setMax(i);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public int m11622() {
        if (this.f10881 == null) {
            return 0;
        }
        return this.f10881.getProgress();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11631(int i) {
        if (this.f10881 != null) {
            this.f10881.setProgress(i);
            m11600(i);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m11648(boolean z) {
        if (this.f10878 != null) {
            this.f10878.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m11621(boolean z) {
        ImageView[] imageViewArr = this.f10893 != null ? new ImageView[]{this.f10893, this.f10891} : new ImageView[]{this.f10891};
        for (ImageView imageView : imageViewArr) {
            if (imageView != null) {
                imageView.setImageResource(z ? R.drawable.ic_play : R.drawable.ic_pause);
                imageView.setOnClickListener(z ? this.f10923 : this.f10926);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11628(boolean z, String str) {
        if (this.f10908 != z) {
            this.f10908 = z;
            this.f10904 = str;
            if (this.f10903 != null) {
                this.f10903.setVisibility(z ? 0 : 8);
                this.f10903.setText(str);
            }
            ViewGroup.LayoutParams layoutParams = this.f10873.getLayoutParams();
            if (this.f10908) {
                C1004.m15952(this.f10885, 3, this.f10885.getResources().getDimensionPixelOffset(R.dimen.cast_player_skip_intro_height));
            } else {
                C1004.m15952(this.f10885, 3, 0);
            }
            layoutParams.height = this.f10885.getResources().getDimensionPixelOffset(R.dimen.cast_player_title_height) + this.f10885.getPaddingBottom();
            this.f10873.requestLayout();
            if (this.f10877 != null) {
                this.f10877.mo284(layoutParams.height);
            }
            if (m11630()) {
                this.f10919 -= (float) this.f10885.getPaddingBottom();
            }
            m11591();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11627(String str) {
        if (this.f10918 != null) {
            this.f10918.setText(str);
        }
        if (this.f10906 != null) {
            this.f10906.setText(str);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11632(String str) {
        boolean r2 = C1349Bv.m4107(str);
        if (this.f10910 != null) {
            this.f10910.setText(str);
            this.f10910.setVisibility(r2 ? 0 : 8);
        }
        if (this.f10912 != null) {
            this.f10912.setText(str);
            this.f10912.setVisibility(r2 ? 0 : 8);
        }
        if (this.f10876 != null) {
            ((ViewGroup.MarginLayoutParams) this.f10876.getLayoutParams()).bottomMargin = C1004.m15954(this.f10913, r2 ? 1 : 5);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11636(String str) {
        if (this.f10871 != null) {
            this.f10871.setText(str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11600(int i) {
        String r2 = f10869.m4134(i);
        if (this.f10883 != null) {
            this.f10883.setText(r2);
        }
        if (this.f10882 != null) {
            this.f10882.setText(r2);
        }
        if (this.f10881 != null) {
            String r3 = f10869.m4134(this.f10881.getMax() - i);
            if (this.f10886 != null) {
                this.f10886.setText(r3);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11626(float f) {
        mo11552(f);
        m11595(f);
        m11591();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m11640() {
        C1283.m16846("MdxMiniPlayerViews", "onPanelExpanded()");
        m11619(true);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m11645() {
        C1283.m16846("MdxMiniPlayerViews", "onPanelCollapsed()");
        m11625();
        mo11553(false);
        m11619(false);
        m11613();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m11639() {
        if (this.f10915 != null) {
            this.f10915.m11544(true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m11625() {
        if (this.f10883 != null) {
            m11644(this.f10883);
        }
        if (this.f10879 != null) {
            m11634(this.f10879);
        }
        if (this.f10882 != null) {
            m11634(this.f10882);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11595(float f) {
        float f2 = f * f;
        for (View view : this.f10901) {
            if (view != null) {
                view.setAlpha(f2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼॱ  reason: contains not printable characters */
    private void m11591() {
        if (this.f10903 != null && this.f10916 != null) {
            float f = 0.0f;
            if (this.f10907 != null) {
                f = this.f10907.getTranslationY();
            }
            this.f10903.setTranslationY(this.f10920 + (this.f10919 - this.f10916.getY()) + f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m11619(boolean z) {
        if (this.f10921 == null) {
            this.f10921 = Boolean.valueOf(!z);
        }
        if (this.f10921.booleanValue() == z) {
            C1283.m16846("MdxMiniPlayerViews", "Views already updated for panel expansion - skipping");
            return;
        }
        this.f10921 = Boolean.valueOf(z);
        C1283.m16846("MdxMiniPlayerViews", "Updating views for panel expansion, expanded: " + this.f10921);
        if (this.f10921.booleanValue()) {
            m11611(this.f10901);
            m11628(this.f10908, this.f10904);
            m11635(0);
            return;
        }
        m11606(this.f10901);
        m11628(this.f10908, this.f10904);
        m11635(180);
        m11613();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean m11630() {
        return this.f10921 != null && this.f10921.booleanValue();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11635(int i) {
        if (this.f10876 != null) {
            this.f10876.animate().rotation((float) i).setDuration(200).setInterpolator(this.f10905).start();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public void mo11552(float f) {
        if (this.f10911 != null) {
            float f2 = 1.0f - f;
            this.f10911.setY(this.f10875 + (((float) this.f10890) * f2));
            int i = (int) (((float) this.f10902) * f2);
            if (this.f10918 != null) {
                this.f10918.setPadding(this.f10918.getPaddingLeft(), i, this.f10918.getPaddingRight(), i);
            }
        }
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private void m11593() {
        if (this.f10880 != null) {
            this.f10880.setOnClickListener(this.f10870);
        }
        if (this.f10892 != null) {
            this.f10892.setOnClickListener(this.f10924);
        }
        if (this.f10884 != null) {
            this.f10884.setOnClickListener(this.f10924);
        }
        if (this.f10903 != null) {
            this.f10903.setOnClickListener(this.f10927);
        }
        if (this.f10898 != null) {
            this.f10898.setOnClickListener(this.f10929);
        }
        if (this.f10889 != null) {
            this.f10889.setOnClickListener(this.f10929);
        }
        if (this.f10895 != null) {
            this.f10895.setOnClickListener(this.f10928);
        }
        if (this.f10888 != null) {
            this.f10888.setOnClickListener(this.f10928);
        }
        if (this.f10914 != null) {
            this.f10914.setOnClickListener(this.f10874);
        }
        if (this.f10878 != null) {
            this.f10878.setOnClickListener(this.f10930);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11605(View view, boolean z) {
        if (view != null) {
            view.setEnabled(z);
            view.clearAnimation();
            view.setAlpha(z ? 1.0f : 0.4f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public void mo11553(boolean z) {
        if (z) {
            m11638(this.f10900, this.f10909);
            if (this.f10914 != null) {
                m11634(this.f10914);
                return;
            }
            return;
        }
        m11644(this.f10900, this.f10909, this.f10914);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11644(View... viewArr) {
        m11606(Arrays.asList(viewArr));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11606(Collection<View> collection) {
        for (View view : collection) {
            if (view != null) {
                view.clearAnimation();
                view.animate().alpha(1.0f).setDuration(100).setListener(null).start();
                view.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11638(View... viewArr) {
        m11597(Arrays.asList(viewArr), 0.0f);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11597(Collection<View> collection, float f) {
        for (View view : collection) {
            if (view != null) {
                view.clearAnimation();
                view.animate().alpha(f).setDuration(100).setListener(null).start();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11634(View... viewArr) {
        m11611(Arrays.asList(viewArr));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11611(Collection<View> collection) {
        for (View view : collection) {
            if (view != null) {
                view.clearAnimation();
                view.animate().alpha(0.0f).setDuration(100).setListener(new BQ.C0069(view)).start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11596(String str) {
    }
}
