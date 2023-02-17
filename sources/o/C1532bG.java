package o;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import com.netflix.mediaclient.service.logging.error.ErrorLoggingDataCollector$breadcrumbs$1;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.bG  reason: case insensitive filesystem */
public final class C1532bG {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static WeakReference<Activity> f6126 = null;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C1532bG f6127 = new C1532bG();

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final List<String> f6128;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final int f6129 = 50;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Map<String, String> f6130 = new LinkedHashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f6131 = null;

    static {
        List<String> synchronizedList = Collections.synchronizedList(new ErrorLoggingDataCollector$breadcrumbs$1());
        if (synchronizedList == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
        f6128 = synchronizedList;
        AbstractApplicationC1258.m16691().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: o.bG.5
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                C1457Fr.m5025(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                C1457Fr.m5025(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                C1457Fr.m5025(activity, "activity");
                C1532bG bGVar = C1532bG.f6127;
                C1532bG.f6126 = new WeakReference(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                C1457Fr.m5025(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                C1457Fr.m5025(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                C1457Fr.m5025(activity, "activity");
                C1457Fr.m5025(bundle, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                C1457Fr.m5025(activity, "activity");
            }
        });
    }

    private C1532bG() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m5748(String str) {
        f6131 = str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final List<String> m5747() {
        return f6128;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final void m5744(Map<String, String> map) {
        f6130.clear();
        if (map != null) {
            f6130.putAll(map);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Activity m5741() {
        WeakReference<Activity> weakReference = f6126;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final JSONObject m5742(Throwable th, boolean z) {
        StringBuilder append;
        C1457Fr.m5025(th, "throwable");
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : f6130.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            String str = f6131;
            if (str != null) {
                jSONObject.put("abTest", str);
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                C1457Fr.m5016((Object) stackTraceElement, "element");
                String className = stackTraceElement.getClassName();
                C1457Fr.m5016((Object) className, "element.className");
                if (Ge.m5067(className, "com.netflix", false, 2, null) && (!C1457Fr.m5018((Object) stackTraceElement.getClassName(), (Object) C1529bE.class.getName())) && (!C1457Fr.m5018((Object) stackTraceElement.getClassName(), (Object) C0407.class.getName()))) {
                    jSONObject.put("appClass", "" + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber());
                    break;
                }
                i++;
            }
            Activity r6 = f6127.m5741();
            if (r6 != null) {
                if (r6.isFinishing()) {
                    jSONObject.put("finishing", r6.isFinishing());
                }
                if (r6.isDestroyed()) {
                    jSONObject.put("destroyed", r6.isDestroyed());
                }
                jSONObject.put("activity", r6.getClass().getName());
            }
            StringBuilder sb = null;
            for (T t : f6128) {
                if (!Ge.m5067(t, "Explicit AB allocations", false, 2, null)) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    if (!(sb == null || (append = sb.append((String) t)) == null)) {
                        append.append(";");
                    }
                }
            }
            if (sb != null) {
                jSONObject.put("breadcrumbs", sb);
            }
            if (z) {
                f6127.m5743(jSONObject, r6);
            }
        } catch (JSONException e) {
            C1283.m16864("ErrorLoggingDataCollector", e, "Unable to write additionalData JSON", new Object[0]);
        }
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m5743(JSONObject jSONObject, Activity activity) {
        if (activity != null) {
            Resources resources = activity.getResources();
            C1457Fr.m5016((Object) resources, "activity.resources");
            jSONObject.put("orientation", resources.getConfiguration().orientation);
            Resources resources2 = activity.getResources();
            C1457Fr.m5016((Object) resources2, "activity.resources");
            jSONObject.put("screenHeightDp", resources2.getConfiguration().screenHeightDp);
            Resources resources3 = activity.getResources();
            C1457Fr.m5016((Object) resources3, "activity.resources");
            jSONObject.put("screenWidthDp", resources3.getConfiguration().screenWidthDp);
            Resources resources4 = activity.getResources();
            C1457Fr.m5016((Object) resources4, "activity.resources");
            jSONObject.put("densityDpi", resources4.getConfiguration().densityDpi);
        }
    }
}
