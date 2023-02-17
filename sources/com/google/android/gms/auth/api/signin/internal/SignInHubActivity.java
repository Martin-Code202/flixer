package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
@KeepName
public class SignInHubActivity extends FragmentActivity {
    private zzy zzedd;
    private boolean zzede = false;
    private SignInConfiguration zzedf;
    private boolean zzedg;
    private int zzedh;
    private Intent zzedi;

    /* access modifiers changed from: package-private */
    public class zza implements LoaderManager.LoaderCallbacks<Void> {
        private zza() {
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzb(SignInHubActivity.this, GoogleApiClient.zzafo());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v4.content.Loader, java.lang.Object] */
        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public final /* synthetic */ void onLoadFinished(Loader<Void> loader, Void r6) {
            SignInHubActivity.this.setResult(SignInHubActivity.this.zzedh, SignInHubActivity.this.zzedi);
            SignInHubActivity.this.finish();
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public final void onLoaderReset(Loader<Void> loader) {
        }
    }

    private final void zzaar() {
        getSupportLoaderManager().initLoader(0, null, new zza());
    }

    private final void zzay(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.zzede) {
            setResult(0);
            switch (i) {
                case 40962:
                    if (intent != null) {
                        SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                        if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                            GoogleSignInAccount googleSignInAccount = signInAccount.getGoogleSignInAccount();
                            this.zzedd.zza(googleSignInAccount, this.zzedf.zzaaq());
                            intent.removeExtra("signInAccount");
                            intent.putExtra("googleSignInAccount", googleSignInAccount);
                            this.zzedg = true;
                            this.zzedh = i2;
                            this.zzedi = intent;
                            zzaar();
                            return;
                        } else if (intent.hasExtra("errorCode")) {
                            zzay(intent.getIntExtra("errorCode", 8));
                            return;
                        }
                    }
                    zzay(8);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzedd = zzy.zzbl(this);
        Intent intent = getIntent();
        if (!"com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent.getAction())) {
            String valueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            finish();
        }
        this.zzedf = (SignInConfiguration) intent.getParcelableExtra("config");
        if (this.zzedf == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
        } else if (bundle == null) {
            Intent intent2 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
            intent2.setPackage("com.google.android.gms");
            intent2.putExtra("config", this.zzedf);
            try {
                startActivityForResult(intent2, 40962);
            } catch (ActivityNotFoundException unused) {
                this.zzede = true;
                Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                zzay(17);
            }
        } else {
            this.zzedg = bundle.getBoolean("signingInGoogleApiClients");
            if (this.zzedg) {
                this.zzedh = bundle.getInt("signInResultCode");
                this.zzedi = (Intent) bundle.getParcelable("signInResultData");
                zzaar();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zzedg);
        if (this.zzedg) {
            bundle.putInt("signInResultCode", this.zzedh);
            bundle.putParcelable("signInResultData", this.zzedi);
        }
    }
}
