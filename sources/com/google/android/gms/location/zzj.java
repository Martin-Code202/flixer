package com.google.android.gms.location;

import android.os.IInterface;
public interface zzj extends IInterface {
    void onLocationAvailability(LocationAvailability locationAvailability);

    void onLocationResult(LocationResult locationResult);
}
