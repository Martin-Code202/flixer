package com.netflix.mediaclient.acquisition.viewmodels;

import java.util.List;
import o.C1457Fr;
public final class PlanGridRowData {
    private final String localizedHeading;
    private final List<Object> values;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.netflix.mediaclient.acquisition.viewmodels.PlanGridRowData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlanGridRowData copy$default(PlanGridRowData planGridRowData, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = planGridRowData.localizedHeading;
        }
        if ((i & 2) != 0) {
            list = planGridRowData.values;
        }
        return planGridRowData.copy(str, list);
    }

    public final String component1() {
        return this.localizedHeading;
    }

    public final List<Object> component2() {
        return this.values;
    }

    public final PlanGridRowData copy(String str, List<? extends Object> list) {
        C1457Fr.m5025(str, "localizedHeading");
        C1457Fr.m5025(list, "values");
        return new PlanGridRowData(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlanGridRowData)) {
            return false;
        }
        PlanGridRowData planGridRowData = (PlanGridRowData) obj;
        return C1457Fr.m5018(this.localizedHeading, planGridRowData.localizedHeading) && C1457Fr.m5018(this.values, planGridRowData.values);
    }

    public int hashCode() {
        String str = this.localizedHeading;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Object> list = this.values;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "PlanGridRowData(localizedHeading=" + this.localizedHeading + ", values=" + this.values + ")";
    }

    public PlanGridRowData(String str, List<? extends Object> list) {
        C1457Fr.m5025(str, "localizedHeading");
        C1457Fr.m5025(list, "values");
        this.localizedHeading = str;
        this.values = list;
    }

    public final String getLocalizedHeading() {
        return this.localizedHeading;
    }

    public final List<Object> getValues() {
        return this.values;
    }
}
