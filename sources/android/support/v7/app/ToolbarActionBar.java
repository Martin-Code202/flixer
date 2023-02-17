package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;
/* access modifiers changed from: package-private */
public class ToolbarActionBar extends ActionBar {
    DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private boolean mMenuCallbackSet;
    private final Toolbar.OnMenuItemClickListener mMenuClicker = new Toolbar.OnMenuItemClickListener() { // from class: android.support.v7.app.ToolbarActionBar.2
        @Override // android.support.v7.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, menuItem);
        }
    };
    private final Runnable mMenuInvalidator = new Runnable() { // from class: android.support.v7.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.populateOptionsMenu();
        }
    };
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    boolean mToolbarMenuPrepared;
    Window.Callback mWindowCallback;

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        this.mWindowCallback = new ToolbarCallbackWrapper(callback);
        this.mDecorToolbar.setWindowCallback(this.mWindowCallback);
        toolbar.setOnMenuItemClickListener(this.mMenuClicker);
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public Window.Callback getWrappedWindowCallback() {
        return this.mWindowCallback;
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.mDecorToolbar.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setElevation(float f) {
        ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), f);
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.mDecorToolbar.setNavigationContentDescription(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void setDisplayOptions(int i, int i2) {
        this.mDecorToolbar.setDisplayOptions((i & i2) | ((i2 ^ -1) & this.mDecorToolbar.getDisplayOptions()));
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        return this.mDecorToolbar.getVisibility() == 0;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        if (!this.mDecorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void populateOptionsMenu() {
        Menu menu = getMenu();
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            menu.clear();
            if (!this.mWindowCallback.onCreatePanelMenu(0, menu) || !this.mWindowCallback.onPreparePanel(0, null, menu)) {
                menu.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1) {
            return true;
        }
        openOptionsMenu();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menu.performShortcut(i, keyEvent, 0);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBar
    public void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z;
            int size = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < size; i++) {
                this.mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        public ToolbarCallbackWrapper(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !ToolbarActionBar.this.mToolbarMenuPrepared) {
                ToolbarActionBar.this.mDecorToolbar.setMenuPrepared();
                ToolbarActionBar.this.mToolbarMenuPrepared = true;
            }
            return onPreparePanel;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(ToolbarActionBar.this.mDecorToolbar.getContext());
            }
            return super.onCreatePanelView(i);
        }
    }

    private Menu getMenu() {
        if (!this.mMenuCallbackSet) {
            this.mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.mMenuCallbackSet = true;
        }
        return this.mDecorToolbar.getMenu();
    }

    /* access modifiers changed from: package-private */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean mClosingActionMenu;

        ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.mWindowCallback == null) {
                return false;
            }
            ToolbarActionBar.this.mWindowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (!this.mClosingActionMenu) {
                this.mClosingActionMenu = true;
                ToolbarActionBar.this.mDecorToolbar.dismissPopupMenus();
                if (ToolbarActionBar.this.mWindowCallback != null) {
                    ToolbarActionBar.this.mWindowCallback.onPanelClosed(108, menuBuilder);
                }
                this.mClosingActionMenu = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.mWindowCallback == null) {
                return;
            }
            if (ToolbarActionBar.this.mDecorToolbar.isOverflowMenuShowing()) {
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.mWindowCallback.onPreparePanel(0, null, menuBuilder)) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(108, menuBuilder);
            }
        }
    }
}
