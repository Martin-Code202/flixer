package org.slf4j.impl;

import android.util.Log;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
public class AndroidLogger extends MarkerIgnoringBase {
    private static final long serialVersionUID = -1227274521521287937L;

    AndroidLogger(String str) {
        this.name = str;
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj) {
        Log.d(this.name, format(str, obj, null));
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj, Object obj2) {
        Log.d(this.name, format(str, obj, obj2));
    }

    @Override // org.slf4j.Logger
    public void info(String str) {
        Log.i(this.name, str);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object obj) {
        Log.i(this.name, format(str, obj, null));
    }

    @Override // org.slf4j.Logger
    public void info(String str, Throwable th) {
        Log.i(this.name, str, th);
    }

    @Override // org.slf4j.Logger
    public void error(String str) {
        Log.e(this.name, str);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj) {
        Log.e(this.name, format(str, obj, null));
    }

    private String format(String str, Object obj, Object obj2) {
        return MessageFormatter.format(str, obj, obj2);
    }
}
