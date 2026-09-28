package com.codesense.domain;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "project_id",
            nullable = false
    )
    private Project project;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ReviewStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "overall_result", length = 20)
    private ReviewResult overallResult;

    @Enumerated(EnumType.STRING)
    @Column(name = "highest_severity", length = 20)
    private FindingSeverity highestSeverity;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public UUID getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ReviewStatus getStatus() {
        return status;
    }

    public void setStatus(ReviewStatus status) {
        this.status = status;
    }

    public ReviewResult getOverallResult() {
        return overallResult;
    }

    public void setOverallResult(ReviewResult overallResult) {
        this.overallResult = overallResult;
    }

    public FindingSeverity getHighestSeverity() {
        return highestSeverity;
    }

    public void setHighestSeverity(FindingSeverity highestSeverity) {
        this.highestSeverity = highestSeverity;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        createdAt = now;
        updatedAt = now;

        if (status == null) {
            status = ReviewStatus.PENDING;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

}
