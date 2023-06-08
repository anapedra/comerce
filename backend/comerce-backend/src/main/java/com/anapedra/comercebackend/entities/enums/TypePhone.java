package com.anapedra.comercebackend.entities.enums;

public enum TypePhone {
    /*
    Attention: When inserting another enumerator, sequence the integers
    in the proposed order to avoid a possible collapse of subsequent codes.
     */

    HPME_PHONE(1),
    WORK_PHONE(2),
    MOBILE_PHONE_WHATSAPP_TOO(3),
    WHATSAPP_ONLY(4),
    MOBILE_PHONE_ONLY(5);


    private int code;

    private TypePhone(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public static TypePhone valueOf(int code){
        for (TypePhone volue: TypePhone.values()){
            if (volue.getCode()==code){
                return volue;
            }
        }
        throw new IllegalArgumentException("Invalid code!");
    }
}
