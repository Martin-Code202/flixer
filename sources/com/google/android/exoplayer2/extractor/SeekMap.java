package com.google.android.exoplayer2.extractor;
public interface SeekMap {

    public static final class Unseekable implements SeekMap {
        private final long durationUs;

        public Unseekable(long j) {
            this.durationUs = j;
        }
    }
}
