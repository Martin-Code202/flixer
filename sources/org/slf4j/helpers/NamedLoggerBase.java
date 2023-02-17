package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public abstract class NamedLoggerBase implements Logger, Serializable {
    protected String name;

    NamedLoggerBase() {
    }

    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return LoggerFactory.getLogger(getName());
    }
}
