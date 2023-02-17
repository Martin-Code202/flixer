package o;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.SocketTimeoutException;
import o.AbstractC0499;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
/* renamed from: o.С  reason: contains not printable characters */
public final class AsyncTaskC0486 extends AsyncTask<String, Void, byte[]> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0499.iF f13565;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f13566 = "nf_net";

    /* renamed from: ˎ  reason: contains not printable characters */
    private byte[] f13567;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f13568 = 5000;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f13569 = 3000;

    public AsyncTaskC0486(byte[] bArr, AbstractC0499.iF iFVar) {
        this.f13567 = bArr;
        this.f13565 = iFVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] doInBackground(String... strArr) {
        byte[] bArr = null;
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(strArr[0] + "&signedRequest=" + new String(this.f13567));
        HttpParams params = defaultHttpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(params, this.f13568);
        HttpConnectionParams.setSoTimeout(params, this.f13569);
        int i = 0;
        try {
            httpPost.setHeader("Accept", "*/*");
            httpPost.setHeader("User-Agent", "Widevine CDM v1.0");
            httpPost.setHeader("Content-Type", "application/json");
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            i = execute.getStatusLine().getStatusCode();
            if (i == 200) {
                bArr = EntityUtils.toByteArray(execute.getEntity());
            } else if (i == 400) {
                C1276.m16820().mo5727("15002. Provisiong failed with status code 400 " + strArr[0]);
                if (this.f13565 != null) {
                    this.f13565.mo8078();
                }
                return null;
            }
        } catch (ConnectTimeoutException e) {
            C1283.m16847("nf_net", "Connection timeout", e);
        } catch (SocketTimeoutException e2) {
            C1283.m16847("nf_net", "Socket timeout", e2);
        } catch (ClientProtocolException e3) {
            C1283.m16847("nf_net", "Request protocol failed", (Throwable) e3);
        } catch (IOException e4) {
            C1283.m16847("nf_net", "Request IO failed ", e4);
        }
        if (bArr != null) {
            C1283.m16854("nf_net", "response length=" + bArr.length);
        } else {
            C1283.m16850("nf_net", "Response is null!");
            C1276.m16820().mo5727("Failed to get provisiong certificate. Response is null from URL " + strArr[0] + ". HTTP status code: " + i);
        }
        if (this.f13565 != null) {
            this.f13565.mo8079(bArr);
        }
        return bArr;
    }
}
