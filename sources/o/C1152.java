package o;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import o.C0897;
/* renamed from: o.ﯾ  reason: contains not printable characters */
public class C1152 implements AbstractC0939 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f15402;

    public C1152(Context context) {
        this.f15402 = context;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int m16336(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        int dataSize = obtain.dataSize();
        obtain.recycle();
        return dataSize;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static List<String> m16338(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        list.addAll(list2);
        return list;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static List<String> m16335(List<String> list, String str) {
        if (str == null) {
            return list;
        }
        if (list == null) {
            return m16340(str);
        }
        Collections.addAll(list, str);
        return list;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static List<String> m16334(boolean z, List<String> list, String str) {
        if (z) {
            return m16335(list, str);
        }
        return list;
    }

    @Override // o.AbstractC0939
    /* renamed from: ˊ */
    public List<String> mo93(AbstractC0639 r4) {
        List<String> r2 = m16338(m16338(null, m16341(r4.mo14601())), m16342(r4.mo14603()));
        if (r4.mo14608() && r4.mo14601() == C0821.f14612) {
            r2 = m16335(r2, "ImmediateTriggers can't be used with recurring jobs");
        }
        List<String> r22 = m16338(r2, m16332(r4.mo14605()));
        if (r4.mo14609() > 1) {
            r22 = m16338(r22, m16339(r4.mo14605()));
        }
        return m16338(m16338(r22, m16333(r4.mo14606())), m16337(r4.mo14602()));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public List<String> m16341(C0897 r2) {
        if (r2 == C0821.f14612 || (r2 instanceof C0897.If)) {
            return null;
        }
        return m16340("Unknown trigger provided");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public List<String> m16342(C0986 r7) {
        int r3 = r7.m15925();
        int r4 = r7.m15924();
        int r5 = r7.m15926();
        return m16334(r4 < 30, m16334(300 > r5, m16334(r5 < r4, m16334((r3 == 1 || r3 == 2) ? false : true, null, "Unknown retry policy provided"), "Maximum backoff must be greater than or equal to initial backoff"), "Maximum backoff must be greater than 300s (5 minutes)"), "Initial backoff must be at least 30s");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<String> m16339(Bundle bundle) {
        List<String> list = null;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                list = m16335(list, m16331(bundle, str));
            }
        }
        return list;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private List<String> m16332(Bundle bundle) {
        int r5;
        if (bundle != null && (r5 = m16336(bundle)) > 10240) {
            return m16340(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", Integer.valueOf(r5), 10240));
        }
        return null;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002c: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v0 java.lang.Class<?>) */
    /* renamed from: ˊ  reason: contains not printable characters */
    private String m16331(Bundle bundle, String str) {
        Class<?> cls;
        Object obj = bundle.get(str);
        if (obj == null || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean)) {
            return null;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        objArr[0] = cls;
        objArr[1] = str;
        return String.format(locale, "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean", objArr);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private List<String> m16337(String str) {
        if (str == null || str.isEmpty()) {
            return m16340("Service can't be empty");
        }
        if (this.f15402 == null) {
            return m16340("Context is null, can't query PackageManager");
        }
        PackageManager packageManager = this.f15402.getPackageManager();
        if (packageManager == null) {
            return m16340("PackageManager is null, can't validate service");
        }
        String str2 = "Couldn't find a registered service with the name " + str + ". Is it declared in the manifest with the right intent-filter?";
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f15402, str);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return m16340(str2);
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.enabled) {
                return null;
            }
        }
        return m16340(str2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private List<String> m16333(String str) {
        if (str == null) {
            return m16340("Tag can't be null");
        }
        if (str.length() > 100) {
            return m16340("Tag must be shorter than 100");
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static List<String> m16340(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }
}
