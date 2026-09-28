package com.codesense.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
        name = "requirement_evaluations",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_review_requirement",
                        columnNames = {"review_id", "requirement_id"}
                )
        }
)
public class RequirementEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(
            name = "requirement_id",
            nullable = false
    )
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "requirement_id",
            nullable = false
    )
    private Requirement requirement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RequirementEvaluationResult result;

    @Column(length = 2000)
    private String explanation;

    public UUID getId() {
        return id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public RequirementEvaluationResult getResult() {
        return result;
    }

    public void setResult(RequirementEvaluationResult result) {
        this.result = result;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }


}
