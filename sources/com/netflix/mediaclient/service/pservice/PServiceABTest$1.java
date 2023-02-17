package com.netflix.mediaclient.service.pservice;

import com.netflix.mediaclient.service.pservice.PDiskData;
import java.util.HashMap;
public class PServiceABTest$1 extends HashMap<PDiskData.ListType, Integer> {
    public PServiceABTest$1() {
        put(PDiskData.ListType.BILLBOARD, 1);
        put(PDiskData.ListType.CW, 1);
        put(PDiskData.ListType.IQ, 3);
        put(PDiskData.ListType.STANDARD_FIRST, 3);
        put(PDiskData.ListType.STANDARD_SECOND, 3);
        put(PDiskData.ListType.NON_MEMBER, 10);
    }
}
