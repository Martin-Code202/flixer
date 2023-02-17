package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Trie2_32;
import com.ibm.icu.impl.USerializedSet;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ICUException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;
final class CollationDataReader {
    static final /* synthetic */ boolean $assertionsDisabled = (!CollationDataReader.class.desiredAssertionStatus());
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable();

    static void read(CollationTailoring collationTailoring, ByteBuffer byteBuffer, CollationTailoring collationTailoring2) {
        int i;
        int i2;
        int[] iArr;
        collationTailoring2.version = ICUBinary.readHeader(byteBuffer, 1430482796, IS_ACCEPTABLE);
        if (collationTailoring == null || collationTailoring.getUCAVersion() == collationTailoring2.getUCAVersion()) {
            int remaining = byteBuffer.remaining();
            if (remaining < 8) {
                throw new ICUException("not enough bytes");
            }
            int i3 = byteBuffer.getInt();
            if (i3 < 2 || remaining < i3 * 4) {
                throw new ICUException("not enough indexes");
            }
            int[] iArr2 = new int[20];
            iArr2[0] = i3;
            for (int i4 = 1; i4 < i3; i4++) {
                int length = iArr2.length;
                if (i4 >= 20) {
                    break;
                }
                iArr2[i4] = byteBuffer.getInt();
            }
            int i5 = i3;
            while (true) {
                int length2 = iArr2.length;
                if (i5 >= 20) {
                    break;
                }
                iArr2[i5] = -1;
                i5++;
            }
            int length3 = iArr2.length;
            if (i3 > 20) {
                int length4 = iArr2.length;
                ICUBinary.skipBytes(byteBuffer, (i3 - 20) * 4);
            }
            if (i3 > 19) {
                i = iArr2[19];
            } else if (i3 > 5) {
                i = iArr2[i3 - 1];
            } else {
                i = 0;
            }
            if (remaining < i) {
                throw new ICUException("not enough bytes");
            }
            CollationData collationData = collationTailoring == null ? null : collationTailoring.data;
            int i6 = iArr2[6] - iArr2[5];
            if (i6 < 4) {
                iArr = new int[0];
                i2 = 0;
                ICUBinary.skipBytes(byteBuffer, i6);
            } else if (collationData == null) {
                throw new ICUException("Collation base data must not reorder scripts");
            } else {
                int i7 = i6 / 4;
                iArr = ICUBinary.getInts(byteBuffer, i7, i6 & 3);
                int i8 = 0;
                while (i8 < i7 && (iArr[(i7 - i8) - 1] & -65536) != 0) {
                    i8++;
                }
                if ($assertionsDisabled || i8 < i7) {
                    i2 = i7 - i8;
                } else {
                    throw new AssertionError();
                }
            }
            byte[] bArr = null;
            int i9 = iArr2[7] - iArr2[6];
            if (i9 >= 256) {
                if (i2 == 0) {
                    throw new ICUException("Reordering table without reordering codes");
                }
                bArr = new byte[256];
                byteBuffer.get(bArr);
                i9 -= 256;
            }
            ICUBinary.skipBytes(byteBuffer, i9);
            if (collationData == null || collationData.numericPrimary == (((long) iArr2[1]) & 4278190080L)) {
                CollationData collationData2 = null;
                int i10 = iArr2[8] - iArr2[7];
                if (i10 >= 8) {
                    collationTailoring2.ensureOwnedData();
                    collationData2 = collationTailoring2.ownedData;
                    collationData2.base = collationData;
                    collationData2.numericPrimary = ((long) iArr2[1]) & 4278190080L;
                    Trie2_32 createFromSerialized = Trie2_32.createFromSerialized(byteBuffer);
                    collationTailoring2.trie = createFromSerialized;
                    collationData2.trie = createFromSerialized;
                    int serializedLength = collationData2.trie.getSerializedLength();
                    if (serializedLength > i10) {
                        throw new ICUException("Not enough bytes for the mappings trie");
                    }
                    i10 -= serializedLength;
                } else if (collationData != null) {
                    collationTailoring2.data = collationData;
                } else {
                    throw new ICUException("Missing collation data mappings");
                }
                ICUBinary.skipBytes(byteBuffer, i10);
                ICUBinary.skipBytes(byteBuffer, iArr2[9] - iArr2[8]);
                int i11 = iArr2[10] - iArr2[9];
                if (i11 < 8) {
                    ICUBinary.skipBytes(byteBuffer, i11);
                } else if (collationData2 == null) {
                    throw new ICUException("Tailored ces without tailored trie");
                } else {
                    collationData2.ces = ICUBinary.getLongs(byteBuffer, i11 / 8, i11 & 7);
                }
                ICUBinary.skipBytes(byteBuffer, iArr2[11] - iArr2[10]);
                int i12 = iArr2[12] - iArr2[11];
                if (i12 < 4) {
                    ICUBinary.skipBytes(byteBuffer, i12);
                } else if (collationData2 == null) {
                    throw new ICUException("Tailored ce32s without tailored trie");
                } else {
                    collationData2.ce32s = ICUBinary.getInts(byteBuffer, i12 / 4, i12 & 3);
                }
                int i13 = iArr2[4];
                if (i13 >= 0) {
                    if (collationData2 == null || collationData2.ce32s == null) {
                        throw new ICUException("JamoCE32sStart index into non-existent ce32s[]");
                    }
                    collationData2.jamoCE32s = new int[67];
                    System.arraycopy(collationData2.ce32s, i13, collationData2.jamoCE32s, 0, 67);
                } else if (collationData2 != null) {
                    if (collationData != null) {
                        collationData2.jamoCE32s = collationData.jamoCE32s;
                    } else {
                        throw new ICUException("Missing Jamo CE32s for Hangul processing");
                    }
                }
                int i14 = iArr2[13] - iArr2[12];
                if (i14 >= 4) {
                    int i15 = i14 / 4;
                    if (collationData2 == null) {
                        throw new ICUException("Root elements but no mappings");
                    } else if (i15 <= 4) {
                        throw new ICUException("Root elements array too short");
                    } else {
                        collationData2.rootElements = new long[i15];
                        for (int i16 = 0; i16 < i15; i16++) {
                            collationData2.rootElements[i16] = ((long) byteBuffer.getInt()) & 4294967295L;
                        }
                        if (collationData2.rootElements[3] != 83887360) {
                            throw new ICUException("Common sec/ter weights in base data differ from the hardcoded value");
                        } else if ((collationData2.rootElements[4] >>> 24) < 69) {
                            throw new ICUException("[fixed last secondary common byte] is too low");
                        } else {
                            i14 &= 3;
                        }
                    }
                }
                ICUBinary.skipBytes(byteBuffer, i14);
                int i17 = iArr2[14] - iArr2[13];
                if (i17 < 2) {
                    ICUBinary.skipBytes(byteBuffer, i17);
                } else if (collationData2 == null) {
                    throw new ICUException("Tailored contexts without tailored trie");
                } else {
                    collationData2.contexts = ICUBinary.getString(byteBuffer, i17 / 2, i17 & 1);
                }
                int i18 = iArr2[15] - iArr2[14];
                if (i18 >= 2) {
                    if (collationData2 == null) {
                        throw new ICUException("Unsafe-backward-set but no mappings");
                    }
                    if (collationData == null) {
                        collationTailoring2.unsafeBackwardSet = new UnicodeSet(56320, 57343);
                        collationData2.nfcImpl.addLcccChars(collationTailoring2.unsafeBackwardSet);
                    } else {
                        collationTailoring2.unsafeBackwardSet = collationData.unsafeBackwardSet.cloneAsThawed();
                    }
                    USerializedSet uSerializedSet = new USerializedSet();
                    i18 = 0;
                    uSerializedSet.getSet(ICUBinary.getChars(byteBuffer, i18 / 2, i18 & 1), 0);
                    int countRanges = uSerializedSet.countRanges();
                    int[] iArr3 = new int[2];
                    for (int i19 = 0; i19 < countRanges; i19++) {
                        uSerializedSet.getRange(i19, iArr3);
                        collationTailoring2.unsafeBackwardSet.add(iArr3[0], iArr3[1]);
                    }
                    int i20 = 65536;
                    int i21 = 55296;
                    while (i21 < 56320) {
                        if (!collationTailoring2.unsafeBackwardSet.containsNone(i20, i20 + 1023)) {
                            collationTailoring2.unsafeBackwardSet.add(i21);
                        }
                        i21++;
                        i20 += 1024;
                    }
                    collationTailoring2.unsafeBackwardSet.freeze();
                    collationData2.unsafeBackwardSet = collationTailoring2.unsafeBackwardSet;
                } else if (collationData2 != null) {
                    if (collationData != null) {
                        collationData2.unsafeBackwardSet = collationData.unsafeBackwardSet;
                    } else {
                        throw new ICUException("Missing unsafe-backward-set");
                    }
                }
                ICUBinary.skipBytes(byteBuffer, i18);
                int i22 = iArr2[16] - iArr2[15];
                if (collationData2 != null) {
                    collationData2.fastLatinTable = null;
                    collationData2.fastLatinTableHeader = null;
                    if (((iArr2[1] >> 16) & 255) == 2) {
                        if (i22 >= 2) {
                            char c = byteBuffer.getChar();
                            int i23 = c & 255;
                            collationData2.fastLatinTableHeader = new char[i23];
                            collationData2.fastLatinTableHeader[0] = c;
                            for (int i24 = 1; i24 < i23; i24++) {
                                collationData2.fastLatinTableHeader[i24] = byteBuffer.getChar();
                            }
                            collationData2.fastLatinTable = ICUBinary.getChars(byteBuffer, (i22 / 2) - i23, i22 & 1);
                            i22 = 0;
                            if ((c >> '\b') != 2) {
                                throw new ICUException("Fast-Latin table version differs from version in data header");
                            }
                        } else if (collationData != null) {
                            collationData2.fastLatinTable = collationData.fastLatinTable;
                            collationData2.fastLatinTableHeader = collationData.fastLatinTableHeader;
                        }
                    }
                }
                ICUBinary.skipBytes(byteBuffer, i22);
                int i25 = iArr2[17] - iArr2[16];
                if (i25 >= 2) {
                    if (collationData2 == null) {
                        throw new ICUException("Script order data but no mappings");
                    }
                    CharBuffer asCharBuffer = byteBuffer.asCharBuffer();
                    collationData2.numScripts = asCharBuffer.get();
                    int i26 = (i25 / 2) - ((collationData2.numScripts + 1) + 16);
                    if (i26 <= 2) {
                        throw new ICUException("Script order data too short");
                    }
                    char[] cArr = new char[(collationData2.numScripts + 16)];
                    collationData2.scriptsIndex = cArr;
                    asCharBuffer.get(cArr);
                    char[] cArr2 = new char[i26];
                    collationData2.scriptStarts = cArr2;
                    asCharBuffer.get(cArr2);
                    if (!(collationData2.scriptStarts[0] == 0 && collationData2.scriptStarts[1] == 768 && collationData2.scriptStarts[i26 - 1] == 65280)) {
                        throw new ICUException("Script order data not valid");
                    }
                } else if (!(collationData2 == null || collationData == null)) {
                    collationData2.numScripts = collationData.numScripts;
                    collationData2.scriptsIndex = collationData.scriptsIndex;
                    collationData2.scriptStarts = collationData.scriptStarts;
                }
                ICUBinary.skipBytes(byteBuffer, i25);
                int i27 = iArr2[18] - iArr2[17];
                if (i27 >= 256) {
                    if (collationData2 == null) {
                        throw new ICUException("Data for compressible primary lead bytes but no mappings");
                    }
                    collationData2.compressibleBytes = new boolean[256];
                    for (int i28 = 0; i28 < 256; i28++) {
                        collationData2.compressibleBytes[i28] = byteBuffer.get() != 0;
                    }
                    i27 -= 256;
                } else if (collationData2 != null) {
                    if (collationData != null) {
                        collationData2.compressibleBytes = collationData.compressibleBytes;
                    } else {
                        throw new ICUException("Missing data for compressible primary lead bytes");
                    }
                }
                ICUBinary.skipBytes(byteBuffer, i27);
                ICUBinary.skipBytes(byteBuffer, iArr2[19] - iArr2[18]);
                CollationSettings readOnly = collationTailoring2.settings.readOnly();
                int i29 = iArr2[1] & 65535;
                char[] cArr3 = new char[384];
                int options = CollationFastLatin.getOptions(collationTailoring2.data, readOnly, cArr3);
                if (i29 != readOnly.options || readOnly.variableTop == 0 || !Arrays.equals(iArr, readOnly.reorderCodes) || options != readOnly.fastLatinOptions || (options >= 0 && !Arrays.equals(cArr3, readOnly.fastLatinPrimaries))) {
                    CollationSettings copyOnWrite = collationTailoring2.settings.copyOnWrite();
                    copyOnWrite.options = i29;
                    copyOnWrite.variableTop = collationTailoring2.data.getLastPrimaryForGroup(copyOnWrite.getMaxVariable() + 4096);
                    if (copyOnWrite.variableTop == 0) {
                        throw new ICUException("The maxVariable could not be mapped to a variableTop");
                    }
                    if (i2 != 0) {
                        copyOnWrite.aliasReordering(collationData, iArr, i2, bArr);
                    }
                    copyOnWrite.fastLatinOptions = CollationFastLatin.getOptions(collationTailoring2.data, copyOnWrite, copyOnWrite.fastLatinPrimaries);
                    return;
                }
                return;
            }
            throw new ICUException("Tailoring numeric primary weight differs from base data");
        }
        throw new ICUException("Tailoring UCA version differs from base data UCA version");
    }

    static final class IsAcceptable implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 5;
        }
    }

    private CollationDataReader() {
    }
}
