package com.jackie.util;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {


    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("string can't convert to date");
        }
        return date;
    }
}
