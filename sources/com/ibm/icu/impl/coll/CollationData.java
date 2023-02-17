package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Trie2_32;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ICUException;
public final class CollationData {
    static final /* synthetic */ boolean $assertionsDisabled = (!CollationData.class.desiredAssertionStatus());
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    public CollationData base;
    int[] ce32s;
    long[] ces;
    public boolean[] compressibleBytes;
    String contexts;
    public char[] fastLatinTable;
    char[] fastLatinTableHeader;
    int[] jamoCE32s = new int[67];
    public Normalizer2Impl nfcImpl;
    int numScripts;
    long numericPrimary = 301989888;
    public long[] rootElements;
    char[] scriptStarts;
    char[] scriptsIndex;
    Trie2_32 trie;
    UnicodeSet unsafeBackwardSet;

    CollationData(Normalizer2Impl normalizer2Impl) {
        this.nfcImpl = normalizer2Impl;
    }

    public int getCE32(int i) {
        return this.trie.get(i);
    }

    /* access modifiers changed from: package-private */
    public int getCE32FromSupplementary(int i) {
        return this.trie.get(i);
    }

    /* access modifiers changed from: package-private */
    public boolean isDigit(int i) {
        if (i < 1632) {
            return i <= 57 && 48 <= i;
        }
        return Collation.hasCE32Tag(getCE32(i), 10);
    }

    public boolean isUnsafeBackward(int i, boolean z) {
        return this.unsafeBackwardSet.contains(i) || (z && isDigit(i));
    }

    /* access modifiers changed from: package-private */
    public int getCE32FromContexts(int i) {
        return (this.contexts.charAt(i) << 16) | this.contexts.charAt(i + 1);
    }

