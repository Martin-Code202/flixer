package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
public final class Id3Decoder implements MetadataDecoder {
    public static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    private final FramePredicate framePredicate;

    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(FramePredicate framePredicate2) {
        this.framePredicate = framePredicate2;
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata decode(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        Id3Header decodeHeader = decodeHeader(parsableByteArray);
        if (decodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i2 = decodeHeader.majorVersion == 2 ? 6 : 10;
        int i3 = decodeHeader.framesSize;
        if (decodeHeader.isUnsynchronized) {
            i3 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + i3);
        boolean z = false;
        if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i2, false)) {
            if (decodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i2, true)) {
                Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion);
                return null;
            }
            z = true;
        }
        while (parsableByteArray.bytesLeft() >= i2) {
            Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z, i2, this.framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new Metadata(arrayList);
    }

    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        if (readUnsignedInt24 != ID3_TAG) {
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: " + readUnsignedInt24);
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else if (readUnsignedByte == 4) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                readSynchSafeInt -= 10;
            }
        } else {
            Log.w("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte);
            return null;
        }
        return new Id3Header(readUnsignedByte, readUnsignedByte < 4 && (readUnsignedByte2 & 128) != 0, readSynchSafeInt);
    }

    private static boolean validateFrames(ParsableByteArray parsableByteArray, int i, int i2, boolean z) {
        int i3;
        long j;
        int i4;
        int position = parsableByteArray.getPosition();
        while (parsableByteArray.bytesLeft() >= i2) {
            try {
                if (i >= 3) {
                    i4 = parsableByteArray.readInt();
                    j = parsableByteArray.readUnsignedInt();
                    i3 = parsableByteArray.readUnsignedShort();
                } else {
                    i4 = parsableByteArray.readUnsignedInt24();
                    j = (long) parsableByteArray.readUnsignedInt24();
                    i3 = 0;
                }
                if (i4 == 0 && j == 0 && i3 == 0) {
                    parsableByteArray.setPosition(position);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & j) != 0) {
                        parsableByteArray.setPosition(position);
                        return false;
                    }
                    j = (255 & j) | (((j >> 8) & 255) << 7) | (((j >> 16) & 255) << 14) | (((j >> 24) & 255) << 21);
                }
                boolean z2 = false;
                boolean z3 = false;
                if (i == 4) {
                    z2 = (i3 & 64) != 0;
                    z3 = (i3 & 1) != 0;
                } else if (i == 3) {
                    z2 = (i3 & 32) != 0;
                    z3 = (i3 & 128) != 0;
                }
                int i5 = 0;
                if (z2) {
                    i5 = 0 + 1;
                }
                if (z3) {
                    i5 += 4;
                }
                if (j < ((long) i5)) {
                    parsableByteArray.setPosition(position);
                    return false;
                } else if (((long) parsableByteArray.bytesLeft()) < j) {
                    return false;
                } else {
                    parsableByteArray.skipBytes((int) j);
                }
            } finally {
                parsableByteArray.setPosition(position);
            }
        }
        parsableByteArray.setPosition(position);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:147:0x01d7, code lost:
        if (r9 == 67) goto L_0x01d9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame decodeFrame(int r21, com.google.android.exoplayer2.util.ParsableByteArray r22, boolean r23, int r24, com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r25) {
        /*
        // Method dump skipped, instructions count: 662
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.decodeFrame(int, com.google.android.exoplayer2.util.ParsableByteArray, boolean, int, com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i) {
        String str;
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str2 = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        if (delimiterLength < bArr.length) {
            str = new String(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte) - delimiterLength, charsetName);
        } else {
            str = "";
        }
        return new TextInformationFrame("TXXX", str2, str);
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i, String str) {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        return new TextInformationFrame(str, null, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i) {
        String str;
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str2 = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        if (delimiterLength < bArr.length) {
            str = new String(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength) - delimiterLength, "ISO-8859-1");
        } else {
            str = "";
        }
        return new UrlLinkFrame("WXXX", str2, str);
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, bArr.length));
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i2 = indexOfZeroByte + 1;
        int indexOfEos = indexOfEos(bArr, i2, readUnsignedByte);
        String str2 = new String(bArr, i2, indexOfEos - i2, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, str2, new String(bArr, delimiterLength, indexOfEos2 - delimiterLength, charsetName), copyOfRangeIfValid(bArr, indexOfEos2 + delimiterLength(readUnsignedByte), bArr.length));
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3;
        String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        if (i2 == 2) {
            i3 = 2;
            str = "image/" + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals("image/jpg")) {
                str = "image/jpeg";
            }
        } else {
            i3 = indexOfZeroByte(bArr, 0);
            str = Util.toLowerInvariant(new String(bArr, 0, i3, "ISO-8859-1"));
            if (str.indexOf(47) == -1) {
                str = "image/" + str;
            }
        }
        int i4 = bArr[i3 + 1] & 255;
        int i5 = i3 + 2;
        int indexOfEos = indexOfEos(bArr, i5, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i5, indexOfEos - i5, charsetName), i4, copyOfRangeIfValid(bArr, indexOfEos + delimiterLength(readUnsignedByte), bArr.length));
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i) {
        String str;
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str2 = new String(bArr, 0, 3);
        byte[] bArr2 = new byte[(i - 4)];
        parsableByteArray.readBytes(bArr2, 0, i - 4);
        int indexOfEos = indexOfEos(bArr2, 0, readUnsignedByte);
        String str3 = new String(bArr2, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        if (delimiterLength < bArr2.length) {
            str = new String(bArr2, delimiterLength, indexOfEos(bArr2, delimiterLength, readUnsignedByte) - delimiterLength, charsetName);
        } else {
            str = "";
        }
        return new CommentFrame(str2, str3, str);
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate2) {
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt == 4294967295L) {
            readUnsignedInt = -1;
        }
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt2 == 4294967295L) {
            readUnsignedInt2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = position + i;
        while (parsableByteArray.getPosition() < i4) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, readInt, readInt2, readUnsignedInt, readUnsignedInt2, id3FrameArr);
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate2) {
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 2) != 0;
        boolean z3 = (readUnsignedByte & 1) != 0;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray.data, position2);
            strArr[i4] = new String(parsableByteArray.data, position2, indexOfZeroByte2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = position + i;
        while (parsableByteArray.getPosition() < i5) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = parsableByteArray.data;
        for (int position = parsableByteArray.getPosition(); position + 1 < i; position++) {
            if ((bArr[position] & 255) == 255 && bArr[position + 1] == 0) {
                System.arraycopy(bArr, position + 2, bArr, position + 1, (i - position) - 2);
                i--;
            }
        }
        return i;
    }

    private static String getCharsetName(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }

    private static String getFrameId(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int indexOfEos(byte[] bArr, int i, int i2) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return indexOfZeroByte;
        }
        while (indexOfZeroByte < bArr.length - 1) {
            if (indexOfZeroByte % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                return indexOfZeroByte;
            }
            indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
        }
        return bArr.length;
    }

    private static int indexOfZeroByte(byte[] bArr, int i) {
        for (int i2 = i; i2 < bArr.length; i2++) {
            if (bArr[i2] == 0) {
                return i2;
            }
        }
        return bArr.length;
    }

    private static int delimiterLength(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[0];
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    /* access modifiers changed from: package-private */
    public static final class Id3Header {
        private final int framesSize;
        private final boolean isUnsynchronized;
        private final int majorVersion;

        public Id3Header(int i, boolean z, int i2) {
            this.majorVersion = i;
            this.isUnsynchronized = z;
            this.framesSize = i2;
        }
    }
}
