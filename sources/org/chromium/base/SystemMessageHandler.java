package org.chromium.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.base.annotations.CalledByNative;
class SystemMessageHandler extends Handler {
    private long mDelayedScheduledTimeTicks;
    private long mMessagePumpDelegateNative;
    private long mMessagePumpNative;

    private native void nativeDoRunLoopOnce(long j, long j2, long j3);

    protected SystemMessageHandler(long j, long j2) {
        this.mMessagePumpDelegateNative = j;
        this.mMessagePumpNative = j2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 2) {
            this.mDelayedScheduledTimeTicks = 0;
        }
        nativeDoRunLoopOnce(this.mMessagePumpDelegateNative, this.mMessagePumpNative, this.mDelayedScheduledTimeTicks);
    }

    @CalledByNative
    private void scheduleWork() {
        sendMessage(obtainAsyncMessage(1));
    }

    @CalledByNative
    private void scheduleDelayedWork(long j, long j2) {
        if (this.mDelayedScheduledTimeTicks != 0) {
            removeMessages(2);
        }
        this.mDelayedScheduledTimeTicks = j;
        sendMessageDelayed(obtainAsyncMessage(2), j2);
    }

    @CalledByNative
    private void removeAllPendingMessages() {
        removeMessages(1);
        removeMessages(2);
    }

    private Message obtainAsyncMessage(int i) {
        Message obtain = Message.obtain();
        obtain.what = i;
        MessageCompat.setAsynchronous(obtain, true);
        return obtain;
    }

    /* access modifiers changed from: package-private */
    public static class MessageCompat {
        static final MessageWrapperImpl IMPL;

        /* access modifiers changed from: package-private */
        public interface MessageWrapperImpl {
            void setAsynchronous(Message message, boolean z);
        }

        public static void setAsynchronous(Message message, boolean z) {
            IMPL.setAsynchronous(message, z);
        }

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                IMPL = new LollipopMr1MessageWrapperImpl();
            } else {
                IMPL = new LegacyMessageWrapperImpl();
            }
        }

        static class LollipopMr1MessageWrapperImpl implements MessageWrapperImpl {
            LollipopMr1MessageWrapperImpl() {
            }

            @Override // org.chromium.base.SystemMessageHandler.MessageCompat.MessageWrapperImpl
            @SuppressLint({"NewApi"})
            public void setAsynchronous(Message message, boolean z) {
                message.setAsynchronous(z);
            }
        }

        static class LegacyMessageWrapperImpl implements MessageWrapperImpl {
            private Method mMessageMethodSetAsynchronous;

            LegacyMessageWrapperImpl() {
                try {
                    this.mMessageMethodSetAsynchronous = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
                } catch (ClassNotFoundException e) {
                    Log.e("cr.SysMessageHandler", "Failed to find android.os.Message class", e);
                } catch (NoSuchMethodException e2) {
                    Log.e("cr.SysMessageHandler", "Failed to load Message.setAsynchronous method", e2);
                } catch (RuntimeException e3) {
                    Log.e("cr.SysMessageHandler", "Exception while loading Message.setAsynchronous method", e3);
                }
            }

            @Override // org.chromium.base.SystemMessageHandler.MessageCompat.MessageWrapperImpl
            public void setAsynchronous(Message message, boolean z) {
                if (this.mMessageMethodSetAsynchronous != null) {
                    try {
                        this.mMessageMethodSetAsynchronous.invoke(message, Boolean.valueOf(z));
                    } catch (IllegalAccessException e) {
                        Log.e("cr.SysMessageHandler", "Illegal access to async message creation, disabling.", new Object[0]);
                        this.mMessageMethodSetAsynchronous = null;
                    } catch (IllegalArgumentException e2) {
                        Log.e("cr.SysMessageHandler", "Illegal argument for async message creation, disabling.", new Object[0]);
                        this.mMessageMethodSetAsynchronous = null;
                    } catch (InvocationTargetException e3) {
                        Log.e("cr.SysMessageHandler", "Invocation exception during async message creation, disabling.", new Object[0]);
                        this.mMessageMethodSetAsynchronous = null;
                    } catch (RuntimeException e4) {
                        Log.e("cr.SysMessageHandler", "Runtime exception during async message creation, disabling.", new Object[0]);
                        this.mMessageMethodSetAsynchronous = null;
                    }
                }
            }
        }
    }

    @CalledByNative
    private static SystemMessageHandler create(long j, long j2) {
        return new SystemMessageHandler(j, j2);
    }
}
