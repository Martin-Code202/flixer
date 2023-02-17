package com.netflix.mediaclient.servicemgr.interface_.user;
public enum ProfileType {
    STANDARD("standard"),
    JFK("jfk");
    
    private String value;

    private ProfileType(String str) {
        this.value = str;
    }

    public static ProfileType create(String str) {
        ProfileType[] values = values();
        for (ProfileType profileType : values) {
            if (profileType.value.equalsIgnoreCase(str)) {
                return profileType;
            }
        }
        throw new IllegalStateException("Unknown profile type");
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.value;
    }
}
