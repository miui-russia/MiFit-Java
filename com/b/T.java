package com.b;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class T extends FilterOutputStream {
    final /* synthetic */ S a;

    private T(S s, OutputStream outputStream) {
        this.a = s;
        super(outputStream);
    }

    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            this.a.d = true;
        }
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.a.d = true;
        }
    }

    public void write(int i) {
        try {
            this.out.write(i);
        } catch (IOException e) {
            this.a.d = true;
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            this.a.d = true;
        }
    }
}
