package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;
final class Sonic {
    private final short[] downSampleBuffer = new short[this.maxRequired];
    private short[] inputBuffer;
    private int inputBufferSize = this.maxRequired;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequired = (this.maxPeriod * 2);
    private int minDiff;
    private final int minPeriod;
    private int newRatePosition;
    private final int numChannels;
    private int numInputSamples;
    private int numOutputSamples;
    private int numPitchSamples;
    private int oldRatePosition;
    private short[] outputBuffer;
    private int outputBufferSize;
    private float pitch;
    private short[] pitchBuffer;
    private int pitchBufferSize;
    private int prevMinDiff;
    private int prevPeriod;
    private int remainingInputToCopy;
    private final int sampleRate;
    private float speed;

    public Sonic(int i, int i2) {
        this.sampleRate = i;
        this.numChannels = i2;
        this.minPeriod = i / 400;
        this.maxPeriod = i / 65;
        this.inputBuffer = new short[(this.maxRequired * i2)];
        this.outputBufferSize = this.maxRequired;
        this.outputBuffer = new short[(this.maxRequired * i2)];
        this.pitchBufferSize = this.maxRequired;
        this.pitchBuffer = new short[(this.maxRequired * i2)];
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.prevPeriod = 0;
        this.speed = 1.0f;
        this.pitch = 1.0f;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public void setPitch(float f) {
        this.pitch = f;
    }

    public void queueInput(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.numChannels;
        int i = this.numChannels * remaining * 2;
        enlargeInputBufferIfNeeded(remaining);
        shortBuffer.get(this.inputBuffer, this.numInputSamples * this.numChannels, i / 2);
        this.numInputSamples += remaining;
        processStreamInput();
    }

    public void getOutput(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.numChannels, this.numOutputSamples);
        shortBuffer.put(this.outputBuffer, 0, this.numChannels * min);
        this.numOutputSamples -= min;
        System.arraycopy(this.outputBuffer, this.numChannels * min, this.outputBuffer, 0, this.numOutputSamples * this.numChannels);
    }

    public void queueEndOfStream() {
        int i = this.numInputSamples;
        int i2 = this.numOutputSamples + ((int) ((((((float) i) / (this.speed / this.pitch)) + ((float) this.numPitchSamples)) / this.pitch) + 0.5f));
        enlargeInputBufferIfNeeded((this.maxRequired * 2) + i);
        for (int i3 = 0; i3 < this.maxRequired * 2 * this.numChannels; i3++) {
            this.inputBuffer[(this.numChannels * i) + i3] = 0;
        }
        this.numInputSamples += this.maxRequired * 2;
        processStreamInput();
        if (this.numOutputSamples > i2) {
            this.numOutputSamples = i2;
        }
        this.numInputSamples = 0;
        this.remainingInputToCopy = 0;
        this.numPitchSamples = 0;
    }

    public int getSamplesAvailable() {
        return this.numOutputSamples;
    }

    private void enlargeOutputBufferIfNeeded(int i) {
        if (this.numOutputSamples + i > this.outputBufferSize) {
            this.outputBufferSize += (this.outputBufferSize / 2) + i;
            this.outputBuffer = Arrays.copyOf(this.outputBuffer, this.outputBufferSize * this.numChannels);
        }
    }

    private void enlargeInputBufferIfNeeded(int i) {
        if (this.numInputSamples + i > this.inputBufferSize) {
            this.inputBufferSize += (this.inputBufferSize / 2) + i;
            this.inputBuffer = Arrays.copyOf(this.inputBuffer, this.inputBufferSize * this.numChannels);
        }
    }

    private void removeProcessedInputSamples(int i) {
        int i2 = this.numInputSamples - i;
        System.arraycopy(this.inputBuffer, this.numChannels * i, this.inputBuffer, 0, this.numChannels * i2);
        this.numInputSamples = i2;
    }

