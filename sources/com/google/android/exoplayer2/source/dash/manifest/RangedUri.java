package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.UriUtil;
public final class RangedUri {
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(String str, long j, long j2) {
        this.referenceUri = str == null ? "" : str;
        this.start = j;
        this.length = j2;
    }

    public Uri resolveUri(String str) {
        return UriUtil.resolveToUri(str, this.referenceUri);
    }

    public String resolveUriString(String str) {
        return UriUtil.resolve(str, this.referenceUri);
    }

    public RangedUri attemptMerge(RangedUri rangedUri, String str) {
        String resolveUriString = resolveUriString(str);
        if (rangedUri == null || !resolveUriString.equals(rangedUri.resolveUriString(str))) {
            return null;
        }
        if (this.length != -1 && this.start + this.length == rangedUri.start) {
            return new RangedUri(resolveUriString, this.start, rangedUri.length == -1 ? -1 : this.length + rangedUri.length);
        } else if (rangedUri.length == -1 || rangedUri.start + rangedUri.length != this.start) {
            return null;
        } else {
            return new RangedUri(resolveUriString, rangedUri.start, this.length == -1 ? -1 : rangedUri.length + this.length);
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((int) this.start) + 527) * 31) + ((int) this.length)) * 31) + this.referenceUri.hashCode();
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        return this.start == rangedUri.start && this.length == rangedUri.length && this.referenceUri.equals(rangedUri.referenceUri);
    }
}
