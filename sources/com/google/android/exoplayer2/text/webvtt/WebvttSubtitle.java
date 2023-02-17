package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* access modifiers changed from: package-private */
public final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs = new long[(this.numCues * 2)];
    private final List<WebvttCue> cues;
    private final int numCues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCue> list) {
        this.cues = list;
        this.numCues = list.size();
        for (int i = 0; i < this.numCues; i++) {
            WebvttCue webvttCue = list.get(i);
            int i2 = i * 2;
            this.cueTimesUs[i2] = webvttCue.startTime;
            this.cueTimesUs[i2 + 1] = webvttCue.endTime;
        }
        this.sortedCueTimesUs = Arrays.copyOf(this.cueTimesUs, this.cueTimesUs.length);
        Arrays.sort(this.sortedCueTimesUs);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, j, false, false);
        if (binarySearchCeil < this.sortedCueTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i >= 0);
        Assertions.checkArgument(i < this.sortedCueTimesUs.length);
        return this.sortedCueTimesUs[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        ArrayList arrayList = null;
        WebvttCue webvttCue = null;
        SpannableStringBuilder spannableStringBuilder = null;
        for (int i = 0; i < this.numCues; i++) {
            if (this.cueTimesUs[i * 2] <= j && j < this.cueTimesUs[(i * 2) + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                WebvttCue webvttCue2 = this.cues.get(i);
                if (!webvttCue2.isNormalCue()) {
                    arrayList.add(webvttCue2);
                } else if (webvttCue == null) {
                    webvttCue = webvttCue2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(webvttCue.text).append((CharSequence) "\n").append(webvttCue2.text);
                } else {
                    spannableStringBuilder.append((CharSequence) "\n").append(webvttCue2.text);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new WebvttCue(spannableStringBuilder));
        } else if (webvttCue != null) {
            arrayList.add(webvttCue);
        }
        if (arrayList != null) {
            return arrayList;
        }
        return Collections.emptyList();
    }
}
