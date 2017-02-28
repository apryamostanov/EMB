package com.a9ae0b01f0ffc.emb.main

import com.a9ae0b01f0ffc.black_box.main.T_s
import com.a9ae0b01f0ffc.commons.exceptions.E_application_exception

class T_main {



    static void main(String... i_args) {
        Thread.currentThread().setName("TPN_MAIN_THREAD")
        if (!T_u.method_arguments_present(i_args)) {
            throw new E_application_exception(T_s.s().Missing_command_line_argument_Main_configuration_file_name)
        }
        String l_conf_file_name = i_args[T_emb_const.GC_FIRST_INDEX]
        T_emb_s.x().init_custom(l_conf_file_name)
        T_s.l().log_debug(T_s.s().Main_configration_file_name_Z1, l_conf_file_name)
        T_s.l().log_info(T_s.s().Welcome_to_Wirecard_Transaction_Push_Notification_Service)
    }

}
