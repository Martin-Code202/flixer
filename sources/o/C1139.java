package o;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import java.util.List;
/* renamed from: o.ﮈ  reason: contains not printable characters */
public final class C1139 extends AbstractC0454 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f15388;

    public C1139(String str) {
        C1457Fr.m5025(str, "videoId");
        this.f15388 = str;
    }

    @Override // o.AbstractC0454, o.AbstractC0487
    /* renamed from: ˊ */
    public boolean mo14335() {
        return true;
    }

    @Override // o.AbstractC0487
    /* renamed from: ˊ */
    public void mo14421(List<C0859> list) {
        C1457Fr.m5025(list, "pqls");
        C0859 r0 = C0859.m15528("shows", this.f15388, "detail");
        C1457Fr.m5016((Object) r0, "PQL.create(FalkorBranche…SHOWS, videoId, \"detail\")");
        list.add(r0);
        C0859 r02 = C0859.m15528("shows", this.f15388, "episodes", "current");
        C1457Fr.m5016((Object) r02, "PQL.create(FalkorBranche…d, \"episodes\", \"current\")");
        list.add(r02);
        C0859 r03 = C0859.m15528("shows", this.f15388, "seasons", "current");
        C1457Fr.m5016((Object) r03, "PQL.create(FalkorBranche…Id, \"seasons\", \"current\")");
        list.add(r03);
        C0859 r04 = C0859.m15528("shows", this.f15388, "seasons", "summary");
        C1457Fr.m5016((Object) r04, "PQL.create(FalkorBranche…Id, \"seasons\", \"summary\")");
        list.add(r04);
        C0859 r05 = C0859.m15528("shows", this.f15388, "seasons", "all", "detail");
        C1457Fr.m5016((Object) r05, "PQL.create(FalkorBranche…easons\", \"all\", \"detail\")");
        list.add(r05);
        C0859 r06 = C0859.m15528("shows", this.f15388, "seasons", "latest", "episodes", C0859.m15532(0, 39), "detail");
        C1457Fr.m5016((Object) r06, "PQL.create(FalkorBranche…isodes\", range, \"detail\")");
        list.add(r06);
    }

    @Override // o.AbstractC0487
    /* renamed from: ॱ */
    public void mo14423(C0498 r7, AbstractC1203 r8, C0856 r9) {
        C1457Fr.m5025(r7, "cmpTask");
        C1457Fr.m5025(r8, "callbackOnMain");
        CH ch = (CH) r7.f13290.m15584(C0859.m15528("shows", this.f15388));
        if (ch == null || C1349Bv.m4113(ch.getId())) {
            C1276.m16820().mo5725("RefreshSeasonsAndEpisodes bad shows id. Requested: " + this.f15388 + ", got: " + (ch == null ? "rtn=null" : ch.getId()));
            r8.mo8175((pR) null, new FalkorAgentStatus(StatusCode.INT_ERR_CMP_RESP_NULL, false));
            return;
        }
        r8.mo8175((pR) ch, (Status) new FalkorAgentStatus(StatusCode.OK, false));
    }

    @Override // o.AbstractC0487
    /* renamed from: ˋ */
    public void mo14422(AbstractC1203 r2, Status status) {
        C1457Fr.m5025(r2, "callbackOnMain");
        C1457Fr.m5025(status, "res");
        r2.mo8175((pR) null, status);
    }
}
