package com.ibm.icu.text;

import com.ibm.icu.impl.CharTrie;
import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Trie;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* access modifiers changed from: package-private */
public final class RBBIDataWrapper {
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable();
    static TrieFoldingFunc fTrieFoldingFunc = new TrieFoldingFunc();
    short[] fFTable;
    RBBIDataHeader fHeader;
    short[] fRTable;
    String fRuleSource;
    short[] fSFTable;
    short[] fSRTable;
    int[] fStatusTable;
    CharTrie fTrie;
    private boolean isBigEndian;

    /* access modifiers changed from: package-private */
    public static final class RBBIDataHeader {
        int fCatCount;
        int fFTable;
        int fFTableLen;
        byte[] fFormatVersion = new byte[4];
        int fLength;
        int fMagic = 0;
        int fRTable;
        int fRTableLen;
        int fRuleSource;
        int fRuleSourceLen;
        int fSFTable;
        int fSFTableLen;
        int fSRTable;
        int fSRTableLen;
        int fStatusTable;
        int fStatusTableLen;
        int fTrie;
        int fTrieLen;
        int fVersion;
    }

    /* access modifiers changed from: package-private */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 3;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRowIndex(int i) {
        return ((this.fHeader.fCatCount + 4) * i) + 8;
    }

    /* access modifiers changed from: package-private */
    public static class TrieFoldingFunc implements Trie.DataManipulate {
        TrieFoldingFunc() {
        }

        @Override // com.ibm.icu.impl.Trie.DataManipulate
        public int getFoldingOffset(int i) {
            if ((32768 & i) != 0) {
                return i & 32767;
            }
            return 0;
        }
    }

    RBBIDataWrapper() {
    }

