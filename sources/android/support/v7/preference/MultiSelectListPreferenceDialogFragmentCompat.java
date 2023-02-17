package android.support.v7.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private Set<String> mNewValues = new HashSet();
    private boolean mPreferenceChanged;

    public static MultiSelectListPreferenceDialogFragmentCompat newInstance(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            AbstractMultiSelectListPreference listPreference = getListPreference();
            if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.mNewValues.clear();
            this.mNewValues.addAll(listPreference.getValues());
            this.mPreferenceChanged = false;
            this.mEntries = listPreference.getEntries();
            this.mEntryValues = listPreference.getEntryValues();
            return;
        }
        this.mNewValues.clear();
        this.mNewValues.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.mPreferenceChanged = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.mEntries = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.mEntryValues = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.mNewValues));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.mPreferenceChanged);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.mEntries);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.mEntryValues);
    }

    private AbstractMultiSelectListPreference getListPreference() {
        return (AbstractMultiSelectListPreference) getPreference();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        int length = this.mEntryValues.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.mNewValues.contains(this.mEntryValues[i].toString());
        }
        builder.setMultiChoiceItems(this.mEntries, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: android.support.v7.preference.MultiSelectListPreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                if (z) {
                    MultiSelectListPreferenceDialogFragmentCompat.this.mPreferenceChanged |= MultiSelectListPreferenceDialogFragmentCompat.this.mNewValues.add(MultiSelectListPreferenceDialogFragmentCompat.this.mEntryValues[i2].toString());
                    return;
                }
                MultiSelectListPreferenceDialogFragmentCompat.this.mPreferenceChanged |= MultiSelectListPreferenceDialogFragmentCompat.this.mNewValues.remove(MultiSelectListPreferenceDialogFragmentCompat.this.mEntryValues[i2].toString());
            }
        });
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z) {
        AbstractMultiSelectListPreference listPreference = getListPreference();
        if (z && this.mPreferenceChanged) {
            Set<String> set = this.mNewValues;
            if (listPreference.callChangeListener(set)) {
                listPreference.setValues(set);
            }
        }
        this.mPreferenceChanged = false;
    }
}
