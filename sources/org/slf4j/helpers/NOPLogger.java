package org.slf4j.helpers;
public class NOPLogger extends MarkerIgnoringBase {
    public static final NOPLogger NOP_LOGGER = new NOPLogger();
    private static final long serialVersionUID = -517220405410904473L;

    protected NOPLogger() {
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public String getName() {
        return "NOP";
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj) {
    }
}
