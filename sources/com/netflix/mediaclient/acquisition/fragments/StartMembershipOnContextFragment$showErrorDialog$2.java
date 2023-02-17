package com.netflix.mediaclient.acquisition.fragments;

import android.content.DialogInterface;
/* access modifiers changed from: package-private */
public final class StartMembershipOnContextFragment$showErrorDialog$2 implements DialogInterface.OnClickListener {
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    StartMembershipOnContextFragment$showErrorDialog$2(StartMembershipOnContextFragment startMembershipOnContextFragment) {
        this.this$0 = startMembershipOnContextFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.sendReceiptToMoneyball();
    }
}
