package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
public final class zze {
    public final void zzb(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, map.get(str));
        }
        String uri = buildUpon.build().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    Log.w("HttpUrlPinger", new StringBuilder(String.valueOf(uri).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(uri).toString());
                }
                httpURLConnection.disconnect();
            } catch (IOException | RuntimeException e) {
                String message = e.getMessage();
                Log.w("HttpUrlPinger", new StringBuilder(String.valueOf(message).length() + String.valueOf(uri).length() + 27).append("Error while pinging URL: ").append(uri).append(". ").append(message).toString(), e);
            } catch (Throwable th) {
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IndexOutOfBoundsException e2) {
            String message2 = e2.getMessage();
            Log.w("HttpUrlPinger", new StringBuilder(String.valueOf(message2).length() + String.valueOf(uri).length() + 32).append("Error while parsing ping URL: ").append(uri).append(". ").append(message2).toString(), e2);
        }
    }
}
