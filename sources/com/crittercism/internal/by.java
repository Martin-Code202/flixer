package com.crittercism.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.UUID;
public final class by {
    public static boolean a = true;
    private SharedPreferences b;
    private SharedPreferences c;
    private Context d;

    public by(Context context) {
        if (context == null) {
            throw new NullPointerException("context was null");
        }
        this.d = context;
        this.b = context.getSharedPreferences("com.crittercism.usersettings", 0);
        this.c = context.getSharedPreferences("com.crittercism.prefs", 0);
        if (this.b == null) {
            throw new NullPointerException("prefs were null");
        } else if (this.c == null) {
            throw new NullPointerException("legacy prefs were null");
        }
    }

    private static String b() {
        try {
            return UUID.randomUUID().toString();
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
            cf.b(th);
            return null;
        }
    }

    public final String a() {
        if (a) {
            a = false;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                cf.b(ce.StrictModeDeviceId.a());
            }
        }
        String string = this.b.getString("hashedDeviceID", null);
        if (string == null && (string = this.c.getString("com.crittercism.prefs.did", null)) != null && a(string)) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.remove("com.crittercism.prefs.did");
            edit.commit();
        }
        if (string != null) {
            return string;
        }
        String b2 = b();
        a(b2);
        return b2;
    }

    private boolean a(String str) {
        SharedPreferences.Editor edit = this.b.edit();
        edit.putString("hashedDeviceID", str);
        return edit.commit();
    }
}
