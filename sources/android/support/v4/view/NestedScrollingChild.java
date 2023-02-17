package android.support.v4.view;
public interface NestedScrollingChild {
    @Override // android.support.v4.view.NestedScrollingChild
    boolean isNestedScrollingEnabled();

    @Override // android.support.v4.view.NestedScrollingChild
    void stopNestedScroll();
}
