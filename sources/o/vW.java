package o;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.offline.OfflineAdapterData;
import com.netflix.mediaclient.util.ViewUtils;
import o.vF;
public class vW extends vF {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final vQ f11272 = NetflixApplication.getInstance().m251();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f11273 = m12086();

    public vW(NetflixActivity netflixActivity, AbstractC1853hl hlVar, vF.AbstractC0241 r4) {
        super(netflixActivity, hlVar, r4);
        m11899();
        m12081();
    }

    /* access modifiers changed from: protected */
    @Override // o.vF
    /* renamed from: ᐝ */
    public String mo11916() {
        if (this.f11149 != null) {
            return this.f11149.getResources().getString(R.string.label_download_screen);
        }
        return null;
    }

    @Override // o.vF, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (vO.m12029(this.f11152) == null) {
            return 0;
        }
        return m12086() ? vO.m12029(this.f11152).mo4074() + 1 : vO.m12029(this.f11152).mo4074();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m12086() {
        return this.f11149.getServiceManager().m9826() != null && this.f11149.getServiceManager().m9826().isKidsProfile();
    }

    @Override // o.vF, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (!m12086()) {
            return 0;
        }
        if (vO.m12029(this.f11152) == null || i == vO.m12029(this.f11152).mo4074()) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m12081() {
        if (this.f11272.m12033(this.f11273)) {
            this.f11152.mo7137();
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        if (viewHolder instanceof vF.C2229iF) {
            vF.C2229iF iFVar = (vF.C2229iF) viewHolder;
            iFVar.f11161.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this.f11149, this.f11273 ? R.drawable.ic_chevron_down : R.drawable.ic_chevron_up), (Drawable) null);
            iFVar.f11161.setText(this.f11273 ? R.string.label_show_all_profiles : R.string.label_show_only_this_profile);
            iFVar.f11161.setOnClickListener(new View.OnClickListener() { // from class: o.vW.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    vW.this.f11273 = !vW.this.f11273;
                    vW.this.m12081();
                }
            });
            return;
        }
        vF.C0240 r7 = (vF.C0240) viewHolder;
        OfflineAdapterData.If r8 = i == 0 ? null : ((OfflineAdapterData) vO.m12029(this.f11152).mo4075(i - 1)).m2192();
        OfflineAdapterData.If r9 = ((OfflineAdapterData) vO.m12029(this.f11152).mo4075(i)).m2192();
        if (r9 == null || !C2093qn.m10093(r9.f3357)) {
            viewHolder.itemView.setVisibility(4);
            return;
        }
        viewHolder.itemView.setVisibility(0);
        ViewUtils.m3002(r7.f11164, r9.f3356 == OfflineAdapterData.ViewType.SHOW);
        ViewUtils.m3002(r7.f11171, r9.f3356 == OfflineAdapterData.ViewType.MOVIE);
        pF playable = r9.f3357.getPlayable();
        C2052pa paVar = null;
        if (!(this.f11149.getServiceManager() == null || this.f11149.getServiceManager().m9826() == null)) {
            paVar = vO.m12023(C2059ph.m9741(this.f11149), this.f11149.getServiceManager().m9826().getProfileGuid(), r9.f3357.getId());
        }
        if (paVar == null || playable == null) {
            ViewUtils.m3002((View) r7.f11172, false);
        } else {
            ViewUtils.m3002((View) r7.f11172, true);
            r7.f11172.setProgress(uC.m11326(r9.f3357.getPlayable().getRuntime(), paVar.mBookmarkInSecond));
        }
        r7.f11173.setText(r9.f3357.getTitle());
        NetflixActivity.getImageLoader(this.f11149).mo3057(r7.f11170, r9.f3357.getRealmHorzDispUrl(this.f11149), AssetType.boxArt, "", StaticImgConfig.DARK, true);
        r7.f11168.setContentDescription(r9.f3357.getTitle());
        boolean z = false;
        if (r9.f3356 == OfflineAdapterData.ViewType.SHOW) {
            r7.f11165.setText(this.f11149.getString(R.string.label_offline_video_info, new Object[]{C0403.m14185(this.f11149, R.string.label_offline_episodes_capital).m14187(r9.f3355).m14188(), m11911(vO.m12029(this.f11152).mo11968(i))}));
        } else if (r9.f3356 == OfflineAdapterData.ViewType.MOVIE) {
            String certification = r9.f3357.getCertification();
            if (TextUtils.isEmpty(certification)) {
                str = BG.m3861(this.f11149, vO.m12029(this.f11152).mo11968(i));
            } else {
                str = this.f11149.getString(R.string.label_offline_video_info, new Object[]{certification, BX.m3953(BG.m3861(this.f11149, vO.m12029(this.f11152).mo11968(i)))});
            }
            r7.f11165.setText(str);
            r7.f11171.setStateFromPlayable(r9.f3357.getPlayable(), this.f11149);
            if (vO.m12029(this.f11152).mo11969(i) < 100) {
                r7.f11171.setProgress(vO.m12029(this.f11152).mo11969(i));
            }
            z = vO.m12016(vO.m12029(this.f11152).mo11976(r9.f3357.getId()));
        }
        m11901(r7, i, mo11903(i) != null ? r9.f3357.getId() : null, mo11903(i));
        ViewUtils.m3002(r7.f11163, z);
        m12083(r7, r8, r9);
        m11914(r7, i, r9.f3357.getId(), true);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12083(vF.C0240 r10, OfflineAdapterData.If r11, OfflineAdapterData.If r12) {
        if (!C2093qn.m10093(r12.f3357) || (r11 != null && TextUtils.equals(r12.f3357.getProfileId(), r11.f3357.getProfileId()))) {
            ((ViewGroup.MarginLayoutParams) r10.f11162.getLayoutParams()).topMargin = 0;
            r10.f11177.setVisibility(8);
            r10.f11169.setText((CharSequence) null);
            r10.f11167.setImageDrawable(null);
            return;
        }
        ((ViewGroup.MarginLayoutParams) r10.f11162.getLayoutParams()).topMargin = (r10.f11162.getResources().getDimensionPixelOffset(R.dimen.double_padding) * 2) + r10.f11162.getResources().getDimensionPixelOffset(R.dimen.offline_profile_row_height);
        r10.f11177.setVisibility(0);
        C2091ql r8 = C2093qn.m10090(r12.f3357.getProfileId());
        if (r8 != null) {
            r10.f11169.setText(r8.getName());
            NetflixActivity.getImageLoader(this.f11149).mo3057(r10.f11167, r8.getRealmProfileIconUrl(r10.f11167.getContext()), AssetType.boxArt, "", StaticImgConfig.DARK, true);
            return;
        }
        C1276.m16820().mo5725("profile not found for " + r12.f3357.getProfileId());
    }

    @Override // o.vF
    /* renamed from: ˎ */
    public String mo11907(int i) {
        if (i >= vO.m12029(this.f11152).mo4074()) {
            return null;
        }
        OfflineAdapterData offlineAdapterData = (OfflineAdapterData) vO.m12029(this.f11152).mo4075(i);
        if (offlineAdapterData.m2192().f3356 == OfflineAdapterData.ViewType.MOVIE || offlineAdapterData.m2192().f3356 == OfflineAdapterData.ViewType.SHOW) {
            return offlineAdapterData.m2192().f3357.getId();
        }
        return null;
    }

    @Override // o.vF
    /* renamed from: ˊ */
    public boolean mo11902(int i, String str) {
        return vO.m12029(this.f11152).mo4074() > i && ((OfflineAdapterData) vO.m12029(this.f11152).mo4075(i)).m2189(str);
    }

    @Override // o.vF
    /* renamed from: ˋ */
    public VideoType mo11903(int i) {
        switch (((OfflineAdapterData) vO.m12029(this.f11152).mo4075(i)).m2192().f3356) {
            case MOVIE:
                return VideoType.MOVIE;
            case SHOW:
                return VideoType.SHOW;
            default:
                return null;
        }
    }
}
