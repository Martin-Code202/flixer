package o;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* renamed from: o.ᒾ  reason: contains not printable characters */
public class C0815 {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static final Comparator<byte[]> f14571 = new Comparator<byte[]>() { // from class: o.ᒾ.3
        /* renamed from: ˏ  reason: contains not printable characters */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private List<byte[]> f14572 = new ArrayList(64);

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f14573;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f14574 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<byte[]> f14575 = new LinkedList();

    public C0815(int i) {
        this.f14573 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized byte[] m15386(int i) {
        for (int i2 = 0; i2 < this.f14572.size(); i2++) {
            byte[] bArr = this.f14572.get(i2);
            if (bArr.length >= i) {
                this.f14574 -= bArr.length;
                this.f14572.remove(i2);
                this.f14575.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m15387(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f14573) {
                this.f14575.add(bArr);
                int binarySearch = Collections.binarySearch(this.f14572, bArr, f14571);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f14572.add(binarySearch, bArr);
                this.f14574 += bArr.length;
                m15385();
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private synchronized void m15385() {
        while (this.f14574 > this.f14573) {
            byte[] remove = this.f14575.remove(0);
            this.f14572.remove(remove);
            this.f14574 -= remove.length;
        }
    }
}
