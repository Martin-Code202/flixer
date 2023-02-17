package o;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.List;
import kotlin.TypeCastException;
import o.AbstractC2214un;
/* renamed from: o.uj  reason: case insensitive filesystem */
public final class C2210uj extends C2212ul {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f10987 = f10987;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final iF f10988 = new iF(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final TextView f10989;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2210uj(final View view, AbstractC0954 r7, AbstractC2214un.Cif ifVar) {
        super(view, r7, ifVar);
        C1457Fr.m5025(view, "itemView");
        C1457Fr.m5025(r7, "config");
        C1457Fr.m5025(ifVar, "onRetryListener");
        View findViewById = view.findViewById(R.id.lomo_title);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.f10989 = (TextView) findViewById;
        ViewUtils.m3011(this.f10989);
        if (r7.mo15089()) {
            ViewUtils.m3022(this.f10989, (int) R.color.kids_text_color);
            ViewUtils.m3012(this.f10989, (int) R.dimen.text_medium);
            this.f10989.setAllCaps(true);
        }
        this.f10989.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this.f10989.getContext(), R.drawable.ic_chevron_small), (Drawable) null);
        this.f10989.setOnClickListener(new View.OnClickListener(this) { // from class: o.uj.5

            /* renamed from: ॱ  reason: contains not printable characters */
            final /* synthetic */ C2210uj f10991;

            {
                this.f10991 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NetflixActivity netflixActivity;
                if (this.f10991.getAdapterPosition() != -1 && (netflixActivity = (NetflixActivity) C0345.m13893(view.getContext(), NetflixActivity.class)) != null) {
                    C2059ph serviceManager = netflixActivity.getServiceManager();
                    C1457Fr.m5016((Object) serviceManager, "activity.serviceManager");
                    oF r0 = serviceManager.m9764();
                    if (r0 != null) {
                        r0.mo9493(new Cif(netflixActivity, C2210uj.f10988.m11709()));
                    }
                }
            }

            /* renamed from: o.uj$5$if  reason: invalid class name */
            public static final class Cif extends oP {

                /* renamed from: ˊ  reason: contains not printable characters */
                final /* synthetic */ NetflixActivity f10992;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                Cif(NetflixActivity netflixActivity, String str) {
                    super(str);
                    this.f10992 = netflixActivity;
                }

                @Override // o.oP, o.oU
                public void onGenreListsFetched(List<? extends GenreList> list, Status status) {
                    C1457Fr.m5025(status, "res");
                    super.onGenreListsFetched(list, status);
                    if (status.mo301()) {
                        C1283.m16865(C2210uj.f10988.m11709(), "Invalid status code for genres fetch");
                    } else if (list != null && list.size() > 1) {
                        for (GenreList genreList : list) {
                            if (C1457Fr.m5018((Object) "839338", (Object) genreList.getId())) {
                                ActivityC2153sl.m10770(this.f10992, genreList, true);
                                return;
                            }
                        }
                    }
                }
            }
        });
    }

    /* renamed from: o.uj$iF */
    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final String m11709() {
            return C2210uj.f10987;
        }
    }

    @Override // o.C2212ul, o.AbstractC2214un
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo11706(pC pCVar) {
        C1457Fr.m5025(pCVar, "lomo");
        super.mo11706(pCVar);
        this.f10989.setText(pCVar.getTitle());
        this.f10989.setClickable(true);
        this.f10989.setCompoundDrawablePadding(20);
    }
}
