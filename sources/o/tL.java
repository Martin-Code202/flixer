package o;

import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import o.tP;
class tL extends tR {
    tL(Context context, pC pCVar, C2059ph phVar, UiLocation uiLocation, AbstractC0954 r5, int i) {
        super(context, pCVar, phVar, uiLocation, r5, i);
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ͺ */
    public int mo10896() {
        return tP.C0214.m10991(m11286().size(), m15489());
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ˏ */
    public int mo10894(Context context, int i) {
        return tP.C0214.m10992(context, i);
    }

    /* access modifiers changed from: protected */
    @Override // o.tR, o.AbstractC2195ty
    /* renamed from: ˊ */
    public void mo10892(Context context, C2059ph phVar, int i, int i2, oU oUVar, Intent intent) {
        phVar.m9764().mo9478(i, i2, (pC) null, BrowseExperience.m1780(), oUVar);
    }
}
