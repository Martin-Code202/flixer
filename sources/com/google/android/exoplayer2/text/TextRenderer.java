package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private SubtitleDecoder decoder;
    private final SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private SubtitleInputBuffer nextInputBuffer;
    private SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final Output output;
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private Format streamFormat;
    private SubtitleOutputBuffer subtitle;

    public interface Output {
        void onCues(List<Cue> list);
    }

    public TextRenderer(Output output2, Looper looper) {
        this(output2, looper, SubtitleDecoderFactory.DEFAULT);
    }

    public TextRenderer(Output output2, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.output = (Output) Assertions.checkNotNull(output2);
        this.outputHandler = looper == null ? null : new Handler(looper, this);
        this.decoderFactory = subtitleDecoderFactory;
        this.formatHolder = new FormatHolder();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        if (this.decoderFactory.supportsFormat(format)) {
            return 4;
        }
        return MimeTypes.isText(format.sampleMimeType) ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j) {
        this.streamFormat = formatArr[0];
        if (this.decoder != null) {
            this.decoderReplacementState = 1;
        } else {
            this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoderReplacementState != 0) {
            replaceDecoder();
            return;
        }
        releaseBuffers();
        this.decoder.flush();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        if (!this.outputStreamEnded) {
            if (this.nextSubtitle == null) {
                this.decoder.setPositionUs(j);
                try {
                    this.nextSubtitle = (SubtitleOutputBuffer) this.decoder.dequeueOutputBuffer();
                } catch (SubtitleDecoderException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            }
            if (getState() == 2) {
                boolean z = false;
                if (this.subtitle != null) {
                    long nextEventTime = getNextEventTime();
                    while (nextEventTime <= j) {
                        this.nextSubtitleEventIndex++;
                        nextEventTime = getNextEventTime();
                        z = true;
                    }
                }
                if (this.nextSubtitle != null) {
                    if (this.nextSubtitle.isEndOfStream()) {
                        if (!z && getNextEventTime() == Long.MAX_VALUE) {
                            if (this.decoderReplacementState == 2) {
                                replaceDecoder();
                            } else {
                                releaseBuffers();
                                this.outputStreamEnded = true;
                            }
                        }
                    } else if (this.nextSubtitle.timeUs <= j) {
                        if (this.subtitle != null) {
                            this.subtitle.release();
                        }
                        this.subtitle = this.nextSubtitle;
                        this.nextSubtitle = null;
                        this.nextSubtitleEventIndex = this.subtitle.getNextEventTimeIndex(j);
                        z = true;
                    }
                }
                if (z) {
                    updateOutput(this.subtitle.getCues(j));
                }
                if (this.decoderReplacementState != 2) {
                    while (!this.inputStreamEnded) {
                        try {
                            if (this.nextInputBuffer == null) {
                                this.nextInputBuffer = (SubtitleInputBuffer) this.decoder.dequeueInputBuffer();
                                if (this.nextInputBuffer == null) {
                                    return;
                                }
                            }
                            if (this.decoderReplacementState == 1) {
                                this.nextInputBuffer.setFlags(4);
                                this.decoder.queueInputBuffer(this.nextInputBuffer);
                                this.nextInputBuffer = null;
                                this.decoderReplacementState = 2;
                                return;
                            }
                            int readSource = readSource(this.formatHolder, this.nextInputBuffer, false);
                            if (readSource == -4) {
                                if (this.nextInputBuffer.isEndOfStream()) {
                                    this.inputStreamEnded = true;
                                } else {
                                    this.nextInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                                    this.nextInputBuffer.flip();
                                }
                                this.decoder.queueInputBuffer(this.nextInputBuffer);
                                this.nextInputBuffer = null;
                            } else if (readSource == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e2) {
                            throw ExoPlaybackException.createForRenderer(e2, getIndex());
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.streamFormat = null;
        clearOutput();
        releaseDecoder();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    private void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        if (this.subtitle != null) {
            this.subtitle.release();
            this.subtitle = null;
        }
        if (this.nextSubtitle != null) {
            this.nextSubtitle.release();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        releaseBuffers();
        this.decoder.release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private void replaceDecoder() {
        releaseDecoder();
        this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
    }

    private long getNextEventTime() {
        if (this.nextSubtitleEventIndex == -1 || this.nextSubtitleEventIndex >= this.subtitle.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
    }

    private void updateOutput(List<Cue> list) {
        if (this.outputHandler != null) {
            this.outputHandler.obtainMessage(0, list).sendToTarget();
        } else {
            invokeUpdateOutputInternal(list);
        }
    }

    private void clearOutput() {
        updateOutput(Collections.emptyList());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                invokeUpdateOutputInternal((List) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void invokeUpdateOutputInternal(List<Cue> list) {
        this.output.onCues(list);
    }
}
