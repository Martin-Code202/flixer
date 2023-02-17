package o;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.widget.TextView;
import com.netflix.mediaclient.R;
/* renamed from: o.qw  reason: case insensitive filesystem */
public class C2103qw extends BroadcastReceiver {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f9619;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Activity f9620;

    public C2103qw(Activity activity, String str) {
        this.f9620 = activity;
        this.f9619 = str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals("com.netflix.mediaclient.mylist.intent.action.ADD", intent.getAction()) && TextUtils.equals(intent.getStringExtra("pre_release_video_id"), this.f9619)) {
            m10121();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10121() {
        Snackbar make = Snackbar.make(this.f9620.findViewById(16908290), (int) R.string.snackbar_pre_release_add_mylist, 0);
        TextView textView = (TextView) ((Snackbar.SnackbarLayout) make.getView()).findViewById(R.id.snackbar_text);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextAlignment(4);
        make.show();
    }
}
