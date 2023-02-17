package o;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.mediaclient.util.log.UIScreen;
import o.C2275wq;
public class vY extends C2258wa {

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private static String f11278 = "BottomPanel_Ab8579";

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected C2282wx f11279;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public View f11280;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private Button f11281;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected pF f11282;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected Button f11283;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected ImageButton f11284;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected Button f11285;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected Button f11286;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected ImageButton f11287;

    public vY(PlayerFragment playerFragment, View view, C2275wq.C0256 r3) {
        super(playerFragment, view, r3);
    }

    @Override // o.C2258wa, o.AbstractC2264wf
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12098() {
        super.mo12098();
        if (this.f11280 != null) {
            this.f11280.setVisibility(8);
        }
    }

    @Override // o.C2258wa, o.AbstractC2264wf
    /* renamed from: ˏ  reason: contains not printable characters */
    public ViewGroup mo12101() {
        return (ViewGroup) this.f11280;
    }

    @Override // o.C2258wa, o.AbstractC2264wf
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo12097() {
        super.mo12097();
        this.f11279.m12587(this.f11280, true);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2258wa
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12102(View view, C2275wq.C0256 r2) {
        mo12108(view, r2);
        mo12100(r2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo12108(View view, C2275wq.C0256 r5) {
        this.f11279 = new C2282wx();
        this.f11565 = (TextView) view.findViewById(R.id.label_duration);
        this.f11570 = view.findViewById(R.id.bottom_panel);
        this.f11567 = (C1081) view.findViewById(R.id.timeline);
        this.f11574 = r5.f11691;
        this.f11567.setThumbOffset(C1004.m15954(this.f11438.m14534(), this.f11438.m2472().f11516));
        this.f11573 = (ImageButton) view.findViewById(R.id.player_pause_btn);
        this.f11573.setOnClickListener(r5.f11695);
        this.f11572 = view.findViewById(R.id.extra_seekbar_handler);
        this.f11562 = vZ.m12109(this.f11438);
        this.f11286 = (Button) view.findViewById(R.id.player_episodes_text_button);
        this.f11285 = (Button) view.findViewById(R.id.player_langSubs_text_button);
        this.f11281 = (Button) view.findViewById(R.id.player_share_text_button);
        this.f11283 = (Button) view.findViewById(R.id.player_next_episode_text_button);
        this.f11287 = (ImageButton) view.findViewById(R.id.player_episodes_button_bar);
        this.f11284 = (ImageButton) view.findViewById(R.id.player_langSubs_button_bar);
        this.f11280 = view.findViewById(R.id.player_bottom_buttons_bar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo12100(C2275wq.C0256 r4) {
        if (C0650.m14805() || Config_Ab9454_InPlayerPivots.m514()) {
            if (C0650.m14808() || Config_Ab9454_InPlayerPivots.m527()) {
                this.f11285.setText(this.f11438.getResources().getString(R.string.label_language_subtitles));
            }
            ViewUtils.m3003(this.f11285);
            if (m12095()) {
                ViewUtils.m3003(this.f11286);
            }
            if (C0650.m14800() || Config_Ab9454_InPlayerPivots.m516()) {
                ViewUtils.m3003(this.f11281);
            }
            if ((C0650.m14804() || Config_Ab9454_InPlayerPivots.m522()) && m12095()) {
                ViewUtils.m3003(this.f11283);
            }
        } else if (C0650.m14794() || Config_Ab9454_InPlayerPivots.m524()) {
            if (m12095()) {
                ViewUtils.m3019(this.f11287, 0);
            }
            ViewUtils.m3019(this.f11284, 0);
        }
        m12093(r4);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean m12095() {
        return m12091() && !this.f11438.mo2255();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean m12091() {
        return this.f11438.mo2268() != null && this.f11438.mo2268().isPlayableEpisode();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12093(final C2275wq.C0256 r3) {
        if (this.f11283 != null && this.f11283.getVisibility() == 0) {
            this.f11283.setOnClickListener(new View.OnClickListener() { // from class: o.vY.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (vY.this.f11282 != null) {
                        C1364Cj.m4434(UIViewLogging.UIViewCommandName.next, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                        vY.this.f11438.mo2253(vY.this.f11282, VideoType.EPISODE, qN.f9509, vY.this.f11282.getPlayableBookmarkPosition());
                    }
                }
            });
        }
        if (this.f11286 != null && this.f11286.getVisibility() == 0) {
            this.f11286.setOnClickListener(new View.OnClickListener() { // from class: o.vY.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r3.f11690 != null) {
                        r3.f11690.onClick(view);
                    }
                }
            });
        }
        if (this.f11287 != null && this.f11287.getVisibility() == 0) {
            this.f11287.setOnClickListener(new View.OnClickListener() { // from class: o.vY.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r3.f11690 != null) {
                        r3.f11690.onClick(view);
                    }
                }
            });
        }
        if (this.f11281 != null && this.f11281.getVisibility() == 0) {
            this.f11281.setOnClickListener(new View.OnClickListener() { // from class: o.vY.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    pF r2 = vY.this.f11438.mo2268();
                    if (vY.this.f11438.m14535() && r2 != null) {
                        String parentTitle = r2.getParentTitle();
                        AJ.m3367(vY.this.f11438.getActivity(), r2.getTopLevelId(), parentTitle, UIScreen.playbackControls);
                    }
                }
            });
        }
        if (this.f11285 != null && this.f11285.getVisibility() == 0) {
            this.f11285.setOnClickListener(new View.OnClickListener() { // from class: o.vY.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r3.f11696 != null && vY.this.f11438.m14535()) {
                        r3.f11696.onClick(view);
                    }
                }
            });
        }
        if (this.f11284 != null && this.f11284.getVisibility() == 0) {
            this.f11284.setOnClickListener(new View.OnClickListener() { // from class: o.vY.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r3.f11696 != null && vY.this.f11438.m14535()) {
                        r3.f11696.onClick(view);
                    }
                }
            });
        }
    }

    @Override // o.C2258wa
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12104(boolean z) {
        this.f11279.m12590((View) this.f11283, z);
        this.f11279.m12590((View) this.f11286, z);
        this.f11279.m12590((View) this.f11281, z);
        this.f11279.m12590((View) this.f11285, z);
        this.f11279.m12590(this.f11287, z);
        this.f11279.m12590(this.f11284, z);
    }

    @Override // o.C2258wa
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void mo12099() {
        this.f11279.m12592(this.f11570, true, true);
        this.f11562.m12113();
        if (this.f11564 <= 0) {
            C1283.m16854(f11278, "Timeline was NOT visible before, its location is NOT known, delay until is rendered first time");
            final C1081 r4 = this.f11567;
            r4.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.vY.10
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    C1283.m16854(vY.f11278, "Timeline is visible now, its location is known, render current time now!!! <==");
                    vY.this.f11562.mo12116();
                    if (vY.this.f11564 > 1) {
                        ViewUtils.m3009(r4, this);
                    }
                    vY.this.f11564++;
                }
            });
        }
    }

    @Override // o.C2258wa
    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void mo12107() {
        if (this.f11562 != null) {
            this.f11562.m12110();
        }
        this.f11279.m12592(this.f11570, false, true);
        m12405();
    }

    /* access modifiers changed from: protected */
    @Override // o.C2258wa
    /* renamed from: ʽ  reason: contains not printable characters */
    public void mo12096() {
    }

    @Override // o.C2258wa
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo12106(View view) {
        int r3 = m12094(this.f11567, this.f11566);
        if (!(this.f11572 == null || this.f11572.getLayoutParams() == null || !(this.f11572.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
            ((ViewGroup.MarginLayoutParams) this.f11572.getLayoutParams()).leftMargin = (this.f11572.getMeasuredWidth() / 2) + r3;
            this.f11572.requestLayout();
        }
        view.measure(0, 0);
        int measuredWidth = (this.f11572.getMeasuredWidth() + r3) - (view.getMeasuredWidth() / 2);
        int measuredWidth2 = this.f11549.getWindow().getDecorView().getMeasuredWidth();
        if (measuredWidth < 10) {
            return 10;
        }
        if (view.getMeasuredWidth() + measuredWidth > measuredWidth2) {
            return (measuredWidth2 - view.getMeasuredWidth()) - 10;
        }
        return measuredWidth;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2258wa
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo12105(int i) {
        return m12397(null, this.f11567, i) + (this.f11572.getMeasuredWidth() / 2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m12094(C1081 r2, int i) {
        return (int) r2.m16172((long) i);
    }

    @Override // o.C2258wa
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12103(pT pTVar, boolean z) {
        if (this.f11283 != null) {
            if (pTVar == null) {
                this.f11283.setVisibility(8);
                return;
            }
            this.f11283.setVisibility(z ? 0 : 8);
            this.f11282 = pTVar.getPlayable();
        }
    }
}
