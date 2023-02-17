package com.ibm.icu.text;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.util.Freezable;
import java.util.Arrays;
@Deprecated
public final class PluralRanges implements Freezable<PluralRanges>, Comparable<PluralRanges> {
    private boolean[] explicit = new boolean[StandardPlural.COUNT];
    private volatile boolean isFrozen;
    private Matrix matrix = new Matrix();

    /* access modifiers changed from: package-private */
    public static final class Matrix implements Comparable<Matrix>, Cloneable {
        private byte[] data = new byte[(StandardPlural.COUNT * StandardPlural.COUNT)];

        Matrix() {
            for (int i = 0; i < this.data.length; i++) {
                this.data[i] = -1;
            }
        }

        /* access modifiers changed from: package-private */
        public void setIfNew(StandardPlural standardPlural, StandardPlural standardPlural2, StandardPlural standardPlural3) {
            byte b;
            byte b2 = this.data[(standardPlural.ordinal() * StandardPlural.COUNT) + standardPlural2.ordinal()];
            if (b2 >= 0) {
                throw new IllegalArgumentException("Previously set value for <" + standardPlural + ", " + standardPlural2 + ", " + StandardPlural.VALUES.get(b2) + ">");
            }
            byte[] bArr = this.data;
            int ordinal = (standardPlural.ordinal() * StandardPlural.COUNT) + standardPlural2.ordinal();
            if (standardPlural3 == null) {
                b = -1;
            } else {
                b = (byte) standardPlural3.ordinal();
            }
            bArr[ordinal] = b;
        }

        /* access modifiers changed from: package-private */
        public StandardPlural get(StandardPlural standardPlural, StandardPlural standardPlural2) {
            byte b = this.data[(standardPlural.ordinal() * StandardPlural.COUNT) + standardPlural2.ordinal()];
            if (b < 0) {
                return null;
            }
            return StandardPlural.VALUES.get(b);
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = 0;
            for (int i2 = 0; i2 < this.data.length; i2++) {
                i = (i * 37) + this.data[i2];
            }
            return i;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            return (obj instanceof Matrix) && 0 == compareTo((Matrix) obj);
        }

        public int compareTo(Matrix matrix) {
            for (int i = 0; i < this.data.length; i++) {
                int i2 = this.data[i] - matrix.data[i];
                if (i2 != 0) {
                    return i2;
                }
            }
            return 0;
        }

        @Override // java.lang.Object
        public Matrix clone() {
            Matrix matrix = new Matrix();
            matrix.data = (byte[]) this.data.clone();
            return matrix;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder();
            StandardPlural[] values = StandardPlural.values();
            for (StandardPlural standardPlural : values) {
                StandardPlural[] values2 = StandardPlural.values();
                for (StandardPlural standardPlural2 : values2) {
                    StandardPlural standardPlural3 = get(standardPlural, standardPlural2);
                    if (standardPlural3 != null) {
                        sb.append(standardPlural + " & " + standardPlural2 + " → " + standardPlural3 + ";\n");
                    }
                }
            }
            return sb.toString();
        }
    }

    @Deprecated
    public void add(StandardPlural standardPlural, StandardPlural standardPlural2, StandardPlural standardPlural3) {
        if (this.isFrozen) {
            throw new UnsupportedOperationException();
        }
        this.explicit[standardPlural3.ordinal()] = true;
        if (standardPlural == null) {
            StandardPlural[] values = StandardPlural.values();
            for (StandardPlural standardPlural4 : values) {
                if (standardPlural2 == null) {
                    for (StandardPlural standardPlural5 : StandardPlural.values()) {
                        this.matrix.setIfNew(standardPlural4, standardPlural5, standardPlural3);
                    }
                } else {
                    this.explicit[standardPlural2.ordinal()] = true;
                    this.matrix.setIfNew(standardPlural4, standardPlural2, standardPlural3);
                }
            }
        } else if (standardPlural2 == null) {
            this.explicit[standardPlural.ordinal()] = true;
            for (StandardPlural standardPlural6 : StandardPlural.values()) {
                this.matrix.setIfNew(standardPlural, standardPlural6, standardPlural3);
            }
        } else {
            this.explicit[standardPlural.ordinal()] = true;
            this.explicit[standardPlural2.ordinal()] = true;
            this.matrix.setIfNew(standardPlural, standardPlural2, standardPlural3);
        }
    }

    @Override // java.lang.Object
    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluralRanges)) {
            return false;
        }
        PluralRanges pluralRanges = (PluralRanges) obj;
        return this.matrix.equals(pluralRanges.matrix) && Arrays.equals(this.explicit, pluralRanges.explicit);
    }

    @Override // java.lang.Object
    @Deprecated
    public int hashCode() {
        return this.matrix.hashCode();
    }

    @Deprecated
    public int compareTo(PluralRanges pluralRanges) {
        return this.matrix.compareTo(pluralRanges.matrix);
    }

    @Deprecated
    public PluralRanges freeze() {
        this.isFrozen = true;
        return this;
    }

    @Override // java.lang.Object
    @Deprecated
    public String toString() {
        return this.matrix.toString();
    }
}
