package android.support.v4.app;
public abstract class FragmentTransaction {
    public abstract FragmentTransaction add(int i, Fragment fragment, String str);

    public abstract FragmentTransaction add(Fragment fragment, String str);

    public abstract FragmentTransaction addToBackStack(String str);

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public abstract FragmentTransaction hide(Fragment fragment);

    public abstract FragmentTransaction remove(Fragment fragment);

    public abstract FragmentTransaction replace(int i, Fragment fragment);

    public abstract FragmentTransaction replace(int i, Fragment fragment, String str);

    public abstract FragmentTransaction setCustomAnimations(int i, int i2);

    public abstract FragmentTransaction setTransition(int i);

    public abstract FragmentTransaction show(Fragment fragment);
}
