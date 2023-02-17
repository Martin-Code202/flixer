package o;

import android.os.Build;
import o.C1064;
/* access modifiers changed from: package-private */
/* renamed from: o.ﭘ  reason: contains not printable characters */
public final class C1117 implements C1064.If {
    C1117() {
    }

    @Override // o.C1064.If
    /* renamed from: ˎ */
    public void mo16119(String str) {
        System.loadLibrary(str);
    }

    @Override // o.C1064.If
    /* renamed from: ˊ */
    public void mo16117(String str) {
        System.load(str);
    }

    @Override // o.C1064.If
    /* renamed from: ˋ */
    public String mo16118(String str) {
        if (!str.startsWith("lib") || !str.endsWith(".so")) {
            return System.mapLibraryName(str);
        }
        return str;
    }

    @Override // o.C1064.If
    /* renamed from: ˏ */
    public String mo16121(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // o.C1064.If
    /* renamed from: ˎ */
    public String[] mo16120() {
        if (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) {
            return !C1190.m16452(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
        }
        return Build.SUPPORTED_ABIS;
    }
}
