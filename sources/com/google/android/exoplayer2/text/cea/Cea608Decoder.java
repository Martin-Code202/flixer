package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public final class Cea608Decoder extends CeaDecoder {
    private static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] COLORS = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] SPECIAL_CHARACTER_SET = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private int captionMode;
    private int captionRowCount;
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final LinkedList<CueBuilder> cueBuilders = new LinkedList<>();
    private List<Cue> cues;
    private CueBuilder currentCueBuilder = new CueBuilder(0, 4);
    private List<Cue> lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedField;

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() {
        return super.dequeueInputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() {
        return super.dequeueOutputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    public Cea608Decoder(String str, int i) {
        this.packetLength = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
            default:
                this.selectedField = 1;
                break;
            case 3:
            case 4:
                this.selectedField = 2;
                break;
        }
        setCaptionMode(0);
        resetCueBuilders();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        setCaptionMode(0);
        resetCueBuilders();
        this.captionRowCount = 4;
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = 0;
        this.repeatableControlCc2 = 0;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public Subtitle createSubtitle() {
        this.lastCues = this.cues;
        return new CeaSubtitle(this.cues);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void decode(SubtitleInputBuffer subtitleInputBuffer) {
        byte b;
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.ccData.bytesLeft() >= this.packetLength) {
            if (this.packetLength == 2) {
                b = -4;
            } else {
                b = (byte) this.ccData.readUnsignedByte();
            }
            byte readUnsignedByte = (byte) (this.ccData.readUnsignedByte() & 127);
            byte readUnsignedByte2 = (byte) (this.ccData.readUnsignedByte() & 127);
            if ((b & 6) == 4 && (this.selectedField != 1 || (b & 1) == 0)) {
                if (this.selectedField != 2 || (b & 1) == 1) {
                    if (readUnsignedByte != 0 || readUnsignedByte2 != 0) {
                        z = true;
                        if ((readUnsignedByte & 247) == 17 && (readUnsignedByte2 & 240) == 48) {
                            this.currentCueBuilder.append(getSpecialChar(readUnsignedByte2));
                        } else if ((readUnsignedByte & 246) == 18 && (readUnsignedByte2 & 224) == 32) {
                            this.currentCueBuilder.backspace();
                            if ((readUnsignedByte & 1) == 0) {
                                this.currentCueBuilder.append(getExtendedEsFrChar(readUnsignedByte2));
                            } else {
                                this.currentCueBuilder.append(getExtendedPtDeChar(readUnsignedByte2));
                            }
                        } else if ((readUnsignedByte & 224) == 0) {
                            z2 = handleCtrl(readUnsignedByte, readUnsignedByte2);
                        } else {
                            this.currentCueBuilder.append(getChar(readUnsignedByte));
                            if ((readUnsignedByte2 & 224) != 0) {
                                this.currentCueBuilder.append(getChar(readUnsignedByte2));
                            }
                        }
                    }
                }
            }
        }
        if (z) {
            if (!z2) {
                this.repeatableControlSet = false;
            }
            if (this.captionMode == 1 || this.captionMode == 3) {
                this.cues = getDisplayCues();
            }
        }
    }

    private boolean handleCtrl(byte b, byte b2) {
        boolean isRepeatable = isRepeatable(b);
        if (isRepeatable) {
            if (this.repeatableControlSet && this.repeatableControlCc1 == b && this.repeatableControlCc2 == b2) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b;
            this.repeatableControlCc2 = b2;
        }
        if (isMidrowCtrlCode(b, b2)) {
            handleMidrowCtrl(b2);
        } else if (isPreambleAddressCode(b, b2)) {
            handlePreambleAddressCode(b, b2);
        } else if (isTabCtrlCode(b, b2)) {
            this.currentCueBuilder.setTab(b2 - 32);
        } else if (isMiscCode(b, b2)) {
            handleMiscCode(b2);
        }
        return isRepeatable;
    }

    private void handleMidrowCtrl(byte b) {
        this.currentCueBuilder.setUnderline((b & 1) == 1);
        int i = (b >> 1) & 15;
        if (i == 7) {
            this.currentCueBuilder.setMidrowStyle(new StyleSpan(2), 2);
            this.currentCueBuilder.setMidrowStyle(new ForegroundColorSpan(-1), 1);
            return;
        }
        this.currentCueBuilder.setMidrowStyle(new ForegroundColorSpan(COLORS[i]), 1);
    }

    private void handlePreambleAddressCode(byte b, byte b2) {
        int i = ROW_INDICES[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.currentCueBuilder.getRow()) {
            if (this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                this.currentCueBuilder = new CueBuilder(this.captionMode, this.captionRowCount);
                this.cueBuilders.add(this.currentCueBuilder);
            }
            this.currentCueBuilder.setRow(i);
        }
        if ((b2 & 1) == 1) {
            this.currentCueBuilder.setPreambleStyle(new UnderlineSpan());
        }
        int i2 = (b2 >> 1) & 15;
        if (i2 > 7) {
            this.currentCueBuilder.setIndent(COLUMN_INDICES[i2 & 7]);
        } else if (i2 == 7) {
            this.currentCueBuilder.setPreambleStyle(new StyleSpan(2));
            this.currentCueBuilder.setPreambleStyle(new ForegroundColorSpan(-1));
        } else {
            this.currentCueBuilder.setPreambleStyle(new ForegroundColorSpan(COLORS[i2]));
        }
    }

    private void handleMiscCode(byte b) {
        switch (b) {
            case 32:
                setCaptionMode(2);
                return;
            case 33:
            case 34:
            case 35:
            case 36:
            case 40:
            default:
                if (this.captionMode != 0) {
                    switch (b) {
                        case 33:
                            this.currentCueBuilder.backspace();
                            return;
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        default:
                            return;
                        case 44:
                            this.cues = null;
                            if (this.captionMode == 1 || this.captionMode == 3) {
                                resetCueBuilders();
                                return;
                            }
                            return;
                        case 45:
                            if (this.captionMode == 1 && !this.currentCueBuilder.isEmpty()) {
                                this.currentCueBuilder.rollUp();
                                return;
                            }
                            return;
                        case 46:
                            resetCueBuilders();
                            return;
                        case 47:
                            this.cues = getDisplayCues();
                            resetCueBuilders();
                            return;
                    }
                } else {
                    return;
                }
            case 37:
                this.captionRowCount = 2;
                setCaptionMode(1);
                return;
            case 38:
                this.captionRowCount = 3;
                setCaptionMode(1);
                return;
            case 39:
                this.captionRowCount = 4;
                setCaptionMode(1);
                return;
            case 41:
                setCaptionMode(3);
                return;
        }
    }

    private List<Cue> getDisplayCues() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cueBuilders.size(); i++) {
            Cue build = this.cueBuilders.get(i).build();
            if (build != null) {
                arrayList.add(build);
            }
        }
        return arrayList;
    }

    private void setCaptionMode(int i) {
        if (this.captionMode != i) {
            int i2 = this.captionMode;
            this.captionMode = i;
            resetCueBuilders();
            if (i2 == 3 || i == 1 || i == 0) {
                this.cues = null;
            }
        }
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode, this.captionRowCount);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    private static char getChar(byte b) {
        return (char) BASIC_CHARACTER_SET[(b & Byte.MAX_VALUE) - 32];
    }

    private static char getSpecialChar(byte b) {
        return (char) SPECIAL_CHARACTER_SET[b & 15];
    }

    private static char getExtendedEsFrChar(byte b) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b & 31];
    }

    private static char getExtendedPtDeChar(byte b) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b & 31];
    }

    private static boolean isMidrowCtrlCode(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    private static boolean isPreambleAddressCode(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    private static boolean isTabCtrlCode(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    private static boolean isMiscCode(byte b, byte b2) {
        return (b & 247) == 20 && (b2 & 240) == 32;
    }

    private static boolean isRepeatable(byte b) {
        return (b & 240) == 16;
    }

    /* access modifiers changed from: package-private */
    public static class CueBuilder {
        private int captionMode;
        private int captionRowCount;
        private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();
        private int indent;
        private final List<CueStyle> midrowStyles = new ArrayList();
        private final List<CharacterStyle> preambleStyles = new ArrayList();
        private final List<SpannableString> rolledUpCaptions = new LinkedList();
        private int row;
        private int tabOffset;
        private int underlineStartPosition;

        public CueBuilder(int i, int i2) {
            reset(i, i2);
        }

        public void reset(int i, int i2) {
            this.preambleStyles.clear();
            this.midrowStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
            this.captionMode = i;
            this.captionRowCount = i2;
            this.underlineStartPosition = -1;
        }

        public boolean isEmpty() {
            return this.preambleStyles.isEmpty() && this.midrowStyles.isEmpty() && this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0;
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        public int getRow() {
            return this.row;
        }

        public void setRow(int i) {
            this.row = i;
        }

        public void rollUp() {
            this.rolledUpCaptions.add(buildSpannableString());
            this.captionStringBuilder.clear();
            this.preambleStyles.clear();
            this.midrowStyles.clear();
            this.underlineStartPosition = -1;
            int min = Math.min(this.captionRowCount, this.row);
            while (this.rolledUpCaptions.size() >= min) {
                this.rolledUpCaptions.remove(0);
            }
        }

        public void setIndent(int i) {
            this.indent = i;
        }

        public void setTab(int i) {
            this.tabOffset = i;
        }

        public void setPreambleStyle(CharacterStyle characterStyle) {
            this.preambleStyles.add(characterStyle);
        }

        public void setMidrowStyle(CharacterStyle characterStyle, int i) {
            this.midrowStyles.add(new CueStyle(characterStyle, this.captionStringBuilder.length(), i));
        }

        public void setUnderline(boolean z) {
            if (z) {
                this.underlineStartPosition = this.captionStringBuilder.length();
            } else if (this.underlineStartPosition != -1) {
                this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                this.underlineStartPosition = -1;
            }
        }

        public void append(char c) {
            this.captionStringBuilder.append(c);
        }

        public SpannableString buildSpannableString() {
            int length = this.captionStringBuilder.length();
            for (int i = 0; i < this.preambleStyles.size(); i++) {
                this.captionStringBuilder.setSpan(this.preambleStyles.get(i), 0, length, 33);
            }
            int i2 = 0;
            while (i2 < this.midrowStyles.size()) {
                CueStyle cueStyle = this.midrowStyles.get(i2);
                this.captionStringBuilder.setSpan(cueStyle.style, cueStyle.start, i2 < this.midrowStyles.size() - cueStyle.nextStyleIncrement ? this.midrowStyles.get(cueStyle.nextStyleIncrement + i2).start : length, 33);
                i2++;
            }
            if (this.underlineStartPosition != -1) {
                this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
            }
            return new SpannableString(this.captionStringBuilder);
        }

        public Cue build() {
            int i;
            float f;
            int i2;
            int i3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.rolledUpCaptions.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.rolledUpCaptions.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) buildSpannableString());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.indent + this.tabOffset;
            int length = (32 - i5) - spannableStringBuilder.length();
            int i6 = i5 - length;
            if (this.captionMode == 2 && Math.abs(i6) < 3) {
                f = 0.5f;
                i = 1;
            } else if (this.captionMode != 2 || i6 <= 0) {
                f = (0.8f * (((float) i5) / 32.0f)) + 0.1f;
                i = 0;
            } else {
                f = (0.8f * (((float) (32 - length)) / 32.0f)) + 0.1f;
                i = 2;
            }
            if (this.captionMode == 1 || this.row > 7) {
                i3 = 2;
                i2 = (this.row - 15) - 2;
            } else {
                i3 = 0;
                i2 = this.row;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public String toString() {
            return this.captionStringBuilder.toString();
        }

        /* access modifiers changed from: package-private */
        public static class CueStyle {
            public final int nextStyleIncrement;
            public final int start;
            public final CharacterStyle style;

            public CueStyle(CharacterStyle characterStyle, int i, int i2) {
                this.style = characterStyle;
                this.start = i;
                this.nextStyleIncrement = i2;
            }
        }
    }
}
