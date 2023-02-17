package android.support.v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* access modifiers changed from: package-private */
public class PreferenceInflater {
    private static final HashMap<String, Constructor> CONSTRUCTOR_MAP = new HashMap<>();
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class};
    private final Object[] mConstructorArgs = new Object[2];
    private final Context mContext;
    private String[] mDefaultPackages;
    private PreferenceManager mPreferenceManager;

    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        this.mContext = context;
        init(preferenceManager);
    }

    private void init(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        setDefaultPackages(new String[]{"android.support.v14.preference.", "android.support.v7.preference."});
    }

    public void setDefaultPackages(String[] strArr) {
        this.mDefaultPackages = strArr;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Preference inflate(int i, PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = getContext().getResources().getXml(i);
        try {
            return inflate(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    public Preference inflate(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup onMergeRoots;
        synchronized (this.mConstructorArgs) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.mConstructorArgs[0] = this.mContext;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e) {
                    throw e;
                } catch (XmlPullParserException e2) {
                    InflateException inflateException = new InflateException(e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (IOException e3) {
                    InflateException inflateException2 = new InflateException(xmlPullParser.getPositionDescription() + ": " + e3.getMessage());
                    inflateException2.initCause(e3);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            onMergeRoots = onMergeRoots(preferenceGroup, (PreferenceGroup) createItemFromTag(xmlPullParser.getName(), asAttributeSet));
            rInflate(xmlPullParser, onMergeRoots, asAttributeSet);
        }
        return onMergeRoots;
    }

    private PreferenceGroup onMergeRoots(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.onAttachedToHierarchy(this.mPreferenceManager);
        return preferenceGroup2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        r6 = r11;
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
        r5 = new android.view.InflateException(r15.getPositionDescription() + ": Error inflating class " + r13);
        r5.initCause(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083 A[ExcHandler: Exception (r4v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:2:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.support.v7.preference.Preference createItem(java.lang.String r13, java.lang.String[] r14, android.util.AttributeSet r15) {
        /*
            r12 = this;
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor> r0 = android.support.v7.preference.PreferenceInflater.CONSTRUCTOR_MAP
            java.lang.Object r0 = r0.get(r13)
            r3 = r0
            java.lang.reflect.Constructor r3 = (java.lang.reflect.Constructor) r3
            if (r3 != 0) goto L_0x0075
            android.content.Context r0 = r12.mContext     // Catch:{ ClassNotFoundException -> 0x0081, Exception -> 0x0083 }
            java.lang.ClassLoader r4 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0081, Exception -> 0x0083 }
            r5 = 0
            if (r14 == 0) goto L_0x0017
            int r0 = r14.length     // Catch:{ ClassNotFoundException -> 0x0081, Exception -> 0x0083 }
            if (r0 != 0) goto L_0x001c
        L_0x0017:
            java.lang.Class r5 = r4.loadClass(r13)     // Catch:{ ClassNotFoundException -> 0x0081, Exception -> 0x0083 }
            goto L_0x0066
        L_0x001c:
            r6 = 0
            r7 = r14
            int r8 = r7.length     // Catch:{ ClassNotFoundException -> 0x0081, Exception -> 0x0083 }
            r9 = 0
        L_0x0020:
            if (r9 >= r8) goto L_0x0040
            r10 = r7[r9]     // Catch:{ ClassNotFoundException -> 0x0081, Exception -> 0x0083 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x003b, Exception -> 0x0083 }
            r0.<init>()     // Catch:{ ClassNotFoundException -> 0x003b, Exception -> 0x0083 }
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch:{ ClassNotFoundException -> 0x003b, Exception -> 0x0083 }
            java.lang.StringBuilder r0 = r0.append(r13)     // Catch:{ ClassNotFoundException -> 0x003b, Exception -> 0x0083 }
            java.lang.String r0 = r0.toString()     // Catch:{ ClassNotFoundException -> 0x003b, Exception -> 0x0083 }
            java.lang.Class r0 = r4.loadClass(r0)     // Catch:{ ClassNotFoundException -> 0x003b, Exception -> 0x0083 }
            r5 = r0
            goto L_0x0040
        L_0x003b:
            r11 = move-exception
            r6 = r11
            int r9 = r9 + 1
            goto L_0x0020
        L_0x0040:
            if (r5 != 0) goto L_0x0066
            if (r6 != 0) goto L_0x0065
            android.view.InflateException r0 = new android.view.InflateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r15.getPositionDescription()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ": Error inflating class "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r13)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0065:
            throw r6
        L_0x0066:
            java.lang.Class<?>[] r0 = android.support.v7.preference.PreferenceInflater.CONSTRUCTOR_SIGNATURE
            java.lang.reflect.Constructor r3 = r5.getConstructor(r0)
            r0 = 1
            r3.setAccessible(r0)
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor> r0 = android.support.v7.preference.PreferenceInflater.CONSTRUCTOR_MAP
            r0.put(r13, r3)
        L_0x0075:
            java.lang.Object[] r4 = r12.mConstructorArgs
            r0 = 1
            r4[r0] = r15
            java.lang.Object r0 = r3.newInstance(r4)
            android.support.v7.preference.Preference r0 = (android.support.v7.preference.Preference) r0
            return r0
        L_0x0081:
            r4 = move-exception
            throw r4
        L_0x0083:
            r4 = move-exception
            android.view.InflateException r5 = new android.view.InflateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r15.getPositionDescription()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ": Error inflating class "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r13)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            r5.initCause(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.preference.PreferenceInflater.createItem(java.lang.String, java.lang.String[], android.util.AttributeSet):android.support.v7.preference.Preference");
    }

    /* access modifiers changed from: protected */
    public Preference onCreateItem(String str, AttributeSet attributeSet) {
        return createItem(str, this.mDefaultPackages, attributeSet);
    }

    private Preference createItemFromTag(String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return onCreateItem(str, attributeSet);
            }
            return createItem(str, null, attributeSet);
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e2) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    private void rInflate(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.setIntent(Intent.parseIntent(getContext().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    getContext().getResources().parseBundleExtra("extra", attributeSet, preference.getExtras());
                    try {
                        skipCurrentTag(xmlPullParser);
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e2);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference createItemFromTag = createItemFromTag(name, attributeSet);
                    ((PreferenceGroup) preference).addItemFromInflater(createItemFromTag);
                    rInflate(xmlPullParser, createItemFromTag, attributeSet);
                }
            }
        }
    }

    private static void skipCurrentTag(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }
}
