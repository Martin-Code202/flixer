package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
public class CM implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: o.CM.5
        /* renamed from: ˎ  reason: contains not printable characters */
        public CM createFromParcel(Parcel parcel) {
            return new CM(parcel);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public CM[] newArray(int i) {
            return new CM[i];
        }
    };
    @SerializedName("positiveChoice")
    String agree;
    @SerializedName("questionBody")
    String body;
    @SerializedName("negativeChoice")
    String disagree;
    @SerializedName("type")
    String header;
    @SerializedName("id")
    String id;
    @SerializedName("skipLabel")
    String skip;
    @SerializedName("questionHeader")
    String title;
    @SerializedName("surveyType")
    String type;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m4217() {
        return this.id;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m4216() {
        return this.header;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m4218() {
        return this.title;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m4220() {
        return this.body;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m4219() {
        return this.agree;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m4222() {
        return this.disagree;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m4221() {
        return this.skip;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m4215() {
        return this.type;
    }

    protected CM() {
    }

    public CM(JsonElement jsonElement) {
        populate(jsonElement);
    }

    public CM(Parcel parcel) {
        this.id = parcel.readString();
        this.type = parcel.readString();
        this.header = parcel.readString();
        this.title = parcel.readString();
        this.body = parcel.readString();
        this.agree = parcel.readString();
        this.disagree = parcel.readString();
        this.skip = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.header);
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        parcel.writeString(this.agree);
        parcel.writeString(this.disagree);
        parcel.writeString(this.skip);
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1221270899:
                    if (key.equals("header")) {
                        c = 2;
                        break;
                    }
                    break;
                case -673944140:
                    if (key.equals("surveyType")) {
                        c = 1;
                        break;
                    }
                    break;
                case -172652888:
                    if (key.equals("questionBody")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1683659318:
                    if (key.equals("negativeChoice")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1746732563:
                    if (key.equals("questionHeader")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2076524725:
                    if (key.equals("skipLabel")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2091762938:
                    if (key.equals("positiveChoice")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.id = value.getAsString();
                    break;
                case 1:
                    this.type = value.getAsString();
                    break;
                case 2:
                    this.header = value.getAsString();
                    break;
                case 3:
                    this.title = value.getAsString();
                    break;
                case 4:
                    this.body = value.getAsString();
                    break;
                case 5:
                    this.agree = value.getAsString();
                    break;
                case 6:
                    this.disagree = value.getAsString();
                    break;
                case 7:
                    this.skip = value.getAsString();
                    break;
            }
        }
    }
}
