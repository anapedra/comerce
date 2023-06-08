package com.anapedra.comercebackend.dtos;

import java.io.Serializable;
import java.time.Instant;

public class UserDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String name;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private String mainPhone;
    private String registrationEmail;
    private AdditionalDataDTO additionalData;





}
