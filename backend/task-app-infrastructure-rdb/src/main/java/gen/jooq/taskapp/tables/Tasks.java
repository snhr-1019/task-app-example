/*
 * This file is generated by jOOQ.
 */
package gen.jooq.taskapp.tables;


import gen.jooq.taskapp.Keys;
import gen.jooq.taskapp.Taskapp;
import gen.jooq.taskapp.tables.records.TasksRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tasks extends TableImpl<TasksRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>taskapp.tasks</code>
     */
    public static final Tasks TASKS = new Tasks();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TasksRecord> getRecordType() {
        return TasksRecord.class;
    }

    /**
     * The column <code>taskapp.tasks.id</code>.
     */
    public final TableField<TasksRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>taskapp.tasks.user_id</code>.
     */
    public final TableField<TasksRecord, Integer> USER_ID = createField(DSL.name("user_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>taskapp.tasks.title</code>.
     */
    public final TableField<TasksRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>taskapp.tasks.completed</code>.
     */
    public final TableField<TasksRecord, Byte> COMPLETED = createField(DSL.name("completed"), SQLDataType.TINYINT.nullable(false), this, "");

    private Tasks(Name alias, Table<TasksRecord> aliased) {
        this(alias, aliased, null);
    }

    private Tasks(Name alias, Table<TasksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>taskapp.tasks</code> table reference
     */
    public Tasks(String alias) {
        this(DSL.name(alias), TASKS);
    }

    /**
     * Create an aliased <code>taskapp.tasks</code> table reference
     */
    public Tasks(Name alias) {
        this(alias, TASKS);
    }

    /**
     * Create a <code>taskapp.tasks</code> table reference
     */
    public Tasks() {
        this(DSL.name("tasks"), null);
    }

    public <O extends Record> Tasks(Table<O> child, ForeignKey<O, TasksRecord> key) {
        super(child, key, TASKS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Taskapp.TASKAPP;
    }

    @Override
    public Identity<TasksRecord, Integer> getIdentity() {
        return (Identity<TasksRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TasksRecord> getPrimaryKey() {
        return Keys.KEY_TASKS_PRIMARY;
    }

    @Override
    public Tasks as(String alias) {
        return new Tasks(DSL.name(alias), this);
    }

    @Override
    public Tasks as(Name alias) {
        return new Tasks(alias, this);
    }

    @Override
    public Tasks as(Table<?> alias) {
        return new Tasks(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Tasks rename(String name) {
        return new Tasks(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Tasks rename(Name name) {
        return new Tasks(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Tasks rename(Table<?> name) {
        return new Tasks(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, String, Byte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Integer, ? super Integer, ? super String, ? super Byte, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Integer, ? super Integer, ? super String, ? super Byte, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
