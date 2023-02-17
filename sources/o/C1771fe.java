package o;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: o.fe  reason: case insensitive filesystem */
public class C1771fe extends Cast.Listener implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, Cast.MessageReceivedCallback {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f6747 = C1771fe.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f6748;

    /* renamed from: ʼ  reason: contains not printable characters */
    private AtomicBoolean f6749 = new AtomicBoolean(false);

    /* renamed from: ʽ  reason: contains not printable characters */
    private AtomicBoolean f6750 = new AtomicBoolean(false);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final CastDevice f6751;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC0109 f6752;

    /* renamed from: ˏ  reason: contains not printable characters */
    private GoogleApiClient f6753;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f6754;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C1767fa f6755;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f6756;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AtomicBoolean f6757 = new AtomicBoolean(false);

    /* renamed from: o.fe$ˊ  reason: contains not printable characters */
    public interface AbstractC0109 {
        /* renamed from: ʽ */
        void mo6313();

        /* renamed from: ˊ */
        void mo6315(String str);

        /* renamed from: ˊ */
        void mo6316(String str, Integer num);

        /* renamed from: ˋ */
        void mo6318(String str);

        /* renamed from: ˋ */
        void mo6319(String str, Integer num);

        /* renamed from: ˎ */
        void mo6321(String str);

        /* renamed from: ॱॱ */
        void mo6329();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.fe$iF  reason: case insensitive filesystem */
    public final class C1772iF implements ResultCallback<Cast.ApplicationConnectionResult> {

        /* renamed from: ˋ  reason: contains not printable characters */
        final Cast.MessageReceivedCallback f6759;

