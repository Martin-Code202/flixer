package o;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
public final class uM {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC0229 f10818;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean f10819 = BrowseExperience.m1771(this.f10821, (int) R.attr.isLightCastActionBarIcon);

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Handler f10820;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final NetflixActivity f10821;

    /* access modifiers changed from: package-private */
    /* renamed from: o.uM$ˊ  reason: contains not printable characters */
    public interface AbstractC0229 {
        /* renamed from: ˊ */
        void mo11545(boolean z);

        /* renamed from: ˋ */
        Drawable mo11546(Drawable drawable);

        /* renamed from: ॱ */
        void mo11547(boolean z);
    }

    class If implements AbstractC0229 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final MenuItem f10825;

        If(NetflixActivity netflixActivity, Menu menu, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f10825 = menu.add(0, R.id.ab_menu_cast_item, 0, netflixActivity.getString(R.string.label_selectTarget));
            this.f10825.setShowAsAction(1);
            this.f10825.setOnMenuItemClickListener(onMenuItemClickListener);
        }

        @Override // o.uM.AbstractC0229
        /* renamed from: ˋ  reason: contains not printable characters */
        public Drawable mo11546(Drawable drawable) {
            this.f10825.setIcon(drawable);
            return this.f10825.getIcon();
        }

        @Override // o.uM.AbstractC0229
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo11547(boolean z) {
            this.f10825.setEnabled(z);
        }

        @Override // o.uM.AbstractC0229
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo11545(boolean z) {
            this.f10825.setVisible(z);
        }
    }

    /* renamed from: o.uM$iF  reason: case insensitive filesystem */
    class C2200iF implements AbstractC0229 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final FloatingActionButton f10827;

        C2200iF(NetflixActivity netflixActivity, final MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f10827 = (FloatingActionButton) netflixActivity.findViewById(R.id.cast_icon_fab_ab9031);
            if (this.f10827 != null) {
                this.f10827.setOnClickListener(new View.OnClickListener(uM.this) { // from class: o.uM.iF.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        onMenuItemClickListener.onMenuItemClick(null);
                    }
                });
            }
            mo11545(true);
        }

        @Override // o.uM.AbstractC0229
        /* renamed from: ˋ */
        public Drawable mo11546(Drawable drawable) {
            if (this.f10827 != null) {
                this.f10827.setImageDrawable(drawable);
            }
            return drawable;
        }

        @Override // o.uM.AbstractC0229
        /* renamed from: ॱ */
        public void mo11547(boolean z) {
        }

        @Override // o.uM.AbstractC0229
        /* renamed from: ˊ */
        public void mo11545(boolean z) {
            if (this.f10827 != null) {
                this.f10827.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m11540(NetflixActivity netflixActivity, Menu menu) {
        new uM(netflixActivity, menu);
    }

    private uM(NetflixActivity netflixActivity, Menu menu) {
        C1283.m16846("CastMenu", "creating");
        this.f10821 = netflixActivity;
        uU castPlayerFrag = this.f10821.getCastPlayerFrag();
        this.f10820 = new Handler();
        if (castPlayerFrag == null) {
            throw new IllegalArgumentException("Activity that uses CastMenu must own a reference to mdxFrag!");
        }
        castPlayerFrag.mo11491(this);
        AnonymousClass3 r3 = new MenuItem.OnMenuItemClickListener() { // from class: o.uM.3
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                AlertDialog r2 = AU.m3422(uM.this.f10821, uM.this.f10821.getCastPlayerFrag());
                if (r2 == null) {
                    return true;
                }
                uM.this.f10821.displayDialog(r2);
                return true;
            }
        };
        if (C0727.m15067()) {
            this.f10818 = new C2200iF(netflixActivity, r3);
        } else {
            this.f10818 = new If(netflixActivity, menu, r3);
        }
        m11544(castPlayerFrag.mo11479());
        m11543();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11544(boolean z) {
        C1283.m16848("CastMenu", "Setting cast menu item enabled %b: ", Boolean.valueOf(z));
        this.f10818.mo11547(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11543() {
        if (!this.f10821.shouldAddCastToMenu()) {
            C1283.m16865("CastMenu", "Service manager or mdx are null");
            this.f10818.mo11545(false);
            return;
        }
        Drawable r2 = this.f10818.mo11546(ContextCompat.getDrawable(this.f10821, m11541()));
        if (r2 instanceof AnimationDrawable) {
            m11542((AnimationDrawable) r2);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11542(final AnimationDrawable animationDrawable) {
        this.f10820.post(new Runnable() { // from class: o.uM.5
            @Override // java.lang.Runnable
            public void run() {
                animationDrawable.start();
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m11541() {
        return this.f10821.isConnectingToTarget() ? this.f10819 ? R.drawable.mr_button_connecting_dark : R.drawable.mr_button_connecting_light : AU.m3428(this.f10821.getServiceManager()) ? this.f10821.wasMdxStatusUpdatedByMdxReceiver() ? this.f10819 ? R.drawable.mr_button_connected_dark : R.drawable.mr_button_connected_light : this.f10819 ? R.drawable.ic_mr_button_connected_22_dark : R.drawable.ic_mr_button_connected_22_light : this.f10819 ? R.drawable.mr_button_dark : R.drawable.mr_button_light;
    }
}
