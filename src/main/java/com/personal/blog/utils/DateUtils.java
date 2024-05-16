package com.personal.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String formatedCurrentDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        return simpleDateFormat.format(new Date());
    }
}
