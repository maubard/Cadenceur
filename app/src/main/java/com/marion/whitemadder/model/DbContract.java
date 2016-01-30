package com.marion.whitemadder.model;

import android.provider.BaseColumns;

/**
 * Created by marion on 30/01/16.
 */
public class DbContract {

    private static final String NUMBER_TYPE = " NUMBER";
    private static final String COMMA_SEP = ",";




    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public DbContract() {}

    /* Inner class that defines the table contents */
    public static abstract class AreaEntry implements BaseColumns {
        public static final String TABLE_NAME = "area";
        public static final String COLUMN_NAME_ENTRY_ID = "id";

        protected static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + AreaEntry.TABLE_NAME + " (" +
                        AreaEntry.COLUMN_NAME_ENTRY_ID + " INTEGER PRIMARY KEY) ";

        protected static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + AreaEntry.TABLE_NAME;

    }

    /* Inner class that defines the table contents */
    public static abstract class LineEntry implements BaseColumns {
        public static final String TABLE_NAME = "line";
        public static final String COLUMN_NAME_ENTRY_ID = "id";
        public static final String COLUMN_NAME_ENTRY_DISTANCE = "distance";
        public static final String COLUMN_NAME_ENTRY_AVERAGE = "average";
        public static final String COLUMN_NAME_ENTRY_AREA = "area";

        protected static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + LineEntry.TABLE_NAME + " (" +
                        LineEntry.COLUMN_NAME_ENTRY_ID + " INTEGER PRIMARY KEY " +
                        LineEntry.COLUMN_NAME_ENTRY_DISTANCE + NUMBER_TYPE + COMMA_SEP +
                        LineEntry.COLUMN_NAME_ENTRY_AVERAGE + NUMBER_TYPE + COMMA_SEP +
                        LineEntry.COLUMN_NAME_ENTRY_AREA + " INTEGER " + COMMA_SEP +
                ")";

        protected static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + LineEntry.TABLE_NAME;
    }
}
