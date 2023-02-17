package android.support.v7.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private EditText mEditText;
    private CharSequence mText;

    public static EditTextPreferenceDialogFragmentCompat newInstance(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mText = getEditTextPreference().getText();
        } else {
            this.mText = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.mText);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public void onBindDialogView(View view) {
        super.onBindDialogView(view);
        this.mEditText = (EditText) view.findViewById(16908291);
        if (this.mEditText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        this.mEditText.setText(this.mText);
    }

    private EditTextPreference getEditTextPreference() {
        return (EditTextPreference) getPreference();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public boolean needInputMethod() {
        return true;
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z) {
        if (z) {
            String obj = this.mEditText.getText().toString();
            if (getEditTextPreference().callChangeListener(obj)) {
                getEditTextPreference().setText(obj);
            }
        }
    }
}
