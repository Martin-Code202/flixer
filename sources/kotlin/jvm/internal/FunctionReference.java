package kotlin.jvm.internal;

import o.C1457Fr;
import o.C1461Fv;
import o.FL;
import o.FP;
public class FunctionReference extends CallableReference implements FunctionBase, FP {
    private final int arity;

    public FunctionReference(int i) {
        this.arity = i;
    }

    public FunctionReference(int i, Object obj) {
        super(obj);
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public FP getReflected() {
        return (FP) super.getReflected();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public FL computeReflected() {
        return C1461Fv.m5034(this);
    }

    @Override // o.FP
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // o.FP
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // o.FP
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // o.FP
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // o.FP
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (getOwner() != null ? getOwner().equals(functionReference.getOwner()) : functionReference.getOwner() == null) {
                if (getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && C1457Fr.m5018(getBoundReceiver(), functionReference.getBoundReceiver())) {
                    return true;
                }
            }
            return false;
        } else if (obj instanceof FP) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        FL compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "<init>".equals(getName()) ? "constructor (Kotlin reflection is not available)" : "function " + getName() + " (Kotlin reflection is not available)";
    }
}
