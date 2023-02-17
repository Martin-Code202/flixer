package org.linphone.core;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.linphone.mediastream.MediastreamerAndroidContext;
import org.linphone.mediastream.Version;
import org.linphone.tools.OpenH264DownloadHelper;
public class LinphoneCoreFactoryImpl extends LinphoneCoreFactory {
    private native Object _createTunnelConfig();

    private native void _setLogHandler(Object obj);

    private native long createErrorInfoNative();

    private native DialPlan[] getAllDialPlanNative();

    @Override // org.linphone.core.LinphoneCoreFactory
    public native void enableLogCollection(boolean z);

    @Override // org.linphone.core.LinphoneCoreFactory
    public native void setDebugMode(boolean z, String str);

    @Override // org.linphone.core.LinphoneCoreFactory
    public native void setLogCollectionPath(String str);

    private static boolean loadOptionalLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            Log.w("LinphoneCoreFactoryImpl", "Unable to load optional library " + str + ": " + th.getMessage());
            return false;
        }
    }

    static {
        System.loadLibrary("gnustl_shared");
        loadOptionalLibrary("ffmpeg-linphone");
        System.loadLibrary("bctoolbox");
        System.loadLibrary("ortp");
        System.loadLibrary("mediastreamer_base");
        System.loadLibrary("mediastreamer_voip");
        System.loadLibrary("linphone");
        Version.dumpCapabilities();
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneAuthInfo createAuthInfo(String str, String str2, String str3, String str4) {
        return new LinphoneAuthInfoImpl(str, str2, str3, str4);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneAddress createLinphoneAddress(String str, String str2, String str3) {
        return new LinphoneAddressImpl(str, str2, str3);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneAddress createLinphoneAddress(String str) {
        return new LinphoneAddressImpl(str);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LpConfig createLpConfig(String str) {
        return LpConfigImpl.fromFile(str);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LpConfig createLpConfigFromString(String str) {
        return LpConfigImpl.fromBuffer(str);
    }

    private boolean loadingDownloadedOpenH264(Context context) {
        if (!new File(context.getApplicationInfo().nativeLibraryDir + "/libmsopenh264.so").exists()) {
            org.linphone.mediastream.Log.i("LinphoneCoreFactoryImpl", " libmsopenh264 not found, we disable the download of Openh264");
            return false;
        }
        OpenH264DownloadHelper openH264DownloadHelper = new OpenH264DownloadHelper(context);
        if (openH264DownloadHelper.isCodecFound()) {
            org.linphone.mediastream.Log.i("LinphoneCoreFactoryImpl", " Loading OpenH264 downloaded plugin:" + openH264DownloadHelper.getFullPathLib());
            System.load(openH264DownloadHelper.getFullPathLib());
            return true;
        }
        org.linphone.mediastream.Log.i("LinphoneCoreFactoryImpl", " Cannot load OpenH264 downloaded plugin");
        return true;
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneCore createLinphoneCore(LinphoneCoreListener linphoneCoreListener, String str, String str2, Object obj, Object obj2) {
        try {
            this.fcontext = (Context) obj2;
            boolean z = false;
            if (obj2 != null) {
                z = loadingDownloadedOpenH264(this.fcontext);
            }
            MediastreamerAndroidContext.setContext(obj2);
            LinphoneCoreImpl linphoneCoreImpl = new LinphoneCoreImpl(linphoneCoreListener, str == null ? null : new File(str), str2 == null ? null : new File(str2), obj, obj2);
            linphoneCoreImpl.enableDownloadOpenH264(z);
            return linphoneCoreImpl;
        } catch (IOException e) {
            throw new LinphoneCoreException("Cannot create LinphoneCore", e);
        }
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneCore createLinphoneCore(LinphoneCoreListener linphoneCoreListener, Object obj) {
        try {
            this.fcontext = (Context) obj;
            boolean z = false;
            if (obj != null) {
                z = loadingDownloadedOpenH264(this.fcontext);
            }
            MediastreamerAndroidContext.setContext(obj);
            LinphoneCoreImpl linphoneCoreImpl = new LinphoneCoreImpl(linphoneCoreListener, obj);
            linphoneCoreImpl.enableDownloadOpenH264(z);
            return linphoneCoreImpl;
        } catch (IOException e) {
            throw new LinphoneCoreException("Cannot create LinphoneCore", e);
        }
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public void setLogHandler(LinphoneLogHandler linphoneLogHandler) {
        _setLogHandler(linphoneLogHandler);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public OpenH264DownloadHelper createOpenH264DownloadHelper() {
        if (this.fcontext != null) {
            return new OpenH264DownloadHelper(this.fcontext);
        }
        new LinphoneCoreException("Cannot create OpenH264DownloadHelper");
        return null;
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    @Deprecated
    public LinphoneFriend createLinphoneFriend(String str) {
        return new LinphoneFriendImpl(str);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    @Deprecated
    public LinphoneFriend createLinphoneFriend() {
        return createLinphoneFriend(null);
    }

    public static boolean isArmv7() {
        return System.getProperty("os.arch").contains("armv7");
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneAuthInfo createAuthInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        return new LinphoneAuthInfoImpl(str, str2, str3, str4, str5, str6);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneContent createLinphoneContent(String str, String str2, byte[] bArr, String str3) {
        return new LinphoneContentImpl(str, str2, bArr, str3);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneContent createLinphoneContent(String str, String str2, String str3) {
        return new LinphoneContentImpl(str, str2, str3 == null ? null : str3.getBytes(), null);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public PresenceActivity createPresenceActivity(PresenceActivityType presenceActivityType, String str) {
        return new PresenceActivityImpl(presenceActivityType, str);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public PresenceService createPresenceService(String str, PresenceBasicStatus presenceBasicStatus, String str2) {
        return new PresenceServiceImpl(str, presenceBasicStatus, str2);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public PresenceModel createPresenceModel() {
        return new PresenceModelImpl();
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public PresenceModel createPresenceModel(PresenceActivityType presenceActivityType, String str) {
        return new PresenceModelImpl(presenceActivityType, str);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public PresenceModel createPresenceModel(PresenceActivityType presenceActivityType, String str, String str2, String str3) {
        return new PresenceModelImpl(presenceActivityType, str, str2, str3);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public TunnelConfig createTunnelConfig() {
        return (TunnelConfig) _createTunnelConfig();
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public LinphoneAccountCreator createAccountCreator(LinphoneCore linphoneCore, String str) {
        return new LinphoneAccountCreatorImpl(linphoneCore, str);
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public DialPlan[] getAllDialPlan() {
        return getAllDialPlanNative();
    }

    @Override // org.linphone.core.LinphoneCoreFactory
    public ErrorInfo createErrorInfo() {
        return new ErrorInfoImpl(createErrorInfoNative(), true);
    }
}
