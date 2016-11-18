package com.lvg.txtest.conv.converters;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Victor on 18.11.2016.
 */
public class StringToURLConverter implements Converter<String, URL> {
    private static final Logger LOG = Logger.getLogger(StringToURLConverter.class);

    @Override
    public URL convert(String source) {
        try {
            URL resultUrl = new URL(source);
            return resultUrl;
        }catch (MalformedURLException ex){
            LOG.info("It is exception during converting String to URL. message: "+ex.getMessage()
                    +". Converter can not convert String source:"+source+" to URL set value null");
            return null;        }

    }
}
