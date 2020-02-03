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
    private static final String DB_NAME = "Univ";
    private static final String T_Univ = "tb_notes";

    private static final String ID = "id_universitas";
    private static final String NAMA = "nama_universitas";
    private static final String AKRE = "akreditas";
    private static final String STATUS = "status";
    private static final String JENIS = "jenis";
    private static final String ALAMAT = "alamat";
    private static final String KOTA = "kota";
    private static final String PROV = "provinsi";
    private static final String WEBSITE = "website";
    private static final String SINGKAT = "singkat";


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        String query = "CREATE TABLE " + T_Univ + " (" +
                ID + " INTEGER PRIMARY KEY, " +
                NAMA + " TEXT, " +
                AKRE + " TEXT, " +
                STATUS + " TEXT, " +
                JENIS + " TEXT, " +
                ALAMAT + " TEXT, " +
                KOTA + " TEXT, " +
                PROV + " TEXT, " +
                WEBSITE + " TEXT, " +
                SINGKAT + " TEXT" +")";
        Log.d("Data", "onCreate: " + query);
        db.execSQL(query);


        query = "insert into tb_notes values(1,'Institut Teknologi Bandung','A','PTN-BH','NEGERI','Jl. Ganesha no 10 Siliwangi','Kota Bandung','Provinsi Jawa Barat','itb.ac.id','(ITB)')";
        db.execSQL(query);
        query = "insert into tb_notes values(2,'Universitas Gadjah Mada','A','PTN-BH','NEGERI','Jl. Bulaksumur','Kota Sleman','Provinsi D I Yogyakarta','ugm.ac.id','(UGM)')";
        db.execSQL(query);
        query = "insert into tb_notes values(3,'Institut Pertanian Bogor','A','PTN-BH','NEGERI','Jl. Pajajaran','Kota Bogor','Provinsi Jawa Barat','ipb.ac.id','(IPB)')";
        db.execSQL(query);
        query = "insert into tb_notes values(4,'Institut Teknologi Sepuluh November','A','PTN-BH','NEGERI','Jl. Raya Keputih','Kota Surabaya','Provinsi Jawa Timur','its.ac.id','(ITS)')";
        db.execSQL(query);
        query = "insert into tb_notes values(5,'Universitas Indonesia','A','PTN-BH','NEGERI','Jl. Margonda Raya','Kota Depok','Provinsi Jawa Barat','ui.ac.id','(UI)')";
        db.execSQL(query);
        query = "insert into tb_notes values(6,'Universitas Diponegoro','A','PTN-BH','NEGERI','Jl. Prof. Soedarto SH','Kota Semarang','Provinsi Jawa Tengah','undip.ac.id','(Undip)')";
        db.execSQL(query);
        query = "insert into tb_notes values(7,'Universitas Airlangga','A','PTN-BH','NEGERI','Jl. Airlangga No 4-6','Kota Surabaya','Provinsi Jawa Timur','unair.ac.id','(Unair)')";
        db.execSQL(query);
        query = "insert into tb_notes values(8,'Universitas Hasanuddin','A','PTN-BH','NEGERI','Jl. Perintis Kemerdekaan','Kota Makasar','Provinsi Sulawesi Selatan','unhas.ac.id','(Unhas)')";
        db.execSQL(query);
        query = "insert into tb_notes values(9,'Universitas Brawijaya','A','PTN-BLU','NEGERI','Jl. Veteran','Kota Malang','Provinsi Jawa Timur','ub.ac.id','(UB)')";
        db.execSQL(query);
        query = "insert into tb_notes values(10,'Universitas Padjajaran','A','PTN-BH','NEGERI','Jl. Raya Bandung','Kota Sumedang','Provinsi Jawa Barat','unpat.ac.id','(Unpad)')";
        db.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + T_Univ);

        onCreate(db);
    }
    public List<UnivModel> getUniv() {
        List<UnivModel> univList = new ArrayList<>();
        String query = "SELECT * FROM " + T_Univ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String akreditas = cursor.getString(2);
                String status = cursor.getString(3);
                String jenis = cursor.getString(4);
                String alamat = cursor.getString(5);
                String kota = cursor.getString(6);
                String provinsi = cursor.getString(7);
                String website = cursor.getString(8);
                String singkat = cursor.getString(9);

                UnivModel UnivModel = new UnivModel(id, nama, akreditas, status, jenis, alamat, kota, provinsi, website, singkat);

                univList.add(UnivModel);
            } while (cursor.moveToNext());
        }

        return univList;
    }
}
