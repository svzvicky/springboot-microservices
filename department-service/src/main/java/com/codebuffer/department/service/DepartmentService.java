package com.codebuffer.department.service;

import com.codebuffer.department.entity.Department;
import com.codebuffer.department.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService " + department.toString());
        Department responseDept = departmentRepository.saveAndFlush(department);
        log.debug("responseDept -> " + responseDept.toString());
        return responseDept;
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentByiD of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
        //return departmentRepository.findById(departmentId).get();

    }
}
