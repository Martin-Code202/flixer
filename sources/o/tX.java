package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import com.netflix.mediaclient.R;
public final class tX extends AbstractC0467 {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0217 f10458 = new C0217(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f10459;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C2204ud f10460;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f10461;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tX(Context context, String str, C2204ud udVar) {
        super(udVar);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(str, "listId");
        C1457Fr.m5025(udVar, "previewsLolomoView");
        this.f10461 = context;
        this.f10459 = str;
        this.f10460 = udVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tX(Context context, String str, C2204ud udVar, int i, C1456Fq fq) {
        this(context, str, (i & 4) != 0 ? new C2204ud(context, null, 0, 6, null) : udVar);
    }

    /* renamed from: o.tX$ˊ  reason: contains not printable characters */
    public static final class C0217 {
        private C0217() {
        }

        public /* synthetic */ C0217(C1456Fq fq) {
            this();
        }
    }

    @Override // o.AbstractC0467
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo11047(AbstractC0508 r3) {
        C1457Fr.m5025(r3, "uiModel");
        if (!(r3 instanceof C2202ub)) {
            C1283.m16850("PreviewsLolomoUIView", "UIModel is not PreviewsLolomoUIModel - cannot render PreviewsLolomoUIView");
            return;
        }
        this.f10460.m11697((C2202ub) r3);
        m11045(((C2202ub) r3).m11691());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final int m11046() {
        return R.id.previews_lolomo_view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tX$ˋ  reason: contains not printable characters */
    public static final class View$OnClickListenerC0218 implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ int f10462;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ tX f10463;

        View$OnClickListenerC0218(tX tXVar, int i) {
            this.f10463 = tXVar;
            this.f10462 = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intent intent = new Intent(this.f10463.f10461, yY.class);
            ActivityC2153sl slVar = (ActivityC2153sl) C0345.m13893(this.f10463.f10461, ActivityC2153sl.class);
            if (slVar != null) {
                ActivityOptionsCompat makeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(slVar, this.f10463.f10460.m11698(), "title_treatment");
                yT.f12460.m13281(Integer.valueOf(this.f10462));
                intent.putExtra("list_id", this.f10463.f10459);
                this.f10463.f10461.startActivity(intent, makeSceneTransitionAnimation.toBundle());
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m11045(int i) {
        this.f10460.m11699(new View$OnClickListenerC0218(this, i));
    }
}
