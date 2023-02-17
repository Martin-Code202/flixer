package org.linphone.core;
public interface OpenH264DownloadHelperListener {
    void OnError(String str);

    void OnProgress(int i, int i2);
}
