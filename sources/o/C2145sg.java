package o;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.history.WatchHistoryViewModel;
import com.netflix.model.leafs.Episode;
import com.netflix.model.leafs.PostPlayItem;
import com.netflix.model.leafs.Video;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import o.C0567;
import o.C2152sk;
/* renamed from: o.sg  reason: case insensitive filesystem */
public final class C2145sg extends AbstractC0517 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private LinearLayoutManager f10139;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Observer<List<CH>> f10140 = new C2146If(this);

    /* renamed from: ʽ  reason: contains not printable characters */
    private WatchHistoryViewModel f10141;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final C2147iF f10142 = new C2147iF(this);

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f10143 = "WatchHistoryFragment";

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Long f10144;

    /* renamed from: ͺ  reason: contains not printable characters */
    private HashMap f10145;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f10146;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0567.Cif f10147 = new C0198(this);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0616 f10148;

    /* renamed from: ˎ  reason: contains not printable characters */
    public View m10717(int i) {
        if (this.f10145 == null) {
            this.f10145 = new HashMap();
        }
        View view = (View) this.f10145.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f10145.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void m10726() {
        if (this.f10145 != null) {
            this.f10145.clear();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m10718() {
        return this.f10143;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final C0616 m10725() {
        return this.f10148;
    }

    /* renamed from: o.sg$ˊ  reason: contains not printable characters */
    static final class C0198 implements C0567.Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2145sg f10156;

        C0198(C2145sg sgVar) {
            this.f10156 = sgVar;
        }

        @Override // o.C0567.Cif
        public final void N_() {
            this.f10156.m10721();
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public final WatchHistoryViewModel m10724() {
        return this.f10141;
    }

    /* renamed from: o.sg$If  reason: case insensitive filesystem */
    static final class C2146If<T> implements Observer<List<? extends CH>> {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2145sg f10150;

        C2146If(C2145sg sgVar) {
            this.f10150 = sgVar;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final void onChanged(List<? extends CH> list) {
            if (!this.f10150.isDetached()) {
                this.f10150.m10711(list);
            }
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public final int m10716() {
        return this.f10146;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m10719(int i) {
        this.f10146 = i;
    }

    /* renamed from: o.sg$iF  reason: case insensitive filesystem */
    public static final class C2147iF extends BroadcastReceiver {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2145sg f10153;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C2147iF(C2145sg sgVar) {
            this.f10153 = sgVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1457Fr.m5025(context, "context");
            C1457Fr.m5025(intent, "intent");
            if (!this.f10153.isDetached()) {
                this.f10153.m10721();
            }
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public final Long m10720() {
        return this.f10144;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MutableLiveData<List<CH>> r0;
        C1457Fr.m5025(layoutInflater, "inflater");
        C1283.m16846(this.f10143, "Creating frag view");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
        }
        this.f10141 = (WatchHistoryViewModel) ViewModelProviders.of(activity).get(WatchHistoryViewModel.class);
        WatchHistoryViewModel watchHistoryViewModel = this.f10141;
        if (!(watchHistoryViewModel == null || (r0 = watchHistoryViewModel.m1965()) == null)) {
            r0.observe(activity, this.f10140);
        }
        return layoutInflater.inflate(R.layout.fragment_watch_history_primary, viewGroup, false);
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        m10713(view);
        af_();
        m10714();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        MutableLiveData<List<CH>> r0;
        super.onDestroyView();
        NetflixApplication.getInstance().unregisterReceiver(this.f10142);
        WatchHistoryViewModel watchHistoryViewModel = this.f10141;
        if (!(watchHistoryViewModel == null || (r0 = watchHistoryViewModel.m1965()) == null)) {
            r0.removeObserver(this.f10140);
        }
        this.f10141 = null;
        m10726();
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m10713(View view) {
        this.f10148 = new C0616(view, this.f10147);
        RecyclerView recyclerView = (RecyclerView) m10717(R.Cif.recycler_view);
        this.f10139 = new LinearLayoutManager(recyclerView != null ? recyclerView.getContext() : null);
        RecyclerView recyclerView2 = (RecyclerView) m10717(R.Cif.recycler_view);
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(this.f10139);
        }
    }

    @Override // o.AbstractC0517
    public boolean af_() {
        NetflixActivity r4 = m14534();
        if (r4 == null) {
            return false;
        }
        NetflixActionBar netflixActionBar = r4.getNetflixActionBar();
        if (netflixActionBar == null) {
            return true;
        }
        netflixActionBar.m355(r4.getActionBarStateBuilder().mo399(false).mo394((CharSequence) C2149si.f10161.m10733(r4)).mo392());
        return true;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final void m10714() {
        NetflixApplication.getInstance().registerReceiver(this.f10142, new IntentFilter("com.netflix.mediaclient.intent.action.BA_WH_REFRESH"));
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        C1457Fr.m5025(phVar, "manager");
        C1457Fr.m5025(status, "res");
        super.onManagerReady(phVar, status);
        C1283.m16846(this.f10143, "onManagerReady");
        if (status.mo301()) {
            C1283.m16865(this.f10143, "Manager status code not okay");
        } else {
            m10721();
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public final void m10721() {
        oF r0;
        C0616 r02;
        C1283.m16846(this.f10143, "Fetching watch history videos");
        if (this.f10146 == 0 && (r02 = this.f10148) != null) {
            r02.mo14570(true);
        }
        C2059ph r03 = m14536();
        if (!(r03 == null || (r0 = r03.m9764()) == null)) {
            r0.mo9499(this.f10146, new Cif(this, this.f10143, null, 2, null));
        }
        this.f10146 += 30;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m10711(List<? extends CH> list) {
        C1283.m16854(this.f10143, "Received list of watch history videos");
        RecyclerView recyclerView = (RecyclerView) m10717(R.Cif.recycler_view);
        if ((recyclerView != null ? recyclerView.getAdapter() : null) == null) {
            C2152sk skVar = new C2152sk(new C0199(this));
            RecyclerView recyclerView2 = (RecyclerView) m10717(R.Cif.recycler_view);
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(skVar);
            }
            skVar.m10749(list);
        } else {
            RecyclerView recyclerView3 = (RecyclerView) m10717(R.Cif.recycler_view);
            if ((recyclerView3 != null ? recyclerView3.getAdapter() : null) instanceof C2152sk) {
                RecyclerView recyclerView4 = (RecyclerView) m10717(R.Cif.recycler_view);
                RecyclerView.Adapter adapter = recyclerView4 != null ? recyclerView4.getAdapter() : null;
                if (adapter == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.history.WatchHistoryAdapter");
                }
                ((C2152sk) adapter).m10749(list);
            }
        }
        mo9990(AbstractC0367.f13235);
    }

    /* renamed from: o.sg$ˋ  reason: contains not printable characters */
    public static final class C0199 implements C2152sk.AbstractC0206 {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C2145sg f10157;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0199(C2145sg sgVar) {
            this.f10157 = sgVar;
        }

        @Override // o.C2152sk.AbstractC0206
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo10729(int i) {
            CH r6 = m10730(i);
            if (r6 == null || !r6.isAvailableToStream()) {
                FragmentActivity activity = this.f10157.getActivity();
                Toast.makeText(activity != null ? activity.getApplicationContext() : null, (int) R.string.label_watch_history_removed_content, 1).show();
            } else if (r6 instanceof C1383Cz) {
                NetflixActivity r0 = this.f10157.m14534();
                VideoType videoType = VideoType.SHOW;
                Episode.Detail detail = ((C1383Cz) r6).f5242;
                C1457Fr.m5016((Object) detail, "video.episodeDetail");
                qU.m9966(r0, videoType, detail.getShowId(), "", qN.f9507, "WatchHistoryClickListener");
            } else {
                qU.m9974(this.f10157.m14534(), m10730(i), qN.f9507, "WatchHistoryClickListener");
            }
        }

        @Override // o.C2152sk.AbstractC0206
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo10728(int i) {
            this.f10157.m10722(m10730(i));
        }

        @Override // o.C2152sk.AbstractC0206
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo10731() {
            this.f10157.m10721();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final CH m10730(int i) {
            RecyclerView recyclerView = (RecyclerView) this.f10157.m10717(R.Cif.recycler_view);
            if (!((recyclerView != null ? recyclerView.getAdapter() : null) instanceof C2152sk)) {
                return null;
            }
            RecyclerView recyclerView2 = (RecyclerView) this.f10157.m10717(R.Cif.recycler_view);
            RecyclerView.Adapter adapter = recyclerView2 != null ? recyclerView2.getAdapter() : null;
            if (adapter == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.history.WatchHistoryAdapter");
            }
            List<CH> r0 = ((C2152sk) adapter).m10745();
            if (r0 != null) {
                return (CH) EI.m4834((List<? extends Object>) r0, i);
            }
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m10722(CH ch) {
        int i;
        CharSequence charSequence;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            C1283.m16846(this.f10143, "Showing watch history deletion Dialog");
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            CharSequence r8 = BX.m3953(C0403.m14185(activity, R.string.label_watch_history_hide_dialog_title).m14186("section", C2149si.f10161.m10733(activity)).m14188());
            C1457Fr.m5016((Object) r8, "LocalizationUtils.forceL…               .format())");
            if (ch instanceof C1383Cz) {
                C0403 r0 = C0403.m14185(activity, R.string.label_watch_history_hide_dialog_show_text);
                Episode.Detail detail = ((C1383Cz) ch).f5242;
                C1457Fr.m5016((Object) detail, "video.episodeDetail");
                C0403 r02 = r0.m14186("title", detail.getShowTitle());
                C2149si siVar = C2149si.f10161;
                C1457Fr.m5016((Object) activity, "activity");
                charSequence = BX.m3953(r02.m14186(PostPlayItem.POST_PLAY_ITEM_EPISODE, siVar.m10732(activity, (C1383Cz) ch)).m14188());
                C1457Fr.m5016((Object) charSequence, "LocalizationUtils.forceL…               .format())");
                i = R.string.label_watch_history_hide_dialog_show_remove_series;
                builder.setNegativeButton(R.string.label_watch_history_hide_dialog_show_remove_episode, new DialogInterface$OnClickListenerC0201(this, ch));
            } else {
                charSequence = BX.m3953(C0403.m14185(activity, R.string.label_watch_history_hide_dialog_movie_text).m14186("title", ch != null ? ch.getTitle() : null).m14188());
                C1457Fr.m5016((Object) charSequence, "LocalizationUtils.forceL…, video?.title).format())");
                i = R.string.label_watch_history_hide_dialog_movie_remove;
            }
            this.f10144 = Logger.INSTANCE.m142(new C1080(AppView.hideWatchedDialog, C1300Ac.m3528(ch)));
            builder.setTitle(C1349Bv.m4102(r8.toString())).setMessage(C1349Bv.m4102(charSequence.toString())).setPositiveButton(i, new aux(this, ch)).setNeutralButton(R.string.label_cancel, DialogInterface$OnClickListenerC0200.f10158);
            builder.create().show();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.sg$ᐝ  reason: contains not printable characters */
    public static final class DialogInterface$OnClickListenerC0201 implements DialogInterface.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2145sg f10159;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ CH f10160;

        DialogInterface$OnClickListenerC0201(C2145sg sgVar, CH ch) {
            this.f10159 = sgVar;
            this.f10160 = ch;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            oF r0;
            C0616 r02 = this.f10159.m10725();
            if (r02 != null) {
                r02.mo14570(true);
            }
            Long r6 = Logger.INSTANCE.m142(new C0701());
            NetflixActivity r03 = this.f10159.m14534();
            C1457Fr.m5016((Object) r03, "netflixActivity");
            C1362Ch.m4381(null, r03.getUiScreen().f4084);
            C2059ph r04 = this.f10159.m14536();
            if (!(r04 == null || (r0 = r04.m9764()) == null)) {
                Video.Summary summary = ((C1383Cz) this.f10160).getSummary();
                VideoType type = summary != null ? summary.getType() : null;
                Video.Summary summary2 = ((C1383Cz) this.f10160).getSummary();
                r0.mo9490(type, summary2 != null ? summary2.id : null, false, (oU) new Cif(this.f10159, this.f10159.m10718(), r6));
            }
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.sg$aux */
    public static final class aux implements DialogInterface.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2145sg f10151;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ CH f10152;

        aux(C2145sg sgVar, CH ch) {
            this.f10151 = sgVar;
            this.f10152 = ch;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            oF r0;
            Video.Summary summary;
            Video.Summary summary2;
            boolean z = this.f10152 instanceof C1383Cz;
            C0616 r02 = this.f10151.m10725();
            if (r02 != null) {
                r02.mo14570(true);
            }
            Long r7 = Logger.INSTANCE.m142(new C0701());
            NetflixActivity r03 = this.f10151.m14534();
            C1457Fr.m5016((Object) r03, "netflixActivity");
            C1362Ch.m4381(null, r03.getUiScreen().f4084);
            C2059ph r04 = this.f10151.m14536();
            if (!(r04 == null || (r0 = r04.m9764()) == null)) {
                CH ch = this.f10152;
                VideoType type = (ch == null || (summary2 = ch.getSummary()) == null) ? null : summary2.getType();
                CH ch2 = this.f10152;
                r0.mo9490(type, (ch2 == null || (summary = ch2.getSummary()) == null) ? null : summary.id, z, new Cif(this.f10151, this.f10151.m10718(), r7));
            }
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.sg$ˎ  reason: contains not printable characters */
    public static final class DialogInterface$OnClickListenerC0200 implements DialogInterface.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        public static final DialogInterface$OnClickListenerC0200 f10158 = new DialogInterface$OnClickListenerC0200();

        DialogInterface$OnClickListenerC0200() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m10723(boolean z) {
        if (!isDetached()) {
            C0616 r0 = this.f10148;
            if (r0 != null) {
                r0.mo14663(true);
            }
            if (z) {
                C0601 r02 = (C0601) m10717(R.Cif.empty_state_view);
                if (r02 != null) {
                    r02.setIconDrawable(R.drawable.ic_emptygraphic_mylist);
                }
                C0601 r03 = (C0601) m10717(R.Cif.empty_state_view);
                if (r03 != null) {
                    r03.setMessageText(getString(R.string.label_watch_history_empty_message));
                }
                C0601 r04 = (C0601) m10717(R.Cif.empty_state_view);
                if (r04 != null) {
                    r04.setButtonText(getString(R.string.label_watch_history_empty_button));
                }
                C0601 r05 = (C0601) m10717(R.Cif.empty_state_view);
                if (r05 != null) {
                    r05.setButtonClickListener(new IF(this));
                }
            } else {
                BQ.m3911((RecyclerView) m10717(R.Cif.recycler_view), true);
            }
            C0601 r06 = (C0601) m10717(R.Cif.empty_state_view);
            if (r06 != null) {
                r06.setVisibility(z ? 0 : 8);
            }
            RecyclerView recyclerView = (RecyclerView) m10717(R.Cif.recycler_view);
            if (recyclerView != null) {
                recyclerView.setVisibility(z ? 8 : 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.sg$IF */
    public static final class IF implements View.OnClickListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2145sg f10149;

        IF(C2145sg sgVar) {
            this.f10149 = sgVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.f10149.isDetached()) {
                this.f10149.startActivity(ActivityC2153sl.m10779(this.f10149.m14534()));
            }
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final void m10715() {
        C1283.m16846(this.f10143, "Showing error view");
        this.f10146 = 0;
        BQ.m3909((RecyclerView) m10717(R.Cif.recycler_view), true);
        C0754 r0 = (C0754) m10717(R.Cif.error_view_all_downloads_button);
        C1457Fr.m5016((Object) r0, "error_view_all_downloads_button");
        r0.setText(getString(R.string.my_list_empty_button));
        C0616 r02 = this.f10148;
        if (r02 != null) {
            r02.mo14660(true);
        }
    }

    /* renamed from: o.sg$if  reason: invalid class name */
    public final class Cif extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private Long f10154;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2145sg f10155;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(C2145sg sgVar, String str, Long l) {
            super(str);
            C1457Fr.m5025(str, "logTag");
            this.f10155 = sgVar;
            this.f10154 = l;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Cif(C2145sg sgVar, String str, Long l, int i, C1456Fq fq) {
            this(sgVar, str, (i & 2) != 0 ? null : l);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
        @Override // o.oP, o.oU
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWatchHistoryVideosFetched(java.util.List<? extends o.CH> r6, com.netflix.mediaclient.android.app.Status r7) {
            /*
                r5 = this;
                super.onWatchHistoryVideosFetched(r6, r7)
                o.sg r0 = r5.f10155
                boolean r0 = r0.isDetached()
                if (r0 == 0) goto L_0x000c
                return
            L_0x000c:
                if (r7 == 0) goto L_0x0016
                boolean r0 = r7.mo301()
                r1 = 1
                if (r0 != r1) goto L_0x001d
                goto L_0x0017
            L_0x0016:
                goto L_0x001d
            L_0x0017:
                o.sg r0 = r5.f10155
                r0.m10715()
                return
            L_0x001d:
                if (r6 == 0) goto L_0x002f
                r4 = r6
                java.util.Collection r4 = (java.util.Collection) r4
                boolean r0 = r4.isEmpty()
                if (r0 != 0) goto L_0x002a
                r0 = 1
                goto L_0x002b
            L_0x002a:
                r0 = 0
            L_0x002b:
                if (r0 == 0) goto L_0x002f
                r3 = 1
                goto L_0x0030
            L_0x002f:
                r3 = 0
            L_0x0030:
                o.sg r0 = r5.f10155
                if (r3 != 0) goto L_0x0040
                o.sg r1 = r5.f10155
                int r1 = r1.m10716()
                r2 = 30
                if (r1 != r2) goto L_0x0040
                r1 = 1
                goto L_0x0041
            L_0x0040:
                r1 = 0
            L_0x0041:
                r0.m10723(r1)
                if (r3 == 0) goto L_0x006a
                o.sg r0 = r5.f10155
                int r0 = r0.m10716()
                r1 = 30
                if (r0 > r1) goto L_0x005d
                o.sg r0 = r5.f10155
                com.netflix.mediaclient.ui.history.WatchHistoryViewModel r0 = r0.m10724()
                if (r0 == 0) goto L_0x005c
                r0.m1966(r6)
            L_0x005c:
                goto L_0x0069
            L_0x005d:
                o.sg r0 = r5.f10155
                com.netflix.mediaclient.ui.history.WatchHistoryViewModel r0 = r0.m10724()
                if (r0 == 0) goto L_0x0069
                r0.m1967(r6)
            L_0x0069:
                goto L_0x00a2
            L_0x006a:
                o.sg r0 = r5.f10155
                int r1 = com.netflix.mediaclient.R.Cif.recycler_view
                android.view.View r0 = r0.m10717(r1)
                android.support.v7.widget.RecyclerView r0 = (android.support.v7.widget.RecyclerView) r0
                if (r0 == 0) goto L_0x007b
                android.support.v7.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                goto L_0x007c
            L_0x007b:
                r0 = 0
            L_0x007c:
                boolean r0 = r0 instanceof o.C2152sk
                if (r0 == 0) goto L_0x00a2
                o.sg r0 = r5.f10155
                int r1 = com.netflix.mediaclient.R.Cif.recycler_view
                android.view.View r0 = r0.m10717(r1)
                android.support.v7.widget.RecyclerView r0 = (android.support.v7.widget.RecyclerView) r0
                if (r0 == 0) goto L_0x0091
                android.support.v7.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                goto L_0x0092
            L_0x0091:
                r0 = 0
            L_0x0092:
                if (r0 != 0) goto L_0x009c
                kotlin.TypeCastException r1 = new kotlin.TypeCastException
                java.lang.String r2 = "null cannot be cast to non-null type com.netflix.mediaclient.ui.history.WatchHistoryAdapter"
                r1.<init>(r2)
                throw r1
            L_0x009c:
                o.sk r0 = (o.C2152sk) r0
                r1 = 0
                r0.m10750(r1)
            L_0x00a2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o.C2145sg.Cif.onWatchHistoryVideosFetched(java.util.List, com.netflix.mediaclient.android.app.Status):void");
        }

        @Override // o.oP, o.oU
        public void onVideoHide(Status status) {
            oF r0;
            super.onVideoHide(status);
            if (status == null || !status.mo301()) {
                Logger.INSTANCE.m140(this.f10154);
                C1362Ch.m4391(IClientLogging.CompletionReason.success, (UIError) null);
            } else {
                Logger.INSTANCE.m145(this.f10154, C1300Ac.m3532(status));
                C1362Ch.m4391(IClientLogging.CompletionReason.failed, AbstractC1358Cd.m4353(status, NetflixApplication.getInstance().getString(R.string.label_watch_history_hide_failed), ActionOnUIError.displayedError));
            }
            Logger.INSTANCE.m140(this.f10155.m10720());
            if (!this.f10155.isDetached()) {
                if (status == null || !status.mo301()) {
                    C1283.m16846(this.f10155.m10718(), "Deleted video in history successful callback to the WatchHistoryFragment");
                    this.f10155.m10719(0);
                    RecyclerView recyclerView = (RecyclerView) this.f10155.m10717(R.Cif.recycler_view);
                    if ((recyclerView != null ? recyclerView.getAdapter() : null) instanceof C2152sk) {
                        RecyclerView recyclerView2 = (RecyclerView) this.f10155.m10717(R.Cif.recycler_view);
                        RecyclerView.Adapter adapter = recyclerView2 != null ? recyclerView2.getAdapter() : null;
                        if (adapter == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.history.WatchHistoryAdapter");
                        }
                        ((C2152sk) adapter).m10750(true);
                    }
                    C2059ph r02 = this.f10155.m14536();
                    if (!(r02 == null || (r0 = r02.m9764()) == null)) {
                        r0.mo9464();
                    }
                    C2059ph.m9742(this.f10155.getActivity(), (String) null);
                    return;
                }
                this.f10155.m10715();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        C1457Fr.m5025(view, "view");
        RecyclerView recyclerView = (RecyclerView) m10717(R.Cif.recycler_view);
        if (recyclerView != null) {
            recyclerView.setPadding(recyclerView.getPaddingLeft(), this.f13651 + this.f13649, recyclerView.getPaddingRight(), this.f13650);
        }
        C0601 r4 = (C0601) m10717(R.Cif.empty_state_view);
        if (r4 != null) {
            r4.setPadding(r4.getPaddingLeft(), this.f13651 + this.f13649, r4.getPaddingRight(), this.f13650);
        }
    }
}
