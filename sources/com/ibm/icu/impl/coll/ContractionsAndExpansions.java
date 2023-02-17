package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Trie2;
import com.ibm.icu.text.UnicodeSet;
import java.util.Iterator;
public final class ContractionsAndExpansions {
    static final /* synthetic */ boolean $assertionsDisabled = (!ContractionsAndExpansions.class.desiredAssertionStatus());
    private boolean addPrefixes;
    private long[] ces = new long[31];
    private int checkTailored = 0;
    private UnicodeSet contractions;
    private CollationData data;
    private UnicodeSet expansions;
    private UnicodeSet ranges;
    private CESink sink;
    private String suffix;
    private UnicodeSet tailored = new UnicodeSet();
    private StringBuilder unreversedPrefix = new StringBuilder();

    public interface CESink {
        void handleCE(long j);

        void handleExpansion(long[] jArr, int i, int i2);
    }

    public ContractionsAndExpansions(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, CESink cESink, boolean z) {
        this.contractions = unicodeSet;
        this.expansions = unicodeSet2;
        this.sink = cESink;
        this.addPrefixes = z;
    }

    public void forData(CollationData collationData) {
        if (collationData.base != null) {
            this.checkTailored = -1;
        }
        this.data = collationData;
        Iterator<Trie2.Range> it = this.data.trie.iterator();
        while (it.hasNext()) {
            Trie2.Range next = it.next();
            if (next.leadSurrogate) {
                break;
            }
            enumCnERange(next.startCodePoint, next.endCodePoint, next.value, this);
        }
        if (collationData.base != null) {
            this.tailored.freeze();
            this.checkTailored = 1;
            this.data = collationData.base;
            Iterator<Trie2.Range> it2 = this.data.trie.iterator();
            while (it2.hasNext()) {
                Trie2.Range next2 = it2.next();
                if (!next2.leadSurrogate) {
                    enumCnERange(next2.startCodePoint, next2.endCodePoint, next2.value, this);
                } else {
                    return;
                }
            }
        }
    }

    private void enumCnERange(int i, int i2, int i3, ContractionsAndExpansions contractionsAndExpansions) {
        if (contractionsAndExpansions.checkTailored != 0) {
            if (contractionsAndExpansions.checkTailored < 0) {
                if (i3 != 192) {
                    contractionsAndExpansions.tailored.add(i, i2);
                } else {
                    return;
                }
            } else if (i == i2) {
                if (contractionsAndExpansions.tailored.contains(i)) {
                    return;
                }
            } else if (contractionsAndExpansions.tailored.containsSome(i, i2)) {
                if (contractionsAndExpansions.ranges == null) {
                    contractionsAndExpansions.ranges = new UnicodeSet();
                }
                contractionsAndExpansions.ranges.set(i, i2).removeAll(contractionsAndExpansions.tailored);
                int rangeCount = contractionsAndExpansions.ranges.getRangeCount();
                for (int i4 = 0; i4 < rangeCount; i4++) {
                    contractionsAndExpansions.handleCE32(contractionsAndExpansions.ranges.getRangeStart(i4), contractionsAndExpansions.ranges.getRangeEnd(i4), i3);
                }
            }
        }
        contractionsAndExpansions.handleCE32(i, i2, i3);
    }

