package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import java.util.List;
import o.pJ;
public class oA<T extends pJ> extends oP {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f9217;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final long f9218;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f9219;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Cif<T> f9220;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f9221;

    /* renamed from: o.oA$if  reason: invalid class name */
    public interface Cif<T> {
        /* renamed from: ˋ  reason: contains not printable characters */
        void mo9387(FlatGenreListOfVideosSummary flatGenreListOfVideosSummary);

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo9388(String str, int i, int i2);

        /* renamed from: ˎ  reason: contains not printable characters */
        void mo9389();

        /* renamed from: ˎ  reason: contains not printable characters */
        void mo9390(List<T> list, String str, int i, int i2);

        /* renamed from: ॱ  reason: contains not printable characters */
        long mo9391();
    }

    public oA(String str, Cif<T> ifVar, String str2, int i, int i2) {
        super(str);
        this.f9220 = ifVar;
        this.f9218 = ifVar.mo9391();
        this.f9221 = str2;
        this.f9219 = i;
        this.f9217 = i2;
    }

    @Override // o.oP, o.oU
    public void onVideosFetched(List<pJ> list, Status status) {
        super.onVideosFetched(list, status);
        m9386(list, status);
    }

    @Override // o.oP, o.oU
    public void onCWVideosFetched(List<AbstractC2074pw> list, Status status) {
        super.onCWVideosFetched(list, status);
        m9386(list, status);
    }

    @Override // o.oP, o.oU
    public void onShortFormVideosFetched(List<Object> list, Status status) {
        super.onShortFormVideosFetched(list, status);
        m9386(list, status);
    }

    @Override // o.oP, o.oU
    public void onPreviewsFetched(List<pD> list, Status status) {
        super.onPreviewsFetched(list, status);
        m9386(list, status);
    }

    @Override // o.oP, o.oU
    public void onBBVideosFetched(List<AbstractC2077pz> list, Status status) {
        super.onBBVideosFetched(list, status);
        m9386(list, status);
    }

    @Override // o.oP, o.oU
    public void onBigRowVideofetched(List<AbstractC2070ps> list, Status status) {
        super.onBigRowVideofetched(list, status);
        m9386(list, status);
    }

    @Override // o.oP, o.oU
    public void onTallPanelVideosFetched(List<pK> list, Status status) {
        super.onTallPanelVideosFetched(list, status);
        m9386(list, status);
    }

    @Override // o.oP, o.oU
    public void onFlatGenreVideosFetched(FlatGenreListOfVideosSummary flatGenreListOfVideosSummary, List<pJ> list, Status status) {
        super.onFlatGenreVideosFetched(flatGenreListOfVideosSummary, list, status);
        if (flatGenreListOfVideosSummary != null) {
            this.f9220.mo9387(flatGenreListOfVideosSummary);
        }
        m9386(list, status);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m9386(List<? extends pJ> list, Status status) {
        if (this.f9218 != this.f9220.mo9391()) {
            C1283.m16846(this.f9234, "Ignoring stale onVideosFetched callback");
        } else if (status.mo301()) {
            C1283.m16865(this.f9234, "Invalid status code");
            this.f9220.mo9389();
        } else if (list == null || list.size() <= 0) {
            C1283.m16854(this.f9234, "No videos in response");
            this.f9220.mo9388(this.f9221, this.f9219, this.f9217);
        } else {
            this.f9220.mo9390(list, this.f9221, this.f9219, this.f9217);
        }
    }
}
