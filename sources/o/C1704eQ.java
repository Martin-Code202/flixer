package o;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;
import java.util.List;
/* renamed from: o.eQ  reason: case insensitive filesystem */
public class C1704eQ implements OptionsProvider {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f6588 = C1704eQ.class.getSimpleName();

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6589 = "CA5E8412";

    @Override // com.google.android.gms.cast.framework.OptionsProvider
    public CastOptions getCastOptions(Context context) {
        if (C1349Bv.m4107(C0352.m13955(context))) {
            this.f6589 = C0352.m13955(context);
        }
        C0352.m13954(context, this.f6589);
        return new CastOptions.Builder().setReceiverApplicationId(this.f6589).build();
    }

    @Override // com.google.android.gms.cast.framework.OptionsProvider
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }
}
