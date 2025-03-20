package com.example.TrainingManagementApplication.service;

import org.springframework.stereotype.Service;
import com.example.TrainingManagementApplication.model.Training;
import com.example.TrainingManagementApplication.model.Status;
import com.example.TrainingManagementApplication.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {
    @Autowired
    private static TrainingRepository trainingRepository;

    // Get all trainings that have started
    public static List<Training> getTrainingsStarted() {
        return trainingRepository.findByStartDateAfter(new Date());
    }

    // Retrieve trainings by skills
    public List<Training> getTrainingsBySkills(List<String> skills) {
        return trainingRepository.findBySkillsIn(skills);
    }

    // Retrieve trainings by organization name
    public List<Training> getTrainingsByOrganizationName(String organizationName) {
        return trainingRepository.findByOrganizationName(organizationName);
    }

    // Retrieve trainings by status
    public List<Training> getTrainingsByStatus(Status status) {
        return trainingRepository.findByStatus(status);
    }

    // Add a new training
    public Training addTraining(Training training) {
        return trainingRepository.save(training);
    }

    // Update existing training
    public Training updateTraining(Long trainingId, Training trainingDetails) {
        Optional<Training> trainingOptional = trainingRepository.findById(trainingId);
        if (trainingOptional.isPresent()) {
            Training training = trainingOptional.get();
            training.setName(trainingDetails.getName());
            training.setSkills(trainingDetails.getSkills());
            training.setDuration(trainingDetails.getDuration());
            training.setStartDate(trainingDetails.getStartDate());
            training.setEndDate(trainingDetails.getEndDate());
            training.setNumberOfBatches(trainingDetails.getNumberOfBatches());
            training.setStudentsPerBatch(trainingDetails.getStudentsPerBatch());
            training.setBudget(trainingDetails.getBudget());
            training.setTableOfContent(trainingDetails.getTableOfContent());
            training.setOrganizationName(trainingDetails.getOrganizationName());
            training.setPointOfContact(trainingDetails.getPointOfContact());
            training.setEmailId(trainingDetails.getEmailId());
            training.setPhoneNumber(trainingDetails.getPhoneNumber());
            training.setStatus(trainingDetails.getStatus());
            return trainingRepository.save(training);
        }
        return null; // or throw exception
    }

    // Get a training by ID
    public Training getTrainingById(Long trainingId) {
        return trainingRepository.findById(trainingId).orElse(null); // or throw exception
    }
}
