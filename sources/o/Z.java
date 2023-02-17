package o;

import android.content.Intent;
import com.netflix.mediaclient.service.logging.client.model.Event;
import o.AbstractC2062pk;
public class Z implements AbstractC2062pk {

    /* renamed from: ˏ  reason: contains not printable characters */
    private K f5888;

    Z(K k) {
        this.f5888 = k;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5356(AbstractC2062pk.Cif ifVar) {
        if (ifVar instanceof Event) {
            this.f5888.mo4783((Event) ifVar);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m5357(Intent intent) {
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.LOG_PUSH_NOTIFICATION_PRESENTED".equals(action)) {
            C1283.m16854("nf_log_push", "PUSH_NOTIFICATION_PRESENTED");
            m5356((C1579cA) intent.getExtras().getParcelable("event"));
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_PUSH_NOTIFICATION_RECEIVED".equals(action)) {
            C1283.m16854("nf_log_push", "PUSH_NOTIFICATION_RECEIVED");
            m5356((C1580cB) intent.getExtras().getParcelable("event"));
            return true;
        } else if (!"com.netflix.mediaclient.intent.action.LOG_PUSH_NOTIFICATION_RESOLVED".equals(action)) {
            return false;
        } else {
            C1283.m16854("nf_log_push", "PUSH_NOTIFICATION_RESOLVED");
            m5356((C1582cD) intent.getExtras().getParcelable("event"));
            return true;
        }
    }
}
