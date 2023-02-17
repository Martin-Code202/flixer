package com.netflix.mediaclient.servicemgr.offline.realm;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import io.realm.Realm;
import io.realm.RealmIncompleteVideoDetailsRealmProxyInterface;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import o.C1276;
import o.C1283;
public class RealmIncompleteVideoDetails extends RealmObject implements RealmIncompleteVideoDetailsRealmProxyInterface {
    private String playableId;
    private String profileId;
    private int videoType;

    @Override // io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public String realmGet$playableId() {
        return this.playableId;
    }

    @Override // io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public String realmGet$profileId() {
        return this.profileId;
    }

    @Override // io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public int realmGet$videoType() {
        return this.videoType;
    }

    @Override // io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public void realmSet$playableId(String str) {
        this.playableId = str;
    }

    @Override // io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public void realmSet$profileId(String str) {
        this.profileId = str;
    }

    @Override // io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public void realmSet$videoType(int i) {
        this.videoType = i;
    }

    public RealmIncompleteVideoDetails() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public String getPlayableId() {
        return realmGet$playableId();
    }

    public void setPlayableId(String str) {
        realmSet$playableId(str);
    }

    public int getVideoType() {
        return realmGet$videoType();
    }

    public void setVideoType(int i) {
        realmSet$videoType(i);
    }

    public String getProfileId() {
        return realmGet$profileId();
    }

    public void setProfileId(String str) {
        realmSet$profileId(str);
    }

    public static void insertInRealm(Realm realm, final String str, final VideoType videoType2, final String str2) {
        realm.executeTransaction(new Realm.Transaction() { // from class: com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails.2
            @Override // io.realm.Realm.Transaction
            public void execute(Realm realm2) {
                RealmIncompleteVideoDetails realmIncompleteVideoDetails = (RealmIncompleteVideoDetails) realm2.where(RealmIncompleteVideoDetails.class).equalTo("playableId", str).findFirst();
                if (realmIncompleteVideoDetails == null) {
                    realmIncompleteVideoDetails = (RealmIncompleteVideoDetails) realm2.createObject(RealmIncompleteVideoDetails.class, str);
                } else {
                    String str3 = "Incomplete object was already in realm " + realmIncompleteVideoDetails.getPlayableId() + ";" + realmIncompleteVideoDetails.getProfileId() + ";" + realmIncompleteVideoDetails.getVideoType();
                    C1283.m16854("RealmIncompleteVideoDetails", str3);
                    C1276.m16820().mo5725(str3);
                }
                realmIncompleteVideoDetails.setVideoType(videoType2.getKey());
                realmIncompleteVideoDetails.setProfileId(str2);
            }
        });
    }
}
