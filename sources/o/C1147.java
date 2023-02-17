package o;

import com.netflix.falkor.cache.FalkorCache;
import io.realm.FalkorRealmCacheLruBasedRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import java.util.Date;
/* renamed from: o.ﮣ  reason: contains not printable characters */
public class C1147 implements FalkorCache.If, FalkorCache.Cif, FalkorRealmCacheLruBasedRealmProxyInterface {
    private Date expiry;
    private long lastModified;
    private String path;
    private String payload;
    private boolean sentinel;

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public Date realmGet$expiry() {
        return this.expiry;
    }

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public long realmGet$lastModified() {
        return this.lastModified;
    }

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public String realmGet$path() {
        return this.path;
    }

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public String realmGet$payload() {
        return this.payload;
    }

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public boolean realmGet$sentinel() {
        return this.sentinel;
    }

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public void realmSet$expiry(Date date) {
        this.expiry = date;
    }

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public void realmSet$lastModified(long j) {
        this.lastModified = j;
    }

    public void realmSet$path(String str) {
        this.path = str;
    }

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public void realmSet$payload(String str) {
        this.payload = str;
    }

    @Override // io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public void realmSet$sentinel(boolean z) {
        this.sentinel = z;
    }

    public C1147() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    @Override // com.netflix.falkor.cache.FalkorCache.If
    public void setPath(String str) {
        realmSet$path(str);
    }

    @Override // com.netflix.falkor.cache.FalkorCache.Cif
    public String getPath() {
        return realmGet$path();
    }

    @Override // com.netflix.falkor.cache.FalkorCache.If
    public void setPayload(String str) {
        realmSet$payload(str);
    }

    @Override // com.netflix.falkor.cache.FalkorCache.If
    public String getPayload() {
        return realmGet$payload();
    }

    @Override // com.netflix.falkor.cache.FalkorCache.If
    public void setExpiry(Date date) {
        realmSet$expiry(date);
    }

    @Override // com.netflix.falkor.cache.FalkorCache.If
    public void setSentinel(boolean z) {
        realmSet$sentinel(z);
    }

    @Override // com.netflix.falkor.cache.FalkorCache.If
    public boolean getSentinel() {
        return realmGet$sentinel();
    }

    @Override // com.netflix.falkor.cache.FalkorCache.If
    public void setLastModifiedTime(long j) {
        realmSet$lastModified(j);
    }

    @Override // com.netflix.falkor.cache.FalkorCache.If
    public long getLastModifiedTime() {
        return realmGet$lastModified();
    }
}
