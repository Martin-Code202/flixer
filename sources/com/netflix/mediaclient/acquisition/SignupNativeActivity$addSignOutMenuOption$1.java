package com.netflix.mediaclient.acquisition;

import android.view.MenuItem;
import o.ActivityC2194tx;
import o.C1283;
/* access modifiers changed from: package-private */
public final class SignupNativeActivity$addSignOutMenuOption$1 implements MenuItem.OnMenuItemClickListener {
    final /* synthetic */ SignupNativeActivity this$0;

    SignupNativeActivity$addSignOutMenuOption$1(SignupNativeActivity signupNativeActivity) {
        this.this$0 = signupNativeActivity;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        C1283.m16854(SignupNativeActivity.Companion.getTAG(), "User tapped sign-out button");
        this.this$0.updateNavigationLevel(null);
        this.this$0.startActivity(ActivityC2194tx.m11258(this.this$0));
        return true;
    }
}
