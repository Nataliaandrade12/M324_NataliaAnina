package com.example.demo;

import java.time.LocalDate;

public class DueDate {
    private LocalDate date;

    public DueDate(LocalDate date) {
        this.date = date;
    }

    // Getters and setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Method to check if the due date is overdue
    public boolean isOverdue() {
        return date.isBefore(LocalDate.now());
    }
}
