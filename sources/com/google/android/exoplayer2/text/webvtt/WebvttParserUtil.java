package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.regex.Pattern;
public final class WebvttParserUtil {
    private static final Pattern COMMENT = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern HEADER = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static void validateWebvttHeaderLine(ParsableByteArray parsableByteArray) {
        String readLine = parsableByteArray.readLine();
        if (readLine == null || !HEADER.matcher(readLine).matches()) {
            throw new SubtitleDecoderException("Expected WEBVTT. Got " + readLine);
        }
    }

    public static long parseTimestampUs(String str) {
        long j = 0;
        String[] split = str.split("\\.", 2);
        for (String str2 : split[0].split(":")) {
            j = (60 * j) + Long.parseLong(str2);
        }
        return ((1000 * j) + Long.parseLong(split[1])) * 1000;
    }

    public static float parsePercentage(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
