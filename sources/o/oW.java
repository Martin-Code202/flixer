package o;

import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
public class oW extends C2067pp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private TextView f9240;

    @Override // o.C2067pp, com.netflix.mediaclient.servicemgr.AddToListData.Cif
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo1480(AddToListData.AddToListState addToListState) {
        super.mo1480(addToListState);
    }

    public oW(C2042or orVar, NetflixActivity netflixActivity, TextView textView, TextView textView2, String str, VideoType videoType, int i, boolean z) {
        super(orVar, netflixActivity, textView, str, videoType, i, z);
        this.f9240 = textView2;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2067pp
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo9587() {
        if (this.f9419 != null) {
            this.f9419.setText(R.string.icon_font_add_to_list);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2067pp
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9588() {
        if (this.f9419 != null) {
            this.f9419.setText(R.string.icon_font_remove_from_list);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2067pp
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo9585() {
        if (this.f9419 != null) {
            this.f9419.setVisibility(0);
        }
        if (this.f9240 != null) {
            this.f9240.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2067pp
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9586() {
        if (this.f9419 != null) {
            this.f9419.setVisibility(8);
        }
        if (this.f9240 != null) {
            this.f9240.setVisibility(8);
        }
    }
}
