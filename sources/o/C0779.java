package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import java.util.List;
/* renamed from: o.ᒑ  reason: contains not printable characters */
public class C0779 extends LinearLayout {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f14428;

    /* renamed from: ˎ  reason: contains not printable characters */
    private If f14429;

    /* renamed from: ˏ  reason: contains not printable characters */
    private View.OnClickListener f14430;

    /* renamed from: ॱ  reason: contains not printable characters */
    AbstractC2089qj f14431;

    /* renamed from: o.ᒑ$If */
    public interface If {
        /* renamed from: ˎ */
        void mo11841(AbstractC2089qj qjVar);
    }

    public C0779(Context context) {
        this(context, null);
    }

    public C0779(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0779(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14428 = 5;
        this.f14430 = new View.OnClickListener() { // from class: o.ᒑ.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0779.this.setSelected(((AbstractC2089qj) view.getTag()).getProfileGuid());
            }
        };
        m15238(attributeSet, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15238(AttributeSet attributeSet, int i) {
        setOrientation(0);
        setGravity(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.profile_selector_top_padding);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        inflate(getContext(), R.layout.add_profile_item, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.C0006.ProfileSelector, i, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                this.f14428 = obtainStyledAttributes.getInt(0, 5);
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd();
        int i3 = getChildCount() > 3 ? this.f14428 : 4;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            getChildAt(i4).getLayoutParams().width = measuredWidth / i3;
        }
        super.onMeasure(i, i2);
    }

    public void setProfiles(List<AbstractC2089qj> list, AbstractC2089qj qjVar) {
        if (list.size() > this.f14428) {
            throw new IllegalArgumentException("Max of " + this.f14428 + " profiles supported, set with app:ps_max_profiles");
        }
        this.f14431 = qjVar;
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            removeView(getChildAt(childCount));
        }
        for (AbstractC2089qj qjVar2 : list) {
            m15240(qjVar2, getChildCount() - 1, C1349Bv.m4126(qjVar2.getProfileGuid(), qjVar.getProfileGuid()));
        }
        getChildAt(getChildCount() - 1).setVisibility(list.size() < this.f14428 ? 0 : 8);
        m15239();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15239() {
        if (this.f14431 != null) {
            C0403 r2 = C0403.m14185(getContext(), R.string.accessibility_current_profile_formatter);
            r2.m14186("profile", this.f14431.getProfileName());
            setContentDescription(r2.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15240(AbstractC2089qj qjVar, int i, boolean z) {
        View inflate = inflate(getContext(), z ? R.layout.profile_item_selected : R.layout.profile_item, null);
        ((TextView) inflate.findViewById(R.id.name)).setText(qjVar.getProfileName());
        NetflixActivity.getImageLoader(getContext()).mo3057((C0522) inflate.findViewById(R.id.avatar), qjVar.getAvatarUrl(), AssetType.profileAvatar, null, StaticImgConfig.DARK, true);
        inflate.setTag(qjVar);
        C0403 r8 = C0403.m14185(getContext(), R.string.accessibility_select_profile_formatter);
        r8.m14186("profile", qjVar.getProfileName());
        inflate.setContentDescription(r8.toString());
        addView(inflate, i);
        inflate.setOnClickListener(this.f14430);
        inflate.setBackgroundResource(R.drawable.selectable_item_background);
    }

    public void setSelected(String str) {
        AbstractC2089qj qjVar = null;
        AbstractC2089qj qjVar2 = this.f14431;
        if (qjVar2 == null || !C1349Bv.m4126(qjVar2.getProfileGuid(), str)) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                AbstractC2089qj qjVar3 = (AbstractC2089qj) childAt.getTag();
                if (qjVar3 != null) {
                    if (C1349Bv.m4126(qjVar3.getProfileGuid(), str)) {
                        removeView(childAt);
                        m15240(qjVar3, i, true);
                        qjVar = qjVar3;
                    } else if (qjVar2 != null && C1349Bv.m4126(qjVar3.getProfileGuid(), qjVar2.getProfileGuid())) {
                        removeView(childAt);
                        m15240(qjVar3, i, false);
                    }
                }
            }
            this.f14431 = qjVar;
            m15239();
        }
        if (this.f14429 != null) {
            this.f14429.mo11841(qjVar);
        }
    }

    public void setAddProfileListener(View.OnClickListener onClickListener) {
        getChildAt(getChildCount() - 1).setOnClickListener(onClickListener);
    }

    public void setProfileSelectedListener(If r1) {
        this.f14429 = r1;
    }
}
