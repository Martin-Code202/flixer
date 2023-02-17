package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class ErrorLoggingSpecification {
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

    public static ErrorLoggingSpecification getDefault() {
        ErrorLoggingSpecification errorLoggingSpecification = new ErrorLoggingSpecification();
        errorLoggingSpecification.disable = false;
        errorLoggingSpecification.disableChancePercentage = 50;
        return errorLoggingSpecification;
    }

    public int hashCode() {
        return (((this.disable ? 1231 : 1237) + 31) * 31) + this.disableChancePercentage;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ErrorLoggingSpecification errorLoggingSpecification = (ErrorLoggingSpecification) obj;
        if (this.disable == errorLoggingSpecification.disable && this.disableChancePercentage == errorLoggingSpecification.disableChancePercentage) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ErrorLoggingSpecification [implementation=" + this.implementation + ", disable=" + this.disable + ", disableChancePercentage=" + this.disableChancePercentage + "]";
    }
}
