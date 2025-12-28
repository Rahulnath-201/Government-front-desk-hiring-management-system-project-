package com.examly.springapp.controller;

import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    
    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department saved = departmentService.addDepartment(department);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
 
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department dept = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(dept);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable Long id,
            @RequestBody Department department) {

        Department updated = departmentService.updateDepartment(id, department);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Department>> getDepartmentsPaginated(
            @PathVariable int page,
            @PathVariable int size) {
        Page<Department> departments = departmentService.getDepartmentsPaginated(page, size);
        return ResponseEntity.ok(departments);
    }
}
