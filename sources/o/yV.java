package o;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
public final class yV extends RecyclerView.Adapter<yS> {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static boolean f12462;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Cif f12463 = new Cif(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    private PublishSubject<C0461> f12464;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f12465;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f12466 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    private oY f12467;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final List<yR> f12468;

    public yV(Context context, List<yR> list) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(list, "previewItems");
        this.f12465 = context;
        this.f12468 = list;
    }

    /* renamed from: o.yV$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final boolean m13298() {
            return yV.f12462;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m13299(boolean z) {
            yV.f12462 = z;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13297(boolean z) {
        this.f12466 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13294(PublishSubject<C0461> publishSubject) {
        this.f12464 = publishSubject;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13295(oY oYVar) {
        this.f12467 = oYVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12468.size();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public yS onCreateViewHolder(ViewGroup viewGroup, int i) {
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_previews_player, viewGroup, false);
        C1457Fr.m5016((Object) inflate, "viewItem");
        return new yS(inflate, this.f12467, this.f12464);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void onBindViewHolder(yS ySVar, int i) {
        C1457Fr.m5025(ySVar, "holder");
        ySVar.m13275(this.f12465, i, this.f12468);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean onFailedToRecycleView(yS ySVar) {
        C1457Fr.m5025(ySVar, "holder");
        ySVar.m13268();
        return super.onFailedToRecycleView(ySVar);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void onViewRecycled(yS ySVar) {
        C1457Fr.m5025(ySVar, "holder");
        super.onViewRecycled(ySVar);
        ySVar.m13271();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void onViewDetachedFromWindow(yS ySVar) {
        C1457Fr.m5025(ySVar, "holder");
        super.onViewDetachedFromWindow(ySVar);
        ySVar.m13273(this.f12468);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void onViewAttachedToWindow(yS ySVar) {
        C1457Fr.m5025(ySVar, "holder");
        super.onViewAttachedToWindow(ySVar);
        ySVar.m13270(this.f12466);
        this.f12466 = false;
    }
}
