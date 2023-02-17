package com.crittercism.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import java.math.BigInteger;
import org.json.JSONException;
import org.json.JSONObject;
public final class au {
    public ak a;
    Context b;
    ao c;
    ax d = new ay();
    public String e;
    public cb f;
    public String g;
    public String h;
    private by i;
    private a j;

    /* access modifiers changed from: package-private */
    public interface a {
        String a();

        String b();

        String c();

        String d();
    }

    public au(ak akVar, Context context, ao aoVar, String str) {
        this.a = akVar;
        this.b = context;
        this.c = aoVar;
        this.e = str;
        this.i = new by(context);
        this.f = new cb(context);
        if (Build.VERSION.SDK_INT >= 18) {
            this.j = new b((byte) 0);
        } else {
            this.j = new c((byte) 0);
        }
        try {
            Class.forName("UnityPlayerActivity");
            this.h = "unity";
        } catch (ClassNotFoundException unused) {
            this.h = "android";
        }
    }

    public final Integer a() {
        return Integer.valueOf(this.a.b);
    }

    public final String b() {
        try {
            return ((TelephonyManager) this.b.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception unused) {
            return "";
        }
    }

    public final Integer c() {
        int i2 = 0;
        try {
            String networkOperator = ((TelephonyManager) this.b.getSystemService("phone")).getNetworkOperator();
            if (networkOperator != null) {
                i2 = Integer.parseInt(networkOperator.substring(0, 3));
            }
        } catch (Exception unused) {
        }
        return Integer.valueOf(i2);
    }

    public final Integer d() {
        try {
            String networkOperator = ((TelephonyManager) this.b.getSystemService("phone")).getNetworkOperator();
            if (networkOperator != null) {
                return Integer.valueOf(Integer.parseInt(networkOperator.substring(3)));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public final Float e() {
        return Float.valueOf(this.b.getResources().getDisplayMetrics().density);
    }

    public final float f() {
        return this.b.getResources().getDisplayMetrics().xdpi;
    }

    public final float g() {
        return this.b.getResources().getDisplayMetrics().ydpi;
    }

    public final String h() {
        if (this.i != null) {
            return this.i.a();
        }
        return "";
    }

    public final String i() {
        String language = this.b.getResources().getConfiguration().locale.getLanguage();
        if (language == null || language.length() == 0) {
            return "en";
        }
        return language;
    }

    public final String j() {
        try {
            return this.j.b();
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String k() {
        try {
            return this.j.a();
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Long l() {
        return Long.valueOf(Runtime.getRuntime().maxMemory());
    }

    public final String m() {
        try {
            return this.j.d();
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String n() {
        try {
            return this.j.c();
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a(int i2) {
        if (!this.c.b || !ConnectivityManager.isNetworkTypeValid(i2)) {
            return null;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getNetworkInfo(i2);
        JSONObject jSONObject = new JSONObject();
        if (networkInfo != null) {
            try {
                jSONObject.put("available", networkInfo.isAvailable());
                jSONObject.put("connected", networkInfo.isConnected());
                if (!networkInfo.isConnected()) {
                    jSONObject.put("connecting", networkInfo.isConnectedOrConnecting());
                }
                jSONObject.put("failover", networkInfo.isFailover());
                if (i2 == 0) {
                    jSONObject.put("roaming", networkInfo.isRoaming());
                }
            } catch (JSONException unused) {
                return null;
            }
        } else {
            jSONObject.put("available", false);
            jSONObject.put("connected", false);
            jSONObject.put("connecting", false);
            jSONObject.put("failover", false);
            if (i2 == 0) {
                jSONObject.put("roaming", false);
            }
        }
        return jSONObject;
    }

    static class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.crittercism.internal.au.a
        public final String b() {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT < 18) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return BigInteger.valueOf(statFs.getAvailableBlocksLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).toString();
        }

        @Override // com.crittercism.internal.au.a
        public final String a() {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT < 18) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return BigInteger.valueOf(statFs.getBlockCountLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).toString();
        }

        @Override // com.crittercism.internal.au.a
        public final String d() {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT < 18) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return BigInteger.valueOf(statFs.getAvailableBlocksLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).toString();
        }

        @Override // com.crittercism.internal.au.a
        public final String c() {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT < 18) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return BigInteger.valueOf(statFs.getBlockCountLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).toString();
        }
    }

    static class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.crittercism.internal.au.a
        public final String b() {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 18) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return BigInteger.valueOf((long) statFs.getAvailableBlocks()).multiply(BigInteger.valueOf((long) statFs.getBlockSize())).toString();
        }

        @Override // com.crittercism.internal.au.a
        public final String a() {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 18) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return BigInteger.valueOf((long) statFs.getBlockCount()).multiply(BigInteger.valueOf((long) statFs.getBlockSize())).toString();
        }

        @Override // com.crittercism.internal.au.a
        public final String d() {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 18) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return BigInteger.valueOf((long) statFs.getAvailableBlocks()).multiply(BigInteger.valueOf((long) statFs.getBlockSize())).toString();
        }

        @Override // com.crittercism.internal.au.a
        public final String c() {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 18) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return BigInteger.valueOf((long) statFs.getBlockCount()).multiply(BigInteger.valueOf((long) statFs.getBlockSize())).toString();
        }
    }
}
