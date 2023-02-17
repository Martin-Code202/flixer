package com.google.android.gms.location;

import android.location.Location;
import android.os.IInterface;
public interface zzm extends IInterface {
    void onLocationChanged(Location location);
}
