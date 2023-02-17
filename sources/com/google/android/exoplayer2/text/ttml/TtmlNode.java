package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/* access modifiers changed from: package-private */
public final class TtmlNode {
    private List<TtmlNode> children;
    public final long endTimeUs;
    public final boolean isTextNode;
    private final HashMap<String, Integer> nodeEndsByRegion;
    private final HashMap<String, Integer> nodeStartsByRegion;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    public static TtmlNode buildTextNode(String str) {
        return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(str), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    public static TtmlNode buildNode(String str, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str2) {
        return new TtmlNode(str, null, j, j2, ttmlStyle, strArr, str2);
    }

    private TtmlNode(String str, String str2, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str3) {
        this.tag = str;
        this.text = str2;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        this.isTextNode = str2 != null;
        this.startTimeUs = j;
        this.endTimeUs = j2;
        this.regionId = (String) Assertions.checkNotNull(str3);
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    public boolean isActive(long j) {
        return (this.startTimeUs == -9223372036854775807L && this.endTimeUs == -9223372036854775807L) || (this.startTimeUs <= j && this.endTimeUs == -9223372036854775807L) || ((this.startTimeUs == -9223372036854775807L && j < this.endTimeUs) || (this.startTimeUs <= j && j < this.endTimeUs));
    }

    public void addChild(TtmlNode ttmlNode) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(ttmlNode);
    }

    public TtmlNode getChild(int i) {
        if (this.children != null) {
            return this.children.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getChildCount() {
        if (this.children == null) {
            return 0;
        }
        return this.children.size();
    }

    public long[] getEventTimesUs() {
        TreeSet<Long> treeSet = new TreeSet<>();
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        int i = 0;
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            i++;
            jArr[i] = it.next().longValue();
        }
        return jArr;
    }

    private void getEventTimes(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.tag);
        if (z || equals) {
            if (this.startTimeUs != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.startTimeUs));
            }
            if (this.endTimeUs != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.endTimeUs));
            }
        }
        if (this.children != null) {
            for (int i = 0; i < this.children.size(); i++) {
                this.children.get(i).getEventTimes(treeSet, z || equals);
            }
        }
    }

    public List<Cue> getCues(long j, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        TreeMap treeMap = new TreeMap();
        traverseForText(j, false, this.regionId, treeMap);
        traverseForStyle(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion = map2.get(entry.getKey());
            arrayList.add(new Cue(cleanUpText((SpannableStringBuilder) entry.getValue()), null, ttmlRegion.line, ttmlRegion.lineType, ttmlRegion.lineAnchor, ttmlRegion.position, Integer.MIN_VALUE, ttmlRegion.width));
        }
        return arrayList;
    }

    private void traverseForText(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        String str2 = this.regionId;
        if ("".equals(str2)) {
            str2 = str;
        }
        if (this.isTextNode && z) {
            getRegionOutput(str2, map).append((CharSequence) this.text);
        } else if ("br".equals(this.tag) && z) {
            getRegionOutput(str2, map).append('\n');
        } else if (!"metadata".equals(this.tag) && isActive(j)) {
            boolean equals = "p".equals(this.tag);
            for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                this.nodeStartsByRegion.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChild(i).traverseForText(j, z || equals, str2, map);
            }
            if (equals) {
                TtmlRenderUtil.endParagraph(getRegionOutput(str2, map));
            }
            for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                this.nodeEndsByRegion.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
            }
        }
    }

    private static SpannableStringBuilder getRegionOutput(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    private void traverseForStyle(Map<String, TtmlStyle> map, Map<String, SpannableStringBuilder> map2) {
        for (Map.Entry<String, Integer> entry : this.nodeEndsByRegion.entrySet()) {
            String key = entry.getKey();
            applyStyleToOutput(map, map2.get(key), this.nodeStartsByRegion.containsKey(key) ? this.nodeStartsByRegion.get(key).intValue() : 0, entry.getValue().intValue());
            for (int i = 0; i < getChildCount(); i++) {
                getChild(i).traverseForStyle(map, map2);
            }
        }
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        TtmlStyle resolveStyle;
        if (i != i2 && (resolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map)) != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder, i, i2, resolveStyle);
        }
    }

    private SpannableStringBuilder cleanUpText(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        for (int i = 0; i < length; i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                while (i2 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i2) == ' ') {
                    i2++;
                }
                int i3 = i2 - (i + 1);
                if (i3 > 0) {
                    spannableStringBuilder.delete(i, i + i3);
                    length -= i3;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        for (int i4 = 0; i4 < length - 1; i4++) {
            if (spannableStringBuilder.charAt(i4) == '\n' && spannableStringBuilder.charAt(i4 + 1) == ' ') {
                spannableStringBuilder.delete(i4 + 1, i4 + 2);
                length--;
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(length - 1) == ' ') {
            spannableStringBuilder.delete(length - 1, length);
            length--;
        }
        for (int i5 = 0; i5 < length - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == ' ' && spannableStringBuilder.charAt(i5 + 1) == '\n') {
                spannableStringBuilder.delete(i5, i5 + 1);
                length--;
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(length - 1) == '\n') {
            spannableStringBuilder.delete(length - 1, length);
        }
        return spannableStringBuilder;
    }
}
