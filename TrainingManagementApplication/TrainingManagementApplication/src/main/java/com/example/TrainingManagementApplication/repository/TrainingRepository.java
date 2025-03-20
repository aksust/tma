package com.example.TrainingManagementApplication.repository;

import com.example.TrainingManagementApplication.model.Status;
import com.example.TrainingManagementApplication.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findBySkillsIn(List<String> skills);

    List<Training> findByOrganizationName(String organizationName);

    List<Training> findByStatus(Status status);

    List<Training> findByStartDateAfter(Date date);

}

