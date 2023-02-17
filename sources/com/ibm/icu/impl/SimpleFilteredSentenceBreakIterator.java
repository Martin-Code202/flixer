package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.FilteredBreakIteratorBuilder;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.CharsTrieBuilder;
import com.ibm.icu.util.StringTrieBuilder;
import com.ibm.icu.util.ULocale;
import java.text.CharacterIterator;
import java.util.HashSet;
import java.util.Iterator;
public class SimpleFilteredSentenceBreakIterator extends BreakIterator {
    private CharsTrie backwardsTrie;
    private BreakIterator delegate;
    private CharsTrie forwardsPartialTrie;
    private UCharacterIterator text;

    public SimpleFilteredSentenceBreakIterator(BreakIterator breakIterator, CharsTrie charsTrie, CharsTrie charsTrie2) {
        this.delegate = breakIterator;
        this.forwardsPartialTrie = charsTrie;
        this.backwardsTrie = charsTrie2;
    }

    private final void resetState() {
        this.text = UCharacterIterator.getInstance((CharacterIterator) this.delegate.getText().clone());
    }

    private final boolean breakExceptionAt(int i) {
        int i2 = -1;
        int i3 = -1;
        this.text.setIndex(i);
        this.backwardsTrie.reset();
        if (this.text.previousCodePoint() != 32) {
            this.text.nextCodePoint();
        }
        BytesTrie.Result result = BytesTrie.Result.INTERMEDIATE_VALUE;
        while (true) {
            int previousCodePoint = this.text.previousCodePoint();
            if (previousCodePoint == -1) {
                break;
            }
            result = this.backwardsTrie.nextForCodePoint(previousCodePoint);
            if (!result.hasNext()) {
                break;
            } else if (result.hasValue()) {
                i2 = this.text.getIndex();
                i3 = this.backwardsTrie.getValue();
            }
        }
        if (result.matches()) {
            i3 = this.backwardsTrie.getValue();
            i2 = this.text.getIndex();
        }
        if (i2 < 0) {
            return false;
        }
        if (i3 == 2) {
            return true;
        }
        if (i3 != 1 || this.forwardsPartialTrie == null) {
            return false;
        }
        this.forwardsPartialTrie.reset();
        BytesTrie.Result result2 = BytesTrie.Result.INTERMEDIATE_VALUE;
        this.text.setIndex(i2);
        do {
            int nextCodePoint = this.text.nextCodePoint();
            if (nextCodePoint == -1) {
                break;
            }
            result2 = this.forwardsPartialTrie.nextForCodePoint(nextCodePoint);
        } while (result2.hasNext());
        if (result2.matches()) {
            return true;
        }
        return false;
    }

    private final int internalNext(int i) {
        if (i == -1 || this.backwardsTrie == null) {
            return i;
        }
        resetState();
        int length = this.text.getLength();
        while (i != -1 && i != length && breakExceptionAt(i)) {
            i = this.delegate.next();
        }
        return i;
    }

