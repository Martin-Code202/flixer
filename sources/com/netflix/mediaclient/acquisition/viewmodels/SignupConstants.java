package com.netflix.mediaclient.acquisition.viewmodels;

import java.util.List;
import o.EI;
public final class SignupConstants {
    public static final SignupConstants INSTANCE = new SignupConstants();

    public static final class Flow {
        public static final Flow INSTANCE = new Flow();
        public static final String SIGNUP_SIMPLICITY = "signupSimplicity";
        public static final String SIMPLE_SILVER_SIGN_UP = "simpleSilverSignUp";

        private Flow() {
        }
    }

    private SignupConstants() {
    }

    public static final class Mode {
        public static final String CONFIRM = "confirm";
        public static final String CONFIRM_MEMBERSHIP_STARTED = "confirmMembershipStarted";
        public static final String CONFIRM_WITH_CONTEXT = "confirmWithContext";
        public static final String CREDIT_OPTION = "creditOptionMode";
        public static final String EDIT_PLAN_SELECTION = "editPlanSelection";
        public static final String ENTER_MEMBER_CREDENTIALS = "enterMemberCredentials";
        public static final String FALLBACK = "fallback";
        public static final String GIFT_OPTION = "giftOptionMode";
        public static final Mode INSTANCE = new Mode();
        public static final String MEMBER_HOME = "memberHome";
        public static final String OBTAIN_CONSENT = "obtainConsent";
        public static final String ONBOARDING = "onboarding";
        public static final String PAYMENT_WITH_CONTEXT = "payAndStartMembershipWithContext";
        public static final String PAY_START_MEMBERSHIP = "payAndStartMembership";
        public static final String PLAN_SELECTION = "planSelection";
        public static final String PLAN_SELECTION_WITH_CONTEXT = "planSelectionWithContext";
        public static final String REGISTRATION = "registration";
        public static final String REGISTRATION_WITH_CONTEXT = "registrationWithContext";
        public static final String RESTORE = "restore";
        public static final String SIGNUP_BLOCKED = "signupBlocked";
        public static final String START_MEMBERSHIP_ON_CONTEXT = "startMembershipOnContext";
        public static final String SWITCH_FLOW = "switchFlow";
        public static final String WARN_USER = "warnUser";
        public static final String WELCOME = "welcome";

        private Mode() {
        }

        public final List<String> values() {
            return EI.m4804("welcome", "enterMemberCredentials", "planSelection", "planSelectionWithContext", "registration", "registrationWithContext", "payAndStartMembershipWithContext", "payAndStartMembership", CREDIT_OPTION, GIFT_OPTION, "confirm", "confirmWithContext", CONFIRM_MEMBERSHIP_STARTED, ONBOARDING, "memberHome", WARN_USER, START_MEMBERSHIP_ON_CONTEXT, FALLBACK, RESTORE, SWITCH_FLOW);
        }
    }

    public static final class Field {
        public static final String ADAPTIVE_FIELDS = "adaptiveFields";
        public static final String CARDS = "cards";
        public static final String COUNTRY_CODE = "countryCode";
        public static final String CS_CONTACT_US_URL = "csContactUsUrl";
        public static final String CS_PHONE_NUMBER = "csPhoneNumber";
        public static final String DEV_PAYLOAD = "devPayload";
        public static final String EMAIL = "email";
        public static final String EMAIL_CONSENT = "emailConsent";
        public static final String EMAIL_CONSENT_LABEL_ID = "emailConsentLabelId";
        public static final String EMAIL_PREFERENCE = "emailPreference";
        public static final String ERROR_CODE = "errorCode";
        public static final String EXPECT = "expect";
        public static final String FALLBACK_TRIGGER_MODE = "fallbackTriggerMode";
        public static final String FALLBACK_TRIGGER_REASON = "fallbackTriggerReason";
        public static final String FIRST_NAME = "firstName";
        public static final String FREE_TRIAL_END_DATE = "freeTrialEndDate";
        public static final String HAS_ACCEPTED_TERMS_OF_USE = "hasAcceptedTermsOfUse";
        public static final String HAS_FREE_TRIAL = "hasFreeTrial";
        public static final String INFORMATION_ABROAD_CONSENT = "informationAbroadConsent";
        public static final Field INSTANCE = new Field();
        public static final String LABEL = "label";
        public static final String LAST_NAME = "lastName";
        public static final String MESSAGES = "messages";
        public static final String MOBILE_PHONE = "mobilePhone";
        public static final String MONEYBALL_FIELD = "moneyballField";
        public static final String OFFER_ID = "offerId";
        public static final String PARTNER_ID = "partnerID";
        public static final String PARTNER_RESPONSE = "partnerResponse";
        public static final String PARTNER_RESPONSE_SIGNATURE = "partnerResponseSignature";
        public static final String PASSWORD = "password";
        public static final String PLAN_CHOICE = "planChoice";
        public static final String PLAN_HAS_HD = "planHasHd";
        public static final String PLAN_HAS_ULTRA_HD = "planHasUltraHd";
        public static final String PLAN_MAX_SCREEN_COUNT = "planMaxScreenCount";
        public static final String PLAN_NAME = "planName";
        public static final String PLAN_PRICE = "planPrice";
        public static final String PLAN_ROWS = "rows";
        public static final String PLAYSTORE_FALLBACK_ENABLED = "playStoreFallbackEnabled";
        public static final String RECEIPT = "receipt";
        public static final String RECOGNIZED_FORMER_MEMBER = "recognizedFormerMember";
        public static final String RECOGNIZED_NEVER_MEMBER = "recognizedNeverMember";
        public static final String REGION_EU = "eu";
        public static final String REGION_FR = "fr";
        public static final String REGION_US = "us";
        public static final String REST_OF_WORLD = "rest";
        public static final String SELECTED_PLAN = "selectedPlan";
        public static final String SLIDING_DOORS = "slidingDoors";
        public static final String STEPS = "steps";
        public static final String STRING = "string";
        public static final String TARGET_FLOW = "targetFlow";
        public static final String TARGET_MODE = "targetMode";
        public static final String TARGET_NETFLIX_CLIENT_PLATFORM = "targetNetflixClientPlatform";
        public static final String TERMS_OF_USE_MINIMUM_VERIFICATION_AGE = "termsOfUseMinimumVerificationAge";
        public static final String TERMS_OF_USE_REGION = "termsOfUseRegion";
        public static final String THIRD_PARTY_CONSENT = "thirdPartyConsent";
        public static final String USER_MESSAGE = "userMessage";

