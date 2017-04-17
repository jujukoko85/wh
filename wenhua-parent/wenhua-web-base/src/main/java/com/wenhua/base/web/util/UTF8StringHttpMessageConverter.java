package com.wenhua.base.web.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.StreamUtils;

import com.google.common.base.Charsets;

/**
 * 
 *
 * @author Fuchun
 * @version $Id: UTF8StringHttpMessageConverter.java 27723 2013-05-14 02:52:15Z C629 $
 * @since 1.0
 */
public class UTF8StringHttpMessageConverter extends StringHttpMessageConverter {
    
    private static final MediaType utf8 = new MediaType("text", "plain", Charsets.UTF_8);  
    
    private boolean writeAcceptCharset = true;
    
    protected List<Charset> getAcceptedCharsets() {  
        return Arrays.asList(Charsets.UTF_8);  
    }
    
    @Override
    protected MediaType getDefaultContentType(String t) throws IOException {
        return utf8;
    }

    @Override
    protected void writeInternal(String s, HttpOutputMessage outputMessage) throws IOException {
        if (this.writeAcceptCharset) {  
            outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());  
        }
        Charset charset = getContentTypeCharset(outputMessage.getHeaders().getContentType());
        StreamUtils.copy(s, charset, outputMessage.getBody());
    }
    
    @Override
    public void setWriteAcceptCharset(boolean writeAcceptCharset) {
        this.writeAcceptCharset = writeAcceptCharset;
    }
    
    private Charset getContentTypeCharset(MediaType contentType) {
        if (contentType != null && contentType.getCharset() != null) {
            return contentType.getCharset();
        }
        else {
            return Charsets.UTF_8;
        }
    }
}
