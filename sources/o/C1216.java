package o;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import o.AbstractC0374;
/* renamed from: o.ﻨ  reason: contains not printable characters */
public class C1216 extends AbstractC0374.AbstractC2397iF {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C1242 f15742;

    public C1216(boolean z, C1242 r5) {
        this.f13316 = z;
        this.f15742 = r5;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f13317 = r5.m16602(allocate, 16);
        this.f13315 = r5.m16600(allocate, 32);
        this.f13314 = r5.m16600(allocate, 40);
        this.f13318 = r5.m16602(allocate, 54);
        this.f13320 = r5.m16602(allocate, 56);
        this.f13319 = r5.m16602(allocate, 58);
        this.f13313 = r5.m16602(allocate, 60);
        this.f13312 = r5.m16602(allocate, 62);
    }

    @Override // o.AbstractC0374.AbstractC2397iF
    /* renamed from: ˏ */
    public AbstractC0374.AbstractC0375 mo14139(int i) {
        return new C0404(this.f15742, this, i);
    }

    @Override // o.AbstractC0374.AbstractC2397iF
    /* renamed from: ॱ */
    public AbstractC0374.AbstractC0376 mo14140(long j) {
        return new C0388(this.f15742, this, j);
    }

    @Override // o.AbstractC0374.AbstractC2397iF
    /* renamed from: ˊ */
    public AbstractC0374.If mo14138(long j, int i) {
        return new C1195(this.f15742, this, j, i);
    }
}
