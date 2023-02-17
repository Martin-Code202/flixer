package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.cl.model.GestureInputKind;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaCta;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Date;
import o.tP;
import org.json.JSONObject;
/* renamed from: o.Ad  reason: case insensitive filesystem */
public class C1301Ad extends LinearLayout {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final View f4357;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Space f4358;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Space f4359;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0628 f4360;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private UmaAlert f4361;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ValueAnimator f4362;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private AbstractC0496 f4363;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final TextView f4364;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final TextView f4365;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private AbstractC2220ut f4366;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Long f4367;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ViewGroup f4368;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Long f4369;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private Long f4370;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private Long f4371;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f4372;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final ViewPropertyAnimator f4373;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private PublishSubject<Boolean> f4374 = PublishSubject.create();

    public C1301Ad(Context context, boolean z) {
        super(context);
        this.f4372 = z;
        inflate(context, this.f4372 ? R.layout.user_message_area : R.layout.user_message_area_dialog, this);
        this.f4364 = (TextView) findViewById(R.id.title);
        this.f4364.setMovementMethod(LinkMovementMethod.getInstance());
        this.f4365 = (TextView) findViewById(R.id.body);
        this.f4365.setMovementMethod(LinkMovementMethod.getInstance());
        this.f4368 = (ViewGroup) findViewById(R.id.cta_container);
        this.f4360 = (C0628) findViewById(R.id.icon);
        this.f4357 = findViewById(R.id.alert);
        this.f4359 = (Space) findViewById(R.id.dim_space);
        setOnTouchListener(new View.OnTouchListener() { // from class: o.Ad.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        BX.m3950(this.f4368);
        this.f4373 = animate();
        this.f4373.setDuration((long) getResources().getInteger(17694721));
        this.f4373.setListener(new AnimatorListenerAdapter() { // from class: o.Ad.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (C1301Ad.this.isAttachedToWindow()) {
                    C1301Ad.this.f4362.start();
                }
            }
        });
        this.f4362 = new ValueAnimator();
        this.f4362.setStartDelay(20);
        this.f4362.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f4362.setFloatValues(0.0f, 1.0f);
        this.f4362.setDuration((long) getResources().getInteger(17694721));
        this.f4362.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.Ad.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (C1301Ad.this.isAttachedToWindow()) {
                    View view = C1301Ad.this.f4361.blocking() ? C1301Ad.this.f4358 : C1301Ad.this;
                    if (valueAnimator.getAnimatedFraction() == 1.0f) {
                        C1301Ad.this.f4366.mo11039(view);
                        if (C1301Ad.this.f4361.blocking()) {
                            ((ViewGroup) C1301Ad.this.getParent()).removeView(C1301Ad.this);
                        }
                    } else if (view != null) {
                        view.getLayoutParams().height = Math.max(1, (int) (((float) view.getMeasuredHeight()) - (valueAnimator.getAnimatedFraction() * ((float) view.getMeasuredHeight()))));
                        view.requestLayout();
                    }
                }
            }
        });
        this.f4362.addListener(new AnimatorListenerAdapter() { // from class: o.Ad.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (C1301Ad.this.isAttachedToWindow()) {
                    C1301Ad.this.f4366.mo11039(C1301Ad.this);
                }
            }
        });
        if (this.f4372) {
            setVisibility(8);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m3570(UmaAlert umaAlert, AbstractC2220ut utVar, ViewGroup viewGroup) {
        NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class);
        if (netflixActivity != null) {
            this.f4366 = utVar;
            this.f4361 = umaAlert;
            m3561();
            setVisibility(0);
            if (this.f4361.blocking()) {
                if (tP.Cif.m10990()) {
                    C1004.m15952(this, 1, netflixActivity.getActionBarHeight());
                } else {
                    C1004.m15952(this, 1, netflixActivity.getActionBarHeight());
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.Ad.7
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            C1301Ad.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            C1301Ad.this.f4358 = new Space(C1301Ad.this.getContext());
                            C1301Ad.this.f4358.setLayoutParams(new AbsListView.LayoutParams(-1, C1301Ad.this.f4357.getMeasuredHeight()));
                            C1301Ad.this.f4366.mo11038(C1301Ad.this.f4358, null, false);
                        }
                    });
                }
                C1316Ar.m3740(viewGroup, this, true);
                if (!TextUtils.isEmpty(umaAlert.title())) {
                    C1316Ar.m3739(netflixActivity, umaAlert.title());
                } else if (!TextUtils.isEmpty(umaAlert.body())) {
                    C1316Ar.m3739(netflixActivity, umaAlert.body());
                }
                viewGroup.addView(this, new FrameLayout.LayoutParams(-1, -1));
                this.f4359.setVisibility(0);
                setBackgroundResource(R.color.uma_blocking_dim);
            } else if (tP.Cif.m10990()) {
                viewGroup.addView(this, new FrameLayout.LayoutParams(-1, -2));
                C1004.m15952(this, 1, netflixActivity.getActionBarHeight() + C1004.m15956(netflixActivity));
                setBackgroundResource(R.color.uma_blocking_dim);
            } else {
                this.f4366.mo11038(this, null, false);
                this.f4359.setVisibility(8);
                setBackground(null);
            }
            m3569();
            C1283.m16854("UserMessageAreaView", "Displaying uma alert for banner created on " + new Date(this.f4361.timestamp()));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3566(UmaAlert umaAlert, AbstractC0496 r8) {
        if (((NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class)) != null) {
            this.f4361 = umaAlert;
            this.f4363 = r8;
            m3561();
            C1283.m16854("UserMessageAreaView", "Displaying uma alert for modal created on " + new Date(this.f4361.timestamp()));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m3569() {
        NetflixActivity netflixActivity;
        if (this.f4361 != null) {
            AnonymousClass14 r3 = null;
            try {
                if (this.f4361.trackingInfo() != null) {
                    r3 = new AbstractC0574() { // from class: o.Ad.14
                        @Override // o.AbstractC0503
                        public JSONObject toJSONObject() {
                            return new JSONObject(C1301Ad.this.f4361.trackingInfo());
                        }
                    };
                }
            } catch (Throwable th) {
                C1276.m16820().mo5727("Bad UMA trackingInfo " + this.f4361.trackingInfo());
            }
            C1364Cj.m4440(IClientLogging.ModalView.umsAlert, this.f4361.trackingInfo());
            this.f4369 = Logger.INSTANCE.m142(new C1224(r3, AppView.umsAlert));
            if (this.f4361.umsAlertRenderFeedback() != null && (netflixActivity = (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class)) != null) {
                netflixActivity.getServiceManager().m9780(this.f4361.umsAlertRenderFeedback());
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3571() {
        Logger.INSTANCE.m140(this.f4369);
        C1364Cj.m4448(IClientLogging.ModalView.umsAlert, this.f4361.blocking(), this.f4361.trackingInfo());
        this.f4369 = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3546(final UmaCta umaCta, UIViewLogging.UIViewCommandName uIViewCommandName, AbstractC0401 r9) {
        NetflixActivity netflixActivity;
        C1359Ce ce = new C1359Ce();
        ce.m4364(umaCta.trackingInfo());
        C1364Cj.m4436(uIViewCommandName, IClientLogging.ModalView.umsAlert, ce, (String) null);
        AnonymousClass13 r4 = null;
        try {
            if (umaCta.trackingInfo() != null) {
                r4 = new AbstractC0574() { // from class: o.Ad.13
                    @Override // o.AbstractC0503
                    public JSONObject toJSONObject() {
                        return new JSONObject(umaCta.trackingInfo());
                    }
                };
            }
        } catch (Throwable th) {
            C1276.m16820().mo5727("Bad UMA cta trackingInfo " + umaCta.trackingInfo());
        }
        this.f4370 = Logger.INSTANCE.m142(new C1080(AppView.umsAlertButton, r4));
        this.f4367 = Long.valueOf(Logger.INSTANCE.m127(r9));
        this.f4371 = Logger.INSTANCE.m142(new C1014());
        if (umaCta.umsAlertCtaFeedback() != null && (netflixActivity = (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class)) != null) {
            netflixActivity.getServiceManager().m9780(umaCta.umsAlertCtaFeedback());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3549() {
        m3562((C0510) null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3562(C0510 r3) {
        C1364Cj.m4432();
        if (r3 == null) {
            Logger.INSTANCE.m140(this.f4371);
        } else {
            Logger.INSTANCE.m145(this.f4371, r3);
        }
        Logger.INSTANCE.m132(this.f4367);
        Logger.INSTANCE.m140(this.f4370);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3568(boolean z) {
        if (this.f4361 == null) {
            return;
        }
        if (this.f4372) {
            m3571();
            if (z && (this.f4361.blocking() || (this.f4366 instanceof ListView))) {
                this.f4373.alpha(0.0f);
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    C1316Ar.m3740((ViewGroup) parent, this, false);
                }
            } else if (this.f4361.blocking()) {
                ViewParent parent2 = getParent();
                if (parent2 instanceof ViewGroup) {
                    C1316Ar.m3740((ViewGroup) parent2, this, false);
                    ((ViewGroup) parent2).removeView(this);
                }
                this.f4366.mo11039(this.f4358);
            } else if (AD.m3292()) {
                ViewParent parent3 = getParent();
                if (parent3 instanceof ViewGroup) {
                    ((ViewGroup) parent3).removeView(this);
                }
            } else {
                this.f4366.mo11039(this);
            }
        } else if (this.f4363 != null) {
            this.f4363.dismiss();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m3572(UmaAlert umaAlert) {
        this.f4361 = umaAlert;
        boolean z = false;
        if (this.f4363 == null) {
            if (umaAlert.bannerAlert() && isAttachedToWindow()) {
                z = true;
            }
        } else if (umaAlert.modalAlert() && this.f4363.isVisible()) {
            z = true;
        }
        if (z) {
            m3571();
        }
        m3561();
        if (z) {
            m3569();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3561() {
        this.f4364.setText(this.f4361.title() == null ? null : C1349Bv.m4102(this.f4361.title()));
        this.f4365.setText(this.f4361.body() == null ? null : C1349Bv.m4102(this.f4361.body()));
        this.f4368.removeAllViews();
        UmaCta cta1 = this.f4361.cta1();
        if (cta1 != null) {
            m3545(cta1, R.id.uma_cta_1);
        }
        UmaCta cta2 = this.f4361.cta2();
        if (cta2 != null) {
            m3545(cta2, R.id.uma_cta_2);
        }
        if (UmaAlert.TYPE_INFO.equalsIgnoreCase(this.f4361.viewType())) {
            this.f4360.setVisibility(0);
            this.f4360.setText(R.string.icon_font_info_fill);
            this.f4360.setTextColor(getResources().getColor(R.color.info_blue));
        } else if (UmaAlert.TYPE_WARN.equalsIgnoreCase(this.f4361.viewType())) {
            this.f4360.setVisibility(0);
            this.f4360.setText(R.string.icon_font_warn_fill);
            this.f4360.setTextColor(getResources().getColor(R.color.info_orange));
        } else if (UmaAlert.TYPE_ERROR.equalsIgnoreCase(this.f4361.viewType())) {
            this.f4360.setVisibility(0);
            this.f4360.setText(R.string.icon_font_error_fill);
            this.f4360.setTextColor(getResources().getColor(R.color.info_red));
        } else {
            this.f4360.setVisibility(8);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3545(UmaCta umaCta, int i) {
        Button button;
        try {
            button = new C0754(new ContextThemeWrapper(getContext(), umaCta.selected() ? R.style.UmaCtaSelected : this.f4372 ? R.style.UmaCtaNotSelected : R.style.UmaCtaNotSelectedDialog));
        } catch (IndexOutOfBoundsException e) {
            C1276.m16820().mo5729("SPY-13671 - NetflixTextButton with font-family failed", e);
            try {
                button = new C0754(new ContextThemeWrapper(getContext(), (int) R.style.NetflixButtonDebugForSPY13671));
            } catch (IndexOutOfBoundsException e2) {
                C1276.m16820().mo5729("SPY-13671 - NetflixTextButton with NetflixButtonDebugForSPY13671 failed", e2);
                try {
                    button = new AppCompatButton(new ContextThemeWrapper(getContext(), (int) R.style.NetflixButtonDebugForSPY13671));
                } catch (IndexOutOfBoundsException e3) {
                    C1276.m16820().mo5729("SPY-13671 - AppCompatButton with NetflixButtonDebugForSPY13671 failed", e3);
                    try {
                        button = new AppCompatButton(NetflixApplication.getInstance());
                        button.setTextColor(-1);
                    } catch (IndexOutOfBoundsException e4) {
                        C1276.m16820().mo5729("SPY-13671 - AppCompatButton without style failed", e4);
                        try {
                            button = new Button(new ContextThemeWrapper(getContext(), (int) R.style.NetflixButtonDebugForSPY13671));
                        } catch (IndexOutOfBoundsException e5) {
                            C1276.m16820().mo5729("SPY-13671 - Button with NetflixButtonDebugForSPY13671 failed (last resort, no UMA for this device!!", e5);
                            return;
                        }
                    }
                }
            }
        }
        button.setText(umaCta.text());
        button.setId(i);
        if (this.f4372) {
            this.f4368.addView(button, new ViewGroup.LayoutParams(-2, -2));
        } else {
            this.f4368.addView(button, new ViewGroup.LayoutParams(-1, -2));
            int dimension = (int) this.f4357.getResources().getDimension(R.dimen.moderate_padding);
            int dimension2 = (int) this.f4357.getResources().getDimension(R.dimen.moderate_padding);
            button.setPadding(0, dimension, 0, dimension);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.setMargins(0, dimension2, 0, dimension2);
            button.setLayoutParams(layoutParams);
        }
        this.f4368.setVisibility(0);
        this.f4368.requestLayout();
        if (TextUtils.equals(UmaCta.ACTION_TYPE_LINK, umaCta.actionType())) {
            button.setOnClickListener(m3558(umaCta));
        } else if (TextUtils.equals(UmaCta.ACTION_RETRY_PAYMENT, umaCta.action())) {
            button.setOnClickListener(m3552(umaCta));
        } else if (TextUtils.equals(UmaCta.ACTION_RESTART_MEMBERSHIP, umaCta.action())) {
            button.setOnClickListener(m3543(umaCta));
        } else if (TextUtils.equals(UmaCta.ACTION_TYPE_UMS_IMPRESSION, umaCta.actionType()) && TextUtils.equals(UmaCta.ACTION_NOT_NOW, umaCta.action())) {
            button.setOnClickListener(m3553(umaCta, true));
        } else if (TextUtils.equals(UmaCta.ACTION_TYPE_BACKGROUND_CALL, umaCta.actionType()) && TextUtils.equals(UmaCta.ACTION_DISMISS, umaCta.action())) {
            button.setOnClickListener(m3553(umaCta, false));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public PublishSubject<Boolean> m3565() {
        return this.f4374;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3567(NetflixActivity netflixActivity, String str) {
        if (str != null && TextUtils.equals(UmaCta.ACTION_RETRY_PAYMENT, str)) {
            m3555((String) null, (String) null, netflixActivity, true);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private View.OnClickListener m3558(final UmaCta umaCta) {
        return new View.OnClickListener() { // from class: o.Ad.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(view.getContext(), NetflixActivity.class);
                if (netflixActivity != null && !C1317As.m3750(netflixActivity)) {
                    C1301Ad.this.m3546(umaCta, UIViewLogging.UIViewCommandName.deepLink, new C0711(1.0f, umaCta.action()));
                    NetflixApplication.getInstance().m242().m4490();
                    C1301Ad.this.m3549();
                    if (umaCta.action() != null) {
                        if (umaCta.autoLogin()) {
                            zZ.m13582(umaCta.action());
                        }
                        netflixActivity.getServiceManager().m9813();
                        if (C1301Ad.this.f4372) {
                            C1301Ad.this.m3568(true);
                        }
                        if (umaCta.openLinkInWebView()) {
                            Intent r7 = zZ.m13580(netflixActivity, umaCta.action(), umaCta.successMessage(), umaCta.failureMessage(), umaCta.autoLogin());
                            if (r7 != null) {
                                netflixActivity.startActivity(r7);
                                return;
                            }
                            return;
                        }
                        if (umaCta.autoLogin()) {
                            C1301Ad.this.m3544(netflixActivity, umaCta);
                        } else {
                            view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(umaCta.action())));
                        }
                        LocalBroadcastManager.getInstance(C1301Ad.this.getContext()).sendBroadcast(new Intent("RefreshUserMessageRequest.ACTION_DISMISS_UMA_MESSAGE"));
                        return;
                    }
                    C1276.m16820().mo5727("Invalid UMA, no link provided on cta. [uma:" + C1301Ad.this.f4361.messageId() + "/" + C1301Ad.this.f4361.messageName() + "/" + umaCta.actionType() + "]");
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m3555(final String str, final String str2, final NetflixActivity netflixActivity, final boolean z) {
        Observable<Status> r7 = netflixActivity.getServiceManager().m9807();
        if (r7 == null) {
            m3562(new C0510(AbstractC0367.f13255.toString()));
            C1276.m16820().mo5725("Retry payment rx is null, request is not sent out");
            if (z) {
                this.f4374.onError(new Throwable("Retry payment rx is null"));
                return;
            }
            if (str2 != null) {
                C1004.m15961(netflixActivity, str2, 1);
            }
            netflixActivity.getServiceManager().m9821();
            return;
        }
        r7.observeOn(AndroidSchedulers.mainThread()).take(1).takeUntil(C0965.m15784(this)).subscribe(new Observer<Status>() { // from class: o.Ad.12
            /* renamed from: ˋ  reason: contains not printable characters */
            public void onNext(Status status) {
                if (status == AbstractC0367.f13235) {
                    C1301Ad.this.m3549();
                    if (z) {
                        C1301Ad.this.f4374.onNext(true);
                    } else if (str != null) {
                        C1004.m15961(netflixActivity, str, 1);
                        LocalBroadcastManager.getInstance(C1301Ad.this.getContext()).sendBroadcast(new Intent("RefreshUserMessageRequest.ACTION_DISMISS_UMA_MESSAGE"));
                    }
                } else {
                    C1301Ad.this.m3562(new C0510(status.toString()));
                    if (z) {
                        C1301Ad.this.f4374.onNext(false);
                        return;
                    }
                    if (str2 != null) {
                        C1004.m15961(netflixActivity, str2, 1);
                        C1276.m16820().mo5727("Request (ecom-api) for Retry Payment failed");
                    }
                    netflixActivity.getServiceManager().m9821();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                C1301Ad.this.m3562(new C0510(AbstractC0367.f13241.toString()));
                C1276.m16820().mo5725("Retry Payment request rx exceptioned out");
                if (z) {
                    C1301Ad.this.f4374.onError(th);
                    return;
                }
                if (str2 != null) {
                    C1004.m15961(netflixActivity, str2, 1);
                }
                netflixActivity.getServiceManager().m9821();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private View.OnClickListener m3552(final UmaCta umaCta) {
        return new View.OnClickListener() { // from class: o.Ad.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(C1301Ad.this.getContext(), NetflixActivity.class);
                if (netflixActivity == null || C1317As.m3750(netflixActivity)) {
                    C1276.m16820().mo5725("Expected UMA view to run in a NetflixActivity");
                    return;
                }
                C1301Ad.this.m3546(umaCta, UIViewLogging.UIViewCommandName.submitCommand, new C0944(1.0f, GestureInputKind.tap));
                netflixActivity.getServiceManager().m9813();
                C1301Ad.this.m3568(true);
                C1301Ad.this.m3555(umaCta.successMessage(), umaCta.failureMessage(), netflixActivity, false);
            }
        };
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private View.OnClickListener m3543(final UmaCta umaCta) {
        return new View.OnClickListener() { // from class: o.Ad.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(view.getContext(), NetflixActivity.class);
                if (netflixActivity == null || C1317As.m3750(netflixActivity)) {
                    C1276.m16820().mo5725("Expected UMA view to run in a NetflixActivity");
                    return;
                }
                C1301Ad.this.m3546(umaCta, UIViewLogging.UIViewCommandName.submitCommand, new C0944(1.0f, GestureInputKind.tap));
                netflixActivity.getServiceManager().m9813();
                C1301Ad.this.m3568(true);
                Single<Status> r7 = netflixActivity.getServiceManager().m9797();
                if (r7 == null) {
                    C1301Ad.this.m3562(new C0510(AbstractC0367.f13255.toString()));
                    C1276.m16820().mo5725("Restart membership rx is null, request is not sent out");
                    if (umaCta.failureMessage() != null) {
                        C1004.m15961(netflixActivity, umaCta.failureMessage(), 1);
                    }
                    netflixActivity.getServiceManager().m9821();
                    return;
                }
                r7.observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<Status>() { // from class: o.Ad.5.4
                    /* renamed from: ˏ  reason: contains not printable characters */
                    public void onSuccess(Status status) {
                        if (status == AbstractC0367.f13235) {
                            C1301Ad.this.m3549();
                            if (umaCta.successMessage() != null) {
                                C1004.m15961(netflixActivity, umaCta.successMessage(), 1);
                            }
                            LocalBroadcastManager.getInstance(C1301Ad.this.getContext()).sendBroadcast(new Intent("RefreshUserMessageRequest.ACTION_DISMISS_UMA_MESSAGE"));
                            return;
                        }
                        C1301Ad.this.m3562(new C0510(status.toString()));
                        if (umaCta.failureMessage() != null) {
                            C1004.m15961(netflixActivity, umaCta.failureMessage(), 1);
                            C1276.m16820().mo5725("Request (ecom-api) for Restart Membership failed");
                        }
                        netflixActivity.getServiceManager().m9821();
                    }

                    @Override // io.reactivex.SingleObserver
                    public void onError(Throwable th) {
                        C1301Ad.this.m3562(new C0510(AbstractC0367.f13241.toString()));
                        C1276.m16820().mo5725("Restart Membership request rx exceptioned out");
                        if (umaCta.failureMessage() != null) {
                            C1004.m15961(netflixActivity, umaCta.failureMessage(), 1);
                        }
                        netflixActivity.getServiceManager().m9821();
                    }

                    @Override // io.reactivex.SingleObserver
                    public void onSubscribe(Disposable disposable) {
                    }
                });
            }
        };
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private View.OnClickListener m3553(final UmaCta umaCta, final boolean z) {
        return new View.OnClickListener() { // from class: o.Ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(view.getContext(), NetflixActivity.class);
                if (netflixActivity != null && !C1317As.m3750(netflixActivity)) {
                    C1301Ad.this.m3546(umaCta, UIViewLogging.UIViewCommandName.notifyUms, new C0944(1.0f, GestureInputKind.tap));
                    Long r7 = Logger.INSTANCE.m142(new C0617());
                    if (z) {
                        netflixActivity.getServiceManager().m9803(C1301Ad.this.f4361.messageName(), umaCta.callback());
                    }
                    netflixActivity.getServiceManager().m9813();
                    Logger.INSTANCE.m140(r7);
                    C1301Ad.this.m3549();
                    C1301Ad.this.m3568(true);
                    LocalBroadcastManager.getInstance(C1301Ad.this.getContext()).sendBroadcast(new Intent("RefreshUserMessageRequest.ACTION_DISMISS_UMA_MESSAGE"));
                } else if (view.getContext() != null) {
                    C1276.m16820().mo5725("Expected UMA view to run in a NetflixActivity");
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3544(NetflixActivity netflixActivity, final UmaCta umaCta) {
        if (netflixActivity.getServiceManager() == null || !netflixActivity.getServiceManager().mo9519()) {
            C1276.m16820().mo5727("Unable to generate token, no service. [serviceManager:" + netflixActivity.getServiceManager() + "]");
            return;
        }
        final C2154sm smVar = new C2154sm(netflixActivity);
        final NetworkErrorStatus networkErrorStatus = new NetworkErrorStatus(BK.f4581);
        final AnonymousClass4 r5 = new Runnable() { // from class: o.Ad.4
            @Override // java.lang.Runnable
            public void run() {
                smVar.m10803(null, networkErrorStatus, umaCta.action());
            }
        };
        netflixActivity.getHandler().postDelayed(r5, 10000);
        netflixActivity.getServiceManager().m9784(3600000, new AbstractC2061pj() { // from class: o.Ad.6
            @Override // o.AbstractC2061pj, o.oU
            public void onAutoLoginTokenCreated(String str, Status status) {
                NetflixActivity netflixActivity2 = (NetflixActivity) C1317As.m3755(C1301Ad.this.getContext(), NetflixActivity.class);
                if (netflixActivity2 != null && !C1317As.m3750(netflixActivity2)) {
                    netflixActivity2.getHandler().removeCallbacks(r5);
                    smVar.m10803(str, status, umaCta.action());
                }
            }
        });
    }
}
