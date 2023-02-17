package o;

import android.content.Context;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails;
import io.realm.Realm;
import java.util.List;
import java.util.Map;
import o.AbstractC1863hu;
/* renamed from: o.hs  reason: case insensitive filesystem */
public class C1861hs implements AbstractC1863hu {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Realm f7422 = C2093qn.m10094();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final BookmarkStore f7423;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1899j f7424;

    public C1861hs(AbstractC1899j jVar, BookmarkStore bookmarkStore) {
        this.f7424 = jVar;
        this.f7423 = bookmarkStore;
    }

    @Override // o.AbstractC1863hu
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7340(int i) {
        this.f7424.mo7803(i, new AbstractC1222() { // from class: o.hs.3
        });
    }

    @Override // o.AbstractC1863hu
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7345(AbstractC0933 r10, final Runnable runnable) {
        for (RealmIncompleteVideoDetails realmIncompleteVideoDetails : C2093qn.m10095(this.f7422)) {
            C1283.m16851("offlineFalkor", "Recover details for %s", realmIncompleteVideoDetails.getPlayableId());
            m7334(r10, realmIncompleteVideoDetails.getPlayableId(), VideoType.create(realmIncompleteVideoDetails.getVideoType()), realmIncompleteVideoDetails.getProfileId(), new Runnable() { // from class: o.hs.5
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    @Override // o.AbstractC1863hu
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo7342(AbstractC2089qj qjVar, AbstractC0933 r8, String str, VideoType videoType) {
        if (qjVar != null) {
            C2091ql.insertProfileIfNeeded(this.f7422, AbstractApplicationC1258.m16692(), r8, qjVar);
            RealmIncompleteVideoDetails.insertInRealm(this.f7422, str, videoType, qjVar.getProfileGuid());
            m7334(r8, str, videoType, qjVar.getProfileGuid(), null);
        }
    }

    @Override // o.AbstractC1863hu
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7343(Context context, String str) {
        C2093qn.m10088(context, this.f7422, str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7334(final AbstractC0933 r8, final String str, VideoType videoType, final String str2, final Runnable runnable) {
        if (videoType == VideoType.MOVIE) {
            this.f7424.mo7805(str, (String) null, new AbstractC1222() { // from class: o.hs.2
                @Override // o.AbstractC1222, o.AbstractC1203
                /* renamed from: ˏ */
                public void mo6200(pP pPVar, Status status) {
                    super.mo6200(pPVar, status);
                    if (status.mo301() || pPVar == null) {
                        C1861hs.m7337(status, pPVar);
                        return;
                    }
                    C1283.m16854("offlineFalkor", "Saving movie details");
                    C2098qr.insertInRealm(C2093qn.m10094(), r8, pPVar, str2);
                    C1861hs.this.f7423.createOrUpdateBookmark(pPVar, str2);
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        } else if (videoType == VideoType.EPISODE) {
            this.f7424.mo7817(str, null, new AbstractC1222() { // from class: o.hs.1
                @Override // o.AbstractC1222, o.AbstractC1203
                /* renamed from: ˎ */
                public void mo6203(final pI pIVar, Status status) {
                    super.mo6203(pIVar, status);
                    if (status.mo301() || pIVar == null) {
                        C1861hs.m7337(status, pIVar);
                        return;
                    }
                    String r4 = pIVar.mo4565();
                    if (C2093qn.m10092(C1861hs.this.f7422, C2098qr.class, r4)) {
                        C1861hs.this.f7424.mo7806(r4, str, false, (AbstractC1203) new AbstractC1222() { // from class: o.hs.1.3
                            @Override // o.AbstractC1222, o.AbstractC1203
                            /* renamed from: ˎ  reason: contains not printable characters */
                            public void mo7346(pR pRVar, List<pS> list, Status status2) {
                                super.mo7346(pRVar, list, status2);
                                if (status2.mo301() || pRVar == null) {
                                    C1861hs.m7337(status2, pRVar);
                                    return;
                                }
                                C1283.m16854("offlineFalkor", "Saving episode details and season details");
                                C2098qr.insertInRealm(C1861hs.this.f7422, r8, pIVar, str2);
                                C1861hs.this.f7423.createOrUpdateBookmark(pIVar, str2);
                                C2098qr.insertInRealm(C1861hs.this.f7422, r8, pRVar, list, str2);
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        });
                        return;
                    }
                    C1283.m16854("offlineFalkor", "Saving episode details, season details already saved");
                    C2098qr.insertInRealm(C1861hs.this.f7422, r8, pIVar, str2);
                    C1861hs.this.f7423.createOrUpdateBookmark(pIVar, str2);
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    @Override // o.AbstractC1863hu
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo7341(String str, VideoType videoType, int i, int i2, final AbstractC1863hu.AbstractC0118 r12) {
        this.f7424.mo7810(str, CmpTaskMode.FROM_CACHE_OR_NETWORK, videoType, i, i2, new AbstractC1222() { // from class: o.hs.4
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ᐝ  reason: contains not printable characters */
            public void mo7347(List<pI> list, Status status) {
                r12.mo7325(list, status);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m7337(Status status, pT pTVar) {
        String str = "serializeMetadataToDisc() got an error: " + status + " videoDetails" + pTVar;
        C1283.m16865("offlineFalkor", str);
        C1276.m16820().mo5725(str);
    }

    @Override // o.AbstractC1863hu
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7344(List<String> list, final AbstractC1863hu.Cif ifVar) {
        C1283.m16862("offlineFalkor", "sendGeoPlayabilityRequest");
        if (list.size() <= 0) {
            C1283.m16862("offlineFalkor", "videoIdList is empty");
            return;
        }
        C1283.m16854("offlineFalkor", "sendGeoPlayabilityRequest calling... updateOfflineGeoPlayability");
        this.f7424.mo7818(list, new AbstractC1222() { // from class: o.hs.8
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo7348(Map<String, Boolean> map, Status status) {
                ifVar.mo7291(map);
            }
        });
    }
}
