package o;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: o.ﭠ  reason: contains not printable characters */
public class C1122 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static volatile Integer f15356;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m16272(Context context) {
        if (f15356 == null) {
            synchronized (C1122.class) {
                if (f15356 == null) {
                    f15356 = Integer.valueOf(m16276(context));
                }
            }
        }
        return f15356.intValue();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m16277(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m16276(Context context) {
        Log.v("YearClass", "getClockSpeedYear(): " + m16275());
        Log.v("YearClass", "getNumCoresYear(): " + m16273());
        Log.v("YearClass", "getRamYear(): " + m16274(context));
        ArrayList arrayList = new ArrayList();
        m16277(arrayList, m16275());
        m16277(arrayList, m16274(context));
        if (arrayList.isEmpty()) {
            m16277(arrayList, m16273());
        }
        int i = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() > -1) {
                i += num.intValue();
            }
        }
        if (i > 0) {
            return i / arrayList.size();
        }
        return -1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m16273() {
        int r1 = C1114.m16242();
        if (r1 < 1) {
            return -1;
        }
        if (r1 == 1) {
            return 2008;
        }
        if (r1 <= 3) {
            return 2011;
        }
        if (r1 <= 4) {
            return 2014;
        }
        return 2015;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m16275() {
        long r2 = (long) C1114.m16241();
        if (r2 == -1) {
            return -1;
        }
        if (C1114.m16242() < 8) {
            if (r2 <= 528000) {
                return 2008;
            }
            if (r2 <= 620000) {
                return 2009;
            }
            if (r2 <= 1020000) {
                return 2010;
            }
            if (r2 <= 1220000) {
                return 2011;
            }
            if (r2 <= 1520000) {
                return 2012;
            }
            if (r2 <= 2020000) {
                return 2013;
            }
            if (r2 <= 2200000) {
                return 2014;
            }
            return 2015;
        } else if (r2 <= 1520000) {
            return 2014;
        } else {
            return 2015;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m16274(Context context) {
        long r2 = C1114.m16243(context);
        if (r2 <= 0) {
            return -1;
        }
        if (r2 <= 201326592) {
            return 2008;
        }
        if (r2 <= 304087040) {
            return 2009;
        }
        if (r2 <= 536870912) {
            return 2010;
        }
        if (r2 <= 1073741824) {
            return 2011;
        }
        if (r2 <= 1610612736) {
            return 2012;
        }
        if (r2 <= 2147483648L) {
            return 2013;
        }
        return 2015;
    }
}
