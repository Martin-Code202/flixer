package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Log;
public final class ChunkedTrackBlacklistUtil {
    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i, Exception exc) {
        return maybeBlacklistTrack(trackSelection, i, exc, 60000);
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i, Exception exc, long j) {
        if (!shouldBlacklist(exc)) {
            return false;
        }
        boolean blacklist = trackSelection.blacklist(i, j);
        int i2 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        if (blacklist) {
            Log.w("ChunkedTrackBlacklist", "Blacklisted: duration=" + j + ", responseCode=" + i2 + ", format=" + trackSelection.getFormat(i));
        } else {
            Log.w("ChunkedTrackBlacklist", "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i2 + ", format=" + trackSelection.getFormat(i));
        }
        return blacklist;
    }

    public static boolean shouldBlacklist(Exception exc) {
        if (!(exc instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        return i == 404 || i == 410;
    }
}
