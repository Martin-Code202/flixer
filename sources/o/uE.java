package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.model.leafs.originals.BillboardSummary;
import com.netflix.model.leafs.originals.ListOfTagSummary;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C1106;
public final class uE extends uD {

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final C2198iF f10700 = new C2198iF(null);

    /* renamed from: ॱˋ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f10701 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(uE.class), "tagStub", "getTagStub()Landroid/view/ViewStub;"))};

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final C1106 f10702;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final FI f10703;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final List<ListOfTagSummary> f10704;

    public uE(Context context) {
        this(context, null, 0, 6, null);
    }

    public uE(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final ViewStub m11356() {
        return (ViewStub) this.f10703.mo4986(this, f10701[0]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uE(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f10703 = C1197.m16465(this, (int) R.id.tag_container);
        this.f10704 = new ArrayList();
        if (C0714.f14240.m15043()) {
            m11356().setLayoutResource(R.layout.tags_layout_clickable_ab9080);
        } else {
            m11356().setLayoutResource(R.layout.tags_layout_non_clickable_ab9080);
        }
        m11356().inflate();
        View findViewById = findViewById(R.id.tag_container);
        C1457Fr.m5016((Object) findViewById, "findViewById(R.id.tag_container)");
        this.f10702 = (C1106) findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ uE(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.uE$iF  reason: case insensitive filesystem */
    public static final class C2198iF {
        private C2198iF() {
        }

        public /* synthetic */ C2198iF(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m11360(ListOfTagSummary listOfTagSummary) {
            C1457Fr.m5025(listOfTagSummary, "tag");
            if (listOfTagSummary.getTrackingInfo() == null) {
                C1276.m16820().mo5725("BillboardView_Ab9080_Tags: Mobile Tags Test: trackingInfo for tag: " + listOfTagSummary + " should not be null");
            }
            C1300Ac.m3531(new C1080(AppView.titleDescriptorTag, listOfTagSummary.getTrackingInfo()), new C0344(), true);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.uD, com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ˋ */
    public int mo2117() {
        return R.layout.billboard_view_ab9080_tags;
    }

    @Override // o.uD, com.netflix.mediaclient.ui.lomo.BillboardView
    /* renamed from: ˋ */
    public void mo2123(AbstractC2077pz pzVar, AbstractC2087qh qhVar, int i, boolean z, boolean z2) {
        BillboardSummary billboardSummary;
        List<ListOfTagSummary> list;
        super.mo2123(pzVar, qhVar, i, z, z2);
        if ((pzVar == null || pzVar.isOriginal()) && pzVar != null && (billboardSummary = pzVar.getBillboardSummary()) != null && (list = billboardSummary.tags) != null) {
            if (this.f3265 != null) {
                TextView textView = this.f3265;
                C1457Fr.m5016((Object) textView, "infoPhone");
                textView.setVisibility(8);
            }
            if (this.f10704.isEmpty()) {
                List<ListOfTagSummary> list2 = this.f10704;
                C1457Fr.m5016((Object) list, "it");
                list2.addAll(list);
            }
            if (!m11352(pzVar.getBillboardSummary())) {
                C1457Fr.m5016((Object) list, "it");
                m11357(list);
            }
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public final List<ListOfTagSummary> m11358() {
        List<ListOfTagSummary> list = this.f10704;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t.getIsVisible()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final class If implements C1106.AbstractC2410iF {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ List f10705;

        If(List list) {
            this.f10705 = list;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public String mo10301(int i) {
            return ((ListOfTagSummary) this.f10705.get(i)).getTitle();
        }

        @Override // o.C1106.AbstractC2410iF
        /* renamed from: ˊ */
        public int mo10300() {
            return this.f10705.size();
        }

        @Override // o.C1106.AbstractC2410iF
        /* renamed from: ॱ */
        public void mo10304(int i) {
            ((ListOfTagSummary) this.f10705.get(i)).setIsVisible(true);
        }

        @Override // o.C1106.AbstractC2410iF
        /* renamed from: ˏ */
        public boolean mo10303(int i) {
            return C0714.f14240.m15043();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m11357(List<? extends ListOfTagSummary> list) {
        this.f10702.setAdapter(new If(list));
        this.f10702.setOnTagClickListener(new Cif(this, list));
    }

    /* renamed from: o.uE$if  reason: invalid class name */
    public static final class Cif implements C1106.Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ uE f10706;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ List f10707;

        Cif(uE uEVar, List list) {
            this.f10706 = uEVar;
            this.f10707 = list;
        }

        @Override // o.C1106.Cif
        /* renamed from: ˏ */
        public void mo10297(View view, int i) {
            C1457Fr.m5025(view, "view");
            if (C0714.f14240.m15043()) {
                ListOfTagSummary listOfTagSummary = (ListOfTagSummary) this.f10707.get(i);
                uE.f10700.m11360(listOfTagSummary);
                Context context = this.f10706.getContext();
                if (context == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.android.activity.NetflixActivity");
                }
                ActivityC2153sl.m10769((NetflixActivity) context, listOfTagSummary);
            }
        }
    }
}
