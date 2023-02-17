package o;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import kotlin.jvm.internal.PropertyReference1Impl;
/* renamed from: o.ud  reason: case insensitive filesystem */
public final class C2204ud extends ConstraintLayout {

    /* renamed from: ॱ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f10981 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2204ud.class), "previewsBoxArtView", "getPreviewsBoxArtView()Lcom/netflix/mediaclient/ui/lolomo/PreviewsBoxArtView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2204ud.class), "titleTreatment", "getTitleTreatment()Lcom/netflix/mediaclient/android/widget/AdvancedImageView;"))};

    /* renamed from: ˊ  reason: contains not printable characters */
    private final FI f10982;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final FI f10983;

    public C2204ud(Context context) {
        this(context, null, 0, 6, null);
    }

    public C2204ud(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final tY m11696() {
        return (tY) this.f10983.mo4986(this, f10981[0]);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final C0522 m11698() {
        return (C0522) this.f10982.mo4986(this, f10981[1]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2204ud(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f10983 = C1197.m16465(this, (int) R.id.previews_box_art);
        this.f10982 = C1197.m16465(this, (int) R.id.previews_title_treatment);
        setFocusable(true);
        setBackgroundResource(R.drawable.selectable_video_background);
        View.inflate((Context) C0345.m13893(context, NetflixActivity.class), R.layout.previews_lolomo_view, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2204ud(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m11697(C2202ub ubVar) {
        C1457Fr.m5025(ubVar, "uiModel");
        m11696().m11051(ubVar);
        m11695(ubVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m11695(C2202ub ubVar) {
        ImageLoader imageLoader = NetflixActivity.getImageLoader(getContext());
        if (imageLoader != null) {
            imageLoader.mo3063(m11698(), ubVar.m11692(), AssetType.boxArt, ubVar.m11688(), BrowseExperience.m1769(), true, ubVar.m11694());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m11699(View.OnClickListener onClickListener) {
        C1457Fr.m5025(onClickListener, "onClickListener");
        setOnClickListener(onClickListener);
    }
}
