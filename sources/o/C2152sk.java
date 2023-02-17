package o;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.Video;
import java.util.List;
import kotlin.TypeCastException;
/* renamed from: o.sk  reason: case insensitive filesystem */
public final class C2152sk extends RecyclerView.Adapter<C0203> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f10169 = "WatchHistoryAdapter";

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0206 f10170;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f10171 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<? extends CH> f10172;

    /* renamed from: o.sk$ˋ  reason: contains not printable characters */
    public interface AbstractC0206 {
        /* renamed from: ˊ */
        void mo10728(int i);

        /* renamed from: ˋ */
        void mo10729(int i);

        /* renamed from: ˏ */
        void mo10731();
    }

    public C2152sk(AbstractC0206 r2) {
        this.f10170 = r2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final AbstractC0206 m10752() {
        return this.f10170;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final String m10748() {
        return this.f10169;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends o.CH>, java.util.List<o.CH> */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final List<CH> m10745() {
        return this.f10172;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0203 onCreateViewHolder(ViewGroup viewGroup, int i) {
        C1457Fr.m5025(viewGroup, "parent");
        Object systemService = viewGroup.getContext().getSystemService("layout_inflater");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.watch_history_list_item, viewGroup, false);
        C1457Fr.m5016((Object) inflate, "inflater.inflate(R.layou…list_item, parent, false)");
        return new C0203(this, inflate);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (m10747()) {
            List<? extends CH> list = this.f10172;
            if (list != null) {
                return list.size() + 1;
            }
            return 0;
        }
        List<? extends CH> list2 = this.f10172;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void onBindViewHolder(C0203 r2, int i) {
        C1457Fr.m5025(r2, "holder");
        View view = r2.itemView;
        if ((view != null ? view.getContext() : null) != null) {
            List<? extends CH> list = this.f10172;
            r2.m10753(list != null ? (CH) EI.m4834((List<? extends Object>) list, i) : null);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m10749(List<? extends CH> list) {
        this.f10172 = list;
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m10744() {
        AbstractC0206 r0;
        if (m10747() && (r0 = this.f10170) != null) {
            r0.mo10731();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m10750(boolean z) {
        this.f10171 = z;
        notifyDataSetChanged();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final boolean m10747() {
        List<? extends CH> list = this.f10172;
        return list != null && list.size() % 30 == 0 && this.f10171;
    }

    /* renamed from: o.sk$ˊ  reason: contains not printable characters */
    public final class C0203 extends RecyclerView.ViewHolder {

        /* renamed from: ʻ  reason: contains not printable characters */
        private final ProgressBar f10173;

        /* renamed from: ʼ  reason: contains not printable characters */
        private final TextView f10174;

        /* renamed from: ʽ  reason: contains not printable characters */
        private final View.OnLongClickListener f10175;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final LinearLayout f10176;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final TextView f10177;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final C0522 f10178;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2152sk f10179;

        /* renamed from: ͺ  reason: contains not printable characters */
        private final View.OnClickListener f10180;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final ProgressBar f10181;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private final ImageView f10182;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final View.OnClickListener f10183;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0203(C2152sk skVar, View view) {
            super(view);
            C1457Fr.m5025(view, "itemView");
            this.f10179 = skVar;
            View findViewById = view.findViewById(R.id.watch_history_item_content);
            if (findViewById == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            this.f10176 = (LinearLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.loading_view);
            if (findViewById2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ProgressBar");
            }
            this.f10181 = (ProgressBar) findViewById2;
            View findViewById3 = view.findViewById(R.id.watch_history_box_shot);
            if (findViewById3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.android.widget.AdvancedImageView");
            }
            this.f10178 = (C0522) findViewById3;
            View findViewById4 = view.findViewById(R.id.watch_history_title);
            if (findViewById4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.f10177 = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.watch_history_date);
            if (findViewById5 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.f10174 = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.watch_history_video_progress);
            if (findViewById6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ProgressBar");
            }
            this.f10173 = (ProgressBar) findViewById6;
            View findViewById7 = view.findViewById(R.id.watch_history_delete);
            if (findViewById7 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
            }
            this.f10182 = (ImageView) findViewById7;
            this.f10183 = new View$OnClickListenerC0205(this);
            this.f10175 = new iF(this);
            this.f10180 = new View$OnClickListenerC0204(this);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m10753(CH ch) {
            String str;
            int i;
            pF playable;
            pF playable2;
            Video.Bookmark bookmark;
            Video.Bookmark bookmark2;
            View view = this.itemView;
            int adapterPosition = getAdapterPosition();
            List<CH> r1 = this.f10179.m10745();
            if (r1 != null && adapterPosition == r1.size() - 30) {
                this.f10179.m10744();
            }
            int adapterPosition2 = getAdapterPosition();
            List<CH> r12 = this.f10179.m10745();
            if (r12 == null || adapterPosition2 != r12.size()) {
                this.f10176.setVisibility(0);
                this.f10181.setVisibility(8);
                View view2 = this.itemView;
                C1457Fr.m5016((Object) view2, "itemView");
                Context context = view2.getContext();
                ImageLoader imageLoader = NetflixActivity.getImageLoader(context);
                if (imageLoader != null) {
                    imageLoader.mo3057(this.f10178, ch != null ? ch.getTvCardUrl() : null, AssetType.boxArt, "icon", StaticImgConfig.DARK, true);
                }
                if (ch instanceof C1383Cz) {
                    C2149si siVar = C2149si.f10161;
                    C1457Fr.m5016((Object) context, "context");
                    str = siVar.m10732(context, (C1383Cz) ch);
                } else {
                    str = ch != null ? ch.getTitle() : null;
                }
                this.f10177.setText(str);
                this.f10174.setText(C1352By.m4138((ch == null || (bookmark2 = ch.getBookmark()) == null) ? -1 : bookmark2.getLastModified()));
                int max = Math.max(0, (ch == null || (bookmark = ch.getBookmark()) == null) ? 0 : bookmark.getBookmarkPosition());
                if (((ch == null || (playable2 = ch.getPlayable()) == null) ? 0 : playable2.getRuntime()) > 0) {
                    i = (max * 100) / ((ch == null || (playable = ch.getPlayable()) == null) ? 1 : playable.getRuntime());
                } else {
                    i = 0;
                }
                this.f10173.setProgress(i);
                this.f10176.setOnClickListener(this.f10183);
                View view3 = this.itemView;
                if (C0654.m14814(view3 != null ? view3.getContext() : null)) {
                    this.f10176.setOnLongClickListener(this.f10175);
                    this.f10182.setOnClickListener(this.f10180);
                    return;
                }
                this.f10182.setVisibility(8);
                return;
            }
            this.f10176.setVisibility(8);
            this.f10181.setVisibility(0);
        }

        /* renamed from: o.sk$ˊ$ˋ  reason: contains not printable characters */
        static final class View$OnClickListenerC0205 implements View.OnClickListener {

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ C0203 f10186;

            View$OnClickListenerC0205(C0203 r1) {
                this.f10186 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int adapterPosition = this.f10186.getAdapterPosition();
                if (adapterPosition != -1) {
                    AbstractC0206 r0 = this.f10186.f10179.m10752();
                    if (r0 != null) {
                        r0.mo10729(adapterPosition);
                        return;
                    }
                    return;
                }
                C1283.m16863(this.f10186.f10179.m10748(), "clickCellListener position=%d", Integer.valueOf(adapterPosition));
            }
        }

        /* renamed from: o.sk$ˊ$iF */
        static final class iF implements View.OnLongClickListener {

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ C0203 f10184;

            iF(C0203 r1) {
                this.f10184 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                this.f10184.m10754();
                return true;
            }
        }

        /* renamed from: o.sk$ˊ$ˊ  reason: contains not printable characters */
        static final class View$OnClickListenerC0204 implements View.OnClickListener {

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ C0203 f10185;

            View$OnClickListenerC0204(C0203 r1) {
                this.f10185 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10185.m10754();
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m10754() {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1) {
                AbstractC0206 r0 = this.f10179.m10752();
                if (r0 != null) {
                    r0.mo10728(adapterPosition);
                    return;
                }
                return;
            }
            C1283.m16863(this.f10179.m10748(), "deleteClickAction position=%d", Integer.valueOf(adapterPosition));
        }
    }
}
