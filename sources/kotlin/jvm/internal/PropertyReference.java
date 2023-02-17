package kotlin.jvm.internal;

import o.C1457Fr;
import o.FL;
import o.FQ;
public abstract class PropertyReference extends CallableReference implements FQ {
    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public FQ getReflected() {
        return (FQ) super.getReflected();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && C1457Fr.m5018(getBoundReceiver(), propertyReference.getBoundReceiver());
        } else if (obj instanceof FQ) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        FL compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
