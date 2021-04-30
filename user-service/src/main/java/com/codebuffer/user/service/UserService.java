package com.codebuffer.user.service;

import com.codebuffer.user.VO.Department;
import com.codebuffer.user.VO.ResponseTemplateVO;
import com.codebuffer.user.controller.UserController;
import com.codebuffer.user.entity.User;
import com.codebuffer.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        String URL = "http://DEPARTMENT-SERVICE:9001/departments/" + user.getDepartmentId();
        log.debug("Request sent to URL -> "+ URL);
        Department department = restTemplate.getForObject(URL, Department.class);
        log.debug("department info ->" + department.toString());

        vo.setUser(user);
        vo.setDepartment(department);
        log.debug("vo debug info ->" + vo.toString());

        return vo;

    }
}
