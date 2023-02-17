package android.support.v7.preference;

import java.util.Set;
public abstract class PreferenceDataStore {
    public void putString(String str, String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String str, Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String str, int i) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putBoolean(String str, boolean z) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public String getString(String str, String str2) {
        return str2;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return set;
    }

    public int getInt(String str, int i) {
        return i;
    }

    public boolean getBoolean(String str, boolean z) {
        return z;
    }
}
