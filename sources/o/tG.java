package o;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import com.netflix.mediaclient.ui.lomo.BillboardView;
import com.netflix.model.leafs.originals.ListOfTagSummary;
import java.util.List;
import java.util.Locale;
import o.tP;
import o.tT;
import o.uD;
import org.json.JSONException;
import org.json.JSONObject;
public class tG extends tT<Cif, AbstractC2077pz> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private uD.AbstractC0227 f10329;

    public tG(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r4, int i, uD.AbstractC0227 r6) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r4, i);
        this.f10329 = r6;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10907(uD.AbstractC0227 r1) {
        this.f10329 = r1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Cif onCreateViewHolder(ViewGroup viewGroup, int i) {
        BillboardView billboardView;
        uD uDVar;
        Context context = viewGroup.getContext();
        if (tP.Cif.m10990()) {
            if (C0714.m15040()) {
                uDVar = new uE(context);
            } else {
                uDVar = new uD(context);
            }
            uDVar.setBillboardListener(this.f10329);
            billboardView = uDVar;
        } else {
            billboardView = new BillboardView(context);
        }
        billboardView.setId(R.id.billboard_view_group);
        return new Cif(viewGroup, billboardView, m15489(), R.id.billboard_view_group);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo10910(Cif ifVar, AbstractC2077pz pzVar, int i, boolean z) {
        ifVar.mo10906(m11288(), pzVar, i, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10900(Cif ifVar, int i, boolean z) {
        ifVar.m10913(m11288(), i, z);
    }

    @Override // o.AbstractC2195ty, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ˏ */
    public int mo10894(Context context, int i) {
        return (i + 3) - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tG$if  reason: invalid class name */
    public static class Cif extends tT.AbstractC0216 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final BillboardView f10330;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final C0489 f10331;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final FrameLayout f10332 = ((FrameLayout) this.itemView);

        Cif(ViewGroup viewGroup, BillboardView billboardView, AbstractC0954 r8, int i) {
            super(viewGroup, new FrameLayout(viewGroup.getContext()), r8, i);
            this.f10330 = billboardView;
            this.f10331 = new C0489(viewGroup.getContext());
            this.f10332.addView(this.f10330, new FrameLayout.LayoutParams(-1, -1));
            this.f10332.addView(this.f10331, new FrameLayout.LayoutParams(-2, -2));
            ((FrameLayout.LayoutParams) this.f10331.getLayoutParams()).gravity = 17;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m10913(tU tUVar, int i, boolean z) {
            this.f10330.setVisibility(4);
            this.f10331.setVisibility(0);
        }

        @Override // o.tT.AbstractC0216
        /* renamed from: ˊ */
        public void mo10906(tU tUVar, AbstractC2072pu puVar, int i, boolean z) {
            super.mo10906(tUVar, puVar, i, z);
            this.f10331.setVisibility(8);
            this.f10330.setVisibility(0);
            this.f10330.mo2123((AbstractC2077pz) puVar, tUVar.mo10878(), i, true, false);
        }

        @Override // o.tT.AbstractC0216, o.AbstractC0837.AbstractC0838
        public void X_() {
            this.f10330.mo2114();
            super.X_();
        }

        @Override // o.tT.AbstractC0216
        /* renamed from: ॱ  reason: contains not printable characters */
        public JSONObject mo10914(AbstractC2072pu puVar, tU tUVar) {
            if (!C0714.m15040() || !(this.f10330 instanceof uE)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            List<ListOfTagSummary> r8 = ((uE) this.f10330).m11358();
            if (r8.size() <= 0) {
                return null;
            }
            try {
                for (ListOfTagSummary listOfTagSummary : r8) {
                    jSONObject2.put(listOfTagSummary.getId(), listOfTagSummary.getPosition());
                    if (!(puVar == null || tUVar == null)) {
                        m10912(listOfTagSummary, puVar, tUVar);
                    }
                }
                jSONObject.put("titleDescriptorTagMap", jSONObject2);
            } catch (JSONException e) {
                C1276.m16820().mo5725(String.format(Locale.US, "%s: was not able to create tracking info JSON for tags: %s", "BillboardListAdapter", r8.toString()));
            }
            return jSONObject;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m10912(ListOfTagSummary listOfTagSummary, AbstractC2072pu puVar, tU tUVar) {
            pC r6 = tUVar.mo10878();
            listOfTagSummary.setTrackingInfo(puVar.getId(), r6.getRequestId(), r6.getTrackId(), tUVar.mo10875(), getAdapterPosition());
        }
    }
}
