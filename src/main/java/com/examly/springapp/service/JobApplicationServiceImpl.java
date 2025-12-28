package com.examly.springapp.service;

import com.examly.springapp.model.JobApplication;
import com.examly.springapp.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Override
    public JobApplication addJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        return jobApplicationRepository.findById(id).orElse(null);
    }

    @Override
    public JobApplication updateJobApplication(Long id, JobApplication jobApplication) {
        JobApplication existing = jobApplicationRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCoverLetter(jobApplication.getCoverLetter());
            existing.setResumeUrl(jobApplication.getResumeUrl());
            existing.setStatus(jobApplication.getStatus());
            existing.setPriority(jobApplication.getPriority());
            if (jobApplication.getCandidate() != null) {
                existing.setCandidate(jobApplication.getCandidate());
            }
            if (jobApplication.getJobPosition() != null) {
                existing.setJobPosition(jobApplication.getJobPosition());
            }
            return jobApplicationRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteJobApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }
}