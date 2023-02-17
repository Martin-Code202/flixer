package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
final class ResamplingAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer = EMPTY_BUFFER;
    private int channelCount = -1;
    private int encoding = 0;
    private boolean inputEnded;
    private ByteBuffer outputBuffer = EMPTY_BUFFER;
    private int sampleRateHz = -1;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i, int i2, int i3) {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        } else if (this.sampleRateHz == i && this.channelCount == i2 && this.encoding == i3) {
            return false;
        } else {
            this.sampleRateHz = i;
            this.channelCount = i2;
            this.encoding = i3;
            if (i3 != 2) {
                return true;
            }
            this.buffer = EMPTY_BUFFER;
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return (this.encoding == 0 || this.encoding == 2) ? false : true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        return this.channelCount;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        switch (this.encoding) {
            case Integer.MIN_VALUE:
                i = (i2 / 3) * 2;
                break;
            case -1:
            case 0:
            case 2:
            default:
                throw new IllegalStateException();
            case 3:
                i = i2 * 2;
                break;
            case 1073741824:
                i = i2 / 2;
                break;
        }
        if (this.buffer.capacity() < i) {
            this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        switch (this.encoding) {
            case Integer.MIN_VALUE:
                for (int i3 = position; i3 < limit; i3 += 3) {
                    this.buffer.put(byteBuffer.get(i3 + 1));
                    this.buffer.put(byteBuffer.get(i3 + 2));
                }
                break;
            case -1:
            case 0:
            case 2:
            default:
                throw new IllegalStateException();
            case 3:
                for (int i4 = position; i4 < limit; i4++) {
                    this.buffer.put((byte) 0);
                    this.buffer.put((byte) ((byteBuffer.get(i4) & 255) - 128));
                }
                break;
            case 1073741824:
                for (int i5 = position; i5 < limit; i5 += 4) {
                    this.buffer.put(byteBuffer.get(i5 + 2));
                    this.buffer.put(byteBuffer.get(i5 + 3));
                }
                break;
        }
        byteBuffer.position(byteBuffer.limit());
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.inputEnded = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.inputEnded && this.outputBuffer == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.outputBuffer = EMPTY_BUFFER;
        this.inputEnded = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.sampleRateHz = -1;
        this.channelCount = -1;
        this.encoding = 0;
    }
}
