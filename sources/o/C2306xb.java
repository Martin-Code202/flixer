package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.TextView;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.util.ViewUtils;
import o.C2275wq;
import o.DialogC2233vc;
import o.qI;
/* renamed from: o.xb  reason: case insensitive filesystem */
public class C2306xb extends wF {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C2275wq f12117;

    /* renamed from: ʼ  reason: contains not printable characters */
    private MenuItem f12118;

    /* renamed from: ʽ  reason: contains not printable characters */
    private View f12119;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected qI f12120;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f12121;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected MenuItem f12122;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private MenuItem f12123;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected uW f12124;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final C2275wq.C0256 f12125;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private MenuItem f12126;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f12127;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected TextView f12128;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private ViewPropertyAnimator f12129;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final View.OnClickListener f12130 = new View.OnClickListener() { // from class: o.xb.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2306xb.this.f11438.m14534().performUpAction();
            C2306xb.this.f11438.mo2248();
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private ActionBar f12131;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Toolbar f12132;

    public C2306xb(PlayerFragment playerFragment, C2275wq.C0256 r3) {
        super(playerFragment);
        this.f12125 = r3;
        mo12889(playerFragment);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12889(PlayerFragment playerFragment) {
        this.f12131 = playerFragment.m14534().getSupportActionBar();
        if (this.f12131 != null) {
            this.f12131.setTitle("");
        }
        this.f12128 = (TextView) playerFragment.getView().findViewById(R.id.label_title);
        this.f12119 = playerFragment.getView().findViewById(R.id.top_gradient);
        this.f12132 = (Toolbar) playerFragment.getView().findViewById(R.id.top_panel_toolbar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12886(Menu menu) {
        this.f12117 = this.f11438.mo2226();
        mo12904(menu);
        mo12897(menu);
        mo12896();
        mo12901(menu);
        m12893(menu);
        mo12888(menu);
        int i = Build.VERSION.SDK_INT;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m12899(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                this.f12130.onClick(null);
                return true;
            default:
                C1283.m16850("screen", "Unhandled menu action: " + ((Object) menuItem.getTitle()));
                return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12888(Menu menu) {
        this.f12118 = menu.add(R.string.accesibility_volume);
        this.f12118.setIcon(R.drawable.ic_volume);
        this.f12118.setShowAsAction(2);
        this.f12118.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.xb.6
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                ((AudioManager) C2306xb.this.f11438.getActivity().getSystemService("audio")).adjustStreamVolume(3, 0, 1);
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12896() {
        this.f12131.setDisplayHomeAsUpEnabled(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12893(Menu menu) {
        this.f12120 = qI.m9894(this.f11438.m14534(), this.f11438.m14534().isTablet(), new qI.AbstractC0168() { // from class: o.xb.9
            @Override // o.qI.AbstractC0168
            /* renamed from: ˊ */
            public void mo2532() {
                C1283.m16854("screen", "User canceled selection");
                C2306xb.this.f11438.mo2247();
                C2306xb.this.f11438.m2482();
                C2306xb.this.f11438.m14534().reportPresentationSessionCanceled(AppView.audioSubtitlesSelector);
            }

            @Override // o.qI.AbstractC0168
            /* renamed from: ˏ */
            public void mo2533(Dialog dialog) {
                C2306xb.this.f11438.m14534().updateVisibleDialog(dialog);
            }

            @Override // o.qI.AbstractC0168
            /* renamed from: ˏ */
            public void mo2534(Language language, boolean z) {
                C1283.m16854("screen", "Language changed");
                C2306xb.this.m12894(language);
                C2306xb.this.f11438.m14534().reportPresentationSessionEnded(AppView.audioSubtitlesSelector);
            }

            @Override // o.qI.AbstractC0168
            /* renamed from: ॱ */
            public boolean mo2535() {
                return C2306xb.this.f11438.mo2454();
            }
        });
        this.f12123 = menu.add(R.string.accesibility_btnLanguage);
        this.f12123.setVisible(m12882());
        this.f12123.setIcon(R.drawable.ic_subsdubs_loc);
        this.f12123.setShowAsAction(2);
        this.f12123.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.xb.7
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                C1283.m16854("screen", "Display language dialog");
                C2306xb.this.m12883();
                C2306xb.this.f12120.m9898(C2306xb.this.f11438.m2501());
                C2306xb.this.f11438.m2481();
                C2306xb.this.f11438.m14534().reportPresentationSessionStart(AppView.audioSubtitlesSelector);
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo12901(Menu menu) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12897(Menu menu) {
        this.f12126 = menu.add(R.string.accesibility_btnEpisodes);
        this.f12126.setVisible(this.f12127);
        this.f12126.setIcon(R.drawable.ic_episodes);
        this.f12126.setShowAsAction(2);
        this.f12126.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.xb.8
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                C2306xb.this.f12125.f11690.onClick(null);
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo12904(Menu menu) {
        this.f12122 = menu.add(R.string.accesibility_btnMdxTarget);
        this.f12122.setIcon(R.drawable.mr_button_dark);
        this.f12122.setVisible(this.f12121);
        this.f12122.setShowAsAction(2);
        this.f12122.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.xb.2
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (!C2306xb.this.f11438.m14535()) {
                    return true;
                }
                C2306xb.this.f11438.m2479();
                C2306xb.this.m12884();
                return true;
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void mo12902(uW uWVar) {
        this.f12124 = uWVar;
        boolean r2 = m12891();
        if (this.f12131 != null && this.f12131.isShowing()) {
            if (!this.f11438.m14535()) {
                C1283.m16865("screen", "Player activity was destroyed, do nothing");
            } else {
                ViewUtils.m3018(this.f12122, r2);
                this.f12121 = r2;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12884() {
        if (this.f12124 == null || this.f12124.m11664() == null || this.f12124.m11664().length < 2) {
            C1283.m16854("screen", "Non local targets are not available!");
        } else if (this.f11438.m14535()) {
            C1283.m16854("screen", "MDX target is reachable, display dialog");
            this.f11438.m14534().displayDialog(m12879(this.f11438));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private AlertDialog m12879(final PlayerFragment playerFragment) {
        C1362Ch.m4394("impression", IClientLogging.ModalView.castDeviceSelector, this.f12124.m11663());
        oM r4 = playerFragment.mo2500();
        final boolean r5 = r4 != null ? r4.mo892() : false;
        int r6 = this.f12124.m11659();
        this.f12124.m11662(r6);
        DialogC2233vc.C0245 r7 = new DialogC2233vc.C0245(playerFragment.getActivity());
        r7.setCancelable(false);
        r7.setTitle(R.string.label_localMdxTargetWatch);
        r7.m12128(this.f12124.m11661(playerFragment.getActivity()));
        r7.m12129(r6, String.format(playerFragment.getString(R.string.now_playing_title), m12877()));
        r7.m12130(new AdapterView.OnItemClickListener() { // from class: o.xb.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C1283.m16854("screen", "Mdx target clicked: item with id " + j + ", on position " + i);
                playerFragment.m14534().removeVisibleDialog();
                if (C2306xb.this.f12124 != null) {
                    C2306xb.this.f12124.m11662(i);
                    uZ r42 = C2306xb.this.f12124.m11665();
                    if (r42 == null) {
                        C1283.m16850("screen", "Target is NULL, this should NOT happen!");
                        if (r5) {
                            playerFragment.mo2247();
                        }
                    } else if (r42.m11679()) {
                        C1283.m16854("screen", "Target is local, same as cancel. Do nothing");
                        if (r5) {
                            playerFragment.mo2247();
                        }
                    } else if (AU.m3421(playerFragment.m14534().getServiceManager(), r42.m11680())) {
                        C1283.m16854("screen", "Remote target is available, start MDX playback, use local bookmark!");
                        playerFragment.m14534().getServiceManager().m9811().mo6180(r42.m11680());
                        pF r52 = playerFragment.mo2268();
                        oX r62 = playerFragment.mo1635();
                        VideoType r72 = playerFragment.m2460();
                        int i2 = 0;
                        if (playerFragment.mo2500() != null) {
                            i2 = (int) (playerFragment.mo2500().mo928() / 1000);
                        } else if (r52 != null) {
                            i2 = r52.getPlayableBookmarkPosition();
                        }
                        PlaybackLauncher.m1613(playerFragment.m14534(), r52, r72, r62, i2);
                        playerFragment.m14534().getServiceManager().m9811().mo6185();
                        playerFragment.m14534().finish();
                    } else {
                        C1283.m16865("screen", "Remote target is NOT available anymore, continue local plaback");
                        if (r5) {
                            playerFragment.mo2247();
                        }
                    }
                }
            }
        });
        r7.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: o.xb.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                C1283.m16854("screen", "Mdx::onCancel");
                playerFragment.mo2247();
            }
        });
        return r7.create();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m12891() {
        return m12880(this.f12124);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m12880(uW uWVar) {
        return (uWVar == null || uWVar.m11664() == null || uWVar.m11664().length <= 1) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12894(Language language) {
        boolean z;
        if (this.f11438.mo2226() != null) {
            C1355Ca.m4328(this.f11549, language);
            AudioSource selectedAudio = language.getSelectedAudio();
            Subtitle selectedSubtitle = language.getSelectedSubtitle();
            boolean z2 = false;
            if (selectedSubtitle == null) {
                C1283.m16854("screen", "Selected subtitle is NONE");
                z = false;
                z2 = true;
            } else {
                z = true;
            }
            this.f11438.mo2245().mo9033(z);
            if (selectedAudio.getNccpOrderNumber() != language.getCurrentNccpAudioIndex()) {
                z2 = true;
                C1283.m16854("screen", "Start change language, get awake clock");
            } else {
                C1283.m16854("screen", "No need to change audio.");
            }
            if (selectedSubtitle == null) {
                C1283.m16854("screen", "Subtitle is off");
                z2 = true;
            } else if (selectedSubtitle.getNccpOrderNumber() != language.getCurrentNccpSubtitleIndex()) {
                z2 = true;
            } else {
                C1283.m16854("screen", "No need to change subtitle.");
            }
            if (z2) {
                C1283.m16854("screen", "Reloading tracks");
                this.f11438.mo2511(language);
                return;
            }
            C1283.m16854("screen", "No need to switch tracks");
            this.f11438.mo2247();
            this.f11438.m2482();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12890(final String str) {
        if (this.f11438.m14535()) {
            this.f11438.mo2235(new Runnable() { // from class: o.xb.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C1349Bv.m4113(str)) {
                        C2306xb.this.f12128.setText("");
                    } else {
                        C2306xb.this.f12128.setText(C1349Bv.m4102(str));
                    }
                }
            });
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private String m12877() {
        if (this.f12128 == null) {
            return null;
        }
        return this.f12128.getText().toString();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void mo12898(boolean z) {
        m12384(this.f12123, z);
        m12384(this.f12126, z);
        m12384(this.f12122, z);
        m12384(this.f12118, z);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m12900() {
        mo12887(false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m12892() {
        mo12887(true);
    }

    @Override // o.wF
    /* renamed from: ॱॱ */
    public synchronized void mo12118() {
        if (this.f12126 != null) {
            this.f12126.setOnMenuItemClickListener(null);
        }
        if (this.f12128 != null) {
            this.f12128.setOnClickListener(null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo12887(boolean z) {
        if (z) {
            this.f12129 = BQ.m3916(this.f12132, z);
            m12881();
            if (m12882()) {
                ViewUtils.m3018(this.f12123, true);
            }
        } else {
            if (this.f12129 != null) {
                this.f12129.cancel();
            }
            ViewUtils.m3020((View) this.f12132, false);
            m12878();
        }
        m12903(z);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean m12882() {
        Language r1 = this.f11438.m2501();
        return (this.f12123 == null || r1 == null || !r1.isLanguageSwitchEnabled()) ? false : true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12895(boolean z) {
        this.f12127 = z;
        if (this.f12126 != null) {
            ViewUtils.m3018(this.f12126, z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public void m12883() {
        if (this.f11438.m14535()) {
            this.f11438.m2479();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12903(boolean z) {
        if (this.f12119 != null) {
            ViewUtils.m3002(this.f12119, !z);
            if (ViewUtils.m3023(this.f12119) != z) {
                BQ.m3916(this.f12119, z);
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m12878() {
        if (this.f12117 != null) {
            this.f12117.m12502();
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m12881() {
        if (this.f12117 != null) {
            this.f12117.m12516();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo12885(Configuration configuration) {
    }
}
