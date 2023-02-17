package o;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.credentials.Credential;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.app.Status;
public class AS {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3411(Credential credential, Status status, Intent intent) {
        if (credential != null) {
            String id = credential.getId();
            String password = credential.getPassword();
            if (C1349Bv.m4107(id)) {
                intent.putExtra(SignupConstants.Field.EMAIL, id);
                if (C1349Bv.m4107(password)) {
                    intent.putExtra(SignupConstants.Field.PASSWORD, password);
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3410(Context context) {
        return m3412() && AD.m3321(context);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m3412() {
        return true;
    }
}
