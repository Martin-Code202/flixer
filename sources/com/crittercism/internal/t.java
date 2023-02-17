package com.crittercism.internal;

import java.net.Socket;
import java.net.SocketImplFactory;
public final class t implements SocketImplFactory {
    private static boolean a = false;
    private d b;
    private c c;

    public static boolean a(d dVar, c cVar) {
        if (a) {
            return a;
        }
        t tVar = new t(dVar, cVar);
        try {
            tVar.createSocketImpl();
            Socket.setSocketImplFactory(tVar);
            a = true;
            return true;
        } catch (Throwable unused) {
            return a;
        }
    }

    private t(d dVar, c cVar) {
        this.b = dVar;
        this.c = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.SocketImpl, com.crittercism.internal.s] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.net.SocketImplFactory
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.SocketImpl createSocketImpl() {
        /*
            r3 = this;
            com.crittercism.internal.s r0 = new com.crittercism.internal.s
            com.crittercism.internal.d r1 = r3.b
            com.crittercism.internal.c r2 = r3.c
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.t.createSocketImpl():java.net.SocketImpl");
    }
}
