package o;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.ui.lolomo.GenreSelectorDialog_Ab9031$loadData$1;
import com.netflix.mediaclient.ui.lolomo.GenreSelectorDialog_Ab9031$loadData$2;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.SubscribersKt;
import kotlin.TypeCastException;
import o.C0567;
public final class tM extends Dialog implements View.OnClickListener {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0616 f10396;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2218ur f10397;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Activity f10398;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Disposable f10399;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tM(Activity activity, AbstractC2218ur urVar) {
        super(activity, R.style.Fullscreen_Dialog);
        C1457Fr.m5025(activity, "activity");
        C1457Fr.m5025(urVar, Device.MODEL);
        this.f10398 = activity;
        this.f10397 = urVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final /* synthetic */ C0616 m10975(tM tMVar) {
        C0616 r0 = tMVar.f10396;
        if (r0 == null) {
            C1457Fr.m5017("loadingAndErrorWrapper");
        }
        return r0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final AbstractC2218ur m10978() {
        return this.f10397;
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.genre_selection_list_ab9031);
        ((ImageButton) findViewById(R.Cif.close_button)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1457Fr.m5025(view, "view");
        if (view.getId() == R.id.close_button) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.Cif.genre_select_recyclerview);
            C1457Fr.m5016((Object) recyclerView, "genre_select_recyclerview");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.lolomo.ab9031.ListOfGenresAdapter");
            }
            ((C2225uy) adapter).m11786();
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        C2225uy uyVar = new C2225uy(this.f10397);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.Cif.genre_select_recyclerview);
        C1457Fr.m5016((Object) recyclerView, "genre_select_recyclerview");
        recyclerView.setAdapter(uyVar);
        this.f10399 = uyVar.m11784().take(1).subscribe(new Cif(this));
        this.f10396 = new C0616((FrameLayout) findViewById(R.Cif.genre_selection_list), new iF(this));
        m10977(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tM$if  reason: invalid class name */
    public static final class Cif<T> implements Consumer<Integer> {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ tM f10401;

        Cif(tM tMVar) {
            this.f10401 = tMVar;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void accept(Integer num) {
            C1457Fr.m5025(num, "it");
            this.f10401.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class iF implements C0567.Cif {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ tM f10400;

        iF(tM tMVar) {
            this.f10400 = tMVar;
        }

        @Override // o.C0567.Cif
        public final void N_() {
            this.f10400.m10977(true);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Disposable disposable = this.f10399;
        if (disposable != null) {
            disposable.dispose();
        }
        super.dismiss();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m10977(boolean z) {
        C0616 r0 = this.f10396;
        if (r0 == null) {
            C1457Fr.m5017("loadingAndErrorWrapper");
        }
        r0.mo14570(true);
        SubscribersKt.subscribeBy$default(this.f10397.mo11737(z), new GenreSelectorDialog_Ab9031$loadData$2(this), null, new GenreSelectorDialog_Ab9031$loadData$1(this), 2, null);
    }
}
