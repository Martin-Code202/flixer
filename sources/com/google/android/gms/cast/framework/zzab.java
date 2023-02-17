package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
public interface zzab extends IInterface {
    void end(boolean z);

    long getSessionRemainingTimeMs();

    void resume(Bundle bundle);

    void start(Bundle bundle);

    IObjectWrapper zzacd();
}
