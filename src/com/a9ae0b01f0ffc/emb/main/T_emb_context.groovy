package com.a9ae0b01f0ffc.emb.main

import com.a9ae0b01f0ffc.black_box.annotations.I_black_box
import com.a9ae0b01f0ffc.black_box.main.T_s
import com.a9ae0b01f0ffc.commons.main.T_common_context
import groovy.sql.Sql

class T_emb_context {

    protected static ThreadLocal<T_emb_context> p_context_thread_local = new ThreadLocal<T_emb_context>()
    private Sql p_sql = T_emb_const.GC_NULL_OBJ_REF as Sql
    private T_emb_commons p_commons = T_emb_const.GC_NULL_OBJ_REF as T_emb_commons

    private static void check_init() {
        if (p_context_thread_local.get() == T_emb_const.GC_NULL_OBJ_REF) {
            p_context_thread_local.set(new T_emb_context())
        }
    }

    void init_custom(String i_commons_conf_file_name) {
        check_init()
        p_context_thread_local.get().p_commons = new T_emb_commons(i_commons_conf_file_name)
        T_common_context.get_context().init_custom(i_commons_conf_file_name)
        T_s.x().init_custom(T_emb_s.c().GC_BLACK_BOX_CONFIG)
    }

    private static void check_init_sql() {
        if (get_context().p_sql == T_emb_const.GC_NULL_OBJ_REF) {
            get_context().p_sql = Sql.newInstance(T_emb_s.c().GC_MYSQL_CONNECTION_STRING, T_emb_s.c().GC_MYSQL_USERNAME, T_emb_s.c().GC_MYSQL_PASSWORD, T_emb_s.c().GC_MYSQL_DRIVER)
            get_context().p_sql.getConnection().setAutoCommit(T_emb_const.GC_FALSE)
        }
    }

    T_emb_commons get_commons() {
        check_init()
        return p_context_thread_local.get().p_commons
    }

    static T_emb_context get_context() {
        check_init()
        return p_context_thread_local.get()
    }

    @I_black_box
    void sql_update(String i_sql_string, String... i_bind_variables = T_emb_const.GC_SKIPPED_ARGS) {
        check_init_sql()
        T_s.l().log_sql("update", i_sql_string, i_bind_variables)
        if (T_u.method_arguments_present(i_bind_variables)) {
            p_sql.executeUpdate(i_sql_string, i_bind_variables)
        } else {
            p_sql.executeUpdate(i_sql_string)
        }
    }

    Sql get_sql() {
        check_init_sql()
        return p_sql
    }

    Boolean sql_update2(String i_sql_string, String... i_bind_variables = T_emb_const.GC_SKIPPED_ARGS) {
        T_s.l().log_enter("com.a9ae0b01f0ffc.tpn.main.T_emb_context", "sql_update", T_logging_const.GC_STATEMENT_NAME_METHOD, 123, T_s.r(i_sql_string, "i_sql_string"), T_s.r(i_bind_variables, "i_bind_variables"))
        try {
            T_s.l().log_enter("com.a9ae0b01f0ffc.tpn.main.T_emb_context", "sql_update", "check_init_sql", 125)
            try {
                check_init_sql()
            } catch (Throwable e_others) {
                l_logger.log_error(e_others)
                throw e_others
            } finally {
                T_s.l().log_exit()
            }
            T_s.l().log_sql("update", i_sql_string, i_bind_variables)
            T_s.l().log_enter("com.a9ae0b01f0ffc.tpn.main.T_emb_context", "sql_update", "if", 127)
            try {
                if (T_u.method_arguments_present(i_bind_variables)) {
                    T_s.l().log_enter("com.a9ae0b01f0ffc.tpn.main.T_emb_context", "sql_update", "then", 129)
                    try {
                        p_sql.executeUpdate(i_sql_string, i_bind_variables)
                    } catch (Throwable e_others) {
                        T_s.l()..log_error(e_others)
                        throw e_others
                    } finally {
                        T_s.l().log_exit()
                    }
                } else {
                    T_s.l().log_enter("com.a9ae0b01f0ffc.tpn.main.T_emb_context", "sql_update", "else", 132)
                    try {
                        p_sql.executeUpdate(i_sql_string)
                    } catch (Throwable e_others) {
                        T_s.l()..log_error(e_others)
                        throw e_others
                    } finally {
                        T_s.l().log_exit()
                    }
                }
            } catch (Throwable e_others) {
                T_s.l()..log_error(e_others)
                throw e_others
            } finally {
                T_s.l().log_exit()
            }
            T_s.l().log_enter("com.a9ae0b01f0ffc.tpn.main.T_emb_context", "sql_update", "declaration", 135)
            Boolean l_result
            try {
                l_result = true
            } catch (Throwable e_others) {
                T_s.l()..log_error(e_others)
                throw e_others
            } finally {
                T_s.l().log_exit()
            }
            return T_s.l().log_result(T_s.r(l_result, "l_result"))
        } catch (Throwable e_others) {
            T_s.l()..log_error(e_others)
            throw e_others
        } finally {
            T_s.l().log_exit()
        }
    }

}
