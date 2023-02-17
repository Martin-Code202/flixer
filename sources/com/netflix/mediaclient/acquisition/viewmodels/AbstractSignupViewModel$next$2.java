package com.netflix.mediaclient.acquisition.viewmodels;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1457Fr;
import o.C2059ph;
import o.EA;
/* access modifiers changed from: package-private */
public final class AbstractSignupViewModel$next$2 extends Lambda implements AbstractC1451Fl<String, String, EA> {
    final /* synthetic */ AbstractC1451Fl $completion;
    final /* synthetic */ C2059ph $serviceManager;
    final /* synthetic */ AbstractSignupViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractSignupViewModel$next$2(AbstractSignupViewModel abstractSignupViewModel, C2059ph phVar, AbstractC1451Fl fl) {
        super(2);
        this.this$0 = abstractSignupViewModel;
        this.$serviceManager = phVar;
        this.$completion = fl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* bridge */ /* synthetic */ EA invoke(String str, String str2) {
        invoke(str, str2);
        return EA.f5503;
    }

    public final void invoke(String str, String str2) {
        C1457Fr.m5025(str, "mode");
        C1457Fr.m5025(str2, "flowId");
        this.this$0.fetch(str2, str, this.$serviceManager, this.$completion);
    }
}