    /* access modifiers changed from: package-private */
    public int getIndirectCE32(int i) {
        if ($assertionsDisabled || Collation.isSpecialCE32(i)) {
            int tagFromCE32 = Collation.tagFromCE32(i);
            if (tagFromCE32 == 10) {
                return this.ce32s[Collation.indexFromCE32(i)];
            }
            if (tagFromCE32 == 13) {
                return -1;
            }
            if (tagFromCE32 == 11) {
                return this.ce32s[0];
            }
            return i;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public int getFinalCE32(int i) {
        if (Collation.isSpecialCE32(i)) {
            return getIndirectCE32(i);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public long getCEFromOffsetCE32(int i, int i2) {
        return Collation.makeCE(Collation.getThreeBytePrimaryForOffsetData(i, this.ces[Collation.indexFromCE32(i2)]));
    }

    /* access modifiers changed from: package-private */
    public int getFCD16(int i) {
        return this.nfcImpl.getFCD16(i);
    }

    /* access modifiers changed from: package-private */
    public long getFirstPrimaryForGroup(int i) {
        int scriptIndex = getScriptIndex(i);
        if (scriptIndex == 0) {
            return 0;
        }
        return ((long) this.scriptStarts[scriptIndex]) << 16;
    }

    public long getLastPrimaryForGroup(int i) {
        int scriptIndex = getScriptIndex(i);
        if (scriptIndex == 0) {
            return 0;
        }
        return (((long) this.scriptStarts[scriptIndex + 1]) << 16) - 1;
    }

    private int getScriptIndex(int i) {
        int i2;
        if (i < 0) {
            return 0;
        }
        if (i < this.numScripts) {
            return this.scriptsIndex[i];
        }
        if (i >= 4096 && i - 4096 < 8) {
            return this.scriptsIndex[this.numScripts + i2];
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void makeReorderRanges(int[] iArr, UVector32 uVector32) {
        makeReorderRanges(iArr, false, uVector32);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:142:0x00b0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:149:0x00e6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:157:0x00f2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:144:0x0176 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:162:0x0190 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:150:0x00e6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:158:0x00f2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.ibm.icu.impl.coll.CollationData] */
    /* JADX WARN: Type inference failed for: r0v10, types: [char[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [char] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [int] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    private void makeReorderRanges(int[] iArr, boolean z, UVector32 uVector32) {
        uVector32.removeAllElements();
        int length = iArr.length;
        if (length == 0) {
            return;
        }
        if (length != 1 || iArr[0] != 103) {
            short[] sArr = new short[(this.scriptStarts.length - 1)];
            char c = this.scriptsIndex[(this.numScripts + 4110) - 4096];
            if (c != 0) {
                sArr[c] = 255;
            }
            char c2 = this.scriptsIndex[(this.numScripts + 4111) - 4096];
            if (c2 != 0) {
                sArr[c2] = 255;
            }
            if (!$assertionsDisabled && this.scriptStarts.length < 2) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.scriptStarts[0] == 0) {
                char c3 = this.scriptStarts[1];
                if ($assertionsDisabled || c3 == 768) {
                    char c4 = this.scriptStarts[this.scriptStarts.length - 1];
                    if ($assertionsDisabled || c4 == 65280) {
                        int i = 0;
                        for (int i2 = 0; i2 < length; i2++) {
                            int i3 = iArr[i2] - 4096;
                            if (0 <= i3 && i3 < 8) {
                                i |= 1 << i3;
                            }
                        }
                        int i4 = 0;
                        int i5 = c3;
                        while (i4 < 8) {
                            char c5 = this.scriptsIndex[this.numScripts + i4];
                            if (c5 != 0 && ((1 << i4) & i) == 0) {
                                i5 = addLowScriptRange(sArr, c5, i5);
                            }
                            i4++;
                            i5 = i5;
                        }
                        int i6 = 0;
                        char c6 = i5;
                        if (i == 0) {
                            c6 = i5;
                            c6 = i5;
                            if (iArr[0] == 25 && !z) {
                                char c7 = this.scriptsIndex[25];
                                if ($assertionsDisabled || c7 != 0) {
                                    char c8 = this.scriptStarts[c7];
                                    if ($assertionsDisabled || i5 <= c8) {
                                        i6 = c8 - i5;
                                        c6 = c8;
                                    } else {
                                        throw new AssertionError();
                                    }
                                } else {
                                    throw new AssertionError();
                                }
                            }
                        }
                        boolean z2 = false;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= length) {
                                break;
                            }
                            i7++;
                            int i8 = iArr[i7];
                            if (i8 == 103) {
                                z2 = true;
                                while (i7 < length) {
                                    length--;
                                    int i9 = iArr[length];
                                    if (i9 == 103) {
                                        throw new IllegalArgumentException("setReorderCodes(): duplicate UScript.UNKNOWN");
                                    } else if (i9 == -1) {
                                        throw new IllegalArgumentException("setReorderCodes(): UScript.DEFAULT together with other scripts");
                                    } else {
                                        int scriptIndex = getScriptIndex(i9);
                                        if (scriptIndex != 0) {
                                            if (sArr[scriptIndex] != 0) {
                                                throw new IllegalArgumentException("setReorderCodes(): duplicate or equivalent script " + scriptCodeString(i9));
                                            }
                                            c4 = addHighScriptRange(sArr, scriptIndex, c4);
                                        }
                                    }
                                }
                            } else if (i8 == -1) {
                                throw new IllegalArgumentException("setReorderCodes(): UScript.DEFAULT together with other scripts");
                            } else {
                                int scriptIndex2 = getScriptIndex(i8);
                                if (scriptIndex2 != 0) {
                                    if (sArr[scriptIndex2] != 0) {
                                        throw new IllegalArgumentException("setReorderCodes(): duplicate or equivalent script " + scriptCodeString(i8));
                                    }
                                    c6 = addLowScriptRange(sArr, scriptIndex2, c6 == true ? 1 : 0);
                                }
                            }
                        }
                        int i10 = 1;
                        int i11 = c6;
                        while (i10 < this.scriptStarts.length - 1) {
                            if (sArr[i10] == 0) {
                                char c9 = this.scriptStarts[i10];
                                char c10 = i11;
                                c10 = i11;
                                if (!z2 && c9 > i11) {
                                    c10 = c9;
                                }
                                i11 = addLowScriptRange(sArr, i10, c10 == 1 ? 1 : 0);
                            }
                            i10++;
                            i11 = i11;
                        }
                        if (i11 <= c4) {
                            int i12 = 0;
                            int i13 = 1;
                            while (true) {
                                int i14 = i12;
                                while (i13 < this.scriptStarts.length - 1 && ((r13 = sArr[i13]) == 255 || (i14 = r13 - (this.scriptStarts[i13] >> '\b')) == i12)) {
                                    i13++;
                                }
                                if (i12 != 0 || i13 < this.scriptStarts.length - 1) {
                                    uVector32.addElement((this.scriptStarts[i13] << 16) | (65535 & i12));
                                }
                                if (i13 != this.scriptStarts.length - 1) {
                                    i12 = i14;
                                    i13++;
                                } else {
                                    return;
                                }
                            }
                        } else if (i11 - (65280 & i6) <= c4) {
                            makeReorderRanges(iArr, true, uVector32);
                        } else {
                            throw new ICUException("setReorderCodes(): reordering too many partial-primary-lead-byte scripts");
                        }
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw new AssertionError();
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    private int addLowScriptRange(short[] sArr, int i, int i2) {
        char c = this.scriptStarts[i];
        if ((c & 255) < (i2 & 255)) {
            i2 += 256;
        }
        sArr[i] = (short) (i2 >> 8);
        char c2 = this.scriptStarts[i + 1];
        return ((65280 & i2) + ((65280 & c2) - (65280 & c))) | (c2 & 255);
    }

    private int addHighScriptRange(short[] sArr, int i, int i2) {
        char c = this.scriptStarts[i + 1];
        if ((c & 255) > (i2 & 255)) {
            i2 -= 256;
        }
        char c2 = this.scriptStarts[i];
        int i3 = ((65280 & i2) - ((65280 & c) - (65280 & c2))) | (c2 & 255);
        sArr[i] = (short) (i3 >> 8);
        return i3;
    }

    private static String scriptCodeString(int i) {
        return i < 4096 ? Integer.toString(i) : "0x" + Integer.toHexString(i);
    }
}