    static RBBIDataWrapper get(ByteBuffer byteBuffer) {
        RBBIDataWrapper rBBIDataWrapper = new RBBIDataWrapper();
        ICUBinary.readHeader(byteBuffer, 1114794784, IS_ACCEPTABLE);
        rBBIDataWrapper.isBigEndian = byteBuffer.order() == ByteOrder.BIG_ENDIAN;
        rBBIDataWrapper.fHeader = new RBBIDataHeader();
        rBBIDataWrapper.fHeader.fMagic = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fVersion = byteBuffer.getInt(byteBuffer.position());
        rBBIDataWrapper.fHeader.fFormatVersion[0] = byteBuffer.get();
        rBBIDataWrapper.fHeader.fFormatVersion[1] = byteBuffer.get();
        rBBIDataWrapper.fHeader.fFormatVersion[2] = byteBuffer.get();
        rBBIDataWrapper.fHeader.fFormatVersion[3] = byteBuffer.get();
        rBBIDataWrapper.fHeader.fLength = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fCatCount = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fFTable = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fFTableLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fRTable = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fRTableLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fSFTable = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fSFTableLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fSRTable = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fSRTableLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fTrie = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fTrieLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fRuleSource = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fRuleSourceLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fStatusTable = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fStatusTableLen = byteBuffer.getInt();
        ICUBinary.skipBytes(byteBuffer, 24);
        if (rBBIDataWrapper.fHeader.fMagic != 45472 || (rBBIDataWrapper.fHeader.fVersion != 1 && rBBIDataWrapper.fHeader.fFormatVersion[0] != 3)) {
            throw new IOException("Break Iterator Rule Data Magic Number Incorrect, or unsupported data version.");
        } else if (rBBIDataWrapper.fHeader.fFTable < 96 || rBBIDataWrapper.fHeader.fFTable > rBBIDataWrapper.fHeader.fLength) {
            throw new IOException("Break iterator Rule data corrupt");
        } else {
            ICUBinary.skipBytes(byteBuffer, rBBIDataWrapper.fHeader.fFTable - 96);
            int i = rBBIDataWrapper.fHeader.fFTable;
            rBBIDataWrapper.fFTable = ICUBinary.getShorts(byteBuffer, rBBIDataWrapper.fHeader.fFTableLen / 2, rBBIDataWrapper.fHeader.fFTableLen & 1);
            ICUBinary.skipBytes(byteBuffer, rBBIDataWrapper.fHeader.fRTable - (i + rBBIDataWrapper.fHeader.fFTableLen));
            int i2 = rBBIDataWrapper.fHeader.fRTable;
            rBBIDataWrapper.fRTable = ICUBinary.getShorts(byteBuffer, rBBIDataWrapper.fHeader.fRTableLen / 2, rBBIDataWrapper.fHeader.fRTableLen & 1);
            int i3 = i2 + rBBIDataWrapper.fHeader.fRTableLen;
            if (rBBIDataWrapper.fHeader.fSFTableLen > 0) {
                ICUBinary.skipBytes(byteBuffer, rBBIDataWrapper.fHeader.fSFTable - i3);
                int i4 = rBBIDataWrapper.fHeader.fSFTable;
                rBBIDataWrapper.fSFTable = ICUBinary.getShorts(byteBuffer, rBBIDataWrapper.fHeader.fSFTableLen / 2, rBBIDataWrapper.fHeader.fSFTableLen & 1);
                i3 = i4 + rBBIDataWrapper.fHeader.fSFTableLen;
            }
            if (rBBIDataWrapper.fHeader.fSRTableLen > 0) {
                ICUBinary.skipBytes(byteBuffer, rBBIDataWrapper.fHeader.fSRTable - i3);
                int i5 = rBBIDataWrapper.fHeader.fSRTable;
                rBBIDataWrapper.fSRTable = ICUBinary.getShorts(byteBuffer, rBBIDataWrapper.fHeader.fSRTableLen / 2, rBBIDataWrapper.fHeader.fSRTableLen & 1);
                i3 = i5 + rBBIDataWrapper.fHeader.fSRTableLen;
            }
            ICUBinary.skipBytes(byteBuffer, rBBIDataWrapper.fHeader.fTrie - i3);
            int i6 = rBBIDataWrapper.fHeader.fTrie;
            byteBuffer.mark();
            rBBIDataWrapper.fTrie = new CharTrie(byteBuffer, fTrieFoldingFunc);
            byteBuffer.reset();
            if (i6 > rBBIDataWrapper.fHeader.fStatusTable) {
                throw new IOException("Break iterator Rule data corrupt");
            }
            ICUBinary.skipBytes(byteBuffer, rBBIDataWrapper.fHeader.fStatusTable - i6);
            int i7 = rBBIDataWrapper.fHeader.fStatusTable;
            rBBIDataWrapper.fStatusTable = ICUBinary.getInts(byteBuffer, rBBIDataWrapper.fHeader.fStatusTableLen / 4, rBBIDataWrapper.fHeader.fStatusTableLen & 3);
            int i8 = i7 + rBBIDataWrapper.fHeader.fStatusTableLen;
            if (i8 > rBBIDataWrapper.fHeader.fRuleSource) {
                throw new IOException("Break iterator Rule data corrupt");
            }
            ICUBinary.skipBytes(byteBuffer, rBBIDataWrapper.fHeader.fRuleSource - i8);
            int i9 = rBBIDataWrapper.fHeader.fRuleSource;
            rBBIDataWrapper.fRuleSource = ICUBinary.getString(byteBuffer, rBBIDataWrapper.fHeader.fRuleSourceLen / 2, rBBIDataWrapper.fHeader.fRuleSourceLen & 1);
            if (RuleBasedBreakIterator.fDebugEnv != null && RuleBasedBreakIterator.fDebugEnv.indexOf(Event.DATA) >= 0) {
                rBBIDataWrapper.dump(System.out);
            }
            return rBBIDataWrapper;
        }
    }

    private int getStateTableNumStates(short[] sArr) {
        if (this.isBigEndian) {
            return (sArr[0] << 16) | (sArr[1] & 65535);
        }
        return (sArr[1] << 16) | (sArr[0] & 65535);
    }

    /* access modifiers changed from: package-private */
    public int getStateTableFlags(short[] sArr) {
        return sArr[this.isBigEndian ? (char) 5 : 4];
    }

