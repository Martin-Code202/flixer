package com.netflix.mediaclient.ui.verifyplay;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import o.oX;
import o.qN;
public class PlayVerifierVault implements Parcelable {
    public static final Parcelable.Creator<PlayVerifierVault> CREATOR = new Parcelable.Creator<PlayVerifierVault>() { // from class: com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault.4
        /* renamed from: ॱ  reason: contains not printable characters */
        public PlayVerifierVault createFromParcel(Parcel parcel) {
            return new PlayVerifierVault(parcel);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public PlayVerifierVault[] newArray(int i) {
            return new PlayVerifierVault[i];
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final String f3962 = PlayVerifierVault.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f3963;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f3964;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f3965;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f3966;

    /* renamed from: ˎ  reason: contains not printable characters */
    private VideoType f3967;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f3968;

    /* renamed from: ॱ  reason: contains not printable characters */
    private oX f3969;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f3970;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f3971;

    PlayVerifierVault(String str, String str2, boolean z, boolean z2, VideoType videoType, boolean z3, oX oXVar, String str3, int i) {
        this.f3968 = str;
        this.f3966 = str2;
        this.f3971 = z3;
        this.f3964 = str3;
        this.f3970 = i;
        this.f3969 = oXVar;
        this.f3967 = videoType;
        this.f3965 = z;
        this.f3963 = z2;
    }

    public PlayVerifierVault(String str, String str2, boolean z, boolean z2, VideoType videoType, boolean z3, oX oXVar, int i) {
        this(str, str2, z, z2, videoType, z3, oXVar, null, i);
    }

    public PlayVerifierVault(String str, String str2) {
        this(str, null, false, false, null, false, qN.f9503, str2, -1);
    }

    protected PlayVerifierVault(Parcel parcel) {
        this.f3968 = parcel.readString();
        this.f3966 = parcel.readString();
        this.f3969 = (oX) parcel.readParcelable(oX.class.getClassLoader());
        this.f3971 = parcel.readByte() != 0;
        this.f3964 = parcel.readString();
        this.f3970 = parcel.readInt();
        this.f3965 = parcel.readByte() != 0;
        this.f3963 = parcel.readByte() != 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m2946() {
        return this.f3971;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m2944() {
        return this.f3964;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m2945() {
        return this.f3968;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m2943() {
        return this.f3970;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m2942() {
        return this.f3966;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public oX m2941() {
        return this.f3969;
    }

    @Override // java.lang.Object
    public String toString() {
        return "PinDialogVault [mInvokeLocation=" + this.f3968 + ", mVideoId=" + this.f3966 + ", mRemotePlayback=" + this.f3971 + ", mUuid=" + this.f3964 + ", mPlayContext" + this.f3969 + ", mBookmark=" + this.f3970 + "]";
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public VideoType m2940() {
        return this.f3967;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m2947() {
        return this.f3965;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m2948() {
        return this.f3963;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3968);
        parcel.writeString(this.f3966);
        parcel.writeParcelable(this.f3969, i);
        parcel.writeByte((byte) (this.f3971 ? 1 : 0));
        parcel.writeString(this.f3964);
        parcel.writeInt(this.f3970);
        parcel.writeByte((byte) (this.f3965 ? 1 : 0));
        parcel.writeByte((byte) (this.f3963 ? 1 : 0));
    }

    public enum RequestedBy {
        MDX("mdx"),
        PLAYER("player"),
        PLAY_LAUNCHER("launcher"),
        OFFLINE_DOWNLOAD("offline_download"),
        UNKNOWN("");
        

        /* renamed from: ᐝ  reason: contains not printable characters */
        private String f3978;

        private RequestedBy(String str) {
            this.f3978 = str;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m2951() {
            return this.f3978;
        }
    }
}
