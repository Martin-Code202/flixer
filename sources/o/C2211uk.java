package o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.model.leafs.ListOfMoviesSummary;
import java.util.Arrays;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC2214un;
/* renamed from: o.uk  reason: case insensitive filesystem */
public final class C2211uk extends C2212ul {

    /* renamed from: ˊ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f10993 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2211uk.class), "shortFormLomoRowContainer", "getShortFormLomoRowContainer()Landroid/widget/FrameLayout;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2211uk.class), "shortFormInfo", "getShortFormInfo()Landroid/widget/ImageView;"))};

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0233 f10994 = new C0233(null);

    /* renamed from: ʼ  reason: contains not printable characters */
    private final FI f10995;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final FI f10996 = C1197.m16471(this, (int) R.id.short_form_lomo_row_container);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ImageView m11710() {
        return (ImageView) this.f10995.mo4986(this, f10993[1]);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final FrameLayout m11711() {
        return (FrameLayout) this.f10996.mo4986(this, f10993[0]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2211uk(View view, AbstractC0954 r5, AbstractC2214un.Cif ifVar) {
        super(view, r5, ifVar);
        C1457Fr.m5025(view, "itemView");
        C1457Fr.m5025(r5, "config");
        C1457Fr.m5025(ifVar, "listener");
        if (AD.m3299()) {
            ViewGroup.LayoutParams layoutParams = m11711().getLayoutParams();
            Context context = view.getContext();
            C1457Fr.m5016((Object) context, "itemView.context");
            layoutParams.height = (int) context.getResources().getDimension(R.dimen.short_form_row_height_tablet);
        }
        this.f10995 = C1197.m16471(this, (int) R.id.short_form_info);
    }

    /* renamed from: o.uk$ˋ  reason: contains not printable characters */
    public static final class C0233 {
        private C0233() {
        }

        public /* synthetic */ C0233(C1456Fq fq) {
            this();
        }
    }

    @Override // o.C2212ul, o.AbstractC2214un
    /* renamed from: ˋ */
    public void mo11706(pC pCVar) {
        String str;
        C1457Fr.m5025(pCVar, "lomo");
        super.mo11706(pCVar);
        if (pCVar instanceof ListOfMoviesSummary) {
            str = ((ListOfMoviesSummary) pCVar).getVideoId();
        } else {
            str = null;
        }
        ImageView r0 = m11710();
        View view = this.itemView;
        C1457Fr.m5016((Object) view, "itemView");
        r0.setContentDescription(view.getResources().getString(R.string.accessibility_show_details_for, pCVar.getTitle()));
        m11710().setOnClickListener(new iF(this, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uk$iF */
    public static final class iF implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ String f10997;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2211uk f10998;

        iF(C2211uk ukVar, String str) {
            this.f10998 = ukVar;
            this.f10997 = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.f10997 != null) {
                Uri build = new Uri.Builder().scheme("http").authority("www.netflix.com").appendPath("title").appendPath("" + this.f10997).build();
                View view2 = this.f10998.itemView;
                C1457Fr.m5016((Object) view2, "itemView");
                C0693.m14984((NetflixActivity) C0345.m13893(view2.getContext(), NetflixActivity.class), new Intent("android.intent.action.VIEW", build));
                return;
            }
            AbstractC1236 r7 = C1276.m16820();
            C1464Fy fy = C1464Fy.f5682;
            Object[] objArr = {"RowListOfMoviesViewHolder_Ab9296_ShortForm"};
            int length = objArr.length;
            String format = String.format("%s -  videoId is null.", Arrays.copyOf(objArr, 1));
            C1457Fr.m5016((Object) format, "java.lang.String.format(format, *args)");
            r7.mo5725(format);
        }
    }
}
