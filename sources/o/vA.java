package o;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.C0816;
public class vA extends AbstractC2068pq {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final List<String> f11065 = new ArrayList();

    /* renamed from: ʻ  reason: contains not printable characters */
    private final View.OnClickListener f11066 = new View.OnClickListener() { // from class: o.vA.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(view.getContext(), NetflixActivity.class);
            if (!C1317As.m3750(netflixActivity)) {
                AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(netflixActivity);
                if (offlineAgentOrNull != null && vO.m12029(offlineAgentOrNull).mo11974() == 0) {
                    C1283.m16862("ActivityPageOfflineAgentListener", "launchMyDownloads dismissing");
                    vA.this.m11809();
                }
                netflixActivity.startActivity(vH.m11936(netflixActivity));
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final ViewGroup f11067;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Drawable f11068;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean f11069;

    /* renamed from: ॱ  reason: contains not printable characters */
    private vJ f11070;

    public vA(ViewGroup viewGroup, boolean z) {
        this.f11069 = z;
        this.f11067 = viewGroup;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11813() {
        m11800(false, false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11800(boolean z, boolean z2) {
        AbstractC1853hl r4;
        NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(this.f11067.getContext(), NetflixActivity.class);
        if (netflixActivity != null && netflixActivity.canShowDownloadProgressBar() && this.f11069 && (r4 = netflixActivity.getServiceManager().m9832()) != null) {
            if (!vO.m12018(this.f11067.getContext()) || this.f11070 != null) {
                pX r5 = m11805(r4);
                if (r5 != null) {
                    m11807(z, r5);
                    if (r5.f9370) {
                        f11065.clear();
                    }
                    if (this.f11070 != null) {
                        if (!z2) {
                            this.f11070.m11958();
                        }
                        this.f11070.m11960(m11801(), r5.f9372);
                        return;
                    }
                    return;
                }
                C1283.m16862("ActivityPageOfflineAgentListener", "no message, dismiss snack-bar");
                m11809();
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private pX m11805(AbstractC1853hl hlVar) {
        try {
            return vO.m12029(hlVar).mo11973(this.f11067.getContext(), hlVar);
        } catch (IllegalIcuArgumentException e) {
            C1283.m16862("ActivityPageOfflineAgentListener", "Bad message, dismiss snack-bar and logging exception");
            C1276.m16820().mo5730(e);
            m11809();
            return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11807(boolean z, pX pXVar) {
        this.f11070 = m11799(pXVar.f9371, (!pXVar.f9370 || pXVar.f9373 <= 0) ? R.color.download_snackbar_bg : R.color.download_snackbar_error_bg);
        if (this.f11070 != null) {
            this.f11070.m15413(Typeface.createFromAsset(this.f11067.getContext().getAssets(), "nf-icon.otf"));
            this.f11070.m15408(this.f11067.getLayoutDirection() == 1 ? R.string.icon_left_arrow : R.string.icon_right_arrow, this.f11066);
            if (!this.f11070.m15402()) {
                this.f11070.m15410(z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11809() {
        if (this.f11070 != null) {
            this.f11070.m15405();
            this.f11070 = null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private vJ m11799(String str, int i) {
        final NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(this.f11067.getContext(), NetflixActivity.class);
        if (netflixActivity == null || C1317As.m3750(netflixActivity) || (netflixActivity instanceof ActivityC2280wv)) {
            C1283.m16851("ActivityPageOfflineAgentListener", "No buffetBar to display as activity is finishing (or in PlayerActivity). Current activity is %s", netflixActivity);
            return null;
        } else if (netflixActivity.isCastPlayerShowing()) {
            C1283.m16854("ActivityPageOfflineAgentListener", "No buffetBar while MDX mini player display");
            return null;
        } else {
            final View findViewById = netflixActivity.findViewById(R.id.coordinatorLayout);
            if (findViewById instanceof CoordinatorLayout) {
                int color = ContextCompat.getColor(this.f11067.getContext(), i);
                CharSequence r7 = m11810(str);
                if (this.f11070 == null) {
                    this.f11070 = vJ.m11956(findViewById, r7, color, netflixActivity.hasBottomNavBar() ? netflixActivity.getResources().getDimensionPixelSize(R.dimen.bottom_navigation_height) : 0, -2);
                }
                if (this.f11070 == null) {
                    return null;
                }
                this.f11070.m15403(r7).m15397(color);
                this.f11070.m11960(m11801(), true);
                this.f11070.m15401(new C0816.AbstractC0819() { // from class: o.vA.1
                    @Override // o.C0816.AbstractC0819
                    /* renamed from: ˋ  reason: contains not printable characters */
                    public void mo11815(C0816 r3, int i2) {
                        if (!C1317As.m3750(netflixActivity)) {
                            if ((i2 == 1 && vA.this.m11801() == 100) || i2 == 0) {
                                vA.this.m11802(netflixActivity);
                            }
                            vA.this.f11070 = null;
                        }
                    }

                    @Override // o.C0816.AbstractC0819
                    /* renamed from: ˋ  reason: contains not printable characters */
                    public View mo11814() {
                        return findViewById.findViewById(R.id.layout_content);
                    }

                    @Override // o.C0816.AbstractC0819
                    /* renamed from: ॱ  reason: contains not printable characters */
                    public View mo11817() {
                        return findViewById.findViewById(R.id.fragment_host_container);
                    }

                    @Override // o.C0816.AbstractC0819
                    /* renamed from: ˏ  reason: contains not printable characters */
                    public boolean mo11816() {
                        return AD.m3292();
                    }
                });
                return this.f11070;
            }
            String str2 = "SPY-10658 : No suitable parent found to attach buffetBar, current activity is " + netflixActivity;
            C1283.m16854("ActivityPageOfflineAgentListener", str2);
            C1276.m16820().mo5725(str2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11802(NetflixActivity netflixActivity) {
        vO.m12026(netflixActivity, true);
        vO.m12021(netflixActivity);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private CharSequence m11810(String str) {
        SpannableString spannableString = new SpannableString(C1349Bv.m4102(str));
        if (spannableString.toString().contains("💥")) {
            if (this.f11068 == null) {
                this.f11068 = DrawableCompat.wrap(ContextCompat.getDrawable(this.f11067.getContext(), R.drawable.ic_download_error).mutate());
                DrawableCompat.setTint(this.f11068, -1);
                int dimensionPixelSize = this.f11067.getResources().getDimensionPixelSize(R.dimen.offline_snackbar_icon_size);
                this.f11068.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            }
            ImageSpan imageSpan = new ImageSpan(this.f11068, 1);
            int indexOf = spannableString.toString().indexOf("💥");
            spannableString.setSpan(imageSpan, indexOf, "💥".length() + indexOf, 17);
        }
        return spannableString;
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˊ */
    public void mo2173(String str) {
        AbstractC1853hl offlineAgentOrNull;
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(this.f11067.getContext(), NetflixActivity.class);
        if (netflixActivity != null && netflixActivity.canShowDownloadProgressBar() && (offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(netflixActivity)) != null) {
            pX r4 = m11805(offlineAgentOrNull);
            if (r4 == null || vO.m12018(netflixActivity)) {
                r4 = new pX(C0403.m14185(this.f11067.getContext(), R.string.offline_snackbar_downloading_multiple).m14187(1).m14188(), 0);
            }
            if (!f11065.contains(str)) {
                f11065.add(str);
            }
            if (this.f11070 == null || !this.f11070.m15402()) {
                m11807(true, r4);
            }
            if (this.f11070 != null) {
                this.f11070.m15403(m11810(r4.f9371));
                this.f11070.m11962();
            }
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2185(String str, Status status) {
        if (this.f11067 != null) {
            DownloadButton downloadButton = (DownloadButton) this.f11067.findViewWithTag("download_btn" + str);
            if (downloadButton != null) {
                downloadButton.m2168(status.mo298() ? DownloadButton.ButtonState.QUEUED : DownloadButton.ButtonState.ERROR, str);
                downloadButton.setEnabled(true);
            }
            vO.m12026(this.f11067.getContext(), false);
            m11800(true, true);
            if (!status.mo298()) {
                m11813();
                if (downloadButton == null) {
                    return;
                }
                if (status.mo302() == StatusCode.DL_NOT_ENOUGH_FREE_SPACE) {
                    downloadButton.m2165();
                } else if (status.mo302() == StatusCode.DL_TITTLE_ALREADY_REQUESTED_FOR_DOWNLOAD) {
                    vD.m11890(this.f11067.getContext()).show();
                }
            } else if (status.mo297() && downloadButton != null) {
                downloadButton.m2168(DownloadButton.ButtonState.ERROR, str);
            }
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2181(pV pVVar, int i) {
        if (this.f11067 != null) {
            DownloadButton downloadButton = (DownloadButton) this.f11067.findViewWithTag("download_btn" + pVVar.mo6915());
            if (downloadButton != null) {
                if (pVVar.mo6881() == DownloadState.Complete) {
                    downloadButton.m2168(DownloadButton.ButtonState.SAVED, pVVar.mo6915());
                } else {
                    downloadButton.m2168(DownloadButton.ButtonState.DOWNLOADING, pVVar.mo6915());
                    downloadButton.setProgress(i);
                }
            }
            m11800(false, true);
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˊ */
    public void mo2174(pV pVVar) {
        if (this.f11067 != null) {
            vO.m12024(this.f11067.getContext());
            DownloadButton downloadButton = (DownloadButton) this.f11067.findViewWithTag("download_btn" + pVVar.mo6915());
            if (downloadButton != null) {
                downloadButton.m2168(DownloadButton.ButtonState.SAVED, pVVar.mo6915());
            }
            vO.m12026(this.f11067.getContext(), false);
            if (C2093qn.m10096(pVVar.mo6915()) != null) {
                m11800(true, false);
            }
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2175(pV pVVar) {
        if (this.f11067 != null) {
            vO.m12026(this.f11067.getContext(), false);
            m11800(true, true);
            if (this.f11070 != null) {
                this.f11070.m11963();
            }
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2177(pV pVVar, StopReason stopReason) {
        if (this.f11067 != null) {
            DownloadButton downloadButton = (DownloadButton) this.f11067.findViewWithTag("download_btn" + pVVar.mo6915());
            if (downloadButton != null) {
                if (stopReason.m1581()) {
                    downloadButton.m2168(DownloadButton.ButtonState.ERROR, pVVar.mo6915());
                } else if (stopReason != StopReason.WaitingToBeStarted) {
                    downloadButton.m2168(DownloadButton.ButtonState.PAUSED, pVVar.mo6915());
                }
            }
            vO.m12026(this.f11067.getContext(), false);
            m11800(true, true);
            if (this.f11070 != null) {
                this.f11070.m11961();
                this.f11070.m11959();
            }
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2180(String str, Status status, boolean z) {
        if (this.f11067 != null) {
            f11065.remove(str);
            DownloadButton downloadButton = (DownloadButton) this.f11067.findViewWithTag("download_btn" + str);
            if (downloadButton != null) {
                downloadButton.m2168(z ? DownloadButton.ButtonState.QUEUED : DownloadButton.ButtonState.AVAILABLE, str);
            }
            DownloadButton.m2159(str);
            if (!z) {
                m11800(true, false);
            }
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˎ */
    public void mo2178(List<String> list, Status status) {
        if (this.f11067 != null) {
            for (String str : list) {
                f11065.remove(str);
                DownloadButton downloadButton = (DownloadButton) this.f11067.findViewWithTag("download_btn" + str);
                if (downloadButton != null) {
                    downloadButton.m2168(DownloadButton.ButtonState.AVAILABLE, str);
                    DownloadButton.m2159(str);
                }
            }
            m11800(true, false);
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo1758(Status status) {
        if (this.f11067 != null) {
            f11065.clear();
            vO.m12021(this.f11067.getContext());
            ArrayList<View> arrayList = new ArrayList<>();
            this.f11067.findViewsWithText(arrayList, "download_btn", 2);
            DownloadButton.m2156();
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next instanceof DownloadButton) {
                    ((DownloadButton) next).m2168(DownloadButton.ButtonState.AVAILABLE, ((DownloadButton) next).m2166());
                }
            }
            m11800(true, false);
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2184(Status status) {
        if (this.f11067 != null) {
            switch (status.mo302()) {
                case DL_OFFLINE_STORAGE_NOT_AVAILABLE:
                case DL_NOT_ENOUGH_FREE_SPACE:
                    vD.m11888(this.f11067.getContext(), true).show();
                    break;
                case DL_URL_DOWNLOAD_DISK_IO_ERROR:
                case DL_CANT_CREATE_VIEWABLE_DIRECTORY:
                    vD.m11891(this.f11067.getContext(), "(" + status.mo302().m271() + ")").show();
                    break;
                default:
                    vO.m12026(this.f11067.getContext(), false);
                    m11800(true, false);
                    break;
            }
            if (this.f11070 != null) {
                this.f11070.m11958();
                this.f11070.m11961();
            }
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2176(pV pVVar, Status status) {
        m11803(pVVar.mo6915(), status);
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˎ */
    public void mo2179(pV pVVar, Status status) {
        m11803(pVVar.mo6915(), status);
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2182(boolean z) {
        if (this.f11067 != null) {
            NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(this.f11067.getContext(), NetflixActivity.class);
            if (!C1317As.m3750(netflixActivity)) {
                C1004.m15958(netflixActivity, (int) R.string.offline_message_offline_storage_change_in_progress, 1);
                if (netflixActivity instanceof DetailsActivity) {
                    LocalBroadcastManager.getInstance(netflixActivity).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.DETAIL_PAGE_REFRESH"));
                }
            }
        }
    }

    @Override // o.AbstractC1854hm
    public boolean aa_() {
        if (this.f11067 == null) {
            return true;
        }
        return C1317As.m3750((NetflixActivity) C1317As.m3755(this.f11067.getContext(), NetflixActivity.class));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11803(String str, Status status) {
        DownloadButton downloadButton;
        if (this.f11067 != null && (downloadButton = (DownloadButton) this.f11067.findViewWithTag("download_btn" + str)) != null) {
            downloadButton.m2168(status.mo298() ? DownloadButton.ButtonState.SAVED : DownloadButton.ButtonState.ERROR, str);
            downloadButton.setEnabled(true);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11812(NetflixActivity netflixActivity, String str) {
        DownloadButton downloadButton;
        if (this.f11067 != null && (downloadButton = (DownloadButton) this.f11067.findViewWithTag("download_btn" + str)) != null) {
            downloadButton.m2164(str, netflixActivity);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private int m11801() {
        long j = 0;
        long j2 = 0;
        AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull((NetflixActivity) C1317As.m3755(this.f11067.getContext(), NetflixActivity.class));
        if (offlineAgentOrNull == null) {
            return 0;
        }
        int i = 0;
        for (pV pVVar : vO.m12029(offlineAgentOrNull).mo11971()) {
            if (f11065.contains(pVVar.mo6915())) {
                i++;
                j += pVVar.mo6914();
                j2 += pVVar.mo6887();
            }
        }
        if (i <= 0 || j2 <= 0) {
            return 100;
        }
        return (int) ((100 * j) / j2);
    }
}
