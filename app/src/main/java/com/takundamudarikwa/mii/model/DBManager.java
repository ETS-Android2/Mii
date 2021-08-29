package com.takundamudarikwa.mii.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private Context context;
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    public DBManager(Context c) {
        this.context = c;
    }

    public DBManager open() throws SQLException {
        this.dbHelper = new SQLiteHelper(this.context);
        this.database = this.dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.dbHelper.close();
    }

    public String insertintoUsers(String givenName, String familyName, String email, String phone) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(SQLiteHelper.USERS_COLUMN_GIVENNAME, givenName);
        contentValue.put(SQLiteHelper.USERS_COLUMN_FAMILYNAME, familyName);
        contentValue.put(SQLiteHelper.USERS_COLUMN_EMAIL, email);
        contentValue.put(SQLiteHelper.USERS_COLUMN_PHONENUMBER, phone);
        long dbInsert = this.database.insert(SQLiteHelper.USERS_TABLE_NAME, null, contentValue);

        if (dbInsert != -1) {
            return "New user created successfully";
        } else {
            return "Sorry there was an error saving your information";
        }
    }

    public String insertintoProfile(String sacredName, String selfImage,String handb,String handb2,String handb3,String handb4,String handb5,String handb6,String handb7,String handb8,String handb9) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_SACREDNAME, sacredName);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_SELFIMAGE, selfImage);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST, handb);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST2, handb2);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST3, handb3);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST4, handb4);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST5, handb5);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST6, handb6);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST7, handb7);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST8, handb8);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST9, handb9);
        long dbInsert = this.database.insert(SQLiteHelper.PROFILE_TABLE_NAME, null, contentValues);

        if (dbInsert != -1) {
            return "Profile saved successfully";
        } else {
            return "Sorry there was an error saving your information";
        }
    }


    public Cursor fetchUser() {
        Cursor cursor = this.database.query(SQLiteHelper.USERS_TABLE_NAME, new String[]{SQLiteHelper.USERS_COLUMN_ID, SQLiteHelper.USERS_COLUMN_EMAIL, SQLiteHelper.USERS_PREV_ACCESS}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchProfile() {
        Cursor cursor = this.database.query(SQLiteHelper.PROFILE_TABLE_NAME, new String[]{SQLiteHelper.PROFILE_COLUMN_ID, SQLiteHelper.PROFILE_COLUMN_SACREDNAME, SQLiteHelper.PROFILE_COLUMN_SELFIMAGE, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST2, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST3, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST4, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST5, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST6, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST7, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST8, SQLiteHelper.PROFILE_COLUMN_HOBINTEREST9}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int updateProfile(int id,String sacredName, String selfImage,String handb,String handb2,String handb3,String handb4,String handb5,String handb6,String handb7,String handb8,String handb9) {
        ContentValues contentValues = new ContentValues();
        /*contentValues.put(SQLiteHelper.PROFILE_COLUMN_SACREDNAME, sacredName);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_SELFIMAGE, selfImage);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST, handb);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST2, handb2);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST3, handb3);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST4, handb4);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST5, handb5);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST6, handb6);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST7, handb7);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST8, handb8);
        contentValues.put(SQLiteHelper.PROFILE_COLUMN_HOBINTEREST9, handb9);*/
        return this.database.update(SQLiteHelper.PROFILE_TABLE_NAME, contentValues, "id = " + id, null);
    }

    public void deleteUsers(long _id) {
        this.database.delete(SQLiteHelper.USERS_TABLE_NAME, "id=" + _id, null);
    }
}