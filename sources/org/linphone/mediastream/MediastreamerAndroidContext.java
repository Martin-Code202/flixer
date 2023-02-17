package org.linphone.mediastream;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
public class MediastreamerAndroidContext {
    private static final int DEVICE_CHOICE = 0;
    public static final int DEVICE_HAS_BUILTIN_AEC = 1;
    public static final int DEVICE_HAS_BUILTIN_AEC_CRAPPY = 2;
    public static final int DEVICE_HAS_BUILTIN_OPENSLES_AEC = 8;
    public static final int DEVICE_USE_ANDROID_MIC = 4;
    private static MediastreamerAndroidContext instance = null;
    private static Context mContext = null;

    private native int enableFilterFromNameImpl(String str, boolean z);

    private native boolean filterFromNameEnabledImpl(String str);

    private native void setDeviceFavoriteBufferSize(int i);

    private native void setDeviceFavoriteSampleRate(int i);

    private MediastreamerAndroidContext() {
    }

    private static MediastreamerAndroidContext getInstance() {
        if (instance == null) {
            instance = new MediastreamerAndroidContext();
        }
        return instance;
    }

    public static Context getContext() {
        return mContext;
    }

    @TargetApi(19)
    public static void setContext(Object obj) {
        if (obj != null) {
            mContext = (Context) obj;
            Log.i("[Device] hasLowLatencyFeature: " + mContext.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency") + ", hasProFeature: " + mContext.getPackageManager().hasSystemFeature("android.hardware.audio.pro"));
            MediastreamerAndroidContext instance2 = getInstance();
            if (Build.VERSION.SDK_INT >= 19) {
                AudioManager audioManager = (AudioManager) mContext.getSystemService("audio");
                int parseInt = parseInt(audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"), 256);
                int parseInt2 = parseInt(audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"), 44100);
                Log.i("[Device] Output frames per buffer: " + parseInt + ", output sample rates: " + parseInt2 + " for OpenSLES MS sound card.");
                instance2.setDeviceFavoriteSampleRate(parseInt2);
                instance2.setDeviceFavoriteBufferSize(parseInt);
                return;
            }
            Log.i("Android < 4.4 detected, android context not used.");
        }
    }

    private static int parseInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            Log.e("Can't parse " + str + " to integer ; using default value " + i);
            return i;
        }
    }

    public static void enableFilterFromName(String str, boolean z) {
        if (getInstance().enableFilterFromNameImpl(str, z) != 0) {
            throw new MediastreamException("Cannot " + (z ? "enable" : "disable") + " filter  name [" + str + "]");
        }
    }

    public static boolean filterFromNameEnabled(String str) {
        return getInstance().filterFromNameEnabledImpl(str);
    }
}
