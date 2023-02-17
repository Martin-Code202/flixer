package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ე  reason: contains not printable characters */
public final class C0714 extends AbstractC1067 {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final If f14240 = new If(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final boolean m15040() {
        return f14240.m15042();
    }

    /* renamed from: o.ე$If */
    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final boolean m15042() {
            return !AD.m3299() && (C1457Fr.m5018(m15041(), ABTestConfig.Cell.CELL_1) ^ true);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final boolean m15043() {
            if (!C1457Fr.m5018(m15041(), ABTestConfig.Cell.CELL_4)) {
                ABTestConfig.Cell cell = ABTestConfig.Cell.CELL_15;
                ABTestConfig.Cell r3 = m15041();
                if (r3.compareTo(ABTestConfig.Cell.CELL_10) < 0 || r3.compareTo(cell) > 0) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private final ABTestConfig.Cell m15041() {
            ABTestConfig.Cell r0 = C1272.m16803(C0714.class);
            C1457Fr.m5016((Object) r0, "PersistentConfig.getCell…_Ab9080_Tags::class.java)");
            return r0;
        }
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_ab" + mo511();
    }

    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "9080";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˊ */
    public boolean mo509() {
        return true;
    }
}
