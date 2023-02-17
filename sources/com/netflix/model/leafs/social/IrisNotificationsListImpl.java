package com.netflix.model.leafs.social;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC0929;
import o.AbstractC2082qc;
import o.C1382Cy;
import o.CH;
public class IrisNotificationsListImpl implements AbstractC2082qc, Parcelable {
    public static final Parcelable.Creator<IrisNotificationsListImpl> CREATOR = new Parcelable.Creator<IrisNotificationsListImpl>() { // from class: com.netflix.model.leafs.social.IrisNotificationsListImpl.1
        @Override // android.os.Parcelable.Creator
        public IrisNotificationsListImpl createFromParcel(Parcel parcel) {
            return new IrisNotificationsListImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IrisNotificationsListImpl[] newArray(int i) {
            return new IrisNotificationsListImpl[i];
        }
    };
    List<IrisNotificationSummary> notifications;
    IrisNotificationsListSummary summary;

    public IrisNotificationsListImpl(List<IrisNotificationSummary> list, IrisNotificationsListSummary irisNotificationsListSummary) {
        this.notifications = list;
        this.summary = irisNotificationsListSummary;
    }

    public IrisNotificationsListImpl(IrisNotificationsListSummary irisNotificationsListSummary, List<C1382Cy> list, AbstractC0929<?> r8) {
        this.notifications = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C1382Cy cy = list.get(i);
            cy.f5241.fillVideoDetails((CH) r8.mo15251(cy.f5240.m16080()));
            this.notifications.add(cy.f5241);
        }
        this.summary = irisNotificationsListSummary;
    }

    @Override // o.AbstractC2082qc
    public List<IrisNotificationSummary> getSocialNotifications() {
        return this.notifications;
    }

    @Override // o.AbstractC2082qc
    public IrisNotificationsListSummary getSocialNotificationsListSummary() {
        return this.summary;
    }

    protected IrisNotificationsListImpl(Parcel parcel) {
        this.summary = (IrisNotificationsListSummary) parcel.readParcelable(IrisNotificationsListSummary.class.getClassLoader());
        this.notifications = new ArrayList();
        parcel.readList(this.notifications, IrisNotificationSummary.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.summary, i);
        parcel.writeList(this.notifications);
    }

    @Override // o.AbstractC2082qc
    public Parcelable getParcelable() {
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
