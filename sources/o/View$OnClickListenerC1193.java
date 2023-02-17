package o;

import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.ui.search.SearchUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ﺣ  reason: contains not printable characters */
public class View$OnClickListenerC1193 implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0574 f15577;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final NetflixActivity f15578;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final qK f15579;

    public View$OnClickListenerC1193(NetflixActivity netflixActivity, qK qKVar) {
        this.f15578 = netflixActivity;
        this.f15579 = qKVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag(R.id.video_details_click_listener);
        if (tag == null) {
            C1283.m16865("VideoDetailsClickListener", "No video details for click listener to use");
            return;
        }
        pJ pJVar = (pJ) tag;
        oX r5 = this.f15579.mo1635();
        if (this.f15577 != null) {
            C1300Ac.m3531(new C1080(AppView.boxArt, this.f15577), new C0642(), true);
        }
        if (view instanceof C1210) {
            m16459((C1210) view);
        }
        mo11180(this.f15578, pJVar, r5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public void mo11180(NetflixActivity netflixActivity, pJ pJVar, oX oXVar) {
        qU.m9974(netflixActivity, pJVar, oXVar, "DeetsClickListener");
        SearchUtils.m2922(pJVar, SearchUtils.SuggestionType.BROWSE_HISTORY, netflixActivity);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Object tag = view.getTag(R.id.video_details_click_listener);
        if (tag == null) {
            return false;
        }
        C1362Ch.m4394("onLongClick", (IClientLogging.ModalView) null, (JSONObject) null);
        C1004.m15961(this.f15578, ((pJ) tag).getTitle(), 0);
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16460(View view) {
        C1283.m16846("VideoDetailsClickListener", "Removing click listeners");
        view.setOnClickListener(null);
        view.setOnLongClickListener(null);
        view.setTag(R.id.video_details_click_listener, null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16462(View view, pJ pJVar) {
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        view.setTag(R.id.video_details_click_listener, pJVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16461(View view, pJ pJVar, AbstractC0574 r3) {
        m16462(view, pJVar);
        this.f15577 = r3;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16459(C1210 r9) {
        String r6 = r9.m16496();
        C1283.m16851("VideoDetailsClickListener", "VideoDetailsOnClick is reporting to CL...  boxArtUIState is %s", r6);
        try {
            C1364Cj.m4441(UIViewLogging.UIViewCommandName.viewTitleDetails, null, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap, new JSONObject().put("boxArtUIState", r6));
        } catch (JSONException e) {
            C1283.m16847("VideoDetailsClickListener", "VideoDetailsOnClick had exception", e);
            C1276.m16820().mo5730(e);
        }
    }
}
