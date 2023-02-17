package o;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DummyDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.AbstractC1951ky;
import o.kH;
import o.kL;
public class kK implements AbstractC1951ky {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Map<String, List<C1950ku>> f8191 = new HashMap();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Object f8192 = new Object();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final kH f8193;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final kw f8194;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f8195;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final kL f8196;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final kI f8197;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private lS f8198;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Map<String, iF> f8199 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    public static kI m8229(Context context) {
        return kI.m8208(context, "header", 2097152);
    }

    public kK(Context context, Long l, kH kHVar, kw kwVar) {
        this.f8197 = m8229(context);
        this.f8195 = l.toString();
        this.f8196 = new kL(this.f8197, new C1962lu(context), null);
        this.f8193 = kHVar;
        this.f8194 = kwVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8236(lS lSVar) {
        this.f8198 = lSVar;
    }

    @Override // o.AbstractC1951ky
    /* renamed from: ˊ  reason: contains not printable characters */
    public Set<String> mo8233() {
        Set<String> keySet;
        synchronized (this.f8192) {
            keySet = this.f8191.keySet();
        }
        return keySet;
    }

    @Override // o.AbstractC1951ky
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized List<C1950ku> mo8234(String str, long j, long j2) {
        List<C1950ku> list;
        synchronized (this.f8192) {
            list = this.f8191.get(str);
        }
        if (list == null && m8228(str)) {
            synchronized (this.f8192) {
                list = this.f8191.get(str);
            }
        }
        if (list == null) {
            return null;
        }
        return kC.m8185(list, j, j2);
    }

    @Override // o.AbstractC1951ky
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8235(Set<String> set) {
        for (String str : set) {
            mo8237(str, null);
        }
    }

    @Override // o.AbstractC1951ky
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8237(String str, AbstractC1951ky.If r16) {
        synchronized (this.f8192) {
            List<C1950ku> list = this.f8191.get(str);
            if (list != null) {
                if (r16 != null) {
                    r16.mo8224(str, list);
                }
                return;
            }
            iF iFVar = this.f8199.get(str);
            if (iFVar != null) {
                if (r16 != null) {
                    iFVar.m8238(r16);
                }
                return;
            }
            this.f8199.put(str, new iF(r16));
            kH.Cif r10 = this.f8193.m8201(str);
            this.f8196.m8246(new DataSpec(Uri.parse(this.f8194.mo8455(str).m8191()), (long) r10.m8204(), (long) r10.m8202(), r10.m8203()), this.f8198, new C0130(str, r10.m8204()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kK$ˊ  reason: contains not printable characters */
    public class C0130 implements kL.If<byte[]> {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final String f8201;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final int f8202;

        public C0130(String str, int i) {
            this.f8201 = str;
            this.f8202 = i;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo8222(byte[] bArr) {
            iF iFVar;
            List<C1950ku> r3 = kK.m8230(this.f8201, this.f8202, ByteBuffer.wrap(bArr));
            if (r3 != null) {
                synchronized (kK.this.f8192) {
                    iFVar = (iF) kK.this.f8199.remove(this.f8201);
                    kK.this.f8191.put(this.f8201, r3);
                }
                if (iFVar != null) {
                    iFVar.m8239(this.f8201, r3);
                }
            }
        }

        @Override // o.kL.If
        /* renamed from: ॱ */
        public void mo8223() {
            iF iFVar;
            synchronized (kK.this.f8192) {
                iFVar = (iF) kK.this.f8199.remove(this.f8201);
            }
            if (iFVar != null) {
                iFVar.m8239(this.f8201, null);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m8228(String str) {
        List<C1950ku> r13;
        kH.Cif r7 = this.f8193.m8201(str);
        if (r7 == null) {
            C1283.m16855("nf_cache", "unable to find header infor for stream %s", str);
            return false;
        } else if (!this.f8197.getKeys().contains(r7.m8203())) {
            return false;
        } else {
            DataSpec dataSpec = new DataSpec(Uri.EMPTY, (long) r7.m8204(), (long) r7.m8202(), r7.m8203());
            CacheDataSource cacheDataSource = new CacheDataSource(this.f8197, DummyDataSource.INSTANCE);
            int i = 0;
            byte[] bArr = new byte[r7.m8202()];
            try {
                cacheDataSource.open(dataSpec);
                while (i < bArr.length) {
                    i = cacheDataSource.read(bArr, i, bArr.length - i) + i;
                }
            } catch (IOException e) {
            } finally {
                Util.closeQuietly(cacheDataSource);
            }
            if (i <= 0 || (r13 = m8230(str, r7.m8204(), ByteBuffer.wrap(bArr, 0, i))) == null) {
                return false;
            }
            synchronized (this.f8192) {
                this.f8191.put(str, r13);
            }
            C1283.m16851("nf_cache", "header %s parsed from cache", str);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static List<C1950ku> m8230(String str, int i, ByteBuffer byteBuffer) {
        long j;
        long j2;
        try {
            int integerCodeForString = Util.getIntegerCodeForString("sidx");
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = byteBuffer.getInt();
                if (byteBuffer.getInt() == integerCodeForString) {
                    i3 = i4;
                    i2 = i5;
                    break;
                }
                byteBuffer.position((byteBuffer.position() + i5) - 8);
                i4 += i5;
                if (!byteBuffer.hasRemaining()) {
                    break;
                }
            }
            if (i3 == 0) {
                C1283.m16850("nf_cache", "could not find sidx");
                return null;
            }
            int i6 = (byteBuffer.getInt() >> 24) & 255;
            byteBuffer.getInt();
            int i7 = byteBuffer.getInt();
            long j3 = (long) (i3 + i);
            if (i6 == 0) {
                j2 = (long) byteBuffer.getInt();
                j = ((long) i2) + j3 + ((long) byteBuffer.getInt());
            } else {
                j2 = byteBuffer.getLong();
                j = ((long) i2) + j3 + byteBuffer.getLong();
            }
            byteBuffer.getShort();
            short s = byteBuffer.getShort();
            ArrayList arrayList = new ArrayList(s);
            long j4 = j2;
            C1283.m16851("nf_cache", "parsing %s header: sidx offset=%d, size=%d, entries=%d", str, Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(s));
            for (int i8 = 0; i8 < s; i8++) {
                int i9 = Integer.MAX_VALUE & byteBuffer.getInt();
                int i10 = byteBuffer.getInt();
                byteBuffer.getInt();
                arrayList.add(new C1950ku(Util.scaleLargeTimestamp(j4, 1000000, (long) i7), Util.scaleLargeTimestamp((long) i10, 1000000, (long) i7), j, (long) i9));
                j += (long) i9;
                j4 += (long) i10;
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception e) {
            C1283.m16856("nf_cache", e, "unable to parse sidx", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class iF {

        /* renamed from: ˏ  reason: contains not printable characters */
        List<AbstractC1951ky.If> f8200 = new LinkedList();

        public iF(AbstractC1951ky.If r2) {
            m8238(r2);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m8238(AbstractC1951ky.If r2) {
            if (r2 != null) {
                this.f8200.add(r2);
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m8239(String str, List<C1950ku> list) {
            if (list == null || list.isEmpty()) {
                for (AbstractC1951ky.If r0 : this.f8200) {
                    r0.mo8225(str);
                }
                return;
            }
            for (AbstractC1951ky.If r02 : this.f8200) {
                r02.mo8224(str, list);
            }
        }
    }
}
