package o;

import android.support.v7.widget.RecyclerView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.offline.OfflineAdapterData;
import com.netflix.mediaclient.ui.offline.OfflineFragment;
import com.netflix.mediaclient.util.ViewUtils;
import o.C1348Bu;
import o.vF;
import org.apache.commons.lang.ArrayUtils;
public class vL extends vF {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f11193;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C2098qr[] f11194;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f11195;

    public vL(NetflixActivity netflixActivity, AbstractC1853hl hlVar, vF.AbstractC0241 r3, String str, String str2) {
        super(netflixActivity, hlVar, r3);
        this.f11193 = str;
        this.f11195 = str2;
        m11965();
    }

    /* access modifiers changed from: protected */
    @Override // o.vF
    /* renamed from: ᐝ */
    public String mo11916() {
        if (this.f11149 == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(this.f11194) || !C2093qn.m10093(this.f11194[0]) || !C2093qn.m10093(this.f11194[0].getPlayable())) {
            return this.f11149.getResources().getString(R.string.label_download_screen);
        }
        return this.f11194[0].getPlayable().getParentTitle();
    }

    @Override // o.vF, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f11194 == null) {
            return 0;
        }
        return this.f11194.length;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        vF.C0240 r7 = (vF.C0240) viewHolder;
        C2098qr qrVar = this.f11194 == null ? null : this.f11194[i];
        if (qrVar == null || !C2093qn.m10093(qrVar)) {
            viewHolder.itemView.setVisibility(4);
            return;
        }
        viewHolder.itemView.setVisibility(0);
        boolean z = qrVar.getType() == VideoType.EPISODE;
        boolean z2 = false;
        if (z) {
            pV r11 = vO.m12029(this.f11152).mo11976(qrVar.getId());
            if (r11 != null) {
                r7.f11165.setText(this.f11149.getString(R.string.label_offline_video_info, new Object[]{this.f11149.getResources().getString(R.string.label_num_minutes_shorthand, Integer.valueOf(C1352By.m4137(qrVar.getPlayable().getRuntime()))), BG.m3861(this.f11149, r11.mo6887())}));
                if (r11.mo6916() < 100) {
                    r7.f11171.setProgress(r11.mo6916());
                }
                z2 = vO.m12016(r11);
            }
            if (qrVar.isEpisodeNumberHidden()) {
                r7.f11173.setText(qrVar.getTitle());
            } else {
                r7.f11173.setText(String.format("%d. %s", Integer.valueOf(qrVar.getPlayable().getEpisodeNumber()), qrVar.getTitle()));
            }
            r7.f11171.setStateFromPlayable(qrVar.getPlayable(), this.f11149);
            C2052pa paVar = null;
            if (!(this.f11149.getServiceManager() == null || this.f11149.getServiceManager().m9826() == null)) {
                paVar = vO.m12023(C2059ph.m9741(this.f11149), this.f11149.getServiceManager().m9826().getProfileGuid(), qrVar.getId());
            }
            ViewUtils.m3002(r7.f11172, paVar != null);
            pF playable = qrVar.getPlayable();
            if (!(paVar == null || playable == null)) {
                r7.f11172.setProgress(uC.m11326(qrVar.getPlayable().getRuntime(), paVar.mBookmarkInSecond));
            }
            NetflixActivity.getImageLoader(this.f11149).mo3057(r7.f11170, qrVar.getRealmHorzDispUrl(this.f11149), AssetType.boxArt, "boxart", StaticImgConfig.DARK, true);
            r7.f11169.setText((CharSequence) null);
            r7.f11177.setVisibility(8);
            r7.f11167.setVisibility(0);
            r7.f11162.setVisibility(0);
        } else {
            r7.f11169.setText(qrVar.getTitle());
            r7.f11177.setVisibility(0);
            r7.f11167.setVisibility(8);
            r7.f11162.setVisibility(8);
        }
        r7.f11168.setContentDescription(qrVar.getTitle());
        m11914(r7, i, qrVar.getId(), z);
        m11901(r7, i, z ? qrVar.getId() : null, z ? VideoType.EPISODE : null);
        ViewUtils.m3002(r7.f11163, z2);
        r7.itemView.setLongClickable(z);
    }

    @Override // o.vF
    /* renamed from: ˎ */
    public String mo11907(int i) {
        if (this.f11194 == null) {
            return null;
        }
        C2098qr qrVar = this.f11194[i];
        if (!C2093qn.m10093(qrVar)) {
            return null;
        }
        if (qrVar.getType() == VideoType.EPISODE) {
            return qrVar.getId();
        }
        return null;
    }

    @Override // o.vF
    /* renamed from: ˊ */
    public boolean mo11902(int i, String str) {
        return this.f11194 != null && this.f11194.length > i && C2093qn.m10093(this.f11194[i]) && str.equalsIgnoreCase(this.f11194[i].getId());
    }

    @Override // o.vF
    /* renamed from: ˋ */
    public VideoType mo11903(int i) {
        return (this.f11194 == null || this.f11194.length <= i || !C2093qn.m10093(this.f11194[i])) ? VideoType.UNKNOWN : this.f11194[i].getType();
    }

    @Override // o.vF
    /* renamed from: ˎ */
    public void mo11908() {
        m11965();
        super.mo11908();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m11965() {
        OfflineAdapterData r3 = OfflineFragment.m2205(vO.m12029(this.f11152), this.f11193, this.f11195);
        if (r3 == null) {
            C1283.m16862("OfflineEpisodesAdapter", "All the episodes were removed - closing the activity");
            this.f11194 = null;
            C1348Bu.If.m4098(new Runnable() { // from class: o.vL.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!vL.this.f11149.isFinishing()) {
                        vL.this.f11149.onBackPressed();
                    }
                }
            });
            return;
        }
        this.f11194 = r3.m2190();
        m11899();
    }
}
