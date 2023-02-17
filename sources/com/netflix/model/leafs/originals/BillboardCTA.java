package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.AK;
import o.AbstractC0852;
public class BillboardCTA implements AbstractC0852 {
    private static final String TAG = "BillboardCTA";
    private String billboardPhase;
    private String bookmarkPosition;
    private Boolean ignoreBookmark;
    private int index;
    private String name;
    private String sequenceNumber;
    private Boolean suppressPostPlay;
    private String type;
    private String videoId;

    public BillboardCTA(String str, Boolean bool, String str2, String str3, Boolean bool2, String str4, String str5) {
        this(str, bool, str2, str3, bool2, str4, str5, 0, null);
    }

    public BillboardCTA(String str, Boolean bool, String str2, String str3, Boolean bool2, String str4, String str5, int i, String str6) {
        this.bookmarkPosition = str;
        this.ignoreBookmark = bool;
        this.name = str2;
        this.sequenceNumber = str3;
        this.suppressPostPlay = bool2;
        this.type = str4;
        this.videoId = str5;
        this.index = i;
        this.billboardPhase = str6;
    }

    public BillboardCTA(JsonElement jsonElement) {
        populate(jsonElement);
    }

    public String getName() {
        return this.name;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public Boolean getSuppressPostPlay() {
        return this.suppressPostPlay;
    }

    public String getType() {
        return this.type;
    }

    public String getSequenceNumber() {
        return this.sequenceNumber;
    }

    public String getBookmarkPosition() {
        return this.bookmarkPosition;
    }

    public boolean ignoreBookmark() {
        return this.ignoreBookmark.booleanValue();
    }

    public int getIndex() {
        return this.index;
    }

    public String getBillboardPhase() {
        return this.billboardPhase;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1829827457:
                    if (key.equals("bookmarkPosition")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1353995670:
                    if (key.equals("sequenceNumber")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1041198724:
                    if (key.equals("billboardPhase")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3373707:
                    if (key.equals("name")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3575610:
                    if (key.equals("type")) {
                        c = 3;
                        break;
                    }
                    break;
                case 100346066:
                    if (key.equals("index")) {
                        c = 5;
                        break;
                    }
                    break;
                case 452782838:
                    if (key.equals("videoId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 994317608:
                    if (key.equals("ignoreBookmark")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1144180169:
                    if (key.equals("suppressPostPlay")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.name = AK.m3375(value);
                    break;
                case 1:
                    this.videoId = AK.m3375(value);
                    break;
                case 2:
                    this.suppressPostPlay = Boolean.valueOf(AK.m3384(value));
                    break;
                case 3:
                    this.type = AK.m3375(value);
                    break;
                case 4:
                    this.billboardPhase = AK.m3375(value);
                    break;
                case 5:
                    this.index = AK.m3379(value);
                    break;
                case 6:
                    this.ignoreBookmark = Boolean.valueOf(AK.m3384(value));
                    break;
                case 7:
                    this.sequenceNumber = AK.m3375(value);
                    break;
                case '\b':
                    this.bookmarkPosition = AK.m3375(value);
                    break;
            }
        }
    }

    public static List<BillboardCTA> getListOfActions(JsonElement jsonElement) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(new BillboardCTA(it.next()));
        }
        return arrayList;
    }
}
