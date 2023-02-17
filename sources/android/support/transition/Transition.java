package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
public abstract class Transition implements Cloneable {
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() { // from class: android.support.transition.Transition.1
        @Override // android.support.transition.PathMotion
        public Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    private ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded = false;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<TransitionListener> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances = 0;
    TransitionSet mParent = null;
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    TransitionPropagation mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class> mTargetTypeChildExcludes = null;
    private ArrayList<Class> mTargetTypeExcludes = null;
    private ArrayList<Class> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();

    public static abstract class EpicenterCallback {
    }

    public interface TransitionListener {
        void onTransitionEnd(Transition transition);

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public abstract void captureStartValues(TransitionValues transitionValues);

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, SessionEndedEvent.DURATION, 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(parseMatchOrder(namedString));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
                i--;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return iArr;
    }

    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (alreadyContains(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View keyAt = arrayMap.keyAt(size);
            if (!(keyAt == null || !isValidTarget(keyAt) || (remove = arrayMap2.remove(keyAt)) == null || remove.view == null || !isValidTarget(remove.view))) {
                this.mStartValuesList.add(arrayMap.removeAt(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = longSparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i = 0; i < size; i++) {
            View valueAt = arrayMap3.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i = 0; i < arrayMap.size(); i++) {
            TransitionValues valueAt = arrayMap.valueAt(i);
            if (isValidTarget(valueAt.view)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            TransitionValues valueAt2 = arrayMap2.valueAt(i2);
            if (isValidTarget(valueAt2.view)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.mViewValues);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.mViewValues);
        for (int i = 0; i < this.mMatchOrder.length; i++) {
            switch (this.mMatchOrder[i]) {
                case 1:
                    matchInstances(arrayMap, arrayMap2);
                    break;
                case 2:
                    matchNames(arrayMap, arrayMap2, transitionValuesMaps.mNameValues, transitionValuesMaps2.mNameValues);
                    break;
                case 3:
                    matchIds(arrayMap, arrayMap2, transitionValuesMaps.mIdValues, transitionValuesMaps2.mIdValues);
                    break;
                case 4:
                    matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.mItemIdValues, transitionValuesMaps2.mItemIdValues);
                    break;
            }
        }
        addUnmatched(arrayMap, arrayMap2);
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        Animator createAnimator;
        View view;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        long j = Long.MAX_VALUE;
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TransitionValues transitionValues = arrayList.get(i);
            TransitionValues transitionValues2 = arrayList2.get(i);
            if (transitionValues != null && !transitionValues.mTargetedTransitions.contains(this)) {
                transitionValues = null;
            }
            if (transitionValues2 != null && !transitionValues2.mTargetedTransitions.contains(this)) {
                transitionValues2 = null;
            }
            if (transitionValues != null || transitionValues2 != null) {
                if ((transitionValues == null || transitionValues2 == null || isTransitionRequired(transitionValues, transitionValues2)) && (createAnimator = createAnimator(viewGroup, transitionValues, transitionValues2)) != null) {
                    TransitionValues transitionValues3 = null;
                    if (transitionValues2 != null) {
                        view = transitionValues2.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (view != null && transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues3 = new TransitionValues();
                            transitionValues3.view = view;
                            TransitionValues transitionValues4 = transitionValuesMaps2.mViewValues.get(view);
                            if (transitionValues4 != null) {
                                for (int i2 = 0; i2 < transitionProperties.length; i2++) {
                                    transitionValues3.values.put(transitionProperties[i2], transitionValues4.values.get(transitionProperties[i2]));
                                }
                            }
                            int size2 = runningAnimators.size();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    break;
                                }
                                AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i3));
                                if (animationInfo.mValues != null && animationInfo.mView == view && animationInfo.mName.equals(getName()) && animationInfo.mValues.equals(transitionValues3)) {
                                    createAnimator = null;
                                    break;
                                }
                                i3++;
                            }
                        }
                    } else {
                        view = transitionValues.view;
                    }
                    if (createAnimator != null) {
                        if (this.mPropagation != null) {
                            long startDelay = this.mPropagation.getStartDelay(viewGroup, this, transitionValues, transitionValues2);
                            sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                            j = Math.min(startDelay, j);
                        }
                        runningAnimators.put(createAnimator, new AnimationInfo(view, getName(), this, ViewUtils.getWindowId(viewGroup), transitionValues3));
                        this.mAnimators.add(createAnimator);
                    }
                }
            }
        }
        if (j != 0) {
            for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                Animator animator = this.mAnimators.get(sparseIntArray.keyAt(i4));
                animator.setStartDelay((((long) sparseIntArray.valueAt(i4)) - j) + animator.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        int id = view.getId();
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return false;
        }
        if (this.mTargetTypeExcludes != null) {
            int size = this.mTargetTypeExcludes.size();
            for (int i = 0; i < size; i++) {
                if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (!(this.mTargetNameExcludes == null || ViewCompat.getTransitionName(view) == null || !this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(view)))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && ((this.mTargetTypes == null || this.mTargetTypes.isEmpty()) && (this.mTargetNames == null || this.mTargetNames.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        if (this.mTargetNames != null && this.mTargetNames.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.mTargetTypes == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
            if (this.mTargetTypes.get(i2).isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.Transition.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.mCurrentAnimators.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.mCurrentAnimators.remove(animator2);
                }
            });
            animate(animator);
        }
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class> getTargetTypes() {
        return this.mTargetTypes;
    }

    /* access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && ((this.mTargetNames == null || this.mTargetNames.isEmpty()) && (this.mTargetTypes == null || this.mTargetTypes.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = findViewById;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                TransitionValues transitionValues2 = new TransitionValues();
                transitionValues2.view = view;
                if (z) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.mTargetedTransitions.add(this);
                capturePropagationValues(transitionValues2);
                if (z) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (!(z || this.mNameOverrides == null)) {
            int size = this.mNameOverrides.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(this.mStartValues.mNameValues.remove(this.mNameOverrides.keyAt(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) arrayList.get(i4);
                if (view2 != null) {
                    this.mStartValues.mNameValues.put(this.mNameOverrides.valueAt(i4), view2);
                }
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.mViewValues.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.mIdValues.indexOfKey(id) >= 0) {
                transitionValuesMaps.mIdValues.put(id, null);
            } else {
                transitionValuesMaps.mIdValues.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (transitionValuesMaps.mNameValues.containsKey(transitionName)) {
                transitionValuesMaps.mNameValues.put(transitionName, null);
            } else {
                transitionValuesMaps.mNameValues.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.mItemIdValues.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = transitionValuesMaps.mItemIdValues.get(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.setHasTransientState(view2, false);
                        transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.setHasTransientState(view, true);
                transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
            return;
        }
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        this.mEndValues.mItemIdValues.clear();
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.mTargetExcludes == null || !this.mTargetExcludes.contains(view)) {
                if (this.mTargetTypeExcludes != null) {
                    int size = this.mTargetTypeExcludes.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = view;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, view, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, view, transitionValues);
                    }
                }
                if (!(view instanceof ViewGroup)) {
                    return;
                }
                if (this.mTargetIdChildExcludes != null && this.mTargetIdChildExcludes.contains(Integer.valueOf(id))) {
                    return;
                }
                if (this.mTargetChildExcludes == null || !this.mTargetChildExcludes.contains(view)) {
                    if (this.mTargetTypeChildExcludes != null) {
                        int size2 = this.mTargetTypeChildExcludes.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            if (this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        captureHierarchy(viewGroup.getChildAt(i3), z);
                    }
                }
            }
        }
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).mViewValues.get(view);
    }

    /* access modifiers changed from: package-private */
    public TransitionValues getMatchedTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getMatchedTransitionValues(view, z);
        }
        ArrayList<TransitionValues> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TransitionValues transitionValues = arrayList.get(i2);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i < 0) {
            return null;
        }
        return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
    }

