package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.1
        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    };
    public final List<Event> events;

    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDuration;
        public final List<ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        private Event(long j, boolean z, boolean z2, boolean z3, List<ComponentSplice> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.spliceEventId = j;
            this.spliceEventCancelIndicator = z;
            this.outOfNetworkIndicator = z2;
            this.programSpliceFlag = z3;
            this.componentSpliceList = Collections.unmodifiableList(list);
            this.utcSpliceTime = j2;
            this.autoReturn = z4;
            this.breakDuration = j3;
            this.uniqueProgramId = i;
            this.availNum = i2;
            this.availsExpected = i3;
        }

        private Event(Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(ComponentSplice.createFromParcel(parcel));
            }
            this.componentSpliceList = Collections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1;
            this.breakDuration = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }

        /* access modifiers changed from: private */
        public static Event parseFromSection(ParsableByteArray parsableByteArray) {
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            boolean z = (parsableByteArray.readUnsignedByte() & 128) != 0;
            boolean z2 = false;
            boolean z3 = false;
            long j = -9223372036854775807L;
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            boolean z4 = false;
            long j2 = -9223372036854775807L;
            if (!z) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                z2 = (readUnsignedByte & 128) != 0;
                z3 = (readUnsignedByte & 64) != 0;
                boolean z5 = (readUnsignedByte & 32) != 0;
                if (z3) {
                    j = parsableByteArray.readUnsignedInt();
                }
                if (!z3) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    arrayList = new ArrayList(readUnsignedByte2);
                    for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
                        arrayList.add(new ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                    }
                }
                if (z5) {
                    long readUnsignedByte3 = (long) parsableByteArray.readUnsignedByte();
                    z4 = (128 & readUnsignedByte3) != 0;
                    j2 = ((1 & readUnsignedByte3) << 32) | parsableByteArray.readUnsignedInt();
                }
                i = parsableByteArray.readUnsignedShort();
                i2 = parsableByteArray.readUnsignedByte();
                i3 = parsableByteArray.readUnsignedByte();
            }
            return new Event(readUnsignedInt, z, z2, z3, arrayList, j, z4, j2, i, i2, i3);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void writeToParcel(Parcel parcel) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte((byte) (this.spliceEventCancelIndicator ? 1 : 0));
            parcel.writeByte((byte) (this.outOfNetworkIndicator ? 1 : 0));
            parcel.writeByte((byte) (this.programSpliceFlag ? 1 : 0));
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.componentSpliceList.get(i).writeToParcel(parcel);
            }
            parcel.writeLong(this.utcSpliceTime);
            parcel.writeByte((byte) (this.autoReturn ? 1 : 0));
            parcel.writeLong(this.breakDuration);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }

        /* access modifiers changed from: private */
        public static Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }
    }

    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        private ComponentSplice(int i, long j) {
            this.componentTag = i;
            this.utcSpliceTime = j;
        }

        /* access modifiers changed from: private */
        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.utcSpliceTime);
        }
    }

    private SpliceScheduleCommand(List<Event> list) {
        this.events = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(Event.createFromParcel(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    static SpliceScheduleCommand parseFromSection(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        ArrayList arrayList = new ArrayList(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            arrayList.add(Event.parseFromSection(parsableByteArray));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.events.get(i2).writeToParcel(parcel);
        }
    }
}
