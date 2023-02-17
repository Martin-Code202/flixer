package io.realm;

import java.util.Date;
public interface FalkorRealmCacheLruBasedRealmProxyInterface {
    Date realmGet$expiry();

    long realmGet$lastModified();

    String realmGet$path();

    String realmGet$payload();

    boolean realmGet$sentinel();

    void realmSet$expiry(Date date);

    void realmSet$lastModified(long j);

    void realmSet$payload(String str);

    void realmSet$sentinel(boolean z);
}
