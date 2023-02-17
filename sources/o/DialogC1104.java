package o;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
/* renamed from: o.忄  reason: contains not printable characters */
public class DialogC1104 extends AlertDialog {
    public DialogC1104(Context context) {
        super(context);
    }

    @Override // android.support.v7.app.AlertDialog, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        C1283.m16862("Update", "Key " + i);
        if (i == 84) {
            C1283.m16862("Update", "Ignore search key");
            return true;
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            C1283.m16862("Update", "Ignore back key");
            return true;
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.忄$iF */
    public static class iF {

        /* renamed from: ʻ  reason: contains not printable characters */
        public CharSequence f15296;

        /* renamed from: ʼ  reason: contains not printable characters */
        public CharSequence f15297;

        /* renamed from: ʽ  reason: contains not printable characters */
        public boolean f15298;

        /* renamed from: ˊ  reason: contains not printable characters */
        public Drawable f15299;

        /* renamed from: ˋ  reason: contains not printable characters */
        public CharSequence f15300;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final Context f15301;

        /* renamed from: ˏ  reason: contains not printable characters */
        public int f15302;

        /* renamed from: ˏॱ  reason: contains not printable characters */
        public DialogInterface.OnKeyListener f15303;

        /* renamed from: ॱ  reason: contains not printable characters */
        public CharSequence f15304;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        public DialogInterface.OnCancelListener f15305;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public DialogInterface.OnClickListener f15306;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public DialogInterface.OnClickListener f15307;

        private iF(Context context) {
            this.f15302 = -1;
            this.f15301 = context;
        }
    }

    /* renamed from: o.忄$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˎ  reason: contains not printable characters */
        private iF f15308;

        public Cif(Context context) {
            this.f15308 = new iF(context);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public Cif m16217(CharSequence charSequence) {
            this.f15308.f15300 = charSequence;
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public Cif m16215(int i) {
            this.f15308.f15304 = this.f15308.f15301.getText(i);
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public Cif m16214(CharSequence charSequence) {
            this.f15308.f15304 = charSequence;
            return this;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public Cif m16221(int i, DialogInterface.OnClickListener onClickListener) {
            this.f15308.f15297 = this.f15308.f15301.getText(i);
            this.f15308.f15306 = onClickListener;
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public Cif m16218(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f15308.f15297 = charSequence;
            this.f15308.f15306 = onClickListener;
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public Cif m16216(int i, DialogInterface.OnClickListener onClickListener) {
            this.f15308.f15296 = this.f15308.f15301.getText(i);
            this.f15308.f15307 = onClickListener;
            return this;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public Cif m16219(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f15308.f15296 = charSequence;
            this.f15308.f15307 = onClickListener;
            return this;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public Cif m16222(boolean z) {
            this.f15308.f15298 = z;
            return this;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public DialogC1104 m16223() {
            DialogC1104 r3 = new DialogC1104(this.f15308.f15301);
            r3.setCancelable(this.f15308.f15298);
            r3.setOnCancelListener(this.f15308.f15305);
            r3.setOnKeyListener(this.f15308.f15303);
            if (this.f15308.f15300 != null) {
                r3.setTitle(this.f15308.f15300);
            }
            if (this.f15308.f15299 != null) {
                r3.setIcon(this.f15308.f15299);
            }
            if (this.f15308.f15302 >= 0) {
                r3.setIcon(this.f15308.f15302);
            }
            if (this.f15308.f15304 != null) {
                r3.setMessage(this.f15308.f15304);
            }
            if (this.f15308.f15297 != null) {
                r3.setButton(-1, this.f15308.f15297, this.f15308.f15306);
            }
            if (this.f15308.f15296 != null) {
                r3.setButton(-2, this.f15308.f15296, this.f15308.f15307);
            }
            return r3;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public AlertDialog m16220() {
            DialogC1104 r0 = m16223();
            r0.show();
            return r0;
        }
    }
}
