package o;

import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.HashMap;
/* renamed from: o.or  reason: case insensitive filesystem */
public class C2042or {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final HashMap<String, AddToListData> f9361 = new HashMap<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    final C2059ph f9362;

    public C2042or(C2059ph phVar) {
        this.f9362 = phVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C2067pp m9707(NetflixActivity netflixActivity, TextView textView, String str, VideoType videoType, int i, boolean z) {
        return new C2067pp(this, netflixActivity, textView, str, videoType, i, z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C2067pp m9699(NetflixActivity netflixActivity, TextView textView, TextView textView2, String str, VideoType videoType, int i, boolean z) {
        return new oW(this, netflixActivity, textView, textView2, str, videoType, i, z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C2067pp m9700(NetflixActivity netflixActivity, TextView textView, String str, VideoType videoType, int i) {
        return new oW(this, netflixActivity, textView, null, str, videoType, i, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9702(String str, AddToListData.Cif ifVar) {
        AddToListData addToListData = this.f9361.get(str);
        if (addToListData == null) {
            C1283.m16846("AddToMyListWrapper", "Creating new state data for video: " + str);
            addToListData = new AddToListData(ifVar);
            this.f9361.put(str, addToListData);
        } else {
            addToListData.m1477(ifVar);
            C1283.m16846("AddToMyListWrapper", "Found state data for video: " + str + ", state: " + addToListData.m1476());
        }
        ifVar.mo1480(addToListData.m1476());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9705(String str, AddToListData.Cif ifVar) {
        AddToListData addToListData = this.f9361.get(str);
        if (addToListData == null) {
            C1283.m16865("AddToMyListWrapper", "Unexpected case - can't find listener for video: " + str);
        } else {
            addToListData.m1479(ifVar);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9708(String str, boolean z) {
        m9698(str, z ? AddToListData.AddToListState.IN_LIST : AddToListData.AddToListState.NOT_IN_LIST);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9701(Status status, String str, boolean z, boolean z2) {
        AddToListData addToListData = this.f9361.get(str);
        if (addToListData == null) {
            C1283.m16846("AddToMyListWrapper", "Could not revert state for video: " + str);
            return;
        }
        addToListData.m1475();
        if (z2) {
            C1004.m15958(this.f9362.m9814(), z ? R.string.label_error_adding_to_list : R.string.label_error_removing_from_list, 1);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9704(String str) {
        m9698(str, AddToListData.AddToListState.LOADING);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9698(String str, AddToListData.AddToListState addToListState) {
        AddToListData addToListData = this.f9361.get(str);
        if (addToListData == null) {
            C1283.m16846("AddToMyListWrapper", "No listeners for video: " + str);
        } else {
            addToListData.m1478(addToListState);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9706(String str, VideoType videoType, int i, String str2) {
        this.f9362.m9764().mo9469(str, videoType, i, str2, new oP("AddToMyListWrapper"));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9703(String str, VideoType videoType, String str2) {
        this.f9362.m9764().mo9483(str, videoType, str2, new oP("AddToMyListWrapper"));
    }
}
