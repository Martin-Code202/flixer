package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget;
/* access modifiers changed from: package-private */
public class Chain {
    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        ConstraintWidget[] constraintWidgetArr;
        int i2;
        int i3;
        if (i == 0) {
            i3 = 0;
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            constraintWidgetArr = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            i3 = 2;
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            constraintWidgetArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, constraintWidgetArr[i4]);
        }
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ConstraintWidget constraintWidget) {
        boolean z;
        boolean z2;
        boolean z3;
        float f;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = null;
        ConstraintWidget constraintWidget5 = null;
        boolean z4 = false;
        int i3 = 0;
        float f2 = 0.0f;
        ConstraintWidget constraintWidget6 = null;
        ConstraintWidget constraintWidget7 = null;
        boolean z5 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z3 = constraintWidget.mHorizontalChainStyle == 0;
            z2 = constraintWidget.mHorizontalChainStyle == 1;
            z = constraintWidget.mHorizontalChainStyle == 2;
        } else {
            z3 = constraintWidget.mVerticalChainStyle == 0;
            z2 = constraintWidget.mVerticalChainStyle == 1;
            z = constraintWidget.mVerticalChainStyle == 2;
        }
        while (!z4) {
            constraintWidget3.mListNextVisibleWidget[i] = null;
            if (constraintWidget3.getVisibility() != 8) {
                if (constraintWidget5 != null) {
                    constraintWidget5.mListNextVisibleWidget[i] = constraintWidget3;
                }
                if (constraintWidget4 == null) {
                    constraintWidget4 = constraintWidget3;
                }
                constraintWidget5 = constraintWidget3;
            }
            ConstraintAnchor constraintAnchor = constraintWidget3.mListAnchors[i2];
            int i4 = 1;
            int margin = constraintAnchor.getMargin();
            if (!(!z || constraintWidget3 == constraintWidget || constraintWidget3 == constraintWidget4)) {
                i4 = 6;
            }
            linearSystem.addGreaterThan(constraintAnchor.mSolverVariable, constraintAnchor.mTarget.mSolverVariable, margin, 6);
            linearSystem.addEquality(constraintAnchor.mSolverVariable, constraintAnchor.mTarget.mSolverVariable, margin, i4);
            constraintWidget3.mListNextMatchConstraintsWidget[i] = null;
            if (constraintWidget3.getVisibility() != 8 && constraintWidget3.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i3++;
                f2 += constraintWidget3.mWeight[i];
                if (constraintWidget6 == null) {
                    constraintWidget6 = constraintWidget3;
                } else {
                    constraintWidget7.mListNextMatchConstraintsWidget[i] = constraintWidget3;
                }
                constraintWidget7 = constraintWidget3;
                if (z5) {
                    linearSystem.addGreaterThan(constraintWidget3.mListAnchors[i2 + 1].mSolverVariable, constraintWidget3.mListAnchors[i2].mSolverVariable, 0, 6);
                }
            }
            if (z5) {
                linearSystem.addGreaterThan(constraintWidget3.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, 0, 6);
            }
            ConstraintAnchor constraintAnchor2 = constraintWidget3.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor2 != null) {
                constraintWidget2 = constraintAnchor2.mOwner;
                if (constraintWidget2.mListAnchors[i2].mTarget == null || constraintWidget2.mListAnchors[i2].mTarget.mOwner != constraintWidget3) {
                    constraintWidget2 = null;
                }
            } else {
                constraintWidget2 = null;
            }
            if (constraintWidget2 != null) {
                constraintWidget3 = constraintWidget2;
            } else {
                z4 = true;
            }
        }
        if (!(constraintWidget5 == null || constraintWidget3.mListAnchors[i2 + 1].mTarget == null)) {
            ConstraintAnchor constraintAnchor3 = constraintWidget5.mListAnchors[i2 + 1];
            linearSystem.addLowerThan(constraintAnchor3.mSolverVariable, constraintWidget3.mListAnchors[i2 + 1].mTarget.mSolverVariable, -constraintAnchor3.getMargin(), 6);
        }
        if (z5) {
            linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i2 + 1].mSolverVariable, constraintWidget3.mListAnchors[i2 + 1].mSolverVariable, constraintWidget3.mListAnchors[i2 + 1].getMargin(), 6);
        }
        if (i3 > 0) {
            ConstraintWidget constraintWidget8 = constraintWidget6;
            while (constraintWidget8 != null) {
                ConstraintWidget constraintWidget9 = constraintWidget8.mListNextMatchConstraintsWidget[i];
                if (constraintWidget9 != null) {
                    ArrayRow createRow = linearSystem.createRow();
                    createRow.createRowEqualMatchDimensions(constraintWidget8.mWeight[i], f2, constraintWidget9.mWeight[i], constraintWidget8.mListAnchors[i2].mSolverVariable, constraintWidget8.mListAnchors[i2 + 1].mSolverVariable, constraintWidget9.mListAnchors[i2].mSolverVariable, constraintWidget9.mListAnchors[i2 + 1].mSolverVariable);
                    linearSystem.addConstraint(createRow);
                }
                constraintWidget8 = constraintWidget9;
            }
        }
        if (constraintWidget4 == constraintWidget5 || z) {
            ConstraintAnchor constraintAnchor4 = constraintWidget.mListAnchors[i2];
            ConstraintAnchor constraintAnchor5 = constraintWidget3.mListAnchors[i2 + 1];
            SolverVariable solverVariable3 = constraintWidget.mListAnchors[i2].mTarget != null ? constraintWidget.mListAnchors[i2].mTarget.mSolverVariable : null;
            SolverVariable solverVariable4 = constraintWidget3.mListAnchors[i2 + 1].mTarget != null ? constraintWidget3.mListAnchors[i2 + 1].mTarget.mSolverVariable : null;
            if (solverVariable3 != null && solverVariable4 != null) {
                if (i == 0) {
                    f = constraintWidget.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget.mVerticalBiasPercent;
                }
                int margin2 = constraintAnchor4.getMargin();
                if (constraintWidget5 == null) {
                    constraintWidget5 = constraintWidget3;
                }
                linearSystem.addCentering(constraintAnchor4.mSolverVariable, solverVariable3, margin2, f, solverVariable4, constraintAnchor5.mSolverVariable, constraintWidget5.mListAnchors[i2 + 1].getMargin(), 4);
            }
        } else if (z3 && constraintWidget4 != null) {
            ConstraintWidget constraintWidget10 = constraintWidget4;
            ConstraintWidget constraintWidget11 = constraintWidget4;
            while (constraintWidget10 != null) {
                ConstraintWidget constraintWidget12 = constraintWidget10.mListNextVisibleWidget[i];
                if (constraintWidget12 != null || constraintWidget10 == constraintWidget5) {
                    ConstraintAnchor constraintAnchor6 = constraintWidget10.mListAnchors[i2];
                    SolverVariable solverVariable5 = constraintAnchor6.mSolverVariable;
                    SolverVariable solverVariable6 = constraintAnchor6.mTarget != null ? constraintAnchor6.mTarget.mSolverVariable : null;
                    if (constraintWidget11 != constraintWidget10) {
                        solverVariable6 = constraintWidget11.mListAnchors[i2 + 1].mSolverVariable;
                    }
                    SolverVariable solverVariable7 = null;
                    constraintAnchor6.getMargin();
                    if (constraintWidget12 != null) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget12.mListAnchors[i2];
                        solverVariable7 = constraintAnchor7.mSolverVariable;
                        solverVariable2 = constraintAnchor7.mTarget != null ? constraintAnchor7.mTarget.mSolverVariable : null;
                        constraintAnchor7.getMargin();
                    } else {
                        ConstraintAnchor constraintAnchor8 = constraintWidget3.mListAnchors[i2 + 1].mTarget;
                        if (constraintAnchor8 != null) {
                            solverVariable7 = constraintAnchor8.mSolverVariable;
                        }
                        solverVariable2 = constraintWidget10.mListAnchors[i2 + 1].mSolverVariable;
                    }
                    if (!(solverVariable5 == null || solverVariable6 == null || solverVariable7 == null || solverVariable2 == null)) {
                        int i5 = 0;
                        if (constraintWidget10 == constraintWidget4) {
                            i5 = constraintWidget4.mListAnchors[i2].getMargin();
                        }
                        int i6 = 0;
                        if (constraintWidget10 == constraintWidget5) {
                            i6 = constraintWidget5.mListAnchors[i2 + 1].getMargin();
                        }
                        linearSystem.addCentering(solverVariable5, solverVariable6, i5, 0.5f, solverVariable7, solverVariable2, i6, 4);
                    }
                }
                constraintWidget11 = constraintWidget10;
                constraintWidget10 = constraintWidget12;
            }
        } else if (z2 && constraintWidget4 != null) {
            ConstraintWidget constraintWidget13 = constraintWidget4;
            ConstraintWidget constraintWidget14 = constraintWidget4;
            while (constraintWidget13 != null) {
                ConstraintWidget constraintWidget15 = constraintWidget13.mListNextVisibleWidget[i];
                if (!(constraintWidget13 == constraintWidget4 || constraintWidget15 == null)) {
                    if (constraintWidget15 == constraintWidget5) {
                        constraintWidget15 = null;
                    }
                    ConstraintAnchor constraintAnchor9 = constraintWidget13.mListAnchors[i2];
                    SolverVariable solverVariable8 = constraintAnchor9.mSolverVariable;
                    if (constraintAnchor9.mTarget != null) {
                        SolverVariable solverVariable9 = constraintAnchor9.mTarget.mSolverVariable;
                    }
                    SolverVariable solverVariable10 = constraintWidget14.mListAnchors[i2 + 1].mSolverVariable;
                    SolverVariable solverVariable11 = null;
                    constraintAnchor9.getMargin();
                    if (constraintWidget15 != null) {
                        ConstraintAnchor constraintAnchor10 = constraintWidget15.mListAnchors[i2];
                        solverVariable11 = constraintAnchor10.mSolverVariable;
                        solverVariable = constraintAnchor10.mTarget != null ? constraintAnchor10.mTarget.mSolverVariable : null;
                        constraintAnchor10.getMargin();
                    } else {
                        ConstraintAnchor constraintAnchor11 = constraintWidget13.mListAnchors[i2 + 1].mTarget;
                        if (constraintAnchor11 != null) {
                            solverVariable11 = constraintAnchor11.mSolverVariable;
                        }
                        solverVariable = constraintWidget13.mListAnchors[i2 + 1].mSolverVariable;
                    }
                    if (!(solverVariable8 == null || solverVariable10 == null || solverVariable11 == null || solverVariable == null)) {
                        linearSystem.addCentering(solverVariable8, solverVariable10, 0, 0.5f, solverVariable11, solverVariable, 0, 4);
                    }
                }
                constraintWidget14 = constraintWidget13;
                constraintWidget13 = constraintWidget15;
            }
            ConstraintAnchor constraintAnchor12 = constraintWidget4.mListAnchors[i2];
            ConstraintAnchor constraintAnchor13 = constraintWidget.mListAnchors[i2].mTarget;
            ConstraintAnchor constraintAnchor14 = constraintWidget5.mListAnchors[i2 + 1];
            ConstraintAnchor constraintAnchor15 = constraintWidget3.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor13 != null) {
                if (constraintWidget4 != constraintWidget5) {
                    linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, constraintAnchor12.getMargin(), 6);
                } else if (constraintAnchor15 != null) {
                    linearSystem.addCentering(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, constraintAnchor12.getMargin(), 0.5f, constraintAnchor14.mSolverVariable, constraintAnchor15.mSolverVariable, constraintAnchor14.getMargin(), 6);
                }
            }
            if (constraintAnchor15 != null && constraintWidget4 != constraintWidget5) {
                linearSystem.addEquality(constraintAnchor14.mSolverVariable, constraintAnchor15.mSolverVariable, -constraintAnchor14.getMargin(), 6);
            }
        }
    }
}
