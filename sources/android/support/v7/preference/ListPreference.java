package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
public class ListPreference extends DialogPreference {
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private String mSummary;
    private String mValue;
    private boolean mValueSet;

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, i, i2);
        this.mEntries = TypedArrayUtils.getTextArray(obtainStyledAttributes, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
        this.mEntryValues = TypedArrayUtils.getTextArray(obtainStyledAttributes, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i, i2);
        this.mSummary = TypedArrayUtils.getString(obtainStyledAttributes2, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.mEntries = charSequenceArr;
    }

    public CharSequence[] getEntries() {
        return this.mEntries;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.mEntryValues = charSequenceArr;
    }

    public CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    public void setValue(String str) {
        boolean z = !TextUtils.equals(this.mValue, str);
        if (z || !this.mValueSet) {
            this.mValue = str;
            this.mValueSet = true;
            persistString(str);
            if (z) {
                notifyChanged();
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0019: APUT  (r1v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r2v0 java.lang.CharSequence) */
    @Override // android.support.v7.preference.Preference
    public CharSequence getSummary() {
        CharSequence entry = getEntry();
        if (this.mSummary == null) {
            return super.getSummary();
        }
        String str = this.mSummary;
        Object[] objArr = new Object[1];
        objArr[0] = entry == null ? "" : entry;
        return String.format(str, objArr);
    }

    @Override // android.support.v7.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.mSummary != null) {
            this.mSummary = null;
        } else if (charSequence != null && !charSequence.equals(this.mSummary)) {
            this.mSummary = charSequence.toString();
        }
    }

    public String getValue() {
        return this.mValue;
    }

    public CharSequence getEntry() {
        int valueIndex = getValueIndex();
        if (valueIndex < 0 || this.mEntries == null) {
            return null;
        }
        return this.mEntries[valueIndex];
    }

    public int findIndexOfValue(String str) {
        if (str == null || this.mEntryValues == null) {
            return -1;
        }
        for (int length = this.mEntryValues.length - 1; length >= 0; length--) {
            if (this.mEntryValues[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    private int getValueIndex() {
        return findIndexOfValue(this.mValue);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.Preference
    public void onSetInitialValue(boolean z, Object obj) {
        setValue(z ? getPersistedString(this.mValue) : (String) obj);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.value = getValue();
        return savedState;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setValue(savedState.value);
    }

    /* access modifiers changed from: package-private */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.preference.ListPreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String value;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.value = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.value);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
