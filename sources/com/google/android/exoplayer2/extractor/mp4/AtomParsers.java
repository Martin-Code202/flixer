package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
final class AtomParsers {
    private static final int TYPE_cenc = Util.getIntegerCodeForString("cenc");
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString("meta");
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_text = Util.getIntegerCodeForString("text");
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z) {
        long j2;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
        int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (parseHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        if (j == -9223372036854775807L) {
            j = parseTkhd.duration;
        }
        long parseMvhd = parseMvhd(leafAtom.data);
        if (j == -9223372036854775807L) {
            j2 = -9223372036854775807L;
        } else {
            j2 = Util.scaleLargeTimestamp(j, 1000000, parseMvhd);
        }
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z);
        Pair<long[], long[]> parseEdts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j2, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, (long[]) parseEdts.first, (long[]) parseEdts.second);
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0 ? 8 : 16);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j;
        int i;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        boolean z = true;
        int position = parsableByteArray.getPosition();
        int i2 = parseFullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            } else if (parsableByteArray.data[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        if (z) {
            parsableByteArray.skipBytes(i2);
            j = -9223372036854775807L;
        } else {
            j = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (j == 0) {
                j = -9223372036854775807L;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i = 180;
        } else {
            i = 0;
        }
        return new TkhdData(readInt, j, i);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int readInt = parsableByteArray.readInt();
        if (readInt == TYPE_soun) {
            return 1;
        }
        if (readInt == TYPE_vide) {
            return 2;
        }
        if (readInt == TYPE_text || readInt == TYPE_sbtl || readInt == TYPE_subt || readInt == TYPE_clcp) {
            return 3;
        }
        if (readInt == TYPE_meta) {
            return 4;
        }
        return -1;
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 4 : 8);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkArgument(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == Atom.TYPE_avc1 || readInt3 == Atom.TYPE_avc3 || readInt3 == Atom.TYPE_encv || readInt3 == Atom.TYPE_mp4v || readInt3 == Atom.TYPE_hvc1 || readInt3 == Atom.TYPE_hev1 || readInt3 == Atom.TYPE_s263 || readInt3 == Atom.TYPE_vp08 || readInt3 == Atom.TYPE_vp09 || readInt3 == Atom.TYPE_dvhe || readInt3 == Atom.TYPE_dvav || readInt3 == Atom.TYPE_dva1 || readInt3 == Atom.TYPE_dvh1) {
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData, i3);
            } else if (readInt3 == Atom.TYPE_mp4a || readInt3 == Atom.TYPE_enca || readInt3 == Atom.TYPE_ac_3 || readInt3 == Atom.TYPE_ec_3 || readInt3 == Atom.TYPE_dtsc || readInt3 == Atom.TYPE_dtse || readInt3 == Atom.TYPE_dtsh || readInt3 == Atom.TYPE_dtsl || readInt3 == Atom.TYPE_samr || readInt3 == Atom.TYPE_sawb || readInt3 == Atom.TYPE_lpcm || readInt3 == Atom.TYPE_sowt || readInt3 == Atom.TYPE__mp3 || readInt3 == Atom.TYPE_alac) {
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i3);
            } else if (readInt3 == Atom.TYPE_TTML || readInt3 == Atom.TYPE_tx3g || readInt3 == Atom.TYPE_wvtt || readInt3 == Atom.TYPE_stpp || readInt3 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
            } else if (readInt3 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i), "application/x-camera-motion", null, -1, null);
            }
            parsableByteArray.setPosition(position + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        String str2;
        parsableByteArray.setPosition(i2 + 8 + 8);
        List list = null;
        long j = Long.MAX_VALUE;
        if (i == Atom.TYPE_TTML) {
            str2 = "application/ttml+xml";
        } else if (i == Atom.TYPE_tx3g) {
            str2 = "application/x-quicktime-tx3g";
            int i5 = (i3 - 8) - 8;
            byte[] bArr = new byte[i5];
            parsableByteArray.readBytes(bArr, 0, i5);
            list = Collections.singletonList(bArr);
        } else if (i == Atom.TYPE_wvtt) {
            str2 = "application/x-mp4-vtt";
        } else if (i == Atom.TYPE_stpp) {
            str2 = "application/ttml+xml";
            j = 0;
        } else if (i == Atom.TYPE_c608) {
            str2 = "application/x-mp4-cea-608";
            stsdData.requiredSampleTransformation = 1;
        } else {
            throw new IllegalStateException();
        }
        stsdData.format = Format.createTextSampleFormat(Integer.toString(i4), str2, null, -1, 0, str, -1, null, j, list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x01ca A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseVideoSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r33, int r34, int r35, int r36, int r37, int r38, com.google.android.exoplayer2.drm.DrmInitData r39, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r40, int r41) {
        /*
        // Method dump skipped, instructions count: 512
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseVideoSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, int, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static Pair<Integer, Integer> parseDvcCFromParent(ParsableByteArray parsableByteArray) {
        parsableByteArray.readUnsignedByte();
        parsableByteArray.readUnsignedByte();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte >> 1;
        int readUnsignedByte2 = ((readUnsignedByte & 1) << 5) | ((parsableByteArray.readUnsignedByte() >> 3) & 31);
        if (i == 0 || i == 2 || i == 4) {
            return Pair.create(-1, -1);
        }
        return Pair.create(Integer.valueOf(new int[]{1, 2, 4, 8, 16, 32, 64, 128}[i]), Integer.valueOf(new int[]{0, 1, 2, 4, 8, 16, 32, 64, 128, 256}[readUnsignedByte2]));
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create(null, null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : (long) parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) {
        int i6;
        int i7;
        List list;
        int i8;
        parsableByteArray.setPosition(i2 + 8 + 8);
        int i9 = 0;
        if (z) {
            i9 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
        }
        if (i9 == 0 || i9 == 1) {
            i7 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            i6 = parsableByteArray.readUnsignedFixedPoint1616();
            if (i9 == 1) {
                parsableByteArray.skipBytes(16);
            }
        } else if (i9 == 2) {
            parsableByteArray.skipBytes(16);
            i6 = (int) Math.round(parsableByteArray.readDouble());
            i7 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
        } else {
            return;
        }
        int position = parsableByteArray.getPosition();
        if (i == Atom.TYPE_enca) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i2, i3);
            if (parseSampleEntryEncryptionData != null) {
                i = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData == null) {
                    drmInitData = null;
                } else {
                    drmInitData = drmInitData.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str2 = null;
        if (i == Atom.TYPE_ac_3) {
            str2 = "audio/ac3";
        } else if (i == Atom.TYPE_ec_3) {
            str2 = "audio/eac3";
        } else if (i == Atom.TYPE_dtsc) {
            str2 = "audio/vnd.dts";
        } else if (i == Atom.TYPE_dtsh || i == Atom.TYPE_dtsl) {
            str2 = "audio/vnd.dts.hd";
        } else if (i == Atom.TYPE_dtse) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i == Atom.TYPE_samr) {
            str2 = "audio/3gpp";
        } else if (i == Atom.TYPE_sawb) {
            str2 = "audio/amr-wb";
        } else if (i == Atom.TYPE_lpcm || i == Atom.TYPE_sowt) {
            str2 = "audio/raw";
        } else if (i == Atom.TYPE__mp3) {
            str2 = "audio/mpeg";
        } else if (i == Atom.TYPE_alac) {
            str2 = "audio/alac";
        }
        byte[] bArr = null;
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_esds || (z && readInt2 == Atom.TYPE_wave)) {
                if (readInt2 == Atom.TYPE_esds) {
                    i8 = position;
                } else {
                    i8 = findEsdsPosition(parsableByteArray, position, readInt);
                }
                if (i8 != -1) {
                    Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, i8);
                    str2 = (String) parseEsdsFromParent.first;
                    bArr = (byte[]) parseEsdsFromParent.second;
                    if ("audio/mp4a-latm".equals(str2)) {
                        Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                        i6 = ((Integer) parseAacAudioSpecificConfig.first).intValue();
                        i7 = ((Integer) parseAacAudioSpecificConfig.second).intValue();
                    }
                }
            } else if (readInt2 == Atom.TYPE_dac3) {
                parsableByteArray.setPosition(position + 8);
                stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData);
            } else if (readInt2 == Atom.TYPE_dec3) {
                parsableByteArray.setPosition(position + 8);
                stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData);
            } else if (readInt2 == Atom.TYPE_ddts) {
                stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str2, null, -1, -1, i7, i6, null, drmInitData, 0, str);
            } else if (readInt2 == Atom.TYPE_alac) {
                bArr = new byte[readInt];
                parsableByteArray.setPosition(position);
                parsableByteArray.readBytes(bArr, 0, readInt);
            }
            position += readInt;
        }
        if (stsdData.format == null && str2 != null) {
            int i10 = "audio/raw".equals(str2) ? 2 : -1;
            String num = Integer.toString(i4);
            if (bArr == null) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            stsdData.format = Format.createAudioSampleFormat(num, str2, null, -1, -1, i7, i6, i10, list, drmInitData, 0, str);
        }
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        String str;
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        switch (parsableByteArray.readUnsignedByte()) {
            case 32:
                str = "video/mp4v-es";
                break;
            case 33:
                str = "video/avc";
                break;
            case 35:
                str = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = "audio/mp4a-latm";
                break;
            case 96:
            case 97:
                str = "video/mpeg2";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                str = "audio/ac3";
                break;
            case 166:
                str = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
            default:
                str = null;
                break;
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(str, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> parseSinfFromParentForNetflix;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseSinfFromParentForNetflix = parseSinfFromParentForNetflix(parsableByteArray, position, readInt)) != null) {
                return parseSinfFromParentForNetflix;
            }
            position += readInt;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSinfFromParentForNetflix(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        boolean z = false;
        TrackEncryptionBox trackEncryptionBox = null;
        Integer num = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_frma) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                z = parsableByteArray.readInt() == TYPE_cenc;
            } else if (readInt2 == Atom.TYPE_schi) {
                trackEncryptionBox = parseSchiFromParent(parsableByteArray, i3, readInt, "cenc");
            }
            i3 += readInt;
        }
        if (!z) {
            return null;
        }
        Assertions.checkArgument(num != null, "frma atom is mandatory");
        Assertions.checkArgument(trackEncryptionBox != null, "schi->tenc atom is mandatory");
        return Pair.create(num, trackEncryptionBox);
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                int i4 = 0;
                int i5 = 0;
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i4 = (readUnsignedByte & 240) >> 4;
                    i5 = readUnsignedByte & 15;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr = new byte[16];
                int length = bArr.length;
                parsableByteArray.readBytes(bArr, 0, 16);
                byte[] bArr2 = null;
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr2 = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr2, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr, i4, i5, bArr2);
            }
            i3 += readInt;
        }
        return null;
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, i3 + readInt);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class StsdData {
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }
}
