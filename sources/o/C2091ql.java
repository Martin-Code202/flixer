package o;

import android.content.Context;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmProfileRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import java.io.File;
/* renamed from: o.ql  reason: case insensitive filesystem */
public class C2091ql implements RealmModel, RealmProfileRealmProxyInterface {
    private String iconUrl;
    private String id;
    private boolean kids;
    private String name;

    @Override // io.realm.RealmProfileRealmProxyInterface
    public String realmGet$iconUrl() {
        return this.iconUrl;
    }

    @Override // io.realm.RealmProfileRealmProxyInterface
    public String realmGet$id() {
        return this.id;
    }

    @Override // io.realm.RealmProfileRealmProxyInterface
    public boolean realmGet$kids() {
        return this.kids;
    }

    @Override // io.realm.RealmProfileRealmProxyInterface
    public String realmGet$name() {
        return this.name;
    }

    @Override // io.realm.RealmProfileRealmProxyInterface
    public void realmSet$iconUrl(String str) {
        this.iconUrl = str;
    }

    @Override // io.realm.RealmProfileRealmProxyInterface
    public void realmSet$kids(boolean z) {
        this.kids = z;
    }

    @Override // io.realm.RealmProfileRealmProxyInterface
    public void realmSet$name(String str) {
        this.name = str;
    }

    public C2091ql() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public static void insertProfileIfNeeded(Realm realm, Context context, AbstractC0933 r4, final AbstractC2089qj qjVar) {
        final String profileGuid = qjVar.getProfileGuid();
        if (C2093qn.m10092(realm, C2091ql.class, profileGuid)) {
            C2093qn.m10089(realm, new Realm.Transaction() { // from class: o.ql.5
                @Override // io.realm.Realm.Transaction
                public void execute(Realm realm2) {
                    if (C2093qn.m10092(realm2, C2091ql.class, profileGuid)) {
                        ((C2091ql) realm2.createObject(C2091ql.class, profileGuid)).fillForRealm(qjVar);
                    }
                }
            });
            C2053pb.m9722(context, r4, qjVar.getAvatarUrl(), profileGuid);
        }
    }

    public String getId() {
        return realmGet$id();
    }

    public String getName() {
        return realmGet$name();
    }

    public boolean isKids() {
        return realmGet$kids();
    }

    public String getRealmProfileIconUrl(Context context) {
        String r2 = C2053pb.m9719(context, getId());
        if (new File(r2).exists()) {
            return "file://" + r2;
        }
        return realmGet$iconUrl();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fillForRealm(AbstractC2089qj qjVar) {
        realmSet$name(qjVar.getProfileName());
        realmSet$kids(qjVar.isKidsProfile());
        realmSet$iconUrl(qjVar.getAvatarUrl());
    }
}
