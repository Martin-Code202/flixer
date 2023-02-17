package com.google.android.gms.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
/* access modifiers changed from: package-private */
public final class zzaop extends zzams {
    private static final byte[] zzdtl = "\n".getBytes();
    private final String zzbwh = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzamt.VERSION, Build.VERSION.RELEASE, zzapd.zza(Locale.getDefault()), Build.MODEL, Build.ID);
    private final zzaoz zzdtk;

    zzaop(zzamu zzamu) {
        super(zzamu);
        this.zzdtk = new zzaoz(zzamu.zzvx());
    }

    private final int zza(URL url) {
        zzbp.zzu(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection zzb = zzb(url);
            zzb.connect();
            zzb(zzb);
            int responseCode = zzb.getResponseCode();
            if (responseCode == 200) {
                zzwc().zzvv();
            }
            zzb("GET status", Integer.valueOf(responseCode));
            if (zzb != null) {
                zzb.disconnect();
            }
            return responseCode;
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            if (0 == 0) {
                return 0;
            }
            httpURLConnection.disconnect();
            return 0;
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private final int zza(URL url, byte[] bArr) {
        zzbp.zzu(url);
        zzbp.zzu(bArr);
        zzb("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (zzqu()) {
            zza("Post payload\n", new String(bArr));
        }
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        try {
            getContext().getPackageName();
            HttpURLConnection zzb = zzb(url);
            zzb.setDoOutput(true);
            zzb.setFixedLengthStreamingMode(bArr.length);
            zzb.connect();
            OutputStream outputStream2 = zzb.getOutputStream();
            outputStream2.write(bArr);
            zzb(zzb);
            int responseCode = zzb.getResponseCode();
            if (responseCode == 200) {
                zzwc().zzvv();
            }
            zzb("POST status", Integer.valueOf(responseCode));
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException e) {
                    zze("Error closing http post connection output stream", e);
                }
            }
            if (zzb != null) {
                zzb.disconnect();
            }
            return responseCode;
        } catch (IOException e2) {
            zzd("Network POST connection error", e2);
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    zze("Error closing http post connection output stream", e3);
                }
            }
            if (0 == 0) {
                return 0;
            }
            httpURLConnection.disconnect();
            return 0;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    zze("Error closing http post connection output stream", e4);
                }
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static void zza(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private final int zzb(URL url, byte[] bArr) {
        zzbp.zzu(url);
        zzbp.zzu(bArr);
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        try {
            getContext().getPackageName();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            zza("POST compressed size, ratio %, url", Integer.valueOf(byteArray.length), Long.valueOf((((long) byteArray.length) * 100) / ((long) bArr.length)), url);
            if (byteArray.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray.length), Integer.valueOf(bArr.length));
            }
            if (zzqu()) {
                String valueOf = String.valueOf(new String(bArr));
                zza("Post payload", valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n"));
            }
            HttpURLConnection zzb = zzb(url);
            zzb.setDoOutput(true);
            zzb.addRequestProperty("Content-Encoding", "gzip");
            zzb.setFixedLengthStreamingMode(byteArray.length);
            zzb.connect();
            OutputStream outputStream2 = zzb.getOutputStream();
            outputStream2.write(byteArray);
            outputStream2.close();
            zzb(zzb);
            int responseCode = zzb.getResponseCode();
            if (responseCode == 200) {
                zzwc().zzvv();
            }
            zzb("POST status", Integer.valueOf(responseCode));
            if (zzb != null) {
                zzb.disconnect();
            }
            return responseCode;
        } catch (IOException e) {
            zzd("Network compressed POST connection error", e);
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http compressed post connection output stream", e2);
                }
            }
            if (0 == 0) {
                return 0;
            }
            httpURLConnection.disconnect();
            return 0;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    zze("Error closing http compressed post connection output stream", e3);
                }
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private final HttpURLConnection zzb(URL url) {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzaod.zzdsc.get().intValue());
        httpURLConnection.setReadTimeout(zzaod.zzdsd.get().intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzbwh);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private final URL zzb(zzaoi zzaoi, String str) {
        String str2;
        if (zzaoi.zzyp()) {
            String zzyb = zzanv.zzyb();
            String zzyd = zzanv.zzyd();
            str2 = new StringBuilder(String.valueOf(str).length() + String.valueOf(zzyb).length() + 1 + String.valueOf(zzyd).length()).append(zzyb).append(zzyd).append("?").append(str).toString();
        } else {
            String zzyc = zzanv.zzyc();
            String zzyd2 = zzanv.zzyd();
            str2 = new StringBuilder(String.valueOf(str).length() + String.valueOf(zzyc).length() + 1 + String.valueOf(zzyd2).length()).append(zzyc).append(zzyd2).append("?").append(str).toString();
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final void zzb(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = httpURLConnection.getInputStream();
            do {
            } while (inputStream2.read(new byte[1024]) > 0);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
            throw th;
        }
    }

    private final URL zzd(zzaoi zzaoi) {
        String str;
        if (zzaoi.zzyp()) {
            String valueOf = String.valueOf(zzanv.zzyb());
            String valueOf2 = String.valueOf(zzanv.zzyd());
            str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            String valueOf3 = String.valueOf(zzanv.zzyc());
            String valueOf4 = String.valueOf(zzanv.zzyd());
            str = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final List<Long> zzt(List<zzaoi> list) {
        boolean z;
        ArrayList arrayList = new ArrayList(list.size());
        for (zzaoi zzaoi : list) {
            zzbp.zzu(zzaoi);
            String zza = zza(zzaoi, !zzaoi.zzyp());
            if (zza == null) {
                zzvy().zza(zzaoi, "Error formatting hit for upload");
                z = true;
            } else {
                if (zza.length() <= zzaod.zzdrs.get().intValue()) {
                    URL zzb = zzb(zzaoi, zza);
                    if (zzb == null) {
                        zzdq("Failed to build collect GET endpoint url");
                    } else {
                        z = zza(zzb) == 200;
                    }
                } else {
                    String zza2 = zza(zzaoi, false);
                    if (zza2 == null) {
                        zzvy().zza(zzaoi, "Error formatting hit for POST upload");
                        z = true;
                    } else {
                        byte[] bytes = zza2.getBytes();
                        if (bytes.length > zzaod.zzdrx.get().intValue()) {
                            zzvy().zza(zzaoi, "Hit payload exceeds size limit");
                            z = true;
                        } else {
                            URL zzd = zzd(zzaoi);
                            if (zzd == null) {
                                zzdq("Failed to build collect POST endpoint url");
                            } else if (zza(zzd, bytes) == 200) {
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (!z) {
                break;
            }
            arrayList.add(Long.valueOf(zzaoi.zzym()));
            if (arrayList.size() >= zzanv.zzxz()) {
                break;
            }
        }
        return arrayList;
    }

    private final URL zzyy() {
        String valueOf = String.valueOf(zzanv.zzyb());
        String valueOf2 = String.valueOf(zzaod.zzdrr.get());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzaoi zzaoi, boolean z) {
        zzbp.zzu(zzaoi);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzaoi.zziy().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    zza(sb, key, entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzaoi.zzyn()));
            zza(sb, "qt", String.valueOf(zzvx().currentTimeMillis() - zzaoi.zzyn()));
            if (z) {
                long zzyq = zzaoi.zzyq();
                zza(sb, "z", zzyq != 0 ? String.valueOf(zzyq) : String.valueOf(zzaoi.zzym()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Long> zzs(java.util.List<com.google.android.gms.internal.zzaoi> r15) {
        /*
        // Method dump skipped, instructions count: 269
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaop.zzs(java.util.List):java.util.List");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
        zza("Network initialized. User agent", this.zzbwh);
    }

    public final boolean zzyx() {
        zzj.zzuj();
        zzwk();
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzdm("No network connectivity");
        return false;
    }
}
