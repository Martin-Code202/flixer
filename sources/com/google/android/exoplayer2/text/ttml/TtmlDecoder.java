package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private final XmlPullParserFactory xmlParserFactory;

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
            this.xmlParserFactory.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public TtmlSubtitle decode(byte[] bArr, int i, boolean z) {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new TtmlRegion(null));
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            TtmlSubtitle ttmlSubtitle = null;
            LinkedList linkedList = new LinkedList();
            int i2 = 0;
            FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) linkedList.peekLast();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRate = parseFrameAndTickRates(newPullParser);
                        }
                        if (!isSupportedTag(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i2++;
                        } else if ("head".equals(name)) {
                            parseHeader(newPullParser, hashMap, hashMap2);
                        } else {
                            try {
                                TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                linkedList.addLast(parseNode);
                                if (ttmlNode != null) {
                                    ttmlNode.addChild(parseNode);
                                }
                            } catch (SubtitleDecoderException e) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e);
                                i2++;
                            }
                        }
                    } else if (eventType == 4) {
                        ttmlNode.addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) linkedList.getLast(), hashMap, hashMap2);
                        }
                        linkedList.removeLast();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            return ttmlSubtitle;
        } catch (XmlPullParserException e2) {
            throw new SubtitleDecoderException("Unable to decode source", e2);
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        }
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) {
        int i = 30;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        }
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(" ");
            if (split.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
        }
        int i2 = DEFAULT_FRAME_AND_TICK_RATE.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = DEFAULT_FRAME_AND_TICK_RATE.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(((float) i) * f, i2, i3);
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        TtmlRegion parseRegionAttributes;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                if (parseStyleAttributes.getId() != null) {
                    map.put(parseStyleAttributes.getId(), parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region") && (parseRegionAttributes = parseRegionAttributes(xmlPullParser)) != null) {
                map2.put(parseRegionAttributes.id, parseRegionAttributes);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
        return map;
    }

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
        if (attributeValue == null) {
            return null;
        }
        String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "origin");
        if (attributeValue2 != null) {
            Matcher matcher = PERCENTAGE_COORDINATES.matcher(attributeValue2);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
                    if (attributeValue3 != null) {
                        Matcher matcher2 = PERCENTAGE_COORDINATES.matcher(attributeValue3);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                int i = 0;
                                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "displayAlign");
                                if (attributeValue4 != null) {
                                    String lowerInvariant = Util.toLowerInvariant(attributeValue4);
                                    char c = 65535;
                                    switch (lowerInvariant.hashCode()) {
                                        case -1364013995:
                                            if (lowerInvariant.equals("center")) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case 92734940:
                                            if (lowerInvariant.equals("after")) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c) {
                                        case 0:
                                            i = 1;
                                            parseFloat2 += parseFloat4 / 2.0f;
                                            break;
                                        case 1:
                                            i = 2;
                                            parseFloat2 += parseFloat4;
                                            break;
                                    }
                                }
                                return new TtmlRegion(attributeValue, parseFloat, parseFloat2, 0, i, parseFloat3);
                            } catch (NumberFormatException e) {
                                Log.w("TtmlDecoder", "Ignoring region with malformed extent: " + attributeValue2);
                                return null;
                            }
                        } else {
                            Log.w("TtmlDecoder", "Ignoring region with unsupported extent: " + attributeValue2);
                            return null;
                        }
                    } else {
                        Log.w("TtmlDecoder", "Ignoring region without an extent");
                        return null;
                    }
                } catch (NumberFormatException e2) {
                    Log.w("TtmlDecoder", "Ignoring region with malformed origin: " + attributeValue2);
                    return null;
                }
            } else {
                Log.w("TtmlDecoder", "Ignoring region with unsupported origin: " + attributeValue2);
                return null;
            }
        } else {
            Log.w("TtmlDecoder", "Ignoring region without an origin");
            return null;
        }
    }

    private String[] parseStyleIds(String str) {
        return str.split("\\s+");
    }

    private TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            char c = 65535;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c = 7;
                        break;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c = 2;
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if ("style".equals(xmlPullParser.getName())) {
                        ttmlStyle = createIfNull(ttmlStyle).setId(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException e) {
                        Log.w("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                case 2:
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException e2) {
                        Log.w("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case 3:
                    ttmlStyle = createIfNull(ttmlStyle).setFontFamily(attributeValue);
                    break;
                case 4:
                    try {
                        ttmlStyle = createIfNull(ttmlStyle);
                        parseFontSize(attributeValue, ttmlStyle);
                        break;
                    } catch (SubtitleDecoderException e3) {
                        Log.w("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case 5:
                    ttmlStyle = createIfNull(ttmlStyle).setBold("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    ttmlStyle = createIfNull(ttmlStyle).setItalic("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    String lowerInvariant = Util.toLowerInvariant(attributeValue);
                    char c2 = 65535;
                    switch (lowerInvariant.hashCode()) {
                        case -1364013995:
                            if (lowerInvariant.equals("center")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 100571:
                            if (lowerInvariant.equals("end")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 3317767:
                            if (lowerInvariant.equals("left")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 108511772:
                            if (lowerInvariant.equals("right")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 109757538:
                            if (lowerInvariant.equals("start")) {
                                c2 = 1;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            continue;
                        case 1:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            continue;
                        case 2:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            continue;
                        case 3:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            continue;
                        case 4:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_CENTER);
                            continue;
                    }
                case '\b':
                    String lowerInvariant2 = Util.toLowerInvariant(attributeValue);
                    char c3 = 65535;
                    switch (lowerInvariant2.hashCode()) {
                        case -1461280213:
                            if (lowerInvariant2.equals("nounderline")) {
                                c3 = 3;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (lowerInvariant2.equals("underline")) {
                                c3 = 2;
                                break;
                            }
                            break;
                        case 913457136:
                            if (lowerInvariant2.equals("nolinethrough")) {
                                c3 = 1;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (lowerInvariant2.equals("linethrough")) {
                                c3 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c3) {
                        case 0:
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(true);
                            continue;
                        case 1:
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(false);
                            continue;
                        case 2:
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(true);
                            continue;
                        case 3:
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(false);
                            continue;
                    }
            }
        }
        return ttmlStyle;
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) {
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        String str = "";
        String[] strArr = null;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, null);
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            char c = 65535;
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c = 4;
                        break;
                    }
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 2;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 1;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 0;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    j2 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case 1:
                    j3 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case 2:
                    j = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case 3:
                    String[] parseStyleIds = parseStyleIds(attributeValue);
                    if (parseStyleIds.length > 0) {
                        strArr = parseStyleIds;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        break;
                    } else {
                        break;
                    }
            }
        }
        if (!(ttmlNode == null || ttmlNode.startTimeUs == -9223372036854775807L)) {
            if (j2 != -9223372036854775807L) {
                j2 += ttmlNode.startTimeUs;
            }
            if (j3 != -9223372036854775807L) {
                j3 += ttmlNode.startTimeUs;
            }
        }
        if (j3 == -9223372036854775807L) {
            if (j != -9223372036854775807L) {
                j3 = j2 + j;
            } else if (!(ttmlNode == null || ttmlNode.endTimeUs == -9223372036854775807L)) {
                j3 = ttmlNode.endTimeUs;
            }
        }
        return TtmlNode.buildNode(xmlPullParser.getName(), j2, j3, parseStyleAttributes, strArr, str);
    }

    private static boolean isSupportedTag(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            char c = 65535;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    ttmlStyle.setFontSizeUnit(1);
                    break;
                case 1:
                    ttmlStyle.setFontSizeUnit(2);
                    break;
                case 2:
                    ttmlStyle.setFontSizeUnit(3);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
            }
            ttmlStyle.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) {
        Matcher matcher = CLOCK_TIME.matcher(str);
        if (matcher.matches()) {
            double parseLong = ((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60)) + ((double) Long.parseLong(matcher.group(3)));
            String group = matcher.group(4);
            double parseDouble = parseLong + (group != null ? Double.parseDouble(group) : 0.0d);
            String group2 = matcher.group(5);
            double parseLong2 = parseDouble + (group2 != null ? (double) (((float) Long.parseLong(group2)) / frameAndTickRate.effectiveFrameRate) : 0.0d);
            String group3 = matcher.group(6);
            return (long) (1000000.0d * (parseLong2 + (group3 != null ? (((double) Long.parseLong(group3)) / ((double) frameAndTickRate.subFrameRate)) / ((double) frameAndTickRate.effectiveFrameRate) : 0.0d)));
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (matcher2.matches()) {
            double parseDouble2 = Double.parseDouble(matcher2.group(1));
            String group4 = matcher2.group(2);
            char c = 65535;
            switch (group4.hashCode()) {
                case 102:
                    if (group4.equals("f")) {
                        c = 4;
                        break;
                    }
                    break;
                case 104:
                    if (group4.equals("h")) {
                        c = 0;
                        break;
                    }
                    break;
                case 109:
                    if (group4.equals("m")) {
                        c = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group4.equals("s")) {
                        c = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group4.equals("t")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group4.equals("ms")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    parseDouble2 *= 3600.0d;
                    break;
                case 1:
                    parseDouble2 *= 60.0d;
                    break;
                case 3:
                    parseDouble2 /= 1000.0d;
                    break;
                case 4:
                    parseDouble2 /= (double) frameAndTickRate.effectiveFrameRate;
                    break;
                case 5:
                    parseDouble2 /= (double) frameAndTickRate.tickRate;
                    break;
            }
            return (long) (1000000.0d * parseDouble2);
        }
        throw new SubtitleDecoderException("Malformed time expression: " + str);
    }

    /* access modifiers changed from: package-private */
    public static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }
}
