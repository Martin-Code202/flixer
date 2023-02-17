package com.netflix.mediaclient.acquisition;

import android.webkit.ValueCallback;
import com.netflix.mediaclient.acquisition.OnBoardingActivity;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1376Cs;
import o.EA;
/* access modifiers changed from: package-private */
public final class OnBoardingActivity$mHandleError$1 implements Runnable {
    final /* synthetic */ OnBoardingActivity this$0;

    OnBoardingActivity$mHandleError$1(OnBoardingActivity onBoardingActivity) {
        this.this$0 = onBoardingActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1283.m16854(OnBoardingActivity.Companion.access$getTAG$p(OnBoardingActivity.Companion), "Handling error during Onramp");
        C1376Cs.m4555(this.this$0.getApplicationContext(), new ValueCallback<Boolean>(this) { // from class: com.netflix.mediaclient.acquisition.OnBoardingActivity$mHandleError$1.1
            final /* synthetic */ OnBoardingActivity$mHandleError$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onReceiveValue(Boolean bool) {
                new AbstractC1450Fk<Boolean, EA>(this) { // from class: com.netflix.mediaclient.acquisition.OnBoardingActivity.mHandleError.1.1.1
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // o.AbstractC1450Fk
                    public /* synthetic */ EA invoke(Boolean bool2) {
                        invoke(bool2.booleanValue());
                        return EA.f5503;
                    }

                    public final void invoke(boolean z) {
                        PerformanceProfiler.INSTANCE.m665(Sessions.ONRAMP_TTR, PerformanceProfiler.m652());
                        this.this$0.this$0.this$0.finish();
                    }
                };
            }
        });
    }
}
