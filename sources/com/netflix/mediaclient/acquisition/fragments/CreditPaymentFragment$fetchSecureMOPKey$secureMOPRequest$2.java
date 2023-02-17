package com.netflix.mediaclient.acquisition.fragments;

import android.widget.Button;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.util.crypto.NetflixPublicKey;
import o.C0524;
import o.C1457Fr;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public final class CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$2<T> implements C0524.If<JSONObject> {
    final /* synthetic */ CreditPaymentFragment this$0;

    CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$2(CreditPaymentFragment creditPaymentFragment) {
        this.this$0 = creditPaymentFragment;
    }

    public final void onResponse(JSONObject jSONObject) {
        long j = jSONObject.getLong("kid");
        int i = jSONObject.getInt("aid");
        String string = jSONObject.getString("modulus");
        C1457Fr.m5016((Object) string, "response.getString(\"modulus\")");
        String string2 = jSONObject.getString("exponent");
        C1457Fr.m5016((Object) string2, "response.getString(\"exponent\")");
        this.this$0.publicKey = new NetflixPublicKey(j, i, string, string2);
        Button button = (Button) this.this$0._$_findCachedViewById(R.Cif.creditButton);
        C1457Fr.m5016((Object) button, "creditButton");
        button.setEnabled(true);
    }
}
