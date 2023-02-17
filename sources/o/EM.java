package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1;
public class EM extends EN {

    /* renamed from: o.EM$ˋ */
    public static final class C0085 implements FW<T> {

        /* renamed from: ˏ */
        final /* synthetic */ Iterable f5506;

        public C0085(Iterable iterable) {
            this.f5506 = iterable;
        }

        @Override // o.FW
        /* renamed from: ˊ */
        public Iterator<T> mo4843() {
            return this.f5506.iterator();
        }
    }

    /* renamed from: ˏ */
    public static final <T> T m4833(List<? extends T> list) {
        C1457Fr.m5025(list, "$receiver");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* renamed from: ˋ */
    public static final <T> T m4825(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        if (!(iterable instanceof List)) {
            Iterator<? extends T> it = iterable.iterator();
            if (!it.hasNext()) {
                return null;
            }
            return (T) it.next();
        } else if (((List) iterable).isEmpty()) {
            return null;
        } else {
            return (T) ((List) iterable).get(0);
        }
    }

    /* renamed from: ˎ */
    public static final <T> T m4828(List<? extends T> list) {
        C1457Fr.m5025(list, "$receiver");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    /* renamed from: ˏ */
    public static final <T> T m4834(List<? extends T> list, int i) {
        C1457Fr.m5025(list, "$receiver");
        if (i < 0 || i > EI.m4801((List) list)) {
            return null;
        }
        return (T) list.get(i);
    }

    /* renamed from: ˋ */
    public static final <T> int m4824(List<? extends T> list, T t) {
        C1457Fr.m5025(list, "$receiver");
        return list.indexOf(t);
    }

    /* renamed from: ˏ */
    public static final <T> T m4832(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        if (iterable instanceof List) {
            return (T) EI.m4840((List<? extends Object>) ((List) iterable));
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T t = (T) it.next();
        while (it.hasNext()) {
            t = (T) it.next();
        }
        return t;
    }

    /* renamed from: ॱॱ */
    public static final <T> T m4840(List<? extends T> list) {
        C1457Fr.m5025(list, "$receiver");
        if (!list.isEmpty()) {
            return (T) list.get(EI.m4801((List) list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* renamed from: ˊ */
    public static final <T> T m4820(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        if (iterable instanceof List) {
            return (T) EI.m4817((List<? extends Object>) ((List) iterable));
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T t = (T) it.next();
        if (!it.hasNext()) {
            return t;
        }
        throw new IllegalArgumentException("Collection has more than one element.");
    }

    /* renamed from: ʼ */
    public static final <T> T m4817(List<? extends T> list) {
        C1457Fr.m5025(list, "$receiver");
        switch (list.size()) {
            case 0:
                throw new NoSuchElementException("List is empty.");
            case 1:
                return (T) list.get(0);
            default:
                throw new IllegalArgumentException("List has more than one element.");
        }
    }

    /* renamed from: ˊ */
    public static final <T> List<T> m4822(Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        C1457Fr.m5025(iterable, "$receiver");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return EI.m4841(iterable);
        } else {
            if (iterable instanceof Collection) {
                int size = ((Collection) iterable).size() - i;
                if (size <= 0) {
                    return EI.m4805();
                }
                if (size == 1) {
                    return EI.m4806(EI.m4832(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int i2 = i;
                        int size2 = ((List) iterable).size() - 1;
                        if (i2 <= size2) {
                            while (true) {
                                arrayList.add(((List) iterable).get(i2));
                                if (i2 == size2) {
                                    break;
                                }
                                i2++;
                            }
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            int i3 = 0;
            for (Object obj : iterable) {
                i3++;
                if (i3 >= i) {
                    arrayList.add(obj);
                }
            }
            return EI.m4807((List) arrayList);
        }
    }

    /* renamed from: ॱ */
    public static final <T> List<T> m4838(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        return (List) EI.m4837((Iterable) iterable, new ArrayList());
    }

    /* renamed from: ॱ */
    public static final <C extends Collection<? super T>, T> C m4837(Iterable<? extends T> iterable, C c) {
        C1457Fr.m5025(iterable, "$receiver");
        C1457Fr.m5025(c, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                c.add(obj);
            }
        }
        return c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˎ */
    public static final <T> List<T> m4831(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        C1457Fr.m5025(iterable, "$receiver");
        C1457Fr.m5025(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> r2 = EI.m4816(iterable);
            EI.m4808((List) r2, (Comparator) comparator);
            return r2;
        } else if (((Collection) iterable).size() <= 1) {
            return EI.m4841(iterable);
        } else {
            Object[] array = ((Collection) iterable).toArray(new Object[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            } else if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                ED.m4793(array, comparator);
                return ED.m4792(array);
            }
        }
    }

    /* renamed from: ˎ */
    public static final <T, C extends Collection<? super T>> C m4829(Iterable<? extends T> iterable, C c) {
        C1457Fr.m5025(iterable, "$receiver");
        C1457Fr.m5025(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    /* renamed from: ˎ */
    public static final <T> HashSet<T> m4830(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        return (HashSet) EI.m4829(iterable, new HashSet(ES.m4860(EI.m4812(iterable, 12))));
    }

    /* renamed from: ॱॱ */
    public static final <T> List<T> m4841(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        if (!(iterable instanceof Collection)) {
            return EI.m4807(EI.m4816(iterable));
        }
        switch (((Collection) iterable).size()) {
            case 0:
                return EI.m4805();
            case 1:
                return EI.m4806(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            default:
                return EI.m4835((Collection) iterable);
        }
    }

    /* renamed from: ʻ */
    public static final <T> List<T> m4816(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        if (iterable instanceof Collection) {
            return EI.m4835((Collection) iterable);
        }
        return (List) EI.m4829(iterable, new ArrayList());
    }

    /* renamed from: ˏ */
    public static final <T> List<T> m4835(Collection<? extends T> collection) {
        C1457Fr.m5025(collection, "$receiver");
        return new ArrayList(collection);
    }

    /* renamed from: ᐝ */
    public static final <T> Iterable<EL<T>> m4842(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        return new EP(new CollectionsKt___CollectionsKt$withIndex$1(iterable));
    }

    /* renamed from: ॱ */
    public static final <T> Set<T> m4839(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        C1457Fr.m5025(iterable, "$receiver");
        C1457Fr.m5025(iterable2, "other");
        Set<T> r1 = EI.m4818(iterable);
        EI.m4809(r1, iterable2);
        return r1;
    }

    /* renamed from: ʼ */
    public static final <T> Set<T> m4818(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) EI.m4829(iterable, new LinkedHashSet());
    }

    /* renamed from: ˊ */
    public static final <T> List<T> m4823(Iterable<? extends T> iterable, T t) {
        boolean z;
        C1457Fr.m5025(iterable, "$receiver");
        ArrayList arrayList = new ArrayList(EI.m4812(iterable, 10));
        boolean z2 = false;
        for (Object obj : iterable) {
            if (z2 || !C1457Fr.m5018(obj, (Object) t)) {
                z = true;
            } else {
                z2 = true;
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: ˋ */
    public static final <T> List<T> m4826(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        C1457Fr.m5025(collection, "$receiver");
        C1457Fr.m5025(iterable, "elements");
        if (iterable instanceof Collection) {
            ArrayList arrayList = new ArrayList(collection.size() + ((Collection) iterable).size());
            arrayList.addAll(collection);
            arrayList.addAll((Collection) iterable);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        EI.m4810(arrayList2, iterable);
        return arrayList2;
    }

    /* renamed from: ˎ */
    public static final <T, A extends Appendable> A m4827(Iterable<? extends T> iterable, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, AbstractC1450Fk<? super T, ? extends CharSequence> fk) {
        C1457Fr.m5025(iterable, "$receiver");
        C1457Fr.m5025(a, "buffer");
        C1457Fr.m5025(charSequence, "separator");
        C1457Fr.m5025(charSequence2, "prefix");
        C1457Fr.m5025(charSequence3, "postfix");
        C1457Fr.m5025(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            Ge.m5061(a, obj, fk);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    /* renamed from: ॱ */
    public static /* synthetic */ String m4836(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, AbstractC1450Fk fk, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
            fk = null;
        }
        return EI.m4821(iterable, charSequence, charSequence2, charSequence3, i, charSequence4, fk);
    }

    /* renamed from: ˊ */
    public static final <T> String m4821(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, AbstractC1450Fk<? super T, ? extends CharSequence> fk) {
        C1457Fr.m5025(iterable, "$receiver");
        C1457Fr.m5025(charSequence, "separator");
        C1457Fr.m5025(charSequence2, "prefix");
        C1457Fr.m5025(charSequence3, "postfix");
        C1457Fr.m5025(charSequence4, "truncated");
        String sb = ((StringBuilder) EI.m4827(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, fk)).toString();
        C1457Fr.m5016((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    /* renamed from: ʽ */
    public static final <T> FW<T> m4819(Iterable<? extends T> iterable) {
        C1457Fr.m5025(iterable, "$receiver");
        return new C0085(iterable);
    }
}
