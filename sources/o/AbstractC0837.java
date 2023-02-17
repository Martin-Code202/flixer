package o;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.netflix.android.widgetry.widget.TrackedLayoutManager;
import java.util.List;
import o.AbstractC0835;
import o.AbstractC0837.AbstractC0838;
import o.C0602;
/* renamed from: o.ᓯ  reason: contains not printable characters */
public abstract class AbstractC0837<T extends AbstractC0838> extends RecyclerView.Adapter<T> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Context f14655;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14656;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C0840 f14657;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0954 f14658;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final LayoutInflater f14659;

    /* renamed from: ॱ  reason: contains not printable characters */
    private TrackedLayoutManager f14660;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final RecyclerView.OnScrollListener f14661 = new RecyclerView.OnScrollListener() { // from class: o.ᓯ.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            AbstractC0837.this.mo11681(recyclerView, i);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            AbstractC0837.this.m15483(recyclerView, i, i2);
        }
    };

    /* renamed from: ˏ */
    public abstract void mo11297(T t, int i);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ<T extends o.ᓯ$ˋ> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m15484((AbstractC0837<T>) ((AbstractC0838) viewHolder), i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ<T extends o.ᓯ$ˋ> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return m15485((AbstractC0837<T>) ((AbstractC0838) viewHolder));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ<T extends o.ᓯ$ˋ> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        mo11682((AbstractC0837<T>) ((AbstractC0838) viewHolder));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ<T extends o.ᓯ$ˋ> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        m15487((AbstractC0837<T>) ((AbstractC0838) viewHolder));
    }

    public AbstractC0837(Context context, AbstractC0954 r3, int i) {
        this.f14655 = context;
        this.f14659 = LayoutInflater.from(this.f14655);
        this.f14658 = r3;
        this.f14656 = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public Context m15486() {
        return this.f14655;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC0954 m15489() {
        return this.f14658;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public int m15482() {
        return this.f14656;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15487(T t) {
        t.X_();
        super.onViewRecycled(t);
    }

    /* renamed from: ˋ */
    public void mo11294(View view) {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public LinearLayoutManager m15491() {
        return (LinearLayoutManager) this.f14660;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public RecyclerView m15481() {
        return this.f14657;
    }

    /* renamed from: ˏ */
    public void mo10895(RecyclerView recyclerView, int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15483(RecyclerView recyclerView, int i, int i2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo11681(RecyclerView recyclerView, int i) {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m15484(T t, int i) {
        mo11297((AbstractC0837<T>) t, i);
        t.m15498(m15489());
        t.m15497(i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m15485(T t) {
        t.Y_();
        return super.onFailedToRecycleView(t);
    }

    /* renamed from: ˊ */
    public void mo11682(T t) {
        if (((AbstractC0838) t).itemView.getLayoutParams() == null || ((AbstractC0838) t).itemView.getLayoutParams().width < 0 || ((AbstractC0838) t).itemView.getLayoutParams().height < 0) {
            t.m15498(m15489());
        }
        t.mo11025();
        super.onViewAttachedToWindow(t);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void onViewDetachedFromWindow(T t) {
        t.mo11723();
        super.onViewDetachedFromWindow(t);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void onBindViewHolder(T t, int i, List<Object> list) {
        m15484((AbstractC0837<T>) t, i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f14660 = (TrackedLayoutManager) recyclerView.getLayoutManager();
        this.f14657 = (C0840) recyclerView;
        recyclerView.addOnScrollListener(this.f14661);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f14660 = null;
        this.f14657 = null;
        recyclerView.removeOnScrollListener(this.f14661);
    }

    /* renamed from: ˋ */
    public void mo11293(Context context) {
    }

    /* renamed from: ˊ */
    public void mo11306(Context context) {
    }

    /* renamed from: ˎ */
    public void mo11311(Context context) {
    }

    /* renamed from: ॱ */
    public void mo11300(Context context) {
    }

    /* renamed from: ˋ */
    public void mo11308(Context context, boolean z) {
    }

    /* renamed from: ॱॱ */
    public boolean mo10904() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo11291(AbstractC0835.AbstractC2404iF iFVar) {
    }

    /* renamed from: o.ᓯ$ˋ  reason: contains not printable characters */
    public static abstract class AbstractC0838 extends RecyclerView.ViewHolder {

        /* renamed from: ˊ  reason: contains not printable characters */
        protected final C1045 f14664;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final View f14665;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final ViewGroup f14666;

        public AbstractC0838(ViewGroup viewGroup, View view, AbstractC0954 r4, int i) {
            super(m15496(view));
            if (this.itemView instanceof C1045) {
                this.f14664 = (C1045) this.itemView;
            } else {
                this.f14664 = null;
            }
            this.f14665 = this.itemView.findViewById(i);
            this.f14666 = viewGroup;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static View m15496(View view) {
            if (!C0407.m14210(view.getContext(), C0602.IF.debug_recyclerview_item_overlay)) {
                return view;
            }
            C1045 r3 = new C1045(view.getContext());
            r3.addView(view, new FrameLayout.LayoutParams(-1, -1));
            return r3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public void m15498(final AbstractC0954 r8) {
            if (this.f14664 != null) {
                this.f14664.mo16047();
            }
            if (this.f14666.getMeasuredWidth() == 0) {
                C1283.m16851("BaseRowAdapter", "[pos=%d] Parent not measured yet, will layout cover view later...", Integer.valueOf(getAdapterPosition()));
                this.f14666.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.ᓯ.ˋ.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        AbstractC0838.this.f14666.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AbstractC0838.this.m15498(r8);
                    }
                });
                return;
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
            if (layoutParams == null) {
                View view = this.itemView;
                layoutParams = new RecyclerView.LayoutParams(0, 0);
                view.setLayoutParams(layoutParams);
            }
            m15494(r8, layoutParams);
            if (m15495(r8, layoutParams)) {
                C1283.m16851("BaseRowAdapter", "[pos=%d] Layout cover view to %dx%d", Integer.valueOf(getAdapterPosition()), Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                layoutParams.setMargins(r8.mo15084(), r8.mo15084(), r8.mo15084(), r8.mo15084());
                this.itemView.requestLayout();
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m15494(AbstractC0954 r7, RecyclerView.LayoutParams layoutParams) {
            if (r7.mo15082() < 1) {
                throw new IllegalStateException("config.numberOfItemsPerPage need a positive integer");
            }
            int r3 = r7.mo15084() * 2;
            if (r7.mo15090() > 0.0f) {
                int measuredWidth = this.f14666.getMeasuredWidth() - r7.mo15076();
                layoutParams.width = (measuredWidth / r7.mo15082()) - r3;
                layoutParams.width = ((measuredWidth - ((int) (r7.mo15090() * ((float) layoutParams.width)))) / r7.mo15082()) - r3;
                return;
            }
            layoutParams.width = ((this.f14666.getMeasuredWidth() - (r7.mo15076() * 2)) / r7.mo15082()) - r3;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean m15495(AbstractC0954 r6, RecyclerView.LayoutParams layoutParams) {
            if (layoutParams.width == 0) {
                throw new IllegalStateException("call to adjustItemWidth() method is required before calling adjustItemHeight()");
            } else if (r6.mo15085() > 0.0f) {
                layoutParams.height = (int) (((float) layoutParams.width) * r6.mo15085());
                if (r6.mo15091() <= 0 || layoutParams.height <= r6.mo15091()) {
                    return true;
                }
                switch (r6.mo15081()) {
                    case 0:
                        layoutParams.height = r6.mo15091();
                        return true;
                    case 1:
                        C1283.m16851("BaseRowAdapter", "[pos=%d] Item height too large, request re-layout with one additional item", Integer.valueOf(getAdapterPosition()));
                        m15498(r6.m15772());
                        return false;
                    default:
                        return true;
                }
            } else {
                layoutParams.height = -2;
                return true;
            }
        }

        /* renamed from: ˏ */
        public void mo11025() {
            if (this.f14664 != null) {
                this.f14664.mo16051();
            }
        }

        /* renamed from: ˋ */
        public void mo11723() {
            if (this.f14664 != null) {
                this.f14664.mo16052();
            }
        }

        public void X_() {
            if (this.f14664 != null) {
                this.f14664.mo16053();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m15497(int i) {
            if (this.f14664 != null) {
                this.f14664.mo16050(i);
            }
        }

        public void Y_() {
            if (this.f14664 != null) {
                this.f14664.mo16049();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static If m15480(Context context, int i) {
        return new If(context, i);
    }

    /* renamed from: o.ᓯ$If */
    public static class If extends AbstractC0837<AbstractC0838> {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static final AbstractC0954 f14663 = AbstractC0954.m15771(0).mo15105();

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ$If */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
        public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            AbstractC0837.super.m15484((If) ((AbstractC0838) viewHolder), i);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ$If */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
        public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
            AbstractC0837.super.onBindViewHolder((AbstractC0838) viewHolder, i, list);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ$If */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
        public /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
            return AbstractC0837.super.m15485((If) ((AbstractC0838) viewHolder));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ$If */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
        public /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            AbstractC0837.super.mo11682((If) ((AbstractC0838) viewHolder));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ$If */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
        public /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            AbstractC0837.super.onViewDetachedFromWindow((AbstractC0838) viewHolder);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᓯ$If */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
        public /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            AbstractC0837.super.m15487((If) ((AbstractC0838) viewHolder));
        }

        If(Context context, int i) {
            super(context, f14663, i);
        }

        @Override // o.AbstractC0837
        /* renamed from: ˏ */
        public void mo11297(AbstractC0838 r1, int i) {
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public AbstractC0838 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return null;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }
    }
}
