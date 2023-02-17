package o;

import android.content.res.Resources;
import java.io.InputStream;
import o.C0433;
/* renamed from: o.ʳ  reason: contains not printable characters */
public final class AsyncTaskC0412 extends AbstractAsyncTaskC1018<InputStream> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Resources f13378;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC0437 f13379;

    public AsyncTaskC0412(Resources resources, AbstractC0437 r2) {
        this.f13378 = resources;
        this.f13379 = r2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public C0433 doInBackground(InputStream... inputStreamArr) {
        return C0433.iF.m14276(this.f13378, inputStreamArr[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void onPostExecute(C0433 r2) {
        this.f13379.mo18(r2);
    }
}
