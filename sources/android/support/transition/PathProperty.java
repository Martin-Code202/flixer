package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
class PathProperty<T> extends Property<T, Float> {
    private float mCurrentFraction;
    private final float mPathLength;
    private final PathMeasure mPathMeasure;
    private final PointF mPointF = new PointF();
    private final float[] mPosition = new float[2];
    private final Property<T, PointF> mProperty;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
        set((PathProperty<T>) obj, f);
    }

    PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.mProperty = property;
        this.mPathMeasure = new PathMeasure(path, false);
        this.mPathLength = this.mPathMeasure.getLength();
    }

    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.mCurrentFraction);
    }

    public void set(T t, Float f) {
        this.mCurrentFraction = f.floatValue();
        this.mPathMeasure.getPosTan(this.mPathLength * f.floatValue(), this.mPosition, null);
        this.mPointF.x = this.mPosition[0];
        this.mPointF.y = this.mPosition[1];
        this.mProperty.set(t, this.mPointF);
    }
}
