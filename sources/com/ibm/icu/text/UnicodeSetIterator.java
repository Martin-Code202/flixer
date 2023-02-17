package com.ibm.icu.text;

import java.util.Iterator;
public class UnicodeSetIterator {
    public static int IS_STRING = -1;
    public int codepoint;
    public int codepointEnd;
    @Deprecated
    protected int endElement;
    private int endRange = 0;
    @Deprecated
    protected int nextElement;
    private int range = 0;
    private UnicodeSet set;
    public String string;
    private Iterator<String> stringIterator = null;

    public UnicodeSetIterator(UnicodeSet unicodeSet) {
        reset(unicodeSet);
    }

    public UnicodeSetIterator() {
        reset(new UnicodeSet());
    }

    public boolean next() {
        if (this.nextElement <= this.endElement) {
            int i = this.nextElement;
            this.nextElement = i + 1;
            this.codepointEnd = i;
            this.codepoint = i;
            return true;
        } else if (this.range < this.endRange) {
            int i2 = this.range + 1;
            this.range = i2;
            loadRange(i2);
            int i3 = this.nextElement;
            this.nextElement = i3 + 1;
            this.codepointEnd = i3;
            this.codepoint = i3;
            return true;
        } else if (this.stringIterator == null) {
            return false;
        } else {
            this.codepoint = IS_STRING;
            this.string = this.stringIterator.next();
            if (this.stringIterator.hasNext()) {
                return true;
            }
            this.stringIterator = null;
            return true;
        }
    }

    public void reset(UnicodeSet unicodeSet) {
        this.set = unicodeSet;
        reset();
    }

    public void reset() {
        this.endRange = this.set.getRangeCount() - 1;
        this.range = 0;
        this.endElement = -1;
        this.nextElement = 0;
        if (this.endRange >= 0) {
            loadRange(this.range);
        }
        this.stringIterator = null;
        if (this.set.strings != null) {
            this.stringIterator = this.set.strings.iterator();
            if (!this.stringIterator.hasNext()) {
                this.stringIterator = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void loadRange(int i) {
        this.nextElement = this.set.getRangeStart(i);
        this.endElement = this.set.getRangeEnd(i);
    }
}
