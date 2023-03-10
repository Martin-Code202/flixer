package io.realm;
public enum Case {
    SENSITIVE(true),
    INSENSITIVE(false);
    
    private final boolean value;

    private Case(boolean z) {
        this.value = z;
    }

    public boolean getValue() {
        return this.value;
    }
}
