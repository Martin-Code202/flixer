package o;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.player.subtitles.text.ColorMapping;
import com.netflix.mediaclient.service.player.subtitles.text.HorizontalAlignment;
import com.netflix.mediaclient.service.player.subtitles.text.VerticalAlignment;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o.C1984mo;
/* renamed from: o.xy  reason: case insensitive filesystem */
public class C2331xy extends AbstractC2329xw {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private RelativeLayout f12307;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private C2328xv f12308;

    /* renamed from: ʾ  reason: contains not printable characters */
    private Point f12309;

    /* renamed from: ʿ  reason: contains not printable characters */
    private AtomicBoolean f12310 = new AtomicBoolean(false);

    /* renamed from: ˈ  reason: contains not printable characters */
    private float f12311;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private Map<String, List<TextView>> f12312 = new HashMap();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    final ViewTreeObserver.OnPreDrawListener f12313 = new ViewTreeObserver.OnPreDrawListener() { // from class: o.xy.3
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            C1283.m16854("nf_subtitles_render", "onPreDraw on display area");
            return false;
        }
    };

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private LinearLayout f12314;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Map<String, LinearLayout> f12315 = new HashMap();

    @Override // o.AbstractC2329xw, o.AbstractC1978mi
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ void mo9032(oM oMVar) {
        super.mo9032(oMVar);
    }

    @Override // o.AbstractC2329xw
    /* renamed from: ॱ */
    public /* bridge */ /* synthetic */ NetflixActivity mo13028() {
        return super.mo13028();
    }

    public C2331xy(View view) {
        super(view);
        if (mo13028().isTablet()) {
            this.f12311 = view.getResources().getDimension(R.dimen.player_tablet_subtitle_size);
        } else {
            this.f12311 = view.getResources().getDimension(R.dimen.player_phone_subtitle_size);
        }
        this.f12290 = view.getResources().getColor(17170445);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m13046() {
        C1283.m16846("nf_subtitles_render", "Find root display area");
        if (m13022()) {
            C1283.m16846("nf_subtitles_render", "Create safe display area");
            NetflixActivity r3 = mo13028();
            this.f12307 = new RelativeLayout(r3);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.f12283.addView(this.f12307, layoutParams);
            C1283.m16846("nf_subtitles_render", "Create safe display area done.");
            C1283.m16846("nf_subtitles_render", "Create default region");
            this.f12314 = new LinearLayout(r3);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            this.f12314.setOrientation(1);
            layoutParams2.addRule(12);
            this.f12307.addView(this.f12314, layoutParams2);
            this.f12314.setVisibility(4);
            this.f12312.put("DEFAULT", new ArrayList());
            this.f12310.set(true);
        }
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˎ */
    public void mo9031() {
        C1283.m16854("nf_subtitles_render", "Remove all subtitles.");
        m13073(true);
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˏ */
    public synchronized void mo9035(C1987mr mrVar, Point point) {
        C1283.m16854("nf_subtitles_render", "EnhancedSubtitleManager:: update subtitle data");
        if (mrVar == null) {
            C1283.m16850("nf_subtitles_render", "Subtitle data is null. This should never happen!");
        } else if (mrVar.m9065() == null) {
            C1283.m16850("nf_subtitles_render", "Subtitle parser is null. This should never happen!");
        } else if (mrVar.m9065() instanceof mT) {
            this.f12282 = mrVar.m9065();
            if (!this.f12310.get()) {
                C1283.m16854("nf_subtitles_render", "Try to set defaults. They were not initialized before");
                m13046();
                if (this.f12310.get()) {
                    C1283.m16854("nf_subtitles_render", "Initialization was ok, proceed with subtitles.");
                } else {
                    C1283.m16865("nf_subtitles_render", "Initialization was NOT ok, exit.");
                    return;
                }
            }
            m13073(false);
            m13060(point);
            int hashCode = mrVar.m9065().hashCode();
            if (this.f12284 == null || this.f12284.intValue() != hashCode) {
                this.f12284 = Integer.valueOf(mrVar.m9065().hashCode());
                m13076();
                m13058(((mT) mrVar.m9065()).mo8734());
            }
            m13054(mrVar.m9066());
            m13024(mrVar.m9064(), true);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13060(Point point) {
        C1283.m16851("nf_subtitles_render", "AspectRatio dimensions: %s", point);
        if (point == null) {
            C1283.m16865("nf_subtitles_render", "AspectRatio is null!");
        } else if (this.f12309 == null || !this.f12309.equals(point)) {
            C1283.m16854("nf_subtitles_render", "AspectRatio is changed, update");
            this.f12309 = point;
            this.f12308 = C2328xv.m13014(point.x, point.y, this.f12287);
        } else {
            C1283.m16854("nf_subtitles_render", "AspectRatio not changed");
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private synchronized void m13076() {
        if (this.f12315.size() < 1) {
            C1283.m16854("nf_subtitles_render", "removeRegions:: no region found to remove.");
            return;
        }
        for (String str : this.f12315.keySet()) {
            LinearLayout linearLayout = this.f12315.get(str);
            if (linearLayout != null) {
                this.f12283.removeView(linearLayout);
            } else {
                return;
            }
        }
        this.f12315.clear();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m13066() {
        C1283.m16854("nf_subtitles_render", "Sets margin for safe display area");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12307.getLayoutParams();
        int width = (int) (((float) (this.f12283.getWidth() / 100)) * 5.0f);
        int height = (int) (((float) (this.f12283.getHeight() / 100)) * 5.0f);
        marginLayoutParams.setMargins(width, height, width, height);
        this.f12307.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13058(mQ[] mQVarArr) {
        m13066();
        this.f12312.put("DEFAULT", new ArrayList());
        if (mQVarArr == null || mQVarArr.length < 1) {
            C1283.m16850("nf_subtitles_render", "createRegions:: no region found to be added!");
            return;
        }
        for (int i = 0; i < mQVarArr.length; i++) {
            mQ mQVar = mQVarArr[i];
            if (mQVar == null) {
                C1283.m16850("nf_subtitles_render", "createRegions:: region is null on position " + i);
            } else if (mQVar.m8888() == null) {
                C1283.m16850("nf_subtitles_render", "createRegions:: region ID is null on position " + i + ". Ignore region " + mQVar);
            } else {
                m13051(mQVar);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13051(mQ mQVar) {
        C1283.m16854("nf_subtitles_render", "Add region ");
        LinearLayout linearLayout = new LinearLayout(mo13028());
        linearLayout.setVisibility(4);
        linearLayout.setTag(mQVar.m8888());
        RelativeLayout.LayoutParams r4 = m13047(mQVar);
        linearLayout.setOrientation(1);
        this.f12283.addView(linearLayout, r4);
        this.f12315.put(mQVar.m8888(), linearLayout);
        HorizontalAlignment horizontalAlignment = null;
        if (!(mQVar == null || mQVar.m8891() == null)) {
            horizontalAlignment = mQVar.m8891();
        }
        VerticalAlignment verticalAlignment = null;
        if (!(mQVar == null || mQVar.m8892() == null)) {
            verticalAlignment = mQVar.m8892();
        }
        if (horizontalAlignment != null && verticalAlignment != null) {
            linearLayout.setGravity(C1984mo.m9044(horizontalAlignment, verticalAlignment));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private RelativeLayout.LayoutParams m13047(mQ mQVar) {
        RelativeLayout.LayoutParams layoutParams;
        C1283.m16854("nf_subtitles_render", "Set initial region position");
        lZ r2 = mQVar.m8890();
        lZ r3 = mQVar.m8889();
        Rect r5 = C1984mo.m9050(this.f12283, r2, r3);
        if (r2 == null || !r2.m8742()) {
            C1283.m16854("nf_subtitles_render", "Region w/h not know, wrap around content");
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        } else {
            int width = r5.width();
            int height = r5.height();
            if (height < this.f12283.getHeight() / 4) {
                C1283.m16854("nf_subtitles_render", "Use wrap content for height");
                layoutParams = new RelativeLayout.LayoutParams(width, -2);
            } else {
                C1283.m16854("nf_subtitles_render", "Use region height");
                layoutParams = new RelativeLayout.LayoutParams(width, height);
            }
        }
        if (r3 != null && r3.m8742() && r2 != null && r2.m8742()) {
            m13068(layoutParams, r5);
        }
        return layoutParams;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13068(ViewGroup.MarginLayoutParams marginLayoutParams, Rect rect) {
        int i = rect.left;
        int i2 = rect.top;
        int width = this.f12283.getWidth() - rect.right;
        int height = this.f12283.getHeight() - rect.bottom;
        if (height < 0) {
            C1283.m16865("nf_subtitles_render", "Bottom margin is less than 0, correct");
            i2 += height;
            height = 0;
        }
        if (i2 < 0) {
            C1283.m16865("nf_subtitles_render", "Top margin is less than 0, correct");
            height += i2;
            i2 = 0;
            if (height < 0) {
                C1283.m16865("nf_subtitles_render", "Bottom margin is less than 0, after fixing top, set to 0");
                height = 0;
            }
        }
        marginLayoutParams.setMargins(i, i2, width, height);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13054(List<AbstractC1976mg> list) {
        ViewTreeObserver viewTreeObserver = this.f12283.getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(this.f12313);
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractC1976mg> it = list.iterator();
        while (it.hasNext()) {
            m13071((mR) it.next(), arrayList);
        }
        m13023(arrayList);
        m13030(arrayList);
        viewTreeObserver.removeOnPreDrawListener(this.f12313);
        this.f12283.forceLayout();
        this.f12283.requestLayout();
        this.f12283.invalidate();
        C1283.m16854("nf_subtitles_render", "Add displayed block to pending queue to be removed at end time");
        m13024(list, false);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2329xw
    /* renamed from: ॱ */
    public Runnable mo13029(AbstractC1976mg mgVar, final boolean z) {
        final mR mRVar = (mR) mgVar;
        AnonymousClass1 r2 = new Runnable() { // from class: o.xy.1
            @Override // java.lang.Runnable
            public void run() {
                C2331xy.this.f12289.remove(this);
                synchronized (C2331xy.this) {
                    if (z) {
                        C1283.m16865("nf_subtitles_render", "===> showSubtitleBlock was called from pending queue!!");
                        C2331xy.this.m13071(mRVar, (List<ViewUtils.C0049>) null);
                    } else {
                        C2331xy.this.m13055(mRVar);
                    }
                }
            }
        };
        this.f12289.add(r2);
        return r2;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˎ */
    public synchronized void mo9033(final boolean z) {
        this.f12286 = z;
        this.f12285.post(new Runnable() { // from class: o.xy.2
            @Override // java.lang.Runnable
            public void run() {
                C2331xy.this.m13065(z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13065(boolean z) {
        for (LinearLayout linearLayout : this.f12315.values()) {
            linearLayout.setVisibility(z ? 0 : 4);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private synchronized void m13067() {
        if (this.f12289 != null && this.f12289.size() >= 1) {
            for (Runnable runnable : this.f12289) {
                this.f12285.removeCallbacks(runnable);
            }
            this.f12289.clear();
        }
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public synchronized void mo9027() {
        C1283.m16846("nf_subtitles_render", "Remove current and pending actions");
        m13073(true);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13073(boolean z) {
        m13067();
        mo13026(z);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2329xw
    /* renamed from: ˋ */
    public synchronized void mo13026(boolean z) {
        if (this.f12314 != null) {
            this.f12314.setBackgroundColor(this.f12290);
            this.f12314.setVisibility(4);
            if (z) {
                this.f12314.removeAllViews();
            } else {
                this.f12314.removeAllViewsInLayout();
            }
        }
        for (String str : this.f12315.keySet()) {
            LinearLayout linearLayout = this.f12315.get(str);
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(this.f12290);
                linearLayout.setVisibility(4);
                if (z) {
                    linearLayout.removeAllViews();
                } else {
                    linearLayout.removeAllViewsInLayout();
                }
            }
        }
        this.f12312.clear();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13055(mR mRVar) {
        if (mRVar == null) {
            C1283.m16850("nf_subtitles_render", "Subtitle block can not be null!");
            return;
        }
        mQ r3 = mRVar.m8901();
        if (r3 == null) {
            C1283.m16854("nf_subtitles_render", "Remove block from default region for id " + mRVar.m8702());
            m13064(mRVar.m8702(), this.f12312.get("DEFAULT"), "DEFAULT");
            return;
        }
        String r4 = r3.m8888();
        if (r4 == null) {
            C1283.m16850("nf_subtitles_render", "Region id can NOT be null!");
            return;
        }
        C1283.m16854("nf_subtitles_render", "Remove block from region " + r4 + " for block id " + mRVar.m8702());
        m13064(mRVar.m8702(), this.f12312.get(r4), r4);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13064(String str, List<TextView> list, String str2) {
        if (str == null) {
            C1283.m16865("nf_subtitles_render", "Block id can not be null!");
        } else if (list == null || list.size() < 1) {
            C1283.m16854("nf_subtitles_render", "Views are null or empty, nothing to remove!");
        } else {
            if ("DEFAULT".equals(str2)) {
                m13062(this.f12315.get(str2), m13048(str2, list));
            }
            for (TextView textView : list) {
                if (textView == null) {
                    C1283.m16850("nf_subtitles_render", "Text view can not be null!");
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13062(LinearLayout linearLayout, List<TextView> list) {
        if (linearLayout == null) {
            C1283.m16850("nf_subtitles_render", "Region is null, can not remove views!");
        } else if (list == null) {
            C1283.m16850("nf_subtitles_render", "Blocks are null, can not remove views!");
        } else {
            for (TextView textView : list) {
                C1283.m16854("nf_subtitles_render", "Removing block from region " + linearLayout.getTag());
                linearLayout.removeView(textView);
                linearLayout.setVisibility(4);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private List<TextView> m13048(String str, List<TextView> list) {
        ArrayList arrayList = new ArrayList();
        for (TextView textView : list) {
            if (textView == null) {
                C1283.m16850("nf_subtitles_render", "Text view can not be null!");
            } else if (str.equals((String) textView.getTag())) {
                C1283.m16854("nf_subtitles_render", "Text view found for removal");
                arrayList.add(textView);
            }
        }
        if (arrayList.size() < 1) {
            C1283.m16865("nf_subtitles_render", "Text view NOT found for removal for block " + str);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13071(mR mRVar, List<ViewUtils.C0049> list) {
        if (mRVar == null || mRVar.m8904().size() < 1) {
            C1283.m16850("nf_subtitles_render", "Block is empty! Can not show!");
            return;
        }
        LinearLayout r4 = m13059(mRVar);
        r4.setVisibility(4);
        if (list != null) {
            list.add(new ViewUtils.C0049(r4));
        }
        boolean z = !C1346Bs.m4079(r4, mRVar);
        C1984mo.m9052(r4, mRVar);
        LinearLayout linearLayout = r4;
        if (z) {
            C1283.m16854("nf_subtitles_render", "Using extent/origin from original region, add wrapper region that will be wrapped around block and that will be used for background color for region");
            linearLayout = new LinearLayout(mo13028());
            C1984mo.m9052(linearLayout, mRVar);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setPadding(this.f12296, this.f12294, this.f12296, this.f12294);
            linearLayout.setOrientation(1);
            r4.addView(linearLayout);
        } else {
            C1283.m16854("nf_subtitles_render", "Using extent/origin from block, region will be wrapped around block and background color will be applied to it.");
        }
        Pair<Integer, Integer> r7 = m13052(mRVar, linearLayout);
        m13070(r4, mRVar, ((Integer) r7.first).intValue(), ((Integer) r7.second).intValue());
        m13063(linearLayout, mRVar);
        mRVar.m8905();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private Pair<Integer, Integer> m13052(mR mRVar, LinearLayout linearLayout) {
        int i = 0;
        int i2 = 0;
        LinearLayout linearLayout2 = null;
        for (int i3 = 0; i3 < mRVar.m8904().size(); i3++) {
            mM mMVar = mRVar.m8904().get(i3);
            TextView r8 = m13050(mMVar);
            if (mMVar.m8849() > 0) {
                C1283.m16854("nf_subtitles_render", "This node belongs to its own line");
                if (linearLayout2 != null) {
                    linearLayout2.measure(0, 0);
                    i2 += linearLayout2.getMeasuredHeight();
                    if (i < linearLayout2.getMeasuredWidth()) {
                        i = linearLayout2.getMeasuredWidth();
                    }
                }
                linearLayout2 = null;
            }
            if (C1984mo.m9043(mRVar.m8904(), i3)) {
                C1283.m16854("nf_subtitles_render", "Next node is in same line, add current node to horizontal LL.");
                if (linearLayout2 == null) {
                    linearLayout2 = new LinearLayout(mo13028());
                    linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    linearLayout2.setOrientation(0);
                    linearLayout.addView(linearLayout2);
                }
            } else {
                C1283.m16854("nf_subtitles_render", "Next node is not in same line");
            }
            if (linearLayout2 != null) {
                C1283.m16854("nf_subtitles_render", "Adding node to horizontal wrapper");
                linearLayout2.addView(r8);
            } else {
                C1283.m16854("nf_subtitles_render", "Adding node directly to a window region");
                linearLayout.addView(r8);
                i2 += r8.getMeasuredHeight();
                if (i < r8.getMeasuredWidth()) {
                    i = r8.getMeasuredWidth();
                }
            }
        }
        if (linearLayout2 != null) {
            C1283.m16854("nf_subtitles_render", "Last horizontal wrapper needs to be measured");
            linearLayout2.measure(0, 0);
            int measuredHeight = i2 + linearLayout2.getMeasuredHeight();
            if (i < linearLayout2.getMeasuredWidth()) {
                linearLayout2.getMeasuredWidth();
            }
        } else {
            C1283.m16854("nf_subtitles_render", "No unmeasured last horizontal wrapper");
        }
        linearLayout.measure(0, 0);
        return new Pair<>(Integer.valueOf(linearLayout.getMeasuredWidth()), Integer.valueOf(linearLayout.getMeasuredHeight()));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13070(LinearLayout linearLayout, mR mRVar, int i, int i2) {
        C1283.m16854("nf_subtitles_render", "updatePositionIfNeeded start");
        mQ r6 = mRVar.m8901();
        if (r6 == null) {
            C1283.m16854("nf_subtitles_render", "updatePositionIfNeeded no region, no update");
            return;
        }
        C1283.m16854("nf_subtitles_render", "updatePositionIfNeeded start for real");
        if (mRVar.m8904().size() < 1) {
            C1283.m16865("nf_subtitles_render", "updatePositionIfNeeded no text blocks!");
            return;
        }
        mM mMVar = mRVar.m8904().get(0);
        if (mMVar == null || mMVar.m8847() == null) {
            C1283.m16865("nf_subtitles_render", "updatePositionIfNeeded p missing");
            return;
        }
        lZ r8 = mRVar.m8900().m8877();
        lZ r9 = mRVar.m8900().m8878();
        if (!lZ.m8741(r8) || !lZ.m8741(r9)) {
            C1283.m16865("nf_subtitles_render", "updatePositionIfNeeded using region defaults for extent and origin");
            m13069(linearLayout, r6);
            if (m13074(linearLayout, r6, i, i2)) {
                m13061(linearLayout, i, i2, r6.m8890(), r6.m8889());
                return;
            }
            return;
        }
        C1283.m16865("nf_subtitles_render", "updatePositionIfNeeded using block extent and origin overrides");
        m13061(linearLayout, i, i2, r8, r9);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13069(LinearLayout linearLayout, mQ mQVar) {
        C1283.m16854("nf_subtitles_render", "Set region position");
        lZ r2 = mQVar.m8890();
        lZ r3 = mQVar.m8889();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
        Rect r5 = C1984mo.m9050(this.f12283, r2, r3);
        if (r2 == null || !r2.m8742()) {
            C1283.m16854("nf_subtitles_render", "Region w/h not know, skip setting w/h");
        } else {
            int width = r5.width();
            int height = r5.height();
            if (height < this.f12283.getHeight() / 4) {
                C1283.m16854("nf_subtitles_render", "Use wrap content for height");
                marginLayoutParams.width = width;
                marginLayoutParams.height = -2;
            } else {
                C1283.m16854("nf_subtitles_render", "Use region height");
                marginLayoutParams.width = width;
                marginLayoutParams.height = height;
            }
        }
        if (r3 != null && r3.m8742() && r2 != null && r2.m8742()) {
            m13068(marginLayoutParams, r5);
        }
        linearLayout.setLayoutParams(marginLayoutParams);
        linearLayout.requestLayout();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m13074(LinearLayout linearLayout, mQ mQVar, int i, int i2) {
        if (!lZ.m8741(mQVar.m8890()) || !lZ.m8741(mQVar.m8889())) {
            return false;
        }
        Rect r3 = C1984mo.m9050(this.f12283, mQVar.m8890(), mQVar.m8889());
        if (r3.height() < i2 && r3.width() < i) {
            C1283.m16854("nf_subtitles_render", "Text does not fit into region by height AND width. Update region position taking into account measured data.");
            return true;
        } else if (r3.height() < i2) {
            C1283.m16854("nf_subtitles_render", "Text does not fit into region by height. Update region position taking into account measured data.");
            return true;
        } else if (r3.width() < i) {
            C1283.m16854("nf_subtitles_render", "Text does not fit into region by width. Update region position taking into account measured data.");
            return true;
        } else {
            C1283.m16854("nf_subtitles_render", "Text fits into region.");
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13061(LinearLayout linearLayout, int i, int i2, lZ lZVar, lZ lZVar2) {
        int i3;
        int i4;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
        Rect r5 = C1984mo.m9050(this.f12283, lZVar, lZVar2);
        C1984mo.If r7 = m13053(C1984mo.m9059(this.f12283, lZVar, lZVar2), i, i2, r5);
        marginLayoutParams.setMargins(r7.f8918, r7.f8916, 0, 0);
        if (r5.height() >= i2) {
            C1283.m16854("nf_subtitles_render", "Original region is high enough, keep original measure");
            marginLayoutParams.height = r5.height();
            i3 = r7.f8916 + r5.height();
        } else {
            C1283.m16854("nf_subtitles_render", "Original region is NOT high enough, recalculate");
            marginLayoutParams.height = (this.f12294 * 2) + i2;
            i3 = r7.f8916 + marginLayoutParams.height;
        }
        if (r5.width() >= i) {
            C1283.m16854("nf_subtitles_render", "Original region is wide enough, keep original measure");
            marginLayoutParams.width = r5.width();
            i4 = r7.f8918 + r5.width();
        } else {
            C1283.m16854("nf_subtitles_render", "Original region is NOT wide enough, recalculate");
            marginLayoutParams.width = (this.f12296 * 2) + i;
            i4 = r7.f8918 + marginLayoutParams.width;
        }
        linearLayout.setTag(new Rect(r7.f8918, r7.f8916, i4, i3));
        linearLayout.setPadding(this.f12296, this.f12294, this.f12296, this.f12294);
        linearLayout.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1984mo.If m13053(C1984mo.If r9, int i, int i2, Rect rect) {
        int i3;
        int i4;
        C1984mo.If r3 = new C1984mo.If();
        int i5 = r9.f8916;
        int i6 = r9.f8918;
        if (rect.height() >= i2) {
            C1283.m16854("nf_subtitles_render", "Original region is high enough, keep original measure");
            i3 = r9.f8917;
        } else {
            C1283.m16854("nf_subtitles_render", "Original region is NOT high enough, recalculate");
            i3 = r9.f8916 + i2 + (this.f12294 * 2);
        }
        if (rect.width() >= i) {
            C1283.m16854("nf_subtitles_render", "Original region is wide enough, keep original measure");
            i4 = r9.f8915;
        } else {
            C1283.m16854("nf_subtitles_render", "Original region is NOT wide enough, recalculate");
            i4 = r9.f8918 + i + (this.f12296 * 2);
        }
        C1283.m16854("nf_subtitles_render", "Check if region bottom is lower than display area");
        if (i3 > this.f12283.getHeight()) {
            i5 -= i3 - this.f12283.getHeight();
        } else {
            C1283.m16854("nf_subtitles_render", "No need to change top");
        }
        C1283.m16854("nf_subtitles_render", "Check if region top is higher than display area");
        if (i5 < 0) {
            i5 = 0;
            C1283.m16854("nf_subtitles_render", "Top is 0");
        } else {
            C1283.m16854("nf_subtitles_render", "No need to change top");
        }
        C1283.m16854("nf_subtitles_render", "Check if region right is pass right of display area");
        if (i4 > this.f12283.getWidth()) {
            i6 -= i4 - this.f12283.getWidth();
        } else {
            C1283.m16854("nf_subtitles_render", "No need to change left");
        }
        C1283.m16854("nf_subtitles_render", "Check if region left is pass left of display area");
        if (i6 < 0) {
            i6 = 0;
            C1283.m16854("nf_subtitles_render", "Left is 0");
        } else {
            C1283.m16854("nf_subtitles_render", "No need to change left");
        }
        r3.f8918 = i6;
        r3.f8916 = i5;
        return r3;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private LinearLayout m13059(mR mRVar) {
        C1283.m16854("nf_subtitles_render", "findRegionLayout start");
        mQ r2 = mRVar.m8901();
        if (r2 == null || r2.m8888() == null) {
            C1283.m16854("nf_subtitles_render", "Block does not have region, put it in default region");
            return this.f12314;
        }
        LinearLayout linearLayout = this.f12315.get(r2.m8888());
        if (linearLayout == null) {
            return this.f12314;
        }
        C1283.m16854("nf_subtitles_render", "LL for region found!");
        return linearLayout;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13063(LinearLayout linearLayout, mR mRVar) {
        mP r4;
        mP r2 = ((mT) this.f12282).mo8738();
        Integer num = null;
        if (r2 == null) {
            C1283.m16854("nf_subtitles_render", "No user overides for window color");
            if (!(mRVar.m8904().size() <= 0 || (r4 = mRVar.m8904().get(0).m8847()) == null || r4.m8870() == null)) {
                num = ColorMapping.m1161(r4.m8873(), r4.m8870());
            }
        } else {
            C1283.m16854("nf_subtitles_render", "User overides found for window color");
            num = ColorMapping.m1161(r2.m8873(), r2.m8870());
        }
        if (num == null) {
            C1283.m16854("nf_subtitles_render", "Sets region background color to transparent");
            linearLayout.setBackgroundColor(mo13028().getResources().getColor(17170445));
            return;
        }
        linearLayout.setBackgroundColor(num.intValue());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private TextView m13050(mM mMVar) {
        C0544 r5;
        String r3 = C1984mo.m9046(mMVar.m8848(), mMVar.m8849());
        mP mPVar = new mP();
        mPVar.m8880(((mT) this.f12282).mo8738());
        mPVar.m8880(mMVar.m8847());
        mPVar.m8880(((mT) this.f12282).mo8735());
        NetflixActivity r6 = mo13028();
        if (C1346Bs.m4085(mPVar)) {
            r5 = new C0832(r6);
        } else {
            r5 = new C0544(r6);
        }
        r5.setEllipsize(null);
        r5.setSingleLine(true);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (Boolean.TRUE.equals(mMVar.m8847().m8868())) {
            C1283.m16854("nf_subtitles_render", "Sets underline");
            r5.setUnderline(true);
        }
        C1346Bs.m4084(r5, mPVar, this.f12311);
        r5.setText(r3);
        r5.setGravity(119);
        r5.measure(0, 0);
        return r5;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˏ */
    public void mo9034() {
        m13067();
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˋ */
    public ISubtitleDef.SubtitleProfile mo9030() {
        return ISubtitleDef.SubtitleProfile.ENHANCED;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public boolean mo9029(ISubtitleDef.SubtitleProfile subtitleProfile) {
        if (subtitleProfile == null || subtitleProfile == ISubtitleDef.SubtitleProfile.IMAGE || subtitleProfile == ISubtitleDef.SubtitleProfile.IMAGE_ENC) {
            return false;
        }
        return true;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int m13049() {
        C2328xv xvVar = this.f12308;
        if (xvVar == null) {
            return 0;
        }
        return xvVar.m13019();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int m13075() {
        C2328xv xvVar = this.f12308;
        if (xvVar == null) {
            return 0;
        }
        return xvVar.m13017();
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public synchronized void mo9028(boolean z) {
        if (this.f12283 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12283.getLayoutParams();
            if (z) {
                marginLayoutParams.setMargins(m13075(), m13021(), m13075(), m13031());
            } else {
                C1283.m16854("nf_subtitles_render", "Reset all margins to display area on not visible");
                marginLayoutParams.setMargins(m13075(), m13049(), m13075(), m13049());
            }
            mo13026(true);
            this.f12283.setLayoutParams(marginLayoutParams);
            this.f12283.requestLayout();
        } else {
            C1283.m16865("nf_subtitles_render", "Display area is null, unable to set margins!");
        }
    }
}
