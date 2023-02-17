package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
/* renamed from: o.sp  reason: case insensitive filesystem */
public class C2157sp extends AbstractC0496 {
    /* renamed from: ˊ  reason: contains not printable characters */
    protected static C2157sp m10806(NetflixActivity netflixActivity) {
        C2157sp spVar = new C2157sp();
        spVar.setStyle(1, R.style.res_2131951877_netflixdialog_notitle);
        return spVar;
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.sp.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setMessage(getString(R.string.access_error_account));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }
}
