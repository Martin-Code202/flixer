package com.netflix.msl.msg;

import com.netflix.msl.MslConstants;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.MslMessageException;
import com.netflix.msl.msg.MessageContext;
import com.netflix.msl.util.MslContext;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.FileLockInterruptionException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.crypto.spec.SecretKeySpec;
import o.AbstractC1385Db;
import o.AbstractC1386Dc;
import o.AbstractC1390Dg;
import o.AbstractC1400Dq;
import o.AbstractC1403Dt;
import o.AbstractC1406Dw;
import o.AbstractC1408Dy;
import o.AbstractC1412Ec;
import o.AbstractC1415Ef;
import o.AbstractC1417Eh;
import o.C1387Dd;
import o.C1391Dh;
import o.C1393Dj;
import o.C1405Dv;
import o.C1407Dx;
import o.C1409Dz;
import o.C1411Eb;
import o.C1416Eg;
import o.C1424En;
import o.CK;
import o.DB;
import o.DC;
import o.DD;
import o.DE;
import o.DH;
import o.DJ;
import o.DK;
import o.DL;
import o.DM;
import o.DN;
import o.DO;
import o.DP;
import o.DQ;
import o.DR;
import o.DS;
import o.DU;
import o.DV;
import o.DW;
public class MslControl {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final ConcurrentHashMap<IF, ReadWriteLock> f4158 = new ConcurrentHashMap<>();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final ConcurrentHashMap<MslContext, BlockingQueue<DV>> f4159 = new ConcurrentHashMap<>();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ExecutorService f4160;

    /* renamed from: ˎ  reason: contains not printable characters */
    private DE f4161 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final DH f4162;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final DQ f4163;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final DV f4164;

    public enum ApplicationError {
        ENTITY_REJECTED,
        USER_REJECTED
    }

    /* renamed from: com.netflix.msl.msg.MslControl$ᐝ  reason: contains not printable characters */
    public static class C0058 {

        /* renamed from: ˏ  reason: contains not printable characters */
        public final DO f4193;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final DP f4194;

        protected C0058(DP dp, DO r2) {
            this.f4194 = dp;
            this.f4193 = r2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class IF {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final MslContext f4170;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final DV f4171;

        public IF(MslContext mslContext, DV dv) {
            this.f4170 = mslContext;
            this.f4171 = dv;
        }

        public int hashCode() {
            return this.f4170.hashCode() ^ this.f4171.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IF)) {
                return false;
            }
            IF r2 = (IF) obj;
            return this.f4170.equals(r2.f4170) && this.f4171.equals(r2.f4171);
        }
    }

    /* renamed from: com.netflix.msl.msg.MslControl$ʻ  reason: contains not printable characters */
    static class C0051 extends AbstractExecutorService {

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean f4175;

        private C0051() {
            this.f4175 = false;
        }

