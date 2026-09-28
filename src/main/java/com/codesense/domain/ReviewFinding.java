package com.codesense.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "review_findings")
public class ReviewFinding {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "review_file_id",
            nullable = false
    )
    private ReviewFile reviewFile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FindingSeverity severity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private FindingType type;

    @Column(nullable = false, length = 2000)
    private String message;

    @Column(name = "line_number")
    private Integer lineNumber;

    @Column(length = 2000)
    private String suggestion;

    public UUID getId() {
        return id;
    }

    public ReviewFile getReviewFile() {
        return reviewFile;
    }

    public void setReviewFile(ReviewFile reviewFile) {
        this.reviewFile = reviewFile;
    }

    public FindingSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(FindingSeverity severity) {
        this.severity = severity;
    }

    public FindingType getType() {
        return type;
    }

    public void setType(FindingType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
