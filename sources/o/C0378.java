package o;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import o.AbstractC0374;
/* renamed from: o.ɪ  reason: contains not printable characters */
public class C0378 extends AbstractC0374.AbstractC2397iF {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C1242 f13326;

    public C0378(boolean z, C1242 r5) {
        this.f13316 = z;
        this.f13326 = r5;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f13317 = r5.m16602(allocate, 16);
        this.f13315 = r5.m16605(allocate, 28);
        this.f13314 = r5.m16605(allocate, 32);
        this.f13318 = r5.m16602(allocate, 42);
        this.f13320 = r5.m16602(allocate, 44);
        this.f13319 = r5.m16602(allocate, 46);
        this.f13313 = r5.m16602(allocate, 48);
        this.f13312 = r5.m16602(allocate, 50);
    }

    @Override // o.AbstractC0374.AbstractC2397iF
    /* renamed from: ˏ */
    public AbstractC0374.AbstractC0375 mo14139(int i) {
        return new C0387(this.f13326, this, i);
    }

    @Override // o.AbstractC0374.AbstractC2397iF
    /* renamed from: ॱ */
    public AbstractC0374.AbstractC0376 mo14140(long j) {
        return new C0408(this.f13326, this, j);
    }

    @Override // o.AbstractC0374.AbstractC2397iF
    /* renamed from: ˊ */
    public AbstractC0374.If mo14138(long j, int i) {
        return new C1013(this.f13326, this, j, i);
    }
}
