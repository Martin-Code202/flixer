package com.google.android.exoplayer2.mediacodec;
public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new MediaCodecSelector() { // from class: com.google.android.exoplayer2.mediacodec.MediaCodecSelector.1
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public MediaCodecInfo getDecoderInfo(String str, boolean z) {
            return MediaCodecUtil.getDecoderInfo(str, z);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public MediaCodecInfo getPassthroughDecoderInfo() {
            return MediaCodecUtil.getPassthroughDecoderInfo();
        }
    };

    MediaCodecInfo getDecoderInfo(String str, boolean z);

    MediaCodecInfo getPassthroughDecoderInfo();
}
