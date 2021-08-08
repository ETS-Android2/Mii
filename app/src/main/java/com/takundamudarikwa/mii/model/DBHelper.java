package com.takundamudarikwa.mii.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Mii.db";

    /**
     *
     * USER's table
     * Used for storing login credentials
     */
    public static final String USERS_TABLE_NAME = "users";
    public static final String USERS_COLUMN_ID = "id";
    public static final String USERS_COLUMN_GIVENNAME = "given_name";
    public static final String USERS_COLUMN_FAMILYNAME = "family_name";
    public static final String USERS_COLUMN_EMAIL = "email";
    public static final String USERS_COLUMN_PHONENUMBER = "phone_number";

    /*public static final String PROFILE_TABLE_NAME = "profile";
    public static final String PROFILE_COLUMN_ID = "id";
    public static final String PROFILE_COLUMN_SACREDNAME = "given_name";
    public static final String PROFILE_COLUMN_SELFIMAGE = "family_name";
    public static final String PROFILE_COLUMN_HOBINTEREST = "hobbies_interests";
    public static final String PROFILE_COLUMN_HOBINTEREST2 = "hobbies_interests2";
    public static final String PROFILE_COLUMN_HOBINTEREST3 = "hobbies_interests3";
    public static final String PROFILE_COLUMN_HOBINTEREST4 = "hobbies_interests4";
    public static final String PROFILE_COLUMN_HOBINTEREST5 = "hobbies_interests5";
    public static final String PROFILE_COLUMN_HOBINTEREST6 = "hobbies_interests6";
    public static final String PROFILE_COLUMN_HOBINTEREST7 = "hobbies_interests7";
    public static final String PROFILE_COLUMN_HOBINTEREST8 = "hobbies_interests8";
    public static final String PROFILE_COLUMN_HOBINTEREST9 = "hobbies_interests9";
    public static final String PROFILE_COLUMN_IMAGE= "image";
    public static final String PROFILE_COLUMN_IMAGE2= "image2";
    public static final String PROFILE_COLUMN_IMAGE3= "image3";
    public static final String PROFILE_FOREIGN_KEY= "fk_users"

    public static final String SQL_CREATE_USERS =
            "create table users " +
            "(id integer primary key, given_name text, family_name text,phone text,email text)";

    public static final String SQL_CREATE_PROFILE =*/

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table users " +
                        "(id integer primary key, given_name text, family_name text,phone text,email text)"
        );
    }
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}

    public String createNewUser(String givenName, String familyName, String email, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put("given_name", givenName);
        contentValues.put("family_name", familyName);
        contentValues.put("email", email);
        contentValues.put("phone",phone);

        long dbInsert = db.insert("users", null, contentValues);

        if(dbInsert != -1){
            return "New user created successfully";
        }else{
            return "Sorry there was an error saving your information";
        }
    }

}
