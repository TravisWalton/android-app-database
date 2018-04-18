package aj.hw8;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "hw8.db";
    // Table name
    private static final String TABLE_NAME = "employees";

    public static final String ID = "Employee_ID";
    public static final String LAST = "Last_Name";
    public static final String TITLE = "Title_ID";
    public static final String LOCATION = "Location_ID";


    // Default constructor
    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " int not null primary key, " + LAST + " varchar(100), " + TITLE + " varchar(100), " + LOCATION + " varchar(255))";
        // Execute SQL statement
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void AddToDatabase(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, employee.ID);
        values.put(LAST, employee.name);
        values.put(TITLE, employee.titleID);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Employee QueryDatabase(String employeeID){

        // SQL statement
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + ID + " =  \"" + employeeID + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Employee employee = new Employee();

        if(cursor.moveToFirst()){
            employee.SetterID(cursor.getString(0));
            employee.SetterLast(cursor.getString(1));
            employee.SetterTitleID(cursor.getString(2));
            cursor.close();
        } else{
            employee = null;
        }
        db.close();

        return employee;
    }
}
