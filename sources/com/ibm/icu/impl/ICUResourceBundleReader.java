package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.ICUException;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceTypeMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
public final class ICUResourceBundleReader {
    static final /* synthetic */ boolean $assertionsDisabled = (!ICUResourceBundleReader.class.desiredAssertionStatus());
    private static ReaderCache CACHE = new ReaderCache();
    private static final CharBuffer EMPTY_16_BIT_UNITS = CharBuffer.wrap("\u0000");
    private static final Array EMPTY_ARRAY = new Array();
    private static final Table EMPTY_TABLE = new Table();
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable();
    private static final ICUResourceBundleReader NULL_READER = new ICUResourceBundleReader();
    private static int[] PUBLIC_TYPES = {0, 1, 2, 3, 2, 2, 0, 7, 8, 8, -1, -1, -1, -1, 14, -1};
    private static final ByteBuffer emptyByteBuffer = ByteBuffer.allocate(0).asReadOnlyBuffer();
    private static final byte[] emptyBytes = new byte[0];
    private static final char[] emptyChars = new char[0];
    private static final int[] emptyInts = new int[0];
    private CharBuffer b16BitUnits;
    private ByteBuffer bytes;
    private int dataVersion;
    private boolean isPoolBundle;
    private byte[] keyBytes;
    private int localKeyLimit;
    private boolean noFallback;
    private ICUResourceBundleReader poolBundleReader;
    private int poolCheckSum;
    private int poolStringIndex16Limit;
    private int poolStringIndexLimit;
    private ResourceCache resourceCache;
    private int rootRes;
    private boolean usesPoolBundle;

