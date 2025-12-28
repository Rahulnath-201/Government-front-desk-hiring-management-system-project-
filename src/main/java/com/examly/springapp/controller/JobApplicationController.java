package com.examly.springapp.controller;

import com.examly.springapp.model.JobApplication;
import com.examly.springapp.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @PostMapping
    public ResponseEntity<?> createJobApplication(
            @RequestBody(required = false) JobApplication jobApplication) {

        if (jobApplication == null) {
            return ResponseEntity.badRequest().build();
        }

        JobApplication saved = jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<?> getAllJobApplications() {
        List<JobApplication> applications = jobApplicationService.getAllJobApplications();
        
        if (applications.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(applications);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getJobApplicationById(@PathVariable Long id) {
        JobApplication application = jobApplicationService.getJobApplicationById(id);
        
        if (application == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Job application not found");
        }
        
        return ResponseEntity.ok("Job application found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateJobApplication(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
