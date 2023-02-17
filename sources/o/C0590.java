package o;

import com.netflix.cl.Logger;
import com.netflix.cl.util.NamedLogSessionLookup;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ٳ  reason: contains not printable characters */
public final class C0590 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static long f13859 = ((long) Math.pow(2.0d, (double) f13861));

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f13860 = 53;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f13861 = (f13860 - f13863);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static long f13862 = (((long) Math.pow(2.0d, (double) f13863)) - 1);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f13863 = 28;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static long f13864;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static synchronized long m14711() {
        long j;
        synchronized (C0590.class) {
            long r8 = m14707(C0441.m14299(), 1000) & f13862;
            long floor = (long) Math.floor(Math.random() * ((double) f13859));
            if (r8 <= f13864) {
                r8 = f13864 + 1;
            }
            f13864 = r8;
            j = (f13859 * r8) + floor;
        }
        return j;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0510 m14708(String str, JSONObject jSONObject, Throwable th) {
        if (th == null && str == null) {
            return null;
        }
        if (th.getStackTrace() != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put(DeepErrorElement.Debug.CLASSNAME, th.getClass().getName());
                jSONObject.put(DeepErrorElement.Debug.MESSAGE, th.getMessage());
                jSONObject.put(DeepErrorElement.Debug.STACKTRACE, m14712(th));
            } catch (JSONException e) {
            }
        }
        return new C0510(str, m14713(jSONObject), null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static C0501 m14713(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C0501(jSONObject);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m14712(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long m14707(long j, long j2) {
        long j3 = j / j2;
        if ((j ^ j2) >= 0 || j3 * j2 == j) {
            return j3;
        }
        return j3 - 1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m14710(String str, AbstractC1274 r3) {
        Long r1;
        if (str == null || r3 == null || (r1 = Logger.INSTANCE.m142(r3)) == null) {
            return false;
        }
        NamedLogSessionLookup.INSTANCE.m152(str, r1);
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m14714(String str) {
        if (str != null) {
            Logger.INSTANCE.m140(NamedLogSessionLookup.INSTANCE.m151(str));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m14709(String str) {
        if (str != null) {
            Logger.INSTANCE.m129(NamedLogSessionLookup.INSTANCE.m151(str));
        }
    }
}
