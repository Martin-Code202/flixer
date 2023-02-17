package o;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
/* access modifiers changed from: package-private */
/* renamed from: o.pp  reason: case insensitive filesystem */
public class C2067pp implements AddToListData.Cif {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f9415;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final boolean f9416;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C2042or f9417;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final VideoType f9418;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final TextView f9419;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final NetflixActivity f9420;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f9421;

    public C2067pp(C2042or orVar, NetflixActivity netflixActivity, TextView textView, String str, VideoType videoType, int i, boolean z) {
        this.f9417 = orVar;
        this.f9420 = netflixActivity;
        this.f9419 = textView;
        this.f9421 = str;
        this.f9418 = videoType;
        this.f9415 = i;
        this.f9416 = z;
    }

    @Override // com.netflix.mediaclient.servicemgr.AddToListData.Cif
    /* renamed from: ˏ */
    public void mo1480(AddToListData.AddToListState addToListState) {
        switch (addToListState) {
            case IN_LIST:
                this.f9419.setContentDescription(this.f9420.getString(R.string.label_remove_from_my_list));
                this.f9419.setEnabled(true);
                mo9588();
                this.f9419.setOnClickListener(new View.OnClickListener() { // from class: o.pp.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2067pp.this.mo9587();
                        C1004.m15961(C2067pp.this.f9420, C2067pp.this.f9419.getContext().getString(R.string.toast_details_action_removed_from_mylist), 0);
                        C1362Ch.m4422(null, C2067pp.this.f9420.getUiScreen().f4084);
                        Logger.INSTANCE.m142(new C1265());
                        String str = null;
                        if (C2067pp.this.f9420 instanceof DetailsActivity) {
                            str = ((DetailsActivity) C2067pp.this.f9420).m1636();
                        }
                        C2067pp.this.f9417.m9703(C2067pp.this.f9421, C2067pp.this.f9418, str);
                    }
                });
                break;
            case NOT_IN_LIST:
                this.f9419.setContentDescription(this.f9420.getString(R.string.label_add_to_my_list));
                this.f9419.setEnabled(true);
                mo9587();
                this.f9419.setOnClickListener(new View.OnClickListener() { // from class: o.pp.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2067pp.this.mo9588();
                        C1004.m15961(C2067pp.this.f9420, C2067pp.this.f9419.getContext().getString(R.string.toast_details_action_added_to_mylist), 0);
                        C1362Ch.m4389((UserActionLogging.CommandName) null, C2067pp.this.f9420.getUiScreen().f4084);
                        Logger.INSTANCE.m142(new C1039());
                        String str = null;
                        if (C2067pp.this.f9420 instanceof DetailsActivity) {
                            str = ((DetailsActivity) C2067pp.this.f9420).m1636();
                        }
                        C2067pp.this.f9417.m9706(C2067pp.this.f9421, C2067pp.this.f9418, C2067pp.this.f9415, str);
                        Intent intent = new Intent();
                        intent.putExtra("pre_release_video_id", C2067pp.this.f9421);
                        intent.setAction("com.netflix.mediaclient.mylist.intent.action.ADD");
                        C2067pp.this.f9419.getContext().sendBroadcast(intent);
                    }
                });
                break;
            case LOADING:
                this.f9419.setEnabled(false);
                break;
        }
        if (this.f9416) {
            return;
        }
        if (this.f9417.f9362.m9822()) {
            mo9585();
        } else {
            mo9586();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo9585() {
        this.f9419.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public void mo9586() {
        this.f9419.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public void mo9587() {
        this.f9419.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(this.f9420, R.drawable.ic_mylist_plus), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f9419.setText(this.f9420.getString(R.string.label_my_list_2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public void mo9588() {
        this.f9419.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(this.f9420, R.drawable.ic_mylist_check), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f9419.setText(this.f9420.getString(R.string.label_my_list_2));
    }
}