        C1772iF(Cast.MessageReceivedCallback messageReceivedCallback) {
            this.f6759 = messageReceivedCallback;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void onResult(Cast.ApplicationConnectionResult applicationConnectionResult) {
            Status status = applicationConnectionResult.getStatus();
            if (status.isSuccess()) {
                C1283.m16854(C1771fe.f6747, "launchApplication(), success");
                C1771fe.this.f6748 = applicationConnectionResult.getSessionId();
                try {
                    Cast.CastApi.setMessageReceivedCallbacks(C1771fe.this.f6753, "urn:x-cast:mdx-netflix-com:service:target:2", this.f6759);
                    C1771fe.this.f6757.set(false);
                    if (!C1771fe.this.f6754) {
                        C1771fe.this.f6754 = true;
                        C1771fe.this.f6752.mo6329();
                    }
                } catch (IllegalStateException e) {
                    m6393("Launch onResult Success - IllegalStateException: " + e.getMessage());
                } catch (IOException e2) {
                    m6393("Launch onResult Success - IOException: " + e2.getMessage());
                } catch (Exception e3) {
                    m6393("Launch onResult Success - Exception: " + e3.getMessage());
                }
            } else if (status.getStatusCode() == 2002) {
                C1283.m16854(C1771fe.f6747, "launchApplication(), cancelled & ignored");
            } else if (status.getStatusCode() == 15) {
                C1283.m16854(C1771fe.f6747, "launchApplication(), timeout, wait - JUST A WORKAROUND");
                m6394(String.format("Launch onResult failed - Timeout, Message: %s", status.getStatusMessage()), Integer.valueOf(status.getStatusCode()));
            } else {
                C1283.m16854(C1771fe.f6747, "launchApplication(), failure, result: " + status.getStatusCode());
                m6394(String.format("Launch onResult failed - Status: %s, Message: %s", Integer.valueOf(status.getStatusCode()), status.getStatusMessage()), Integer.valueOf(status.getStatusCode()));
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m6393(String str) {
            m6394(str, null);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m6394(String str, Integer num) {
            C1771fe.this.f6754 = false;
            C1771fe.this.f6752.mo6316(str, num);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.fe$If */
    public final class If implements ResultCallback<Status> {
        private If() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void onResult(Status status) {
            if (status.isSuccess()) {
                C1283.m16854(C1771fe.f6747, "SendMessage(), success");
                C1771fe.this.f6752.mo6313();
            } else if (status.getStatus().getStatusCode() == 15) {
                C1283.m16854(C1771fe.f6747, "SendMessage(), has timed out");
                C1771fe.this.f6752.mo6321("StatusCodes: TIMEOUT");
            } else {
                C1771fe.this.f6752.mo6321("getStatusCode: " + status.getStatus().getStatusCode());
            }
        }
    }

    C1771fe(Context context, String str, CastDevice castDevice, AbstractC0109 r8, boolean z, C1767fa faVar) {
        this.f6756 = str;
        this.f6751 = castDevice;
        this.f6752 = r8;
        this.f6757.set(z);
        this.f6755 = faVar;
        this.f6753 = new GoogleApiClient.Builder(context).addApi(Cast.API, Cast.CastOptions.builder(castDevice, this).build()).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        this.f6753.connect();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6391(String str) {
        if (!this.f6750.get()) {
            C1283.m16854(f6747, "SendMessage(), disconnected, message can't be delivered");
        } else if (!this.f6749.get()) {
            C1283.m16854(f6747, "SendMessage(), message delivered to cast");
            Cast.CastApi.sendMessage(this.f6753, "urn:x-cast:mdx-netflix-com:service:target:2", str).setResultCallback(new If(), 5000, TimeUnit.MILLISECONDS);
        } else {
            C1283.m16854(f6747, "SendMessage(), connection suspended, message can't be delivered");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6390() {
        try {
            Cast.CastApi.removeMessageReceivedCallbacks(this.f6753, "urn:x-cast:mdx-netflix-com:service:target:2");
            if (this.f6753 != null && this.f6753.isConnected()) {
                if (this.f6748 != null) {
                    Cast.CastApi.stopApplication(this.f6753, this.f6748);
                }
                this.f6753.disconnect();
                this.f6755.m6373().m701(MdxTargetType.Cast, this.f6751.getDeviceId(), this.f6751.getFriendlyName());
                this.f6748 = null;
            }
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        C1283.m16854(f6747, "GoogleApiClient connect(), failure" + connectionResult);
        this.f6750.set(false);
        this.f6749.set(false);
        this.f6752.mo6319(String.format("onConnectionFailed - ErrorCode: %s, Message: %s", Integer.valueOf(connectionResult.getErrorCode()), connectionResult.getErrorMessage()), Integer.valueOf(connectionResult.getErrorCode()));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0058: APUT  (r2v2 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v2 java.lang.String) */
    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        C1283.m16854(f6747, "GoogleApiClient connect(), success arg:" + bundle);
        this.f6750.set(true);
        this.f6749.set(false);
        try {
            if (this.f6757.get()) {
                C1283.m16854(f6747, "forced, GoogleApiClient launchApp()");
                m6387();
                return;
            }
            C1283.m16854(f6747, "GoogleApiClient joinApp()");
            m6389();
        } catch (IllegalStateException e) {
            AbstractC0109 r0 = this.f6752;
            Object[] objArr = new Object[2];
            objArr[0] = this.f6757.get() ? "launch" : "join";
            objArr[1] = e.getMessage();
            r0.mo6319(String.format("onConnected %s - IllegalStateException: %s", objArr), null);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6387() {
        Cast.CastApi.launchApplication(this.f6753, this.f6756).setResultCallback(new C1772iF(this));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6389() {
        Cast.CastApi.joinApplication(this.f6753, this.f6756).setResultCallback(new C1772iF(this));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        C1283.m16854(f6747, "GoogleApiClient connect(), suspended" + i);
        this.f6749.set(true);
        this.f6752.mo6319(String.format("onConnectionSuspended - Cause: %s", Integer.valueOf(i)), Integer.valueOf(i));
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public void onApplicationDisconnected(int i) {
        C1283.m16854(f6747, "Cast.Listener disconnected with statusCode" + i);
        this.f6752.mo6315("onApplicationDisconnected: " + i);
        m6390();
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public void onApplicationStatusChanged() {
        C1283.m16854(f6747, "Cast.Listener onApplicationStatusChanged");
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public void onVolumeChanged() {
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        C1283.m16854(f6747, "onMessageReceived :" + str + ": " + str2);
        this.f6752.mo6318(str2);
    }
}
