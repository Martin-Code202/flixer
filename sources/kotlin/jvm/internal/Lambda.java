package kotlin.jvm.internal;

import o.C1461Fv;
public abstract class Lambda implements FunctionBase {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    @Override // java.lang.Object
    public String toString() {
        return C1461Fv.m5036(this);
    }
}
