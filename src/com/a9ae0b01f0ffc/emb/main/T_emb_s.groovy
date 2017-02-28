package com.a9ae0b01f0ffc.emb.main

import com.a9ae0b01f0ffc.commons.static_string.T_static_string_builder

class T_emb_s {

    static T_emb_context x() {
        return (T_emb_context)T_emb_context.get_context()
    }

    static T_emb_commons c() {
        return x().get_commons()
    }

    static final T_static_string_builder s() {
        return T_emb_const.GC_STATIC_STRING_BUILDER
    }



}
