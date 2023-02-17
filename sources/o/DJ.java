package o;

import com.netflix.msl.MslConstants;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.io.MslEncoderException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class DJ implements AbstractC1399Dp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<String> f5270;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Set<MslConstants.CompressionAlgorithm> f5271;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Set<C1407Dx> f5272;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static DJ m4603(DJ dj, DJ dj2) {
        if (dj == null || dj2 == null) {
            return null;
        }
        EnumSet noneOf = EnumSet.noneOf(MslConstants.CompressionAlgorithm.class);
        noneOf.addAll(dj.f5271);
        noneOf.retainAll(dj2.f5271);
        ArrayList arrayList = new ArrayList(dj.f5270);
        arrayList.retainAll(dj2.f5270);
        HashSet hashSet = new HashSet();
        hashSet.addAll(dj.f5272);
        hashSet.retainAll(dj2.f5272);
        return new DJ(noneOf, arrayList, hashSet);
    }

    public DJ(Set<MslConstants.CompressionAlgorithm> set, List<String> list, Set<C1407Dx> set2) {
        this.f5271 = Collections.unmodifiableSet(set != null ? set : EnumSet.noneOf(MslConstants.CompressionAlgorithm.class));
        this.f5270 = Collections.unmodifiableList(list != null ? list : new ArrayList<>());
        this.f5272 = Collections.unmodifiableSet(set2 != null ? set2 : new HashSet<>());
    }

    public DJ(C1405Dv dv) {
        try {
            EnumSet noneOf = EnumSet.noneOf(MslConstants.CompressionAlgorithm.class);
            C1401Dr r5 = dv.m4764("compressionalgos");
            int i = 0;
            while (r5 != null && i < r5.m4732()) {
                try {
                    noneOf.add(MslConstants.CompressionAlgorithm.valueOf(r5.m4736(i)));
                } catch (IllegalArgumentException e) {
                }
                i++;
            }
            this.f5271 = Collections.unmodifiableSet(noneOf);
            ArrayList arrayList = new ArrayList();
            C1401Dr r7 = dv.m4764("languages");
            int i2 = 0;
            while (r7 != null && i2 < r7.m4732()) {
                arrayList.add(r7.m4736(i2));
                i2++;
            }
            this.f5270 = Collections.unmodifiableList(arrayList);
            HashSet hashSet = new HashSet();
            C1401Dr r9 = dv.m4764("encoderformats");
            int i3 = 0;
            while (r9 != null && i3 < r9.m4732()) {
                C1407Dx r12 = C1407Dx.m4769(r9.m4736(i3));
                if (r12 != null) {
                    hashSet.add(r12);
                }
                i3++;
            }
            this.f5272 = Collections.unmodifiableSet(hashSet);
        } catch (MslEncoderException e2) {
            throw new MslEncodingException(CK.f4804, "capabilities " + dv, e2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Set<MslConstants.CompressionAlgorithm> m4605() {
        return this.f5271;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Set<C1407Dx> m4604() {
        return this.f5272;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("compressionalgos", dq.m4726(this.f5271));
        r2.mo4754("languages", this.f5270);
        C1401Dr r3 = dq.m4730();
        for (C1407Dx dx2 : this.f5272) {
            r3.mo4734(-1, dx2.m4770());
        }
        r2.mo4754("encoderformats", r3);
        return dq.mo3178(r2, dx);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DJ)) {
            return false;
        }
        DJ dj = (DJ) obj;
        return this.f5271.equals(dj.f5271) && this.f5270.equals(dj.f5270) && this.f5272.equals(dj.f5272);
    }

    public int hashCode() {
        return (this.f5271.hashCode() ^ this.f5270.hashCode()) ^ this.f5272.hashCode();
    }
}
