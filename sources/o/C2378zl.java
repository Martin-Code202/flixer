package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
/* renamed from: o.zl  reason: case insensitive filesystem */
public class C2378zl extends AbstractC0496 {
    /* renamed from: ॱ  reason: contains not printable characters */
    protected static C2378zl m13710(NetflixActivity netflixActivity, String str, String str2) {
        C2378zl zlVar = new C2378zl();
        zlVar.setStyle(1, R.style.res_2131951877_netflixdialog_notitle);
        return zlVar;
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        DialogInterface.OnClickListener onClickListener = (DialogInterface.OnClickListener) getActivity();
        builder.setNegativeButton(R.string.label_cancel, onClickListener);
        builder.setPositiveButton(R.string.profile_delete_dlg_positive_button, onClickListener);
        builder.setMessage(getString(R.string.profile_delete_dlg_text));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        DialogInterface.OnClickListener onClickListener = (DialogInterface.OnClickListener) getActivity();
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, -2);
        }
    }
}
