package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;

public class ai extends SQLiteOpenHelper {
    static final String a = c.b;
    static final String b = c.d;
    static final String c = GroupItemBaseInfo.KEY_COUNT;
    static final String d = "d";
    static final String e = GroupItemBaseInfo.KEY_END_TIME;
    static final String f = "a1";
    static final String g = "a2";
    static final String h = "a3";
    static final String i = "a4";
    static final String j = "a5";
    static final String k = "a6";
    static final String l = "b1";
    static final String m = "b2";
    static final String n = "b3";
    static final String o = "c1";
    static final String p = "c2";
    static final String q = "c3";
    private static final String r = ("CREATE TABLE IF NOT EXISTS " + a + " (_id integer primary key autoincrement, " + f + "  varchar(20), " + g + " varchar(10)," + h + " varchar(50)," + i + " varchar(100)," + j + " varchar(20)," + k + " integer);");
    private static final String s = ("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement," + l + " varchar(40), " + m + " integer," + n + "  integer," + f + "  varchar(20));");
    private static final String t = ("CREATE TABLE IF NOT EXISTS " + e + " (_id integer primary key autoincrement," + o + " integer," + p + " integer," + q + " integer);");

    public ai(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(r);
            sQLiteDatabase.execSQL(String.format(s, new Object[]{b}));
            sQLiteDatabase.execSQL(String.format(s, new Object[]{c}));
            sQLiteDatabase.execSQL(String.format(s, new Object[]{d}));
            sQLiteDatabase.execSQL(t);
        } catch (Throwable th) {
            az.a(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
