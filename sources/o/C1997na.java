package o;

import com.netflix.mediaclient.service.pservice.PDiskData;
import com.netflix.mediaclient.service.pservice.PServiceABTest$1;
import com.netflix.mediaclient.service.pservice.PServiceABTest$2;
import java.util.Map;
/* renamed from: o.na  reason: case insensitive filesystem */
public final class C1997na {

    /* renamed from: ˊ  reason: contains not printable characters */
    static Map<PDiskData.ListType, Integer> f9099 = new PServiceABTest$1();

    /* renamed from: ˋ  reason: contains not printable characters */
    static Map<PDiskData.ListType, Integer> f9100 = new PServiceABTest$2();

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m9265(PDiskData.ListType listType, PDiskData pDiskData) {
        if (pDiskData == null || C1349Bv.m4113(pDiskData.preAppWidgetExperience)) {
            return f9100.get(listType).intValue();
        }
        String str = pDiskData.preAppWidgetExperience;
        char c = 65535;
        switch (str.hashCode()) {
            case 1544803905:
                if (str.equals("default")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            default:
                return f9100.get(listType).intValue();
        }
    }
}
