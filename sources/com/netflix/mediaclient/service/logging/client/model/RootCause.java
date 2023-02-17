package com.netflix.mediaclient.service.logging.client.model;
public enum RootCause {
    dnsTimeout,
    dnsLookupFailure,
    tcpConnectionTimeout,
    tcpNoRouteToHost,
    tcpConnectionRefusal,
    sslUntrustedCert,
    sslExpiredCert,
    sslNoCipher,
    sslHandshakeFailure,
    networkFailure,
    http4xx,
    http5xx,
    clientRequestBad,
    clientFailure,
    serverResponseBad,
    serverFailure,
    unknownFailure,
    handledException,
    unhandledException
}
