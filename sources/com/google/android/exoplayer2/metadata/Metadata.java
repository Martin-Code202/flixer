package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() { // from class: com.google.android.exoplayer2.metadata.Metadata.1
        @Override // android.os.Parcelable.Creator
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Metadata[] newArray(int i) {
            return new Metadata[0];
        }
    };
    private final Entry[] entries;

    public interface Entry extends Parcelable {
    }

    public Metadata(Entry... entryArr) {
        this.entries = entryArr == null ? new Entry[0] : entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        if (list != null) {
            this.entries = new Entry[list.size()];
            list.toArray(this.entries);
            return;
        }
        this.entries = new Entry[0];
    }

    Metadata(Parcel parcel) {
        this.entries = new Entry[parcel.readInt()];
        for (int i = 0; i < this.entries.length; i++) {
            this.entries[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
        }
    }

    public int length() {
        return this.entries.length;
    }

    public Entry get(int i) {
        return this.entries[i];
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.entries, ((Metadata) obj).entries);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(this.entries);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.entries.length);
        for (Entry entry : this.entries) {
            parcel.writeParcelable(entry, 0);
        }
    }
}
