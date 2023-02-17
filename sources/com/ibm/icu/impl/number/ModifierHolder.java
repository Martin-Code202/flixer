package com.ibm.icu.impl.number;

import java.util.ArrayDeque;
import java.util.Iterator;
public class ModifierHolder {
    private ArrayDeque<Modifier> mods = new ArrayDeque<>();

    public ModifierHolder clear() {
        this.mods.clear();
        return this;
    }

    public void add(Modifier modifier) {
        if (modifier != null) {
            this.mods.addFirst(modifier);
        }
    }

    public int applyAll(NumberStringBuilder numberStringBuilder, int i, int i2) {
        int i3 = 0;
        while (!this.mods.isEmpty()) {
            i3 += this.mods.removeFirst().apply(numberStringBuilder, i, i2 + i3);
        }
        return i3;
    }

    public int applyStrong(NumberStringBuilder numberStringBuilder, int i, int i2) {
        int i3 = 0;
        while (!this.mods.isEmpty() && this.mods.peekFirst().isStrong()) {
            i3 += this.mods.removeFirst().apply(numberStringBuilder, i, i2 + i3);
        }
        return i3;
    }

    public int totalLength() {
        int i = 0;
        Iterator<Modifier> it = this.mods.iterator();
        while (it.hasNext()) {
            Modifier next = it.next();
            if (next != null) {
                i += next.length();
            }
        }
        return i;
    }
}
