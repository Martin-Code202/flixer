package com.crittercism.internal;

import android.os.Build;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;
public final class ay implements ax {
    public static final String a = String.format("%s %d (%s)", "Logcat data is not collected for Android APIs before", 16, "Jellybean");

    private static JSONArray a(InputStream inputStream) {
        JSONArray jSONArray = new JSONArray();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int i = 0;
        do {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    jSONArray.put(readLine);
                    i++;
                }
                break;
            } catch (IOException e) {
                cf.c("LogcatProfiler encountered an IOException when attempting to read stream.", e);
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    cf.c("LogcatProfiler unable to close input stream", e2);
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    cf.c("LogcatProfiler unable to close input stream", e3);
                }
                throw th;
            }
        } while (i <= 200);
        try {
            break;
            bufferedReader.close();
        } catch (IOException e4) {
            cf.c("LogcatProfiler unable to close input stream", e4);
        }
        return jSONArray;
    }

    @Override // com.crittercism.internal.ax
    public final JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        Process process = null;
        if (Build.VERSION.SDK_INT < 16) {
            jSONArray.put(a);
            jSONArray.put("API level is " + Build.VERSION.SDK_INT + "(" + Build.VERSION.CODENAME + ")");
            return jSONArray;
        }
        try {
            Process start = new ProcessBuilder("logcat", "-t", Integer.toString(100), "-v", "time").redirectErrorStream(true).start();
            process = start;
            JSONArray a2 = a(start.getInputStream());
            if (process != null) {
                process.destroy();
            }
            return a2;
        } catch (Exception e) {
            cf.b("Unable to collect logcat data", e);
            jSONArray.put("Unable to collect logcat data due to a(n) " + e.getClass().getName());
            String message = e.getMessage();
            if (message != null) {
                jSONArray.put(message);
            }
            if (process != null) {
                process.destroy();
            }
            return jSONArray;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }
}
