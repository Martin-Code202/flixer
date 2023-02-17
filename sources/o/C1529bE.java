package o;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.LocalBroadcastManager;
import com.crittercism.app.Crittercism;
import com.crittercism.app.CrittercismConfig;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import com.netflix.mediaclient.service.webclient.model.leafs.BreadcrumbLoggingSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.ErrorLoggingSpecification;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
@TargetApi(4)
/* renamed from: o.bE  reason: case insensitive filesystem */
public final class C1529bE implements AbstractC1236 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final boolean f6118 = (!C1317As.m3757());

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final If f6119 = new If();

    /* renamed from: o.bE$iF  reason: case insensitive filesystem */
    public interface AbstractC1530iF {
        /* renamed from: ˏ  reason: contains not printable characters */
        void mo5740(boolean z, Thread thread, Throwable th, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
    }

    public C1529bE(AbstractC1530iF iFVar) {
        m5721(false, iFVar);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m5721(final boolean z, final AbstractC1530iF iFVar) {
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: o.bE.5
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                iFVar.mo5740(z, thread, th, defaultUncaughtExceptionHandler);
            }
        });
    }

    @Override // o.AbstractC1236
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5727(String str) {
        mo5731(new Throwable(str));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5726(String str, Throwable th) {
        mo5731(new Throwable(str, th));
    }

    @Override // o.AbstractC1236
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo5731(Throwable th) {
        m5719(m5720(th), true);
        C0510 r2 = C0590.m14708(RootCause.handledException.name(), C1532bG.m5742(th, false), th);
        if (r2 != null) {
            Logger.INSTANCE.m131(new C0927(r2));
        } else {
            C1283.m16850("nf_log_crit", "Unable to create an CLv2 error object, this should NOT happen. Unable to report handled excpetion to CLv2");
        }
        if (f6119.m5735() && f6119.m5738()) {
            Crittercism.logHandledException(th);
        }
    }

    @Override // o.AbstractC1236
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo5725(String str) {
        mo5727(str);
    }

    @Override // o.AbstractC1236
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo5729(String str, Throwable th) {
        m5726(str, th);
    }

    @Override // o.AbstractC1236
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo5730(Throwable th) {
        mo5731(th);
    }

    @Override // o.AbstractC1236
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5728(String str) {
        if (!C1349Bv.m4113(str)) {
            C1532bG.f6127.m5747().add(str);
            if (f6119.m5735() && f6119.m5737()) {
                Crittercism.leaveBreadcrumb(str);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m5722(String str) {
        if (str != null && f6119.m5735()) {
            Crittercism.setUsername(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m5723(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            jSONObject.put(str, str2);
        } else {
            jSONObject.put(str, "N/A");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m5719(List<DeepErrorElement> list, boolean z) {
        if (list != null) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_EXCEPTION_CL");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            if (!z) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, new Error(RootCause.unhandledException, list).toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log_crit", "Failed to get JSON string from UIError for CL Exception", e);
                    return;
                }
            } else {
                intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, new Error(RootCause.handledException, list).toJSONObject().toString());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static List<DeepErrorElement> m5720(Throwable th) {
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

    /* renamed from: o.bE$If */
    public static final class If {

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean f6123;

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean f6124 = false;

        /* renamed from: ॱ  reason: contains not printable characters */
        private boolean f6125 = false;

        /* renamed from: ˏ  reason: contains not printable characters */
        public synchronized void m5739(Context context, long j, ErrorLoggingSpecification errorLoggingSpecification, BreadcrumbLoggingSpecification breadcrumbLoggingSpecification) {
            m5733(context, errorLoggingSpecification);
            m5734(context, breadcrumbLoggingSpecification);
            m5732(context, j);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean m5738() {
            return this.f6125;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m5737() {
            return this.f6124;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean m5735() {
            return this.f6123;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m5733(Context context, ErrorLoggingSpecification errorLoggingSpecification) {
            if (errorLoggingSpecification == null) {
                C1283.m16850("nf_log_crit", "Error logging specification is missing. It should NOT happen!");
            } else if (errorLoggingSpecification.isDisabled()) {
                C1283.m16854("nf_log_crit", "Error logging is explicitly disabled");
                this.f6125 = false;
            } else {
                C1283.m16854("nf_log_crit", "Error logging is NOT explicitly disabled, apply disable chance percentage");
                this.f6125 = AD.m3293(context, errorLoggingSpecification.getDisableChancePercentage());
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private synchronized void m5732(Context context, long j) {
            if (this.f6123) {
                C1283.m16865("nf_log_crit", "Crittercism is already initialized");
                return;
            }
            C1283.m16854("nf_log_crit", "Crittercism was not initialized before...");
            if (m5738()) {
                C1283.m16854("nf_log_crit", "This device is approved for sampling, initialize Crittercism");
                CrittercismConfig crittercismConfig = new CrittercismConfig();
                crittercismConfig.setVersionCodeToBeIncludedInVersionString(true);
                crittercismConfig.setServiceMonitoringEnabled(false);
                crittercismConfig.setLogcatReportingEnabled(false);
                crittercismConfig.setCustomVersionName("6.1.0");
                try {
                    Crittercism.initialize(context, SecurityRepository.getCrittercismAppId(), crittercismConfig);
                    Crittercism.setLoggingLevel(Crittercism.LoggingLevel.Silent);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("android", Build.VERSION.SDK_INT);
                    C1529bE.m5723(jSONObject, "oem", Build.MANUFACTURER);
                    C1529bE.m5723(jSONObject, Device.MODEL, Build.MODEL);
                    C1529bE.m5723(jSONObject, "critSessionId", j + "");
                    Crittercism.setMetadata(jSONObject);
                    this.f6123 = true;
                    C1283.m16854("nf_log_crit", "Init Crittercism done.");
                } catch (Throwable th) {
                    C1283.m16847("nf_log_crit", "Unable to init crittercism", th);
                }
                return;
            }
            C1283.m16854("nf_log_crit", "This device is NOT approved for sampling");
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m5734(Context context, BreadcrumbLoggingSpecification breadcrumbLoggingSpecification) {
            if (breadcrumbLoggingSpecification == null) {
                C1283.m16850("nf_log_crit", "Breadcrumb logging specification is missing. It should NOT happen!");
            } else if (breadcrumbLoggingSpecification.isDisabled()) {
                C1283.m16854("nf_log_crit", "Breadcrumb logging is explicitly disabled");
                this.f6124 = false;
            } else {
                C1283.m16854("nf_log_crit", "Breadcrumb logging is NOT explicitly disabled, use error logging chance to keep all in sync since we are using only one service, ignore its own disable chance percentage");
                this.f6124 = this.f6125;
            }
        }
    }
}
