package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
public abstract class FragmentHostCallback<E> extends FragmentContainer {
    private final Activity mActivity;
    final Context mContext;
    final FragmentManagerImpl mFragmentManager;
    private final Handler mHandler;
    final int mWindowAnimations;

    public abstract E onGetHost();

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.mWindowAnimations = i;
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.startIntentSenderForResult(this.mActivity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void onRequestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
    }

    public boolean onShouldShowRequestPermissionRationale(String str) {
        return false;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    @Override // android.support.v4.app.FragmentContainer
    public View onFindViewById(int i) {
        return null;
    }

    @Override // android.support.v4.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Activity getActivity() {
        return this.mActivity;
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    public Handler getHandler() {
        return this.mHandler;
    }

    /* access modifiers changed from: package-private */
    public FragmentManagerImpl getFragmentManagerImpl() {
        return this.mFragmentManager;
    }

    /* access modifiers changed from: package-private */
    public void onAttachFragment(Fragment fragment) {
    }
}
