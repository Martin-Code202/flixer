package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
public class StaticLoggerBinder {
    public static String REQUESTED_API_VERSION = "1.5.8";
    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
    private static final String loggerFactoryClassStr = AndroidLoggerFactory.class.getName();
    private final ILoggerFactory loggerFactory = new AndroidLoggerFactory();

    public static final StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    private StaticLoggerBinder() {
    }

    public ILoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    public String getLoggerFactoryClassStr() {
        return loggerFactoryClassStr;
    }
}
