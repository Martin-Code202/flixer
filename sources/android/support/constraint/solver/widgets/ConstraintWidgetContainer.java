package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.Arrays;
public class ConstraintWidgetContainer extends WidgetContainer {
    int mDebugSolverPassCount = 0;
    private boolean mHeightMeasuredTooSmall = false;
    ConstraintWidget[] mHorizontalChainsArray = new ConstraintWidget[4];
    int mHorizontalChainsSize = 0;
    private int mOptimizationLevel = 2;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem = new LinearSystem();
    ConstraintWidget[] mVerticalChainsArray = new ConstraintWidget[4];
    int mVerticalChainsSize = 0;
    private boolean mWidthMeasuredTooSmall = false;

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    @Override // android.support.constraint.solver.widgets.WidgetContainer, android.support.constraint.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        boolean z = true;
        if (this.mOptimizationLevel == 2 || this.mOptimizationLevel == 4) {
            if (Optimizer.optimize(linearSystem, this)) {
                return false;
            }
            z = true;
        }
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                if (z) {
                    Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                }
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize <= 0) {
            return true;
        }
        Chain.applyChainConstraints(this, linearSystem, 1);
        return true;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.WidgetContainer
    public void layout() {
        int i = this.mX;
        int i2 = this.mY;
        int max = Math.max(0, getWidth());
        int max2 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        if (this.mParent != null) {
            if (this.mSnapshot == null) {
                this.mSnapshot = new Snapshot(this);
            }
            this.mSnapshot.updateFrom(this);
            setX(this.mPaddingLeft);
            setY(this.mPaddingTop);
            resetAnchors();
            resetSolverVariables(this.mSystem.getCache());
        } else {
            this.mX = 0;
            this.mY = 0;
        }
        boolean z = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mListDimensionBehaviors[0];
        resetChains();
        int size = this.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i3);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).layout();
            }
        }
        boolean z2 = true;
        int i4 = 0;
        while (z2) {
            i4++;
            try {
                this.mSystem.reset();
                z2 = addChildrenToSolver(this.mSystem);
                if (z2) {
                    this.mSystem.minimize();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("EXCEPTION : " + e);
            }
            if (!z2) {
                updateFromSolver(this.mSystem);
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    ConstraintWidget constraintWidget2 = (ConstraintWidget) this.mChildren.get(i5);
                    if (constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.getWidth() < constraintWidget2.getWrapWidth()) {
                        Optimizer.flags[2] = true;
                        break;
                    }
                    if (constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.getHeight() < constraintWidget2.getWrapHeight()) {
                        Optimizer.flags[2] = true;
                        break;
                    }
                    i5++;
                }
            } else {
                updateChildrenFromSolver(this.mSystem, Optimizer.flags);
            }
            z2 = false;
            if (i4 < 8 && Optimizer.flags[2]) {
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < size; i8++) {
                    ConstraintWidget constraintWidget3 = (ConstraintWidget) this.mChildren.get(i8);
                    i6 = Math.max(i6, constraintWidget3.mX + constraintWidget3.getWidth());
                    i7 = Math.max(i7, constraintWidget3.mY + constraintWidget3.getHeight());
                }
                int max3 = Math.max(this.mMinWidth, i6);
                int max4 = Math.max(this.mMinHeight, i7);
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getWidth() < max3) {
                    setWidth(max3);
                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    z = true;
                    z2 = true;
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getHeight() < max4) {
                    setHeight(max4);
                    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    z = true;
                    z2 = true;
                }
            }
            int max5 = Math.max(this.mMinWidth, getWidth());
            if (max5 > getWidth()) {
                setWidth(max5);
                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z = true;
                z2 = true;
            }
            int max6 = Math.max(this.mMinHeight, getHeight());
            if (max6 > getHeight()) {
                setHeight(max6);
                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z = true;
                z2 = true;
            }
            if (!z) {
                if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && max > 0 && getWidth() > max) {
                    this.mWidthMeasuredTooSmall = true;
                    z = true;
                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setWidth(max);
                    z2 = true;
                }
                if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && max2 > 0 && getHeight() > max2) {
                    this.mHeightMeasuredTooSmall = true;
                    z = true;
                    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setHeight(max2);
                    z2 = true;
                }
            }
        }
        if (this.mParent != null) {
            int max7 = Math.max(this.mMinWidth, getWidth());
            int max8 = Math.max(this.mMinHeight, getHeight());
            this.mSnapshot.applyTo(this);
            setWidth(this.mPaddingLeft + max7 + this.mPaddingRight);
            setHeight(this.mPaddingTop + max8 + this.mPaddingBottom);
        } else {
            this.mX = i;
            this.mY = i2;
        }
        if (z) {
            this.mListDimensionBehaviors[0] = dimensionBehaviour2;
            this.mListDimensionBehaviors[1] = dimensionBehaviour;
        }
        resetSolverVariables(this.mSystem.getCache());
        if (this == getRootConstraintContainer()) {
            updateDrawPosition();
        }
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2 = constraintWidget;
        if (i == 0) {
            while (constraintWidget2.mLeft.mTarget != null && constraintWidget2.mLeft.mTarget.mOwner.mRight.mTarget != null && constraintWidget2.mLeft.mTarget.mOwner.mRight.mTarget == constraintWidget2.mLeft && constraintWidget2.mLeft.mTarget.mOwner != constraintWidget2) {
                constraintWidget2 = constraintWidget2.mLeft.mTarget.mOwner;
            }
            addHorizontalChain(constraintWidget2);
        } else if (i == 1) {
            while (constraintWidget2.mTop.mTarget != null && constraintWidget2.mTop.mTarget.mOwner.mBottom.mTarget != null && constraintWidget2.mTop.mTarget.mOwner.mBottom.mTarget == constraintWidget2.mTop && constraintWidget2.mTop.mTarget.mOwner != constraintWidget2) {
                constraintWidget2 = constraintWidget2.mTop.mTarget.mOwner;
            }
            addVerticalChain(constraintWidget2);
        }
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        for (int i = 0; i < this.mHorizontalChainsSize; i++) {
            if (this.mHorizontalChainsArray[i] == constraintWidget) {
                return;
            }
        }
        if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
            this.mHorizontalChainsArray = (ConstraintWidget[]) Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = constraintWidget;
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        for (int i = 0; i < this.mVerticalChainsSize; i++) {
            if (this.mVerticalChainsArray[i] == constraintWidget) {
                return;
            }
        }
        if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
            this.mVerticalChainsArray = (ConstraintWidget[]) Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = constraintWidget;
        this.mVerticalChainsSize++;
    }
}
