package com.netflix.mediaclient.acquisition;

import o.C1456Fq;
public final class Constants {
    private static final String ACTION_PLAN_SELECTION = "planSelectionAction";
    private static final String ACTION_START_MEMBERSHIP = "startMembershipAction";
    public static final Companion Companion = new Companion(null);
    private static final String FIELD_PARTNER_RESPONSE = "partnerResponse";
    private static final String FIELD_PARTNER_RESPONSE_SIGNATURE = "partnerResponseSignature";
    private static final String FIELD_PLAN_CHOICE = "planChoice";
    private static final String FIELD_RECEIPT = "receipt";
    private static final String FIELD_TIN_CANCEL = FIELD_TIN_CANCEL;
    private static final String FIELD_TIN_DEVICES = FIELD_TIN_DEVICES;
    private static final String FIELD_TIN_PRICING = FIELD_TIN_PRICING;
    private static final String FLOW_SIMPLE_SILVER_SIGNUP = "simpleSilverSignUp";
    private static final String FLOW_SIMPLICITY_SIGNUP = "signupSimplicity";
    private static final String MODE_PLAN_SELECTION = "planSelectionWithContext";
    private static final String MODE_START_MEMBERSHIP_ON_CONTEXT = "startMembershipOnContext";
    private static final String MODE_WELCOME = "welcome";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final String getFLOW_SIMPLICITY_SIGNUP() {
            return Constants.FLOW_SIMPLICITY_SIGNUP;
        }

        public final String getFLOW_SIMPLE_SILVER_SIGNUP() {
            return Constants.FLOW_SIMPLE_SILVER_SIGNUP;
        }

        public final String getMODE_START_MEMBERSHIP_ON_CONTEXT() {
            return Constants.MODE_START_MEMBERSHIP_ON_CONTEXT;
        }

        public final String getMODE_WELCOME() {
            return Constants.MODE_WELCOME;
        }

        public final String getMODE_PLAN_SELECTION() {
            return Constants.MODE_PLAN_SELECTION;
        }

        public final String getACTION_START_MEMBERSHIP() {
            return Constants.ACTION_START_MEMBERSHIP;
        }

        public final String getACTION_PLAN_SELECTION() {
            return Constants.ACTION_PLAN_SELECTION;
        }

        public final String getFIELD_PLAN_CHOICE() {
            return Constants.FIELD_PLAN_CHOICE;
        }

        public final String getFIELD_RECEIPT() {
            return Constants.FIELD_RECEIPT;
        }

        public final String getFIELD_PARTNER_RESPONSE() {
            return Constants.FIELD_PARTNER_RESPONSE;
        }

        public final String getFIELD_PARTNER_RESPONSE_SIGNATURE() {
            return Constants.FIELD_PARTNER_RESPONSE_SIGNATURE;
        }

        public final String getFIELD_TIN_CANCEL() {
            return Constants.FIELD_TIN_CANCEL;
        }

        public final String getFIELD_TIN_DEVICES() {
            return Constants.FIELD_TIN_DEVICES;
        }

        public final String getFIELD_TIN_PRICING() {
            return Constants.FIELD_TIN_PRICING;
        }
    }
}
