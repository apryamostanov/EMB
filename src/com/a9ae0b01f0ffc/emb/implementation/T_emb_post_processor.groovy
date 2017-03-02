package com.a9ae0b01f0ffc.emb.implementation

import com.a9ae0b01f0ffc.black_box.annotations.I_black_box
import com.a9ae0b01f0ffc.emb.main.T_emb_const
import com.a9ae0b01f0ffc.emb.main.T_u

class T_emb_post_processor {

    static FileWriter p_file_writer = T_emb_const.GC_NULL_OBJ_REF as FileWriter

    @I_black_box
    static String process_line(String i_line) {
        return i_line
    }

    @I_black_box
    static void write_line(String i_line) {
        p_file_writer.write(i_line + System.lineSeparator())
        p_file_writer.flush()
    }

    @I_black_box
    static void process_file(String i_source_file_name, String i_destination_file_name) {
        p_file_writer = T_u.init_file(i_destination_file_name)
        new File(i_source_file_name).eachLine { String l_line ->
            write_line(process_line(l_line))
        }
    }

}
