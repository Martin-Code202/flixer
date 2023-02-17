package o;

import com.netflix.mediaclient.servicemgr.PlayLocationType;
public class oB extends qN {
    public oB(String str) {
        super("", -100, -1, -1, PlayLocationType.UNKNOWN, false, str);
        if (C1349Bv.m4113(str)) {
            throw new IllegalStateException("Empty play Context tag passed in");
        }
    }
}
