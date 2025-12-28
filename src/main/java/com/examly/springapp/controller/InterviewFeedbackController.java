package com.examly.springapp.controller;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {

    @Autowired
    private InterviewFeedbackService interviewFeedbackService;

    @PostMapping
    public ResponseEntity<InterviewFeedback> addInterviewFeedback(@RequestBody InterviewFeedback interviewFeedback) {
        InterviewFeedback saved = interviewFeedbackService.addInterviewFeedback(interviewFeedback);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InterviewFeedback>> getAllInterviewFeedbacks() {
        return ResponseEntity.ok(interviewFeedbackService.getAllInterviewFeedbacks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getInterviewFeedbackById(@PathVariable Long id) {
        InterviewFeedback feedback = interviewFeedbackService.getInterviewFeedbackById(id);
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewFeedback> updateInterviewFeedback(@PathVariable Long id, @RequestBody InterviewFeedback interviewFeedback) {
        InterviewFeedback updated = interviewFeedbackService.updateInterviewFeedback(id, interviewFeedback);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterviewFeedback(@PathVariable Long id) {
        interviewFeedbackService.deleteInterviewFeedback(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/application/{applicationId}")
    public ResponseEntity<List<InterviewFeedback>> getFeedbacksByJobApplication(@PathVariable Long applicationId) {
        List<InterviewFeedback> feedbacks = interviewFeedbackService.getFeedbacksByJobApplication(applicationId);
        return ResponseEntity.ok(feedbacks);
    }
}
