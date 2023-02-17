package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import java.util.concurrent.TimeUnit;
/* renamed from: o.Ꮭ  reason: contains not printable characters */
public final class C0728 extends AbstractC1067 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Cif f14271 = new Cif(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final boolean m15070() {
        return f14271.m15074();
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_9064";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "9064";
    }

    /* renamed from: o.Ꮭ$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final long m15072() {
            ABTestConfig.Cell r1 = C1272.m16803(C0728.class);
            if (r1 != null) {
                switch (C0752.f14362[r1.ordinal()]) {
                    case 1:
                        return 8;
                    case 2:
                        return 4;
                    case 3:
                        return 2;
                    case 4:
                        return 1;
                    case 5:
                        return 1;
                }
            }
            return 0;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final long m15071() {
            if (m15074()) {
                return TimeUnit.HOURS.toMillis(10);
            }
            return 0;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean m15074() {
            return !C1457Fr.m5018(C1272.m16803(C0728.class), ABTestConfig.Cell.CELL_1);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final ABTestConfig.Cell m15075() {
            return C1272.m16803(C0728.class);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final boolean m15073() {
            ABTestConfig.Cell r1 = C1272.m16803(C0728.class);
            if (r1 != null) {
                switch (C0752.f14361[r1.ordinal()]) {
                    case 1:
                        return false;
                }
            }
            return true;
        }
    }
}
