package com.google.android.exoplayer2.text;
final class SimpleSubtitleOutputBuffer extends SubtitleOutputBuffer {
    private final SimpleSubtitleDecoder owner;

    public SimpleSubtitleOutputBuffer(SimpleSubtitleDecoder simpleSubtitleDecoder) {
        this.owner = simpleSubtitleDecoder;
    }

    @Override // com.google.android.exoplayer2.text.SubtitleOutputBuffer
    public final void release() {
        this.owner.releaseOutputBuffer((SubtitleOutputBuffer) this);
    }
}
