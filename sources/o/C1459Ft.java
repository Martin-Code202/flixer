package o;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* renamed from: o.Ft  reason: case insensitive filesystem */
public final class C1459Ft implements FN<Object>, AbstractC1454Fo {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Class<?> f5679;

    public C1459Ft(Class<?> cls) {
        C1457Fr.m5025(cls, "jClass");
        this.f5679 = cls;
    }

    @Override // o.AbstractC1454Fo
    /* renamed from: ˎ */
    public Class<?> mo5011() {
        return this.f5679;
    }

    @Override // o.FM
    public List<Annotation> getAnnotations() {
        m5028();
        throw null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Void m5028() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1459Ft) && C1457Fr.m5018(C1447Fh.m5006(this), C1447Fh.m5006((FN) obj));
    }

    public int hashCode() {
        return C1447Fh.m5006(this).hashCode();
    }

    public String toString() {
        return mo5011().toString() + " (Kotlin reflection is not available)";
    }
}
