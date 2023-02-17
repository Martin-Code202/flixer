package com.ibm.icu.impl;
public final class UResource {

    public interface Array {
        int getSize();

        boolean getValue(int i, Value value);
    }

    public static abstract class Sink {
        public abstract void put(Key key, Value value, boolean z);
    }

    public interface Table {
        boolean getKeyAndValue(int i, Key key, Value value);
    }

    public static final class Key implements CharSequence, Cloneable, Comparable<Key> {
        static final /* synthetic */ boolean $assertionsDisabled = (!UResource.class.desiredAssertionStatus());
        private byte[] bytes;
        private int length;
        private int offset;
        private String s;

        public Key() {
            this.s = "";
        }

        private Key(byte[] bArr, int i, int i2) {
            this.bytes = bArr;
            this.offset = i;
            this.length = i2;
        }

        public Key setBytes(byte[] bArr, int i) {
            this.bytes = bArr;
            this.offset = i;
            this.length = 0;
            while (bArr[this.length + i] != 0) {
                this.length++;
            }
            this.s = null;
            return this;
        }

        public Key setToEmpty() {
            this.bytes = null;
            this.length = 0;
            this.offset = 0;
            this.s = "";
            return this;
        }

        public Key setString(String str) {
            if (str.isEmpty()) {
                setToEmpty();
            } else {
                this.bytes = new byte[str.length()];
                this.offset = 0;
                this.length = str.length();
                for (int i = 0; i < this.length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= 127) {
                        this.bytes[i] = (byte) charAt;
                    } else {
                        throw new IllegalArgumentException('\"' + str + "\" is not an ASCII string");
                    }
                }
                this.s = str;
            }
            return this;
        }

        @Override // java.lang.Object
        public Key clone() {
            try {
                return (Key) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            if ($assertionsDisabled || (0 <= i && i < this.length)) {
                return (char) this.bytes[this.offset + i];
            }
            throw new AssertionError();
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.length;
        }

        @Override // java.lang.CharSequence
        public Key subSequence(int i, int i2) {
            if (!$assertionsDisabled && (0 > i || i >= this.length)) {
                throw new AssertionError();
            } else if ($assertionsDisabled || (i <= i2 && i2 <= this.length)) {
                return new Key(this.bytes, this.offset + i, i2 - i);
            } else {
                throw new AssertionError();
            }
        }

        @Override // java.lang.CharSequence, java.lang.Object
        public String toString() {
            if (this.s == null) {
                this.s = internalSubString(0, this.length);
            }
            return this.s;
        }

        private String internalSubString(int i, int i2) {
            StringBuilder sb = new StringBuilder(i2 - i);
            for (int i3 = i; i3 < i2; i3++) {
                sb.append((char) this.bytes[this.offset + i3]);
            }
            return sb.toString();
        }

        private boolean regionMatches(byte[] bArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.bytes[this.offset + i3] != bArr[i + i3]) {
                    return false;
                }
            }
            return true;
        }

        private boolean regionMatches(int i, CharSequence charSequence, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.bytes[this.offset + i + i3] != charSequence.charAt(i3)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.length == key.length && regionMatches(key.bytes, key.offset, this.length);
        }

        public boolean contentEquals(CharSequence charSequence) {
            if (charSequence == null) {
                return false;
            }
            return this == charSequence || (charSequence.length() == this.length && regionMatches(0, charSequence, this.length));
        }

        public boolean startsWith(CharSequence charSequence) {
            int length2 = charSequence.length();
            return length2 <= this.length && regionMatches(0, charSequence, length2);
        }

        public boolean endsWith(CharSequence charSequence) {
            int length2 = charSequence.length();
            return length2 <= this.length && regionMatches(this.length - length2, charSequence, length2);
        }

        public boolean regionMatches(int i, CharSequence charSequence) {
            int length2 = charSequence.length();
            return length2 == this.length - i && regionMatches(i, charSequence, length2);
        }

        @Override // java.lang.Object
        public int hashCode() {
            if (this.length == 0) {
                return 0;
            }
            int i = 1;
            byte b = this.bytes[this.offset];
            while (i < this.length) {
                i++;
                b = (b * 37) + this.bytes[this.offset];
            }
            return b == 1 ? 1 : 0;
        }

        public int compareTo(Key key) {
            return compareTo((CharSequence) key);
        }

        public int compareTo(CharSequence charSequence) {
            int length2 = charSequence.length();
            int i = this.length <= length2 ? this.length : length2;
            for (int i2 = 0; i2 < i; i2++) {
                int charAt = charAt(i2) - charSequence.charAt(i2);
                if (charAt != 0) {
                    return charAt;
                }
            }
            return this.length - length2;
        }
    }

    public static abstract class Value {
        public abstract String getAliasString();

        public abstract Array getArray();

        public abstract int getInt();

        public abstract int[] getIntVector();

        public abstract String getString();

        public abstract String[] getStringArray();

        public abstract Table getTable();

        public abstract int getType();

        public abstract boolean isNoInheritanceMarker();

        protected Value() {
        }

        public String toString() {
            switch (getType()) {
                case 0:
                    return getString();
                case 1:
                    return "(binary blob)";
                case 2:
                    return "(table)";
                case 3:
                case 4:
                case 5:
                case 6:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                default:
                    return "???";
                case 7:
                    return Integer.toString(getInt());
                case 8:
                    return "(array)";
                case 14:
                    int[] intVector = getIntVector();
                    StringBuilder sb = new StringBuilder("[");
                    sb.append(intVector.length).append("]{");
                    if (intVector.length != 0) {
                        sb.append(intVector[0]);
                        for (int i = 1; i < intVector.length; i++) {
                            sb.append(", ").append(intVector[i]);
                        }
                    }
                    return sb.append('}').toString();
            }
        }
    }
}
