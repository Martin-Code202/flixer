package o;

import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.ui.launch.LaunchActivity;
/* renamed from: o.tq  reason: case insensitive filesystem */
public class ActivityC2187tq extends LaunchActivity {
    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.launch.LaunchActivity
    /* renamed from: ˏ */
    public boolean mo2014() {
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Intent m11247(Context context, String str) {
        return new Intent(context, m11248()).putExtra("extra_source", str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Class<?> m11248() {
        return NetflixApplication.getInstance().m254() ? ActivityC2184tn.class : ActivityC2187tq.class;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m11249() {
        return getIntent().getStringExtra("extra_source");
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.launch.LaunchActivity
    /* renamed from: ˎ */
    public boolean mo2013() {
        String r1 = m11249();
        return r1 != null && !r1.contains("handleProfileActivated");
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.launch.LaunchActivity
    /* renamed from: ˊ */
    public boolean mo2012() {
        return false;
    }
}
