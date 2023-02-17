package com.netflix.mediaclient.android.app;

import com.netflix.mediaclient.StatusCode;
import java.io.Serializable;
public interface Status extends Serializable {

    public enum ErrorGroup {
        NetworkError,
        HttpError,
        MslError,
        DrmError,
        BladerunnerError,
        ManifestError,
        SubtitleError
    }

    /* renamed from: ʽ */
    ErrorGroup mo295();

    /* renamed from: ˊ */
    boolean mo296();

    /* renamed from: ˊॱ */
    boolean mo306();

    /* renamed from: ˋ */
    boolean mo297();

    /* renamed from: ˎ */
    boolean mo298();

    /* renamed from: ˏ */
    boolean mo301();

    /* renamed from: ॱ */
    StatusCode mo302();

    /* renamed from: ॱˊ */
    String mo307();

    /* renamed from: ॱॱ */
    boolean mo304();

    /* renamed from: ᐝ */
    String mo305();
}
