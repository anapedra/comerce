package com.anapedra.comercebackend.entities.enums;

import com.anapedra.comercebackend.entities.Absence;

public enum TypeAbsence {

    /*
    Attention: When inserting another enumerator, sequence the integers
    in the proposed order to avoid a possible collapse of subsequent codes.
     */

    JUSTIFIED(1),
    UNJUSTIFIED(2);

    private int code;

    private TypeAbsence(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }
    public static TypeAbsence valueOf(int code){
        for(TypeAbsence value : TypeAbsence.values() ) {
            if (value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code!");
    }


}
