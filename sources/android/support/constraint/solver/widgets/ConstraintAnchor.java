package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.HashSet;
public class ConstraintAnchor {
    private int mConnectionCreator = 0;
    private ConnectionType mConnectionType = ConnectionType.RELAXED;
    int mGoneMargin = -1;
    public int mMargin = 0;
    final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    private Strength mStrength = Strength.NONE;
    ConstraintAnchor mTarget;
    final Type mType;
    public int resolutionStatus = 0;
    ConstraintAnchor resolvedAnchor = null;
    public int resolvedValue = -1;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* access modifiers changed from: package-private */
    public void resolve(LinearSystem linearSystem, int i, ConstraintAnchor constraintAnchor) {
        if (this.mSolverVariable == null) {
            this.mSolverVariable = linearSystem.createObjectVariable(this);
        }
        this.resolutionStatus = 1;
        this.resolvedValue = i;
        this.resolvedAnchor = constraintAnchor;
    }

    /* access modifiers changed from: package-private */
    public void addResolvedValue(LinearSystem linearSystem) {
        this.mSolverVariable = linearSystem.createObjectVariable(this);
        if (this.resolvedAnchor == null) {
            linearSystem.addEquality(this.mSolverVariable, this.resolvedValue);
            return;
        }
        linearSystem.addEquality(this.mSolverVariable, linearSystem.createObjectVariable(this.resolvedAnchor), this.resolvedValue, 6);
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public void resetSolverVariable(Cache cache) {
        if (this.mSolverVariable == null) {
            this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            this.mSolverVariable.reset();
        }
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public Type getType() {
        return this.mType;
    }

    public int getMargin() {
        if (this.mOwner.getVisibility() == 8) {
            return 0;
        }
        if (this.mGoneMargin <= -1 || this.mTarget == null || this.mTarget.mOwner.getVisibility() != 8) {
            return this.mMargin;
        }
        return this.mGoneMargin;
    }

    public Strength getStrength() {
        return this.mStrength;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public int getConnectionCreator() {
        return this.mConnectionCreator;
    }

    public void reset() {
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mStrength = Strength.STRONG;
        this.mConnectionCreator = 0;
        this.mConnectionType = ConnectionType.RELAXED;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        return connect(constraintAnchor, i, -1, strength, i2, false);
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.mTarget = null;
            this.mMargin = 0;
            this.mGoneMargin = -1;
            this.mStrength = Strength.NONE;
            this.mConnectionCreator = 2;
            return true;
        } else if (!z && !isValidConnection(constraintAnchor)) {
            return false;
        } else {
            this.mTarget = constraintAnchor;
            if (i > 0) {
                this.mMargin = i;
            } else {
                this.mMargin = 0;
            }
            this.mGoneMargin = i2;
            this.mStrength = strength;
            this.mConnectionCreator = i3;
            return true;
        }
    }

    public boolean isConnected() {
        return this.mTarget != null;
    }

    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.getType();
        if (type != this.mType) {
            switch (this.mType) {
                case CENTER:
                    return (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) ? false : true;
                case LEFT:
                case RIGHT:
                    boolean z = type == Type.LEFT || type == Type.RIGHT;
                    if (constraintAnchor.getOwner() instanceof Guideline) {
                        return z || type == Type.CENTER_X;
                    }
                    return z;
                case TOP:
                case BOTTOM:
                    boolean z2 = type == Type.TOP || type == Type.BOTTOM;
                    if (constraintAnchor.getOwner() instanceof Guideline) {
                        return z2 || type == Type.CENTER_Y;
                    }
                    return z2;
                case BASELINE:
                case CENTER_X:
                case CENTER_Y:
                case NONE:
                    return false;
                default:
                    throw new AssertionError(this.mType.name());
            }
        } else if (this.mType != Type.BASELINE) {
            return true;
        } else {
            if (!constraintAnchor.getOwner().hasBaseline() || !getOwner().hasBaseline()) {
                return false;
            }
            return true;
        }
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString() + (this.mTarget != null ? " connected to " + this.mTarget.toString(new HashSet<>()) : "");
    }

    private String toString(HashSet<ConstraintAnchor> hashSet) {
        if (!hashSet.add(this)) {
            return "<-";
        }
        return this.mOwner.getDebugName() + ":" + this.mType.toString() + (this.mTarget != null ? " connected to " + this.mTarget.toString(hashSet) : "");
    }
}
