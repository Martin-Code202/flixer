package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public class AnimatorInflaterCompat {
    public static Animator loadAnimator(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return loadAnimator(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int i) {
        return loadAnimator(context, resources, theme, i, 1.0f);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int i, float f) {
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = resources.getAnimation(i);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, resources, theme, xmlResourceParser, f);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return createAnimatorFromXml;
        } catch (XmlPullParserException e) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (IOException e2) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException2.initCause(e2);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        private PathDataEvaluator() {
        }

        public PathParser.PathDataNode[] evaluate(float f, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (this.mNodeArray == null || !PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
                this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                this.mNodeArray[i].interpolatePathDataNode(pathDataNodeArr[i], pathDataNodeArr2[i], f);
            }
            return this.mNodeArray;
        }
    }

    private static PropertyValuesHolder getPVH(TypedArray typedArray, int i, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6;
        float f;
        float f2;
        float f3;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            if ((!z || !isColorType(i7)) && (!z2 || !isColorType(i8))) {
                i = 0;
            } else {
                i = 3;
            }
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser.PathDataNode[] createNodesFromPathData = PathParser.createNodesFromPathData(string);
            PathParser.PathDataNode[] createNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
                return null;
            }
            if (createNodesFromPathData != null) {
                PathDataEvaluator pathDataEvaluator = new PathDataEvaluator();
                if (createNodesFromPathData2 == null) {
                    return PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData);
                }
                if (PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                    return PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData, createNodesFromPathData2);
                }
                throw new InflateException(" Can't morph from " + string + " to " + string2);
            } else if (createNodesFromPathData2 != null) {
                return PropertyValuesHolder.ofObject(str, new PathDataEvaluator(), createNodesFromPathData2);
            } else {
                return null;
            }
        } else {
            ArgbEvaluator argbEvaluator = null;
            if (i == 3) {
                argbEvaluator = ArgbEvaluator.getInstance();
            }
            if (z3) {
                if (z) {
                    if (i7 == 5) {
                        f2 = typedArray.getDimension(i2, 0.0f);
                    } else {
                        f2 = typedArray.getFloat(i2, 0.0f);
                    }
                    if (z2) {
                        if (i8 == 5) {
                            f3 = typedArray.getDimension(i3, 0.0f);
                        } else {
                            f3 = typedArray.getFloat(i3, 0.0f);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2, f3);
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2);
                    }
                } else {
                    if (i8 == 5) {
                        f = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f = typedArray.getFloat(i3, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f);
                }
            } else if (z) {
                if (i7 == 5) {
                    i5 = (int) typedArray.getDimension(i2, 0.0f);
                } else if (isColorType(i7)) {
                    i5 = typedArray.getColor(i2, 0);
                } else {
                    i5 = typedArray.getInt(i2, 0);
                }
                if (z2) {
                    if (i8 == 5) {
                        i6 = (int) typedArray.getDimension(i3, 0.0f);
                    } else if (isColorType(i8)) {
                        i6 = typedArray.getColor(i3, 0);
                    } else {
                        i6 = typedArray.getInt(i3, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5, i6);
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
                }
            } else if (z2) {
                if (i8 == 5) {
                    i4 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (isColorType(i8)) {
                    i4 = typedArray.getColor(i3, 0);
                } else {
                    i4 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i4);
            }
            if (propertyValuesHolder == null || argbEvaluator == null) {
                return propertyValuesHolder;
            }
            propertyValuesHolder.setEvaluator(argbEvaluator);
            return propertyValuesHolder;
        }
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long namedInt = (long) TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, SessionEndedEvent.DURATION, 1, 300);
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = inferValueTypeFromValues(typedArray, 5, 6);
            }
            PropertyValuesHolder pvh = getPVH(typedArray, namedInt3, 5, 6, "");
            if (pvh != null) {
                valueAnimator.setValues(pvh);
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            setupObjectAnimator(valueAnimator, typedArray2, namedInt3, f, xmlPullParser);
        }
    }

    private static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString != null) {
            String namedString2 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
            String namedString3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
            if (i == 2 || i == 4) {
            }
            if (namedString2 == null && namedString3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            setupPathMotion(PathParser.createPathFromPathData(namedString), objectAnimator, 0.5f * f, namedString2, namedString3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void setupPathMotion(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f2 = 0.0f;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        int i = 0;
        float f3 = f2 / ((float) (min - 1));
        float f4 = 0.0f;
        for (int i2 = 0; i2 < min; i2++) {
            pathMeasure2.getPosTan(f4, fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f4 += f3;
            if (i + 1 < arrayList.size() && f4 > ((Float) arrayList.get(i + 1)).floatValue()) {
                f4 -= ((Float) arrayList.get(i + 1)).floatValue();
                i++;
                pathMeasure2.nextContour();
            }
        }
        PropertyValuesHolder propertyValuesHolder = null;
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (str != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, fArr);
        }
        if (str2 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder == null) {
            objectAnimator.setValues(propertyValuesHolder2);
        } else if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(propertyValuesHolder);
        } else {
            objectAnimator.setValues(propertyValuesHolder, propertyValuesHolder2);
        }
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) {
        Animator animator = null;
        ArrayList arrayList = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    boolean z = false;
                    if (name.equals("objectAnimator")) {
                        animator = loadObjectAnimator(context, resources, theme, attributeSet, f, xmlPullParser);
                    } else if (name.equals("animator")) {
                        animator = loadAnimator(context, resources, theme, attributeSet, null, f, xmlPullParser);
                    } else if (name.equals("set")) {
                        animator = new AnimatorSet();
                        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
                        createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, (AnimatorSet) animator, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "ordering", 0, 0), f);
                        obtainAttributes.recycle();
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] loadValues = loadValues(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (!(loadValues == null || animator == null || !(animator instanceof ValueAnimator))) {
                            ((ValueAnimator) animator).setValues(loadValues);
                        }
                        z = true;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null && !z) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animator);
                    }
                }
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            int i2 = 0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i2++;
                animatorArr[i2] = (Animator) it.next();
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    private static PropertyValuesHolder[] loadValues(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                    String namedString = TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser, "propertyName", 3);
                    int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder loadPvh = loadPvh(context, resources, theme, xmlPullParser, namedString, namedInt);
                    if (loadPvh == null) {
                        loadPvh = getPVH(obtainAttributes, namedInt, 0, 1, namedString);
                    }
                    if (loadPvh != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(loadPvh);
                    }
                    obtainAttributes.recycle();
                }
                xmlPullParser.next();
            }
        }
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (int i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    private static int inferValueTypeOfKeyframe(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        int i;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if (!(peekNamedValue != null) || !isColorType(peekNamedValue.type)) {
            i = 0;
        } else {
            i = 3;
        }
        obtainAttributes.recycle();
        return i;
    }

    private static int inferValueTypeFromValues(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = peekValue != null;
        int i3 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        boolean z2 = peekValue2 != null;
        int i4 = z2 ? peekValue2.type : 0;
        if ((!z || !isColorType(i3)) && (!z2 || !isColorType(i4))) {
            return 0;
        }
        return 3;
    }

    private static PropertyValuesHolder loadPvh(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i == 4) {
                    i = inferValueTypeOfKeyframe(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe loadKeyframe = loadKeyframe(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i, xmlPullParser);
                if (loadKeyframe != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(loadKeyframe);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = size;
            if (size > 0) {
                Keyframe keyframe = (Keyframe) arrayList.get(0);
                Keyframe keyframe2 = (Keyframe) arrayList.get(i2 - 1);
                float fraction = keyframe2.getFraction();
                if (fraction < 1.0f) {
                    if (fraction < 0.0f) {
                        keyframe2.setFraction(1.0f);
                    } else {
                        arrayList.add(arrayList.size(), createNewKeyframe(keyframe2, 1.0f));
                        i2++;
                    }
                }
                float fraction2 = keyframe.getFraction();
                if (fraction2 != 0.0f) {
                    if (fraction2 < 0.0f) {
                        keyframe.setFraction(0.0f);
                    } else {
                        arrayList.add(0, createNewKeyframe(keyframe, 0.0f));
                        i2++;
                    }
                }
                Keyframe[] keyframeArr = new Keyframe[i2];
                arrayList.toArray(keyframeArr);
                for (int i3 = 0; i3 < i2; i3++) {
                    Keyframe keyframe3 = keyframeArr[i3];
                    if (keyframe3.getFraction() < 0.0f) {
                        if (i3 == 0) {
                            keyframe3.setFraction(0.0f);
                        } else if (i3 == i2 - 1) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i3;
                            int i5 = i3 + 1;
                            while (i5 < i2 - 1 && keyframeArr[i5].getFraction() < 0.0f) {
                                i4 = i5;
                                i5++;
                            }
                            distributeKeyframes(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, i4);
                        }
                    }
                }
                propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                if (i == 3) {
                    propertyValuesHolder.setEvaluator(ArgbEvaluator.getInstance());
                }
            }
        }
        return propertyValuesHolder;
    }

    private static Keyframe createNewKeyframe(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    private static void distributeKeyframes(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((float) ((i2 - i) + 2));
        for (int i3 = i; i3 <= i2; i3++) {
            keyframeArr[i3].setFraction(keyframeArr[i3 - 1].getFraction() + f2);
        }
    }

    private static Keyframe loadKeyframe(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        Keyframe keyframe = null;
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        boolean z = peekNamedValue != null;
        if (i == 4) {
            if (!z || !isColorType(peekNamedValue.type)) {
                i = 0;
            } else {
                i = 3;
            }
        }
        if (z) {
            switch (i) {
                case 0:
                    keyframe = Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "value", 0, 0.0f));
                    break;
                case 1:
                case 3:
                    keyframe = Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "value", 0, 0));
                    break;
            }
        } else if (i == 0) {
            keyframe = Keyframe.ofFloat(namedFloat);
        } else {
            keyframe = Keyframe.ofInt(namedFloat);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 1, 0);
        if (namedResourceId > 0) {
            keyframe.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        return keyframe;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, obtainAttributes, obtainAttributes2, f, xmlPullParser);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }

    private static boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }
}
