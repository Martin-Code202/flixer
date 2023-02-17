package com.netflix.mediaclient.net;
enum AppVisibilityState {
    FOREGROUND,
    BACKGROUND;

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        switch (this) {
            case FOREGROUND:
                return "foreground";
            case BACKGROUND:
                return "background";
            default:
                return "unknown";
        }
    }
}
