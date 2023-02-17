package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.text.MessagePattern;
import java.io.ObjectInputStream;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
public class SelectFormat extends Format {
    static final /* synthetic */ boolean $assertionsDisabled = (!SelectFormat.class.desiredAssertionStatus());
    private static final long serialVersionUID = 2993154333257524984L;
    private transient MessagePattern msgPattern;
    private String pattern;

    private void reset() {
        this.pattern = null;
        if (this.msgPattern != null) {
            this.msgPattern.clear();
        }
    }

    public void applyPattern(String str) {
        this.pattern = str;
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        try {
            this.msgPattern.parseSelectStyle(str);
        } catch (RuntimeException e) {
            reset();
            throw e;
        }
    }

    static int findSubMessage(MessagePattern messagePattern, int i, String str) {
        int countParts = messagePattern.countParts();
        int i2 = 0;
        do {
            int i3 = i + 1;
            MessagePattern.Part part = messagePattern.getPart(i);
            MessagePattern.Part.Type type = part.getType();
            if (type == MessagePattern.Part.Type.ARG_LIMIT) {
                break;
            } else if (!$assertionsDisabled && type != MessagePattern.Part.Type.ARG_SELECTOR) {
                throw new AssertionError();
            } else if (messagePattern.partSubstringMatches(part, str)) {
                return i3;
            } else {
                if (i2 == 0 && messagePattern.partSubstringMatches(part, "other")) {
                    i2 = i3;
                }
                i = messagePattern.getLimitPartIndex(i3) + 1;
            }
        } while (i < countParts);
        return i2;
    }

    public final String format(String str) {
        int index;
        if (!PatternProps.isIdentifier(str)) {
            throw new IllegalArgumentException("Invalid formatting argument.");
        } else if (this.msgPattern == null || this.msgPattern.countParts() == 0) {
            throw new IllegalStateException("Invalid format error.");
        } else {
            int findSubMessage = findSubMessage(this.msgPattern, 0, str);
            if (!this.msgPattern.jdkAposMode()) {
                return this.msgPattern.getPatternString().substring(this.msgPattern.getPart(findSubMessage).getLimit(), this.msgPattern.getPatternIndex(this.msgPattern.getLimitPartIndex(findSubMessage)));
            }
            StringBuilder sb = null;
            int limit = this.msgPattern.getPart(findSubMessage).getLimit();
            int i = findSubMessage;
            while (true) {
                i++;
                MessagePattern.Part part = this.msgPattern.getPart(i);
                MessagePattern.Part.Type type = part.getType();
                index = part.getIndex();
                if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                    break;
                } else if (type == MessagePattern.Part.Type.SKIP_SYNTAX) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append((CharSequence) this.pattern, limit, index);
                    limit = part.getLimit();
                } else if (type == MessagePattern.Part.Type.ARG_START) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append((CharSequence) this.pattern, limit, index);
                    i = this.msgPattern.getLimitPartIndex(i);
                    int limit2 = this.msgPattern.getPart(i).getLimit();
                    MessagePattern.appendReducedApostrophes(this.pattern, index, limit2, sb);
                    limit = limit2;
                }
            }
            if (sb == null) {
                return this.pattern.substring(limit, index);
            }
            return sb.append((CharSequence) this.pattern, limit, index).toString();
        }
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof String) {
            stringBuffer.append(format((String) obj));
            return stringBuffer;
        }
        throw new IllegalArgumentException("'" + obj + "' is not a String");
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SelectFormat selectFormat = (SelectFormat) obj;
        if (this.msgPattern == null) {
            return selectFormat.msgPattern == null;
        }
        return this.msgPattern.equals(selectFormat.msgPattern);
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.pattern != null) {
            return this.pattern.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "pattern='" + this.pattern + "'";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.pattern != null) {
            applyPattern(this.pattern);
        }
    }
}
