package o;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.android.kotlinx.ButterKnifeKt$lifecycleFinder$1;
import com.netflix.android.kotlinx.ButterKnifeKt$optional$1;
import com.netflix.android.kotlinx.ButterKnifeKt$required$1;
import com.netflix.android.kotlinx.ButterKnifeKt$viewFinder$1;
import com.netflix.android.kotlinx.ButterKnifeKt$viewFinder$10;
import com.netflix.android.kotlinx.ButterKnifeKt$viewFinder$7;
import com.netflix.android.kotlinx.ButterKnifeKt$viewFinder$8;
import com.netflix.android.kotlinx.ButterKnifeKt$viewFinder$9;
import com.netflix.mediaclient.common.ui.LifecycleController;
import o.C1133;
/* renamed from: o.ﺫ  reason: contains not printable characters */
public final class C1197 {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <V extends View> FI<View, V> m16465(View view, int i) {
        C1457Fr.m5025(view, "$receiver");
        return m16473(i, m16476(view));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <V extends View> FI<Fragment, V> m16464(Fragment fragment, int i) {
        C1457Fr.m5025(fragment, "$receiver");
        return m16473(i, m16475(fragment));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final <V extends View> FI<RecyclerView.ViewHolder, V> m16471(RecyclerView.ViewHolder viewHolder, int i) {
        C1457Fr.m5025(viewHolder, "$receiver");
        return m16473(i, m16466(viewHolder));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <V extends View> FI<LifecycleController<?>, V> m16474(LifecycleController<?> lifecycleController, int i) {
        C1457Fr.m5025(lifecycleController, "$receiver");
        return m16473(i, m16467(lifecycleController));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final <V extends View> FI<AbstractC0467, V> m16470(AbstractC0467 r1, int i) {
        C1457Fr.m5025(r1, "$receiver");
        return m16473(i, m16477(r1));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <V extends View> FI<C1133.Cif, V> m16479(C1133.Cif ifVar, int i) {
        C1457Fr.m5025(ifVar, "$receiver");
        return m16473(i, m16472(ifVar));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <V extends View> FI<View, V> m16478(View view, int i) {
        C1457Fr.m5025(view, "$receiver");
        return m16468(i, m16476(view));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final AbstractC1451Fl<View, Integer, View> m16476(View view) {
        return ButterKnifeKt$viewFinder$1.f150;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final AbstractC1451Fl<Fragment, Integer, View> m16475(Fragment fragment) {
        return ButterKnifeKt$viewFinder$7.f152;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final AbstractC1451Fl<RecyclerView.ViewHolder, Integer, View> m16466(RecyclerView.ViewHolder viewHolder) {
        return ButterKnifeKt$viewFinder$8.f153;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final AbstractC1451Fl<LifecycleController<?>, Integer, View> m16467(LifecycleController<?> lifecycleController) {
        return ButterKnifeKt$lifecycleFinder$1.f145;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final AbstractC1451Fl<AbstractC0467, Integer, View> m16477(AbstractC0467 r1) {
        return ButterKnifeKt$viewFinder$9.f154;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final AbstractC1451Fl<C1133.Cif, Integer, View> m16472(C1133.Cif ifVar) {
        return ButterKnifeKt$viewFinder$10.f151;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public static final Void m16469(int i, FQ<?> fq) {
        throw new IllegalStateException("View ID " + i + " for '" + fq.getName() + "' not found.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final <T, V extends View> C0347<T, V> m16473(int i, AbstractC1451Fl<? super T, ? super Integer, ? extends View> fl) {
        return new C0347<>(new ButterKnifeKt$required$1(fl, i));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final <T, V extends View> C0347<T, V> m16468(int i, AbstractC1451Fl<? super T, ? super Integer, ? extends View> fl) {
        return new C0347<>(new ButterKnifeKt$optional$1(fl, i));
    }
}
