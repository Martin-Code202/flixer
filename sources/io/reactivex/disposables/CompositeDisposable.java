package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;
public final class CompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean disposed;
    OpenHashSet<Disposable> resources;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    this.disposed = true;
                    OpenHashSet<Disposable> openHashSet = this.resources;
                    this.resources = null;
                    dispose(openHashSet);
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    OpenHashSet<Disposable> openHashSet = this.resources;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.resources = openHashSet;
                    }
                    openHashSet.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "Disposable item is null");
        if (this.disposed) {
            return false;
        }
        synchronized (this) {
            if (this.disposed) {
                return false;
            }
            OpenHashSet<Disposable> openHashSet = this.resources;
            if (openHashSet == null || !openHashSet.remove(disposable)) {
                return false;
            }
            return true;
        }
    }

    public void clear() {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    OpenHashSet<Disposable> openHashSet = this.resources;
                    this.resources = null;
                    dispose(openHashSet);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispose(OpenHashSet<Disposable> openHashSet) {
        if (openHashSet != null) {
            ArrayList arrayList = null;
            Object[] keys = openHashSet.keys();
            for (Object obj : keys) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).dispose();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }
}
