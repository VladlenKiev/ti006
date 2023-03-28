package com.softserve.edu;

import java.util.regex.Pattern;

public class EmailValidationService {
    public static boolean checkEmail(String text) {
        String emailRegex = "^[A-Za-z][A-Za-z0-9\\.]*@[A-Za-z0-9]+(\\.[A-Za-z]{2,}){2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(text).matches();
    }
}
