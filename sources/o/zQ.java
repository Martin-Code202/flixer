package o;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import java.util.concurrent.TimeUnit;
public class zQ extends Fragment {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final long f12704 = TimeUnit.SECONDS.toMillis(1);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_survey_thanks, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        new Handler().postDelayed(new Runnable() { // from class: o.zQ.3
            @Override // java.lang.Runnable
            public void run() {
                if (zQ.this.getActivity() != null && !zQ.this.getActivity().isFinishing()) {
                    zQ.this.getActivity().overridePendingTransition(17432577, 17432576);
                    zQ.this.getActivity().finish();
                }
            }
        }, f12704);
    }
}
