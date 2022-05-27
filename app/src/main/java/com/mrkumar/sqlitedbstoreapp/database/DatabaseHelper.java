package com.mrkumar.sqlitedbstoreapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import androidx.annotation.Nullable;

import com.mrkumar.sqlitedbstoreapp.model.ResponseApiItem;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ApiData.TABLE_NAME + " (" +
                    ApiData._ID + " INTEGER PRIMARY KEY," +
                    ApiData.COLUMN_NAME_NAME + " TEXT," +
                    ApiData.COLUMN_NAME_REALNAME + " TEXT," +
                    ApiData.COLUMN_NAME_CREATED + " TEXT," +
                    ApiData.COLUMN_NAME_IAMGEURL + " TEXT," +
                    ApiData.COLUMN_NAME_PUBLISHER + " TEXT," +
                    ApiData.COLUMN_NAME_TEAM + " TEXT," +
                    ApiData.COLUMN_NAME_BIO + " TEXT," +
                    ApiData.COLUMN_NAME_APPERENCE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ApiData.TABLE_NAME;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Heroes.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME ,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean insert(List<ResponseApiItem> responseApiItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Log.d("TAG", "insert: "+responseApiItem.size());
        for (int i= 0;i <responseApiItem.size() ; i++){
            contentValues.put(ApiData.COLUMN_NAME_NAME, responseApiItem.get(i).getName());
            contentValues.put(ApiData.COLUMN_NAME_REALNAME, responseApiItem.get(i).getRealname());
            contentValues.put(ApiData.COLUMN_NAME_CREATED, responseApiItem.get(i).getCreatedby());
            contentValues.put(ApiData.COLUMN_NAME_BIO, responseApiItem.get(i).getBio());
            contentValues.put(ApiData.COLUMN_NAME_APPERENCE, responseApiItem.get(i).getFirstappearance());
            contentValues.put(ApiData.COLUMN_NAME_TEAM, responseApiItem.get(i).getTeam());
            contentValues.put(ApiData.COLUMN_NAME_PUBLISHER, responseApiItem.get(i).getPublisher());
            contentValues.put(ApiData.COLUMN_NAME_IAMGEURL, responseApiItem.get(i).getImageurl());
            db.insert(ApiData.TABLE_NAME, null, contentValues);
        }

        return true;
    }

    public List<ResponseApiItem> getAllHeros() {
        List heroList = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + ApiData.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ResponseApiItem data = new ResponseApiItem();
                data.setId(Integer.parseInt(cursor.getString(0)));
                data.setName(cursor.getString(1));
                data.setRealname(cursor.getString(2));
                data.setCreatedby(cursor.getString(3));
                data.setImageurl(cursor.getString(4));
                data.setPublisher(cursor.getString(5));
                data.setTeam(cursor.getString(6));
                data.setBio(cursor.getString(7));
                data.setFirstappearance(cursor.getString(8));

                // Adding country to list
                heroList.add(data);
            } while (cursor.moveToNext());

        }

        // return country list
        return heroList;
    }



        /* Inner class that defines the table contents */
        public static class ApiData implements BaseColumns {
            public static final String TABLE_NAME = "heroes";
            public static final String COLUMN_NAME_NAME = "name";
            public static final String COLUMN_NAME_REALNAME = "realname";
            public static final String COLUMN_NAME_TEAM = "team";
            public static final String COLUMN_NAME_APPERENCE = "firstappearance";
            public static final String COLUMN_NAME_CREATED = "createdby";
            public static final String COLUMN_NAME_PUBLISHER = "publisher";
            public static final String COLUMN_NAME_IAMGEURL = "imageurl";
            public static final String COLUMN_NAME_BIO = "bio";

        }
}
