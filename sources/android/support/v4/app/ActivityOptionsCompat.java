package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
public class ActivityOptionsCompat {
    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return createImpl(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
        }
        return new ActivityOptionsCompat();
    }

    private static ActivityOptionsCompat createImpl(ActivityOptions activityOptions) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompatApi24Impl(activityOptions);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompatApi23Impl(activityOptions);
        }
        return new ActivityOptionsCompatApi16Impl(activityOptions);
    }

    /* access modifiers changed from: package-private */
    public static class ActivityOptionsCompatApi16Impl extends ActivityOptionsCompat {
        protected final ActivityOptions mActivityOptions;

        ActivityOptionsCompatApi16Impl(ActivityOptions activityOptions) {
            this.mActivityOptions = activityOptions;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }
    }

    /* access modifiers changed from: package-private */
    public static class ActivityOptionsCompatApi23Impl extends ActivityOptionsCompatApi16Impl {
        ActivityOptionsCompatApi23Impl(ActivityOptions activityOptions) {
            super(activityOptions);
        }
    }

    /* access modifiers changed from: package-private */
    public static class ActivityOptionsCompatApi24Impl extends ActivityOptionsCompatApi23Impl {
        ActivityOptionsCompatApi24Impl(ActivityOptions activityOptions) {
            super(activityOptions);
        }
    }

    protected ActivityOptionsCompat() {
    }

    public Bundle toBundle() {
        return null;
    }
}
