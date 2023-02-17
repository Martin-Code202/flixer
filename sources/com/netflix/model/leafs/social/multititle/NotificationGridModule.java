package com.netflix.model.leafs.social.multititle;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.AbstractC0852;
public class NotificationGridModule extends NotificationModule implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<NotificationGridModule> CREATOR = new Parcelable.Creator<NotificationGridModule>() { // from class: com.netflix.model.leafs.social.multititle.NotificationGridModule.1
        @Override // android.os.Parcelable.Creator
        public NotificationGridModule createFromParcel(Parcel parcel) {
            return new NotificationGridModule(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationGridModule[] newArray(int i) {
            return new NotificationGridModule[i];
        }
    };
    private static final String TAG = "NotificationGridModule";
    @SerializedName("actions")
    private List<NotificationGridTitleAction> actions = new ArrayList();
    @SerializedName("columnWidth")
    private int columnWidth;
    @SerializedName("headlineText")
    private String headlineText;

    public NotificationGridModule() {
    }

    public String getHeadlineText() {
        return this.headlineText;
    }

    public List<NotificationGridTitleAction> getActions() {
        return this.actions;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1613873887:
                    if (key.equals("headlineText")) {
                        c = 1;
                        break;
                    }
                    break;
                case -873453285:
                    if (key.equals("titles")) {
                        c = 2;
                        break;
                    }
                    break;
                case -842461168:
                    if (key.equals("columnWidth")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.columnWidth = value.getAsInt();
                    break;
                case 1:
                    this.headlineText = value.getAsString();
                    break;
                case 2:
                    populateActions(value.getAsJsonArray());
                    break;
            }
        }
    }

    private void populateActions(JsonArray jsonArray) {
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            NotificationGridTitleAction notificationGridTitleAction = new NotificationGridTitleAction();
            notificationGridTitleAction.populate(it.next());
            this.actions.add(notificationGridTitleAction);
        }
    }

    protected NotificationGridModule(Parcel parcel) {
        this.columnWidth = parcel.readInt();
        this.headlineText = parcel.readString();
        parcel.readList(this.actions, NotificationGridTitleAction.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.columnWidth);
        parcel.writeString(this.headlineText);
        parcel.writeList(this.actions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
