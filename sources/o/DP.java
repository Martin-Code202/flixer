package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.MslKeyExchangeException;
import com.netflix.msl.MslMasterTokenException;
import com.netflix.msl.MslMessageException;
import com.netflix.msl.MslUserIdTokenException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
public class DP extends InputStream {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f5347 = false;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC1386Dc f5348;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Boolean f5349 = null;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final DI f5350;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final InputStream f5351;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private IOException f5352 = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1406Dw f5353;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final MslContext f5354;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private ListIterator<ByteArrayInputStream> f5355 = null;

    /* renamed from: ͺ  reason: contains not printable characters */
    private ByteArrayInputStream f5356 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1386Dc f5357;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final List<ByteArrayInputStream> f5358 = new LinkedList();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f5359 = false;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private long f5360 = 1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static AbstractC1386Dc m4662(MslContext mslContext, DM dm, Set<AbstractC1408Dy> set) {
        DV r4 = dm.m4636();
        DC r5 = dm.m4643();
        if (r5 == null) {
            return null;
        }
        DV r6 = r5.m4587();
        if (r6.m4693()) {
            return new CZ(mslContext, r6);
        }
        C1409Dz r7 = r5.m4589();
        DB r8 = mslContext.mo3162(r7);
        if (r8 == null) {
            throw new MslKeyExchangeException(CK.f4834, r7.m4774());
        }
        MslKeyExchangeException mslKeyExchangeException = null;
        Iterator<AbstractC1408Dy> it = set.iterator();
        while (it.hasNext()) {
            AbstractC1408Dy next = it.next();
            if (r7.equals(next.m4772())) {
                try {
                    return r8.mo4585(mslContext, next, r5, r4);
                } catch (MslKeyExchangeException e) {
                    if (!it.hasNext()) {
                        throw e;
                    }
                    mslKeyExchangeException = e;
                } catch (MslEncodingException e2) {
                    if (!it.hasNext()) {
                        throw e2;
                    }
                    mslKeyExchangeException = e2;
                } catch (MslMasterTokenException e3) {
                    if (!it.hasNext()) {
                        throw e3;
                    }
                    mslKeyExchangeException = e3;
                } catch (MslEntityAuthException e4) {
                    if (!it.hasNext()) {
                        throw e4;
                    }
                    mslKeyExchangeException = e4;
                }
            }
        }
        if (mslKeyExchangeException == null) {
            throw new MslKeyExchangeException(CK.f4844, Arrays.toString(set.toArray()));
        } else if (mslKeyExchangeException instanceof MslKeyExchangeException) {
            throw mslKeyExchangeException;
        } else if (mslKeyExchangeException instanceof MslEncodingException) {
            throw ((MslEncodingException) mslKeyExchangeException);
        } else if (mslKeyExchangeException instanceof MslMasterTokenException) {
            throw ((MslMasterTokenException) mslKeyExchangeException);
        } else if (mslKeyExchangeException instanceof MslEntityAuthException) {
            throw ((MslEntityAuthException) mslKeyExchangeException);
        } else {
            throw new MslInternalException("Unexpected exception caught during key exchange.", mslKeyExchangeException);
        }
    }

