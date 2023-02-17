package o;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import o.AbstractC0374;
/* renamed from: o.ﺩ  reason: contains not printable characters */
public class C1195 extends AbstractC0374.If {
    public C1195(C1242 r4, AbstractC0374.AbstractC2397iF iFVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(iFVar.f13316 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 16));
        this.f13310 = r4.m16600(allocate, j2);
        this.f13311 = r4.m16600(allocate, 8 + j2);
    }
}
