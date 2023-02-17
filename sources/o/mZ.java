package o;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.pservice.PDiskData;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
public class mZ {
    @SerializedName("horzDispUrl")
    public String horzDispUrl;
    @SerializedName("id")
    public String id;
    @SerializedName("isAgeProtected")
    public boolean isAgeProtected;
    @SerializedName("isAutoPlayEnabled")
    public boolean isAutoPlayEnabled;
    @SerializedName("isNextPlayableEpisode")
    public boolean isNextPlayableEpisode;
    @SerializedName("isPinProtected")
    public boolean isPinProtected;
    @SerializedName("isPlayable")
    public boolean isPlayable;
    @SerializedName("isPlayableEpisode")
    public boolean isPlayableEpisode;
    @SerializedName("isPreviewProtected")
    public boolean isPreviewProtected;
    @SerializedName("playableEndtime")
    public int playableEndtime;
    @SerializedName("playableEpisodeNumber")
    public int playableEpisodeNumber;
    @SerializedName("playableId")
    public String playableId;
    @SerializedName("playableParentId")
    public String playableParentId;
    @SerializedName("playableParentTitle")
    public String playableParentTitle;
    @SerializedName("playableRuntime")
    public int playableRuntime;
    @SerializedName("playableSeasonNumAbbrLabel")
    public String playableSeasonNumAbbrLabel;
    @SerializedName("playableSeasonNumber")
    public int playableSeasonNumber;
    @SerializedName("playableTitle")
    public String playableTitle;
    @SerializedName("plyableBookmarkPos")
    public int plyableBookmarkPos;
    @SerializedName("title")
    public String title;
    @SerializedName("trickplayUrl")
    public String trickplayUrl;
    @SerializedName("tvCardUrl")
    public String tvCardUrl;
    @SerializedName("videoType")
    public VideoType videoType;

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m8986(String str) {
        if (C1349Bv.m4113(str)) {
            return false;
        }
        if (C1349Bv.m4107(this.horzDispUrl) && this.horzDispUrl.contains(str)) {
            return true;
        }
        if (C1349Bv.m4107(this.trickplayUrl) && this.trickplayUrl.contains(str)) {
            return true;
        }
        if (!C1349Bv.m4107(this.tvCardUrl) || !this.tvCardUrl.contains(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m8984(String str) {
        if (C1349Bv.m4113(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("/") + 1;
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf < lastIndexOf2) {
            return str.substring(lastIndexOf, lastIndexOf2);
        }
        try {
            return str.substring(str.indexOf("://") + 3);
        } catch (IndexOutOfBoundsException e) {
            C1276.m16820().mo5725("pre-app url parsing exception " + e);
            return str;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m8985(mZ mZVar, PDiskData.ImageType imageType) {
        String str;
        switch (imageType) {
            case TITLE_CARD:
                str = mZVar.tvCardUrl;
                break;
            case TRICKPLAY:
                str = mZVar.trickplayUrl;
                break;
            case HORIZONTAL_ART:
            default:
                str = mZVar.horzDispUrl;
                break;
        }
        if (!C1349Bv.m4113(str)) {
            return str;
        }
        String str2 = mZVar.horzDispUrl;
        if (!C1349Bv.m4113(str2)) {
            return str2;
        }
        String str3 = mZVar.tvCardUrl;
        C1283.m16855("PVideo", "even fallback url empty try tvCardUrl: %s", mZVar.tvCardUrl);
        return str3;
    }
}
