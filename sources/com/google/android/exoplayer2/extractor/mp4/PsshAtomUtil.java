package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.UUID;
public final class PsshAtomUtil {
    public static UUID parseUuid(byte[] bArr) {
        Pair<UUID, byte[]> parsePsshAtom = parsePsshAtom(bArr);
        if (parsePsshAtom == null) {
            return null;
        }
        return (UUID) parsePsshAtom.first;
    }

    private static Pair<UUID, byte[]> parsePsshAtom(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.limit() < 32) {
            return null;
        }
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readInt() != parsableByteArray.bytesLeft() + 4 || parsableByteArray.readInt() != Atom.TYPE_pssh) {
            return null;
        }
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion > 1) {
            Log.w("PsshAtomUtil", "Unsupported pssh version: " + parseFullAtomVersion);
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.readLong(), parsableByteArray.readLong());
        if (parseFullAtomVersion == 1) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedIntToInt() * 16);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt != parsableByteArray.bytesLeft()) {
            return null;
        }
        byte[] bArr2 = new byte[readUnsignedIntToInt];
        parsableByteArray.readBytes(bArr2, 0, readUnsignedIntToInt);
        return Pair.create(uuid, bArr2);
    }
}
