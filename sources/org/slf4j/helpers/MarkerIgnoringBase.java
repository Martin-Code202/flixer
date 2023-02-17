package org.slf4j.helpers;
public abstract class MarkerIgnoringBase extends NamedLoggerBase {
    @Override // org.slf4j.helpers.NamedLoggerBase
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }
}
