package o;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Checkable;
import android.widget.FrameLayout;
import com.netflix.mediaclient.servicemgr.UiLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import o.uO;
/* renamed from: o.ᒲ  reason: contains not printable characters */
public abstract class AbstractC0801 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private UiLocation f14513;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f14514 = true;

    /* renamed from: ʽ  reason: contains not printable characters */
    private AbstractC2087qh f14515;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f14516 = 2;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final List<pJ> f14517 = new ArrayList();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private View f14518;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected pR f14519;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<View> f14520 = new ArrayList();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f14521 = -1;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f14522 = -1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Checkable f14523 = null;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Cif f14524;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f14525 = -1;

    /* renamed from: o.ᒲ$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˏ */
        View mo4156(View view);
    }

    public AbstractC0801(Cif ifVar) {
        this.f14524 = ifVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo10425(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC2087qh m15317() {
        return this.f14515;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15329(AbstractC2087qh qhVar, UiLocation uiLocation) {
        this.f14513 = uiLocation;
        m15323(qhVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15323(AbstractC2087qh qhVar) {
        this.f14515 = qhVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15321(boolean z) {
        this.f14514 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public pJ m15322(int i) {
        if (i < this.f14517.size()) {
            return this.f14517.get(i);
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == this.f14516) {
            return new View$OnClickListenerC0802(this.f14524.mo4156(viewGroup), viewGroup.getContext());
        }
        if (i == 0) {
            return new View$OnClickListenerC0802(null, viewGroup.getContext());
        }
        if (i == 3) {
            return new View$OnClickListenerC0802(null, viewGroup.getContext());
        }
        throw new IllegalArgumentException("No matching type " + i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            m15307(viewHolder, i);
        } else if (itemViewType == 3) {
            m15309(viewHolder);
        } else if (itemViewType == this.f14516) {
            m15311(viewHolder, i - m15326());
        }
        mo10425(i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15307(RecyclerView.ViewHolder viewHolder, int i) {
        m15310(viewHolder, i);
        ((ViewGroup) viewHolder.itemView).addView(this.f14520.get(i));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15309(RecyclerView.ViewHolder viewHolder) {
        if (this.f14518 != null) {
            m15304(viewHolder);
            ((ViewGroup) viewHolder.itemView).addView(this.f14518);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15310(RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewGroup) viewHolder.itemView).removeAllViews();
        ViewParent parent = this.f14520.get(i).getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f14520.get(i));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15304(RecyclerView.ViewHolder viewHolder) {
        if (this.f14518 != null) {
            ((ViewGroup) viewHolder.itemView).removeAllViews();
            ViewParent parent = this.f14518.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.f14518);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15311(RecyclerView.ViewHolder viewHolder, int i) {
        pJ r6 = m15322(i);
        if (r6 != null) {
            if (viewHolder instanceof View$OnClickListenerC0802) {
                View$OnClickListenerC0802 r7 = (View$OnClickListenerC0802) viewHolder;
                r7.m15334(r6);
                r7.f14528.m13244(false);
            }
            View childAt = ((ViewGroup) viewHolder.itemView).getChildAt(0);
            if (childAt instanceof AbstractC2118rg) {
                ((AbstractC2118rg) childAt).mo10086(r6, this.f14519);
            } else if (childAt instanceof uO.Cif) {
                ((uO.Cif) childAt).mo2123(r6, m15317(), i, false, false);
            }
            m15306(i, childAt);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof View$OnClickListenerC0802) {
            View$OnClickListenerC0802 r2 = (View$OnClickListenerC0802) viewHolder;
            r2.f14528.m13244(false);
            yO.m13231(r2.f14528);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof View$OnClickListenerC0802) {
            View$OnClickListenerC0802 r1 = (View$OnClickListenerC0802) viewHolder;
            r1.m15334((pJ) null);
            yO.m13229(r1.f14528);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15306(int i, View view) {
        if (!(view instanceof Checkable)) {
            return;
        }
        if (i == this.f14525) {
            ((Checkable) view).setChecked(true);
        } else {
            ((Checkable) view).setChecked(false);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14517.size() + m15326() + (this.f14518 == null ? 0 : 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public int m15312() {
        return this.f14517.size();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m15326() {
        return this.f14520.size();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m15324() {
        return this.f14518 != null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m15325(View view, RecyclerView recyclerView) {
        return (view == null || recyclerView == null || recyclerView.getChildPosition(view) >= m15326()) ? false : true;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (m15316(i)) {
            return 0;
        }
        if (m15330(i)) {
            return 3;
        }
        return this.f14516;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15318(int i) {
        this.f14516 = i;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15313(Cif ifVar) {
        this.f14524 = ifVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15320(Collection<? extends pJ> collection, int i, Cif ifVar) {
        m15313(ifVar);
        m15318(i);
        m15328(collection);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15314() {
        this.f14517.clear();
        notifyDataSetChanged();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15328(Collection<? extends pJ> collection) {
        this.f14517.clear();
        this.f14517.addAll(collection);
        notifyDataSetChanged();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15315(Collection<? extends pJ> collection, int i) {
        if (i == 0) {
            this.f14517.clear();
        }
        this.f14517.addAll(collection);
        notifyDataSetChanged();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15327(View view) {
        if (!this.f14520.contains(view)) {
            this.f14520.add(view);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15319(View view) {
        this.f14518 = view;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m15316(int i) {
        return i < m15326();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m15330(int i) {
        return this.f14518 != null && i >= getItemCount() + -1;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m15332(int i) {
        if (!this.f14514) {
            C1283.m16846("RecyclerViewHeaderAdapter", "Not in single choice mode - skipping setItemChecked()");
        } else if (i < 0) {
            C1283.m16846("RecyclerViewHeaderAdapter", "Skipping setItemChecked() - invalid position: " + i);
        } else {
            int r3 = this.f14525 + m15326();
            this.f14525 = i - m15326();
            notifyItemChanged(r3);
            notifyItemChanged(i);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public int m15331() {
        return this.f14525;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public static View m15303(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return frameLayout;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᒲ$ˋ  reason: contains not printable characters */
    public class View$OnClickListenerC0802 extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        private pJ f14526;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final yQ f14528 = new yQ() { // from class: o.ᒲ.ˋ.4
            @Override // o.yQ
            /* renamed from: ॱ */
            public View mo11032() {
                return View$OnClickListenerC0802.this.itemView;
            }

            @Override // o.yQ
            /* renamed from: ˎ */
            public AbstractC2072pu mo11030() {
                return View$OnClickListenerC0802.this.m15335();
            }

            @Override // o.yQ
            /* renamed from: ˋ */
            public Integer mo11029() {
                if (View$OnClickListenerC0802.this.getAdapterPosition() == -1) {
                    return null;
                }
                return Integer.valueOf(View$OnClickListenerC0802.this.getAdapterPosition() - AbstractC0801.this.m15326());
            }

            @Override // o.yQ
            /* renamed from: ˏ */
            public Integer mo11031() {
                return 0;
            }

            @Override // o.yQ
            /* renamed from: ˊ */
            public AbstractC2087qh mo11028() {
                return AbstractC0801.this.f14515;
            }

            @Override // o.yQ
            /* renamed from: ᐝ */
            public UiLocation mo11034() {
                return AbstractC0801.this.f14513;
            }
        };

        public View$OnClickListenerC0802(View view, Context context) {
            super(AbstractC0801.m15303(context));
            if (view != null) {
                ((ViewGroup) this.itemView).addView(view);
                view.setOnClickListener(this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof AbstractC2118rg) || ((AbstractC2118rg) view).mo9942()) {
                AbstractC0801.this.m15332(getAdapterPosition());
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m15334(pJ pJVar) {
            this.f14526 = pJVar;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public pJ m15335() {
            return this.f14526;
        }
    }
}
