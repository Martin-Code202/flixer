package o;

import java.lang.Number;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* renamed from: o.ร  reason: contains not printable characters */
public class C0692<Sample extends Number> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Sample f14190;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Sample f14191;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Integer f14192;

    /* renamed from: ˏ  reason: contains not printable characters */
    private List<Integer> f14193;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Class<Sample> f14194;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AtomicIntegerArray f14195;

    public C0692(Class<Sample> cls) {
        this.f14194 = cls;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14980(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14977(Sample sample, int i) {
        m14980(sample != null);
        m14980(i >= 0);
        m14980((this.f14193 == null || this.f14195 == null) ? false : true);
        int intValue = ((Integer) Integer.class.cast(sample)).intValue();
        for (int i2 = 0; i2 < this.f14193.size(); i2++) {
            if (intValue <= this.f14193.get(i2).intValue()) {
                this.f14195.addAndGet(i2, i);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f14193 == null || this.f14195 == null || this.f14193.size() != this.f14195.length()) {
            sb.append("[]");
        } else {
            sb.append('[');
            for (int i = 0; i < this.f14193.size(); i++) {
                if (i != 0) {
                    sb.append(" ");
                }
                sb.append(this.f14193.get(i)).append(':').append(this.f14195.get(i));
            }
            sb.append(']');
        }
        return sb.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Map<String, Integer> m14979() {
        m14980(this.f14193.size() == this.f14195.length());
        HashMap hashMap = new HashMap(this.f14193.size());
        for (int i = 0; i < this.f14193.size(); i++) {
            hashMap.put(this.f14193.get(i).toString(), Integer.valueOf(this.f14195.get(i)));
        }
        return hashMap;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m14978() {
        return String.format("%d/%d/%d", this.f14191, this.f14190, this.f14192);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: java.util.List<java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14981(Sample sample, Sample sample2, Integer num) {
        if (num.intValue() < 1 || ((Integer) Integer.class.cast(sample)).intValue() > ((Integer) Integer.class.cast(sample2)).intValue()) {
            this.f14193 = null;
            this.f14195 = null;
            this.f14192 = 0;
            this.f14191 = this.f14194.cast(0);
            this.f14190 = this.f14194.cast(0);
            return;
        }
        if (this.f14193 == null || this.f14193.size() != 0) {
            this.f14193 = new ArrayList(num.intValue());
            this.f14195 = null;
            this.f14191 = sample;
            this.f14190 = sample2;
            this.f14192 = num;
        }
        double log = Math.log(((Integer) Integer.class.cast(sample2)).doubleValue());
        int i = 1;
        Sample sample3 = sample;
        this.f14193.add(0);
        this.f14193.add(Integer.class.cast(sample3));
        while (true) {
            i++;
            if (num.intValue() <= i) {
                break;
            }
            double log2 = Math.log(((Integer) Integer.class.cast(sample3)).doubleValue());
            Sample cast = this.f14194.cast(Integer.valueOf((int) Math.floor(Math.exp(log2 + ((log - log2) / ((double) (num.intValue() - i)))) + 0.5d)));
            if (((Integer) Integer.class.cast(cast)).intValue() > ((Integer) Integer.class.cast(sample3)).intValue()) {
                sample3 = cast;
            } else {
                sample3 = this.f14194.cast(Integer.valueOf(((Integer) Integer.class.cast(sample3)).intValue() + 1));
            }
            this.f14193.add(Integer.valueOf(((Integer) Integer.class.cast(sample3)).intValue()));
        }
        this.f14193.add(Integer.MAX_VALUE);
        this.f14195 = new AtomicIntegerArray(this.f14193.size());
        synchronized (this.f14195) {
            for (int i2 = 0; i2 < this.f14193.size(); i2++) {
                this.f14195.set(i2, 0);
            }
        }
    }
}
