package com.netflix.model.branches;

import com.netflix.falkor.BranchMap;
import com.netflix.model.leafs.originals.BillboardSummary;
import o.AbstractC1264;
public class FalkorBillboardData extends BranchMap<BillboardSummary> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private BillboardSummary f4086;

    public FalkorBillboardData(AbstractC1264<BillboardSummary> r1) {
        super(r1);
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1113967769:
                if (str.equals("billboardSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4086;
            default:
                return null;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1113967769:
                if (str.equals("billboardSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                BillboardSummary billboardSummary = new BillboardSummary();
                this.f4086 = billboardSummary;
                return billboardSummary;
            default:
                return null;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1113967769:
                if (str.equals("billboardSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4086 = (BillboardSummary) obj;
                return;
            default:
                return;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }
}
