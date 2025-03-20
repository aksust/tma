package com.example.TrainingManagementApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;

    @NotNull
    private String name;

    @ElementCollection
    private List<String> skills;

    @Enumerated(EnumType.STRING)
    private DurationType duration;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    private Long numberOfBatches;
    private Long studentsPerBatch;

    private Double budget;

    @Lob
    private String tableOfContent;

    private String organizationName;

    private String pointOfContact; // POC
    private String emailId;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Getters and Setters


    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public DurationType getDuration() {
        return duration;
    }

    public void setDuration(DurationType duration) {
        this.duration = duration;
    }

    public @NotNull Date getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull Date startDate) {
        this.startDate = startDate;
    }

    public @NotNull Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotNull Date endDate) {
        this.endDate = endDate;
    }

    public Long getNumberOfBatches() {
        return numberOfBatches;
    }

    public void setNumberOfBatches(Long numberOfBatches) {
        this.numberOfBatches = numberOfBatches;
    }

    public Long getStudentsPerBatch() {
        return studentsPerBatch;
    }

    public void setStudentsPerBatch(Long studentsPerBatch) {
        this.studentsPerBatch = studentsPerBatch;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getTableOfContent() {
        return tableOfContent;
    }

    public void setTableOfContent(String tableOfContent) {
        this.tableOfContent = tableOfContent;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getPointOfContact() {
        return pointOfContact;
    }

    public void setPointOfContact(String pointOfContact) {
        this.pointOfContact = pointOfContact;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    // Custom logic to check start date and end date
    @PrePersist
    @PreUpdate
    public void validateDates() throws IllegalArgumentException {
        if (startDate != null && endDate != null && startDate.after(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }
    }
}
