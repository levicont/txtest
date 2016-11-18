package com.lvg.txtest.conv.formatters;

import com.lvg.txtest.conv.converters.StringToURLConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Victor on 18.11.2016.
 */
public class ApplicationConversionServiceFactoryBean extends
        FormattingConversionServiceFactoryBean{
    private static final String DAFAULT_DATE_PATTERN = "yyyy-mm-dd";
    private String datePattern = DAFAULT_DATE_PATTERN;
    private DateTimeFormatter dateTimeFormatter;

    private Set<Formatter<?>> formatters = new HashSet<Formatter<?>>();



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
        formatters.add(getDateTimeFormatter());
        formatters.add(getURLFormatter());
        setFormatters(formatters);

    }

    public Formatter<DateTime> getDateTimeFormatter(){
        return new Formatter<DateTime>() {
            @Override
            public DateTime parse(String text, Locale locale) throws ParseException {

                return dateTimeFormatter.parseDateTime(text);
            }

            @Override
            public String print(DateTime object, Locale locale) {
                return dateTimeFormatter.print(object);
            }
        };
    }

    public Formatter<URL> getURLFormatter(){
        return new Formatter<URL>() {
            @Override
            public URL parse(String text, Locale locale) throws ParseException {
                return new StringToURLConverter().convert(text);
            }

            @Override
            public String print(URL object, Locale locale) {
                return object.toString();
            }
        };
    }



}
