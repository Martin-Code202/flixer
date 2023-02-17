package com.netflix.mediaclient.servicemgr.offline.realm;

import io.realm.RealmObject;
import io.realm.RealmSeasonRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
public class RealmSeason extends RealmObject implements RealmSeasonRealmProxyInterface {
    private int number;
    private String title;

    @Override // io.realm.RealmSeasonRealmProxyInterface
    public int realmGet$number() {
        return this.number;
    }

    @Override // io.realm.RealmSeasonRealmProxyInterface
    public String realmGet$title() {
        return this.title;
    }

    @Override // io.realm.RealmSeasonRealmProxyInterface
    public void realmSet$number(int i) {
        this.number = i;
    }

    @Override // io.realm.RealmSeasonRealmProxyInterface
    public void realmSet$title(String str) {
        this.title = str;
    }

    public RealmSeason() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public String getTitle() {
        return realmGet$title();
    }

    public void setTitle(String str) {
        realmSet$title(str);
    }

    public void setNumber(int i) {
        realmSet$number(i);
    }

    public int getNumber() {
        return realmGet$number();
    }
}
