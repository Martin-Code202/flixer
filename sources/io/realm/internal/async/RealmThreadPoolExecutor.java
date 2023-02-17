package io.realm.internal.async;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
public class RealmThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = calculateCorePoolSize();
    private boolean isPaused;
    private ReentrantLock pauseLock = new ReentrantLock();
    private Condition unpaused = this.pauseLock.newCondition();

    public static RealmThreadPoolExecutor newDefaultExecutor() {
        return new RealmThreadPoolExecutor(CORE_POOL_SIZE, CORE_POOL_SIZE);
    }

    @SuppressFBWarnings({"DMI_HARDCODED_ABSOLUTE_FILENAME"})
    private static int calculateCorePoolSize() {
        int countFilesInDir = countFilesInDir("/sys/devices/system/cpu/", "cpu[0-9]+");
        if (countFilesInDir <= 0) {
            countFilesInDir = Runtime.getRuntime().availableProcessors();
        }
        if (countFilesInDir <= 0) {
            return 1;
        }
        return (countFilesInDir * 2) + 1;
    }

    private static int countFilesInDir(String str, String str2) {
        final Pattern compile = Pattern.compile(str2);
        try {
            File[] listFiles = new File(str).listFiles(new FileFilter() { // from class: io.realm.internal.async.RealmThreadPoolExecutor.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return compile.matcher(file.getName()).matches();
                }
            });
            if (listFiles == null) {
                return 0;
            }
            return listFiles.length;
        } catch (SecurityException e) {
            return 0;
        }
    }

    private RealmThreadPoolExecutor(int i, int i2) {
        super(i, i2, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
    }

    public Future<?> submitTransaction(Runnable runnable) {
        return super.submit(new BgPriorityRunnable(runnable));
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.pauseLock.lock();
        while (this.isPaused) {
            try {
                this.unpaused.await();
            } catch (InterruptedException e) {
                thread.interrupt();
                return;
            } finally {
                this.pauseLock.unlock();
            }
        }
    }
}
