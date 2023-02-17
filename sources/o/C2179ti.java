package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.ViewUtils;
@SuppressLint({"ViewConstructor"})
/* renamed from: o.ti  reason: case insensitive filesystem */
public class C2179ti extends C2113rb {

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private View.OnClickListener f10546 = new View.OnClickListener() { // from class: o.ti.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2179ti.this.f10550 != null) {
                C2179ti.this.m9938(C2179ti.this.f10550);
                C2179ti.this.f10548.invoke(C2179ti.this.f10550.getId());
            }
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private final int f10547;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final AbstractC1450Fk<String, Void> f10548;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private C0522 f10549;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private pI f10550;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C0792 f10551;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private View.OnClickListener f10552;

    public C2179ti(Context context, int i, int i2, AbstractC1450Fk<String, Void> fk) {
        super(context, i);
        this.f10548 = fk;
        this.f10547 = i2;
    }

    /* access modifiers changed from: protected */
    @Override // o.qO
    /* renamed from: ˋ */
    public void mo9936() {
        super.mo9936();
        this.f10551 = (C0792) findViewById(R.id.pressable_view_group);
        this.f10549 = (C0522) findViewById(R.id.result_img);
    }

    /* access modifiers changed from: protected */
    @Override // o.qO
    /* renamed from: ˊ */
    public int mo9934() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2113rb, o.qO
    /* renamed from: ˊ */
    public void mo9935(pI pIVar) {
        if (this.f10549 != null) {
            if (pIVar.isAvailableToStream()) {
                m11172(pIVar);
            } else {
                m11176();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.qO
    /* renamed from: ॱ */
    public CharSequence mo9943(pI pIVar) {
        return pIVar.getTitle();
    }

    @Override // o.qO, android.widget.Checkable
    public void setChecked(boolean z) {
        this.f9526 = z;
        mo9944();
    }

    @Override // o.C2113rb
    /* renamed from: ˋ */
    public void mo10086(pI pIVar, pR pRVar) {
        super.mo10086(pIVar, pRVar);
        m11171(pIVar);
        m11169(pIVar);
        m11173(pIVar);
        mo9944();
        mo9935(pIVar);
        m11170(pIVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.qO
    /* renamed from: ॱ */
    public void mo9944() {
        if (this.f9525 != null) {
            if (this.f9530 > 0) {
                this.f9525.setVisibility(0);
                this.f9525.setProgress(this.f9530);
                this.f9525.setSecondaryProgress(0);
                this.f9525.getLayoutParams().width = -1;
                return;
            }
            this.f9525.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public void m11172(pI pIVar) {
        if (this.f9529 != null) {
            this.f9529.setVisibility(0);
        }
        this.f10549.setEnabled(true);
        this.f10550 = pIVar;
        if (this.f10552 == null) {
            this.f10552 = this.f10546;
        }
        m11174().setOnClickListener(this.f10552);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public View m11174() {
        return this.f10551;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m11176() {
        if (this.f9529 != null) {
            this.f9529.setVisibility(8);
        }
        this.f10549.setOnClickListener(null);
        this.f10549.setEnabled(false);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m11170(pI pIVar) {
        int color = getResources().getColor((!this.f9536 || !(pIVar.getPlayable().getPlayableBookmarkPosition() > 0)) ? R.color.kids_character_text_color : R.color.white);
        if (this.f9532 != null) {
            this.f9532.setTextColor(color);
            if (this.f9536) {
                m11165();
            }
        }
        if (this.f9524 != null) {
            this.f9524.setTextColor(color);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ  reason: contains not printable characters */
    public void m11173(pI pIVar) {
        if (this.f9527 != null) {
            this.f9527.setTextColor(getResources().getColor(R.color.kids_text_color));
            View view = (View) getParent();
            if (view != null) {
                view.setTag(R.id.season_number, Integer.valueOf(pIVar.getSeasonNumber()));
            }
            if (this.f9531 != null) {
                ViewUtils.m3002(this.f9531, !pIVar.isEpisodeNumberHidden());
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m11165() {
        this.f9532.setMaxLines(10);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m11171(pI pIVar) {
        if (this.f10549 != null) {
            String interestingSmallUrl = pIVar.getInterestingSmallUrl();
            if (C1349Bv.m4107(interestingSmallUrl)) {
                NetflixActivity.getImageLoader(getContext()).mo3063(this.f10549, interestingSmallUrl, AssetType.boxArt, pIVar.getTitle(), BrowseExperience.m1769(), true, 1);
            }
            m11175();
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m11169(pI pIVar) {
        if (this.f9524 == null) {
            return;
        }
        if (!pIVar.isAvailableToStream() || pIVar.getPlayable().getRuntime() <= 0) {
            this.f9524.setVisibility(8);
            return;
        }
        this.f9524.setVisibility(0);
        String string = getResources().getString(R.string.label_num_minutes_shorthand, Integer.valueOf(C1352By.m4137(pIVar.getPlayable().getRuntime())));
        if (pIVar.isNSRE()) {
            string = string + "        " + pIVar.mo4567();
        }
        this.f9524.setText(string);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m11175() {
        if (getContext() != null) {
            float dimensionPixelOffset = (((float) this.f10547) + 1.0f) * ((float) getContext().getResources().getDimensionPixelOffset(R.dimen.kids_content_padding));
            this.f10549.getLayoutParams().height = (int) (((((float) AD.m3317(getContext())) - dimensionPixelOffset) / ((float) this.f10547)) * 0.5625f);
        }
    }
}
