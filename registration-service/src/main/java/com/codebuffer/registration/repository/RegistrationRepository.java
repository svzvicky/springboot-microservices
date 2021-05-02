package com.codebuffer.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codebuffer.registration.entity.User;

public interface RegistrationRepository extends JpaRepository<User, Long>{

}
