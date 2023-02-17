package o;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
/* renamed from: o.ᔄ  reason: contains not printable characters */
public final class C0859 implements Cloneable {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C0859 f14704 = new C0859(new ArrayList(0));

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List f14705;

    private C0859(List list) {
        this.f14705 = list;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public List<Object> m15533() {
        return this.f14705;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m15541() {
        if (this.f14705 == null) {
            return 0;
        }
        return this.f14705.size();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0859 m15540(C0859 r3) {
        ArrayList arrayList = new ArrayList(r3.f14705);
        arrayList.addAll(this.f14705);
        return new C0859(arrayList);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0859 m15535(C0859 r3) {
        ArrayList arrayList = new ArrayList(this.f14705);
        arrayList.addAll(r3.f14705);
        return new C0859(arrayList);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0859 m15542(Object obj) {
        ArrayList arrayList = new ArrayList(this.f14705);
        arrayList.add(m15518(obj));
        return new C0859(arrayList);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0859 m15538(int i, Object obj) {
        List r1 = C0463.m14349(m15533()).m14350();
        r1.set(i, obj);
        return new C0859(r1);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static List m15531(List list) {
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                List list2 = (List) obj;
                if (list2 == null || list2.size() != 1) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        list2.set(i2, m15518(list2.get(i2)));
                    }
                } else {
                    list.set(i, m15518(obj));
                }
            } else {
                list.set(i, m15518(obj));
            }
        }
        return list;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Object m15518(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 1) {
                obj = list.get(0);
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(NetflixActivity.EXTRA_FROM);
            if (obj2 == null) {
                map.put(NetflixActivity.EXTRA_FROM, 0);
            } else if (obj2 instanceof Long) {
                map.put(NetflixActivity.EXTRA_FROM, Integer.valueOf(((Long) obj2).intValue()));
            }
            Object obj3 = map.get("to");
            if (!(obj3 instanceof Long)) {
                return obj;
            }
            map.put("to", Integer.valueOf(((Long) obj3).intValue()));
            return obj;
        } else if (obj instanceof Integer) {
            return obj.toString();
        } else {
            if ((obj instanceof String) || (obj instanceof List)) {
                return obj;
            }
            C1276.m16820().mo5730(new IllegalArgumentException("Invalid PQL key " + (obj == null ? "null" : obj.getClass().getSimpleName())));
            return obj.toString();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0859 m15528(Object... objArr) {
        return new C0859(m15531(Arrays.asList(objArr)));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0859 m15524(List list) {
        return new C0859(m15531(list));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0859 m15527(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList(jsonArray.size());
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement next = it.next();
            if (next.isJsonPrimitive()) {
                arrayList.add(next.getAsString());
            } else if (next.isJsonArray()) {
                ArrayList arrayList2 = new ArrayList();
                JsonArray asJsonArray = next.getAsJsonArray();
                for (int i = 0; i < asJsonArray.size(); i++) {
                    arrayList2.add(jsonArray.get(i).toString());
                }
                arrayList.add(arrayList2);
            } else if (next.isJsonObject()) {
                JsonObject asJsonObject = next.getAsJsonObject();
                JsonElement jsonElement = asJsonObject.get("to");
                if (jsonElement != null) {
                    JsonElement jsonElement2 = asJsonObject.get(NetflixActivity.EXTRA_FROM);
                    HashMap hashMap = new HashMap();
                    hashMap.put("to", Long.valueOf(jsonElement.getAsLong()));
                    hashMap.put(NetflixActivity.EXTRA_FROM, Long.valueOf(jsonElement2 == null ? 0 : jsonElement2.getAsLong()));
                    arrayList.add(hashMap);
                }
            } else {
                C1276.m16820().mo5725("PQL.fromJsonArray: unknown json " + next);
            }
        }
        return m15524((List) arrayList);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0859 m15537(int i) {
        return m15534(i, this.f14705.size() - i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0859 m15534(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = i; i3 < i + i2; i3++) {
            arrayList.add(this.f14705.get(i3));
        }
        return new C0859(arrayList);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static List m15523(Object... objArr) {
        return Arrays.asList(objArr);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Map m15532(int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(NetflixActivity.EXTRA_FROM, Integer.valueOf(i));
        hashMap.put("to", Integer.valueOf(i2));
        return hashMap;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Map m15519(int i) {
        return m15532(0, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public LinkedHashSet<C0859> m15536() {
        List list = this.f14705;
        LinkedHashSet<C0859> linkedHashSet = new LinkedHashSet<>();
        Map map = null;
        Object[] objArr = new Object[this.f14705.size()];
        Integer[] numArr = new Integer[this.f14705.size()];
        Integer[] numArr2 = new Integer[this.f14705.size()];
        Integer[] numArr3 = new Integer[this.f14705.size()];
        int i = 0;
        if (list.size() == 0) {
            linkedHashSet.add(new C0859(list));
            return linkedHashSet;
        }
        int size = list.size() - 1;
        for (int i2 = 0; i2 <= size; i2++) {
            Object obj = list.get(i2);
            numArr[i2] = 0;
            numArr2[i2] = null;
            numArr3[i2] = Integer.valueOf(obj instanceof List ? ((List) obj).size() - 1 : 0);
        }
        while (i >= 0) {
            do {
                for (int i3 = i; i3 <= size; i3++) {
                    Object obj2 = list.get(i3);
                    if (obj2 instanceof List) {
                        obj2 = ((List) obj2).get(numArr[i3].intValue());
                    }
                    map = obj2 instanceof Map ? (Map) obj2 : null;
                    Integer num = map != null ? (Integer) map.get("to") : null;
                    if (num != null) {
                        Integer valueOf = Integer.valueOf(map.get(NetflixActivity.EXTRA_FROM) != null ? ((Integer) map.get(NetflixActivity.EXTRA_FROM)).intValue() : 0);
                        if (num.intValue() < valueOf.intValue()) {
                            throw new RuntimeException("Invalid range in path.  Range to value is smaller than from value (" + valueOf + " > " + num + ")");
                        }
                        if (numArr2[i3] == null) {
                            numArr2[i3] = valueOf;
                        }
                        objArr[i3] = numArr2[i3].toString();
                    } else {
                        objArr[i3] = obj2.toString();
                    }
                }
                linkedHashSet.add(new C0859(Arrays.asList((Object[]) objArr.clone())));
                i = size;
                if (numArr2[i] != null) {
                    Integer num2 = numArr2[i];
                    numArr2[i] = Integer.valueOf(numArr2[i].intValue() + 1);
                    if (map != null && numArr2[i].intValue() > ((Integer) map.get("to")).intValue()) {
                        numArr2[i] = null;
                        Integer num3 = numArr[i];
                        numArr[i] = Integer.valueOf(numArr[i].intValue() + 1);
                    }
                } else {
                    Integer num4 = numArr[i];
                    numArr[i] = Integer.valueOf(numArr[i].intValue() + 1);
                }
            } while (numArr[i].intValue() <= numArr3[i].intValue());
            numArr[i] = numArr3[i];
            while (i >= 0) {
                int intValue = numArr[i].intValue();
                Object obj3 = list.get(i);
                Object obj4 = obj3 instanceof List ? ((List) obj3).get(numArr[i].intValue()) : obj3;
                Map map2 = obj4 instanceof Map ? (Map) obj4 : null;
                Integer num5 = map2 != null ? (Integer) map2.get("to") : null;
                Integer num6 = map2 != null ? (Integer) map2.get(NetflixActivity.EXTRA_FROM) : null;
                if (!(intValue == numArr3[i].intValue() && (numArr2[i] == null || numArr2[i].equals(num5)))) {
                    break;
                }
                numArr[i] = 0;
                Object obj5 = list.get(i);
                if (obj5 instanceof List) {
                    ((List) obj5).get(numArr[i].intValue());
                }
                numArr2[i] = num5 != null ? Integer.valueOf(num6 != null ? num6.intValue() : 0) : null;
                i--;
            }
            if (i >= 0) {
                Object obj6 = list.get(i);
                Object obj7 = obj6 instanceof List ? ((List) obj6).get(numArr[i].intValue()) : obj6;
                Map map3 = obj7 instanceof Map ? (Map) obj7 : null;
                Integer num7 = map3 != null ? (Integer) map3.get("to") : null;
                Integer num8 = obj7 instanceof Map ? (Integer) map3.get(NetflixActivity.EXTRA_FROM) : null;
                if (num7 != null) {
                    numArr2[i] = Integer.valueOf(numArr2[i] == null ? num8 != null ? num8.intValue() : 0 : numArr2[i].intValue());
                }
                if (numArr2[i] == null || numArr2[i].equals(num7)) {
                    numArr2[i] = null;
                    Integer num9 = numArr[i];
                    numArr[i] = Integer.valueOf(numArr[i].intValue() + 1);
                } else {
                    Integer num10 = numArr2[i];
                    numArr2[i] = Integer.valueOf(numArr2[i].intValue() + 1);
                }
            }
        }
        return linkedHashSet;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m15539() {
        List list = this.f14705;
        int size = list.size();
        if (size <= 1) {
            return -1;
        }
        for (int i = 1; i < size; i++) {
            Object obj = list.get(i);
            if ((obj instanceof String) && "all".equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Double m15522(Object obj) {
        if ((obj instanceof Map) || (obj instanceof List)) {
            return null;
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (Exception e) {
                return null;
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            return (Double) obj;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Integer m15526(Object obj) {
        if (obj instanceof Map) {
            return null;
        }
        if (!(obj instanceof String)) {
            return (Integer) obj;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) obj));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m15521(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        } else if (obj2 == null) {
            return false;
        } else {
            return obj.equals(obj2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m15529(Object obj, Object obj2) {
        if (m15521(obj.toString(), obj2.toString())) {
            return true;
        }
        Map map = obj instanceof Map ? (Map) obj : null;
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        if (map != null && map2 != null && map.get("to") != null && m15521(map.get("to"), map2.get("to")) && m15521(map.get(NetflixActivity.EXTRA_FROM), map2.get(NetflixActivity.EXTRA_FROM))) {
            return true;
        }
        List list = obj instanceof List ? (List) obj : null;
        List list2 = obj2 instanceof List ? (List) obj2 : null;
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size() - 1;
        while (size >= 0 && m15529(list.get(size), list2.get(size))) {
            size--;
        }
        if (size < 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m15530(C0859 r30, C0859 r31) {
        List list = r30.f14705;
        List list2 = r31.f14705;
        int size = list.size();
        int size2 = list2.size();
        int i = size - size2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (i != 0) {
            return i;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof String) {
                arrayList2.add(Integer.valueOf(i2));
            } else {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        arrayList2.addAll(arrayList);
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = ((Integer) arrayList2.get(i3)).intValue();
            Object obj = list.get(intValue);
            Object obj2 = list2.get(intValue);
            List list3 = obj instanceof List ? (List) obj : null;
            List list4 = obj2 instanceof List ? (List) obj2 : null;
            if (list3 != null && list3.size() == 1 && list4 == null) {
                obj = list3.get(0);
                list3 = null;
            }
            if (list4 != null && list4.size() == 1 && list3 == null) {
                obj2 = list4.get(0);
                list4 = null;
            }
            if (list3 == null || list4 == null) {
                Map map = obj instanceof Map ? (Map) obj : null;
                if (map != null && (obj = map.get(NetflixActivity.EXTRA_FROM)) == null) {
                    obj = 0;
                }
                Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
                if (map2 != null && (obj2 = map2.get(NetflixActivity.EXTRA_FROM)) == null) {
                    obj2 = 0;
                }
                Double r13 = m15522(obj);
                Double r19 = m15522(obj2);
                if (!(r13 == null || r19 == null || r13.equals(r19))) {
                    return (int) (r13.doubleValue() - r19.doubleValue());
                }
                int compareTo = obj.toString().compareTo(obj2.toString());
                if (compareTo != 0) {
                    return compareTo;
                }
            } else {
                int size3 = list4.size() - list4.size();
                if (size3 != 0) {
                    return size3;
                }
                for (int i4 = 0; i4 < list3.size(); i4++) {
                    Object obj3 = list3.get(i4);
                    Object obj4 = list4.get(i4);
                    if (obj3 instanceof Map) {
                        obj3 = ((Map) obj3).get(NetflixActivity.EXTRA_FROM);
                    }
                    if (obj4 instanceof Map) {
                        obj4 = ((Map) obj4).get(NetflixActivity.EXTRA_FROM);
                    }
                    Double r16 = m15522(obj3);
                    Double r22 = m15522(obj4);
                    if (r22 == null || r22 == null || r16.equals(r22)) {
                        int compareTo2 = obj3.toString().compareTo(obj4.toString());
                        if (compareTo2 != 0) {
                            return compareTo2;
                        }
                    } else {
                        double doubleValue = r16.doubleValue() - r22.doubleValue();
                        if (doubleValue != 0.0d) {
                            return (int) doubleValue;
                        }
                    }
                }
                return 0;
            }
        }
        if (size > size2) {
            return 1;
        }
        if (size2 > size) {
            return -1;
        }
        return 0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m15520(List<C0859> list) {
        List list2;
        int size = list.size();
        C0859 r8 = null;
        C0859 r10 = null;
        boolean z = true;
        boolean z2 = false;
        if (list.size() >= 2) {
            Collections.sort(list, new Comparator<C0859>() { // from class: o.ᔄ.2
                /* renamed from: ˋ  reason: contains not printable characters */
                public int compare(C0859 r2, C0859 r3) {
                    return C0859.m15530(r2, r3);
                }
            });
            while (z) {
                z = false;
                int i = 0;
                int i2 = 0;
                int i3 = 1;
                int i4 = -1;
                while (i3 < size) {
                    r8 = list.get(i2);
                    List list3 = r8.f14705;
                    r10 = list.get(i3);
                    List list4 = r10.f14705;
                    Integer num = 100;
                    if (list3.size() == list4.size() && list3.size() > 1) {
                        num = 0;
                        for (int size2 = list3.size() - 1; size2 >= 0 && num.intValue() <= 1; size2--) {
                            if (!m15529(list3.get(size2), list4.get(size2))) {
                                num = Integer.valueOf(num.intValue() + 1);
                                i4 = size2;
                            }
                        }
                    }
                    if (num.intValue() == 1) {
                        Object obj = list3.get(i4);
                        if (!(obj instanceof List)) {
                            list2 = new ArrayList();
                            list2.add(obj);
                            list3.set(i4, list2);
                        } else if (obj instanceof ArrayList) {
                            list2 = (List) obj;
                        } else {
                            list2 = new ArrayList((List) obj);
                        }
                        Object obj2 = list2.get(list2.size() - 1);
                        Map map = obj2 instanceof Map ? (Map) obj2 : null;
                        Integer r13 = m15526(obj2);
                        Integer r16 = m15526(list4.get(i4));
                        if (map != null && map.get("to") != null && r16 != null && ((Integer) map.get("to")).equals(Integer.valueOf(r16.intValue() - 1))) {
                            map.put("to", Integer.valueOf(((Integer) map.get("to")).intValue() + 1));
                        } else if (r13 == null || r16 == null || !r13.equals(Integer.valueOf(r16.intValue() - 1))) {
                            list2.add(list4.get(i4));
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put(NetflixActivity.EXTRA_FROM, r13);
                            hashMap.put("to", r16);
                            list2.set(list2.size() - 1, hashMap);
                        }
                        z = true;
                        z2 = true;
                        i3++;
                    } else if (num.intValue() == 0) {
                        z = true;
                        z2 = true;
                        i3++;
                    } else {
                        z2 = false;
                        i4 = -1;
                        i2 = i3;
                        i3++;
                        list.set(i, r8);
                        i++;
                    }
                }
                if (!z2) {
                    list.set(i, r10);
                } else if (z) {
                    list.set(i, r8);
                }
                size = i + 1;
            }
            for (int size3 = list.size() - 1; size3 >= size; size3--) {
                list.remove(size3);
            }
            for (C0859 r0 : list) {
                m15531((List) r0.m15533());
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return ((Gson) C1281.m16832(Gson.class)).toJson(this.f14705);
    }

    @Override // java.lang.Object
    public Object clone() {
        return new C0859(new ArrayList(this.f14705));
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0859)) {
            return false;
        }
        C0859 r2 = (C0859) obj;
        if (this.f14705 == null) {
            if (r2.f14705 != null) {
                return false;
            }
            return true;
        } else if (!this.f14705.equals(r2.f14705)) {
            return false;
        } else {
            return true;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return toString().hashCode();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m15543() {
        return this.f14705 == null || this.f14705.size() == 0;
    }
}
