package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.iid.zzb;
import com.google.firebase.iid.zzq;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import java.util.Iterator;
public class FirebaseMessagingService extends zzb {
    static boolean zzag(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    static void zzq(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    @Override // com.google.firebase.iid.zzb
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        char c = 65535;
        switch (action.hashCode()) {
            case 75300319:
                if (action.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
                    c = 1;
                    break;
                }
                break;
            case 366519424:
                if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                String stringExtra = intent.getStringExtra("message_type");
                if (stringExtra == null) {
                    stringExtra = "gcm";
                }
                char c2 = 65535;
                switch (stringExtra.hashCode()) {
                    case -2062414158:
                        if (stringExtra.equals("deleted_messages")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 102161:
                        if (stringExtra.equals("gcm")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 814694033:
                        if (stringExtra.equals("send_error")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 814800675:
                        if (stringExtra.equals("send_event")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (zzag(intent.getExtras())) {
                            zzd.zzg(this, intent);
                        }
                        Bundle extras = intent.getExtras();
                        if (extras == null) {
                            extras = new Bundle();
                        }
                        extras.remove("android.support.content.wakelockid");
                        if (zza.zzad(extras)) {
                            if (zza.zzeq(this).zzs(extras)) {
                                return;
                            }
                            if (zzag(extras)) {
                                zzd.zzj(this, intent);
                            }
                        }
                        onMessageReceived(new RemoteMessage(extras));
                        return;
                    case 1:
                        onDeletedMessages();
                        return;
                    case 2:
                        onMessageSent(intent.getStringExtra("google.message_id"));
                        return;
                    case 3:
                        String stringExtra2 = intent.getStringExtra("google.message_id");
                        if (stringExtra2 == null) {
                            stringExtra2 = intent.getStringExtra("message_id");
                        }
                        onSendError(stringExtra2, new SendException(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE)));
                        return;
                    default:
                        String valueOf = String.valueOf(stringExtra);
                        Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Received message with unknown type: ".concat(valueOf) : new String("Received message with unknown type: "));
                        return;
                }
            case 1:
                if (zzag(intent.getExtras())) {
                    zzd.zzi(this, intent);
                    return;
                }
                return;
            default:
                String valueOf2 = String.valueOf(intent.getAction());
                Log.d("FirebaseMessaging", valueOf2.length() != 0 ? "Unknown intent action: ".concat(valueOf2) : new String("Unknown intent action: "));
                return;
        }
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.firebase.iid.zzb
    public final Intent zzn(Intent intent) {
        return zzq.zzbys().zzbyt();
    }

    @Override // com.google.firebase.iid.zzb
    public final boolean zzo(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!zzag(intent.getExtras())) {
            return true;
        }
        zzd.zzh(this, intent);
        return true;
    }
}
