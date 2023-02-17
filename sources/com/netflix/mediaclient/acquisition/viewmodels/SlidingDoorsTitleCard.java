package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.mediaclient.acquisition.kotlinx.KeyPathEvaluationKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.List;
import java.util.Map;
import o.C1456Fq;
import o.C1457Fr;
import o.EI;
public final class SlidingDoorsTitleCard {
    public static final Companion Companion = new Companion(null);
    private final String imageUrl;
    private final String name;
    private final String subtitleStringKey;
    private final String titleStringKey;

    public static /* synthetic */ SlidingDoorsTitleCard copy$default(SlidingDoorsTitleCard slidingDoorsTitleCard, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = slidingDoorsTitleCard.name;
        }
        if ((i & 2) != 0) {
            str2 = slidingDoorsTitleCard.imageUrl;
        }
        if ((i & 4) != 0) {
            str3 = slidingDoorsTitleCard.titleStringKey;
        }
        if ((i & 8) != 0) {
            str4 = slidingDoorsTitleCard.subtitleStringKey;
        }
        return slidingDoorsTitleCard.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final String component3() {
        return this.titleStringKey;
    }

    public final String component4() {
        return this.subtitleStringKey;
    }

    public final SlidingDoorsTitleCard copy(String str, String str2, String str3, String str4) {
        C1457Fr.m5025(str, "name");
        return new SlidingDoorsTitleCard(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SlidingDoorsTitleCard)) {
            return false;
        }
        SlidingDoorsTitleCard slidingDoorsTitleCard = (SlidingDoorsTitleCard) obj;
        return C1457Fr.m5018(this.name, slidingDoorsTitleCard.name) && C1457Fr.m5018(this.imageUrl, slidingDoorsTitleCard.imageUrl) && C1457Fr.m5018(this.titleStringKey, slidingDoorsTitleCard.titleStringKey) && C1457Fr.m5018(this.subtitleStringKey, slidingDoorsTitleCard.subtitleStringKey);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.titleStringKey;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.subtitleStringKey;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "SlidingDoorsTitleCard(name=" + this.name + ", imageUrl=" + this.imageUrl + ", titleStringKey=" + this.titleStringKey + ", subtitleStringKey=" + this.subtitleStringKey + ")";
    }

    public SlidingDoorsTitleCard(String str, String str2, String str3, String str4) {
        C1457Fr.m5025(str, "name");
        this.name = str;
        this.imageUrl = str2;
        this.titleStringKey = str3;
        this.subtitleStringKey = str4;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SlidingDoorsTitleCard(String str, String str2, String str3, String str4, int i, C1456Fq fq) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getTitleStringKey() {
        return this.titleStringKey;
    }

    public final String getSubtitleStringKey() {
        return this.subtitleStringKey;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final SlidingDoorsTitleCard fromJson(Map<String, ? extends Object> map) {
            C1457Fr.m5025(map, "json");
            Object obj = map.get("name");
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str = (String) obj;
            if (str == null) {
                return null;
            }
            Object obj2 = map.get("image");
            if (!(obj2 instanceof String)) {
                obj2 = null;
            }
            String str2 = (String) obj2;
            Object pathValue = KeyPathEvaluationKt.getPathValue((Object) map, (List<String>) EI.m4804(SignupConstants.Field.MESSAGES, "headline", "string"));
            if (!(pathValue instanceof String)) {
                pathValue = null;
            }
            String str3 = (String) pathValue;
            Object pathValue2 = KeyPathEvaluationKt.getPathValue((Object) map, (List<String>) EI.m4804(SignupConstants.Field.MESSAGES, "subHeadline", "string"));
            if (!(pathValue2 instanceof String)) {
                pathValue2 = null;
            }
            return new SlidingDoorsTitleCard(str, str2, str3, (String) pathValue2);
        }
    }
}
