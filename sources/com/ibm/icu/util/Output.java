package com.ibm.icu.util;
public class Output<T> {
    public T value;

    public String toString() {
        return this.value == null ? "null" : this.value.toString();
    }

    public Output() {
    }

    public Output(T t) {
        this.value = t;
    }
}
