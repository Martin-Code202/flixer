package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.net.LogMobileType;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.voip.BaseVoipEngine;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipCallConfigData;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IVoip;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import o.nZ;
import org.json.JSONObject;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneAuthInfo;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCallParams;
import org.linphone.core.LinphoneCallStats;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneChatRoom;
import org.linphone.core.LinphoneContent;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListener;
import org.linphone.core.LinphoneEvent;
import org.linphone.core.LinphoneFriend;
import org.linphone.core.LinphoneFriendList;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.PublishState;
import org.linphone.core.SubscriptionState;
/* renamed from: o.od  reason: case insensitive filesystem */
final class C2028od extends BaseVoipEngine implements LinphoneCoreListener, nZ.If {

    /* renamed from: ˉ  reason: contains not printable characters */
    private static Handler f9295 = new Handler(Looper.getMainLooper());

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private static AtomicBoolean f9296 = new AtomicBoolean(false);

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private LinphoneAddress f9297 = null;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private Timer f9298;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final oH f9299;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private AtomicBoolean f9300 = new AtomicBoolean(false);

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private final String f9301;

    /* renamed from: ˌ  reason: contains not printable characters */
    private LinphoneCore f9302 = null;

    /* renamed from: ˍ  reason: contains not printable characters */
    private final String f9303;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private final String f9304;

