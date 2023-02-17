package android.support.v7.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import java.util.ArrayList;
public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private int mClickedDialogEntryIndex;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;

    public static ListPreferenceDialogFragmentCompat newInstance(String str) {
        ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = new ListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragmentCompat.setArguments(bundle);
        return listPreferenceDialogFragmentCompat;
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference listPreference = getListPreference();
            if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.mClickedDialogEntryIndex = listPreference.findIndexOfValue(listPreference.getValue());
            this.mEntries = listPreference.getEntries();
            this.mEntryValues = listPreference.getEntryValues();
            return;
        }
        this.mClickedDialogEntryIndex = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.mEntries = getCharSequenceArray(bundle, "ListPreferenceDialogFragment.entries");
        this.mEntryValues = getCharSequenceArray(bundle, "ListPreferenceDialogFragment.entryValues");
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.mClickedDialogEntryIndex);
        putCharSequenceArray(bundle, "ListPreferenceDialogFragment.entries", this.mEntries);
        putCharSequenceArray(bundle, "ListPreferenceDialogFragment.entryValues", this.mEntryValues);
    }

    private static void putCharSequenceArray(Bundle bundle, String str, CharSequence[] charSequenceArr) {
        ArrayList<String> arrayList = new ArrayList<>(charSequenceArr.length);
        for (CharSequence charSequence : charSequenceArr) {
            arrayList.add(charSequence.toString());
        }
        bundle.putStringArrayList(str, arrayList);
    }

    private static CharSequence[] getCharSequenceArray(Bundle bundle, String str) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            return null;
        }
        return (CharSequence[]) stringArrayList.toArray(new CharSequence[stringArrayList.size()]);
    }

    private ListPreference getListPreference() {
        return (ListPreference) getPreference();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        builder.setSingleChoiceItems(this.mEntries, this.mClickedDialogEntryIndex, new DialogInterface.OnClickListener() { // from class: android.support.v7.preference.ListPreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ListPreferenceDialogFragmentCompat.this.mClickedDialogEntryIndex = i;
                ListPreferenceDialogFragmentCompat.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z) {
        ListPreference listPreference = getListPreference();
        if (z && this.mClickedDialogEntryIndex >= 0) {
            String charSequence = this.mEntryValues[this.mClickedDialogEntryIndex].toString();
            if (listPreference.callChangeListener(charSequence)) {
                listPreference.setValue(charSequence);
            }
        }
    }
}
