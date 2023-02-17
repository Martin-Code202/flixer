package com.ibm.icu.impl;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
public abstract class ICUNotifier {
    private List<EventListener> listeners;
    private final Object notifyLock = new Object();
    private NotifyThread notifyThread;

    /* access modifiers changed from: protected */
    public abstract void notifyListener(EventListener eventListener);

    public void notifyChanged() {
        synchronized (this.notifyLock) {
            if (this.listeners != null) {
                if (this.notifyThread == null) {
                    this.notifyThread = new NotifyThread(this);
                    this.notifyThread.setDaemon(true);
                    this.notifyThread.start();
                }
                this.notifyThread.queue((EventListener[]) this.listeners.toArray(new EventListener[this.listeners.size()]));
            }
        }
    }

    static class NotifyThread extends Thread {
        private final ICUNotifier notifier;
        private final List<EventListener[]> queue = new ArrayList();

        NotifyThread(ICUNotifier iCUNotifier) {
            this.notifier = iCUNotifier;
        }

        public void queue(EventListener[] eventListenerArr) {
            synchronized (this) {
                this.queue.add(eventListenerArr);
                notify();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            EventListener[] remove;
            while (true) {
                try {
                    synchronized (this) {
                        while (this.queue.isEmpty()) {
                            wait();
                        }
                        remove = this.queue.remove(0);
                    }
                    for (EventListener eventListener : remove) {
                        this.notifier.notifyListener(eventListener);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
