package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.model.leafs.ListOfGenreSummary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import o.AbstractC0574;
import o.C1276;
import org.json.JSONException;
import org.json.JSONObject;
public class ListOfTagSummary extends ListOfGenreSummary {
    private static final String TAG = "ListOfTagSummary";
    private boolean isVisible = false;
    private int position;
    private int rank;
    private TagTrackingInfo trackingInfo;

    public ListOfTagSummary(String str, String str2, int i) {
        super(str, str2, GenreList.GenreType.GALLERY);
        this.position = i;
    }

    @Override // com.netflix.model.leafs.ListOfGenreSummary, com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary, o.AbstractC0852
    public void populate(JsonElement jsonElement) {
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public int getRank() {
        return this.rank;
    }

    public int getPosition() {
        return this.position;
    }

    public void setIsVisible(boolean z) {
        this.isVisible = z;
    }

    public boolean getIsVisible() {
        return this.isVisible;
    }

    public void setTrackingInfo(String str, String str2, int i, int i2, int i3) {
        setRequestId(str2);
        setTrackId(i);
        setRank(i3);
        setListPos(i2);
        this.trackingInfo = new TagTrackingInfo(this, str, i2);
    }

    static List<ListOfTagSummary> getListOfTags(JsonElement jsonElement) {
        ArrayList arrayList = new ArrayList();
        if (jsonElement != null && jsonElement.isJsonArray()) {
            int i = 0;
            Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
            while (it.hasNext()) {
                for (Map.Entry<String, JsonElement> entry : it.next().getAsJsonObject().entrySet()) {
                    arrayList.add(new ListOfTagSummary(entry.getKey(), entry.getValue().getAsString(), i));
                    i++;
                }
            }
        }
        return arrayList;
    }

    public AbstractC0574 getTrackingInfo() {
        return this.trackingInfo;
    }

    /* access modifiers changed from: package-private */
    public class TagTrackingInfo implements AbstractC0574 {
        private static final String TAG = "TagTrackingInfo";
        private JSONObject json;

        private TagTrackingInfo(ListOfTagSummary listOfTagSummary, String str, int i) {
            this.json = new JSONObject();
            JSONObject jSONObject = new JSONObject();
            try {
                this.json.put("videoId", str);
                this.json.put("requestId", listOfTagSummary.getRequestId());
                this.json.put("trackId", listOfTagSummary.getTrackId());
                this.json.put("row", i);
                this.json.put("rank", listOfTagSummary.getRank());
                this.json.put("isHero", listOfTagSummary.isHero());
                jSONObject.put(listOfTagSummary.genreId, listOfTagSummary.position);
                this.json.put("titleDescriptorTagMap", jSONObject);
            } catch (JSONException e) {
                C1276.m16820().mo5729(String.format(Locale.US, "%s: Couldn't add genreId: %s and position: %d to trackingInfo.", TAG, listOfTagSummary.genreId, Integer.valueOf(ListOfTagSummary.this.position)), e);
            }
        }

        @Override // o.AbstractC0503
        public JSONObject toJSONObject() {
            return this.json;
        }
    }
}
