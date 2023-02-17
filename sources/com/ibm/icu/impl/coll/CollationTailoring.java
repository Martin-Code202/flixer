package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Trie2_32;
import com.ibm.icu.impl.coll.SharedObject;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.Map;
public final class CollationTailoring {
    static final /* synthetic */ boolean $assertionsDisabled = (!CollationTailoring.class.desiredAssertionStatus());
    public ULocale actualLocale = ULocale.ROOT;
    public CollationData data;
    public Map<Integer, Integer> maxExpansions;
    CollationData ownedData;
    private String rules;
    private UResourceBundle rulesResource;
    public SharedObject.Reference<CollationSettings> settings;
    Trie2_32 trie;
    UnicodeSet unsafeBackwardSet;
    public int version = 0;

    CollationTailoring(SharedObject.Reference<CollationSettings> reference) {
        if (reference == null) {
            this.settings = new SharedObject.Reference<>(new CollationSettings());
        } else if (!$assertionsDisabled && reference.readOnly().reorderCodes.length != 0) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && reference.readOnly().reorderTable != null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || reference.readOnly().minHighNoReorder == 0) {
            this.settings = reference.clone();
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureOwnedData() {
        if (this.ownedData == null) {
            this.ownedData = new CollationData(Norm2AllModes.getNFCInstance().impl);
        }
        this.data = this.ownedData;
    }

    /* access modifiers changed from: package-private */
    public void setRulesResource(UResourceBundle uResourceBundle) {
        if ($assertionsDisabled || (this.rules == null && this.rulesResource == null)) {
            this.rulesResource = uResourceBundle;
            return;
        }
        throw new AssertionError();
    }

    public String getRules() {
        if (this.rules != null) {
            return this.rules;
        }
        if (this.rulesResource != null) {
            return this.rulesResource.getString();
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public int getUCAVersion() {
        return ((this.version >> 12) & 4080) | ((this.version >> 14) & 3);
    }
}