    public DP(MslContext mslContext, InputStream inputStream, Set<AbstractC1408Dy> set, Map<String, AbstractC1386Dc> map) {
        CK r9;
        this.f5354 = mslContext;
        this.f5351 = inputStream;
        try {
            this.f5353 = this.f5354.mo3174().m4728(inputStream);
            if (!this.f5353.m4766(-1)) {
                throw new MslEncodingException(CK.f4779);
            }
            this.f5350 = DI.m4602(mslContext, this.f5353.m4767(-1), map);
            try {
                if (this.f5350 instanceof DD) {
                    this.f5348 = null;
                    this.f5357 = null;
                    return;
                }
                DM dm = (DM) this.f5350;
                this.f5348 = m4662(mslContext, dm, set);
                if (mslContext.mo3166() || this.f5348 == null) {
                    this.f5357 = dm.m4640();
                } else {
                    this.f5357 = this.f5348;
                }
                if (!dm.m4645() || (dm.m4632() && !dm.m4639().isEmpty())) {
                    DV r5 = dm.m4636();
                    if (r5 != null && (mslContext.mo3166() || r5.m4696())) {
                        DS r6 = mslContext.mo3161();
                        CK r7 = r6.mo4672(mslContext, r5);
                        if (r7 != null) {
                            throw new MslMasterTokenException(r7, r5);
                        }
                        C1411Eb r8 = dm.m4646();
                        if (r8 != null && (r9 = r6.mo4676(mslContext, r5, r8)) != null) {
                            throw new MslUserIdTokenException(r9, r8);
                        } else if (r5.m4692(null)) {
                            if (!dm.m4632() || dm.m4639().isEmpty()) {
                                throw new MslMessageException(CK.f4788, dm.toString());
                            }
                            CK r92 = r6.mo4675(mslContext, r5);
                            if (r92 != null) {
                                throw new MslMessageException(r92, "Master token is expired and not renewable.");
                            }
                        }
                    }
                    Long r62 = dm.m4635();
                    if (r62 == null) {
                        return;
                    }
                    if (r5 == null) {
                        throw new MslMessageException(CK.f4809, dm.toString());
                    }
                    CK r82 = mslContext.mo3161().mo4673(mslContext, r5, r62.longValue());
                    if (r82 != null) {
                        throw new MslMessageException(r82, dm.toString());
                    }
                    return;
                }
                throw new MslMessageException(CK.f4819, dm.toString());
            } catch (MslException e) {
                if (this.f5350 instanceof DM) {
                    DM dm2 = (DM) this.f5350;
                    e.mo3076(dm2.m4636());
                    e.mo3077(dm2.m4644());
                    e.mo3086(dm2.m4646());
                    e.mo3087(dm2.m4642());
                    e.mo3085(dm2.m4648());
                } else {
                    DD dd = (DD) this.f5350;
                    e.mo3077(dd.m4590());
                    e.mo3085(dd.m4591());
                }
                throw e;
            }
        } catch (MslEncoderException e2) {
            throw new MslEncodingException(CK.f4804, "header", e2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        super.finalize();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public C1405Dv m4666() {
        if (m4669() == null) {
            throw new MslInternalException("Read attempted with error message.");
        } else if (this.f5347) {
            return null;
        } else {
            try {
                if (this.f5353.m4766(-1)) {
                    return this.f5353.m4767(-1);
                }
                this.f5347 = true;
                return null;
            } catch (MslEncoderException e) {
                throw new MslEncodingException(CK.f4804, "payloadchunk", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public ByteArrayInputStream m4667() {
        DM r5 = m4669();
        if (r5 == null) {
            throw new MslInternalException("Read attempted with error message.");
        } else if (this.f5355 != null && this.f5355.hasNext()) {
            return this.f5355.next();
        } else {
            C1405Dv r6 = m4666();
            if (r6 == null) {
                return null;
            }
            DN dn = new DN(this.f5354, r6, this.f5357);
            DV r8 = r5.m4636();
            AbstractC1385Db r9 = r5.m4644();
            C1411Eb r10 = r5.m4646();
            AbstractC1412Ec r11 = r5.m4642();
            if (dn.m4655() != r5.m4648()) {
                throw new MslMessageException(CK.f4770, "payload mid " + dn.m4655() + " header mid " + r5.m4648()).mo3076(r8).mo3077(r9).mo3086(r10).mo3087(r11);
            } else if (dn.m4654() != this.f5360) {
                throw new MslMessageException(CK.f4772, "payload seqno " + dn.m4654() + " expected seqno " + this.f5360).mo3076(r8).mo3077(r9).mo3086(r10).mo3087(r11);
            } else {
                this.f5360++;
                if (this.f5349 == null) {
                    this.f5349 = Boolean.valueOf(r5.m4632() && !r5.m4639().isEmpty() && dn.m4656() && dn.m4652().length == 0);
                }
                if (dn.m4656()) {
                    this.f5347 = true;
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dn.m4652());
                this.f5358.add(byteArrayInputStream);
                this.f5355 = null;
                return byteArrayInputStream;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m4665() {
        DM r2 = m4669();
        if (r2 == null) {
            return false;
        }
        if (r2.m4645()) {
            return true;
        }
        if (this.f5349 == null) {
            try {
                this.f5356 = m4667();
                if (this.f5356 == null) {
                    this.f5349 = Boolean.FALSE;
                }
            } catch (MslException e) {
                this.f5352 = new IOException("Error reading the payload chunk.", e);
                throw e;
            }
        }
        return this.f5349.booleanValue();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public DM m4669() {
        if (this.f5350 instanceof DM) {
            return (DM) this.f5350;
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public DD m4668() {
        if (this.f5350 instanceof DD) {
            return (DD) this.f5350;
        }
        return null;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public AbstractC1386Dc m4663() {
        return this.f5348;
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.f5356 == null) {
            return 0;
        }
        int available = this.f5356.available();
        int indexOf = this.f5358.indexOf(this.f5356);
        if (indexOf != -1 && indexOf < this.f5358.size() - 1) {
            ListIterator<ByteArrayInputStream> listIterator = this.f5358.listIterator(indexOf + 1);
            while (listIterator.hasNext()) {
                available += listIterator.next().available();
            }
        }
        return available;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4664(boolean z) {
        this.f5359 = z;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f5359) {
            this.f5351.close();
            return;
        }
        try {
            if (!m4665() && m4669() != null) {
                do {
                } while (m4667() != null);
            }
        } catch (MslException e) {
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this.f5356 != null) {
            this.f5355 = null;
            while (this.f5358.size() > 0 && !this.f5358.get(0).equals(this.f5356)) {
                this.f5358.remove(0);
            }
            this.f5355 = this.f5358.listIterator();
            this.f5356 = this.f5355.next();
            this.f5356.mark(i);
            return;
        }
        this.f5355 = null;
        this.f5358.clear();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f5352 != null) {
            IOException iOException = this.f5352;
            this.f5352 = null;
            throw iOException;
        }
        try {
            if (m4665()) {
                return -1;
            }
            int i3 = 0;
            while (i3 < i2) {
                int read = this.f5356 != null ? this.f5356.read(bArr, i + i3, i2 - i3) : -1;
                if (read != -1) {
                    i3 += read;
                } else {
                    try {
                        this.f5356 = m4667();
                        if (this.f5356 == null) {
                            break;
                        }
                    } catch (MslException e) {
                        IOException iOException2 = new IOException("Error reading the payload chunk.", e);
                        if (i3 > 0) {
                            this.f5352 = iOException2;
                            return i3;
                        }
                        throw iOException2;
                    }
                }
            }
            if (i3 != 0 || i2 <= 0) {
                return i3;
            }
            return -1;
        } catch (MslException e2) {
            this.f5352 = null;
            throw new IOException("Error reading the payload chunk.", e2);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public void reset() {
        for (ByteArrayInputStream byteArrayInputStream : this.f5358) {
            byteArrayInputStream.reset();
        }
        this.f5355 = this.f5358.listIterator();
        if (this.f5355.hasNext()) {
            this.f5356 = this.f5355.next();
        } else {
            this.f5356 = null;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int i = 0;
        while (((long) i) < j) {
            long skip = this.f5356 != null ? this.f5356.skip(j - ((long) i)) : 0;
            if (skip != 0) {
                i = (int) (((long) i) + skip);
            } else {
                try {
                    this.f5356 = m4667();
                    if (this.f5356 == null) {
                        break;
                    }
                } catch (MslInternalException e) {
                    throw new IOException("Cannot skip data off an error message.", e);
                } catch (MslException e2) {
                    throw new IOException("Error skipping in the payload chunk.", e2);
                }
            }
        }
        return (long) i;
    }
}
