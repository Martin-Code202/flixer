package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import java.util.LinkedList;
import java.util.List;
import o.C0904;
import o.pJ;
import o.tT;
/* renamed from: o.uo  reason: case insensitive filesystem */
public class C2215uo<O extends pJ> extends AbstractC2195ty<AbstractC0235, O> {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final AbstractC2072pu f11005 = new AbstractC2072pu() { // from class: o.uo.4
        @Override // o.AbstractC2072pu
        public String getId() {
            return "";
        }

        @Override // o.AbstractC2072pu
        public String getTitle() {
            return "";
        }

        @Override // o.AbstractC2072pu
        public VideoType getType() {
            return VideoType.UNAVAILABLE;
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0904 f11006;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final LinkedList<pJ> f11007 = new LinkedList<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0957 f11008 = new AbstractC0957() { // from class: o.uo.3
        @Override // o.AbstractC0957
        public void onErrorResponse(String str) {
        }

        @Override // o.AbstractC0957
        public void onResponse(Bitmap bitmap, String str) {
        }
    };

    public C2215uo(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r5, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r5, i);
        this.f11006 = new C0904(context, this);
    }

    C2215uo(Context context, pC pCVar, C2059ph phVar, UiLocation uiLocation, AbstractC0954 r6, int i) {
        super(context, pCVar, phVar, uiLocation, r6, i);
        this.f11006 = new C0904(context, this);
    }

    @Override // o.AbstractC2195ty, o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f11006.m15699(recyclerView);
    }

