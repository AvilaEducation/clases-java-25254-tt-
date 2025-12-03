package com.techlab.speedrun.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {

  public boolean isEmpty(String textToValidate){
    return textToValidate == null || textToValidate.isBlank();
  }

  public static boolean validation(String as){
    return true;
  }
}
