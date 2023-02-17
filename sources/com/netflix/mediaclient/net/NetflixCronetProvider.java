package com.netflix.mediaclient.net;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;
import o.C1283;
import o.C1339Bl;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;
public class NetflixCronetProvider extends CronetProvider {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Boolean f992 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final long f993 = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: ˊ  reason: contains not printable characters */
    private CronetProvider f994 = null;

    public NetflixCronetProvider(Context context) {
        super(context);
        if (m466(context)) {
            C1283.m16846("NetflixCronetProvider", "using native implementation");
            this.f994 = m464(context, "org.chromium.net.impl.NativeCronetProvider");
        }
        if (this.f994 == null) {
            C1283.m16865("NetflixCronetProvider", "falling back to platform/Java Cronet implementation");
            this.f994 = m464(context, "org.chromium.net.impl.JavaCronetProvider");
        }
    }

    @Override // org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder() {
        return this.f994.createBuilder();
    }

    @Override // org.chromium.net.CronetProvider
    public String getName() {
        return "NetflixCronetProvider";
    }

    @Override // org.chromium.net.CronetProvider
    public String getVersion() {
        return "99.0.0.0";
    }

    @Override // org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static CronetProvider m464(Context context, String str) {
        try {
            return (CronetProvider) context.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            m465(str, e);
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m465(String str, Exception exc) {
        C1283.m16856("NetflixCronetProvider", exc, "Unable to load provider class: %s", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static synchronized boolean m466(Context context) {
        synchronized (NetflixCronetProvider.class) {
            if (f992 != null) {
                return f992.booleanValue();
            }
            boolean z = true;
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                String str = strArr[0];
                if ("x86".equals(str) || "x86_64".equals(str)) {
                    if (!Build.FINGERPRINT.equals(C1339Bl.m4045(context, "nflx_cronet_load_attempted_fingerprint", (String) null))) {
                        C1339Bl.m4041(context, "nflx_cronet_load_attempted_fingerprint");
                        C1339Bl.m4041(context, "nflx_cronet_load_successful");
                    }
                    z = C1339Bl.m4051(context, "nflx_cronet_load_successful", false);
                    if (!z && !C1339Bl.m4047(context, "nflx_cronet_load_attempted_fingerprint")) {
                        C1339Bl.m4039(context, "nflx_cronet_load_attempted_fingerprint", Build.FINGERPRINT);
                        z = true;
                        new Handler().postDelayed(new If(context), f993);
                    }
                }
            }
            f992 = Boolean.valueOf(z);
            return z;
        }
    }

    /* access modifiers changed from: package-private */
    public static class If implements Runnable {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Context f995;

        If(Context context) {
            this.f995 = context.getApplicationContext();
        }

        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("NetflixCronetProvider", "assuming cronet loaded successfully. white-listing this device for cronet in the future");
            C1339Bl.m4048(this.f995, "nflx_cronet_load_successful", true);
        }
    }
}
