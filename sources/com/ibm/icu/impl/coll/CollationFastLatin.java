package com.ibm.icu.impl.coll;
public final class CollationFastLatin {
    static final /* synthetic */ boolean $assertionsDisabled = (!CollationFastLatin.class.desiredAssertionStatus());

    public static int getOptions(CollationData collationData, CollationSettings collationSettings, char[] cArr) {
        char c;
        int i;
        char[] cArr2 = collationData.fastLatinTableHeader;
        if (cArr2 == null) {
            return -1;
        }
        if (!$assertionsDisabled && (cArr2[0] >> '\b') != 2) {
            throw new AssertionError();
        } else if (cArr.length == 384) {
            if ((collationSettings.options & 12) == 0) {
                c = 3071;
            } else {
                int i2 = cArr2[0] & 255;
                int maxVariable = collationSettings.getMaxVariable() + 1;
                if (maxVariable >= i2) {
                    return -1;
                }
                c = cArr2[maxVariable];
            }
            boolean z = false;
            if (collationSettings.hasReordering()) {
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                for (int i3 = 4096; i3 < 4104; i3++) {
                    long reorder = collationSettings.reorder(collationData.getFirstPrimaryForGroup(i3));
                    if (i3 == 4100) {
                        j2 = j;
                        j3 = reorder;
                    } else if (reorder == 0) {
                        continue;
                    } else if (reorder < j) {
                        return -1;
                    } else {
                        if (j3 != 0 && j4 == 0 && j == j2) {
                            j4 = reorder;
                        }
                        j = reorder;
                    }
                }
                long reorder2 = collationSettings.reorder(collationData.getFirstPrimaryForGroup(25));
                if (reorder2 < j) {
                    return -1;
                }
                if (j4 == 0) {
                    j4 = reorder2;
                }
                if (j2 >= j3 || j3 >= j4) {
                    z = true;
                }
            }
            char[] cArr3 = collationData.fastLatinTable;
            for (int i4 = 0; i4 < 384; i4++) {
                char c2 = cArr3[i4];
                if (c2 >= 4096) {
                    i = c2 & 64512;
                } else if (c2 > c) {
                    i = c2 & 65528;
                } else {
                    i = 0;
                }
                cArr[i4] = (char) i;
            }
            if (z || (collationSettings.options & 2) != 0) {
                for (int i5 = 48; i5 <= 57; i5++) {
                    cArr[i5] = 0;
                }
            }
            return (c << 16) | collationSettings.options;
        } else if ($assertionsDisabled) {
            return -1;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:318:0x00e2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:358:0x0259 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:375:0x0306 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:392:0x03b5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:297:0x0077 */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: char[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v71, resolved type: char */
    /* JADX DEBUG: Multi-variable search result rejected for r5v67, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x00ec A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x00e4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x00e2 A[EDGE_INSN: B:318:0x00e2->B:69:0x00e2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x01bf A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x01b7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x01b5 A[EDGE_INSN: B:336:0x01b5->B:128:0x01b5 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0268 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0260 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x025e A[EDGE_INSN: B:355:0x025e->B:180:0x025e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0315 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x030d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x030b A[EDGE_INSN: B:372:0x030b->B:231:0x030b ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x03c4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x03bc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x03ba A[EDGE_INSN: B:389:0x03ba->B:285:0x03ba ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int compareUTF16(char[] r11, char[] r12, int r13, java.lang.CharSequence r14, java.lang.CharSequence r15, int r16) {
        /*
        // Method dump skipped, instructions count: 994
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.CollationFastLatin.compareUTF16(char[], char[], int, java.lang.CharSequence, java.lang.CharSequence, int):int");
    }

    private static int lookup(char[] cArr, int i) {
        if (!$assertionsDisabled && i <= 383) {
            throw new AssertionError();
        } else if (8192 <= i && i < 8256) {
            return cArr[(i - 8192) + 384];
        } else {
            if (i == 65534) {
                return 3;
            }
            if (i == 65535) {
                return 64680;
            }
            return 1;
        }
    }

    private static long nextPair(char[] cArr, int i, int i2, CharSequence charSequence, int i3) {
        long j;
        int i4;
        if (i2 >= 3072 || i2 < 1024) {
            return (long) i2;
        }
        if (i2 >= 2048) {
            int i5 = (i2 & 1023) + 448;
            return (((long) cArr[i5 + 1]) << 16) | ((long) cArr[i5]);
        }
        int i6 = (i2 & 1023) + 448;
        boolean z = false;
        if (i3 != charSequence.length()) {
            int i7 = i3 + 1;
            int charAt = charSequence.charAt(i3);
            if (charAt > 383) {
                if (8192 <= charAt && charAt < 8256) {
                    charAt = (charAt - 8192) + 384;
                } else if (charAt != 65534 && charAt != 65535) {
                    return 1;
                } else {
                    charAt = -1;
                }
            }
            int i8 = i6;
            char c = cArr[i8];
            do {
                i8 += c >> '\t';
                c = cArr[i8];
                i4 = c & 511;
            } while (i4 < charAt);
            if (i4 == charAt) {
                i6 = i8;
                z = true;
            }
        }
        int i9 = cArr[i6] >> '\t';
        if (i9 == 1) {
            return 1;
        }
        char c2 = cArr[i6 + 1];
        if (i9 == 2) {
            j = (long) c2;
        } else {
            j = (((long) cArr[i6 + 2]) << 16) | ((long) c2);
        }
        return z ? -1 ^ j : j;
    }

    private static int getPrimaries(int i, int i2) {
        int i3 = i2 & 65535;
        if (i3 >= 4096) {
            return -67044352 & i2;
        }
        if (i3 > i) {
            return -458760 & i2;
        }
        if (i3 >= 3072) {
            return 0;
        }
        return i2;
    }

    private static int getSecondariesFromOneShortCE(int i) {
        int i2 = i & 992;
        if (i2 < 384) {
            return i2 + 32;
        }
        return ((i2 + 32) << 16) | 192;
    }

    private static int getSecondaries(int i, int i2) {
        if (i2 > 65535) {
            int i3 = i2 & 65535;
            if (i3 >= 4096) {
                return (65012704 & i2) + 2097184;
            }
            if (i3 > i) {
                return 12583104;
            }
            if ($assertionsDisabled || i3 >= 3072) {
                return 0;
            }
            throw new AssertionError();
        } else if (i2 >= 4096) {
            return getSecondariesFromOneShortCE(i2);
        } else {
            if (i2 > i) {
                return 192;
            }
            if (i2 >= 3072) {
                return 0;
            }
            return i2;
        }
    }

    private static int getCases(int i, boolean z, int i2) {
        if (i2 > 65535) {
            int i3 = i2 & 65535;
            if (i3 >= 4096) {
                if (!z || (-67108864 & i2) != 0) {
                    return i2 & 1572888;
                }
                return i2 & 24;
            } else if (i3 > i) {
                return 524296;
            } else {
                if ($assertionsDisabled || i3 >= 3072) {
                    return 0;
                }
                throw new AssertionError();
            }
        } else if (i2 >= 4096) {
            int i4 = i2 & 24;
            if (z || (i2 & 992) < 384) {
                return i4;
            }
            return i4 | 524288;
        } else if (i2 > i) {
            return 8;
        } else {
            if (i2 >= 3072) {
                return 0;
            }
            return i2;
        }
    }

    private static int getTertiaries(int i, boolean z, int i2) {
        int i3;
        if (i2 > 65535) {
            int i4 = i2 & 65535;
            if (i4 >= 4096) {
                if (z) {
                    i3 = i2 & 2031647;
                } else {
                    i3 = i2 & 458759;
                }
                return i3 + 2097184;
            } else if (i4 > i) {
                int i5 = (458759 & i2) + 2097184;
                if (z) {
                    return i5 | 524296;
                }
                return i5;
            } else if ($assertionsDisabled || i4 >= 3072) {
                return 0;
            } else {
                throw new AssertionError();
            }
        } else if (i2 >= 4096) {
            if (z) {
                int i6 = (i2 & 31) + 32;
                if ((i2 & 992) >= 384) {
                    return i6 | 2621440;
                }
                return i6;
            }
            int i7 = (i2 & 7) + 32;
            if ((i2 & 992) >= 384) {
                return i7 | 2097152;
            }
            return i7;
        } else if (i2 > i) {
            int i8 = (i2 & 7) + 32;
            if (z) {
                return i8 | 8;
            }
            return i8;
        } else if (i2 >= 3072) {
            return 0;
        } else {
            return i2;
        }
    }

    private static int getQuaternaries(int i, int i2) {
        if (i2 > 65535) {
            int i3 = i2 & 65535;
            if (i3 > i) {
                return -67044352;
            }
            if ($assertionsDisabled || i3 >= 3072) {
                return i2 & -458760;
            }
            throw new AssertionError();
        } else if (i2 >= 4096) {
            if ((i2 & 992) >= 384) {
                return -67044352;
            }
            return 64512;
        } else if (i2 > i) {
            return 64512;
        } else {
            if (i2 >= 3072) {
                return i2 & 65528;
            }
            return i2;
        }
    }

    private CollationFastLatin() {
    }
}
