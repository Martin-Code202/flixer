package com.netflix.mediaclient.protocol.nflx;
public interface NflxHandler {

    public enum Response {
        HANDLING,
        NOT_HANDLING,
        HANDLING_WITH_DELAY
    }

    Response c_();
}
