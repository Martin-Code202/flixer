package o;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import o.AbstractC0374;
/* renamed from: o.ʟ  reason: contains not printable characters */
public class C0404 extends AbstractC0374.AbstractC0375 {
    public C0404(C1242 r6, AbstractC0374.AbstractC2397iF iFVar, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(iFVar.f13316 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f13321 = r6.m16605(allocate, iFVar.f13314 + ((long) (iFVar.f13319 * i)) + 44);
    }
}
