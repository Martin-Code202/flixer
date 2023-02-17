package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class BreadcrumbLoggingSpecification {
    private static final boolean DEFAULT_DISABLE = false;
    private static final int DEFAULT_DISABLE_CHANCE_PERCENTAGE = 50;
    private static String TAG = "nf_log";
    @SerializedName("disable")
    private boolean disable;
    @SerializedName("disableChancePercentage")
    private int disableChancePercentage;
    @SerializedName("implementation")
    private String implementation;

    public String getImplementation() {
        return this.implementation;
    }

    public boolean isDisabled() {
        return this.disable;
    }

    public int getDisableChancePercentage() {
        return this.disableChancePercentage;
    }

    public static BreadcrumbLoggingSpecification getDefault() {
        BreadcrumbLoggingSpecification breadcrumbLoggingSpecification = new BreadcrumbLoggingSpecification();
        breadcrumbLoggingSpecification.disable = false;
        breadcrumbLoggingSpecification.disableChancePercentage = 50;
        return breadcrumbLoggingSpecification;
    }

    public int hashCode() {
        return (((((this.disable ? 1231 : 1237) + 31) * 31) + this.disableChancePercentage) * 31) + (this.implementation == null ? 0 : this.implementation.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BreadcrumbLoggingSpecification breadcrumbLoggingSpecification = (BreadcrumbLoggingSpecification) obj;
        if (this.disable != breadcrumbLoggingSpecification.disable || this.disableChancePercentage != breadcrumbLoggingSpecification.disableChancePercentage) {
            return false;
        }
        if (this.implementation == null) {
            if (breadcrumbLoggingSpecification.implementation != null) {
                return false;
            }
            return true;
        } else if (!this.implementation.equals(breadcrumbLoggingSpecification.implementation)) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return "BreadcrumbLoggingSpecification [implementation=" + this.implementation + ", disable=" + this.disable + ", disableChancePercentage=" + this.disableChancePercentage + "]";
    }
}
