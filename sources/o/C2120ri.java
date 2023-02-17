package o;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.service.webclient.model.leafs.TrackableObject;
import com.netflix.mediaclient.servicemgr.UiLocation;
import o.AbstractC0801;
/* renamed from: o.ri  reason: case insensitive filesystem */
public class C2120ri extends C2122rk implements qV {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private AbstractC0801.Cif f9893;

    /* renamed from: ʾ  reason: contains not printable characters */
    private GridLayoutManager f9894;

    /* renamed from: ˈ  reason: contains not printable characters */
    private qQ f9895;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int f9896 = 1;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C2120ri m10432(String str) {
        C2120ri riVar = new C2120ri();
        Bundle bundle = new Bundle();
        bundle.putString("video_id", str);
        riVar.setArguments(bundle);
        return riVar;
    }

    @Override // o.C2122rk, o.qW, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null) {
            this.f9896 = bundle.getInt("saved_state_active_tab_mdp", 1);
            Parcelable parcelable = bundle.getParcelable("trailersLayoutState");
            if (parcelable != null) {
                this.f9906.getLayoutManager().onRestoreInstanceState(parcelable);
            }
        }
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2122rk
    /* renamed from: ˈ  reason: contains not printable characters */
    public void mo10433() {
        super.mo10433();
        m10431();
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m10431() {
        this.f9893 = C1353Bz.m4154(this.f9906);
        this.f9895 = new qQ(this.f9893);
        this.f9894 = C1353Bz.m4152(getActivity(), this.f9895);
        this.f9895.m15327(this.f9559);
    }

    @Override // o.C2122rk, o.AbstractC0517, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("saved_state_active_tab_mdp", this.f9896);
        if (this.f9894 != null && this.f9896 == 2) {
            mo10452(this.f9894.onSaveInstanceState());
            bundle.putParcelable("trailersLayoutState", this.f9894.onSaveInstanceState());
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2122rk
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo9987(pP pPVar) {
        super.mo9987(pPVar);
        if (pPVar != null) {
            m10430(pPVar);
            mo10458(pPVar);
            this.f9895.m15328(pPVar.getTrailers());
        }
        switch (this.f9896) {
            case 1:
                Q_();
                if (this.f9559 instanceof rA) {
                    ((rA) this.f9559).m10132();
                    return;
                }
                return;
            case 2:
                U_();
                if (this.f9559 instanceof rA) {
                    ((rA) this.f9559).m10133();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m10430(pP pPVar) {
        super.m10455(pPVar);
        this.f9895.m15329(new TrackableObject(pPVar.getTrailersRequestId(), pPVar.getTrailersTrackId(), pPVar.getTrailersListPos()), UiLocation.MDP_SIMILARS);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2122rk
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo10434(pP pPVar) {
    }

    @Override // o.qV
    public void Q_() {
        this.f9896 = 1;
        this.f9906.setAdapter(this.f9902);
        if (this.f9904 != null) {
            this.f9906.setLayoutManager(this.f9904);
        }
        this.f9906.removeItemDecoration(this.f9907);
        this.f9906.addItemDecoration(this.f9907);
    }

    @Override // o.qV
    public void U_() {
        this.f9896 = 2;
        this.f9906.setAdapter(this.f9895);
        this.f9906.setLayoutManager(this.f9894);
        this.f9906.removeItemDecoration(this.f9907);
    }

    @Override // o.qV
    public void R_() {
    }
}
