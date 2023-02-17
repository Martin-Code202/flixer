package com.netflix.mediaclient.ui.offline;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import com.netflix.android.widgetry.widget.tabs.BadgeView;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC1853hl;
import o.C1011;
import o.C1276;
import o.C1283;
import o.C1359Ce;
import o.C1364Cj;
import o.C2059ph;
import o.C2093qn;
import o.oB;
import o.oX;
import o.pF;
import o.pV;
import o.qK;
import o.qN;
import o.vD;
import o.vM;
import o.vN;
import o.vO;
public class DownloadButton extends FrameLayout {

    /* renamed from: ॱ  reason: contains not printable characters */
    static List<String> f3320 = new ArrayList();

    /* renamed from: ʽ  reason: contains not printable characters */
    private pF f3321;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f3322;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f3323;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f3324;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ButtonState f3325 = ButtonState.NOT_AVAILABLE;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private iF f3326;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private BadgeView f3327;

    public enum ButtonState {
        AVAILABLE,
        NOT_AVAILABLE,
        SAVED,
        DOWNLOADING,
        PAUSED,
        QUEUED,
        PRE_QUEUED,
        ERROR
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2165() {
        if (this.f3326 != null) {
            this.f3326.m2170(this);
        }
    }

    public DownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2155(context, attributeSet);
        this.f3327 = (BadgeView) LayoutInflater.from(getContext()).inflate(this.f3322 ? R.layout.download_button_with_primary_message : R.layout.download_button, this).findViewById(R.id.download_button_badge);
        m2153();
        m2161();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2153() {
        m2154(R.drawable.ic_download_icon);
        setContentDescription(getResources().getString(R.string.button_message_download));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2155(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.C0006.DownloadButton);
        this.f3322 = obtainStyledAttributes.getBoolean(0, false);
        this.f3324 = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2167(int i) {
        this.f3327.setDisplayType(BadgeView.DisplayType.PROGRESS);
        this.f3327.setBackgroundColor(getContext().getResources().getColor(R.color.tab_downloads_badge));
        this.f3327.setBackgroundShadowColor(getContext().getResources().getColor(R.color.transparent));
        this.f3327.setProgress(i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2154(int i) {
        this.f3327.setDisplayType(BadgeView.DisplayType.DRAWABLE);
        this.f3327.setDrawable(getContext().getDrawable(i));
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m2161() {
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.netflix.mediaclient.ui.offline.DownloadButton.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                String str = null;
                switch (((DownloadButton) view).m2163()) {
                    case PRE_QUEUED:
                    case QUEUED:
                    case DOWNLOADING:
                        str = DownloadButton.this.getResources().getString(R.string.offline_action_pause_download);
                        break;
                    case PAUSED:
                        str = DownloadButton.this.getResources().getString(R.string.offline_action_resume_download);
                        break;
                    case AVAILABLE:
                        str = DownloadButton.this.getResources().getString(R.string.offline_action_start_download);
                        break;
                    case SAVED:
                        str = DownloadButton.this.getResources().getString(R.string.button_message_available);
                        break;
                }
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                Snackbar.make(view, str, -1).show();
                return true;
            }
        });
    }

    public void setProgress(int i) {
        m2167(i);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0052: APUT  
      (r2v1 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x004d: INVOKE  (r3v1 java.lang.Boolean) = (r3v0 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    public void setStateFromPlayable(pF pFVar, NetflixActivity netflixActivity) {
        AbstractC1853hl r6;
        C1283.m16862("download_button", "setStateFromPlayable");
        C2059ph serviceManager = netflixActivity.getServiceManager();
        if (pFVar != null && serviceManager != null && serviceManager.mo9519() && C2093qn.m10093(pFVar) && (r6 = serviceManager.m9832()) != null) {
            this.f3321 = pFVar;
            this.f3326 = new iF(pFVar, netflixActivity);
            setOnClickListener(this.f3326);
            vM r7 = vO.m12029(r6);
            pV pVVar = null;
            if (r7 != null) {
                pVVar = r7.mo11976(pFVar.getPlayableId());
            }
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(pVVar != null);
            C1283.m16863("download_button", "setStateFromPlayable hasOfflinePlayableData=%b", objArr);
            if (pVVar != null) {
                if (vO.m12019(pVVar)) {
                    m2168(ButtonState.ERROR, pFVar.getPlayableId());
                    return;
                }
                DownloadState r9 = pVVar.mo6881();
                int r10 = pVVar.mo6916();
                switch (r9) {
                    case Complete:
                        if (pVVar.mo6912().m1586()) {
                            m2168(ButtonState.ERROR, pFVar.getPlayableId());
                            return;
                        } else {
                            m2168(ButtonState.SAVED, pFVar.getPlayableId());
                            return;
                        }
                    case Creating:
                        m2168(ButtonState.QUEUED, pFVar.getPlayableId());
                        return;
                    case InProgress:
                        m2168(ButtonState.DOWNLOADING, pFVar.getPlayableId());
                        setProgress(r10);
                        return;
                    case Stopped:
                        if (pVVar.mo6911().m1581()) {
                            m2168(ButtonState.ERROR, pFVar.getPlayableId());
                            return;
                        } else if (r10 > 0) {
                            m2168(ButtonState.PAUSED, pFVar.getPlayableId());
                            setProgress(r10);
                            return;
                        } else {
                            m2168(ButtonState.QUEUED, pFVar.getPlayableId());
                            return;
                        }
                    case CreateFailed:
                        m2168(ButtonState.ERROR, pFVar.getPlayableId());
                        return;
                    default:
                        if (!f3320.contains(pFVar.getPlayableId())) {
                            m2168(pFVar.isAvailableOffline() ? ButtonState.AVAILABLE : ButtonState.NOT_AVAILABLE, pFVar.getPlayableId());
                            return;
                        } else {
                            m2168(ButtonState.QUEUED, pFVar.getPlayableId());
                            return;
                        }
                }
            } else if (!f3320.contains(pFVar.getPlayableId())) {
                m2168(pFVar.isAvailableOffline() ? ButtonState.AVAILABLE : ButtonState.NOT_AVAILABLE, pFVar.getPlayableId());
            } else {
                m2168(ButtonState.QUEUED, pFVar.getPlayableId());
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m2166() {
        return this.f3323;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2168(ButtonState buttonState, String str) {
        ButtonState buttonState2 = this.f3325;
        this.f3325 = buttonState;
        this.f3323 = str;
        if (buttonState != ButtonState.QUEUED) {
            m2159(str);
        }
        setImportantForAccessibility(buttonState == ButtonState.NOT_AVAILABLE ? 4 : 1);
        m2162();
        if (buttonState2 != buttonState && buttonState2 == ButtonState.NOT_AVAILABLE) {
            setVisibility(0);
        }
        setTag("download_btn" + str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ButtonState m2163() {
        return this.f3325;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m2162() {
        switch (this.f3325) {
            case PRE_QUEUED:
                m2167(0);
                m2154(R.drawable.ic_download_prequeued);
                m2149();
                return;
            case QUEUED:
                m2167(0);
                m2151(R.drawable.ic_download_queue);
                return;
            case DOWNLOADING:
                this.f3327.clearAnimation();
                m2151(R.drawable.ic_download_progress);
                return;
            case PAUSED:
                m2151(R.drawable.ic_download_progress_resume);
                return;
            case AVAILABLE:
                m2167(0);
                m2154(R.drawable.ic_download_icon);
                return;
            case SAVED:
                m2167(0);
                m2151(R.drawable.ic_download_complete);
                return;
            case ERROR:
                m2167(0);
                m2151(R.drawable.ic_download_error);
                return;
            case NOT_AVAILABLE:
                setVisibility(4);
                return;
            default:
                return;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m2149() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 90.0f, (float) (this.f3327.getMeasuredWidth() / 2), (float) (this.f3327.getMeasuredHeight() / 2));
        rotateAnimation.setDuration(400);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.netflix.mediaclient.ui.offline.DownloadButton.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                C1283.m16862("download_button", "onAnimationEnd");
                if (DownloadButton.this.m2163() != ButtonState.ERROR) {
                    DownloadButton.this.m2168(ButtonState.QUEUED, DownloadButton.this.f3323);
                }
                DownloadButton.this.f3327.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.f3327.startAnimation(rotateAnimation);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2151(int i) {
        this.f3327.clearAnimation();
        this.f3327.animate().alpha(1.0f).setDuration(500);
        m2154(i);
    }

    /* access modifiers changed from: package-private */
    public class iF implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final String f3341;

        /* renamed from: ˋ  reason: contains not printable characters */
        final pF f3342;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final NetflixActivity f3343;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final VideoType f3345;

        iF(pF pFVar, NetflixActivity netflixActivity) {
            this.f3343 = netflixActivity;
            this.f3341 = pFVar.getPlayableId();
            this.f3342 = pFVar;
            this.f3345 = pFVar.isPlayableEpisode() ? VideoType.EPISODE : VideoType.MOVIE;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m2170(view);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m2170(View view) {
            AbstractC1853hl r6;
            if (DownloadButton.this.f3325 != ButtonState.NOT_AVAILABLE && (r6 = this.f3343.getServiceManager().m9832()) != null) {
                vM r8 = vO.m12029(r6);
                boolean z = r8.mo11967() == 0;
                pV r10 = r8.mo11976(this.f3341);
                if (r10 != null) {
                    switch (((DownloadButton) view).m2163()) {
                        case PRE_QUEUED:
                        case QUEUED:
                            this.f3343.showMenu(vD.m11893(DownloadButton.this.getContext(), DownloadButton.this, this.f3341, DownloadButton.this.f3324, z));
                            return;
                        case DOWNLOADING:
                            this.f3343.showMenu(vD.m11892(DownloadButton.this.getContext(), DownloadButton.this, this.f3341, DownloadButton.this.f3324));
                            return;
                        case PAUSED:
                            this.f3343.showMenu(vD.m11893(DownloadButton.this.getContext(), DownloadButton.this, this.f3341, DownloadButton.this.f3324, z));
                            return;
                        case AVAILABLE:
                        default:
                            m2169(view, this.f3342);
                            return;
                        case SAVED:
                            oX r11 = vO.m12020(r10);
                            if (r11 != qN.f9513) {
                                if (this.f3343 instanceof qK) {
                                    r11 = ((qK) this.f3343).mo1635();
                                } else {
                                    r11 = new oB("download_button");
                                }
                            }
                            vD.m11884(DownloadButton.this.getContext(), DownloadButton.this, this.f3341, this.f3345, DownloadButton.this.f3324, r11).show();
                            return;
                        case ERROR:
                            vN r12 = vN.m11997(this.f3345, r10, r6);
                            if (this.f3343.isDialogFragmentVisible()) {
                                this.f3343.removeDialogFrag();
                            }
                            this.f3343.showDialog(r12);
                            return;
                        case NOT_AVAILABLE:
                            return;
                    }
                } else {
                    m2169(view, this.f3342);
                }
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m2169(View view, pF pFVar) {
            oX oXVar;
            Logger.INSTANCE.m142(new C1011());
            C1364Cj.m4436(UIViewLogging.UIViewCommandName.AddCachedVideoCommand, IClientLogging.ModalView.addCachedVideoButton, (C1359Ce) null, (String) null);
            boolean r4 = this.f3343.getServiceManager().m9832().mo7131();
            boolean r5 = ConnectivityUtils.m2955(DownloadButton.this.getContext());
            if (r4 && !r5 && ConnectivityUtils.m2964(view.getContext())) {
                vD.m11894(DownloadButton.this.getContext(), DownloadButton.this.m2166(), this.f3345, false).show();
            } else if (!ConnectivityUtils.m2964(view.getContext())) {
                vD.m11895(DownloadButton.this.getContext(), DownloadButton.this.m2166(), false).show();
            } else if (!DownloadButton.f3320.contains(this.f3341)) {
                ((DownloadButton) view).m2168(ButtonState.PRE_QUEUED, this.f3341);
                DownloadButton.f3320.add(this.f3341);
                if (this.f3343 instanceof qK) {
                    oXVar = ((qK) this.f3343).mo1635();
                } else {
                    C1276.m16820().mo5725("netflixActivity is NOT an instanceof PlayContextProvider");
                    oXVar = new oB("download_button");
                }
                this.f3343.getServiceManager().m9832().mo7141(this.f3341, this.f3345, oXVar);
            } else {
                return;
            }
            C1364Cj.m4432();
            Logger.INSTANCE.m130("AddCachedVideoCommand");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m2160(List<String> list) {
        for (String str : list) {
            f3320.remove(str);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m2159(String str) {
        f3320.remove(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m2156() {
        f3320.clear();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m2164(String str, NetflixActivity netflixActivity) {
        if (str != null && str.equals(this.f3323)) {
            setStateFromPlayable(this.f3321, netflixActivity);
        }
    }
}
