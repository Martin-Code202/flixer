package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.IMdxSharedState;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import java.util.List;
import o.BJ;
public final class uY extends BroadcastReceiver {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final NetflixActivity f10960;

    public uY(NetflixActivity netflixActivity) {
        this.f10960 = netflixActivity;
        C1283.m16846("nf_mdx", "Receiver created");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public IntentFilter m11675() {
        C1283.m16846("nf_mdx", "Get filter called");
        IntentFilter intentFilter = new IntentFilter("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_READY");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_NOTREADY");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_TARGETLIST");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PIN_VERIFICATION_SHOW");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_PIN_VERIFICATION_NOT_REQUIRED");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_POSTPLAY");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKSTART");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_CAPABILITY");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_ERROR");
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.MDX");
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (this.f10960.isFinishing() || (action = intent.getAction()) == null) {
            return;
        }
        if (!this.f10960.shouldAddCastToMenu()) {
            C1283.m16854("nf_mdx", "Ignore MDX broadcast");
            return;
        }
        this.f10960.mdxStatusUpdatedByMdxReceiver();
        if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_NOTREADY".equals(action)) {
            C1283.m16854("nf_mdx", "MDX is NOT ready, invalidate action bar");
            this.f10960.invalidateOptionsMenu();
        } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_READY".equals(action)) {
            C1283.m16854("nf_mdx", "MDX is ready, invalidate action bar");
            this.f10960.invalidateOptionsMenu();
        } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_TARGETLIST".equals(action)) {
            C1283.m16854("nf_mdx", "MDX is ready, got target list update, invalidate action bar");
            this.f10960.invalidateOptionsMenu();
            this.f10960.updateTargetSelectionDialog();
            this.f10960.setConnectingToTarget(false);
        } else if ("com.netflix.mediaclient.intent.action.PIN_VERIFICATION_SHOW".equals(action)) {
            C1283.m16854("nf_mdx", "MDX PIN show dialog");
            m11670(intent);
        } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_PIN_VERIFICATION_NOT_REQUIRED".equals(action)) {
            C1283.m16854("nf_mdx", "MDX cancel pin dialog - verified on other controller");
            m11673();
        } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_POSTPLAY".equals(action)) {
            m11672(intent, context);
            abortBroadcast();
        } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKSTART".equals(action)) {
            m11669(context);
        } else if (intent.getAction().equals("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE")) {
            IMdxSharedState r4 = this.f10960.getServiceManager().m9811().mo6191();
            if (r4 != null && r4.mo1522() == IMdxSharedState.MdxPlaybackState.Transitioning) {
                m11669(context);
            }
        } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_CAPABILITY".equals(action)) {
            C1283.m16854("nf_mdx", "MDX is connected, invalidate action bar to finish animation");
            this.f10960.setConnectingToTarget(false);
            this.f10960.invalidateOptionsMenu();
            LocalBroadcastManager.getInstance(this.f10960).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.UPDATE_CAPABILITIES_BADGES"));
        } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_ERROR".equals(action)) {
            C1283.m16854("nf_mdx", "MDX is has error");
            this.f10960.setConnectingToTarget(false);
            this.f10960.invalidateOptionsMenu();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11669(Context context) {
        LocalBroadcastManager.getInstance(this.f10960).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_HIDE"));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11672(Intent intent, Context context) {
        String string = intent.getExtras().getString("postplayState");
        if (!C1349Bv.m4113(string)) {
            oT oTVar = new oT(string);
            if (oTVar.m9581()) {
                m11671(oTVar);
            } else if (oTVar.m9580()) {
                m11674(oTVar);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11671(oT oTVar) {
        BJ.C0067 r6;
        oG r5 = this.f10960.getServiceManager().m9811();
        if ((r5 instanceof C1698eK) && (r6 = ((C1698eK) r5).m6174()) != null && r6.f4578 != null) {
            this.f10960.getServiceManager().m9764().mo9484(String.valueOf(r6.f4578), null, new C0231("nf_mdx", this.f10960));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11674(oT oTVar) {
        BJ.C0067 r8;
        if (this.f10960.getServiceManager().m9811() != null && (r8 = this.f10960.getServiceManager().m9811().mo6172()) != null && r8.f4578 != null) {
            this.f10960.getServiceManager().m9764().mo9502(String.valueOf(r8.f4578), r8.m3868(), PlayLocationType.MDX, new Cif("nf_mdx", this.f10960));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uY$ˋ  reason: contains not printable characters */
    public static class C0231 extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean f10963 = false;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final NetflixActivity f10964;

        public C0231(String str, NetflixActivity netflixActivity) {
            super(str);
            this.f10964 = netflixActivity;
        }

        @Override // o.oP, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            super.onEpisodeDetailsFetched(pIVar, status);
            if (status.mo298() && pIVar != null && !this.f10963) {
                Intent intent = new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_NEXT");
                intent.putExtra("id", pIVar.getId());
                LocalBroadcastManager.getInstance(this.f10964).sendBroadcast(intent);
                uL.m11460(this.f10964);
                this.f10963 = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uY$if  reason: invalid class name */
    public static class Cif extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean f10961 = false;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final NetflixActivity f10962;

        public Cif(String str, NetflixActivity netflixActivity) {
            super(str);
            this.f10962 = netflixActivity;
        }

        @Override // o.oP, o.oU
        public void onPostPlayVideosFetched(pO pOVar, Status status) {
            List<pN> postPlayVideos;
            super.onPostPlayVideosFetched(pOVar, status);
            if (!this.f10961 && this.f10962 != null && status.mo298() && pOVar != null && (postPlayVideos = pOVar.getPostPlayVideos()) != null && postPlayVideos.size() > 0) {
                String id = postPlayVideos.get(0).getId();
                if (!TextUtils.isEmpty(id)) {
                    this.f10962.getServiceManager().m9764().mo9484(id, null, new C0231("nf_mdx", this.f10962));
                    this.f10961 = true;
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11673() {
        C1283.m16854("nf_pin", "cancelPin on MDX_ACTION_PIN_VERIFICATION_NOT_REQUIRED");
        C1306Ah.m3615().m3620();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11670(Intent intent) {
        String string = intent.getExtras().getString("uuid");
        C1283.m16854("nf_pin", "verifyPinAndNotify on PIN_VERIFICATION_SHOW");
        C1306Ah.m3615().m3623(this.f10960, true, new PlayVerifierVault(PlayVerifierVault.RequestedBy.MDX.m2951(), string), this.f10960);
    }
}
