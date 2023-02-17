package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
/* access modifiers changed from: package-private */
public abstract class BaseFragmentActivityApi16 extends BaseFragmentActivityApi14 {
    boolean mStartedActivityFromFragment;

    BaseFragmentActivityApi16() {
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
