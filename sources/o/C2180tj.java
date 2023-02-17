package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.kids.lolomo.KidsCharacterView$1;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.util.List;
import o.uO;
@SuppressLint({"ViewConstructor"})
/* renamed from: o.tj  reason: case insensitive filesystem */
public class C2180tj extends FrameLayout implements uO.Cif<pJ> {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final List<Pair<Integer, Integer>> f10554 = new KidsCharacterView$1();

    /* renamed from: ˊ  reason: contains not printable characters */
    private oX f10555 = new oB("KidsCharacterView");

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f10556;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0522 f10557;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0522 f10558;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final View$OnClickListenerC1193 f10559;

    public C2180tj(Context context) {
        super(context);
        setFocusable(true);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.kids_character_row_item_padding);
        setPadding(dimensionPixelSize, context.getResources().getDimensionPixelSize(R.dimen.kids_character_row_item_padding_top), dimensionPixelSize, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 80);
        this.f10557 = new C0522(context);
        addView(this.f10557, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 80);
        this.f10558 = new C0522(context);
        this.f10558.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f10558, layoutParams2);
        this.f10559 = new C0224((NetflixActivity) context, this);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f10558.setCornerRadius(i / 2);
            this.f10558.m14542();
        }
    }

    /* renamed from: o.tj$ˋ  reason: contains not printable characters */
    class C0224 extends View$OnClickListenerC1193 {
        public C0224(NetflixActivity netflixActivity, qK qKVar) {
            super(netflixActivity, qKVar);
        }

        /* access modifiers changed from: protected */
        @Override // o.View$OnClickListenerC1193
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo11180(NetflixActivity netflixActivity, pJ pJVar, oX oXVar) {
            Bundle bundle = new Bundle();
            bundle.putInt("extra_kids_color_id", C2180tj.this.f10556);
            qU.m9975(netflixActivity, pJVar, oXVar, "DeetsClickListener", bundle);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m11178(pJ pJVar) {
        if (pJVar == null) {
            return null;
        }
        return pJVar.getBoxshotUrl();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo2123(pJ pJVar, AbstractC2087qh qhVar, int i, boolean z, boolean z2) {
        String r8 = m11178(pJVar);
        this.f10555 = new qN(qhVar, i);
        setVisibility(0);
        int size = i % f10554.size();
        this.f10557.setBackgroundResource(f10554.get(size).first.intValue());
        this.f10556 = f10554.get(size).second.intValue();
        ImageLoader imageLoader = NetflixActivity.getImageLoader(getContext());
        if (imageLoader != null) {
            imageLoader.mo3063(this.f10558, r8, AssetType.bif, pJVar.getTitle(), StaticImgConfig.LIGHT_NO_PLACEHOLDER, true, z ? 1 : 0);
        }
        this.f10559.m16462(this, pJVar);
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        return this.f10555;
    }
}
