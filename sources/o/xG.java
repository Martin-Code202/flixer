package o;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.ViewGroup;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
public final class xG {

    /* renamed from: ˊ  reason: contains not printable characters */
    private PublishSubject<xJ> f11971;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ArrayList<PublishSubject<xJ>> f11972 = new ArrayList<>();

    public xG(ViewGroup viewGroup, PublishSubject<xH> publishSubject, Observable<EA> observable, xE xEVar, NetflixVideoView netflixVideoView) {
        C1457Fr.m5025(viewGroup, "mainContainer");
        C1457Fr.m5025(publishSubject, "playerStateEventObservable");
        C1457Fr.m5025(observable, "destroyObservable");
        C1457Fr.m5025(xEVar, "playerRepository");
        C1457Fr.m5025(netflixVideoView, "videoView");
        C2356yu yuVar = new C2356yu(viewGroup);
        new xP(yuVar, publishSubject, observable);
        this.f11972.add(yuVar.mo13082());
        yM yMVar = new yM(viewGroup);
        new C2339yd(yMVar, publishSubject, observable);
        this.f11972.add(yMVar.mo13082());
        C2357yv yvVar = new C2357yv(viewGroup);
        new xO(yvVar, publishSubject, observable);
        this.f11972.add(yvVar.mo13082());
        yL yLVar = new yL(viewGroup);
        new xZ(yLVar, publishSubject, observable);
        this.f11972.add(yLVar.mo13082());
        yG yGVar = new yG(viewGroup, netflixVideoView);
        new xU(yGVar, publishSubject, observable);
        this.f11972.add(yGVar.mo13082());
        C2355yt ytVar = new C2355yt(viewGroup);
        new xL(ytVar, publishSubject, observable);
        this.f11972.add(ytVar.mo13082());
        C2359yx yxVar = new C2359yx(viewGroup);
        new xM(yxVar, publishSubject, observable);
        this.f11972.add(yxVar.mo13082());
        C2337yb ybVar = new C2337yb((NetflixActivity) C0345.m13893(viewGroup.getContext(), NetflixActivity.class));
        C2358yw ywVar = new C2358yw(viewGroup);
        new xN(ywVar, publishSubject, ybVar, observable);
        this.f11972.add(ywVar.mo13082());
        yB yBVar = new yB(viewGroup);
        new xQ(yBVar, publishSubject, observable);
        this.f11972.add(yBVar.mo13082());
        C2360yy yyVar = new C2360yy(viewGroup);
        new xS(yyVar, publishSubject, observable);
        this.f11972.add(yyVar.mo13082());
        yA yAVar = new yA(viewGroup);
        new xR(yAVar, publishSubject, xEVar, observable);
        this.f11972.add(yAVar.mo13082());
        yD yDVar = new yD(viewGroup);
        new xW(yDVar, publishSubject, observable);
        this.f11972.add(yDVar.mo13082());
        yH yHVar = new yH(viewGroup);
        new xY(yHVar, publishSubject, observable);
        this.f11972.add(yHVar.mo13082());
        yF yFVar = new yF(viewGroup);
        new xX(yFVar, publishSubject, observable);
        this.f11972.add(yFVar.mo13082());
        C2361yz yzVar = new C2361yz(viewGroup);
        new xV(yzVar, publishSubject, observable);
        this.f11972.add(yzVar.mo13082());
        yC yCVar = new yC(viewGroup);
        new xT(yCVar, publishSubject, observable);
        this.f11972.add(yCVar.mo13082());
        this.f11971 = yCVar.mo13082();
        if (viewGroup instanceof ConstraintLayout) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone((ConstraintLayout) viewGroup);
            constraintSet.connect(yGVar.m13129(), 3, yBVar.ai_(), 4);
            constraintSet.connect(yGVar.m13129(), 4, yDVar.ai_(), 3);
            constraintSet.connect(yLVar.ai_(), 3, yBVar.ai_(), 4);
            constraintSet.connect(yDVar.ai_(), 4, yAVar.ai_(), 3);
            constraintSet.connect(yHVar.ai_(), 4, yDVar.ai_(), 3);
            constraintSet.connect(yFVar.ai_(), 4, yDVar.ai_(), 3);
            constraintSet.connect(yFVar.ai_(), 7, 0, 7);
            constraintSet.connect(yzVar.ai_(), 4, yDVar.ai_(), 3);
            constraintSet.connect(yzVar.ai_(), 7, 0, 7);
            constraintSet.applyTo((ConstraintLayout) viewGroup);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final ArrayList<PublishSubject<xJ>> m12756() {
        return this.f11972;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final PublishSubject<xJ> m12755() {
        return this.f11971;
    }
}
