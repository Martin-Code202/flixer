package o;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.webclient.model.leafs.AvatarInfo;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.ArrayList;
import java.util.List;
import o.C0567;
/* renamed from: o.zg  reason: case insensitive filesystem */
public class ActivityC2373zg extends NetflixActivity {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C0333 f12844;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f12845;

    /* renamed from: ˊ  reason: contains not printable characters */
    private GridView f12846;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AvatarInfo f12847;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AvatarInfo f12848;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0616 f12849;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C2059ph f12850;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0567.Cif f12851 = new C0567.Cif() { // from class: o.zg.5
        @Override // o.C0567.Cif
        public void N_() {
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    private List<AvatarInfo> f12852;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Intent m13653(Context context, AvatarInfo avatarInfo, AvatarInfo avatarInfo2) {
        Intent intent = new Intent(context, m13656());
        if (avatarInfo == null || avatarInfo2 == null) {
            throw new RuntimeException("You must specify default and current avatars to launch this activity");
        }
        intent.putExtra("extra_default_avatar", avatarInfo);
        intent.putExtra("extra_current_avatar", avatarInfo2);
        return intent;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Class<?> m13656() {
        return NetflixApplication.getInstance().m254() ? ActivityC2375zi.class : ActivityC2373zg.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("extra_default_avatar") && intent.hasExtra("extra_current_avatar")) {
            this.f12848 = (AvatarInfo) intent.getParcelableExtra("extra_default_avatar");
            this.f12847 = (AvatarInfo) intent.getParcelableExtra("extra_current_avatar");
            this.f12845 = 0;
        }
        if (bundle != null && bundle.containsKey("extra_icons_list")) {
            this.f12852 = bundle.getParcelableArrayList("extra_icons_list");
        }
        m13655();
        m13651();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void setTheme() {
        if (AD.m3299()) {
            setTheme(R.style.res_2131952210_theme_avatarsgridtablet);
            getWindow().setBackgroundDrawable(null);
            return;
        }
        setTheme(R.style.res_2131952221_theme_netflix_default);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f12852 != null) {
            bundle.putParcelableArrayList("extra_icons_list", (ArrayList) this.f12852);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.zg.4
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                C1283.m16854("AvatarsGridActivity", "Manager is here!");
                ActivityC2373zg.this.f12850 = phVar;
                if (ActivityC2373zg.this.f12852 == null) {
                    ActivityC2373zg.this.f12850.m9819((oU) new If());
                    return;
                }
                ActivityC2373zg.this.m13647();
                ActivityC2373zg.this.m13651();
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16854("AvatarsGridActivity", "Manager isn't available!");
                ActivityC2373zg.this.f12850 = null;
                ActivityC2373zg.this.m13651();
            }
        };
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfilesListUpdated() {
        if (this.f12850 != null) {
            this.f12850.m9819((oU) new If());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldAttachToolbar() {
        return AD.m3292();
    }

    /* renamed from: o.zg$If */
    class If extends AbstractC2061pj {
        private If() {
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onAvailableAvatarsListFetched(List<AvatarInfo> list, Status status) {
            if (!status.mo298() || list == null) {
                ActivityC2373zg.this.handleUserAgentErrors(status);
                return;
            }
            ActivityC2373zg.this.f12852 = list;
            if (ActivityC2373zg.this.f12852.contains(ActivityC2373zg.this.f12848)) {
                ActivityC2373zg.this.f12852.remove(ActivityC2373zg.this.f12848);
            }
            ActivityC2373zg.this.m13647();
            ActivityC2373zg.this.m13651();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13647() {
        this.f12845 = this.f12852.contains(this.f12847) ? this.f12852.indexOf(this.f12847) + 1 : 0;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        setResult(0);
        finish();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13655() {
        setContentView(R.layout.avatars_grid_activity);
        this.f12846 = (GridView) findViewById(R.id.grid_view);
        this.f12849 = new C0616(findViewById(R.id.avatars_grid_parent), this.f12851);
        this.f12844 = new C0333();
        NetflixActionBar netflixActionBar = getNetflixActionBar();
        if (netflixActionBar != null) {
            netflixActionBar.m355(getActionBarStateBuilder().mo394((CharSequence) getResources().getString(R.string.profile_choose_picture_actionbar_title)).mo399(false).mo392());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13651() {
        if (!(this.f12850 != null) || this.f12852 == null) {
            m13658(true, false);
            return;
        }
        m13658(false, true);
        m13650();
        this.f12846.setAdapter((ListAdapter) this.f12844);
        this.f12846.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: o.zg.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AvatarInfo avatarInfo;
                Intent intent = new Intent();
                if (i == 0) {
                    avatarInfo = ActivityC2373zg.this.f12848;
                } else {
                    avatarInfo = (AvatarInfo) ActivityC2373zg.this.f12852.get(i - 1);
                }
                intent.putExtra("avatar_name", avatarInfo);
                ActivityC2373zg.this.setResult(-1, intent);
                ActivityC2373zg.this.finish();
            }
        });
        this.f12846.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.zg.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewUtils.m3009(ActivityC2373zg.this.f12846, this);
                ActivityC2373zg.this.f12844.m13662();
            }
        });
        this.f12844.notifyDataSetChanged();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13650() {
        int dimension = (int) getResources().getDimension(R.dimen.profile_avatars_grid_padding);
        if (AD.m3292()) {
            dimension += ViewUtils.m3006(this);
        }
        ((FrameLayout.LayoutParams) this.f12846.getLayoutParams()).topMargin = dimension;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13658(boolean z, boolean z2) {
        if (z) {
            this.f12849.mo14570(true);
        } else {
            this.f12849.mo14663(true);
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.profilesGate;
    }

    /* renamed from: o.zg$ˋ  reason: contains not printable characters */
    static class C0334 {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final C0522 f12859;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final ImageView f12860;

        public C0334(C0522 r1, ImageView imageView) {
            this.f12859 = r1;
            this.f12860 = imageView;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zg$ˊ  reason: contains not printable characters */
    public class C0333 extends BaseAdapter {
        private C0333() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (ActivityC2373zg.this.f12852 == null) {
                return 1;
            }
            return ActivityC2373zg.this.f12852.size() + 1;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public String getItem(int i) {
            return (ActivityC2373zg.this.f12852 == null || i == 0) ? ActivityC2373zg.this.f12848.getUrl() : ((AvatarInfo) ActivityC2373zg.this.f12852.get(i - 1)).getUrl();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m13661(int i) {
            return (ActivityC2373zg.this.f12852 == null || i == 0) ? ActivityC2373zg.this.f12848.getName() : ((AvatarInfo) ActivityC2373zg.this.f12852.get(i - 1)).getName();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ActivityC2373zg.this.getLayoutInflater().inflate(R.layout.avatars_gridview_item, viewGroup, false);
                view.setTag(new C0334((C0522) view.findViewById(R.id.profile_avatar_img), (ImageView) view.findViewById(R.id.avatar_checkmark_overlay)));
            }
            C0334 r7 = (C0334) view.getTag();
            String r8 = getItem(i);
            if (ActivityC2373zg.this.f12845 == i) {
                r7.f12860.setVisibility(0);
                r7.f12860.setBackgroundResource(R.drawable.profile_picture_checkmark);
            } else {
                r7.f12860.setVisibility(8);
            }
            NetflixActivity.getImageLoader(ActivityC2373zg.this).mo3057(r7.f12859, r8, AssetType.profileAvatar, m13661(i), StaticImgConfig.DARK, false);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            m13662();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m13662() {
            int width = ActivityC2373zg.this.f12846.getWidth();
            if (width > 0) {
                Resources resources = ActivityC2373zg.this.getResources();
                float dimension = resources.getDimension(R.dimen.profile_avatars_grid_padding);
                float dimension2 = resources.getDimension(R.dimen.profile_avatars_grid_img_size) + dimension;
                int i = (int) (((float) width) / dimension2);
                ActivityC2373zg.this.f12846.setNumColumns(i);
                m13660(width, i, dimension2, dimension);
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private void m13660(int i, int i2, float f, float f2) {
            int i3 = (int) ((((float) (i - ((int) (((float) i2) * f)))) + f2) / 2.0f);
            ActivityC2373zg.this.f12846.setPadding(i3, 0, (int) (((float) i3) - f2), 0);
        }
    }
}
