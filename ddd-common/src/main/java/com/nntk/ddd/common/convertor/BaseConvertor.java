package com.nntk.ddd.common.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseConvertor {
    Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException p) {
            return null;
        }
    }
}
