package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ᕃ  reason: contains not printable characters */
public final class C0891 extends AbstractC1067 {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final If f14767 = new If(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final boolean m15609() {
        return f14767.m15611();
    }

    /* renamed from: o.ᕃ$If */
    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean m15611() {
            return !C1457Fr.m5018(m15610(), ABTestConfig.Cell.CELL_1);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private final ABTestConfig.Cell m15610() {
            ABTestConfig.Cell r0 = C1272.m16803(C0891.class);
            C1457Fr.m5016((Object) r0, "PersistentConfig.getCell…658_Previews::class.java)");
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
        return "9658";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˊ */
    public boolean mo509() {
        return true;
    }
}
