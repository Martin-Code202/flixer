package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.UResourceBundle;
import java.nio.ByteBuffer;
final class DictionaryData {
    public static DictionaryMatcher loadDictionaryFor(String str) {
        ByteBuffer requiredData = ICUBinary.getRequiredData("brkitr/" + ((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/brkitr")).getStringWithFallback("dictionaries/" + str));
        ICUBinary.readHeader(requiredData, 1147757428, null);
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = requiredData.getInt();
        }
        int i2 = iArr[0];
        Assert.assrt(i2 >= 32);
        if (i2 > 32) {
            ICUBinary.skipBytes(requiredData, i2 - 32);
        }
        int i3 = iArr[4] & 7;
        int i4 = iArr[3] - i2;
        if (i3 == 0) {
            int i5 = iArr[5];
            byte[] bArr = new byte[i4];
            requiredData.get(bArr);
            return new BytesDictionaryMatcher(bArr, i5);
        } else if (i3 != 1) {
            return null;
        } else {
            Assert.assrt(i4 % 2 == 0);
            return new CharsDictionaryMatcher(ICUBinary.getString(requiredData, i4 / 2, i4 & 1));
        }
    }
}