    /* access modifiers changed from: package-private */
    public void dump(PrintStream printStream) {
        if (this.fFTable.length == 0) {
            throw new NullPointerException();
        }
        printStream.println("RBBI Data Wrapper dump ...");
        printStream.println();
        printStream.println("Forward State Table");
        dumpTable(printStream, this.fFTable);
        printStream.println("Reverse State Table");
        dumpTable(printStream, this.fRTable);
        printStream.println("Forward Safe Points Table");
        dumpTable(printStream, this.fSFTable);
        printStream.println("Reverse Safe Points Table");
        dumpTable(printStream, this.fSRTable);
        dumpCharCategories(printStream);
        printStream.println("Source Rules: " + this.fRuleSource);
    }

    public static String intToString(int i, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        sb.append(i);
        while (sb.length() < i2) {
            sb.insert(0, ' ');
        }
        return sb.toString();
    }

    public static String intToHexString(int i, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        sb.append(Integer.toHexString(i));
        while (sb.length() < i2) {
            sb.insert(0, ' ');
        }
        return sb.toString();
    }

    private void dumpTable(PrintStream printStream, short[] sArr) {
        if (sArr == null) {
            printStream.println("  -- null -- ");
            return;
        }
        StringBuilder sb = new StringBuilder(" Row  Acc Look  Tag");
        for (int i = 0; i < this.fHeader.fCatCount; i++) {
            sb.append(intToString(i, 5));
        }
        printStream.println(sb.toString());
        for (int i2 = 0; i2 < sb.length(); i2++) {
            printStream.print("-");
        }
        printStream.println();
        for (int i3 = 0; i3 < getStateTableNumStates(sArr); i3++) {
            dumpRow(printStream, sArr, i3);
        }
        printStream.println();
    }

    private void dumpRow(PrintStream printStream, short[] sArr, int i) {
        StringBuilder sb = new StringBuilder((this.fHeader.fCatCount * 5) + 20);
        sb.append(intToString(i, 4));
        int rowIndex = getRowIndex(i);
        if (sArr[rowIndex + 0] != 0) {
            sb.append(intToString(sArr[rowIndex + 0], 5));
        } else {
            sb.append("     ");
        }
        if (sArr[rowIndex + 1] != 0) {
            sb.append(intToString(sArr[rowIndex + 1], 5));
        } else {
            sb.append("     ");
        }
        sb.append(intToString(sArr[rowIndex + 2], 5));
        for (int i2 = 0; i2 < this.fHeader.fCatCount; i2++) {
            sb.append(intToString(sArr[rowIndex + 4 + i2], 5));
        }
        printStream.println(sb);
    }

    private void dumpCharCategories(PrintStream printStream) {
        int codePointValue;
        int i = this.fHeader.fCatCount;
        String[] strArr = new String[(i + 1)];
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int[] iArr = new int[(i + 1)];
        for (int i5 = 0; i5 <= this.fHeader.fCatCount; i5++) {
            strArr[i5] = "";
        }
        printStream.println("\nCharacter Categories");
        printStream.println("--------------------");
        int i6 = 0;
        while (true) {
            if (i6 > 1114111) {
                break;
            }
            codePointValue = this.fTrie.getCodePointValue(i6) & 49151;
            if (codePointValue < 0 || codePointValue > this.fHeader.fCatCount) {
                break;
            }
            if (codePointValue == i4) {
                i3 = i6;
            } else {
                if (i4 >= 0) {
                    if (strArr[i4].length() > iArr[i4] + 70) {
                        iArr[i4] = strArr[i4].length() + 10;
                        strArr[i4] = strArr[i4] + "\n       ";
                    }
                    strArr[i4] = strArr[i4] + " " + Integer.toHexString(i2);
                    if (i3 != i2) {
                        strArr[i4] = strArr[i4] + "-" + Integer.toHexString(i3);
                    }
                }
                i4 = codePointValue;
                i3 = i6;
                i2 = i6;
            }
            i6++;
        }
        printStream.println("Error, bad category " + Integer.toHexString(codePointValue) + " for char " + Integer.toHexString(i6));
        strArr[i4] = strArr[i4] + " " + Integer.toHexString(i2);
        if (i3 != i2) {
            strArr[i4] = strArr[i4] + "-" + Integer.toHexString(i3);
        }
        for (int i7 = 0; i7 <= this.fHeader.fCatCount; i7++) {
            printStream.println(intToString(i7, 5) + "  " + strArr[i7]);
        }
        printStream.println();
    }
}
