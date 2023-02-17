package com.netflix.mediaclient.ui.player.pivots;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import o.AbstractC0409;
import o.AbstractC0500;
import o.AbstractC2264wf;
import o.C0403;
import o.C0522;
import o.C1283;
import o.C1349Bv;
import o.C1456Fq;
import o.C1457Fr;
import o.C2279wu;
import o.C2282wx;
import o.C2325xt;
import o.C2332xz;
import o.CH;
import o.pF;
import o.qN;
public final class PivotsUIView extends AbstractC0500<C2325xt> {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private static int f3679 = -1;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final Cif f3680 = new Cif(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final RecyclerView f3681;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Button f3682;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final View f3683;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C2282wx f3684 = new C2282wx();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final AbstractC2264wf f3685;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C2282wx f3686 = new C2282wx();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private PivotsListAssetType f3687;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f3688;

    /* renamed from: ˏ  reason: contains not printable characters */
    public RecyclerView.Adapter<RecyclerView.ViewHolder> f3689;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final PublishSubject<IPlayerFragment.PublisherEvents> f3690;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f3691;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final long f3692;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final List<CH> f3693;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final IPlayerFragment f3694;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private View f3695;

    public enum PivotsListAssetType {
        HORIZONTAL_BOX_ART,
        BIF
    }

    public enum PivotsListVisibility {
        SHOW,
        HIDE,
        SHOW_PARTIALLY
    }

    public PivotsUIView(ViewGroup viewGroup, PublishSubject<IPlayerFragment.PublisherEvents> publishSubject, AbstractC2264wf wfVar, IPlayerFragment iPlayerFragment) {
        C1457Fr.m5025(viewGroup, "container");
        C1457Fr.m5025(publishSubject, "playerEventsObservable");
        C1457Fr.m5025(wfVar, "bottomPanel");
        C1457Fr.m5025(iPlayerFragment, "player");
        this.f3690 = publishSubject;
        this.f3685 = wfVar;
        this.f3694 = iPlayerFragment;
        Context context = viewGroup.getContext();
        C1457Fr.m5016((Object) context, "container.context");
        this.f3688 = m2640(context);
        this.f3693 = new ArrayList();
        this.f3687 = PivotsListAssetType.HORIZONTAL_BOX_ART;
        this.f3692 = 200;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_pivots, viewGroup, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(cont…_pivots, container, true)");
        this.f3683 = inflate;
        View findViewById = this.f3683.findViewById(R.id.pivots_list);
        C1457Fr.m5016((Object) findViewById, "uiRoot.findViewById(R.id.pivots_list)");
        this.f3681 = (RecyclerView) findViewById;
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_pivots_up_next_button, this.f3685.mo12101(), true);
        C1457Fr.m5016((Object) inflate2, "LayoutInflater.from(cont…tomPanel.container, true)");
        this.f3695 = inflate2;
        View findViewById2 = this.f3695.findViewById(R.id.player_up_next_button);
        C1457Fr.m5016((Object) findViewById2, "uiButton.findViewById(R.id.player_up_next_button)");
        this.f3682 = (Button) findViewById2;
        Context context2 = viewGroup.getContext();
        C1457Fr.m5016((Object) context2, "container.context");
        m2621(context2, this.f3681);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final AbstractC2264wf m2635() {
        return this.f3685;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final RecyclerView m2642() {
        return this.f3681;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final List<CH> m2638() {
        return this.f3693;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final PivotsListAssetType m2639() {
        return this.f3687;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final boolean m2637() {
        return this.f3691;
    }

    /* renamed from: com.netflix.mediaclient.ui.player.pivots.PivotsUIView$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m2648(int i) {
            PivotsUIView.f3679 = i;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final int m2649() {
            return PivotsUIView.f3679;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m2640(Context context) {
        C1457Fr.m5025(context, "context");
        switch (C2332xz.f12322[Config_Ab9454_InPlayerPivots.f1097.m537().ordinal()]) {
            case 1:
                String string = context.getString(R.string.label_continue_watching);
                C1457Fr.m5016((Object) string, "context.getString(R.stri….label_continue_watching)");
                return string;
            case 2:
                String string2 = context.getString(R.string.label_similar_shows);
                C1457Fr.m5016((Object) string2, "context.getString(R.string.label_similar_shows)");
                return string2;
            default:
                return "";
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m2621(Context context, RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        m2629(context);
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.f3689;
        if (adapter == null) {
            C1457Fr.m5017("adapter");
        }
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new C0043((int) context.getResources().getDimension(R.dimen.next_episode_padding)));
        m2613();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static /* synthetic */ void m2617(PivotsUIView pivotsUIView, float f, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        pivotsUIView.m2624(f, j);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m2624(float f, long j) {
        if (this.f3681.getVisibility() != 0) {
            this.f3681.setVisibility(0);
        }
        ViewParent parent = this.f3681.getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        }
        ((View) parent).animate().y(f).setDuration(j).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.player.pivots.PivotsUIView$iF  reason: case insensitive filesystem */
    public static final class View$OnClickListenerC1293iF implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ PivotsUIView f3709;

        View$OnClickListenerC1293iF(PivotsUIView pivotsUIView) {
            this.f3709 = pivotsUIView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f3709.f3690.onNext(IPlayerFragment.PublisherEvents.INTENT_CLICK_TO_SHOW_PIVOTS);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ʻ  reason: contains not printable characters */
    private final void m2613() {
        this.f3682.setOnClickListener(new View$OnClickListenerC1293iF(this));
        this.f3681.setOnTouchListener(new View$OnTouchListenerC0045(this));
    }

    /* renamed from: com.netflix.mediaclient.ui.player.pivots.PivotsUIView$ᐝ  reason: contains not printable characters */
    public static final class View$OnTouchListenerC0045 implements View.OnTouchListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ PivotsUIView f3714;

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f3715;

        /* renamed from: ˎ  reason: contains not printable characters */
        private float f3716;

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean f3717;

        /* renamed from: ॱ  reason: contains not printable characters */
        private float f3718;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        View$OnTouchListenerC0045(PivotsUIView pivotsUIView) {
            this.f3714 = pivotsUIView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            C1457Fr.m5025(view, "view");
            C1457Fr.m5025(motionEvent, "event");
            float r7 = this.f3714.m2636();
            switch (motionEvent.getActionMasked()) {
                case 0:
                    C1283.m16854("PivotsUIView", "ACTION_DOWN");
                    this.f3716 = motionEvent.getX();
                    this.f3718 = motionEvent.getY();
                    ViewParent parent = this.f3714.m2642().getParent();
                    if (parent == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                    }
                    this.f3715 = (int) (((View) parent).getY() - motionEvent.getRawY());
                    this.f3714.m2635().mo12098();
                    return false;
                case 1:
                case 3:
                    float abs = Math.abs(motionEvent.getX() - this.f3716);
                    float abs2 = Math.abs(motionEvent.getY() - this.f3718);
                    ViewParent parent2 = this.f3714.m2642().getParent();
                    if (parent2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                    }
                    float y = ((View) parent2).getY();
                    C1283.m16851("PivotsUIView", "ACTION_UP xDiff=%s yDiff=%s", Float.valueOf(abs), Float.valueOf(abs2));
                    if (this.f3717) {
                        this.f3717 = false;
                        if (Math.abs(0.0f - y) <= Math.abs(r7 - y)) {
                            C1283.m16854("PivotsUIView", "SNAP UP");
                            this.f3714.f3690.onNext(IPlayerFragment.PublisherEvents.INTENT_ON_PLAYER_SNAP_UP);
                            return true;
                        }
                        C1283.m16854("PivotsUIView", "SNAP DOWN");
                        this.f3714.f3690.onNext(IPlayerFragment.PublisherEvents.INTENT_ON_PLAYER_SNAP_DOWN);
                        return true;
                    }
                    ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
                    C1457Fr.m5016((Object) viewConfiguration, "ViewConfiguration.get(view.context)");
                    int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                    if (abs >= 0.0f && abs < ((float) scaledTouchSlop) && abs2 >= 0.0f && abs2 < ((float) scaledTouchSlop)) {
                        int childAdapterPosition = this.f3714.m2642().getChildAdapterPosition(this.f3714.m2642().findChildViewUnder(motionEvent.getX(), motionEvent.getY()));
                        C1283.m16851("PivotsUIView", "ACTION_UP is a CLICK at %s position", Integer.valueOf(childAdapterPosition));
                        PivotsUIView pivotsUIView = this.f3714;
                        pF playable = this.f3714.m2638().get(childAdapterPosition).getPlayable();
                        C1457Fr.m5016((Object) playable, "videoList[childPosition].playable");
                        VideoType type = this.f3714.m2638().get(childAdapterPosition).getType();
                        C1457Fr.m5016((Object) type, "videoList[childPosition].type");
                        pivotsUIView.m2628(childAdapterPosition, playable, type);
                    }
                    if (y <= 0.0f) {
                        return false;
                    }
                    this.f3714.m2635().mo12097();
                    return false;
                case 2:
                    float abs3 = Math.abs(motionEvent.getX() - this.f3716);
                    float abs4 = Math.abs(motionEvent.getY() - this.f3718);
                    if (!this.f3717 && abs3 > abs4 && abs3 > 0.0f) {
                        C1283.m16851("PivotsUIView", "ACTION_MOVE HORIZONTAL yDiff=%s, xDiff=%s", Float.valueOf(abs4), Float.valueOf(abs3));
                        return false;
                    } else if (abs4 <= 0.0f) {
                        return true;
                    } else {
                        C1283.m16851("PivotsUIView", "ACTION_MOVE VERTICAL yDiff=%s, xDiff=%s", Float.valueOf(abs4), Float.valueOf(abs3));
                        this.f3717 = true;
                        if (motionEvent.getRawY() + ((float) this.f3715) < 0.0f) {
                            C1283.m16854("PivotsUIView", "reached the top max");
                            PivotsUIView.m2617(this.f3714, 0.0f, 0, 2, null);
                            return true;
                        } else if (motionEvent.getRawY() + ((float) this.f3715) >= r7) {
                            C1283.m16851("PivotsUIView", "reached the bottom max - min is %s", Float.valueOf(r7));
                            PivotsUIView.m2617(this.f3714, r7, 0, 2, null);
                            return true;
                        } else {
                            PivotsUIView.m2617(this.f3714, motionEvent.getRawY() + ((float) this.f3715), 0, 2, null);
                            return true;
                        }
                    }
                default:
                    return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m2628(int i, pF pFVar, VideoType videoType) {
        this.f3694.mo2243(new C2279wu(pFVar, videoType, new qN(null, qN.f9501, 0, i), 0));
    }

    /* renamed from: com.netflix.mediaclient.ui.player.pivots.PivotsUIView$ˋ  reason: contains not printable characters */
    public static final class C0044 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ Context f3712;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ PivotsUIView f3713;

        C0044(PivotsUIView pivotsUIView, Context context) {
            this.f3713 = pivotsUIView;
            this.f3712 = context;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            C1457Fr.m5025(viewGroup, "viewGroup");
            PivotsUIView pivotsUIView = this.f3713;
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_pivots_view_holder, viewGroup, false);
            C1457Fr.m5016((Object) inflate, "LayoutInflater.from(view…holder, viewGroup, false)");
            return new If(pivotsUIView, inflate);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            C1457Fr.m5025(viewHolder, "viewHolder");
            m2651((If) viewHolder, i);
            m2650((If) viewHolder, i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f3713.m2638().size();
        }

        @SuppressLint({"StringFormatMatches"})
        /* renamed from: ˎ  reason: contains not printable characters */
        private final void m2650(If r9, int i) {
            String str;
            switch (i) {
                case 0:
                    r9.m2643().getLayoutParams().width = r9.m2644().getPaddingStart() + ((int) r9.m2644().getPaint().measureText(C1349Bv.m4102(C0403.m14185(NetflixApplication.getInstance(), R.string.label_postplay_nextEpisode).m14187(10).m14188()).toString())) + r9.m2644().getPaddingEnd();
                    r9.m2643().requestLayout();
                    if (this.f3713.m2637()) {
                        TextView r0 = r9.m2645();
                        if (PivotsUIView.f3680.m2649() > -1) {
                            str = C1349Bv.m4102(C0403.m14185(NetflixApplication.getInstance(), R.string.label_postplay_nextEpisode).m14187(PivotsUIView.f3680.m2649()).m14188());
                        } else {
                            str = this.f3712.getResources().getString(R.string.label_next_episode);
                        }
                        r0.setText(str);
                        r9.m2644().setText(this.f3713.m2638().get(i).getParentTitle());
                        r9.m2646().setText(this.f3712.getResources().getString(R.string.label_season_and_episode_abbreviated, this.f3713.m2638().get(i).getSeasonAbbrSeqLabel(), Integer.valueOf(this.f3713.m2638().get(i).getEpisodeNumber())));
                        r9.m2644().setVisibility(0);
                        r9.m2646().setVisibility(0);
                        return;
                    }
                    r9.m2645().setText(this.f3713.f3688);
                    r9.m2644().setVisibility(8);
                    r9.m2646().setVisibility(8);
                    return;
                case 1:
                    if (this.f3713.m2637()) {
                        r9.m2645().setText(this.f3713.f3688);
                    } else {
                        r9.m2645().setText("");
                    }
                    r9.m2644().setVisibility(8);
                    r9.m2646().setVisibility(8);
                    return;
                default:
                    r9.m2645().setText("");
                    r9.m2644().setVisibility(8);
                    r9.m2646().setVisibility(8);
                    return;
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private final void m2651(If r11, int i) {
            String horzDispUrl = this.f3713.m2638().get(i).getHorzDispUrl();
            AssetType assetType = AssetType.boxArt;
            if ((i == 0 && this.f3713.m2637()) || C1457Fr.m5018(this.f3713.m2639(), PivotsListAssetType.BIF)) {
                horzDispUrl = this.f3713.m2638().get(i).createModifiedStillUrl();
                assetType = AssetType.bif;
            }
            ImageLoader imageLoader = NetflixActivity.getImageLoader(this.f3712);
            if (imageLoader != null) {
                imageLoader.mo3063(r11.m2647(), horzDispUrl, assetType, this.f3713.m2638().get(i).getTitle(), BrowseExperience.m1769(), true, 1);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m2629(Context context) {
        this.f3689 = new C0044(this, context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final float m2636() {
        NetflixApplication instance = NetflixApplication.getInstance();
        C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
        return instance.getResources().getDimension(R.dimen.player_pivots_show_partially_height);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002f: APUT  
      (r2v1 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Float : 0x002a: INVOKE  (r3v7 java.lang.Float) = 
      (wrap: float : 0x0026: INVOKE  (r3v6 float) = 
      (wrap: android.view.View : 0x0024: CHECK_CAST (r3v5 android.view.View) = (android.view.View) (r3v4 android.view.ViewParent))
     type: VIRTUAL call: android.view.View.getY():float)
     type: STATIC call: java.lang.Float.valueOf(float):java.lang.Float)
     */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private final void m2633() {
        Object[] objArr = new Object[2];
        objArr[0] = Float.valueOf(this.f3681.getY());
        ViewParent parent = this.f3681.getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        }
        objArr[1] = Float.valueOf(((View) parent).getY());
        C1283.m16851("PivotsUIView", "Hiding, current y is %s parent y is %s", objArr);
        m2617(this, 0.0f, 0, 2, null);
        this.f3681.setVisibility(8);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002f: APUT  
      (r2v1 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Float : 0x002a: INVOKE  (r3v7 java.lang.Float) = 
      (wrap: float : 0x0026: INVOKE  (r3v6 float) = 
      (wrap: android.view.View : 0x0024: CHECK_CAST (r3v5 android.view.View) = (android.view.View) (r3v4 android.view.ViewParent))
     type: VIRTUAL call: android.view.View.getY():float)
     type: STATIC call: java.lang.Float.valueOf(float):java.lang.Float)
     */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final void m2632() {
        Object[] objArr = new Object[2];
        objArr[0] = Float.valueOf(this.f3681.getY());
        ViewParent parent = this.f3681.getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        }
        objArr[1] = Float.valueOf(((View) parent).getY());
        C1283.m16851("PivotsUIView", "Showing, current y is %s parent y is %s", objArr);
        ViewParent parent2 = this.f3681.getParent();
        if (parent2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        } else if (((View) parent2).getY() > 0.0f) {
            m2622();
        } else if (this.f3681.getVisibility() != 0) {
            NetflixApplication instance = NetflixApplication.getInstance();
            C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
            this.f3686.m12591(this.f3681, true, true, instance.getResources().getDimension(R.dimen.player_pivots_translation), null);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m2618(boolean z) {
        C1283.m16854("PivotsUIView", "Showing partially");
        m2624(m2636(), z ? this.f3692 : 0);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final void m2622() {
        C1283.m16854("PivotsUIView", "resetHeight");
        m2624(0.0f, this.f3692);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m2625(List<? extends CH> list, PivotsListAssetType pivotsListAssetType) {
        this.f3693.clear();
        this.f3693.addAll(list);
        this.f3687 = pivotsListAssetType;
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.f3689;
        if (adapter == null) {
            C1457Fr.m5017("adapter");
        }
        adapter.notifyDataSetChanged();
    }

    public final class If extends RecyclerView.ViewHolder {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final TextView f3696;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final C0522 f3697;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final TextView f3698;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ PivotsUIView f3699;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final TextView f3700;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private final ViewGroup f3701;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public If(PivotsUIView pivotsUIView, View view) {
            super(view);
            C1457Fr.m5025(view, "view");
            this.f3699 = pivotsUIView;
            View findViewById = view.findViewById(R.id.pivots_img);
            C1457Fr.m5016((Object) findViewById, "view.findViewById(R.id.pivots_img)");
            this.f3697 = (C0522) findViewById;
            View findViewById2 = view.findViewById(R.id.pivot_item_title);
            C1457Fr.m5016((Object) findViewById2, "view.findViewById(R.id.pivot_item_title)");
            this.f3698 = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.pivot_item_episode);
            C1457Fr.m5016((Object) findViewById3, "view.findViewById(R.id.pivot_item_episode)");
            this.f3696 = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.pivots_label);
            C1457Fr.m5016((Object) findViewById4, "view.findViewById(R.id.pivots_label)");
            this.f3700 = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.pivots_container);
            C1457Fr.m5016((Object) findViewById5, "view.findViewById(R.id.pivots_container)");
            this.f3701 = (ViewGroup) findViewById5;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final C0522 m2647() {
            return this.f3697;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final TextView m2644() {
            return this.f3698;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final TextView m2646() {
            return this.f3696;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final TextView m2645() {
            return this.f3700;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final ViewGroup m2643() {
            return this.f3701;
        }
    }

    /* renamed from: com.netflix.mediaclient.ui.player.pivots.PivotsUIView$ˊ  reason: contains not printable characters */
    public final class C0043 extends RecyclerView.ItemDecoration {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final int f3711;

        public C0043(int i) {
            this.f3711 = i;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            C1457Fr.m5025(rect, "outRect");
            C1457Fr.m5025(view, "view");
            C1457Fr.m5025(recyclerView, "parent");
            C1457Fr.m5025(state, "state");
            if (PivotsUIView.this.m2637() && recyclerView.getChildAdapterPosition(view) == 1) {
                rect.left = this.f3711;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m2623(CH ch) {
        if (!this.f3693.isEmpty()) {
            if (!this.f3691) {
                this.f3691 = true;
                this.f3693.add(0, ch);
                RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.f3689;
                if (adapter == null) {
                    C1457Fr.m5017("adapter");
                }
                adapter.notifyDataSetChanged();
                this.f3681.scrollToPosition(0);
                return;
            }
            this.f3693.set(0, ch);
            RecyclerView.Adapter<RecyclerView.ViewHolder> adapter2 = this.f3689;
            if (adapter2 == null) {
                C1457Fr.m5017("adapter");
            }
            adapter2.notifyDataSetChanged();
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final void m2626() {
        if (this.f3691) {
            this.f3691 = false;
            this.f3693.remove(0);
            RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.f3689;
            if (adapter == null) {
                C1457Fr.m5017("adapter");
            }
            adapter.notifyDataSetChanged();
            this.f3681.scrollToPosition(0);
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final void m2619() {
        this.f3684.m12590((View) this.f3682, false);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final void m2631() {
        this.f3684.m12590((View) this.f3682, true);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private final void m2627() {
        this.f3682.setVisibility(8);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final void m2634() {
        this.f3682.setVisibility(0);
    }

    @Override // o.AbstractC0500
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo2641(AbstractC0409<C2325xt> r3) {
        C1457Fr.m5025(r3, Device.MODEL);
        C2325xt xtVar = (C2325xt) r3;
        switch (C2332xz.f12323[((C2325xt) r3).m12995().ordinal()]) {
            case 1:
                m2632();
                break;
            case 2:
                m2633();
                break;
            case 3:
                m2618(((C2325xt) r3).m12992());
                break;
        }
        if (((C2325xt) r3).m12993()) {
            m2631();
        } else {
            m2619();
        }
        if (!((C2325xt) r3).m12996() || !(!C1457Fr.m5018(((C2325xt) r3).m12995(), PivotsListVisibility.SHOW_PARTIALLY))) {
            m2627();
        } else {
            m2634();
        }
        if (((C2325xt) r3).m12998()) {
            this.f3685.mo12097();
        } else {
            this.f3685.mo12098();
        }
        m2625(((C2325xt) r3).m12994(), ((C2325xt) r3).m12991());
        if (((C2325xt) r3).m13000() != null) {
            f3680.m2648(((C2325xt) r3).m12999());
            m2623(((C2325xt) r3).m13000());
            return;
        }
        m2626();
    }
}
