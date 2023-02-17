package com.netflix.model.branches;

import com.netflix.falkor.BranchMap;
import com.netflix.model.leafs.originals.TallPanelAsset;
import o.AbstractC1264;
public class FalkorRoarData extends BranchMap<TallPanelAsset> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private TallPanelAsset f4095;

    public FalkorRoarData(AbstractC1264<TallPanelAsset> r1) {
        super(r1);
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1722431145:
                if (str.equals("tallPanel")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4095;
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
            case -1722431145:
                if (str.equals("tallPanel")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                TallPanelAsset tallPanelAsset = new TallPanelAsset();
                this.f4095 = tallPanelAsset;
                return tallPanelAsset;
            default:
                return null;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1722431145:
                if (str.equals("tallPanel")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4095 = (TallPanelAsset) obj;
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
