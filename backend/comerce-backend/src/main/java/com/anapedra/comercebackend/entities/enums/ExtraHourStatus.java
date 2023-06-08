package com.anapedra.comercebackend.entities.enums;

import com.anapedra.comercebackend.entities.Employee;

public enum ExtraHourStatus {
     /*
    Attention: When inserting another enumerator, sequence the integers
    in the proposed order to avoid a possible collapse of subsequent codes.
     */

    DAYTIME(1),
    NIGHT_OR_DOMIGOS_HOLIDAYS(2);

    private int code;


    private ExtraHourStatus(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }

    public static ExtraHourStatus valueOf(int code){
        for(ExtraHourStatus value : ExtraHourStatus.values() ) {
            if (value.getCode() == code){
                return value;
            }
        }

        if (code==1){
            Employee employee=new Employee();
            double calcH=(employee.getSalary()/220)+(employee.getSalary()/220)*0.5;
        }
        else if (code==2){
            Employee employee=new Employee();
            double calcH=(employee.getSalary()/220)+(employee.getSalary()/220)*0.5;
        }
        throw new IllegalArgumentException("Invalid code!");
    }
}
