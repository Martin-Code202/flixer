package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private int formatEndIndex;
    private int formatKeyCount;
    private int formatStartIndex;
    private int formatTextIndex;
    private final boolean haveInitializationData;

    public SsaDecoder() {
        this(null);
    }

    public SsaDecoder(List<byte[]> list) {
        super("SsaDecoder");
        if (list != null) {
            this.haveInitializationData = true;
            String str = new String(list.get(0));
            Assertions.checkArgument(str.startsWith("Format: "));
            parseFormatLine(str);
            parseHeader(new ParsableByteArray(list.get(1)));
            return;
        }
        this.haveInitializationData = false;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public SsaSubtitle decode(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray);
        }
        parseEventBody(parsableByteArray, arrayList, longArray);
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SsaSubtitle(cueArr, longArray.toArray());
    }

    private void parseHeader(ParsableByteArray parsableByteArray) {
        String readLine;
        do {
            readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
        } while (!readLine.startsWith("[Events]"));
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List<Cue> list, LongArray longArray) {
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (!this.haveInitializationData && readLine.startsWith("Format: ")) {
                parseFormatLine(readLine);
            } else if (readLine.startsWith("Dialogue: ")) {
                parseDialogueLine(readLine, list, longArray);
            }
        }
    }

    private void parseFormatLine(String str) {
        String[] split = TextUtils.split(str.substring("Format: ".length()), ",");
        this.formatKeyCount = split.length;
        this.formatStartIndex = -1;
        this.formatEndIndex = -1;
        this.formatTextIndex = -1;
        for (int i = 0; i < this.formatKeyCount; i++) {
            String lowerInvariant = Util.toLowerInvariant(split[i].trim());
            char c = 65535;
            switch (lowerInvariant.hashCode()) {
                case 100571:
                    if (lowerInvariant.equals("end")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3556653:
                    if (lowerInvariant.equals("text")) {
                        c = 2;
                        break;
                    }
                    break;
                case 109757538:
                    if (lowerInvariant.equals("start")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.formatStartIndex = i;
                    break;
                case 1:
                    this.formatEndIndex = i;
                    break;
                case 2:
                    this.formatTextIndex = i;
                    break;
            }
        }
    }

    private void parseDialogueLine(String str, List<Cue> list, LongArray longArray) {
        if (this.formatKeyCount == 0) {
            Log.w("SsaDecoder", "Skipping dialogue line before format: " + str);
            return;
        }
        String[] split = str.substring("Dialogue: ".length()).split(",", this.formatKeyCount);
        long parseTimecodeUs = parseTimecodeUs(split[this.formatStartIndex]);
        if (parseTimecodeUs == -9223372036854775807L) {
            Log.w("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long j = -9223372036854775807L;
        String str2 = split[this.formatEndIndex];
        if (!str2.trim().isEmpty()) {
            j = parseTimecodeUs(str2);
            if (j == -9223372036854775807L) {
                Log.w("SsaDecoder", "Skipping invalid timing: " + str);
                return;
            }
        }
        list.add(new Cue(split[this.formatTextIndex].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
        longArray.add(parseTimecodeUs);
        if (j != -9223372036854775807L) {
            list.add(null);
            longArray.add(j);
        }
    }

    public static long parseTimecodeUs(String str) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }
}
