package o;

import android.content.Context;
import com.netflix.mediaclient.R;
/* renamed from: o.ws  reason: case insensitive filesystem */
public class C2277ws implements AbstractC2101qu {
    @Override // o.AbstractC2101qu
    /* renamed from: ॱ */
    public int mo10115(boolean z) {
        return z ? R.string.offline_message_retry : R.string.streaming_message_retry;
    }

    @Override // o.AbstractC2101qu
    /* renamed from: ˊ */
    public String mo10113(Context context) {
        return context.getString(R.string.label_startup_nointernet);
    }

    @Override // o.AbstractC2101qu
    /* renamed from: ˏ */
    public String mo10114(Context context, String str) {
        return context.getString(R.string.NFErr_STREAMING_PLAYBACK_NETWORK, str);
    }

    @Override // o.AbstractC2101qu
    /* renamed from: ॱ */
    public String mo10116(Context context, String str) {
        return context.getString(R.string.NFErr_STREAMING_PLAYBACK_FAILED, str);
    }
}
