package com.example.jaminhu.inventoryappstage1.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.jaminhu.inventoryappstage1.Data.ProductsContract.ProductsEntry;

public class ProductsDbHandler extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "shop.db";

    private final static int DATABASE_VERSION = 1;

    public ProductsDbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_COMMAND_STRING = "CREATE TABLE " + ProductsEntry.TABLE_NAME + " (" +
                ProductsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ProductsEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                ProductsEntry.COLUMN_PRICE + " INTEGER NOT NULL, " +
                ProductsEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0, " +
                ProductsEntry.COLUMN_SUPPLIER + " TEXT, " +
                ProductsEntry.COLUMN_SUPPLIER_CONTACT + " TEXT);";

        db.execSQL(CREATE_COMMAND_STRING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
