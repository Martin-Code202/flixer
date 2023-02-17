package o;

import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import o.C0593;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;
/* renamed from: o.ৰ  reason: contains not printable characters */
public class C0671 implements AbstractC0644 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private Exception f14039;

    /* renamed from: ʼ  reason: contains not printable characters */
    private VolleyError f14040;

    /* renamed from: ʽ  reason: contains not printable characters */
    private ByteBuffer f14041 = ByteBuffer.allocate(16384);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AtomicBoolean f14042 = new AtomicBoolean(false);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final CountDownLatch f14043 = new CountDownLatch(1);

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f14044;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ExperimentalUrlRequest.Builder f14045;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ExperimentalUrlRequest f14046;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1181 f14047;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C0593.iF f14048 = new C0593.iF() { // from class: o.ৰ.5
        @Override // o.C0593.iF
        /* renamed from: ˊ */
        public void mo14652(C1181 r2) {
            C0671.this.f14047 = r2;
            C0671.this.f14043.countDown();
        }

        @Override // o.C0593.iF
        /* renamed from: ˋ */
        public void mo14653(VolleyError volleyError) {
            C0671.this.f14040 = volleyError;
            C0671.this.f14043.countDown();
        }
    };

    public C0671(ExperimentalCronetEngine experimentalCronetEngine, String str, Request.Priority priority, Map<String, String> map, Object obj) {
        this.f14044 = str;
        this.f14045 = experimentalCronetEngine.newUrlRequestBuilder(str, (UrlRequest.Callback) new C0593(str, this.f14048), AbstractC0661.f14007).disableCache().setPriority(C0651.m14810(priority)).setHttpMethod("POST");
        this.f14045.addHeader("Content-Type", "application/x-www-form-urlencoded");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f14045.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (obj != null) {
            this.f14045.addRequestAnnotation(obj);
        }
    }

    @Override // o.AbstractC0644
    /* renamed from: ˎ */
    public InputStream mo14782() {
        m14874();
        if (this.f14047 != null) {
            if (this.f14047.f15527 < 400) {
                return new ByteArrayInputStream(this.f14047.f15530);
            }
            throw new IOException(new ServerError(this.f14047));
        } else if (this.f14040 != null) {
            throw new IOException(this.f14040.getCause());
        } else if (this.f14039 != null) {
            throw new IOException(this.f14039);
        } else {
            throw new IOException("unknown error");
        }
    }

    @Override // o.AbstractC0644
    /* renamed from: ॱ */
    public String mo14784() {
        if (this.f14047 == null || this.f14047.f15530 == null) {
            return null;
        }
        return new String(this.f14047.f15530);
    }

    @Override // o.AbstractC0644
    /* renamed from: ˏ */
    public OutputStream mo14783() {
        return new OutputStream() { // from class: o.ৰ.1
            @Override // java.io.OutputStream
            public void write(int i) {
                m14875(1);
                C0671.this.f14041.put((byte) i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                m14875(i2);
                C0671.this.f14041.put(bArr, i, i2);
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            private void m14875(int i) {
                if (C0671.this.f14041.limit() - C0671.this.f14041.position() <= i) {
                    ByteBuffer allocate = ByteBuffer.allocate(Math.max(C0671.this.f14041.capacity() * 2, C0671.this.f14041.capacity() + i));
                    C0671.this.f14041.flip();
                    allocate.put(C0671.this.f14041);
                    C0671.this.f14041 = allocate;
                }
            }
        };
    }

    @Override // o.AbstractC0644
    /* renamed from: ˊ */
    public int mo14780() {
        m14874();
        if (this.f14047 == null) {
            return -1;
        }
        return this.f14047.f15527;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m14874() {
        if (!this.f14042.getAndSet(true)) {
            this.f14041.flip();
            this.f14045.setUploadDataProvider(UploadDataProviders.create(this.f14041), AbstractC0661.f14007);
            this.f14045.addHeader("Content-Length", Integer.toString(this.f14041.limit()));
            this.f14046 = this.f14045.build();
            this.f14046.start();
            try {
                this.f14043.await();
            } catch (InterruptedException e) {
                this.f14039 = new IOException("interrupted");
            }
        }
    }

    @Override // o.AbstractC0644
    /* renamed from: ˋ */
    public void mo14781() {
        if (this.f14046 != null) {
            this.f14046.cancel();
        }
    }
}
