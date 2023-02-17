package o;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import java.util.ArrayList;
import java.util.Iterator;
import o.qY;
/* renamed from: o.rj  reason: case insensitive filesystem */
public class ActivityC2121rj extends DetailsActivity {

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f9897;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C2059ph f9898;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ArrayList<qY.iF> f9899 = new ArrayList<>();

    /* renamed from: ʿ  reason: contains not printable characters */
    public static Class<? extends DetailsActivity> m10436() {
        return NetflixApplication.getInstance().m254() ? ActivityC2126ro.class : ActivityC2121rj.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null && bundle.containsKey("extra_back_stack")) {
            Iterator it = bundle.getParcelableArrayList("extra_back_stack").iterator();
            while (it.hasNext()) {
                this.f9899.add((qY.iF) ((Parcelable) it.next()));
            }
        }
        m10437();
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        C1283.m16853("MovieDetailsActivity", "onNewIntent: ", intent);
        super.onNewIntent(intent);
        setIntent(intent);
        m10437();
        if (this.f9898 == null) {
            this.f9897 = true;
            return;
        }
        m1638();
        m10438((Parcelable) null);
        m1644();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        C1283.m16846("MovieDetailsActivity", "Back pressed, backStack size: " + this.f9899.size());
        if (this.f9899.size() > 0) {
            qY.iF remove = this.f9899.remove(this.f9899.size() - 1);
            m1641(remove.f9599);
            m1648(remove.f9598);
            m10438(remove.f9601);
            return true;
        }
        C1283.m16846("MovieDetailsActivity", "No more videos in back stack, finishing...");
        return false;
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        this.f9898 = phVar;
        if (this.f9897 && phVar != null) {
            m10438((Parcelable) null);
            this.f9897 = false;
        }
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        super.onManagerUnavailable(phVar, status);
        this.f9898 = null;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        if (C0881.m15600(this)) {
            return C2120ri.m10432(m1634());
        }
        return C2122rk.m10441(m1634(), this.f2888);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("extra_back_stack", this.f9899);
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity
    /* renamed from: ˋॱ */
    public VideoType mo1643() {
        return VideoType.MOVIE;
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m10437() {
        if (C1349Bv.m4107(m1634())) {
            Parcelable parcelable = null;
            if (mo10792() instanceof AbstractC2124rm) {
                parcelable = ((AbstractC2124rm) mo10792()).mo10450();
            }
            this.f9899.add(new qY.iF(m1634(), mo1635(), parcelable));
        }
        m1641(getIntent().getStringExtra(NetflixActivity.EXTRA_VIDEO_ID));
        m1648((oX) getIntent().getParcelableExtra(NetflixActivity.EXTRA_PLAY_CONTEXT));
        m1640((DetailsActivity.Action) getIntent().getSerializableExtra("extra_action"), getIntent().getStringExtra("extra_action_token"));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m10438(Parcelable parcelable) {
        if (this.f9898 != null) {
            Fragment r3 = mo10792();
            m13998(mo10189());
            ((C2122rk) mo10792()).mo10452(parcelable);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            m10439(r3, mo10792(), parcelable != null);
            beginTransaction.replace(R.id.primary_fragment, mo10792(), "primary");
            beginTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();
            ((oV) mo10792()).onManagerReady(this.f9898, AbstractC0367.f13235);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10439(Fragment fragment, Fragment fragment2, boolean z) {
        BY by = new BY();
        by.m3962(BrowseExperience.m1774(this, 16842836));
        by.setDuration((long) C1317As.m3768(NetflixApplication.getInstance(), R.integer.activity_transition_anim_time_ms));
        if (fragment2 != null) {
            fragment2.setEnterTransition(z ? new Fade() : by);
        }
        if (fragment != null) {
            fragment.setExitTransition(z ? by : new Fade());
        }
    }
}
