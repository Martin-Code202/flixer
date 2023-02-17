package org.linphone.mediastream;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
@TargetApi(16)
public class AACFilter {
    private static AACFilter singleton;
    int bitrate;
    int channelCount;
    MediaCodec decoder;
    MediaCodec.BufferInfo decoderBufferInfo;
    ByteBuffer[] decoderInputBuffers;
    ByteBuffer[] decoderOutputBuffers;
    MediaCodec encoder;
    MediaCodec.BufferInfo encoderBufferInfo;
    ByteBuffer[] encoderInputBuffers;
    ByteBuffer[] encoderOutputBuffers;
    boolean initialized = false;
    int sampleRate;

    public static AACFilter instance() {
        if (singleton == null) {
            singleton = new AACFilter();
        }
        return singleton;
    }

    public boolean preprocess(int i, int i2, int i3, boolean z) {
        MediaFormat mediaFormat;
        if (this.initialized) {
            return true;
        }
        this.sampleRate = i;
        this.channelCount = i2;
        this.bitrate = i3;
        byte[] bArr = null;
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
            createAudioFormat.setInteger("aac-profile", 39);
            createAudioFormat.setInteger("bitrate", i3);
            this.encoder = MediaCodec.createByCodecName("OMX.google.aac.encoder");
            this.encoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.encoder.start();
            this.encoderBufferInfo = new MediaCodec.BufferInfo();
            int i4 = 0;
            while (bArr == null && i4 < 1000) {
                int dequeueOutputBuffer = this.encoder.dequeueOutputBuffer(this.encoderBufferInfo, 0);
                if (dequeueOutputBuffer >= 0 && this.encoderBufferInfo.flags == 2) {
                    bArr = new byte[this.encoderBufferInfo.size];
                    this.encoder.getOutputBuffers()[dequeueOutputBuffer].get(bArr, 0, this.encoderBufferInfo.size);
                    this.encoder.getOutputBuffers()[dequeueOutputBuffer].position(0);
                    this.encoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
                i4++;
            }
            this.encoderOutputBuffers = this.encoder.getOutputBuffers();
            this.encoderInputBuffers = this.encoder.getInputBuffers();
            if (bArr == null) {
                Log.e("Sigh, failed to read asc from encoder");
            }
            Log.i("AAC encoder initialized");
            if (bArr != null) {
                try {
                    mediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 0, 0);
                    mediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
                } catch (Exception e) {
                    Log.e(e, "Unable to create AAC Decoder");
                    return false;
                }
            } else {
                mediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
                mediaFormat.setInteger("bitrate", i3);
            }
            this.decoder = MediaCodec.createByCodecName("OMX.google.aac.decoder");
            this.decoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            this.decoder.start();
            this.decoderOutputBuffers = this.decoder.getOutputBuffers();
            this.decoderInputBuffers = this.decoder.getInputBuffers();
            this.decoderBufferInfo = new MediaCodec.BufferInfo();
            Log.i("AAC decoder initialized");
            this.initialized = true;
            return true;
        } catch (Exception e2) {
            Log.e(e2, "Unable to create AAC Encoder");
            return false;
        }
    }

    public boolean pushToDecoder(byte[] bArr, int i) {
        if (bArr == null) {
            return false;
        }
        try {
            if (this.decoder != null) {
                return queueData(this.decoder, this.decoderInputBuffers, bArr, i);
            }
            return false;
        } catch (Exception e) {
            Log.e(e, "Push to decoder failed");
            return false;
        }
    }

    public int pullFromDecoder(byte[] bArr) {
        try {
            int dequeueData = dequeueData(this.decoder, this.decoderOutputBuffers, this.decoderBufferInfo, bArr);
            if (dequeueData != -3) {
                return dequeueData;
            }
            this.decoderOutputBuffers = this.decoder.getOutputBuffers();
            return pullFromDecoder(bArr);
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean pushToEncoder(byte[] bArr, int i) {
        if (bArr == null) {
            return false;
        }
        try {
            if (this.encoder != null) {
                return queueData(this.encoder, this.encoderInputBuffers, bArr, i);
            }
            return false;
        } catch (Exception e) {
            Log.e(e, "Push to encoder failed");
            return false;
        }
    }

    public int pullFromEncoder(byte[] bArr) {
        try {
            int dequeueData = dequeueData(this.encoder, this.encoderOutputBuffers, this.encoderBufferInfo, bArr);
            if (dequeueData != -3) {
                return dequeueData;
            }
            this.encoderOutputBuffers = this.encoder.getOutputBuffers();
            return pullFromDecoder(bArr);
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean postprocess() {
        if (!this.initialized) {
            return true;
        }
        this.encoder.flush();
        Log.i("Stopping encoder");
        this.encoder.stop();
        Log.i("Stopping decoder");
        this.decoder.flush();
        this.decoder.stop();
        Log.i("Release encoder");
        this.encoder.release();
        Log.i("Release decoder");
        this.decoder.release();
        this.encoder = null;
        this.decoder = null;
        this.initialized = false;
        return true;
    }

    private static boolean queueData(MediaCodec mediaCodec, ByteBuffer[] byteBufferArr, byte[] bArr, int i) {
        int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0);
        if (dequeueInputBuffer < 0) {
            return false;
        }
        byteBufferArr[dequeueInputBuffer].position(0);
        byteBufferArr[dequeueInputBuffer].put(bArr, 0, i);
        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, 0, 0);
        return true;
    }

    private static int dequeueData(MediaCodec mediaCodec, ByteBuffer[] byteBufferArr, MediaCodec.BufferInfo bufferInfo, byte[] bArr) {
        for (int i = 0; i < 1; i++) {
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 100);
            if (dequeueOutputBuffer >= 0) {
                if (bArr.length < bufferInfo.size) {
                    Log.e("array is too small " + bArr.length + " < " + bufferInfo.size);
                }
                if (bufferInfo.flags == 2) {
                    Log.i("JUST READ MediaCodec.BUFFER_FLAG_CODEC_CONFIG buffer");
                }
                byteBufferArr[dequeueOutputBuffer].get(bArr, 0, bufferInfo.size);
                byteBufferArr[dequeueOutputBuffer].position(0);
                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                return bufferInfo.size;
            } else if (dequeueOutputBuffer == -3) {
                return -3;
            } else {
                if (dequeueOutputBuffer == -2) {
                    Log.i("MediaCodec.INFO_OUTPUT_FORMAT_CHANGED");
                    Log.i("CHANNEL_COUNT: " + mediaCodec.getOutputFormat().getInteger("channel-count"));
                    Log.i("SAMPLE_RATE: " + mediaCodec.getOutputFormat().getInteger("sample-rate"));
                }
            }
        }
        return 0;
    }
}
