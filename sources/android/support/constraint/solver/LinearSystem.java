package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;
public class LinearSystem {
    private static int POOL_SIZE = 1000;
    private int TABLE_SIZE;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    private ArrayRow[] tempClientsCopy;

    /* access modifiers changed from: package-private */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);
    }

    public LinearSystem() {
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = this.TABLE_SIZE;
        this.mRows = null;
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = this.TABLE_SIZE;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.tempClientsCopy = new ArrayRow[this.TABLE_SIZE];
        this.mRows = new ArrayRow[this.TABLE_SIZE];
        releaseRows();
        this.mCache = new Cache();
        this.mGoal = new GoalRow(this.mCache);
    }

    private void increaseTableSize() {
        this.TABLE_SIZE *= 2;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, this.TABLE_SIZE);
        this.mCache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE);
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mMaxColumns = this.TABLE_SIZE;
        this.mMaxRows = this.TABLE_SIZE;
    }

    private void releaseRows() {
        for (int i = 0; i < this.mRows.length; i++) {
            ArrayRow arrayRow = this.mRows[i];
            if (arrayRow != null) {
                this.mCache.arrayRowPool.release(arrayRow);
            }
            this.mRows[i] = null;
        }
    }

    public void reset() {
        for (int i = 0; i < this.mCache.mIndexedVariables.length; i++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
        }
        this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        if (this.mVariables != null) {
            this.mVariables.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            this.mRows[i2].used = false;
        }
        releaseRows();
        this.mNumRows = 0;
    }

    public SolverVariable createObjectVariable(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariable = null;
        if (obj instanceof ConstraintAnchor) {
            solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
            if (solverVariable == null) {
                ((ConstraintAnchor) obj).resetSolverVariable(this.mCache);
                solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
            }
            if (solverVariable.id == -1 || solverVariable.id > this.mVariablesID || this.mCache.mIndexedVariables[solverVariable.id] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                this.mVariablesID++;
                this.mNumColumns++;
                solverVariable.id = this.mVariablesID;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire = this.mCache.arrayRowPool.acquire();
        if (acquire == null) {
            acquire = new ArrayRow(this.mCache);
        } else {
            acquire.reset();
        }
        SolverVariable.increaseErrorId();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    /* access modifiers changed from: package-private */
    public void addSingleError(ArrayRow arrayRow, int i, int i2) {
        arrayRow.addSingleError(createErrorVariable(i2, null), i);
    }

    public SolverVariable createErrorVariable(int i, String str) {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        acquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.mCache.solverVariablePool.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        if (this.mPoolVariablesCount >= POOL_SIZE) {
            POOL_SIZE *= 2;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, POOL_SIZE);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i + 1;
        solverVariableArr[i] = acquire;
        return acquire;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public void minimize() {
        minimizeGoal(this.mGoal);
    }

    /* access modifiers changed from: package-private */
    public void minimizeGoal(Row row) {
        updateRowFromVariables((ArrayRow) row);
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    /* access modifiers changed from: package-private */
    public void updateRowFromVariables(ArrayRow arrayRow) {
        if (this.mNumRows > 0) {
            arrayRow.variables.updateFromSystem(arrayRow, this.mRows);
            if (arrayRow.variables.currentSize == 0) {
                arrayRow.isSimpleDefinition = true;
            }
        }
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable pickPivot;
        if (arrayRow != null) {
            if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            boolean z = false;
            if (!arrayRow.isSimpleDefinition) {
                updateRowFromVariables(arrayRow);
                if (!arrayRow.isEmpty()) {
                    arrayRow.ensurePositiveConstant();
                    if (arrayRow.chooseSubject(this)) {
                        SolverVariable createExtraVariable = createExtraVariable();
                        arrayRow.variable = createExtraVariable;
                        addRow(arrayRow);
                        z = true;
                        ArrayRow arrayRow2 = new ArrayRow(this.mCache);
                        arrayRow2.initFromRow(arrayRow);
                        optimize(arrayRow2, true);
                        if (createExtraVariable.definitionId == -1) {
                            if (arrayRow.variable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                                arrayRow.pivot(pickPivot);
                                arrayRow.updateClientEquations();
                            }
                            for (int i = 0; i < this.mNumRows; i++) {
                                this.mRows[i].variables.remove(createExtraVariable);
                            }
                            for (int i2 = 0; i2 < this.mNumRows; i2++) {
                                ArrayRow arrayRow3 = this.mRows[i2];
                                if (arrayRow3 != arrayRow) {
                                    arrayRow3.updateRowWithEquation(arrayRow);
                                }
                            }
                            if (!arrayRow.isSimpleDefinition) {
                                arrayRow.updateClientEquations();
                                int i3 = arrayRow.variable.mClientEquationsCount;
                                if (i3 > 0) {
                                    while (this.tempClientsCopy.length < i3) {
                                        this.tempClientsCopy = new ArrayRow[(this.tempClientsCopy.length * 2)];
                                    }
                                    ArrayRow[] arrayRowArr = this.tempClientsCopy;
                                    for (int i4 = 0; i4 < i3; i4++) {
                                        arrayRowArr[i4] = arrayRow.variable.mClientEquations[i4];
                                    }
                                    for (int i5 = 0; i5 < i3; i5++) {
                                        ArrayRow arrayRow4 = arrayRowArr[i5];
                                        if (arrayRow4 != arrayRow) {
                                            arrayRow4.variables.updateFromRow(arrayRow4, arrayRow);
                                            arrayRow4.updateClientEquations();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!arrayRow.hasKeyVariable()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z) {
                addRow(arrayRow);
            }
        }
    }

    private void addRow(ArrayRow arrayRow) {
        if (this.mRows[this.mNumRows] != null) {
            this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
        }
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateClientEquations();
        }
        this.mRows[this.mNumRows] = arrayRow;
        arrayRow.variable.definitionId = this.mNumRows;
        this.mNumRows++;
        int i = arrayRow.variable.mClientEquationsCount;
        if (i > 0) {
            while (this.tempClientsCopy.length < i) {
                this.tempClientsCopy = new ArrayRow[(this.tempClientsCopy.length * 2)];
            }
            ArrayRow[] arrayRowArr = this.tempClientsCopy;
            for (int i2 = 0; i2 < i; i2++) {
                arrayRowArr[i2] = arrayRow.variable.mClientEquations[i2];
            }
            for (int i3 = 0; i3 < i; i3++) {
                ArrayRow arrayRow2 = arrayRowArr[i3];
                if (arrayRow2 != arrayRow) {
                    arrayRow2.variables.updateFromRow(arrayRow2, arrayRow);
                    arrayRow2.updateClientEquations();
                }
            }
        }
        updateRowFromVariables((GoalRow) this.mGoal);
    }

    private int optimize(Row row, boolean z) {
        boolean z2 = false;
        int i = 0;
        for (int i2 = 0; i2 < this.mNumColumns; i2++) {
            this.mAlreadyTestedCandidates[i2] = false;
        }
        while (!z2) {
            i++;
            if (i >= this.mNumColumns * 2) {
                return i;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                if (this.mAlreadyTestedCandidates[pivotCandidate.id]) {
                    return i;
                }
                this.mAlreadyTestedCandidates[pivotCandidate.id] = true;
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.mNumRows; i4++) {
                    ArrayRow arrayRow = this.mRows[i4];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && arrayRow.hasVariable(pivotCandidate)) {
                        float f2 = arrayRow.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow.constantValue) / f2;
                            if (f3 < f) {
                                f = f3;
                                i3 = i4;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i3];
                    arrayRow2.variable.definitionId = -1;
                    arrayRow2.pivot(pivotCandidate);
                    arrayRow2.updateClientEquations();
                    arrayRow2.variable.definitionId = i3;
                    for (int i5 = 0; i5 < this.mNumRows; i5++) {
                        this.mRows[i5].updateRowWithEquation(arrayRow2);
                    }
                    updateRowFromVariables((ArrayRow) row);
                } else {
                    System.out.println("we couldn't find an equation to pivot upon");
                    z2 = true;
                }
            } else {
                z2 = true;
            }
        }
        return i;
    }

    private int enforceBFS(Row row) {
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mNumRows) {
                break;
            } else if (this.mRows[i2].variable.mType != SolverVariable.Type.UNRESTRICTED && this.mRows[i2].constantValue < 0.0f) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            boolean z2 = false;
            i = 0;
            while (!z2) {
                i++;
                float f = Float.MAX_VALUE;
                int i3 = 0;
                int i4 = -1;
                int i5 = -1;
                for (int i6 = 0; i6 < this.mNumRows; i6++) {
                    ArrayRow arrayRow = this.mRows[i6];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && arrayRow.constantValue < 0.0f) {
                        for (int i7 = 1; i7 < this.mNumColumns; i7++) {
                            SolverVariable solverVariable = this.mCache.mIndexedVariables[i7];
                            float f2 = arrayRow.variables.get(solverVariable);
                            if (f2 > 0.0f) {
                                for (int i8 = 0; i8 < 7; i8++) {
                                    float f3 = solverVariable.strengthVector[i8] / f2;
                                    if ((f3 < f && i8 == i3) || i8 > i3) {
                                        f = f3;
                                        i4 = i6;
                                        i5 = i7;
                                        i3 = i8;
                                    }
                                }
                            }
                        }
                    }
                }
                if (i4 != -1) {
                    ArrayRow arrayRow2 = this.mRows[i4];
                    arrayRow2.variable.definitionId = -1;
                    arrayRow2.pivot(this.mCache.mIndexedVariables[i5]);
                    arrayRow2.updateClientEquations();
                    arrayRow2.variable.definitionId = i4;
                    for (int i9 = 0; i9 < this.mNumRows; i9++) {
                        this.mRows[i9].updateRowWithEquation(arrayRow2);
                    }
                    updateRowFromVariables((ArrayRow) row);
                } else {
                    z2 = true;
                }
            }
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.mNumRows) {
                break;
            } else if (this.mRows[i10].variable.mType != SolverVariable.Type.UNRESTRICTED && this.mRows[i10].constantValue < 0.0f) {
                break;
            } else {
                i10++;
            }
        }
        return i;
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public Cache getCache() {
        return this.mCache;
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 6) {
            addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)), i2);
        }
        addConstraint(createRow);
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, 0);
        addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)), 5);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 6) {
            addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)), i2);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, 0);
        addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)), 5);
        addConstraint(createRow);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 6) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 6) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i2 != 6) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.definitionId;
        if (solverVariable.definitionId != -1) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i;
            } else if (arrayRow.variables.currentSize == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = (float) i;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i);
                addConstraint(createRow);
            }
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.createRowDefinition(solverVariable, i);
            addConstraint(createRow2);
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        if (z) {
            linearSystem.addError(createRow);
        }
        return createRow.createRowDimensionPercent(solverVariable, solverVariable2, solverVariable3, f);
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow createRow = createRow();
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin((double) f) * ((double) i)));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos((double) f) * ((double) i)));
        addConstraint(createRow2);
    }
}
