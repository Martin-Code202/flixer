package o;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.previews.PreviewsSlideShowFragment$onCreateView$1;
import java.util.HashMap;
/* renamed from: o.za  reason: case insensitive filesystem */
public final class C2365za extends AbstractC0517 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private HashMap f12775;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C2369ze f12776;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private yX f12777;

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m13591() {
        if (this.f12775 != null) {
            this.f12775.clear();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final /* synthetic */ yX m13589(C2365za zaVar) {
        yX yXVar = zaVar.f12777;
        if (yXVar == null) {
            C1457Fr.m5017("previewsSlideShowUIPresenter");
        }
        return yXVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final /* synthetic */ C2369ze m13590(C2365za zaVar) {
        C2369ze zeVar = zaVar.f12776;
        if (zeVar == null) {
            C1457Fr.m5017("previewsSlideShowUIView");
        }
        return zeVar;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        Intent intent;
        C1457Fr.m5025(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("list_id")) == null) {
            str = "";
        }
        if (viewGroup == null) {
            C1276.m16820().mo5725("container is null, cant create previews slideshow ui");
            return null;
        }
        this.f12776 = new C2369ze(viewGroup, new PreviewsSlideShowFragment$onCreateView$1(this), str);
        C2369ze zeVar = this.f12776;
        if (zeVar == null) {
            C1457Fr.m5017("previewsSlideShowUIView");
        }
        this.f12777 = new yX(zeVar, bundle, str);
        C2369ze zeVar2 = this.f12776;
        if (zeVar2 == null) {
            C1457Fr.m5017("previewsSlideShowUIView");
        }
        return zeVar2.m14352();
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(getContext(), NetflixActivity.class);
        if (netflixActivity != null) {
            netflixActivity.runWhenManagerIsReady(new Cif(this));
        }
    }

    /* renamed from: o.za$if  reason: invalid class name */
    public static final class Cif extends NetflixActivity.If {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C2365za f12778;

        Cif(C2365za zaVar) {
            this.f12778 = zaVar;
        }

        @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
        public void run(C2059ph phVar) {
            C1457Fr.m5025(phVar, "manager");
            C2365za.m13590(this.f12778).m13627(phVar);
            yX r0 = C2365za.m13589(this.f12778);
            C2059ph r1 = this.f12778.m14536();
            C1457Fr.m5016((Object) r1, "serviceManager");
            r0.m13309(r1);
        }
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        C1457Fr.m5025(bundle, "outState");
        super.onSaveInstanceState(bundle);
        yX yXVar = this.f12777;
        if (yXVar == null) {
            C1457Fr.m5017("previewsSlideShowUIPresenter");
        }
        yXVar.mo13307(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C2369ze zeVar = this.f12776;
        if (zeVar == null) {
            C1457Fr.m5017("previewsSlideShowUIView");
        }
        zeVar.mo13628();
        yX yXVar = this.f12777;
        if (yXVar == null) {
            C1457Fr.m5017("previewsSlideShowUIPresenter");
        }
        yXVar.mo13308();
        m13591();
    }
}
