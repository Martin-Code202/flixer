package com.ibm.icu.util;
public abstract class Holiday implements DateRule {
    private static Holiday[] noHolidays = new Holiday[0];
    private String name;
    private DateRule rule;

    protected Holiday(String str, DateRule dateRule) {
        this.name = str;
        this.rule = dateRule;
    }
}
