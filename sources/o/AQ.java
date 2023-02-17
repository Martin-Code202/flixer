package o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
public class AQ implements Runnable {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f4293 = AQ.class.getSimpleName();

    /* renamed from: ˋ  reason: contains not printable characters */
    private Context f4294;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Uri f4295;

    public AQ(Context context, Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("Uri can not be null");
        } else if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        } else {
            this.f4295 = uri;
            this.f4294 = context;
        }
    }

    public AQ(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("Uri can not be null");
        } else if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        } else {
            this.f4295 = Uri.parse(str);
            this.f4294 = context;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3402(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Uri can not be null");
        }
        this.f4295 = Uri.parse(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent data = new Intent("android.intent.action.VIEW").setData(this.f4295);
        data.addFlags(268435456);
        if (data.resolveActivity(this.f4294.getPackageManager()) != null) {
            this.f4294.getApplicationContext().startActivity(data);
        } else {
            Log.e(f4293, "Unable to launchHelp");
        }
    }
}
