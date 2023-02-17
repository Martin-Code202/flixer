package o;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
/* renamed from: o.ry  reason: case insensitive filesystem */
public class C2136ry {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C2136ry f9958 = new C2136ry("", "", VideoType.UNAVAILABLE, new oB("VideoInfo NONE"));

    /* renamed from: ˊ  reason: contains not printable characters */
    private VideoType f9959 = VideoType.UNAVAILABLE;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f9960;

    /* renamed from: ˎ  reason: contains not printable characters */
    private oX f9961 = new oB("VideoInfo");

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f9962 = "";

    public C2136ry(String str, String str2, VideoType videoType, oX oXVar) {
        m10497(str);
        m10498(str2);
        m10496(videoType);
        m10494(oXVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10497(String str) {
        this.f9960 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m10493() {
        return this.f9960;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10498(String str) {
        this.f9962 = str == null ? "" : str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10496(VideoType videoType) {
        if (videoType != null) {
            this.f9959 = videoType;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public VideoType m10492() {
        return this.f9959;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m10494(oX oXVar) {
        if (oXVar != null) {
            this.f9961 = oXVar;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m10495() {
        return this.f9961.getTrackId();
    }
}
