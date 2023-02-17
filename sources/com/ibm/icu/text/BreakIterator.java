package com.ibm.icu.text;

import com.ibm.icu.impl.CacheValue;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.ULocale;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.MissingResourceException;
public abstract class BreakIterator implements Cloneable {
    private static final boolean DEBUG = ICUDebug.enabled("breakiterator");
    private static final CacheValue<?>[] iterCache = new CacheValue[5];
    private static BreakIteratorServiceShim shim;
    private ULocale actualLocale;
    private ULocale validLocale;

    public abstract int first();

    public abstract int following(int i);

    public abstract CharacterIterator getText();

    public abstract int next();

    public abstract int previous();

    public abstract void setText(CharacterIterator characterIterator);

    protected BreakIterator() {
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public int preceding(int i) {
        int following = following(i);
        while (following >= i && following != -1) {
            following = previous();
        }
        return following;
    }

    public void setText(String str) {
        setText(new StringCharacterIterator(str));
    }

    public static BreakIterator getWordInstance(ULocale uLocale) {
        return getBreakInstance(uLocale, 1);
    }

    public static BreakIterator getSentenceInstance(ULocale uLocale) {
        return getBreakInstance(uLocale, 3);
    }

    @Deprecated
    public static BreakIterator getBreakInstance(ULocale uLocale, int i) {
        BreakIteratorCache breakIteratorCache;
        if (uLocale == null) {
            throw new NullPointerException("Specified locale is null");
        } else if (iterCache[i] != null && (breakIteratorCache = (BreakIteratorCache) iterCache[i].get()) != null && breakIteratorCache.getLocale().equals(uLocale)) {
            return breakIteratorCache.createBreakInstance();
        } else {
            BreakIterator createBreakIterator = getShim().createBreakIterator(uLocale, i);
            iterCache[i] = CacheValue.getInstance(new BreakIteratorCache(uLocale, createBreakIterator));
            if (createBreakIterator instanceof RuleBasedBreakIterator) {
                ((RuleBasedBreakIterator) createBreakIterator).setBreakType(i);
            }
            return createBreakIterator;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class BreakIteratorCache {
        private BreakIterator iter;
        private ULocale where;

        BreakIteratorCache(ULocale uLocale, BreakIterator breakIterator) {
            this.where = uLocale;
            this.iter = (BreakIterator) breakIterator.clone();
        }

        /* access modifiers changed from: package-private */
        public ULocale getLocale() {
            return this.where;
        }

        /* access modifiers changed from: package-private */
        public BreakIterator createBreakInstance() {
            return (BreakIterator) this.iter.clone();
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class BreakIteratorServiceShim {
        public abstract BreakIterator createBreakIterator(ULocale uLocale, int i);

        BreakIteratorServiceShim() {
        }
    }

    private static BreakIteratorServiceShim getShim() {
        if (shim == null) {
            try {
                shim = (BreakIteratorServiceShim) Class.forName("com.ibm.icu.text.BreakIteratorFactory").newInstance();
            } catch (MissingResourceException e) {
                throw e;
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                throw new RuntimeException(e2.getMessage());
            }
        }
        return shim;
    }

    /* access modifiers changed from: package-private */
    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            throw new IllegalArgumentException();
        }
        this.validLocale = uLocale;
        this.actualLocale = uLocale2;
    }
}
