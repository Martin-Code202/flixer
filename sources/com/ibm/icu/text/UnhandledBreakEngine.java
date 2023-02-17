package com.ibm.icu.text;

import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DictionaryBreakEngine;
import java.text.CharacterIterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* access modifiers changed from: package-private */
public final class UnhandledBreakEngine implements LanguageBreakEngine {
    final AtomicReferenceArray<UnicodeSet> fHandled = new AtomicReferenceArray<>(5);

    public UnhandledBreakEngine() {
        for (int i = 0; i < this.fHandled.length(); i++) {
            this.fHandled.set(i, new UnicodeSet());
        }
    }

    @Override // com.ibm.icu.text.LanguageBreakEngine
    public boolean handles(int i, int i2) {
        return i2 >= 0 && i2 < this.fHandled.length() && this.fHandled.get(i2).contains(i);
    }

    @Override // com.ibm.icu.text.LanguageBreakEngine
    public int findBreaks(CharacterIterator characterIterator, int i, int i2, boolean z, int i3, DictionaryBreakEngine.DequeI dequeI) {
        if (i3 < 0 || i3 >= this.fHandled.length()) {
            return 0;
        }
        UnicodeSet unicodeSet = this.fHandled.get(i3);
        int current32 = CharacterIteration.current32(characterIterator);
        if (z) {
            while (characterIterator.getIndex() > i && unicodeSet.contains(current32)) {
                CharacterIteration.previous32(characterIterator);
                current32 = CharacterIteration.current32(characterIterator);
            }
            return 0;
        }
        while (characterIterator.getIndex() < i2 && unicodeSet.contains(current32)) {
            CharacterIteration.next32(characterIterator);
            current32 = CharacterIteration.current32(characterIterator);
        }
        return 0;
    }

    public void handleChar(int i, int i2) {
        if (i2 >= 0 && i2 < this.fHandled.length() && i != Integer.MAX_VALUE) {
            UnicodeSet unicodeSet = this.fHandled.get(i2);
            if (!unicodeSet.contains(i)) {
                int intPropertyValue = UCharacter.getIntPropertyValue(i, 4106);
                UnicodeSet unicodeSet2 = new UnicodeSet();
                unicodeSet2.applyIntPropertyValue(4106, intPropertyValue);
                unicodeSet2.addAll(unicodeSet);
                this.fHandled.set(i2, unicodeSet2);
            }
        }
    }
}
