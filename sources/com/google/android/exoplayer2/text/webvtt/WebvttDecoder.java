package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttCue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;
public final class WebvttDecoder extends SimpleSubtitleDecoder {
    private final CssParser cssParser = new CssParser();
    private final WebvttCueParser cueParser = new WebvttCueParser();
    private final List<WebvttCssStyle> definedStyles = new ArrayList();
    private final ParsableByteArray parsableWebvttData = new ParsableByteArray();
    private final WebvttCue.Builder webvttCueBuilder = new WebvttCue.Builder();

    public WebvttDecoder() {
        super("WebvttDecoder");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public WebvttSubtitle decode(byte[] bArr, int i, boolean z) {
        this.parsableWebvttData.reset(bArr, i);
        this.webvttCueBuilder.reset();
        this.definedStyles.clear();
        WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
        do {
        } while (!TextUtils.isEmpty(this.parsableWebvttData.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int nextEvent = getNextEvent(this.parsableWebvttData);
            if (nextEvent == 0) {
                return new WebvttSubtitle(arrayList);
            }
            if (nextEvent == 1) {
                skipComment(this.parsableWebvttData);
            } else if (nextEvent == 2) {
                if (!arrayList.isEmpty()) {
                    throw new SubtitleDecoderException("A style block was found after the first cue.");
                }
                this.parsableWebvttData.readLine();
                WebvttCssStyle parseBlock = this.cssParser.parseBlock(this.parsableWebvttData);
                if (parseBlock != null) {
                    this.definedStyles.add(parseBlock);
                }
            } else if (nextEvent == 3 && this.cueParser.parseCue(this.parsableWebvttData, this.webvttCueBuilder, this.definedStyles)) {
                arrayList.add(this.webvttCueBuilder.build());
                this.webvttCueBuilder.reset();
            }
        }
    }

    private static int getNextEvent(ParsableByteArray parsableByteArray) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = parsableByteArray.getPosition();
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                i = 0;
            } else if ("STYLE".equals(readLine)) {
                i = 2;
            } else if ("NOTE".startsWith(readLine)) {
                i = 1;
            } else {
                i = 3;
            }
        }
        parsableByteArray.setPosition(i2);
        return i;
    }

    private static void skipComment(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
    }
}
