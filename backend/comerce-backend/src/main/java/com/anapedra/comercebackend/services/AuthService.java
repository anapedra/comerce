package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.entities.User;
import com.anapedra.comercebackend.repositories.UserRepository;
import com.anapedra.comercebackend.services.exceptionservice.ForbiddenException;
import com.anapedra.comercebackend.services.exceptionservice.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {



    @Autowired
    private UserRepository repository;


    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return repository.registrationEmail(username);

        }
        catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateSelfOrMember(Long userId) {
        User user = authenticated();
        if(user.getId().equals(userId) && user.hasHole("ROLE_MEMBER")) {
            throw new ForbiddenException("Access denied");
        }

    }


}






