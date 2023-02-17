package o;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.netflix.mediaclient.R;
public class vJ extends C0816 {

    /* renamed from: ʽ  reason: contains not printable characters */
    ImageView f11189;

    /* renamed from: ॱ  reason: contains not printable characters */
    C0716 f11190;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    ProgressBar f11191;

    /* renamed from: ᐝ  reason: contains not printable characters */
    AnimationDrawable f11192;

    private vJ(ViewGroup viewGroup) {
        super(viewGroup);
        m11957(viewGroup);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11957(ViewGroup viewGroup) {
        m15407().m15424().addView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offline_buffet_include, m15411(), false));
        this.f11190 = (C0716) m15407().m15424().findViewById(R.id.snackbar_percent);
        this.f11191 = (ProgressBar) m15407().m15424().findViewById(R.id.snackbar_loading);
        this.f11189 = (ImageView) m15407().m15424().findViewById(R.id.snackbar_downloading);
        LayerDrawable layerDrawable = (LayerDrawable) this.f11189.getContext().getResources().getDrawable(R.drawable.animated_download);
        this.f11192 = (AnimationDrawable) layerDrawable.getDrawable(1);
        this.f11189.setImageDrawable(layerDrawable);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static vJ m11956(View view, CharSequence charSequence, int i, int i2, int i3) {
        ViewGroup r2 = m15389(view);
        if (r2 == null) {
            return null;
        }
        vJ vJVar = new vJ(r2);
        vJVar.m15403(charSequence);
        vJVar.m15397(i);
        vJVar.m15412(i2);
        vJVar.m15400(i3);
        if (r2.getWidth() < vJVar.m15407().m15426()) {
            vJVar.m15407().setMaxWidth(r2.getWidth());
        }
        return vJVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11960(int i, boolean z) {
        if (i <= 0 || i >= 100) {
            this.f11190.setText("");
            this.f11189.setVisibility(8);
            this.f11192.stop();
            return;
        }
        this.f11190.setVisibility(0);
        this.f11190.setText(BG.m3854(i));
        this.f11189.setVisibility(0);
        if (!this.f11192.isRunning() && !z) {
            this.f11192.start();
        }
        m11961();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m11958() {
        this.f11190.setVisibility(8);
        this.f11191.setVisibility(8);
        this.f11189.setVisibility(8);
        this.f11192.stop();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m11959() {
        this.f11192.stop();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m11963() {
        this.f11192.start();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m11961() {
        this.f11191.setVisibility(8);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m11962() {
        if (!this.f11192.isRunning()) {
            this.f11191.setVisibility(0);
        }
    }
}
