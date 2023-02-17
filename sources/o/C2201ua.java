package o;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import com.netflix.model.leafs.PreviewsFeedItemSummary;
import java.util.ArrayList;
import java.util.Arrays;
import o.C2215uo;
/* renamed from: o.ua  reason: case insensitive filesystem */
public final class C2201ua extends C2215uo<pD> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f10968;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2201ua(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r5, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r5, i);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(pCVar, "lomo");
        C1457Fr.m5025(lolomoRecyclerViewAdapter, "parentAdapter");
        C1457Fr.m5025(r5, "config");
    }

    @Override // o.AbstractC0837
    /* renamed from: ॱॱ */
    public boolean mo10904() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2195ty
    /* renamed from: ˊ */
    public void mo10892(Context context, C2059ph phVar, int i, int i2, oU oUVar, Intent intent) {
        C1457Fr.m5025(phVar, "serviceManager");
        C1457Fr.m5025(oUVar, "updateVideosManagerCallback");
        yT.f12460.m13286(i);
        yT.f12460.m13280(i2);
        oF r0 = phVar.m9764();
        pC r1 = m11301();
        C1457Fr.m5016((Object) r1, "lomo");
        r0.mo9477(i, i2, r1.getId(), oUVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2215uo, o.AbstractC0837
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo11681(RecyclerView recyclerView, int i) {
        yR r13;
        C1457Fr.m5025(recyclerView, "recyclerView");
        super.mo11681(recyclerView, i);
        this.f10968 = i;
        switch (i) {
            case 0:
                ArrayList arrayList = new ArrayList();
                int childCount = recyclerView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt != null) {
                        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                        if ((childViewHolder instanceof C0232) && (r13 = ((C0232) childViewHolder).m11684()) != null) {
                            arrayList.add(r13);
                            ((C0232) childViewHolder).m11685();
                        }
                    }
                }
                yN yNVar = yN.f12408;
                Context context = recyclerView.getContext();
                C1457Fr.m5016((Object) context, "recyclerView.context");
                yNVar.m13223(context);
                yN yNVar2 = yN.f12408;
                Context context2 = recyclerView.getContext();
                C1457Fr.m5016((Object) context2, "recyclerView.context");
                yN.m13222(yNVar2, arrayList, context2, 0, 0, 12, null);
                return;
            default:
                return;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11682(C2215uo.AbstractC0235 r6) {
        yR r3;
        C1457Fr.m5025(r6, "holder");
        super.mo11682((C2201ua) r6);
        if (this.f10968 == 0 && (r6 instanceof C0232) && (r3 = ((C0232) r6).m11684()) != null) {
            ((C0232) r6).m11685();
            yN yNVar = yN.f12408;
            View view = r6.itemView;
            C1457Fr.m5016((Object) view, "holder.itemView");
            Context context = view.getContext();
            C1457Fr.m5016((Object) context, "holder.itemView.context");
            yNVar.m13224(r3, context);
        }
    }

    @Override // o.C2215uo
    /* renamed from: ॱ */
    public C2215uo.AbstractC0235 onCreateViewHolder(ViewGroup viewGroup, int i) {
        C1457Fr.m5025(viewGroup, "parent");
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
        layoutParams.leftMargin = m15489().mo15084();
        layoutParams.topMargin = m15489().mo15084();
        layoutParams.rightMargin = m15489().mo15084();
        layoutParams.bottomMargin = m15489().mo15084();
        if (i == 0) {
            Context context = viewGroup.getContext();
            C1457Fr.m5016((Object) context, "parent.context");
            pC r2 = m11301();
            C1457Fr.m5016((Object) r2, "lomo");
            String id = r2.getId();
            C1457Fr.m5016((Object) id, "lomo.id");
            tX tXVar = new tX(context, id, null, 4, null);
            View r8 = tXVar.m14352();
            r8.setId(tXVar.m11046());
            r8.setLayoutParams(layoutParams);
            AbstractC0954 r1 = m15489();
            C1457Fr.m5016((Object) r1, "config");
            return new C0232(viewGroup, tXVar, r1);
        }
        C2215uo.If r0 = m11720(viewGroup, m15489(), layoutParams);
        C1457Fr.m5016((Object) r0, "createLoadingViewHolder(parent, config, lp)");
        return r0;
    }

    /* renamed from: o.ua$ˊ  reason: contains not printable characters */
    public static final class C0232 extends C2215uo.AbstractC0235 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private yR f10969;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final tX f10970;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0232(ViewGroup viewGroup, tX tXVar, AbstractC0954 r4) {
            super(viewGroup, tXVar.m14352(), r4);
            C1457Fr.m5025(viewGroup, "parent");
            C1457Fr.m5025(tXVar, "previewsLolomoUIView");
            C1457Fr.m5025(r4, "config");
            this.f10970 = tXVar;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final yR m11684() {
            return this.f10969;
        }

        @Override // o.tT.AbstractC0216
        /* renamed from: ˊ */
        public void mo10906(tU tUVar, AbstractC2072pu puVar, int i, boolean z) {
            C1457Fr.m5025(tUVar, "lomoContext");
            super.mo10906(tUVar, puVar, i, z);
            if (puVar instanceof PreviewsFeedItemSummary) {
                ((PreviewsFeedItemSummary) puVar).setPosition(i);
                yR yRVar = new yR((pD) puVar);
                String panelArtUrl = yRVar.getPanelArtUrl();
                String titleTreatmentUrl = yRVar.getTitleTreatmentUrl();
                if (panelArtUrl == null || titleTreatmentUrl == null) {
                    C1276.m16820().mo5727("cant render box art, null artwork for " + yRVar);
                } else {
                    tX tXVar = this.f10970;
                    qN qNVar = new qN(tUVar.mo10878(), i);
                    boolean isOriginal = yRVar.isOriginal();
                    C1464Fy fy = C1464Fy.f5682;
                    View view = this.itemView;
                    C1457Fr.m5016((Object) view, "itemView");
                    Context context = view.getContext();
                    C1457Fr.m5016((Object) context, "itemView.context");
                    String string = context.getResources().getString(R.string.accesibility_play_video);
                    C1457Fr.m5016((Object) string, "itemView.context.resourc….accesibility_play_video)");
                    Object[] objArr = {yRVar.getTitle()};
                    int length = objArr.length;
                    String format = String.format(string, Arrays.copyOf(objArr, 1));
                    C1457Fr.m5016((Object) format, "java.lang.String.format(format, *args)");
                    tXVar.mo11047(new C2202ub(i, qNVar, panelArtUrl, isOriginal, titleTreatmentUrl, format, false, yRVar.getForegroundColor(), yRVar.getBackgroundColor(), z ? 1 : 0, 64, null));
                }
                this.f10969 = yRVar;
            }
        }

        @Override // o.tT.AbstractC0216, o.AbstractC0837.AbstractC0838
        public void X_() {
            super.X_();
            this.f10969 = null;
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        public final EA m11685() {
            C1045 r0 = this.f14664;
            if (r0 == null) {
                return null;
            }
            r0.m16048("Sending prefetch hint");
            return EA.f5503;
        }
    }
}
