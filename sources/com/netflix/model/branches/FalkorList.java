package com.netflix.model.branches;

import android.os.Parcel;
import com.netflix.falkor.BranchMap;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.model.leafs.ListOfMoviesSummary;
import o.AbstractC1264;
import o.C1049;
import o.CO;
import o.pC;
public class FalkorList<T> extends BranchMap<T> implements pC {

    /* renamed from: ʽ  reason: contains not printable characters */
    private UnsummarizedList<FalkorBigRowData> f4087;

    /* renamed from: ˊ  reason: contains not printable characters */
    private UnsummarizedList<C1049> f4088;

    /* renamed from: ˋ  reason: contains not printable characters */
    private UnsummarizedList<FalkorRoarData> f4089;

    /* renamed from: ˎ  reason: contains not printable characters */
    private ListOfMoviesSummary f4090;

    /* renamed from: ˏ  reason: contains not printable characters */
    private UnsummarizedList<UnsummarizedList<C1049>> f4091;

    /* renamed from: ॱ  reason: contains not printable characters */
    private UnsummarizedList<FalkorBillboardData> f4092;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private UnsummarizedList<FalkorPreviewsFeedItem> f4093;

    public FalkorList(AbstractC1264<T> r1) {
        super(r1);
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 0;
                    break;
                }
                break;
            case -711058556:
                if (str.equals("bigRowData")) {
                    c = 5;
                    break;
                }
                break;
            case -569992200:
                if (str.equals("roarData")) {
                    c = 4;
                    break;
                }
                break;
            case -172498039:
                if (str.equals("billboardData")) {
                    c = 3;
                    break;
                }
                break;
            case 116091890:
                if (str.equals("videoEvidence")) {
                    c = 2;
                    break;
                }
                break;
            case 411356348:
                if (str.equals("thirtySecondPreviewData")) {
                    c = 6;
                    break;
                }
                break;
            case 1781258279:
                if (str.equals("discoveryEvidence")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4090;
            case 1:
                return this.f4091;
            case 2:
                return this.f4088;
            case 3:
                return this.f4092;
            case 4:
                return this.f4089;
            case 5:
                return this.f4087;
            case 6:
                return this.f4093;
            default:
                return super.get(str);
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 0;
                    break;
                }
                break;
            case -711058556:
                if (str.equals("bigRowData")) {
                    c = 5;
                    break;
                }
                break;
            case -569992200:
                if (str.equals("roarData")) {
                    c = 4;
                    break;
                }
                break;
            case -172498039:
                if (str.equals("billboardData")) {
                    c = 3;
                    break;
                }
                break;
            case 116091890:
                if (str.equals("videoEvidence")) {
                    c = 2;
                    break;
                }
                break;
            case 411356348:
                if (str.equals("thirtySecondPreviewData")) {
                    c = 6;
                    break;
                }
                break;
            case 1781258279:
                if (str.equals("discoveryEvidence")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ListOfMoviesSummary listOfMoviesSummary = new ListOfMoviesSummary();
                this.f4090 = listOfMoviesSummary;
                return listOfMoviesSummary;
            case 1:
                UnsummarizedList<UnsummarizedList<C1049>> unsummarizedList = new UnsummarizedList<>(CO.f4962);
                this.f4091 = unsummarizedList;
                return unsummarizedList;
            case 2:
                UnsummarizedList<C1049> unsummarizedList2 = new UnsummarizedList<>(CO.f4967);
                this.f4088 = unsummarizedList2;
                return unsummarizedList2;
            case 3:
                UnsummarizedList<FalkorBillboardData> unsummarizedList3 = new UnsummarizedList<>(CO.m4236());
                this.f4092 = unsummarizedList3;
                return unsummarizedList3;
            case 4:
                UnsummarizedList<FalkorRoarData> unsummarizedList4 = new UnsummarizedList<>(CO.m4231());
                this.f4089 = unsummarizedList4;
                return unsummarizedList4;
            case 5:
                UnsummarizedList<FalkorBigRowData> unsummarizedList5 = new UnsummarizedList<>(CO.m4235());
                this.f4087 = unsummarizedList5;
                return unsummarizedList5;
            case 6:
                UnsummarizedList<FalkorPreviewsFeedItem> unsummarizedList6 = new UnsummarizedList<>(CO.m4240());
                this.f4093 = unsummarizedList6;
                return unsummarizedList6;
            default:
                return super.getOrCreate(str);
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 0;
                    break;
                }
                break;
            case -711058556:
                if (str.equals("bigRowData")) {
                    c = 5;
                    break;
                }
                break;
            case -569992200:
                if (str.equals("roarData")) {
                    c = 4;
                    break;
                }
                break;
            case -172498039:
                if (str.equals("billboardData")) {
                    c = 2;
                    break;
                }
                break;
            case 116091890:
                if (str.equals("videoEvidence")) {
                    c = 1;
                    break;
                }
                break;
            case 411356348:
                if (str.equals("thirtySecondPreviewData")) {
                    c = 6;
                    break;
                }
                break;
            case 1781258279:
                if (str.equals("discoveryEvidence")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4090 = (ListOfMoviesSummary) obj;
                return;
            case 1:
                this.f4088 = (UnsummarizedList) obj;
                return;
            case 2:
                this.f4092 = (UnsummarizedList) obj;
                return;
            case 3:
                this.f4091 = (UnsummarizedList) obj;
                return;
            case 4:
                this.f4089 = (UnsummarizedList) obj;
                return;
            case 5:
                this.f4087 = (UnsummarizedList) obj;
                return;
            case 6:
                this.f4093 = (UnsummarizedList) obj;
                return;
            default:
                super.set(str, obj);
                return;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    @Override // o.AbstractC2069pr
    public String getId() {
        if (this.f4090 == null) {
            return null;
        }
        return this.f4090.getId();
    }

    @Override // o.AbstractC2069pr
    public String getTitle() {
        if (this.f4090 == null) {
            return null;
        }
        return this.f4090.getTitle();
    }

    @Override // o.AbstractC2069pr
    public LoMoType getType() {
        return this.f4090 == null ? LoMoType.STANDARD : this.f4090.getType();
    }

    @Override // o.AbstractC2087qh
    public int getTrackId() {
        if (this.f4090 == null) {
            return -1;
        }
        return this.f4090.getTrackId();
    }

    @Override // o.AbstractC2087qh
    public int getListPos() {
        if (this.f4090 == null) {
            return 0;
        }
        return this.f4090.getListPos();
    }

    @Override // o.AbstractC2087qh
    public String getRequestId() {
        if (this.f4090 == null) {
            return null;
        }
        return this.f4090.getRequestId();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        throw new IllegalStateException("unsupported method");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        throw new IllegalStateException("unsupported method");
    }

    @Override // o.pC
    public int getNumVideos() {
        if (this.f4090 == null) {
            return 0;
        }
        return this.f4090.getNumVideos();
    }

    @Override // o.pC
    public boolean isRichUITreatment() {
        return this.f4090 != null && this.f4090.isRichUITreatment();
    }

    @Override // o.pC
    public void setListPos(int i) {
        if (this.f4090 != null) {
            this.f4090.setListPos(i);
        }
    }

    @Override // o.pC
    public long getRefreshInterval() {
        if (this.f4090 == null) {
            return 0;
        }
        return this.f4090.getRefreshInterval();
    }

    @Override // o.pC
    public String getListContext() {
        if (this.f4090 == null) {
            return null;
        }
        return this.f4090.getListContext();
    }

    @Override // o.AbstractC2087qh
    public int getHeroTrackId() {
        return this.f4090.getHeroTrackId();
    }

    @Override // o.AbstractC2087qh
    public String getImpressionToken() {
        return this.f4090.getImpressionToken();
    }

    @Override // o.AbstractC2087qh
    public boolean isHero() {
        return this.f4090.isHero();
    }
}
