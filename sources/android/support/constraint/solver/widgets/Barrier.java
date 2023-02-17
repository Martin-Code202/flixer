package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
public class Barrier extends Helper {
    private int mBarrierType = 0;

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        for (int i = 0; i < this.mListAnchors.length; i++) {
            this.mListAnchors[i].mSolverVariable = linearSystem.createObjectVariable(this.mListAnchors[i]);
        }
        if (this.mBarrierType >= 0 && this.mBarrierType < 4) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[this.mBarrierType];
            for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mWidgets[i2].mListAnchors[this.mBarrierType]);
                this.mWidgets[i2].mListAnchors[this.mBarrierType].mSolverVariable = createObjectVariable;
                if (this.mBarrierType == 0 || this.mBarrierType == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, createObjectVariable);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, createObjectVariable);
                }
            }
            if (this.mBarrierType == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
            } else if (this.mBarrierType == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
            } else if (this.mBarrierType == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
            } else if (this.mBarrierType == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
            }
        }
    }
}
