package com.ibm.icu.text;

import com.ibm.icu.text.DictionaryBreakEngine;
import java.text.CharacterIterator;
/* access modifiers changed from: package-private */
public interface LanguageBreakEngine {
    int findBreaks(CharacterIterator characterIterator, int i, int i2, boolean z, int i3, DictionaryBreakEngine.DequeI dequeI);

    boolean handles(int i, int i2);
}
