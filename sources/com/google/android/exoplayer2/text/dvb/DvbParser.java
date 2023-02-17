package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* access modifiers changed from: package-private */
public final class DvbParser {
    private static final byte[] defaultMap2To4 = {0, 7, 8, 15};
    private static final byte[] defaultMap2To8 = {0, 119, -120, -1};
    private static final byte[] defaultMap4To8 = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas canvas;
    private final ClutDefinition defaultClutDefinition;
    private final DisplayDefinition defaultDisplayDefinition;
    private final Paint defaultPaint = new Paint();
    private final Paint fillRegionPaint;
    private final SubtitleService subtitleService;

    public DvbParser(int i, int i2) {
        this.defaultPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.defaultPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.defaultPaint.setPathEffect(null);
        this.fillRegionPaint = new Paint();
        this.fillRegionPaint.setStyle(Paint.Style.FILL);
        this.fillRegionPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.fillRegionPaint.setPathEffect(null);
        this.canvas = new Canvas();
        this.defaultDisplayDefinition = new DisplayDefinition(719, 575, 0, 719, 0, 575);
        this.defaultClutDefinition = new ClutDefinition(0, generateDefault2BitClutEntries(), generateDefault4BitClutEntries(), generateDefault8BitClutEntries());
        this.subtitleService = new SubtitleService(i, i2);
    }

    public void reset() {
        this.subtitleService.reset();
    }

