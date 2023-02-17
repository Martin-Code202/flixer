package o;

import com.netflix.msl.MslConstants;
import com.netflix.msl.util.MslContext;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
public class CQ extends MslContext {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1417Eh f4996;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Map<C1409Dz, DB> f4997;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Map<C1391Dh, AbstractC1390Dg> f4998;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC0076 f4999;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1386Dc f5000;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final DS f5001;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Random f5002;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1385Db f5003;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final CU f5004;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1400Dq f5005;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final CW f5006;

    /* renamed from: o.CQ$ˊ  reason: contains not printable characters */
    public interface AbstractC0076 {
        /* renamed from: ॱ  reason: contains not printable characters */
        long mo4298();
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ॱॱ */
    public Random mo3173() {
        return this.f5002;
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ʼ */
    public AbstractC1386Dc mo3160() {
        return this.f5000;
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ʽ */
    public DS mo3161() {
        return this.f5001;
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ʻ */
    public AbstractC1417Eh mo3159() {
        return this.f4996;
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ᐝ */
    public AbstractC1400Dq mo3174() {
        return this.f5005;
    }

    public static class If {

        /* renamed from: ʻ  reason: contains not printable characters */
        private ArrayList<C1391Dh> f5007;

        /* renamed from: ʼ  reason: contains not printable characters */
        private ArrayList<C1409Dz> f5008;

        /* renamed from: ʽ  reason: contains not printable characters */
        private ArrayList<DB> f5009;

        /* renamed from: ˊ  reason: contains not printable characters */
        private DS f5010;

        /* renamed from: ˊॱ  reason: contains not printable characters */
        private CW f5011;

        /* renamed from: ˋ  reason: contains not printable characters */
        private AbstractC1386Dc f5012;

        /* renamed from: ˎ  reason: contains not printable characters */
        private Random f5013;

        /* renamed from: ˏ  reason: contains not printable characters */
        private AbstractC0076 f5014;

        /* renamed from: ͺ  reason: contains not printable characters */
        private CU f5015;

        /* renamed from: ॱ  reason: contains not printable characters */
        private AbstractC1385Db f5016;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private AbstractC1400Dq f5017;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private AbstractC1417Eh f5018;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private ArrayList<AbstractC1390Dg> f5019;

        If() {
        }

        public String toString() {
            return "ClientMslContext.ClientMslContextBuilder(clock=" + this.f5014 + ", random=" + this.f5013 + ", mslCryptoContext=" + this.f5012 + ", tokenFactory=" + this.f5010 + ", entityAuthData=" + this.f5016 + ", entityAuthFactories$key=" + this.f5007 + ", entityAuthFactories$value=" + this.f5019 + ", keyxFactories$key=" + this.f5008 + ", keyxFactories$value=" + this.f5009 + ", mslStore=" + this.f5018 + ", rsaStore=" + this.f5011 + ", eccStore=" + this.f5015 + ", mslEncoderFactory=" + this.f5017 + ")";
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public CQ m4292() {
            Map map;
            Map map2;
            switch (this.f5007 == null ? 0 : this.f5007.size()) {
                case 0:
                    map = Collections.emptyMap();
                    break;
                case 1:
                    map = Collections.singletonMap(this.f5007.get(0), this.f5019.get(0));
                    break;
                default:
                    LinkedHashMap linkedHashMap = new LinkedHashMap(this.f5007.size() < 1073741824 ? this.f5007.size() + 1 + ((this.f5007.size() - 3) / 3) : Integer.MAX_VALUE);
                    for (int i = 0; i < this.f5007.size(); i++) {
                        linkedHashMap.put(this.f5007.get(i), this.f5019.get(i));
                    }
                    map = Collections.unmodifiableMap(linkedHashMap);
                    break;
            }
            switch (this.f5008 == null ? 0 : this.f5008.size()) {
                case 0:
                    map2 = Collections.emptyMap();
                    break;
                case 1:
                    map2 = Collections.singletonMap(this.f5008.get(0), this.f5009.get(0));
                    break;
                default:
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(this.f5008.size() < 1073741824 ? this.f5008.size() + 1 + ((this.f5008.size() - 3) / 3) : Integer.MAX_VALUE);
                    for (int i2 = 0; i2 < this.f5008.size(); i2++) {
                        linkedHashMap2.put(this.f5008.get(i2), this.f5009.get(i2));
                    }
                    map2 = Collections.unmodifiableMap(linkedHashMap2);
                    break;
            }
            return new CQ(this.f5014, this.f5013, this.f5012, this.f5010, this.f5016, map, map2, this.f5018, this.f5011, this.f5015, this.f5017);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.ArrayList<o.Dh> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.util.ArrayList<o.Dg> */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: ˋ  reason: contains not printable characters */
        public If m4293(Map<? extends C1391Dh, ? extends AbstractC1390Dg> map) {
            if (this.f5007 == null) {
                this.f5007 = new ArrayList<>();
                this.f5019 = new ArrayList<>();
            }
            for (Map.Entry<? extends C1391Dh, ? extends AbstractC1390Dg> entry : map.entrySet()) {
                this.f5007.add(entry.getKey());
                this.f5019.add(entry.getValue());
            }
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public If m4294(AbstractC1385Db db) {
            this.f5016 = db;
            return this;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public If m4295(AbstractC1417Eh eh) {
            this.f5018 = eh;
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.ArrayList<o.Dz> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.util.ArrayList<o.DB> */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: ˏ  reason: contains not printable characters */
        public If m4296(Map<? extends C1409Dz, ? extends DB> map) {
            if (this.f5008 == null) {
                this.f5008 = new ArrayList<>();
                this.f5009 = new ArrayList<>();
            }
            for (Map.Entry<? extends C1409Dz, ? extends DB> entry : map.entrySet()) {
                this.f5008.add(entry.getKey());
                this.f5009.add(entry.getValue());
            }
            return this;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public If m4297(AbstractC1400Dq dq) {
            this.f5017 = dq;
            return this;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static If m4291() {
        return new If();
    }

    public CQ(AbstractC0076 r2, Random random, AbstractC1386Dc dc, DS ds, AbstractC1385Db db, Map<C1391Dh, AbstractC1390Dg> map, Map<C1409Dz, DB> map2, AbstractC1417Eh eh, CW cw, CU cu, AbstractC1400Dq dq) {
        this.f4999 = r2 != null ? r2 : new C0077();
        this.f5002 = random != null ? random : new SecureRandom();
        this.f5000 = dc != null ? dc : new CX();
        this.f5001 = ds != null ? ds : new DT();
        this.f5003 = db;
        this.f4998 = map;
        this.f4997 = map2;
        this.f4996 = eh;
        this.f5006 = cw;
        this.f5004 = cu;
        this.f5005 = dq;
    }

    /* renamed from: o.CQ$ˋ  reason: contains not printable characters */
    public static class C0077 implements AbstractC0076 {
        @Override // o.CQ.AbstractC0076
        /* renamed from: ॱ */
        public long mo4298() {
            return System.currentTimeMillis();
        }
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ˏ */
    public long mo3167() {
        return this.f4999.mo4298();
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ˎ */
    public boolean mo3166() {
        return false;
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ॱ */
    public DJ mo3170() {
        HashSet hashSet = new HashSet();
        hashSet.add(MslConstants.CompressionAlgorithm.GZIP);
        hashSet.add(MslConstants.CompressionAlgorithm.LZW);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(C1407Dx.f5471);
        return new DJ(hashSet, null, hashSet2);
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ˏ */
    public AbstractC1385Db mo3168(MslContext.ReauthCode reauthCode) {
        return this.f5003;
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ˊ */
    public C1391Dh mo3163(String str) {
        return C1391Dh.m4715(str);
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ˏ */
    public AbstractC1390Dg mo3169(C1391Dh dh) {
        return this.f4998.get(dh);
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ॱ */
    public C1416Eg mo3172(String str) {
        return C1416Eg.m4879(str);
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ॱ */
    public AbstractC1415Ef mo3171(C1416Eg eg) {
        return null;
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ˋ */
    public C1409Dz mo3165(String str) {
        return C1409Dz.m4773(str);
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ˊ */
    public DB mo3162(C1409Dz dz) {
        return this.f4997.get(dz);
    }

    @Override // com.netflix.msl.util.MslContext
    /* renamed from: ˋ */
    public SortedSet<DB> mo3164() {
        return new TreeSet(this.f4997.values());
    }
}