    public void pause(View view) {
        if (!this.mEnded) {
            ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            WindowIdImpl windowId = ViewUtils.getWindowId(view);
            for (int i = size - 1; i >= 0; i--) {
                AnimationInfo valueAt = runningAnimators.valueAt(i);
                if (valueAt.mView != null && windowId.equals(valueAt.mWindowId)) {
                    AnimatorUtils.pause(runningAnimators.keyAt(i));
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((TransitionListener) arrayList.get(i2)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdImpl windowId = ViewUtils.getWindowId(view);
                for (int i = size - 1; i >= 0; i--) {
                    AnimationInfo valueAt = runningAnimators.valueAt(i);
                    if (valueAt.mView != null && windowId.equals(valueAt.mWindowId)) {
                        AnimatorUtils.resume(runningAnimators.keyAt(i));
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((TransitionListener) arrayList.get(i2)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdImpl windowId = ViewUtils.getWindowId(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator keyAt = runningAnimators.keyAt(i);
            if (!(keyAt == null || (animationInfo = runningAnimators.get(keyAt)) == null || animationInfo.mView == null || !windowId.equals(animationInfo.mWindowId))) {
                TransitionValues transitionValues = animationInfo.mValues;
                View view = animationInfo.mView;
                TransitionValues transitionValues2 = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (!(transitionValues2 == null && matchedTransitionValues == null) && animationInfo.mTransition.isTransitionRequired(transitionValues, matchedTransitionValues)) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        runningAnimators.remove(keyAt);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (isValueChanged(transitionValues, transitionValues2, str)) {
                    return true;
                }
            }
            return false;
        }
        for (String str2 : transitionValues.values.keySet()) {
            if (isValueChanged(transitionValues, transitionValues2, str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        return obj == null || obj2 == null || !obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    /* access modifiers changed from: protected */
    public void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionEnd(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.mItemIdValues.size(); i2++) {
                View valueAt = this.mStartValues.mItemIdValues.valueAt(i2);
                if (valueAt != null) {
                    ViewCompat.setHasTransientState(valueAt, false);
                }
            }
            for (int i3 = 0; i3 < this.mEndValues.mItemIdValues.size(); i3++) {
                View valueAt2 = this.mEndValues.mItemIdValues.valueAt(i3);
                if (valueAt2 != null) {
                    ViewCompat.setHasTransientState(valueAt2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public Transition addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public Transition removeListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            return this;
        }
        this.mListeners.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] propagationProperties;
        if (this.mPropagation != null && !transitionValues.values.isEmpty() && (propagationProperties = this.mPropagation.getPropagationProperties()) != null) {
            boolean z = true;
            int i = 0;
            while (true) {
                if (i >= propagationProperties.length) {
                    break;
                } else if (!transitionValues.values.containsKey(propagationProperties[i])) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.mPropagation.captureValues(transitionValues);
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return toString("");
    }

    @Override // java.lang.Object
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargetIds.get(i);
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i2);
            }
        }
        return str3 + ")";
    }

    /* access modifiers changed from: package-private */
    public static class AnimationInfo {
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowIdImpl mWindowId;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.mView = view;
            this.mName = str;
            this.mValues = transitionValues;
            this.mWindowId = windowIdImpl;
            this.mTransition = transition;
        }
    }
}
