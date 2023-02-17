package o;

import android.view.View;
import android.widget.Button;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayAction;
public class wL {

    /* renamed from: ˊ  reason: contains not printable characters */
    private NetflixActivity f11485;

    /* renamed from: ˋ  reason: contains not printable characters */
    private IPlayerFragment f11486;

    /* renamed from: ˎ  reason: contains not printable characters */
    private PlayLocationType f11487;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f11488;

    /* renamed from: ॱ  reason: contains not printable characters */
    private PostPlayAction f11489;

    public wL(NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PostPlayAction postPlayAction, PlayLocationType playLocationType) {
        this(netflixActivity, iPlayerFragment, postPlayAction, playLocationType, null);
    }

    public wL(NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PostPlayAction postPlayAction, PlayLocationType playLocationType, View view) {
        this.f11488 = "PostPlayCallToAction";
        this.f11485 = netflixActivity;
        this.f11486 = iPlayerFragment;
        this.f11487 = playLocationType;
        this.f11489 = postPlayAction;
        if (view != null) {
            if (view instanceof Button) {
                m12327((Button) view);
            }
            m12326(view);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12327(Button button) {
        button.setText(m12332());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m12332() {
        if (this.f11489.getDisplayText() != null) {
            return this.f11489.getDisplayText();
        }
        switch (this.f11489.getType()) {
            case play:
                return C1349Bv.m4126(this.f11489.getName(), "playTrailer") ? m12325(R.string.label_play_trailer_all_caps) : m12325(R.string.billboard_cta_play);
            case mdp:
                return (this.f11489.getVideoType() == null || !this.f11489.getVideoType().equals(VideoType.EPISODE)) ? m12325(R.string.label_more_info) : m12325(R.string.billboard_cta_list_episodes);
            case playlist:
                return m12325(this.f11489.isInMyList() ? R.string.label_add_to_my_list : R.string.label_remove_from_my_list);
            default:
                return "";
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m12325(int i) {
        return this.f11485.getResources().getString(i);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12326(View view) {
        switch (this.f11489.getType()) {
            case play:
                if (this.f11489.getPlayBackVideo() != null) {
                    m12324(view);
                    return;
                }
                return;
            case mdp:
                m12322(view);
                return;
            case playlist:
                if (view instanceof Button) {
                    m12323((Button) view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12324(View view) {
        view.setOnClickListener(m12330());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public View.OnClickListener m12330() {
        return new View.OnClickListener() { // from class: o.wL.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wL.this.m12337(false);
            }
        };
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12337(boolean z) {
        if (PlayLocationType.MDX.equals(this.f11487)) {
            m12334(z);
        } else {
            m12331(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12331(boolean z) {
        if (this.f11489.getType().equals(PostPlayAction.CallToActionType.play) && this.f11486 != null && this.f11489.getPlayBackVideo() != null && this.f11489.getPlayBackVideo().getPlayable() != null) {
            C2275wq r8 = this.f11486.mo2226();
            if (this.f11486.mo2265()) {
                C1283.m16854(this.f11488, "Playback currently in Pip, ingoring");
                return;
            }
            if (r8 != null) {
                if (r8.m12506().m2587()) {
                    C1283.m16854(this.f11488, "Play action already consumed, ignoring");
                    return;
                }
                r8.m12506().m2586(true);
            }
            m12320();
            boolean z2 = !this.f11489.isDoNotIncrementInterrupter() && z;
            if (this.f11489.getSeamlessStart() > 0) {
                this.f11486.mo2261(this.f11489.getPlayBackVideo().getPlayable(), this.f11489.getVideoType(), m12329(), z2, z, this.f11489.getSeamlessStart(), true);
            } else {
                this.f11486.mo2261(this.f11489.getPlayBackVideo().getPlayable(), this.f11489.getVideoType(), m12329(), z2, z, -1, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12334(boolean z) {
        if (this.f11489.getPlayBackVideo() != null) {
            m12321();
            uT.m11651(this.f11485, this.f11489.getPlayBackVideo().getPlayable(), this.f11489.getVideoType(), qN.f9499, -1, true);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m12328() {
        if (!this.f11485.isFinishing()) {
            this.f11485.finish();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m12321() {
        oG r2 = this.f11485.getServiceManager().m9811();
        if (r2 instanceof C1698eK) {
            ((C1698eK) r2).m6182();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m12320() {
        C1283.m16854(this.f11488, "User starts next play, report as such");
        C1300Ac.m3537(new C1263());
        C1362Ch.m4392(IClientLogging.CompletionReason.success, IClientLogging.ModalView.playback, null, false, true, Integer.valueOf(this.f11489.getVideoId()), Integer.valueOf(this.f11489.getItemIndex()), this.f11489.getTrackId());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12322(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: o.wL.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                wL.this.m12336();
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12336() {
        if (PlayLocationType.MDX.equals(this.f11487)) {
            m12335();
        } else {
            m12333();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12333() {
        qU.m9981(this.f11485, this.f11489.getVideoType().equals(VideoType.MOVIE) ? VideoType.MOVIE : VideoType.SHOW, String.valueOf(this.f11489.getVideoId()), this.f11489.getAncestorTitle(), m12329(), null, null, "PostPlay");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12335() {
        m12328();
        m12333();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12323(Button button) {
        C2059ph serviceManager = this.f11485.getServiceManager();
        String valueOf = String.valueOf(this.f11489.getVideoId());
        if (button != null) {
            serviceManager.m9802(valueOf, serviceManager.m9792(this.f11485, button, valueOf, this.f11489.getVideoType(), this.f11489.getTrackId(), false));
            serviceManager.m9818(valueOf, this.f11489.isInMyList());
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private oX m12329() {
        qN qNVar = new qN(this.f11489, this.f11489.getBookmarkPosition());
        qNVar.mo9594(PlayLocationType.POST_PLAY);
        return qNVar;
    }
}
