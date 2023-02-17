package com.netflix.mediaclient.media.manifest;

import java.util.ArrayList;
import java.util.List;
public class Stream {
    public int bitrate;
    public String content_profile;
    public String downloadable_id;
    public boolean isDrm;
    public String new_stream_id;
    public int peakBitrate;
    public int res_h;
    public int res_w;
    public Long size;
    public String trackType;
    public int type;
    public List<Url> urls = new ArrayList();
    public int vmaf;

    public String toString() {
        String str = "BR=" + this.bitrate + ", WxH=" + this.res_w + " x " + this.res_h + ", vmaf=" + this.vmaf;
        if (this.peakBitrate > 0) {
            return str + ", peakBR=" + this.peakBitrate;
        }
        return str;
    }
}
