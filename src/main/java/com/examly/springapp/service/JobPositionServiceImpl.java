package com.examly.springapp.service;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionServiceImpl implements JobPositionService {

    @Autowired
    private JobPositionRepository jobPositionRepository;

    @Override
    public JobPosition addJobPosition(JobPosition jobPosition) {
        return jobPositionRepository.save(jobPosition);
    }

    @Override
    public List<JobPosition> getAllJobPositions() {
        return jobPositionRepository.findAll();
    }

    @Override
    public JobPosition getJobPositionById(Long id) {
        return jobPositionRepository.findById(id).orElse(null);
    }

    @Override
    public JobPosition updateJobPosition(Long id, JobPosition jobPosition) {
        JobPosition existing = jobPositionRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setPositionTitle(jobPosition.getPositionTitle());
            existing.setDescription(jobPosition.getDescription());
            existing.setLocation(jobPosition.getLocation());
            existing.setExperienceRequired(jobPosition.getExperienceRequired());
            existing.setOpenings(jobPosition.getOpenings());
            if (jobPosition.getDepartment() != null) {
                existing.setDepartment(jobPosition.getDepartment());
            }
            return jobPositionRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteJobPosition(Long id) {
        jobPositionRepository.deleteById(id);
    }

    @Override
    public List<JobPosition> searchJobPositions(String keyword) {
        return jobPositionRepository.findByKeyword(keyword);
    }
}