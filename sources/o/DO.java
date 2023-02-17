package o;

import com.netflix.msl.MslConstants;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
public class DO extends OutputStream {

    /* renamed from: ʻ  reason: contains not printable characters */
    private ByteArrayOutputStream f5334 = new ByteArrayOutputStream();

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f5335 = 1;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC1386Dc f5336;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final OutputStream f5337;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1407Dx f5338;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final MslContext f5339;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final DJ f5340;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f5341 = false;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f5342 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final DI f5343;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final List<DN> f5344 = new ArrayList();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private MslConstants.CompressionAlgorithm f5345;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f5346 = false;

    public DO(MslContext mslContext, OutputStream outputStream, DM dm, AbstractC1386Dc dc) {
        C1407Dx dx;
        MslConstants.CompressionAlgorithm compressionAlgorithm;
        AbstractC1400Dq r2 = mslContext.mo3174();
        DJ r3 = dm.m4637();
        if (r3 != null) {
            compressionAlgorithm = MslConstants.CompressionAlgorithm.m3071(r3.m4605());
            dx = r2.mo3177(r3.m4604());
        } else {
            compressionAlgorithm = null;
            dx = r2.mo3177((Set<C1407Dx>) null);
        }
        try {
            byte[] r6 = dm.mo3114(r2, dx);
            this.f5339 = mslContext;
            this.f5337 = outputStream;
            this.f5338 = dx;
            this.f5340 = r3;
            this.f5343 = dm;
            this.f5345 = compressionAlgorithm;
            this.f5336 = dc;
            this.f5337.write(r6);
            this.f5337.flush();
        } catch (MslEncoderException e) {
            throw new IOException("Error encoding the message header.", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        close();
        super.finalize();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m4660(MslConstants.CompressionAlgorithm compressionAlgorithm) {
        if (m4657() == null) {
            throw new MslInternalException("Cannot write payload data for an error message.");
        } else if (compressionAlgorithm != null && (this.f5340 == null || !this.f5340.m4605().contains(compressionAlgorithm))) {
            return false;
        } else {
            if (this.f5345 != compressionAlgorithm) {
                flush();
            }
            this.f5345 = compressionAlgorithm;
            return true;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public DM m4657() {
        if (this.f5343 instanceof DM) {
            return (DM) this.f5343;
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public List<DN> m4661() {
        return Collections.unmodifiableList(this.f5344);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m4658() {
        this.f5342 = false;
        this.f5344.clear();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m4659(boolean z) {
        this.f5341 = z;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f5346) {
            this.f5346 = true;
            flush();
            this.f5334 = null;
            if (this.f5341) {
                this.f5337.close();
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        DM r10;
        if (this.f5334 != null) {
            if ((this.f5346 || this.f5334.size() != 0) && (r10 = m4657()) != null && !r10.m4645()) {
                try {
                    DN dn = new DN(this.f5339, this.f5335, r10.m4648(), this.f5346, this.f5345, this.f5334 != null ? this.f5334.toByteArray() : new byte[0], this.f5336);
                    if (this.f5342) {
                        this.f5344.add(dn);
                    }
                    this.f5337.write(dn.mo3114(this.f5339.mo3174(), this.f5338));
                    this.f5337.flush();
                    this.f5335++;
                    if (this.f5346) {
                        this.f5334 = null;
                    } else {
                        this.f5334.reset();
                    }
                } catch (MslEncoderException e) {
                    throw new IOException("Error encoding payload chunk [sequence number " + this.f5335 + "].", e);
                } catch (MslCryptoException e2) {
                    throw new IOException("Error encrypting payload chunk [sequence number " + this.f5335 + "].", e2);
                } catch (MslException e3) {
                    throw new IOException("Error compressing payload chunk [sequence number " + this.f5335 + "].", e3);
                }
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.f5346) {
            throw new IOException("Message output stream already closed.");
        }
        DM r2 = m4657();
        if (r2 == null) {
            throw new MslInternalException("Cannot write payload data for an error message.");
        } else if (r2.m4645()) {
            throw new MslInternalException("Cannot write payload data for a handshake message.");
        } else {
            this.f5334.write(bArr, i, i2);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) (i & 255)});
    }
}
