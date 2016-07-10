package dhbk.android.todomvp.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by huynhducthanhphong on 7/10/16.
 */
// TODO: 7/10/16 7
/**
 * The contract used for the db to save the tasks locally.
 */
public final class TasksPersistenceContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public TasksPersistenceContract() {}

    /* Inner class that defines the table contents */
    public static abstract class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "task";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_COMPLETED = "completed";
    }
}