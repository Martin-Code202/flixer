package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
public class SubstituteLoggerFactory implements ILoggerFactory {
    final List loggerNameList = new ArrayList();

    @Override // org.slf4j.ILoggerFactory
    public Logger getLogger(String str) {
        this.loggerNameList.add(str);
        return NOPLogger.NOP_LOGGER;
    }

    public List getLoggerNameList() {
        return this.loggerNameList;
    }
}
