package com.netflix.mediaclient.android.widget;

import android.os.SystemClock;
import com.netflix.cl.Logger;
import io.reactivex.SingleEmitter;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0433;
import o.C0676;
import o.C0729;
import o.C0757;
import o.C1457Fr;
import o.EA;
import org.json.JSONObject;
public final class NetflixLottieHelper$loadCompositionFromAssetFile$1$1 extends Lambda implements AbstractC1450Fk<JSONObject, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ long f949;

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ JSONObject f950;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ C0757.C0758 f951;

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ SingleEmitter f952;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetflixLottieHelper$loadCompositionFromAssetFile$1$1(C0757.C0758 r2, JSONObject jSONObject, SingleEmitter singleEmitter, long j) {
        super(1);
        this.f951 = r2;
        this.f950 = jSONObject;
        this.f952 = singleEmitter;
        this.f949 = j;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(JSONObject jSONObject) {
        m446(jSONObject);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m446(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f950.put("isCompleted", false);
            Logger.INSTANCE.m131(new C0729(this.f950));
            this.f952.onError(new Throwable("could not parse json file"));
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C0433 r5 = C0433.iF.m14278(this.f951.f14375.getResources(), jSONObject);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        C0757 r0 = C0757.f14372;
        C1457Fr.m5016((Object) r5, "composition");
        ArrayList arrayList = r0.m15177(r5) ? C0757.f14372.m15179(jSONObject) : new ArrayList();
        long elapsedRealtime3 = SystemClock.elapsedRealtime();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("jsonFileRead", elapsedRealtime - this.f949);
        jSONObject2.put("lottieCompositionCreation", elapsedRealtime2 - elapsedRealtime);
        jSONObject2.put("tapListCreation", elapsedRealtime3 - elapsedRealtime2);
        this.f950.put("elapsedTime", jSONObject2);
        this.f950.put("isCompleted", true);
        Logger.INSTANCE.m131(new C0729(this.f950));
        this.f952.onSuccess(new C0676(r5, arrayList, jSONObject));
    }
}
