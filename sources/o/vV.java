package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.player.PlanChoice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public abstract class vV extends AbstractC0496 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final If f11264 = new If(null);

    /* renamed from: ʽ  reason: contains not printable characters */
    private List<PlanChoice> f11265;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private PlanChoice f11266 = PlanChoice.f3470.m2387();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private HashMap f11267;

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo12067();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public abstract void mo12064();

    /* renamed from: ʽ  reason: contains not printable characters */
    public abstract void mo12066();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void mo12067() {
        if (this.f11267 != null) {
            this.f11267.clear();
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public abstract IClientLogging.ModalView mo12068();

    /* renamed from: ͺ  reason: contains not printable characters */
    public abstract int mo12070();

    /* renamed from: ॱ  reason: contains not printable characters */
    public View mo12071(int i) {
        if (this.f11267 == null) {
            this.f11267 = new HashMap();
        }
        View view = (View) this.f11267.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f11267.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public abstract String mo12073();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public abstract IClientLogging.ModalView mo12074();

    /* renamed from: ᐝ  reason: contains not printable characters */
    public abstract IClientLogging.ModalView mo12075();

    public vV() {
        List<PlanChoice> emptyList = Collections.emptyList();
        C1457Fr.m5016((Object) emptyList, "emptyList()");
        this.f11265 = emptyList;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final PlanChoice m12065() {
        return this.f11266;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        NetflixActivity r0 = m14476();
        if (r0 != null) {
            r0.reportUiViewChanged(mo12074());
        }
        return layoutInflater.inflate(R.layout.plan_upgrade_dialog_frag, viewGroup, false);
    }

    @Override // o.AbstractC0496, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ArrayList arrayList;
        ArrayList parcelableArrayList;
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (parcelableArrayList = arguments.getParcelableArrayList("choices")) == null) {
            arrayList = Collections.emptyList();
            C1457Fr.m5016((Object) arrayList, "emptyList()");
        } else {
            arrayList = parcelableArrayList;
        }
        this.f11265 = arrayList;
        this.f11266 = f11264.m12077(this.f11265);
        m12062();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        mo12066();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.vV$ˊ  reason: contains not printable characters */
    public static final class View$OnClickListenerC0243 implements View.OnClickListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ vV f11270;

        View$OnClickListenerC0243(vV vVVar) {
            this.f11270 = vVVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f11270.mo12066();
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final void m12062() {
        ((C0754) mo12071(R.Cif.cancel_button)).setOnClickListener(new View$OnClickListenerC0243(this));
        if (BrowseExperience.m1780()) {
            C0754 r0 = (C0754) mo12071(R.Cif.upgrade_button);
            C1457Fr.m5016((Object) r0, "upgrade_button");
            r0.setVisibility(8);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m12072(String str, String str2, String str3) {
        C1457Fr.m5025(str, "messageConfirmText");
        C1457Fr.m5025(str2, "planScreensText");
        C1457Fr.m5025(str3, "upgradeButtonText");
        NetflixActivity r0 = m14476();
        if (r0 != null) {
            r0.reportUiViewChanged(mo12075());
        }
        C0716 r02 = (C0716) mo12071(R.Cif.devices_streaming);
        C1457Fr.m5016((Object) r02, "devices_streaming");
        r02.setVisibility(8);
        C0754 r03 = (C0754) mo12071(R.Cif.retry_button);
        C1457Fr.m5016((Object) r03, "retry_button");
        r03.setVisibility(8);
        C0716 r04 = (C0716) mo12071(R.Cif.title);
        C1457Fr.m5016((Object) r04, "title");
        r04.setVisibility(8);
        C0716 r05 = (C0716) mo12071(R.Cif.message);
        C1457Fr.m5016((Object) r05, DeepErrorElement.Debug.MESSAGE);
        r05.setVisibility(8);
        C0716 r06 = (C0716) mo12071(R.Cif.title_confirm);
        C1457Fr.m5016((Object) r06, "title_confirm");
        r06.setVisibility(0);
        C0716 r07 = (C0716) mo12071(R.Cif.message_confirm);
        C1457Fr.m5016((Object) r07, "message_confirm");
        r07.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) mo12071(R.Cif.plan_details);
        C1457Fr.m5016((Object) linearLayout, "plan_details");
        linearLayout.setVisibility(0);
        C0716 r08 = (C0716) mo12071(R.Cif.message_confirm);
        C1457Fr.m5016((Object) r08, "message_confirm");
        r08.setText(str);
        C0716 r09 = (C0716) mo12071(R.Cif.plan_screens);
        C1457Fr.m5016((Object) r09, "plan_screens");
        r09.setText(str2);
        C0716 r010 = (C0716) mo12071(R.Cif.plan_price);
        C1457Fr.m5016((Object) r010, "plan_price");
        r010.setText(getString(R.string.plan_upgrade_cost_per_month, this.f11266.m2373()));
        C0754 r011 = (C0754) mo12071(R.Cif.upgrade_button);
        C1457Fr.m5016((Object) r011, "upgrade_button");
        r011.setText(str3);
        ((C0754) mo12071(R.Cif.upgrade_button)).setOnClickListener(new View$OnClickListenerC0244(this));
    }

    /* renamed from: o.vV$ˋ  reason: contains not printable characters */
    static final class View$OnClickListenerC0244 implements View.OnClickListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ vV f11271;

        View$OnClickListenerC0244(vV vVVar) {
            this.f11271 = vVVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f11271.m12063(this.f11271.m12065());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m12063(PlanChoice planChoice) {
        if (m14476() != null) {
            setCancelable(false);
            ProgressBar progressBar = (ProgressBar) mo12071(R.Cif.progress);
            C1457Fr.m5016((Object) progressBar, "progress");
            progressBar.setVisibility(0);
            C0716 r0 = (C0716) mo12071(R.Cif.title_confirm);
            C1457Fr.m5016((Object) r0, "title_confirm");
            r0.setVisibility(8);
            C0716 r02 = (C0716) mo12071(R.Cif.message_confirm);
            C1457Fr.m5016((Object) r02, "message_confirm");
            r02.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) mo12071(R.Cif.plan_details);
            C1457Fr.m5016((Object) linearLayout, "plan_details");
            linearLayout.setVisibility(8);
            C0754 r03 = (C0754) mo12071(R.Cif.cancel_button);
            C1457Fr.m5016((Object) r03, "cancel_button");
            r03.setVisibility(8);
            C0754 r04 = (C0754) mo12071(R.Cif.retry_button);
            C1457Fr.m5016((Object) r04, "retry_button");
            r04.setVisibility(8);
            C0754 r05 = (C0754) mo12071(R.Cif.upgrade_button);
            C1457Fr.m5016((Object) r05, "upgrade_button");
            r05.setVisibility(8);
            m14476().reportUiViewChanged(mo12068());
            C1362Ch.m4390((UserActionLogging.CommandName) null, mo12068(), Integer.valueOf(planChoice.m2381()));
            m14474().m9779(planChoice.m2381(), planChoice.m2385(), mo12073(), new C2230iF(this, planChoice));
        }
    }

    /* renamed from: o.vV$iF  reason: case insensitive filesystem */
    public static final class C2230iF extends AbstractC2061pj {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ PlanChoice f11268;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ vV f11269;

        C2230iF(vV vVVar, PlanChoice planChoice) {
            this.f11269 = vVVar;
            this.f11268 = planChoice;
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onUpdatePlanCompleted(Status status) {
            this.f11269.m12069(this.f11268.m2381(), status);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m12069(int i, Status status) {
        if (getActivity() != null) {
            C1283.m16862("PlanUpgradeDialogFragment", "onUpdateResult: " + status);
            if (status == null || !status.mo298()) {
                C1362Ch.m4407(IClientLogging.CompletionReason.failed, (UIError) null, Integer.valueOf(i));
                C1004.m15958(getActivity(), (int) R.string.plan_upgrade_failure, 0);
                mo12066();
                return;
            }
            C1362Ch.m4407(IClientLogging.CompletionReason.success, (UIError) null, Integer.valueOf(i));
            C1004.m15958(getActivity(), mo12070(), 0);
            mo12064();
        }
    }

    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final vV m12080(C1935kf kfVar) {
            C1457Fr.m5025(kfVar, ExceptionClEvent.CATEGORY_VALUE);
            C2260wc wcVar = new C2260wc();
            wcVar.setStyle(2, 0);
            Bundle bundle = new Bundle();
            JSONObject r4 = kfVar.m8379();
            JSONArray optJSONArray = r4.optJSONArray("currentViewings");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList<String> arrayList = new ArrayList<>(optJSONArray.length());
                ArrayList<String> arrayList2 = new ArrayList<>(optJSONArray.length());
                Iterator<JSONObject> r8 = C0350.m13943(optJSONArray);
                while (r8.hasNext()) {
                    JSONObject next = r8.next();
                    arrayList.add(next.getString(LoggingRequest.DEVICE));
                    arrayList2.add(next.getString("video"));
                }
                bundle.putStringArrayList("devices", arrayList);
                bundle.putStringArrayList("streams", arrayList2);
            }
            C1457Fr.m5016((Object) r4, "extraInfo");
            m12076(bundle, r4);
            wcVar.setArguments(bundle);
            return wcVar;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final vV m12078(JSONObject jSONObject, oX oXVar) {
            C1457Fr.m5025(jSONObject, "extraInfo");
            C1457Fr.m5025(oXVar, "playContext");
            vX vXVar = new vX();
            vXVar.setStyle(2, 0);
            Bundle bundle = new Bundle();
            bundle.putParcelable("play_context", oXVar);
            m12076(bundle, jSONObject);
            vXVar.setArguments(bundle);
            return vXVar;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private final void m12076(Bundle bundle, JSONObject jSONObject) {
            if (!jSONObject.optBoolean(SignupConstants.Mode.FALLBACK)) {
                bundle.putParcelableArrayList("choices", m12079(jSONObject));
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final ArrayList<PlanChoice> m12079(JSONObject jSONObject) {
            C1457Fr.m5025(jSONObject, "extraInfo");
            JSONArray optJSONArray = jSONObject.optJSONArray("choices");
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList<>();
            if ((optJSONArray != null ? optJSONArray.length() : 0) > 0) {
                FE r8 = FF.m4991(0, optJSONArray.length());
                ArrayList arrayList2 = new ArrayList();
                Iterator it = r8.iterator();
                while (it.hasNext()) {
                    arrayList2.add((PlanChoice) NetflixApplication.m222().fromJson(optJSONArray.get(((EU) it).mo4855()).toString(), (Class<Object>) PlanChoice.class));
                }
                arrayList = arrayList2;
            }
            C1283.m16854("PlanUpgradeDialogFragment", "Time to gson Plan Choices: " + (System.currentTimeMillis() - currentTimeMillis));
            return arrayList;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final PlanChoice m12077(List<PlanChoice> list) {
            if (list != null) {
                for (T t : list) {
                    String r0 = t.m2382();
                    if (r0 != null && r0.equals("IMMEDIATE")) {
                        return t;
                    }
                }
            }
            return PlanChoice.f3470.m2387();
        }
    }
}
