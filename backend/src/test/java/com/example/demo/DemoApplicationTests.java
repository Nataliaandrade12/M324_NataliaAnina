package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true, "alles gut");
	}

	@Test
	void shouldCreateDueDate() {
		DueDate dueDate = new DueDate(LocalDate.of(2026, 3, 25));
		assertNotNull(dueDate);
	}
	
	@Test
	void shouldDetectOverdueDate() {
		DueDate dueDate = new DueDate(LocalDate.of(2020, 1, 1));
		assertTrue(dueDate.isOverdue());
	}
}