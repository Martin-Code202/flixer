package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private final MetadataInputBuffer buffer;
    private MetadataDecoder decoder;
    private final MetadataDecoderFactory decoderFactory;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private final Output output;
    private final Handler outputHandler;
    private final Metadata[] pendingMetadata;
    private int pendingMetadataCount;
    private int pendingMetadataIndex;
    private final long[] pendingMetadataTimestamps;

    public interface Output {
        void onMetadata(Metadata metadata);
    }

    public MetadataRenderer(Output output2, Looper looper) {
        this(output2, looper, MetadataDecoderFactory.DEFAULT);
    }

    public MetadataRenderer(Output output2, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(4);
        this.output = (Output) Assertions.checkNotNull(output2);
        this.outputHandler = looper == null ? null : new Handler(looper, this);
        this.decoderFactory = (MetadataDecoderFactory) Assertions.checkNotNull(metadataDecoderFactory);
        this.formatHolder = new FormatHolder();
        this.buffer = new MetadataInputBuffer();
        this.pendingMetadata = new Metadata[5];
        this.pendingMetadataTimestamps = new long[5];
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        return this.decoderFactory.supportsFormat(format) ? 4 : 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j) {
        this.decoder = this.decoderFactory.createDecoder(formatArr[0]);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        flushPendingMetadata();
        this.inputStreamEnded = false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        if (!this.inputStreamEnded && this.pendingMetadataCount < 5) {
            this.buffer.clear();
            if (readSource(this.formatHolder, this.buffer, false) == -4) {
                if (this.buffer.isEndOfStream()) {
                    this.inputStreamEnded = true;
                } else if (!this.buffer.isDecodeOnly()) {
                    this.buffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                    this.buffer.flip();
                    try {
                        int i = (this.pendingMetadataIndex + this.pendingMetadataCount) % 5;
                        this.pendingMetadata[i] = this.decoder.decode(this.buffer);
                        this.pendingMetadataTimestamps[i] = this.buffer.timeUs;
                        this.pendingMetadataCount++;
                    } catch (MetadataDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
            }
        }
        if (this.pendingMetadataCount > 0 && this.pendingMetadataTimestamps[this.pendingMetadataIndex] <= j) {
            invokeRenderer(this.pendingMetadata[this.pendingMetadataIndex]);
            this.pendingMetadata[this.pendingMetadataIndex] = null;
            this.pendingMetadataIndex = (this.pendingMetadataIndex + 1) % 5;
            this.pendingMetadataCount--;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        flushPendingMetadata();
        this.decoder = null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.inputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    private void invokeRenderer(Metadata metadata) {
        if (this.outputHandler != null) {
            this.outputHandler.obtainMessage(0, metadata).sendToTarget();
        } else {
            invokeRendererInternal(metadata);
        }
    }

    private void flushPendingMetadata() {
        Arrays.fill(this.pendingMetadata, (Object) null);
        this.pendingMetadataIndex = 0;
        this.pendingMetadataCount = 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                invokeRendererInternal((Metadata) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void invokeRendererInternal(Metadata metadata) {
        this.output.onMetadata(metadata);
    }
}
