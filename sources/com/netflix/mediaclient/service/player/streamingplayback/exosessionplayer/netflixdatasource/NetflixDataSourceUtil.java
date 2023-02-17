package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource;

import com.google.android.exoplayer2.upstream.DataSpec;
import o.kP;
public class NetflixDataSourceUtil {

    public enum DataSourceRequestType {
        MediaFragment,
        Header,
        RequestUnknown
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m1024(String str) {
        return "file://nfheader/" + str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m1025(long j) {
        return (((int) (j / 2000)) * 12) + 4096;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static DataSourceRequestType m1023(DataSpec dataSpec) {
        String uri = dataSpec.uri.toString();
        if (uri == null) {
            return DataSourceRequestType.RequestUnknown;
        }
        return uri.startsWith("file://nfheader") ? DataSourceRequestType.Header : DataSourceRequestType.MediaFragment;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m1026(DataSpec dataSpec) {
        kP.C0134 r1 = kP.m8293(dataSpec.key);
        if (r1 == null) {
            return null;
        }
        return r1.f8270;
    }
}
