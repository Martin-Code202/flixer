package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DictionaryBreakEngine;
import java.text.CharacterIterator;
/* access modifiers changed from: package-private */
public class KhmerBreakEngine extends DictionaryBreakEngine {
    private static UnicodeSet fBeginWordSet = new UnicodeSet();
    private static UnicodeSet fEndWordSet = new UnicodeSet(fKhmerWordSet);
    private static UnicodeSet fKhmerWordSet = new UnicodeSet();
    private static UnicodeSet fMarkSet = new UnicodeSet();
    private DictionaryMatcher fDictionary = DictionaryData.loadDictionaryFor("Khmr");

    static {
        fKhmerWordSet.applyPattern("[[:Khmer:]&[:LineBreak=SA:]]");
        fKhmerWordSet.compact();
        fMarkSet.applyPattern("[[:Khmer:]&[:LineBreak=SA:]&[:M:]]");
        fMarkSet.add(32);
        fBeginWordSet.add(6016, 6067);
        fEndWordSet.remove(6098);
        fMarkSet.compact();
        fEndWordSet.compact();
        fBeginWordSet.compact();
        fKhmerWordSet.freeze();
        fMarkSet.freeze();
        fEndWordSet.freeze();
        fBeginWordSet.freeze();
    }

    public KhmerBreakEngine() {
        super(1, 2);
        setCharacters(fKhmerWordSet);
    }

    public boolean equals(Object obj) {
        return obj instanceof KhmerBreakEngine;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override // com.ibm.icu.text.DictionaryBreakEngine, com.ibm.icu.text.LanguageBreakEngine
    public boolean handles(int i, int i2) {
        return (i2 == 1 || i2 == 2) && UCharacter.getIntPropertyValue(i, 4106) == 23;
    }

    @Override // com.ibm.icu.text.DictionaryBreakEngine
    public int divideUpDictionaryRange(CharacterIterator characterIterator, int i, int i2, DictionaryBreakEngine.DequeI dequeI) {
        if (i2 - i < 4) {
            return 0;
        }
        int i3 = 0;
        DictionaryBreakEngine.PossibleWord[] possibleWordArr = new DictionaryBreakEngine.PossibleWord[3];
        for (int i4 = 0; i4 < 3; i4++) {
            possibleWordArr[i4] = new DictionaryBreakEngine.PossibleWord();
        }
        characterIterator.setIndex(i);
        while (true) {
            int index = characterIterator.getIndex();
            if (index >= i2) {
                break;
            }
            int i5 = 0;
            int candidates = possibleWordArr[i3 % 3].candidates(characterIterator, this.fDictionary, i2);
            if (candidates == 1) {
                i5 = possibleWordArr[i3 % 3].acceptMarked(characterIterator);
                i3++;
            } else if (candidates > 1) {
                boolean z = false;
                if (characterIterator.getIndex() < i2) {
                    do {
                        if (possibleWordArr[(i3 + 1) % 3].candidates(characterIterator, this.fDictionary, i2) > 0) {
                            if (1 < 2) {
                                possibleWordArr[i3 % 3].markCurrent();
                            }
                            if (characterIterator.getIndex() >= i2) {
                                break;
                            }
                            while (true) {
                                if (possibleWordArr[(i3 + 2) % 3].candidates(characterIterator, this.fDictionary, i2) <= 0) {
                                    if (!possibleWordArr[(i3 + 1) % 3].backUp(characterIterator)) {
                                        break;
                                    }
                                } else {
                                    possibleWordArr[i3 % 3].markCurrent();
                                    z = true;
                                    break;
                                }
                            }
                        }
                        if (!possibleWordArr[i3 % 3].backUp(characterIterator)) {
                            break;
                        }
                    } while (!z);
                }
                i5 = possibleWordArr[i3 % 3].acceptMarked(characterIterator);
                i3++;
            }
            if (characterIterator.getIndex() < i2 && i5 < 3) {
                if (possibleWordArr[i3 % 3].candidates(characterIterator, this.fDictionary, i2) > 0 || (i5 != 0 && possibleWordArr[i3 % 3].longestPrefix() >= 3)) {
                    characterIterator.setIndex(index + i5);
                } else {
                    int i6 = i2 - (index + i5);
                    char current = characterIterator.current();
                    int i7 = 0;
                    while (true) {
                        characterIterator.next();
                        char current2 = characterIterator.current();
                        i7++;
                        i6--;
                        if (i6 <= 0) {
                            break;
                        }
                        if (fEndWordSet.contains(current) && fBeginWordSet.contains(current2)) {
                            int candidates2 = possibleWordArr[(i3 + 1) % 3].candidates(characterIterator, this.fDictionary, i2);
                            characterIterator.setIndex(index + i5 + i7);
                            if (candidates2 > 0) {
                                break;
                            }
                        }
                        current = current2;
                    }
                    if (i5 <= 0) {
                        i3++;
                    }
                    i5 += i7;
                }
            }
            while (true) {
                int index2 = characterIterator.getIndex();
                if (index2 >= i2 || !fMarkSet.contains(characterIterator.current())) {
                    break;
                }
                characterIterator.next();
                i5 += characterIterator.getIndex() - index2;
            }
            if (i5 > 0) {
                dequeI.push(Integer.valueOf(index + i5).intValue());
            }
        }
        if (dequeI.peek() < i2) {
            return i3;
        }
        dequeI.pop();
        return i3 - 1;
    }
}
