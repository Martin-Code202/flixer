package o;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* access modifiers changed from: package-private */
public class hH extends AbstractC1055 implements AbstractC1151 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f7119;

    /* renamed from: ˊ  reason: contains not printable characters */
    private BufferedOutputStream f7120;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f7121;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final hE f7122 = new hE();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final File f7123;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f7124;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private If f7125;

    public interface If {
        /* renamed from: ʽ  reason: contains not printable characters */
        void mo6937();

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo6938();

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo6939(VolleyError volleyError);

        /* renamed from: ˎ  reason: contains not printable characters */
        void mo6940(long j);

        /* renamed from: ॱ  reason: contains not printable characters */
        void mo6941(hH hHVar);
    }

    public hH(String str, File file, Request.Priority priority, If r7) {
        super(str, priority);
        this.f7121 = str;
        this.f7123 = file;
        this.f7119 = this.f7123.getName();
        this.f7125 = r7;
        m16104(this);
        this.f7124 = "bytes=" + this.f7123.length() + "-";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6931(C0482 r4) {
        this.f7122.f7064 = System.currentTimeMillis();
        this.f7122.f7063 = this.f7123.length();
        r4.m14415(this);
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Range", this.f7124);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1055
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6936(long j) {
        if (this.f7120 == null) {
            try {
                this.f7120 = new BufferedOutputStream(new FileOutputStream(this.f7123, true));
            } catch (FileNotFoundException e) {
                m6926();
                return;
            }
        }
        this.f7122.f7062 = System.currentTimeMillis();
        if (this.f7125 != null) {
            this.f7125.mo6940(j);
        }
    }

    @Override // o.AbstractC1151
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6932(byte[] bArr, int i) {
        try {
            if (this.f7120 == null) {
                C1283.m16862("nf_httpUrlDownloader", "onNext mBufferedOutputStream null. not writing");
            } else if (isCanceled()) {
                C1283.m16862("nf_httpUrlDownloader", "cancelled, closing file and returning");
                m16104((AbstractC1151) null);
                m6929();
            } else if (i > 0) {
                this.f7120.write(bArr, 0, i);
                this.f7122.f7065 += (long) i;
                m6928();
            } else if (i < 0) {
                C1283.m16862("nf_httpUrlDownloader", "onNext done count=" + i);
                m16104((AbstractC1151) null);
                m6929();
                this.f7122.f7067 = System.currentTimeMillis();
                m6927();
            }
        } catch (IOException e) {
            C1283.m16856("nf_httpUrlDownloader", e, "onNext write to disk failed", new Object[0]);
            m16104((AbstractC1151) null);
            m6926();
            super.cancel();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6928() {
        if (this.f7125 != null) {
            this.f7125.mo6941(this);
        }
    }

    @Override // o.AbstractC1151
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6934(VolleyError volleyError) {
        m16104((AbstractC1151) null);
        this.f7122.f7066 = System.currentTimeMillis();
        m6929();
        m6930(volleyError);
    }

    @Override // o.AbstractC1151
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6935() {
        C1283.m16862("nf_httpUrlDownloader", "onCancelled");
        m16104((AbstractC1151) null);
        m6929();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6927() {
        If r1 = this.f7125;
        if (r1 != null) {
            r1.mo6938();
            this.f7125 = null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6929() {
        if (this.f7120 != null) {
            try {
                this.f7120.flush();
                this.f7120.close();
            } catch (IOException e) {
                C1283.m16856("nf_httpUrlDownloader", e, "flushAndCloseOutputStream:", new Object[0]);
            }
            this.f7120 = null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6930(VolleyError volleyError) {
        If r1 = this.f7125;
        if (r1 != null) {
            r1.mo6939(volleyError);
            this.f7125 = null;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m6926() {
        If r1 = this.f7125;
        if (r1 != null) {
            r1.mo6937();
            this.f7125 = null;
        }
    }

    @Override // com.android.volley.Request
    public void cancel() {
        this.f7125 = null;
        super.cancel();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public long m6933() {
        return this.f7122.f7063 + this.f7122.f7065;
    }
}
