package o;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.IVoip;
import com.netflix.mediaclient.util.ViewUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
/* access modifiers changed from: package-private */
/* renamed from: o.Am  reason: case insensitive filesystem */
public class C1311Am {

    /* renamed from: ʻ  reason: contains not printable characters */
    private View[] f4456;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final View f4457;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f4458;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final View f4459;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final TextView f4460;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final View f4461;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final AudioManager f4462;

    /* renamed from: ʿ  reason: contains not printable characters */
    private int f4463;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final View f4464;

    /* renamed from: ˉ  reason: contains not printable characters */
    private CompositeDisposable f4465 = new CompositeDisposable();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final TextView f4466;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private int f4467;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final Handler f4468 = new Handler();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f4469;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private int f4470;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final TextView f4471;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private int f4472;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private final View.OnTouchListener f4473 = new View.OnTouchListener() { // from class: o.Am.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    C1311Am.this.m3656(view, true);
                    return false;
                case 1:
                    C1311Am.this.m3656(view, false);
                    return false;
                default:
                    return false;
            }
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f4474;

    /* renamed from: ˌ  reason: contains not printable characters */
    private final Runnable f4475 = new Runnable() { // from class: o.Am.7
        @Override // java.lang.Runnable
        public void run() {
            if (C1317As.m3750(C1311Am.this.f4476)) {
                C1283.m16854("VoipActivity", "timer update exit");
                return;
            }
            C1311Am.this.m3654();
            C1311Am.this.m3660(1000);
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ActivityC1313Ao f4476;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ImageView f4477;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final FloatingActionButton f4478;

    /* renamed from: ͺ  reason: contains not printable characters */
    private ToneGenerator f4479;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final TextView f4480;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1351Bx f4481;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final View f4482;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final TableLayout f4483;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final ImageView f4484;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final View f4485;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final ImageView f4486;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final TextView f4487;

    @TargetApi(23)
    C1311Am(ActivityC1313Ao ao) {
        this.f4476 = ao;
        this.f4463 = this.f4476.getResources().getInteger(R.integer.ripple_anim_time_ms);
        this.f4471 = (TextView) this.f4476.findViewById(R.id.customerSupportDialerHeaderCallStatus1);
        this.f4466 = (TextView) this.f4476.findViewById(R.id.customerSupportDialerHeaderCallStatus2);
        this.f4477 = (ImageView) this.f4476.findViewById(R.id.customerSupportDialerHeaderSpeakerIcon);
        this.f4465.add(C0965.m15783(this.f4477).debounce(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Object>() { // from class: o.Am.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Object obj) {
                C1311Am.this.m3649();
            }
        }));
        this.f4480 = (TextView) this.f4476.findViewById(R.id.customerSupportDialerHeaderSpeakerLabel);
        this.f4465.add(C0965.m15783(this.f4480).debounce(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Object>() { // from class: o.Am.5
            @Override // io.reactivex.functions.Consumer
            public void accept(Object obj) {
                C1311Am.this.m3649();
            }
        }));
        this.f4460 = (TextView) this.f4476.findViewById(R.id.customerSupportDialerHeaderDuration);
        this.f4486 = (ImageView) this.f4476.findViewById(R.id.customerSupportDialerHeaderMicIcon);
        this.f4484 = (ImageView) this.f4476.findViewById(R.id.customerSupportDialerHeaderDialPadIcon);
        this.f4464 = this.f4476.findViewById(R.id.customerSupportDialerHeaderDialPadLabel);
        m3675(false);
        this.f4457 = this.f4476.findViewById(R.id.dialerPadContainer);
        this.f4485 = this.f4476.findViewById(R.id.dialerStatusContainer);
        this.f4482 = this.f4476.findViewById(R.id.dialerButtonsContainer);
        this.f4461 = this.f4476.findViewById(R.id.loading_view);
        this.f4459 = this.f4476.findViewById(R.id.customerSupportDialerHeaderSpeakerContainer);
        this.f4478 = (FloatingActionButton) this.f4476.findViewById(R.id.customerSupportCancelFab);
        this.f4483 = (TableLayout) this.f4476.findViewById(R.id.dialpad);
        this.f4487 = (TextView) this.f4476.findViewById(R.id.customerSupportDialpadStatus);
        if (m3663()) {
            this.f4487.setVisibility(0);
        }
        try {
            this.f4479 = new ToneGenerator(0, 100);
        } catch (Throwable th) {
            C1283.m16847("VoipActivity", "Failed to initiate tone generator", th);
        }
        m3684();
        this.f4462 = (AudioManager) m3653().getSystemService("audio");
        this.f4458 = (this.f4476 == null || this.f4476.m3733() == null) ? this.f4462.isSpeakerphoneOn() : this.f4476.m3733().mo1544();
        this.f4469 = (this.f4476 == null || this.f4476.m3733() == null || !this.f4476.m3733().mo1541()) ? false : true;
        this.f4481 = new C1351Bx();
        if (C1317As.m3758() > 22) {
            this.f4470 = ao.getColor(R.color.contact_us_dialer_primary_color);
            this.f4472 = ao.getColor(R.color.contact_us_dialer_pad_primary_color);
            this.f4467 = ao.getColor(R.color.contact_us_dialer_status_selected_color);
        } else {
            this.f4470 = ao.getResources().getColor(R.color.contact_us_dialer_primary_color);
            this.f4472 = ao.getResources().getColor(R.color.contact_us_dialer_pad_primary_color);
            this.f4467 = ao.getResources().getColor(R.color.contact_us_dialer_status_selected_color);
        }
        m3650();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m3692() {
        this.f4465.dispose();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3675(boolean z) {
        m3665(this.f4476, z, this.f4484, R.drawable.ic_dialpad_btn);
        this.f4464.setEnabled(z);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m3650() {
        if (this.f4476.isTablet()) {
            C1283.m16854("VoipActivity", "Tablet: hide speaker option");
            if (this.f4459 != null) {
                this.f4459.setVisibility(8);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3657(boolean z) {
        if (this.f4456 != null && this.f4456.length >= 1) {
            View[] viewArr = this.f4456;
            for (View view : viewArr) {
                view.setEnabled(z);
                view.setAlpha(z ? 1.0f : 0.25f);
            }
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m3684() {
        this.f4456 = new View[12];
        this.f4456[0] = this.f4476.findViewById(R.id.button0);
        this.f4456[1] = this.f4476.findViewById(R.id.button1);
        this.f4456[2] = this.f4476.findViewById(R.id.button2);
        this.f4456[3] = this.f4476.findViewById(R.id.button3);
        this.f4456[4] = this.f4476.findViewById(R.id.button4);
        this.f4456[5] = this.f4476.findViewById(R.id.button5);
        this.f4456[6] = this.f4476.findViewById(R.id.button6);
        this.f4456[7] = this.f4476.findViewById(R.id.button7);
        this.f4456[8] = this.f4476.findViewById(R.id.button8);
        this.f4456[9] = this.f4476.findViewById(R.id.button9);
        this.f4456[10] = this.f4476.findViewById(R.id.buttonstar);
        this.f4456[11] = this.f4476.findViewById(R.id.buttonpound);
        for (View view : this.f4456) {
            view.setOnTouchListener(this.f4473);
        }
        m3657(this.f4476.getServiceManager().m9787() != null && this.f4476.getServiceManager().m9787().mo1446());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3656(View view, boolean z) {
        switch (view.getId()) {
            case R.id.button0 /* 2131427475 */:
                m3673(R.id.button0, '0', z, 0);
                return;
            case R.id.button1 /* 2131427476 */:
                m3673(R.id.button1, '1', z, 1);
                return;
            case R.id.button2 /* 2131427477 */:
                m3673(R.id.button2, '2', z, 2);
                return;
            case R.id.button3 /* 2131427478 */:
                m3673(R.id.button3, '3', z, 3);
                return;
            case R.id.button4 /* 2131427479 */:
                m3673(R.id.button4, '4', z, 4);
                return;
            case R.id.button5 /* 2131427480 */:
                m3673(R.id.button5, '5', z, 5);
                return;
            case R.id.button6 /* 2131427481 */:
                m3673(R.id.button6, '6', z, 6);
                return;
            case R.id.button7 /* 2131427482 */:
                m3673(R.id.button7, '7', z, 7);
                return;
            case R.id.button8 /* 2131427483 */:
                m3673(R.id.button8, '8', z, 8);
                return;
            case R.id.button9 /* 2131427484 */:
                m3673(R.id.button9, '9', z, 9);
                return;
            case R.id.buttonPanel /* 2131427485 */:
            case R.id.button_0 /* 2131427486 */:
            case R.id.button_1 /* 2131427487 */:
            case R.id.button_2 /* 2131427488 */:
            case R.id.button_3 /* 2131427489 */:
            case R.id.button_container /* 2131427490 */:
            case R.id.button_play_pause_toggle /* 2131427491 */:
            case R.id.buttons /* 2131427493 */:
            default:
                return;
            case R.id.buttonpound /* 2131427492 */:
                m3673(R.id.buttonpound, '#', z, 11);
                return;
            case R.id.buttonstar /* 2131427494 */:
                m3673(R.id.buttonstar, '*', z, 10);
                return;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3673(int i, char c, boolean z, int i2) {
        TextView textView = (TextView) this.f4476.findViewById(i);
        if (z) {
            this.f4476.m3733().mo1546(c);
            if (this.f4479 != null) {
                this.f4479.startTone(i2);
            }
        } else {
            this.f4476.m3733().mo1542();
            if (this.f4479 != null) {
                this.f4479.stopTone();
            }
        }
        m3661(i, c, z);
        if (textView == null) {
            C1283.m16865("VoipActivity", "Button label not found!");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3661(int i, char c, boolean z) {
        if (C1317As.m3758() < 21) {
            C1283.m16854("VoipActivity", "Sets color to label for pre L devices...");
            if (z) {
                m3674(i, this.f4467);
            } else {
                m3674(i, Character.isDigit(c) ? this.f4470 : this.f4472);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3674(int i, int i2) {
        TextView textView = (TextView) this.f4476.findViewById(i);
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3688() {
        this.f4485.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.Am.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (AD.m3307(C1311Am.this.f4476)) {
                    int measuredHeight = C1311Am.this.f4485.getMeasuredHeight();
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(measuredHeight, measuredHeight);
                    layoutParams.gravity = 1;
                    C1311Am.this.f4457.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(measuredHeight, -2);
                    layoutParams2.gravity = 1;
                    C1311Am.this.f4482.setLayoutParams(layoutParams2);
                } else {
                    int measuredWidth = C1311Am.this.f4485.getMeasuredWidth();
                    int measuredHeight2 = C1311Am.this.f4485.getMeasuredHeight() + C1311Am.this.f4482.getMeasuredHeight();
                    int measuredHeight3 = measuredWidth + C1311Am.this.f4482.getMeasuredHeight();
                    if (measuredHeight3 > measuredHeight2) {
                        measuredWidth = (measuredWidth - measuredHeight3) + measuredHeight2;
                    }
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(measuredWidth, measuredWidth);
                    layoutParams3.gravity = 1;
                    C1311Am.this.f4457.setLayoutParams(layoutParams3);
                }
                ViewUtils.m3009(C1311Am.this.f4485, this);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3690(boolean z) {
        m3669();
        m3676();
        this.f4474 = z;
        m3681();
        if (this.f4474) {
            m3679();
        }
        m3657(z);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m3681() {
        C1283.m16854("VoipActivity", "Update call status...");
        if (this.f4474) {
            m3675(true);
            this.f4471.setText(this.f4476.getString(R.string.label_cs_dialer_status_connected1));
            this.f4466.setText(this.f4476.getString(R.string.label_cs_dialer_status_connected2));
            this.f4460.setVisibility(0);
            this.f4461.setVisibility(8);
            if (m3663()) {
                m3670();
                return;
            }
            return;
        }
        m3675(false);
        this.f4471.setText(this.f4476.getString(R.string.label_cs_dialer_status_connecting1));
        this.f4466.setText(this.f4476.getString(R.string.label_cs_dialer_status_connecting2));
        this.f4460.setVisibility(8);
        this.f4461.setVisibility(0);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean m3663() {
        return (m3653() == null || m3653().getServiceManager() == null || m3653().getServiceManager().m9827() == null || m3653().getServiceManager().m9827().mo16527() == null || !m3653().getServiceManager().m9827().mo16527().isOpenDialpadByDefault()) ? false : true;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m3669() {
        if (this.f4486 != null) {
            this.f4469 = (this.f4476 == null || this.f4476.m3733() == null || !this.f4476.m3733().mo1541()) ? false : true;
            m3662(new Runnable() { // from class: o.Am.3
                @Override // java.lang.Runnable
                public void run() {
                    if (C1311Am.this.f4469) {
                        C1311Am.this.f4486.setImageResource(R.drawable.ic_mic_btn_selected);
                        C1311Am.this.f4486.setSelected(true);
                        return;
                    }
                    C1311Am.this.f4486.setImageResource(R.drawable.ic_mic_btn);
                    C1311Am.this.f4486.setSelected(false);
                }
            }, this.f4463);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m3691() {
        return this.f4469;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3662(Runnable runnable, int i) {
        if (C1317As.m3758() >= 21) {
            this.f4468.postDelayed(runnable, (long) i);
        } else {
            runnable.run();
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m3676() {
        if (!this.f4476.isTablet() && this.f4477 != null) {
            this.f4458 = (this.f4476 == null || this.f4476.m3733() == null) ? this.f4462.isSpeakerphoneOn() : this.f4476.m3733().mo1544();
            m3662(new Runnable() { // from class: o.Am.10
                @Override // java.lang.Runnable
                public void run() {
                    if (C1311Am.this.f4458) {
                        C1311Am.this.f4477.setImageResource(R.drawable.ic_speakerphone_btn_selected);
                        C1311Am.this.f4477.setSelected(true);
                        return;
                    }
                    C1311Am.this.f4477.setImageResource(R.drawable.ic_speakerphone_btn);
                    C1311Am.this.f4477.setSelected(false);
                }
            }, this.f4463);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3693() {
        C1283.m16854("VoipActivity", "Call started!");
        m3690(false);
        this.f4474 = false;
        if (this.f4476.m3733().mo1540()) {
            C1283.m16854("VoipActivity", "Success on starting call");
        } else {
            C1283.m16850("VoipActivity", "Failed to start call");
            this.f4476.m3732(null, null, -1);
        }
        this.f4457.setVisibility(8);
        this.f4485.setVisibility(0);
        m3675(false);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m3694() {
        C1283.m16854("VoipActivity", "Call is connected");
        this.f4474 = true;
        m3681();
        m3657(true);
        m3685();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m3686() {
        C1283.m16854("VoipActivity", "Call is ringing");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m3687() {
        this.f4474 = false;
        m3681();
        m3682();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m3689(View view) {
        if (view == null) {
            C1283.m16850("VoipActivity", "DialScreen:: null view? This should never happen!");
            return true;
        }
        switch (view.getId()) {
            case R.id.customerSupportCancelFab /* 2131427607 */:
                m3658();
                return true;
            case R.id.customerSupportCancelMyAccountLink /* 2131427608 */:
            case R.id.customerSupportChatFab /* 2131427609 */:
            case R.id.customerSupportDialFab /* 2131427610 */:
            case R.id.customerSupportDialerButtonsContainer /* 2131427611 */:
            case R.id.customerSupportDialerHeader /* 2131427612 */:
            case R.id.customerSupportDialerHeaderCallStatus1 /* 2131427613 */:
            case R.id.customerSupportDialerHeaderCallStatus2 /* 2131427614 */:
            case R.id.customerSupportDialerHeaderDialPadContainer /* 2131427615 */:
            case R.id.customerSupportDialerHeaderDuration /* 2131427618 */:
            case R.id.customerSupportDialerHeaderMicContainer /* 2131427619 */:
            default:
                return false;
            case R.id.customerSupportDialerHeaderDialPadIcon /* 2131427616 */:
            case R.id.customerSupportDialerHeaderDialPadLabel /* 2131427617 */:
                m3670();
                return true;
            case R.id.customerSupportDialerHeaderMicIcon /* 2131427620 */:
            case R.id.customerSupportDialerHeaderMicLabel /* 2131427621 */:
                m3678();
                return true;
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m3658() {
        C1283.m16854("VoipActivity", "Cancel call by user");
        if (this.f4476 != null) {
            this.f4476.m3734();
            if (this.f4476.m3733() != null) {
                this.f4476.m3733().mo1538();
            }
            this.f4476.mo1548((IVoip.Cif) null);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m3670() {
        final boolean z = this.f4457.getVisibility() == 0;
        if (z) {
            C1283.m16854("VoipActivity", "Dialpad was visible, remove it!");
            this.f4485.setVisibility(0);
            this.f4457.setVisibility(8);
        } else {
            C1283.m16854("VoipActivity", "Dialpad was NOT visible, show it!");
            this.f4485.setVisibility(8);
            this.f4457.setVisibility(0);
        }
        m3662(new Runnable() { // from class: o.Am.9
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    C1311Am.this.f4484.setImageResource(R.drawable.ic_dialpad_btn);
                    C1311Am.this.f4484.setSelected(false);
                    return;
                }
                C1311Am.this.f4484.setImageResource(R.drawable.ic_dialpad_btn_selected);
                C1311Am.this.f4484.setSelected(true);
            }
        }, this.f4463);
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m3678() {
        if (this.f4469) {
            C1283.m16854("VoipActivity", "Unmute");
        } else {
            C1283.m16854("VoipActivity", "Mute");
        }
        this.f4469 = !this.f4469;
        if (!(this.f4476 == null || this.f4476.m3733() == null)) {
            this.f4476.m3733().mo1543(this.f4469);
        }
        m3669();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m3649() {
        if (this.f4458) {
            C1283.m16854("VoipActivity", "Set speaker from on to off");
        } else {
            C1283.m16854("VoipActivity", "Set speaker from off to on");
        }
        this.f4458 = !this.f4458;
        if (!(this.f4476 == null || this.f4476.m3733() == null)) {
            this.f4476.m3733().mo1545(this.f4458);
        }
        m3676();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m3682() {
        C1283.m16854("VoipActivity", "Stop timer...");
        this.f4468.removeCallbacks(this.f4475);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m3685() {
        C1283.m16854("VoipActivity", "Start timer...");
        this.f4468.post(this.f4475);
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m3679() {
        m3682();
        m3685();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3660(int i) {
        this.f4468.removeCallbacks(this.f4475);
        this.f4468.postDelayed(this.f4475, (long) i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˈ  reason: contains not printable characters */
    private synchronized void m3654() {
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.f4476.m3733().mo1430());
        this.f4460.setText(this.f4481.m4133(currentTimeMillis));
        this.f4487.setText(m3653().getString(R.string.label_cs_dialpad_status_connected, new Object[]{this.f4481.m4133(currentTimeMillis)}));
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    private ActivityC1313Ao m3653() {
        return this.f4476;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m3665(Context context, boolean z, ImageView imageView, int i) {
        imageView.setEnabled(z);
        Drawable drawable = context.getResources().getDrawable(i);
        imageView.setImageDrawable(z ? drawable : m3671(drawable));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Drawable m3671(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        mutate.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return mutate;
    }
}
