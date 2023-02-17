package org.linphone.core;
public final class VideoSize {
    public static final int CIF = 1;
    public static final int HVGA = 2;
    public static final int QCIF = 0;
    public static final int QVGA = 3;
    public static final VideoSize VIDEO_SIZE_1020P = new VideoSize(1920, 1080);
    public static final VideoSize VIDEO_SIZE_720P = new VideoSize(1280, 720);
    public static final VideoSize VIDEO_SIZE_CIF = new VideoSize(352, 288);
    public static final VideoSize VIDEO_SIZE_HVGA = new VideoSize(320, 480);
    public static final VideoSize VIDEO_SIZE_QCIF = new VideoSize(176, 144);
    public static final VideoSize VIDEO_SIZE_QVGA = new VideoSize(320, 240);
    public static final VideoSize VIDEO_SIZE_VGA = new VideoSize(640, 480);
    public int height;
    public int width;

    public VideoSize() {
    }

    public VideoSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Deprecated
    public static final VideoSize createStandard(int i, boolean z) {
        switch (i) {
            case 0:
                return z ? new VideoSize(144, 176) : new VideoSize(176, 144);
            case 1:
                return z ? new VideoSize(288, 352) : new VideoSize(352, 288);
            case 2:
                return z ? new VideoSize(320, 480) : new VideoSize(480, 320);
            case 3:
                return z ? new VideoSize(240, 320) : new VideoSize(320, 240);
            default:
                return new VideoSize();
        }
    }

    public boolean isValid() {
        return this.width > 0 && this.height > 0;
    }

    public int hashCode() {
        return ((this.height + 31) * 31) + this.width;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        if (this.height == videoSize.height && this.width == videoSize.width) {
            return true;
        }
        return false;
    }

    public String toDisplayableString() {
        return this.width + "x" + this.height;
    }

    public String toString() {
        return "width = " + this.width + " height = " + this.height;
    }

    public boolean isPortrait() {
        return this.height >= this.width;
    }

    public VideoSize createInverted() {
        return new VideoSize(this.height, this.width);
    }
}