    private void copyToOutput(short[] sArr, int i, int i2) {
        enlargeOutputBufferIfNeeded(i2);
        System.arraycopy(sArr, this.numChannels * i, this.outputBuffer, this.numOutputSamples * this.numChannels, this.numChannels * i2);
        this.numOutputSamples += i2;
    }

    private int copyInputToOutput(int i) {
        int min = Math.min(this.maxRequired, this.remainingInputToCopy);
        copyToOutput(this.inputBuffer, i, min);
        this.remainingInputToCopy -= min;
        return min;
    }

    private void downSampleInput(short[] sArr, int i, int i2) {
        int i3 = this.maxRequired / i2;
        int i4 = this.numChannels * i2;
        int i5 = i * this.numChannels;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.downSampleBuffer[i6] = (short) (i7 / i4);
        }
    }

    private int findPitchPeriodInRange(short[] sArr, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = i * this.numChannels;
        for (int i9 = i2; i9 <= i3; i9++) {
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                i10 += Math.abs(sArr[i8 + i11] - sArr[(i8 + i9) + i11]);
            }
            if (i10 * i4 < i6 * i9) {
                i6 = i10;
                i4 = i9;
            }
            if (i10 * i5 > i7 * i9) {
                i7 = i10;
                i5 = i9;
            }
        }
        this.minDiff = i6 / i4;
        this.maxDiff = i7 / i5;
        return i4;
    }

    private boolean previousPeriodBetter(int i, int i2, boolean z) {
        if (i == 0 || this.prevPeriod == 0) {
            return false;
        }
        if (z) {
            if (i2 <= i * 3 && i * 2 > this.prevMinDiff * 3) {
                return true;
            }
            return false;
        } else if (i <= this.prevMinDiff) {
            return false;
        } else {
            return true;
        }
    }

    private int findPitchPeriod(short[] sArr, int i, boolean z) {
        int i2;
        int i3;
        int i4 = this.sampleRate > 4000 ? this.sampleRate / 4000 : 1;
        if (this.numChannels == 1 && i4 == 1) {
            i2 = findPitchPeriodInRange(sArr, i, this.minPeriod, this.maxPeriod);
        } else {
            downSampleInput(sArr, i, i4);
            i2 = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i4, this.maxPeriod / i4);
            if (i4 != 1) {
                int i5 = i2 * i4;
                int i6 = i5 - (i4 * 4);
                int i7 = i5 + (i4 * 4);
                if (i6 < this.minPeriod) {
                    i6 = this.minPeriod;
                }
                if (i7 > this.maxPeriod) {
                    i7 = this.maxPeriod;
                }
                if (this.numChannels == 1) {
                    i2 = findPitchPeriodInRange(sArr, i, i6, i7);
                } else {
                    downSampleInput(sArr, i, 1);
                    i2 = findPitchPeriodInRange(this.downSampleBuffer, 0, i6, i7);
                }
            }
        }
        if (previousPeriodBetter(this.minDiff, this.maxDiff, z)) {
            i3 = this.prevPeriod;
        } else {
            i3 = i2;
        }
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = i2;
        return i3;
    }

    private void moveNewSamplesToPitchBuffer(int i) {
        int i2 = this.numOutputSamples - i;
        if (this.numPitchSamples + i2 > this.pitchBufferSize) {
            this.pitchBufferSize += (this.pitchBufferSize / 2) + i2;
            this.pitchBuffer = Arrays.copyOf(this.pitchBuffer, this.pitchBufferSize * this.numChannels);
        }
        System.arraycopy(this.outputBuffer, this.numChannels * i, this.pitchBuffer, this.numPitchSamples * this.numChannels, this.numChannels * i2);
        this.numOutputSamples = i;
        this.numPitchSamples += i2;
    }

    private void removePitchSamples(int i) {
        if (i != 0) {
            System.arraycopy(this.pitchBuffer, this.numChannels * i, this.pitchBuffer, 0, (this.numPitchSamples - i) * this.numChannels);
            this.numPitchSamples -= i;
        }
    }

    private short interpolate(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.numChannels + i];
        int i4 = this.newRatePosition * i2;
        int i5 = this.oldRatePosition * i3;
        int i6 = (this.oldRatePosition + 1) * i3;
        int i7 = i6 - i4;
        int i8 = i6 - i5;
        return (short) (((i7 * s) + ((i8 - i7) * s2)) / i8);
    }

    private void adjustRate(float f, int i) {
        if (this.numOutputSamples != i) {
            int i2 = (int) (((float) this.sampleRate) / f);
            int i3 = this.sampleRate;
            while (true) {
                if (i2 <= 16384 && i3 <= 16384) {
                    break;
                }
                i2 /= 2;
                i3 /= 2;
            }
            moveNewSamplesToPitchBuffer(i);
            for (int i4 = 0; i4 < this.numPitchSamples - 1; i4++) {
                while ((this.oldRatePosition + 1) * i2 > this.newRatePosition * i3) {
                    enlargeOutputBufferIfNeeded(1);
                    for (int i5 = 0; i5 < this.numChannels; i5++) {
                        this.outputBuffer[(this.numOutputSamples * this.numChannels) + i5] = interpolate(this.pitchBuffer, (this.numChannels * i4) + i5, i3, i2);
                    }
                    this.newRatePosition++;
                    this.numOutputSamples++;
                }
                this.oldRatePosition++;
                if (this.oldRatePosition == i3) {
                    this.oldRatePosition = 0;
                    Assertions.checkState(this.newRatePosition == i2);
                    this.newRatePosition = 0;
                }
            }
            removePitchSamples(this.numPitchSamples - 1);
        }
    }

    private int skipPitchPeriod(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (((float) i2) / (f - 1.0f));
        } else {
            i3 = i2;
            this.remainingInputToCopy = (int) ((((float) i2) * (2.0f - f)) / (f - 1.0f));
        }
        enlargeOutputBufferIfNeeded(i3);
        overlapAdd(i3, this.numChannels, this.outputBuffer, this.numOutputSamples, sArr, i, sArr, i + i2);
        this.numOutputSamples += i3;
        return i3;
    }

    private int insertPitchPeriod(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((((float) i2) * f) / (1.0f - f));
        } else {
            i3 = i2;
            this.remainingInputToCopy = (int) ((((float) i2) * ((2.0f * f) - 1.0f)) / (1.0f - f));
        }
        enlargeOutputBufferIfNeeded(i2 + i3);
        System.arraycopy(sArr, this.numChannels * i, this.outputBuffer, this.numOutputSamples * this.numChannels, this.numChannels * i2);
        overlapAdd(i3, this.numChannels, this.outputBuffer, this.numOutputSamples + i2, sArr, i + i2, sArr, i);
        this.numOutputSamples += i2 + i3;
        return i3;
    }

    private void changeSpeed(float f) {
        if (this.numInputSamples >= this.maxRequired) {
            int i = this.numInputSamples;
            int i2 = 0;
            do {
                if (this.remainingInputToCopy > 0) {
                    i2 += copyInputToOutput(i2);
                } else {
                    int findPitchPeriod = findPitchPeriod(this.inputBuffer, i2, true);
                    if (((double) f) > 1.0d) {
                        i2 += skipPitchPeriod(this.inputBuffer, i2, f, findPitchPeriod) + findPitchPeriod;
                    } else {
                        i2 += insertPitchPeriod(this.inputBuffer, i2, f, findPitchPeriod);
                    }
                }
            } while (this.maxRequired + i2 <= i);
            removeProcessedInputSamples(i2);
        }
    }

    private void processStreamInput() {
        int i = this.numOutputSamples;
        float f = this.speed / this.pitch;
        if (((double) f) > 1.00001d || ((double) f) < 0.99999d) {
            changeSpeed(f);
        } else {
            copyToOutput(this.inputBuffer, 0, this.numInputSamples);
            this.numInputSamples = 0;
        }
        if (this.pitch != 1.0f) {
            adjustRate(this.pitch, i);
        }
    }

    private static void overlapAdd(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
