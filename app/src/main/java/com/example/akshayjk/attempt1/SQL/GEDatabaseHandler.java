package com.example.akshayjk.attempt1.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.akshayjk.attempt1.Helper.GroupData;
import com.example.akshayjk.attempt1.Helper.RegisterData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by AkshayJk on 01-Dec-17.
 */

public class GEDatabaseHandler extends SQLiteOpenHelper {

    public GEDatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final String datatbase="mydatabase.db";
    private static final String table_name1="geregistry3";
    private static final int database_version=1;

    public static final String email="email_id";
    public static final String group_name="group_name";
    public static final String doe="doe";
    public static final String timing="timing";
    private static final String create_table1="CREATE TABLE " + table_name1 + "( " + email+" TEXT, "+group_name+" TEXT, "+doe+" NUMBER, "+timing+" TEXT "+ ");";

    private static final String table_name2="getypes2";
    public static final String group_name1="group_name";
    public static final String timings="timing";
    private static final String create_table2="CREATE TABLE "+ table_name2+"( "+group_name1+" TEXT, "+timings+" TEXT, "+ doe+" NUMBER );";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table2);
        db.execSQL(create_table1);
        fillGetypes(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name2);
        db.execSQL("DROP TABLE IF EXISTS " + table_name1);

        // Create tables again
        onCreate(db);

    }

    public void fillGetypes(SQLiteDatabase db){
        String[] types={"Bodypump", "Barre", "Cycle 45"};
        int[] times={1200,1230,1630,1700,1730,1745,1830,1900,1930};
        String[] day={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
;
        ContentValues values = new ContentValues();
        values.put(group_name1,types[0]);
        values.put(timings,times[0]);
        values.put(doe,day[0]);
        db.insert(table_name2, null, values);;


        values=new ContentValues();
        values.put(group_name1,types[0]);
        values.put(timings,times[4]);
        values.put(doe,day[0]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[0]);
        values.put(timings,times[3]);
        values.put(doe,day[1]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[0]);
        values.put(timings,times[4]);
        values.put(doe,day[2]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[0]);
        values.put(timings,times[8]);
        values.put(doe,day[3]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[0]);
        values.put(timings,times[0]);
        values.put(doe,day[4]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[0]);
        values.put(timings,times[2]);
        values.put(doe,day[4]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[1]);
        values.put(timings,times[0]);
        values.put(doe,day[0]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[1]);
        values.put(timings,times[3]);
        values.put(doe,day[1]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[1]);
        values.put(timings,times[6]);
        values.put(doe,day[3]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[1]);
        values.put(timings,times[5]);
        values.put(doe,day[4]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[2]);
        values.put(timings,times[4]);
        values.put(doe,day[0]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[2]);
        values.put(timings,times[6]);
        values.put(doe,day[0]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[2]);
        values.put(timings,times[0]);
        values.put(doe,day[1]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[2]);
        values.put(timings,times[6]);
        values.put(doe,day[1]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[2]);
        values.put(timings,times[3]);
        values.put(doe,day[2]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[2]);
        values.put(timings,times[2]);
        values.put(doe,day[3]);
        db.insert(table_name2, null, values);;

        values=new ContentValues();
        values.put(group_name1,types[2]);
        values.put(timings,times[0]);
        values.put(doe,day[4]);
        db.insert(table_name2, null, values);;
    }

    public void addRegister(GroupData groupData){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(email,groupData.getEmailId());
        values.put(group_name,groupData.getgroup());
        values.put(doe,groupData.getdOB());
        values.put(timing,groupData.gettiming());
        // Inserting Row
        try {
            db.execSQL("INSERT INTO "+table_name1+" VALUES(?,?,?,?)",new String[]{groupData.getEmailId(),groupData.getgroup(),groupData.getdOB(),String.valueOf(groupData.gettiming())});
            db.close(); // Closing database connection
        }catch (Exception e){
            e.printStackTrace();
        }
        /*
        */
    }

    public boolean isTableExists(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+table_name1+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

    public List<GroupData> getAllRegister(){
        String[] columns = {
                "*"
        };
        SQLiteDatabase db = this.getReadableDatabase();

        List<GroupData> groupData=new ArrayList<>();
        // query user table with condition
        Cursor cursor = db.query(table_name1, //Table to query
                columns,                    //columns to return
                null,                  //columns for the WHERE clause
                null,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount=0;
        if(cursor.moveToFirst()){
            do {
                GroupData user = new GroupData();
                user.setEmailId(cursor.getString(cursor.getColumnIndex(email)));
                user.setDoB(cursor.getString(cursor.getColumnIndex(doe)));
                user.settiming(Integer.parseInt(cursor.getString(cursor.getColumnIndex(timings))));
                user.setgroup(cursor.getString(cursor.getColumnIndex(group_name1)));
                // Adding user record to list
                groupData.add(user);
            } while (cursor.moveToNext());
        }
        if(cursor!=null && !cursor.isClosed()){
            cursorCount=cursor.getCount();
            cursor.close();
        }
        db.close();


        return groupData;
    }

    public int checkcount(String exgroup, String Doe, int timing){
        String[] columns = {
                "*"
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection =  group_name+ " = ? AND "+doe+" = ? AND " +timings+" = ?";

        // selection argument
        String[] selectionArgs = {exgroup,Doe, String.valueOf(timing)};

        // query user table with condition
        Cursor cursor = db.query(table_name1, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount=0;
        if(cursor!=null && !cursor.isClosed()){
            cursorCount=cursor.getCount();
            cursor.close();
        }
        db.close();

        return cursorCount;
    }

    public int checkexists(String email, String exgroup, String Doe, int timing){
        String[] columns = {
                "*"
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection =  this.email+" = ? AND "+group_name+ " = ? AND "+doe+" = ? AND " +timings+" = ?";

        // selection argument
        String[] selectionArgs = {email,exgroup,Doe, String.valueOf(timing)};

        // query user table with condition
        Cursor cursor = db.query(table_name1, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount=0;
        if(cursor!=null && !cursor.isClosed()){
            cursorCount=cursor.getCount();
            cursor.close();
        }
        db.close();

        return cursorCount;
    }

    public List<GroupData> retTypes(String exgroup){
        Date now=new Date();
        int i;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEEE");
        String daynow=simpleDateFormat.format(now);
        String[] day={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        for(i=0;i<day.length;i++){
            if(day[i].equals(daynow))
                break;
        }
        simpleDateFormat=new SimpleDateFormat("HH:mm");
        Calendar calendar=Calendar.getInstance();
        String time=simpleDateFormat.format(calendar.getTime());
        String nowtime=time.replace(":","");
        int timeNow= Integer.parseInt(nowtime);
        nowtime="0"+new Integer(timeNow).toString();
        String[] columns = {
                "*"
        };
        List<GroupData> groupDataList=new ArrayList<GroupData>();
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection =  group_name1+" = ? AND " +doe+" IN (?,?,?)";
        // selection argument
        String[] selectionArgs = {exgroup,day[i%7],day[(i+1)%7],day[(i+2)%7]};

        // query user table with condition
        Cursor cursor = db.query(table_name2, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                GroupData user = new GroupData();
                user.setgroup(cursor.getString(cursor.getColumnIndex(group_name1)));
                user.settiming(Integer.parseInt(cursor.getString(cursor.getColumnIndex(timing))));
                user.setDoB(cursor.getString(cursor.getColumnIndex(doe)));
                // Adding user record to list
                groupDataList.add(user);
            } while (cursor.moveToNext());
        }
        if(cursor!=null && !cursor.isClosed())
            cursor.close();
        db.close();
        return groupDataList;
    }

    public List<GroupData> retTypes(String exgroup, String chosenDay){
        Date now=new Date();
        int i;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEEE");
        String daynow=simpleDateFormat.format(now);
        String[] day={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        for(i=0;i<day.length;i++){
            if(day[i].equals(daynow))
                break;
        }
        simpleDateFormat=new SimpleDateFormat("HH:mm");
        Calendar calendar=Calendar.getInstance();
        String time=simpleDateFormat.format(calendar.getTime());
        String nowtime=time.replace(":","");
        int timeNow= Integer.parseInt(nowtime);
        nowtime=new Integer(timeNow+1000).toString();
        String[] columns = {
                "*"
        };
        List<GroupData> groupDataList=new ArrayList<GroupData>();
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection =  group_name1+" = ? AND " +doe+" = ?";
        // selection argument
        String[] selectionArgs = {exgroup,chosenDay};

        // query user table with condition
        Cursor cursor = db.query(table_name2, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                GroupData user = new GroupData();
                user.setgroup(cursor.getString(cursor.getColumnIndex(group_name1)));
                user.settiming(Integer.parseInt(cursor.getString(cursor.getColumnIndex(timing))));
                user.setDoB(cursor.getString(cursor.getColumnIndex(doe)));
                // Adding user record to list
                groupDataList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return groupDataList;
    }

}
