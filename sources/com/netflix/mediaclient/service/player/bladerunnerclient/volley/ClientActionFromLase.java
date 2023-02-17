package com.netflix.mediaclient.service.player.bladerunnerclient.volley;

import com.netflix.mediaclient.StatusCode;
public enum ClientActionFromLase {
    NO_ACTION(0),
    ACQUIRE_NEW_LICENSE(1),
    DELETE_LICENSES(2),
    MARK_PLAYABLE(3),
    DELETE_CONTENT_ON_REVOCATION(4);
    

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f1716;

    private ClientActionFromLase(int i) {
        this.f1716 = i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m972() {
        return this.f1716;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public StatusCode m973() {
        switch (this) {
            case NO_ACTION:
            case DELETE_LICENSES:
            case MARK_PLAYABLE:
            default:
                return StatusCode.OK;
            case ACQUIRE_NEW_LICENSE:
                return StatusCode.OFFLINE_LICENSE_FETCH_NEW;
            case DELETE_CONTENT_ON_REVOCATION:
                return StatusCode.DL_ENCODES_DELETE_ON_REVOCATION;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static ClientActionFromLase m971(int i) {
        ClientActionFromLase[] values = values();
        for (ClientActionFromLase clientActionFromLase : values) {
            if (clientActionFromLase.f1716 == i) {
                return clientActionFromLase;
            }
        }
        return NO_ACTION;
    }
}