    /* access modifiers changed from: package-private */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return (bArr[0] == 1 && (bArr[1] & 255) >= 1) || (2 <= bArr[0] && bArr[0] <= 3);
        }
    }

    /* access modifiers changed from: package-private */
    public static class ReaderCacheKey {
        final String baseName;
        final String localeID;

        ReaderCacheKey(String str, String str2) {
            this.baseName = str == null ? "" : str;
            this.localeID = str2 == null ? "" : str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReaderCacheKey)) {
                return false;
            }
            ReaderCacheKey readerCacheKey = (ReaderCacheKey) obj;
            return this.baseName.equals(readerCacheKey.baseName) && this.localeID.equals(readerCacheKey.localeID);
        }

        public int hashCode() {
            return this.baseName.hashCode() ^ this.localeID.hashCode();
        }
    }

    /* access modifiers changed from: package-private */
    public static class ReaderCache extends SoftCache<ReaderCacheKey, ICUResourceBundleReader, ClassLoader> {
        private ReaderCache() {
        }

        /* access modifiers changed from: protected */
        public ICUResourceBundleReader createInstance(ReaderCacheKey readerCacheKey, ClassLoader classLoader) {
            ByteBuffer byteBuffer;
            String fullName = ICUResourceBundleReader.getFullName(readerCacheKey.baseName, readerCacheKey.localeID);
            try {
                if (readerCacheKey.baseName == null || !readerCacheKey.baseName.startsWith("com/ibm/icu/impl/data/icudt59b")) {
                    InputStream stream = ICUData.getStream(classLoader, fullName);
                    if (stream == null) {
                        return ICUResourceBundleReader.NULL_READER;
                    }
                    byteBuffer = ICUBinary.getByteBufferFromInputStreamAndCloseStream(stream);
                } else {
                    byteBuffer = ICUBinary.getData(classLoader, fullName, fullName.substring("com/ibm/icu/impl/data/icudt59b".length() + 1));
                    if (byteBuffer == null) {
                        return ICUResourceBundleReader.NULL_READER;
                    }
                }
                return new ICUResourceBundleReader(byteBuffer, readerCacheKey.baseName, readerCacheKey.localeID, classLoader);
            } catch (IOException e) {
                throw new ICUUncheckedIOException("Data file " + fullName + " is corrupt - " + e.getMessage(), e);
            }
        }
    }

    private ICUResourceBundleReader() {
    }

    private ICUResourceBundleReader(ByteBuffer byteBuffer, String str, String str2, ClassLoader classLoader) {
        init(byteBuffer);
        if (this.usesPoolBundle) {
            this.poolBundleReader = getReader(str, "pool", classLoader);
            if (this.poolBundleReader == null || !this.poolBundleReader.isPoolBundle) {
                throw new IllegalStateException("pool.res is not a pool bundle");
            } else if (this.poolBundleReader.poolCheckSum != this.poolCheckSum) {
                throw new IllegalStateException("pool.res has a different checksum than this bundle");
            }
        }
    }

    static ICUResourceBundleReader getReader(String str, String str2, ClassLoader classLoader) {
        ICUResourceBundleReader iCUResourceBundleReader = (ICUResourceBundleReader) CACHE.getInstance(new ReaderCacheKey(str, str2), classLoader);
        if (iCUResourceBundleReader == NULL_READER) {
            return null;
        }
        return iCUResourceBundleReader;
    }

    private void init(ByteBuffer byteBuffer) {
        this.dataVersion = ICUBinary.readHeader(byteBuffer, 1382380354, IS_ACCEPTABLE);
        byte b = byteBuffer.get(16);
        this.bytes = ICUBinary.sliceWithOrder(byteBuffer);
        int remaining = this.bytes.remaining();
        this.rootRes = this.bytes.getInt(0);
        int indexesInt = getIndexesInt(0);
        int i = indexesInt & 255;
        if (i <= 4) {
            throw new ICUException("not enough indexes");
        }
        if (remaining >= ((i + 1) << 2)) {
            int indexesInt2 = getIndexesInt(3);
            if (remaining >= (indexesInt2 << 2)) {
                int i2 = indexesInt2 - 1;
                if (b >= 3) {
                    this.poolStringIndexLimit = indexesInt >>> 8;
                }
                if (i > 5) {
                    int indexesInt3 = getIndexesInt(5);
                    this.noFallback = (indexesInt3 & 1) != 0;
                    this.isPoolBundle = (indexesInt3 & 2) != 0;
                    this.usesPoolBundle = (indexesInt3 & 4) != 0;
                    this.poolStringIndexLimit |= (61440 & indexesInt3) << 12;
                    this.poolStringIndex16Limit = indexesInt3 >>> 16;
                }
                int i3 = i + 1;
                int indexesInt4 = getIndexesInt(1);
                if (indexesInt4 > i3) {
                    if (this.isPoolBundle) {
                        this.keyBytes = new byte[((indexesInt4 - i3) << 2)];
                        this.bytes.position(i3 << 2);
                    } else {
                        this.localKeyLimit = indexesInt4 << 2;
                        this.keyBytes = new byte[this.localKeyLimit];
                    }
                    this.bytes.get(this.keyBytes);
                }
                if (i > 6) {
                    int indexesInt5 = getIndexesInt(6);
                    if (indexesInt5 > indexesInt4) {
                        int i4 = (indexesInt5 - indexesInt4) * 2;
                        this.bytes.position(indexesInt4 << 2);
                        this.b16BitUnits = this.bytes.asCharBuffer();
                        this.b16BitUnits.limit(i4);
                        i2 |= i4 - 1;
                    } else {
                        this.b16BitUnits = EMPTY_16_BIT_UNITS;
                    }
                } else {
                    this.b16BitUnits = EMPTY_16_BIT_UNITS;
                }
                if (i > 7) {
                    this.poolCheckSum = getIndexesInt(7);
                }
                if (!this.isPoolBundle || this.b16BitUnits.length() > 1) {
                    this.resourceCache = new ResourceCache(i2);
                }
                this.bytes.position(0);
                return;
            }
        }
        throw new ICUException("not enough bytes");
    }

    private int getIndexesInt(int i) {
        return this.bytes.getInt((i + 1) << 2);
    }

    /* access modifiers changed from: package-private */
    public int getRootResource() {
        return this.rootRes;
    }

    /* access modifiers changed from: package-private */
    public boolean getNoFallback() {
        return this.noFallback;
    }

    static int RES_GET_TYPE(int i) {
        return i >>> 28;
    }

    /* access modifiers changed from: private */
    public static int RES_GET_OFFSET(int i) {
        return 268435455 & i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getResourceByteOffset(int i) {
        return i << 2;
    }

    static int RES_GET_INT(int i) {
        return (i << 4) >> 4;
    }

    static boolean URES_IS_ARRAY(int i) {
        return i == 8 || i == 9;
    }

    static boolean URES_IS_TABLE(int i) {
        return i == 2 || i == 5 || i == 4;
    }

    private char[] getChars(int i, int i2) {
        char[] cArr = new char[i2];
        if (i2 <= 16) {
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = this.bytes.getChar(i);
                i += 2;
            }
        } else {
            CharBuffer asCharBuffer = this.bytes.asCharBuffer();
            asCharBuffer.position(i / 2);
            asCharBuffer.get(cArr);
        }
        return cArr;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getInt(int i) {
        return this.bytes.getInt(i);
    }

    private int[] getInts(int i, int i2) {
        int[] iArr = new int[i2];
        if (i2 <= 16) {
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = this.bytes.getInt(i);
                i += 4;
            }
        } else {
            IntBuffer asIntBuffer = this.bytes.asIntBuffer();
            asIntBuffer.position(i / 4);
            asIntBuffer.get(iArr);
        }
        return iArr;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private char[] getTable16KeyOffsets(int i) {
        int i2 = i + 1;
        int charAt = this.b16BitUnits.charAt(i);
        if (charAt <= 0) {
            return emptyChars;
        }
        char[] cArr = new char[charAt];
        if (charAt <= 16) {
            for (int i3 = 0; i3 < charAt; i3++) {
                i2++;
                cArr[i3] = this.b16BitUnits.charAt(i2);
            }
        } else {
            CharBuffer duplicate = this.b16BitUnits.duplicate();
            duplicate.position(i2);
            duplicate.get(cArr);
        }
        return cArr;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private char[] getTableKeyOffsets(int i) {
        char c = this.bytes.getChar(i);
        if (c > 0) {
            return getChars(i + 2, c);
        }
        return emptyChars;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int[] getTable32KeyOffsets(int i) {
        int i2 = getInt(i);
        if (i2 > 0) {
            return getInts(i + 4, i2);
        }
        return emptyInts;
    }

    private static String makeKeyStringFromBytes(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            byte b = bArr[i];
            if (b == 0) {
                return sb.toString();
            }
            i++;
            sb.append((char) b);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getKey16String(int i) {
        if (i < this.localKeyLimit) {
            return makeKeyStringFromBytes(this.keyBytes, i);
        }
        return makeKeyStringFromBytes(this.poolBundleReader.keyBytes, i - this.localKeyLimit);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getKey32String(int i) {
        if (i >= 0) {
            return makeKeyStringFromBytes(this.keyBytes, i);
        }
        return makeKeyStringFromBytes(this.poolBundleReader.keyBytes, Integer.MAX_VALUE & i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setKeyFromKey16(int i, UResource.Key key) {
        if (i < this.localKeyLimit) {
            key.setBytes(this.keyBytes, i);
        } else {
            key.setBytes(this.poolBundleReader.keyBytes, i - this.localKeyLimit);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setKeyFromKey32(int i, UResource.Key key) {
        if (i >= 0) {
            key.setBytes(this.keyBytes, i);
        } else {
            key.setBytes(this.poolBundleReader.keyBytes, Integer.MAX_VALUE & i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int compareKeys(CharSequence charSequence, char c) {
        if (c < this.localKeyLimit) {
            return ICUBinary.compareKeys(charSequence, this.keyBytes, c);
        }
        return ICUBinary.compareKeys(charSequence, this.poolBundleReader.keyBytes, c - this.localKeyLimit);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int compareKeys32(CharSequence charSequence, int i) {
        if (i >= 0) {
            return ICUBinary.compareKeys(charSequence, this.keyBytes, i);
        }
        return ICUBinary.compareKeys(charSequence, this.poolBundleReader.keyBytes, Integer.MAX_VALUE & i);
    }

    /* access modifiers changed from: package-private */
    public String getStringV2(int i) {
        String str;
        int i2;
        int i3;
        if ($assertionsDisabled || RES_GET_TYPE(i) == 6) {
            int RES_GET_OFFSET = RES_GET_OFFSET(i);
            if ($assertionsDisabled || RES_GET_OFFSET != 0) {
                Object obj = this.resourceCache.get(i);
                if (obj != null) {
                    return (String) obj;
                }
                char charAt = this.b16BitUnits.charAt(RES_GET_OFFSET);
                if ((charAt & 64512) == 56320) {
                    if (charAt < 57327) {
                        i2 = charAt & 1023;
                        i3 = RES_GET_OFFSET + 1;
                    } else if (charAt < 57343) {
                        i2 = ((charAt - 57327) << 16) | this.b16BitUnits.charAt(RES_GET_OFFSET + 1);
                        i3 = RES_GET_OFFSET + 2;
                    } else {
                        i2 = (this.b16BitUnits.charAt(RES_GET_OFFSET + 1) << 16) | this.b16BitUnits.charAt(RES_GET_OFFSET + 2);
                        i3 = RES_GET_OFFSET + 3;
                    }
                    str = this.b16BitUnits.subSequence(i3, i3 + i2).toString();
                } else if (charAt == 0) {
                    return "";
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append((char) charAt);
                    while (true) {
                        RES_GET_OFFSET++;
                        char charAt2 = this.b16BitUnits.charAt(RES_GET_OFFSET);
                        if (charAt2 == 0) {
                            break;
                        }
                        sb.append(charAt2);
                    }
                    str = sb.toString();
                }
                return (String) this.resourceCache.putIfAbsent(i, str, str.length() * 2);
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private String makeStringFromBytes(int i, int i2) {
        if (i2 <= 16) {
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(this.bytes.getChar(i));
                i += 2;
            }
            return sb.toString();
        }
        int i4 = i / 2;
        return this.bytes.asCharBuffer().subSequence(i4, i4 + i2).toString();
    }

    /* access modifiers changed from: package-private */
    public String getString(int i) {
        int RES_GET_OFFSET = RES_GET_OFFSET(i);
        if (i != RES_GET_OFFSET && RES_GET_TYPE(i) != 6) {
            return null;
        }
        if (RES_GET_OFFSET == 0) {
            return "";
        }
        if (i == RES_GET_OFFSET) {
            Object obj = this.resourceCache.get(i);
            if (obj != null) {
                return (String) obj;
            }
            int resourceByteOffset = getResourceByteOffset(RES_GET_OFFSET);
            String makeStringFromBytes = makeStringFromBytes(resourceByteOffset + 4, getInt(resourceByteOffset));
            return (String) this.resourceCache.putIfAbsent(i, makeStringFromBytes, makeStringFromBytes.length() * 2);
        } else if (RES_GET_OFFSET < this.poolStringIndexLimit) {
            return this.poolBundleReader.getStringV2(i);
        } else {
            return getStringV2(i - this.poolStringIndexLimit);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isNoInheritanceMarker(int i) {
        int RES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_OFFSET == 0) {
            return false;
        }
        if (i == RES_GET_OFFSET) {
            int resourceByteOffset = getResourceByteOffset(RES_GET_OFFSET);
            return getInt(resourceByteOffset) == 3 && this.bytes.getChar(resourceByteOffset + 4) == 8709 && this.bytes.getChar(resourceByteOffset + 6) == 8709 && this.bytes.getChar(resourceByteOffset + 8) == 8709;
        } else if (RES_GET_TYPE(i) != 6) {
            return false;
        } else {
            if (RES_GET_OFFSET < this.poolStringIndexLimit) {
                return this.poolBundleReader.isStringV2NoInheritanceMarker(RES_GET_OFFSET);
            }
            return isStringV2NoInheritanceMarker(RES_GET_OFFSET - this.poolStringIndexLimit);
        }
    }

    private boolean isStringV2NoInheritanceMarker(int i) {
        char charAt = this.b16BitUnits.charAt(i);
        return charAt == 8709 ? this.b16BitUnits.charAt(i + 1) == 8709 && this.b16BitUnits.charAt(i + 2) == 8709 && this.b16BitUnits.charAt(i + 3) == 0 : charAt == 56323 && this.b16BitUnits.charAt(i + 1) == 8709 && this.b16BitUnits.charAt(i + 2) == 8709 && this.b16BitUnits.charAt(i + 3) == 8709;
    }

    /* access modifiers changed from: package-private */
    public String getAlias(int i) {
        int RES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_TYPE(i) != 3) {
            return null;
        }
        if (RES_GET_OFFSET == 0) {
            return "";
        }
        Object obj = this.resourceCache.get(i);
        if (obj != null) {
            return (String) obj;
        }
        int resourceByteOffset = getResourceByteOffset(RES_GET_OFFSET);
        int i2 = getInt(resourceByteOffset);
        return (String) this.resourceCache.putIfAbsent(i, makeStringFromBytes(resourceByteOffset + 4, i2), i2 * 2);
    }

    /* access modifiers changed from: package-private */
    public byte[] getBinary(int i, byte[] bArr) {
        int RES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_TYPE(i) != 1) {
            return null;
        }
        if (RES_GET_OFFSET == 0) {
            return emptyBytes;
        }
        int resourceByteOffset = getResourceByteOffset(RES_GET_OFFSET);
        int i2 = getInt(resourceByteOffset);
        if (i2 == 0) {
            return emptyBytes;
        }
        if (bArr == null || bArr.length != i2) {
            bArr = new byte[i2];
        }
        int i3 = resourceByteOffset + 4;
        if (i2 <= 16) {
            for (int i4 = 0; i4 < i2; i4++) {
                i3++;
                bArr[i4] = this.bytes.get(i3);
            }
        } else {
            ByteBuffer duplicate = this.bytes.duplicate();
            duplicate.position(i3);
            duplicate.get(bArr);
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getBinary(int i) {
        int RES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_TYPE(i) != 1) {
            return null;
        }
        if (RES_GET_OFFSET == 0) {
            return emptyByteBuffer.duplicate();
        }
        int resourceByteOffset = getResourceByteOffset(RES_GET_OFFSET);
        int i2 = getInt(resourceByteOffset);
        if (i2 == 0) {
            return emptyByteBuffer.duplicate();
        }
        int i3 = resourceByteOffset + 4;
        ByteBuffer duplicate = this.bytes.duplicate();
        duplicate.position(i3).limit(i3 + i2);
        ByteBuffer sliceWithOrder = ICUBinary.sliceWithOrder(duplicate);
        if (!sliceWithOrder.isReadOnly()) {
            return sliceWithOrder.asReadOnlyBuffer();
        }
        return sliceWithOrder;
    }

    /* access modifiers changed from: package-private */
    public int[] getIntVector(int i) {
        int RES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_TYPE(i) != 14) {
            return null;
        }
        if (RES_GET_OFFSET == 0) {
            return emptyInts;
        }
        int resourceByteOffset = getResourceByteOffset(RES_GET_OFFSET);
        return getInts(resourceByteOffset + 4, getInt(resourceByteOffset));
    }

    /* access modifiers changed from: package-private */
    public Array getArray(int i) {
        int RES_GET_TYPE = RES_GET_TYPE(i);
        if (!URES_IS_ARRAY(RES_GET_TYPE)) {
            return null;
        }
        int RES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_OFFSET == 0) {
            return EMPTY_ARRAY;
        }
        Object obj = this.resourceCache.get(i);
        if (obj != null) {
            return (Array) obj;
        }
        return (Array) this.resourceCache.putIfAbsent(i, RES_GET_TYPE == 8 ? new Array32(this, RES_GET_OFFSET) : new Array16(this, RES_GET_OFFSET), 0);
    }

    /* access modifiers changed from: package-private */
    public Table getTable(int i) {
        int i2;
        Table table;
        int RES_GET_TYPE = RES_GET_TYPE(i);
        if (!URES_IS_TABLE(RES_GET_TYPE)) {
            return null;
        }
        int RES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_OFFSET == 0) {
            return EMPTY_TABLE;
        }
        Object obj = this.resourceCache.get(i);
        if (obj != null) {
            return (Table) obj;
        }
        if (RES_GET_TYPE == 2) {
            table = new Table1632(this, RES_GET_OFFSET);
            i2 = table.getSize() * 2;
        } else if (RES_GET_TYPE == 5) {
            table = new Table16(this, RES_GET_OFFSET);
            i2 = table.getSize() * 2;
        } else {
            table = new Table32(this, RES_GET_OFFSET);
            i2 = table.getSize() * 4;
        }
        return (Table) this.resourceCache.putIfAbsent(i, table, i2);
    }

    /* access modifiers changed from: package-private */
    public static class ReaderValue extends UResource.Value {
        ICUResourceBundleReader reader;
        int res;

        ReaderValue() {
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public int getType() {
            return ICUResourceBundleReader.PUBLIC_TYPES[ICUResourceBundleReader.RES_GET_TYPE(this.res)];
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public String getString() {
            String string = this.reader.getString(this.res);
            if (string != null) {
                return string;
            }
            throw new UResourceTypeMismatchException("");
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public String getAliasString() {
            String alias = this.reader.getAlias(this.res);
            if (alias != null) {
                return alias;
            }
            throw new UResourceTypeMismatchException("");
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public int getInt() {
            if (ICUResourceBundleReader.RES_GET_TYPE(this.res) == 7) {
                return ICUResourceBundleReader.RES_GET_INT(this.res);
            }
            throw new UResourceTypeMismatchException("");
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public int[] getIntVector() {
            int[] intVector = this.reader.getIntVector(this.res);
            if (intVector != null) {
                return intVector;
            }
            throw new UResourceTypeMismatchException("");
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public UResource.Array getArray() {
            Array array = this.reader.getArray(this.res);
            if (array != null) {
                return array;
            }
            throw new UResourceTypeMismatchException("");
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public UResource.Table getTable() {
            Table table = this.reader.getTable(this.res);
            if (table != null) {
                return table;
            }
            throw new UResourceTypeMismatchException("");
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public boolean isNoInheritanceMarker() {
            return this.reader.isNoInheritanceMarker(this.res);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public String[] getStringArray() {
            Array array = this.reader.getArray(this.res);
            if (array != null) {
                return getStringArray(array);
            }
            throw new UResourceTypeMismatchException("");
        }

        private String[] getStringArray(Array array) {
            String[] strArr = new String[array.size];
            for (int i = 0; i < array.size; i++) {
                String string = this.reader.getString(array.getContainerResource(this.reader, i));
                if (string == null) {
                    throw new UResourceTypeMismatchException("");
                }
                strArr[i] = string;
            }
            return strArr;
        }
    }

    /* access modifiers changed from: package-private */
    public static class Container {
        protected int itemsOffset;
        protected int size;

        public final int getSize() {
            return this.size;
        }

        /* access modifiers changed from: package-private */
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return -1;
        }

        /* access modifiers changed from: protected */
        public int getContainer16Resource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            if (i < 0 || this.size <= i) {
                return -1;
            }
            int charAt = iCUResourceBundleReader.b16BitUnits.charAt(this.itemsOffset + i);
            if (charAt >= iCUResourceBundleReader.poolStringIndex16Limit) {
                charAt = (charAt - iCUResourceBundleReader.poolStringIndex16Limit) + iCUResourceBundleReader.poolStringIndexLimit;
            }
            return 1610612736 | charAt;
        }

        /* access modifiers changed from: protected */
        public int getContainer32Resource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            if (i < 0 || this.size <= i) {
                return -1;
            }
            return iCUResourceBundleReader.getInt(this.itemsOffset + (i * 4));
        }

        /* access modifiers changed from: package-private */
        public int getResource(ICUResourceBundleReader iCUResourceBundleReader, String str) {
            return getContainerResource(iCUResourceBundleReader, Integer.parseInt(str));
        }

        Container() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class Array extends Container implements UResource.Array {
        Array() {
        }

        @Override // com.ibm.icu.impl.UResource.Array
        public boolean getValue(int i, UResource.Value value) {
            if (0 > i || i >= this.size) {
                return false;
            }
            ReaderValue readerValue = (ReaderValue) value;
            readerValue.res = getContainerResource(readerValue.reader, i);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Array32 extends Array {
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer32Resource(iCUResourceBundleReader, i);
        }

        Array32(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            int resourceByteOffset = iCUResourceBundleReader.getResourceByteOffset(i);
            this.size = iCUResourceBundleReader.getInt(resourceByteOffset);
            this.itemsOffset = resourceByteOffset + 4;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Array16 extends Array {
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer16Resource(iCUResourceBundleReader, i);
        }

        Array16(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            this.size = iCUResourceBundleReader.b16BitUnits.charAt(i);
            this.itemsOffset = i + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public static class Table extends Container implements UResource.Table {
        protected int[] key32Offsets;
        protected char[] keyOffsets;

        Table() {
        }

        /* access modifiers changed from: package-private */
        public String getKey(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            if (i < 0 || this.size <= i) {
                return null;
            }
            if (this.keyOffsets != null) {
                return iCUResourceBundleReader.getKey16String(this.keyOffsets[i]);
            }
            return iCUResourceBundleReader.getKey32String(this.key32Offsets[i]);
        }

        /* access modifiers changed from: package-private */
        public int findTableItem(ICUResourceBundleReader iCUResourceBundleReader, CharSequence charSequence) {
            int i;
            int i2 = 0;
            int i3 = this.size;
            while (i2 < i3) {
                int i4 = (i2 + i3) >>> 1;
                if (this.keyOffsets != null) {
                    i = iCUResourceBundleReader.compareKeys(charSequence, this.keyOffsets[i4]);
                } else {
                    i = iCUResourceBundleReader.compareKeys32(charSequence, this.key32Offsets[i4]);
                }
                if (i < 0) {
                    i3 = i4;
                } else if (i <= 0) {
                    return i4;
                } else {
                    i2 = i4 + 1;
                }
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getResource(ICUResourceBundleReader iCUResourceBundleReader, String str) {
            return getContainerResource(iCUResourceBundleReader, findTableItem(iCUResourceBundleReader, str));
        }

        @Override // com.ibm.icu.impl.UResource.Table
        public boolean getKeyAndValue(int i, UResource.Key key, UResource.Value value) {
            if (0 > i || i >= this.size) {
                return false;
            }
            ReaderValue readerValue = (ReaderValue) value;
            if (this.keyOffsets != null) {
                readerValue.reader.setKeyFromKey16(this.keyOffsets[i], key);
            } else {
                readerValue.reader.setKeyFromKey32(this.key32Offsets[i], key);
            }
            readerValue.res = getContainerResource(readerValue.reader, i);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Table1632 extends Table {
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer32Resource(iCUResourceBundleReader, i);
        }

        Table1632(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            int resourceByteOffset = iCUResourceBundleReader.getResourceByteOffset(i);
            this.keyOffsets = iCUResourceBundleReader.getTableKeyOffsets(resourceByteOffset);
            this.size = this.keyOffsets.length;
            this.itemsOffset = (((this.size + 2) & -2) * 2) + resourceByteOffset;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Table16 extends Table {
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer16Resource(iCUResourceBundleReader, i);
        }

        Table16(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            this.keyOffsets = iCUResourceBundleReader.getTable16KeyOffsets(i);
            this.size = this.keyOffsets.length;
            this.itemsOffset = i + 1 + this.size;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Table32 extends Table {
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer32Resource(iCUResourceBundleReader, i);
        }

        Table32(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            int resourceByteOffset = iCUResourceBundleReader.getResourceByteOffset(i);
            this.key32Offsets = iCUResourceBundleReader.getTable32KeyOffsets(resourceByteOffset);
            this.size = this.key32Offsets.length;
            this.itemsOffset = ((this.size + 1) * 4) + resourceByteOffset;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ResourceCache {
        static final /* synthetic */ boolean $assertionsDisabled = (!ICUResourceBundleReader.class.desiredAssertionStatus());
        private int[] keys = new int[32];
        private int length;
        private int levelBitsList;
        private int maxOffsetBits;
        private Level rootLevel;
        private Object[] values = new Object[32];

        /* access modifiers changed from: private */
        public static boolean storeDirectly(int i) {
            return i < 24 || CacheValue.futureInstancesWillBeStrong();
        }

        /* access modifiers changed from: private */
        public static final Object putIfCleared(Object[] objArr, int i, Object obj, int i2) {
            Object obj2 = objArr[i];
            if (!(obj2 instanceof SoftReference)) {
                return obj2;
            }
            if ($assertionsDisabled || i2 >= 24) {
                Object obj3 = ((SoftReference) obj2).get();
                if (obj3 != null) {
                    return obj3;
                }
                objArr[i] = CacheValue.futureInstancesWillBeStrong() ? obj : new SoftReference(obj);
                return obj;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public static final class Level {
            static final /* synthetic */ boolean $assertionsDisabled = (!ICUResourceBundleReader.class.desiredAssertionStatus());
            int[] keys;
            int levelBitsList;
            int mask;
            int shift;
            Object[] values;

            Level(int i, int i2) {
                this.levelBitsList = i;
                this.shift = i2;
                int i3 = i & 15;
                if ($assertionsDisabled || i3 != 0) {
                    int i4 = 1 << i3;
                    this.mask = i4 - 1;
                    this.keys = new int[i4];
                    this.values = new Object[i4];
                    return;
                }
                throw new AssertionError();
            }

            /* access modifiers changed from: package-private */
            public Object get(int i) {
                Level level;
                int i2 = (i >> this.shift) & this.mask;
                int i3 = this.keys[i2];
                if (i3 == i) {
                    return this.values[i2];
                }
                if (i3 != 0 || (level = (Level) this.values[i2]) == null) {
                    return null;
                }
                return level.get(i);
            }

            /* access modifiers changed from: package-private */
            public Object putIfAbsent(int i, Object obj, int i2) {
                int i3 = (i >> this.shift) & this.mask;
                int i4 = this.keys[i3];
                if (i4 == i) {
                    return ResourceCache.putIfCleared(this.values, i3, obj, i2);
                }
                if (i4 == 0) {
                    Level level = (Level) this.values[i3];
                    if (level != null) {
                        return level.putIfAbsent(i, obj, i2);
                    }
                    this.keys[i3] = i;
                    this.values[i3] = ResourceCache.storeDirectly(i2) ? obj : new SoftReference(obj);
                    return obj;
                }
                Level level2 = new Level(this.levelBitsList >> 4, this.shift + (this.levelBitsList & 15));
                int i5 = (i4 >> level2.shift) & level2.mask;
                level2.keys[i5] = i4;
                level2.values[i5] = this.values[i3];
                this.keys[i3] = 0;
                this.values[i3] = level2;
                return level2.putIfAbsent(i, obj, i2);
            }
        }

        ResourceCache(int i) {
            if ($assertionsDisabled || i != 0) {
                this.maxOffsetBits = 28;
                while (i <= 134217727) {
                    i <<= 1;
                    this.maxOffsetBits--;
                }
                int i2 = this.maxOffsetBits + 2;
                if (i2 <= 7) {
                    this.levelBitsList = i2;
                } else if (i2 < 10) {
                    this.levelBitsList = (i2 - 3) | 48;
                } else {
                    this.levelBitsList = 7;
                    int i3 = i2 - 7;
                    int i4 = 4;
                    while (i3 > 6) {
                        if (i3 < 9) {
                            this.levelBitsList |= ((i3 - 3) | 48) << i4;
                            return;
                        }
                        this.levelBitsList |= 6 << i4;
                        i3 -= 6;
                        i4 += 4;
                    }
                    this.levelBitsList |= i3 << i4;
                }
            } else {
                throw new AssertionError();
            }
        }

        private int makeKey(int i) {
            int RES_GET_TYPE = ICUResourceBundleReader.RES_GET_TYPE(i);
            return ICUResourceBundleReader.RES_GET_OFFSET(i) | ((RES_GET_TYPE == 6 ? 1 : RES_GET_TYPE == 5 ? 3 : RES_GET_TYPE == 9 ? 2 : 0) << this.maxOffsetBits);
        }

        private int findSimple(int i) {
            int i2 = 0;
            int i3 = this.length;
            while (i3 - i2 > 8) {
                int i4 = (i2 + i3) / 2;
                if (i < this.keys[i4]) {
                    i3 = i4;
                } else {
                    i2 = i4;
                }
            }
            while (i2 < i3) {
                int i5 = this.keys[i2];
                if (i < i5) {
                    return i2 ^ -1;
                }
                if (i == i5) {
                    return i2;
                }
                i2++;
            }
            return i2 ^ -1;
        }

        /* access modifiers changed from: package-private */
        public synchronized Object get(int i) {
            Object obj;
            if ($assertionsDisabled || ICUResourceBundleReader.RES_GET_OFFSET(i) != 0) {
                if (this.length >= 0) {
                    int findSimple = findSimple(i);
                    if (findSimple < 0) {
                        return null;
                    }
                    obj = this.values[findSimple];
                } else {
                    obj = this.rootLevel.get(makeKey(i));
                    if (obj == null) {
                        return null;
                    }
                }
                if (obj instanceof SoftReference) {
                    obj = ((SoftReference) obj).get();
                }
                return obj;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public synchronized Object putIfAbsent(int i, Object obj, int i2) {
            if (this.length >= 0) {
                int findSimple = findSimple(i);
                if (findSimple >= 0) {
                    return putIfCleared(this.values, findSimple, obj, i2);
                } else if (this.length < 32) {
                    int i3 = findSimple ^ -1;
                    if (i3 < this.length) {
                        System.arraycopy(this.keys, i3, this.keys, i3 + 1, this.length - i3);
                        System.arraycopy(this.values, i3, this.values, i3 + 1, this.length - i3);
                    }
                    this.length++;
                    this.keys[i3] = i;
                    this.values[i3] = storeDirectly(i2) ? obj : new SoftReference(obj);
                    return obj;
                } else {
                    this.rootLevel = new Level(this.levelBitsList, 0);
                    for (int i4 = 0; i4 < 32; i4++) {
                        this.rootLevel.putIfAbsent(makeKey(this.keys[i4]), this.values[i4], 0);
                    }
                    this.keys = null;
                    this.values = null;
                    this.length = -1;
                }
            }
            return this.rootLevel.putIfAbsent(makeKey(i), obj, i2);
        }
    }

    public static String getFullName(String str, String str2) {
        if (str == null || str.length() == 0) {
            if (str2.length() == 0) {
                return ULocale.getDefault().toString();
            }
            return str2 + ".res";
        } else if (str.indexOf(46) != -1) {
            String replace = str.replace('.', '/');
            if (str2.length() == 0) {
                return replace + ".res";
            }
            return replace + "_" + str2 + ".res";
        } else if (str.charAt(str.length() - 1) != '/') {
            return str + "/" + str2 + ".res";
        } else {
            return str + str2 + ".res";
        }
    }
}
