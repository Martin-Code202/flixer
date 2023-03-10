package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
public final class CeaUtil {
    public static void consume(long j, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        while (parsableByteArray.bytesLeft() > 1) {
            int readNon255TerminatedValue = readNon255TerminatedValue(parsableByteArray);
            int readNon255TerminatedValue2 = readNon255TerminatedValue(parsableByteArray);
            if (readNon255TerminatedValue2 == -1 || readNon255TerminatedValue2 > parsableByteArray.bytesLeft()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                parsableByteArray.setPosition(parsableByteArray.limit());
            } else if (isSeiMessageCea608(readNon255TerminatedValue, readNon255TerminatedValue2, parsableByteArray)) {
                parsableByteArray.skipBytes(8);
                int readUnsignedByte = parsableByteArray.readUnsignedByte() & 31;
                parsableByteArray.skipBytes(1);
                int i = readUnsignedByte * 3;
                int position = parsableByteArray.getPosition();
                for (TrackOutput trackOutput : trackOutputArr) {
                    parsableByteArray.setPosition(position);
                    trackOutput.sampleData(parsableByteArray, i);
                    trackOutput.sampleMetadata(j, 1, i, 0, null);
                }
                parsableByteArray.skipBytes(readNon255TerminatedValue2 - ((readUnsignedByte * 3) + 10));
            } else {
                parsableByteArray.skipBytes(readNon255TerminatedValue2);
            }
        }
    }

    private static int readNon255TerminatedValue(ParsableByteArray parsableByteArray) {
        int i = 0;
        while (parsableByteArray.bytesLeft() != 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            i += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isSeiMessageCea608(int i, int i2, ParsableByteArray parsableByteArray) {
        if (i != 4 || i2 < 8) {
            return false;
        }
        int position = parsableByteArray.getPosition();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readInt = parsableByteArray.readInt();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(position);
        return readUnsignedByte == 181 && readUnsignedShort == 49 && readInt == 1195456820 && readUnsignedByte2 == 3;
    }
}
