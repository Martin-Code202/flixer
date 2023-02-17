package o;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.util.log.UIScreen;
/* renamed from: o.zv  reason: case insensitive filesystem */
public class C2390zv implements AbstractC2141sc {
    @Override // o.AbstractC2141sc
    /* renamed from: ॱ */
    public boolean mo10080(Intent intent) {
        return intent.getComponent() != null && intent.getComponent().getClassName().equals(ActivityC2392zx.m13837().getCanonicalName());
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˋ */
    public AbstractC0517 mo10061(Intent intent) {
        C1283.m16853("SearchSuggestionGalleryCreator", "createFragment: ", intent);
        if (mo10080(intent)) {
            return C2393zy.m13853(intent);
        }
        return null;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public boolean mo10074() {
        return false;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ʽ */
    public AppView mo10051(Intent intent) {
        return AppView.searchResults;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ᐝ */
    public UIScreen mo10083() {
        return UIScreen.searchResults;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ʻ */
    public AbstractC0574 mo10050(Intent intent) {
        return null;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public boolean mo10075(Intent intent) {
        return false;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˊ */
    public void mo10055(Intent intent, AbstractC0517 r2, boolean z) {
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˋ */
    public void mo10062(Intent intent, AbstractC0517 r2, boolean z) {
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public void mo10069(Intent intent, Fragment fragment) {
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˎ */
    public void mo10066(Intent intent, Fragment fragment) {
    }
}
