package com.ibm.icu.impl.coll;
public final class CollationRoot {
    private static final RuntimeException exception;
    private static final CollationTailoring rootSingleton;

    public static final CollationTailoring getRoot() {
        if (exception == null) {
            return rootSingleton;
        }
        throw exception;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.RuntimeException] */
    /* JADX WARNING: Unknown variable types count: 1 */
    static {
        /*
            r3 = 0
            r4 = 0
            java.lang.String r0 = "coll/ucadata.icu"
            java.nio.ByteBuffer r5 = com.ibm.icu.impl.ICUBinary.getRequiredData(r0)     // Catch:{ IOException -> 0x0014, RuntimeException -> 0x0021 }
            com.ibm.icu.impl.coll.CollationTailoring r6 = new com.ibm.icu.impl.coll.CollationTailoring     // Catch:{ IOException -> 0x0014, RuntimeException -> 0x0021 }
            r0 = 0
            r6.<init>(r0)     // Catch:{ IOException -> 0x0014, RuntimeException -> 0x0021 }
            r0 = 0
            com.ibm.icu.impl.coll.CollationDataReader.read(r0, r5, r6)     // Catch:{ IOException -> 0x0014, RuntimeException -> 0x0021 }
            r3 = r6
            goto L_0x0023
        L_0x0014:
            r5 = move-exception
            java.util.MissingResourceException r4 = new java.util.MissingResourceException
            java.lang.String r0 = "IOException while reading CLDR root data"
            java.lang.String r1 = "CollationRoot"
            java.lang.String r2 = "data/icudt59b/coll/ucadata.icu"
            r4.<init>(r0, r1, r2)
            goto L_0x0023
        L_0x0021:
            r5 = move-exception
            r4 = r5
        L_0x0023:
            com.ibm.icu.impl.coll.CollationRoot.rootSingleton = r3
            com.ibm.icu.impl.coll.CollationRoot.exception = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.CollationRoot.<clinit>():void");
    }
}
