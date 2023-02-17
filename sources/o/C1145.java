package o;

import io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface;
import io.realm.RealmModel;
import io.realm.internal.RealmObjectProxy;
import java.util.Date;
/* renamed from: o.ﮞ  reason: contains not printable characters */
public class C1145 implements RealmModel, FalkorRealmCacheHomeLolomoRealmProxyInterface {
    private Date expiry;
    private String lolomosRef;

    @Override // io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface
    public Date realmGet$expiry() {
        return this.expiry;
    }

    @Override // io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface
    public String realmGet$lolomosRef() {
        return this.lolomosRef;
    }

    @Override // io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface
    public void realmSet$expiry(Date date) {
        this.expiry = date;
    }

    @Override // io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface
    public void realmSet$lolomosRef(String str) {
        this.lolomosRef = str;
    }

    public C1145() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public String getLolomosRef() {
        return realmGet$lolomosRef();
    }

    public void setLolomosRef(String str) {
        realmSet$lolomosRef(str);
    }

    public Date getExpiry() {
        return realmGet$expiry();
    }

    public void setExpiry(Date date) {
        realmSet$expiry(date);
    }
}
