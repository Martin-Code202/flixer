package o;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.model.leafs.ListOfGenreSummary;
import java.util.ArrayList;
import java.util.List;
import o.C0567;
import o.C2155sn;
import o.sF;
@SuppressLint({"InflateParams"})
/* renamed from: o.ss  reason: case insensitive filesystem */
public class C2160ss implements AbstractC2159sr {

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final GenreList f10242 = new C2161iF();

    /* renamed from: ʻ  reason: contains not printable characters */
    private C2059ph f10243;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final C0616 f10244;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected TextView f10245;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final BroadcastReceiver f10246 = new BroadcastReceiver() { // from class: o.ss.7
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C2160ss.this.m10814();
            C2160ss.this.mo10847();
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    protected LinearLayout f10247;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f10248 = false;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final BroadcastReceiver f10249 = new BroadcastReceiver() { // from class: o.ss.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C2160ss.this.m10838();
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private final C0874 f10250;

    /* renamed from: ˈ  reason: contains not printable characters */
    private C0208 f10251;

    /* renamed from: ˉ  reason: contains not printable characters */
    private final AdapterView.OnItemClickListener f10252 = new AdapterView.OnItemClickListener() { // from class: o.ss.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C2160ss.this.f10264.closeDrawers();
            C2155sn.C0207 r1 = C2160ss.this.f10251.getItem(i);
            if (r1 != null && r1.f10239 != null) {
                r1.f10239.run();
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final TextView f10253;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private final View.OnClickListener f10254 = new View.OnClickListener() { // from class: o.ss.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent r1 = ActivityC2153sl.m10779(C2160ss.this.f10258);
            r1.addFlags(67108864);
            C2160ss.this.f10258.startActivity(r1);
            C2160ss.this.m10842();
        }
    };

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final View.OnClickListener f10255 = new View.OnClickListener() { // from class: o.ss.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2160ss.this.f10258.startActivity(ActivityC2383zq.m13737(C2160ss.this.f10258));
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private ViewStub f10256;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final C0567.Cif f10257 = new C0567.Cif() { // from class: o.ss.14
        @Override // o.C0567.Cif
        public void N_() {
            C2160ss.this.m10835();
            C2160ss.this.m10819();
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final NetflixActivity f10258;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final AdapterView.OnItemClickListener f10259 = new AdapterView.OnItemClickListener() { // from class: o.ss.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!C2160ss.this.f10248) {
                ActivityC2153sl.m10769(C2160ss.this.f10258, C2160ss.this.f10271.getItem(i - C2160ss.this.f10270.getHeaderViewsCount()));
                C2160ss.this.m10842();
            }
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final boolean f10260;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final View f10261;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final View f10262;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private sK f10263;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final DrawerLayout f10264;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final ImageView f10265;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final View f10266;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final View f10267;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private GenreList f10268;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final C0522 f10269;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected final C0874 f10270;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Cif f10271;

    @SuppressLint({"ParcelCreator"})
    /* renamed from: o.ss$iF  reason: case insensitive filesystem */
    static class C2161iF extends ListOfGenreSummary {
    }

    public C2160ss(final NetflixActivity netflixActivity, DrawerLayout drawerLayout, boolean z) {
        this.f10258 = netflixActivity;
        this.f10264 = drawerLayout;
        this.f10260 = z;
        View inflate = netflixActivity.getLayoutInflater().inflate(R.layout.standard_sliding_menu, drawerLayout);
        this.f10247 = (LinearLayout) drawerLayout.findViewById(R.id.sliding_menu_content);
        this.f10247.setOnClickListener(null);
        this.f10244 = new C0616(drawerLayout.findViewById(R.id.sliding_menu_genres_frame), this.f10257);
        this.f10261 = drawerLayout.findViewById(R.id.header_separator_notifications);
        this.f10262 = drawerLayout.findViewById(R.id.header_notifications);
        if (this.f10262 != null) {
            TextView textView = (TextView) this.f10262.findViewById(R.id.row_text);
            textView.setText(netflixActivity.getString(R.string.notifications));
            textView.setPadding(0, 0, 0, 0);
        }
        if (this.f10260) {
            C1283.m16846("StandardSlidingMenu", "Inflating notifications into layout");
            this.f10256 = (ViewStub) inflate.findViewById(R.id.sliding_menu_notifications_stub);
            this.f10256.inflate();
            this.f10263 = (sK) netflixActivity.getSupportFragmentManager().findFragmentById(R.id.social_notifications_frag);
            this.f10263.m10578(new sF.iF() { // from class: o.ss.9
                @Override // o.sF.iF
                /* renamed from: ˋ */
                public void mo10591(boolean z2) {
                    C2160ss.this.m10827(z2);
                }
            });
            m10827(this.f10263.m10589());
            View findViewById = this.f10247.findViewById(R.id.header_notifications);
            findViewById.setBackgroundResource(R.drawable.selectable_item_background);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: o.ss.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    netflixActivity.startActivity(new Intent(netflixActivity, sC.m10520()));
                }
            });
        } else {
            this.f10261.setVisibility(8);
            this.f10262.setVisibility(8);
        }
        this.f10266 = inflate.findViewById(R.id.sliding_menu_profiles_group);
        this.f10266.setOnClickListener(this.f10255);
        this.f10265 = (ImageView) this.f10266.findViewById(R.id.sliding_menu_profiles_switch_icon);
        this.f10253 = (TextView) this.f10266.findViewById(R.id.sliding_menu_profiles_title);
        this.f10269 = (C0522) this.f10266.findViewById(R.id.sliding_menu_profiles_img);
        this.f10270 = (C0874) this.f10247.findViewById(R.id.sliding_menu_genres_list_view);
        this.f10270.setFocusable(false);
        this.f10267 = m10816();
        this.f10270.addHeaderView(this.f10267, null, false);
        mo10811(f10242);
        this.f10250 = (C0874) this.f10247.findViewById(R.id.sliding_menu_app_list_view);
        this.f10250.setFocusable(false);
        m10814();
        m10819();
        netflixActivity.registerReceiverWithAutoUnregister(this.f10246, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m10838() {
        if (this.f10243 != null) {
            UmaAlert r2 = this.f10243.m9820();
            this.f10248 = r2 != null && !r2.isConsumed() && r2.blocking();
            if (this.f10270 != null) {
                this.f10270.setVisibility(this.f10248 ? 8 : 0);
            }
            m10836();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10827(boolean z) {
        if (this.f10256 == null) {
            C1283.m16846("StandardSlidingMenu", "notificationsStub is null - can't set visibility");
        }
        if (z) {
            C1283.m16846("StandardSlidingMenu", "Showing notifications header");
            this.f10256.setVisibility(0);
            this.f10261.setVisibility(0);
            this.f10262.setVisibility(0);
            return;
        }
        C1283.m16846("StandardSlidingMenu", "Hiding notifications header");
        this.f10256.setVisibility(8);
        this.f10261.setVisibility(8);
        this.f10262.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private void m10814() {
        List<C2155sn.C0207> r2 = C2155sn.m10805(this.f10258);
        if (r2 == null || r2.size() <= 0) {
            this.f10250.setVisibility(8);
            return;
        }
        this.f10251 = new C0208(r2);
        this.f10250.setAdapter((ListAdapter) this.f10251);
        this.f10250.setOnItemClickListener(this.f10252);
        this.f10250.setVisibility(0);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private View m10816() {
        View inflate = this.f10258.getLayoutInflater().inflate(R.layout.standard_menu_row, (ViewGroup) null);
        this.f10245 = (TextView) inflate.findViewById(R.id.row_text);
        this.f10245.setText(R.string.label_home);
        inflate.setBackgroundResource(R.drawable.selectable_item_background);
        inflate.setOnClickListener(this.f10254);
        inflate.setTag(new C0209(this.f10245, inflate.findViewById(R.id.row_selection_indicator)));
        return inflate;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m10823() {
        if (this.f10258.showOfflineInMenu() && this.f10258.getServiceManager().m9824()) {
            View findViewById = this.f10247.findViewById(R.id.sliding_menu_my_downloads);
            m10848(findViewById, this.f10258.getString(R.string.label_download_screen), ContextCompat.getDrawable(this.f10258, R.drawable.ic_download_icon));
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: o.ss.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C2160ss.this.f10258.startActivity(vH.m11936(C2160ss.this.f10258));
                    C2160ss.this.m10849();
                }
            });
            findViewById.setVisibility(0);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m10834() {
        if (this.f10243.m9822()) {
            View findViewById = this.f10247.findViewById(R.id.sliding_menu_my_list);
            m10848(findViewById, this.f10258.getString(R.string.label_my_list_2), ContextCompat.getDrawable(this.f10258, R.drawable.ic_mylist_check_drawer));
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: o.ss.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!C2160ss.this.f10248) {
                        uB.m11324(C2160ss.this.f10258, new tO("MyListFakeId", C2160ss.this.f10258.getString(R.string.label_my_list_2), LoMoType.INSTANT_QUEUE, LoMoType.INSTANT_QUEUE.m1575()));
                        C2160ss.this.m10849();
                    }
                }
            });
            findViewById.setVisibility(0);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m10830() {
        if (C0654.m14815(this.f10258)) {
            C1283.m16854("StandardSlidingMenu", "Showing Watch History Row for Ab8505");
            View findViewById = this.f10247.findViewById(R.id.sliding_menu_watch_history);
            m10848(findViewById, C2149si.f10161.m10733(this.f10258), ContextCompat.getDrawable(this.f10258, R.drawable.ic_history_white_24dp));
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: o.ss.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C2160ss.this.f10258.startActivity(ActivityC2150sj.f10162.m10741(C2160ss.this.f10258));
                    C2160ss.this.m10849();
                }
            });
            findViewById.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10848(View view, String str, Drawable drawable) {
        view.findViewById(R.id.row_separator).setVisibility(0);
        TextView textView = (TextView) view.findViewById(R.id.row_text);
        textView.setPadding(0, 0, 0, 0);
        textView.setText(str);
        BrowseExperience.m1776((ImageView) view.findViewById(R.id.row_icon), drawable, R.attr.actionBarIconColor);
    }

    @Override // o.AbstractC2168sz
    public void a_(Status status) {
        if (this.f10263 != null) {
            this.f10263.a_(status);
        }
        m10819();
    }

    @Override // o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        this.f10243 = phVar;
        if (this.f10263 != null) {
            this.f10263.onManagerReady(phVar, status);
        }
        m10823();
        m10834();
        m10830();
        m10814();
        m10841();
        m10838();
    }

    @Override // o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        if (this.f10263 != null) {
            this.f10263.onManagerUnavailable(phVar, status);
        }
        this.f10243 = null;
    }

    @Override // o.AbstractC2159sr
    /* renamed from: ˋ */
    public void mo10808(NetflixActivity netflixActivity) {
        m10841();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_UPDATED");
        intentFilter.addAction("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_CONSUMED");
        LocalBroadcastManager.getInstance(netflixActivity).registerReceiver(this.f10249, intentFilter);
    }

    @Override // o.AbstractC2159sr
    /* renamed from: ˏ */
    public void mo10809(NetflixActivity netflixActivity) {
        LocalBroadcastManager.getInstance(netflixActivity).unregisterReceiver(this.f10249);
    }

    @Override // o.AbstractC2159sr
    /* renamed from: ॱ */
    public void mo10810() {
        m10835();
        m10819();
        if (this.f10263 != null) {
            this.f10263.m10583();
        }
    }

    @Override // o.AbstractC2159sr
    /* renamed from: ॱ */
    public void mo10811(GenreList genreList) {
        if (genreList == null || genreList == f10242) {
            this.f10268 = f10242;
            m10845((C0209) this.f10267.getTag(), true);
        } else {
            this.f10268 = genreList;
            m10845((C0209) this.f10267.getTag(), false);
        }
        if (this.f10271 != null) {
            this.f10271.notifyDataSetChanged();
        }
    }

    @Override // o.AbstractC2159sr
    /* renamed from: ˊ */
    public boolean mo10807() {
        return this.f10260;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10844() {
        if (this.f10263 != null) {
            this.f10263.m10577();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10846(boolean z) {
        if (this.f10263 != null) {
            this.f10263.m10580(z);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m10819() {
        if (!m10829()) {
            C1283.m16846("StandardSlidingMenu", "Fetching genres list...");
            this.f10243.m9764().mo9493(new If());
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean m10829() {
        if (this.f10243 != null && this.f10243.mo9519()) {
            return false;
        }
        C1283.m16846("StandardSlidingMenu", "Manager is not ready - can't update");
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m10813() {
        this.f10244.mo14660(true);
        BQ.m3909(this.f10270, true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m10835() {
        this.f10244.mo14570(true);
        BQ.m3909(this.f10270, true);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m10841() {
        m10836();
        m10839();
        mo10847();
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m10836() {
        if (m10829()) {
            C1283.m16854("StandardSlidingMenu", "Manager not ready - can't update profile view visibility yet");
        } else {
            this.f10266.setVisibility((!m10843() || this.f10248) ? 8 : 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m10843() {
        if (this.f10243.m9833() != null) {
            return true;
        }
        C1283.m16865("StandardSlidingMenu", "No profiles found for user!");
        return false;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m10839() {
        if (!m10829()) {
            AbstractC2089qj r7 = this.f10243.m9826();
            if (r7 == null) {
                C1283.m16846("StandardSlidingMenu", "Profile is null - can't update profile info");
                return;
            }
            this.f10253.setText(r7.getProfileName());
            NetflixActivity.getImageLoader(this.f10258).mo3057(this.f10269, r7.getAvatarUrl(), AssetType.profileAvatar, r7.getProfileName(), StaticImgConfig.DARK_NO_PLACEHOLDER, true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo10847() {
        if (!m10829()) {
            this.f10243.m9765();
            boolean z = !ConnectivityUtils.m2954(this.f10243.m9814()) || this.f10243.m9762();
            this.f10266.setEnabled(!z);
            this.f10265.setImageResource(z ? 17301535 : R.drawable.ic_change_profile);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10832(List<GenreList> list) {
        this.f10244.mo14663(true);
        if (!this.f10248) {
            BQ.m3914(this.f10270, true);
        }
        this.f10271 = new Cif(list);
        this.f10270.setAdapter((ListAdapter) this.f10271);
        this.f10270.setOnItemClickListener(this.f10259);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m10820(C0209 r3) {
        ViewUtils.m3011(r3.f10291);
        r3.f10292.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10833(C0209 r3) {
        ViewUtils.m3021(r3.f10291);
        r3.f10292.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10845(C0209 r1, boolean z) {
        if (z) {
            m10820(r1);
        } else {
            m10833(r1);
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m10842() {
        this.f10264.postDelayed(new Runnable() { // from class: o.ss.12
            @Override // java.lang.Runnable
            public void run() {
                C2160ss.this.f10264.closeDrawers();
            }
        }, Build.VERSION.SDK_INT >= 21 ? 300 : 0);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m10849() {
        this.f10264.closeDrawers();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ss$If */
    public class If extends oP {
        public If() {
            super("StandardSlidingMenu");
        }

        @Override // o.oP, o.oU
        public void onGenreListsFetched(List<GenreList> list, Status status) {
            super.onGenreListsFetched(list, status);
            if (status.mo301()) {
                C1283.m16865("StandardSlidingMenu", "Invalid status code for genres fetch");
                C2160ss.this.m10813();
            } else if (list == null || list.size() < 1) {
                C1283.m16846("StandardSlidingMenu", "No genres in response");
                C2160ss.this.m10813();
                C1276.m16820().mo5727("SPY-7985 - GenresListAdapter got null or empty genres list: " + (list == null ? "null" : String.valueOf(list.size())));
            } else {
                C2160ss.this.m10832(list);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ss$if  reason: invalid class name */
    public class Cif extends BaseAdapter {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final List<GenreList> f10288 = new ArrayList();

        public Cif(List<GenreList> list) {
            this.f10288.addAll(list);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f10288.size();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public GenreList getItem(int i) {
            return this.f10288.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = C2160ss.this.f10258.getLayoutInflater().inflate(R.layout.standard_menu_row, (ViewGroup) null);
                view.setTag(new C0209((TextView) view.findViewById(R.id.row_text), view.findViewById(R.id.row_selection_indicator)));
            }
            C0209 r3 = (C0209) view.getTag();
            GenreList r4 = getItem(i);
            boolean z = false;
            if (r4 != null) {
                r3.f10291.setText(r4.getTitle());
                z = C1349Bv.m4107(r4.getId()) && r4.getId().equals(C2160ss.this.f10268.getId());
            }
            C2160ss.this.m10845(r3, z);
            return view;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o.ss$ˋ  reason: contains not printable characters */
    public static class C0209 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final TextView f10291;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final View f10292;

        public C0209(TextView textView, View view) {
            this.f10291 = textView;
            this.f10292 = view;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ss$ˊ  reason: contains not printable characters */
    public class C0208 extends BaseAdapter {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final List<C2155sn.C0207> f10289;

        public C0208(List<C2155sn.C0207> list) {
            this.f10289 = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f10289.size();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public C2155sn.C0207 getItem(int i) {
            return this.f10289.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = C2160ss.this.f10258.getLayoutInflater().inflate(R.layout.standard_menu_row, (ViewGroup) null);
                view.setTag(new C0209((TextView) view.findViewById(R.id.row_text), view.findViewById(R.id.row_selection_indicator)));
            }
            C0209 r3 = (C0209) view.getTag();
            r3.f10291.setText(getItem(i).f10238);
            C2160ss.this.m10833(r3);
            return view;
        }
    }
}
