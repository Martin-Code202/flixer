package o;

import java.util.ArrayList;
import java.util.List;
public final class yZ extends AbstractC0508 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<yR> f12481;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Integer f12482;

    public yZ() {
        this(null, null, 3, null);
    }

    public yZ(List<yR> list, Integer num) {
        C1457Fr.m5025(list, "feedList");
        this.f12481 = list;
        this.f12482 = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yZ(List list, Integer num, int i, C1456Fq fq) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? null : num);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m13311(Integer num) {
        this.f12482 = num;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final List<yR> m13312() {
        return this.f12481;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final Integer m13313() {
        return this.f12482;
    }
}
