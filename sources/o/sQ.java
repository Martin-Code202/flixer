package o;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.model.leafs.social.multititle.NotificationGridTitleAction;
import java.util.List;
import kotlin.TypeCastException;
import o.sL;
import o.sM;
import o.sN;
import o.sO;
import o.sP;
public class sQ extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final iF f10093 = new iF(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private List<sW> f10094;

    /* renamed from: ˎ  reason: contains not printable characters */
    private RecyclerView f10095;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f10096;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f10097;

    public sQ(int i, int i2) {
        this.f10096 = i;
        this.f10097 = i2;
    }

    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.sQ$iF$if  reason: invalid class name */
        public static final class Cif implements View.OnClickListener {

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ NetflixActivity f10098;

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ String f10099;

            Cif(NetflixActivity netflixActivity, String str) {
                this.f10098 = netflixActivity;
                this.f10099 = str;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C0693.m14984(this.f10098, new Intent("android.intent.action.VIEW", Uri.parse(this.f10099)));
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m10657(NetflixActivity netflixActivity, View view, String str) {
            C1457Fr.m5025(netflixActivity, "activity");
            C1457Fr.m5025(view, "view");
            C1457Fr.m5025(str, "url");
            view.setOnClickListener(new Cif(netflixActivity, str));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public float mo10656() {
        return 0.71f;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        C1457Fr.m5025(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.f10095 = recyclerView;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        sW sWVar;
        List<sW> list = this.f10094;
        if (list != null && (sWVar = list.get(i)) != null) {
            return sWVar.mo10597();
        }
        throw new IndexOutOfBoundsException("MultiTitleNotificationsAdapter - position " + i + " is not valid");
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        C1457Fr.m5025(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        C1457Fr.m5016((Object) from, "LayoutInflater.from(parent.context)");
        switch (i) {
            case 0:
                View inflate = from.inflate(R.layout.multi_title_hero_headline, viewGroup, false);
                C1457Fr.m5016((Object) inflate, "inflater.inflate(R.layou…_headline, parent, false)");
                return new sN.iF(inflate);
            case 1:
                View inflate2 = from.inflate(R.layout.multi_title_hero_item, viewGroup, false);
                C1457Fr.m5016((Object) inflate2, "inflater.inflate(R.layou…hero_item, parent, false)");
                return new sP.If(inflate2);
            case 2:
                View inflate3 = from.inflate(R.layout.multi_title_grid_headline, viewGroup, false);
                C1457Fr.m5016((Object) inflate3, "inflater.inflate(R.layou…_headline, parent, false)");
                return new sO.If(inflate3);
            case 3:
            default:
                View inflate4 = from.inflate(R.layout.multi_title_grid_item, viewGroup, false);
                C1457Fr.m5016((Object) inflate4, "inflater.inflate(R.layou…grid_item, parent, false)");
                return new sL.C0188(inflate4);
            case 4:
                View inflate5 = from.inflate(R.layout.multi_title_call_to_action, viewGroup, false);
                C1457Fr.m5016((Object) inflate5, "inflater.inflate(R.layou…to_action, parent, false)");
                return new sM.iF(inflate5);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<sW> list = this.f10094;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        C1457Fr.m5025(viewHolder, "holder");
        List<sW> list = this.f10094;
        sW sWVar = list != null ? list.get(i) : null;
        RecyclerView recyclerView = this.f10095;
        Integer valueOf = recyclerView != null ? Integer.valueOf(recyclerView.getMeasuredWidth()) : null;
        if (viewHolder instanceof sN.iF) {
            sN.iF iFVar = (sN.iF) viewHolder;
            if (sWVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.HeroHeadline");
            }
            iFVar.m10618((sN) sWVar);
        } else if (viewHolder instanceof sP.If) {
            sP.If r0 = (sP.If) viewHolder;
            if (sWVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.HeroTitle");
            }
            r0.m10649((sP) sWVar, valueOf, 1.778f);
        } else if (viewHolder instanceof sO.If) {
            sO.If r02 = (sO.If) viewHolder;
            if (sWVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.GridHeadline");
            }
            r02.m10621((sO) sWVar);
        } else if (viewHolder instanceof sL.C0188) {
            sL.C0188 r03 = (sL.C0188) viewHolder;
            if (sWVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.GridTitle");
            }
            r03.m10604((sL) sWVar, mo10654(((sL) sWVar).m10596()), valueOf, mo10656(), this.f10096, this.f10097);
        } else if (viewHolder instanceof sM.iF) {
            sM.iF iFVar2 = (sM.iF) viewHolder;
            if (sWVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.CallToActionRow");
            }
            iFVar2.m10613((sM) sWVar);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo10654(NotificationGridTitleAction notificationGridTitleAction) {
        C1457Fr.m5025(notificationGridTitleAction, "gridTitleAction");
        String boxshot = notificationGridTitleAction.getBoxshot();
        C1457Fr.m5016((Object) boxshot, "gridTitleAction.boxshot");
        return boxshot;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final boolean m10655(int i) {
        sW sWVar;
        List<sW> list = this.f10094;
        if (list == null || (sWVar = list.get(i)) == null) {
            return false;
        }
        return sWVar.m10690();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final boolean m10653(int i) {
        List<sW> list = this.f10094;
        sW sWVar = list != null ? list.get(i) : null;
        if (sWVar instanceof sL) {
            return ((sL) sWVar).m10598();
        }
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m10652(List<sW> list) {
        this.f10094 = list;
        notifyDataSetChanged();
    }
}
