package com.ibm.icu.text;

import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.math.BigDecimal;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
public class RuleBasedNumberFormat extends NumberFormat {
    private static final boolean DEBUG = ICUDebug.enabled("rbnf");
    private static final BigDecimal MAX_VALUE = BigDecimal.valueOf(Long.MAX_VALUE);
    private static final BigDecimal MIN_VALUE = BigDecimal.valueOf(Long.MIN_VALUE);
    private static final String[] locnames = {"SpelloutLocalizations", "OrdinalLocalizations", "DurationLocalizations", "NumberingSystemLocalizations"};
    private static final String[] rulenames = {"SpelloutRules", "OrdinalRules", "DurationRules", "NumberingSystemRules"};
    static final long serialVersionUID = -7664252765575395068L;
    private transient BreakIterator capitalizationBrkIter = null;
    private boolean capitalizationForListOrMenu = false;
    private boolean capitalizationForStandAlone = false;
    private boolean capitalizationInfoIsSet = false;
    private transient DecimalFormat decimalFormat = null;
    private transient DecimalFormatSymbols decimalFormatSymbols = null;
    private transient NFRule defaultInfinityRule = null;
    private transient NFRule defaultNaNRule = null;
    private transient NFRuleSet defaultRuleSet = null;
    private boolean lenientParse = false;
    private transient String lenientParseRules;
    private ULocale locale = null;
    private transient boolean lookedForScanner;
    private transient String postProcessRules;
    private transient RBNFPostProcessor postProcessor;
    private String[] publicRuleSetNames;
    private int roundingMode = 7;
    private Map<String, String[]> ruleSetDisplayNames;
    private transient NFRuleSet[] ruleSets = null;
    private transient Map<String, NFRuleSet> ruleSetsMap = null;
    private transient RbnfLenientScannerProvider scannerProvider = null;

    public RuleBasedNumberFormat(String str, ULocale uLocale) {
        this.locale = uLocale;
        init(str, null);
    }

