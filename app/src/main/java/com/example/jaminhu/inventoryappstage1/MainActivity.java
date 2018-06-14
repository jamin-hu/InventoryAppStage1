package com.example.jaminhu.inventoryappstage1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jaminhu.inventoryappstage1.Data.ProductsContract.ProductsEntry;
import com.example.jaminhu.inventoryappstage1.Data.ProductsDbHandler;

import java.security.ProtectionDomain;

public class MainActivity extends AppCompatActivity {

    private ProductsDbHandler mDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHandler = new ProductsDbHandler(this);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData();
                displayData();
            }
        });
    }

    public void inputData(){

        SQLiteDatabase db = mDbHandler.getReadableDatabase();

        ContentValues dummyValues = new ContentValues();

        dummyValues.put(ProductsEntry.COLUMN_NAME, "Oneplus 2");
        dummyValues.put(ProductsEntry.COLUMN_PRICE, 300);
        dummyValues.put(ProductsEntry.COLUMN_QUANTITY, 4000 );
        dummyValues.put(ProductsEntry.COLUMN_SUPPLIER, "Oneplus");
        dummyValues.put(ProductsEntry.COLUMN_SUPPLIER_CONTACT, "" + "oneplus.com");

        long newRowId = db.insert(ProductsEntry.TABLE_NAME, null, dummyValues);
    }

    public void displayData(){

        String[] projection = {ProductsEntry._ID,
                ProductsEntry.COLUMN_NAME,
                ProductsEntry.COLUMN_PRICE,
                ProductsEntry.COLUMN_QUANTITY,
                ProductsEntry.COLUMN_SUPPLIER,
                ProductsEntry.COLUMN_SUPPLIER_CONTACT};

        SQLiteDatabase db = mDbHandler.getReadableDatabase();
        Cursor c = db.query(ProductsEntry.TABLE_NAME, projection, null, null, null, null, null);

        TextView display = findViewById(R.id.display);

        int idIndex = c.getColumnIndex(ProductsEntry._ID);
        int nameIndex = c.getColumnIndex(ProductsEntry.COLUMN_NAME);
        int priceIndex = c.getColumnIndex(ProductsEntry.COLUMN_PRICE);
        int quantityIndex = c.getColumnIndex(ProductsEntry.COLUMN_QUANTITY);
        int supplierIndex = c.getColumnIndex(ProductsEntry.COLUMN_SUPPLIER);
        int supplierContactIndex = c.getColumnIndex(ProductsEntry.COLUMN_SUPPLIER_CONTACT);

        display.setText("Database with dummy product: \n");

        display.append(ProductsEntry._ID + " - " +
                ProductsEntry.COLUMN_NAME + " - " +
                ProductsEntry.COLUMN_PRICE + " - " +
                ProductsEntry.COLUMN_QUANTITY + " - " +
                ProductsEntry.COLUMN_SUPPLIER + " - " +
                ProductsEntry.COLUMN_SUPPLIER_CONTACT + "\n");

        while (c.moveToNext()) {
            // Use that index to extract the String or Int value of the word
            // at the current row the cursor is on.
            int currentId = c.getInt(idIndex);
            String currentName = c.getString(nameIndex);
            int currentPrice = c.getInt(priceIndex);
            int currentQuantity = c.getInt(quantityIndex);
            String currentSupplier = c.getString(supplierIndex);
            String currentSupplierContact = c.getString(supplierContactIndex);

            // Display the values from each column of the current row in the cursor in the TextView

            display.append("\n" +
                    currentId + " - " +
                    currentName + " - " +
                    currentPrice + " - " +
                    currentQuantity + " - " +
                    currentSupplier + " - " +
                    currentSupplierContact);
        }
        c.close();
    }
}
