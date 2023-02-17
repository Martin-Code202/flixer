package o;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.res.Configuration;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o.rZ;
public final class rS extends RecyclerView.Adapter<rZ.AbstractC2110iF> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final SimpleDateFormat f9675 = new SimpleDateFormat("mm:ss", Locale.getDefault());

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final iF f9676 = new iF(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final LifecycleOwner f9677;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final TrailersFeedViewModel f9678;

    /* renamed from: ˎ  reason: contains not printable characters */
    private List<rW> f9679 = Collections.emptyList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<rZ.AbstractC2110iF> f9680 = new ArrayList();

    public rS(TrailersFeedViewModel trailersFeedViewModel, LifecycleOwner lifecycleOwner) {
        C1457Fr.m5025(trailersFeedViewModel, "trailersFeedViewModel");
        C1457Fr.m5025(lifecycleOwner, "owner");
        this.f9678 = trailersFeedViewModel;
        this.f9677 = lifecycleOwner;
        this.f9678.m1933().observe(this.f9677, new Observer<List<? extends rW>>(this) { // from class: o.rS.2

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ rS f9681;

            {
                this.f9681 = r1;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final void onChanged(List<rW> list) {
                C1283.m16854("TrailersFeedAdapter", "Got new " + (list != null ? Integer.valueOf(list.size()) : null) + " item(s)");
                if (list instanceof List) {
                    List list2 = this.f9681.f9679;
                    C1457Fr.m5016((Object) list2, "oldItems");
                    if (!list2.isEmpty()) {
                        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new C0173(list2, list));
                        this.f9681.f9679 = list;
                        calculateDiff.dispatchUpdatesTo(this.f9681);
                        return;
                    }
                    this.f9681.f9679 = list;
                    this.f9681.notifyItemRangeInserted(0, list.size());
                }
            }

            /* renamed from: o.rS$2$ˋ  reason: contains not printable characters */
            public static final class C0173 extends DiffUtil.Callback {

                /* renamed from: ˊ  reason: contains not printable characters */
                final /* synthetic */ List f9682;

                /* renamed from: ˋ  reason: contains not printable characters */
                final /* synthetic */ List f9683;

                C0173(List list, List list2) {
                    this.f9683 = list;
                    this.f9682 = list2;
                }

                @Override // android.support.v7.util.DiffUtil.Callback
                public boolean areItemsTheSame(int i, int i2) {
                    return C1457Fr.m5018((rW) this.f9683.get(i), (rW) this.f9682.get(i2));
                }

                @Override // android.support.v7.util.DiffUtil.Callback
                public boolean areContentsTheSame(int i, int i2) {
                    return C1457Fr.m5018((rW) this.f9683.get(i), (rW) this.f9682.get(i2));
                }

                @Override // android.support.v7.util.DiffUtil.Callback
                public int getNewListSize() {
                    return this.f9682.size();
                }

                @Override // android.support.v7.util.DiffUtil.Callback
                public int getOldListSize() {
                    return this.f9683.size();
                }
            }
        });
    }

    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final SimpleDateFormat m10184() {
            return rS.f9675;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return C1457Fr.m5018(this.f9679.get(i), TrailersFeedViewModel.f3143.m1960()) ? 2 : 1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public rZ.AbstractC2110iF onCreateViewHolder(ViewGroup viewGroup, int i) {
        rZ.If r4;
        C1457Fr.m5025(viewGroup, "parent");
        switch (i) {
            case 1:
                TrailersFeedViewModel trailersFeedViewModel = this.f9678;
                LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
                C1457Fr.m5016((Object) from, "LayoutInflater.from(parent.context)");
                r4 = new rZ.Cif(trailersFeedViewModel, from, viewGroup);
                break;
            case 2:
                LayoutInflater from2 = LayoutInflater.from(viewGroup.getContext());
                C1457Fr.m5016((Object) from2, "LayoutInflater.from(parent.context)");
                r4 = new rZ.If(from2, viewGroup);
                break;
            default:
                throw new IllegalArgumentException("unexpected type");
        }
        this.f9680.add(r4);
        return r4;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void onBindViewHolder(rZ.AbstractC2110iF iFVar, int i) {
        C1457Fr.m5025(iFVar, "holder");
        rW rWVar = this.f9679.get(i);
        C1457Fr.m5016((Object) rWVar, "itemList[position]");
        iFVar.m10242(i, rWVar, null, this.f9678.m1940(i));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void onViewAttachedToWindow(rZ.AbstractC2110iF iFVar) {
        C1457Fr.m5025(iFVar, "holder");
        iFVar.mo10237();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void onViewDetachedFromWindow(rZ.AbstractC2110iF iFVar) {
        C1457Fr.m5025(iFVar, "holder");
        iFVar.mo10239();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void onViewRecycled(rZ.AbstractC2110iF iFVar) {
        C1457Fr.m5025(iFVar, "holder");
        iFVar.mo10246();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean onFailedToRecycleView(rZ.AbstractC2110iF iFVar) {
        C1457Fr.m5025(iFVar, "holder");
        return iFVar.mo10244();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9679.size();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m10175(Configuration configuration) {
        C1457Fr.m5025(configuration, "newConfig");
        Iterator<T> it = this.f9680.iterator();
        while (it.hasNext()) {
            it.next().mo10243(configuration);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m10181() {
        Iterator<T> it = this.f9680.iterator();
        while (it.hasNext()) {
            it.next().mo10241();
        }
        this.f9680.clear();
    }
}
