package com.sj.assign6;

public class Validator {

    public static boolean nameCheck(String inputName) {
        String nameRegex = "^[a-zA-Z]{1,24}$";
        return inputName.matches(nameRegex);
    }

    public static boolean phoneCheck(String inputPhone) {
//  String phonePattern = "^\+?1-\d{3}-\d{3}-\d{4}$";
        String phoneRegex = "^\\d{3}-\\d{3}-\\d{4}$";
        return inputPhone.matches(phoneRegex);
    }

    public static boolean emailCheck(String inputEmail) {
        String emailRegex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return inputEmail.matches(emailRegex);
    }

    public static boolean ageCheck(int inputage) {
        return inputage >= 18 && inputage <= 110;
    }

}
