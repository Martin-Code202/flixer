package o;

import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSeekbarBifPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSeekbarBifPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSeekbarBifPresenter$3;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
import java.nio.ByteBuffer;
public final class xY extends C2338yc {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C0292 f12112 = new C0292(null);

    /* renamed from: ˎ  reason: contains not printable characters */
    private oM f12113;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1351Bx f12114 = new C1351Bx();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2345yj f12115;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xY(AbstractC2345yj yjVar, Observable<xH> observable, Observable<EA> observable2) {
        super(yjVar, observable, observable2);
        C1457Fr.m5025(yjVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12115 = yjVar;
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy(takeUntil, new PlayerSeekbarBifPresenter$2(this), new PlayerSeekbarBifPresenter$3(this), new PlayerSeekbarBifPresenter$1(this));
    }

    /* renamed from: o.xY$ˋ  reason: contains not printable characters */
    public static final class C0292 {
        private C0292() {
        }

        public /* synthetic */ C0292(C1456Fq fq) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m12874(int i, int i2, boolean z) {
        C1283.m16854("PlayerSeekbarBifPresenter", "updateInformation, currentProgress is " + i + " xPositionFromProgress is " + i2);
        AbstractC2345yj yjVar = this.f12115;
        String r1 = this.f12114.m4133(i);
        C1457Fr.m5016((Object) r1, "timeLineFormatterHelper.…ingForMs(currentProgress)");
        yjVar.mo13136(r1, i2);
        oM oMVar = this.f12113;
        ByteBuffer r4 = oMVar != null ? oMVar.mo905((long) i) : null;
        if (r4 != null) {
            C1283.m16854("PlayerSeekbarBifPresenter", "reportSkipCommand with trickplayScrubberThumb goingBack is " + z);
            C1300Ac.m3536(new C1080(AppView.trickplayScrubberThumb, null), z, false, (long) i2);
            this.f12115.mo13134(r4, i2);
            if (!this.f12115.mo13132()) {
                this.f12115.mo13137();
                return;
            }
            return;
        }
        C1283.m16854("PlayerSeekbarBifPresenter", "reportSkipCommand with trickplayScrubber goingBack is " + z);
        C1300Ac.m3536(new C1080(AppView.trickplayScrubber, null), z, false, (long) i2);
        this.f12115.mo13133();
    }
}
