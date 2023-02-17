package com.netflix.mediaclient.acquisition.viewmodels;
public final class GooglePlayConstants {
    public static final String ERROR_API_TIMED_OUT = "APITimedOut";
    public static final String ERROR_APP_STORE_ACCOUNT_USED = "appStoreAccountUsed";
    public static final String ERROR_CALL_CS = "callCS";
    public static final String ERROR_GOOGLE_PLAY_FETCH_RETRY_COUNT_EXCEEDED = "googlePlayFetchRetryCountExceeded";
    public static final String ERROR_GOOGLE_PLAY_PURCHASE_RETRY_COUNT_EXCEEDED = "googlePlayPurchaseRetryCountExceeded";
    public static final String ERROR_INVALID_APP_STORE_RECEIPT = "invalidAppStoreReceipt";
    public static final String ERROR_MISSING_RECEIPT = "missingReceipt";
    public static final String ERROR_RETRY_MONEYBALL = "retryMoneyball";
    public static final GooglePlayConstants INSTANCE = new GooglePlayConstants();

    private GooglePlayConstants() {
    }
}
