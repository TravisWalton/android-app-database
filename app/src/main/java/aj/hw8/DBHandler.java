package aj.hw8;

import android.content.Context;
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
        // SQL string statement
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " int not null primary key, " + LAST + " varchar(100), " + TITLE + " varchar(100), " + LOCATION + " varchar(255))";
        // Execute SQL statement
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void addHandler(int id, String name, String titleID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(LAST, id);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
