package o;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.previews.PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$2;
import com.netflix.mediaclient.ui.previews.PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$3;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C1133;
/* renamed from: o.zc  reason: case insensitive filesystem */
public final class C2367zc extends C1133.If {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2367zc(List<yR> list) {
        super(C1462Fw.m5045(list));
        C1457Fr.m5025(list, "dataList");
    }

    @Override // o.C1133.If
    /* renamed from: ˋ  reason: contains not printable characters */
    public C1133.Cif mo13596(ViewGroup viewGroup) {
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_preview_title_bar, viewGroup, false);
        C1457Fr.m5016((Object) inflate, "view");
        return new Cif(this, inflate, this);
    }

    /* renamed from: o.zc$if  reason: invalid class name */
    public final class Cif extends C1133.Cif {

        /* renamed from: ˏ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f12785 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "titleImg", "getTitleImg()Lcom/netflix/mediaclient/android/widget/AdvancedImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "currProgress", "getCurrProgress()Landroid/widget/ProgressBar;"))};

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2367zc f12786;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final FI f12787 = C1197.m16479(this, (int) R.id.curr_progress);

        /* renamed from: ˎ  reason: contains not printable characters */
        private Disposable f12788;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final FI f12789 = C1197.m16479(this, (int) R.id.previews_title_treatment);

        /* access modifiers changed from: private */
        /* renamed from: ʻ  reason: contains not printable characters */
        public final ProgressBar m13597() {
            return (ProgressBar) this.f12787.mo4986(this, f12785[1]);
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        private final C0522 m13598() {
            return (C0522) this.f12789.mo4986(this, f12785[0]);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(C2367zc zcVar, View view, C1133.If r4) {
            super(view, r4);
            C1457Fr.m5025(view, "view");
            C1457Fr.m5025(r4, "adapter");
            this.f12786 = zcVar;
        }

        public String toString() {
            String str;
            int size = m16308().m16302().size();
            int r4 = m16306();
            if (0 <= r4 && size > r4) {
                Object obj = m16308().m16302().get(m16306());
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.previews.PreviewsFeedItemModel");
                }
                str = ((yR) obj).getTitle();
            } else {
                str = "";
            }
            return "" + m16306() + " - " + str + " x = " + m16303().m16310() + ", width = " + m16303().width + ", height = " + m16303().height + ", visible = " + (m16309().getVisibility() == 0) + ' ';
        }

        @Override // o.C1133.Cif
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo13601(Object obj) {
            C1457Fr.m5025(obj, "item");
            Object obj2 = obj;
            if (!(obj2 instanceof yR)) {
                obj2 = null;
            }
            yR yRVar = (yR) obj2;
            if (yRVar != null) {
                m13598().setVisibility(0);
                String titleTreatmentUrl = yRVar.getTitleTreatmentUrl();
                m13598().setPassActualScaleTypeToParent(true);
                m13598().setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageLoader imageLoader = NetflixActivity.getImageLoader(m16309().getContext());
                if (imageLoader != null) {
                    imageLoader.mo3063(m13598(), titleTreatmentUrl, AssetType.boxArt, yRVar.getTitle(), BrowseExperience.m1769(), true, 1);
                }
                m13597().setVisibility(0);
                m13597().setProgressTintList(ColorStateList.valueOf(yRVar.getForegroundColor()));
            }
        }

        @Override // o.C1133.Cif
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo13603(int i) {
            super.mo13603(i);
            if (i != -1 && i < m16308().m16302().size()) {
                Object obj = m16308().m16302().get(i);
                if (obj instanceof yR) {
                    Observable<Integer> observeOn = ((yR) obj).m13246().onErrorResumeNext(Observable.just(Integer.valueOf(m13597().getProgress()))).filter(C0321.f12790).observeOn(AndroidSchedulers.mainThread());
                    C1457Fr.m5016((Object) observeOn, "previewItem.playProgress…dSchedulers.mainThread())");
                    this.f12788 = SubscribersKt.subscribeBy$default(observeOn, PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$3.f3824, null, new PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$2(this), 2, null);
                }
            }
        }

        /* renamed from: o.zc$if$ˊ  reason: contains not printable characters */
        static final class C0321<T> implements Predicate<Integer> {

            /* renamed from: ˎ  reason: contains not printable characters */
            public static final C0321 f12790 = new C0321();

            C0321() {
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final boolean test(Integer num) {
                C1457Fr.m5025(num, "it");
                return C1457Fr.m5021(num.intValue(), 0) >= 0;
            }
        }

        @Override // o.C1133.Cif
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo13602() {
            super.mo13602();
            Disposable disposable = this.f12788;
            if (disposable != null) {
                disposable.dispose();
            }
        }

        @Override // o.C1133.Cif
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo13600() {
            m13598().setImageDrawable(null);
        }
    }
}
