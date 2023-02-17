package o;

import android.media.AudioManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.util.ViewUtils;
import o.C2275wq;
/* renamed from: o.xh  reason: case insensitive filesystem */
public class C2312xh extends C2306xb {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected final Runnable f12171 = new Runnable() { // from class: o.xh.4
        @Override // java.lang.Runnable
        public void run() {
            if (C2312xh.this.f11438 != null && C2312xh.this.f11438.mo2226() != null) {
                C2312xh.this.f11438.mo2226().m12502();
            }
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    protected C2282wx f12172;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected ImageButton f12173;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private ImageButton f12174;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private ImageButton f12175;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private LinearLayout f12176;

    /* renamed from: ͺ  reason: contains not printable characters */
    private ImageButton f12177;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private ImageView f12178;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private Button f12179;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected ImageButton f12180;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private ImageButton f12181;

    public C2312xh(PlayerFragment playerFragment, View view, C2275wq.C0256 r4) {
        super(playerFragment, r4);
        mo12934(view);
        mo12935(playerFragment);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo12934(View view) {
        this.f12172 = new C2282wx();
        this.f12176 = (LinearLayout) view.findViewById(R.id.top_panel);
        this.f12128 = (TextView) view.findViewById(R.id.player_title_label);
        this.f12175 = (ImageButton) view.findViewById(R.id.player_cast_button);
        this.f12180 = (ImageButton) view.findViewById(R.id.player_cast_button_end);
        this.f12179 = (Button) view.findViewById(R.id.player_cast_text_button);
        this.f12178 = (ImageButton) view.findViewById(R.id.player_episodes_button);
        this.f12181 = (ImageButton) view.findViewById(R.id.player_langSubs_button);
        this.f12174 = (ImageButton) view.findViewById(R.id.player_volume_button);
        this.f12177 = (ImageButton) view.findViewById(R.id.player_close_button);
        this.f12173 = (ImageButton) view.findViewById(R.id.player_back_button);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12935(PlayerFragment playerFragment) {
        if (C0650.m14803() || Config_Ab9454_InPlayerPivots.m526()) {
            ViewUtils.m3019(this.f12181, 0);
            ViewUtils.m3019(this.f12174, 0);
            if (m12931()) {
                ViewUtils.m3019(this.f12178, 0);
            }
            if (this.f12128 != null) {
                this.f12128.setTextAlignment(2);
            }
        }
        if (C0650.m14795() || Config_Ab9454_InPlayerPivots.m523()) {
            ViewUtils.m3019(this.f12177, 0);
        } else {
            ViewUtils.m3019(this.f12173, 0);
        }
        m12932(playerFragment);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m12931() {
        return this.f11438.mo2268() != null && this.f11438.mo2268().isPlayableEpisode() && !this.f11438.mo2255();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12932(final PlayerFragment playerFragment) {
        if (this.f12174 != null && this.f12174.getVisibility() == 0) {
            this.f12174.setOnClickListener(new View.OnClickListener() { // from class: o.xh.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C2312xh.this.f11438.m14535()) {
                        ((AudioManager) C2312xh.this.f11438.getActivity().getSystemService("audio")).adjustStreamVolume(3, 0, 1);
                    }
                }
            });
        }
        if (this.f12177 != null && this.f12177.getVisibility() == 0) {
            this.f12177.setOnClickListener(new View.OnClickListener() { // from class: o.xh.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.close, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    if (C2312xh.this.f11438.m14535()) {
                        playerFragment.getActivity().onBackPressed();
                    }
                }
            });
        }
        if (this.f12173 != null && this.f12173.getVisibility() == 0) {
            this.f12173.setOnClickListener(new View.OnClickListener() { // from class: o.xh.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.close, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    if (C2312xh.this.f11438.m14535()) {
                        playerFragment.getActivity().onBackPressed();
                    }
                }
            });
        }
        if (this.f12178 != null && this.f12178.getVisibility() == 0) {
            this.f12178.setOnClickListener(new View.OnClickListener() { // from class: o.xh.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C2312xh.this.f12125.f11690 != null && C2312xh.this.f11438.m14535()) {
                        C2312xh.this.f12125.f11690.onClick(view);
                    }
                }
            });
        }
        if (this.f12181 != null && this.f12181.getVisibility() == 0) {
            this.f12181.setOnClickListener(new View.OnClickListener() { // from class: o.xh.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C2312xh.this.f12125.f11696 != null && C2312xh.this.f11438.m14535()) {
                        C2312xh.this.f12125.f11696.onClick(view);
                    }
                }
            });
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m12933() {
        if (C0650.m14797() || Config_Ab9454_InPlayerPivots.m512()) {
            ViewUtils.m3019(this.f12175, 0);
        } else if (C0650.m14807() || Config_Ab9454_InPlayerPivots.m515()) {
            ViewUtils.m3003(this.f12179);
        } else {
            ViewUtils.m3019(this.f12180, 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2306xb
    /* renamed from: ˊ */
    public void mo12887(boolean z) {
        if (z && this.f11438.mo2226() != null) {
            this.f11438.mo2226().m12516();
        }
        if (this.f12176 != null) {
            this.f12172.m12591(this.f12176, z, false, -1.0f, z ? null : this.f12171);
        }
    }

    @Override // o.C2306xb
    /* renamed from: ˏ */
    public synchronized void mo12898(boolean z) {
        super.mo12898(z);
        this.f12172.m12590(this.f12174, z);
        this.f12172.m12590(this.f12181, z);
        this.f12172.m12590(this.f12178, z);
        this.f12172.m12590(this.f12175, z);
        this.f12172.m12590((View) this.f12179, z);
        this.f12172.m12590(this.f12180, z);
        this.f12172.m12590((View) this.f12128, z);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2306xb
    /* renamed from: ॱ */
    public synchronized void mo12902(uW uWVar) {
        this.f12124 = uWVar;
        if (m12891() && this.f11438.m14535()) {
            m12933();
            m12930();
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m12930() {
        View view = null;
        if (this.f12179 != null && this.f12179.getVisibility() == 0) {
            view = this.f12179;
        } else if (this.f12175 != null && this.f12175.getVisibility() == 0) {
            view = this.f12175;
        } else if (this.f12180 != null && this.f12180.getVisibility() == 0) {
            view = this.f12180;
        }
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: o.xh.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C2312xh.this.f11438.m14535()) {
                        C2312xh.this.f11438.m2479();
                        C2312xh.this.m12884();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2306xb
    /* renamed from: ˋ */
    public void mo12889(PlayerFragment playerFragment) {
    }

    /* access modifiers changed from: protected */
    @Override // o.C2306xb
    /* renamed from: ᐝ */
    public void mo12904(Menu menu) {
    }

    /* access modifiers changed from: protected */
    @Override // o.C2306xb
    /* renamed from: ˏ */
    public void mo12897(Menu menu) {
    }

    /* access modifiers changed from: protected */
    @Override // o.C2306xb
    /* renamed from: ˏ */
    public void mo12896() {
    }

    /* access modifiers changed from: protected */
    @Override // o.C2306xb
    /* renamed from: ॱ */
    public void mo12901(Menu menu) {
    }

    /* access modifiers changed from: protected */
    @Override // o.C2306xb
    /* renamed from: ˋ */
    public void mo12888(Menu menu) {
    }
}