    private void handleCE32(int i, int i2, int i3) {
        while ((i3 & 255) >= 192) {
            switch (Collation.tagFromCE32(i3)) {
                case 0:
                    return;
                case 1:
                    if (this.sink != null) {
                        this.sink.handleCE(Collation.ceFromLongPrimaryCE32(i3));
                        return;
                    }
                    return;
                case 2:
                    if (this.sink != null) {
                        this.sink.handleCE(Collation.ceFromLongSecondaryCE32(i3));
                        return;
                    }
                    return;
                case 3:
                case 7:
                case 13:
                    throw new AssertionError(String.format("Unexpected CE32 tag type %d for ce32=0x%08x", Integer.valueOf(Collation.tagFromCE32(i3)), Integer.valueOf(i3)));
                case 4:
                    if (this.sink != null) {
                        this.ces[0] = Collation.latinCE0FromCE32(i3);
                        this.ces[1] = Collation.latinCE1FromCE32(i3);
                        this.sink.handleExpansion(this.ces, 0, 2);
                    }
                    if (this.unreversedPrefix.length() == 0) {
                        addExpansions(i, i2);
                        return;
                    }
                    return;
                case 5:
                    if (this.sink != null) {
                        int indexFromCE32 = Collation.indexFromCE32(i3);
                        int lengthFromCE32 = Collation.lengthFromCE32(i3);
                        for (int i4 = 0; i4 < lengthFromCE32; i4++) {
                            this.ces[i4] = Collation.ceFromCE32(this.data.ce32s[indexFromCE32 + i4]);
                        }
                        this.sink.handleExpansion(this.ces, 0, lengthFromCE32);
                    }
                    if (this.unreversedPrefix.length() == 0) {
                        addExpansions(i, i2);
                        return;
                    }
                    return;
                case 6:
                    if (this.sink != null) {
                        this.sink.handleExpansion(this.data.ces, Collation.indexFromCE32(i3), Collation.lengthFromCE32(i3));
                    }
                    if (this.unreversedPrefix.length() == 0) {
                        addExpansions(i, i2);
                        return;
                    }
                    return;
                case 8:
                    handlePrefixes(i, i2, i3);
                    return;
                case 9:
                    handleContractions(i, i2, i3);
                    return;
                case 10:
                    i3 = this.data.ce32s[Collation.indexFromCE32(i3)];
                    break;
                case 11:
                    if ($assertionsDisabled || (i == 0 && i2 == 0)) {
                        i3 = this.data.ce32s[0];
                        break;
                    } else {
                        throw new AssertionError();
                    }
                case 12:
                    if (this.sink != null) {
                        UTF16CollationIterator uTF16CollationIterator = new UTF16CollationIterator(this.data);
                        StringBuilder sb = new StringBuilder(1);
                        for (int i5 = i; i5 <= i2; i5++) {
                            sb.setLength(0);
                            sb.appendCodePoint(i5);
                            uTF16CollationIterator.setText(false, sb, 0);
                            int fetchCEs = uTF16CollationIterator.fetchCEs();
                            if ($assertionsDisabled || (fetchCEs >= 2 && uTF16CollationIterator.getCE(fetchCEs - 1) == 4311744768L)) {
                                this.sink.handleExpansion(uTF16CollationIterator.getCEs(), 0, fetchCEs - 1);
                            } else {
                                throw new AssertionError();
                            }
                        }
                    }
                    if (this.unreversedPrefix.length() == 0) {
                        addExpansions(i, i2);
                        return;
                    }
                    return;
                case 14:
                    return;
                case 15:
                    return;
            }
        }
        if (this.sink != null) {
            this.sink.handleCE(Collation.ceFromSimpleCE32(i3));
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.ibm.icu.util.CharsTrie$Iterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handlePrefixes(int r7, int r8, int r9) {
        /*
            r6 = this;
            int r3 = com.ibm.icu.impl.coll.Collation.indexFromCE32(r9)
            com.ibm.icu.impl.coll.CollationData r0 = r6.data
            int r9 = r0.getCE32FromContexts(r3)
            r6.handleCE32(r7, r8, r9)
            boolean r0 = r6.addPrefixes
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            com.ibm.icu.util.CharsTrie r0 = new com.ibm.icu.util.CharsTrie
            com.ibm.icu.impl.coll.CollationData r1 = r6.data
            java.lang.String r1 = r1.contexts
            int r2 = r3 + 2
            r0.<init>(r1, r2)
            com.ibm.icu.util.CharsTrie$Iterator r4 = r0.iterator()
        L_0x0021:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0040
            com.ibm.icu.util.CharsTrie$Entry r5 = r4.next()
            java.lang.CharSequence r0 = r5.chars
            r6.setPrefix(r0)
            com.ibm.icu.text.UnicodeSet r0 = r6.contractions
            r6.addStrings(r7, r8, r0)
            com.ibm.icu.text.UnicodeSet r0 = r6.expansions
            r6.addStrings(r7, r8, r0)
            int r0 = r5.value
            r6.handleCE32(r7, r8, r0)
            goto L_0x0021
        L_0x0040:
            r6.resetPrefix()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.ContractionsAndExpansions.handlePrefixes(int, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.ibm.icu.util.CharsTrie$Iterator] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleContractions(int r7, int r8, int r9) {
        /*
            r6 = this;
            int r3 = com.ibm.icu.impl.coll.Collation.indexFromCE32(r9)
            r0 = r9 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x001a
            boolean r0 = com.ibm.icu.impl.coll.ContractionsAndExpansions.$assertionsDisabled
            if (r0 != 0) goto L_0x0033
            java.lang.StringBuilder r0 = r6.unreversedPrefix
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0033
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x001a:
            com.ibm.icu.impl.coll.CollationData r0 = r6.data
            int r9 = r0.getCE32FromContexts(r3)
            boolean r0 = com.ibm.icu.impl.coll.ContractionsAndExpansions.$assertionsDisabled
            if (r0 != 0) goto L_0x0030
            boolean r0 = com.ibm.icu.impl.coll.Collation.isContractionCE32(r9)
            if (r0 == 0) goto L_0x0030
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0030:
            r6.handleCE32(r7, r8, r9)
        L_0x0033:
            com.ibm.icu.util.CharsTrie r0 = new com.ibm.icu.util.CharsTrie
            com.ibm.icu.impl.coll.CollationData r1 = r6.data
            java.lang.String r1 = r1.contexts
            int r2 = r3 + 2
            r0.<init>(r1, r2)
            com.ibm.icu.util.CharsTrie$Iterator r4 = r0.iterator()
        L_0x0042:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x006c
            com.ibm.icu.util.CharsTrie$Entry r5 = r4.next()
            java.lang.CharSequence r0 = r5.chars
            java.lang.String r0 = r0.toString()
            r6.suffix = r0
            com.ibm.icu.text.UnicodeSet r0 = r6.contractions
            r6.addStrings(r7, r8, r0)
            java.lang.StringBuilder r0 = r6.unreversedPrefix
            int r0 = r0.length()
            if (r0 == 0) goto L_0x0066
            com.ibm.icu.text.UnicodeSet r0 = r6.expansions
            r6.addStrings(r7, r8, r0)
        L_0x0066:
            int r0 = r5.value
            r6.handleCE32(r7, r8, r0)
            goto L_0x0042
        L_0x006c:
            r0 = 0
            r6.suffix = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.ContractionsAndExpansions.handleContractions(int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void addExpansions(int i, int i2) {
        if (this.unreversedPrefix.length() != 0 || this.suffix != null) {
            addStrings(i, i2, this.expansions);
        } else if (this.expansions != null) {
            this.expansions.add(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void addStrings(int i, int i2, UnicodeSet unicodeSet) {
        if (unicodeSet != null) {
            StringBuilder sb = new StringBuilder(this.unreversedPrefix);
            do {
                sb.appendCodePoint(i);
                if (this.suffix != null) {
                    sb.append(this.suffix);
                }
                unicodeSet.add(sb);
                sb.setLength(this.unreversedPrefix.length());
                i++;
            } while (i <= i2);
        }
    }

    private void setPrefix(CharSequence charSequence) {
        this.unreversedPrefix.setLength(0);
        this.unreversedPrefix.append(charSequence).reverse();
    }

    private void resetPrefix() {
        this.unreversedPrefix.setLength(0);
    }
}