        private Field() {
        }
    }

    public static final class Message {
        public static final String CTA = "cta";
        public static final String CTA_BUTTON = "ctaButton";
        public static final Message INSTANCE = new Message();
        public static final String NEXT = "next";
        public static final String PLAN_SUBTITLE = "headerSubtitleMessage";
        public static final String PLAN_TITLE = "headerTitleMessage";
        public static final String REG_SUBTITLE = "registrationFormSubtitle";
        public static final String REG_TITLE = "registrationFormTitle";
        public static final String STRING = "string";
        public static final String TEXT_DISCLAIMER = "textDisclaimer";
        public static final String VALUE_PROP_MESSAGE = "valuePropMessage";
        public static final String VALUE_PROP_MESSAGE_SECONDARY = "valuePropMessageSecondary";

        private Message() {
        }
    }

    public static final class Action {
        public static final String CANCEL_ACTION = "cancelAction";
        public static final String CONFIRM_ORDER_ACTION = "confirmOrderAction";
        public static final String FALLBACK_ACTION = "fallbackAction";
        public static final Action INSTANCE = new Action();
        public static final String PLAN_SELECTION = "planSelectionAction";
        public static final String RESTORE_ACTION = "restoreAction";
        public static final String START_MEMBERSHIP = "startMembershipAction";

        private Action() {
        }
    }

    public static final class Key {
        public static final String CTA_BUTTON = "ctaButton";
        public static final String CURRENT_STEP = "currentStep";
        public static final String FIELDS = "fields";
        public static final String HEADER_SUBTITLE_MESSAGE = "headerSubtitleMessage";
        public static final String HEADER_TITLE_MESSAGE = "headerTitleMessage";
        public static final String ID = "ID";
        public static final Key INSTANCE = new Key();
        public static final String OFFERS = "offers";
        public static final String PLAN_OPTIONS = "options";
        public static final String TOTAL_STEPS = "totalSteps";
        public static final String VALUE = "value";

        private Key() {
        }
    }

    public static final class Events {
        public static final Events INSTANCE = new Events();
        public static final String SIMPLICITY_GOOGLE_PLAY_PURCHASE_END = "simplicityGooglePlayPurchaseEnd";
        public static final String SIMPLICITY_PRICE_FETCHING_END = "simplicityPriceFetchingEnd";
        public static final String SIMPLICITY_SUBMIT_GOOGLE_PLAY_RECEIPT_END = "simplicitySubmitGooglePlayReceiptEnd";

        private Events() {
        }
    }

    public static final class LoggingEvent {
        public static final String APPEND_REJOIN = "_rejoin";
        public static final String CONFIRM = "confirm";
        public static final String CONFIRM_WITH_CONTEXT = "confirmWithContext";
        public static final LoggingEvent INSTANCE = new LoggingEvent();
        public static final String ORDER_CONFIRM = "orderConfirm";
        public static final String ORDER_FINAL = "orderfinal";
        public static final String PAYMENT_WITH_CONTEXT = "payAndStartMembershipWithContext";
        public static final String PAY_START_MEMBERSHIP = "payAndStartMembership";
        public static final String PLAN_SELECTION = "planSelection";
        public static final String PLAN_SELECTION_WITH_CONTEXT = "planSelectionWithContext";
        public static final String REGISTRATION = "registration";
        public static final String REGISTRATION_WITH_CONTEXT = "registrationWithContext";
        public static final String START_MEMBERSHIP_ON_CONTEXT = "payment";
        public static final String WELCOME = "nmLanding";

        private LoggingEvent() {
        }
    }
}
