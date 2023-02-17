package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import o.uO;
/* renamed from: o.ﻡ  reason: contains not printable characters */
public class C1210 extends C0522 implements uO.Cif<pJ> {

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f15605 = "EMPTY";

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0964 f15606;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected View$OnClickListenerC1193 f15607;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected oX f15608 = new oB("VideoView");

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f15609;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f15610;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private pJ f15611;

    public C1210(Context context) {
        super(context);
        m16493();
    }

    public C1210(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16493();
    }

    public C1210(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16493();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m16493() {
        setFocusable(true);
        setBackgroundResource(R.drawable.selectable_video_background);
        if (!isInEditMode()) {
            this.f15607 = new View$OnClickListenerC1193((NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class), this);
        }
    }

    public void setClickListener(View$OnClickListenerC1193 r1) {
        this.f15607 = r1;
    }

    public void setIsHorizontal(boolean z) {
        this.f15610 = z;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m16495() {
        if (this.f15606 == null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.video_view_text_placeholder_padding);
            this.f15606 = new C0964();
            this.f15606.m15777(getResources().getInteger(R.integer.video_view_text_placeholder_max_lines));
            this.f15606.m15780(getContext().getResources().getColor(R.color.video_view_placeholder_text_color));
            this.f15606.m15781(0, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.f15606.m15778(getContext().getResources().getDimensionPixelSize(R.dimen.video_view_text_placeholder_size));
            this.f15606.m15782(getContext(), BrowseExperience.m1769().mo452());
        }
        this.f15606.m15779(this.f15609);
        setImageDrawable(this.f15606);
    }

    @Override // o.C0522
    /* renamed from: ˎ */
    public void mo14543() {
        super.mo14543();
        this.f15607.m16460(this);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo2123(pJ pJVar, AbstractC2087qh qhVar, int i, boolean z, boolean z2) {
        if (qhVar != null) {
            this.f15608 = new qN(qhVar, i);
        }
        this.f15605 = "EMPTY";
        this.f15611 = pJVar;
        String r8 = mo15364(pJVar);
        setVisibility(C1349Bv.m4113(r8) ? 4 : 0);
        this.f15607.m16462(this, pJVar);
        NetflixActivity.getImageLoader(getContext()).mo3063(this, r8, AssetType.boxArt, pJVar.getTitle(), BrowseExperience.m1769(), true, z ? 1 : 0);
        if (C0640.b_(getContext()) && !m14545()) {
            this.f15609 = pJVar.getTitle();
            m16495();
        }
    }

    /* renamed from: ˏ */
    public String mo15364(pJ pJVar) {
        if (pJVar == null) {
            return null;
        }
        return this.f15610 ? m16494(pJVar) : pJVar.getBoxshotUrl();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m16494(pJ pJVar) {
        if (pJVar instanceof CH) {
            return ((CH) pJVar).getHorzDispUrl();
        }
        return null;
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        return this.f15608;
    }

    @Override // o.AbstractC1188, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable instanceof C0964) {
            this.f15605 = "TEXT";
        } else if (drawable instanceof BitmapDrawable) {
            this.f15605 = "IMAGE";
        } else if (drawable instanceof TransitionDrawable) {
            this.f15605 = "EMPTY";
        }
    }

    @Override // o.AbstractC1188, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            this.f15605 = "IMAGE";
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m16496() {
        return this.f15605;
    }
}
