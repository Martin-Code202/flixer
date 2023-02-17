package com.crittercism.internal;

import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
public final class bu {
    public SSLSocketFactory a = a();

    public final bv a(bt btVar) {
        bv bvVar;
        byte[] bArr;
        HttpURLConnection httpURLConnection = null;
        cf.a(btVar);
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) btVar.a.openConnection();
            for (Map.Entry<String, String> entry : btVar.d.entrySet()) {
                httpURLConnection2.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection2.setConnectTimeout(2500);
            httpURLConnection2.setReadTimeout(2500);
            httpURLConnection2.setDoOutput(btVar.b.equals("POST"));
            httpURLConnection2.setRequestMethod(btVar.b);
            if (httpURLConnection2 instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
            }
            httpURLConnection2.getOutputStream().write(btVar.c);
            int responseCode = httpURLConnection2.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                bArr = cg.a(httpURLConnection2.getErrorStream());
            } else {
                bArr = cg.a(httpURLConnection2.getInputStream());
            }
            bvVar = new bv(responseCode, bArr);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Exception e) {
            bvVar = new bv(e);
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        cf.a(btVar.a, bvVar);
        return bvVar;
    }

    private static SSLSocketFactory a() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, null, null);
            SSLSocketFactory socketFactory = instance.getSocketFactory();
            if (socketFactory instanceof k) {
                return ((k) socketFactory).a();
            }
            return socketFactory;
        } catch (NoSuchAlgorithmException e) {
            cf.a(ce.NoTLSContext.a());
            cf.c("Error retrieving SSLSocketFactory", e);
            return null;
        } catch (KeyManagementException e2) {
            cf.a(ce.TLSContextInit.a());
            cf.c("Error retrieving SSLSocketFactory", e2);
            return null;
        }
    }
}
