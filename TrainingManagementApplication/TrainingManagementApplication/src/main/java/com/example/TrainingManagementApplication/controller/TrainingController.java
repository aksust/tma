package com.example.TrainingManagementApplication.controller;

import com.example.TrainingManagementApplication.model.Status;
import com.example.TrainingManagementApplication.model.Training;
import com.example.TrainingManagementApplication.service.TrainingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    // Create a new training
    @PostMapping
    public ResponseEntity<Training> createTraining(@Valid @RequestBody Training training) {
        return new ResponseEntity<>(trainingService.addTraining(training), HttpStatus.CREATED);
    }

    // Update an existing training
    @PutMapping("/{id}")
    public ResponseEntity<Training> updateTraining(@PathVariable Long id, @Valid @RequestBody Training training) {
        Training updatedTraining = trainingService.updateTraining(id, training);
        if (updatedTraining != null) {
            return ResponseEntity.ok(updatedTraining);
        }
        return ResponseEntity.notFound().build();
    }

    // Get all trainings that have started
    @GetMapping("/started")
    public List<Training> getTrainingsStarted() {
        return TrainingService.getTrainingsStarted();
    }

    // Retrieve trainings by skills
    @GetMapping("/skills")
    public List<Training> getTrainingsBySkills(@RequestParam List<String> skills) {
        return trainingService.getTrainingsBySkills(skills);
    }

    // Retrieve trainings by organization name
    @GetMapping("/organization")
    public List<Training> getTrainingsByOrganizationName(@RequestParam String organizationName) {
        return trainingService.getTrainingsByOrganizationName(organizationName);
    }

    // Retrieve trainings by status
    @GetMapping("/status")
    public List<Training> getTrainingsByStatus(@RequestParam Status status) {
        return trainingService.getTrainingsByStatus(status);
    }

    // Get training by ID
    @GetMapping("/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable Long id) {
        Training training = trainingService.getTrainingById(id);
        if (training != null) {
            return ResponseEntity.ok(training);
        }
        return ResponseEntity.notFound().build();
    }
}
