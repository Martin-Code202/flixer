package o;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.ui.offline.OfflineFragment;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;
public abstract class vF extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final NetflixActivity f11149;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected If f11150 = new If();

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final AbstractC0241 f11151;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected AbstractC1853hl f11152;

    /* renamed from: o.vF$ˋ  reason: contains not printable characters */
    public interface AbstractC0241 {
        /* renamed from: ˊ */
        void mo2223(int i, boolean z);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public abstract int getItemCount();

    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract boolean mo11902(int i, String str);

    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract VideoType mo11903(int i);

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract String mo11907(int i);

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public abstract String mo11916();

    public class If {

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean f11154 = false;

        /* renamed from: ˏ  reason: contains not printable characters */
        private SparseArray<C0239If> f11155 = new SparseArray<>();

        /* renamed from: ॱ  reason: contains not printable characters */
        private long f11156;

        public If() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.vF$If$If  reason: collision with other inner class name */
        public class C0239If {

            /* renamed from: ˏ  reason: contains not printable characters */
            public String f11158;

            /* renamed from: ॱ  reason: contains not printable characters */
            public String f11159;

            public C0239If(String str, String str2) {
                this.f11158 = str;
                this.f11159 = str2;
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m11920(int i, String str, boolean z) {
            long j;
            if (vF.this instanceof vL) {
                j = vO.m12029(vF.this.f11152).mo11976(str).mo6914();
            } else {
                j = vO.m12029(vF.this.f11152).mo11968(i);
            }
            boolean z2 = false;
            if (z) {
                if (this.f11155.size() == 0) {
                    z2 = true;
                }
                String str2 = null;
                if (C2093qn.m10096(str).getType() == VideoType.SHOW) {
                    str2 = OfflineFragment.m2199(vO.m12029(vF.this.f11152), i);
                }
                this.f11155.put(i, new C0239If(str, str2));
                this.f11156 += j;
            } else {
                if (this.f11155.size() == 1) {
                    z2 = true;
                }
                this.f11155.remove(i);
                this.f11156 -= j;
            }
            if (z2) {
                vF.this.m11897();
            }
            m11923();
            vF.this.notifyItemChanged(i);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m11918(NetflixActionBar.iF.AbstractC0010 r9) {
            String r6 = vF.this.mo11916();
            if (this.f11154) {
                r9.mo386(0);
                if (this.f11155.size() > 0) {
                    r6 = String.format(Locale.getDefault(), "%d (%s)", Integer.valueOf(this.f11155.size()), vF.this.m11911(this.f11156));
                    vF.this.m11909(r9, r6, -1);
                    r9.mo401(NetflixActionBar.LogoType.START_ALIGNED);
                } else {
                    r6 = vF.this.f11149.getResources().getString(R.string.label_offline_remove_downloads);
                    vF.this.m11912(r9, r6, -1);
                }
            } else {
                r9.mo386(1);
                r9.mo394((CharSequence) r6);
            }
            if (r6 != null) {
                C1316Ar.m3739(vF.this.f11149, r6);
            }
            NetflixActionBar netflixActionBar = vF.this.f11149.getNetflixActionBar();
            if (netflixActionBar != null) {
                netflixActionBar.m355(r9.mo392());
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m11927(int i, String str) {
            m11920(i, str, this.f11155.get(i) == null);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean m11924(int i) {
            return this.f11155.get(i) != null;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m11921(boolean z) {
            this.f11154 = z;
            m11923();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public void m11923() {
            NetflixActivity netflixActivity = vF.this.f11149;
            if (netflixActivity != null) {
                NetflixActionBar.iF.AbstractC0010 actionBarStateBuilder = netflixActivity.getActionBarStateBuilder();
                if (this.f11154) {
                    m11918(actionBarStateBuilder);
                    actionBarStateBuilder.mo403(true).mo398(netflixActivity.getDrawable(R.drawable.ic_action_cancel)).mo395(netflixActivity.getString(R.string.label_cancel)).mo387(new ColorDrawable(netflixActivity.getResources().getColor(R.color.download_button)));
                } else {
                    m11917();
                    m11918(actionBarStateBuilder);
                }
                if (netflixActivity.getNetflixActionBar() != null) {
                    netflixActivity.getNetflixActionBar().m355(actionBarStateBuilder.mo392());
                }
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m11922() {
            return this.f11154;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public int m11926() {
            return this.f11155.size();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m11925() {
            ArrayList arrayList = new ArrayList();
            AbstractC1853hl r6 = vF.this.f11149.getServiceManager().m9832();
            if (r6 == null) {
                C1276.m16820().mo5725("SPY-14731 OfflineAgent was null in OfflineBaseAdapter.deleteSelected().");
                vF.this.f11149.finish();
            }
            int size = this.f11155.size();
            for (int i = 0; i < size; i++) {
                String str = this.f11155.valueAt(i).f11158;
                C2098qr r10 = C2093qn.m10096(str);
                if (r10 != null) {
                    if (r10.getType() == VideoType.SHOW) {
                        C2098qr[] r12 = OfflineFragment.m2205(vO.m12029(vF.this.f11152), str, this.f11155.valueAt(i).f11159).m2190();
                        for (C2098qr qrVar : r12) {
                            VideoType type = qrVar.getType();
                            C1283.m16863("OfflineBaseAdapter", "details id=%s videoType=%s", qrVar.getId(), type);
                            if (type == VideoType.EPISODE) {
                                arrayList.add(qrVar.getPlayable().getPlayableId());
                            }
                        }
                    } else {
                        arrayList.add(str);
                    }
                }
            }
            if (arrayList.size() > 0) {
                r6.mo7129(arrayList);
                DownloadButton.m2160(arrayList);
            }
            this.f11155.clear();
            m11923();
            if (size > 0) {
                vF.this.m11897();
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m11917() {
            this.f11155.clear();
            this.f11154 = false;
            this.f11156 = 0;
        }
    }

    /* renamed from: o.vF$iF  reason: case insensitive filesystem */
    public class C2229iF extends RecyclerView.ViewHolder {

        /* renamed from: ॱ  reason: contains not printable characters */
        public TextView f11161;

        public C2229iF(View view) {
            super(view);
            this.f11161 = (TextView) view.findViewById(R.id.all_profiles_button);
        }
    }

    /* renamed from: o.vF$ˊ  reason: contains not printable characters */
    public class C0240 extends RecyclerView.ViewHolder {

        /* renamed from: ʻ  reason: contains not printable characters */
        public View f11162;

        /* renamed from: ʼ  reason: contains not printable characters */
        public View f11163;

        /* renamed from: ʽ  reason: contains not printable characters */
        public ImageView f11164;

        /* renamed from: ˊ  reason: contains not printable characters */
        public TextView f11165;

        /* renamed from: ˋ  reason: contains not printable characters */
        public C0522 f11167;

        /* renamed from: ˋॱ  reason: contains not printable characters */
        public AppCompatCheckBox f11168;

        /* renamed from: ˎ  reason: contains not printable characters */
        public TextView f11169;

        /* renamed from: ˏ  reason: contains not printable characters */
        public C0522 f11170;

        /* renamed from: ˏॱ  reason: contains not printable characters */
        public DownloadButton f11171;

        /* renamed from: ͺ  reason: contains not printable characters */
        public ProgressBar f11172;

        /* renamed from: ॱ  reason: contains not printable characters */
        public TextView f11173;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private View.OnClickListener f11174 = new View.OnClickListener() { // from class: o.vF.ˊ.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = C0240.this.getAdapterPosition();
                if (adapterPosition != -1) {
                    vF.this.f11151.mo2223(adapterPosition, C0240.this.f11163.getVisibility() == 0);
                } else {
                    C1283.m16863("OfflineBaseAdapter", "clickListener position=%d", Integer.valueOf(adapterPosition));
                }
            }
        };

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public TextView f11175;

        /* renamed from: ॱᐝ  reason: contains not printable characters */
        private View.OnLongClickListener f11176 = new View.OnLongClickListener() { // from class: o.vF.ˊ.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C1362Ch.m4394("onLongClick", IClientLogging.ModalView.offlineShows, (JSONObject) null);
                int adapterPosition = C0240.this.getAdapterPosition();
                if (adapterPosition != -1) {
                    vF.this.m11905(adapterPosition, vF.this.mo11907(adapterPosition));
                    vF.this.m11906(true);
                    return true;
                }
                C1283.m16863("OfflineBaseAdapter", "longClickListener clickedPosition=%d", Integer.valueOf(adapterPosition));
                return true;
            }
        };

        /* renamed from: ᐝ  reason: contains not printable characters */
        public View f11177;

        /* renamed from: ᐝॱ  reason: contains not printable characters */
        private View.OnClickListener f11178 = new View.OnClickListener() { // from class: o.vF.ˊ.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = C0240.this.getAdapterPosition();
                if (adapterPosition != -1) {
                    vF.this.m11905(adapterPosition, vF.this.mo11907(adapterPosition));
                } else {
                    C1283.m16863("OfflineBaseAdapter", "checkmarkClickListener position=%d", Integer.valueOf(adapterPosition));
                }
            }
        };

        public C0240(View view) {
            super(view);
            this.f11177 = view.findViewById(R.id.item_header);
            this.f11162 = view.findViewById(R.id.item_content);
            this.f11170 = (C0522) view.findViewById(R.id.box_shot);
            this.f11173 = (TextView) view.findViewById(R.id.title);
            this.f11165 = (TextView) view.findViewById(R.id.download_info);
            this.f11169 = (TextView) view.findViewById(R.id.profile_name);
            this.f11167 = (C0522) view.findViewById(R.id.profile_avatar);
            this.f11164 = (ImageView) view.findViewById(R.id.show_indicator);
            this.f11175 = (TextView) view.findViewById(R.id.download_status);
            this.f11163 = view.findViewById(R.id.play_icon);
            this.f11171 = (DownloadButton) view.findViewById(R.id.download_button);
            this.f11172 = (ProgressBar) view.findViewById(R.id.video_progress);
            this.f11168 = (AppCompatCheckBox) view.findViewById(R.id.checkmark);
            if (BrowseExperience.m1780()) {
                this.f11168.setSupportButtonTintList(ColorStateList.valueOf(ContextCompat.getColor(view.getContext(), R.color.kids_icon_color)));
            }
            this.f11162.setOnClickListener(this.f11174);
            this.f11162.setOnLongClickListener(this.f11176);
            this.f11168.setOnClickListener(this.f11178);
            this.f11170.setForeground(null);
        }
    }

    public vF(NetflixActivity netflixActivity, AbstractC1853hl hlVar, AbstractC0241 r4) {
        this.f11149 = netflixActivity;
        this.f11151 = r4;
        this.f11152 = hlVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new C2229iF(this.f11149.getLayoutInflater().inflate(R.layout.offline_list_footer_item, viewGroup, false));
        }
        return new C0240(this.f11149.getLayoutInflater().inflate(R.layout.offline_list_item, viewGroup, false));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11906(boolean z) {
        this.f11150.m11921(z);
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m11915() {
        return this.f11150.m11922();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m11900() {
        return this.f11150.m11926();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m11910() {
        return m11911(this.f11150.f11156);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11905(int i, String str) {
        this.f11150.m11927(i, str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11904() {
        this.f11150.m11925();
        if (this.f11150.m11926() == getItemCount()) {
            C1283.m16862("OfflineBaseAdapter", "All the titles on this screen were removed - finishing the activity");
            this.f11149.finish();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11914(C0240 r4, int i, String str, boolean z) {
        C2098qr r2;
        if (z) {
            r4.f11170.setScaleX(this.f11150.m11924(i) ? 0.8f : 1.0f);
            r4.f11170.setScaleY(this.f11150.m11924(i) ? 0.8f : 1.0f);
            r4.f11172.setScaleX(this.f11150.m11924(i) ? 0.8f : 1.0f);
            r4.f11172.setScaleY(this.f11150.m11924(i) ? 0.8f : 1.0f);
            r4.f11168.setChecked(this.f11150.m11924(i));
            r4.itemView.setLongClickable(true);
            r4.itemView.setClickable(true);
        } else {
            r4.f11170.setScaleX(1.0f);
            r4.f11170.setScaleY(1.0f);
            r4.itemView.setLongClickable(false);
            r4.itemView.setClickable(false);
        }
        ViewUtils.m3002(r4.f11168, z && this.f11150.m11922());
        if (str != null && (r2 = C2093qn.m10096(str)) != null) {
            if (r2.getType() == VideoType.SHOW) {
                ViewUtils.m3002(r4.f11164, !this.f11150.m11922());
            } else if (r2.getType() == VideoType.MOVIE || r2.getType() == VideoType.EPISODE) {
                ViewUtils.m3002(r4.f11171, !this.f11150.m11922());
                ViewUtils.m3002((View) r4.f11164, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11901(C0240 r5, int i, String str, VideoType videoType) {
        CharSequence r2 = videoType == null ? null : vO.m12029(this.f11152).mo11970(this.f11149, i, str, videoType);
        boolean r3 = C1349Bv.m4112(r2);
        if (r3) {
            r5.f11175.setText(r2);
        }
        ViewUtils.m3002(r5.f11175, r3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m11897() {
        if (!C1317As.m3750(this.f11149)) {
            this.f11149.invalidateOptionsMenu();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11908() {
        notifyDataSetChanged();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public oX m11913(String str) {
        return vO.m12020(vO.m12029(this.f11152).mo11976(str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11909(NetflixActionBar.iF.AbstractC0010 r2, String str, int i) {
        r2.mo399(false).mo394((CharSequence) str).mo393(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11912(NetflixActionBar.iF.AbstractC0010 r3, String str, int i) {
        r3.mo399(false).mo396(false).mo402(str).mo390(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public String m11911(long j) {
        return BG.m3861(this.f11149, j);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m11899() {
        this.f11150.m11923();
    }
}
