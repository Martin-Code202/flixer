package com.crittercism.internal;

import java.util.HashMap;
public enum bi {
    OK(0, null),
    ASSERTION_ERROR(1, "java.lang.AssertionError"),
    BIND_EXCEPTION(2, "java.net.BindException"),
    CLASS_NOT_FOUND_EXCEPTION(3, "java.lang.ClassNotFoundException"),
    ERROR(4, "java.lang.Error"),
    IO_EXCEPTION(5, "java.io.IOException"),
    ILLEGAL_ARGUMENT_EXCEPTION(6, "java.lang.IllegalArgumentException"),
    ILLEGAL_STATE_EXCEPTION(7, "java.lang.IllegalStateException"),
    INDEX_OUT_OF_BOUNDS_EXCEPTION(8, "java.lang.IndexOutOfBoundsException"),
    MALFORMED_URL_EXCEPTION(9, "java.net.MalformedURLException"),
    NO_SUCH_PROVIDER_EXCEPTION(10, "java.security.NoSuchProviderException"),
    NULL_POINTER_EXCEPTION(11, "java.lang.NullPointerException"),
    PROTOCOL_EXCEPTION(12, "java.net.ProtocolException"),
    SECURITY_EXCEPTION(13, "java.lang.SecurityException"),
    SOCKET_EXCEPTION(14, "java.net.SocketException"),
    SOCKET_TIMEOUT_EXCEPTION(15, "java.net.SocketTimeoutException"),
    SSL_PEER_UNVERIFIED_EXCEPTION(16, "javax.net.ssl.SSLPeerUnverifiedException"),
    STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION(17, "java.lang.StringIndexOutOfBoundsException"),
    UNKNOWN_HOST_EXCEPTION(18, "java.net.UnknownHostException"),
    UNKNOWN_SERVICE_EXCEPTION(19, "java.net.UnknownServiceException"),
    UNSUPPORTED_OPERATION_EXCEPTION(20, "java.lang.UnsupportedOperationException"),
    URI_SYNTAX_EXCEPTION(21, "java.net.URISyntaxException"),
    CONNECT_EXCEPTION(22, "java.net.ConnectException"),
    SSL_EXCEPTION(23, "javax.net.ssl.SSLException"),
    SSL_HANDSHAKE_EXCEPTION(24, "javax.net.ssl.SSLHandshakeException"),
    SSL_KEY_EXCEPTION(25, "javax.net.ssl.SSLKeyException"),
    SSL_PROTOCOL_EXCEPTION(26, "javax.net.ssl.SSLProtocolException"),
    UNDEFINED_EXCEPTION(-1, "__UNKNOWN__");
    
    private static HashMap<String, bi> D;
    public int C;
    private String E;

    private bi(int i, String str) {
        this.C = i;
        this.E = str;
    }

    private static synchronized void a() {
        synchronized (bi.class) {
            if (D == null) {
                HashMap<String, bi> hashMap = new HashMap<>();
                bi[] values = values();
                for (bi biVar : values) {
                    hashMap.put(biVar.E, biVar);
                }
                D = hashMap;
            }
        }
    }

    public static bi a(Throwable th) {
        if (D == null) {
            a();
        }
        String str = null;
        if (th != null) {
            str = th.getClass().getName();
        }
        bi biVar = D.get(str);
        if (biVar == null) {
            return UNDEFINED_EXCEPTION;
        }
        return biVar;
    }
}
