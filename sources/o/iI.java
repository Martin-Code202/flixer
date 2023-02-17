package o;

import com.netflix.mediaclient.service.player.OfflinePlaybackSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.AbstractC1891is;
/* access modifiers changed from: package-private */
public class iI {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Map<oY, List<AbstractC1891is>> f7535 = new HashMap();

    iI() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m7444(oY oYVar) {
        this.f7535.put(oYVar, new ArrayList());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized OfflinePlaybackSession m7446(long j) {
        for (List<AbstractC1891is> list : this.f7535.values()) {
            Iterator<AbstractC1891is> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    AbstractC1891is next = it.next();
                    if ((next instanceof OfflinePlaybackSession) && next.mo7754() == j) {
                        return (OfflinePlaybackSession) next;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized iM m7442(long j) {
        for (List<AbstractC1891is> list : this.f7535.values()) {
            Iterator<AbstractC1891is> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    AbstractC1891is next = it.next();
                    if ((next instanceof iM) && next.mo7754() == j) {
                        return (iM) next;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m7445(oY oYVar, AbstractC1891is isVar) {
        List<AbstractC1891is> list = this.f7535.get(oYVar);
        if (list == null) {
            C1276.m16820().mo5725("video group found but there is no session list");
            list = new ArrayList<>();
            this.f7535.put(oYVar, list);
        }
        list.add(isVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m7443(oY oYVar) {
        List<AbstractC1891is> remove = this.f7535.remove(oYVar);
        if (remove != null) {
            for (AbstractC1891is isVar : remove) {
                C1283.m16863("nf_playbackSessionMgr", "closing session streamingSession=%b movieId=%d", Boolean.valueOf(isVar instanceof iM), Long.valueOf(isVar.mo7754()));
                isVar.mo920((AbstractC1891is.AbstractC0128) null);
                if (isVar == AbstractC1891is.f7775) {
                    isVar.m7760();
                }
            }
        }
    }
}
