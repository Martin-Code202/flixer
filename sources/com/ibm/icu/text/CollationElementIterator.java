package com.ibm.icu.text;

import com.ibm.icu.impl.coll.CollationData;
import com.ibm.icu.impl.coll.CollationIterator;
import com.ibm.icu.impl.coll.ContractionsAndExpansions;
import com.ibm.icu.impl.coll.FCDUTF16CollationIterator;
import com.ibm.icu.impl.coll.UTF16CollationIterator;
import com.ibm.icu.impl.coll.UVector32;
import java.util.HashMap;
import java.util.Map;
public final class CollationElementIterator {
    static final /* synthetic */ boolean $assertionsDisabled = (!CollationElementIterator.class.desiredAssertionStatus());
    private byte dir_;
    private CollationIterator iter_;
    private UVector32 offsets_;
    private int otherHalf_;
    private RuleBasedCollator rbc_;
    private String string_;

    public static final int primaryOrder(int i) {
        return (i >>> 16) & 65535;
    }

    /* access modifiers changed from: private */
    public static final int getFirstHalf(long j, int i) {
        return (((int) j) & -65536) | ((i >> 16) & 65280) | ((i >> 8) & 255);
    }

    /* access modifiers changed from: private */
    public static final int getSecondHalf(long j, int i) {
        return (((int) j) << 16) | ((i >> 8) & 65280) | (i & 63);
    }

    /* access modifiers changed from: private */
    public static final boolean ceNeedsTwoParts(long j) {
        return (281470698455103L & j) != 0;
    }

    private CollationElementIterator(RuleBasedCollator ruleBasedCollator) {
        this.iter_ = null;
        this.rbc_ = ruleBasedCollator;
        this.otherHalf_ = 0;
        this.dir_ = 0;
        this.offsets_ = null;
    }

    CollationElementIterator(String str, RuleBasedCollator ruleBasedCollator) {
        this(ruleBasedCollator);
        setText(str);
    }

    public int getOffset() {
        if (this.dir_ >= 0 || this.offsets_ == null || this.offsets_.isEmpty()) {
            return this.iter_.getOffset();
        }
        int cEsLength = this.iter_.getCEsLength();
        if (this.otherHalf_ != 0) {
            cEsLength++;
        }
        if ($assertionsDisabled || cEsLength < this.offsets_.size()) {
            return this.offsets_.elementAti(cEsLength);
        }
        throw new AssertionError();
    }

    public int next() {
        if (this.dir_ > 1) {
            if (this.otherHalf_ != 0) {
                int i = this.otherHalf_;
                this.otherHalf_ = 0;
                return i;
            }
        } else if (this.dir_ == 1) {
            this.dir_ = 2;
        } else if (this.dir_ == 0) {
            this.dir_ = 2;
        } else {
            throw new IllegalStateException("Illegal change of direction");
        }
        this.iter_.clearCEsIfNoneRemaining();
        long nextCE = this.iter_.nextCE();
        if (nextCE == 4311744768L) {
            return -1;
        }
        long j = nextCE >>> 32;
        int i2 = (int) nextCE;
        int firstHalf = getFirstHalf(j, i2);
        int secondHalf = getSecondHalf(j, i2);
        if (secondHalf != 0) {
            this.otherHalf_ = secondHalf | 192;
        }
        return firstHalf;
    }

    public void setText(String str) {
        CollationIterator collationIterator;
        this.string_ = str;
        boolean isNumeric = this.rbc_.settings.readOnly().isNumeric();
        if (this.rbc_.settings.readOnly().dontCheckFCD()) {
            collationIterator = new UTF16CollationIterator(this.rbc_.data, isNumeric, this.string_, 0);
        } else {
            collationIterator = new FCDUTF16CollationIterator(this.rbc_.data, isNumeric, this.string_, 0);
        }
        this.iter_ = collationIterator;
        this.otherHalf_ = 0;
        this.dir_ = 0;
    }

    static final class MaxExpSink implements ContractionsAndExpansions.CESink {
        static final /* synthetic */ boolean $assertionsDisabled = (!CollationElementIterator.class.desiredAssertionStatus());
        private Map<Integer, Integer> maxExpansions;

        MaxExpSink(Map<Integer, Integer> map) {
            this.maxExpansions = map;
        }

        @Override // com.ibm.icu.impl.coll.ContractionsAndExpansions.CESink
        public void handleCE(long j) {
        }

        @Override // com.ibm.icu.impl.coll.ContractionsAndExpansions.CESink
        public void handleExpansion(long[] jArr, int i, int i2) {
            int i3;
            if (i2 > 1) {
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    i4 += CollationElementIterator.ceNeedsTwoParts(jArr[i + i5]) ? 2 : 1;
                }
                long j = jArr[(i + i2) - 1];
                long j2 = j >>> 32;
                int i6 = (int) j;
                int secondHalf = CollationElementIterator.getSecondHalf(j2, i6);
                if (secondHalf == 0) {
                    i3 = CollationElementIterator.getFirstHalf(j2, i6);
                    if (!$assertionsDisabled && i3 == 0) {
                        throw new AssertionError();
                    }
                } else {
                    i3 = secondHalf | 192;
                }
                Integer num = this.maxExpansions.get(Integer.valueOf(i3));
                if (num == null || i4 > num.intValue()) {
                    this.maxExpansions.put(Integer.valueOf(i3), Integer.valueOf(i4));
                }
            }
        }
    }

    static final Map<Integer, Integer> computeMaxExpansions(CollationData collationData) {
        HashMap hashMap = new HashMap();
        new ContractionsAndExpansions(null, null, new MaxExpSink(hashMap), true).forData(collationData);
        return hashMap;
    }

    private byte normalizeDir() {
        if (this.dir_ == 1) {
            return 0;
        }
        return this.dir_;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollationElementIterator)) {
            return false;
        }
        CollationElementIterator collationElementIterator = (CollationElementIterator) obj;
        return this.rbc_.equals(collationElementIterator.rbc_) && this.otherHalf_ == collationElementIterator.otherHalf_ && normalizeDir() == collationElementIterator.normalizeDir() && this.string_.equals(collationElementIterator.string_) && this.iter_.equals(collationElementIterator.iter_);
    }

    @Deprecated
    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }
}
