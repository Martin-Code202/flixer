package o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionValues;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.ui.player.PlanChoice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* renamed from: o.wc  reason: case insensitive filesystem */
public final class C2260wc extends vV {

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final If f11594 = new If(null);

    /* renamed from: ʼ  reason: contains not printable characters */
    private HashMap f11595;

    /* renamed from: ʽ  reason: contains not printable characters */
    private List<String> f11596;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private List<String> f11597;

    @Override // o.vV, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo12067();
    }

    @Override // o.vV
    /* renamed from: ˊॱ */
    public void mo12067() {
        if (this.f11595 != null) {
            this.f11595.clear();
        }
    }

    @Override // o.vV
    /* renamed from: ॱ */
    public View mo12071(int i) {
        if (this.f11595 == null) {
            this.f11595 = new HashMap();
        }
        View view = (View) this.f11595.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f11595.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public C2260wc() {
        List<String> emptyList = Collections.emptyList();
        C1457Fr.m5016((Object) emptyList, "emptyList()");
        this.f11596 = emptyList;
        List<String> emptyList2 = Collections.emptyList();
        C1457Fr.m5016((Object) emptyList2, "emptyList()");
        this.f11597 = emptyList2;
    }

    @Override // o.vV, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        NetflixActivity r0 = m14476();
        if (r0 != null) {
            r0.reportUiViewChanged(mo12074());
        }
        return layoutInflater.inflate(R.layout.plan_upgrade_dialog_frag, viewGroup, false);
    }

    @Override // o.vV, o.AbstractC0496, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (stringArrayList2 = arguments.getStringArrayList("devices")) == null) {
            arrayList = Collections.emptyList();
            C1457Fr.m5016((Object) arrayList, "emptyList()");
        } else {
            arrayList = stringArrayList2;
        }
        this.f11596 = arrayList;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (stringArrayList = arguments2.getStringArrayList("streams")) == null) {
            arrayList2 = Collections.emptyList();
            C1457Fr.m5016((Object) arrayList2, "emptyList()");
        } else {
            arrayList2 = stringArrayList;
        }
        this.f11597 = arrayList2;
        m12420();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final void m12420() {
        if (!C1457Fr.m5018(m12065(), PlanChoice.f3470.m2387())) {
            if (this.f11596.isEmpty()) {
                C0716 r0 = (C0716) mo12071(R.Cif.message);
                C1457Fr.m5016((Object) r0, DeepErrorElement.Debug.MESSAGE);
                r0.setText(getString(R.string.plan_upgrade_upgradable_no_devices_message));
            } else {
                C0716 r02 = (C0716) mo12071(R.Cif.message);
                C1457Fr.m5016((Object) r02, DeepErrorElement.Debug.MESSAGE);
                r02.setText(getString(R.string.plan_upgrade_upgradable_message));
                C0716 r25 = (C0716) mo12071(R.Cif.message);
                C1457Fr.m5016((Object) r25, DeepErrorElement.Debug.MESSAGE);
                StringBuilder sb = new StringBuilder();
                C0716 r1 = (C0716) mo12071(R.Cif.message);
                C1457Fr.m5016((Object) r1, DeepErrorElement.Debug.MESSAGE);
                StringBuilder append = sb.append(r1.getText().toString()).append("\n");
                List<String> list = this.f11596;
                List<String> list2 = this.f11597;
                Iterator<T> it = list.iterator();
                Iterator<T> it2 = list2.iterator();
                ArrayList arrayList = new ArrayList(Math.min(EI.m4812((Iterable) list, 10), EI.m4812((Iterable) list2, 10)));
                while (it.hasNext() && it2.hasNext()) {
                    C1464Fy fy = C1464Fy.f5682;
                    String string = getString(R.string.plan_upgrade_device_dash_video);
                    C1457Fr.m5016((Object) string, "getString(R.string.plan_upgrade_device_dash_video)");
                    Object[] objArr = {it.next(), it2.next()};
                    int length = objArr.length;
                    String format = String.format(string, Arrays.copyOf(objArr, 2));
                    C1457Fr.m5016((Object) format, "java.lang.String.format(format, *args)");
                    arrayList.add(format);
                }
                r25.setContentDescription(append.append(EI.m4836(EI.m4831((Iterable) arrayList, (Comparator) new C2261iF()), "\n", null, null, 0, null, null, 62, null)).toString());
            }
            C0754 r03 = (C0754) mo12071(R.Cif.upgrade_button);
            C1457Fr.m5016((Object) r03, "upgrade_button");
            r03.setText(C0403.m14185(m14476(), R.string.plan_upgrade_to_x_screens).m14187(m12065().m2383()).m14188());
            ((C0754) mo12071(R.Cif.upgrade_button)).setOnClickListener(new View$OnClickListenerC0254(this));
            ((C0754) mo12071(R.Cif.retry_button)).m15172(R.style.res_2131951868_netflixbutton_outline_transparent);
        } else {
            C0716 r04 = (C0716) mo12071(R.Cif.message);
            C1457Fr.m5016((Object) r04, DeepErrorElement.Debug.MESSAGE);
            r04.setText(getString(R.string.plan_upgrade_message));
            C0754 r05 = (C0754) mo12071(R.Cif.upgrade_button);
            C1457Fr.m5016((Object) r05, "upgrade_button");
            r05.setVisibility(8);
            ((C0754) mo12071(R.Cif.retry_button)).m15172(R.style.res_2131951869_netflixbutton_red);
        }
        if (this.f11596.isEmpty()) {
            C0716 r06 = (C0716) mo12071(R.Cif.devices_streaming);
            C1457Fr.m5016((Object) r06, "devices_streaming");
            r06.setVisibility(8);
        } else {
            C0716 r252 = (C0716) mo12071(R.Cif.devices_streaming);
            C1457Fr.m5016((Object) r252, "devices_streaming");
            List<String> list3 = this.f11596;
            List<String> list4 = this.f11597;
            Iterator<T> it3 = list3.iterator();
            Iterator<T> it4 = list4.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(EI.m4812((Iterable) list3, 10), EI.m4812((Iterable) list4, 10)));
            while (it3.hasNext() && it4.hasNext()) {
                C1464Fy fy2 = C1464Fy.f5682;
                String string2 = getString(R.string.plan_upgrade_formatted_device_dash_video);
                C1457Fr.m5016((Object) string2, "getString(R.string.plan_…matted_device_dash_video)");
                Object[] objArr2 = {it3.next(), it4.next()};
                int length2 = objArr2.length;
                String format2 = String.format(string2, Arrays.copyOf(objArr2, 2));
                C1457Fr.m5016((Object) format2, "java.lang.String.format(format, *args)");
                arrayList2.add(format2);
            }
            r252.setText(C1349Bv.m4102(EI.m4836(EI.m4831((Iterable) arrayList2, (Comparator) new C0255()), "<br>", null, null, 0, null, null, 62, null)));
        }
        ((C0754) mo12071(R.Cif.retry_button)).setOnClickListener(new Cif(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.wc$ˊ  reason: contains not printable characters */
    public static final class View$OnClickListenerC0254 implements View.OnClickListener {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C2260wc f11601;

        View$OnClickListenerC0254(C2260wc wcVar) {
            this.f11601 = wcVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f11601.m12421();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.wc$if  reason: invalid class name */
    public static final class Cif implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2260wc f11600;

        Cif(C2260wc wcVar) {
            this.f11600 = wcVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f11600.mo12064();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final void m12421() {
        View view = getView();
        ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
        if (viewGroup != null && !isDetached()) {
            If.C0253 r3 = new If.C0253();
            r3.setDuration(700);
            r3.setInterpolator(new AccelerateDecelerateInterpolator());
            TransitionManager.beginDelayedTransition(viewGroup, r3);
            String string = getString(R.string.plan_upgrade_confirm_to_watch_now);
            String r5 = C0403.m14185(m14476(), R.string.plan_upgrade_x_screens).m14187(m12065().m2383()).m14188();
            String string2 = getString(R.string.plan_upgrade_and_watch);
            C1457Fr.m5016((Object) string, "messageConfirmText");
            C1457Fr.m5016((Object) r5, "planScreensText");
            C1457Fr.m5016((Object) string2, "upgradeButtonText");
            m12072(string, r5, string2);
        }
    }

    /* renamed from: o.wc$iF  reason: case insensitive filesystem */
    public static final class C2261iF<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return EZ.m5000(Integer.valueOf(t.length()), Integer.valueOf(t2.length()));
        }
    }

    /* renamed from: o.wc$ˋ  reason: contains not printable characters */
    public static final class C0255<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return EZ.m5000(Integer.valueOf(t.length()), Integer.valueOf(t2.length()));
        }
    }

    @Override // o.vV
    /* renamed from: ʻ */
    public void mo12064() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.sendBroadcast(new Intent("ACTION_RELOAD_VIDEO"));
        }
        dismiss();
    }

    @Override // o.vV
    /* renamed from: ʽ */
    public void mo12066() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // o.vV
    /* renamed from: ॱॱ */
    public IClientLogging.ModalView mo12074() {
        return IClientLogging.ModalView.planUpgradeGate;
    }

    @Override // o.vV
    /* renamed from: ᐝ */
    public IClientLogging.ModalView mo12075() {
        return IClientLogging.ModalView.planUpgradeConfirmationPrompt;
    }

    @Override // o.vV
    /* renamed from: ˋॱ */
    public IClientLogging.ModalView mo12068() {
        return IClientLogging.ModalView.upgradingPlan;
    }

    @Override // o.vV
    /* renamed from: ॱˊ */
    public String mo12073() {
        return "StreamLimitUpgrade";
    }

    @Override // o.vV
    /* renamed from: ͺ */
    public int mo12070() {
        return R.string.plan_upgrade_streaming_success;
    }

    /* renamed from: o.wc$If */
    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: o.wc$If$ˋ  reason: contains not printable characters */
        public static final class C0253 extends Explode {

            /* renamed from: ˋ  reason: contains not printable characters */
            private final Fade f11598 = new Fade();

            /* renamed from: ॱ  reason: contains not printable characters */
            private final BU f11599 = new BU();

            @Override // android.transition.Explode, android.transition.Visibility
            public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(this.f11598.onAppear(viewGroup, view, transitionValues, transitionValues2), this.f11599.onAppear(viewGroup, view, transitionValues, transitionValues2));
                return animatorSet;
            }

            @Override // android.transition.Explode, android.transition.Visibility, android.transition.Transition
            public void captureStartValues(TransitionValues transitionValues) {
                super.captureStartValues(transitionValues);
                this.f11598.captureStartValues(transitionValues);
                this.f11599.captureStartValues(transitionValues);
            }

            @Override // android.transition.Explode, android.transition.Visibility, android.transition.Transition
            public void captureEndValues(TransitionValues transitionValues) {
                super.captureEndValues(transitionValues);
                this.f11598.captureEndValues(transitionValues);
                this.f11599.captureEndValues(transitionValues);
            }
        }
    }
}
