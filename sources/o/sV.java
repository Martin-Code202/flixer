package o;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.util.ViewUtils;
import java.io.InvalidObjectException;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
public class sV extends AbstractC0517 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0194 f10120 = new C0194(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private HashMap f10121;

    /* renamed from: ʽ  reason: contains not printable characters */
    private vA f10122;

    /* renamed from: ˊ  reason: contains not printable characters */
    public View mo10682(int i) {
        if (this.f10121 == null) {
            this.f10121 = new HashMap();
        }
        View view = (View) this.f10121.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f10121.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void mo10687() {
        if (this.f10121 != null) {
            this.f10121.clear();
        }
    }

    /* renamed from: o.sV$ˋ  reason: contains not printable characters */
    public static final class C0194 {
        private C0194() {
        }

        public /* synthetic */ C0194(C1456Fq fq) {
            this();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        Log.v("MultiTitleNotifications", "Creating new multi-title notifications fragment.");
        View inflate = layoutInflater.inflate(R.layout.multi_title_notifications_frag, viewGroup, false);
        C1457Fr.m5016((Object) inflate, "content");
        return inflate;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        if (mo10686()) {
            m10689();
        }
    }

    @Override // o.AbstractC0459
    public final boolean isLoadingData() {
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo10686() {
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public sQ mo10688(int i, int i2) {
        return new sQ(i, i2);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final void m10689() {
        NetflixActionBar netflixActionBar;
        NetflixActivity r0 = m14534();
        if (r0 != null && (netflixActionBar = r0.getNetflixActionBar()) != null) {
            NetflixActivity r1 = m14534();
            C1457Fr.m5016((Object) r1, "netflixActivity");
            netflixActionBar.m355(r1.getActionBarStateBuilder().mo399(false).mo394("").mo392());
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void mo10684() {
        RecyclerView recyclerView = (RecyclerView) mo10682(R.Cif.recycler_view);
        C1457Fr.m5016((Object) recyclerView, "recycler_view");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new Cif(this));
        NetflixActivity r0 = m14534();
        C1457Fr.m5016((Object) r0, "netflixActivity");
        int dimensionPixelOffset = r0.getResources().getDimensionPixelOffset(R.dimen.text_padding);
        NetflixActivity r02 = m14534();
        C1457Fr.m5016((Object) r02, "netflixActivity");
        int dimensionPixelOffset2 = r02.getResources().getDimensionPixelOffset(R.dimen.medium_padding);
        RecyclerView recyclerView2 = (RecyclerView) mo10682(R.Cif.recycler_view);
        C1457Fr.m5016((Object) recyclerView2, "recycler_view");
        recyclerView2.setAdapter(mo10688(dimensionPixelOffset, dimensionPixelOffset2));
        RecyclerView recyclerView3 = (RecyclerView) mo10682(R.Cif.recycler_view);
        C1457Fr.m5016((Object) recyclerView3, "recycler_view");
        recyclerView3.setLayoutManager(gridLayoutManager);
        ((RecyclerView) mo10682(R.Cif.recycler_view)).addItemDecoration(new iF(dimensionPixelOffset, dimensionPixelOffset2, 2));
        RecyclerView recyclerView4 = (RecyclerView) mo10682(R.Cif.recycler_view);
        C1457Fr.m5016((Object) recyclerView4, "recycler_view");
        m10683((ViewGroup) recyclerView4);
    }

    /* renamed from: o.sV$if  reason: invalid class name */
    public static final class Cif extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ sV f10127;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        Cif(sV sVVar) {
            this.f10127 = sVVar;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            RecyclerView recyclerView = (RecyclerView) this.f10127.mo10682(R.Cif.recycler_view);
            C1457Fr.m5016((Object) recyclerView, "recycler_view");
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = (RecyclerView) this.f10127.mo10682(R.Cif.recycler_view);
                C1457Fr.m5016((Object) recyclerView2, "recycler_view");
                RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                if (adapter != null) {
                    return !((sQ) adapter).m10655(i) ? 2 : 1;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationsAdapter");
            }
            throw new InvalidObjectException("MultiTitleNotifications - span size is called even though adapter is null");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m10685(List<sW> list) {
        Log.d("MultiTitleNotifications", "Received list of multi-title notification rows.");
        mo10684();
        if (list != null && list.size() > 0) {
            m10680(list);
        }
        mo9990(AbstractC0367.f13235);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m10680(List<sW> list) {
        RecyclerView recyclerView = (RecyclerView) mo10682(R.Cif.recycler_view);
        if ((recyclerView != null ? recyclerView.getAdapter() : null) instanceof sQ) {
            RecyclerView recyclerView2 = (RecyclerView) mo10682(R.Cif.recycler_view);
            RecyclerView.Adapter adapter = recyclerView2 != null ? recyclerView2.getAdapter() : null;
            if (adapter == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationsAdapter");
            }
            ((sQ) adapter).m10652(list);
        }
        ViewUtils.m3019((ProgressBar) mo10682(R.Cif.loading_view), 8);
        ViewUtils.m3019((RecyclerView) mo10682(R.Cif.recycler_view), 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m10683(ViewGroup viewGroup) {
        C1457Fr.m5025(viewGroup, "viewGroup");
        m10681();
        AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(m14534());
        if (offlineAgentOrNull != null) {
            this.f10122 = new vA(viewGroup, false);
            offlineAgentOrNull.mo7124(this.f10122);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final void m10681() {
        AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(m14534());
        if (offlineAgentOrNull != null && this.f10122 != null) {
            offlineAgentOrNull.mo7135(this.f10122);
            this.f10122 = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        m10681();
        mo10687();
    }

    public final class iF extends RecyclerView.ItemDecoration {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f10123;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final int f10124;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f10126;

        public iF(int i, int i2, int i3) {
            this.f10126 = i;
            this.f10123 = i2;
            this.f10124 = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            C1457Fr.m5025(rect, "outRect");
            C1457Fr.m5025(view, "view");
            C1457Fr.m5025(recyclerView, "parent");
            C1457Fr.m5025(state, "state");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationsAdapter");
            }
            sQ sQVar = (sQ) adapter;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (sQVar.m10655(childAdapterPosition)) {
                rect.left = this.f10126 / 2;
                rect.right = this.f10126 / 2;
                rect.bottom = this.f10126 / 2;
                rect.top = this.f10126 / 2;
                if (sQVar.m10653(childAdapterPosition)) {
                    rect.left = this.f10123 / 2;
                }
                if (!sQVar.m10653(childAdapterPosition)) {
                    rect.right = this.f10123 / 2;
                }
            }
        }
    }
}
