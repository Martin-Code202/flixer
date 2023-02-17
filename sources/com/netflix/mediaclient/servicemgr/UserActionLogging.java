package com.netflix.mediaclient.servicemgr;

import com.netflix.mediaclient.service.logging.client.model.Event;
import o.C1349Bv;
import org.json.JSONObject;
public interface UserActionLogging {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String[] f2746 = {"com.netflix.mediaclient.intent.action.LOG_UIA_SIGNUP_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SIGNUP_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_ADD_TO_PLAYLIST_START", "com.netflix.mediaclient.intent.action.LOG_UIA_ADD_TO_PLAYLIST_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_LOGIN_START", "com.netflix.mediaclient.intent.action.LOG_UIA_LOGIN_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_REMOVE_FROM_PLAYLIST_START", "com.netflix.mediaclient.intent.action.LOG_UIA_REMOVE_FROM_PLAYLIST_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_NAVIGATION_START", "com.netflix.mediaclient.intent.action.LOG_UIA_NAVIGATION_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_RATE_TITLE_START", "com.netflix.mediaclient.intent.action.LOG_UIA_RATE_TITLE_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_START", "com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SEARCH_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SEARCH_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_START_PLAY_START", "com.netflix.mediaclient.intent.action.LOG_UIA_START_PLAY_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SUBMIT_PAYMENT_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SUBMIT_PAYMENT_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_UPGRADE_STREAMS_START", "com.netflix.mediaclient.intent.action.LOG_UIA_UPGRADE_STREAMS_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PROFILE_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PROFILE_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_ADD_PROFILE_START", "com.netflix.mediaclient.intent.action.LOG_UIA_ADD_PROFILE_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_EDIT_PROFILE_START", "com.netflix.mediaclient.intent.action.LOG_UIA_EDIT_PROFILE_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_DELETE_PROFILE_START", "com.netflix.mediaclient.intent.action.LOG_UIA_DELETE_PROFILE_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_NEW_LOLOMO_START", "com.netflix.mediaclient.intent.action.LOG_UIA_NEW_LOLOMO_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_OPEN_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_OPEN_ENDED", "com.netflix.mediaclient.intent.action.PREAPP_WIDGET_ACTION_START", "com.netflix.mediaclient.intent.action.PREAPP_WIDGET_ACTION_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_POSTPLAY_START", "com.netflix.mediaclient.intent.action.LOG_UIA_POSTPLAY_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_CHANGE_VALUE_START", "com.netflix.mediaclient.intent.action.LOG_UIA_CHANGE_VALUE_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_QUESTION_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_QUESTION_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_PREFETCH_LOLOMO_JOB_START", "com.netflix.mediaclient.intent.action.LOG_UIA_PREFETCH_LOLOMO_JOB_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SERIALIZE_LOLOMO_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SERIALIZE_LOLOMO_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_DESERIALIZE_LOLOMO_START", "com.netflix.mediaclient.intent.action.LOG_UIA_DESERIALIZE_LOLOMO_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_FOR_PUSH_NOTIFICATION_START", "com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_FOR_PUSH_NOTIFICATION_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PLAN_START", "com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PLAN_ENDED", "com.netflix.mediaclient.intent.action.LOG_UIA_CUSTOM_ACTION", "com.netflix.mediaclient.intent.action.LOG_UIA_HIDE_FROM_HISTORY_START", "com.netflix.mediaclient.intent.action.LOG_UIA_HIDE_FROM_HISTORY_ENDED"};

    public enum CommandName {
        rating,
        androidWidgetCommand,
        AddCachedVideoCommand,
        RemoveCachedVideoCommand,
        RemoveAllCachedVideosCommand,
        RemoveCachedVideoAndPlayNextCommand,
        PauseDownloadCommand,
        ResumeDownloadCommand,
        RetryDownloadCommand
    }

    public enum PaymentType {
        directDebit,
        creditCard,
        ideal,
        paypal,
        boletto
    }

    public enum PostPlayExperience {
        PostPlayNextEpisode,
        PostPlaySuggestions
    }

    public enum RememberProfile {
        userNotOfferedChoice,
        userChoseToRemember,
        userChoseNotToRemember
    }

    public enum Streams {
        _1("1"),
        _2("2"),
        _3("3"),
        _4("4");
        

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f2775;

        private Streams(String str) {
            this.f2775 = str;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public String m1565() {
            return this.f2775;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static Streams m1564(String str) {
            if (C1349Bv.m4113(str)) {
                return null;
            }
            Streams[] values = values();
            for (Streams streams : values) {
                if (streams.m1565().equals(str)) {
                    return streams;
                }
            }
            return null;
        }
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.UserActionLogging$ˋ  reason: contains not printable characters */
    public static class C0029 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private Integer f2776;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f2777;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f2778;

        /* renamed from: ॱ  reason: contains not printable characters */
        private boolean f2779;

        public C0029(String str, String str2, Integer num, boolean z) {
            this.f2778 = str;
            this.f2777 = str2;
            this.f2776 = num;
            this.f2779 = z;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public JSONObject m1567() {
            JSONObject jSONObject = new JSONObject();
            if (this.f2778 != null) {
                jSONObject.put("profileId", this.f2778);
            }
            if (this.f2776 != null) {
                jSONObject.put("age", this.f2776.intValue());
            }
            jSONObject.put(Event.KIDS, this.f2779);
            return jSONObject;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m1566() {
            return this.f2778;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public Integer m1569() {
            return this.f2776;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean m1568() {
            return this.f2779;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m1570() {
            return this.f2777;
        }
    }
}
