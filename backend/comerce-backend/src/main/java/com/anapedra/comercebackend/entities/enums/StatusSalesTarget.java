package com.anapedra.comercebackend.entities.enums;

public enum StatusSalesTarget{

    /*
    Attention: When inserting another enumerator, sequence the integers
    in the proposed order to avoid a possible collapse of subsequent codes.
     */

    SIMPLE_SALES_TARGET(1),
    SUPER_SALES_TARGET(2);

    private int code;

    private StatusSalesTarget(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }
    public static StatusSalesTarget valueOf(int code){
        for(StatusSalesTarget value : StatusSalesTarget.values() ) {
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code!");
    }
}
