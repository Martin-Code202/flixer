package com.netflix.mediaclient.acquisition.fragments;

import android.widget.TabHost;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class WelcomeFragment$initTINTabs$1 implements TabHost.OnTabChangeListener {
    final /* synthetic */ WelcomeFragment this$0;

    WelcomeFragment$initTINTabs$1(WelcomeFragment welcomeFragment) {
        this.this$0 = welcomeFragment;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public final void onTabChanged(String str) {
        WelcomeFragment welcomeFragment = this.this$0;
        C1457Fr.m5016((Object) str, "tabId");
        welcomeFragment.switchTab(str);
    }
}
