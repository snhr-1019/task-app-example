/*
 * This file is generated by jOOQ.
 */
package gen.jooq.taskapp;


import gen.jooq.taskapp.tables.AppUser;
import gen.jooq.taskapp.tables.Task;
import gen.jooq.taskapp.tables.records.AppUserRecord;
import gen.jooq.taskapp.tables.records.TaskRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * taskapp.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AppUserRecord> KEY_APP_USER_APP_USER_PK = Internal.createUniqueKey(AppUser.APP_USER, DSL.name("KEY_app_user_app_user_pk"), new TableField[] { AppUser.APP_USER.UUID }, true);
    public static final UniqueKey<AppUserRecord> KEY_APP_USER_PRIMARY = Internal.createUniqueKey(AppUser.APP_USER, DSL.name("KEY_app_user_PRIMARY"), new TableField[] { AppUser.APP_USER.UUID }, true);
    public static final UniqueKey<TaskRecord> KEY_TASK_PRIMARY = Internal.createUniqueKey(Task.TASK, DSL.name("KEY_task_PRIMARY"), new TableField[] { Task.TASK.UUID }, true);
}