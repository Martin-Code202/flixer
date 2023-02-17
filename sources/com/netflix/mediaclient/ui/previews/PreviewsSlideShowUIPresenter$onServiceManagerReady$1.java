package com.netflix.mediaclient.ui.previews;

import com.netflix.mediaclient.android.app.Status;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.EA;
import o.yR;
import o.yT;
import o.yX;
public final class PreviewsSlideShowUIPresenter$onServiceManagerReady$1 extends Lambda implements AbstractC1450Fk<Pair<? extends Status, ? extends List<? extends yR>>, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ yX f3821;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewsSlideShowUIPresenter$onServiceManagerReady$1(yX yXVar) {
        super(1);
        this.f3821 = yXVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Pair<? extends Status, ? extends List<? extends yR>> pair) {
        m2759(pair);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2759(Pair<? extends Status, ? extends List<yR>> pair) {
        List list = (List) pair.m3222();
        if (!list.isEmpty()) {
            this.f3821.f12477.m13312().addAll(list);
            this.f3821.f12477.m13311(yT.f12460.m13282());
            Integer r3 = yT.f12460.m13282();
            if (r3 != null) {
                int intValue = r3.intValue();
                this.f3821.m13306(intValue);
                this.f3821.f12475 = intValue;
            }
            this.f3821.m14367().mo11047(this.f3821.f12477);
            yT.f12460.m13281((Integer) null);
        }
    }
}
