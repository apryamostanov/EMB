package com.a9ae0b01f0ffc.emb.main

import com.a9ae0b01f0ffc.commons.main.T_common_commons


class T_emb_commons extends T_common_commons{

    String GC_TPN_CLASSES_CONF
    String GC_BLACK_BOX_CONFIG
    String GC_SOURCE_FILE_NAME
    String GC_DESTINATION_FILE_NAME

    T_emb_commons(String i_conf_file_name) {
        super(i_conf_file_name)
        GC_TPN_CLASSES_CONF = GC_CONST_CONF.GC_TPN_CLASSES_CONF(GC_TPN_CLASSES_CONF)
        GC_BLACK_BOX_CONFIG = GC_CONST_CONF.GC_BLACK_BOX_CONFIG(GC_BLACK_BOX_CONFIG)
        GC_SOURCE_FILE_NAME = GC_CONST_CONF.GC_SOURCE_FILE_NAME(GC_SOURCE_FILE_NAME)
        GC_DESTINATION_FILE_NAME = GC_CONST_CONF.GC_DESTINATION_FILE_NAME(GC_DESTINATION_FILE_NAME)
    }

}
