package android.arch.lifecycle;

import android.support.v4.app.FragmentActivity;
public class ViewModelStores {
    public static ViewModelStore of(FragmentActivity fragmentActivity) {
        if (fragmentActivity instanceof ViewModelStoreOwner) {
            return fragmentActivity.getViewModelStore();
        }
        return HolderFragment.holderFragmentFor(fragmentActivity).getViewModelStore();
    }
}
