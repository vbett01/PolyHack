package com.example.vincentbett.inventoryapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;





public class transactionDB {

    private static final String DBNAME = "TransactionDb";
    private static final String TABLE_NAME = "transactionInfo";
    private static final int DATABASE_VERSION = 1;

    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_TRANSACTION_TYPE = "transactionType";
    public static final String COLUMN_NAME_TRANSACTION_ID = "transactionId";
    public static final String COLUMN_NAME_PRODUCT_ID = "productID";
    public static final String COLUMN_NAME_TRANSACTION_AMOUNT = "transactionAmnt";

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    private transactionDB(Context context)
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
                    COLUMN_NAME_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME_TRANSACTION_ID + "TEXT NOT NULL, " +
                    COLUMN_NAME_PRODUCT_ID + " TEXT NOT NULL, " +
                    COLUMN_NAME_TRANSACTION_AMOUNT + " INTEGER NOT NULL, " +
                    COLUMN_NAME_TRANSACTION_TYPE + " TEXT NOT NULL)";
            db.execSQL(sqlCode);

        }
    }

    public transactionDB open() throws SQLException
    {
        ourHelper = new DBHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return  this;
    }

    public void close()
    {
        ourHelper.close();
    }

    public long createEntry(String transactionId, String prodId, int tranAmnt, String type)
    {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_TRANSACTION_ID, transactionId );
        cv.put(COLUMN_NAME_PRODUCT_ID, prodId);
        cv.put(COLUMN_NAME_TRANSACTION_AMOUNT, tranAmnt);
        cv.put(COLUMN_NAME_TRANSACTION_TYPE, type);
        return ourDatabase.insert(TABLE_NAME, null, cv);

    }

    public String getData()
    {
        String [] columns = new String[] {COLUMN_NAME_PRODUCT_ID, COLUMN_NAME_TRANSACTION_ID, COLUMN_NAME_TRANSACTION_TYPE, COLUMN_NAME_TRANSACTION_AMOUNT};
        Cursor c = ourDatabase.query(TABLE_NAME, columns, null, null, null, null, null);

        String result = "";

        int iPid = c.getColumnIndex(COLUMN_NAME_PRODUCT_ID);
        int iTranId = c.getColumnIndex(COLUMN_NAME_TRANSACTION_ID);
        int iTranType = c.getColumnIndex(COLUMN_NAME_TRANSACTION_TYPE);
        int iTranAmnt = c.getColumnIndex(COLUMN_NAME_TRANSACTION_AMOUNT);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToLast())
        {
            result = result + c.getString(iPid) + ":" + c.getString(iTranId) + c.getString(iTranAmnt) + c.getString(iTranType) + "\n";
        }

        c.close();
        return result;
    }

    public long deleteEntry(String id)
    {
        return ourDatabase.delete(TABLE_NAME, COLUMN_NAME_ID + "=?", new String[]{id} );

    }

    /*
    public long updateEntry(String rowId, String productId, int qty)
    {
        ContentValues cv =  new ContentValues();
        cv.put("Xxxxxxxx", productId);
        cv.put("COLUMN_NAME_QUANTITY", qty);

        return ourDatabase.update(TABLE_NAME, cv, COLUMN_NAME_ID +"=?", new String[]{rowId});
    }
    */

}
