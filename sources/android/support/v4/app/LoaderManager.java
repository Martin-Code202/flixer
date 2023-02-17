package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        Loader<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(Loader<D> loader, D d);

        void onLoaderReset(Loader<D> loader);
    }

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> Loader<D> initLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    public boolean hasRunningLoaders() {
        return false;
    }
}
