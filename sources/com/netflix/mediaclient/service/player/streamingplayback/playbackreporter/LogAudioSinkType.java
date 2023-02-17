package com.netflix.mediaclient.service.player.streamingplayback.playbackreporter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import o.C1317As;
public class LogAudioSinkType {

    enum AudioSinkType {
        AUDIOSINK_BT("bluetooth"),
        AUDIOSINK_BUILTIN("builtin"),
        AUDIOSINK_HEADPHONE("headphone"),
        AUDIOSINK_DOCK("dock"),
        AUDIOSINK_USB("usb"),
        AUDIOSINK_OTHERS("others"),
        AUDIOSINK_DEAULT("default");
        

        /* renamed from: ᐝ  reason: contains not printable characters */
        private String f1962;

        private AudioSinkType(String str) {
            this.f1962 = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public String m1132() {
            return this.f1962;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m1131(Context context) {
        if (null != context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (C1317As.m3758() > 22) {
                AudioDeviceInfo[] devices = audioManager.getDevices(2);
                if (devices == null || devices.length == 0) {
                    return AudioSinkType.AUDIOSINK_DEAULT.m1132();
                }
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                for (AudioDeviceInfo audioDeviceInfo : devices) {
                    if (audioDeviceInfo.isSink()) {
                        switch (audioDeviceInfo.getType()) {
                            case 1:
                            case 2:
                                z2 = true;
                                continue;
                            case 3:
                            case 4:
                                z3 = true;
                                continue;
                            case 7:
                            case 8:
                                z = true;
                                continue;
                            case 11:
                            case 12:
                                z4 = true;
                                continue;
                            case 13:
                                z5 = true;
                                continue;
                        }
                    }
                }
                if (z) {
                    return AudioSinkType.AUDIOSINK_BT.m1132();
                }
                if (z3) {
                    return AudioSinkType.AUDIOSINK_HEADPHONE.m1132();
                }
                if (z5) {
                    return AudioSinkType.AUDIOSINK_DOCK.m1132();
                }
                if (z4) {
                    return AudioSinkType.AUDIOSINK_USB.m1132();
                }
                if (z2) {
                    return AudioSinkType.AUDIOSINK_BUILTIN.m1132();
                }
                return AudioSinkType.AUDIOSINK_OTHERS.m1132();
            } else if (audioManager.isBluetoothA2dpOn()) {
                return AudioSinkType.AUDIOSINK_BT.m1132();
            } else {
                if (audioManager.isBluetoothScoOn()) {
                    return AudioSinkType.AUDIOSINK_BT.m1132();
                }
                if (audioManager.isSpeakerphoneOn()) {
                    return AudioSinkType.AUDIOSINK_BUILTIN.m1132();
                }
                if (audioManager.isWiredHeadsetOn()) {
                    return AudioSinkType.AUDIOSINK_HEADPHONE.m1132();
                }
            }
        }
        return AudioSinkType.AUDIOSINK_DEAULT.m1132();
    }
}
