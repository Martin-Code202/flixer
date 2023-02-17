package o;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.SortedMap;
import java.util.TreeMap;
/* access modifiers changed from: package-private */
public abstract class iS implements iQ {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final SortedMap<Integer, Integer> f7645 = new TreeMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f7646 = 1000;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract boolean mo7537();

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract RandomAccessFile mo7540();

    iS() {
    }

    @Override // o.iQ
    /* renamed from: ˎ */
    public ByteBuffer mo7538(int i) {
        if (!mo7537()) {
            return null;
        }
        int i2 = ((this.f7646 + i) - 1) / this.f7646;
        SortedMap<Integer, Integer> headMap = this.f7645.headMap(Integer.valueOf(i2));
        SortedMap<Integer, Integer> tailMap = this.f7645.tailMap(Integer.valueOf(i2));
        if (headMap.isEmpty() || tailMap.isEmpty()) {
            return null;
        }
        int intValue = headMap.get(headMap.lastKey()).intValue();
        int intValue2 = tailMap.get(tailMap.firstKey()).intValue() - intValue;
        byte[] bArr = new byte[intValue2];
        try {
            RandomAccessFile r9 = mo7540();
            r9.seek((long) intValue);
            r9.read(bArr, 0, intValue2);
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, intValue2);
            wrap.position(0);
            wrap.limit(intValue2);
            return wrap;
        } catch (Exception e) {
            C1283.m16856("BasicBifManager", e, "Failed reading bif ", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m7554(InputStream inputStream) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bArr = new byte[64];
            int read = bufferedInputStream.read(bArr, 0, 64);
            C1283.m16851("BasicBifManager", "read %d bytes", Integer.valueOf(read));
            if (read < 64) {
                bufferedInputStream.close();
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.nativeOrder());
            wrap.order(ByteOrder.nativeOrder());
            int i = wrap.getInt(8);
            int i2 = wrap.getInt(12);
            this.f7646 = wrap.getInt(16);
            C1283.m16851("BasicBifManager", "version= %d, bifCount= %d, mInterval= %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f7646));
            if (i2 <= 0 || i2 > 28800) {
                C1283.m16851("BasicBifManager", "bif count may not be correct %d", Integer.valueOf(i2));
                bufferedInputStream.close();
                return false;
            }
            int i3 = (i2 + 1) * 8;
            byte[] bArr2 = new byte[i3];
            int i4 = 0;
            C1283.m16851("BasicBifManager", "try to read index %d", Integer.valueOf(i3));
            while (i4 < i3) {
                int i5 = 1024;
                if (i3 - i4 < 1024) {
                    i5 = i3 - i4;
                }
                int read2 = bufferedInputStream.read(bArr2, i4, i5);
                if (read2 != i5) {
                    C1283.m16851("BasicBifManager", "attempt to read %d, actual %d bytes", Integer.valueOf(i5), Integer.valueOf(read2));
                }
                if (read2 <= 0) {
                    bufferedInputStream.close();
                    return false;
                }
                i4 += read2;
            }
            ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
            wrap2.order(ByteOrder.nativeOrder());
            for (int i6 = 0; i6 < i4; i6 += 8) {
                int i7 = wrap2.getInt();
                int i8 = wrap2.getInt();
                if (i7 == -1) {
                    i7 = Integer.MAX_VALUE;
                }
                this.f7645.put(Integer.valueOf(i7), Integer.valueOf(i8));
            }
            bufferedInputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
