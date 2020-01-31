package com.example.projecttest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DBUniv";
    private static final String T_Univ = "tb_notes";

    private static final String KEY_ID = "id_univ";
    private static final String KEY_NAMA = "nama_univ";
    private static final String KEY_AKRE = "akre";
    private static final String KEY_STATUS = "status";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + T_Univ + " (" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAMA + " TEXT, " +
                KEY_AKRE + " TEXT, " +
                KEY_STATUS + " TEXT" + ")";
        Log.d("Data", "onCreate: " + query);
        db.execSQL(query);

        query = "insert into tb_notes values(1,'itb','hadfne','xcvxcvxcvxc')";
        db.execSQL(query);
        query = "insert into tb_notes values(2,'UNG','sdfsdfdsfsxczxc','xcvxcvxcvxc')";
        db.execSQL(query);
        query = "insert into tb_notes values(3,'UI','sdfsdfdsfsxczxc','xcvxcvxcvxc')";
        db.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + T_Univ);

        onCreate(db);
    }
    public List<UnivModel> getNotes() {
        List<UnivModel> noteList = new ArrayList<>();
        String query = "SELECT * FROM " + T_Univ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String desc = cursor.getString(2);
                String date = cursor.getString(3);

                UnivModel UnivModel = new UnivModel(id, title, desc, date);

                noteList.add(UnivModel);
            } while (cursor.moveToNext());
        }

        return noteList;
    }
}
