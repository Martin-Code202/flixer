package com.netflix.mediaclient.servicemgr;

import android.content.Context;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.logging.apm.model.Display;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.HttpResponse;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import o.C1487aS;
import o.C1491aV;
import o.C1626cr;
import org.json.JSONObject;
public interface ApplicationPerformanceMetricsLogging {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String[] f2379 = {"com.netflix.mediaclient.intent.action.LOG_APM_DIALOG_DISPLAYED", "com.netflix.mediaclient.intent.action.LOG_APM_DIALOG_REMOVED", "com.netflix.mediaclient.intent.action.LOG_APM_DATA_REQUEST_STARTED", "com.netflix.mediaclient.intent.action.LOG_APM_DATA_REQUEST_ENDED", "com.netflix.mediaclient.intent.action.LOG_APM_UI_MODAL_VIEW_CHANGED", "com.netflix.mediaclient.intent.action.LOG_APM_UI_MODAL_VIEW_IMPRESSION", "com.netflix.mediaclient.intent.action.LOG_APM_PREAPP_ADD_WIDGET", "com.netflix.mediaclient.intent.action.LOG_APM_PREAPP_DELETE_WIDGET", "com.netflix.mediaclient.intent.action.LOG_APM_DATA_SHARED_CONTEXT_SESSION_STARTED", "com.netflix.mediaclient.intent.action.LOG_APM_DATA_SHARED_CONTEXT_SESSION_ENDED", "com.netflix.mediaclient.intent.action.LOG_APM_LOCAL_SETTINGS_BW", "com.netflix.mediaclient.intent.action.LOG_APM_AB_TEST_LOADED_EVENT", "com.netflix.mediaclient.intent.action.LOG_APM_AB_TEST_RECEIVED_EVENT", "com.netflix.mediaclient.intent.action.LOG_APM_AB_CONFIG_DATA_RECEIVED_EVENT", "com.netflix.mediaclient.intent.action.LOG_APM_AB_CONFIG_DATA_LOADED_EVENT"};

    public enum EndReason {
        timeout,
        appClose,
        logout
    }

    public enum Trigger {
        appStart,
        inputEvent,
        logout,
        resumeFromBackground
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo1483(C1626cr crVar);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo1484(boolean z, IClientLogging.ModalView modalView, long j);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1485(long j, boolean z, UIError uIError);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1486(Trigger trigger);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1487(UiStartupTrigger uiStartupTrigger, IClientLogging.ModalView modalView, Long l, Display display, C1487aS aSVar, C1491aV aVVar);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1488(String str);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1489(String str, IClientLogging.CompletionReason completionReason, HttpResponse httpResponse, Error error, String str2);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1490(String str, JSONObject jSONObject);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo1491(boolean z, IClientLogging.ModalView modalView, String str);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo1492(long j);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo1493(Context context);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo1494(C1626cr crVar);

    /* renamed from: ॱ  reason: contains not printable characters */
    String mo1495(String str, AssetType assetType, String str2);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo1496(Event event);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo1497(boolean z, IClientLogging.ModalView modalView);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo1498(boolean z, boolean z2);

    /* renamed from: ॱ  reason: contains not printable characters */
    boolean mo1499(String str);

    public enum UiStartupTrigger {
        remoteButton(1),
        dedicatedOnScreenIcon(2),
        itemInApplicationList(3),
        searchResult(4),
        searchContinuation(5),
        webBrowser(6),
        liveFolder(7),
        externalApp(8),
        bannerAd(9),
        externalControlProtocol(10),
        metaDiscovery(11),
        dial(12),
        voiceControl(13),
        visualGesture(14),
        touchGesture(15),
        virtualRemote(16),
        epgGrid(17),
        channelNumber(18),
        powerOnFromNetflixButton(19),
        titleRecommend(21),
        suspendAtPowerOn(22),
        suspendAfterAppRestart(22),
        appSwitch(23),
        testing(99);
        

        /* renamed from: ˈ  reason: contains not printable characters */
        private int f2414;

        /* renamed from: ˋ  reason: contains not printable characters */
        public int m1500() {
            return this.f2414;
        }

        private UiStartupTrigger(int i) {
            this.f2414 = i;
        }
    }
}
