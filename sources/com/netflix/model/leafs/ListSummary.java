package com.netflix.model.leafs;

import android.os.Parcel;
import com.google.gson.JsonElement;
import java.util.Map;
import o.AbstractC0847;
import o.AbstractC0852;
public class ListSummary extends AbstractC0847 implements AbstractC0852 {
    private static final String TAG = "ListSummary";
    private int length;

    public ListSummary() {
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1106363674:
                    if (key.equals("length")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.length = entry.getValue().getAsInt();
                    break;
            }
        }
    }

    protected ListSummary(Parcel parcel) {
        this.length = parcel.readInt();
    }

    /* access modifiers changed from: protected */
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.length);
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }
}
