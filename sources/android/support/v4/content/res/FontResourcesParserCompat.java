package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.compat.R;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public class FontResourcesParserCompat {

    public interface FamilyResourceEntry {
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        private final FontRequest mRequest;
        private final int mStrategy;
        private final int mTimeoutMs;

        public ProviderResourceEntry(FontRequest fontRequest, int i, int i2) {
            this.mRequest = fontRequest;
            this.mStrategy = i;
            this.mTimeoutMs = i2;
        }

        public FontRequest getRequest() {
            return this.mRequest;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    public static final class FontFileResourceEntry {
        private final String mFileName;
        private boolean mItalic;
        private int mResourceId;
        private int mWeight;

        public FontFileResourceEntry(String str, int i, boolean z, int i2) {
            this.mFileName = str;
            this.mWeight = i;
            this.mItalic = z;
            this.mResourceId = i2;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }

        public int getResourceId() {
            return this.mResourceId;
        }
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.mEntries = fontFileResourceEntryArr;
        }

        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return readFamilies(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static FamilyResourceEntry readFamilies(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return readFamily(xmlPullParser, resources);
        }
        skip(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry readFamily(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(readFont(xmlPullParser, resources));
                    } else {
                        skip(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
    }

    public static List<List<byte[]>> readCerts(Resources resources, int i) {
        ArrayList arrayList = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                arrayList = new ArrayList();
                if (obtainTypedArray.getResourceId(0, 0) != 0) {
                    for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        arrayList.add(toByteArrayList(resources.getStringArray(obtainTypedArray.getResourceId(i2, 0))));
                    }
                } else {
                    arrayList.add(toByteArrayList(resources.getStringArray(i)));
                }
            }
            obtainTypedArray.recycle();
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    private static List<byte[]> toByteArrayList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static FontFileResourceEntry readFont(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i2, 0);
        String string = obtainAttributes.getString(i2);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new FontFileResourceEntry(string, i, z, resourceId);
    }

    private static void skip(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
