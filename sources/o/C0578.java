package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ث  reason: contains not printable characters */
public final class C0578 extends AbstractC1067 {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final If f13845 = new If(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final boolean m14693() {
        return f13845.m14696();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final int m14694() {
        return f13845.m14695();
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_10107";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "10107";
    }

    /* renamed from: o.ث$If */
    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final boolean m14696() {
            return !C1457Fr.m5018(C1272.m16803(C0578.class), ABTestConfig.Cell.CELL_1);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final int m14695() {
            ABTestConfig.Cell r1 = C1272.m16803(C0578.class);
            if (r1 != null) {
                switch (C0629.f13940[r1.ordinal()]) {
                    case 1:
                        return 10;
                    case 2:
                        return 20;
                    case 3:
                        return 30;
                }
            }
            return 0;
        }
    }
}
