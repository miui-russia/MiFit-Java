package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<BusLineItem> {
    a() {
    }

    public BusLineItem a(Parcel parcel) {
        return new BusLineItem(parcel);
    }

    public BusLineItem[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
