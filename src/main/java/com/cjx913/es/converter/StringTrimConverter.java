package com.cjx913.es.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class StringTrimConverter implements Converter<String,String> {
    @Nullable
    @Override
    public String convert(String s) {
        try {
            if(s!=null){
                s = s.trim();
                if(s.equals("")){
                    return null;
                }
            }
        }catch (Exception e){

        }
        return s;
    }
}
