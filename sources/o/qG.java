package o;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
public class qG {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9431;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final NetflixActivity f9432;

    /* renamed from: ˏ  reason: contains not printable characters */
    private DialogInterface.OnClickListener f9433 = new DialogInterface.OnClickListener() { // from class: o.qG.5
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse("https://help.netflix.com/en/node/12407"));
            if (qG.this.f9432 == null || data.resolveActivity(qG.this.f9432.getPackageManager()) == null) {
                C1283.m16850(qG.this.f9431, "Unable to launchHelp");
            } else {
                qG.this.f9432.startActivity(data);
            }
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    private DialogInterface.OnClickListener f9434 = new DialogInterface.OnClickListener() { // from class: o.qG.3
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse("https://help.netflix.com/en/node/13590"));
            if (qG.this.f9432 == null || data.resolveActivity(qG.this.f9432.getPackageManager()) == null) {
                C1283.m16850(qG.this.f9431, "Unable to launchHelp");
            } else {
                qG.this.f9432.startActivity(data);
            }
        }
    };

    public qG(String str, NetflixActivity netflixActivity) {
        this.f9431 = str;
        this.f9432 = netflixActivity;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9888(int i, String str) {
        if (!C1317As.m3750(this.f9432)) {
            if (i >= 100 && i < 200) {
                C1283.m16854(this.f9431, "Displaying error dialog");
                m9886(i, str);
            } else if (i < 200 || i >= 300) {
                if (m9887()) {
                    C1283.m16854(this.f9431, "Showing toast msg");
                    m9883(i, str);
                    return;
                }
                C1283.m16854(this.f9431, "Not MDX related activity, do not show toast");
            } else if (m9887()) {
                C1283.m16854(this.f9431, "Showing toast msg");
                m9883(i, str);
            } else {
                C1283.m16854(this.f9431, "Not MDX related activity, do not show toast");
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m9883(int i, String str) {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9886(int i, String str) {
        this.f9432.displayDialog(m9884(i, str));
        m9881(i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9881(int i) {
        String str;
        switch (i) {
            case 100:
                str = "16001";
                break;
            case 101:
            case 102:
            case 103:
            default:
                return;
            case 104:
                str = "16002";
                break;
            case 105:
                str = "16003";
                break;
            case 106:
                str = "16004";
                break;
        }
        try {
            this.f9432.getServiceManager().m9811().mo6165(str);
        } catch (Exception e) {
            C1283.m16850(this.f9431, "Unable to log error" + e);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private AlertDialog.Builder m9884(int i, String str) {
        switch (i) {
            case 100:
                return new AlertDialog.Builder(this.f9432).setMessage(m9880(i, str)).setPositiveButton(R.string.label_ok, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.label_dialogButtonMore, this.f9433);
            case 105:
                return new AlertDialog.Builder(this.f9432).setMessage(m9880(i, str)).setPositiveButton(R.string.label_ok, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.label_dialogButtonMore, this.f9434);
            default:
                return new AlertDialog.Builder(this.f9432).setMessage(m9880(i, str)).setPositiveButton(R.string.label_ok, (DialogInterface.OnClickListener) null);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m9880(int i, String str) {
        switch (i) {
            case 100:
            case 103:
                return this.f9432.getString(R.string.label_mdx_error_timeout);
            case 104:
                return this.f9432.getString(R.string.label_mdx_error_pairfail);
            case 105:
                return this.f9432.getString(R.string.label_mdx_error_sessionerror);
            case 106:
                return String.format(this.f9432.getString(R.string.label_mdx_error_launch_error), str);
            case 200:
                return this.f9432.getString(R.string.label_mdx_error_toast_target_gone);
            case 201:
                return this.f9432.getString(R.string.label_mdx_error_toast_targetcontext_gone);
            case 300:
                return str;
            default:
                return str;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m9887() {
        return this.f9432 instanceof AbstractActivityC0360;
    }
}
