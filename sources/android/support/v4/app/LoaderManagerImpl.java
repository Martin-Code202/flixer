package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* access modifiers changed from: package-private */
public class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    private boolean mCreatingLoader;
    private final LifecycleOwner mLifecycleOwner;
    private final LoaderViewModel mLoaderViewModel;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;

        LoaderInfo(int i, Bundle bundle, Loader<D> loader) {
            this.mId = i;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mLoader.registerListener(i, this);
        }

        /* access modifiers changed from: package-private */
        public Loader<D> getLoader() {
            return this.mLoader;
        }

        /* access modifiers changed from: protected */
        @Override // android.arch.lifecycle.LiveData
        public void onActive() {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.mLoader.startLoading();
        }

        /* access modifiers changed from: protected */
        @Override // android.arch.lifecycle.LiveData
        public void onInactive() {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mLoader.stopLoading();
        }

        /* access modifiers changed from: package-private */
        public Loader<D> setCallback(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.mLoader, loaderCallbacks);
            observe(lifecycleOwner, loaderObserver);
            if (this.mObserver != null) {
                removeObserver(this.mObserver);
            }
            this.mLifecycleOwner = lifecycleOwner;
            this.mObserver = loaderObserver;
            return this.mLoader;
        }

        /* access modifiers changed from: package-private */
        public void markForRedelivery() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (lifecycleOwner != null && loaderObserver != null) {
                removeObserver(loaderObserver);
                observe(lifecycleOwner, loaderObserver);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isCallbackWaitingForData() {
            return hasActiveObservers() && this.mObserver != null && !this.mObserver.hasDeliveredData();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.arch.lifecycle.Observer<D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        public void removeObserver(Observer<D> observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        /* access modifiers changed from: package-private */
        public void destroy() {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                loaderObserver.reset();
            }
            this.mLoader.unregisterListener(this);
            this.mLoader.reset();
        }

        @Override // android.support.v4.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(Loader<D> loader, D d) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            if (LoaderManagerImpl.DEBUG) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            this.mLoader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.mObserver != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.mObserver);
                this.mObserver.dump(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(getLoader().dataToString((D) getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }
    }

    /* access modifiers changed from: package-private */
    public static class LoaderObserver<D> implements Observer<D> {
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData = false;
        private final Loader<D> mLoader;

        LoaderObserver(Loader<D> loader, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.mLoader = loader;
            this.mCallback = loaderCallbacks;
        }

        @Override // android.arch.lifecycle.Observer
        public void onChanged(D d) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(d));
            }
            this.mCallback.onLoadFinished(this.mLoader, d);
            this.mDeliveredData = true;
        }

        /* access modifiers changed from: package-private */
        public boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            if (this.mDeliveredData) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Resetting: " + this.mLoader);
                }
                this.mCallback.onLoaderReset(this.mLoader);
            }
        }

        public String toString() {
            return this.mCallback.toString();
        }

        public void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.mDeliveredData);
        }
    }

    /* access modifiers changed from: package-private */
    public static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory FACTORY = new ViewModelProvider.Factory() { // from class: android.support.v4.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // android.arch.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        private SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<>();

        LoaderViewModel() {
        }

        static LoaderViewModel getInstance(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(LoaderViewModel.class);
        }

        /* access modifiers changed from: package-private */
        public void putLoader(int i, LoaderInfo loaderInfo) {
            this.mLoaders.put(i, loaderInfo);
        }

        /* access modifiers changed from: package-private */
        public <D> LoaderInfo<D> getLoader(int i) {
            return this.mLoaders.get(i);
        }

        /* access modifiers changed from: package-private */
        public boolean hasRunningLoaders() {
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                if (this.mLoaders.valueAt(i).isCallbackWaitingForData()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void markForRedelivery() {
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                this.mLoaders.valueAt(i).markForRedelivery();
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.arch.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                this.mLoaders.valueAt(i).destroy();
            }
            this.mLoaders.clear();
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.mLoaders.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.mLoaders.size(); i++) {
                    LoaderInfo valueAt = this.mLoaders.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.mLoaders.keyAt(i));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = LoaderViewModel.getInstance(viewModelStore);
    }

    private <D> Loader<D> createAndInstallLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        try {
            this.mCreatingLoader = true;
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
            if (!onCreateLoader.getClass().isMemberClass() || Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                LoaderInfo loaderInfo = new LoaderInfo(i, bundle, onCreateLoader);
                if (DEBUG) {
                    Log.v("LoaderManager", "  Created new loader " + loaderInfo);
                }
                this.mLoaderViewModel.putLoader(i, loaderInfo);
                return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
        } finally {
            this.mCreatingLoader = false;
        }
    }

    @Override // android.support.v4.app.LoaderManager
    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        } else {
            LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i);
            if (DEBUG) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (loader == null) {
                return createAndInstallLoader(i, bundle, loaderCallbacks);
            }
            if (DEBUG) {
                Log.v("LoaderManager", "  Re-using existing loader " + loader);
            }
            return loader.setCallback(this.mLifecycleOwner, loaderCallbacks);
        }
    }

    /* access modifiers changed from: package-private */
    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // android.support.v4.app.LoaderManager
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mLoaderViewModel.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.support.v4.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }
}
