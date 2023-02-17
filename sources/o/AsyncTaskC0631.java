package o;

import android.content.res.Resources;
import o.C0433;
import org.json.JSONObject;
/* renamed from: o.ۥ  reason: contains not printable characters */
public final class AsyncTaskC0631 extends AbstractAsyncTaskC1018<JSONObject> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC0437 f13943;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Resources f13944;

    public AsyncTaskC0631(Resources resources, AbstractC0437 r2) {
        this.f13944 = resources;
        this.f13943 = r2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public C0433 doInBackground(JSONObject... jSONObjectArr) {
        return C0433.iF.m14278(this.f13944, jSONObjectArr[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void onPostExecute(C0433 r2) {
        this.f13943.mo18(r2);
    }
}
