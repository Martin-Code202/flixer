package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.text.UnicodeSet;
import java.util.Iterator;
public final class TailoredSet {
    static final /* synthetic */ boolean $assertionsDisabled = (!TailoredSet.class.desiredAssertionStatus());
    private CollationData baseData;
    private CollationData data;
    private String suffix;
    private UnicodeSet tailored;
    private StringBuilder unreversedPrefix = new StringBuilder();

    public TailoredSet(UnicodeSet unicodeSet) {
        this.tailored = unicodeSet;
    }

    public void forData(CollationData collationData) {
        this.data = collationData;
        this.baseData = collationData.base;
        if ($assertionsDisabled || this.baseData != null) {
            Iterator<Trie2.Range> it = this.data.trie.iterator();
            while (it.hasNext()) {
                Trie2.Range next = it.next();
                if (!next.leadSurrogate) {
                    enumTailoredRange(next.startCodePoint, next.endCodePoint, next.value, this);
                } else {
                    return;
                }
            }
            return;
        }
        throw new AssertionError();
    }

    private void enumTailoredRange(int i, int i2, int i3, TailoredSet tailoredSet) {
        if (i3 != 192) {
            tailoredSet.handleCE32(i, i2, i3);
        }
    }

    private void handleCE32(int i, int i2, int i3) {
        if (!$assertionsDisabled && i3 == 192) {
            throw new AssertionError();
        } else if (!Collation.isSpecialCE32(i3) || (i3 = this.data.getIndirectCE32(i3)) != 192) {
            do {
                int finalCE32 = this.baseData.getFinalCE32(this.baseData.getCE32(i));
                if (!Collation.isSelfContainedCE32(i3) || !Collation.isSelfContainedCE32(finalCE32)) {
                    compare(i, i3, finalCE32);
                } else if (i3 != finalCE32) {
                    this.tailored.add(i);
                }
                i++;
            } while (i <= i2);
        }
    }

