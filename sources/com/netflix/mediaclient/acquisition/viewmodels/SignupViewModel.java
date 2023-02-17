package com.netflix.mediaclient.acquisition.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.mediaclient.acquisition.SignInButtonInHeaderType;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import o.C1456Fq;
import o.C1457Fr;
public final class SignupViewModel extends ViewModel {
    public static final Companion Companion = new Companion(null);
    private final MutableLiveData<MoneyballData> currentMoneyballData = new MutableLiveData<>();
    private MutableLiveData<SignInButtonInHeaderType> signInButtonType = new MutableLiveData<>();

    public SignupViewModel() {
        this.signInButtonType.setValue(SignInButtonInHeaderType.SIGN_IN);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final String getShaktiInboundUrl(String str, String str2) {
            C1457Fr.m5025(str, "flow");
            C1457Fr.m5025(str2, "mode");
            return "/aui/inbound?flow=" + str + "&mode=" + str2 + "&sourceNetflixClientPlatform=androidNative";
        }
    }

    public final MutableLiveData<MoneyballData> getCurrentMoneyballData() {
        return this.currentMoneyballData;
    }

    public final FlowMode getCurrentFlowMode() {
        MoneyballData value = this.currentMoneyballData.getValue();
        if (value != null) {
            return value.getFlowMode();
        }
        return null;
    }

    public final MutableLiveData<SignInButtonInHeaderType> getSignInButtonType() {
        return this.signInButtonType;
    }

    public final void setSignInButtonType(MutableLiveData<SignInButtonInHeaderType> mutableLiveData) {
        C1457Fr.m5025(mutableLiveData, "<set-?>");
        this.signInButtonType = mutableLiveData;
    }

    public final void updateSignInButtonInHeader(FlowMode flowMode) {
        C1457Fr.m5025(flowMode, "flowMode");
        FlowMode currentFlowMode = getCurrentFlowMode();
        if (C1457Fr.m5018((Object) (currentFlowMode != null ? currentFlowMode.getId() : null), (Object) SignupConstants.Mode.CONFIRM_MEMBERSHIP_STARTED) || isRecognisedFormerOrNeverMember(flowMode)) {
            this.signInButtonType.setValue(SignInButtonInHeaderType.SIGN_OUT);
        } else {
            this.signInButtonType.setValue(SignInButtonInHeaderType.SIGN_IN);
        }
    }

    private final boolean isRecognisedFormerOrNeverMember(FlowMode flowMode) {
        Field field = flowMode.getField(SignupConstants.Field.RECOGNIZED_FORMER_MEMBER);
        Object value = field != null ? field.getValue() : null;
        if (!(value instanceof Boolean)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Field field2 = flowMode.getField(SignupConstants.Field.RECOGNIZED_NEVER_MEMBER);
        Object value2 = field2 != null ? field2.getValue() : null;
        if (!(value2 instanceof Boolean)) {
            value2 = null;
        }
        Boolean bool2 = (Boolean) value2;
        return booleanValue || (bool2 != null ? bool2.booleanValue() : false);
    }
}
