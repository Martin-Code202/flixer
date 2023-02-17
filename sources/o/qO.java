package o;

import android.content.Context;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.lomo.LoMoUtils;
import com.netflix.mediaclient.ui.offline.DownloadButton;
public abstract class qO extends RelativeLayout implements Checkable, AbstractC2118rg<pI, pR> {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected TextView f9524;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected ProgressBar f9525;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected boolean f9526;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected TextView f9527;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final int f9528;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected ImageView f9529;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected int f9530;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected TextView f9531;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected TextView f9532;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f9533;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected boolean f9534;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected TextView f9535;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected boolean f9536;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected DownloadButton f9537;

    /* renamed from: o.qO$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˏ */
        void mo2536(pI pIVar);
    }

    /* renamed from: o.qO$ˋ  reason: contains not printable characters */
    public interface AbstractC0170 {
        Cif getEpisodeRowListener();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract void mo9935(pI pIVar);

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract void mo9937(pF pFVar);

    public qO(Context context, int i) {
        super(context);
        this.f9528 = i;
        m9930();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9930() {
        this.f9533 = true;
        inflate(getContext(), this.f9528, this);
        mo9936();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9936() {
        this.f9535 = (TextView) findViewById(R.id.episode_badge);
        this.f9527 = (TextView) findViewById(R.id.episode_row_title);
        this.f9531 = (TextView) findViewById(R.id.episode_row_number);
        this.f9532 = (TextView) findViewById(R.id.episode_row_synopsis);
        this.f9529 = (ImageView) findViewById(R.id.episode_row_play_button);
        this.f9537 = (DownloadButton) findViewById(R.id.episode_row_download_button);
        this.f9525 = (ProgressBar) findViewById(R.id.episode_row_progress_bar);
        this.f9524 = (TextView) findViewById(R.id.episode_time);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9938(pI pIVar) {
        AbstractC0170 r3 = (AbstractC0170) C1322Av.m3791(getContext(), AbstractC0170.class);
        if (r3 != null) {
            Cif episodeRowListener = r3.getEpisodeRowListener();
            if (episodeRowListener != null) {
                episodeRowListener.mo2536(pIVar);
            } else {
                C1283.m16850("EpisodeRowView", "No EpisodeRowListener provided: " + getContext());
            }
        } else {
            C1283.m16865("EpisodeRowView", "Context is not an EpisodeRowListenerProvider, context: " + getContext());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9526;
    }

    @Override // o.AbstractC2118rg
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo9942() {
        return this.f9533;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.f9526 = z;
        boolean z2 = z && this.f9533;
        if (this.f9532 != null) {
            this.f9532.setVisibility(z2 ? 0 : 8);
        }
        if (this.f9524 != null) {
            this.f9524.setVisibility(z2 ? 0 : 8);
        }
        mo9944();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9944() {
        if (this.f9530 <= 0) {
            this.f9525.setVisibility(8);
            return;
        }
        this.f9525.setVisibility(0);
        if (this.f9536) {
            this.f9525.setProgress(this.f9530);
            this.f9525.setSecondaryProgress(0);
            return;
        }
        this.f9525.setProgress(0);
        this.f9525.setSecondaryProgress(this.f9530);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f9526);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public CharSequence mo9943(pI pIVar) {
        return m9931(pIVar, getContext());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m9932(pI pIVar, Context context) {
        return Integer.toString(pIVar.getEpisodeNumber());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m9929(pI pIVar, Context context) {
        return BD.m3838(pIVar.getPlayable().getRuntime(), context);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m9931(pI pIVar, Context context) {
        if (pIVar.isAvailableToStream() || pIVar.isEpisodeNumberHidden()) {
            return pIVar.getTitle();
        }
        return C1349Bv.m4113(pIVar.mo4567()) ? context.getString(R.string.label_not_available_for_playback) : pIVar.mo4567();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public int mo9934() {
        return 8;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9941(pI pIVar, boolean z) {
        if (pIVar != null) {
            this.f9534 = pIVar.isEpisodeNumberHidden() || !pIVar.isAvailableToStream();
            this.f9536 = z;
            setContentDescription(String.format(getResources().getString(R.string.accesibility_episode_number_description), Integer.valueOf(pIVar.getEpisodeNumber()), pIVar.getTitle(), pIVar.getSynopsis(), Integer.valueOf(C1352By.m4137(pIVar.getPlayable().getRuntime()))));
            if (pIVar.isAvailableToStream() && !this.f9534 && this.f9531 != null) {
                this.f9531.setVisibility(0);
                this.f9531.setText(m9932(pIVar, getContext()));
            }
            if (this.f9531 != null && this.f9534) {
                this.f9531.setVisibility(8);
            }
            if (this.f9527 != null) {
                this.f9527.setText(m9931(pIVar, getContext()));
                this.f9527.setClickable(false);
            }
            if (this.f9535 != null) {
                LoMoUtils.m2145(pIVar.getNewBadge(), this.f9535);
            }
            if (this.f9524 != null) {
                if (!C1349Bv.m4113(pIVar.mo4567())) {
                    this.f9524.setText(pIVar.mo4567());
                    this.f9524.setVisibility(0);
                } else if (pIVar.isAvailableToStream()) {
                    this.f9524.setText(m9929(pIVar, getContext()));
                    this.f9524.setVisibility(0);
                } else {
                    this.f9524.setVisibility(8);
                }
            }
            m9940(pIVar);
            m9939(pIVar);
            mo9935(pIVar);
            mo9937(pIVar.getPlayable());
            setChecked(false);
            m9933(pIVar);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m9933(pI pIVar) {
        this.f9533 = pIVar.isAvailableToStream() && C1349Bv.m4107(pIVar.getSynopsis());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9939(pI pIVar) {
        this.f9530 = pIVar.getPlayable().getRuntime() > 0 ? (Math.max(0, pIVar.mo4563()) * 100) / pIVar.getPlayable().getRuntime() : 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9940(pI pIVar) {
        if (this.f9532 != null) {
            this.f9532.setText(pIVar.isAvailableToStream() ? pIVar.getSynopsis() : pIVar.mo4567());
            this.f9532.setVisibility(mo9934());
        }
    }
}
