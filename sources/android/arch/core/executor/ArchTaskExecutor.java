package android.arch.core.executor;

import java.util.concurrent.Executor;
public class ArchTaskExecutor extends TaskExecutor {
    private static final Executor sIOThreadExecutor = new Executor() { // from class: android.arch.core.executor.ArchTaskExecutor.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    };
    private static volatile ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor = new Executor() { // from class: android.arch.core.executor.ArchTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().postToMainThread(runnable);
        }
    };
    private TaskExecutor mDefaultTaskExecutor = new DefaultTaskExecutor();
    private TaskExecutor mDelegate = this.mDefaultTaskExecutor;

    private ArchTaskExecutor() {
    }

    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            if (sInstance == null) {
                sInstance = new ArchTaskExecutor();
            }
        }
        return sInstance;
    }

    @Override // android.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    @Override // android.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }

    @Override // android.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }
}
