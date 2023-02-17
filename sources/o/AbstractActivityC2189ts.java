package o;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.netflix.mediaclient.android.activity.NetflixActivity;
/* renamed from: o.ts  reason: case insensitive filesystem */
public abstract class AbstractActivityC2189ts extends NetflixActivity {
    private static final String ACTION_FINISH_ACCOUNT_ACTIVITIES = "com.netflix.mediaclient.ui.login.ACTION_FINISH_ACCOUNT_ACTIVITIES";

    public static void finishAllAccountActivities(Context context) {
        context.sendBroadcast(new Intent(ACTION_FINISH_ACCOUNT_ACTIVITIES));
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerFinishReceiverWithAutoUnregister(ACTION_FINISH_ACCOUNT_ACTIVITIES);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasUpAction() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showMdxInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean allowTransitionAnimation() {
        return false;
    }
}
