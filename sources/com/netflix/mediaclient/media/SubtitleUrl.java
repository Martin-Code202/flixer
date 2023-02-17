package com.netflix.mediaclient.media;

import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import o.AK;
import org.json.JSONObject;
public class SubtitleUrl {
    private static final String ATTR_CDN_ID = "cdnId";
    private static final String ATTR_DECRYPTION_KEY = "decryptionKey";
    private static final String ATTR_DOWNLOADABLE_ID = "downloadableId";
    private static final String ATTR_MASTER_INDEX_OFFSET = "masterIndexOffset";
    private static final String ATTR_MASTER_INDEX_SIZE = "masterIndexSize";
    private static final String ATTR_PROFILE = "profile";
    private static final String ATTR_URL = "url";
    private static final String ATTR_XID = "xid";
    private static final String TAG = "nf_subtitles";
    private long mCdnId;
    private String mDecryptionKey;
    private String mDownloadableId;
    private int mMasterIndexOffset;
    private int mMasterIndexSize;
    private ISubtitleDef.SubtitleProfile mProfile;
    private long mSize = -1;
    private String mUrl;
    private long mXid;

    public SubtitleUrl(JSONObject jSONObject) {
        populate(jSONObject);
    }

    /* access modifiers changed from: protected */
    public void populate(JSONObject jSONObject) {
        this.mUrl = AK.m3376(jSONObject, ATTR_URL, (String) null);
        this.mProfile = ISubtitleDef.SubtitleProfile.m1534(AK.m3376(jSONObject, ATTR_PROFILE, (String) null));
        this.mXid = AK.m3388(jSONObject, ATTR_XID, 0);
        this.mCdnId = AK.m3388(jSONObject, ATTR_CDN_ID, 0);
        this.mDownloadableId = AK.m3376(jSONObject, ATTR_DOWNLOADABLE_ID, (String) null);
        if (this.mProfile == ISubtitleDef.SubtitleProfile.IMAGE || this.mProfile == ISubtitleDef.SubtitleProfile.IMAGE_ENC) {
            this.mMasterIndexSize = AK.m3386(jSONObject, ATTR_MASTER_INDEX_SIZE, 0);
            this.mMasterIndexOffset = AK.m3386(jSONObject, ATTR_MASTER_INDEX_OFFSET, 0);
        }
        this.mDecryptionKey = AK.m3376(jSONObject, ATTR_DECRYPTION_KEY, (String) null);
    }

    public SubtitleUrl(String str, ISubtitleDef.SubtitleProfile subtitleProfile, long j, long j2, String str2, long j3) {
        this.mUrl = str;
        this.mProfile = subtitleProfile;
        this.mXid = j;
        this.mCdnId = j2;
        this.mDownloadableId = str2;
        this.mSize = j3;
    }

    public void setDecryptionKey(String str) {
        this.mDecryptionKey = str;
    }

    public void setMasterIndex(int i, int i2) {
        this.mMasterIndexSize = i;
        this.mMasterIndexOffset = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SubtitleUrl subtitleUrl = (SubtitleUrl) obj;
        if (this.mMasterIndexSize != subtitleUrl.mMasterIndexSize || this.mMasterIndexOffset != subtitleUrl.mMasterIndexOffset) {
            return false;
        }
        if (this.mUrl != null) {
            if (!this.mUrl.equals(subtitleUrl.mUrl)) {
                return false;
            }
        } else if (subtitleUrl.mUrl != null) {
            return false;
        }
        if (this.mDownloadableId != null) {
            if (!this.mDownloadableId.equals(subtitleUrl.mDownloadableId)) {
                return false;
            }
        } else if (subtitleUrl.mDownloadableId != null) {
            return false;
        }
        return this.mCdnId == subtitleUrl.mCdnId && this.mXid == subtitleUrl.mXid && this.mProfile == subtitleUrl.mProfile;
    }

    public int hashCode() {
        return ((((((((((((this.mUrl != null ? this.mUrl.hashCode() : 0) * 31) + (this.mDownloadableId != null ? this.mDownloadableId.hashCode() : 0)) * 31) + ((int) this.mCdnId)) * 31) + ((int) this.mXid)) * 31) + this.mMasterIndexSize) * 31) + this.mMasterIndexOffset) * 31) + (this.mProfile != null ? this.mProfile.hashCode() : 0);
    }

    public String getDownloadUrl() {
        return this.mUrl;
    }

    public int getMasterIndexSize() {
        return this.mMasterIndexSize;
    }

    public int getMasterIndexOffset() {
        return this.mMasterIndexOffset;
    }

    public ISubtitleDef.SubtitleProfile getProfile() {
        return this.mProfile;
    }

    public String getDownloadableId() {
        return this.mDownloadableId;
    }

    public long getCdnId() {
        return this.mCdnId;
    }

    public long getXid() {
        return this.mXid;
    }

    public String getDecryptionKey() {
        return this.mDecryptionKey;
    }

    public String getSubtitleProfile() {
        return this.mProfile.m1536();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        if (this.mUrl != null) {
            jSONObject.put(ATTR_URL, this.mUrl);
        }
        jSONObject.put(ATTR_PROFILE, this.mProfile.m1536());
        jSONObject.put(ATTR_XID, this.mXid);
        jSONObject.put(ATTR_CDN_ID, this.mCdnId);
        jSONObject.put(ATTR_DOWNLOADABLE_ID, this.mDownloadableId);
        if (this.mProfile == ISubtitleDef.SubtitleProfile.IMAGE || this.mProfile == ISubtitleDef.SubtitleProfile.IMAGE_ENC) {
            jSONObject.put(ATTR_MASTER_INDEX_OFFSET, this.mMasterIndexOffset);
            jSONObject.put(ATTR_MASTER_INDEX_SIZE, this.mMasterIndexSize);
        }
        if (this.mDecryptionKey != null) {
            jSONObject.put(ATTR_DECRYPTION_KEY, this.mDecryptionKey);
        }
        return jSONObject;
    }

    public String toString() {
        return "SubtitleUrl{mUrl='" + this.mUrl + "', mDownloadableId='" + this.mDownloadableId + "', mCdnId=" + this.mCdnId + ", mXid=" + this.mXid + ", mMasterIndexSize=" + this.mMasterIndexSize + ", mMasterIndexOffset=" + this.mMasterIndexOffset + ", mDecryptionKey='" + this.mDecryptionKey + "', mProfile=" + this.mProfile + '}';
    }

    public long getSize() {
        return this.mSize;
    }
}
