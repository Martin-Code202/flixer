package org.linphone.core;

import android.content.Context;
import org.linphone.tools.OpenH264DownloadHelper;
public abstract class LinphoneCoreFactory {
    private static String factoryName = "org.linphone.core.LinphoneCoreFactoryImpl";
    static LinphoneCoreFactory theLinphoneCoreFactory;
    protected Context fcontext;

    public abstract LinphoneAccountCreator createAccountCreator(LinphoneCore linphoneCore, String str);

    public abstract LinphoneAuthInfo createAuthInfo(String str, String str2, String str3, String str4);

    public abstract LinphoneAuthInfo createAuthInfo(String str, String str2, String str3, String str4, String str5, String str6);

    public abstract ErrorInfo createErrorInfo();

    public abstract LinphoneAddress createLinphoneAddress(String str);

    public abstract LinphoneAddress createLinphoneAddress(String str, String str2, String str3);

    public abstract LinphoneContent createLinphoneContent(String str, String str2, String str3);

    public abstract LinphoneContent createLinphoneContent(String str, String str2, byte[] bArr, String str3);

    public abstract LinphoneCore createLinphoneCore(LinphoneCoreListener linphoneCoreListener, Object obj);

    public abstract LinphoneCore createLinphoneCore(LinphoneCoreListener linphoneCoreListener, String str, String str2, Object obj, Object obj2);

    public abstract LinphoneFriend createLinphoneFriend();

    public abstract LinphoneFriend createLinphoneFriend(String str);

    public abstract LpConfig createLpConfig(String str);

    public abstract LpConfig createLpConfigFromString(String str);

    public abstract OpenH264DownloadHelper createOpenH264DownloadHelper();

    public abstract PresenceActivity createPresenceActivity(PresenceActivityType presenceActivityType, String str);

    public abstract PresenceModel createPresenceModel();

    public abstract PresenceModel createPresenceModel(PresenceActivityType presenceActivityType, String str);

    public abstract PresenceModel createPresenceModel(PresenceActivityType presenceActivityType, String str, String str2, String str3);

    public abstract PresenceService createPresenceService(String str, PresenceBasicStatus presenceBasicStatus, String str2);

    public abstract TunnelConfig createTunnelConfig();

    public abstract void enableLogCollection(boolean z);

    public abstract DialPlan[] getAllDialPlan();

    public abstract void setDebugMode(boolean z, String str);

    public abstract void setLogCollectionPath(String str);

    public abstract void setLogHandler(LinphoneLogHandler linphoneLogHandler);

    public static void setFactoryClassName(String str) {
        factoryName = str;
    }

    public static final synchronized LinphoneCoreFactory instance() {
        LinphoneCoreFactory linphoneCoreFactory;
        synchronized (LinphoneCoreFactory.class) {
            try {
                if (theLinphoneCoreFactory == null) {
                    theLinphoneCoreFactory = (LinphoneCoreFactory) Class.forName(factoryName).newInstance();
                }
            } catch (Exception e) {
                System.err.println("Cannot instanciate factory [" + factoryName + "]");
            }
            linphoneCoreFactory = theLinphoneCoreFactory;
        }
        return linphoneCoreFactory;
    }
}
