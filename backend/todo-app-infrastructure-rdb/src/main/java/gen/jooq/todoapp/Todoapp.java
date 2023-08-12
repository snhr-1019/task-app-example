/*
 * This file is generated by jOOQ.
 */
package gen.jooq.taskapp;


import gen.jooq.DefaultCatalog;
import gen.jooq.taskapp.tables.AppUser;
import gen.jooq.taskapp.tables.Task;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Taskapp extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>taskapp</code>
     */
    public static final Taskapp TODOAPP = new Taskapp();

    /**
     * The table <code>taskapp.app_user</code>.
     */
    public final AppUser APP_USER = AppUser.APP_USER;

    /**
     * The table <code>taskapp.task</code>.
     */
    public final Task TODO = Task.TODO;

    /**
     * No further instances allowed
     */
    private Taskapp() {
        super("taskapp", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            AppUser.APP_USER,
            Task.TODO
        );
    }
}
