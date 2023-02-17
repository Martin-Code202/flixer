package android.support.v7.preference.internal;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;
import java.util.Set;
public abstract class AbstractMultiSelectListPreference extends DialogPreference {
    public abstract CharSequence[] getEntries();

    public abstract CharSequence[] getEntryValues();

    public abstract Set<String> getValues();

    public abstract void setValues(Set<String> set);

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
