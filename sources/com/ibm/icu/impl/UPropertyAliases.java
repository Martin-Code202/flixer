package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.util.BytesTrie;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.MissingResourceException;
public final class UPropertyAliases {
    public static final UPropertyAliases INSTANCE;
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable();
    private byte[] bytesTries;
    private String nameGroups;
    private int[] valueMaps;

    /* access modifiers changed from: package-private */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 2;
        }
    }

    static {
        try {
            INSTANCE = new UPropertyAliases();
        } catch (IOException e) {
            MissingResourceException missingResourceException = new MissingResourceException("Could not construct UPropertyAliases. Missing pnames.icu", "", "");
            missingResourceException.initCause(e);
            throw missingResourceException;
        }
    }

    private void load(ByteBuffer byteBuffer) {
        ICUBinary.readHeader(byteBuffer, 1886282093, IS_ACCEPTABLE);
        int i = byteBuffer.getInt() / 4;
        if (i < 8) {
            throw new IOException("pnames.icu: not enough indexes");
        }
        int[] iArr = new int[i];
        iArr[0] = i * 4;
        for (int i2 = 1; i2 < i; i2++) {
            iArr[i2] = byteBuffer.getInt();
        }
        int i3 = iArr[0];
        int i4 = iArr[1];
        this.valueMaps = ICUBinary.getInts(byteBuffer, (i4 - i3) / 4, 0);
        int i5 = iArr[2];
        this.bytesTries = new byte[(i5 - i4)];
        byteBuffer.get(this.bytesTries);
        int i6 = iArr[3] - i5;
        StringBuilder sb = new StringBuilder(i6);
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append((char) byteBuffer.get());
        }
        this.nameGroups = sb.toString();
    }

    private UPropertyAliases() {
        load(ICUBinary.getRequiredData("pnames.icu"));
    }

    private int findProperty(int i) {
        int i2 = 1;
        for (int i3 = this.valueMaps[0]; i3 > 0; i3--) {
            int i4 = this.valueMaps[i2];
            int i5 = this.valueMaps[i2 + 1];
            int i6 = i2 + 2;
            if (i < i4) {
                return 0;
            }
            if (i < i5) {
                return ((i - i4) * 2) + i6;
            }
            i2 = i6 + ((i5 - i4) * 2);
        }
        return 0;
    }

    private static int asciiToLowercase(int i) {
        return (65 > i || i > 90) ? i : i + 32;
    }

    private boolean containsName(BytesTrie bytesTrie, CharSequence charSequence) {
        BytesTrie.Result result = BytesTrie.Result.NO_VALUE;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!(charAt == '-' || charAt == '_' || charAt == ' ' || ('\t' <= charAt && charAt <= '\r'))) {
                if (!result.hasNext()) {
                    return false;
                }
                result = bytesTrie.next(asciiToLowercase(charAt));
            }
        }
        return result.hasValue();
    }

    private int getPropertyOrValueEnum(int i, CharSequence charSequence) {
        BytesTrie bytesTrie = new BytesTrie(this.bytesTries, i);
        if (containsName(bytesTrie, charSequence)) {
            return bytesTrie.getValue();
        }
        return -1;
    }

    public int getPropertyEnum(CharSequence charSequence) {
        return getPropertyOrValueEnum(0, charSequence);
    }

    public int getPropertyValueEnum(int i, CharSequence charSequence) {
        int findProperty = findProperty(i);
        if (findProperty == 0) {
            throw new IllegalArgumentException("Invalid property enum " + i + " (0x" + Integer.toHexString(i) + ")");
        }
        int i2 = this.valueMaps[findProperty + 1];
        if (i2 != 0) {
            return getPropertyOrValueEnum(this.valueMaps[i2], charSequence);
        }
        throw new IllegalArgumentException("Property " + i + " (0x" + Integer.toHexString(i) + ") does not have named values");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int compare(java.lang.String r9, java.lang.String r10) {
        /*
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
        L_0x0004:
            int r0 = r9.length()
            if (r2 >= r0) goto L_0x0015
            char r5 = r9.charAt(r2)
            switch(r5) {
                case 9: goto L_0x0012;
                case 10: goto L_0x0012;
                case 11: goto L_0x0012;
                case 12: goto L_0x0012;
                case 13: goto L_0x0012;
                case 32: goto L_0x0012;
                case 45: goto L_0x0012;
                case 95: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0015
        L_0x0012:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0015:
            int r0 = r10.length()
            if (r3 >= r0) goto L_0x0026
            char r6 = r10.charAt(r3)
            switch(r6) {
                case 9: goto L_0x0023;
                case 10: goto L_0x0023;
                case 11: goto L_0x0023;
                case 12: goto L_0x0023;
                case 13: goto L_0x0023;
                case 32: goto L_0x0023;
                case 45: goto L_0x0023;
                case 95: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0026
        L_0x0023:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0026:
            int r0 = r9.length()
            if (r2 != r0) goto L_0x002e
            r7 = 1
            goto L_0x002f
        L_0x002e:
            r7 = 0
        L_0x002f:
            int r0 = r10.length()
            if (r3 != r0) goto L_0x0037
            r8 = 1
            goto L_0x0038
        L_0x0037:
            r8 = 0
        L_0x0038:
            if (r7 == 0) goto L_0x0040
            if (r8 == 0) goto L_0x003e
            r0 = 0
            return r0
        L_0x003e:
            r5 = 0
            goto L_0x0043
        L_0x0040:
            if (r8 == 0) goto L_0x0043
            r6 = 0
        L_0x0043:
            int r0 = asciiToLowercase(r5)
            int r1 = asciiToLowercase(r6)
            int r4 = r0 - r1
            if (r4 == 0) goto L_0x0050
            return r4
        L_0x0050:
            int r2 = r2 + 1
            int r3 = r3 + 1
            goto L_0x0004
            switch-data {9->0x0012, 10->0x0012, 11->0x0012, 12->0x0012, 13->0x0012, 32->0x0012, 45->0x0012, 95->0x0012, }
            switch-data {9->0x0023, 10->0x0023, 11->0x0023, 12->0x0023, 13->0x0023, 32->0x0023, 45->0x0023, 95->0x0023, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.UPropertyAliases.compare(java.lang.String, java.lang.String):int");
    }
}
