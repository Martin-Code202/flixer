package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import com.netflix.model.leafs.social.multititle.NotificationLandingPage;
import java.util.Iterator;
import java.util.List;
/* renamed from: o.ᒏ  reason: contains not printable characters */
public final class C0776 implements AbstractC0695 {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final iF f14421 = new iF(null);

    /* renamed from: o.ᒏ$iF */
    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }
    }

    @Override // o.AbstractC0695
    /* renamed from: ˋ */
    public boolean mo14971(List<String> list) {
        C1457Fr.m5025(list, Event.DATA);
        return list.size() > 1;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        C1457Fr.m5025(netflixActivity, "activity");
        C1457Fr.m5025(list, Event.DATA);
        if (list.size() > 1) {
            String str2 = list.get(1);
            if (!(str2.length() == 0)) {
                m15236(netflixActivity, str2);
                return NflxHandler.Response.HANDLING_WITH_DELAY;
            }
        }
        return NflxHandler.Response.NOT_HANDLING;
    }

    /* renamed from: o.ᒏ$ˊ  reason: contains not printable characters */
    public static final class C0777 extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C0776 f14422;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ NetflixActivity f14423;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ String f14424;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0777(C0776 r1, String str, NetflixActivity netflixActivity, String str2) {
            super(str2);
            this.f14422 = r1;
            this.f14424 = str;
            this.f14423 = netflixActivity;
        }

        @Override // o.oP, o.oU
        public void onNotificationsListFetched(AbstractC2082qc qcVar, Status status) {
            T t;
            List<IrisNotificationSummary> socialNotifications;
            T t2;
            super.onNotificationsListFetched(qcVar, status);
            if (qcVar == null || (socialNotifications = qcVar.getSocialNotifications()) == null) {
                t = null;
            } else {
                Iterator<T> it = socialNotifications.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t2 = null;
                        break;
                    }
                    T next = it.next();
                    T t3 = next;
                    C1457Fr.m5016((Object) t3, "notification");
                    if (C1457Fr.m5018((Object) t3.getEventGuid(), (Object) this.f14424)) {
                        t2 = next;
                        break;
                    }
                }
                t = t2;
            }
            if (t != null) {
                this.f14422.m15235(this.f14423, t.getLandingPage());
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m15236(NetflixActivity netflixActivity, String str) {
        C2059ph serviceManager = netflixActivity.getServiceManager();
        C1457Fr.m5016((Object) serviceManager, "activity.serviceManager");
        serviceManager.m9764().mo9508(0, 7, true, new C0777(this, str, netflixActivity, "NetflixComMultiTitleNotificationHandler"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m15235(NetflixActivity netflixActivity, NotificationLandingPage notificationLandingPage) {
        if (notificationLandingPage == null) {
            return;
        }
        if (AD.m3299()) {
            netflixActivity.startActivity(sU.f10118.m10679(netflixActivity, notificationLandingPage));
        } else {
            netflixActivity.startActivity(sR.f10100.m10663(netflixActivity, notificationLandingPage));
        }
    }
}
