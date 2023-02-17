package com.netflix.mediaclient.service.webclient.model.leafs;

import android.os.Parcel;
import android.os.Parcelable;
public class AvatarInfo implements Parcelable {
    public static final Parcelable.Creator<AvatarInfo> CREATOR = new Parcelable.Creator<AvatarInfo>() { // from class: com.netflix.mediaclient.service.webclient.model.leafs.AvatarInfo.1
        @Override // android.os.Parcelable.Creator
        public AvatarInfo createFromParcel(Parcel parcel) {
            return new AvatarInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AvatarInfo[] newArray(int i) {
            return new AvatarInfo[i];
        }
    };
    private boolean bIsInDefaultSet;
    private String name;
    private String url;

    public AvatarInfo(String str, String str2, boolean z) {
        this.name = str;
        this.url = str2;
        this.bIsInDefaultSet = z;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isInDefaultSet() {
        return this.bIsInDefaultSet;
    }

    protected AvatarInfo(Parcel parcel) {
        String[] strArr = new String[3];
        parcel.readStringArray(strArr);
        this.name = strArr[0];
        this.url = strArr[1];
        this.bIsInDefaultSet = Boolean.valueOf(strArr[2]).booleanValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{this.name, this.url, String.valueOf(this.bIsInDefaultSet)});
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AvatarInfo avatarInfo = (AvatarInfo) obj;
        return (this.name == null && avatarInfo.getName() == null) || this.name.equals(avatarInfo.getName());
    }

    @Override // java.lang.Object
    public String toString() {
        return new StringBuffer("Name: ").append(this.name).append("; url: ").append(this.url).append("; isInDefaultSet: ").append(this.bIsInDefaultSet).toString();
    }
}
