package com.ibm.icu.impl;

import com.ibm.icu.text.SymbolTable;
import com.ibm.icu.text.UTF16;
import java.text.ParsePosition;
public class RuleCharacterIterator {
    private char[] buf;
    private int bufPos;
    private boolean isEscaped;
    private ParsePosition pos;
    private SymbolTable sym;
    private String text;

    public RuleCharacterIterator(String str, SymbolTable symbolTable, ParsePosition parsePosition) {
        if (str == null || parsePosition.getIndex() > str.length()) {
            throw new IllegalArgumentException();
        }
        this.text = str;
        this.sym = symbolTable;
        this.pos = parsePosition;
        this.buf = null;
    }

    public boolean atEnd() {
        return this.buf == null && this.pos.getIndex() == this.text.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        if (r4 != 92) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        if ((r7 & 2) == 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0079, code lost:
        r5 = new int[]{0};
        r4 = com.ibm.icu.impl.Utility.unescapeAt(lookahead(), r5);
        jumpahead(r5[0]);
        r6.isEscaped = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0090, code lost:
        if (r4 >= 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
        throw new java.lang.IllegalArgumentException("Invalid escape");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int next(int r7) {
        /*
            r6 = this;
            r4 = -1
            r0 = 0
            r6.isEscaped = r0
        L_0x0004:
            int r4 = r6._current()
            int r0 = com.ibm.icu.text.UTF16.getCharCount(r4)
            r6._advance(r0)
            r0 = 36
            if (r4 != r0) goto L_0x0065
            char[] r0 = r6.buf
            if (r0 != 0) goto L_0x0065
            r0 = r7 & 1
            if (r0 == 0) goto L_0x0065
            com.ibm.icu.text.SymbolTable r0 = r6.sym
            if (r0 == 0) goto L_0x0065
            com.ibm.icu.text.SymbolTable r0 = r6.sym
            java.lang.String r1 = r6.text
            java.text.ParsePosition r2 = r6.pos
            java.lang.String r3 = r6.text
            int r3 = r3.length()
            java.lang.String r5 = r0.parseReference(r1, r2, r3)
            if (r5 != 0) goto L_0x0033
            goto L_0x009a
        L_0x0033:
            r0 = 0
            r6.bufPos = r0
            com.ibm.icu.text.SymbolTable r0 = r6.sym
            char[] r0 = r0.lookup(r5)
            r6.buf = r0
            char[] r0 = r6.buf
            if (r0 != 0) goto L_0x005b
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Undefined variable: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x005b:
            char[] r0 = r6.buf
            int r0 = r0.length
            if (r0 != 0) goto L_0x0004
            r0 = 0
            r6.buf = r0
            goto L_0x0004
        L_0x0065:
            r0 = r7 & 4
            if (r0 == 0) goto L_0x0071
            boolean r0 = com.ibm.icu.impl.PatternProps.isWhiteSpace(r4)
            if (r0 == 0) goto L_0x0071
            goto L_0x0004
        L_0x0071:
            r0 = 92
            if (r4 != r0) goto L_0x009a
            r0 = r7 & 2
            if (r0 == 0) goto L_0x009a
            r5 = 1
            int[] r5 = new int[r5]
            r5 = {x009c: FILL_ARRAY_DATA  , data: [0} // fill-array
            java.lang.String r0 = r6.lookahead()
            int r4 = com.ibm.icu.impl.Utility.unescapeAt(r0, r5)
            r0 = 0
            r0 = r5[r0]
            r6.jumpahead(r0)
            r0 = 1
            r6.isEscaped = r0
            if (r4 >= 0) goto L_0x009a
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Invalid escape"
            r0.<init>(r1)
            throw r0
        L_0x009a:
            return r4
            fill-array 0x009c: FILL_ARRAY_DATA  , data: [0]
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.RuleCharacterIterator.next(int):int");
    }

    public boolean isEscaped() {
        return this.isEscaped;
    }

    public boolean inVariable() {
        return this.buf != null;
    }

    public Object getPos(Object obj) {
        if (obj == null) {
            return new Object[]{this.buf, new int[]{this.pos.getIndex(), this.bufPos}};
        }
        Object[] objArr = (Object[]) obj;
        objArr[0] = this.buf;
        int[] iArr = (int[]) objArr[1];
        iArr[0] = this.pos.getIndex();
        iArr[1] = this.bufPos;
        return obj;
    }

    public void setPos(Object obj) {
        Object[] objArr = (Object[]) obj;
        this.buf = (char[]) objArr[0];
        int[] iArr = (int[]) objArr[1];
        this.pos.setIndex(iArr[0]);
        this.bufPos = iArr[1];
    }

    public void skipIgnored(int i) {
        if ((i & 4) != 0) {
            while (true) {
                int _current = _current();
                if (PatternProps.isWhiteSpace(_current)) {
                    _advance(UTF16.getCharCount(_current));
                } else {
                    return;
                }
            }
        }
    }

    public String lookahead() {
        return this.buf != null ? new String(this.buf, this.bufPos, this.buf.length - this.bufPos) : this.text.substring(this.pos.getIndex());
    }

    public void jumpahead(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (this.buf != null) {
            this.bufPos += i;
            if (this.bufPos > this.buf.length) {
                throw new IllegalArgumentException();
            } else if (this.bufPos == this.buf.length) {
                this.buf = null;
            }
        } else {
            int index = this.pos.getIndex() + i;
            this.pos.setIndex(index);
            if (index > this.text.length()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public String toString() {
        int index = this.pos.getIndex();
        return this.text.substring(0, index) + '|' + this.text.substring(index);
    }

    private int _current() {
        if (this.buf != null) {
            return UTF16.charAt(this.buf, 0, this.buf.length, this.bufPos);
        }
        int index = this.pos.getIndex();
        if (index < this.text.length()) {
            return UTF16.charAt(this.text, index);
        }
        return -1;
    }

    private void _advance(int i) {
        if (this.buf != null) {
            this.bufPos += i;
            if (this.bufPos == this.buf.length) {
                this.buf = null;
                return;
            }
            return;
        }
        this.pos.setIndex(this.pos.getIndex() + i);
        if (this.pos.getIndex() > this.text.length()) {
            this.pos.setIndex(this.text.length());
        }
    }
}
