package android.support.constraint.solver;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
public class ArrayRow implements LinearSystem.Row {
    float constantValue = 0.0f;
    boolean isSimpleDefinition = false;
    boolean used = false;
    SolverVariable variable = null;
    public final ArrayLinkedVariables variables;

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    /* access modifiers changed from: package-private */
    public void updateClientEquations() {
        this.variables.updateClientEquations(this);
    }

    /* access modifiers changed from: package-private */
    public boolean hasKeyVariable() {
        return this.variable != null && (this.variable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f);
    }

    public String toString() {
        return toReadableString();
    }

    /* access modifiers changed from: package-private */
    public String toReadableString() {
        String str = (this.variable == null ? "0" : "" + this.variable) + " = ";
        boolean z = false;
        if (this.constantValue != 0.0f) {
            str = str + this.constantValue;
            z = true;
        }
        int i = this.variables.currentSize;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable2 = this.variables.getVariable(i2);
            if (variable2 != null) {
                float variableValue = this.variables.getVariableValue(i2);
                String solverVariable = variable2.toString();
                if (!z) {
                    if (variableValue < 0.0f) {
                        str = str + "- ";
                        variableValue *= -1.0f;
                    }
                } else if (variableValue > 0.0f) {
                    str = str + " + ";
                } else {
                    str = str + " - ";
                    variableValue *= -1.0f;
                }
                str = variableValue == 1.0f ? str + solverVariable : str + variableValue + " " + solverVariable;
                z = true;
            }
        }
        if (!z) {
            return str + "0.0";
        }
        return str;
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    /* access modifiers changed from: package-private */
    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.containsKey(solverVariable);
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i) {
        this.variable = solverVariable;
        solverVariable.computedValue = (float) i;
        this.constantValue = (float) i;
        this.isSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.constantValue = (float) (i * -1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = (float) i;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            int i2 = i;
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.constantValue = (float) i2;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow addSingleError(SolverVariable solverVariable, int i) {
        this.variables.put(solverVariable, (float) i);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            int i2 = i;
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.constantValue = (float) i2;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            int i2 = i;
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.constantValue = (float) i2;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        if (f2 == 0.0f || f == f3) {
            this.constantValue = 0.0f;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.constantValue = 0.0f;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f4);
            this.variables.put(solverVariable3, -f4);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.constantValue = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = (float) i;
        } else if (f >= 1.0f) {
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.constantValue = (float) i2;
        } else {
            this.variables.put(solverVariable, (1.0f - f) * 1.0f);
            this.variables.put(solverVariable2, (1.0f - f) * -1.0f);
            this.variables.put(solverVariable3, -1.0f * f);
            this.variables.put(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.constantValue = (((float) (-i)) * (1.0f - f)) + (((float) i2) * f);
            }
        }
        return this;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i) {
        this.variables.put(linearSystem.createErrorVariable(i, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f - f);
        this.variables.put(solverVariable3, f);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean updateRowWithEquation(ArrayRow arrayRow) {
        this.variables.updateFromRow(this, arrayRow);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void ensurePositiveConstant() {
        if (this.constantValue < 0.0f) {
            this.constantValue *= -1.0f;
            this.variables.invert();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean chooseSubject(LinearSystem linearSystem) {
        boolean z = false;
        SolverVariable chooseSubject = this.variables.chooseSubject(linearSystem);
        if (chooseSubject == null) {
            z = true;
        } else {
            pivot(chooseSubject);
        }
        if (this.variables.currentSize == 0) {
            this.isSimpleDefinition = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return this.variables.getPivotCandidate(null, solverVariable);
    }

    /* access modifiers changed from: package-private */
    public void pivot(SolverVariable solverVariable) {
        if (this.variable != null) {
            this.variables.put(this.variable, -1.0f);
            this.variable = null;
        }
        float remove = this.variables.remove(solverVariable) * -1.0f;
        this.variable = solverVariable;
        if (remove != 1.0f) {
            this.constantValue /= remove;
            this.variables.divideByAmount(remove);
        }
    }

    public boolean isEmpty() {
        return this.variable == null && this.constantValue == 0.0f && this.variables.currentSize == 0;
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return this.variables.getPivotCandidate(zArr, null);
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i = 0; i < arrayRow.variables.currentSize; i++) {
                this.variables.add(arrayRow.variables.getVariable(i), arrayRow.variables.getVariableValue(i));
            }
        }
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        float f = 1.0f;
        if (solverVariable.strength == 1) {
            f = 1.0f;
        } else if (solverVariable.strength == 2) {
            f = 1000.0f;
        } else if (solverVariable.strength == 3) {
            f = 1000000.0f;
        } else if (solverVariable.strength == 4) {
            f = 1.0E9f;
        } else if (solverVariable.strength == 5) {
            f = 1.0E12f;
        }
        this.variables.put(solverVariable, f);
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }
}
