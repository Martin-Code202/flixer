package com.amazon.drm;

import o.C1283;
public class AmazonLicenseVerificationCallback {
    private static final String TAG = "amazon";
    private static boolean called = false;

    public static synchronized void onDRMSuccess() {
        synchronized (AmazonLicenseVerificationCallback.class) {
            C1283.m16846(TAG, "onDRMSuccess called!");
            called = true;
        }
    }

    public static synchronized boolean isCalled() {
        boolean z;
        synchronized (AmazonLicenseVerificationCallback.class) {
            z = called;
        }
        return z;
    }
}
