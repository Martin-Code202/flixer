package o;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import o.DialogC1104;
/* renamed from: o.ь  reason: contains not printable characters */
public final class C0505 {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static DialogC1104.Cif m14493(Context context, String str, String str2, Handler handler, String str3, Runnable runnable, Runnable runnable2) {
        return m14490(context, str, str2, handler, str3, runnable, null, null, true, runnable2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static DialogC1104.Cif m14492(Context context, Handler handler, C1278 r13, Runnable runnable) {
        if (!(r13 instanceof If)) {
            return m14493(context, r13.f15977, r13.f15979, handler, r13.f15978, r13.f15980, runnable);
        }
        If r10 = (If) r13;
        return m14490(context, r10.f15977, r10.f15979, handler, r10.f15978, r10.f15980, r10.f13633, r10.f13634, false, runnable);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static DialogC1104.Cif m14491(Context context, Handler handler, C1278 r3) {
        return m14492(context, handler, r3, null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Spannable m14487(String str) {
        if (C1349Bv.m4113(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str.replaceAll("netflix.com/changeplan.", "netflix.com/changeplan"));
        try {
            Linkify.addLinks(spannableString, 15);
        } catch (Throwable th) {
            C1283.m16847("nf_dialog", "SPY-10546: Unable to add links to spannable", th);
        }
        return spannableString;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static DialogC1104.Cif m14490(Context context, String str, String str2, final Handler handler, String str3, final Runnable runnable, String str4, final Runnable runnable2, boolean z, final Runnable runnable3) {
        String str5;
        String str6;
        DialogC1104.Cif ifVar = new DialogC1104.Cif(context);
        ifVar.m16217(m14489(str));
        ifVar.m16214(m14487(str2));
        if (str3 != null) {
            str5 = str3;
        } else {
            str5 = context.getString(R.string.label_ok);
        }
        if (str4 != null) {
            str6 = str4;
        } else {
            str6 = context.getString(R.string.label_cancel);
        }
        if (handler != null) {
            ifVar.m16218(str5, new DialogInterface.OnClickListener() { // from class: o.ь.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (runnable != null) {
                        handler.post(runnable);
                    }
                    if (runnable3 != null) {
                        handler.post(runnable3);
                    }
                }
            });
            if (!z) {
                ifVar.m16219(str6, new DialogInterface.OnClickListener() { // from class: o.ь.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (runnable2 != null) {
                            handler.post(runnable2);
                        }
                        if (runnable3 != null) {
                            handler.post(runnable3);
                        }
                    }
                });
            }
        } else {
            ifVar.m16218(str5, (DialogInterface.OnClickListener) null);
            if (!z) {
                ifVar.m16219(str6, null);
            }
        }
        return ifVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m14489(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /* renamed from: o.ь$If */
    public static class If extends C1278 {

        /* renamed from: ˊ  reason: contains not printable characters */
        String f13633;

        /* renamed from: ॱ  reason: contains not printable characters */
        Runnable f13634;

        public If(String str, String str2, String str3, Runnable runnable, String str4, Runnable runnable2) {
            super(str, str2, str3, runnable);
            this.f13633 = str4;
            this.f13634 = runnable2;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m14488(Dialog dialog) {
        TextView textView = (TextView) dialog.findViewById(16908299);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
