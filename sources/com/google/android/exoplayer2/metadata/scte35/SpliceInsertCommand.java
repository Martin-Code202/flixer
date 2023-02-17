package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.1
        @Override // android.os.Parcelable.Creator
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }
    };
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDuration;
    public final List<ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<ComponentSplice> list, boolean z5, long j4, int i, int i2, int i3) {
        this.spliceEventId = j;
        this.spliceEventCancelIndicator = z;
        this.outOfNetworkIndicator = z2;
        this.programSpliceFlag = z3;
        this.spliceImmediateFlag = z4;
        this.programSplicePts = j2;
        this.programSplicePlaybackPositionUs = j3;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z5;
        this.breakDuration = j4;
        this.uniqueProgramId = i;
        this.availNum = i2;
        this.availsExpected = i3;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(ComponentSplice.createFromParcel(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1;
        this.breakDuration = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }

    static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray, long j, TimestampAdjuster timestampAdjuster) {
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        boolean z = (parsableByteArray.readUnsignedByte() & 128) != 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        long j2 = -9223372036854775807L;
        List emptyList = Collections.emptyList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z5 = false;
        long j3 = -9223372036854775807L;
        if (!z) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            z2 = (readUnsignedByte & 128) != 0;
            z3 = (readUnsignedByte & 64) != 0;
            boolean z6 = (readUnsignedByte & 32) != 0;
            z4 = (readUnsignedByte & 16) != 0;
            if (z3 && !z4) {
                j2 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j);
            }
            if (!z3) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                emptyList = new ArrayList(readUnsignedByte2);
                for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    long j4 = -9223372036854775807L;
                    if (!z4) {
                        j4 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j);
                    }
                    emptyList.add(new ComponentSplice(readUnsignedByte3, j4, timestampAdjuster.adjustTsTimestamp(j4)));
                }
            }
            if (z6) {
                long readUnsignedByte4 = (long) parsableByteArray.readUnsignedByte();
                z5 = (128 & readUnsignedByte4) != 0;
                j3 = ((1 & readUnsignedByte4) << 32) | parsableByteArray.readUnsignedInt();
            }
            i = parsableByteArray.readUnsignedShort();
            i2 = parsableByteArray.readUnsignedByte();
            i3 = parsableByteArray.readUnsignedByte();
        }
        return new SpliceInsertCommand(readUnsignedInt, z, z2, z3, z4, j2, timestampAdjuster.adjustTsTimestamp(j2), emptyList, z5, j3, i, i2, i3);
    }

    public static final class ComponentSplice {
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        private ComponentSplice(int i, long j, long j2) {
            this.componentTag = i;
            this.componentSplicePts = j;
            this.componentSplicePlaybackPositionUs = j2;
        }

        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.componentSplicePts);
            parcel.writeLong(this.componentSplicePlaybackPositionUs);
        }

        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte((byte) (this.spliceEventCancelIndicator ? 1 : 0));
        parcel.writeByte((byte) (this.outOfNetworkIndicator ? 1 : 0));
        parcel.writeByte((byte) (this.programSpliceFlag ? 1 : 0));
        parcel.writeByte((byte) (this.spliceImmediateFlag ? 1 : 0));
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.componentSpliceList.get(i2).writeToParcel(parcel);
        }
        parcel.writeByte((byte) (this.autoReturn ? 1 : 0));
        parcel.writeLong(this.breakDuration);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }
}
