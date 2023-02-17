package com.netflix.mediaclient.service.logging.error;

import java.util.LinkedList;
import o.C1457Fr;
import o.C1532bG;
public final class ErrorLoggingDataCollector$breadcrumbs$1 extends LinkedList<String> {
    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.Deque
    public final boolean contains(Object obj) {
        if (obj instanceof String) {
            return m596((String) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.List, java.util.AbstractList
    public final int indexOf(Object obj) {
        if (obj instanceof String) {
            return m600((String) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.List, java.util.AbstractList
    public final int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return m601((String) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.Deque
    public final boolean remove(Object obj) {
        if (obj instanceof String) {
            return m598((String) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.Deque
    public final int size() {
        return m599();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m596(String str) {
        return super.contains(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m598(String str) {
        return super.remove(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m599() {
        return super.size();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m600(String str) {
        return super.indexOf(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m601(String str) {
        return super.lastIndexOf(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean add(String str) {
        C1457Fr.m5025(str, "element");
        boolean add = super.add(str);
        while (add) {
            int size = size();
            C1532bG bGVar = C1532bG.f6127;
            if (size <= C1532bG.f6129) {
                break;
            }
            super.remove();
        }
        return add;
    }
}
