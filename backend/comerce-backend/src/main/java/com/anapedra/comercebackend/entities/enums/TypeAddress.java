package com.anapedra.comercebackend.entities.enums;

public enum TypeAddress {

    /*
    Attention: When inserting another enumerator, sequence the integers
    in the proposed order to avoid a possible collapse of subsequent codes.
     */

    DELIVERY_ADDRESS(1),
    HOME_ADDRESS(2),
    BELLING_ADDRESS(3),
    SHIPPING_ADDRESS(4);

    private int code;
    private TypeAddress(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }

    public static TypeAddress valueOf(int code){
        for(TypeAddress value : TypeAddress.values()){
           if (value.getCode()==code){
               return value;
           }
        }
        throw new IllegalArgumentException("Invalid code!");
    }


}
