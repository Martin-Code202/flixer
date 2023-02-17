package o;

import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
public class tR extends C2215uo<pJ> {
    public tR(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r4, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r4, i);
    }

    tR(Context context, pC pCVar, C2059ph phVar, UiLocation uiLocation, AbstractC0954 r5, int i) {
        super(context, pCVar, phVar, uiLocation, r5, i);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2195ty
    /* renamed from: ˊ */
    public void mo10892(Context context, C2059ph phVar, int i, int i2, oU oUVar, Intent intent) {
        phVar.m9764().mo9478(i, i2, m11288().mo10878(), BrowseExperience.m1780(), oUVar);
    }

    @Override // o.AbstractC0837
    /* renamed from: ॱॱ */
    public boolean mo10904() {
        return true;
    }
}
