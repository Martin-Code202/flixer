package o;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import o.AbstractC0374;
/* renamed from: o.ʰ  reason: contains not printable characters */
public class C0408 extends AbstractC0374.AbstractC0376 {
    public C0408(C1242 r8, AbstractC0374.AbstractC2397iF iFVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(iFVar.f13316 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = iFVar.f13315 + (((long) iFVar.f13318) * j);
        this.f13323 = r8.m16605(allocate, j2);
        this.f13325 = r8.m16605(allocate, 4 + j2);
        this.f13322 = r8.m16605(allocate, 8 + j2);
        this.f13324 = r8.m16605(allocate, 20 + j2);
    }
}
