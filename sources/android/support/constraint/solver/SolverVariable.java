package android.support.constraint.solver;

import java.util.Arrays;
public class SolverVariable {
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId = -1;
    public int id = -1;
    ArrayRow[] mClientEquations = new ArrayRow[8];
    int mClientEquationsCount = 0;
    private String mName;
    Type mType;
    public int strength = 0;
    float[] strengthVector = new float[7];
    public int usageInRowCount = 0;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    public SolverVariable(Type type, String str) {
        this.mType = type;
    }

    /* access modifiers changed from: package-private */
    public void addClientEquation(ArrayRow arrayRow) {
        for (int i = 0; i < this.mClientEquationsCount; i++) {
            if (this.mClientEquations[i] == arrayRow) {
                return;
            }
        }
        if (this.mClientEquationsCount >= this.mClientEquations.length) {
            this.mClientEquations = (ArrayRow[]) Arrays.copyOf(this.mClientEquations, this.mClientEquations.length * 2);
        }
        this.mClientEquations[this.mClientEquationsCount] = arrayRow;
        this.mClientEquationsCount++;
    }

    /* access modifiers changed from: package-private */
    public void removeClientEquation(ArrayRow arrayRow) {
        for (int i = 0; i < this.mClientEquationsCount; i++) {
            if (this.mClientEquations[i] == arrayRow) {
                for (int i2 = 0; i2 < (this.mClientEquationsCount - i) - 1; i2++) {
                    this.mClientEquations[i + i2] = this.mClientEquations[i + i2 + 1];
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String toString() {
        return "" + this.mName;
    }
}
