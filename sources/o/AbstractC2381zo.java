package o;

import com.netflix.cl.Logger;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.zo  reason: case insensitive filesystem */
public abstract class AbstractC2381zo extends oP {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final pT f12897;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Long f12898;

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract void mo1706(pE pEVar);

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract void mo1707(Status status);

    public AbstractC2381zo(String str, pT pTVar, Long l) {
        super(str);
        this.f12897 = pTVar;
        this.f12898 = l;
    }

    @Override // o.oP, o.oU
    public final void onVideoRatingSet(pE pEVar, Status status) {
        super.onVideoRatingSet(pEVar, status);
        Integer valueOf = Integer.valueOf(this.f12897.getMatchPercentage());
        Boolean valueOf2 = Boolean.valueOf(this.f12897.isNewForPvr());
        if (!status.mo298() || pEVar == null) {
            Logger.INSTANCE.m145(this.f12898, C1300Ac.m3532(status));
            C1362Ch.m4384(IClientLogging.CompletionReason.failed, AbstractC1358Cd.m4353(status, NetflixApplication.getInstance().getString(R.string.label_error_setting_rating), ActionOnUIError.displayedError), null, null, "thumb", valueOf, valueOf2);
            mo1707(status);
            return;
        }
        C1362Ch.m4384(IClientLogging.CompletionReason.success, null, null, Integer.valueOf(pEVar.getUserThumbRating()), "thumb", valueOf, valueOf2);
        Logger.INSTANCE.m140(this.f12898);
        mo1706(pEVar);
    }
}
