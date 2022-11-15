package com.example.throttle;


import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="Throttle_DataBase";

    public static final String TABLE_NAME="LOGIN";

    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_FirstName="FirstName";

    public static final String Table_Column_2_LastName="LastName";

    public static final String Table_Column_3_Email="Email";

    public static final String Table_Column_4_Password="Password";

    public static final String TABLE_NAME2="EVENTS";

    public static final String Table2_Column_ID="Event_ID";

    public static final String Table2_Column_1_EventName="EventName";

    public static final String Table2_Column_2_Location="Location";

    public static final String Table2_Column_3_Date="Email";


    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER  PRIMARY KEY, "+Table_Column_1_FirstName+" VARCHAR, "+Table_Column_2_LastName+" VARCHAR, "+Table_Column_3_Email+" VARCHAR, "+Table_Column_4_Password+ " VARCHAR)";
        String CREATE_TABLE2="CREATE TABLE IF NOT EXISTS "+TABLE_NAME2+" ("+Table2_Column_ID+" INTEGER  PRIMARY KEY, "+Table2_Column_1_EventName+" VARCHAR, "+Table2_Column_2_Location+" VARCHAR, "+Table2_Column_3_Date+" DATE)";

        database.execSQL(CREATE_TABLE);
        database.execSQL(CREATE_TABLE2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);

    }

}