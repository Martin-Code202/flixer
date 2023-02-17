package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public final class zzcce implements Runnable {
    private final String mPackageName;
    private final URL zzbvm;
    private final byte[] zzgai;
    private final zzccc zziqh;
    private final Map<String, String> zziqi;
    private /* synthetic */ zzcca zziqj;

    public zzcce(zzcca zzcca, String str, URL url, byte[] bArr, Map<String, String> map, zzccc zzccc) {
        this.zziqj = zzcca;
        zzbp.zzgg(str);
        zzbp.zzu(url);
        zzbp.zzu(zzccc);
        this.zzbvm = url;
        this.zzgai = bArr;
        this.zziqh = zzccc;
        this.mPackageName = str;
        this.zziqi = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziqj.zzatx();
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        try {
            URLConnection openConnection = this.zzbvm.openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
            httpURLConnection2.setDefaultUseCaches(false);
            zzcax.zzawg();
            httpURLConnection2.setConnectTimeout(SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS);
            zzcax.zzawh();
            httpURLConnection2.setReadTimeout(61000);
            httpURLConnection2.setInstanceFollowRedirects(false);
            httpURLConnection2.setDoInput(true);
            if (this.zziqi != null) {
                for (Map.Entry<String, String> entry : this.zziqi.entrySet()) {
                    httpURLConnection2.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if (this.zzgai != null) {
                byte[] zzo = this.zziqj.zzaui().zzo(this.zzgai);
                this.zziqj.zzaum().zzayk().zzj("Uploading data. size", Integer.valueOf(zzo.length));
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.addRequestProperty("Content-Encoding", "gzip");
                httpURLConnection2.setFixedLengthStreamingMode(zzo.length);
                httpURLConnection2.connect();
                OutputStream outputStream2 = httpURLConnection2.getOutputStream();
                outputStream2.write(zzo);
                outputStream2.close();
            }
            int responseCode = httpURLConnection2.getResponseCode();
            Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
            zzcca zzcca = this.zziqj;
            byte[] bArr = zzcca.zzc(httpURLConnection2);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            this.zziqj.zzaul().zzg(new zzccd(this.mPackageName, this.zziqh, responseCode, null, bArr, headerFields));
        } catch (IOException e) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    this.zziqj.zzaum().zzaye().zze("Error closing HTTP compressed POST connection output stream. appId", zzcbw.zzjf(this.mPackageName), e2);
                }
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            this.zziqj.zzaul().zzg(new zzccd(this.mPackageName, this.zziqh, 0, e, null, null));
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    this.zziqj.zzaum().zzaye().zze("Error closing HTTP compressed POST connection output stream. appId", zzcbw.zzjf(this.mPackageName), e3);
                }
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            this.zziqj.zzaul().zzg(new zzccd(this.mPackageName, this.zziqh, 0, null, null, null));
            throw th;
        }
    }
}
