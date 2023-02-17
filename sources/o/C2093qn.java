package o;

import android.content.Context;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails;
import com.netflix.mediaclient.servicemgr.offline.realm.RealmOfflineModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import io.realm.RealmObject;
import java.util.List;
/* renamed from: o.qn  reason: case insensitive filesystem */
public class C2093qn {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static RealmConfiguration f9604 = new RealmConfiguration.Builder().name("offline.realm").modules(new RealmOfflineModule(), new Object[0]).migration(new C2090qk()).schemaVersion(12).build();

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Realm m10094() {
        try {
            return C1341Bn.m4056(f9604);
        } catch (IllegalArgumentException e) {
            C1283.m16865("RealmOffline", "WARNING: If you downgraded the app please clear all app data");
            throw e;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m10091(Realm realm, Realm.Transaction transaction) {
        realm.executeTransaction(transaction);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m10089(Realm realm, Realm.Transaction transaction) {
        realm.executeTransactionAsync(transaction);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m10097(Realm realm) {
        realm.close();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m10092(Realm realm, Class cls, String str) {
        return realm.where(cls).equalTo("id", str).count() == 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C2091ql m10090(String str) {
        Realm r2 = m10094();
        try {
            return (C2091ql) r2.where(C2091ql.class).equalTo("id", str).findFirst();
        } finally {
            m10097(r2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static List<RealmIncompleteVideoDetails> m10095(Realm realm) {
        return realm.where(RealmIncompleteVideoDetails.class).findAll();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C2098qr m10096(String str) {
        Realm r2 = m10094();
        try {
            C2098qr qrVar = (C2098qr) r2.where(C2098qr.class).equalTo("id", str).findFirst();
            if (qrVar != null && qrVar.getPlayable() != null) {
                return qrVar;
            }
            m10097(r2);
            return null;
        } finally {
            m10097(r2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m10088(final Context context, Realm realm, final String str) {
        m10091(realm, new Realm.Transaction() { // from class: o.qn.4
            @Override // io.realm.Realm.Transaction
            public void execute(Realm realm2) {
                C2098qr qrVar = (C2098qr) realm2.where(C2098qr.class).equalTo("id", str).findFirst();
                if (qrVar == null) {
                    C1276.m16820().mo5725("SPY-10597: videoRecord to delete is null (playableId= " + str + ")");
                    return;
                }
                boolean z = true;
                if (qrVar.getType() == VideoType.EPISODE) {
                    if (realm2.where(C2098qr.class).equalTo("playable.parentId", qrVar.getPlayable().getTopLevelId()).equalTo("videoType", Integer.valueOf(VideoType.EPISODE.getKey())).findAll().size() == 1) {
                        C2053pb.m9724(context, qrVar.getPlayable().getTopLevelId());
                        realm2.where(C2098qr.class).equalTo("id", qrVar.getPlayable().getTopLevelId()).findAll().deleteAllFromRealm();
                        realm2.where(C2092qm.class).equalTo("parentId", qrVar.getPlayable().getTopLevelId()).findAll().deleteAllFromRealm();
                    }
                    if (realm2.where(C2098qr.class).equalTo("playable.playableId", str).findAll().size() > 1) {
                        z = false;
                    }
                }
                if (z) {
                    realm2.where(C2092qm.class).equalTo("playableId", str).findAll().deleteAllFromRealm();
                }
                C2053pb.m9724(context, str);
                realm2.where(C2098qr.class).equalTo("id", str).findAll().deleteAllFromRealm();
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m10093(Object obj) {
        if (obj == null) {
            C1276.m16820().mo5727("SPY-14007: object was null (deleted from realm)");
            return false;
        } else if (!(obj instanceof RealmModel)) {
            return true;
        } else {
            boolean isValid = RealmObject.isValid((RealmModel) obj);
            if (!isValid) {
                C1276.m16820().mo5727("SPY-14007: object was expected valid (deleted from realm and still referenced in java)");
            }
            return isValid;
        }
    }
}
