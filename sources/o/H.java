package o;

import android.content.Intent;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import org.json.JSONException;
final class H implements oC {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final K f5731;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1359Ce f5732;

    H(K k) {
        this.f5731 = k;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5156(Intent intent) {
        UIError uIError = null;
        try {
            uIError = Error.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16856("ExceptionLoggingClImpl", e, "Failed JSON", new Object[0]);
        }
        m5160(uIError);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m5159(Intent intent) {
        if (!"com.netflix.mediaclient.intent.action.LOG_EXCEPTION_CL".equals(intent.getAction())) {
            return false;
        }
        m5156(intent);
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5160(Error error) {
        ExceptionClEvent exceptionClEvent = new ExceptionClEvent(error);
        m5157(exceptionClEvent, this.f5732);
        this.f5731.mo4783(exceptionClEvent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5157(Event event, C1359Ce ce) {
        if (event != null) {
            event.setDataContext(ce);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5158(C1359Ce ce) {
        this.f5732 = ce;
    }
}
