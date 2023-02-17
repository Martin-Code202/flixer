package com.netflix.model.leafs.blades;

import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.blades.C$AutoValue_CreditMarks;
public abstract class CreditMarks implements Parcelable {
    @SerializedName("endcredit")
    public abstract int endCredit();

    @SerializedName("endrecap")
    public abstract int endRecap();

    @SerializedName("startcredit")
    public abstract int startCredit();

    @SerializedName("startrecap")
    public abstract int startRecap();

    public static TypeAdapter<CreditMarks> typeAdapter(Gson gson) {
        return new C$AutoValue_CreditMarks.GsonTypeAdapter(gson).setDefaultEndCredit(-1).setDefaultEndRecap(-1).setDefaultStartCredit(-1).setDefaultStartRecap(-1);
    }
}
