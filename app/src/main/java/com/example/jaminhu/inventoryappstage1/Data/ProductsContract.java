package com.example.jaminhu.inventoryappstage1.Data;

import android.provider.BaseColumns;

public class ProductsContract {

    private ProductsContract(){};

    public final class ProductsEntry implements BaseColumns{

        public static final String TABLE_NAME = "products";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER = "supplier";
        public static final String COLUMN_SUPPLIER_CONTACT = "supplier_contact";

    }
}
