package o;

import kotlin.TypeCastException;
/* renamed from: o.Fh  reason: case insensitive filesystem */
public final class C1447Fh {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <T> Class<T> m5005(FN<T> fn) {
        C1457Fr.m5025(fn, "$receiver");
        Class<T> cls = (Class<T>) ((AbstractC1454Fo) fn).mo5011();
        if (!cls.isPrimitive()) {
            String name = cls.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2056817302:
                        if (name.equals("java.lang.Integer")) {
                            return Integer.TYPE;
                        }
                        break;
                    case -527879800:
                        if (name.equals("java.lang.Float")) {
                            return Float.TYPE;
                        }
                        break;
                    case -515992664:
                        if (name.equals("java.lang.Short")) {
                            return Short.TYPE;
                        }
                        break;
                    case 155276373:
                        if (name.equals("java.lang.Character")) {
                            return Character.TYPE;
                        }
                        break;
                    case 344809556:
                        if (name.equals("java.lang.Boolean")) {
                            return Boolean.TYPE;
                        }
                        break;
                    case 398507100:
                        if (name.equals("java.lang.Byte")) {
                            return Byte.TYPE;
                        }
                        break;
                    case 398795216:
                        if (name.equals("java.lang.Long")) {
                            return Long.TYPE;
                        }
                        break;
                    case 761287205:
                        if (name.equals("java.lang.Double")) {
                            return Double.TYPE;
                        }
                        break;
                }
            }
            return null;
        } else if (cls != null) {
            return cls;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0099 A[RETURN] */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Class<T> m5006(o.FN<T> r5) {
        /*
            java.lang.String r0 = "$receiver"
            o.C1457Fr.m5025(r5, r0)
            r0 = r5
            o.Fo r0 = (o.AbstractC1454Fo) r0
            java.lang.Class r3 = r0.mo5011()
            boolean r0 = r3.isPrimitive()
            if (r0 != 0) goto L_0x001d
            if (r3 != 0) goto L_0x001c
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.Class<T>"
            r0.<init>(r1)
            throw r0
        L_0x001c:
            return r3
        L_0x001d:
            java.lang.String r4 = r3.getName()
            if (r4 != 0) goto L_0x0025
            goto L_0x008e
        L_0x0025:
            int r0 = r4.hashCode()
            switch(r0) {
                case -1325958191: goto L_0x0040;
                case 104431: goto L_0x0064;
                case 3039496: goto L_0x0037;
                case 3052374: goto L_0x0049;
                case 3327612: goto L_0x006d;
                case 64711720: goto L_0x002e;
                case 97526364: goto L_0x005b;
                case 109413500: goto L_0x0052;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x008e
        L_0x002e:
            java.lang.String r0 = "boolean"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x008e
            goto L_0x0076
        L_0x0037:
            java.lang.String r0 = "byte"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x008e
            goto L_0x007c
        L_0x0040:
            java.lang.String r0 = "double"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x008e
            goto L_0x008b
        L_0x0049:
            java.lang.String r0 = "char"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x008e
            goto L_0x0079
        L_0x0052:
            java.lang.String r0 = "short"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x008e
            goto L_0x007f
        L_0x005b:
            java.lang.String r0 = "float"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x008e
            goto L_0x0085
        L_0x0064:
            java.lang.String r0 = "int"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x008e
            goto L_0x0082
        L_0x006d:
            java.lang.String r0 = "long"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x008e
            goto L_0x0088
        L_0x0076:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            goto L_0x008f
        L_0x0079:
            java.lang.Class<java.lang.Character> r0 = java.lang.Character.class
            goto L_0x008f
        L_0x007c:
            java.lang.Class<java.lang.Byte> r0 = java.lang.Byte.class
            goto L_0x008f
        L_0x007f:
            java.lang.Class<java.lang.Short> r0 = java.lang.Short.class
            goto L_0x008f
        L_0x0082:
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            goto L_0x008f
        L_0x0085:
            java.lang.Class<java.lang.Float> r0 = java.lang.Float.class
            goto L_0x008f
        L_0x0088:
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            goto L_0x008f
        L_0x008b:
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            goto L_0x008f
        L_0x008e:
            r0 = r3
        L_0x008f:
            if (r0 != 0) goto L_0x0099
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.Class<T>"
            r1.<init>(r2)
            throw r1
        L_0x0099:
            return r0
            switch-data {-1325958191->0x0040, 104431->0x0064, 3039496->0x0037, 3052374->0x0049, 3327612->0x006d, 64711720->0x002e, 97526364->0x005b, 109413500->0x0052, }
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1447Fh.m5006(o.FN):java.lang.Class");
    }
}
