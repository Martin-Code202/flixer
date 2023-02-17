package o;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.netflix.mediaclient.R;
public class sK extends sF {

    /* renamed from: ʽ  reason: contains not printable characters */
    public static int f10042 = 2;

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (AD.m3290((Context) activity) >= 4) {
            f10042 = 2;
        }
    }

    @Override // o.sF, o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f10002 = false;
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // o.sF
    /* renamed from: ˏ */
    public boolean mo10582() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.sF
    /* renamed from: ॱॱ */
    public boolean mo10588() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.sF
    /* renamed from: ᐝॱ */
    public int mo10590() {
        return f10042;
    }

    /* access modifiers changed from: protected */
    @Override // o.sF
    /* renamed from: ॱˋ */
    public int mo10586() {
        return R.layout.standard_sliding_menu_social_notifications_row;
    }

    /* access modifiers changed from: protected */
    @Override // o.sF
    /* renamed from: ͺ */
    public boolean mo10584() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.sF
    /* renamed from: ॱˎ */
    public boolean mo10587() {
        return false;
    }
}
