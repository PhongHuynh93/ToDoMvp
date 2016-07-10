package dhbk.android.todomvp;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by huynhducthanhphong on 7/10/16.
 */
// TODO: 7/10/16 7 create a db
public class TasksDbHelper  extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Tasks.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TasksPersistenceContract.TaskEntry.TABLE_NAME + " (" +
                    TasksPersistenceContract.TaskEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
                    TasksPersistenceContract.TaskEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    TasksPersistenceContract.TaskEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    TasksPersistenceContract.TaskEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    TasksPersistenceContract.TaskEntry.COLUMN_NAME_COMPLETED + BOOLEAN_TYPE +
                    " )";

}
