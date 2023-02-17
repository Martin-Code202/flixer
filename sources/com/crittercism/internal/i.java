package com.crittercism.internal;

import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLContextSpi;
public final class i extends Provider.Service {
    public static final String[] a = {"Default", "SSL", "TLSv1.1", "TLSv1.2", "SSLv3", "TLSv1", "TLS"};
    private d b;
    private c c;
    private Provider.Service d;

    private i(Provider.Service service, d dVar, c cVar) {
        super(service.getProvider(), service.getType(), service.getAlgorithm(), service.getClassName(), null, null);
        this.b = dVar;
        this.c = cVar;
        this.d = service;
    }

    private static i a(Provider.Service service, d dVar, c cVar) {
        i iVar = new i(service, dVar, cVar);
        try {
            Field[] fields = Provider.Service.class.getFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                fields[i].set(iVar, fields[i].get(service));
            }
            return iVar;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Provider a() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            if (instance != null) {
                return instance.getProvider();
            }
            return null;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static boolean a(d dVar, c cVar) {
        i a2;
        if (Build.VERSION.SDK_INT < 17 || !j.a()) {
            return false;
        }
        Provider a3 = a();
        boolean z = false;
        if (a3 == null) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            Provider.Service service = a3.getService("SSLContext", a[i]);
            if (!(service == null || (service instanceof i) || (a2 = a(service, dVar, cVar)) == null)) {
                z |= a2.b();
            }
        }
        return z;
    }

    private boolean b() {
        Provider provider = getProvider();
        if (provider == null) {
            return false;
        }
        try {
            Method declaredMethod = Provider.class.getDeclaredMethod("putService", Provider.Service.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(provider, this);
            provider.put("SSLContext.DummySSLAlgorithm", getClassName());
            provider.remove(getType() + "." + getAlgorithm());
            provider.remove("SSLContext.DummySSLAlgorithm");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // java.security.Provider.Service
    public final Object newInstance(Object obj) {
        Object newInstance = super.newInstance(obj);
        j jVar = newInstance;
        if (jVar instanceof SSLContextSpi) {
            try {
                j a2 = j.a((SSLContextSpi) jVar, this.b, this.c);
                if (a2 != null) {
                    jVar = a2;
                }
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable th) {
                cf.b(th);
                return newInstance;
            }
        }
        return jVar;
    }
}
