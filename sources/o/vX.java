package o;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.offline.OfflineAdapterData;
import com.netflix.model.leafs.PostPlayItem;
import java.util.HashMap;
public final class vX extends vV {

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private HashMap f11276;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private oX f11277;

    @Override // o.vV, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo12067();
    }

    @Override // o.vV
    /* renamed from: ˊॱ */
    public void mo12067() {
        if (this.f11276 != null) {
            this.f11276.clear();
        }
    }

    @Override // o.vV
    /* renamed from: ॱ */
    public View mo12071(int i) {
        if (this.f11276 == null) {
            this.f11276 = new HashMap();
        }
        View view = (View) this.f11276.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f11276.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // o.vV, o.AbstractC0496, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f11277 = arguments != null ? (oX) arguments.getParcelable("play_context") : null;
        m12089();
    }

    @Override // o.vV, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final void m12089() {
        String string = getString(R.string.plan_upgrade_confirm_to_download_now);
        String r3 = C0403.m14185(m14476(), R.string.plan_upgrade_x_download_devices).m14187(m12065().m2383()).m14188();
        String string2 = getString(R.string.plan_upgrade_and_download);
        C1457Fr.m5016((Object) string, "messageConfirmText");
        C1457Fr.m5016((Object) r3, "planScreensText");
        C1457Fr.m5016((Object) string2, "upgradeButtonText");
        m12072(string, r3, string2);
    }

    @Override // o.vV
    /* renamed from: ʻ */
    public void mo12064() {
        AbstractC1853hl r0;
        AbstractC1853hl r02;
        if (this.f11277 != null) {
            vM r4 = m12087();
            if (r4 != null) {
                int r7 = r4.mo4074();
                for (int i = 0; i < r7; i++) {
                    OfflineAdapterData offlineAdapterData = (OfflineAdapterData) r4.mo4075(i);
                    C1457Fr.m5016((Object) offlineAdapterData, "offlineAdapterData");
                    if (C1457Fr.m5018(offlineAdapterData.m2192().f3356, OfflineAdapterData.ViewType.MOVIE)) {
                        C2098qr qrVar = offlineAdapterData.m2192().f3357;
                        C1457Fr.m5016((Object) qrVar, "offlineAdapterData.videoAndProfileData.video");
                        String id = qrVar.getId();
                        pV r03 = r4.mo11976(id);
                        if (m12088(r03 != null ? r03.mo6885() : null) && (r02 = m12090()) != null) {
                            VideoType videoType = VideoType.MOVIE;
                            oX oXVar = this.f11277;
                            if (oXVar == null) {
                                C1457Fr.m5019();
                            }
                            r02.mo7121(id, videoType, oXVar);
                        }
                    } else {
                        C2098qr[] r04 = offlineAdapterData.m2190();
                        C1457Fr.m5016((Object) r04, "offlineAdapterData.episodes");
                        C2098qr[] qrVarArr = r04;
                        for (C2098qr qrVar2 : qrVarArr) {
                            C1457Fr.m5016((Object) qrVar2, PostPlayItem.POST_PLAY_ITEM_EPISODE);
                            pV r05 = r4.mo11976(qrVar2.getId());
                            if (m12088(r05 != null ? r05.mo6885() : null) && (r0 = m12090()) != null) {
                                String id2 = qrVar2.getId();
                                VideoType videoType2 = VideoType.EPISODE;
                                oX oXVar2 = this.f11277;
                                if (oXVar2 == null) {
                                    C1457Fr.m5019();
                                }
                                r0.mo7121(id2, videoType2, oXVar2);
                            }
                        }
                    }
                }
            }
        } else {
            C1276.m16820().mo5725("This dialog in offline mode should not receive any null param as part of SPY-11993.");
        }
        dismiss();
    }

    @Override // o.vV
    /* renamed from: ʽ */
    public void mo12066() {
        dismiss();
    }

    @Override // o.vV
    /* renamed from: ॱॱ */
    public IClientLogging.ModalView mo12074() {
        return IClientLogging.ModalView.planUpgradeGateDownload;
    }

    @Override // o.vV
    /* renamed from: ᐝ */
    public IClientLogging.ModalView mo12075() {
        return IClientLogging.ModalView.planUpgradeConfirmationPromptDownload;
    }

    @Override // o.vV
    /* renamed from: ˋॱ */
    public IClientLogging.ModalView mo12068() {
        return IClientLogging.ModalView.upgradingPlanDownload;
    }

    @Override // o.vV
    /* renamed from: ॱˊ */
    public String mo12073() {
        return "DownloadLimitUpgrade";
    }

    @Override // o.vV
    /* renamed from: ͺ */
    public int mo12070() {
        return R.string.plan_upgrade_download_success;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final AbstractC1853hl m12090() {
        C2059ph r1 = C2059ph.m9741(m14476());
        if (r1 != null) {
            return r1.m9832();
        }
        return null;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final vM m12087() {
        AbstractC1853hl r2;
        C2059ph r1 = C2059ph.m9741(m14476());
        if (r1 == null || (r2 = r1.m9832()) == null) {
            return null;
        }
        return vO.m12029(r2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean m12088(Status status) {
        return C1457Fr.m5018(status != null ? status.mo302() : null, StatusCode.DL_LIMIT_TOO_MANY_DEVICES_PLAN_OPTION);
    }
}
