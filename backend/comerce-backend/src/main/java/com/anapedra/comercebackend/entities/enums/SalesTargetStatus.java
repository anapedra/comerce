package com.anapedra.comercebackend.entities.enums;

public enum SalesTargetStatus {

    /*
    Attention: When inserting another enumerator, sequence the integers
    in the proposed order to avoid a possible collapse of subsequent codes.
     */

    SALES_TARGET(1),
    SUPER_SALES_TARGET(2);

    private int code;

    private  SalesTargetStatus(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }

    public static SalesTargetStatus valueOf(int code){
        for(SalesTargetStatus value : SalesTargetStatus.values() ) {
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code!");
    }

}
