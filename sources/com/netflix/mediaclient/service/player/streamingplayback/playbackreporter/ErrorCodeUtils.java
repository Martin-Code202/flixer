package com.netflix.mediaclient.service.player.streamingplayback.playbackreporter;

import android.media.MediaCodec;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import com.netflix.mediaclient.service.player.streamingplayback.StreamingPlaybackErrorCode;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.cronetdatasource.CronetDataSource;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import o.C1283;
import o.lX;
import org.chromium.net.NetworkException;
public class ErrorCodeUtils {

    public enum TransactionType {
        Authorization,
        License
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static lX m1127(StreamingPlaybackErrorCode streamingPlaybackErrorCode, Status status) {
        lX lXVar = new lX();
        switch (streamingPlaybackErrorCode) {
            case MANIFEST_PROCESS_ERROR:
            case MANIFEST_CACHE_EXTRACT_ERROR:
                lXVar.f8602 = "1.300." + status.mo302().m271();
                lXVar.f8601 = "NccpAuthorizationFailed.ManifestProcessErr";
                return lXVar;
            case MANIFEST_FETCH_ERROR:
                return m1130(TransactionType.Authorization, status);
            case LICENSE_FETCH_ERROR:
                return m1130(TransactionType.License, status);
            case LICENSE_SESSION_UNAVAILABLE_ERROR:
                lXVar.f8602 = "2.101";
                lXVar.f8601 = "NccpLicenseFailed.DrmNoSessions";
                return lXVar;
            default:
                lXVar.f8602 = "6.1." + streamingPlaybackErrorCode.m1004();
                lXVar.f8601 = "TransactionFailed.Unknown";
                return lXVar;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static lX m1126(ExoPlaybackException exoPlaybackException) {
        lX lXVar = new lX();
        switch (exoPlaybackException.type) {
            case 0:
                IOException sourceException = exoPlaybackException.getSourceException();
                lXVar.f8605 = sourceException.getMessage();
                if (!(sourceException instanceof HttpDataSource.HttpDataSourceException)) {
                    if (!(sourceException instanceof ParserException)) {
                        lXVar.f8602 = "3.3";
                        lXVar.f8601 = "StreamingFailure.Other";
                        lXVar.f8605 = C1283.m16857(sourceException);
                        break;
                    } else {
                        lXVar.f8602 = "4.2";
                        lXVar.f8601 = "EncodingError.ParseError";
                        lXVar.f8600 = sourceException.getMessage();
                        lXVar.f8605 = C1283.m16857(sourceException);
                        break;
                    }
                } else {
                    Throwable cause = sourceException.getCause();
                    boolean z = !(sourceException instanceof CronetDataSource.OpenException);
                    if (sourceException instanceof CronetDataSource.CronetDataSourceException) {
                        lXVar.f8605 = m1125(((CronetDataSource.CronetDataSourceException) sourceException).f1911);
                    }
                    if (!(sourceException instanceof HttpDataSource.InvalidResponseCodeException)) {
                        if (!(sourceException instanceof HttpDataSource.InvalidContentTypeException)) {
                            if (!(cause instanceof UnknownHostException)) {
                                if (!(cause instanceof SocketTimeoutException)) {
                                    if (!(cause instanceof NetworkException)) {
                                        lXVar.f8602 = "3.1";
                                        lXVar.f8601 = "StreamingFailure.Network";
                                        lXVar.f8605 = C1283.m16857(sourceException);
                                        break;
                                    } else {
                                        switch (((NetworkException) cause).getErrorCode()) {
                                            case 1:
                                                lXVar.f8602 = "3.1.-70";
                                                lXVar.f8601 = "StreamingFailure.Network.dnsfailure";
                                                break;
                                            case 2:
                                                if (!z) {
                                                    lXVar.f8602 = "3.1.-101";
                                                    lXVar.f8601 = "StreamingFailure.Network.networkdown";
                                                    break;
                                                } else {
                                                    lXVar.f8602 = "3.1.-104";
                                                    lXVar.f8601 = "StreamingFailure.Network.networkdownreset";
                                                    break;
                                                }
                                            case 3:
                                                lXVar.f8602 = "3.1.-50";
                                                lXVar.f8601 = "StreamingFailure.Network.socketerror";
                                                break;
                                            case 4:
                                                lXVar.f8602 = "3.1.-13";
                                                lXVar.f8601 = "StreamingFailure.Network.datatimeout";
                                                break;
                                            case 5:
                                                lXVar.f8602 = "3.1.-61";
                                                lXVar.f8601 = "StreamingFailure.Network.connectionclosed";
                                                break;
                                            case 6:
                                                lXVar.f8602 = "3.1.-82";
                                                lXVar.f8601 = "StreamingFailure.Network.httpconnectiontimeout";
                                                break;
                                            case 7:
                                                lXVar.f8602 = "3.1.-58";
                                                lXVar.f8601 = "StreamingFailure.Network.connectionrefused";
                                                break;
                                            case 8:
                                                lXVar.f8602 = "3.1.-60";
                                                lXVar.f8601 = "StreamingFailure.Network.connectionreset";
                                                break;
                                            case 9:
                                                lXVar.f8602 = "3.1.-100";
                                                lXVar.f8601 = "StreamingFailure.Network.noroutetohost";
                                                break;
                                            case 10:
                                                lXVar.f8602 = "3.1.-800";
                                                lXVar.f8601 = "StreamingFailure.Network.quic";
                                                break;
                                            case 11:
                                                lXVar.f8602 = "3.1.-801";
                                                lXVar.f8601 = "StreamingFailure.Network.other";
                                                break;
                                            default:
                                                lXVar.f8602 = "3.1.-1";
                                                lXVar.f8601 = "StreamingFailure.Network.unknown";
                                                break;
                                        }
                                    }
                                } else if (!z) {
                                    lXVar.f8602 = "3.1.-171";
                                    lXVar.f8601 = "StreamingFailure.Network.connectiontimeout";
                                    break;
                                } else {
                                    lXVar.f8602 = "3.1.-57";
                                    lXVar.f8601 = "StreamingFailure.Network.sockettimeout";
                                    break;
                                }
                            } else {
                                lXVar.f8602 = "3.1.-70";
                                lXVar.f8601 = "StreamingFailure.Network.dnsfailure";
                                break;
                            }
                        } else {
                            lXVar.f8602 = "3.2.-1";
                            lXVar.f8601 = "StreamingFailure.Http.badcontent";
                            lXVar.f8605 = C1283.m16857(sourceException);
                            break;
                        }
                    } else {
                        int i = ((HttpDataSource.InvalidResponseCodeException) sourceException).responseCode;
                        lXVar.f8602 = "3.2." + i;
                        lXVar.f8601 = "StreamingFailure.Http." + i;
                        break;
                    }
                }
            case 1:
                Exception rendererException = exoPlaybackException.getRendererException();
                if (!(rendererException instanceof MediaCodec.CryptoException)) {
                    if (!(rendererException instanceof MediaCodecRenderer.DecoderInitializationException)) {
                        lXVar.f8605 = C1283.m16857(rendererException);
                        lXVar.f8600 = rendererException == null ? "unknown" : rendererException.toString();
                        lXVar.f8602 = "5.0";
                        lXVar.f8601 = "DevicePlaybackError.UnknownError";
                        break;
                    } else {
                        lXVar.f8605 = C1283.m16857(rendererException);
                        lXVar.f8600 = ((MediaCodecRenderer.DecoderInitializationException) rendererException).diagnosticInfo;
                        lXVar.f8602 = "5.8";
                        lXVar.f8601 = "DevicePlaybackError.DecoderInitError";
                        break;
                    }
                } else {
                    int errorCode = ((MediaCodec.CryptoException) rendererException).getErrorCode();
                    lXVar.f8605 = C1283.m16857(rendererException);
                    lXVar.f8600 = rendererException.toString();
                    lXVar.f8602 = "5.7." + errorCode;
                    lXVar.f8601 = "DevicePlaybackError.CryptoError";
                    break;
                }
            case 2:
                RuntimeException unexpectedException = exoPlaybackException.getUnexpectedException();
                lXVar.f8605 = C1283.m16857(unexpectedException);
                lXVar.f8600 = unexpectedException.toString();
                if (exoPlaybackException.rendererIndex != 1) {
                    if (exoPlaybackException.rendererIndex != 2) {
                        lXVar.f8602 = "6.0";
                        lXVar.f8601 = "Other.UnknownError";
                        break;
                    } else {
                        lXVar.f8602 = "5.10." + exoPlaybackException.getMessage();
                        lXVar.f8601 = "DevicePlaybackError.VideoError";
                        break;
                    }
                } else {
                    lXVar.f8602 = "5.9." + exoPlaybackException.getMessage();
                    lXVar.f8601 = "DevicePlaybackError.AudioError";
                    break;
                }
        }
        return lXVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String m1125(int i) {
        switch (i) {
            case -1:
                return "INVALID";
            case 0:
                return "IDLE";
            case 1:
                return "WAITING_FOR_STALLED_SOCKET_POOL";
            case 2:
                return "WAITING_FOR_AVAILABLE_SOCKET";
            case 3:
                return "WAITING_FOR_DELEGATE";
            case 4:
                return "WAITING_FOR_CACHE";
            case 5:
                return "DOWNLOADING_PROXY_SCRIPT";
            case 6:
                return "RESOLVING_PROXY_FOR_URL";
            case 7:
                return "RESOLVING_HOST_IN_PROXY_SCRIPT";
            case 8:
                return "ESTABLISHING_PROXY_TUNNEL";
            case 9:
                return "RESOLVING_HOST";
            case 10:
                return "CONNECTING";
            case 11:
                return "SSL_HANDSHAKE";
            case 12:
                return "SENDING_REQUEST";
            case 13:
                return "WAITING_FOR_RESPONSE";
            case 14:
                return "READING_RESPONSE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static lX m1128(ISubtitleDef.SubtitleFailure subtitleFailure, Status status) {
        lX lXVar = new lX();
        switch (subtitleFailure) {
            case download:
                lXVar.f8602 = "7.1";
                lXVar.f8601 = "SubtitleFailed.DownloadFailed";
                break;
            case parsing:
                lXVar.f8602 = "7.2";
                lXVar.f8601 = "SubtitleFailed.ParsingFailed";
                break;
            case badMasterIndex:
                lXVar.f8602 = "7.3";
                lXVar.f8601 = "SubtitleFailed.BadMasterIndex";
                break;
            case timedOut:
                lXVar.f8602 = "7.4";
                lXVar.f8601 = "SubtitleFailed.TimedOut";
                break;
            case parsingCachedMasterIndex:
            case dnsResolution:
            default:
                lXVar.f8602 = "7.10";
                lXVar.f8601 = "SubtitleFailed.Unknown";
                break;
        }
        return lXVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static lX m1129(String str) {
        lX lXVar = new lX();
        lXVar.f8602 = "2.102";
        lXVar.f8601 = "NccpLicenseFailed.DrmSessionException";
        return lXVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static lX m1130(TransactionType transactionType, Status status) {
        lX lXVar = new lX();
        switch (transactionType) {
            case Authorization:
                lXVar.f8602 = "1";
                lXVar.f8601 = "NccpAuthorizationFailed";
                break;
            case License:
                lXVar.f8602 = "2";
                lXVar.f8601 = "NccpLicenseFailed";
                break;
        }
        Status.ErrorGroup r3 = status == null ? null : status.mo295();
        if (r3 != null) {
            switch (r3) {
                case BladerunnerError:
                    if (status instanceof BladerunnerErrorStatus) {
                        BladerunnerErrorStatus bladerunnerErrorStatus = (BladerunnerErrorStatus) status;
                        lXVar.f8607 = bladerunnerErrorStatus.m967();
                        String r5 = bladerunnerErrorStatus.m966();
                        if (TextUtils.isEmpty(bladerunnerErrorStatus.m963())) {
                            switch (bladerunnerErrorStatus.m965()) {
                                case 1:
                                    if (!r5.equalsIgnoreCase("1009")) {
                                        lXVar.f8602 += ".8";
                                        lXVar.f8601 += ".NoAction";
                                        break;
                                    } else {
                                        lXVar.f8602 += ".5." + r5;
                                        lXVar.f8601 += ".ProtocolVersionIncorrect." + r5;
                                        break;
                                    }
                                case 2:
                                    lXVar.f8602 += ".9." + r5;
                                    lXVar.f8601 += ".RetryExceeded." + r5;
                                    break;
                                case 3:
                                    lXVar.f8602 += ".10." + r5;
                                    lXVar.f8601 += ".ErrorMessage." + r5;
                                    lXVar.f8603 = bladerunnerErrorStatus.m961();
                                    break;
                                case 4:
                                case 6:
                                case 7:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                default:
                                    lXVar.f8602 += ".3." + r5;
                                    lXVar.f8601 += ".Nccp." + r5;
                                    break;
                                case 5:
                                    lXVar.f8602 += ".9." + r5;
                                    lXVar.f8601 += ".RetryExceeded." + r5;
                                    break;
                                case 8:
                                    lXVar.f8602 += ".11." + r5;
                                    lXVar.f8601 += ".InvalidDeviceCredentials." + r5;
                                    break;
                                case 9:
                                    lXVar.f8602 += ".12." + r5;
                                    lXVar.f8601 += ".UnsupportedSoftwareVersion." + r5;
                                    break;
                                case 14:
                                    lXVar.f8602 += ".17";
                                    lXVar.f8601 += ".RegistrationRequired";
                                    break;
                            }
                        } else {
                            lXVar.f8606 = bladerunnerErrorStatus.m963();
                            lXVar.f8602 += ".50." + bladerunnerErrorStatus.m963();
                            lXVar.f8601 += ".BladeRunnerErrCode." + bladerunnerErrorStatus.m963();
                            lXVar.f8603 = bladerunnerErrorStatus.m961();
                            break;
                        }
                    }
                    break;
                case NetworkError:
                    lXVar.f8602 += ".1";
                    lXVar.f8601 += ".Network";
                    break;
                case HttpError:
                    lXVar.f8602 += ".2";
                    lXVar.f8601 += ".Http";
                    break;
                case DrmError:
                    lXVar.f8602 += ".100";
                    lXVar.f8601 += ".DrmError";
                    break;
                case MslError:
                    lXVar.f8602 += ".20";
                    lXVar.f8601 += ".MslError";
                    break;
                default:
                    lXVar.f8602 += ".200";
                    lXVar.f8601 += ".MissingStatus";
                    break;
            }
        } else {
            lXVar.f8602 += ".0";
            lXVar.f8601 += ".UnknownError";
        }
        lXVar.f8600 = status.mo305();
        return lXVar;
    }
}
