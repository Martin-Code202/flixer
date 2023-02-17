package com.netflix.model.leafs.originals;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface Tone {
    public static final String DARK = "dark";
    public static final String LIGHT = "light";
}
