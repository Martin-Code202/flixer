package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import o.FL;
import o.FO;
import o.FT;
public abstract class CallableReference implements FL, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f4246;
    protected final Object receiver;
    private transient FL reflected;

    /* access modifiers changed from: protected */
    public abstract FL computeReflected();

    static class NoReceiver implements Serializable {

        /* renamed from: ॱ  reason: contains not printable characters */
        private static final NoReceiver f4246 = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() {
            return f4246;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    protected CallableReference(Object obj) {
        this.receiver = obj;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public FL compute() {
        FL fl = this.reflected;
        if (fl != null) {
            return fl;
        }
        FL computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    /* access modifiers changed from: protected */
    public FL getReflected() {
        FL compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public FO getOwner() {
        throw new AbstractMethodError();
    }

    @Override // o.FL
    public String getName() {
        throw new AbstractMethodError();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    @Override // o.FL
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    @Override // o.FL
    public FT getReturnType() {
        return getReflected().getReturnType();
    }

    @Override // o.FM
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override // o.FL
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // o.FL
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // o.FL
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @Override // o.FL
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // o.FL
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // o.FL
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // o.FL
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }
}