    private void compare(int i, int i2, int i3) {
        int i4;
        int i5;
        if (Collation.isPrefixCE32(i2)) {
            int indexFromCE32 = Collation.indexFromCE32(i2);
            i2 = this.data.getFinalCE32(this.data.getCE32FromContexts(indexFromCE32));
            if (Collation.isPrefixCE32(i3)) {
                int indexFromCE322 = Collation.indexFromCE32(i3);
                i3 = this.baseData.getFinalCE32(this.baseData.getCE32FromContexts(indexFromCE322));
                comparePrefixes(i, this.data.contexts, indexFromCE32 + 2, this.baseData.contexts, indexFromCE322 + 2);
            } else {
                addPrefixes(this.data, i, this.data.contexts, indexFromCE32 + 2);
            }
        } else if (Collation.isPrefixCE32(i3)) {
            int indexFromCE323 = Collation.indexFromCE32(i3);
            i3 = this.baseData.getFinalCE32(this.baseData.getCE32FromContexts(indexFromCE323));
            addPrefixes(this.baseData, i, this.baseData.contexts, indexFromCE323 + 2);
        }
        if (Collation.isContractionCE32(i2)) {
            int indexFromCE324 = Collation.indexFromCE32(i2);
            if ((i2 & 256) != 0) {
                i2 = 1;
            } else {
                i2 = this.data.getFinalCE32(this.data.getCE32FromContexts(indexFromCE324));
            }
            if (Collation.isContractionCE32(i3)) {
                int indexFromCE325 = Collation.indexFromCE32(i3);
                if ((i3 & 256) != 0) {
                    i3 = 1;
                } else {
                    i3 = this.baseData.getFinalCE32(this.baseData.getCE32FromContexts(indexFromCE325));
                }
                compareContractions(i, this.data.contexts, indexFromCE324 + 2, this.baseData.contexts, indexFromCE325 + 2);
            } else {
                addContractions(i, this.data.contexts, indexFromCE324 + 2);
            }
        } else if (Collation.isContractionCE32(i3)) {
            int indexFromCE326 = Collation.indexFromCE32(i3);
            i3 = this.baseData.getFinalCE32(this.baseData.getCE32FromContexts(indexFromCE326));
            addContractions(i, this.baseData.contexts, indexFromCE326 + 2);
        }
        if (Collation.isSpecialCE32(i2)) {
            i4 = Collation.tagFromCE32(i2);
            if (!$assertionsDisabled && i4 == 8) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && i4 == 9) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && i4 == 14) {
                throw new AssertionError();
            }
        } else {
            i4 = -1;
        }
        if (Collation.isSpecialCE32(i3)) {
            i5 = Collation.tagFromCE32(i3);
            if (!$assertionsDisabled && i5 == 8) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && i5 == 9) {
                throw new AssertionError();
            }
        } else {
            i5 = -1;
        }
        if (i5 == 14) {
            if (!Collation.isLongPrimaryCE32(i2)) {
                add(i);
                return;
            }
            if (Collation.primaryFromLongPrimaryCE32(i2) != Collation.getThreeBytePrimaryForOffsetData(i, this.baseData.ces[Collation.indexFromCE32(i3)])) {
                add(i);
                return;
            }
        }
        if (i4 != i5) {
            add(i);
        } else if (i4 == 5) {
            int lengthFromCE32 = Collation.lengthFromCE32(i2);
            if (lengthFromCE32 != Collation.lengthFromCE32(i3)) {
                add(i);
                return;
            }
            int indexFromCE327 = Collation.indexFromCE32(i2);
            int indexFromCE328 = Collation.indexFromCE32(i3);
            for (int i6 = 0; i6 < lengthFromCE32; i6++) {
                if (this.data.ce32s[indexFromCE327 + i6] != this.baseData.ce32s[indexFromCE328 + i6]) {
                    add(i);
                    return;
                }
            }
        } else if (i4 == 6) {
            int lengthFromCE322 = Collation.lengthFromCE32(i2);
            if (lengthFromCE322 != Collation.lengthFromCE32(i3)) {
                add(i);
                return;
            }
            int indexFromCE329 = Collation.indexFromCE32(i2);
            int indexFromCE3210 = Collation.indexFromCE32(i3);
            for (int i7 = 0; i7 < lengthFromCE322; i7++) {
                if (this.data.ces[indexFromCE329 + i7] != this.baseData.ces[indexFromCE3210 + i7]) {
                    add(i);
                    return;
                }
            }
        } else if (i4 == 12) {
            StringBuilder sb = new StringBuilder();
            int decompose = Normalizer2Impl.Hangul.decompose(i, sb);
            if (this.tailored.contains(sb.charAt(0)) || this.tailored.contains(sb.charAt(1)) || (decompose == 3 && this.tailored.contains(sb.charAt(2)))) {
                add(i);
            }
        } else if (i2 != i3) {
            add(i);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.ibm.icu.util.CharsTrie$Iterator] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.ibm.icu.util.CharsTrie$Iterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void comparePrefixes(int r11, java.lang.CharSequence r12, int r13, java.lang.CharSequence r14, int r15) {
        /*
            r10 = this;
            com.ibm.icu.util.CharsTrie r0 = new com.ibm.icu.util.CharsTrie
            r0.<init>(r12, r13)
            com.ibm.icu.util.CharsTrie$Iterator r2 = r0.iterator()
            com.ibm.icu.util.CharsTrie r0 = new com.ibm.icu.util.CharsTrie
            r0.<init>(r14, r15)
            com.ibm.icu.util.CharsTrie$Iterator r3 = r0.iterator()
            r4 = 0
            r5 = 0
            java.lang.String r6 = "￿"
            r7 = 0
            r8 = 0
        L_0x0018:
            if (r4 != 0) goto L_0x002d
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002b
            com.ibm.icu.util.CharsTrie$Entry r7 = r2.next()
            java.lang.CharSequence r0 = r7.chars
            java.lang.String r4 = r0.toString()
            goto L_0x002d
        L_0x002b:
            r7 = 0
            r4 = r6
        L_0x002d:
            if (r5 != 0) goto L_0x0042
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0040
            com.ibm.icu.util.CharsTrie$Entry r8 = r3.next()
            java.lang.CharSequence r0 = r8.chars
            java.lang.String r5 = r0.toString()
            goto L_0x0042
        L_0x0040:
            r8 = 0
            r5 = r6
        L_0x0042:
            boolean r0 = com.ibm.icu.impl.Utility.sameObjects(r4, r6)
            if (r0 == 0) goto L_0x0050
            boolean r0 = com.ibm.icu.impl.Utility.sameObjects(r5, r6)
            if (r0 == 0) goto L_0x0050
            goto L_0x00a5
        L_0x0050:
            int r9 = r4.compareTo(r5)
            if (r9 >= 0) goto L_0x006c
            boolean r0 = com.ibm.icu.impl.coll.TailoredSet.$assertionsDisabled
            if (r0 != 0) goto L_0x0062
            if (r7 != 0) goto L_0x0062
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0062:
            com.ibm.icu.impl.coll.CollationData r0 = r10.data
            int r1 = r7.value
            r10.addPrefix(r0, r4, r11, r1)
            r7 = 0
            r4 = 0
            goto L_0x00a3
        L_0x006c:
            if (r9 <= 0) goto L_0x0084
            boolean r0 = com.ibm.icu.impl.coll.TailoredSet.$assertionsDisabled
            if (r0 != 0) goto L_0x007a
            if (r8 != 0) goto L_0x007a
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x007a:
            com.ibm.icu.impl.coll.CollationData r0 = r10.baseData
            int r1 = r8.value
            r10.addPrefix(r0, r5, r11, r1)
            r8 = 0
            r5 = 0
            goto L_0x00a3
        L_0x0084:
            r10.setPrefix(r4)
            boolean r0 = com.ibm.icu.impl.coll.TailoredSet.$assertionsDisabled
            if (r0 != 0) goto L_0x0095
            if (r7 == 0) goto L_0x008f
            if (r8 != 0) goto L_0x0095
        L_0x008f:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0095:
            int r0 = r7.value
            int r1 = r8.value
            r10.compare(r11, r0, r1)
            r10.resetPrefix()
            r8 = 0
            r7 = 0
            r5 = 0
            r4 = 0
        L_0x00a3:
            goto L_0x0018
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.TailoredSet.comparePrefixes(int, java.lang.CharSequence, int, java.lang.CharSequence, int):void");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.ibm.icu.util.CharsTrie$Iterator] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.ibm.icu.util.CharsTrie$Iterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void compareContractions(int r11, java.lang.CharSequence r12, int r13, java.lang.CharSequence r14, int r15) {
        /*
            r10 = this;
            com.ibm.icu.util.CharsTrie r0 = new com.ibm.icu.util.CharsTrie
            r0.<init>(r12, r13)
            com.ibm.icu.util.CharsTrie$Iterator r2 = r0.iterator()
            com.ibm.icu.util.CharsTrie r0 = new com.ibm.icu.util.CharsTrie
            r0.<init>(r14, r15)
            com.ibm.icu.util.CharsTrie$Iterator r3 = r0.iterator()
            r4 = 0
            r5 = 0
            java.lang.String r6 = "￿￿"
            r7 = 0
            r8 = 0
        L_0x0018:
            if (r4 != 0) goto L_0x002d
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002b
            com.ibm.icu.util.CharsTrie$Entry r7 = r2.next()
            java.lang.CharSequence r0 = r7.chars
            java.lang.String r4 = r0.toString()
            goto L_0x002d
        L_0x002b:
            r7 = 0
            r4 = r6
        L_0x002d:
            if (r5 != 0) goto L_0x0042
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0040
            com.ibm.icu.util.CharsTrie$Entry r8 = r3.next()
            java.lang.CharSequence r0 = r8.chars
            java.lang.String r5 = r0.toString()
            goto L_0x0042
        L_0x0040:
            r8 = 0
            r5 = r6
        L_0x0042:
            boolean r0 = com.ibm.icu.impl.Utility.sameObjects(r4, r6)
            if (r0 == 0) goto L_0x004f
            boolean r0 = com.ibm.icu.impl.Utility.sameObjects(r5, r6)
            if (r0 == 0) goto L_0x004f
            goto L_0x0075
        L_0x004f:
            int r9 = r4.compareTo(r5)
            if (r9 >= 0) goto L_0x005b
            r10.addSuffix(r11, r4)
            r7 = 0
            r4 = 0
            goto L_0x0073
        L_0x005b:
            if (r9 <= 0) goto L_0x0063
            r10.addSuffix(r11, r5)
            r8 = 0
            r5 = 0
            goto L_0x0073
        L_0x0063:
            r10.suffix = r4
            int r0 = r7.value
            int r1 = r8.value
            r10.compare(r11, r0, r1)
            r0 = 0
            r10.suffix = r0
            r8 = 0
            r7 = 0
            r5 = 0
            r4 = 0
        L_0x0073:
            goto L_0x0018
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.TailoredSet.compareContractions(int, java.lang.CharSequence, int, java.lang.CharSequence, int):void");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.ibm.icu.util.CharsTrie$Iterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addPrefixes(com.ibm.icu.impl.coll.CollationData r5, int r6, java.lang.CharSequence r7, int r8) {
        /*
            r4 = this;
            com.ibm.icu.util.CharsTrie r0 = new com.ibm.icu.util.CharsTrie
            r0.<init>(r7, r8)
            com.ibm.icu.util.CharsTrie$Iterator r2 = r0.iterator()
        L_0x0009:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x001b
            com.ibm.icu.util.CharsTrie$Entry r3 = r2.next()
            java.lang.CharSequence r0 = r3.chars
            int r1 = r3.value
            r4.addPrefix(r5, r0, r6, r1)
            goto L_0x0009
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.TailoredSet.addPrefixes(com.ibm.icu.impl.coll.CollationData, int, java.lang.CharSequence, int):void");
    }

    private void addPrefix(CollationData collationData, CharSequence charSequence, int i, int i2) {
        setPrefix(charSequence);
        int finalCE32 = collationData.getFinalCE32(i2);
        if (Collation.isContractionCE32(finalCE32)) {
            addContractions(i, collationData.contexts, Collation.indexFromCE32(finalCE32) + 2);
        }
        this.tailored.add(new StringBuilder(this.unreversedPrefix.appendCodePoint(i)));
        resetPrefix();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.ibm.icu.util.CharsTrie$Iterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addContractions(int r4, java.lang.CharSequence r5, int r6) {
        /*
            r3 = this;
            com.ibm.icu.util.CharsTrie r0 = new com.ibm.icu.util.CharsTrie
            r0.<init>(r5, r6)
            com.ibm.icu.util.CharsTrie$Iterator r1 = r0.iterator()
        L_0x0009:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0019
            com.ibm.icu.util.CharsTrie$Entry r2 = r1.next()
            java.lang.CharSequence r0 = r2.chars
            r3.addSuffix(r4, r0)
            goto L_0x0009
        L_0x0019:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.TailoredSet.addContractions(int, java.lang.CharSequence, int):void");
    }

    private void addSuffix(int i, CharSequence charSequence) {
        this.tailored.add(new StringBuilder(this.unreversedPrefix).appendCodePoint(i).append(charSequence));
    }

    private void add(int i) {
        if (this.unreversedPrefix.length() == 0 && this.suffix == null) {
            this.tailored.add(i);
            return;
        }
        StringBuilder sb = new StringBuilder(this.unreversedPrefix);
        sb.appendCodePoint(i);
        if (this.suffix != null) {
            sb.append(this.suffix);
        }
        this.tailored.add(sb);
    }

    private void setPrefix(CharSequence charSequence) {
        this.unreversedPrefix.setLength(0);
        this.unreversedPrefix.append(charSequence).reverse();
    }

    private void resetPrefix() {
        this.unreversedPrefix.setLength(0);
    }
}
