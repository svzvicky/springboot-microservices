package com.codebuffer.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codebuffer.registration.entity.User;
import com.codebuffer.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {

    private static final Logger log = LoggerFactory.getLogger(RegistrationService.class);

    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return registrationRepository.save(user);
    }
}
