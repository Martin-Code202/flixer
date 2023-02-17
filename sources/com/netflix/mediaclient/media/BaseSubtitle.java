package com.netflix.mediaclient.media;
public abstract class BaseSubtitle implements Subtitle {
    protected static final String ATTR_CAN_DEVICE_RENDER = "canDeviceRender";
    protected static final String ATTR_FORCED_NARRATIVE = "isForcedNarrative";
    protected static final String ATTR_ID = "id";
    protected static final String ATTR_LANGUAGE = "language";
    protected static final String ATTR_LANGUAGE_DESCRIPTION = "languageDescription";
    protected static final String ATTR_NONE_TRACK = "isNoneTrack";
    public static final String ATTR_ORDER = "order";
    protected static final String ATTR_SELECTED = "selected";
    protected static final String ATTR_TRACK_TYPE = "trackType";
    public static final String IMPL = "impl";
    protected boolean canDeviceRender;
    protected String id;
    protected boolean isForcedNarrative;
    protected boolean isNone;
    protected String languageCodeIso639_1;
    protected String languageCodeIso639_2;
    protected String languageDescription;
    protected int nccpOrderNumber;
    protected int trackType;

    protected BaseSubtitle() {
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getLanguageCodeIso639_1() {
        return this.languageCodeIso639_1;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getLanguageCodeIso639_2() {
        return this.languageCodeIso639_2;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getLanguageDescription() {
        return this.languageDescription;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public int getTrackType() {
        return this.trackType;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public boolean canDeviceRender() {
        return this.canDeviceRender;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public int getNccpOrderNumber() {
        return this.nccpOrderNumber;
    }

    public int compareTo(Subtitle subtitle) {
        if (subtitle == null) {
            return -1;
        }
        if (!this.isForcedNarrative && !this.isNone && subtitle.isForcedNarrativeOrNone()) {
            return 1;
        }
        if (((this.isForcedNarrative || this.isNone) && !subtitle.isForcedNarrativeOrNone()) || this.languageDescription == null) {
            return -1;
        }
        if (subtitle.getLanguageDescription() == null) {
            return 1;
        }
        int compare = String.CASE_INSENSITIVE_ORDER.compare(this.languageDescription, subtitle.getLanguageDescription());
        if (compare == 0) {
            return this.languageDescription.compareTo(subtitle.getLanguageDescription());
        }
        return compare;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getId() {
        return this.id;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public boolean isCC() {
        return this.trackType == 2;
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + " [id=" + this.id + ", languageCodeIso639_1=" + this.languageCodeIso639_1 + ", languageCodeIso639_2=" + this.languageCodeIso639_2 + ", languageDescription=" + this.languageDescription + ", trackType=" + this.trackType + ", canDeviceRender=" + this.canDeviceRender + ", nccpOrderNumber=" + this.nccpOrderNumber + "]";
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.nccpOrderNumber + 31;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof Subtitle) && this.nccpOrderNumber == ((Subtitle) obj).getNccpOrderNumber();
    }
}
