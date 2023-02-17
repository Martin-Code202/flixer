package com.netflix.mediaclient.media;

import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.C1349Bv;
import org.json.JSONArray;
import org.json.JSONObject;
public class SubtitleTrackData {
    private String id;
    private Map<String, Integer> mCdnToRankMap = new HashMap();
    private int mPosition = 0;
    private String mediaId;
    private Subtitle subtitleInfo;
    private List<SubtitleUrl> urls = new ArrayList();

    public String toString() {
        return "SubtitleTrackData{id='" + this.id + "', urls=" + this.urls + ", subtitleInfo=" + this.subtitleInfo + ", mPosition=" + this.mPosition + '}';
    }

    public SubtitleTrackData(JSONObject jSONObject, int i, long j) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        this.subtitleInfo = NccpSubtitle.newInstance(jSONObject, i);
        this.id = jSONObject.getString("id");
        JSONObject jSONObject2 = jSONObject.getJSONObject("downloadableIds");
        JSONObject jSONObject3 = jSONObject.getJSONObject("ttDownloadables");
        this.mediaId = jSONObject.optString("new_track_id");
        ISubtitleDef.SubtitleProfile[] values = ISubtitleDef.SubtitleProfile.values();
        for (ISubtitleDef.SubtitleProfile subtitleProfile : values) {
            String optString = jSONObject2.optString(subtitleProfile.m1536());
            if (!(C1349Bv.m4113(optString) || (optJSONObject = jSONObject3.optJSONObject(subtitleProfile.m1536())) == null || (optJSONObject2 = optJSONObject.optJSONObject("downloadUrls")) == null)) {
                long optLong = optJSONObject.optLong("size", -1);
                int optInt = optJSONObject.optInt("midxOffset", 0);
                int optInt2 = optJSONObject.optInt("midxSize", 0);
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString2 = optJSONObject2.optString(next);
                    if (!C1349Bv.m4113(next) && !C1349Bv.m4113(optString2)) {
                        try {
                            SubtitleUrl subtitleUrl = new SubtitleUrl(optString2, subtitleProfile, j, Long.parseLong(next), optString, optLong);
                            subtitleUrl.setMasterIndex(optInt2, optInt);
                            this.urls.add(subtitleUrl);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("cdnlist");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject4 = (JSONObject) optJSONArray.opt(i2);
                int optInt3 = jSONObject4.optInt("rank", 0);
                String optString3 = jSONObject4.optString("id", null);
                if (C1349Bv.m4107(optString3)) {
                    this.mCdnToRankMap.put(optString3, Integer.valueOf(optInt3));
                }
            }
        }
    }

    public void reset() {
        this.mPosition = 0;
    }

    public String getId() {
        return this.id;
    }

    public int getRankForCdn(String str) {
        Integer num = this.mCdnToRankMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public List<SubtitleUrl> getUrls() {
        return this.urls;
    }

    public SubtitleUrl pop() {
        if (this.mPosition >= this.urls.size()) {
            return null;
        }
        List<SubtitleUrl> list = this.urls;
        int i = this.mPosition;
        this.mPosition = i + 1;
        return list.get(i);
    }

    public Subtitle getSubtitleInfo() {
        return this.subtitleInfo;
    }

    public String getDownloadId() {
        if (this.urls.isEmpty()) {
            return null;
        }
        return this.urls.get(0).getDownloadableId();
    }

    public String getMediaId() {
        return this.mediaId;
    }
}
