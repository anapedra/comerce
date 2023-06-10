package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AdditionalDataDTO  implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String userName;
    private List<PhoneDTO> phones=new ArrayList<>();
    private List<EmailDTO>emails=new ArrayList<>();
    private List<AddressDTO> addresses=new ArrayList<>();

    public AdditionalDataDTO() {

    }

    public AdditionalDataDTO(Long id, String userName) {
        this.id = id;
        this.userName = userName;

    }

    public AdditionalDataDTO(AdditionalData entity) {
        id=entity.getId();
        userName=entity.getUser().getName();
        entity.getPhones().stream().map(x->new PhoneDTO(x)).collect(Collectors.toList());
        entity.getAddresses().stream().map(x->new AddressDTO(x)).collect(Collectors.toList());
        entity.getEmails().stream().map(x->new EmailDTO(x)).collect(Collectors.toList());

    }

    public AdditionalDataDTO(AdditionalData entity, Long id, List<Address> addresses, List<Email> emails, List<Phone> phones) {
        this(entity);
        entity.getAddresses().forEach(address -> this.addresses.add(new AddressDTO(address)));
        entity.getEmails().forEach(email -> this.emails.add(new EmailDTO(email)));
        entity.getPhones().forEach(phone -> this.phones.add(new PhoneDTO(phone)));

    }

    public AdditionalDataDTO(Long id, List<Address> addresses, List<Email> emails, List<Phone> phones) {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public List<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDTO> emails) {
        this.emails = emails;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }


}
