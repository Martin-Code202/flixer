package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget;
public class Optimizer {
    static boolean[] flags = new boolean[3];

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.setHorizontalDimension(i, width);
            constraintWidget.mHorizontalResolution = 2;
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.setVerticalDimension(i2, height);
            constraintWidget.mVerticalResolution = 2;
        }
    }

    static boolean optimize(LinearSystem linearSystem, ConstraintWidgetContainer constraintWidgetContainer) {
        int size = constraintWidgetContainer.mChildren.size();
        boolean z = constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i);
            if (z) {
                constraintWidget.mLeft.resolutionStatus = 2;
                constraintWidget.mRight.resolutionStatus = 2;
            } else {
                constraintWidget.mLeft.resolutionStatus = 0;
                constraintWidget.mRight.resolutionStatus = 0;
            }
            if (z2) {
                constraintWidget.mTop.resolutionStatus = 2;
                constraintWidget.mBottom.resolutionStatus = 2;
                constraintWidget.mBaseline.resolutionStatus = 2;
            } else {
                constraintWidget.mTop.resolutionStatus = 0;
                constraintWidget.mBottom.resolutionStatus = 0;
                constraintWidget.mBaseline.resolutionStatus = 0;
            }
        }
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget2 = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i2);
            ConstraintAnchor constraintAnchor = constraintWidget2.mListAnchors[0];
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mListAnchors[1];
            if (constraintAnchor.resolutionStatus == 0 && constraintAnchor2.resolutionStatus == 0) {
                if (constraintAnchor.mTarget == null || constraintAnchor2.mTarget == null) {
                    if (constraintAnchor.mTarget != null && constraintAnchor.mTarget == constraintWidgetContainer.mLeft) {
                        constraintAnchor.resolve(linearSystem, constraintAnchor.getMargin(), null);
                    } else if (constraintAnchor2.mTarget != null && constraintAnchor2.mTarget == constraintWidgetContainer.mRight) {
                        constraintAnchor2.resolve(linearSystem, constraintWidgetContainer.mWidth - constraintAnchor2.getMargin(), null);
                    }
                } else if (!z && constraintAnchor.mTarget == constraintWidgetContainer.mLeft && constraintAnchor2.mTarget == constraintWidgetContainer.mRight && constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int margin = ((int) ((constraintWidget2.mHorizontalBiasPercent * ((float) (((constraintWidgetContainer.mWidth - constraintWidget2.mWidth) - constraintAnchor.getMargin()) - constraintAnchor2.getMargin()))) + 0.5f)) + constraintAnchor.getMargin();
                    constraintAnchor.resolve(linearSystem, margin, null);
                    constraintAnchor2.resolve(linearSystem, constraintWidget2.mWidth + margin, null);
                }
            }
            ConstraintAnchor constraintAnchor3 = constraintWidget2.mListAnchors[2];
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mListAnchors[3];
            if (constraintAnchor3.resolutionStatus == 0 && constraintAnchor4.resolutionStatus == 0) {
                if (constraintAnchor3.mTarget == null || constraintAnchor4.mTarget == null) {
                    if (constraintAnchor3.mTarget != null && constraintAnchor3.mTarget == constraintWidgetContainer.mTop) {
                        constraintAnchor3.resolve(linearSystem, constraintAnchor3.getMargin(), null);
                    } else if (constraintAnchor4.mTarget != null && constraintAnchor4.mTarget == constraintWidgetContainer.mBottom) {
                        constraintAnchor4.resolve(linearSystem, constraintWidgetContainer.mHeight - constraintAnchor4.getMargin(), null);
                    }
                } else if (!z2 && constraintAnchor3.mTarget == constraintWidgetContainer.mTop && constraintAnchor4.mTarget == constraintWidgetContainer.mBottom && constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int margin2 = ((int) ((constraintWidget2.mVerticalBiasPercent * ((float) (((constraintWidgetContainer.mHeight - constraintWidget2.mHeight) - constraintAnchor3.getMargin()) - constraintAnchor4.getMargin()))) + 0.5f)) + constraintAnchor3.getMargin();
                    constraintAnchor3.resolve(linearSystem, margin2, null);
                    constraintAnchor4.resolve(linearSystem, constraintWidget2.mHeight + margin2, null);
                }
            }
        }
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget3 = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i3);
            if (constraintWidget3.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidget3.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                ConstraintAnchor constraintAnchor5 = constraintWidget3.mListAnchors[0];
                ConstraintAnchor constraintAnchor6 = constraintWidget3.mListAnchors[1];
                if (constraintAnchor5.resolutionStatus == 1 && constraintAnchor6.resolutionStatus == 0) {
                    if (constraintAnchor5.resolvedAnchor == null) {
                        constraintAnchor6.resolve(linearSystem, constraintAnchor5.resolvedValue + constraintWidget3.getWidth(), null);
                    } else {
                        constraintAnchor6.resolve(linearSystem, constraintWidget3.getWidth(), constraintAnchor5);
                    }
                } else if (constraintAnchor5.resolutionStatus == 0 && constraintAnchor6.resolutionStatus == 1) {
                    if (constraintAnchor6.resolvedAnchor == null) {
                        constraintAnchor5.resolve(linearSystem, constraintAnchor6.resolvedValue - constraintWidget3.getWidth(), null);
                    } else {
                        constraintAnchor5.resolve(linearSystem, -constraintWidget3.getWidth(), constraintAnchor6);
                    }
                }
            }
            if (constraintWidget3.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidget3.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                ConstraintAnchor constraintAnchor7 = constraintWidget3.mTop;
                ConstraintAnchor constraintAnchor8 = constraintWidget3.mBottom;
                if (constraintAnchor7.resolutionStatus == 1 && constraintAnchor8.resolutionStatus == 0) {
                    if (constraintAnchor7.resolvedAnchor == null) {
                        constraintAnchor8.resolve(linearSystem, constraintAnchor7.resolvedValue + constraintWidget3.getHeight(), null);
                    } else {
                        constraintAnchor8.resolve(linearSystem, constraintWidget3.getHeight(), constraintAnchor7);
                    }
                } else if (constraintAnchor7.resolutionStatus == 0 && constraintAnchor8.resolutionStatus == 1) {
                    if (constraintAnchor8.resolvedAnchor == null) {
                        constraintAnchor7.resolve(linearSystem, constraintAnchor8.resolvedValue - constraintWidget3.getHeight(), null);
                    } else {
                        constraintAnchor7.resolve(linearSystem, -constraintWidget3.getHeight(), constraintAnchor8);
                    }
                }
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget4 = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i4);
            if (!(constraintWidget4.mLeft.resolutionStatus == 1 && constraintWidget4.mRight.resolutionStatus == 1 && constraintWidget4.mTop.resolutionStatus == 1 && constraintWidget4.mBottom.resolutionStatus == 1)) {
                return false;
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget5 = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i5);
            constraintWidget5.setFrame(constraintWidget5.mLeft.resolvedValue, constraintWidget5.mTop.resolvedValue, constraintWidget5.mRight.resolvedValue, constraintWidget5.mBottom.resolvedValue);
        }
        return true;
    }
}
