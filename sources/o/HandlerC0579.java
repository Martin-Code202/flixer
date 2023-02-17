package o;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.firebase.jobdispatcher.GooglePlayReceiver;
import o.C0742;
@TargetApi(21)
/* renamed from: o.د  reason: contains not printable characters */
public class HandlerC0579 extends Handler {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final GooglePlayReceiver f13846;

    public HandlerC0579(Looper looper, GooglePlayReceiver googlePlayReceiver) {
        super(looper);
        this.f13846 = googlePlayReceiver;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            try {
                ((AppOpsManager) this.f13846.getApplicationContext().getSystemService("appops")).checkPackage(message.sendingUid, "com.google.android.gms");
                switch (message.what) {
                    case 1:
                        m14697(message);
                        return;
                    case 2:
                        m14698(message);
                        return;
                    case 3:
                    default:
                        Log.e("FJD.GooglePlayReceiver", "Unrecognized message received: " + message);
                        return;
                    case 4:
                        return;
                }
            } catch (SecurityException e) {
                Log.e("FJD.GooglePlayReceiver", "Message was not sent from GCM.");
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14697(Message message) {
        Bundle data = message.getData();
        Messenger messenger = message.replyTo;
        String string = data.getString("tag");
        if (messenger != null && string != null) {
            this.f13846.m90().m16765(this.f13846.m89(data, new C0569(messenger, string)));
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            Log.d("FJD.GooglePlayReceiver", "Invalid start execution message.");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14698(Message message) {
        C0742.C0743 r2 = GooglePlayReceiver.m85().m15012(message.getData());
        if (r2 != null) {
            this.f13846.m90().m16766(r2.m15155());
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            Log.d("FJD.GooglePlayReceiver", "Invalid stop execution message.");
        }
    }
}
