package o;

import com.google.gson.annotations.SerializedName;
/* renamed from: o.pa  reason: case insensitive filesystem */
public class C2052pa {
    @SerializedName("mBookmarkInSecond")
    public final int mBookmarkInSecond;
    @SerializedName("mBookmarkUpdateTimeInUTCMs")
    public final long mBookmarkUpdateTimeInUTCMs;
    @SerializedName("mVideoId")
    public final String mVideoId;

    public C2052pa(int i, long j, String str) {
        this.mBookmarkInSecond = i;
        this.mBookmarkUpdateTimeInUTCMs = j;
        this.mVideoId = str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C2052pa m9718(String str, int i) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return new C2052pa(i, System.currentTimeMillis(), str);
    }
}
