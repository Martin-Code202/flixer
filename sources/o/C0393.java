package o;

import android.content.Context;
import android.content.Intent;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.android.AbConfigApiParamsProvider;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.webclient.model.leafs.UserProfile;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.ui.error.ErrorDescriptorFactoryImpl;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.ui.profiles.RestrictedProfilesReceiver;
import java.util.Locale;
/* renamed from: o.ʈ  reason: contains not printable characters */
public class C0393 implements AbstractC0928 {
    @Override // o.AbstractC0928
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo14168() {
        return zK.m13486().m13494();
    }

    @Override // o.AbstractC0928
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo14166(Context context) {
        NetflixActivity.finishAllActivities(context);
    }

    @Override // o.AbstractC0928
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo14176(Context context, Intent intent) {
        C1282.m16841(context, intent);
    }

    @Override // o.AbstractC0928
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo14170(Context context) {
        Intent r1 = ActivityC2194tx.m11258(context);
        r1.addFlags(268435456);
        context.startActivity(r1);
    }

    @Override // o.AbstractC0928
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo14175(Context context) {
        context.startActivity(ActivityC2383zq.m13731(context));
    }

    @Override // o.AbstractC0928
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo14172(Context context) {
        Intent r2 = ActivityC1313Ao.m3712(context);
        r2.putExtra(NetflixActivity.EXTRA_SOURCE, AppView.contactUs.name());
        context.startActivity(r2);
    }

    @Override // o.AbstractC0928
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo14173() {
        return C1306Ah.m3610();
    }

    @Override // o.AbstractC0928
    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1234 mo14174() {
        return AbConfigApiParamsProvider.INSTANCE;
    }

    @Override // o.AbstractC0928
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo14165() {
        DownloadButton.m2156();
    }

    @Override // o.AbstractC0928
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo14167(boolean z, boolean z2) {
        C1306Ah.m3615().m3622(z, z2);
    }

    @Override // o.AbstractC0928
    /* renamed from: ˎ  reason: contains not printable characters */
    public int mo14169(Context context, LoMoType loMoType) {
        return uH.m11414(context, loMoType);
    }

    @Override // o.AbstractC0928
    /* renamed from: ˊ  reason: contains not printable characters */
    public Locale mo14164(Context context) {
        return zN.f12697.m13525(context);
    }

    @Override // o.AbstractC0928
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo14177(UserProfile userProfile) {
        BrowseExperience.m1770(userProfile);
    }

    @Override // o.AbstractC0928
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo14171() {
        return BrowseExperience.m1780();
    }

    @Override // o.AbstractC0928
    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean mo14161(Context context) {
        return RestrictedProfilesReceiver.m2764(context);
    }

    @Override // o.AbstractC0928
    /* renamed from: ʼ  reason: contains not printable characters */
    public AbstractC1635d mo14162() {
        return ErrorDescriptorFactoryImpl.INSTANCE;
    }

    @Override // o.AbstractC0928
    /* renamed from: ʻ  reason: contains not printable characters */
    public String mo14160() {
        return "com.netflix.mediaclient";
    }

    @Override // o.AbstractC0928
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public DH mo14178(Context context) {
        return new rE(context);
    }

    @Override // o.AbstractC0928
    /* renamed from: ˊ  reason: contains not printable characters */
    public Intent mo14163(Context context, String str) {
        return ActivityC2187tq.m11247(context, str);
    }
}
