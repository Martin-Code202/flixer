package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.manifestwrapper;
public class DashManifestConverterException extends Exception {
    public DashManifestConverterException(String str) {
        super(str);
    }

    public DashManifestConverterException(Exception exc) {
        super(exc);
    }
}
