package com.anapedra.comercebackend.entities.enums;

public enum TypeFormPayment {

    PIX(1),
    DEBIT_CARD(2),
    CREDIT_CARD1x(3),
    CREDIT_CARD2x(4),
    CREDIT_CARD3x(5);





    private int code;

    private TypeFormPayment(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }

    public static TypeFormPayment valueOf(int code){
        for(TypeFormPayment value : TypeFormPayment.values() ) {
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code!");
    }


}
