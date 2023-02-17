package o;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
/* renamed from: o.rr  reason: case insensitive filesystem */
public class ActivityC2129rr extends ActivityC2121rj {

    /* renamed from: ˏ  reason: contains not printable characters */
    C2103qw f9937;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f9938 = false;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public static Class<?> m10468() {
        return NetflixApplication.getInstance().m254() ? ActivityC2127rp.class : ActivityC2129rr.class;
    }

    /* access modifiers changed from: protected */
    @Override // o.ActivityC2121rj, com.netflix.mediaclient.ui.details.DetailsActivity, o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9937 = new C2103qw(this, m1634());
        registerReceiverWithAutoUnregister(this.f9937, "com.netflix.mediaclient.mylist.intent.action.ADD");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // o.ActivityC2121rj, o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        this.f9938 = getIntent().getExtras() != null && getIntent().getExtras().getBoolean("extra_is_movie", false);
        return C2128rq.m10461(m1634(), this.f9938);
    }

    @Override // o.ActivityC2121rj, com.netflix.mediaclient.ui.details.DetailsActivity
    /* renamed from: ˋॱ */
    public VideoType mo1643() {
        VideoType videoType = VideoType.UNKNOWN;
        if (getIntent() != null) {
            videoType = VideoType.create(getIntent().getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE));
        }
        if (videoType == VideoType.UNKNOWN) {
            return this.f9938 ? VideoType.MOVIE : VideoType.SHOW;
        }
        return videoType;
    }
}
