package com.a9ae0b01f0ffc.emb.implementation

import com.a9ae0b01f0ffc.black_box.annotations.I_black_box
import com.a9ae0b01f0ffc.emb.main.T_emb_commons
import com.a9ae0b01f0ffc.emb.main.T_emb_s
import com.a9ae0b01f0ffc.emb.main.T_u

import java.lang.reflect.Array

class T_emb_post_processor extends T_emb_s {

    static FileWriter p_file_writer = GC_NULL_OBJ_REF as FileWriter

    @I_black_box("error")
    static ArrayList<String> split(String i_line, String i_token) {
        ArrayList<String> l_fields = new ArrayList<String>()
        String l_field = GC_EMPTY_STRING
        for (l_char in i_line.getChars()) {
            if (new String(l_char) == i_token) {
                l_fields.add(l_field)
                l_field = GC_EMPTY_STRING
            } else {
                l_field += l_char
            }
        }
        return l_fields
    }

    @I_black_box("error")
    static String get_track_1_name(String i_track_1) {
        return i_track_1.substring(i_track_1.indexOf(c().GC_TRACK_1_NAME_SEPARATOR), i_track_1.lastIndexOf(c().GC_TRACK_1_NAME_SEPARATOR) + GC_ONE_CHAR)
    }

    @I_black_box("error")
    static String process_line(String i_line) {
        ArrayList<String> l_fields = split(i_line, c().GC_EMB_CSV_SEPARATOR)
        String l_track_1_name = get_track_1_name(l_fields.get(new Integer(c().GC_CSV_TRACK_1_FIELD_NUMBER)))
        for (l_empty_name in [c().GC_EMPTY_NAME_REPLACEMENT_1, c().GC_EMPTY_NAME_REPLACEMENT_2, c().GC_EMPTY_NAME_REPLACEMENT_3, c().GC_EMPTY_NAME_REPLACEMENT_4, c().GC_EMPTY_NAME_REPLACEMENT_5]) {
            if (l_track_1_name == l_empty_name) {
                l_fields.set(new Integer(c().GC_CSV_NAME_ON_CARD_FIELD_NUMBER), GC_EMPTY_STRING)
                String l_track1 = l_fields.get(new Integer(c().GC_CSV_TRACK_1_FIELD_NUMBER))
                l_track1 = l_track1.replace(l_empty_name, c().GC_TRACK_1_DEFAULT_NAME)
                l_fields.set(new Integer(c().GC_CSV_TRACK_1_FIELD_NUMBER), l_track1)
            }
        }
        String l_result = GC_EMPTY_STRING
        for (l_field in l_fields) {
            l_result += l_field + c().GC_EMB_CSV_SEPARATOR
        }
        return l_result
    }

    @I_black_box("error")
    static void write_line(String i_line) {
        p_file_writer.write(i_line + System.lineSeparator())
        p_file_writer.flush()
    }

    @I_black_box("error")
    static void process_file(String i_source_file_name, String i_destination_file_name) {
        p_file_writer = T_u.init_new_file(i_destination_file_name)
        File l_file = new File(i_source_file_name)
        ArrayList<String> l_records = Arrays.asList(l_file as String[])
        for (String l_line in l_records) {
            if (![l_records.first(), l_records.last()].contains(l_line)) {
                write_line(process_line(l_line))
            } else {
                write_line(l_line)
            }
        }
    }

}