    @Override // o.AbstractC2195ty, o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f11006.m15698(recyclerView);
        super.onDetachedFromRecyclerView(recyclerView);
    }

    /* renamed from: ॱ */
    public AbstractC0235 onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
        layoutParams.leftMargin = m15489().mo15084();
        layoutParams.topMargin = m15489().mo15084();
        layoutParams.rightMargin = m15489().mo15084();
        layoutParams.bottomMargin = m15489().mo15084();
        if (i != 0) {
            return m11720(viewGroup, m15489(), layoutParams);
        }
        C1210 r3 = new C1210(viewGroup.getContext());
        r3.setId(R.id.movie_boxart);
        r3.setLayoutParams(layoutParams);
        return new Cif(viewGroup, r3, m15489());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public final If m11720(ViewGroup viewGroup, AbstractC0954 r9, RecyclerView.LayoutParams layoutParams) {
        View view = new View(viewGroup.getContext());
        view.setId(R.id.movie_boxart);
        view.setLayoutParams(layoutParams);
        if (r9.mo15086()) {
            return new C0234(viewGroup, view, r9, this.f11006);
        }
        return new If(viewGroup, view, r9, this.f11006);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo10910(AbstractC0235 r2, pJ pJVar, int i, boolean z) {
        r2.mo10906(m11288(), pJVar, i, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public void mo10900(AbstractC0235 r3, int i, boolean z) {
        r3.mo10906(m11288(), f11005, i, z);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0837
    /* renamed from: ˊ */
    public void mo11681(RecyclerView recyclerView, int i) {
        super.mo11681(recyclerView, i);
        if (i == 0) {
            m11719();
        } else if (i == 1) {
            while (!this.f11007.isEmpty()) {
                NetflixActivity.getImageLoader(m15486()).mo3060(this.f11007.pop().getBoxshotUrl(), AssetType.boxArt, 0, 0, this.f11008, false);
            }
        }
    }

    @Override // o.AbstractC0837
    /* renamed from: ˏ */
    public void mo10895(RecyclerView recyclerView, int i) {
        if (i == 0) {
            m11719();
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m11719() {
        RecyclerView r1 = m15481();
        if (r1 != null) {
            for (int i = 0; i < r1.getChildCount(); i++) {
                ((AbstractC0235) r1.getChildViewHolder(r1.getChildAt(i))).mo11023();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2195ty
    /* renamed from: ˎ */
    public void mo10902(List<O> list) {
        this.f11007.addAll(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uo$ˋ  reason: contains not printable characters */
    public static abstract class AbstractC0235 extends tT.AbstractC0216 {
        AbstractC0235(ViewGroup viewGroup, View view, AbstractC0954 r4) {
            super(viewGroup, view, r4, view.getId());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uo$if  reason: invalid class name */
    public static class Cif extends AbstractC0235 {

        /* renamed from: ॱ  reason: contains not printable characters */
        final C1210 f11013;

        Cif(ViewGroup viewGroup, C1210 r4, AbstractC0954 r5) {
            super(viewGroup, r4, r5);
            this.f11013 = r4;
            this.f11013.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        @Override // o.tT.AbstractC0216
        /* renamed from: ˊ */
        public void mo10906(tU tUVar, AbstractC2072pu puVar, int i, boolean z) {
            super.mo10906(tUVar, puVar, i, z);
            this.f11013.mo2123((pJ) puVar, tUVar.mo10878(), getAdapterPosition(), z, false);
        }

        @Override // o.tT.AbstractC0216, o.AbstractC0837.AbstractC0838
        public void X_() {
            super.X_();
            this.f11013.mo14543();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o.uo$If */
    public static class If extends AbstractC0235 implements C0904.AbstractC0905 {

        /* renamed from: ˋ  reason: contains not printable characters */
        protected AnimatedVectorDrawable f11010;

        /* renamed from: ˏ  reason: contains not printable characters */
        protected View f11011;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C0904 f11012;

        If(ViewGroup viewGroup, View view, AbstractC0954 r5, C0904 r6) {
            super(viewGroup, view, r5);
            int i;
            if (r5.mo15089()) {
                i = R.drawable.avd_lolomo_row_light_placeholder;
            } else {
                i = R.drawable.avd_lolomo_row_dark_placeholder;
            }
            this.f11010 = (AnimatedVectorDrawable) ContextCompat.getDrawable(viewGroup.getContext(), i);
            this.f11011 = view;
            this.f11012 = r6;
        }

        @Override // o.C0904.AbstractC0905
        /* renamed from: ॱ  reason: contains not printable characters */
        public View mo11725() {
            return this.f11011;
        }

        @Override // o.C0904.AbstractC0905
        /* renamed from: ˊ  reason: contains not printable characters */
        public AnimatedVectorDrawable mo11722() {
            return this.f11010;
        }

        @Override // o.C0904.AbstractC0905
        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean mo11724() {
            return true;
        }

        @Override // o.C0904.AbstractC0905
        /* renamed from: ʼ  reason: contains not printable characters */
        public Rect mo11721() {
            return null;
        }

        @Override // o.tT.AbstractC0216, o.AbstractC0837.AbstractC0838
        /* renamed from: ˏ */
        public void mo11025() {
            super.mo11025();
            this.f11012.m15695();
        }

        @Override // o.AbstractC0837.AbstractC0838
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo11723() {
            this.f11012.m15694();
            super.mo11723();
        }

        @Override // o.tT.AbstractC0216
        /* renamed from: ʻ */
        public void mo11023() {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o.uo$ˊ  reason: contains not printable characters */
    public static class C0234 extends If {
        private C0234(ViewGroup viewGroup, View view, AbstractC0954 r5, C0904 r6) {
            super(viewGroup, view, r5, r6);
            this.f11010 = (AnimatedVectorDrawable) ContextCompat.getDrawable(viewGroup.getContext(), r5.mo15089() ? R.drawable.avd_lolomo_row_light_circle_placeholder : R.drawable.avd_lolomo_row_dark_circle_placeholder);
        }

        @Override // o.C2215uo.If, o.C0904.AbstractC0905
        /* renamed from: ʼ */
        public Rect mo11721() {
            return new Rect(0, 0, this.itemView.getWidth(), this.itemView.getWidth());
        }
    }
}
