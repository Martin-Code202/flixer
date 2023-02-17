package o;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
@Deprecated
/* renamed from: o.ﺏ  reason: contains not printable characters */
public abstract class AbstractC1180 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final long f15503 = TimeUnit.SECONDS.toSeconds(4);

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final long f15504 = TimeUnit.SECONDS.toSeconds(0);

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static Queue<AbstractC1180> f15505 = new LinkedList();

    /* renamed from: ʻ  reason: contains not printable characters */
    float f15506 = ((float) f15504);

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private PopupWindow.OnDismissListener f15507 = new PopupWindow.OnDismissListener() { // from class: o.ﺏ.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            AbstractC1180.this.f15516.getHandler().removeCallbacks(AbstractC1180.this.f15519);
            AbstractC1180.this.f15516.getHandler().removeCallbacks(AbstractC1180.this.f15518);
            AbstractC1180.m16415(AbstractC1180.this.f15510);
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    float f15508 = ((float) f15503);

    /* renamed from: ʽ  reason: contains not printable characters */
    TextView f15509;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    boolean f15510 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    final PopupWindow f15511;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    Advisory f15512;

    /* renamed from: ˎ  reason: contains not printable characters */
    final View f15513;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    PopupWindow.OnDismissListener f15514;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected boolean f15515;

    /* renamed from: ॱ  reason: contains not printable characters */
    NetflixActivity f15516;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    long f15517 = 0;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final Runnable f15518 = new Runnable() { // from class: o.ﺏ.4
        @Override // java.lang.Runnable
        public void run() {
            AbstractC1180.this.mo16431();
        }
    };

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final Runnable f15519 = new Runnable() { // from class: o.ﺏ.2
        @Override // java.lang.Runnable
        public void run() {
            AbstractC1180.this.f15517 = SystemClock.uptimeMillis();
            if (AbstractC1180.this.f15520 != null) {
                AbstractC1180.this.f15511.showAsDropDown(AbstractC1180.this.f15520, 0, 0);
            } else {
                AbstractC1180.this.f15511.showAtLocation(AbstractC1180.this.f15516.findViewById(16908290), 8388659, 0, 0);
            }
            AbstractC1180.this.f15516.getHandler().postDelayed(AbstractC1180.this.f15518, ((long) AbstractC1180.this.f15508) * TimeUnit.SECONDS.toMillis(1));
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    View f15520;

    /* renamed from: ᐝ  reason: contains not printable characters */
    TextView f15521;

    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract int mo16421();

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract int mo16424();

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract int mo16426();

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public View m16429() {
        return this.f15513;
    }

    protected AbstractC1180(NetflixActivity netflixActivity, Advisory advisory) {
        String str;
        ExpiringContentAdvisory expiringContentAdvisory;
        int i;
        this.f15516 = netflixActivity;
        this.f15512 = advisory;
        this.f15513 = ((LayoutInflater) netflixActivity.getSystemService("layout_inflater")).inflate(mo16424(), (ViewGroup) null);
        this.f15511 = new PopupWindow(this.f15513, -1, -2);
        this.f15511.setOutsideTouchable(false);
        this.f15511.setBackgroundDrawable(null);
        this.f15511.setOnDismissListener(this.f15507);
        this.f15511.setInputMethodMode(2);
        this.f15509 = (TextView) this.f15513.findViewById(mo16426());
        this.f15521 = (TextView) this.f15513.findViewById(mo16421());
        View findViewById = this.f15513.findViewById(mo16426());
        if (findViewById != null) {
            findViewById.setVisibility(4);
        }
        View findViewById2 = this.f15513.findViewById(mo16421());
        if (findViewById2 != null) {
            findViewById2.setVisibility(4);
        }
        if (advisory != null) {
            if (advisory instanceof ExpiringContentAdvisory) {
                switch (((ExpiringContentAdvisory) advisory).contentType) {
                    case SERIES:
                        i = R.string.expiring_content_warning_series;
                        break;
                    case SHOW:
                        i = R.string.expiring_content_warning_show;
                        break;
                    case SEASON:
                        i = R.string.expiring_content_warning_season;
                        break;
                    default:
                        i = R.string.expiring_content_warning_movie;
                        break;
                }
                str = netflixActivity.getResources().getString(i, expiringContentAdvisory.localizedDate);
            } else {
                str = advisory.getMessage();
            }
            m16420(str).m16423(advisory.getSecondaryMessage()).m16425(advisory.getDelay()).m16422(advisory.getDuration());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m16408() {
        m16406();
        f15505.clear();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static void m16416() {
        if (!f15505.isEmpty()) {
            f15505.peek().mo16427();
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo16431() {
        m16410();
        if (this.f15514 != null) {
            this.f15514.onDismiss();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m16406() {
        if (!f15505.isEmpty()) {
            f15505.peek().m16417();
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m16417() {
        this.f15510 = true;
        m16410();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m16410() {
        if (this.f15511.isShowing()) {
            this.f15511.dismiss();
            this.f15516.setLifeCycleListener(null);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public Advisory m16418() {
        return this.f15512;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static <T extends AbstractC1180> T m16407(NetflixActivity netflixActivity, Advisory advisory) {
        switch (advisory.getType()) {
            case CONTENT_ADVISORY:
                return new C1142(netflixActivity, advisory);
            case EXPIRY_NOTICE:
                return new C1184(netflixActivity, advisory);
            case PRODUCT_PLACEMENT_ADVISORY:
            default:
                return new C1247(netflixActivity, advisory);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1180 m16420(String str) {
        if (this.f15509 != null && !TextUtils.isEmpty(str)) {
            this.f15509.setText(str);
            ViewUtils.m3002((View) this.f15509, true);
        }
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC1180 m16423(String str) {
        if (this.f15521 != null && !TextUtils.isEmpty(str)) {
            this.f15521.setText(str);
            ViewUtils.m3002((View) this.f15521, true);
            this.f15515 = true;
        }
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1180 m16425(float f) {
        this.f15506 = f;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1180 m16419(PopupWindow.OnDismissListener onDismissListener) {
        this.f15514 = onDismissListener;
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC1180 m16422(float f) {
        this.f15508 = f;
        return this;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m16430() {
        m16413(false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m16411(AbstractC1180 r8) {
        return r8 == null || r8.m16418() == null || ((long) ((r8.m16418().getDuration() * ((float) TimeUnit.SECONDS.toMillis(1))) + ((float) r8.f15517))) - SystemClock.uptimeMillis() < 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m16415(boolean z) {
        if (!f15505.isEmpty()) {
            if (m16411(f15505.peek())) {
                C1283.m16854("AdvisorToast", "hasShownEnough...");
                f15505.remove();
            } else {
                return;
            }
        }
        if (!z && !f15505.isEmpty()) {
            AbstractC1180 peek = f15505.peek();
            if (peek == null) {
                f15505.remove();
                m16415(false);
                return;
            }
            peek.mo16427();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m16413(boolean z) {
        if (!f15505.contains(this)) {
            f15505.offer(this);
        }
        if (f15505.size() == 1 && z) {
            mo16427();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void mo16427() {
        this.f15510 = false;
        this.f15516.getHandler().postDelayed(this.f15519, ((long) this.f15506) * TimeUnit.SECONDS.toMillis(1));
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean m16428() {
        return this.f15511.isShowing();
    }
}
