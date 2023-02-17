package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;
public class ConstraintWidget {
    public static float DEFAULT_BIAS = 0.5f;
    protected ArrayList<ConstraintAnchor> mAnchors = new ArrayList<>();
    ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    int mBaselineDistance = 0;
    ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
    ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    private float mCircleConstraintAngle = 0.0f;
    private Object mCompanionWidget;
    private int mContainerItemSkip = 0;
    private String mDebugName = null;
    protected float mDimensionRatio = 0.0f;
    protected int mDimensionRatioSide = -1;
    private int mDrawHeight = 0;
    private int mDrawWidth = 0;
    private int mDrawX = 0;
    private int mDrawY = 0;
    int mHeight = 0;
    float mHorizontalBiasPercent = DEFAULT_BIAS;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle = 0;
    ConstraintWidget mHorizontalNextWidget = null;
    public int mHorizontalResolution = -1;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    protected ConstraintAnchor[] mListAnchors = {this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
    protected DimensionBehaviour[] mListDimensionBehaviors = {DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
    protected ConstraintWidget[] mListNextMatchConstraintsWidget = {null, null};
    protected ConstraintWidget[] mListNextVisibleWidget = {null, null};
    int mMatchConstraintDefaultHeight = 0;
    int mMatchConstraintDefaultWidth = 0;
    int mMatchConstraintMaxHeight = 0;
    int mMatchConstraintMaxWidth = 0;
    int mMatchConstraintMinHeight = 0;
    int mMatchConstraintMinWidth = 0;
    float mMatchConstraintPercentHeight = 1.0f;
    float mMatchConstraintPercentWidth = 1.0f;
    private int[] mMaxDimension = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    protected int mMinHeight;
    protected int mMinWidth;
    protected int mOffsetX = 0;
    protected int mOffsetY = 0;
    ConstraintWidget mParent = null;
    float mResolvedDimensionRatio = 1.0f;
    int mResolvedDimensionRatioSide = -1;
    ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    private String mType = null;
    float mVerticalBiasPercent = DEFAULT_BIAS;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle = 0;
    ConstraintWidget mVerticalNextWidget = null;
    public int mVerticalResolution = -1;
    boolean mVerticalWrapVisited;
    private int mVisibility = 0;
    float[] mWeight = {0.0f, 0.0f};
    int mWidth = 0;
    private int mWrapHeight;
    private int mWrapWidth;
    protected int mX = 0;
    protected int mY = 0;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        this.mWeight[0] = 0.0f;
        this.mWeight[1] = 0.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMaxDimension[0] = Integer.MAX_VALUE;
        this.mMaxDimension[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
    }

    public ConstraintWidget() {
        addAnchors();
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public String toString() {
        return (this.mType != null ? "type: " + this.mType + " " : "") + (this.mDebugName != null ? "id: " + this.mDebugName + " " : "") + "(" + this.mX + ", " + this.mY + ") - (" + this.mWidth + " x " + this.mHeight + ") wrap: (" + this.mWrapWidth + " x " + this.mWrapHeight + ")";
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void updateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        int i4 = this.mY + this.mHeight;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setDimensionRatio(String str) {
        int i;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i2 = -1;
        float f = 0.0f;
        int length = str.length();
        int indexOf = str.indexOf(44);
        if (indexOf <= 0 || indexOf >= length - 1) {
            i = 0;
        } else {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i);
            if (substring2.length() > 0) {
                try {
                    f = Float.parseFloat(substring2);
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String substring3 = str.substring(i, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                try {
                    float parseFloat = Float.parseFloat(substring3);
                    float parseFloat2 = Float.parseFloat(substring4);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        f = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (f > 0.0f) {
            this.mDimensionRatio = f;
            this.mDimensionRatioSide = i2;
        }
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i5 < this.mWidth) {
            i5 = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i6 < this.mHeight) {
            i6 = this.mHeight;
        }
        this.mWidth = i5;
        this.mHeight = i6;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        this.mWidth = i2 - i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public void addToSolver(LinearSystem linearSystem) {
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        if (this.mParent != null) {
            z3 = this.mParent != null ? this.mParent.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT : false;
            z4 = this.mParent != null ? this.mParent.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT : false;
            if ((this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) || (this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                z = true;
            }
            if ((this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) || (this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                z2 = true;
            }
            if (z3 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (z4 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
            }
        }
        int i = this.mWidth;
        if (i < this.mMinWidth) {
            i = this.mMinWidth;
        }
        int i2 = this.mHeight;
        if (i2 < this.mMinHeight) {
            i2 = this.mMinHeight;
        }
        boolean z5 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z6 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z7 = false;
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        this.mResolvedDimensionRatio = this.mDimensionRatio;
        if (this.mDimensionRatio > 0.0f && this.mVisibility != 8) {
            z7 = true;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                setupDimensionRatio(z3, z4, z5, z6);
            } else if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mResolvedDimensionRatioSide = 0;
                i = (int) (this.mResolvedDimensionRatio * ((float) this.mHeight));
            } else if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
                i2 = (int) (this.mResolvedDimensionRatio * ((float) this.mWidth));
            }
        }
        boolean z8 = z7 && (this.mResolvedDimensionRatioSide == 0 || this.mResolvedDimensionRatioSide == -1);
        boolean z9 = this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
        if (this.mHorizontalResolution != 2) {
            applyConstraints(linearSystem, z3, this.mParent != null ? linearSystem.createObjectVariable(this.mParent.mLeft) : null, this.mParent != null ? linearSystem.createObjectVariable(this.mParent.mRight) : null, this.mListDimensionBehaviors[0], z9, this.mLeft, this.mRight, this.mX, i, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z8, z, this.mMatchConstraintDefaultWidth, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, true);
        }
        if (this.mVerticalResolution != 2) {
            boolean z10 = this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
            boolean z11 = z7 && (this.mResolvedDimensionRatioSide == 1 || this.mResolvedDimensionRatioSide == -1);
            boolean z12 = true;
            if (this.mBaselineDistance > 0) {
                linearSystem.addEquality(createObjectVariable5, createObjectVariable3, getBaselineDistance(), 6);
                if (this.mBaseline.mTarget != null) {
                    linearSystem.addEquality(createObjectVariable5, linearSystem.createObjectVariable(this.mBaseline.mTarget), 0, 6);
                    z12 = false;
                }
            }
            applyConstraints(linearSystem, z4, this.mParent != null ? linearSystem.createObjectVariable(this.mParent.mTop) : null, this.mParent != null ? linearSystem.createObjectVariable(this.mParent.mBottom) : null, this.mListDimensionBehaviors[1], z10, this.mTop, this.mBottom, this.mY, i2, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z11, z2, this.mMatchConstraintDefaultHeight, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z12);
            if (z7) {
                if (this.mResolvedDimensionRatioSide == 1) {
                    linearSystem.addRatio(createObjectVariable4, createObjectVariable3, createObjectVariable2, createObjectVariable, this.mResolvedDimensionRatio, 6);
                } else {
                    linearSystem.addRatio(createObjectVariable2, createObjectVariable, createObjectVariable4, createObjectVariable3, this.mResolvedDimensionRatio, 6);
                }
            }
            if (this.mCenter.isConnected()) {
                linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians((double) (this.mCircleConstraintAngle + 90.0f)), this.mCenter.getMargin());
            }
        }
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 3;
        }
        if (this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 3;
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide != -1) {
            return;
        }
        if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
            this.mResolvedDimensionRatioSide = 0;
        } else if (this.mMatchConstraintMinWidth != 0 || this.mMatchConstraintMinHeight <= 0) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        } else {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    private void applyConstraints(LinearSystem linearSystem, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        if (constraintAnchor.resolutionStatus == 1 && constraintAnchor2.resolutionStatus == 1) {
            constraintAnchor.addResolvedValue(linearSystem);
            constraintAnchor2.addResolvedValue(linearSystem);
            return;
        }
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        boolean z6 = false;
        if (z3) {
            i5 = 3;
        }
        switch (dimensionBehaviour) {
            case FIXED:
                z6 = false;
                break;
            case WRAP_CONTENT:
                z6 = false;
                break;
            case MATCH_PARENT:
                z6 = false;
                break;
            case MATCH_CONSTRAINT:
                z6 = true;
                break;
        }
        if (this.mVisibility == 8) {
            i2 = 0;
            z6 = false;
        }
        if (z6) {
            if (i6 == -2) {
                i6 = i2;
            }
            if (i7 == -2) {
                i7 = i2;
            }
            if (i6 > 0) {
                if (z) {
                    linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i6, 6);
                } else {
                    linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i6, 6);
                }
                i2 = Math.max(i2, i6);
            }
            if (i7 > 0) {
                if (z) {
                    linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i7, 1);
                } else {
                    linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i7, 6);
                }
                i2 = Math.min(i2, i7);
            }
            if (i5 == 1) {
                if (z || z4) {
                    linearSystem.addEquality(createObjectVariable2, createObjectVariable, i2, 3);
                } else {
                    linearSystem.addEquality(createObjectVariable2, createObjectVariable, i2, 1);
                }
            } else if (i5 == 2) {
                if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                    solverVariable4 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                    solverVariable3 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                } else {
                    solverVariable4 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                    solverVariable3 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                }
                linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable2, createObjectVariable, solverVariable3, solverVariable4, f2));
                z6 = false;
            }
        } else if (z2) {
            linearSystem.addEquality(createObjectVariable2, createObjectVariable, 0, 3);
            if (i3 > 0) {
                linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i3, 6);
            }
            if (i4 < Integer.MAX_VALUE) {
                linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i4, 6);
            }
        } else {
            linearSystem.addEquality(createObjectVariable2, createObjectVariable, i2, 6);
        }
        int i8 = 0;
        if (isConnected) {
            i8 = 0 + 1;
        }
        if (isConnected2) {
            i8++;
        }
        if (isConnected3) {
            i8++;
        }
        if (z6 && i8 != 2 && !z3) {
            z6 = false;
            int max = Math.max(i6, i2);
            if (i7 > 0) {
                max = Math.min(i7, max);
            }
            linearSystem.addEquality(createObjectVariable2, createObjectVariable, max, 6);
        }
        if (z5 && !z4) {
            if (!isConnected && !isConnected2 && !isConnected3) {
                linearSystem.addEquality(createObjectVariable, i);
                if (z) {
                    linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, 0, 5);
                }
            } else if (isConnected && !isConnected2) {
                linearSystem.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 6);
                if (z) {
                    linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, 0, 5);
                }
            } else if (!isConnected && isConnected2) {
                linearSystem.addEquality(createObjectVariable2, createObjectVariable4, -constraintAnchor2.getMargin(), 6);
                if (z) {
                    linearSystem.addGreaterThan(createObjectVariable, solverVariable, 0, 5);
                }
            } else if (isConnected && isConnected2 && !z4) {
                if (z6) {
                    if (z && i3 == 0) {
                        linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 6);
                    }
                    linearSystem.addGreaterThan(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 6);
                    linearSystem.addLowerThan(createObjectVariable2, createObjectVariable4, -constraintAnchor2.getMargin(), 6);
                    if (i5 == 0) {
                        linearSystem.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 4);
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable4, -constraintAnchor2.getMargin(), 4);
                    } else if (i5 == 3) {
                        int i9 = 3;
                        if (!z3) {
                            i9 = 5;
                        }
                        linearSystem.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), i9);
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable4, -constraintAnchor2.getMargin(), i9);
                    }
                }
                if (!z6 || !(i5 == 0 || i5 == 1)) {
                    if (z6 && i5 == 3) {
                        linearSystem.addCentering(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), f, createObjectVariable4, createObjectVariable2, constraintAnchor2.getMargin(), 5);
                    } else if (z) {
                        linearSystem.addGreaterThan(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 5);
                        linearSystem.addLowerThan(createObjectVariable2, createObjectVariable4, -constraintAnchor2.getMargin(), 5);
                        linearSystem.addCentering(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), f, createObjectVariable4, createObjectVariable2, constraintAnchor2.getMargin(), 5);
                    } else {
                        linearSystem.addCentering(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), f, createObjectVariable4, createObjectVariable2, constraintAnchor2.getMargin(), 5);
                    }
                } else if (i5 == 1) {
                    linearSystem.addCentering(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), f, createObjectVariable4, createObjectVariable2, constraintAnchor2.getMargin(), 6);
                } else if (i5 == 0 && (i7 > 0 || i6 > 0)) {
                    linearSystem.addCentering(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), f, createObjectVariable4, createObjectVariable2, constraintAnchor2.getMargin(), 5);
                }
            }
            if (z) {
                linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, 0, 6);
            }
        } else if (i8 < 2 && z) {
            linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, 0, 6);
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        setFrame(linearSystem.getObjectVariableValue(this.mLeft), linearSystem.getObjectVariableValue(this.mTop), linearSystem.getObjectVariableValue(this.mRight), linearSystem.getObjectVariableValue(this.mBottom));
    }
}
