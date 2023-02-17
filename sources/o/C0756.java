package o;

import android.text.TextUtils;
import com.netflix.mediaclient.android.app.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.TypeCastException;
import o.AB;
/* renamed from: o.ᐸ  reason: contains not printable characters */
public final class C0756 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f14369;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14370;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f14371;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0756(C0876<?> r2, int i, int i2, String str, AbstractC1203 r6) {
        super(r2, r6);
        C1457Fr.m5025(r2, "netflixModelProxy");
        C1457Fr.m5025(str, "listId");
        C1457Fr.m5025(r6, "cb");
        this.f14371 = i;
        this.f14370 = i2;
        this.f14369 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        C1457Fr.m5025(list, "pqls");
        C0876 r1 = this.f13290;
        C1457Fr.m5016((Object) r1, "modelProxy");
        C0506.m14501(list, r1.m15575(), this.f14369, this.f14371, this.f14370, true);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        C0859 r3;
        C1457Fr.m5025(r6, "callbackOnMain");
        C1457Fr.m5025(r7, "result");
        if (TextUtils.isEmpty(this.f14369)) {
            r3 = C0859.m15528("lolomo", "thirtySecondPreview", "thirtySecondPreviewData", C0859.m15532(this.f14371, this.f14370), "previewSummary");
        } else {
            r3 = C0859.m15528("lists", this.f14369, "thirtySecondPreviewData", C0859.m15532(this.f14371, this.f14370), "previewSummary");
        }
        List<pD> r4 = this.f13290.mo15259(r3);
        if (r4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.netflix.model.leafs.PreviewsFeedItemSummary>");
        }
        r6.mo8530(r4, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        C1457Fr.m5025(r2, "callbackOnMain");
        C1457Fr.m5025(status, "res");
        r2.mo8530(Collections.emptyList(), status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList();
        if (C0891.f14767.m15611()) {
            new AB.If("previewsEnabled", String.valueOf(true));
        }
        return arrayList;
    }
}
