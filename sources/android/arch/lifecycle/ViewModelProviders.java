package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.FragmentActivity;
public class ViewModelProviders {
    private static Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    public static ViewModelProvider of(FragmentActivity fragmentActivity) {
        return new ViewModelProvider(ViewModelStores.of(fragmentActivity), ViewModelProvider.AndroidViewModelFactory.getInstance(checkApplication(fragmentActivity)));
    }
}
