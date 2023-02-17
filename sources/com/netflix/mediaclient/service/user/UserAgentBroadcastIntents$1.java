package com.netflix.mediaclient.service.user;

import java.util.HashSet;
public class UserAgentBroadcastIntents$1 extends HashSet<String> {
    public UserAgentBroadcastIntents$1() {
        add("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_NOT_LOGGED_IN");
        add("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_ACTIVE");
        add("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE");
        add("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_ACTIVE");
        add("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_DEACTIVE");
        add("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_TYPE_CHANGED");
        add("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_READY_TO_SELECT");
        add("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_SELECTION_RESULT");
        add("com.netflix.mediaclient.intent.action.NOTIFY_PROFILES_LIST_UPDATED");
        add("com.netflix.mediaclient.intent.action.NOTIFY_CURRENT_PROFILE_INVALID");
    }
}
