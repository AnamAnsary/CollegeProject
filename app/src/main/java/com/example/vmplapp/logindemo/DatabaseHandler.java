package com.example.vmplapp.logindemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmplapp on 28/8/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHandler";
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "CollegeManager";

    // Contacts table name
    private static final String TABLE_USERS = "users";
    private static final String TABLE_DEPT = "departments";

    // Contacts Table Columns names
   /* private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

*/

   //Common colums
   private static final String KEY_ACTIVE = "active";


    // Mst_Users Table - column names
    private static final String KEY_USERID = "userId";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_FULLNAME = "fullname";
    private static final String KEY_CONTACT = "contactno";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USERTYPE = "usertype";
    private static final String KEY_ISAPPROVED = "isapproved";


    // Mst_Dept Table - column names
    private static final String KEY_DEPTID = "deptId";
    private static final String KEY_DEPTNAME = "deptname";
    private static final String KEY_DEPTHOD = "depthod";


    private Context context;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT,"
                + KEY_FULLNAME + " TEXT,"
                + KEY_CONTACT + " INTEGER,"
                + KEY_EMAIL + " TEXT,"
                + KEY_USERTYPE + " TEXT,"
                + KEY_ISAPPROVED + " INTEGER,"
                + KEY_ACTIVE + " INTEGER"
                + ")";


        String CREATE_DEPT_TABLE = "CREATE TABLE " + TABLE_DEPT + "("
                + KEY_DEPTID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_DEPTNAME + " TEXT,"
                + KEY_DEPTHOD + " INTEGER,"
                + KEY_ACTIVE + " INTEGER"
                + ")";

        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_DEPT_TABLE);
        Log.w(TAG, "onCreate: Database created");
       // Toast.makeText(context, "Database Created", Toast.LENGTH_LONG).show();

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPT);
        Log.w(TAG, "onUpgrade: Database upgrade" );
        // Create tables again
        onCreate(db);
    }

    public void addUser(MstUsers mstUsers) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, mstUsers.getUsername()); // Contact Name
        values.put(KEY_PASSWORD, mstUsers.getPassword()); // Contact Phone
        values.put(KEY_FULLNAME, mstUsers.getFullname()); // Contact Name
        values.put(KEY_CONTACT, mstUsers.getContactno());
        values.put(KEY_EMAIL, mstUsers.getEmail()); // Contact Name
        values.put(KEY_USERTYPE, mstUsers.getUsertype());
        values.put(KEY_ISAPPROVED, mstUsers.getIsApproved());
        values.put(KEY_ACTIVE, mstUsers.getActive());

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        Log.w(TAG, "addUser: added user" );
        //Toast.makeText(context, "User Added", Toast.LENGTH_LONG).show();
        db.close(); // Closing database connection
    }

    // Getting single contact
    MstUsers getSingleUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, null,
                KEY_USERID + "=?",new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        MstUsers userDetail = new MstUsers(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                cursor.getString(4),cursor.getString(5),cursor.getString(6),Integer.parseInt(cursor.getString(7)),Integer.parseInt(cursor.getString(8)));
        // return contact
        return userDetail;
    }


    public MstUsers checkUser(String email, String pass) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_USERS, null, KEY_EMAIL + "=? AND " +KEY_PASSWORD + "=?", new String[] { email, pass }, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        MstUsers userDetail = new MstUsers(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                cursor.getString(4),cursor.getString(5),cursor.getString(6),Integer.parseInt(cursor.getString(7)),Integer.parseInt(cursor.getString(8)));
        // return contact
        return userDetail;
    }


    public List<MstUsers> getAllHodUsers() {
        List<MstUsers> hodList = new ArrayList<MstUsers>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USERS + " where " + KEY_USERTYPE + " = 'Department HOD'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MstUsers hoduser = new MstUsers();
                hoduser.setId(Integer.parseInt(cursor.getString(0)));
                hoduser.setFullname(cursor.getString(3));
                // Adding contact to list
                hodList.add(hoduser);
            } while (cursor.moveToNext());
        }

        // return contact list
        return hodList;

    }

    public void addDept(MstDept mstDept) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DEPTNAME, mstDept.getDeptname());
        values.put(KEY_DEPTHOD, mstDept.getDeptHOD());
        values.put(KEY_ACTIVE, mstDept.getActive());

        // Inserting Row
        db.insert(TABLE_DEPT, null, values);
        Log.w(TAG, "addDept: added department" );
        //Toast.makeText(context, "User Added", Toast.LENGTH_LONG).show();
        db.close(); // Closing database connection
    }
}