package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.AddressList;
import com.anapedra.comercebackend.entities.Documents;
import com.anapedra.comercebackend.entities.PhoneList;

import java.io.Serializable;

public class AdditionalDataDTO  implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;

    public AdditionalDataDTO(Long id, Documents documents, PhoneList phoneList, AddressList addressList) {


    }
}