    C2028od(Context context, C2029oe oeVar, oS oSVar, UserAgentInterface userAgentInterface, AbstractC1221 r7, VoipCallConfigData voipCallConfigData, oH oHVar) {
        super(context, oeVar, oSVar, userAgentInterface, r7, voipCallConfigData);
        this.f9304 = context.getFilesDir().getAbsolutePath() + "/.linphonerc";
        this.f9303 = context.getFilesDir().getAbsolutePath() + "/linphonerc";
        this.f9301 = context.getFilesDir().getAbsolutePath() + "/rootca.pem";
        this.f9299 = oHVar;
        this.f2311 = new BroadcastReceiver() { // from class: o.od.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                if (!intent.hasCategory("com.netflix.mediaclient.intent.category.VOIP")) {
                    C1283.m16853("nf_voip_linphone", "Received intent with uknown category!", intent);
                } else if (BaseVoipEngine.m1423(action)) {
                    C1283.m16854("nf_voip_linphone", "Intent to cancel call received");
                    C2028od.this.mo1538();
                } else {
                    C1283.m16853("nf_voip_linphone", "Uknown VOIP action!", intent);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.voip.BaseVoipEngine
    /* renamed from: ˏ */
    public BroadcastReceiver mo1438() {
        return this.f2311;
    }

    @Override // o.nZ.If
    public void M_() {
        C1283.m16854("nf_voip_linphone", "Routing audio to earpiece, disabling bluetooth audio route");
        if (this.f2308 != null) {
            this.f2308.m9259();
        }
        if (this.f9302 != null) {
            this.f9302.enableSpeaker(false);
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public boolean m9632() {
        if (this.f2308 == null || !this.f2308.m9263()) {
            return false;
        }
        return this.f2308.m9260();
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public boolean m9633() {
        if (this.f2315.get()) {
            return true;
        }
        if (m1441()) {
            return m9620();
        }
        C1283.m16854("nf_voip_linphone", "VOIP service is NOT enabled, no need to start it.");
        return true;
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ʿ */
    public void mo1539() {
        C1283.m16854("nf_voip_linphone", "stop() called");
        m9617();
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ʽॱ */
    public synchronized boolean mo1537() {
        return this.f2315.get() && this.f9302 != null;
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˈ */
    public synchronized boolean mo1540() {
        if (this.f2310.get()) {
            C1283.m16854("nf_voip_linphone", "Request for dial is already in progress!");
            return true;
        }
        this.f2331 = AbstractC1358Cd.m4358();
        C1356Cb.m4336(this.f2324, CustomerServiceLogging.Sdk.direct, String.valueOf(this.f2331), true);
        this.f2326 = Logger.INSTANCE.m142(new C0504(this.f2331, ""));
        Logger.INSTANCE.m142(new C1071());
        this.f2310.set(true);
        m9633();
        if (!this.f2315.get()) {
            C1283.m16854("nf_voip_linphone", "Wait to start dial when callback that VOIP service is started returns!");
            this.f9300.set(true);
            return true;
        }
        m9619();
        return true;
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ʾ */
    public synchronized boolean mo1538() {
        C1283.m16854("nf_voip_linphone", "--- TERMINATE Call");
        if (this.f9302 == null) {
            C1283.m16850("nf_voip_linphone", "Engine is null, unable to terminate call!");
            return false;
        }
        if (this.f2323 == null) {
            C1283.m16850("nf_voip_linphone", "Current call is null, unable to terminate call!");
        } else if (this.f9302.isIncall()) {
            m1447();
            this.f9302.terminateCall(((Cif) this.f2323).m9636());
        }
        return true;
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˋ */
    public void mo1543(boolean z) {
        if (this.f9302 != null) {
            this.f9302.muteMic(z);
            if (z) {
                Logger.INSTANCE.m142(new C1209());
                Logger.INSTANCE.m130("MuteCommand");
                return;
            }
            Logger.INSTANCE.m142(new C0534());
            Logger.INSTANCE.m130("UnmuteCommand");
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˏ */
    public void mo1547(float f) {
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˎ */
    public void mo1545(boolean z) {
        if (this.f9302 != null) {
            if (z || (!z && !m9632())) {
                this.f9302.enableSpeaker(z);
            }
            this.f2322.m9609(z);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("speakerOnEvent", z);
                Logger.INSTANCE.m131(new C0729(jSONObject));
            } catch (Exception e) {
            }
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˉ */
    public boolean mo1541() {
        if (this.f9302 != null) {
            return this.f9302.isMicMuted();
        }
        if (this.f2327 != null) {
            return this.f2327.isMicrophoneMute();
        }
        return false;
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˋˊ */
    public boolean mo1544() {
        if (this.f9302 != null) {
            if (this.f2308 == null || !this.f2308.m9263()) {
                return this.f9302.isSpeakerEnabled();
            }
            return !this.f2308.m9262();
        } else if (this.f2327 != null) {
            return this.f2327.isSpeakerphoneOn();
        } else {
            return false;
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˏ */
    public void mo1546(char c) {
        if (this.f9302 != null) {
            C1283.m16851("nf_voip_linphone", "Sending DTMF code %s", Character.valueOf(c));
            this.f9302.sendDtmf(c);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˊᐝ */
    public void mo1542() {
        if (this.f9302 != null) {
            this.f9302.stopDtmf();
        }
    }

    @Override // com.netflix.mediaclient.service.voip.BaseVoipEngine, com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ʻ */
    public boolean mo1428() {
        return false;
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public synchronized void globalState(LinphoneCore linphoneCore, LinphoneCore.GlobalState globalState, String str) {
        C1283.m16851("nf_voip_linphone", "globalState %s", globalState.toString());
        if (globalState == LinphoneCore.GlobalState.GlobalOn) {
            m9629(linphoneCore);
            this.f2319 = BaseVoipEngine.ServiceState.STARTED;
            for (IVoip.If r6 : this.f2309) {
                r6.mo1552(true);
            }
            if (this.f9300.get()) {
                this.f9300.set(false);
                m9619();
            }
        } else if (globalState == LinphoneCore.GlobalState.GlobalShutdown) {
            this.f2319 = BaseVoipEngine.ServiceState.STOPPING;
        } else if (globalState == LinphoneCore.GlobalState.GlobalOff) {
            this.f2319 = BaseVoipEngine.ServiceState.STOPPED;
        }
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCall.State state, String str) {
        C1283.m16851("nf_voip_linphone", "Call state: %s (%s)", state, str);
        if (state == LinphoneCall.State.OutgoingInit) {
            m9622(linphoneCall);
        } else if (state == LinphoneCall.State.OutgoingRinging && this.f2323 != null) {
            m9616(linphoneCall);
        } else if (state == LinphoneCall.State.Connected) {
            m9628(linphoneCall);
        } else if (state == LinphoneCall.State.StreamsRunning) {
            m9612(linphoneCall);
        } else if (state == LinphoneCall.State.CallEnd) {
            m9631(linphoneCall);
        } else if (state == LinphoneCall.State.CallReleased) {
            m9625();
        } else if (state == LinphoneCall.State.Error) {
            m9613(linphoneCall, str);
        }
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void authInfoRequested(LinphoneCore linphoneCore, String str, String str2, String str3) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void authenticationRequested(LinphoneCore linphoneCore, LinphoneAuthInfo linphoneAuthInfo, LinphoneCore.AuthMethod authMethod) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callStatsUpdated(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCallStats linphoneCallStats) {
        if (linphoneCall != null && linphoneCall.getAudioStats() != null) {
            if (this.f2307 == null) {
                this.f2307 = AbstractC2033oi.m9652().mo9250("linphone").mo9238(((Cif) this.f2323).m9638()).mo9236(((Cif) this.f2323).m9639()).mo9248(linphoneCall.getAudioStats().getDownloadBandwidth()).mo9240(linphoneCall.getAudioStats().getUploadBandwidth()).mo9249(linphoneCall.getAudioStats().getNumberPacketsSent()).mo9245(linphoneCall.getAudioStats().getNumberPacketsReceived()).mo9243(linphoneCall.getAudioStats().getLatePacketsCumulativeNumber()).mo9233(linphoneCall.getAudioStats().getCumulativePacketsLost()).mo9237(linphoneCall.getAudioStats().getNumberBytesSent()).mo9241(linphoneCall.getAudioStats().getNumberBytesReceived()).mo9242(linphoneCall.getAudioStats().getReceiverLossRate()).mo9235(linphoneCall.getAudioStats().getSenderLossRate()).mo9234(linphoneCall.getAudioStats().getSenderInterarrivalJitter()).mo9232(linphoneCall.getAudioStats().getSenderInterarrivalJitter()).mo9253(linphoneCall.getAudioStats().getSenderInterarrivalJitter()).mo9231(linphoneCall.getAudioStats().getReceiverInterarrivalJitter()).mo9252(linphoneCall.getAudioStats().getReceiverInterarrivalJitter()).mo9244(linphoneCall.getAudioStats().getReceiverInterarrivalJitter()).mo9239(linphoneCall.getAudioStats().getRoundTripDelay()).mo9246(linphoneCall.getAudioStats().getRoundTripDelay()).mo9247(linphoneCall.getAudioStats().getRoundTripDelay()).mo9251();
            } else {
                this.f2307 = this.f2307.m9655(linphoneCall.getAudioStats().getDownloadBandwidth(), linphoneCall.getAudioStats().getUploadBandwidth(), linphoneCall.getAudioStats().getNumberBytesSent(), linphoneCall.getAudioStats().getNumberBytesReceived(), linphoneCall.getAudioStats().getNumberPacketsSent(), linphoneCall.getAudioStats().getNumberPacketsReceived(), linphoneCall.getAudioStats().getLatePacketsCumulativeNumber(), linphoneCall.getAudioStats().getCumulativePacketsLost(), linphoneCall.getAudioStats().getSenderLossRate(), linphoneCall.getAudioStats().getReceiverLossRate(), linphoneCall.getAudioStats().getSenderInterarrivalJitter() * 1000.0f, linphoneCall.getAudioStats().getReceiverInterarrivalJitter() * 1000.0f, linphoneCall.getAudioStats().getRoundTripDelay());
            }
            C1283.m16854("nf_voip_linphone", "================== CALL STATISTICS ========================");
            C1283.m16851("nf_voip_linphone", "        CODEC:                  %s/%s", this.f2307.mo9215(), Integer.valueOf(this.f2307.mo9219()));
            C1283.m16851("nf_voip_linphone", "        Download bandwidth:     %.2f kbits/sec", Float.valueOf(this.f2307.mo9220()));
            C1283.m16851("nf_voip_linphone", "        Upload bandwidth:       %.2f kbits/sec", Float.valueOf(this.f2307.mo9217()));
            C1283.m16851("nf_voip_linphone", "        Sender loss rate:       %.2f", Float.valueOf(this.f2307.mo9211()));
            C1283.m16851("nf_voip_linphone", "        Receiver loss rate:     %.2f", Float.valueOf(this.f2307.mo9224()));
            C1283.m16851("nf_voip_linphone", "        Packets/Bytes sent:     %d packets / %d bytes", Long.valueOf(this.f2307.mo9227()), Long.valueOf(this.f2307.mo9229()));
            C1283.m16851("nf_voip_linphone", "        Packets/Bytes received: %d packets / %d bytes", Long.valueOf(this.f2307.mo9213()), Long.valueOf(this.f2307.mo9209()));
            C1283.m16851("nf_voip_linphone", "        Lost cumlative packets: %d", Long.valueOf(this.f2307.mo9218()));
            C1283.m16851("nf_voip_linphone", "        Late cumlative packets: %d", Long.valueOf(this.f2307.mo9222()));
            C1283.m16851("nf_voip_linphone", "        Remote RX Jitter :      %.2f ms average, MIN: %.2f ms, MAX: %.2f ms", Float.valueOf(this.f2307.mo9216()), Float.valueOf(this.f2307.mo9221()), Float.valueOf(this.f2307.mo9228()));
            C1283.m16851("nf_voip_linphone", "        Local TX  Jitter :      %.2f ms average, MIN: %.2f ms, MAX: %.2f ms", Float.valueOf(this.f2307.mo9230()), Float.valueOf(this.f2307.mo9226()), Float.valueOf(this.f2307.mo9210()));
            C1283.m16851("nf_voip_linphone", "        Jitter buffer size:     %.2f ms", Float.valueOf(linphoneCall.getAudioStats().getJitterBufferSize()));
            C1283.m16851("nf_voip_linphone", "        Roundtrip delay:        %.2f ms average, MIN: %.2f ms, MAX: %.2f ms", Float.valueOf(this.f2307.mo9225()), Float.valueOf(this.f2307.mo9214()), Float.valueOf(this.f2307.mo9212()));
            C1283.m16854("nf_voip_linphone", "===========================================================");
        }
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void newSubscriptionRequest(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyPresenceReceived(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void dtmfReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, int i) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneAddress linphoneAddress, byte[] bArr) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void transferState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCall.State state) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void infoReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneInfoMessage linphoneInfoMessage) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void subscriptionStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, SubscriptionState subscriptionState) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void publishStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, PublishState publishState) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void show(LinphoneCore linphoneCore) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void displayStatus(LinphoneCore linphoneCore, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void displayMessage(LinphoneCore linphoneCore, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void displayWarning(LinphoneCore linphoneCore, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void fileTransferProgressIndication(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, int i) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void fileTransferRecv(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, byte[] bArr, int i) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public int fileTransferSend(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, ByteBuffer byteBuffer, int i) {
        return 0;
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void registrationState(LinphoneCore linphoneCore, LinphoneProxyConfig linphoneProxyConfig, LinphoneCore.RegistrationState registrationState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void configuringStatus(LinphoneCore linphoneCore, LinphoneCore.RemoteProvisioningState remoteProvisioningState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void messageReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void messageReceivedUnableToDecrypted(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callEncryptionChanged(LinphoneCore linphoneCore, LinphoneCall linphoneCall, boolean z, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyReceived(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, String str, LinphoneContent linphoneContent) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void isComposingReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void ecCalibrationStatus(LinphoneCore linphoneCore, LinphoneCore.EcCalibratorStatus ecCalibratorStatus, int i, Object obj) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void uploadProgressIndication(LinphoneCore linphoneCore, int i, int i2) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void uploadStateChanged(LinphoneCore linphoneCore, LinphoneCore.LogCollectionUploadState logCollectionUploadState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void friendListCreated(LinphoneCore linphoneCore, LinphoneFriendList linphoneFriendList) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void friendListRemoved(LinphoneCore linphoneCore, LinphoneFriendList linphoneFriendList) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void networkReachableChanged(LinphoneCore linphoneCore, boolean z) {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9621(int i, String str) {
        File file = new File(str);
        if (!file.exists()) {
            m9626(i, file.getName());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9626(int i, String str) {
        try {
            FileOutputStream openFileOutput = this.f2324.openFileOutput(str, 0);
            InputStream openRawResource = this.f2324.getResources().openRawResource(i);
            byte[] bArr = new byte[8048];
            while (true) {
                int read = openRawResource.read(bArr);
                if (read != -1) {
                    openFileOutput.write(bArr, 0, read);
                } else {
                    openFileOutput.flush();
                    openFileOutput.close();
                    openRawResource.close();
                    return;
                }
            }
        } catch (IOException e) {
            C1283.m16844("nf_voip_linphone", "Cannot copy config from package with id %d to file %s, message:%s", Integer.valueOf(i), str, e.getMessage());
        }
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private synchronized boolean m9620() {
        if (this.f9302 == null || this.f2319 != BaseVoipEngine.ServiceState.STARTED) {
            if (this.f2308 == null) {
                this.f2308 = new nZ(this.f2324, this);
            }
            try {
                m9621(R.raw.linphonerc_default, this.f9304);
                m9626(R.raw.linphonerc_factory, new File(this.f9303).getName());
                m9626(R.raw.voip, new File(this.f9301).getName());
                this.f9302 = LinphoneCoreFactory.instance().createLinphoneCore(this, this.f9304, this.f9303, null, this.f2324);
                final If r6 = new If(this.f9302, this.f2319);
                AnonymousClass2 r7 = new TimerTask() { // from class: o.od.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (C2028od.this.f9302 != null) {
                            C2028od.f9295.post(r6);
                        }
                    }
                };
                this.f9298 = new Timer("LinphoneVoipEngine scheduler");
                this.f9298.schedule(r7, 0, 100);
                this.f2319 = BaseVoipEngine.ServiceState.STARTING;
                return true;
            } catch (LinphoneCoreException e) {
                C1283.m16844("nf_voip_linphone", "Could not create LinphoneCore instance, %s", e.getMessage());
                return false;
            }
        } else {
            C1283.m16854("nf_voip_linphone", "Linphone engine already started");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.od$If */
    public static final class If implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final WeakReference<BaseVoipEngine.ServiceState> f9309;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final WeakReference<LinphoneCore> f9310;

        protected If(LinphoneCore linphoneCore, BaseVoipEngine.ServiceState serviceState) {
            this.f9310 = new WeakReference<>(linphoneCore);
            this.f9309 = new WeakReference<>(serviceState);
        }

        @Override // java.lang.Runnable
        public void run() {
            LinphoneCore linphoneCore = this.f9310.get();
            BaseVoipEngine.ServiceState serviceState = this.f9309.get();
            if (linphoneCore != null && serviceState != null && serviceState == BaseVoipEngine.ServiceState.STARTED && !C2028od.f9296.get()) {
                linphoneCore.iterate();
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m9623(List<String> list, String str) {
        for (String str2 : list) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        o.C1283.m16844("nf_voip_linphone", "Could not create LinphoneCore instance, %s", r5.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0132, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0133, code lost:
        o.C1283.m16844("nf_voip_linphone", "Cannot get version name, %s", r5.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0132 A[Catch:{ LinphoneCoreException -> 0x011f, NameNotFoundException -> 0x0132 }, ExcHandler: NameNotFoundException (r5v0 'e' android.content.pm.PackageManager$NameNotFoundException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:2:0x0005] */
    /* renamed from: ˏ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m9629(org.linphone.core.LinphoneCore r12) {
        /*
        // Method dump skipped, instructions count: 329
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C2028od.m9629(org.linphone.core.LinphoneCore):void");
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private void m9619() {
        if (!this.f2310.get()) {
            C1283.m16854("nf_voip_linphone", "No dial request, no need to start engine");
        } else if (!this.f2315.get()) {
            C1283.m16854("nf_voip_linphone", "VOIP is not ready");
        } else {
            m9624();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋˋ  reason: contains not printable characters */
    private synchronized void m9617() {
        f9296.set(true);
        if (this.f9302 == null || !this.f2315.get()) {
            C1283.m16865("nf_voip_linphone", "  --> Engine already stopped!");
        } else {
            this.f2315.set(false);
            C1283.m16854("nf_voip_linphone", "--- STOPPING VOIP engine");
            try {
                if (this.f2308 != null) {
                    this.f2308.m9258();
                }
                this.f9298.cancel();
                this.f9302.destroy();
            } catch (RuntimeException e) {
                C1283.m16844("nf_voip_linphone", "stopEngine exception %s", e.getMessage());
            } finally {
                this.f9302 = null;
                this.f2308 = null;
            }
        }
        C1283.m16854("nf_voip_linphone", "--- STOP COMPLETE, voip engine is now ready for new call");
        if (this.f2309 != null) {
            for (IVoip.If r6 : this.f2309) {
                r6.mo1552(true);
            }
        }
        f9296.set(false);
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m9618() {
        C1283.m16854("nf_voip_linphone", "--- Calling CALL CLEANUP");
        m1440();
        this.f2322.m9608();
        if (this.f2308 != null) {
            this.f2308.m9259();
        }
        if (((TelephonyManager) this.f2324.getSystemService("phone")).getCallState() == 0) {
            if (this.f2327 != null) {
                this.f2327.setMode(0);
            }
            if (this.f9302 != null) {
                this.f9302.enableSpeaker(false);
            }
            this.f2322.m9609(false);
            C1283.m16854("nf_voip_linphone", "All call terminated, AudioManager: back to MODE_NORMAL and routing back to earpiece");
        }
        if (this.f2328 != null) {
            this.f2328.mo3630(this.f2320, f9295);
        }
        this.f2317 = 0;
        this.f2310.set(false);
        this.f2323 = null;
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private synchronized void m9624() {
        m1427();
        if (this.f9302 == null) {
            C1283.m16850("nf_voip_linphone", "engine is null!");
        } else if (this.f9297 == null) {
            C1283.m16850("nf_voip_linphone", "invite address is null!");
        } else if (!this.f2310.get()) {
            C1283.m16854("nf_voip_linphone", "No dial request, no need to dial");
        } else if (this.f2323 != null) {
            this.f2310.set(false);
            C1283.m16850("nf_voip_linphone", "Call is already in progress! Terminate it first!");
        } else {
            try {
                LinphoneCallParams createCallParams = this.f9302.createCallParams(null);
                createCallParams.setVideoEnabled(false);
                if (ConnectivityUtils.m2956(this.f2324) == LogMobileType._2G) {
                    createCallParams.enableLowBandwidth(true);
                }
                if (mo1428()) {
                    createCallParams.setRecordFile(m9630());
                }
                LinphoneCall inviteAddressWithParams = this.f9302.inviteAddressWithParams(this.f9297, createCallParams);
                if (inviteAddressWithParams == null) {
                    C1283.m16844("nf_voip_linphone", "Could not place call to %s", m1445());
                    return;
                }
                inviteAddressWithParams.enableEchoCancellation(true);
                this.f2323 = new Cif(this.f2330.getCallAttributes().getCallId(), inviteAddressWithParams);
                this.f2322.m9610();
                LocalBroadcastManager.getInstance(this.f2324).sendBroadcast(new Intent("com.netflix.mediaclient.ui.cs.ACTION_CALL_STARTED"));
                this.f2328.mo3631(this.f2320, f9295);
            } catch (LinphoneCoreException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9622(LinphoneCall linphoneCall) {
        C1283.m16854("nf_voip_linphone", "Outbound call invite outgoing");
        m1439();
        m1442();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m9616(LinphoneCall linphoneCall) {
        C1283.m16851("nf_voip_linphone", "Outbound call ringing on line %s", linphoneCall.getCallLog().getCallId());
        if (this.f9302 == null) {
            C1283.m16850("nf_voip_linphone", "Engine is null and we received call ringing! Should not happen!");
        } else if (this.f2323 == null) {
            C1283.m16855("nf_voip_linphone", "Call was NOT in progress and we received call ringing on line %s", linphoneCall.getCallLog().getCallId());
        } else {
            for (IVoip.If r6 : this.f2309) {
                r6.mo1550(this.f2323);
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0033: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v0 java.lang.String) */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9628(LinphoneCall linphoneCall) {
        ((Cif) this.f2323).m9640(linphoneCall.getCurrentParamsCopy());
        if (m9632()) {
            C1283.m16854("nf_voip_linphone", "Audio is routed through Bluetooth Sco");
        }
        Object[] objArr = new Object[1];
        objArr[0] = (linphoneCall == null || linphoneCall.getCallLog() == null) ? "" : linphoneCall.getCallLog().getCallId();
        C1283.m16851("nf_voip_linphone", "Call connected on line %s", objArr);
        if (this.f9302 == null) {
            C1283.m16850("nf_voip_linphone", "SDK is null and we received call connected! Should not happen!");
        } else if (this.f2323 == null) {
            C1283.m16855("nf_voip_linphone", "Call was NOT in progress and we received connected on line %s", linphoneCall.getCallLog().getCallId());
        } else {
            for (IVoip.If r7 : this.f2309) {
                r7.mo1549(this.f2323);
            }
        }
        m1435();
        this.f2317 = System.currentTimeMillis();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9612(LinphoneCall linphoneCall) {
        if (linphoneCall != null) {
            if (mo1428()) {
                linphoneCall.startRecording();
            }
            if (this.f2323 != null && linphoneCall.getCurrentParamsCopy() != null && linphoneCall.getCurrentParamsCopy().getUsedAudioCodec() != null) {
                ((Cif) this.f2323).m9634(linphoneCall.getCurrentParamsCopy().getUsedAudioCodec().getMime(), linphoneCall.getCurrentParamsCopy().getUsedAudioCodec().getRate());
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9613(LinphoneCall linphoneCall, String str) {
        C1283.m16851("nf_voip_linphone", "Call failure for line %s with message %s", linphoneCall.getCallLog().getCallId(), str);
        m9618();
        this.f9299.mo5362(C1061.m16114().mo14162().mo1762(this.f2324, this.f2313));
        m1443();
        for (IVoip.If r6 : this.f2309) {
            r6.mo1551((IVoip.Cif) null);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9631(LinphoneCall linphoneCall) {
        C1283.m16851("nf_voip_linphone", "Outbound call disconnected on line %s", linphoneCall.getCallLog().getCallId());
        if (mo1428()) {
            linphoneCall.stopRecording();
        }
        if (this.f2323 != null && !((Cif) this.f2323).m9635()) {
            ((Cif) this.f2323).m9637();
            if (this.f2307 == null) {
                this.f2307 = AbstractC2033oi.m9652().mo9250("linphone").mo9238(((Cif) this.f2323).m9638()).mo9236(((Cif) this.f2323).m9639()).mo9248((float) ((int) linphoneCall.getAudioStats().getDownloadBandwidth())).mo9240((float) ((int) linphoneCall.getAudioStats().getUploadBandwidth())).mo9249(linphoneCall.getAudioStats().getNumberPacketsSent()).mo9245(linphoneCall.getAudioStats().getNumberPacketsReceived()).mo9237(linphoneCall.getAudioStats().getNumberBytesSent()).mo9241(linphoneCall.getAudioStats().getNumberBytesReceived()).mo9243(linphoneCall.getAudioStats().getLatePacketsCumulativeNumber()).mo9233(linphoneCall.getAudioStats().getCumulativePacketsLost()).mo9242(linphoneCall.getAudioStats().getReceiverLossRate()).mo9235(linphoneCall.getAudioStats().getSenderLossRate()).mo9234(linphoneCall.getAudioStats().getSenderInterarrivalJitter()).mo9232(linphoneCall.getAudioStats().getSenderInterarrivalJitter()).mo9253(linphoneCall.getAudioStats().getSenderInterarrivalJitter()).mo9231(linphoneCall.getAudioStats().getReceiverInterarrivalJitter()).mo9252(linphoneCall.getAudioStats().getReceiverInterarrivalJitter()).mo9244(linphoneCall.getAudioStats().getReceiverInterarrivalJitter()).mo9239(linphoneCall.getAudioStats().getRoundTripDelay()).mo9246(linphoneCall.getAudioStats().getRoundTripDelay()).mo9247(linphoneCall.getAudioStats().getRoundTripDelay()).mo9251();
            }
            m1444();
        }
        m9618();
        if (this.f9302 != null) {
            for (IVoip.If r6 : this.f2309) {
                r6.mo1553(this.f2323);
                r6.mo1552(false);
            }
        } else {
            C1283.m16850("nf_voip_linphone", "Engine is null and we received call disconnect! Should not happen!");
        }
        C1356Cb.m4342(CustomerServiceLogging.TerminationReason.canceledByNetflix, IClientLogging.CompletionReason.canceled, (Error) null);
        Logger.INSTANCE.m130("cs.CallCommand");
        Logger.INSTANCE.m147(C0504.m14486(this.f2326, null));
        LocalBroadcastManager.getInstance(this.f2324).sendBroadcast(new Intent("com.netflix.mediaclient.ui.cs.ACTION_CALL_ENDED"));
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private void m9625() {
        C1283.m16854("nf_voip_linphone", "Call released, stopping engine");
        this.f2312.post(new Runnable() { // from class: o.od.1
            @Override // java.lang.Runnable
            public void run() {
                C2028od.this.m9617();
            }
        });
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private String m9630() {
        String str = "";
        if (!mo1428()) {
            return str;
        }
        try {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/record.wav";
            File file = new File(str);
            file.getParentFile().mkdirs();
            file.createNewFile();
            return str;
        } catch (IOException e) {
            C1283.m16852("nf_voip_linphone", e);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.od$if  reason: invalid class name */
    public static class Cif implements IVoip.Cif {

        /* renamed from: ʽ  reason: contains not printable characters */
        int f9311;

        /* renamed from: ˊ  reason: contains not printable characters */
        boolean f9312 = false;

        /* renamed from: ˋ  reason: contains not printable characters */
        LinphoneCallParams f9313;

        /* renamed from: ˎ  reason: contains not printable characters */
        String f9314;

        /* renamed from: ˏ  reason: contains not printable characters */
        LinphoneCall f9315;

        /* renamed from: ॱ  reason: contains not printable characters */
        String f9316;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private IVoip.CallState f9317 = IVoip.CallState.CONNECTING;

        Cif(String str, LinphoneCall linphoneCall) {
            this.f9314 = str;
            this.f9315 = linphoneCall;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public LinphoneCall m9636() {
            return this.f9315;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m9640(LinphoneCallParams linphoneCallParams) {
            this.f9313 = linphoneCallParams;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m9637() {
            this.f9312 = true;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m9635() {
            return this.f9312;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public String m9638() {
            return this.f9316;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public int m9639() {
            return this.f9311;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m9634(String str, int i) {
            this.f9316 = str;
            this.f9311 = i;
        }
    }
}
