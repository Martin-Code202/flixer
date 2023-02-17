package org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.io.IOException;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
public class HttpNegotiateAuthenticator {
    static final /* synthetic */ boolean $assertionsDisabled = (!HttpNegotiateAuthenticator.class.desiredAssertionStatus());
    private final String mAccountType;
    private Bundle mSpnegoContext;

    /* access modifiers changed from: package-private */
    public native void nativeSetResult(long j, int i, String str);

    /* access modifiers changed from: package-private */
    public static class RequestData {
        public Account account;
        public AccountManager accountManager;
        public String authTokenType;
        public long nativeResultObject;
        public Bundle options;

        RequestData() {
        }
    }

    /* access modifiers changed from: package-private */
    public class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final RequestData mRequestData;

        public GetAccountsCallback(RequestData requestData) {
            this.mRequestData = requestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> accountManagerFuture) {
            try {
                Account[] result = accountManagerFuture.getResult();
                if (result.length == 0) {
                    Log.w("net_auth", "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -341, null);
                } else if (result.length > 1) {
                    Log.w("net_auth", "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", Integer.valueOf(result.length));
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -341, null);
                } else if (HttpNegotiateAuthenticator.this.lacksPermission(ContextUtils.getApplicationContext(), "android.permission.USE_CREDENTIALS", true)) {
                    Log.e("net_auth", "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: USE_CREDENTIALS permission not granted. Aborting authentication.", new Object[0]);
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -343, null);
                } else {
                    this.mRequestData.account = result[0];
                    this.mRequestData.accountManager.getAuthToken(this.mRequestData.account, this.mRequestData.authTokenType, this.mRequestData.options, true, (AccountManagerCallback<Bundle>) new GetTokenCallback(this.mRequestData), new Handler(ThreadUtils.getUiThreadLooper()));
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.w("net_auth", "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", e);
                HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -9, null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final RequestData mRequestData;

        public GetTokenCallback(RequestData requestData) {
            this.mRequestData = requestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            try {
                Bundle result = accountManagerFuture.getResult();
                if (result.containsKey("intent")) {
                    final Context applicationContext = ContextUtils.getApplicationContext();
                    applicationContext.registerReceiver(new BroadcastReceiver() { // from class: org.chromium.net.HttpNegotiateAuthenticator.GetTokenCallback.1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            applicationContext.unregisterReceiver(this);
                            GetTokenCallback.this.mRequestData.accountManager.getAuthToken(GetTokenCallback.this.mRequestData.account, GetTokenCallback.this.mRequestData.authTokenType, GetTokenCallback.this.mRequestData.options, true, (AccountManagerCallback<Bundle>) new GetTokenCallback(GetTokenCallback.this.mRequestData), (Handler) null);
                        }
                    }, new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
                    return;
                }
                HttpNegotiateAuthenticator.this.processResult(result, this.mRequestData);
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.w("net_auth", "ERR_UNEXPECTED: Error while attempting to obtain a token.", e);
                HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -9, null);
            }
        }
    }

    protected HttpNegotiateAuthenticator(String str) {
        if ($assertionsDisabled || !TextUtils.isEmpty(str)) {
            this.mAccountType = str;
            return;
        }
        throw new AssertionError();
    }

    @CalledByNative
    static HttpNegotiateAuthenticator create(String str) {
        return new HttpNegotiateAuthenticator(str);
    }

    /* access modifiers changed from: package-private */
    @CalledByNative
    public void getNextAuthToken(long j, String str, String str2, boolean z) {
        if ($assertionsDisabled || str != null) {
            Context applicationContext = ContextUtils.getApplicationContext();
            RequestData requestData = new RequestData();
            requestData.authTokenType = "SPNEGO:HOSTBASED:" + str;
            requestData.accountManager = AccountManager.get(applicationContext);
            requestData.nativeResultObject = j;
            String[] strArr = {"SPNEGO"};
            requestData.options = new Bundle();
            if (str2 != null) {
                requestData.options.putString("incomingAuthToken", str2);
            }
            if (this.mSpnegoContext != null) {
                requestData.options.putBundle("spnegoContext", this.mSpnegoContext);
            }
            requestData.options.putBoolean("canDelegate", z);
            Activity lastTrackedFocusedActivity = ApplicationStatus.getLastTrackedFocusedActivity();
            if (lastTrackedFocusedActivity == null) {
                requestTokenWithoutActivity(applicationContext, requestData, strArr);
            } else {
                requestTokenWithActivity(applicationContext, lastTrackedFocusedActivity, requestData, strArr);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processResult(Bundle bundle, RequestData requestData) {
        int i;
        this.mSpnegoContext = bundle.getBundle("spnegoContext");
        switch (bundle.getInt("spnegoResult", 1)) {
            case 0:
                i = 0;
                break;
            case 1:
                i = -9;
                break;
            case 2:
                i = -3;
                break;
            case 3:
                i = -342;
                break;
            case 4:
                i = -320;
                break;
            case 5:
                i = -338;
                break;
            case 6:
                i = -339;
                break;
            case 7:
                i = -341;
                break;
            case 8:
                i = -344;
                break;
            case 9:
                i = -329;
                break;
            default:
                i = -9;
                break;
        }
        nativeSetResult(requestData.nativeResultObject, i, bundle.getString("authtoken"));
    }

    private void requestTokenWithoutActivity(Context context, RequestData requestData, String[] strArr) {
        if (lacksPermission(context, "android.permission.GET_ACCOUNTS", true)) {
            Log.e("net_auth", "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: GET_ACCOUNTS permission not granted. Aborting authentication.", new Object[0]);
            nativeSetResult(requestData.nativeResultObject, -343, null);
            return;
        }
        requestData.accountManager.getAccountsByTypeAndFeatures(this.mAccountType, strArr, new GetAccountsCallback(requestData), new Handler(ThreadUtils.getUiThreadLooper()));
    }

    private void requestTokenWithActivity(Context context, Activity activity, RequestData requestData, String[] strArr) {
        boolean z = Build.VERSION.SDK_INT < 23;
        String str = z ? "android.permission.MANAGE_ACCOUNTS" : "android.permission.GET_ACCOUNTS";
        if (lacksPermission(context, str, z)) {
            Log.e("net_auth", "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: %s permission not granted. Aborting authentication", str);
            nativeSetResult(requestData.nativeResultObject, -343, null);
            return;
        }
        requestData.accountManager.getAuthTokenByFeatures(this.mAccountType, requestData.authTokenType, strArr, activity, null, requestData.options, new GetTokenCallback(requestData), new Handler(ThreadUtils.getUiThreadLooper()));
    }

    /* access modifiers changed from: package-private */
    public boolean lacksPermission(Context context, String str, boolean z) {
        return (!z || Build.VERSION.SDK_INT < 23) && context.checkPermission(str, Process.myPid(), Process.myUid()) != 0;
    }
}
