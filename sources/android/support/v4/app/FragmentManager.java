package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
public abstract class FragmentManager {

    public interface BackStackEntry {
        String getName();
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    public abstract FragmentTransaction beginTransaction();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(int i);

    public abstract Fragment findFragmentByTag(String str);

    public abstract BackStackEntry getBackStackEntryAt(int i);

    public abstract int getBackStackEntryCount();

    public abstract List<Fragment> getFragments();

    public abstract boolean isDestroyed();

    public abstract boolean isStateSaved();

    public abstract void popBackStack();

    public abstract void popBackStack(int i, int i2);

    public abstract boolean popBackStackImmediate();

    public abstract void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z);

    public abstract void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks);

    public static abstract class FragmentLifecycleCallbacks {
        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }
    }
}
