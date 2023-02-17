package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import org.json.JSONObject;
public final class X {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f5853 = "com.netflix.mediaclient.intent.action.LOG_RATING_CL";

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f5854 = "RatingsLogging";

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String[] f5855 = {f5853};

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1359Ce f5856;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final K f5857;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m5323(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(f5853);
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("EXTRA_RATED", z);
        intent.putExtra("EXTRA_WITH_DRAG", z2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public X(K k) {
        this.f5857 = k;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5325(C1359Ce ce) {
        this.f5856 = ce;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m5326(Intent intent) {
        String action = intent.getAction();
        if (!f5853.equals(action)) {
            C1283.m16851(f5854, "We do not support action %s", action);
            return false;
        } else if (!intent.hasExtra("EXTRA_RATED") || !intent.hasExtra("EXTRA_WITH_DRAG")) {
            C1283.m16851(f5854, "Missing extras on %s", action);
            return false;
        } else {
            m5324(intent.getBooleanExtra("EXTRA_RATED", false), intent.getBooleanExtra("EXTRA_WITH_DRAG", false));
            return true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5324(boolean z, boolean z2) {
        Cif ifVar = new Cif(z, z2);
        ifVar.setDataContext(this.f5856);
        this.f5857.mo4783(ifVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.X$if  reason: invalid class name */
    public static class Cif extends Event {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final boolean f5858;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final boolean f5859;

        private Cif(boolean z, boolean z2) {
            this.name = "UserRatingButtonOverlay.dismissed";
            this.category = UIError.UI_ACTION;
            this.f5858 = z;
            this.f5859 = z2;
        }

        /* access modifiers changed from: protected */
        @Override // com.netflix.mediaclient.service.logging.client.model.Event
        public JSONObject getData() {
            JSONObject data = super.getData();
            if (data == null) {
                data = new JSONObject();
            }
            data.put("rated", this.f5858);
            data.put("drag", this.f5859);
            return data;
        }
    }
}
