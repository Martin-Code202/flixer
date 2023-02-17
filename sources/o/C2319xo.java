package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import com.netflix.cl.Logger;
import com.netflix.cl.model.event.session.DebugSession;
import com.netflix.mediaclient.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import org.json.JSONObject;
/* renamed from: o.xo  reason: case insensitive filesystem */
public final class C2319xo extends AbstractC0496 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final String f12232 = f12232;

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final String f12233 = f12233;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Cif f12234 = new Cif(null);

    /* renamed from: ʼ  reason: contains not printable characters */
    private Long f12235;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private HashMap f12236;

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        m12961();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m12961() {
        if (this.f12236 != null) {
            this.f12236.clear();
        }
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(f12234.m12964()) : null;
        String string2 = arguments != null ? arguments.getString(f12234.m12962()) : null;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(string).setMessage(string2).setCancelable(false).setPositiveButton(R.string.label_ok, new DialogInterface$OnClickListenerC2320iF(this)).create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new If(this));
        Long l = this.f12235;
        if (l != null) {
            l.longValue();
            Logger.INSTANCE.m129(this.f12235);
        }
        this.f12235 = Logger.INSTANCE.m142(new DebugSession(new JSONObject(), DebugSession.DebugSessionType.AppRestartError));
        C1457Fr.m5016((Object) create, "dialog");
        return create;
    }

    /* renamed from: o.xo$iF  reason: case insensitive filesystem */
    static final class DialogInterface$OnClickListenerC2320iF implements DialogInterface.OnClickListener {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C2319xo f12238;

        DialogInterface$OnClickListenerC2320iF(C2319xo xoVar) {
            this.f12238 = xoVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f12238.m12957();
        }
    }

    /* renamed from: o.xo$If */
    static final class If implements DialogInterface.OnKeyListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2319xo f12237;

        If(C2319xo xoVar) {
            this.f12237 = xoVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            C1457Fr.m5016((Object) keyEvent, "event");
            if (keyEvent.getAction() != 1) {
                return false;
            }
            this.f12237.m12957();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private final void m12957() {
        Logger.INSTANCE.m140(this.f12235);
        AbstractApplicationC1258.getInstance().mo252(m14476(), "RestartAppDialog");
    }

    /* renamed from: o.xo$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final String m12964() {
            return C2319xo.f12233;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private final String m12962() {
            return C2319xo.f12232;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final C2319xo m12966(String str, String str2) {
            C1457Fr.m5025(str, C2319xo.f12233);
            C1457Fr.m5025(str2, C2319xo.f12232);
            C2319xo xoVar = new C2319xo();
            Bundle bundle = new Bundle();
            bundle.putString(m12964(), str);
            bundle.putString(m12962(), str2);
            xoVar.setArguments(bundle);
            return xoVar;
        }
    }
}
