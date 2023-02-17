package o;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import o.C2215uo;
import o.tP;
public class tE extends C2215uo<pJ> {
    @Override // o.C2215uo, o.AbstractC2195ty, o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // o.C2215uo, o.AbstractC2195ty, o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // o.C2215uo, o.AbstractC0837
    /* renamed from: ˏ  reason: contains not printable characters */
    public /* bridge */ /* synthetic */ void mo10895(RecyclerView recyclerView, int i) {
        super.mo10895(recyclerView, i);
    }

    @Override // o.C2215uo
    /* renamed from: ॱ  reason: contains not printable characters */
    public /* bridge */ /* synthetic */ C2215uo.AbstractC0235 mo10897(ViewGroup viewGroup, int i) {
        return super.onCreateViewHolder(viewGroup, i);
    }

    tE(Context context, pC pCVar, C2059ph phVar, UiLocation uiLocation, AbstractC0954 r5, int i) {
        super(context, pCVar, phVar, uiLocation, r5, i);
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ͺ  reason: contains not printable characters */
    public int mo10896() {
        return tP.C0214.m10991(m11286().size(), m15489());
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ˏ  reason: contains not printable characters */
    public int mo10894(Context context, int i) {
        return tP.C0214.m10992(context, i);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2195ty
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo10892(Context context, C2059ph phVar, int i, int i2, oU oUVar, Intent intent) {
        phVar.m9764().mo9494(m11301(), i, i2, false, oUVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2195ty
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo10893(final FlatGenreListOfVideosSummary flatGenreListOfVideosSummary) {
        m11296(m11288().m11036(new pW() { // from class: o.tE.3
            @Override // o.pC
            public int getNumVideos() {
                return flatGenreListOfVideosSummary.getLength();
            }

            @Override // o.pC
            public boolean isRichUITreatment() {
                return false;
            }

            @Override // o.pC
            public void setListPos(int i) {
            }

            @Override // o.pC
            public String getListContext() {
                return null;
            }

            @Override // o.pC
            public long getRefreshInterval() {
                return 0;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
            }

            @Override // o.AbstractC2069pr
            public String getId() {
                return flatGenreListOfVideosSummary.getId();
            }

            @Override // o.AbstractC2069pr
            public String getTitle() {
                return null;
            }

            @Override // o.AbstractC2069pr
            public LoMoType getType() {
                return LoMoType.FLAT_GENRE;
            }

            @Override // o.AbstractC2087qh
            public int getTrackId() {
                return flatGenreListOfVideosSummary.getTrackId();
            }

            @Override // o.AbstractC2087qh
            public int getListPos() {
                return flatGenreListOfVideosSummary.getListPos();
            }

            @Override // o.AbstractC2087qh
            public String getRequestId() {
                return flatGenreListOfVideosSummary.getRequestId();
            }

            @Override // o.AbstractC2087qh
            public String getImpressionToken() {
                return flatGenreListOfVideosSummary.getImpressionToken();
            }

            @Override // o.AbstractC2087qh
            public int getHeroTrackId() {
                return flatGenreListOfVideosSummary.getHeroTrackId();
            }

            @Override // o.AbstractC2087qh
            public boolean isHero() {
                return flatGenreListOfVideosSummary.isHero();
            }
        }));
    }
}
