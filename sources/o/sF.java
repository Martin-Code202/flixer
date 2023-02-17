package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import com.netflix.model.leafs.social.IrisNotificationsListSummary;
import com.netflix.model.leafs.social.multititle.NotificationLandingPage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import o.AJ;
import o.C0567;
import org.json.JSONException;
import org.json.JSONObject;
public class sF extends AbstractC0517 {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final String f9994 = sF.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    protected AJ.C0062 f9995 = AJ.f4281;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f9996;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected AbstractC2082qc f9997;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C0187 f9998;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final BroadcastReceiver f9999 = new BroadcastReceiver() { // from class: o.sF.9
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            sF.this.f9995 = AJ.m3360(intent, sF.f9994);
            if (sF.this.f10008 == null || sF.this.f10008.getFirstVisiblePosition() != 0) {
                sF.this.f9996 = true;
            } else {
                sF.this.m10568(false);
            }
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f10000;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f10001;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected boolean f10002 = true;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final Set<IrisNotificationSummary> f10003 = new HashSet();

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f10004;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f10005 = true;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f10006;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final C0567.Cif f10007 = new C0567.Cif() { // from class: o.sF.4
        @Override // o.C0567.Cif
        public void N_() {
            sF.this.m10583();
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected C0874 f10008;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private iF f10009;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean f10010;

    public interface iF {
        /* renamed from: ˋ  reason: contains not printable characters */
        void mo10591(boolean z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10578(iF iFVar) {
        this.f10009 = iFVar;
        m10581();
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("notifications_list")) {
            this.f10005 = bundle.getBoolean("has_load_more_list");
            this.f9997 = (AbstractC2082qc) bundle.getParcelable("notifications_list");
            AJ.m3365(bundle.getParcelableArray("notifications_list_to_be_read"), this.f10003);
            this.f10004 = bundle.getBoolean("were_notifications_fetched");
            this.f9995 = (AJ.C0062) bundle.getParcelable("notification_list_status");
            this.f10002 = bundle.getBoolean("extra_show_notifications");
            m10581();
        }
        if (NetflixBottomNavBar.m416()) {
            m10551();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1283.m16846(f9994, "Creating new frag view...");
        this.f10010 = true;
        View inflate = layoutInflater.inflate(R.layout.social_notifications_frag, viewGroup, false);
        this.f10008 = (C0874) inflate.findViewById(R.id.notifications_listview);
        this.f10008.setItemsCanFocus(true);
        this.f10008.setAsStatic(mo10584());
        this.f10001 = true;
        m10539();
        return inflate;
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        if (!mo10582()) {
            m10539();
        }
    }

    @Override // o.AbstractC0517, o.AbstractC2168sz
    public void a_(Status status) {
        super.a_(status);
        m10539();
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f9997 != null) {
            bundle.putBoolean("has_load_more_list", m10541());
            bundle.putParcelable("notifications_list", this.f9997.getParcelable());
            bundle.putParcelableArray("notifications_list_to_be_read", (Parcelable[]) this.f10003.toArray(new IrisNotificationSummary[this.f10003.size()]));
            bundle.putBoolean("were_notifications_fetched", this.f10004);
            bundle.putParcelable("notification_list_status", this.f9995);
            bundle.putBoolean("extra_show_notifications", this.f10002);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean m10541() {
        return mo10588() && this.f10005;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo10582() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo10588() {
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (!NetflixBottomNavBar.m416()) {
            m10551();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (!NetflixBottomNavBar.m416()) {
            m10552();
        }
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m10552();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m10542();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m10580(boolean z) {
        for (int i = 0; i < m10544(); i++) {
            IrisNotificationSummary irisNotificationSummary = this.f9997.getSocialNotifications().get(i);
            if (z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!(irisNotificationSummary.getLandingPage() == null || irisNotificationSummary.getTrackingInfo() == null)) {
                        jSONObject = irisNotificationSummary.getTrackingInfo().toJSONObject();
                        irisNotificationSummary.getTrackingInfo().addProperty("notificationItemType", "landing");
                        C1300Ac.m3524(false, AppView.notificationItem, irisNotificationSummary.getTrackingInfo());
                    }
                    jSONObject.put("position", i);
                    jSONObject.put("isRead", irisNotificationSummary.getWasRead());
                    jSONObject.put("messageGuid", irisNotificationSummary.getId());
                    jSONObject.put("titleId", irisNotificationSummary.getVideoId());
                    C1364Cj.m4445(jSONObject);
                } catch (JSONException e) {
                    C1276.m16820().mo5729(String.format("%s: could not put data into model: %s", f9994, jSONObject.toString()), e);
                }
            } else {
                C1364Cj.m4438(true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m10583() {
        m10568(true);
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f10001;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean mo10584() {
        return false;
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private void m10539() {
        if (!this.f10010) {
            C1283.m16846(f9994, "Can't complete init - views not created");
        } else if (m14536() == null) {
            C1283.m16846(f9994, "Can't complete init - manager not ready");
        } else {
            this.f9998 = new C0187();
            this.f10008.setAdapter((ListAdapter) this.f9998);
            if (this.f9997 == null) {
                m10568(true);
                return;
            }
            this.f10001 = false;
            this.f9998.m10593("completeInitIfPossible");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public int m10579() {
        if (!this.f10002 || !m10589()) {
            return 0;
        }
        return m10541() ? this.f9997.getSocialNotifications().size() + 1 : this.f9997.getSocialNotifications().size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m10581() {
        if (m10585()) {
            this.f10002 = true;
        }
        if (this.f10009 != null) {
            this.f10009.mo10591(m10589());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean m10585() {
        List<IrisNotificationSummary> socialNotifications;
        if (this.f9997 == null || (socialNotifications = this.f9997.getSocialNotifications()) == null) {
            return false;
        }
        for (IrisNotificationSummary irisNotificationSummary : socialNotifications) {
            if (!irisNotificationSummary.getWasRead()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public void m10577() {
        if (!(this.f9997 == null || this.f9997.getSocialNotifications() == null || this.f9997.getSocialNotifications().size() <= 0)) {
            ArrayList arrayList = new ArrayList();
            int r2 = m10544();
            for (int i = 0; i < r2; i++) {
                IrisNotificationSummary irisNotificationSummary = this.f9997.getSocialNotifications().get(i);
                if (!irisNotificationSummary.getWasRead()) {
                    arrayList.add(irisNotificationSummary);
                }
            }
            if (!(arrayList.size() <= 0 || m14536() == null || m14536().m9764() == null)) {
                m14536().m9764().mo9496(arrayList);
            }
        }
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private int m10544() {
        if (this.f9997 == null || this.f9997.getSocialNotifications() == null) {
            return 0;
        }
        return mo10590() < this.f9997.getSocialNotifications().size() ? mo10590() : this.f9997.getSocialNotifications().size();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public boolean m10589() {
        return (this.f9997 == null || this.f9997.getSocialNotifications() == null || this.f9997.getSocialNotifications().size() <= 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.sF$ˋ  reason: contains not printable characters */
    public class C0187 extends BaseAdapter {
        private C0187() {
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetInvalidated() {
            if (sF.this.f10008 != null) {
                sF.this.f10008.setLastNotifiedCount(getCount(), "notifyDataSetInvalidated");
            }
            super.notifyDataSetInvalidated();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m10593(String str) {
            if (sF.this.f10008 != null) {
                sF.this.f10008.setLastNotifiedCount(getCount(), str);
            }
            super.notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m10593("notifyDataSetChanged");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (!sF.this.f10004 || sF.this.f10000) {
                return 0;
            }
            return sF.this.m10579();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public IrisNotificationSummary getItem(int i) {
            if (!sF.this.m10589() || i > sF.this.f9997.getSocialNotifications().size() - 1) {
                return null;
            }
            return sF.this.f9997.getSocialNotifications().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            IrisNotificationSummary r6 = getItem(i);
            IrisNotificationSummary.NotificationTypes type = r6 == null ? null : r6.getType();
            AbstractC2171tb r8 = sG.m10595(type);
            if (view == null) {
                view = sF.this.getActivity().getLayoutInflater().inflate(sF.this.mo10586(), viewGroup, false);
                view.setTag(AbstractC2171tb.m11064(view, type));
            }
            sB sBVar = (sB) view.getTag();
            if (!sF.this.m10541() && !sF.this.m10589()) {
                AbstractC2171tb.m11062(sBVar, R.string.hint_no_notifications_found);
                view.setOnClickListener(null);
            } else if (sF.this.m10541() && i == getCount() - 1) {
                AbstractC2171tb.m11062(sBVar, R.string.hint_loading);
                view.setOnClickListener(null);
                sF.this.m10545();
            } else if (r8 == null) {
                AbstractC2171tb.m11062(sBVar, R.string.notifications_not_supported_type_text);
                view.setOnClickListener(null);
            } else if (!(sF.this.getActivity() == null || NetflixActivity.getImageLoader(sF.this.getActivity()) == null)) {
                r8.mo11060(sBVar, r6, sF.this.getActivity());
                m10592(r8, r6, sBVar, view, i);
                if (!r6.getWasRead()) {
                    sF.this.f10003.add(r6);
                }
                if (i == 0 && sF.this.f9996) {
                    sF.this.m10568(false);
                    sF.this.f9996 = false;
                }
            }
            return view;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m10592(AbstractC2171tb tbVar, IrisNotificationSummary irisNotificationSummary, sB sBVar, View view, int i) {
            View.OnClickListener onClickListener;
            if (sF.this.f9997 == null || sF.this.f9997.getSocialNotificationsListSummary() == null) {
                C1283.m16850(sF.f9994, "Got null notifications list data");
                return;
            }
            NetflixActivity r7 = sF.this.m14534();
            String videoId = irisNotificationSummary.getVideoId();
            VideoType videoType = irisNotificationSummary.getVideoType();
            IrisNotificationsListSummary socialNotificationsListSummary = sF.this.f9997.getSocialNotificationsListSummary();
            TextView r11 = tbVar.mo11057(sBVar);
            C2059ph r12 = sF.this.m14536();
            if (!(r11 == null || r12 == null)) {
                r12.m9802(videoId, r12.m9792(r7, r11, videoId, videoType, socialNotificationsListSummary.getBaseTrackId(), true));
                r12.m9818(videoId, irisNotificationSummary.getInQueueValue());
            }
            View r13 = tbVar.mo11061(sBVar);
            if (sF.this.mo10587() && r13 != null) {
                r13.setOnClickListener(sF.this.m10558(irisNotificationSummary, i));
            }
            if (irisNotificationSummary.getLandingPage() != null) {
                onClickListener = sF.this.m10563(irisNotificationSummary.getUrlTarget(), irisNotificationSummary, i, r7);
            } else if (!TextUtils.isEmpty(irisNotificationSummary.getUrlTarget())) {
                onClickListener = sF.this.m10546(irisNotificationSummary.getUrlTarget(), irisNotificationSummary, i, r7);
            } else {
                onClickListener = sF.this.m10562(irisNotificationSummary.getImageTarget(), irisNotificationSummary, i);
            }
            sBVar.m10512().setOnClickListener(onClickListener);
            view.setOnClickListener(onClickListener);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private View.OnClickListener m10558(final IrisNotificationSummary irisNotificationSummary, final int i) {
        final String videoId = irisNotificationSummary.getVideoId();
        final VideoType videoType = irisNotificationSummary.getVideoType();
        IrisNotificationsListSummary socialNotificationsListSummary = this.f9997.getSocialNotificationsListSummary();
        final qN qNVar = new qN(socialNotificationsListSummary.getRequestId(), socialNotificationsListSummary.getPlayerTrackId(), 0, 0);
        return new View.OnClickListener() { // from class: o.sF.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sF.this.m10567(videoId, qNVar, videoType);
                sF.this.m10548(UIViewLogging.UIViewCommandName.startPlay, irisNotificationSummary, i);
            }
        };
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private View.OnClickListener m10569(final IrisNotificationSummary irisNotificationSummary, final int i) {
        final String videoId = irisNotificationSummary.getVideoId();
        final VideoType videoType = irisNotificationSummary.getVideoType();
        final IrisNotificationsListSummary socialNotificationsListSummary = this.f9997.getSocialNotificationsListSummary();
        final String requestId = socialNotificationsListSummary.getRequestId();
        return new View.OnClickListener() { // from class: o.sF.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C2059ph r6 = sF.this.m14536();
                if (r6 != null && r6.m9764() != null && irisNotificationSummary != null && sF.this.f9997 != null) {
                    if (!irisNotificationSummary.getWasRead()) {
                        r6.m9764().mo9507(irisNotificationSummary);
                    }
                    qU.m9966(sF.this.m14534(), videoType, videoId, irisNotificationSummary.getVideoTitle(), new qN(requestId, socialNotificationsListSummary.getMDPTrackId(), 0, 0), "SocialNotif");
                    sF.this.m10548(UIViewLogging.UIViewCommandName.viewTitleDetails, irisNotificationSummary, i);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10548(UIViewLogging.UIViewCommandName uIViewCommandName, IrisNotificationSummary irisNotificationSummary, int i) {
        m10570(uIViewCommandName, irisNotificationSummary, i, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10570(UIViewLogging.UIViewCommandName uIViewCommandName, IrisNotificationSummary irisNotificationSummary, int i, String str) {
        C1364Cj.m4437(uIViewCommandName, IClientLogging.ModalView.menuPanel, (C1359Ce) null, str, m10566(irisNotificationSummary, i));
        C1364Cj.m4432();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject m10566(IrisNotificationSummary irisNotificationSummary, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            NotificationLandingPage landingPage = irisNotificationSummary.getLandingPage();
            if (landingPage == null || irisNotificationSummary.getTrackingInfo() == null) {
                jSONObject.put("trackId", this.f9997.getSocialNotificationsListSummary().getBaseTrackId());
            } else {
                jSONObject = irisNotificationSummary.getTrackingInfo().toJSONObject();
                jSONObject.put("trackId", landingPage.getTrackId());
            }
            jSONObject.put("position", i);
            jSONObject.put("messageGuid", irisNotificationSummary.getId());
            jSONObject.put("titleId", irisNotificationSummary.getVideoId());
        } catch (JSONException e) {
            C1283.m16855(f9994, "getModelObject() got an exception", e);
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private View.OnClickListener m10563(final String str, final IrisNotificationSummary irisNotificationSummary, final int i, final NetflixActivity netflixActivity) {
        final NotificationLandingPage landingPage = irisNotificationSummary.getLandingPage();
        return new View.OnClickListener() { // from class: o.sF.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent;
                if (AD.m3299()) {
                    intent = sU.f10118.m10679(netflixActivity, landingPage);
                } else {
                    intent = sR.f10100.m10663(netflixActivity, landingPage);
                }
                C1300Ac.m3531(new C1080(AppView.notificationItem, irisNotificationSummary.getTrackingInfo()), new C0642(), true);
                sF.this.m10570(UIViewLogging.UIViewCommandName.viewTitleDetails, irisNotificationSummary, i, str);
                netflixActivity.startActivity(intent);
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private View.OnClickListener m10546(final String str, final IrisNotificationSummary irisNotificationSummary, final int i, final NetflixActivity netflixActivity) {
        return new View.OnClickListener() { // from class: o.sF.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!(sF.this.m14536() == null || sF.this.m14536().m9764() == null || irisNotificationSummary == null)) {
                    sF.this.m14536().m9764().mo9507(irisNotificationSummary);
                }
                C0693.m14984(netflixActivity, new Intent("android.intent.action.VIEW", Uri.parse(str)));
                sF.this.m10570(UIViewLogging.UIViewCommandName.viewTitleDetails, irisNotificationSummary, i, str);
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private View.OnClickListener m10562(String str, IrisNotificationSummary irisNotificationSummary, int i) {
        if (str == null) {
            C1283.m16865(f9994, "SPY-8161 - Got null target value");
            C1276.m16820().mo5727("SPY-8161 - Got null target value");
            return m10569(irisNotificationSummary, i);
        }
        String upperCase = str.toUpperCase();
        char c = 65535;
        switch (upperCase.hashCode()) {
            case -1905220446:
                if (upperCase.equals("DISPLAY")) {
                    c = 1;
                    break;
                }
                break;
            case -1633171941:
                if (upperCase.equals("PLAYBACK")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return m10558(irisNotificationSummary, i);
            case 1:
                return m10569(irisNotificationSummary, i);
            default:
                String str2 = "SPY-8161 - Got unsupported target value: " + str;
                C1283.m16865(f9994, str2);
                C1276.m16820().mo5727(str2);
                return m10569(irisNotificationSummary, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public boolean mo10587() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public int mo10586() {
        return R.layout.standard_sliding_menu_social_notifications_row;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m10542() {
        C2059ph r2 = m14536();
        if (r2 != null) {
            int firstVisiblePosition = this.f10008.getFirstVisiblePosition();
            int lastVisiblePosition = this.f10008.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                if (!(this.f9998 == null || this.f9998.getItem(i) == null)) {
                    IrisNotificationSummary r6 = this.f9998.getItem(i);
                    r2.m9818(r6.getVideoId(), r6.getInQueueValue());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10567(String str, oX oXVar, VideoType videoType) {
        startActivity(ActivityC2280wv.m12564(getActivity(), str, videoType, oXVar));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10568(boolean z) {
        final C2059ph r4 = m14536();
        if (r4 != null) {
            this.f10001 = true;
            r4.m9764().mo9498(0, mo10590() - 1, new oP(f9994) { // from class: o.sF.7
                @Override // o.oP, o.oU
                public void onNotificationsListFetched(AbstractC2082qc qcVar, Status status) {
                    super.onNotificationsListFetched(qcVar, status);
                    if (!sF.this.m10573(status)) {
                        sF.this.f10005 = (qcVar == null || qcVar.getSocialNotifications() == null || qcVar.getSocialNotifications().size() != sF.this.mo10590()) ? false : true;
                        sF.this.f9997 = qcVar;
                        sF.this.m10581();
                        if (!sF.this.f10004) {
                            r4.m9764().mo9475(false);
                            sF.this.f10004 = true;
                        }
                        if (sF.this.f9998 != null) {
                            sF.this.f9998.m10593("fetchNotificationsList.onNotificationsListFetched");
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public int mo10590() {
        return 8;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˉ  reason: contains not printable characters */
    private void m10545() {
        C2059ph r5 = m14536();
        if (r5 != null && this.f9997 != null && this.f9997.getSocialNotifications() != null) {
            this.f10001 = true;
            r5.m9764().mo9498(this.f9997.getSocialNotifications().size(), (this.f9997.getSocialNotifications().size() + mo10590()) - 1, new oP(f9994) { // from class: o.sF.6
                @Override // o.oP, o.oU
                public void onNotificationsListFetched(AbstractC2082qc qcVar, Status status) {
                    super.onNotificationsListFetched(qcVar, status);
                    if (!sF.this.m10573(status)) {
                        sF.this.f10005 = (qcVar == null || qcVar.getSocialNotifications() == null || qcVar.getSocialNotifications().size() != sF.this.mo10590()) ? false : true;
                        if (!(qcVar == null || qcVar.getSocialNotifications() == null)) {
                            sF.this.f9997.getSocialNotifications().addAll(qcVar.getSocialNotifications());
                            sF.this.m10581();
                        }
                        if (sF.this.f9998 != null) {
                            sF.this.f9998.m10593("loadMoreNotifications.onNotificationsListFetched");
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m10573(Status status) {
        this.f10001 = false;
        if (status.mo302() == StatusCode.NETWORK_ERROR) {
            this.f10000 = true;
            if (this.f9998 == null) {
                return true;
            }
            this.f9998.m10593("checkForNetworkError " + this.f10000);
            return true;
        }
        this.f10000 = false;
        return false;
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private void m10551() {
        if (isAdded() && !this.f10006) {
            this.f10006 = true;
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f9999, new IntentFilter("com.netflix.mediaclient.intent.action.BA_IRIS_NOTIFICATION_LIST_UPDATED"));
        }
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m10552() {
        if (this.f10006) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f9999);
            this.f10006 = false;
        }
    }
}
