package org.slf4j.impl;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.ILoggerFactory;
public class AndroidLoggerFactory implements ILoggerFactory {
    private final Map<String, AndroidLogger> loggerMap = new HashMap();

    @Override // org.slf4j.ILoggerFactory
    public AndroidLogger getLogger(String str) {
        AndroidLogger androidLogger;
        synchronized (this) {
            androidLogger = this.loggerMap.get(str);
            if (androidLogger == null) {
                androidLogger = new AndroidLogger(str);
                this.loggerMap.put(str, androidLogger);
            }
        }
        return androidLogger;
    }
}
