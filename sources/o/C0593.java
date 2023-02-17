package o;

import com.android.volley.VolleyError;
import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
/* renamed from: o.ٺ  reason: contains not printable characters */
class C0593 extends UrlRequest.Callback {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final C0594 f13878 = new C0594(3, 8192, 1024);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final iF f13879;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0594.Cif f13880;

    /* renamed from: ˏ  reason: contains not printable characters */
    private List<byte[]> f13881 = new LinkedList();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f13882;

    /* renamed from: o.ٺ$iF */
    public interface iF {
        /* renamed from: ˊ */
        void mo14652(C1181 v);

        /* renamed from: ˋ */
        void mo14653(VolleyError volleyError);
    }

    public C0593(String str, iF iFVar) {
        this.f13882 = str;
        this.f13879 = iFVar;
        C1283.m16848("nf_network", "--> %s", this.f13882);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        C1283.m16848("nf_network", "--- %s -> %s", this.f13882, str);
        urlRequest.followRedirect();
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f13880 = f13878.m14725();
        urlRequest.read(this.f13880.f13886);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 0, bArr.length);
        this.f13881.add(bArr);
        this.f13880.f13886.clear();
        urlRequest.read(this.f13880.f13886);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        m14724();
        C1283.m16848("nf_network", "<-- %s %s", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()));
        this.f13879.mo14652(m14723(urlResponseInfo, this.f13881));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0019: APUT  (r2v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r3v1 java.lang.String) */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        m14724();
        Object[] objArr = new Object[2];
        objArr[0] = this.f13882;
        objArr[1] = cronetException == null ? "" : cronetException.getMessage();
        C1283.m16848("nf_network", "!!! %s %s", objArr);
        this.f13879.mo14653(new VolleyError(cronetException));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        m14724();
        C1283.m16848("nf_network", "!!! %s CANCELED", urlResponseInfo.getUrl());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14724() {
        if (this.f13880 != null) {
            f13878.m14726(this.f13880);
            this.f13880 = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ٺ$ˊ  reason: contains not printable characters */
    public static class C0594 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f13883;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Deque<Cif> f13884 = new ConcurrentLinkedDeque();

        public C0594(int i, int i2, int i3) {
            this.f13883 = i3;
            for (int i4 = 0; i4 < i; i4++) {
                this.f13884.add(new Cif(i2, true));
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public Cif m14725() {
            Cif poll = this.f13884.poll();
            if (poll == null) {
                return new Cif(this.f13883, false);
            }
            return poll;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m14726(Cif ifVar) {
            if (ifVar.f13885) {
                ifVar.f13886.clear();
                this.f13884.add(ifVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.ٺ$ˊ$if  reason: invalid class name */
        public static class Cif {

            /* renamed from: ˋ  reason: contains not printable characters */
            final boolean f13885;

            /* renamed from: ˎ  reason: contains not printable characters */
            final ByteBuffer f13886;

            public Cif(int i, boolean z) {
                this.f13886 = ByteBuffer.allocateDirect(i);
                this.f13885 = z;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final C1181 m14723(UrlResponseInfo urlResponseInfo, List<byte[]> list) {
        byte[] bArr;
        int httpStatusCode = urlResponseInfo.getHttpStatusCode();
        if (list.size() == 1) {
            bArr = list.get(0);
        } else {
            int i = 0;
            int i2 = 0;
            for (byte[] bArr2 : list) {
                i += bArr2.length;
            }
            bArr = new byte[i];
            for (byte[] bArr3 : list) {
                System.arraycopy(bArr3, 0, bArr, i2, bArr3.length);
                i2 += bArr3.length;
            }
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : urlResponseInfo.getAllHeadersAsList()) {
            if (!"Set-Cookie".equalsIgnoreCase(entry.getKey()) || !treeMap.containsKey("Set-Cookie")) {
                treeMap.put(entry.getKey(), entry.getValue());
            } else {
                treeMap.put(entry.getKey(), ((String) treeMap.get(entry.getKey())) + "; " + entry.getValue());
            }
        }
        return new C1181(httpStatusCode, bArr, treeMap, false);
    }
}
