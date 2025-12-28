package com.examly.springapp.repository;

import com.examly.springapp.model.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {
    
    @Query("SELECT j FROM JobPosition j WHERE j.positionTitle LIKE %:keyword% OR j.description LIKE %:keyword%")
    List<JobPosition> findByKeyword(@Param("keyword") String keyword);
}