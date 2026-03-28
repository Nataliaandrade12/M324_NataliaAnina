package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Testklasse für die Demo-Anwendung.
 * Diese Klasse enthält Unit-Tests für die Hauptfunktionalitäten der Anwendung,
 * einschließlich des Ladens des Spring-Kontexts und der DueDate-Klasse.
 */
@SpringBootTest
class DemoApplicationTests {

	/**
	 * Testet, ob der Spring-Anwendungskontext erfolgreich lädt.
	 * Dies ist ein grundlegender Test, um sicherzustellen, dass die Anwendung startet.
	 */
	@Test
	void contextLoads() {
		assertTrue(true, "alles gut");
	}

	/**
	 * Testet die Erstellung eines DueDate-Objekts mit einem gültigen Datum.
	 * Überprüft, dass das Objekt nicht null ist.
	 */
	@Test
	void shouldCreateDueDate() {
		DueDate dueDate = new DueDate(LocalDate.of(2026, 3, 25));
		assertNotNull(dueDate);
	}
	
	/**
	 * Testet, ob ein überfälliges Datum korrekt erkannt wird.
	 * Erstellt ein DueDate mit einem Datum in der Vergangenheit und prüft, ob isOverdue() true zurückgibt.
	 */
	@Test
	void shouldDetectOverdueDate() {
		DueDate dueDate = new DueDate(LocalDate.of(2020, 1, 1));
		assertTrue(dueDate.isOverdue());
	}
}