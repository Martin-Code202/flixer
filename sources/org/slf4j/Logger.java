package org.slf4j;
public interface Logger {
    void debug(String str, Object obj);

    void debug(String str, Object obj, Object obj2);

    void error(String str);

    void error(String str, Object obj);

    void info(String str);

    void info(String str, Object obj);

    void info(String str, Throwable th);
}
