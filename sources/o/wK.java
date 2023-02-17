package o;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.PostPlay;
import com.netflix.model.leafs.PostPlayItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
public class wK extends PostPlay {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected List<wR> f11473 = new ArrayList(5);

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final DecelerateInterpolator f11474 = new DecelerateInterpolator();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final AtomicBoolean f11475 = new AtomicBoolean(true);

    /* renamed from: ʾ  reason: contains not printable characters */
    private AbstractC2311xg f11476;

    /* renamed from: ʿ  reason: contains not printable characters */
    private List<wC> f11477 = new ArrayList(5);

    /* renamed from: ˈ  reason: contains not printable characters */
    private TextView f11478;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int f11479 = -1;

    public wK(IPlayerFragment iPlayerFragment) {
        super(iPlayerFragment);
        m12309();
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private void m12309() {
        if (this.f3618 == null) {
            C1283.m16850("nf_postplay", "init() - called with null PlayerFragment!");
        } else {
            this.f11476 = new C2315xk(this.f3618);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˎ */
    public boolean mo2577() {
        pF r1 = this.f3618 == null ? null : this.f3618.mo2268();
        boolean z = r1 != null && r1.isSupplementalVideo();
        if (this.f3621) {
            return !z && super.mo2577();
        }
        return super.mo2577();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ॱᐝ */
    public void mo2592() {
        if (this.f3620 == null || this.f3620.getItems().size() == 0) {
            C1283.m16850("nf_postplay", "We do not have any data! Do nothing!");
        } else if (this.f3616.isFinishing()) {
            C1283.m16850("nf_postplay", "Activity for playback is already not valid! Do nothing!");
        } else if (this.f3618 == null || !this.f3618.m2250()) {
            C1283.m16850("nf_postplay", "Player fragment is null, do nothing!");
        } else {
            LayoutInflater layoutInflater = this.f3616.getLayoutInflater();
            boolean r9 = this.f3616.getServiceManager().m9758();
            this.f3624.removeAllViews();
            this.f3609.removeAllViews();
            if (this.f11478 != null) {
                String str = "";
                if (this.f3620.getExperienceTitle().size() != 0 && this.f3620.getExperienceTitle().get(0).getDisplayText() != null) {
                    str = this.f3620.getExperienceTitle().get(0).getDisplayText();
                } else if ("recommendations".equals(this.f3620.getType())) {
                    str = this.f3616.getResources().getString(R.string.label_postplay_recommended);
                }
                this.f11478.setText(str);
                this.f11478.setVisibility(str.isEmpty() ? 8 : 0);
            }
            boolean z = this.f3620.getItems().size() > 1;
            boolean equals = TextUtils.equals(this.f3620.getType(), "nextEpisodeSeamless");
            mo12316();
            int i = z ? R.layout.post_play_background_metadata : R.layout.post_play_background;
            int i2 = 0;
            for (PostPlayItem postPlayItem : this.f3620.getItems()) {
                if (m2564(postPlayItem)) {
                    wC wCVar = (wC) layoutInflater.inflate(i, (ViewGroup) this.f3624, false);
                    this.f3624.addView(wCVar);
                    wCVar.mo12263(postPlayItem, this.f3616, this.f3618, PlayLocationType.POST_PLAY);
                    wCVar.getLayoutParams().width = AD.m3317(this.f3616);
                    this.f11477.add(wCVar);
                    mo12318(layoutInflater, postPlayItem, r9, z, equals, wCVar, i2);
                    i2++;
                }
            }
            if (!(!this.f3620.getAutoplay() || this.f3620.getAutoplaySeconds() <= 0 || r9 || this.f3618 == null || this.f3618.mo2265())) {
                m2575(PlayLocationType.POST_PLAY);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public void mo12316() {
        this.f3624.getLayoutParams().width = AD.m3317(this.f3616) * this.f3620.getItems().size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12318(LayoutInflater layoutInflater, PostPlayItem postPlayItem, boolean z, boolean z2, boolean z3, wC wCVar, int i) {
        int i2;
        if (z) {
            i2 = R.layout.post_play_item_signup;
        } else if (z3) {
            i2 = R.layout.post_play_item_seamless;
        } else if (z2) {
            i2 = R.layout.post_play_item_poster;
        } else {
            i2 = R.layout.post_play_item_metadata;
        }
        wR wRVar = (wR) layoutInflater.inflate(i2, (ViewGroup) this.f3609, false);
        m12319(wRVar, postPlayItem, wCVar, z, z2, i);
        this.f3609.addView(wRVar);
        this.f11473.add(wRVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12319(wR wRVar, PostPlayItem postPlayItem, wC wCVar, boolean z, boolean z2, int i) {
        if (z) {
            wRVar.mo12341(postPlayItem, this.f3616, this.f3618, PlayLocationType.POST_PLAY, new If(this.f3616));
        } else if (z2) {
            wRVar.mo12341(postPlayItem, this.f3616, this.f3618, PlayLocationType.POST_PLAY, new View$OnClickListenerC0250(i, wCVar));
        } else {
            if (postPlayItem.getPlayAction() == null || !TextUtils.equals(postPlayItem.getPlayAction().getName(), "playTrailer")) {
                wRVar.mo12341(postPlayItem, this.f3616, this.f3618, PlayLocationType.POST_PLAY, new wL(this.f3616, this.f3618, postPlayItem.getPlayAction(), PlayLocationType.POST_PLAY).m12330());
            } else {
                wRVar.mo12341(postPlayItem, this.f3616, this.f3618, PlayLocationType.POST_PLAY, null);
            }
            if (postPlayItem.getPlayAction() == null) {
                C1276.m16820().mo5725("Postplay play action is null " + postPlayItem.getVideoId());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class If implements View.OnClickListener {

        /* renamed from: ॱ  reason: contains not printable characters */
        NetflixActivity f11481;

        public If(NetflixActivity netflixActivity) {
            this.f11481 = netflixActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("nextUrl", "/getstarted");
            this.f11481.setResult(21, intent);
            this.f11481.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.wK$ˋ  reason: contains not printable characters */
    public class View$OnClickListenerC0250 implements View.OnClickListener {

        /* renamed from: ˋ  reason: contains not printable characters */
        wC f11483;

        /* renamed from: ˎ  reason: contains not printable characters */
        int f11484;

        public View$OnClickListenerC0250(int i, wC wCVar) {
            this.f11484 = i;
            this.f11483 = wCVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof wQ)) {
                C1276.m16820().mo5725("Listener should be attached to PostPlayItemBasic view, it was attached to " + view);
                return;
            }
            wQ wQVar = (wQ) view;
            if (wQVar.isSelected()) {
                wQVar.m12348();
                return;
            }
            for (int i = 0; i < wK.this.f3609.getChildCount(); i++) {
                if (wK.this.f3609.getChildAt(i) instanceof wQ) {
                    wQ wQVar2 = (wQ) wK.this.f3609.getChildAt(i);
                    if (wQVar != wK.this.f3609.getChildAt(i)) {
                        wQVar2.setSelected(false);
                    } else {
                        wK.this.f11479 = i;
                        wQVar2.setSelected(true);
                    }
                }
            }
            if (wK.this.f11475.getAndSet(false)) {
                C1283.m16854("nf_postplay", "Video was full size, scale down");
                wK.this.m12310();
            }
            wK.this.m12308(this.f11484, true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public int mo12317(int i) {
        return AD.m3317(this.f3616) * -1 * i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12308(int i, boolean z) {
        if (!this.f3616.isFinishing()) {
            int r4 = mo12317(BX.m3957() ? 4 - i : i);
            if (z) {
                this.f3624.animate().setDuration(250).x((float) r4).setInterpolator(this.f11474);
            } else {
                this.f3624.animate().cancel();
                this.f3624.setX((float) r4);
            }
            if (this.f3620.getItems().get(i) != null) {
                this.f11479 = i;
            } else {
                C1283.m16850("nf_postplay", "PostPlay not found for index " + i);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˉ  reason: contains not printable characters */
    public void m12315() {
        if (this.f11479 != -1) {
            m12308(this.f11479, false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˊॱ */
    public void mo2567() {
        if (!(this.f3619 == null || this.f3620 == null || !this.f3620.getAutoplay())) {
            this.f3619.m4150();
            for (wR wRVar : this.f11473) {
                wRVar.m12350();
            }
            for (wC wCVar : this.f11477) {
                wCVar.mo12262();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˋॱ */
    public void mo2572() {
        if (!(this.f3619 == null || this.f3620 == null || !this.f3620.getAutoplay())) {
            this.f3619.m4151();
            for (wR wRVar : this.f11473) {
                wRVar.m12349(this.f3619.m4146());
            }
            for (wC wCVar : this.f11477) {
                wCVar.mo12261();
            }
        }
        if (this.f3617) {
            C1283.m16854("nf_postplay", "Second time postplay");
            m12310();
            this.f11476.mo12928(false);
            return;
        }
        C1283.m16854("nf_postplay", "First time postplay");
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ॱ */
    public void mo2583(int i) {
        for (wR wRVar : this.f11473) {
            wRVar.mo12347(i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˍ  reason: contains not printable characters */
    private void m12310() {
        if (this.f11476.mo12927()) {
            mo2563(true);
        }
        this.f11476.mo12926();
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m12312() {
        this.f11476.mo12929(null);
        mo2563(false);
        this.f11475.set(false);
    }

    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˊ */
    public void mo2563(boolean z) {
        super.mo2563(z);
        if (z) {
            for (wC wCVar : this.f11477) {
                wCVar.mo12265();
            }
        }
    }

    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ॱˋ */
    public void mo2589() {
        super.mo2589();
        m12312();
    }

    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ʿ */
    public void mo2559() {
        super.mo2559();
        this.f11476.mo12928(false);
        if (this.f3620 != null) {
            mo2563(true);
            if ("recommendations".equals(this.f3620.getType())) {
                this.f11478.setVisibility(8);
                if (this.f3609.getChildCount() > 1 && (this.f3609.getChildAt(0) instanceof wQ) && this.f11479 == -1) {
                    ((wQ) this.f3609.getChildAt(0)).setSelected(true);
                    this.f11479 = 0;
                }
            }
        } else if (this.f3618 != null) {
            this.f3618.mo2248();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ʽ */
    public UserActionLogging.PostPlayExperience mo2556() {
        return UserActionLogging.PostPlayExperience.PostPlaySuggestions;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ॱॱ */
    public int mo2591() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ʼ */
    public boolean mo2554() {
        return this.f3620 != null && this.f3620.getAutoplay();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˏ */
    public void mo2579() {
        this.f11478 = (TextView) this.f3616.findViewById(R.id.post_play_experience_title);
    }
}