        /* synthetic */ C0051(AnonymousClass4 r1) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f4175) {
                throw new RejectedExecutionException("Synchronous executor already shut down.");
            }
            runnable.run();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f4175;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f4175;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.f4175 = true;
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            this.f4175 = true;
            return Collections.emptyList();
        }
    }

    /* renamed from: com.netflix.msl.msg.MslControl$ˋ  reason: contains not printable characters */
    static class C0054 extends MslContext {
        private C0054() {
        }

        /* synthetic */ C0054(AnonymousClass4 r1) {
            this();
        }

        /* renamed from: com.netflix.msl.msg.MslControl$ˋ$ˋ  reason: contains not printable characters */
        static class C0055 extends AbstractC1400Dq {
            private C0055() {
            }

            /* synthetic */ C0055(AnonymousClass4 r1) {
                this();
            }

            @Override // o.AbstractC1400Dq
            /* renamed from: ˎ  reason: contains not printable characters */
            public C1407Dx mo3177(Set<C1407Dx> set) {
                return C1407Dx.f5471;
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC1400Dq
            /* renamed from: ˊ  reason: contains not printable characters */
            public AbstractC1406Dw mo3175(InputStream inputStream, C1407Dx dx) {
                throw new MslInternalException("DummyMslEncoderFactory.generateTokenizer() not supported.");
            }

            @Override // o.AbstractC1400Dq
            /* renamed from: ˋ  reason: contains not printable characters */
            public C1405Dv mo3176(byte[] bArr) {
                throw new MslInternalException("DummyMslEncoderFactory.parseObject() not supported.");
            }

            @Override // o.AbstractC1400Dq
            /* renamed from: ॱ  reason: contains not printable characters */
            public byte[] mo3178(C1405Dv dv, C1407Dx dx) {
                throw new MslInternalException("DummyMslEncoderFactory.encodeObject() not supported.");
            }
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ˏ  reason: contains not printable characters */
        public long mo3167() {
            return System.currentTimeMillis();
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ॱॱ  reason: contains not printable characters */
        public Random mo3173() {
            return new Random();
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean mo3166() {
            return false;
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ॱ  reason: contains not printable characters */
        public DJ mo3170() {
            return null;
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ˏ  reason: contains not printable characters */
        public AbstractC1385Db mo3168(MslContext.ReauthCode reauthCode) {
            return new C1393Dj("dummy");
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ʼ  reason: contains not printable characters */
        public AbstractC1386Dc mo3160() {
            return new C1387Dd();
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ˊ  reason: contains not printable characters */
        public C1391Dh mo3163(String str) {
            return C1391Dh.m4715(str);
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ˏ  reason: contains not printable characters */
        public AbstractC1390Dg mo3169(C1391Dh dh) {
            return null;
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ॱ  reason: contains not printable characters */
        public C1416Eg mo3172(String str) {
            return C1416Eg.m4879(str);
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ॱ  reason: contains not printable characters */
        public AbstractC1415Ef mo3171(C1416Eg eg) {
            return null;
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ʽ  reason: contains not printable characters */
        public DS mo3161() {
            throw new MslInternalException("Dummy token factory should never actually get used.");
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ˋ  reason: contains not printable characters */
        public C1409Dz mo3165(String str) {
            return C1409Dz.m4773(str);
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ˊ  reason: contains not printable characters */
        public DB mo3162(C1409Dz dz) {
            return null;
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ˋ  reason: contains not printable characters */
        public SortedSet<DB> mo3164() {
            return new TreeSet();
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ʻ  reason: contains not printable characters */
        public AbstractC1417Eh mo3159() {
            return new C1424En();
        }

        @Override // com.netflix.msl.util.MslContext
        /* renamed from: ᐝ  reason: contains not printable characters */
        public AbstractC1400Dq mo3174() {
            return new C0055(null);
        }
    }

    /* renamed from: com.netflix.msl.msg.MslControl$if  reason: invalid class name */
    static class Cif implements DH {
        private Cif() {
        }

        /* synthetic */ Cif(AnonymousClass4 r1) {
            this();
        }
    }

    /* renamed from: com.netflix.msl.msg.MslControl$ˊ  reason: contains not printable characters */
    static class C0053 implements MessageContext {

        /* renamed from: ॱ  reason: contains not printable characters */
        protected final MessageContext f4178;

        protected C0053(MessageContext messageContext) {
            this.f4178 = messageContext;
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ˏ */
        public Map<String, AbstractC1386Dc> mo3130() {
            return this.f4178.mo3130();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ˊ */
        public String mo3125() {
            return this.f4178.mo3125();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ʻ */
        public boolean mo3122() {
            return this.f4178.mo3122();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ॱॱ */
        public boolean mo3133() {
            return this.f4178.mo3133();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ᐝ */
        public boolean mo3134() {
            return this.f4178.mo3134();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ʼ */
        public boolean mo3123() {
            return this.f4178.mo3123();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ʽ */
        public String mo3124() {
            return this.f4178.mo3124();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ˏ */
        public AbstractC1412Ec mo3131(MessageContext.ReauthCode reauthCode, boolean z, boolean z2) {
            return this.f4178.mo3131(reauthCode, z, z2);
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ˎ */
        public DW mo3129() {
            return this.f4178.mo3129();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ॱ */
        public Set<AbstractC1408Dy> mo3132() {
            return this.f4178.mo3132();
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ˊ */
        public void mo3127(DR dr, boolean z) {
            this.f4178.mo3127(dr, z);
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ˊ */
        public void mo3126(DO r2) {
            this.f4178.mo3126(r2);
        }

        @Override // com.netflix.msl.msg.MessageContext
        /* renamed from: ˋ */
        public DK mo3128() {
            return this.f4178.mo3128();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.msl.msg.MslControl$ˏ  reason: contains not printable characters */
    public static class C0057 extends C0053 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final List<DN> f4192;

        public C0057(List<DN> list, MessageContext messageContext) {
            super(messageContext);
            this.f4192 = list;
        }

        @Override // com.netflix.msl.msg.MslControl.C0053, com.netflix.msl.msg.MessageContext
        /* renamed from: ˊ */
        public void mo3126(DO r4) {
            if (this.f4192 == null || this.f4192.isEmpty()) {
                this.f4178.mo3126(r4);
                return;
            }
            for (DN dn : this.f4192) {
                r4.m4660(dn.m4653());
                r4.write(dn.m4652());
                if (dn.m4656()) {
                    r4.close();
                } else {
                    r4.flush();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.msl.msg.MslControl$iF  reason: case insensitive filesystem */
    public static class C1296iF extends C0053 {
        public C1296iF(MessageContext messageContext) {
            super(messageContext);
        }

        @Override // com.netflix.msl.msg.MslControl.C0053, com.netflix.msl.msg.MessageContext
        /* renamed from: ʻ */
        public boolean mo3122() {
            return false;
        }

        @Override // com.netflix.msl.msg.MslControl.C0053, com.netflix.msl.msg.MessageContext
        /* renamed from: ॱॱ */
        public boolean mo3133() {
            return false;
        }

        @Override // com.netflix.msl.msg.MslControl.C0053, com.netflix.msl.msg.MessageContext
        /* renamed from: ᐝ */
        public boolean mo3134() {
            return false;
        }

        @Override // com.netflix.msl.msg.MslControl.C0053, com.netflix.msl.msg.MessageContext
        /* renamed from: ˊ */
        public void mo3126(DO r1) {
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static boolean m3141(Throwable th) {
        if (Thread.interrupted()) {
            return true;
        }
        while (th != null) {
            if (th instanceof InterruptedException) {
                return true;
            }
            if (((th instanceof InterruptedIOException) && !(th instanceof SocketTimeoutException)) || (th instanceof FileLockInterruptionException) || (th instanceof ClosedByInterruptException)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public MslControl(int i, DQ dq, DH dh) {
        if (i < 0) {
            throw new IllegalArgumentException("Number of threads must be non-negative.");
        }
        this.f4163 = dq != null ? dq : new DQ();
        this.f4162 = dh != null ? dh : new Cif(null);
        if (i > 0) {
            this.f4160 = Executors.newFixedThreadPool(i);
        } else {
            this.f4160 = new C0051(null);
        }
        try {
            C0054 r12 = new C0054(null);
            byte[] bArr = new byte[16];
            this.f4164 = new DV(r12, new Date(), new Date(), 1, 1, r12.mo3174().m4727(), "dummy", new SecretKeySpec(bArr, "AES"), new SecretKeySpec(bArr, "HmacSHA256"));
        } catch (MslEncodingException e) {
            throw new MslInternalException("Unexpected exception when constructing dummy master token.", e);
        } catch (MslCryptoException e2) {
            throw new MslInternalException("Unexpected exception when constructing dummy master token.", e2);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        this.f4160.shutdownNow();
        super.finalize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.concurrent.locks.ReadWriteLock] */
    /* renamed from: ˎ  reason: contains not printable characters */
    private DV m3148(MslContext mslContext) {
        while (true) {
            AbstractC1417Eh r1 = mslContext.mo3159();
            DV r2 = r1.mo4884();
            if (r2 == null) {
                return null;
            }
            IF r3 = new IF(mslContext, r2);
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            ReadWriteLock putIfAbsent = this.f4158.putIfAbsent(r3, reentrantReadWriteLock);
            ReentrantReadWriteLock reentrantReadWriteLock2 = putIfAbsent != 0 ? putIfAbsent : reentrantReadWriteLock;
            reentrantReadWriteLock2.readLock().lockInterruptibly();
            if (r2.equals(r1.mo4884())) {
                return r2;
            }
            reentrantReadWriteLock2.readLock().unlock();
            reentrantReadWriteLock2.writeLock().lockInterruptibly();
            this.f4158.remove(r3);
            reentrantReadWriteLock2.writeLock().unlock();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m3150(MslContext mslContext, DV dv) {
        Lock lock;
        if (dv != null) {
            IF r1 = new IF(mslContext, dv);
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            ReadWriteLock putIfAbsent = this.f4158.putIfAbsent(r1, reentrantReadWriteLock);
            if (putIfAbsent != null) {
                putIfAbsent.readLock().unlock();
                lock = putIfAbsent.writeLock();
            } else {
                lock = reentrantReadWriteLock.writeLock();
            }
            lock.lockInterruptibly();
            try {
                mslContext.mo3159().mo4881(dv);
            } finally {
                this.f4158.remove(r1);
                lock.unlock();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m3152(MslContext mslContext, DV dv) {
        ReadWriteLock readWriteLock;
        if (dv != null && (readWriteLock = this.f4158.get(new IF(mslContext, dv))) != null) {
            readWriteLock.readLock().unlock();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3138(MslContext mslContext, DM dm, DB.C0083 r8) {
        AbstractC1417Eh r1 = mslContext.mo3159();
        if (!mslContext.mo3166() && r8 != null) {
            DC dc = r8.f5251;
            r1.mo4886(dc.m4587(), r8.f5252);
            m3150(mslContext, dm.m4636());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3140(MslContext mslContext, DM dm, DP dp) {
        DM r1 = dp.m4669();
        if (r1 != null) {
            AbstractC1417Eh r2 = mslContext.mo3159();
            DC r3 = r1.m4643();
            if (r3 != null) {
                r2.mo4886(r3.m4587(), dp.m4663());
                m3150(mslContext, dm.m4636());
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m3145(MslContext mslContext, DV dv, C1411Eb eb, Set<DU> set) {
        AbstractC1417Eh r3 = mslContext.mo3159();
        HashSet hashSet = new HashSet();
        for (DU du : set) {
            if (!du.m4684(dv) || !dv.m4696()) {
                byte[] r7 = du.m4682();
                if (r7 == null || r7.length != 0) {
                    hashSet.add(du);
                } else {
                    r3.mo4890(du.m4685(), du.m4686() ? dv : null, du.m4681() ? eb : null);
                }
            }
        }
        r3.mo4885(hashSet);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private DL m3144(MslContext mslContext, MessageContext messageContext) {
        C1411Eb eb;
        AbstractC1417Eh r2 = mslContext.mo3159();
        DV r3 = m3148(mslContext);
        if (r3 != null) {
            String r5 = messageContext.mo3124();
            C1411Eb r6 = r5 != null ? r2.mo4889(r5) : null;
            eb = (r6 == null || !r6.m4871(r3)) ? null : r6;
        } else {
            eb = null;
        }
        try {
            DL r62 = DL.m4609(mslContext, r3, eb, messageContext.mo3125());
            r62.m4622(messageContext.mo3134());
            return r62;
        } catch (MslException e) {
            m3152(mslContext, r3);
            throw new MslInternalException("User ID token not bound to master token despite internal check.", e);
        } catch (RuntimeException e2) {
            m3152(mslContext, r3);
            throw e2;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private DL m3137(MslContext mslContext, MessageContext messageContext, DM dm) {
        C1411Eb eb;
        DL r1 = DL.m4608(mslContext, dm);
        r1.m4622(messageContext.mo3134());
        if (!mslContext.mo3166() && dm.m4643() == null) {
            return r1;
        }
        DV r2 = m3148(mslContext);
        if (r2 != null) {
            String r4 = messageContext.mo3124();
            C1411Eb r6 = r4 != null ? mslContext.mo3159().mo4889(r4) : null;
            eb = (r6 == null || !r6.m4871(r2)) ? null : r6;
        } else {
            eb = null;
        }
        r1.m4618(r2, eb);
        return r1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.msl.msg.MslControl$If  reason: case insensitive filesystem */
    public static class C1295If {

        /* renamed from: ˋ  reason: contains not printable characters */
        public final DL f4172;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final MessageContext f4173;

        public C1295If(DL dl, MessageContext messageContext) {
            this.f4172 = dl;
            this.f4173 = messageContext;
        }
    }

    /* access modifiers changed from: private */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private C1295If m3153(MslContext mslContext, MessageContext messageContext, C0052 r21, DD dd) {
        C1411Eb eb;
        C1411Eb eb2;
        DM r6 = r21.f4176.m4657();
        List<DN> r7 = r21.f4176.m4661();
        MslConstants.ResponseCode r8 = dd.m4593();
        switch (r8) {
            case ENTITYDATA_REAUTH:
            case ENTITY_REAUTH:
                try {
                    if (mslContext.mo3168(MslContext.ReauthCode.m3183(r8)) == null) {
                        return null;
                    }
                    long r9 = DL.m4611(dd.m4591());
                    C0057 r11 = new C0057(r7, messageContext);
                    DL r13 = DL.m4610(mslContext, null, null, r11.mo3125(), r9);
                    if (mslContext.mo3166()) {
                        r13.m4628(r6.m4647(), r6.m4649());
                    }
                    r13.m4622(r11.mo3134());
                    return new C1295If(r13, r11);
                } catch (IllegalArgumentException e) {
                    throw new MslInternalException("Unsupported response code mapping onto entity re-authentication codes.", e);
                }
            case USERDATA_REAUTH:
            case SSOTOKEN_REJECTED:
                try {
                    if (messageContext.mo3131(MessageContext.ReauthCode.m3135(r8), false, true) == null) {
                        return null;
                    }
                } catch (IllegalArgumentException e2) {
                    throw new MslInternalException("Unsupported response code mapping onto user re-authentication codes.", e2);
                }
                break;
            case USER_REAUTH:
                break;
            case KEYX_REQUIRED:
                long r92 = DL.m4611(dd.m4591());
                C0057 r112 = new C0057(r7, messageContext);
                DL r132 = DL.m4610(mslContext, null, null, r112.mo3125(), r92);
                if (mslContext.mo3166()) {
                    r132.m4628(r6.m4647(), r6.m4649());
                }
                r132.m4616(true);
                r132.m4622(r112.mo3134());
                return new C1295If(r132, r112);
            case EXPIRED:
                DV r93 = m3148(mslContext);
                if (r93 != null) {
                    String r113 = messageContext.mo3124();
                    C1411Eb r133 = r113 != null ? mslContext.mo3159().mo4889(r113) : null;
                    eb2 = (r133 == null || !r133.m4871(r93)) ? null : r133;
                } else {
                    eb2 = null;
                }
                long r114 = DL.m4611(dd.m4591());
                C0057 r134 = new C0057(r7, messageContext);
                DL r15 = DL.m4610(mslContext, r93, eb2, r134.mo3125(), r114);
                if (mslContext.mo3166()) {
                    r15.m4628(r6.m4647(), r6.m4649());
                }
                DV r16 = r6.m4636();
                if (r16 == null || r16.equals(r93)) {
                    r15.m4616(true);
                }
                r15.m4622(r134.mo3134());
                return new C1295If(r15, r134);
            case REPLAYED:
                DV r94 = m3148(mslContext);
                if (r94 != null) {
                    String r115 = messageContext.mo3124();
                    C1411Eb r135 = r115 != null ? mslContext.mo3159().mo4889(r115) : null;
                    eb = (r135 == null || !r135.m4871(r94)) ? null : r135;
                } else {
                    eb = null;
                }
                long r116 = DL.m4611(dd.m4591());
                C0057 r136 = new C0057(r7, messageContext);
                DL r152 = DL.m4610(mslContext, r94, eb, r136.mo3125(), r116);
                if (mslContext.mo3166()) {
                    r152.m4628(r6.m4647(), r6.m4649());
                }
                r152.m4622(r136.mo3134());
                return new C1295If(r152, r136);
            default:
                return null;
        }
        DV r95 = m3148(mslContext);
        long r10 = DL.m4611(dd.m4591());
        C0057 r12 = new C0057(r7, messageContext);
        DL r14 = DL.m4610(mslContext, r95, null, r12.mo3125(), r10);
        if (mslContext.mo3166()) {
            r14.m4628(r6.m4647(), r6.m4649());
        }
        r14.m4622(r12.mo3134());
        return new C1295If(r14, r12);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3139(MslContext mslContext, DM dm, DD dd) {
        switch (dd.m4593()) {
            case ENTITYDATA_REAUTH:
            case ENTITY_REAUTH:
                m3150(mslContext, dm.m4636());
                return;
            case USERDATA_REAUTH:
            case USER_REAUTH:
                DV r2 = dm.m4636();
                C1411Eb r3 = dm.m4646();
                if (r2 != null && r3 != null) {
                    mslContext.mo3159().mo4887(r3);
                    return;
                }
                return;
            case SSOTOKEN_REJECTED:
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.msl.msg.MslControl$ʼ  reason: contains not printable characters */
    public static class C0052 {

        /* renamed from: ˋ  reason: contains not printable characters */
        public final DO f4176;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final boolean f4177;

        /* synthetic */ C0052(DO r1, boolean z, AnonymousClass4 r3) {
            this(r1, z);
        }

        private C0052(DO r1, boolean z) {
            this.f4176 = r1;
            this.f4177 = z;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private C0052 m3155(MslContext mslContext, MessageContext messageContext, OutputStream outputStream, DL dl, boolean z) {
        AbstractC1386Dc dc;
        DW r9;
        DV r4 = dl.m4617();
        C1411Eb r5 = dl.m4623();
        C1411Eb r6 = dl.m4626();
        boolean z2 = false;
        if (messageContext.mo3124() != null) {
            AbstractC1412Ec r10 = messageContext.mo3131(null, dl.m4613(), r5 == null);
            if (r10 != null) {
                if (!dl.m4629() || !dl.m4630()) {
                    z2 = true;
                } else {
                    dl.m4621(r10);
                }
            }
        }
        if (((!mslContext.mo3166() && r5 == null) || (mslContext.mo3166() && r6 == null)) && (r9 = messageContext.mo3129()) != null) {
            dl.m4624(r9);
            r5 = dl.m4623();
        }
        boolean z3 = !(!z2 && ((!messageContext.mo3122() || dl.m4625()) && ((!messageContext.mo3133() || dl.m4614()) && (!messageContext.mo3134() || (dl.m4615() && r4 != null)))));
        dl.m4627(z3);
        HashSet<AbstractC1408Dy> hashSet = new HashSet();
        if (dl.m4613()) {
            Date r12 = mslContext.m3181();
            if (r4 == null || r4.m4697(r12) || messageContext.mo3134()) {
                hashSet.addAll(messageContext.mo3132());
                for (AbstractC1408Dy dy : hashSet) {
                    dl.m4620(dy);
                }
            }
        }
        messageContext.mo3127(new DR(mslContext, messageContext, dl), z3);
        DM r13 = dl.m4631();
        DK r14 = messageContext.mo3128();
        if (r14 != null) {
            r14.mo4606(r13);
        }
        DB.C0083 r15 = dl.m4619();
        m3138(mslContext, r13, r15);
        m3145(mslContext, r15 != null ? r15.f5251.m4587() : r4, r5, r13.m4633());
        if (mslContext.mo3166() || r15 == null) {
            dc = r13.m4640();
        } else {
            dc = r15.f5252;
        }
        DO r20 = this.f4163.m4670(mslContext, this.f4161 != null ? this.f4161.m4595(outputStream) : outputStream, r13, dc);
        r20.m4659(z);
        if (!z3) {
            messageContext.mo3126(r20);
        }
        return new C0052(r20, z3, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private DP m3147(MslContext mslContext, MessageContext messageContext, InputStream inputStream, DM dm) {
        AbstractC1412Ec ec;
        C1411Eb eb;
        AbstractC1385Db db;
        DV dv;
        Set<DU> set;
        C1411Eb eb2;
        DV dv2;
        MslConstants.ResponseCode responseCode;
        HashSet hashSet = new HashSet();
        if (dm != null) {
            hashSet.addAll(dm.m4639());
        }
        DP r8 = this.f4163.m4671(mslContext, this.f4161 != null ? this.f4161.m4596(inputStream) : inputStream, hashSet, messageContext.mo3130());
        DM r9 = r8.m4669();
        DD r10 = r8.m4668();
        DK r11 = messageContext.mo3128();
        if (r11 != null) {
            r11.mo4607(r9 != null ? r9 : r10);
        }
        if (r9 != null) {
            dv = r9.m4636();
            db = r9.m4644();
            eb = r9.m4646();
            ec = r9.m4642();
        } else {
            dv = null;
            db = r10.m4590();
            eb = null;
            ec = null;
        }
        if (dm != null) {
            if (r10 != null) {
                try {
                    responseCode = r10.m4593();
                } catch (MslException e) {
                    e.mo3076(dv);
                    e.mo3077(db);
                    e.mo3086(eb);
                    e.mo3087(ec);
                    throw e;
                }
            } else {
                responseCode = null;
            }
            if (!(r9 == null && (responseCode == MslConstants.ResponseCode.FAIL || responseCode == MslConstants.ResponseCode.TRANSIENT_FAILURE || responseCode == MslConstants.ResponseCode.ENTITY_REAUTH || responseCode == MslConstants.ResponseCode.ENTITYDATA_REAUTH))) {
                long r17 = r9 != null ? r9.m4648() : r10.m4591();
                long r19 = DL.m4611(dm.m4648());
                if (r17 != r19) {
                    throw new MslMessageException(CK.f4799, "expected " + r19 + "; received " + r17);
                }
            }
        }
        String r16 = mslContext.mo3168((MslContext.ReauthCode) null).mo4706();
        if (r9 != null) {
            String r172 = dv != null ? r9.m4641() : db.mo4706();
            if (dv != null && dv.m4693() && !dv.m4691().equals(r172)) {
                throw new MslMessageException(CK.f4814, "sender " + r172 + "; master token " + dv.m4691());
            } else if (r16.equals(r172)) {
                throw new MslMessageException(CK.f4830, r172 + " == " + r16);
            } else {
                String r18 = r9.m4634();
                if (r18 == null || r18.equals(r16)) {
                    if (dm != null) {
                        m3140(mslContext, dm, r8);
                    }
                    DC r192 = r9.m4643();
                    if (!mslContext.mo3166()) {
                        dv2 = r192 != null ? r192.m4587() : r9.m4636();
                        eb2 = r9.m4646();
                        set = r9.m4633();
                    } else {
                        dv2 = r192 != null ? r192.m4587() : r9.m4647();
                        eb2 = r9.m4649();
                        set = r9.m4651();
                    }
                    String r23 = messageContext.mo3124();
                    if (!(r23 == null || eb2 == null || eb2.m4872())) {
                        mslContext.mo3159().mo4891(r23, eb2);
                    }
                    m3145(mslContext, dv2, eb2, set);
                } else {
                    throw new MslMessageException(CK.f4826, r18 + " != " + r16);
                }
            }
        } else {
            String r173 = r10.m4590().mo4706();
            if (r16.equals(r173)) {
                throw new MslMessageException(CK.f4814, r173);
            }
        }
        Date r174 = r9 != null ? r9.m4650() : r10.m4594();
        if (r174 != null && (dm != null || mslContext.mo3166())) {
            mslContext.m3182(r174);
        }
        return r8;
    }

    /* access modifiers changed from: package-private */
    public static class aux extends C0052 {

        /* renamed from: ˎ  reason: contains not printable characters */
        public final DP f4174;

        public aux(DP dp, C0052 r5) {
            super(r5.f4176, r5.f4177, null);
            this.f4174 = dp;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private aux m3142(MslContext mslContext, MessageContext messageContext, InputStream inputStream, OutputStream outputStream, DL dl, boolean z, boolean z2, int i) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1, true);
        try {
            boolean r8 = m3151(mslContext, messageContext, arrayBlockingQueue, dl, (long) i);
            DP dp = null;
            try {
                dl.m4616(r8);
                C0052 r9 = m3155(mslContext, messageContext, outputStream, dl, z2);
                DM r11 = r9.f4176.m4657();
                Set<AbstractC1408Dy> r12 = r11.m4639();
                if (z || r9.f4177 || !r12.isEmpty() || !(!r11.m4632() || r11.m4636() == null || r11.m4642() == null)) {
                    dp = m3147(mslContext, messageContext, inputStream, r11);
                    dp.m4664(z2);
                    DD r13 = dp.m4668();
                    if (r13 != null) {
                        m3139(mslContext, r11, r13);
                    }
                }
                return new aux(dp, r9);
            } finally {
                if (r8) {
                    m3149(mslContext, arrayBlockingQueue, dp);
                }
                m3152(mslContext, dl.m4617());
            }
        } catch (InterruptedException e) {
            m3152(mslContext, dl.m4617());
            return null;
        } catch (RuntimeException | TimeoutException e2) {
            m3152(mslContext, dl.m4617());
            throw e2;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m3151(MslContext mslContext, MessageContext messageContext, BlockingQueue<DV> blockingQueue, DL dl, long j) {
        DV r3 = dl.m4617();
        C1411Eb r4 = dl.m4623();
        String r5 = messageContext.mo3124();
        Date r6 = mslContext.m3181();
        if ((messageContext.mo3122() && !dl.m4625()) || ((messageContext.mo3133() && !dl.m4614()) || dl.m4613() || ((r3 == null && messageContext.mo3134()) || ((r3 != null && r3.m4692(r6)) || ((r4 == null && r5 != null && (!dl.m4629() || !dl.m4630())) || (messageContext.mo3123() && (r3 == null || (r5 != null && r4 == null)))))))) {
            while (true) {
                BlockingQueue<DV> putIfAbsent = this.f4159.putIfAbsent(mslContext, blockingQueue);
                if (putIfAbsent == null) {
                    return true;
                }
                DV poll = putIfAbsent.poll(j, TimeUnit.MILLISECONDS);
                if (poll == null) {
                    throw new TimeoutException("acquireRenewalLock timed out.");
                }
                putIfAbsent.add(poll);
                if (poll != this.f4164) {
                    if (r3 == null || !r3.equals(poll)) {
                        m3152(mslContext, r3);
                        r3 = m3148(mslContext);
                        if (r3 == null) {
                            continue;
                        }
                    }
                    if ((r5 != null && r4 == null) || (r4 != null && !r4.m4871(r3))) {
                        C1411Eb r10 = mslContext.mo3159().mo4889(r5);
                        r4 = (r10 == null || !r10.m4871(r3)) ? null : r10;
                    }
                    dl.m4618(r3, r4);
                    if (!r3.m4692(mslContext.m3181()) && (!dl.m4613() || !r3.equals(r3))) {
                        if (!messageContext.mo3123() || r4 != null) {
                            break;
                        }
                    }
                }
            }
        }
        Date r7 = mslContext.m3181();
        if ((r3 == null || r3.m4697(r7) || ((r4 == null && messageContext.mo3124() != null) || (r4 != null && r4.m4870(r7)))) && this.f4159.putIfAbsent(mslContext, blockingQueue) == null) {
            return true;
        }
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m3149(MslContext mslContext, BlockingQueue<DV> blockingQueue, DP dp) {
        if (this.f4159.get(mslContext) != blockingQueue) {
            throw new IllegalStateException("Attempt to release renewal lock that is not owned by this queue.");
        } else if (dp == null) {
            blockingQueue.add(this.f4164);
            this.f4159.remove(mslContext);
        } else {
            DM r2 = dp.m4669();
            if (r2 == null) {
                blockingQueue.add(this.f4164);
                this.f4159.remove(mslContext);
                return;
            }
            DC r3 = r2.m4643();
            if (r3 != null) {
                blockingQueue.add(r3.m4587());
            } else if (!mslContext.mo3166()) {
                DV r4 = r2.m4636();
                if (r4 != null) {
                    blockingQueue.add(r4);
                } else {
                    blockingQueue.add(this.f4164);
                }
            } else {
                DV r42 = r2.m4647();
                if (r42 != null) {
                    blockingQueue.add(r42);
                } else {
                    blockingQueue.add(this.f4164);
                }
            }
            this.f4159.remove(mslContext);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.msl.msg.MslControl$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final /* synthetic */ int[] f4165 = new int[ApplicationError.values().length];

        static {
            try {
                f4165[ApplicationError.ENTITY_REJECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4165[ApplicationError.USER_REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f4166 = new int[MslConstants.ResponseCode.values().length];
            try {
                f4166[MslConstants.ResponseCode.ENTITYDATA_REAUTH.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4166[MslConstants.ResponseCode.ENTITY_REAUTH.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4166[MslConstants.ResponseCode.USERDATA_REAUTH.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4166[MslConstants.ResponseCode.SSOTOKEN_REJECTED.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4166[MslConstants.ResponseCode.USER_REAUTH.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4166[MslConstants.ResponseCode.KEYX_REQUIRED.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f4166[MslConstants.ResponseCode.EXPIRED.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f4166[MslConstants.ResponseCode.REPLAYED.ordinal()] = 8;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* renamed from: com.netflix.msl.msg.MslControl$ˎ  reason: contains not printable characters */
    class CallableC0056 implements Callable<C0058> {

        /* renamed from: ʻ  reason: contains not printable characters */
        private final int f4179;

        /* renamed from: ʼ  reason: contains not printable characters */
        private DL f4180;

        /* renamed from: ʽ  reason: contains not printable characters */
        private final int f4181;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final AbstractC1403Dt f4182;

        /* renamed from: ˊॱ  reason: contains not printable characters */
        private boolean f4183 = false;

        /* renamed from: ˋ  reason: contains not printable characters */
        private InputStream f4184;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final MessageContext f4185;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final MslContext f4186;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private OutputStream f4188;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private boolean f4189;

        /* access modifiers changed from: package-private */
        /* renamed from: com.netflix.msl.msg.MslControl$ˎ$If */
        public class If extends FilterInputStream {

            /* renamed from: ॱ  reason: contains not printable characters */
            private final AbstractC1403Dt.If f4191;

            public If(AbstractC1403Dt.If r3) {
                super(null);
                this.f4191 = r3;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                if (this.in == null) {
                    this.in = this.f4191.mo4743();
                }
                return super.available();
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public void close() {
                if (this.in == null) {
                    this.in = this.f4191.mo4743();
                }
                super.close();
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public synchronized void mark(int i) {
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public boolean markSupported() {
                return false;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.in == null) {
                    this.in = this.f4191.mo4743();
                }
                return this.in.read();
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                if (this.in == null) {
                    this.in = this.f4191.mo4743();
                }
                return super.read(bArr, i, i2);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr) {
                if (this.in == null) {
                    this.in = this.f4191.mo4743();
                }
                return super.read(bArr);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public synchronized void reset() {
                if (this.in == null) {
                    this.in = this.f4191.mo4743();
                }
                super.reset();
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) {
                if (this.in == null) {
                    this.in = this.f4191.mo4743();
                }
                return super.skip(j);
            }
        }

        public CallableC0056(MslContext mslContext, MessageContext messageContext, AbstractC1403Dt dt, int i) {
            this.f4186 = mslContext;
            this.f4185 = messageContext;
            this.f4182 = dt;
            this.f4184 = null;
            this.f4188 = null;
            this.f4189 = false;
            this.f4180 = null;
            this.f4179 = i;
            this.f4181 = 0;
        }

        public CallableC0056(MslContext mslContext, MessageContext messageContext, AbstractC1403Dt dt, DL dl, int i, int i2) {
            this.f4186 = mslContext;
            this.f4185 = messageContext;
            this.f4182 = dt;
            this.f4184 = null;
            this.f4188 = null;
            this.f4189 = false;
            this.f4180 = dl;
            this.f4179 = i;
            this.f4181 = i2;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private C0058 m3179(MessageContext messageContext, DL dl, int i, int i2) {
            C0058 r15;
            if (i2 + 2 > 12) {
                MslControl.this.m3152(this.f4186, dl.m4617());
                this.f4183 = true;
                return null;
            }
            aux r9 = MslControl.this.m3142(this.f4186, messageContext, this.f4184, this.f4188, dl, true, this.f4189, i);
            DO r10 = r9.f4176;
            DP dp = r9.f4174;
            int i3 = i2 + 2;
            DM r12 = dp.m4669();
            if (r12 == null) {
                try {
                    r10.close();
                } catch (IOException e) {
                    if (MslControl.m3141(e)) {
                        return null;
                    }
                }
                try {
                    dp.close();
                } catch (IOException e2) {
                    if (MslControl.m3141(e2)) {
                        return null;
                    }
                }
                C1295If r14 = MslControl.this.m3153(this.f4186, messageContext, r9, dp.m4668());
                if (r14 == null) {
                    return new C0058(dp, null);
                }
                DL dl2 = r14.f4172;
                MessageContext messageContext2 = r14.f4173;
                if (!this.f4186.mo3166()) {
                    CallableC0056 r0 = new CallableC0056(this.f4186, messageContext2, this.f4182, dl2, i, i3);
                    r15 = r0.call();
                    this.f4183 = r0.f4183;
                } else {
                    r15 = m3179(messageContext2, dl2, i, i3);
                }
                if (this.f4183 || (r15 != null && r15.f4194 == null)) {
                    return new C0058(dp, null);
                }
                return r15;
            } else if (!this.f4186.mo3166()) {
                if (!r9.f4177) {
                    return new C0058(dp, r10);
                }
                try {
                    r10.close();
                } catch (IOException e3) {
                    if (MslControl.m3141(e3)) {
                        return null;
                    }
                }
                try {
                    dp.close();
                } catch (IOException e4) {
                    if (MslControl.m3141(e4)) {
                        return null;
                    }
                }
                return new CallableC0056(this.f4186, new C0057(null, messageContext), this.f4182, MslControl.this.m3137(this.f4186, messageContext, r12), i, i3).call();
            } else if (r9.f4177) {
                try {
                    r10.close();
                } catch (IOException e5) {
                    if (MslControl.m3141(e5)) {
                        return null;
                    }
                }
                try {
                    dp.close();
                } catch (IOException e6) {
                    if (MslControl.m3141(e6)) {
                        return null;
                    }
                }
                return m3179(new C0057(null, messageContext), MslControl.this.m3137(this.f4186, messageContext, r12), i, i3);
            } else if (r12.m4639().isEmpty() && (!r12.m4632() || r12.m4636() == null || r12.m4642() == null)) {
                return new C0058(dp, r10);
            } else {
                C1296iF iFVar = new C1296iF(messageContext);
                DL r152 = MslControl.this.m3137(this.f4186, iFVar, r12);
                try {
                    if (!dp.m4665()) {
                        try {
                            r10.close();
                        } catch (IOException e7) {
                            if (MslControl.m3141(e7)) {
                                return null;
                            }
                        }
                        r152.m4616(false);
                        C0058 r02 = new C0058(dp, MslControl.this.m3155(this.f4186, iFVar, this.f4188, r152, this.f4189).f4176);
                        MslControl.this.m3152(this.f4186, r152.m4617());
                        return r02;
                    }
                    try {
                        r10.close();
                    } catch (IOException e8) {
                        if (MslControl.m3141(e8)) {
                            MslControl.this.m3152(this.f4186, r152.m4617());
                            return null;
                        }
                    }
                    try {
                        dp.close();
                    } catch (IOException e9) {
                        if (MslControl.m3141(e9)) {
                            MslControl.this.m3152(this.f4186, r152.m4617());
                            return null;
                        }
                    }
                    C0058 r16 = m3179(iFVar, r152, i, i3);
                    MslControl.this.m3152(this.f4186, r152.m4617());
                    return r16;
                } finally {
                    MslControl.this.m3152(this.f4186, r152.m4617());
                }
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public C0058 call() {
            int i;
            if (this.f4184 == null || this.f4188 == null) {
                try {
                    this.f4182.mo4742(this.f4179);
                    long currentTimeMillis = System.currentTimeMillis();
                    AbstractC1403Dt.If r6 = this.f4182.mo4741();
                    this.f4188 = r6.mo4744();
                    this.f4184 = new If(r6);
                    i = this.f4179 - ((int) (System.currentTimeMillis() - currentTimeMillis));
                    this.f4189 = true;
                } catch (IOException e) {
                    if (this.f4180 != null) {
                        MslControl.this.m3152(this.f4186, this.f4180.m4617());
                    }
                    if (this.f4188 != null) {
                        try {
                            this.f4188.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (this.f4184 != null) {
                        try {
                            this.f4184.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (MslControl.m3141(e)) {
                        return null;
                    }
                    throw e;
                } catch (RuntimeException e4) {
                    if (this.f4180 != null) {
                        MslControl.this.m3152(this.f4186, this.f4180.m4617());
                    }
                    if (this.f4188 != null) {
                        try {
                            this.f4188.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (this.f4184 != null) {
                        try {
                            this.f4184.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e4;
                }
            } else {
                i = this.f4179;
            }
            if (this.f4180 == null) {
                try {
                    this.f4180 = MslControl.this.m3144(this.f4186, this.f4185);
                } catch (InterruptedException e7) {
                    if (!this.f4189) {
                        return null;
                    }
                    try {
                        this.f4188.close();
                    } catch (IOException e8) {
                    }
                    try {
                        this.f4184.close();
                        return null;
                    } catch (IOException e9) {
                        return null;
                    }
                }
            }
            try {
                C0058 r4 = m3179(this.f4185, this.f4180, i, this.f4181);
                if (!(r4 == null || r4.f4193 == null)) {
                    r4.f4193.m4658();
                }
                return r4;
            } catch (InterruptedException e10) {
                if (!this.f4189) {
                    return null;
                }
                try {
                    this.f4188.close();
                } catch (IOException e11) {
                }
                try {
                    this.f4184.close();
                    return null;
                } catch (IOException e12) {
                    return null;
                }
            } catch (MslException | IOException | RuntimeException | TimeoutException e13) {
                if (this.f4189) {
                    try {
                        this.f4188.close();
                    } catch (IOException e14) {
                    }
                    try {
                        this.f4184.close();
                    } catch (IOException e15) {
                    }
                }
                if (MslControl.m3141(e13)) {
                    return null;
                }
                throw e13;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Future<C0058> m3158(MslContext mslContext, MessageContext messageContext, AbstractC1403Dt dt, int i) {
        if (mslContext.mo3166()) {
            throw new IllegalStateException("This method cannot be used in peer-to-peer mode.");
        }
        return this.f4160.submit(new CallableC0056(mslContext, messageContext, dt, i));
    }
}
