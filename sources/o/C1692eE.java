package o;

import android.content.Intent;
import com.netflix.mediaclient.service.logging.client.model.Event;
/* renamed from: o.eE  reason: case insensitive filesystem */
public final class C1692eE {

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC1689eB f6459;

    C1692eE(AbstractC1689eB eBVar) {
        this.f6459 = eBVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6051(Intent intent) {
        if (!intent.hasCategory("com.netflix.mediaclient.intent.category.MDX")) {
            C1283.m16850("nf_mdx", "handleCommandIntent:intent is not for mdx, " + intent.getCategories());
            return;
        }
        String action = intent.getAction();
        if (C1349Bv.m4113(action)) {
            C1283.m16850("nf_mdx", "handleCommandIntent:intent doesn't have action, " + intent.toString());
            return;
        }
        String stringExtra = intent.getStringExtra("uuid");
        if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_GETCAPABILITY")) {
            this.f6459.mo6038(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_GETSTATE")) {
            this.f6459.mo6040(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAY")) {
            String stringExtra2 = intent.getStringExtra("catalogId");
            int intExtra = intent.getIntExtra("trackId", -1);
            String stringExtra3 = intent.getStringExtra("episodeId");
            boolean booleanExtra = intent.getBooleanExtra("previewPinProtected", false);
            int intExtra2 = intent.getIntExtra("time", -1);
            if (intExtra == -1) {
                C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", invalid parameters");
            } else {
                this.f6459.mo6043(stringExtra, stringExtra2, intExtra, stringExtra3, intExtra2, booleanExtra);
            }
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_PAUSE")) {
            this.f6459.mo6042(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_RESUME")) {
            this.f6459.mo6044(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_SEEK")) {
            int intExtra3 = intent.getIntExtra("time", -1);
            if (intExtra3 == -1) {
                C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", invalid parameters");
            } else {
                this.f6459.mo6039(stringExtra, intExtra3);
            }
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_SKIP")) {
            int intExtra4 = intent.getIntExtra("time", -1);
            if (intExtra4 == -1) {
                C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", invalid parameters");
            } else {
                this.f6459.mo6036(stringExtra, intExtra4);
            }
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_STOP")) {
            this.f6459.mo6035(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_SETAUDIOSUB")) {
            String stringExtra4 = intent.getStringExtra("audioTrackId");
            String stringExtra5 = intent.getStringExtra("subtitleTrackId");
            if (C1349Bv.m4113(stringExtra4) || C1349Bv.m4113(stringExtra5)) {
                C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", invalid parameters");
            } else {
                this.f6459.mo6037(stringExtra, stringExtra4, stringExtra5);
            }
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_SETVOLUME")) {
            int intExtra5 = intent.getIntExtra("volume", -1);
            if (intExtra5 == -1) {
                C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", invalid parameters");
            } else {
                this.f6459.mo6045(stringExtra, intExtra5);
            }
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_AUTOADV")) {
            int intExtra6 = intent.getIntExtra("speed", -1);
            if (intExtra6 == -1) {
                C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", invalid parameters");
            } else {
                this.f6459.mo6041(stringExtra, intExtra6);
            }
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_METADATA")) {
            String stringExtra6 = intent.getStringExtra("catalogId");
            String stringExtra7 = intent.getStringExtra("episodeId");
            String stringExtra8 = intent.getStringExtra("type");
            if (C1349Bv.m4113(stringExtra6) || C1349Bv.m4113(stringExtra7)) {
                C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", invalid parameters");
            } else {
                this.f6459.mo6047(stringExtra, stringExtra6, stringExtra7, stringExtra8);
            }
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_DIALOGRESP")) {
            String stringExtra9 = intent.getStringExtra("uid");
            String stringExtra10 = intent.getStringExtra(Event.DATA);
            if (C1349Bv.m4113(stringExtra9) || C1349Bv.m4113(stringExtra10)) {
                C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", invalid parameters");
            } else {
                this.f6459.mo6046(stringExtra, stringExtra9, stringExtra10);
            }
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_GETAUDIOSUB")) {
            this.f6459.mo6048(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_PINCONFIRMED")) {
            this.f6459.mo6033(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_PINCANCELLED")) {
            this.f6459.mo6032(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_STOPPOSTPALY")) {
            this.f6459.mo6049(stringExtra);
        } else if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_SKIP_INTRO")) {
            this.f6459.mo6034(stringExtra);
        } else {
            C1283.m16850("nf_mdx", "handleCommandIntent: " + action + ", unknown command");
        }
    }
}
