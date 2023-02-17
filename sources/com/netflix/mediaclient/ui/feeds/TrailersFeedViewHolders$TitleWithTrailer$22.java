package com.netflix.mediaclient.ui.feeds;

import android.view.View;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0345;
import o.C1457Fr;
import o.C2059ph;
import o.EA;
import o.oP;
import o.rW;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$22 extends Lambda implements AbstractC1450Fk<EA, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3113;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$22(rZ.Cif ifVar) {
        super(1);
        this.f3113 = ifVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(EA ea) {
        m1900(ea);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m1900(EA ea) {
        rW rWVar = this.f3113.f9750;
        if (rWVar != null) {
            this.f3113.f9761.m1838();
            View view = this.f3113.itemView;
            C1457Fr.m5016((Object) view, "itemView");
            NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(view.getContext(), NetflixActivity.class);
            if (netflixActivity != null) {
                this.f3113.m10281().setEnabled(false);
                if (rWVar.mo4194()) {
                    C2059ph serviceManager = netflixActivity.getServiceManager();
                    C1457Fr.m5016((Object) serviceManager, "it.serviceManager");
                    serviceManager.m9764().mo9483(rWVar.mo4199(), rWVar.mo4201(), (String) null, new If("TrailersFeedViewHolders", rWVar, this));
                    return;
                }
                C2059ph serviceManager2 = netflixActivity.getServiceManager();
                C1457Fr.m5016((Object) serviceManager2, "it.serviceManager");
                serviceManager2.m9764().mo9469(rWVar.mo4199(), rWVar.mo4201(), this.f3113.f9754.m1925().getTrackId(), (String) null, new C0035("TrailersFeedViewHolders", rWVar, this));
            }
        }
    }

    public static final class If extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ rW f3114;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ TrailersFeedViewHolders$TitleWithTrailer$22 f3115;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        If(String str, rW rWVar, TrailersFeedViewHolders$TitleWithTrailer$22 trailersFeedViewHolders$TitleWithTrailer$22) {
            super(str);
            this.f3114 = rWVar;
            this.f3115 = trailersFeedViewHolders$TitleWithTrailer$22;
        }

        @Override // o.oP, o.oU
        public void onQueueRemove(Status status) {
            super.onQueueRemove(status);
            if (status != null && status.mo298()) {
                this.f3115.f3113.m10277(false);
            }
            this.f3114.mo4197(false);
            this.f3115.f3113.m10281().setEnabled(true);
        }
    }

    /* renamed from: com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$22$ˊ  reason: contains not printable characters */
    public static final class C0035 extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ rW f3116;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ TrailersFeedViewHolders$TitleWithTrailer$22 f3117;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0035(String str, rW rWVar, TrailersFeedViewHolders$TitleWithTrailer$22 trailersFeedViewHolders$TitleWithTrailer$22) {
            super(str);
            this.f3116 = rWVar;
            this.f3117 = trailersFeedViewHolders$TitleWithTrailer$22;
        }

        @Override // o.oP, o.oU
        public void onQueueAdd(Status status) {
            super.onQueueAdd(status);
            if (status != null && status.mo298()) {
                this.f3117.f3113.m10277(true);
            }
            this.f3116.mo4197(true);
            this.f3117.f3113.m10281().setEnabled(true);
        }
    }
}
