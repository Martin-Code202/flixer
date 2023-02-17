package com.google.android.gms.internal;

import java.io.IOException;
public final class zzehf extends IOException {
    public zzehf(String str) {
        super(str);
    }

    static zzehf zzcek() {
        return new zzehf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzehf zzcel() {
        return new zzehf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzehf zzcem() {
        return new zzehf("CodedInputStream encountered a malformed varint.");
    }

    static zzehf zzcen() {
        return new zzehf("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