    public RuleBasedNumberFormat(ULocale uLocale, int i) {
        this.locale = uLocale;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/rbnf", uLocale);
        ULocale uLocale2 = iCUResourceBundle.getULocale();
        setLocale(uLocale2, uLocale2);
        StringBuilder sb = new StringBuilder();
        String[][] strArr = null;
        try {
            UResourceBundleIterator iterator = iCUResourceBundle.getWithFallback("RBNFRules/" + rulenames[i - 1]).getIterator();
            while (iterator.hasNext()) {
                sb.append(iterator.nextString());
            }
        } catch (MissingResourceException e) {
        }
        ICUResourceBundle findTopLevel = iCUResourceBundle.findTopLevel(locnames[i - 1]);
        if (findTopLevel != null) {
            strArr = new String[findTopLevel.getSize()][];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                strArr[i2] = findTopLevel.get(i2).getStringArray();
            }
        }
        init(sb.toString(), strArr);
    }

    @Override // com.ibm.icu.text.NumberFormat, java.text.Format, java.lang.Object
    public Object clone() {
        return super.clone();
    }

    @Override // com.ibm.icu.text.NumberFormat, java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof RuleBasedNumberFormat)) {
            return false;
        }
        RuleBasedNumberFormat ruleBasedNumberFormat = (RuleBasedNumberFormat) obj;
        if (!(this.locale.equals(ruleBasedNumberFormat.locale) && this.lenientParse == ruleBasedNumberFormat.lenientParse && this.ruleSets.length == ruleBasedNumberFormat.ruleSets.length)) {
            return false;
        }
        for (int i = 0; i < this.ruleSets.length; i++) {
            if (!this.ruleSets[i].equals(ruleBasedNumberFormat.ruleSets[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.ibm.icu.text.NumberFormat, java.lang.Object
    @Deprecated
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NFRuleSet nFRuleSet : this.ruleSets) {
            sb.append(nFRuleSet.toString());
        }
        return sb.toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeUTF(toString());
        objectOutputStream.writeObject(this.locale);
        objectOutputStream.writeInt(this.roundingMode);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ULocale uLocale;
        String readUTF = objectInputStream.readUTF();
        try {
            uLocale = (ULocale) objectInputStream.readObject();
        } catch (Exception e) {
            uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        try {
            this.roundingMode = objectInputStream.readInt();
        } catch (Exception e2) {
        }
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(readUTF, uLocale);
        this.ruleSets = ruleBasedNumberFormat.ruleSets;
        this.ruleSetsMap = ruleBasedNumberFormat.ruleSetsMap;
        this.defaultRuleSet = ruleBasedNumberFormat.defaultRuleSet;
        this.publicRuleSetNames = ruleBasedNumberFormat.publicRuleSetNames;
        this.decimalFormatSymbols = ruleBasedNumberFormat.decimalFormatSymbols;
        this.decimalFormat = ruleBasedNumberFormat.decimalFormat;
        this.locale = ruleBasedNumberFormat.locale;
        this.defaultInfinityRule = ruleBasedNumberFormat.defaultInfinityRule;
        this.defaultNaNRule = ruleBasedNumberFormat.defaultNaNRule;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (stringBuffer.length() == 0) {
            stringBuffer.append(adjustForContext(format(d, this.defaultRuleSet)));
        } else {
            stringBuffer.append(format(d, this.defaultRuleSet));
        }
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (stringBuffer.length() == 0) {
            stringBuffer.append(adjustForContext(format(j, this.defaultRuleSet)));
        } else {
            stringBuffer.append(format(j, this.defaultRuleSet));
        }
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format(new BigDecimal(bigInteger), stringBuffer, fieldPosition);
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(java.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format(new BigDecimal(bigDecimal), stringBuffer, fieldPosition);
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (MIN_VALUE.compareTo(bigDecimal) > 0 || MAX_VALUE.compareTo(bigDecimal) < 0) {
            return getDecimalFormat().format(bigDecimal, stringBuffer, fieldPosition);
        }
        if (bigDecimal.scale() == 0) {
            return format(bigDecimal.longValue(), stringBuffer, fieldPosition);
        }
        return format(bigDecimal.doubleValue(), stringBuffer, fieldPosition);
    }

    @Override // com.ibm.icu.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        String substring = str.substring(parsePosition.getIndex());
        ParsePosition parsePosition2 = new ParsePosition(0);
        Long l = NFRule.ZERO;
        ParsePosition parsePosition3 = new ParsePosition(parsePosition2.getIndex());
        for (int length = this.ruleSets.length - 1; length >= 0; length--) {
            if (this.ruleSets[length].isPublic() && this.ruleSets[length].isParseable()) {
                Number parse = this.ruleSets[length].parse(substring, parsePosition2, Double.MAX_VALUE);
                if (parsePosition2.getIndex() > parsePosition3.getIndex()) {
                    l = parse;
                    parsePosition3.setIndex(parsePosition2.getIndex());
                }
                if (parsePosition3.getIndex() == substring.length()) {
                    break;
                }
                parsePosition2.setIndex(0);
            }
        }
        parsePosition.setIndex(parsePosition.getIndex() + parsePosition3.getIndex());
        return l;
    }

    public boolean lenientParseEnabled() {
        return this.lenientParse;
    }

    public void setLenientScannerProvider(RbnfLenientScannerProvider rbnfLenientScannerProvider) {
        this.scannerProvider = rbnfLenientScannerProvider;
    }

    public RbnfLenientScannerProvider getLenientScannerProvider() {
        if (this.scannerProvider == null && this.lenientParse && !this.lookedForScanner) {
            try {
                this.lookedForScanner = true;
                setLenientScannerProvider((RbnfLenientScannerProvider) Class.forName("com.ibm.icu.impl.text.RbnfScannerProviderImpl").newInstance());
            } catch (Exception e) {
            }
        }
        return this.scannerProvider;
    }

    public void setDefaultRuleSet(String str) {
        String name;
        if (str == null) {
            if (this.publicRuleSetNames.length > 0) {
                this.defaultRuleSet = findRuleSet(this.publicRuleSetNames[0]);
                return;
            }
            this.defaultRuleSet = null;
            int length = this.ruleSets.length;
            do {
                length--;
                if (length >= 0) {
                    name = this.ruleSets[length].getName();
                    if (name.equals("%spellout-numbering") || name.equals("%digits-ordinal")) {
                        break;
                    }
                } else {
                    int length2 = this.ruleSets.length;
                    do {
                        length2--;
                        if (length2 < 0) {
                            return;
                        }
                    } while (!this.ruleSets[length2].isPublic());
                    this.defaultRuleSet = this.ruleSets[length2];
                    return;
                }
            } while (!name.equals("%duration"));
            this.defaultRuleSet = this.ruleSets[length];
        } else if (str.startsWith("%%")) {
            throw new IllegalArgumentException("cannot use private rule set: " + str);
        } else {
            this.defaultRuleSet = findRuleSet(str);
        }
    }

    @Override // com.ibm.icu.text.NumberFormat
    public int getRoundingMode() {
        return this.roundingMode;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public void setRoundingMode(int i) {
        if (i < 0 || i > 7) {
            throw new IllegalArgumentException("Invalid rounding mode: " + i);
        }
        this.roundingMode = i;
    }

    /* access modifiers changed from: package-private */
    public NFRuleSet getDefaultRuleSet() {
        return this.defaultRuleSet;
    }

    /* access modifiers changed from: package-private */
    public RbnfLenientScanner getLenientScanner() {
        RbnfLenientScannerProvider lenientScannerProvider;
        if (!this.lenientParse || (lenientScannerProvider = getLenientScannerProvider()) == null) {
            return null;
        }
        return lenientScannerProvider.get(this.locale, this.lenientParseRules);
    }

    /* access modifiers changed from: package-private */
    public DecimalFormatSymbols getDecimalFormatSymbols() {
        if (this.decimalFormatSymbols == null) {
            this.decimalFormatSymbols = new DecimalFormatSymbols(this.locale);
        }
        return this.decimalFormatSymbols;
    }

    /* access modifiers changed from: package-private */
    public DecimalFormat getDecimalFormat() {
        if (this.decimalFormat == null) {
            this.decimalFormat = new DecimalFormat(getPattern(this.locale, 0), getDecimalFormatSymbols());
        }
        return this.decimalFormat;
    }

    /* access modifiers changed from: package-private */
    public PluralFormat createPluralFormat(PluralRules.PluralType pluralType, String str) {
        return new PluralFormat(this.locale, pluralType, str, getDecimalFormat());
    }

    /* access modifiers changed from: package-private */
    public NFRule getDefaultInfinityRule() {
        if (this.defaultInfinityRule == null) {
            this.defaultInfinityRule = new NFRule(this, "Inf: " + getDecimalFormatSymbols().getInfinity());
        }
        return this.defaultInfinityRule;
    }

    /* access modifiers changed from: package-private */
    public NFRule getDefaultNaNRule() {
        if (this.defaultNaNRule == null) {
            this.defaultNaNRule = new NFRule(this, "NaN: " + getDecimalFormatSymbols().getNaN());
        }
        return this.defaultNaNRule;
    }

    private String extractSpecial(StringBuilder sb, String str) {
        int indexOf = sb.indexOf(str);
        if (indexOf == -1) {
            return null;
        }
        if (indexOf != 0 && sb.charAt(indexOf - 1) != ';') {
            return null;
        }
        int indexOf2 = sb.indexOf(";%", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = sb.length() - 1;
        }
        int length = indexOf + str.length();
        while (length < indexOf2 && PatternProps.isWhiteSpace(sb.charAt(length))) {
            length++;
        }
        String substring = sb.substring(length, indexOf2);
        sb.delete(indexOf, indexOf2 + 1);
        return substring;
    }

    private void init(String str, String[][] strArr) {
        initLocalizations(strArr);
        StringBuilder stripWhitespace = stripWhitespace(str);
        this.lenientParseRules = extractSpecial(stripWhitespace, "%%lenient-parse:");
        this.postProcessRules = extractSpecial(stripWhitespace, "%%post-process:");
        int i = 1;
        int i2 = 0;
        while (true) {
            int indexOf = stripWhitespace.indexOf(";%", i2);
            if (indexOf == -1) {
                break;
            }
            i++;
            i2 = indexOf + 2;
        }
        this.ruleSets = new NFRuleSet[i];
        this.ruleSetsMap = new HashMap((i * 2) + 1);
        this.defaultRuleSet = null;
        int i3 = 0;
        String[] strArr2 = new String[i];
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.ruleSets.length) {
            int indexOf2 = stripWhitespace.indexOf(";%", i5);
            if (indexOf2 < 0) {
                indexOf2 = stripWhitespace.length() - 1;
            }
            strArr2[i4] = stripWhitespace.substring(i5, indexOf2 + 1);
            NFRuleSet nFRuleSet = new NFRuleSet(this, strArr2, i4);
            this.ruleSets[i4] = nFRuleSet;
            String name = nFRuleSet.getName();
            this.ruleSetsMap.put(name, nFRuleSet);
            if (!name.startsWith("%%")) {
                i3++;
                if ((this.defaultRuleSet == null && name.equals("%spellout-numbering")) || name.equals("%digits-ordinal") || name.equals("%duration")) {
                    this.defaultRuleSet = nFRuleSet;
                }
            }
            i4++;
            i5 = indexOf2 + 1;
        }
        if (this.defaultRuleSet == null) {
            int length = this.ruleSets.length - 1;
            while (true) {
                if (length < 0) {
                    break;
                } else if (!this.ruleSets[length].getName().startsWith("%%")) {
                    this.defaultRuleSet = this.ruleSets[length];
                    break;
                } else {
                    length--;
                }
            }
        }
        if (this.defaultRuleSet == null) {
            this.defaultRuleSet = this.ruleSets[this.ruleSets.length - 1];
        }
        for (int i6 = 0; i6 < this.ruleSets.length; i6++) {
            this.ruleSets[i6].parseRules(strArr2[i6]);
        }
        String[] strArr3 = new String[i3];
        int i7 = 0;
        for (int length2 = this.ruleSets.length - 1; length2 >= 0; length2--) {
            if (!this.ruleSets[length2].getName().startsWith("%%")) {
                i7++;
                strArr3[i7] = this.ruleSets[length2].getName();
            }
        }
        if (this.publicRuleSetNames != null) {
            for (int i8 = 0; i8 < this.publicRuleSetNames.length; i8++) {
                String str2 = this.publicRuleSetNames[i8];
                for (String str3 : strArr3) {
                    if (str2.equals(str3)) {
                    }
                }
                throw new IllegalArgumentException("did not find public rule set: " + str2);
            }
            this.defaultRuleSet = findRuleSet(this.publicRuleSetNames[0]);
            return;
        }
        this.publicRuleSetNames = strArr3;
    }

    private void initLocalizations(String[][] strArr) {
        if (strArr != null) {
            this.publicRuleSetNames = (String[]) strArr[0].clone();
            HashMap hashMap = new HashMap();
            for (int i = 1; i < strArr.length; i++) {
                String[] strArr2 = strArr[i];
                String str = strArr2[0];
                String[] strArr3 = new String[(strArr2.length - 1)];
                if (strArr3.length != this.publicRuleSetNames.length) {
                    throw new IllegalArgumentException("public name length: " + this.publicRuleSetNames.length + " != localized names[" + i + "] length: " + strArr3.length);
                }
                System.arraycopy(strArr2, 1, strArr3, 0, strArr3.length);
                hashMap.put(str, strArr3);
            }
            if (!hashMap.isEmpty()) {
                this.ruleSetDisplayNames = hashMap;
            }
        }
    }

    private StringBuilder stripWhitespace(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            while (i < length && PatternProps.isWhiteSpace(str.charAt(i))) {
                i++;
            }
            if (i >= length || str.charAt(i) != ';') {
                int indexOf = str.indexOf(59, i);
                if (indexOf != -1) {
                    if (indexOf >= length) {
                        break;
                    }
                    sb.append(str.substring(i, indexOf + 1));
                    i = indexOf + 1;
                } else {
                    sb.append(str.substring(i));
                    break;
                }
            } else {
                i++;
            }
        }
        return sb;
    }

    private String format(double d, NFRuleSet nFRuleSet) {
        StringBuilder sb = new StringBuilder();
        if (getRoundingMode() != 7) {
            d = new BigDecimal(Double.toString(d)).setScale(getMaximumFractionDigits(), this.roundingMode).doubleValue();
        }
        nFRuleSet.format(d, sb, 0, 0);
        postProcess(sb, nFRuleSet);
        return sb.toString();
    }

    private String format(long j, NFRuleSet nFRuleSet) {
        StringBuilder sb = new StringBuilder();
        if (j == Long.MIN_VALUE) {
            sb.append(getDecimalFormat().format(Long.MIN_VALUE));
        } else {
            nFRuleSet.format(j, sb, 0, 0);
        }
        postProcess(sb, nFRuleSet);
        return sb.toString();
    }

    private void postProcess(StringBuilder sb, NFRuleSet nFRuleSet) {
        if (this.postProcessRules != null) {
            if (this.postProcessor == null) {
                int indexOf = this.postProcessRules.indexOf(";");
                if (indexOf == -1) {
                    indexOf = this.postProcessRules.length();
                }
                String trim = this.postProcessRules.substring(0, indexOf).trim();
                try {
                    this.postProcessor = (RBNFPostProcessor) Class.forName(trim).newInstance();
                    this.postProcessor.init(this, this.postProcessRules);
                } catch (Exception e) {
                    if (DEBUG) {
                        System.out.println("could not locate " + trim + ", error " + e.getClass().getName() + ", " + e.getMessage());
                    }
                    this.postProcessor = null;
                    this.postProcessRules = null;
                    return;
                }
            }
            this.postProcessor.process(sb, nFRuleSet);
        }
    }

    private String adjustForContext(String str) {
        DisplayContext context = getContext(DisplayContext.Type.CAPITALIZATION);
        if (context == DisplayContext.CAPITALIZATION_NONE || str == null || str.length() <= 0 || !UCharacter.isLowerCase(str.codePointAt(0)) || (context != DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE && ((context != DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU || !this.capitalizationForListOrMenu) && (context != DisplayContext.CAPITALIZATION_FOR_STANDALONE || !this.capitalizationForStandAlone)))) {
            return str;
        }
        if (this.capitalizationBrkIter == null) {
            this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.locale);
        }
        return UCharacter.toTitleCase(this.locale, str, this.capitalizationBrkIter, 768);
    }

    /* access modifiers changed from: package-private */
    public NFRuleSet findRuleSet(String str) {
        NFRuleSet nFRuleSet = this.ruleSetsMap.get(str);
        if (nFRuleSet != null) {
            return nFRuleSet;
        }
        throw new IllegalArgumentException("No rule set named " + str);
    }
}
