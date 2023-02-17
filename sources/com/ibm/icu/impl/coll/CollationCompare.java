package com.ibm.icu.impl.coll;
public final class CollationCompare {
    static final /* synthetic */ boolean $assertionsDisabled = (!CollationCompare.class.desiredAssertionStatus());

    public static int compareUpToQuaternary(CollationIterator collationIterator, CollationIterator collationIterator2, CollationSettings collationSettings) {
        long j;
        long j2;
        int ce;
        int i;
        long j3;
        long j4;
        int i2;
        int i3;
        int i4;
        int ce2;
        int ce3;
        int i5;
        int i6;
        long ce4;
        int i7;
        int ce5;
        int i8 = collationSettings.options;
        if ((i8 & 12) == 0) {
            j = 0;
        } else {
            j = collationSettings.variableTop + 1;
        }
        boolean z = false;
        while (true) {
            long nextCE = collationIterator.nextCE();
            long j5 = nextCE >>> 32;
            if (j5 < j && j5 > 33554432) {
                z = true;
                do {
                    collationIterator.setCurrentCE(-4294967296L & nextCE);
                    while (true) {
                        nextCE = collationIterator.nextCE();
                        j5 = nextCE >>> 32;
                        if (j5 != 0) {
                            break;
                        }
                        collationIterator.setCurrentCE(0);
                    }
                    if (j5 >= j) {
                        break;
                    }
                } while (j5 > 33554432);
            }
            if (j5 != 0) {
                do {
                    long nextCE2 = collationIterator2.nextCE();
                    j2 = nextCE2 >>> 32;
                    if (j2 < j && j2 > 33554432) {
                        z = true;
                        do {
                            collationIterator2.setCurrentCE(-4294967296L & nextCE2);
                            while (true) {
                                nextCE2 = collationIterator2.nextCE();
                                j2 = nextCE2 >>> 32;
                                if (j2 != 0) {
                                    break;
                                }
                                collationIterator2.setCurrentCE(0);
                            }
                            if (j2 >= j) {
                                break;
                            }
                        } while (j2 > 33554432);
                    }
                } while (j2 == 0);
                if (j5 != j2) {
                    if (collationSettings.hasReordering()) {
                        j5 = collationSettings.reorder(j5);
                        j2 = collationSettings.reorder(j2);
                    }
                    return j5 < j2 ? -1 : 1;
                } else if (j5 == 1) {
                    if (CollationSettings.getStrength(i8) >= 1) {
                        if ((i8 & 2048) == 0) {
                            int i9 = 0;
                            int i10 = 0;
                            while (true) {
                                i9++;
                                int ce6 = ((int) collationIterator.getCE(i9)) >>> 16;
                                if (ce6 != 0) {
                                    do {
                                        i10++;
                                        ce5 = ((int) collationIterator2.getCE(i10)) >>> 16;
                                    } while (ce5 == 0);
                                    if (ce6 != ce5) {
                                        return ce6 < ce5 ? -1 : 1;
                                    }
                                    if (ce6 == 256) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            int i11 = 0;
                            int i12 = 0;
                            while (true) {
                                int i13 = i11;
                                while (true) {
                                    long ce7 = collationIterator.getCE(i13) >>> 32;
                                    if (ce7 <= 33554432 && ce7 != 0) {
                                        break;
                                    }
                                    i13++;
                                }
                                int i14 = i12;
                                while (true) {
                                    ce4 = collationIterator2.getCE(i14) >>> 32;
                                    if (ce4 <= 33554432 && ce4 != 0) {
                                        break;
                                    }
                                    i14++;
                                }
                                int i15 = i13;
                                int i16 = i14;
                                do {
                                    i7 = 0;
                                    while (i7 == 0 && i15 > i11) {
                                        i15--;
                                        i7 = ((int) collationIterator.getCE(i15)) >>> 16;
                                    }
                                    int i17 = 0;
                                    while (i17 == 0 && i16 > i12) {
                                        i16--;
                                        i17 = ((int) collationIterator2.getCE(i16)) >>> 16;
                                    }
                                    if (i7 != i17) {
                                        return i7 < i17 ? -1 : 1;
                                    }
                                } while (i7 != 0);
                                if (!$assertionsDisabled && collationIterator.getCE(i13) != collationIterator2.getCE(i14)) {
                                    throw new AssertionError();
                                } else if (ce4 == 1) {
                                    break;
                                } else {
                                    i11 = i13 + 1;
                                    i12 = i14 + 1;
                                }
                            }
                        }
                    }
                    if ((i8 & 1024) != 0) {
                        int strength = CollationSettings.getStrength(i8);
                        int i18 = 0;
                        int i19 = 0;
                        do {
                            if (strength == 0) {
                                while (true) {
                                    i18++;
                                    long ce8 = collationIterator.getCE(i18);
                                    i5 = (int) ce8;
                                    if ((ce8 >>> 32) != 0 && i5 != 0) {
                                        break;
                                    }
                                }
                                i3 = i5;
                                i4 = i5 & 49152;
                                while (true) {
                                    i19++;
                                    long ce9 = collationIterator2.getCE(i19);
                                    i6 = (int) ce9;
                                    if ((ce9 >>> 32) != 0 && i6 != 0) {
                                        break;
                                    }
                                }
                                i2 = i6 & 49152;
                            } else {
                                do {
                                    i18++;
                                    ce2 = (int) collationIterator.getCE(i18);
                                } while ((-65536 & ce2) == 0);
                                i3 = ce2;
                                i4 = ce2 & 49152;
                                do {
                                    i19++;
                                    ce3 = (int) collationIterator2.getCE(i19);
                                } while ((-65536 & ce3) == 0);
                                i2 = ce3 & 49152;
                            }
                            if (i4 != i2) {
                                return (i8 & 256) == 0 ? i4 < i2 ? -1 : 1 : i4 < i2 ? 1 : -1;
                            }
                        } while ((i3 >>> 16) != 256);
                    }
                    if (CollationSettings.getStrength(i8) <= 1) {
                        return 0;
                    }
                    int tertiaryMask = CollationSettings.getTertiaryMask(i8);
                    int i20 = 0;
                    int i21 = 0;
                    int i22 = 0;
                    while (true) {
                        i20++;
                        int ce10 = (int) collationIterator.getCE(i20);
                        i22 |= ce10;
                        if ($assertionsDisabled || (ce10 & 16191) != 0 || (49344 & ce10) == 0) {
                            int i23 = ce10 & tertiaryMask;
                            if (i23 != 0) {
                                do {
                                    i21++;
                                    ce = (int) collationIterator2.getCE(i21);
                                    i22 |= ce;
                                    if ($assertionsDisabled || (ce & 16191) != 0 || (49344 & ce) == 0) {
                                        i = ce & tertiaryMask;
                                    } else {
                                        throw new AssertionError();
                                    }
                                } while (i == 0);
                                if (i23 != i) {
                                    if (CollationSettings.sortsTertiaryUpperCaseFirst(i8)) {
                                        if (i23 > 256) {
                                            if ((-65536 & ce10) != 0) {
                                                i23 ^= 49152;
                                            } else {
                                                i23 += 16384;
                                            }
                                        }
                                        if (i > 256) {
                                            i = (-65536 & ce) != 0 ? i ^ 49152 : i + 16384;
                                        }
                                    }
                                    return i23 < i ? -1 : 1;
                                } else if (i23 == 256) {
                                    if (CollationSettings.getStrength(i8) <= 2) {
                                        return 0;
                                    }
                                    if (!z && (i22 & 192) == 0) {
                                        return 0;
                                    }
                                    int i24 = 0;
                                    int i25 = 0;
                                    while (true) {
                                        i24++;
                                        long ce11 = collationIterator.getCE(i24);
                                        long j6 = ce11 & 65535;
                                        if (j6 <= 256) {
                                            j3 = ce11 >>> 32;
                                        } else {
                                            j3 = j6 | 4294967103L;
                                        }
                                        if (j3 != 0) {
                                            do {
                                                i25++;
                                                long ce12 = collationIterator2.getCE(i25);
                                                long j7 = ce12 & 65535;
                                                if (j7 <= 256) {
                                                    j4 = ce12 >>> 32;
                                                } else {
                                                    j4 = j7 | 4294967103L;
                                                }
                                            } while (j4 == 0);
                                            if (j3 != j4) {
                                                if (collationSettings.hasReordering()) {
                                                    j3 = collationSettings.reorder(j3);
                                                    j4 = collationSettings.reorder(j4);
                                                }
                                                return j3 < j4 ? -1 : 1;
                                            } else if (j3 == 1) {
                                                return 0;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
        }
    }
}
