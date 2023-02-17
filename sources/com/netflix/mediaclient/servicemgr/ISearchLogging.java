package com.netflix.mediaclient.servicemgr;
public interface ISearchLogging {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String[] f2589 = {"com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_SESSION_START", "com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_SESSION_END", "com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_SESSION_START", "com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_SESSION_END", "com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_EDIT", "com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_IMPRESSION", "com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_THROTTLE_SESSION_START", "com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_THROTTLE_SESSION_END"};

    public enum InputMode {
        speech,
        keyboard
    }

    public enum SearchType {
        searchQuery,
        searchEntityId
    }
}
