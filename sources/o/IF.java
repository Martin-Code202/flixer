package o;

import android.support.v4.util.ArraySet;
import android.support.v4.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class IF {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Set<Cif> f5734 = new ArraySet();

    /* renamed from: ˎ  reason: contains not printable characters */
    private Map<String, C1163> f5735 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Comparator<Pair<String, Float>> f5736 = new Comparator<Pair<String, Float>>() { // from class: o.IF.2
        /* renamed from: ॱ  reason: contains not printable characters */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f5737 = false;

    /* renamed from: o.IF$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˊ  reason: contains not printable characters */
        void m5164(float f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5162(boolean z) {
        this.f5737 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5161(String str, float f) {
        if (this.f5737) {
            C1163 r1 = this.f5735.get(str);
            if (r1 == null) {
                r1 = new C1163();
                this.f5735.put(str, r1);
            }
            r1.m16352(f);
            if (str.equals("root")) {
                for (Cif ifVar : this.f5734) {
                    ifVar.m5164(f);
                }
            }
        }
    }
}
