package o;

import android.content.Context;
import com.netflix.mediaclient.R;
/* renamed from: o.ve  reason: case insensitive filesystem */
public class C2235ve implements AbstractC2097qq {
    @Override // o.AbstractC2097qq
    /* renamed from: ˊ */
    public AbstractC1778fk mo10111(Context context, boolean z, AbstractC1284 r5, AbstractC0358 r6, AbstractC0346 r7) {
        return new C2254vx(new C2253vw(context, z, r5, r6), r7);
    }

    @Override // o.AbstractC2097qq
    /* renamed from: ˊ */
    public String mo10110(Context context, String str, int i, String str2, boolean z, boolean z2) {
        String string = context.getString(R.string.label_episodeTitle, str, Integer.valueOf(i), str2);
        if (z || z2) {
            return context.getString(R.string.label_episodeTitleBasicQuoted, str2);
        }
        return string;
    }

    @Override // o.AbstractC2097qq
    /* renamed from: ˋ */
    public int mo10112(boolean z) {
        return z ? R.string.label_mdx_notification_up_next : R.string.now_playing;
    }
}
