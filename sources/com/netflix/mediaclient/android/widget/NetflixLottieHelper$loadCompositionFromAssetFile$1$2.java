package com.netflix.mediaclient.android.widget;

import com.netflix.cl.Logger;
import io.reactivex.SingleEmitter;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0729;
import o.C1457Fr;
import o.EA;
import org.json.JSONObject;
public final class NetflixLottieHelper$loadCompositionFromAssetFile$1$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ JSONObject f953;

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ SingleEmitter f954;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetflixLottieHelper$loadCompositionFromAssetFile$1$2(JSONObject jSONObject, SingleEmitter singleEmitter) {
        super(1);
        this.f953 = jSONObject;
        this.f954 = singleEmitter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m447(th);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m447(Throwable th) {
        C1457Fr.m5025(th, "e");
        this.f953.put("isCompleted", false);
        Logger.INSTANCE.m131(new C0729(this.f953));
        this.f954.onError(th);
    }
}
