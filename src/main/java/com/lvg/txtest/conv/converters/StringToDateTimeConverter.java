package com.lvg.txtest.conv.converters;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;

/**
 * Created by Victor on 18.11.2016.
 */
public class StringToDateTimeConverter implements Converter<String, DateTime> {
    private static final String DAFAULT_DATE_PATTERN = "yyyy-mm-dd";
    private String datePattern = DAFAULT_DATE_PATTERN;

    private DateTimeFormatter dateTimeFormatter;


    public String getDatePattern() {
        return datePattern;
    }

    @Autowired(required = false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @PostConstruct
    private void init(){
        dateTimeFormatter = DateTimeFormat.forPattern(datePattern);
    }

    @Override
    public DateTime convert(String source) {
        return dateTimeFormatter.parseDateTime(source);
    }
}
