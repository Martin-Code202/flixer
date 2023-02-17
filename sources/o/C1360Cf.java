package o;

import android.content.Context;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Cf  reason: case insensitive filesystem */
public final class C1360Cf extends AbstractC1358Cd {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4370(Throwable th) {
        C1283.m16854("nf_log_ex", "Saving uncaughtException...");
        If r4 = new If(th);
        C1283.m16851("nf_log_ex", "%s", r4);
        try {
            C1339Bl.m4039(AbstractApplicationC1258.m16692(), "NF_CrashReport", r4.m4375().toString());
        } catch (JSONException e) {
            C1283.m16847("nf_log_ex", "Failed to save to preferences!", e);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4367(Error error) {
        if (error != null) {
            C1529bE.m5719(error.getDeepError(), false);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4369() {
        If r4 = m4371(AbstractApplicationC1258.m16692());
        if (r4 != null) {
            C1283.m16851("nf_log_ex", "last crash exist, report! %s", r4);
            if (r4.f5156 != null) {
                Logger.INSTANCE.m131(new C0958(r4.f5156));
            } else {
                C1283.m16854("nf_log_ex", "Missing CLv2 of last crash. Can not report!");
            }
            if (r4.f5157 != null) {
                m4367(r4.f5157);
            } else {
                C1283.m16854("nf_log_ex", "Missing CLv1 of last crash. Can not report!");
            }
            C1339Bl.m4041(AbstractApplicationC1258.m16692(), "NF_CrashReport");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static If m4371(Context context) {
        If r4 = null;
        try {
            String r5 = C1339Bl.m4045(context, "NF_CrashReport", (String) null);
            C1283.m16851("nf_log_ex", "Crash report found: %s", r5);
            if (r5 != null) {
                r4 = new If(r5);
                C1283.m16851("nf_log_ex", "%s", r4);
            }
        } catch (Throwable th) {
            C1283.m16856("nf_log_ex", th, "Failed to create crash report object!", new Object[0]);
        }
        C1339Bl.m4041(context, "NF_CrashReport");
        return r4;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public static List<DeepErrorElement> m4368(Throwable th) {
        ArrayList arrayList = new ArrayList();
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        DeepErrorElement.Debug debug = new DeepErrorElement.Debug();
        arrayList.add(deepErrorElement);
        deepErrorElement.setDebug(debug);
        debug.setClassName(th.getClass().getName());
        if (th.getStackTrace() != null) {
            debug.setStackTrace(th);
        }
        if (th.getMessage() != null) {
            debug.setMessage(th.getMessage());
        }
        return arrayList;
    }

    /* renamed from: o.Cf$If */
    public static class If {

        /* renamed from: ˎ  reason: contains not printable characters */
        private C0510 f5156;

        /* renamed from: ˏ  reason: contains not printable characters */
        private Error f5157;

        public If(String str) {
            if (!C1349Bv.m4113(str)) {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("clv1");
                JSONObject jSONObject3 = jSONObject.getJSONObject("clv2");
                if (jSONObject2 != null) {
                    this.f5157 = new Error(jSONObject2);
                }
                this.f5156 = C0510.m14526(jSONObject3);
            }
        }

        public If(Throwable th) {
            this.f5157 = new Error(RootCause.unhandledException, C1360Cf.m4368(th));
            this.f5156 = C0590.m14708(RootCause.unhandledException.name(), C1532bG.m5742(th, true), th);
        }

        public String toString() {
            try {
                return "LastCrashError{" + m4375().toString();
            } catch (Throwable th) {
                C1283.m16856("nf_log_ex", th, "Failed to create JSON!", new Object[0]);
                return null;
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public JSONObject m4375() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clv1", this.f5157.toJSONObject());
            jSONObject.put("clv2", this.f5156.toJSONObject());
            return jSONObject;
        }
    }
}
