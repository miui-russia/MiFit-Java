package com.f.a.a.a.a.a;

import cn.com.smartdevices.bracelet.ui.dW;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class f {
    final /* synthetic */ a a;
    private final String b;
    private final long[] c;
    private boolean d;
    private d e;
    private long f;

    private f(a aVar, String str) {
        this.a = aVar;
        this.b = str;
        this.c = new long[aVar.t];
    }

    private void a(String[] strArr) {
        if (strArr.length != this.a.t) {
            throw b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.c[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw b(strArr);
            }
        }
    }

    private IOException b(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File a(int i) {
        return new File(this.a.m, this.b + "." + i);
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.c) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    public File b(int i) {
        return new File(this.a.m, this.b + "." + i + dW.c);
    }
}
