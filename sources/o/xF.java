package o;

import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
public abstract class xF extends xJ {
    private xF() {
        super(null);
    }

    public /* synthetic */ xF(C1456Fq fq) {
        this();
    }

    public static final class If extends xF {

        /* renamed from: ˏ  reason: contains not printable characters */
        public static final If f11968 = new If();

        private If() {
            super(null);
        }
    }

    /* renamed from: o.xF$ˊ  reason: contains not printable characters */
    public static final class C0261 extends xF {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final String f11969;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final ExpiringContentAdvisory.ContentAction f11970;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0261(String str, ExpiringContentAdvisory.ContentAction contentAction) {
            super(null);
            C1457Fr.m5025(str, "videoId");
            C1457Fr.m5025(contentAction, "action");
            this.f11969 = str;
            this.f11970 = contentAction;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final ExpiringContentAdvisory.ContentAction m12753() {
            return this.f11970;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final String m12754() {
            return this.f11969;
        }
    }
}
