package com.a9ae0b01f0ffc.emb.main

import com.a9ae0b01f0ffc.commons.main.T_common_const
import com.a9ae0b01f0ffc.commons.main.T_common_shortcuts
import com.a9ae0b01f0ffc.commons.main.T_common_utils

class T_u extends T_common_utils{

    static FileWriter init_new_file(String i_location) {
        File l_file = T_common_const.GC_NULL_OBJ_REF as File
        FileWriter l_file_writer = T_common_const.GC_NULL_OBJ_REF as FileWriter
        String l_location = process_location(i_location, T_common_shortcuts.commons())
        l_file = new File(l_location)
        l_file.getParentFile().mkdirs()
        l_file_writer = new FileWriter(l_file, T_emb_const.GC_FALSE)
        return l_file_writer
    }

}
