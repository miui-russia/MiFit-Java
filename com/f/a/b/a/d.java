package com.f.a.b.a;

import java.io.FilterInputStream;
import java.io.InputStream;

public class d extends FilterInputStream {
    public d(InputStream inputStream) {
        super(inputStream);
    }

    public long skip(long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = this.in.skip(j - j2);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j2 = skip + j2;
        }
        return j2;
    }
}