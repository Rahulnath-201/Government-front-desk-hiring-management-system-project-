package com.examly.springapp.controller;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

    @Autowired
    private JobPositionService jobPositionService;

    @PostMapping
    public ResponseEntity<JobPosition> addJobPosition(@RequestBody JobPosition jobPosition) {
        JobPosition saved = jobPositionService.addJobPosition(jobPosition);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobPosition>> getAllJobPositions() {
        return ResponseEntity.ok(jobPositionService.getAllJobPositions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getJobPositionById(@PathVariable Long id) {
        JobPosition jobPosition = jobPositionService.getJobPositionById(id);
        return ResponseEntity.ok(jobPosition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> updateJobPosition(@PathVariable Long id, @RequestBody JobPosition jobPosition) {
        JobPosition updated = jobPositionService.updateJobPosition(id, jobPosition);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosition(@PathVariable Long id) {
        jobPositionService.deleteJobPosition(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<JobPosition>> searchJobPositions(@PathVariable String keyword) {
        List<JobPosition> results = jobPositionService.searchJobPositions(keyword);
        return ResponseEntity.ok(results);
    }
}
