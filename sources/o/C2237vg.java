package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: o.vg  reason: case insensitive filesystem */
public class C2237vg extends AbstractC0496 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AtomicBoolean f11321 = new AtomicBoolean(false);

    /* renamed from: o.vg$ˋ  reason: contains not printable characters */
    public interface AbstractC0246 {
        void onResponse(String str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C2237vg m12132(C2232vb vbVar) {
        C2237vg vgVar = new C2237vg();
        Bundle bundle = new Bundle();
        if (vbVar.m12120() != null) {
            bundle.putString("title", vbVar.m12120());
        }
        if (vbVar.m12121() != null) {
            bundle.putString(DeepErrorElement.Debug.MESSAGE, vbVar.m12121());
        }
        bundle.putInt("buttonCount", vbVar.m12119().length);
        for (int i = 0; i < vbVar.m12119().length; i++) {
            bundle.putString("buttonName" + i, (String) vbVar.m12119()[i].first);
            bundle.putString("buttonCode" + i, (String) vbVar.m12119()[i].second);
        }
        vgVar.setArguments(bundle);
        return vgVar;
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString("title");
        String string2 = getArguments().getString(DeepErrorElement.Debug.MESSAGE);
        int i = getArguments().getInt("buttonCount", 0);
        String[] strArr = new String[i];
        final String[] strArr2 = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = getArguments().getString("buttonName" + i2);
            strArr2[i2] = getArguments().getString("buttonCode" + i2);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (string != null) {
            builder.setTitle(string);
        } else {
            C1283.m16865("mdxui", "No title...");
        }
        if (string2 != null) {
            builder.setMessage(string2);
        } else {
            C1283.m16865("mdxui", "No message...");
        }
        if (i < 1) {
            C1283.m16850("mdxui", "We are expecting at least one button!");
        }
        if (i > 0) {
            builder.setPositiveButton(strArr[0], new DialogInterface.OnClickListener() { // from class: o.vg.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    synchronized (C2237vg.this.f11321) {
                        if (C2237vg.this.f11321.get()) {
                            C1283.m16865("mdxui", "Already clicked!");
                            return;
                        }
                        C2237vg.this.f11321.set(true);
                    }
                    C2237vg.this.dismissAllowingStateLoss();
                    C2237vg.this.getFragmentManager().beginTransaction().remove(C2237vg.this).commit();
                    FragmentActivity activity = C2237vg.this.getActivity();
                    if (activity instanceof AbstractC0246) {
                        ((AbstractC0246) activity).onResponse(strArr2[0]);
                    }
                }
            });
        }
        if (i > 1) {
            builder.setNegativeButton(strArr[1], new DialogInterface.OnClickListener() { // from class: o.vg.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    synchronized (C2237vg.this.f11321) {
                        if (C2237vg.this.f11321.get()) {
                            C1283.m16865("mdxui", "Already clicked!");
                            return;
                        }
                        C2237vg.this.f11321.set(true);
                    }
                    C2237vg.this.dismissAllowingStateLoss();
                    C2237vg.this.getFragmentManager().beginTransaction().remove(C2237vg.this).commit();
                    FragmentActivity activity = C2237vg.this.getActivity();
                    if (activity instanceof AbstractC0246) {
                        ((AbstractC0246) activity).onResponse(strArr2[1]);
                    }
                }
            });
        }
        if (i > 2) {
            builder.setNegativeButton(strArr[2], new DialogInterface.OnClickListener() { // from class: o.vg.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    synchronized (C2237vg.this.f11321) {
                        if (C2237vg.this.f11321.get()) {
                            C1283.m16865("mdxui", "Already clicked!");
                            return;
                        }
                        C2237vg.this.f11321.set(true);
                    }
                    C2237vg.this.dismissAllowingStateLoss();
                    C2237vg.this.getFragmentManager().beginTransaction().remove(C2237vg.this).commit();
                    FragmentActivity activity = C2237vg.this.getActivity();
                    if (activity instanceof AbstractC0246) {
                        ((AbstractC0246) activity).onResponse(strArr2[2]);
                    }
                }
            });
        }
        if (i > 3) {
            C1283.m16850("mdxui", "We can support up to 3 buttons!");
        }
        return builder.create();
    }

    @Override // o.AbstractC0496, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }
}
