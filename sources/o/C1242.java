package o;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.AbstractC0374;
/* renamed from: o.ｨ  reason: contains not printable characters */
public class C1242 implements Closeable, AbstractC0374 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final FileChannel f15783;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f15784 = 1179403647;

    public C1242(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f15783 = new FileInputStream(file).getChannel();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC0374.AbstractC2397iF m16601() {
        this.f15783.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (m16605(allocate, 0) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short r5 = m16598(allocate, 4);
        boolean z = m16598(allocate, 5) == 2;
        if (r5 == 1) {
            return new C0378(z, this);
        }
        if (r5 == 2) {
            return new C1216(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public List<String> m16604() {
        AbstractC0374.If r17;
        this.f15783.position(0L);
        ArrayList arrayList = new ArrayList();
        AbstractC0374.AbstractC2397iF r7 = m16601();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(r7.f13316 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j = (long) r7.f13320;
        if (j == 65535) {
            j = r7.mo14139(0).f13321;
        }
        long j2 = 0;
        long j3 = 0;
        while (true) {
            if (j3 >= j) {
                break;
            }
            AbstractC0374.AbstractC0376 r15 = r7.mo14140(j3);
            if (r15.f13323 == 2) {
                j2 = r15.f13325;
                break;
            }
            j3++;
        }
        if (j2 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        int i = 0;
        ArrayList<Long> arrayList2 = new ArrayList();
        long j4 = 0;
        do {
            r17 = r7.mo14138(j2, i);
            if (r17.f13310 == 1) {
                arrayList2.add(Long.valueOf(r17.f13311));
            } else if (r17.f13310 == 5) {
                j4 = r17.f13311;
            }
            i++;
        } while (r17.f13310 != 0);
        if (j4 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long r18 = m16597(r7, j, j4);
        for (Long l : arrayList2) {
            arrayList.add(m16603(allocate, l.longValue() + r18));
        }
        return arrayList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private long m16597(AbstractC0374.AbstractC2397iF iFVar, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            AbstractC0374.AbstractC0376 r6 = iFVar.mo14140(j3);
            if (r6.f13323 == 1 && r6.f13322 <= j2 && j2 <= r6.f13322 + r6.f13324) {
                return (j2 - r6.f13322) + r6.f13325;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15783.close();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public String m16603(ByteBuffer byteBuffer, long j) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            j = 1 + j;
            short r0 = m16598(byteBuffer, j);
            if (r0 == 0) {
                return sb.toString();
            }
            sb.append((char) r0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public long m16600(ByteBuffer byteBuffer, long j) {
        m16599(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public long m16605(ByteBuffer byteBuffer, long j) {
        m16599(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public int m16602(ByteBuffer byteBuffer, long j) {
        m16599(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public short m16598(ByteBuffer byteBuffer, long j) {
        m16599(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16599(ByteBuffer byteBuffer, long j, int i) {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.f15783.read(byteBuffer, j + j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 += (long) read;
        }
        byteBuffer.position(0);
    }
}
