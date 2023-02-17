package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.CommentFrame.1
        @Override // android.os.Parcelable.Creator
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CommentFrame[] newArray(int i) {
            return new CommentFrame[i];
        }
    };
    public final String description;
    public final String language;
    public final String text;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.language = str;
        this.description = str2;
        this.text = str3;
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.language = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return Util.areEqual(this.description, commentFrame.description) && Util.areEqual(this.language, commentFrame.language) && Util.areEqual(this.text, commentFrame.text);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((((this.language != null ? this.language.hashCode() : 0) + 527) * 31) + (this.description != null ? this.description.hashCode() : 0)) * 31) + (this.text != null ? this.text.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.language);
        parcel.writeString(this.text);
    }
}
