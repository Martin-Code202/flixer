package o;

import android.content.Context;
import android.util.AttributeSet;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.feeds.TrailerVideoView$attachPlaybackSession$1;
import com.netflix.mediaclient.ui.feeds.TrailerVideoView$attachPlaybackSession$2;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import o.C2319xo;
import org.json.JSONObject;
public final class rV extends NetflixVideoView {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private static long f9695;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final If f9696 = new If(null);

    /* renamed from: ʼ  reason: contains not printable characters */
    private Cif f9697;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private long f9698;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f9699;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private IPlayer.AbstractC0024 f9700;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f9701;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private IPlayer.AbstractC0025 f9702;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private Disposable f9703;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final PublishSubject<IPlayer.aux> f9704;

    /* renamed from: o.rV$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˊ  reason: contains not printable characters */
        boolean mo10209(long j);
    }

    public rV(Context context) {
        this(context, null, 0, 6, null);
    }

    public rV(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rV(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f9704 = PublishSubject.create();
        super.setOnErrorListener(new IPlayer.AbstractC0024(this) { // from class: o.rV.2

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ rV f9706;

            {
                this.f9706 = r1;
            }

            @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0024
            /* renamed from: ˎ */
            public final void mo1530(IPlayer.aux aux) {
                if (aux.mo997()) {
                    C0403 r0 = C0403.m14185(context, R.string.restart_app_playback_error);
                    C1457Fr.m5016((Object) aux, ExceptionClEvent.CATEGORY_VALUE);
                    String r3 = r0.m14186("errorCode", aux.mo1001()).m14188();
                    C2319xo.Cif ifVar = C2319xo.f12234;
                    C1457Fr.m5016((Object) r3, "msg");
                    C2319xo r4 = ifVar.m12966("", r3);
                    NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(context, NetflixActivity.class);
                    if (netflixActivity != null) {
                        netflixActivity.showDialog(r4);
                        C1276.m16820().mo5727("MobileComingSoon appRestartError " + aux.mo1001());
                    }
                } else if (aux.mo999()) {
                    C1283.m16854("TrailerVideoView", "onPlaybackError retry");
                    this.f9706.f9704.onNext(aux);
                } else {
                    C1283.m16854("TrailerVideoView", "onPlaybackError no retry");
                    IPlayer.AbstractC0024 r02 = this.f9706.f9700;
                    if (r02 != null) {
                        r02.mo1530(aux);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callback", "onPlayerError");
                jSONObject.put("requiresAppRestart", aux.mo997());
                jSONObject.put("canRetry", aux.mo999());
                C1457Fr.m5016((Object) aux, ExceptionClEvent.CATEGORY_VALUE);
                jSONObject.put("errorCode", aux.mo1001());
                Logger.INSTANCE.m131(new C0729(jSONObject));
            }
        });
        super.setPlayerStatusChangeListener(new IPlayer.AbstractC0025(this) { // from class: o.rV.4

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ rV f9707;

            {
                this.f9707 = r1;
            }

            @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0025
            /* renamed from: ˏ */
            public final void mo1531(IPlayer.PlayerState playerState) {
                if (C1457Fr.m5018(playerState, IPlayer.PlayerState.Started)) {
                    this.f9707.f9699 = 0;
                }
                IPlayer.AbstractC0025 r0 = this.f9707.f9702;
                if (r0 != null) {
                    r0.mo1531(playerState);
                }
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rV(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final long m10205() {
            return rV.f9695;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˎ  reason: contains not printable characters */
        private final void m10206(long j) {
            rV.f9695 = j;
        }
    }

    @Override // com.netflix.mediaclient.ui.player.NetflixVideoView
    /* renamed from: ˏ */
    public boolean mo2340(oY oYVar, long j, VideoType videoType, AbstractC2055pd pdVar, oX oXVar, long j2, boolean z) {
        C1283.m16851("TrailerVideoView", "attachPlaybackSession %d", Long.valueOf(j));
        this.f9699 = 0;
        Disposable disposable = this.f9703;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<IPlayer.aux> observeOn = this.f9704.delay(this.f9698, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        C1457Fr.m5016((Object) observeOn, "retryPlaybackErrors\n    …dSchedulers.mainThread())");
        this.f9703 = SubscribersKt.subscribeBy$default(observeOn, TrailerVideoView$attachPlaybackSession$2.f3068, null, new TrailerVideoView$attachPlaybackSession$1(this, j, oYVar, videoType, pdVar, oXVar, j2, z), 2, null);
        return super.mo2340(oYVar, j, videoType, pdVar, oXVar, j2, z);
    }

    @Override // com.netflix.mediaclient.ui.player.NetflixVideoView
    public void b_() {
        C1283.m16854("TrailerVideoView", "reset");
        Disposable disposable = this.f9703;
        if (disposable != null) {
            disposable.dispose();
        }
        super.b_();
    }

    @Override // com.netflix.mediaclient.ui.player.NetflixVideoView
    public void setPlayerStatusChangeListener(IPlayer.AbstractC0025 r1) {
        this.f9702 = r1;
    }

    @Override // com.netflix.mediaclient.ui.player.NetflixVideoView
    public void setOnErrorListener(IPlayer.AbstractC0024 r2) {
        C1457Fr.m5025(r2, "errorListener");
        this.f9700 = r2;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.NetflixVideoView
    /* renamed from: ˎ */
    public boolean mo2339() {
        return m2346() != 0 && f9696.m10205() == m2346();
    }

    @Override // com.netflix.mediaclient.ui.player.NetflixVideoView
    public void setViewInFocus(boolean z) {
        setViewInFocus(m2346(), z);
    }

    public final void setViewInFocus(long j, boolean z) {
        long j2;
        If r0 = f9696;
        if (z) {
            j2 = j;
        } else {
            j2 = 0;
        }
        r0.m10206(j2);
    }

    public final void setRetryPolicy(Cif ifVar, int i, long j) {
        this.f9697 = ifVar;
        this.f9701 = i;
        this.f9698 = j;
    }
}
