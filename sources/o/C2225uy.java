package o;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.ui.lolomo.ab9031.ListOfGenresAdapter$GenreViewHolder$3;
import com.netflix.mediaclient.ui.lolomo.ab9031.ListOfGenresAdapter$GenreViewHolder$4;
import com.netflix.mediaclient.ui.lolomo.ab9031.ListOfGenresAdapter$GenreViewHolder$5;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import kotlin.TypeCastException;
import org.json.JSONObject;
/* renamed from: o.uy  reason: case insensitive filesystem */
public final class C2225uy extends RecyclerView.Adapter<C0238> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final PublishSubject<Integer> f11047 = PublishSubject.create();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC2218ur f11048;

    public C2225uy(AbstractC2218ur urVar) {
        C1457Fr.m5025(urVar, "genresModel");
        this.f11048 = urVar;
    }

    /* renamed from: o.uy$ˊ  reason: contains not printable characters */
    public static final class C0238 extends RecyclerView.ViewHolder {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final AbstractC2218ur f11049;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0238(View view, ViewGroup viewGroup, AbstractC2218ur urVar, PublishSubject<Integer> publishSubject) {
            super(view);
            C1457Fr.m5025(view, "itemView");
            C1457Fr.m5025(viewGroup, "parent");
            C1457Fr.m5025(urVar, Device.MODEL);
            C1457Fr.m5025(publishSubject, "clickSubject");
            this.f11049 = urVar;
            Observable<R> map = C0965.m15783(view).takeUntil(C0965.m15784(viewGroup)).filter(new Predicate<Object>(this) { // from class: o.uy.ˊ.3

                /* renamed from: ॱ  reason: contains not printable characters */
                final /* synthetic */ C0238 f11051;

                {
                    this.f11051 = r1;
                }

                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    C1457Fr.m5025(obj, "it");
                    return this.f11051.getAdapterPosition() != -1;
                }
            }).map(new Function<T, R>(this) { // from class: o.uy.ˊ.1

                /* renamed from: ˋ  reason: contains not printable characters */
                final /* synthetic */ C0238 f11050;

                {
                    this.f11050 = r1;
                }

                @Override // io.reactivex.functions.Function
                public /* synthetic */ Object apply(Object obj) {
                    return Integer.valueOf(m11792(obj));
                }

                /* renamed from: ˎ  reason: contains not printable characters */
                public final int m11792(Object obj) {
                    C1457Fr.m5025(obj, "it");
                    return this.f11050.getAdapterPosition();
                }
            });
            C1457Fr.m5016((Object) map, "RxView.clicks(itemView)\n… .map { adapterPosition }");
            SubscribersKt.subscribeBy(map, new ListOfGenresAdapter$GenreViewHolder$4(publishSubject), new ListOfGenresAdapter$GenreViewHolder$5(publishSubject), new ListOfGenresAdapter$GenreViewHolder$3(this, publishSubject));
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final AbstractC2218ur m11790() {
            return this.f11049;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m11791(GenreList genreList) {
            C0716 r0 = (C0716) this.itemView.findViewById(R.Cif.item_label);
            C1457Fr.m5016((Object) r0, "item_label");
            r0.setText(genreList != null ? genreList.getTitle() : null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.uy$ˊ$iF */
        public static final class iF implements AbstractC0574 {

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ GenreList f11052;

            iF(GenreList genreList) {
                this.f11052 = genreList;
            }

            @Override // o.AbstractC0503
            public final JSONObject toJSONObject() {
                return new JSONObject().put("genreId", C1457Fr.m5018(this.f11052.getId(), "lolomo") ? "all" : this.f11052.getId());
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public final AbstractC0574 m11789(GenreList genreList) {
            return new iF(genreList);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m11786() {
        C1300Ac.m3531(new C1080(AppView.closeButton, null), new C1099(), true);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0238 onCreateViewHolder(ViewGroup viewGroup, int i) {
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.genre_selection_list_item_ab9031, viewGroup, false);
        C1457Fr.m5016((Object) inflate, "view");
        AbstractC2218ur urVar = this.f11048;
        PublishSubject<Integer> publishSubject = this.f11047;
        C1457Fr.m5016((Object) publishSubject, "onClickSubject");
        return new C0238(inflate, viewGroup, urVar, publishSubject);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void onBindViewHolder(C0238 r2, int i) {
        C1457Fr.m5025(r2, "holder");
        r2.m11791(this.f11048.mo11734().get(i));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        C1457Fr.m5025(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Logger.INSTANCE.m131(new C0785(false, AppView.categorySelector, null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11048.mo11735();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Observable<Integer> m11784() {
        PublishSubject<Integer> publishSubject = this.f11047;
        if (publishSubject != null) {
            return publishSubject;
        }
        throw new TypeCastException("null cannot be cast to non-null type io.reactivex.Observable<kotlin.Int>");
    }
}
