package com.netflix.mediaclient.acquisition;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment;
import com.netflix.mediaclient.acquisition.fragments.ConfirmFragment;
import com.netflix.mediaclient.acquisition.fragments.ObtainConsentFragment;
import com.netflix.mediaclient.acquisition.fragments.OrderFinalFragment;
import com.netflix.mediaclient.acquisition.fragments.PlanContextFragment;
import com.netflix.mediaclient.acquisition.fragments.PlanSelectionFragment;
import com.netflix.mediaclient.acquisition.fragments.RegistrationContextFragment;
import com.netflix.mediaclient.acquisition.fragments.RegistrationFragment;
import com.netflix.mediaclient.acquisition.fragments.StartMembershipOnContextFragment;
import com.netflix.mediaclient.acquisition.fragments.WarnUserFragment;
import com.netflix.mediaclient.acquisition.fragments.WelcomeFragment;
import com.netflix.mediaclient.acquisition.fragments.WelcomeSlidingDoorsFragment;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.acquisition.viewmodels.WelcomeSlidingDoorsViewModel;
import o.C1457Fr;
public final class SignupMode {
    public static final SignupMode INSTANCE = new SignupMode();

    private SignupMode() {
    }

    public final AbstractSignupFragment mapToFragment(FlowMode flowMode) {
        C1457Fr.m5025(flowMode, "flowMode");
        String id = flowMode.getId();
        switch (id.hashCode()) {
            case 1233099618:
                if (id.equals("welcome")) {
                    if (WelcomeSlidingDoorsViewModel.Companion.isFlowModeSlidingDoors(flowMode)) {
                        return new WelcomeSlidingDoorsFragment();
                    }
                    return new WelcomeFragment();
                }
                break;
        }
        return mapToFragmentForMode(flowMode.getId());
    }

    public final AbstractSignupFragment mapToFragmentForMode(String str) {
        C1457Fr.m5025(str, "mode");
        switch (str.hashCode()) {
            case -1829657365:
                if (str.equals(SignupConstants.Mode.CONFIRM_MEMBERSHIP_STARTED)) {
                    return new OrderFinalFragment();
                }
                break;
            case -1553736919:
                if (str.equals("confirmWithContext")) {
                    return new ConfirmFragment();
                }
                break;
            case -1350309703:
                if (str.equals("registration")) {
                    return new RegistrationFragment();
                }
                break;
            case -1201876008:
                if (str.equals(SignupConstants.Mode.START_MEMBERSHIP_ON_CONTEXT)) {
                    return new StartMembershipOnContextFragment();
                }
                break;
            case -400551024:
                if (str.equals("registrationWithContext")) {
                    return new RegistrationContextFragment();
                }
                break;
            case 142043558:
                if (str.equals("planSelectionWithContext")) {
                    return new PlanContextFragment();
                }
                break;
            case 195396707:
                if (str.equals("planSelection")) {
                    return new PlanSelectionFragment();
                }
                break;
            case 497500017:
                if (str.equals(SignupConstants.Mode.WARN_USER)) {
                    return new WarnUserFragment();
                }
                break;
            case 951117504:
                if (str.equals("confirm")) {
                    return new ConfirmFragment();
                }
                break;
            case 1233099618:
                if (str.equals("welcome")) {
                    return new WelcomeFragment();
                }
                break;
            case 1589765753:
                if (str.equals(SignupConstants.Mode.EDIT_PLAN_SELECTION)) {
                    return new PlanSelectionFragment();
                }
                break;
            case 1929913269:
                if (str.equals(SignupConstants.Mode.OBTAIN_CONSENT)) {
                    return new ObtainConsentFragment();
                }
                break;
        }
        return null;
    }

    public final boolean isLoginMode(String str) {
        C1457Fr.m5025(str, "mode");
        return C1457Fr.m5018(str, "enterMemberCredentials") || C1457Fr.m5018(str, SignupConstants.Mode.SIGNUP_BLOCKED);
    }

    public final boolean isOnboardingMode(String str) {
        C1457Fr.m5025(str, "mode");
        return C1457Fr.m5018((Object) str, (Object) SignupConstants.Mode.ONBOARDING);
    }

    public final boolean isMemberMode(String str) {
        C1457Fr.m5025(str, "mode");
        return C1457Fr.m5018((Object) str, (Object) "memberHome");
    }

    public final boolean isSignupSimplicityFlow(String str) {
        C1457Fr.m5025(str, "flow");
        return C1457Fr.m5018((Object) str, (Object) SignupConstants.Flow.SIGNUP_SIMPLICITY);
    }

    public final boolean isSwitchFlowMode(String str) {
        C1457Fr.m5025(str, "mode");
        return C1457Fr.m5018((Object) str, (Object) SignupConstants.Mode.SWITCH_FLOW);
    }

    public final boolean isOnboardingSwitchFlowMode(FlowMode flowMode) {
        C1457Fr.m5025(flowMode, "flowMode");
        if (INSTANCE.isSwitchFlowMode(flowMode.getId())) {
            Field field = flowMode.getField(SignupConstants.Field.TARGET_FLOW);
            if (C1457Fr.m5018(field != null ? field.getValue() : null, (Object) SignupConstants.Mode.ONBOARDING)) {
                Field field2 = flowMode.getField(SignupConstants.Field.TARGET_MODE);
                if ((field2 != null ? field2.getValue() : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
