package o;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import o.qO;
/* renamed from: o.ru  reason: case insensitive filesystem */
public class ActivityC2132ru extends DetailsActivity implements qO.Cif {
    /* renamed from: ʿ  reason: contains not printable characters */
    public static Class<? extends DetailsActivity> m10478() {
        return NetflixApplication.getInstance().m254() ? ActivityC2125rn.class : ActivityC2132ru.class;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m10480();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public void m10480() {
        C2116re reVar = (C2116re) m14001();
        if (m10479()) {
            m13997().setVisibility(0);
            reVar.m10391(8);
            return;
        }
        m13997().setVisibility(8);
        reVar.m10391(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10482(pR pRVar) {
        if (mo10792() instanceof C2134rw) {
            ((C2134rw) mo10792()).m10489(pRVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        if (C0881.m15600(this)) {
            return rB.m10134(m1634(), m1651());
        }
        return C2134rw.m10488(m1634(), m1651(), this.f2888);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˋ  reason: contains not printable characters */
    public Fragment mo10481() {
        if (C0881.m15600(this)) {
            return C2117rf.m10409(m1634(), m1651(), !m10479());
        }
        return C2116re.m10365(m1634(), m1651(), !m10479());
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private boolean m10479() {
        return AD.m3299() && AD.m3307(this);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, o.qO.AbstractC0170
    public qO.Cif getEpisodeRowListener() {
        qO.Cif episodeRowListener = super.getEpisodeRowListener();
        if (episodeRowListener != null) {
            return episodeRowListener;
        }
        return this;
    }

    @Override // o.qO.Cif
    /* renamed from: ˏ */
    public void mo2536(pI pIVar) {
        PlaybackLauncher.m1607(this, pIVar.getPlayable(), pIVar.getType(), mo1635());
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity
    /* renamed from: ˋॱ */
    public VideoType mo1643() {
        return VideoType.SHOW;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
        if (menu2 != null) {
            menu2.add("Display episodes dialog").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.ru.5
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C2116re r3 = C2116re.m10365(ActivityC2132ru.this.m1634(), ActivityC2132ru.this.m1651(), false);
                    r3.onManagerReady(ActivityC2132ru.this.getServiceManager(), AbstractC0367.f13235);
                    r3.setCancelable(true);
                    ActivityC2132ru.this.showDialog(r3);
                    return true;
                }
            });
        }
        super.onCreateOptionsMenu(menu, menu2);
    }
}
