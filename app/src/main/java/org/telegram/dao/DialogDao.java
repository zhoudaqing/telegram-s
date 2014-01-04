package org.telegram.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import org.telegram.dao.Dialog;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table DIALOG.
*/
public class DialogDao extends AbstractDao<Dialog, Long> {

    public static final String TABLENAME = "DIALOG";

    /**
     * Properties of entity Dialog.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property UnreadCount = new Property(1, int.class, "unreadCount", false, "UNREAD_COUNT");
        public final static Property TopMessageId = new Property(2, int.class, "topMessageId", false, "TOP_MESSAGE_ID");
        public final static Property SenderId = new Property(3, int.class, "senderId", false, "SENDER_ID");
        public final static Property Date = new Property(4, int.class, "date", false, "DATE");
        public final static Property ContentType = new Property(5, int.class, "contentType", false, "CONTENT_TYPE");
        public final static Property Message = new Property(6, String.class, "message", false, "MESSAGE");
        public final static Property MessageState = new Property(7, int.class, "messageState", false, "MESSAGE_STATE");
        public final static Property LastLocalViewedMessage = new Property(8, int.class, "lastLocalViewedMessage", false, "LAST_LOCAL_VIEWED_MESSAGE");
        public final static Property LastRemoteViewedMessage = new Property(9, int.class, "lastRemoteViewedMessage", false, "LAST_REMOTE_VIEWED_MESSAGE");
        public final static Property Failure = new Property(10, boolean.class, "failure", false, "FAILURE");
        public final static Property FirstUnreadMessage = new Property(11, long.class, "firstUnreadMessage", false, "FIRST_UNREAD_MESSAGE");
    };


    public DialogDao(DaoConfig config) {
        super(config);
    }
    
    public DialogDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DIALOG' (" + //
                "'_id' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'UNREAD_COUNT' INTEGER NOT NULL ," + // 1: unreadCount
                "'TOP_MESSAGE_ID' INTEGER NOT NULL ," + // 2: topMessageId
                "'SENDER_ID' INTEGER NOT NULL ," + // 3: senderId
                "'DATE' INTEGER NOT NULL ," + // 4: date
                "'CONTENT_TYPE' INTEGER NOT NULL ," + // 5: contentType
                "'MESSAGE' TEXT," + // 6: message
                "'MESSAGE_STATE' INTEGER NOT NULL ," + // 7: messageState
                "'LAST_LOCAL_VIEWED_MESSAGE' INTEGER NOT NULL ," + // 8: lastLocalViewedMessage
                "'LAST_REMOTE_VIEWED_MESSAGE' INTEGER NOT NULL ," + // 9: lastRemoteViewedMessage
                "'FAILURE' INTEGER NOT NULL ," + // 10: failure
                "'FIRST_UNREAD_MESSAGE' INTEGER NOT NULL );"); // 11: firstUnreadMessage
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_DIALOG_DATE ON DIALOG" +
                " (DATE);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DIALOG'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Dialog entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getUnreadCount());
        stmt.bindLong(3, entity.getTopMessageId());
        stmt.bindLong(4, entity.getSenderId());
        stmt.bindLong(5, entity.getDate());
        stmt.bindLong(6, entity.getContentType());
 
        String message = entity.getMessage();
        if (message != null) {
            stmt.bindString(7, message);
        }
        stmt.bindLong(8, entity.getMessageState());
        stmt.bindLong(9, entity.getLastLocalViewedMessage());
        stmt.bindLong(10, entity.getLastRemoteViewedMessage());
        stmt.bindLong(11, entity.getFailure() ? 1l: 0l);
        stmt.bindLong(12, entity.getFirstUnreadMessage());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Dialog readEntity(Cursor cursor, int offset) {
        Dialog entity = new Dialog( //
            cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // unreadCount
            cursor.getInt(offset + 2), // topMessageId
            cursor.getInt(offset + 3), // senderId
            cursor.getInt(offset + 4), // date
            cursor.getInt(offset + 5), // contentType
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // message
            cursor.getInt(offset + 7), // messageState
            cursor.getInt(offset + 8), // lastLocalViewedMessage
            cursor.getInt(offset + 9), // lastRemoteViewedMessage
            cursor.getShort(offset + 10) != 0, // failure
            cursor.getLong(offset + 11) // firstUnreadMessage
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Dialog entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setUnreadCount(cursor.getInt(offset + 1));
        entity.setTopMessageId(cursor.getInt(offset + 2));
        entity.setSenderId(cursor.getInt(offset + 3));
        entity.setDate(cursor.getInt(offset + 4));
        entity.setContentType(cursor.getInt(offset + 5));
        entity.setMessage(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMessageState(cursor.getInt(offset + 7));
        entity.setLastLocalViewedMessage(cursor.getInt(offset + 8));
        entity.setLastRemoteViewedMessage(cursor.getInt(offset + 9));
        entity.setFailure(cursor.getShort(offset + 10) != 0);
        entity.setFirstUnreadMessage(cursor.getLong(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Dialog entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Dialog entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
