package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.entities.User;
import com.anapedra.comercebackend.repositories.UserRepository;
import com.anapedra.comercebackend.services.exceptionservice.ForbiddenException;
import com.anapedra.comercebackend.services.exceptionservice.UnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {





    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    public User authenticated(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.registrationEmail(username);
        }
        catch (Exception e){
            throw new UnauthorizedException("Invalid User!");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        User user=authenticated();
        if (!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }

    }

    public void validSelf(){
        User user=authenticated();
        Long userId= user.getId();
        if (user.getId().equals(userId)){
            throw new ForbiddenException("Access denied");
        }
    }
    public void validateAdmin(){
        User user=authenticated();
        if (!user.hasHole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }
    }





}


/*

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

    public void authSelfOrAdmin(Long userId) {
        User user = authenticated();
        if(user.getId().equals(userId) && user.hasHole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }

    }
    public void authAdmin() {
        User user = authenticated();
        if(user.hasHole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }

    }

 */









