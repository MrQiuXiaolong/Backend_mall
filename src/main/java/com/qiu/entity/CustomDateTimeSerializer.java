package com.qiu.entity;




import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CustomDateTimeSerializer extends JsonSerializer<Date>{


    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider serializerProvider)
    throws IOException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        gen.writeString(sdf.format(date));
    }
}
