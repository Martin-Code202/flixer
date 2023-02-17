package o;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.rs  reason: case insensitive filesystem */
public class C2130rs extends BaseAdapter {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f9939 = R.color.transparent;

    /* renamed from: ˋ  reason: contains not printable characters */
    private If f9940;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<pS> f9941 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f9942;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f9943 = -1;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f9944 = -1;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f9945 = -1;

    /* renamed from: o.rs$If */
    public interface If {
        /* renamed from: ॱ */
        View mo10407(ViewGroup viewGroup);
    }

    public C2130rs(NetflixActivity netflixActivity, If r3) {
        this.f9942 = netflixActivity;
        this.f9940 = r3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9941.size();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public pS getItem(int i) {
        if (i >= 0 && i < getCount()) {
            return this.f9941.get(i);
        }
        C1283.m16865("SeasonsSpinnerAdapter", "Position requested (" + i + ") is outside of count: " + getCount());
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m10476(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (i == getItem(i2).getSeasonNumber()) {
                C1283.m16846("SeasonsSpinnerAdapter", "Found season index: " + i2);
                return i2;
            }
        }
        return getCount() > 0 ? 0 : -1;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (textView == null) {
            textView = (TextView) this.f9940.mo10407(viewGroup);
        }
        m10469(viewGroup);
        viewGroup.setOverScrollMode(2);
        if (this.f9944 != -1) {
            textView.setBackgroundResource(this.f9944);
        }
        if (this.f9945 != -1) {
            textView.setTextColor(viewGroup.getResources().getColor(this.f9945));
        }
        textView.setText(getItem(i).getTitle());
        return textView;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10469(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setId(R.id.season_selector_list);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (textView == null) {
            textView = (TextView) this.f9940.mo10407(viewGroup);
        }
        pS r3 = getItem(i);
        if (r3 != null) {
            textView.setTag(Integer.valueOf(r3.getSeasonNumber()));
            textView.setText(r3.getTitle());
        } else {
            m10470(i);
        }
        textView.setBackgroundResource(viewGroup instanceof C2133rv ? R.color.transparent : this.f9939);
        if (this.f9943 != -1) {
            textView.setTextColor(viewGroup.getResources().getColor(this.f9943));
        } else {
            textView.setTextColor(BrowseExperience.m1767((Activity) C1322Av.m3791(viewGroup.getContext(), Activity.class), (int) R.attr.seasonSpinnerItemsTextColor));
        }
        return textView;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m10470(int i) {
        if (this.f9942 instanceof AbstractActivityC0360) {
            Fragment r4 = ((AbstractActivityC0360) this.f9942).mo10792();
            if (r4 instanceof C2116re) {
                String format = String.format("SPY-8698, null season found, show id = %s , position = %d", ((C2116re) r4).m10385(), Integer.valueOf(i));
                C1283.m16850("SeasonsSpinnerAdapter", format);
                C1276.m16820().mo5727(format);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10477(List<pS> list) {
        this.f9941.clear();
        this.f9941.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10475(int i) {
        this.f9939 = i;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10472(int i) {
        this.f9943 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10474(int i) {
        this.f9944 = i;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m10471(int i) {
        this.f9945 = i;
    }
}
