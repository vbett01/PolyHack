package com.example.vincentbett.inventoryapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class productDB {

    private static final String DBNAME = "ProductDb";
    private static final String TABLE_NAME = "ProductInfo";
    private static final int DATABASE_VERSION = 1;

    public static final String COLUMN_NAME_PRODUCT_ID = "productId";
    public static final String COLUMN_NAME_PRODUCT_NAME = "productName";
    public static final String COLUMN_NAME_PRODUCT_PRICE = "productPrice";

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public productDB(Context context)
    {
        ourContext = context;
    }

    private class DBHelper extends SQLiteOpenHelper
    {
        public DBHelper(Context context)
        {
            super(context, DBNAME, null, DATABASE_VERSION);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sqlCode = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME_PRODUCT_NAME + " TEXT NOT NULL, " +
                    COLUMN_NAME_PRODUCT_PRICE + " INTEGER NOT NULL)";

            db.execSQL(sqlCode);

        }
    }

    public productDB open() throws SQLException
    {
        ourHelper = new DBHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return  this;
    }

    public void close()
    {
        ourHelper.close();
    }

    public long createEntry(String productId, String name, int price)
    {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_PRODUCT_ID, productId);
        cv.put(COLUMN_NAME_PRODUCT_NAME, name);
        cv.put(COLUMN_NAME_PRODUCT_PRICE, price);
        return ourDatabase.insert(TABLE_NAME, null, cv);

    }

    public String getData()
    {
        String [] columns = new String[] {COLUMN_NAME_PRODUCT_ID, COLUMN_NAME_PRODUCT_NAME, COLUMN_NAME_PRODUCT_PRICE};
        Cursor c = ourDatabase.query(TABLE_NAME, columns, null, null, null, null, null);

        String result = "";

        int iRow = c.getColumnIndex(COLUMN_NAME_PRODUCT_ID);
        int iProdId = c.getColumnIndex(COLUMN_NAME_PRODUCT_NAME);
        int iProdQty = c.getColumnIndex(COLUMN_NAME_PRODUCT_PRICE);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToLast())
        {
            result = result + c.getString(iRow) + ":" + c.getString(iProdId) + c.getString(iProdQty) + "\n";
        }

        c.close();
        return result;
    }

    public long deleteEntry(String prodId)
    {
        return ourDatabase.delete(TABLE_NAME, COLUMN_NAME_PRODUCT_ID + "=?", new String[]{prodId} );

    }

    public long updateEntry(String prodId, String name, int price)
    {
        ContentValues cv =  new ContentValues();
       // cv.put(COLUMN_NAME_PRODUCT_ID, prodId);
        cv.put(COLUMN_NAME_PRODUCT_NAME, name);
        cv.put(COLUMN_NAME_PRODUCT_PRICE, price);

        return ourDatabase.update(TABLE_NAME, cv, COLUMN_NAME_PRODUCT_ID +"=?", new String[]{prodId});
    }
}
