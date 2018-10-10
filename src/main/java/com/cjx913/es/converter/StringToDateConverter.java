package com.cjx913.es.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StringToDateConverter implements Converter <String, Date> {

    private String datepattern;

    public StringToDateConverter(String datepattern) {
        this.datepattern = datepattern;
    }

    @Nullable
    @Override
    public Date convert(String s) {

        try {
            return new SimpleDateFormat(datepattern).parse(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid date format. Please use this pattern\""+datepattern+"\"");
        }
    }
}
