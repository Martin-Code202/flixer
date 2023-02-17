package o;

import android.os.Bundle;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
public class rB extends C2134rw {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static rB m10134(String str, String str2) {
        rB rBVar = new rB();
        Bundle bundle = new Bundle();
        bundle.putString(NetflixActivity.EXTRA_VIDEO_ID, str);
        bundle.putString("extra_episode_id", str2);
        rBVar.setArguments(bundle);
        return rBVar;
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ˏॱ */
    public int mo9992() {
        return R.layout.video_details_frag_ab9204;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2134rw, o.qW
    /* renamed from: ˎ */
    public void mo9989(View view) {
        this.f9559 = (rA) view.findViewById(R.id.video_details_view_group);
    }
}
