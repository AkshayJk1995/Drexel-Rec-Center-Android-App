package com.example.akshayjk.attempt1.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import com.example.akshayjk.attempt1.Helper.RegisterData;
import com.example.akshayjk.attempt1.R;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AkshayJk on 22-Nov-17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context, Object name,
                           Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    String password;
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Mydatabase.db";

    // Contacts table name
    private static final String TABLE_REGISTER = "Logins";
    public static final String KEY_FIRST_NAME = "first_name";
    public static final String KEY_lAST_NAME = "last_name";
    public static final String KEY_EMAIL_ID = "email_id";
    public static final String KEY_DOB = "DOB";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_GRAD="Grad";
    public static final String KEY_GENDER="Gender";
    public static final String KEY_STATUS="Status";
    private final String CREATE_TABLE = "CREATE TABLE " + TABLE_REGISTER + "("
            + KEY_FIRST_NAME + " TEXT, " + KEY_lAST_NAME + " TEXT, " + KEY_EMAIL_ID + " TEXT PRIMARY KEY,"
            + KEY_DOB + " TEXT, " + KEY_PASSWORD + " TEXT, " + KEY_GRAD + " TEXT, " + KEY_STATUS + " TEXT, " + KEY_GENDER +" TEXT" + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);
    }

    public void addregister(RegisterData RegisterData)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, RegisterData.getfirstName()); // register first Name
        values.put(KEY_lAST_NAME, RegisterData.getlastName()); // register last name
        values.put(KEY_EMAIL_ID, RegisterData.getEmailId());//register email id
        values.put(KEY_DOB, RegisterData.getdOB());//register mobile no
        values.put(KEY_PASSWORD, RegisterData.getPassword());
        values.put(KEY_GRAD, RegisterData.getGrad());
        values.put(KEY_STATUS, RegisterData.get_Status());
        values.put(KEY_GENDER, RegisterData.getGender());

        // Inserting Row

        db.insert(TABLE_REGISTER, null, values);
        db.close(); // Closing database connection

    }

    public List<RegisterData> getAllRegister() {
        // array of columns to fetch
        String[] columns = {
                KEY_FIRST_NAME,
                KEY_EMAIL_ID,
                KEY_PASSWORD,
                KEY_DOB
        };
        // sorting orders
        String sortOrder = KEY_FIRST_NAME + " ASC";
        List<RegisterData> userList = new ArrayList<RegisterData>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_REGISTER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RegisterData user = new RegisterData();
                user.setfirstName(cursor.getString(cursor.getColumnIndex(KEY_FIRST_NAME)));
                user.setDoB(cursor.getString(cursor.getColumnIndex(KEY_DOB)));
                user.setEmailId(cursor.getString(cursor.getColumnIndex(KEY_EMAIL_ID)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }




    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static String getTableContacts() {
        return TABLE_REGISTER;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public boolean Login(String email, String password)
    {
        String[] columns = {
                KEY_FIRST_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = KEY_EMAIL_ID + " = ?" + " AND " + KEY_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_REGISTER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean checkAcc(String email) {

        // array of columns to fetch
        String[] columns = {
                KEY_FIRST_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection =  KEY_EMAIL_ID+ " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_REGISTER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean logon(String email, String password){
        List<RegisterData> list = getAllRegister();
        if(list.isEmpty())
            return false;

        for (RegisterData registerData : list) {
            if(registerData.getEmailId().equals(email) && registerData.getPassword().equals(password))
                return true;
        }
        return false;
        }
}