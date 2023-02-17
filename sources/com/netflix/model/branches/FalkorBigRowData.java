package com.netflix.model.branches;

import com.netflix.falkor.BranchMap;
import com.netflix.model.leafs.originals.BigRowSummary;
import o.AbstractC1264;
public class FalkorBigRowData extends BranchMap<BigRowSummary> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private BigRowSummary f4085;

    public FalkorBigRowData(AbstractC1264<BigRowSummary> r1) {
        super(r1);
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 627488140:
                if (str.equals("bigRowSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4085;
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
            case 627488140:
                if (str.equals("bigRowSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                BigRowSummary bigRowSummary = new BigRowSummary();
                this.f4085 = bigRowSummary;
                return bigRowSummary;
            default:
                return null;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case 627488140:
                if (str.equals("bigRowSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4085 = (BigRowSummary) obj;
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
