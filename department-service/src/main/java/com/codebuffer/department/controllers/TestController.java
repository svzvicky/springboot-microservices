package com.codebuffer.department.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebuffer.department.entity.Department;
import com.codebuffer.department.service.DepartmentService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside saveDepartment method of DepartmentController");
        log.info("Incoming Department Data " + department.toString());
        return departmentService.saveDepartment(department);
    }
    
    @PostMapping("/postbody")
    public String postBody(@RequestBody String fullName) {
    	System.out.println("Incoming fullName Value -> " + fullName);
        return "Hello " + fullName;
    }
    
    @PostMapping("/postDept")
    public String postDept(@RequestBody Department department) {
    	System.out.println("Incoming fullName Value -> " + department);
        return "Hello " + department;
    }

}
