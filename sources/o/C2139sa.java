package o;

import android.arch.lifecycle.Observer;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewModel;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.sa  reason: case insensitive filesystem */
public final class C2139sa {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C2139sa f10131 = new C2139sa();

    private C2139sa() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.sa$ˊ  reason: contains not printable characters */
    public static final class C0196<T> implements Observer<rW> {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ TrailersFeedViewModel f10132;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ rU f10133;

        C0196(rU rUVar, TrailersFeedViewModel trailersFeedViewModel) {
            this.f10133 = rUVar;
            this.f10132 = trailersFeedViewModel;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void onChanged(rW rWVar) {
            C1283.m16854("TrailersFeedPrepareQueue", "Got focused item : " + rWVar);
            if (rWVar instanceof rW) {
                C2059ph serviceManager = this.f10133.getServiceManager();
                C1457Fr.m5016((Object) serviceManager, "trailersFeedActivity.serviceManager");
                if (serviceManager.mo9519()) {
                    C2139sa saVar = C2139sa.f10131;
                    C2059ph serviceManager2 = this.f10133.getServiceManager();
                    C1457Fr.m5016((Object) serviceManager2, "trailersFeedActivity.serviceManager");
                    saVar.m10693(serviceManager2, rWVar, this.f10132);
                    return;
                }
                C1276.m16820().mo5725("Tried to prepare item at " + rWVar.m10214() + " but serviceManager is not ready");
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m10696(rU rUVar, TrailersFeedViewModel trailersFeedViewModel) {
        C1457Fr.m5025(rUVar, "trailersFeedActivity");
        C1457Fr.m5025(trailersFeedViewModel, "trailersFeedViewModel");
        trailersFeedViewModel.m1947().observe(rUVar, new C0196(rUVar, trailersFeedViewModel));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m10693(C2059ph phVar, rW rWVar, TrailersFeedViewModel trailersFeedViewModel) {
        C1283.m16854("TrailersFeedPrepareQueue", "prepareItem : " + rWVar + " at " + rWVar.m10214() + " (total is " + trailersFeedViewModel.m1928() + ')');
        ArrayList arrayList = new ArrayList();
        if (rWVar.m10214() > 0) {
            arrayList.add(trailersFeedViewModel.m1948(rWVar.m10214() - 1));
        }
        if (rWVar.m10214() < trailersFeedViewModel.m1928() - 1) {
            arrayList.add(trailersFeedViewModel.m1948(rWVar.m10214() + 1));
        }
        m10692(phVar, rWVar);
        if (!arrayList.isEmpty()) {
            m10695(phVar, arrayList);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m10692(C2059ph phVar, rW rWVar) {
        pF r7 = rWVar.mo4192();
        if (r7 instanceof pF) {
            C1283.m16854("TrailersFeedPrepareQueue", "push 1 PlayerPrepareRequest");
            rWVar.m10215();
            phVar.m9759().mo7795(EI.m4806(new C2054pc(r7.getPlayableId(), r7.getPlayableBookmarkUpdateTime(), PlayerPrefetchSource.MobileComingSoon, rWVar.m10222())));
            return;
        }
        C1283.m16854("TrailersFeedPrepareQueue", "ignore non playable item");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m10695(C2059ph phVar, List<rW> list) {
        EA ea;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : list) {
            if (t.mo4190()) {
                arrayList2.add(t);
            }
        }
        ArrayList<rW> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(EI.m4812((Iterable) arrayList3, 10));
        for (rW rWVar : arrayList3) {
            rWVar.m10215();
            pF r13 = rWVar.mo4192();
            if (r13 != null) {
                C1457Fr.m5016((Object) r13, "trailerPlayable");
                arrayList.add(new C2054pc(r13.getPlayableId(), r13.getPlayableBookmarkUpdateTime(), PlayerPrefetchSource.MobileComingSoon, rWVar.m10222()));
                ea = EA.f5503;
            } else {
                ea = null;
            }
            arrayList4.add(ea);
        }
        if (!arrayList.isEmpty()) {
            C1283.m16854("TrailersFeedPrepareQueue", "push " + arrayList.size() + " PlayerPrepareRequest(s)");
            phVar.m9759().mo7795(arrayList);
            return;
        }
        C1283.m16854("TrailersFeedPrepareQueue", "ignore non playable item(s)");
    }
}
