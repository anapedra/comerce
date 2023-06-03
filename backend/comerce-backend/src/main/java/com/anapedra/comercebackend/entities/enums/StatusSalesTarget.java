package com.anapedra.comercebackend.entities.enums;

public enum StatusSalesTarget{
    SIMPLE_GOAL(1),
    SUPER_GOAL(2);

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
