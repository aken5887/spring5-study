package me.study.proxy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.util.ObjectUtils;

public class MyUtil {
  public static String getTodayWithFormat(String pattern){
    if(ObjectUtils.isEmpty(pattern)){
      pattern = "yyyy-MM-dd HH:mm:ss";
    }
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
  }
}
