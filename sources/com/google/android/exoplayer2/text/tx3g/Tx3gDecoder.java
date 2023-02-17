package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.List;
public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private static final int TYPE_STYL = Util.getIntegerCodeForString("styl");
    private static final int TYPE_TBOX = Util.getIntegerCodeForString("tbox");
    private int calculatedVideoTrackHeight;
    private boolean customVerticalPlacement;
    private int defaultColorRgba;
    private int defaultFontFace;
    private String defaultFontFamily;
    private float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray = new ParsableByteArray();

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        decodeInitializationData(list);
    }

    private void decodeInitializationData(List<byte[]> list) {
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.defaultFontFace = bArr[24];
            this.defaultColorRgba = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.defaultFontFamily = "Serif".equals(new String(bArr, 43, bArr.length + -43)) ? "serif" : "sans-serif";
            this.calculatedVideoTrackHeight = bArr[25] * 20;
            this.customVerticalPlacement = (bArr[0] & 32) != 0;
            if (this.customVerticalPlacement) {
                this.defaultVerticalPlacement = ((float) (((bArr[10] & 255) << 8) | (bArr[11] & 255))) / ((float) this.calculatedVideoTrackHeight);
                this.defaultVerticalPlacement = Util.constrainValue(this.defaultVerticalPlacement, 0.0f, 0.95f);
                return;
            }
            this.defaultVerticalPlacement = 0.85f;
            return;
        }
        this.defaultFontFace = 0;
        this.defaultColorRgba = -1;
        this.defaultFontFamily = "sans-serif";
        this.customVerticalPlacement = false;
        this.defaultVerticalPlacement = 0.85f;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        this.parsableByteArray.reset(bArr, i);
        String readSubtitleText = readSubtitleText(this.parsableByteArray);
        if (readSubtitleText.isEmpty()) {
            return Tx3gSubtitle.EMPTY;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(readSubtitleText);
        attachFontFace(spannableStringBuilder, this.defaultFontFace, 0, 0, spannableStringBuilder.length(), 16711680);
        attachColor(spannableStringBuilder, this.defaultColorRgba, -1, 0, spannableStringBuilder.length(), 16711680);
        attachFontFamily(spannableStringBuilder, this.defaultFontFamily, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f = this.defaultVerticalPlacement;
        while (this.parsableByteArray.bytesLeft() >= 8) {
            int position = this.parsableByteArray.getPosition();
            int readInt = this.parsableByteArray.readInt();
            int readInt2 = this.parsableByteArray.readInt();
            if (readInt2 == TYPE_STYL) {
                assertTrue(this.parsableByteArray.bytesLeft() >= 2);
                int readUnsignedShort = this.parsableByteArray.readUnsignedShort();
                for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                    applyStyleRecord(this.parsableByteArray, spannableStringBuilder);
                }
            } else if (readInt2 == TYPE_TBOX && this.customVerticalPlacement) {
                assertTrue(this.parsableByteArray.bytesLeft() >= 2);
                f = Util.constrainValue(((float) this.parsableByteArray.readUnsignedShort()) / ((float) this.calculatedVideoTrackHeight), 0.0f, 0.95f);
            }
            this.parsableByteArray.setPosition(position + readInt);
        }
        return new Tx3gSubtitle(new Cue(spannableStringBuilder, null, f, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray2) {
        char peekChar;
        assertTrue(parsableByteArray2.bytesLeft() >= 2);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        if (parsableByteArray2.bytesLeft() < 2 || ((peekChar = parsableByteArray2.peekChar()) != 65279 && peekChar != 65534)) {
            return parsableByteArray2.readString(readUnsignedShort, Charset.forName("UTF-8"));
        }
        return parsableByteArray2.readString(readUnsignedShort, Charset.forName("UTF-16"));
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray2, SpannableStringBuilder spannableStringBuilder) {
        assertTrue(parsableByteArray2.bytesLeft() >= 12);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        parsableByteArray2.skipBytes(1);
        int readInt = parsableByteArray2.readInt();
        attachFontFace(spannableStringBuilder, readUnsignedByte, this.defaultFontFace, readUnsignedShort, readUnsignedShort2, 0);
        attachColor(spannableStringBuilder, readInt, this.defaultColorRgba, readUnsignedShort, readUnsignedShort2, 0);
    }

    private static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z3 && !z && !z2) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    private static void attachColor(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(((i & 255) << 24) | (i >>> 8)), i3, i4, i5 | 33);
        }
    }

    private static void attachFontFamily(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    private static void assertTrue(boolean z) {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }
}
