package com.netflix.mediaclient.service.webclient.model.leafs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.C1457Fr;
import o.EI;
public final class PhoneCodesData {
    private final List<PhoneCode> phoneCodes;

    public PhoneCodesData(List<? extends Map<String, String>> list) {
        C1457Fr.m5025(list, "phoneCodeData");
        List<? extends Map<String, String>> list2 = list;
        ArrayList arrayList = new ArrayList(EI.m4812((Iterable) list2, 10));
        for (T t : list2) {
            String str = (String) t.get("id");
            str = str == null ? "" : str;
            String str2 = (String) t.get("code");
            str2 = str2 == null ? "" : str2;
            String str3 = (String) t.get("name");
            if (str3 == null) {
                str3 = "";
            }
            arrayList.add(new PhoneCode(str, str2, str3));
        }
        this.phoneCodes = arrayList;
    }

    public final List<PhoneCode> getPhoneCodes() {
        return this.phoneCodes;
    }
}