    public List<Cue> decode(byte[] bArr, int i) {
        int i2;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i);
        while (parsableBitArray.bitsLeft() >= 48 && parsableBitArray.readBits(8) == 15) {
            parseSubtitlingSegment(parsableBitArray, this.subtitleService);
        }
        if (this.subtitleService.pageComposition == null) {
            return Collections.emptyList();
        }
        DisplayDefinition displayDefinition = this.subtitleService.displayDefinition != null ? this.subtitleService.displayDefinition : this.defaultDisplayDefinition;
        if (!(this.bitmap != null && displayDefinition.width + 1 == this.bitmap.getWidth() && displayDefinition.height + 1 == this.bitmap.getHeight())) {
            this.bitmap = Bitmap.createBitmap(displayDefinition.width + 1, displayDefinition.height + 1, Bitmap.Config.ARGB_8888);
            this.canvas.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<PageRegion> sparseArray = this.subtitleService.pageComposition.regions;
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            PageRegion valueAt = sparseArray.valueAt(i3);
            RegionComposition regionComposition = this.subtitleService.regions.get(sparseArray.keyAt(i3));
            int i4 = valueAt.horizontalAddress + displayDefinition.horizontalPositionMinimum;
            int i5 = valueAt.verticalAddress + displayDefinition.verticalPositionMinimum;
            this.canvas.clipRect((float) i4, (float) i5, (float) Math.min(regionComposition.width + i4, displayDefinition.horizontalPositionMaximum), (float) Math.min(regionComposition.height + i5, displayDefinition.verticalPositionMaximum), Region.Op.REPLACE);
            ClutDefinition clutDefinition = this.subtitleService.cluts.get(regionComposition.clutId);
            if (clutDefinition == null && (clutDefinition = this.subtitleService.ancillaryCluts.get(regionComposition.clutId)) == null) {
                clutDefinition = this.defaultClutDefinition;
            }
            SparseArray<RegionObject> sparseArray2 = regionComposition.regionObjects;
            for (int i6 = 0; i6 < sparseArray2.size(); i6++) {
                int keyAt = sparseArray2.keyAt(i6);
                RegionObject valueAt2 = sparseArray2.valueAt(i6);
                ObjectData objectData = this.subtitleService.objects.get(keyAt);
                if (objectData == null) {
                    objectData = this.subtitleService.ancillaryObjects.get(keyAt);
                }
                if (objectData != null) {
                    paintPixelDataSubBlocks(objectData, clutDefinition, regionComposition.depth, valueAt2.horizontalPosition + i4, valueAt2.verticalPosition + i5, objectData.nonModifyingColorFlag ? null : this.defaultPaint, this.canvas);
                }
            }
            if (regionComposition.fillFlag) {
                if (regionComposition.depth == 3) {
                    i2 = clutDefinition.clutEntries8Bit[regionComposition.pixelCode8Bit];
                } else if (regionComposition.depth == 2) {
                    i2 = clutDefinition.clutEntries4Bit[regionComposition.pixelCode4Bit];
                } else {
                    i2 = clutDefinition.clutEntries2Bit[regionComposition.pixelCode2Bit];
                }
                this.fillRegionPaint.setColor(i2);
                this.canvas.drawRect((float) i4, (float) i5, (float) (regionComposition.width + i4), (float) (regionComposition.height + i5), this.fillRegionPaint);
            }
            arrayList.add(new Cue(Bitmap.createBitmap(this.bitmap, i4, i5, regionComposition.width, regionComposition.height), ((float) i4) / ((float) displayDefinition.width), 0, ((float) i5) / ((float) displayDefinition.height), 0, ((float) regionComposition.width) / ((float) displayDefinition.width), ((float) regionComposition.height) / ((float) displayDefinition.height)));
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    private static void parseSubtitlingSegment(ParsableBitArray parsableBitArray, SubtitleService subtitleService2) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        int bytePosition = parsableBitArray.getBytePosition() + readBits3;
        if (readBits3 * 8 > parsableBitArray.bitsLeft()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            parsableBitArray.skipBits(parsableBitArray.bitsLeft());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    PageComposition pageComposition = subtitleService2.pageComposition;
                    PageComposition parsePageComposition = parsePageComposition(parsableBitArray, readBits3);
                    if (parsePageComposition.state == 0) {
                        if (!(pageComposition == null || pageComposition.version == parsePageComposition.version)) {
                            subtitleService2.pageComposition = parsePageComposition;
                            break;
                        }
                    } else {
                        subtitleService2.pageComposition = parsePageComposition;
                        subtitleService2.regions.clear();
                        subtitleService2.cluts.clear();
                        subtitleService2.objects.clear();
                        break;
                    }
                }
                break;
            case 17:
                PageComposition pageComposition2 = subtitleService2.pageComposition;
                if (readBits2 == subtitleService2.subtitlePageId && pageComposition2 != null) {
                    RegionComposition parseRegionComposition = parseRegionComposition(parsableBitArray, readBits3);
                    if (pageComposition2.state == 0) {
                        parseRegionComposition.mergeFrom(subtitleService2.regions.get(parseRegionComposition.id));
                    }
                    subtitleService2.regions.put(parseRegionComposition.id, parseRegionComposition);
                    break;
                }
            case 18:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ClutDefinition parseClutDefinition = parseClutDefinition(parsableBitArray, readBits3);
                        subtitleService2.ancillaryCluts.put(parseClutDefinition.id, parseClutDefinition);
                        break;
                    }
                } else {
                    ClutDefinition parseClutDefinition2 = parseClutDefinition(parsableBitArray, readBits3);
                    subtitleService2.cluts.put(parseClutDefinition2.id, parseClutDefinition2);
                    break;
                }
                break;
            case 19:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ObjectData parseObjectData = parseObjectData(parsableBitArray);
                        subtitleService2.ancillaryObjects.put(parseObjectData.id, parseObjectData);
                        break;
                    }
                } else {
                    ObjectData parseObjectData2 = parseObjectData(parsableBitArray);
                    subtitleService2.objects.put(parseObjectData2.id, parseObjectData2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    subtitleService2.displayDefinition = parseDisplayDefinition(parsableBitArray);
                    break;
                }
                break;
        }
        parsableBitArray.skipBytes(bytePosition - parsableBitArray.getBytePosition());
    }

    private static DisplayDefinition parseDisplayDefinition(ParsableBitArray parsableBitArray) {
        int i;
        int i2;
        int i3;
        int i4;
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int readBits = parsableBitArray.readBits(16);
        int readBits2 = parsableBitArray.readBits(16);
        if (readBit) {
            i4 = parsableBitArray.readBits(16);
            i3 = parsableBitArray.readBits(16);
            i2 = parsableBitArray.readBits(16);
            i = parsableBitArray.readBits(16);
        } else {
            i4 = 0;
            i3 = readBits;
            i2 = 0;
            i = readBits2;
        }
        return new DisplayDefinition(readBits, readBits2, i4, i3, i2, i);
    }

    private static PageComposition parsePageComposition(ParsableBitArray parsableBitArray, int i) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(4);
        int readBits3 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits4 = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(8);
            i2 -= 6;
            sparseArray.put(readBits4, new PageRegion(parsableBitArray.readBits(16), parsableBitArray.readBits(16)));
        }
        return new PageComposition(readBits, readBits2, readBits3, sparseArray);
    }

    private static RegionComposition parseRegionComposition(ParsableBitArray parsableBitArray, int i) {
        int readBits = parsableBitArray.readBits(8);
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        int readBits4 = parsableBitArray.readBits(3);
        int readBits5 = parsableBitArray.readBits(3);
        parsableBitArray.skipBits(2);
        int readBits6 = parsableBitArray.readBits(8);
        int readBits7 = parsableBitArray.readBits(8);
        int readBits8 = parsableBitArray.readBits(4);
        int readBits9 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits10 = parsableBitArray.readBits(16);
            int readBits11 = parsableBitArray.readBits(2);
            int readBits12 = parsableBitArray.readBits(2);
            int readBits13 = parsableBitArray.readBits(12);
            parsableBitArray.skipBits(4);
            int readBits14 = parsableBitArray.readBits(12);
            i2 -= 6;
            int i3 = 0;
            int i4 = 0;
            if (readBits11 == 1 || readBits11 == 2) {
                i3 = parsableBitArray.readBits(8);
                i4 = parsableBitArray.readBits(8);
                i2 -= 2;
            }
            sparseArray.put(readBits10, new RegionObject(readBits11, readBits12, readBits13, readBits14, i3, i4));
        }
        return new RegionComposition(readBits, readBit, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
    }

    private static ClutDefinition parseClutDefinition(ParsableBitArray parsableBitArray, int i) {
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int readBits = parsableBitArray.readBits(8);
        parsableBitArray.skipBits(8);
        int i6 = i - 2;
        int[] generateDefault2BitClutEntries = generateDefault2BitClutEntries();
        int[] generateDefault4BitClutEntries = generateDefault4BitClutEntries();
        int[] generateDefault8BitClutEntries = generateDefault8BitClutEntries();
        while (i6 > 0) {
            int readBits2 = parsableBitArray.readBits(8);
            int readBits3 = parsableBitArray.readBits(8);
            int i7 = i6 - 2;
            if ((readBits3 & 128) != 0) {
                iArr = generateDefault2BitClutEntries;
            } else if ((readBits3 & 64) != 0) {
                iArr = generateDefault4BitClutEntries;
            } else {
                iArr = generateDefault8BitClutEntries;
            }
            if ((readBits3 & 1) != 0) {
                i5 = parsableBitArray.readBits(8);
                i4 = parsableBitArray.readBits(8);
                i3 = parsableBitArray.readBits(8);
                i2 = parsableBitArray.readBits(8);
                i6 = i7 - 4;
            } else {
                i5 = parsableBitArray.readBits(6) << 2;
                i4 = parsableBitArray.readBits(4) << 4;
                i3 = parsableBitArray.readBits(4) << 4;
                i2 = parsableBitArray.readBits(2) << 6;
                i6 = i7 - 2;
            }
            if (i5 == 0) {
                i4 = 0;
                i3 = 0;
                i2 = 255;
            }
            iArr[readBits2] = getColor((byte) (255 - (i2 & 255)), Util.constrainValue((int) (((double) i5) + (((double) (i4 - 128)) * 1.402d)), 0, 255), Util.constrainValue((int) ((((double) i5) - (((double) (i3 - 128)) * 0.34414d)) - (((double) (i4 - 128)) * 0.71414d)), 0, 255), Util.constrainValue((int) (((double) i5) + (((double) (i3 - 128)) * 1.772d)), 0, 255));
        }
        return new ClutDefinition(readBits, generateDefault2BitClutEntries, generateDefault4BitClutEntries, generateDefault8BitClutEntries);
    }

    private static ObjectData parseObjectData(ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr = null;
        byte[] bArr2 = null;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr = new byte[readBits3];
                parsableBitArray.readBytes(bArr, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr2 = new byte[readBits4];
                parsableBitArray.readBytes(bArr2, 0, readBits4);
            } else {
                bArr2 = bArr;
            }
        }
        return new ObjectData(readBits, readBit, bArr, bArr2);
    }

    private static int[] generateDefault2BitClutEntries() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] generateDefault4BitClutEntries() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        int i = 1;
        while (true) {
            int length = iArr.length;
            if (i >= 16) {
                return iArr;
            }
            if (i < 8) {
                iArr[i] = getColor(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = getColor(255, (i & 1) != 0 ? 127 : 0, (i & 2) != 0 ? 127 : 0, (i & 4) != 0 ? 127 : 0);
            }
            i++;
        }
    }

    private static int[] generateDefault8BitClutEntries() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        int i = 0;
        while (true) {
            int length = iArr.length;
            if (i >= 256) {
                return iArr;
            }
            if (i < 8) {
                iArr[i] = getColor(63, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                switch (i & 136) {
                    case 0:
                        iArr[i] = getColor(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) != 0 ? 85 : 0) + ((i & 64) != 0 ? 170 : 0));
                        continue;
                    case 8:
                        iArr[i] = getColor(127, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) != 0 ? 85 : 0) + ((i & 64) != 0 ? 170 : 0));
                        continue;
                    case 128:
                        iArr[i] = getColor(255, ((i & 1) != 0 ? 43 : 0) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) != 0 ? 43 : 0) + 127 + ((i & 64) != 0 ? 85 : 0));
                        continue;
                    case 136:
                        iArr[i] = getColor(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) != 0 ? 43 : 0) + ((i & 64) != 0 ? 85 : 0));
                        continue;
                }
            }
            i++;
        }
    }

    private static int getColor(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static void paintPixelDataSubBlocks(ObjectData objectData, ClutDefinition clutDefinition, int i, int i2, int i3, Paint paint, Canvas canvas2) {
        int[] iArr;
        if (i == 3) {
            iArr = clutDefinition.clutEntries8Bit;
        } else if (i == 2) {
            iArr = clutDefinition.clutEntries4Bit;
        } else {
            iArr = clutDefinition.clutEntries2Bit;
        }
        paintPixelDataSubBlock(objectData.topFieldData, iArr, i, i2, i3, paint, canvas2);
        paintPixelDataSubBlock(objectData.bottomFieldData, iArr, i, i2, i3 + 1, paint, canvas2);
    }

    private static void paintPixelDataSubBlock(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas2) {
        byte[] bArr2;
        byte[] bArr3;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i4 = i2;
        int i5 = i3;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        while (parsableBitArray.bitsLeft() != 0) {
            switch (parsableBitArray.readBits(8)) {
                case 16:
                    if (i == 3) {
                        bArr3 = bArr5 == null ? defaultMap2To8 : bArr5;
                    } else if (i == 2) {
                        bArr3 = bArr4 == null ? defaultMap2To4 : bArr4;
                    } else {
                        bArr3 = null;
                    }
                    i4 = paint2BitPixelCodeString(parsableBitArray, iArr, bArr3, i4, i5, paint, canvas2);
                    parsableBitArray.byteAlign();
                    break;
                case 17:
                    if (i == 3) {
                        bArr2 = defaultMap4To8;
                    } else {
                        bArr2 = null;
                    }
                    i4 = paint4BitPixelCodeString(parsableBitArray, iArr, bArr2, i4, i5, paint, canvas2);
                    parsableBitArray.byteAlign();
                    break;
                case 18:
                    i4 = paint8BitPixelCodeString(parsableBitArray, iArr, null, i4, i5, paint, canvas2);
                    break;
                case 32:
                    bArr4 = buildClutMapTable(4, 4, parsableBitArray);
                    break;
                case 33:
                    bArr5 = buildClutMapTable(4, 8, parsableBitArray);
                    break;
                case 34:
                    bArr5 = buildClutMapTable(16, 8, parsableBitArray);
                    break;
                case 240:
                    i4 = i2;
                    i5 += 2;
                    break;
            }
        }
    }

    private static int paint2BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas2) {
        boolean z = false;
        do {
            int i3 = 0;
            int i4 = 0;
            int readBits = parsableBitArray.readBits(2);
            if (readBits == 0) {
                if (!parsableBitArray.readBit()) {
                    if (!parsableBitArray.readBit()) {
                        switch (parsableBitArray.readBits(2)) {
                            case 0:
                                z = true;
                                break;
                            case 1:
                                i3 = 2;
                                break;
                            case 2:
                                i3 = parsableBitArray.readBits(4) + 12;
                                i4 = parsableBitArray.readBits(2);
                                break;
                            case 3:
                                i3 = parsableBitArray.readBits(8) + 29;
                                i4 = parsableBitArray.readBits(2);
                                break;
                        }
                    } else {
                        i3 = 1;
                    }
                } else {
                    i3 = parsableBitArray.readBits(3) + 3;
                    i4 = parsableBitArray.readBits(2);
                }
            } else {
                i3 = 1;
                i4 = readBits;
            }
            if (!(i3 == 0 || paint == null)) {
                paint.setColor(iArr[(bArr != null ? bArr[i4] : i4) == 1 ? 1 : 0]);
                canvas2.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + 1), paint);
            }
            i += i3;
        } while (!z);
        return i;
    }

    private static int paint4BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas2) {
        boolean z = false;
        do {
            int i3 = 0;
            int i4 = 0;
            int readBits = parsableBitArray.readBits(4);
            if (readBits == 0) {
                if (parsableBitArray.readBit()) {
                    if (parsableBitArray.readBit()) {
                        switch (parsableBitArray.readBits(2)) {
                            case 0:
                                i3 = 1;
                                break;
                            case 1:
                                i3 = 2;
                                break;
                            case 2:
                                i3 = parsableBitArray.readBits(4) + 9;
                                i4 = parsableBitArray.readBits(4);
                                break;
                            case 3:
                                i3 = parsableBitArray.readBits(8) + 25;
                                i4 = parsableBitArray.readBits(4);
                                break;
                        }
                    } else {
                        i3 = parsableBitArray.readBits(2) + 4;
                        i4 = parsableBitArray.readBits(4);
                    }
                } else {
                    int readBits2 = parsableBitArray.readBits(3);
                    if (readBits2 != 0) {
                        i3 = readBits2 + 2;
                        i4 = 0;
                    } else {
                        z = true;
                    }
                }
            } else {
                i3 = 1;
                i4 = readBits;
            }
            if (!(i3 == 0 || paint == null)) {
                paint.setColor(iArr[(bArr != null ? bArr[i4] : i4) == 1 ? 1 : 0]);
                canvas2.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + 1), paint);
            }
            i += i3;
        } while (!z);
        return i;
    }

    private static int paint8BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas2) {
        boolean z = false;
        do {
            int i3 = 0;
            int i4 = 0;
            int readBits = parsableBitArray.readBits(8);
            if (readBits != 0) {
                i3 = 1;
                i4 = readBits;
            } else if (!parsableBitArray.readBit()) {
                int readBits2 = parsableBitArray.readBits(7);
                if (readBits2 != 0) {
                    i3 = readBits2;
                    i4 = 0;
                } else {
                    z = true;
                }
            } else {
                i3 = parsableBitArray.readBits(7);
                i4 = parsableBitArray.readBits(8);
            }
            if (!(i3 == 0 || paint == null)) {
                paint.setColor(iArr[(bArr != null ? bArr[i4] : i4) == 1 ? 1 : 0]);
                canvas2.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + 1), paint);
            }
            i += i3;
        } while (!z);
        return i;
    }

    private static byte[] buildClutMapTable(int i, int i2, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) parsableBitArray.readBits(i2);
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public static final class SubtitleService {
        public final SparseArray<ClutDefinition> ancillaryCluts = new SparseArray<>();
        public final SparseArray<ObjectData> ancillaryObjects = new SparseArray<>();
        public final int ancillaryPageId;
        public final SparseArray<ClutDefinition> cluts = new SparseArray<>();
        public DisplayDefinition displayDefinition;
        public final SparseArray<ObjectData> objects = new SparseArray<>();
        public PageComposition pageComposition;
        public final SparseArray<RegionComposition> regions = new SparseArray<>();
        public final int subtitlePageId;

        public SubtitleService(int i, int i2) {
            this.subtitlePageId = i;
            this.ancillaryPageId = i2;
        }

        public void reset() {
            this.regions.clear();
            this.cluts.clear();
            this.objects.clear();
            this.ancillaryCluts.clear();
            this.ancillaryObjects.clear();
            this.displayDefinition = null;
            this.pageComposition = null;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class DisplayDefinition {
        public final int height;
        public final int horizontalPositionMaximum;
        public final int horizontalPositionMinimum;
        public final int verticalPositionMaximum;
        public final int verticalPositionMinimum;
        public final int width;

        public DisplayDefinition(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.horizontalPositionMinimum = i3;
            this.horizontalPositionMaximum = i4;
            this.verticalPositionMinimum = i5;
            this.verticalPositionMaximum = i6;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class PageComposition {
        public final SparseArray<PageRegion> regions;
        public final int state;
        public final int timeOutSecs;
        public final int version;

        public PageComposition(int i, int i2, int i3, SparseArray<PageRegion> sparseArray) {
            this.timeOutSecs = i;
            this.version = i2;
            this.state = i3;
            this.regions = sparseArray;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class PageRegion {
        public final int horizontalAddress;
        public final int verticalAddress;

        public PageRegion(int i, int i2) {
            this.horizontalAddress = i;
            this.verticalAddress = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class RegionComposition {
        public final int clutId;
        public final int depth;
        public final boolean fillFlag;
        public final int height;
        public final int id;
        public final int levelOfCompatibility;
        public final int pixelCode2Bit;
        public final int pixelCode4Bit;
        public final int pixelCode8Bit;
        public final SparseArray<RegionObject> regionObjects;
        public final int width;

        public RegionComposition(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<RegionObject> sparseArray) {
            this.id = i;
            this.fillFlag = z;
            this.width = i2;
            this.height = i3;
            this.levelOfCompatibility = i4;
            this.depth = i5;
            this.clutId = i6;
            this.pixelCode8Bit = i7;
            this.pixelCode4Bit = i8;
            this.pixelCode2Bit = i9;
            this.regionObjects = sparseArray;
        }

        public void mergeFrom(RegionComposition regionComposition) {
            if (regionComposition != null) {
                SparseArray<RegionObject> sparseArray = regionComposition.regionObjects;
                for (int i = 0; i < sparseArray.size(); i++) {
                    this.regionObjects.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class RegionObject {
        public final int backgroundPixelCode;
        public final int foregroundPixelCode;
        public final int horizontalPosition;
        public final int provider;
        public final int type;
        public final int verticalPosition;

        public RegionObject(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.provider = i2;
            this.horizontalPosition = i3;
            this.verticalPosition = i4;
            this.foregroundPixelCode = i5;
            this.backgroundPixelCode = i6;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ClutDefinition {
        public final int[] clutEntries2Bit;
        public final int[] clutEntries4Bit;
        public final int[] clutEntries8Bit;
        public final int id;

        public ClutDefinition(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.clutEntries2Bit = iArr;
            this.clutEntries4Bit = iArr2;
            this.clutEntries8Bit = iArr3;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ObjectData {
        public final byte[] bottomFieldData;
        public final int id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.nonModifyingColorFlag = z;
            this.topFieldData = bArr;
            this.bottomFieldData = bArr2;
        }
    }
}
