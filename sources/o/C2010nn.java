package o;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import o.C0524;
/* renamed from: o.nn  reason: case insensitive filesystem */
public class C2010nn extends Request<String> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private File f9169;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC2006nj f9170;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Request.Priority f9171;

    public C2010nn(String str, AbstractC2006nj njVar, C0524.AbstractC2398iF iFVar, int i, Request.Priority priority, File file) {
        super(0, str, iFVar);
        this.f9170 = njVar;
        this.f9169 = file;
        this.f9171 = priority;
        setShouldCache(false);
        setRetryPolicy(new C1040(i, 2, 2.0f));
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return this.f9171;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<String> parseNetworkResponse(C1181 r14) {
        File file = new File(this.f9169, BG.m3862(getUrl()));
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(r14.f15530);
            bufferedOutputStream.flush();
            C0524<String> r8 = C0524.m14563("file://" + file.getAbsolutePath(), null);
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    C1283.m16855("nf_service_filedownloadrequest", "Could not close the stream for " + file.getAbsolutePath(), e);
                }
            }
            return r8;
        } catch (IOException e2) {
            C0524<String> r9 = C0524.m14562(new VolleyError("Could not save bytes to " + file.getAbsolutePath(), e2));
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e3) {
                    C1283.m16855("nf_service_filedownloadrequest", "Could not close the stream for " + file.getAbsolutePath(), e3);
                }
            }
            return r9;
        } catch (Throwable th) {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    C1283.m16855("nf_service_filedownloadrequest", "Could not close the stream for " + file.getAbsolutePath(), e4);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void deliverResponse(String str) {
        if (this.f9170 != null) {
            this.f9170.mo8943(getUrl(), str, AbstractC0367.f13235);
        }
    }
}
