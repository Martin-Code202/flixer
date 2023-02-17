package o;

import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import o.AU;
import o.uU;
public class uN extends uQ {

    /* renamed from: ʻ  reason: contains not printable characters */
    View f10832;

    /* renamed from: ʽ  reason: contains not printable characters */
    View f10833;

    /* renamed from: ˊ  reason: contains not printable characters */
    C1429Er f10834;

    /* renamed from: ˋ  reason: contains not printable characters */
    View f10835;

    /* renamed from: ˎ  reason: contains not printable characters */
    View f10836;

    /* renamed from: ˏ  reason: contains not printable characters */
    C1428Eq f10837;

    /* renamed from: ॱ  reason: contains not printable characters */
    View f10838;

    /* renamed from: ᐝ  reason: contains not printable characters */
    C0522 f10839;

    public uN(NetflixActivity netflixActivity, uS uSVar, AU.If r3, uU.If r4) {
        super(netflixActivity, uSVar, r3, r4);
    }

    /* access modifiers changed from: protected */
    @Override // o.uQ
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo11549() {
        super.mo11549();
        this.f10834 = (C1429Er) this.f10885.findViewById(R.id.mini_player_pager);
        this.f10837 = (C1428Eq) this.f10885.findViewById(R.id.mini_player_pager_indicator);
        this.f10835 = this.f10885.findViewById(R.id.memento_frag_group);
        this.f10838 = this.f10885.findViewById(R.id.cast_player_text_puller);
        this.f10836 = this.f10885.findViewById(R.id.cast_player_text_group_expanded);
        this.f10833 = this.f10885.findViewById(R.id.mini_player_tabs);
        this.f10832 = this.f10913.findViewById(R.id.sliding_panel_pull);
        this.f10839 = (C0522) this.f10885.findViewById(R.id.cast_player_box_art);
    }

    @Override // o.uQ
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo11550() {
        super.mo11550();
        this.f10873.getLayoutParams().width = AD.m3317(this.f10873.getContext());
        if (AD.m3290(this.f10873.getContext()) == 3 && AD.m3307(this.f10873.getContext())) {
            this.f10836.getLayoutParams().height = 0;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.uQ
    /* renamed from: ˎ  reason: contains not printable characters */
    public int mo11551() {
        return R.layout.cast_player_container;
    }

    @Override // o.uQ
    /* renamed from: ˏ  reason: contains not printable characters */
    public View mo11554() {
        return this.f10838;
    }

    /* access modifiers changed from: protected */
    @Override // o.uQ
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11552(float f) {
        float f2 = 1.0f - f;
        float r4 = ((float) mo11555()) * f;
        float r5 = ((float) mo11555()) * f2 * 0.09f;
        if (this.f10835 != null) {
            this.f10835.setY(r4);
            this.f10835.setAlpha(f2);
        }
        if (this.f10918 != null) {
            this.f10918.setAlpha(f);
        }
        if (this.f10910 != null) {
            this.f10910.setAlpha(f);
        }
        if (this.f10876 != null) {
            if (f2 == 0.0f) {
                this.f10876.animate().alpha(1.0f).setDuration(300);
            } else {
                this.f10876.setAlpha(f2);
            }
            this.f10876.setY(r5 - (((float) m11647().getResources().getDimensionPixelSize(R.dimen.cast_player_caret_offset_y)) * f));
        }
        m11548(f2);
    }

    @Override // o.uQ
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo11555() {
        if (m11646()) {
            return m11647().getResources().getDimensionPixelSize(R.dimen.cast_player_title_height) + m11647().getResources().getDimensionPixelSize(R.dimen.cast_player_skip_intro_height);
        }
        return m11647().getResources().getDimensionPixelSize(R.dimen.cast_player_title_height);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11548(float f) {
        if (this.f10832 != null) {
            this.f10832.setBackgroundColor((((int) (153.0f * f)) << 24) | 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.uQ
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11553(boolean z) {
        if (z) {
            m11638(this.f10900, this.f10909, this.f10873, this.f10834, this.f10837, this.f10914, this.f10876, this.f10836, this.f10833, this.f10839);
            if (this.f10914 != null) {
                m11634(this.f10914);
                return;
            }
            return;
        }
        m11644(this.f10900, this.f10909, this.f10873, this.f10834, this.f10837, this.f10914, this.f10876, this.f10836, this.f10833, this.f10839);
    }
}