    private final int internalPrev(int i) {
        if (i == 0 || i == -1 || this.backwardsTrie == null) {
            return i;
        }
        resetState();
        while (i != -1 && i != 0 && breakExceptionAt(i)) {
            i = this.delegate.previous();
        }
        return i;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SimpleFilteredSentenceBreakIterator simpleFilteredSentenceBreakIterator = (SimpleFilteredSentenceBreakIterator) obj;
        return this.delegate.equals(simpleFilteredSentenceBreakIterator.delegate) && this.text.equals(simpleFilteredSentenceBreakIterator.text) && this.backwardsTrie.equals(simpleFilteredSentenceBreakIterator.backwardsTrie) && this.forwardsPartialTrie.equals(simpleFilteredSentenceBreakIterator.forwardsPartialTrie);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.forwardsPartialTrie.hashCode() * 39) + (this.backwardsTrie.hashCode() * 11) + this.delegate.hashCode();
    }

    @Override // com.ibm.icu.text.BreakIterator, java.lang.Object
    public Object clone() {
        return (SimpleFilteredSentenceBreakIterator) super.clone();
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int first() {
        return this.delegate.first();
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int preceding(int i) {
        return internalPrev(this.delegate.preceding(i));
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int previous() {
        return internalPrev(this.delegate.previous());
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int next() {
        return internalNext(this.delegate.next());
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int following(int i) {
        return internalNext(this.delegate.following(i));
    }

    @Override // com.ibm.icu.text.BreakIterator
    public CharacterIterator getText() {
        return this.delegate.getText();
    }

    @Override // com.ibm.icu.text.BreakIterator
    public void setText(CharacterIterator characterIterator) {
        this.delegate.setText(characterIterator);
    }

    public static class Builder extends FilteredBreakIteratorBuilder {
        private HashSet<String> filterSet;

        public Builder(ULocale uLocale) {
            this.filterSet = new HashSet<>();
            ICUResourceBundle findWithFallback = ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/brkitr", uLocale, ICUResourceBundle.OpenType.LOCALE_ROOT).findWithFallback("exceptions/SentenceBreak");
            if (findWithFallback != null) {
                int size = findWithFallback.getSize();
                for (int i = 0; i < size; i++) {
                    this.filterSet.add(((ICUResourceBundle) findWithFallback.get(i)).getString());
                }
            }
        }

        public Builder() {
            this.filterSet = new HashSet<>();
            this.filterSet = new HashSet<>();
        }

        @Override // com.ibm.icu.text.FilteredBreakIteratorBuilder
        public BreakIterator build(BreakIterator breakIterator) {
            if (this.filterSet.isEmpty()) {
                return breakIterator;
            }
            CharsTrieBuilder charsTrieBuilder = new CharsTrieBuilder();
            CharsTrieBuilder charsTrieBuilder2 = new CharsTrieBuilder();
            int i = 0;
            int i2 = 0;
            int size = this.filterSet.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            CharsTrie charsTrie = null;
            CharsTrie charsTrie2 = null;
            int i3 = 0;
            Iterator<String> it = this.filterSet.iterator();
            while (it.hasNext()) {
                strArr[i3] = it.next();
                iArr[i3] = 0;
                i3++;
            }
            for (int i4 = 0; i4 < size; i4++) {
                int indexOf = strArr[i4].indexOf(46);
                if (indexOf > -1 && indexOf + 1 != strArr[i4].length()) {
                    int i5 = -1;
                    for (int i6 = 0; i6 < size; i6++) {
                        if (i6 != i4 && strArr[i4].regionMatches(0, strArr[i6], 0, indexOf + 1)) {
                            if (iArr[i6] == 0) {
                                iArr[i6] = 3;
                            } else if ((iArr[i6] & 1) != 0) {
                                i5 = i6;
                            }
                        }
                    }
                    if (i5 == -1 && iArr[i4] == 0) {
                        StringBuilder sb = new StringBuilder(strArr[i4].substring(0, indexOf + 1));
                        sb.reverse();
                        charsTrieBuilder.add(sb, 1);
                        i++;
                        iArr[i4] = 3;
                    }
                }
            }
            for (int i7 = 0; i7 < size; i7++) {
                if (iArr[i7] == 0) {
                    charsTrieBuilder.add(new StringBuilder(strArr[i7]).reverse(), 2);
                    i++;
                } else {
                    charsTrieBuilder2.add(strArr[i7], 2);
                    i2++;
                }
            }
            if (i > 0) {
                charsTrie = charsTrieBuilder.build(StringTrieBuilder.Option.FAST);
            }
            if (i2 > 0) {
                charsTrie2 = charsTrieBuilder2.build(StringTrieBuilder.Option.FAST);
            }
            return new SimpleFilteredSentenceBreakIterator(breakIterator, charsTrie2, charsTrie);
        }
    }
}
