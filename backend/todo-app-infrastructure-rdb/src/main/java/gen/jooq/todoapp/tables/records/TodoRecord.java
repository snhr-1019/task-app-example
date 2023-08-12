/*
 * This file is generated by jOOQ.
 */
package gen.jooq.taskapp.tables.records;


import gen.jooq.taskapp.tables.Todo;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TodoRecord extends UpdatableRecordImpl<TodoRecord> implements Record5<String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>taskapp.task.uuid</code>.
     */
    public void setUuid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>taskapp.task.uuid</code>.
     */
    public String getUuid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>taskapp.task.app_user_uuid</code>.
     */
    public void setAppUserUuid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>taskapp.task.app_user_uuid</code>.
     */
    public String getAppUserUuid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>taskapp.task.code</code>.
     */
    public void setCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>taskapp.task.code</code>.
     */
    public String getCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>taskapp.task.title</code>.
     */
    public void setTitle(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>taskapp.task.title</code>.
     */
    public String getTitle() {
        return (String) get(3);
    }

    /**
     * Setter for <code>taskapp.task.status</code>.
     */
    public void setStatus(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>taskapp.task.status</code>.
     */
    public String getStatus() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Todo.TODO.UUID;
    }

    @Override
    public Field<String> field2() {
        return Todo.TODO.APP_USER_UUID;
    }

    @Override
    public Field<String> field3() {
        return Todo.TODO.CODE;
    }

    @Override
    public Field<String> field4() {
        return Todo.TODO.TITLE;
    }

    @Override
    public Field<String> field5() {
        return Todo.TODO.STATUS;
    }

    @Override
    public String component1() {
        return getUuid();
    }

    @Override
    public String component2() {
        return getAppUserUuid();
    }

    @Override
    public String component3() {
        return getCode();
    }

    @Override
    public String component4() {
        return getTitle();
    }

    @Override
    public String component5() {
        return getStatus();
    }

    @Override
    public String value1() {
        return getUuid();
    }

    @Override
    public String value2() {
        return getAppUserUuid();
    }

    @Override
    public String value3() {
        return getCode();
    }

    @Override
    public String value4() {
        return getTitle();
    }

    @Override
    public String value5() {
        return getStatus();
    }

    @Override
    public TodoRecord value1(String value) {
        setUuid(value);
        return this;
    }

    @Override
    public TodoRecord value2(String value) {
        setAppUserUuid(value);
        return this;
    }

    @Override
    public TodoRecord value3(String value) {
        setCode(value);
        return this;
    }

    @Override
    public TodoRecord value4(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public TodoRecord value5(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public TodoRecord values(String value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TodoRecord
     */
    public TodoRecord() {
        super(Todo.TODO);
    }

    /**
     * Create a detached, initialised TodoRecord
     */
    public TodoRecord(String uuid, String appUserUuid, String code, String title, String status) {
        super(Todo.TODO);

        setUuid(uuid);
        setAppUserUuid(appUserUuid);
        setCode(code);
        setTitle(title);
        setStatus(status);
        resetChangedOnNotNull();
    }
}
