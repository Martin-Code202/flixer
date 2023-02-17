package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;
public final class Descriptor {
    public final String id;
    public final String schemeIdUri;
    public final String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        return Util.areEqual(this.schemeIdUri, descriptor.schemeIdUri) && Util.areEqual(this.value, descriptor.value) && Util.areEqual(this.id, descriptor.id);
    }

    public int hashCode() {
        return ((((this.schemeIdUri != null ? this.schemeIdUri.hashCode() : 0) * 31) + (this.value != null ? this.value.hashCode() : 0)) * 31) + (this.id != null ? this.id.hashCode() : 0);
    }
}
