package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: o.zp  reason: case insensitive filesystem */
public class C2382zp extends AbstractC0496 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AtomicBoolean f12899 = new AtomicBoolean(false);

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C2382zp m13718() {
        C2382zp zpVar = new C2382zp();
        zpVar.setCancelable(false);
        return zpVar;
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (getActivity() instanceof ActivityC2153sl) {
            return new AlertDialog.Builder(getActivity()).setTitle(R.string.label_socialOptIn_title).setMessage(R.string.label_socialOptIn_message).setPositiveButton(R.string.label_socialOptIn_positive_button, new DialogInterface.OnClickListener() { // from class: o.zp.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C1283.m16854("social", "User opted In!");
                    synchronized (C2382zp.this.f12899) {
                        if (C2382zp.this.f12899.get()) {
                            C1283.m16865("social", "Already clicked!");
                            return;
                        }
                        C2382zp.this.f12899.set(true);
                    }
                    C2382zp.this.dismiss();
                    C2382zp.this.getFragmentManager().beginTransaction().remove(C2382zp.this).commitAllowingStateLoss();
                    if (!C1317As.m3750(C2382zp.this.getActivity())) {
                        C2382zp.this.m13722();
                        C1364Cj.m4443(UIViewLogging.UIViewCommandName.optInButton, IClientLogging.ModalView.optInDialog, C2382zp.this.m14476().getDataContext(), "yes");
                    }
                }
            }).setNegativeButton(R.string.label_socialOptIn_negative_button, new DialogInterface.OnClickListener() { // from class: o.zp.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C1283.m16854("social", "User opted out!");
                    synchronized (C2382zp.this.f12899) {
                        if (C2382zp.this.f12899.get()) {
                            C1283.m16865("social", "Already clicked!");
                            return;
                        }
                        C2382zp.this.f12899.set(true);
                    }
                    C2382zp.this.dismiss();
                    C2382zp.this.getFragmentManager().beginTransaction().remove(C2382zp.this).commitAllowingStateLoss();
                    if (!C1317As.m3750(C2382zp.this.getActivity())) {
                        C2382zp.this.m13723();
                        C1364Cj.m4443(UIViewLogging.UIViewCommandName.optInButton, IClientLogging.ModalView.optInDialog, C2382zp.this.m14476().getDataContext(), "skip");
                    }
                }
            }).create();
        }
        C1283.m16850("social", "Activity is not HomeActivity! This should not happen!");
        return null;
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        C1283.m16854("social", "User cancelled!");
        C1364Cj.m4443(UIViewLogging.UIViewCommandName.optInButton, IClientLogging.ModalView.optInDialog, m14476().getDataContext(), "cancel");
    }

    @Override // o.AbstractC0496, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m13722() {
        C1283.m16846("social", "Sending PUSH_OPTIN...");
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_OPTIN");
        intent.addCategory("com.netflix.mediaclient.intent.category.PUSH");
        intent.putExtra(NetflixActivity.EXTRA_SOURCE, UIScreen.optInDialog.name());
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
        C1283.m16846("social", "Sending PUSH_OPTIN done.");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m13723() {
        C1283.m16846("social", "Sending PUSH_OPTOUT...");
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_OPTOUT");
        intent.addCategory("com.netflix.mediaclient.intent.category.PUSH");
        intent.putExtra(NetflixActivity.EXTRA_SOURCE, UIScreen.optInDialog.name());
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
        C1283.m16846("social", "Sending PUSH_OPTOUT done.");
    }
}
