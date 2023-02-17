package com.ibm.icu.text;

import com.ibm.icu.impl.SimpleFilteredSentenceBreakIterator;
import com.ibm.icu.util.ULocale;
@Deprecated
public abstract class FilteredBreakIteratorBuilder {
    @Deprecated
    public abstract BreakIterator build(BreakIterator breakIterator);

    @Deprecated
    public static FilteredBreakIteratorBuilder createInstance(ULocale uLocale) {
        return new SimpleFilteredSentenceBreakIterator.Builder(uLocale);
    }

    @Deprecated
    protected FilteredBreakIteratorBuilder() {
    }
}
