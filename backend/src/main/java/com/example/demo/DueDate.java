package com.example.demo;

import java.time.LocalDate;

public class DueDate {
    private LocalDate date;

    public DueDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
