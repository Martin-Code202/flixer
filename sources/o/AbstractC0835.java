package o;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.android.widgetry.lolomo.MultiRowLinearLayoutManager;
import com.netflix.android.widgetry.lolomo.RowLinearLayoutManager;
import com.netflix.android.widgetry.widget.TrackedLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import o.AbstractC0835.AbstractC2404iF;
/* renamed from: o.ᓭ  reason: contains not printable characters */
public abstract class AbstractC0835<T extends AbstractC2404iF> extends RecyclerView.Adapter<T> {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final LayoutInflater f14645;

    /* renamed from: ˋ  reason: contains not printable characters */
    private SparseArray<AbstractC0954> f14646 = new SparseArray<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private SparseArray<Object> f14647;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ArrayList<AbstractC0837> f14648 = new ArrayList<>();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ArrayList<View> f14649 = new ArrayList<>(1);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final RecyclerView.OnScrollListener f14650 = new RecyclerView.OnScrollListener() { // from class: o.ᓭ.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Iterator it = AbstractC0835.this.f14648.iterator();
            while (it.hasNext()) {
                ((AbstractC0837) it.next()).mo10895(recyclerView, i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract void mo2053(T t, int i, AbstractC0837 v, Parcelable parcelable);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract int mo2054();

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract AbstractC0837 mo2055(Context context, AbstractC0954 v, int i);

    /* renamed from: ॱ */
    public abstract int mo2058(int i);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public abstract T mo2060(ViewGroup viewGroup, AbstractC0954 v);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓭ<T extends o.ᓭ$iF> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        m15457((AbstractC0835<T>) ((AbstractC2404iF) viewHolder));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓭ<T extends o.ᓭ$iF> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        m15465((AbstractC0835<T>) ((AbstractC2404iF) viewHolder));
    }

    public AbstractC0835(Context context, AbstractC0954... r8) {
        this.f14645 = LayoutInflater.from(context);
        for (AbstractC0954 r5 : r8) {
            this.f14646.put(r5.mo15078(), r5);
        }
        m15459();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15459() {
        m15471(this.f14645.getContext());
        this.f14648.clear();
        int r2 = mo2054() + m15466();
        this.f14647 = new SparseArray<>(r2);
        for (int i = 0; i < r2; i++) {
            AbstractC0837 r4 = mo2055(this.f14645.getContext(), m15464(i), i);
            r4.mo11293(this.f14645.getContext());
            this.f14648.add(r4);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(this.f14650);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        recyclerView.removeOnScrollListener(this.f14650);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final int m15466() {
        return this.f14649.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f14648.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return mo2058(this.f14648.get(i).m15482());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15469(Context context) {
        Iterator<AbstractC0837> it = this.f14648.iterator();
        while (it.hasNext()) {
            it.next().mo11306(context);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15460(Context context) {
        Iterator<AbstractC0837> it = this.f14648.iterator();
        while (it.hasNext()) {
            it.next().mo11311(context);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15471(Context context) {
        Iterator<AbstractC0837> it = this.f14648.iterator();
        while (it.hasNext()) {
            it.next().mo11300(context);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15470(Context context, boolean z) {
        Iterator<AbstractC0837> it = this.f14648.iterator();
        while (it.hasNext()) {
            it.next().mo11308(context, z);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC0954 m15464(int i) {
        int r3 = mo2058(i);
        AbstractC0954 r4 = this.f14646.get(r3);
        if (r4 != null) {
            return r4;
        }
        throw new IllegalArgumentException("No configuration for viewType = " + r3);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void onBindViewHolder(T t, int i) {
        AbstractC0837 r2 = this.f14648.get(i);
        mo2053(t, i, r2, (Parcelable) this.f14647.get(r2.m15482()));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m15454() {
        m15459();
        super.notifyDataSetChanged();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m15455(int i, int i2) {
        m15459();
        super.notifyItemRangeInserted(i, i2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m15468(int i) {
        m15459();
        super.notifyItemRemoved(i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC0837 m15453(int i) {
        return this.f14648.get(i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        return mo2060(viewGroup, this.f14646.get(i));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m15457(T t) {
        m15452((RecyclerView.ViewHolder) t);
        super.onViewDetachedFromWindow(t);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m15465(T t) {
        m15452((RecyclerView.ViewHolder) t);
        super.onViewRecycled(t);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15452(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof Cif) {
            Cif ifVar = (Cif) viewHolder;
            int adapterPosition = ifVar.getAdapterPosition();
            if (adapterPosition != -1) {
                this.f14647.put(adapterPosition, ifVar.f14654.getLayoutManager().onSaveInstanceState());
            } else {
                C1283.m16865("BaseVerticalRecyclerViewAdapter", "Unable to save state, holder position == NO_POSITION");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public Parcelable m15463(C0843 r4) {
        If r1 = new If();
        for (int i = 0; i < r4.getChildCount(); i++) {
            m15452(r4.getChildViewHolder(r4.getChildAt(i)));
        }
        r1.f14652 = this.f14647;
        return r1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15456(Parcelable parcelable) {
        this.f14647 = ((If) parcelable).f14652;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public View m15458(int i) {
        return this.f14649.get(i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m15462(View view) {
        boolean z = false;
        int indexOf = this.f14649.indexOf(view);
        if (indexOf != -1 && (z = this.f14649.remove(view))) {
            m15468(indexOf);
        }
        return z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15472(View view) {
        this.f14649.add(view);
        m15454();
    }

    /* renamed from: o.ᓭ$If */
    public static class If implements Parcelable {
        public static final Parcelable.Creator<If> CREATOR = new Parcelable.Creator<If>() { // from class: o.ᓭ.If.3
            /* renamed from: ˋ  reason: contains not printable characters */
            public If createFromParcel(Parcel parcel) {
                return new If(parcel);
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public If[] newArray(int i) {
                return new If[i];
            }
        };

        /* renamed from: ॱ  reason: contains not printable characters */
        private SparseArray<Object> f14652;

        public If() {
        }

        If(Parcel parcel) {
            this.f14652 = parcel.readSparseArray(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeSparseArray(this.f14652);
        }
    }

    /* renamed from: o.ᓭ$iF  reason: case insensitive filesystem */
    public static abstract class AbstractC2404iF extends RecyclerView.ViewHolder {
        protected AbstractC2404iF(View view) {
            super(view);
        }

        /* renamed from: ˎ */
        public void mo11717(boolean z) {
        }
    }

    /* renamed from: o.ᓭ$if  reason: invalid class name */
    public static abstract class Cif<T> extends AbstractC2404iF {

        /* renamed from: ˋ  reason: contains not printable characters */
        public final LinearLayoutManager f14653;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final C0840 f14654;

        /* renamed from: ˊ */
        public abstract void mo11706(T t);

        protected Cif(View view, AbstractC0954 r8, int i) {
            super(view);
            if (r8.mo15083() < 2) {
                this.f14653 = new RowLinearLayoutManager(view.getContext(), 0, false);
            } else {
                this.f14653 = new MultiRowLinearLayoutManager(view.getContext(), r8.mo15083(), 0, false);
            }
            this.f14654 = (C0840) view.findViewById(i);
            if (this.f14654 == null) {
                throw new IllegalArgumentException("lomoId not found in itemView");
            }
            this.f14654.setLayoutManager(this.f14653);
            this.f14654.setScrollingTouchSlop(1);
            if (r8.mo15079() != null) {
                this.f14654.setRecycledViewPool(r8.mo15079());
            }
            this.f14654.setHasFixedSize(true);
            this.f14653.setInitialPrefetchItemCount(r8.mo15082() + 1);
            this.f14654.setPadding(r8.mo15076(), 0, r8.mo15076(), 0);
            this.f14654.setNestedScrollingEnabled(false);
            if (r8.mo15087()) {
                return;
            }
            if (r8.mo15082() == 1) {
                new PagerSnapHelper().attachToRecyclerView(this.f14654);
            } else {
                new C0869().m15573(this.f14654, r8);
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final void m15477(T t, AbstractC0837 r4, Parcelable parcelable) {
            this.f14654.swapAdapter(r4, false);
            if (parcelable != null) {
                this.f14653.onRestoreInstanceState(parcelable);
            }
            mo11706(t);
            r4.mo11291(this);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final void m15478(String str) {
            if (this.f14653 instanceof TrackedLayoutManager) {
                ((TrackedLayoutManager) this.f14653).mo105(str);
            }
        }
    }
}
