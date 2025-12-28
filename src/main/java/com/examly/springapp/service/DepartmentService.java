package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import org.springframework.data.domain.Page;
import java.util.List;

public interface DepartmentService {

    Department addDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);
    
    Page<Department> getDepartmentsPaginated(int page, int size);
}
