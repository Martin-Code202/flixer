package com.ibm.icu.impl.number;

import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.text.PluralRules;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
public abstract class Format {
    protected static final ThreadLocal<ModifierHolder> threadLocalModifierHolder = new ThreadLocal<ModifierHolder>() { // from class: com.ibm.icu.impl.number.Format.2
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ModifierHolder initialValue() {
            return new ModifierHolder();
        }
    };
    protected static final ThreadLocal<NumberStringBuilder> threadLocalStringBuilder = new ThreadLocal<NumberStringBuilder>() { // from class: com.ibm.icu.impl.number.Format.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public NumberStringBuilder initialValue() {
            return new NumberStringBuilder();
        }
    };

    public interface AfterFormat extends Exportable {
        int after(ModifierHolder modifierHolder, NumberStringBuilder numberStringBuilder, int i, int i2);
    }

    public interface TargetFormat extends Exportable {
        int target(FormatQuantity formatQuantity, NumberStringBuilder numberStringBuilder, int i);
    }

    public static abstract class SingularFormat extends Format implements Exportable {
        public abstract int process(FormatQuantity formatQuantity, ModifierHolder modifierHolder, NumberStringBuilder numberStringBuilder, int i);

        public String format(FormatQuantity formatQuantity) {
            return formatToStringBuilder(formatQuantity).toString();
        }

        public void format(FormatQuantity formatQuantity, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            NumberStringBuilder formatToStringBuilder = formatToStringBuilder(formatQuantity);
            formatToStringBuilder.populateFieldPosition(fieldPosition, stringBuffer.length());
            stringBuffer.append((CharSequence) formatToStringBuilder);
        }

        public AttributedCharacterIterator formatToCharacterIterator(FormatQuantity formatQuantity) {
            return formatToStringBuilder(formatQuantity).getIterator();
        }

        private NumberStringBuilder formatToStringBuilder(FormatQuantity formatQuantity) {
            ModifierHolder clear = ((ModifierHolder) threadLocalModifierHolder.get()).clear();
            NumberStringBuilder clear2 = ((NumberStringBuilder) threadLocalStringBuilder.get()).clear();
            int process = process(formatQuantity, clear, clear2, 0);
            int applyAll = process + clear.applyAll(clear2, 0, process);
            return clear2;
        }
    }

    public static class BeforeTargetAfterFormat extends SingularFormat {
        private AfterFormat after1 = null;
        private AfterFormat after2 = null;
        private AfterFormat after3 = null;
        private BeforeFormat before1 = null;
        private BeforeFormat before2 = null;
        private BeforeFormat before3 = null;
        private final PluralRules rules;
        private TargetFormat target = null;

        public BeforeTargetAfterFormat(PluralRules pluralRules) {
            this.rules = pluralRules;
        }

        public void addBeforeFormat(BeforeFormat beforeFormat) {
            if (this.before1 == null) {
                this.before1 = beforeFormat;
            } else if (this.before2 == null) {
                this.before2 = beforeFormat;
            } else if (this.before3 == null) {
                this.before3 = beforeFormat;
            } else {
                throw new IllegalArgumentException("Only three BeforeFormats are allowed at a time");
            }
        }

        public void setTargetFormat(TargetFormat targetFormat) {
            this.target = targetFormat;
        }

        public void addAfterFormat(AfterFormat afterFormat) {
            if (this.after1 == null) {
                this.after1 = afterFormat;
            } else if (this.after2 == null) {
                this.after2 = afterFormat;
            } else if (this.after3 == null) {
                this.after3 = afterFormat;
            } else {
                throw new IllegalArgumentException("Only three AfterFormats are allowed at a time");
            }
        }

        @Override // com.ibm.icu.impl.number.Format.SingularFormat
        public String format(FormatQuantity formatQuantity) {
            ModifierHolder clear = ((ModifierHolder) threadLocalModifierHolder.get()).clear();
            NumberStringBuilder clear2 = ((NumberStringBuilder) threadLocalStringBuilder.get()).clear();
            clear.applyAll(clear2, 0, process(formatQuantity, clear, clear2, 0));
            return clear2.toString();
        }

        @Override // com.ibm.icu.impl.number.Format.SingularFormat
        public int process(FormatQuantity formatQuantity, ModifierHolder modifierHolder, NumberStringBuilder numberStringBuilder, int i) {
            if (!formatQuantity.isNaN()) {
                if (this.before1 != null) {
                    this.before1.before(formatQuantity, modifierHolder, this.rules);
                }
                if (this.before2 != null) {
                    this.before2.before(formatQuantity, modifierHolder, this.rules);
                }
                if (this.before3 != null) {
                    this.before3.before(formatQuantity, modifierHolder, this.rules);
                }
            }
            int target2 = this.target.target(formatQuantity, numberStringBuilder, i);
            int applyStrong = target2 + modifierHolder.applyStrong(numberStringBuilder, i, i + target2);
            if (this.after1 != null) {
                applyStrong += this.after1.after(modifierHolder, numberStringBuilder, i, i + applyStrong);
            }
            if (this.after2 != null) {
                applyStrong += this.after2.after(modifierHolder, numberStringBuilder, i, i + applyStrong);
            }
            if (this.after3 != null) {
                return applyStrong + this.after3.after(modifierHolder, numberStringBuilder, i, i + applyStrong);
            }
            return applyStrong;
        }

        @Override // com.ibm.icu.impl.number.Exportable
        public void export(Properties properties) {
            if (this.before1 != null) {
                this.before1.export(properties);
            }
            if (this.before2 != null) {
                this.before2.export(properties);
            }
            if (this.before3 != null) {
                this.before3.export(properties);
            }
            this.target.export(properties);
            if (this.after1 != null) {
                this.after1.export(properties);
            }
            if (this.after2 != null) {
                this.after2.export(properties);
            }
            if (this.after3 != null) {
                this.after3.export(properties);
            }
        }
    }

    public static class PositiveNegativeRounderTargetFormat extends SingularFormat {
        private final Modifier.PositiveNegativeModifier positiveNegative;
        private final Rounder rounder;
        private final TargetFormat target;

        public PositiveNegativeRounderTargetFormat(Modifier.PositiveNegativeModifier positiveNegativeModifier, Rounder rounder2, TargetFormat targetFormat) {
            this.positiveNegative = positiveNegativeModifier;
            this.rounder = rounder2;
            this.target = targetFormat;
        }

        @Override // com.ibm.icu.impl.number.Format.SingularFormat
        public String format(FormatQuantity formatQuantity) {
            NumberStringBuilder clear = ((NumberStringBuilder) threadLocalStringBuilder.get()).clear();
            process(formatQuantity, null, clear, 0);
            return clear.toString();
        }

        @Override // com.ibm.icu.impl.number.Format.SingularFormat
        public int process(FormatQuantity formatQuantity, ModifierHolder modifierHolder, NumberStringBuilder numberStringBuilder, int i) {
            Modifier modifier = null;
            this.rounder.apply(formatQuantity);
            if (!formatQuantity.isNaN() && this.positiveNegative != null) {
                modifier = this.positiveNegative.getModifier(formatQuantity.isNegative());
            }
            int target2 = this.target.target(formatQuantity, numberStringBuilder, i);
            if (modifier != null) {
                return target2 + modifier.apply(numberStringBuilder, 0, target2);
            }
            return target2;
        }

        @Override // com.ibm.icu.impl.number.Exportable
        public void export(Properties properties) {
            this.rounder.export(properties);
            this.positiveNegative.export(properties);
            this.target.export(properties);
        }
    }

    public static abstract class BeforeFormat implements Exportable {
        public abstract void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder);

        public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder, PluralRules pluralRules) {
            before(formatQuantity, modifierHolder);
        }
    }
}
