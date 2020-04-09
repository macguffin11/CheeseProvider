package com.example.cheeseprovider;

import android.provider.BaseColumns;

public class Cheese {

        /** The name of the Cheese table. */
        public static final String TABLE_NAME = "cheeses";

        /** The name of the ID column. */
        public static final String COLUMN_ID = BaseColumns._ID;

        /** The name of the name column. */
        public static final String COLUMN_NAME = "name";

        private long id;

        private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cheese(String name) {
        this.name = name;
    }
}
