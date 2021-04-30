package com.codebuffer.user.controller;

import com.codebuffer.user.VO.ResponseTemplateVO;
import com.codebuffer.user.entity.User;
import com.codebuffer.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserContoller");
        return userService.saveUser(user);
    }

    @GetMapping(value= "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment method of UserController");

        ResponseTemplateVO responseTemplateVO = userService.getUserWithDepartment(userId);
        log.debug("Controller Output -> "+responseTemplateVO.toString());
        return responseTemplateVO;
    }
}
