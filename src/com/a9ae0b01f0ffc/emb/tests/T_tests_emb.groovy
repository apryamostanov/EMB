package com.a9ae0b01f0ffc.emb.tests

import com.a9ae0b01f0ffc.emb.implementation.T_emb_post_processor
import com.a9ae0b01f0ffc.emb.main.T_emb_s
import org.junit.Test

class T_tests_emb {

    @Test
    void test_001() {
        T_emb_s.x().init_custom("./src/com/a9ae0b01f0ffc/emb/conf/commons.conf")
        T_emb_post_processor l_emb_post_processor = new T_emb_post_processor()
        l_emb_post_processor.process_file("e:/emb/input.txt", "e:/emb/output.txt")
    }

}
