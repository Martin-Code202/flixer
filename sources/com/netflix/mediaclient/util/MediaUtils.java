package com.netflix.mediaclient.util;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import o.C1317As;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class MediaUtils {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Map<String, VideoDecoderClassfier> f3992 = new HashMap<String, VideoDecoderClassfier>() { // from class: com.netflix.mediaclient.util.MediaUtils.1
        {
            put("video/avc", VideoDecoderClassfier.AVC_HP);
            put("video/x-vnd.on2.vp9", VideoDecoderClassfier.VP9);
            put("video/hevc", VideoDecoderClassfier.HEVC);
        }
    };

    /* access modifiers changed from: package-private */
    public enum VideoDecoderClassfier {
        AVC(2, 2048, 512, 1),
        AVC_HP(8, 2048, 512, 1),
        VP9(1, 64, 32, 1),
        HEVC(1, 1024, 256, 1);
        

        /* renamed from: ʽ  reason: contains not printable characters */
        private int f3998;

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f3999;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private int f4000;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private int f4001;

        private VideoDecoderClassfier(int i, int i2, int i3, int i4) {
            this.f3999 = i;
            this.f4000 = i2;
            this.f4001 = i3;
            this.f3998 = i4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public int m2980() {
            return this.f3999;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public int m2982() {
            return this.f4000;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public int m2983() {
            return this.f4001;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public int m2981() {
            return this.f3998;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public String m2979() {
            return name();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m2978() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("video/avc");
        arrayList.add("video/hevc");
        arrayList.add("video/x-vnd.on2.vp9");
        JSONObject jSONObject = new JSONObject();
        for (String str : arrayList) {
            try {
                jSONObject.putOpt(f3992.get(str).m2979(), m2977(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static MediaCodecInfo[] m2976() {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo[] mediaCodecInfoArr = new MediaCodecInfo[codecCount];
        for (int i = 0; i < codecCount; i++) {
            mediaCodecInfoArr[i] = MediaCodecList.getCodecInfoAt(i);
        }
        return mediaCodecInfoArr;
    }

    @TargetApi(21)
    /* renamed from: ˋ  reason: contains not printable characters */
    private static MediaCodecInfo[] m2974() {
        return new MediaCodecList(1).getCodecInfos();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static JSONArray m2977(String str) {
        MediaCodecInfo[] mediaCodecInfoArr;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        JSONObject r10;
        JSONArray jSONArray = new JSONArray();
        if (C1317As.m3758() >= 21) {
            mediaCodecInfoArr = m2974();
        } else {
            mediaCodecInfoArr = m2976();
        }
        for (MediaCodecInfo mediaCodecInfo : mediaCodecInfoArr) {
            if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).indexOf(str) >= 0 && (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str)) != null && capabilitiesForType.isFeatureSupported("adaptive-playback") && (r10 = m2975(mediaCodecInfo, str)) != null) {
                jSONArray.put(r10);
            }
        }
        return jSONArray;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static JSONObject m2975(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        boolean isFeatureSupported = capabilitiesForType.isFeatureSupported("secure-playback");
        int i = 0;
        VideoDecoderClassfier videoDecoderClassfier = f3992.get(str);
        if (videoDecoderClassfier == null) {
            return null;
        }
        int r6 = m2973(capabilitiesForType.profileLevels, videoDecoderClassfier.m2980());
        if (r6 >= videoDecoderClassfier.m2982()) {
            i = 3;
        } else if (r6 >= videoDecoderClassfier.m2983()) {
            i = 2;
        } else if (r6 >= videoDecoderClassfier.m2981()) {
            i = 1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("name", mediaCodecInfo.getName());
            jSONObject.putOpt("securePlayback", Boolean.valueOf(isFeatureSupported));
            jSONObject.putOpt("hdPlayback", Integer.valueOf(i));
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m2973(MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr, int i) {
        int i2 = 0;
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == i) {
                i2 = Math.max(i2, codecProfileLevel.level);
            }
        }
        return i2;
    }
}
