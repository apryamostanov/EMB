package com.a9ae0b01f0ffc.emb.main

import com.a9ae0b01f0ffc.black_box.main.T_s
import com.a9ae0b01f0ffc.commons.exceptions.E_application_exception
import com.a9ae0b01f0ffc.emb.implementation.T_emb_post_processor

class T_main {

    static void main(String... i_args) {
        T_emb_s.x().init_custom("./conf/commons.conf")
        T_s.l().log_info(T_s.s().Welcome_to_Wirecard_Embossing_file_post_processor)
        T_s.l().log_info(T_s.s().Input_file_Z1, T_emb_s.c().GC_SOURCE_FILE_NAME)
        T_s.l().log_info(T_s.s().Output_file_Z2, T_emb_s.c().GC_DESTINATION_FILE_NAME)
        T_emb_post_processor l_emb_post_processor = new T_emb_post_processor()
        l_emb_post_processor.process_file(T_emb_s.c().GC_SOURCE_FILE_NAME, T_emb_s.c().GC_DESTINATION_FILE_NAME)
    }

}
